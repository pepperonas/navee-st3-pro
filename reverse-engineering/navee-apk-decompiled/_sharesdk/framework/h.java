package cn.sharesdk.framework;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.sharesdk.framework.utils.SSDKLog;

/* loaded from: classes2.dex */
public class h extends WebViewClient {
    public static final int ERROR_AUTHENTICATION = -4;
    public static final int ERROR_BAD_URL = -12;
    public static final int ERROR_CONNECT = -6;
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    public static final int ERROR_FILE = -13;
    public static final int ERROR_FILE_NOT_FOUND = -14;
    public static final int ERROR_HOST_LOOKUP = -2;
    public static final int ERROR_IO = -7;
    public static final int ERROR_PROXY_AUTHENTICATION = -5;
    public static final int ERROR_REDIRECT_LOOP = -9;
    public static final int ERROR_TIMEOUT = -8;
    public static final int ERROR_TOO_MANY_REQUESTS = -15;
    public static final int ERROR_UNKNOWN = -1;
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z6) {
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        message.sendToTarget();
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i6, String str, String str2) {
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        httpAuthHandler.cancel();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
        String[] strArr;
        String strValueOf;
        String strValueOf2;
        String strValueOf3;
        if (!(webView.getContext() instanceof Activity)) {
            sslErrorHandler.cancel();
            return;
        }
        Activity activity = (Activity) webView.getContext();
        if ("zh".equals(cn.sharesdk.framework.utils.h.a())) {
            strArr = new String[]{String.valueOf(new char[]{19981, 21463, 20449, 20219, 30340, 35777, 20070, 12290, 20320, 35201, 32487, 32493, 21527, 65311}), String.valueOf(new char[]{35777, 20070, 24050, 36807, 26399, 12290, 20320, 35201, 32487, 32493, 21527, 65311}), String.valueOf(new char[]{35777, 20070, 'I', 'D', 19981, 21305, 37197, 12290, 20320, 35201, 32487, 32493, 21527, 65311}), String.valueOf(new char[]{35777, 20070, 23578, 26410, 29983, 25928, 12290, 20320, 35201, 32487, 32493, 21527, 65311}), String.valueOf(new char[]{35777, 20070, 38169, 35823, 12290, 20320, 35201, 32487, 32493, 21527, 65311})};
            strValueOf = String.valueOf(new char[]{35777, 20070, 38169, 35823});
            strValueOf2 = String.valueOf(new char[]{32487, 32493});
            strValueOf3 = String.valueOf(new char[]{20572, 27490});
        } else {
            strArr = new String[]{"Certificate is untrusted. Do you want to continue anyway?", "Certificate has expired. Do you want to continue anyway?", "Certificate ID is mismatched. Do you want to continue anyway?", "Certificate is not yet valid. Do you want to continue anyway?", "Certificate error. Do you want to continue anyway?"};
            strValueOf = "SSL Certificate Error";
            strValueOf2 = "Yes";
            strValueOf3 = "No";
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(strValueOf);
        int primaryError = sslError.getPrimaryError();
        if (primaryError == 0) {
            builder.setMessage(strArr[3]);
        } else if (primaryError == 1) {
            builder.setMessage(strArr[1]);
        } else if (primaryError == 2) {
            builder.setMessage(strArr[2]);
        } else if (primaryError != 3) {
            builder.setMessage(strArr[4]);
        } else {
            builder.setMessage(strArr[0]);
        }
        builder.setCancelable(false);
        builder.setPositiveButton(strValueOf2, new DialogInterface.OnClickListener() { // from class: cn.sharesdk.framework.h.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i6) {
                dialogInterface.dismiss();
                try {
                    sslErrorHandler.proceed();
                } catch (Throwable th) {
                    SSDKLog.b().b(th);
                }
            }
        });
        builder.setNegativeButton(strValueOf3, new DialogInterface.OnClickListener() { // from class: cn.sharesdk.framework.h.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i6) {
                dialogInterface.dismiss();
                sslErrorHandler.cancel();
            }
        });
        try {
            builder.create().show();
        } catch (Throwable th) {
            SSDKLog.b().b(th);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f7, float f8) {
    }

    @Override // android.webkit.WebViewClient
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        message.sendToTarget();
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return false;
    }
}
