package com.uz.navee.ui.mine;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.utils.c;
import com.uz.navee.utils.d;
import com.uz.navee.utils.g0;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class UserAgreementActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public String f13130c;

    /* renamed from: d, reason: collision with root package name */
    public WebView f13131d;

    /* renamed from: e, reason: collision with root package name */
    public ProgressBar f13132e;

    public class a extends WebChromeClient {
        public a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i6) {
            if (i6 == 100) {
                UserAgreementActivity.this.f13132e.setVisibility(8);
            } else {
                UserAgreementActivity.this.f13132e.setVisibility(0);
                UserAgreementActivity.this.f13132e.setProgress(i6);
            }
        }
    }

    private void Q() {
        this.f13131d = (WebView) findViewById(R$id.webView);
        this.f13132e = (ProgressBar) findViewById(R$id.progress_bar);
    }

    private void initView() {
        String strE;
        WebSettings settings = this.f13131d.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBlockNetworkImage(false);
        settings.setMixedContentMode(2);
        settings.setBuiltInZoomControls(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        settings.setDisplayZoomControls(false);
        this.f13131d.setFocusable(true);
        this.f13131d.requestFocus();
        this.f13131d.setHorizontalScrollBarEnabled(false);
        this.f13131d.setVerticalScrollBarEnabled(false);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setAllowContentAccess(true);
        if (d.m(this)) {
            settings.setCacheMode(-1);
        } else {
            settings.setCacheMode(1);
        }
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        this.f13131d.setWebChromeClient(new a());
        String str = this.f13130c;
        if (str == null || str.isEmpty()) {
            strE = g0.e("app.userURL", "");
        } else {
            strE = g0.e(this.f13130c + ".vehicleModel.userURL", "");
        }
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        this.f13131d.loadUrl(strE);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_user_agreement);
        Q();
        c.e(this, getString(R$string.user_agreement), ContextCompat.getColor(this, R$color.nav_title_color));
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        if (bundleExtra != null) {
            this.f13130c = bundleExtra.getString("vehicleModelId", null);
        }
        initView();
    }
}
