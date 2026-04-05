package com.uz.navee.ui.device;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.clj.fastble.data.BleDevice;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.utils.DensityUtil;
import java.io.IOException;

/* loaded from: classes3.dex */
public class DeviceMileageUnitActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public QMUIGroupListView f12223c;

    /* renamed from: d, reason: collision with root package name */
    public QMUICommonListItemView f12224d;

    /* renamed from: e, reason: collision with root package name */
    public QMUICommonListItemView f12225e;

    /* renamed from: f, reason: collision with root package name */
    public BleDevice f12226f;

    /* renamed from: g, reason: collision with root package name */
    public int f12227g;

    private void S() {
        this.f12223c = (QMUIGroupListView) findViewById(R$id.groupListView);
    }

    private void T() {
        int iA = DensityUtil.a(this, 16.0f);
        QMUICommonListItemView qMUICommonListItemViewC = this.f12223c.c(null, getString(R$string.metric) + " (" + getString(R$string.unit_speed_metric) + ")", "", 1, 3);
        this.f12224d = qMUICommonListItemViewC;
        qMUICommonListItemViewC.setRadius(iA);
        QMUICommonListItemView qMUICommonListItemViewC2 = this.f12223c.c(null, getString(R$string.imperial) + " (" + getString(R$string.unit_speed_imperial) + ")", "", 1, 3);
        this.f12225e = qMUICommonListItemViewC2;
        qMUICommonListItemViewC2.setRadius(iA);
        W();
        QMUIGroupListView.e(this).c(this.f12224d, new View.OnClickListener() { // from class: com.uz.navee.ui.device.r5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IOException {
                this.f12635a.U(view);
            }
        }).e(this.f12223c);
        QMUIGroupListView.e(this).c(this.f12225e, new View.OnClickListener() { // from class: com.uz.navee.ui.device.s5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IOException {
                this.f12648a.V(view);
            }
        }).e(this.f12223c);
        if (com.uz.navee.utils.d.o()) {
            this.f12224d.getTextView().setTextSize(16.0f);
            this.f12225e.getTextView().setTextSize(16.0f);
        } else {
            this.f12224d.getTextView().setTextSize(13.0f);
            this.f12225e.getTextView().setTextSize(13.0f);
        }
        if (com.uz.navee.utils.d.p(this)) {
            com.uz.navee.utils.d.b(this.f12223c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(View view) throws IOException {
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(View view) throws IOException {
        X();
    }

    private void W() {
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, R$mipmap.ic_check));
        if (this.f12227g == 0) {
            this.f12224d.setAccessoryType(0);
            this.f12225e.setAccessoryType(3);
            this.f12225e.l(imageView);
        } else {
            this.f12225e.setAccessoryType(0);
            this.f12224d.setAccessoryType(3);
            this.f12224d.l(imageView);
        }
    }

    public final void X() throws IOException {
        if (b4.a.f(this.f12226f)) {
            this.f12227g = 0;
            W();
            b4.a.c0(this.f12226f, b4.a.k(85, this.f12227g, false));
        }
    }

    public final void Y() throws IOException {
        if (b4.a.f(this.f12226f)) {
            this.f12227g = 1;
            W();
            b4.a.c0(this.f12226f, b4.a.k(85, this.f12227g, false));
        }
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_device_mileage_unit);
        S();
        com.uz.navee.utils.c.e(this, getString(R$string.switch_mileage_unit), ContextCompat.getColor(this, R$color.nav_title_color));
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        if (bundleExtra != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.f12226f = (BleDevice) bundleExtra.getParcelable("bleDevice", BleDevice.class);
            } else {
                this.f12226f = (BleDevice) bundleExtra.getParcelable("bleDevice");
            }
        }
        this.f12227g = b4.a.W().f1933f.getMileageUnit();
        T();
    }
}
