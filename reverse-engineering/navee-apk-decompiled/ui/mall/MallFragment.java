package com.uz.navee.ui.mall;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.bean.MallResponseData;
import d4.d;

/* loaded from: classes3.dex */
public class MallFragment extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public View f12896a;

    /* renamed from: b, reason: collision with root package name */
    public WebView f12897b;

    /* renamed from: c, reason: collision with root package name */
    public ProgressBar f12898c;

    public class a extends WebChromeClient {
        public a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i6) {
            if (i6 == 100) {
                MallFragment.this.f12898c.setVisibility(8);
            } else {
                MallFragment.this.f12898c.setVisibility(0);
                MallFragment.this.f12898c.setProgress(i6);
            }
        }
    }

    public class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest == null || webResourceRequest.getUrl().toString().startsWith("http")) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            return true;
        }
    }

    public class c implements d.h {

        public class a extends TypeToken<HttpResponse<MallResponseData>> {
            public a() {
            }
        }

        public c() {
        }

        @Override // d4.d.h
        public void a(String str) {
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse == null || httpResponse.getCode() != 200) {
                return;
            }
            MallFragment.this.f12897b.loadUrl(((MallResponseData) httpResponse.getData()).getUrl());
        }

        @Override // d4.d.h
        public void b(Exception exc) {
        }
    }

    private void d() {
        WebSettings settings = this.f12897b.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBlockNetworkImage(false);
        settings.setMixedContentMode(2);
        settings.setBuiltInZoomControls(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        settings.setDisplayZoomControls(false);
        this.f12897b.setFocusable(true);
        this.f12897b.requestFocus();
        this.f12897b.setHorizontalScrollBarEnabled(false);
        this.f12897b.setVerticalScrollBarEnabled(false);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setAllowContentAccess(true);
        if (com.uz.navee.utils.d.m(requireContext())) {
            settings.setCacheMode(-1);
        } else {
            settings.setCacheMode(1);
        }
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        this.f12897b.setWebChromeClient(new a());
        this.f12897b.setWebViewClient(new b());
    }

    public final void e() {
        d.h().f(e4.a.a() + "/getShopUrl", new c());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.f12896a;
        if (view == null) {
            View viewInflate = layoutInflater.inflate(R$layout.fragment_mall, viewGroup, false);
            this.f12896a = viewInflate;
            this.f12897b = (WebView) viewInflate.findViewById(R$id.webView);
            this.f12898c = (ProgressBar) this.f12896a.findViewById(R$id.progress_bar);
            d();
            e();
        } else {
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.f12896a);
            }
        }
        return this.f12896a;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }
}
