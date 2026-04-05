package com.uz.navee.ui.device;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.rajat.pdfviewer.PdfQuality;
import com.rajat.pdfviewer.PdfRendererView;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.network.utils.DownloadUtils;
import java.io.File;

/* loaded from: classes3.dex */
public class DeviceManualActivity extends BaseActivity implements DownloadUtils.b {

    /* renamed from: c, reason: collision with root package name */
    public PdfRendererView f12219c;

    /* renamed from: d, reason: collision with root package name */
    public ProgressBar f12220d;

    /* renamed from: e, reason: collision with root package name */
    public String f12221e;

    /* renamed from: f, reason: collision with root package name */
    public String f12222f;

    public final void Q() {
        this.f12219c.l(this.f12222f, PdfQuality.NORMAL);
    }

    public final void R() {
        if (this.f12221e != null) {
            String str = getFilesDir().getAbsolutePath() + "/pdf";
            String str2 = com.uz.navee.utils.j0.d(this.f12221e) + ".pdf";
            this.f12222f = str + RemoteSettings.FORWARD_SLASH_STRING + com.uz.navee.utils.j0.d(this.f12221e) + ".pdf";
            if (new File(this.f12222f).exists()) {
                Q();
                return;
            }
            K();
            DownloadUtils.f().set0nDownloadListener(this);
            DownloadUtils.f().e(str, str2, this.f12221e);
        }
    }

    @Override // com.uz.navee.network.utils.DownloadUtils.b
    public void c(DownloadUtils.DownloadStatus downloadStatus, float f7, String str) {
        if (downloadStatus == DownloadUtils.DownloadStatus.success) {
            B();
            Q();
        } else {
            if (downloadStatus == DownloadUtils.DownloadStatus.failed) {
                B();
                Toast.makeText(this, getString(R$string.data_status_fail), 0).show();
                return;
            }
            int i6 = (int) (f7 * 100.0f);
            if (i6 >= 100) {
                this.f12220d.setVisibility(8);
            } else {
                this.f12220d.setVisibility(0);
                this.f12220d.setProgress(i6);
            }
        }
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_device_manual);
        this.f12219c = (PdfRendererView) findViewById(R$id.pdfView);
        this.f12220d = (ProgressBar) findViewById(R$id.progress_bar);
        com.uz.navee.utils.c.e(this, getString(R$string.product_manual), ContextCompat.getColor(this, R$color.nav_title_color));
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        if (bundleExtra != null) {
            this.f12221e = bundleExtra.getString(ImagesContract.URL, null);
        }
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        DownloadUtils.f().set0nDownloadListener(null);
        super.onDestroy();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        R();
    }
}
