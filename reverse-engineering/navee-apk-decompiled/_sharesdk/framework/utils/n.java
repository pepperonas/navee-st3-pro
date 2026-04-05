package cn.sharesdk.framework.utils;

import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* loaded from: classes2.dex */
public class n {
    public static void a(WebView webView, boolean z6) {
        if (webView == null) {
            return;
        }
        try {
            webView.getSettings().setAllowFileAccess(z6);
            webView.getSettings().setSavePassword(z6);
            webView.getSettings().setAllowFileAccessFromFileURLs(z6);
            webView.getSettings().setAllowUniversalAccessFromFileURLs(z6);
        } catch (Throwable unused) {
        }
    }

    public static void a(WebSettings webSettings, boolean z6) {
        if (webSettings == null) {
            return;
        }
        try {
            String strA = i.a("opxLWrBMJweIF1SCwqo+hR2cd4CvxbDxONkTFgKvZMc=");
            if (!TextUtils.isEmpty(strA)) {
                webSettings.getClass().getMethod(strA, Boolean.TYPE).invoke(webSettings, Boolean.valueOf(z6));
            }
            SSDKLog.b().b("wvs");
        } catch (Throwable th) {
            SSDKLog.b().c(th);
        }
    }
}
