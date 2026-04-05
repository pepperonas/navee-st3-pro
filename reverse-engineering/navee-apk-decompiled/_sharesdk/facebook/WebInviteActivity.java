package cn.sharesdk.facebook;

import android.app.Activity;
import android.app.Instrumentation;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.RegisterView;
import cn.sharesdk.framework.h;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.n;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class WebInviteActivity extends FakeActivity {
    private a adapter;
    private String appLink;
    private String consumerKey;
    private String imageUrl;
    private PlatformActionListener listener;
    private Platform platform;
    private boolean resultFailed;
    private boolean resultOk;
    private RegisterView rv;
    private WebView webView;

    /* JADX INFO: Access modifiers changed from: private */
    public void afterInvite(String str) {
        finish();
        String str2 = str == null ? "" : new String(str);
        Bundle bundleUrlToBundle = ResHelper.urlToBundle(str);
        if (bundleUrlToBundle == null) {
            this.resultFailed = true;
            finish();
            if (this.listener != null) {
                finish();
                this.listener.onError(null, 6, new Throwable("failed to parse invite callback uri: " + str2));
                return;
            }
            return;
        }
        try {
            for (String str3 : bundleUrlToBundle.keySet()) {
                if (str3.equals("method_results") && bundleUrlToBundle.get(str3) != null) {
                    HashMap mapFromJson = new Hashon().fromJson((String) bundleUrlToBundle.get(str3));
                    if (mapFromJson.containsKey("didComplete") && this.listener != null) {
                        if (Integer.parseInt(mapFromJson.get("didComplete").toString()) == 1) {
                            this.listener.onComplete(this.platform, 6, null);
                        } else {
                            this.listener.onError(this.platform, 6, new Throwable("Invite Fails"));
                        }
                    }
                } else if (str3.equals("error") && bundleUrlToBundle.get(str3) != null) {
                    this.listener.onError(null, 6, new Throwable((String) bundleUrlToBundle.get(str3)));
                }
            }
        } catch (Throwable th) {
            if (this.listener != null) {
                SSDKLog.b().a(th);
                this.listener.onError(this.platform, 6, th);
            }
        }
    }

    private a getAdapter() {
        try {
            String string = this.activity.getPackageManager().getActivityInfo(this.activity.getComponentName(), 128).metaData.getString("FBWebShareAdapter");
            if (string != null && string.length() > 0) {
                Object objNewInstance = Class.forName(string).newInstance();
                if (objNewInstance instanceof a) {
                    return (a) objNewInstance;
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getScheme(String str) {
        this.appLink = "https://fb.me/1654865544566386";
        this.imageUrl = "http://f1.webshare.mob.com/dimgs/1c950a7b02087bf41bc56f07f7d3572c11dfcf36.jpg";
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("https://m.facebook.com/connect/dialog/MPlatformAppInvitesJSDialog?");
            sb.append("app_id=");
            sb.append(this.consumerKey);
            sb.append("&bridge_args={\"action_id\":\"cf61947c-a8fe-4fa3-aa7c-fbeb7f291352\"");
            sb.append(",\"app_name\":\"");
            sb.append(Data.urlEncode(str, "utf-8") + "\"");
            sb.append(",\"sdk_version\":\"5.4.0\"}");
            sb.append("&cipher_key=");
            sb.append("AYVK8VGJuUpo/soxjw62TUc=");
            sb.append("&ios_bundle_id=");
            sb.append(DH.SyncMtd.getPackageName());
            sb.append("&method_args={\"app_link_url\":\"");
            sb.append(this.appLink + "\"");
            sb.append(",\"preview_image_url\":\"");
            sb.append(Data.urlEncode(this.imageUrl, "utf-8") + "\"");
            sb.append(",\"destination\":\"facebook\"}");
            sb.append("&redirect_url=fb");
            sb.append(this.consumerKey);
            sb.append("://bridge/appinvites");
            sb.append("&sfvc=1");
        } catch (Throwable th) {
            if (this.listener != null) {
                SSDKLog.b().a(th);
                finish();
                this.listener.onError(this.platform, 6, th);
            }
        }
        return sb.toString();
    }

    public RegisterView getBodyView() {
        RegisterView registerView = new RegisterView(this.activity);
        registerView.c().getChildAt(registerView.c().getChildCount() - 1).setVisibility(8);
        registerView.a().setOnClickListener(new View.OnClickListener() { // from class: cn.sharesdk.facebook.WebInviteActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new Thread() { // from class: cn.sharesdk.facebook.WebInviteActivity.2.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Throwable th) {
                            SSDKLog.b().a(th);
                            WebInviteActivity.this.finish();
                            WebInviteActivity.this.listener.onCancel(WebInviteActivity.this.platform, 0);
                        }
                    }
                }.start();
            }
        });
        WebView webViewB = registerView.b();
        this.webView = webViewB;
        WebSettings settings = webViewB.getSettings();
        settings.setBuiltInZoomControls(true);
        n.a(settings, true);
        settings.setCacheMode(1);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setSavePassword(false);
        settings.setDatabasePath(this.activity.getDir("database", 0).getPath());
        this.webView.setVerticalScrollBarEnabled(false);
        this.webView.setHorizontalScrollBarEnabled(false);
        this.webView.setWebViewClient(new h() { // from class: cn.sharesdk.facebook.WebInviteActivity.3
            @Override // cn.sharesdk.framework.h, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str == null) {
                    return false;
                }
                if (!str.startsWith("fb" + WebInviteActivity.this.consumerKey + "://bridge/appinvites?")) {
                    return false;
                }
                WebInviteActivity.this.afterInvite(str);
                return true;
            }
        });
        return registerView;
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        this.rv = getBodyView();
        try {
            int stringRes = ResHelper.getStringRes(getContext(), "ssdk_share_to_facebook");
            if (stringRes > 0) {
                this.rv.c().getTvTitle().setText(stringRes);
            }
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            this.rv.c().setVisibility(8);
        }
        this.adapter.a(this.rv.d());
        this.adapter.a(this.rv.b());
        this.adapter.a(this.rv.c());
        this.adapter.a();
        disableScreenCapture();
        this.activity.setContentView(this.rv);
        DH.requester(MobSDK.getContext()).getAppName().getNetworkTypeForStatic().request(new DH.DHResponder() { // from class: cn.sharesdk.facebook.WebInviteActivity.1
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    String networkTypeForStatic = dHResponse.getNetworkTypeForStatic();
                    String appName = dHResponse.getAppName();
                    if ("none".equals(networkTypeForStatic)) {
                        WebInviteActivity.this.resultFailed = true;
                        WebInviteActivity.this.finish();
                        WebInviteActivity.this.listener.onError(null, 0, new Throwable("failed to load invite webpage, network disconnected."));
                    } else {
                        if (ShareSDK.isRemoveCookieOnAuthorize()) {
                            CookieSyncManager.createInstance(((FakeActivity) WebInviteActivity.this).activity);
                            CookieManager.getInstance().removeAllCookie();
                        }
                        WebInviteActivity.this.rv.b().loadUrl(WebInviteActivity.this.getScheme(appName));
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2);
                }
            }
        });
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        if (!this.resultFailed && !this.resultOk) {
            this.listener.onCancel(null, 0);
        }
        WebView webView = this.webView;
        if (webView != null) {
            webView.setFocusable(false);
        }
        a aVar = this.adapter;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onFinish() {
        a aVar = this.adapter;
        return aVar != null ? aVar.h() : super.onFinish();
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        a aVar = this.adapter;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onRestart() {
        a aVar = this.adapter;
        if (aVar != null) {
            aVar.g();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        a aVar = this.adapter;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onStart() {
        a aVar = this.adapter;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        a aVar = this.adapter;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void setActivity(Activity activity) {
        super.setActivity(activity);
        if (this.adapter == null) {
            a adapter = getAdapter();
            this.adapter = adapter;
            if (adapter == null) {
                this.adapter = new a();
            }
        }
        this.adapter.a(activity);
    }

    public void setInviteParams(String str) {
        this.consumerKey = str;
    }

    public void setPlatformActionListener(PlatformActionListener platformActionListener, Platform platform) {
        this.listener = platformActionListener;
        this.platform = platform;
    }
}
