package cn.sharesdk.facebook;

import android.app.Activity;
import android.app.Instrumentation;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.RegisterView;
import cn.sharesdk.framework.h;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.i;
import cn.sharesdk.framework.utils.n;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ResHelper;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class WebShareActivity extends FakeActivity {
    private a adapter;
    private PlatformActionListener pa;
    private boolean resultFailed;
    private boolean resultOk;
    private RegisterView rv;
    private String scheme;
    private WebView webView;

    /* JADX INFO: Access modifiers changed from: private */
    public void afterShare(String str) {
        String str2 = str == null ? "" : new String(str);
        Bundle bundleUrlToBundle = ResHelper.urlToBundle(str);
        if (bundleUrlToBundle == null) {
            this.resultFailed = true;
            finish();
            this.pa.onError(null, 0, new Throwable("failed to parse callback uri: " + str2));
            return;
        }
        String string = bundleUrlToBundle.getString("post_id");
        HashMap<String, Object> map = new HashMap<>();
        if (!TextUtils.isEmpty(string)) {
            map.put("post_id", string);
        }
        if (!bundleUrlToBundle.containsKey("error_code") && !bundleUrlToBundle.containsKey("error")) {
            this.resultOk = true;
            finish();
            this.pa.onComplete(null, 0, map);
            return;
        }
        if (this.pa != null) {
            String string2 = bundleUrlToBundle.getString("error_code");
            if (bundleUrlToBundle.containsKey("error_code") && string2.equals("4201")) {
                this.pa.onCancel(null, 9);
            } else {
                this.pa.onError(null, 9, new Throwable(ResHelper.encodeUrl(bundleUrlToBundle)));
            }
        }
        this.resultFailed = true;
        finish();
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

    public RegisterView getBodyView() {
        RegisterView registerView = new RegisterView(this.activity);
        registerView.c().getChildAt(registerView.c().getChildCount() - 1).setVisibility(8);
        registerView.a().setOnClickListener(new View.OnClickListener() { // from class: cn.sharesdk.facebook.WebShareActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new Thread() { // from class: cn.sharesdk.facebook.WebShareActivity.2.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Throwable th) {
                            SSDKLog.b().a(th);
                            WebShareActivity.this.finish();
                            WebShareActivity.this.pa.onCancel(null, 0);
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
        this.webView.setWebViewClient(new h() { // from class: cn.sharesdk.facebook.WebShareActivity.3
            @Override // cn.sharesdk.framework.h, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str != null) {
                    try {
                        if (str.startsWith("fbconnect://success")) {
                            WebShareActivity.this.afterShare(str);
                        }
                    } catch (Exception e7) {
                        SSDKLog.b().a(e7.getMessage(), new Object[0]);
                    }
                }
                return super.shouldOverrideUrlLoading(webView, str);
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
        i.a(this.rv);
        this.activity.setContentView(this.rv);
        DH.requester(MobSDK.getContext()).getNetworkTypeForStatic().request(new DH.DHResponder() { // from class: cn.sharesdk.facebook.WebShareActivity.1
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    if (!"none".equals(dHResponse.getNetworkTypeForStatic())) {
                        WebShareActivity.this.rv.b().loadUrl(WebShareActivity.this.scheme);
                        return;
                    }
                    WebShareActivity.this.resultFailed = true;
                    WebShareActivity.this.finish();
                    WebShareActivity.this.pa.onError(null, 0, new Throwable("failed to load webpage, network disconnected."));
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2);
                }
            }
        });
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        if (!this.resultFailed && !this.resultOk) {
            this.pa.onCancel(null, 0);
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

    public void setScheme(String str) {
        this.scheme = str;
    }

    public void setSharedCallback(PlatformActionListener platformActionListener) {
        this.pa = platformActionListener;
    }
}
