package com.uz.navee.ui.device;

import android.R;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.exoplayer.Renderer;
import com.clj.fastble.data.BleDevice;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.uz.navee.MainActivity;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.bean.EmptyResponseData;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.bean.Vehicle;
import d4.d;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class PolicyRevokeActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public WebView f12384c;

    /* renamed from: d, reason: collision with root package name */
    public ProgressBar f12385d;

    /* renamed from: e, reason: collision with root package name */
    public Button f12386e;

    /* renamed from: f, reason: collision with root package name */
    public String f12387f;

    /* renamed from: g, reason: collision with root package name */
    public CountDownTimer f12388g;

    /* renamed from: h, reason: collision with root package name */
    public BleDevice f12389h;

    /* renamed from: i, reason: collision with root package name */
    public Vehicle f12390i;

    public class a extends WebChromeClient {
        public a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i6) {
            if (i6 == 100) {
                PolicyRevokeActivity.this.f12385d.setVisibility(8);
                PolicyRevokeActivity.this.f12388g.start();
            } else {
                PolicyRevokeActivity.this.f12385d.setVisibility(0);
                PolicyRevokeActivity.this.f12385d.setProgress(i6);
            }
        }
    }

    public class b extends CountDownTimer {
        public b(long j6, long j7) {
            super(j6, j7);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PolicyRevokeActivity policyRevokeActivity = PolicyRevokeActivity.this;
            policyRevokeActivity.f12386e.setText(policyRevokeActivity.getString(R$string.confirm));
            PolicyRevokeActivity.this.f12386e.setEnabled(true);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j6) {
            int i6 = (int) (j6 / 1000);
            if (i6 <= 0) {
                PolicyRevokeActivity.this.f12388g.cancel();
                PolicyRevokeActivity policyRevokeActivity = PolicyRevokeActivity.this;
                policyRevokeActivity.f12386e.setText(policyRevokeActivity.getString(R$string.confirm));
                PolicyRevokeActivity.this.f12386e.setEnabled(true);
                return;
            }
            PolicyRevokeActivity.this.f12386e.setText(PolicyRevokeActivity.this.getString(R$string.confirm) + " (" + i6 + "s)");
            PolicyRevokeActivity.this.f12386e.setEnabled(false);
        }
    }

    public class c implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12393a;

        public class a extends TypeToken<HttpResponse<EmptyResponseData>> {
            public a() {
            }
        }

        public c(String str) {
            this.f12393a = str;
        }

        @Override // d4.d.h
        public void a(String str) throws IOException {
            PolicyRevokeActivity.this.B();
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse != null) {
                if (httpResponse.getCode() != 200) {
                    new QMUITipDialog.a(PolicyRevokeActivity.this).f(3).g(httpResponse.getMsg()).a().show();
                    return;
                }
                b4.a.c0(PolicyRevokeActivity.this.f12389h, b4.a.k(80, 1, false));
                b4.a.P(this.f12393a);
                b4.a.Q();
                PolicyRevokeActivity.this.a0();
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            PolicyRevokeActivity.this.B();
            new QMUITipDialog.a(PolicyRevokeActivity.this).f(3).g(exc.getLocalizedMessage()).a().show();
        }
    }

    private void U() {
        this.f12384c = (WebView) findViewById(R$id.webView);
        this.f12385d = (ProgressBar) findViewById(R$id.progress_bar);
        this.f12386e = (Button) findViewById(R$id.confirmButton);
    }

    private void X() {
        this.f12388g = new b(Renderer.DEFAULT_DURATION_TO_PROGRESS_US, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(View view) {
        Z();
    }

    private void Z() {
        if (this.f12390i == null || this.f12389h == null) {
            return;
        }
        K();
        Vehicle vehicle = this.f12390i;
        String str = vehicle.mac;
        String str2 = vehicle.model.pid;
        if (str == null) {
            return;
        }
        String str3 = e4.a.a() + "/vehicle/unbind";
        d4.d dVarH = d4.d.h();
        HashMap map = new HashMap();
        map.put("mac", str);
        map.put("pid", str2);
        dVarH.g(str3, map, new c(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("BleDeviceChangedNotification"));
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
    }

    private void initView() {
        WebSettings settings = this.f12384c.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBlockNetworkImage(false);
        settings.setMixedContentMode(2);
        settings.setBuiltInZoomControls(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        settings.setDisplayZoomControls(false);
        this.f12384c.setFocusable(true);
        this.f12384c.requestFocus();
        this.f12384c.setHorizontalScrollBarEnabled(false);
        this.f12384c.setVerticalScrollBarEnabled(false);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setAllowContentAccess(true);
        if (com.uz.navee.utils.d.m(this)) {
            settings.setCacheMode(-1);
        } else {
            settings.setCacheMode(1);
        }
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        this.f12384c.setWebChromeClient(new a());
        if (TextUtils.isEmpty(this.f12387f)) {
            return;
        }
        this.f12384c.loadUrl(this.f12387f);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_policy_revoke);
        U();
        com.uz.navee.utils.c.e(this, getString(R$string.revoke_policy), ContextCompat.getColor(this, R$color.nav_title_color));
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        if (bundleExtra != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.f12389h = (BleDevice) bundleExtra.getParcelable("bleDevice", BleDevice.class);
                this.f12390i = (Vehicle) bundleExtra.getSerializable("vehicle", Vehicle.class);
            } else {
                this.f12389h = (BleDevice) bundleExtra.getParcelable("bleDevice");
                this.f12390i = (Vehicle) bundleExtra.getSerializable("vehicle");
            }
            this.f12387f = bundleExtra.getString(ImagesContract.URL, null);
        }
        initView();
        this.f12386e.setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, new int[]{-16842910}}, new int[]{ContextCompat.getColor(this, R$color.xF2E1D6), ContextCompat.getColor(this, R$color.xF2E1D6_40)}));
        this.f12386e.setEnabled(false);
        this.f12386e.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.a8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12469a.Y(view);
            }
        });
        X();
    }
}
