package com.uz.navee.ui.web;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* loaded from: classes3.dex */
public class DefaultWebView extends WebView {

    public interface a {
        String a();
    }

    public DefaultWebView(Context context) {
        this(context, null);
    }

    public void a(a aVar) {
        super.addJavascriptInterface(aVar, aVar.a());
    }

    public void b(String str, ValueCallback valueCallback, Object... objArr) {
        super.evaluateJavascript(d(str, objArr), valueCallback);
    }

    public final void c() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(-1);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setBuiltInZoomControls(false);
        settings.setDomStorageEnabled(true);
        settings.setSupportMultipleWindows(false);
        settings.setNeedInitialFocus(false);
        settings.setDatabaseEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setSupportZoom(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setUseWideViewPort(true);
        setScrollBarStyle(33554432);
        settings.setMixedContentMode(0);
        requestFocus();
    }

    public final String d(String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:");
        sb.append(str);
        sb.append("(");
        int length = objArr.length;
        String str2 = "";
        int i6 = 0;
        while (i6 < length) {
            Object obj = objArr[i6];
            sb.append(str2);
            if (obj instanceof String) {
                sb.append("'");
            }
            sb.append(obj.toString().replace("'", "\\'"));
            if (obj instanceof String) {
                sb.append("'");
            }
            i6++;
            str2 = ",";
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // android.webkit.WebView
    public void destroy() {
        stopLoading();
        loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
        clearHistory();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
        removeAllViews();
        super.destroy();
    }

    public DefaultWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public DefaultWebView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        c();
    }
}
