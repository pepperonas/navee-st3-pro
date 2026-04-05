package cn.sharesdk.google;

import android.app.Activity;
import android.app.Instrumentation;
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

/* loaded from: classes2.dex */
public class WebShareActivity extends FakeActivity {
    private GooglePlusWebShareAdapter adapter;
    private PlatformActionListener pa;
    private boolean resultFailed;
    private boolean resultOk;
    private RegisterView rv;
    private String scheme;
    private WebView webView;

    private GooglePlusWebShareAdapter getAdapter() {
        try {
            String string = this.activity.getPackageManager().getActivityInfo(this.activity.getComponentName(), 128).metaData.getString("GooglePlusWebShareAdapter");
            if (string != null && string.length() > 0) {
                Object objNewInstance = Class.forName(string).newInstance();
                if (objNewInstance instanceof GooglePlusWebShareAdapter) {
                    return (GooglePlusWebShareAdapter) objNewInstance;
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
        registerView.a().setOnClickListener(new View.OnClickListener() { // from class: cn.sharesdk.google.WebShareActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new Thread() { // from class: cn.sharesdk.google.WebShareActivity.2.1
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
        settings.setUserAgentString("Mozilla/5.0 Google (windows nt 6.1;wow64) applewebkit/537.36 (khtml,like gecko) chrome/55.0.2883.87 safari/547.36");
        settings.setDatabasePath(this.activity.getDir("database", 0).getPath());
        this.webView.setVerticalScrollBarEnabled(false);
        this.webView.setHorizontalScrollBarEnabled(false);
        this.webView.setWebViewClient(new h() { // from class: cn.sharesdk.google.WebShareActivity.3
            @Override // cn.sharesdk.framework.h, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
        });
        return registerView;
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        this.rv = getBodyView();
        try {
            int stringRes = ResHelper.getStringRes(getContext(), "ssdk_share_to_googleplus");
            if (stringRes > 0) {
                this.rv.c().getTvTitle().setText(stringRes);
            }
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            this.rv.c().setVisibility(8);
        }
        this.adapter.setBodyView(this.rv.d());
        this.adapter.setWebView(this.rv.b());
        this.adapter.setTitleView(this.rv.c());
        this.adapter.onCreate();
        disableScreenCapture();
        i.a(this.rv);
        this.activity.setContentView(this.rv);
        DH.requester(MobSDK.getContext()).getNetworkTypeForStatic().request(new DH.DHResponder() { // from class: cn.sharesdk.google.WebShareActivity.1
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
            this.pa.onComplete(null, 9, null);
        }
        WebView webView = this.webView;
        if (webView != null) {
            webView.setFocusable(false);
        }
        GooglePlusWebShareAdapter googlePlusWebShareAdapter = this.adapter;
        if (googlePlusWebShareAdapter != null) {
            googlePlusWebShareAdapter.onDestroy();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onFinish() {
        GooglePlusWebShareAdapter googlePlusWebShareAdapter = this.adapter;
        return googlePlusWebShareAdapter != null ? googlePlusWebShareAdapter.onFinish() : super.onFinish();
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        GooglePlusWebShareAdapter googlePlusWebShareAdapter = this.adapter;
        if (googlePlusWebShareAdapter != null) {
            googlePlusWebShareAdapter.onPause();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onRestart() {
        GooglePlusWebShareAdapter googlePlusWebShareAdapter = this.adapter;
        if (googlePlusWebShareAdapter != null) {
            googlePlusWebShareAdapter.onRestart();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        GooglePlusWebShareAdapter googlePlusWebShareAdapter = this.adapter;
        if (googlePlusWebShareAdapter != null) {
            googlePlusWebShareAdapter.onResume();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onStart() {
        GooglePlusWebShareAdapter googlePlusWebShareAdapter = this.adapter;
        if (googlePlusWebShareAdapter != null) {
            googlePlusWebShareAdapter.onStart();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        GooglePlusWebShareAdapter googlePlusWebShareAdapter = this.adapter;
        if (googlePlusWebShareAdapter != null) {
            googlePlusWebShareAdapter.onStop();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void setActivity(Activity activity) {
        super.setActivity(activity);
        if (this.adapter == null) {
            GooglePlusWebShareAdapter adapter = getAdapter();
            this.adapter = adapter;
            if (adapter == null) {
                this.adapter = new GooglePlusWebShareAdapter();
            }
        }
        this.adapter.setActivity(activity);
    }

    public void setScheme(String str) {
        this.scheme = str;
    }

    public void setSharedCallback(PlatformActionListener platformActionListener) {
        this.pa = platformActionListener;
    }
}
