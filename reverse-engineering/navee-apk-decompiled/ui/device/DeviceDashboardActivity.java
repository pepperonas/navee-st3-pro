package com.uz.navee.ui.device;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.clj.fastble.data.BleDevice;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.bean.DeviceSubPageInfo;
import com.uz.navee.bean.Vehicle;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Locale;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class DeviceDashboardActivity extends BaseActivity {
    public PropertyChangeListener A;
    public PropertyChangeListener B;
    public PropertyChangeListener C;
    public PropertyChangeListener D;
    public PropertyChangeListener E;

    /* renamed from: c, reason: collision with root package name */
    public TextView f12024c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f12025d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f12026e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f12027f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f12028g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f12029h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f12030i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f12031j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f12032k;

    /* renamed from: l, reason: collision with root package name */
    public TextView f12033l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f12034m;

    /* renamed from: n, reason: collision with root package name */
    public TextView f12035n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f12036o;

    /* renamed from: p, reason: collision with root package name */
    public TextView f12037p;

    /* renamed from: q, reason: collision with root package name */
    public TextView f12038q;

    /* renamed from: r, reason: collision with root package name */
    public TextView f12039r;

    /* renamed from: s, reason: collision with root package name */
    public TextView f12040s;

    /* renamed from: t, reason: collision with root package name */
    public TextView f12041t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f12042u;

    /* renamed from: v, reason: collision with root package name */
    public TextView f12043v;

    /* renamed from: w, reason: collision with root package name */
    public BleDevice f12044w;

    /* renamed from: x, reason: collision with root package name */
    public Vehicle f12045x;

    /* renamed from: y, reason: collision with root package name */
    public PropertyChangeListener f12046y;

    /* renamed from: z, reason: collision with root package name */
    public PropertyChangeListener f12047z;

    private void X() {
        this.f12024c = (TextView) findViewById(R$id.speedLabel);
        this.f12025d = (TextView) findViewById(R$id.speedUnitLabel);
        this.f12026e = (TextView) findViewById(R$id.rangeLabel);
        this.f12027f = (TextView) findViewById(R$id.rangeUnitLabel);
        this.f12028g = (TextView) findViewById(R$id.rangeTitleLabel);
        this.f12029h = (TextView) findViewById(R$id.chargeLabel);
        this.f12030i = (TextView) findViewById(R$id.chargeUnitLabel);
        this.f12031j = (TextView) findViewById(R$id.chargeTitleLabel);
        this.f12032k = (TextView) findViewById(R$id.mileageLabel);
        this.f12033l = (TextView) findViewById(R$id.mileageUnitLabel);
        this.f12034m = (TextView) findViewById(R$id.mileageTitleLabel);
        this.f12035n = (TextView) findViewById(R$id.durationLabel);
        this.f12036o = (TextView) findViewById(R$id.durationUnitLabel);
        this.f12037p = (TextView) findViewById(R$id.durationTitleLabel);
        this.f12038q = (TextView) findViewById(R$id.maxSpeedLabel);
        this.f12039r = (TextView) findViewById(R$id.maxSpeedUnitLabel);
        this.f12040s = (TextView) findViewById(R$id.maxSpeedTitleLabel);
        this.f12041t = (TextView) findViewById(R$id.averageSpeedLabel);
        this.f12042u = (TextView) findViewById(R$id.averageSpeedUnitLabel);
        this.f12043v = (TextView) findViewById(R$id.averageSpeedTitleLabel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(PropertyChangeEvent propertyChangeEvent) {
        if ("realTimeSpeed".equals(propertyChangeEvent.getPropertyName())) {
            l0(((Integer) propertyChangeEvent.getNewValue()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(PropertyChangeEvent propertyChangeEvent) {
        if ("remainMileage".equals(propertyChangeEvent.getPropertyName())) {
            m0(((Integer) propertyChangeEvent.getNewValue()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(PropertyChangeEvent propertyChangeEvent) {
        if ("drivingMileage".equals(propertyChangeEvent.getPropertyName())) {
            j0(((Integer) propertyChangeEvent.getNewValue()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(PropertyChangeEvent propertyChangeEvent) {
        if ("drivingDuration".equals(propertyChangeEvent.getPropertyName())) {
            i0(((Integer) propertyChangeEvent.getNewValue()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(PropertyChangeEvent propertyChangeEvent) {
        if ("maximumSpeed".equals(propertyChangeEvent.getPropertyName())) {
            k0(((Integer) propertyChangeEvent.getNewValue()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(PropertyChangeEvent propertyChangeEvent) {
        if ("averageSpeed".equals(propertyChangeEvent.getPropertyName())) {
            g0(((Integer) propertyChangeEvent.getNewValue()).intValue());
        }
    }

    public final /* synthetic */ void Y(PropertyChangeEvent propertyChangeEvent) {
        if ("batteryCharge".equals(propertyChangeEvent.getPropertyName())) {
            h0(((Integer) propertyChangeEvent.getNewValue()).intValue());
        }
    }

    public final void f0(DeviceSubPageInfo deviceSubPageInfo) {
        this.f12046y = deviceSubPageInfo.addListener("batteryCharge", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.i3
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12548a.Y(propertyChangeEvent);
            }
        });
        this.f12047z = deviceSubPageInfo.addListener("realTimeSpeed", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.j3
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12558a.Z(propertyChangeEvent);
            }
        });
        this.A = deviceSubPageInfo.addListener("remainMileage", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.k3
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12567a.a0(propertyChangeEvent);
            }
        });
        this.B = deviceSubPageInfo.addListener("drivingMileage", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.l3
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12576a.b0(propertyChangeEvent);
            }
        });
        this.C = deviceSubPageInfo.addListener("drivingDuration", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.m3
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12587a.c0(propertyChangeEvent);
            }
        });
        this.D = deviceSubPageInfo.addListener("maximumSpeed", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.n3
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12598a.d0(propertyChangeEvent);
            }
        });
        this.E = deviceSubPageInfo.addListener("averageSpeed", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.o3
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12606a.e0(propertyChangeEvent);
            }
        });
    }

    public final void g0(int i6) {
        float f7 = i6;
        if (b4.a.W().f1932e.getVersion() == 1) {
            f7 = (float) (f7 / 10.0d);
        }
        if (b4.a.W().f1933f.getMileageUnit() == 0) {
            this.f12041t.setText(String.valueOf((int) (Math.round(f7) * 0.621d)));
        } else {
            this.f12041t.setText(String.valueOf(Math.round(f7)));
        }
    }

    public final void h0(int i6) {
        this.f12029h.setText(String.valueOf(i6));
    }

    public final void i0(int i6) {
        this.f12035n.setText(String.valueOf(i6));
    }

    public final void j0(int i6) {
        float f7 = i6;
        if (b4.a.W().f1932e.getVersion() == 1) {
            f7 = (float) (f7 / 10.0d);
        }
        if (b4.a.W().f1933f.getMileageUnit() == 0) {
            f7 = (float) (f7 * 0.621d);
        }
        String str = String.format(Locale.getDefault(), "%.1f", Float.valueOf(f7));
        if (str.endsWith(".0")) {
            str = str.split("\\.0")[0];
        }
        this.f12032k.setText(str);
    }

    public final void k0(int i6) {
        float f7 = i6;
        if (b4.a.W().f1932e.getVersion() == 1) {
            f7 = (float) (f7 / 10.0d);
        }
        if (b4.a.W().f1933f.getMileageUnit() == 0) {
            this.f12038q.setText(String.valueOf((int) (Math.round(f7) * 0.621d)));
        } else {
            this.f12038q.setText(String.valueOf(Math.round(f7)));
        }
    }

    public final void l0(int i6) {
        float f7 = i6;
        if (b4.a.W().f1932e.getVersion() == 1) {
            f7 = (float) (f7 / 10.0d);
        }
        if (b4.a.W().f1933f.getMileageUnit() == 0) {
            this.f12024c.setText(String.valueOf((int) (Math.round(f7) * 0.621d)));
        } else {
            this.f12024c.setText(String.valueOf(Math.round(f7)));
        }
    }

    public final void m0(int i6) {
        if (b4.a.W().f1933f.getMileageUnit() == 0) {
            this.f12026e.setText(String.valueOf((int) Math.round(i6 * 0.621d)));
        } else {
            this.f12026e.setText(String.valueOf(i6));
        }
    }

    public final void n0() {
        String string = getString(b4.a.W().f1933f.getMileageUnit() == 0 ? R$string.unit_mileage_imperial : R$string.unit_mileage_metric);
        String string2 = getString(b4.a.W().f1933f.getMileageUnit() == 0 ? R$string.unit_speed_imperial : R$string.unit_speed_metric);
        this.f12027f.setText(string);
        this.f12033l.setText(string);
        this.f12025d.setText(string2);
        this.f12039r.setText(string2);
        this.f12042u.setText(string2);
        h0(b4.a.W().f1932e.getBatteryCharge());
        l0(b4.a.W().f1932e.getRealTimeSpeed());
        m0(b4.a.W().f1932e.getRemainMileage());
        j0(b4.a.W().f1932e.getDrivingMileage());
        i0(b4.a.W().f1932e.getDrivingDuration());
        k0(b4.a.W().f1932e.getMaximumSpeed());
        g0(b4.a.W().f1932e.getAverageSpeed());
    }

    public final void o0(DeviceSubPageInfo deviceSubPageInfo) {
        deviceSubPageInfo.removeListener("batteryCharge", this.f12046y);
        deviceSubPageInfo.removeListener("realTimeSpeed", this.f12047z);
        deviceSubPageInfo.removeListener("remainMileage", this.A);
        deviceSubPageInfo.removeListener("drivingMileage", this.B);
        deviceSubPageInfo.removeListener("drivingDuration", this.C);
        deviceSubPageInfo.removeListener("maximumSpeed", this.D);
        deviceSubPageInfo.removeListener("averageSpeed", this.E);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_device_dashboard);
        X();
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        if (bundleExtra != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.f12044w = (BleDevice) bundleExtra.getParcelable("bleDevice", BleDevice.class);
                this.f12045x = (Vehicle) bundleExtra.getSerializable("vehicle", Vehicle.class);
            } else {
                this.f12044w = (BleDevice) bundleExtra.getParcelable("bleDevice");
                this.f12045x = (Vehicle) bundleExtra.getSerializable("vehicle");
            }
        }
        com.uz.navee.utils.c.e(this, this.f12045x.displayName(), ContextCompat.getColor(this, R$color.nav_title_color));
        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(getAssets(), "font/youshebiaotihei_regular.ttf");
        this.f12024c.setTypeface(typefaceCreateFromAsset);
        this.f12025d.setTypeface(typefaceCreateFromAsset);
        f0(b4.a.W().f1932e);
        if (com.uz.navee.utils.d.o()) {
            this.f12028g.setTextSize(15.0f);
            this.f12031j.setTextSize(15.0f);
            this.f12034m.setTextSize(15.0f);
            this.f12037p.setTextSize(15.0f);
            this.f12040s.setTextSize(15.0f);
            this.f12043v.setTextSize(15.0f);
            return;
        }
        this.f12028g.setTextSize(12.0f);
        this.f12031j.setTextSize(12.0f);
        this.f12034m.setTextSize(12.0f);
        this.f12037p.setTextSize(12.0f);
        this.f12040s.setTextSize(12.0f);
        this.f12043v.setTextSize(12.0f);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        o0(b4.a.W().f1932e);
        super.onDestroy();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        n0();
        b4.a.G(this.f12044w);
    }
}
