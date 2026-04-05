package cn.sharesdk.facebook;

import android.os.Bundle;
import android.webkit.WebView;
import cn.sharesdk.framework.authorize.WebAuthorizeActivity;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.utils.ResHelper;

/* loaded from: classes2.dex */
public class c extends cn.sharesdk.framework.authorize.b {
    public c(WebAuthorizeActivity webAuthorizeActivity) {
        super(webAuthorizeActivity);
    }

    @Override // cn.sharesdk.framework.authorize.b
    public void onComplete(String str) {
        int i6;
        Bundle bundleUrlToBundle = ResHelper.urlToBundle(str);
        String string = bundleUrlToBundle.getString("error_message");
        if (string != null && this.listener != null) {
            string = "error_message ==>>" + string + "\nerror_code ==>>" + bundleUrlToBundle.getString("error_code");
            this.listener.onError(new Throwable(str));
        }
        if (string == null) {
            String string2 = bundleUrlToBundle.getString("access_token");
            String string3 = bundleUrlToBundle.containsKey("expires_in") ? bundleUrlToBundle.getString("expires_in") : "-1";
            if (this.listener != null) {
                Bundle bundle = new Bundle();
                bundle.putString("oauth_token", string2);
                bundle.putString("oauth_token_secret", "");
                try {
                    i6 = ResHelper.parseInt(string3);
                } catch (Throwable th) {
                    SSDKLog.b().a(th);
                    i6 = -1;
                }
                bundle.putInt("oauth_token_expires", i6);
                this.listener.onComplete(bundle);
            }
        }
    }

    @Override // cn.sharesdk.framework.h, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            String str2 = this.redirectUri;
            if (str2 != null && str.startsWith(str2)) {
                webView.stopLoading();
                webView.postDelayed(new Runnable() { // from class: cn.sharesdk.facebook.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ((cn.sharesdk.framework.authorize.b) c.this).activity.finish();
                    }
                }, 500L);
                onComplete(str);
                return true;
            }
        } catch (Exception e7) {
            SSDKLog.b().d(e7.getMessage(), new Object[0]);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
