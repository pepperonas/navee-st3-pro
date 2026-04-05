package cn.sharesdk.google;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.WebAuthorizeActivity;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class GooglePlusAuthorizeWebviewClient extends cn.sharesdk.framework.authorize.b {
    private boolean finished;

    public GooglePlusAuthorizeWebviewClient(WebAuthorizeActivity webAuthorizeActivity) {
        super(webAuthorizeActivity);
    }

    private void requestAuthToken(final Platform platform, final String str) {
        new Thread() { // from class: cn.sharesdk.google.GooglePlusAuthorizeWebviewClient.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                String strB;
                try {
                    try {
                        strB = a.a(platform).b(str);
                    } catch (Throwable th) {
                        ((cn.sharesdk.framework.authorize.b) GooglePlusAuthorizeWebviewClient.this).listener.onError(th);
                        strB = null;
                    }
                    if (strB == null) {
                        ((cn.sharesdk.framework.authorize.b) GooglePlusAuthorizeWebviewClient.this).listener.onError(new Throwable("Authorize token is empty"));
                        return;
                    }
                    HashMap mapFromJson = new Hashon().fromJson(strB);
                    Bundle bundle = new Bundle();
                    bundle.putString("access_token", String.valueOf(mapFromJson.get("access_token")));
                    bundle.putString("expires_in", String.valueOf(mapFromJson.get("expires_in")));
                    bundle.putString("token_type", String.valueOf(mapFromJson.get("token_type")));
                    bundle.putString("refresh_token", String.valueOf(mapFromJson.get("refresh_token")));
                    bundle.putString("id_token", String.valueOf(mapFromJson.get("id_token")));
                    ((cn.sharesdk.framework.authorize.b) GooglePlusAuthorizeWebviewClient.this).listener.onComplete(bundle);
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2);
                }
            }
        }.start();
    }

    @Override // cn.sharesdk.framework.authorize.b
    public void onComplete(String str) {
        int i6;
        if (this.finished) {
            return;
        }
        this.finished = true;
        Bundle bundleUrlToBundle = ResHelper.urlToBundle(str);
        String string = bundleUrlToBundle.getString("error");
        String string2 = bundleUrlToBundle.getString("error_code");
        if (this.listener != null) {
            if (string == null && string2 == null) {
                String string3 = bundleUrlToBundle.getString("code");
                if (TextUtils.isEmpty(string3)) {
                    this.listener.onError(new Throwable("Authorize code is empty"));
                }
                requestAuthToken(this.activity.getHelper().getPlatform(), string3);
                return;
            }
            if (string.equals("access_denied")) {
                this.listener.onCancel();
                return;
            }
            try {
                i6 = ResHelper.parseInt(string2);
            } catch (Throwable th) {
                SSDKLog.b().a(th);
                i6 = 0;
            }
            this.listener.onError(new Throwable(string + " (" + i6 + ")"));
        }
    }

    @Override // cn.sharesdk.framework.h, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            String str2 = this.redirectUri;
            if (str2 != null && str.startsWith(str2)) {
                webView.stopLoading();
                webView.postDelayed(new Runnable() { // from class: cn.sharesdk.google.GooglePlusAuthorizeWebviewClient.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ((cn.sharesdk.framework.authorize.b) GooglePlusAuthorizeWebviewClient.this).activity.finish();
                    }
                }, 500L);
                onComplete(str);
                return true;
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
