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
import com.uz.navee.bean.DeviceCarInfo;
import com.uz.navee.ui.wheel.AlertPopup;
import com.uz.navee.utils.DensityUtil;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

/* loaded from: classes3.dex */
public class AccelerationActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public QMUIGroupListView f11694c;

    /* renamed from: d, reason: collision with root package name */
    public QMUICommonListItemView f11695d;

    /* renamed from: e, reason: collision with root package name */
    public QMUICommonListItemView f11696e;

    /* renamed from: f, reason: collision with root package name */
    public BleDevice f11697f;

    /* renamed from: g, reason: collision with root package name */
    public int f11698g;

    /* renamed from: h, reason: collision with root package name */
    public PropertyChangeListener f11699h;

    private void U() {
        this.f11694c = (QMUIGroupListView) findViewById(R$id.groupListView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(PropertyChangeEvent propertyChangeEvent) {
        if ("drivingMode".equals(propertyChangeEvent.getPropertyName())) {
            this.f11698g = b4.a.W().f1933f.getDrivingMode();
            c0();
        }
    }

    public static /* synthetic */ void Z() {
    }

    private void a0(DeviceCarInfo deviceCarInfo) {
        this.f11699h = deviceCarInfo.addListener("drivingMode", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.d
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12489a.Y(propertyChangeEvent);
            }
        });
    }

    private void b0() {
        if (b4.a.f(this.f11697f)) {
            b4.a.G(this.f11697f);
        }
    }

    private void f0(DeviceCarInfo deviceCarInfo) {
        deviceCarInfo.removeListener("drivingMode", this.f11699h);
    }

    public final void V() {
        int iA = DensityUtil.a(this, 16.0f);
        QMUICommonListItemView qMUICommonListItemViewC = this.f11694c.c(null, getString(R$string.eco_mode), "", 1, 3);
        this.f11695d = qMUICommonListItemViewC;
        qMUICommonListItemViewC.setRadius(iA);
        QMUICommonListItemView qMUICommonListItemViewC2 = this.f11694c.c(null, getString(R$string.turbo_mode), "", 1, 3);
        this.f11696e = qMUICommonListItemViewC2;
        qMUICommonListItemViewC2.setRadius(iA);
        c0();
        QMUIGroupListView.e(this).c(this.f11695d, new View.OnClickListener() { // from class: com.uz.navee.ui.device.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IOException {
                this.f12471a.W(view);
            }
        }).e(this.f11694c);
        QMUIGroupListView.e(this).c(this.f11696e, new View.OnClickListener() { // from class: com.uz.navee.ui.device.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IOException {
                this.f12480a.X(view);
            }
        }).e(this.f11694c);
        if (com.uz.navee.utils.d.o()) {
            this.f11695d.getTextView().setTextSize(16.0f);
            this.f11696e.getTextView().setTextSize(16.0f);
        } else {
            this.f11695d.getTextView().setTextSize(13.0f);
            this.f11696e.getTextView().setTextSize(13.0f);
        }
        if (com.uz.navee.utils.d.p(this)) {
            com.uz.navee.utils.d.b(this.f11694c);
        }
    }

    public final /* synthetic */ void W(View view) throws IOException {
        d0();
    }

    public final /* synthetic */ void X(View view) throws IOException {
        e0();
    }

    public final void c0() {
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, R$mipmap.ic_check));
        if (this.f11698g == 5) {
            this.f11695d.setAccessoryType(0);
            this.f11696e.setAccessoryType(3);
            this.f11696e.l(imageView);
        } else {
            this.f11696e.setAccessoryType(0);
            this.f11695d.setAccessoryType(3);
            this.f11695d.l(imageView);
        }
    }

    public final void d0() throws IOException {
        this.f11698g = 3;
        c0();
        if (b4.a.f(this.f11697f)) {
            b4.a.c0(this.f11697f, b4.a.k(88, this.f11698g, false));
        }
    }

    public final void e0() throws IOException {
        this.f11698g = 5;
        c0();
        if (b4.a.f(this.f11697f)) {
            b4.a.c0(this.f11697f, b4.a.k(88, this.f11698g, false));
        }
        AlertPopup.Q(this, getResources().getString(R$string.kind_tips), getResources().getString(R$string.turbo_mode_tips), null, getResources().getString(R$string.i_see), new AlertPopup.a() { // from class: com.uz.navee.ui.device.e
            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public /* synthetic */ void a() {
                j4.c.a(this);
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public final void b() {
                AccelerationActivity.Z();
            }
        });
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_acceleration);
        U();
        com.uz.navee.utils.c.e(this, getString(R$string.acceleration_title), ContextCompat.getColor(this, R$color.nav_title_color));
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        if (bundleExtra != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.f11697f = (BleDevice) bundleExtra.getParcelable("bleDevice", BleDevice.class);
            } else {
                this.f11697f = (BleDevice) bundleExtra.getParcelable("bleDevice");
            }
        }
        this.f11698g = b4.a.W().f1933f.getDrivingMode();
        V();
        a0(b4.a.W().f1933f);
        b0();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        f0(b4.a.W().f1933f);
        super.onDestroy();
    }
}
