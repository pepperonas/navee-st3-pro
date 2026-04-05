package com.uz.navee.ui.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.clj.fastble.data.BleDevice;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.bean.DeviceHomePageInfo;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.bean.VehicleModel;
import com.uz.navee.ble.AreaCode;
import com.uz.navee.ble.SKUVersion;
import com.uz.navee.ui.mine.QuestionListActivity;
import com.uz.navee.utils.CommonExt;
import com.uz.navee.utils.DensityUtil;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

/* loaded from: classes3.dex */
public class DeviceBatteryInfoActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public QMUIGroupListView f11947c;

    /* renamed from: d, reason: collision with root package name */
    public QMUIGroupListView.a f11948d;

    /* renamed from: e, reason: collision with root package name */
    public BleDevice f11949e;

    /* renamed from: f, reason: collision with root package name */
    public Vehicle f11950f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f11951g;

    /* renamed from: h, reason: collision with root package name */
    public QMUICommonListItemView f11952h;

    /* renamed from: i, reason: collision with root package name */
    public QMUICommonListItemView f11953i;

    /* renamed from: j, reason: collision with root package name */
    public QMUICommonListItemView f11954j;

    /* renamed from: k, reason: collision with root package name */
    public QMUICommonListItemView f11955k;

    /* renamed from: l, reason: collision with root package name */
    public QMUICommonListItemView f11956l;

    /* renamed from: m, reason: collision with root package name */
    public QMUICommonListItemView f11957m;

    /* renamed from: n, reason: collision with root package name */
    public QMUICommonListItemView f11958n;

    /* renamed from: o, reason: collision with root package name */
    public QMUICommonListItemView f11959o;

    /* renamed from: p, reason: collision with root package name */
    public QMUICommonListItemView f11960p;

    /* renamed from: q, reason: collision with root package name */
    public QMUICommonListItemView f11961q;

    /* renamed from: r, reason: collision with root package name */
    public QMUICommonListItemView f11962r;

    /* renamed from: s, reason: collision with root package name */
    public QMUICommonListItemView f11963s;

    /* renamed from: t, reason: collision with root package name */
    public QMUICommonListItemView f11964t;

    /* renamed from: u, reason: collision with root package name */
    public QMUICommonListItemView f11965u;

    /* renamed from: v, reason: collision with root package name */
    public QMUICommonListItemView f11966v;

    /* renamed from: w, reason: collision with root package name */
    public final BroadcastReceiver f11967w = new a();

    /* renamed from: x, reason: collision with root package name */
    public PropertyChangeListener f11968x;

    /* renamed from: y, reason: collision with root package name */
    public PropertyChangeListener f11969y;

    /* renamed from: z, reason: collision with root package name */
    public PropertyChangeListener f11970z;

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
            if (bleDevice == null || DeviceBatteryInfoActivity.this.f11949e == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(DeviceBatteryInfoActivity.this.f11949e))) {
                return;
            }
            DeviceBatteryInfoActivity.this.e0();
        }
    }

    private void W() {
        this.f11947c = (QMUIGroupListView) findViewById(R$id.groupListView);
    }

    private void X() {
        int iA = DensityUtil.a(this, 16.0f);
        this.f11952h = this.f11947c.c(null, getString(R$string.battery_status), "", 1, 0);
        this.f11953i = this.f11947c.c(null, getString(R$string.battery_power), "", 1, 0);
        this.f11954j = this.f11947c.c(null, getString(R$string.battery_voltage), "", 1, 0);
        this.f11955k = this.f11947c.c(null, getString(R$string.battery_current), "", 1, 0);
        this.f11956l = this.f11947c.c(null, getString(R$string.battery_temperature), "", 1, 0);
        this.f11957m = this.f11947c.c(null, getString(R$string.charging_state), "", 1, 0);
        this.f11958n = this.f11947c.c(null, getString(R$string.battery_cycles), "", 1, 0);
        this.f11959o = this.f11947c.c(null, getString(R$string.energy_throughput), "", 1, 0);
        this.f11960p = this.f11947c.c(null, getString(R$string.capacity_throughput), "", 1, 0);
        this.f11961q = this.f11947c.c(null, getString(R$string.deep_discharge), "", 1, 0);
        QMUICommonListItemView qMUICommonListItemViewC = this.f11947c.c(null, getString(R$string.self_discharge_rate), getString(R$string.self_discharge_rate_subtitle), 1, 1);
        this.f11962r = qMUICommonListItemViewC;
        com.uz.navee.utils.d.t(this, qMUICommonListItemViewC);
        this.f11963s = this.f11947c.c(null, getString(R$string.remain_capacity), "", 1, 0);
        this.f11964t = this.f11947c.c(null, getString(R$string.battery_generation_date), "", 1, 0);
        this.f11965u = this.f11947c.c(null, getString(R$string.extreme_temperature_duration), "", 1, 0);
        this.f11966v = this.f11947c.c(null, getString(R$string.extreme_temperature_charging_time), "", 1, 0);
        this.f11959o.e(iA, 3);
        this.f11966v.e(iA, 1);
        this.f11948d = QMUIGroupListView.e(this).c(this.f11959o, null).c(this.f11960p, null).c(this.f11961q, null).c(this.f11962r, new View.OnClickListener() { // from class: com.uz.navee.ui.device.t2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12655a.Z(view);
            }
        }).c(this.f11963s, null).c(this.f11964t, null).c(this.f11965u, null).c(this.f11966v, null);
        if (Y()) {
            this.f11952h.e(iA, 3);
            this.f11958n.e(iA, 1);
            QMUIGroupListView.e(this).c(this.f11952h, null).c(this.f11953i, null).c(this.f11954j, null).c(this.f11955k, null).c(this.f11956l, null).c(this.f11957m, null).c(this.f11958n, null).g(iA, iA).h(true).e(this.f11947c);
        } else {
            this.f11953i.e(iA, 3);
            this.f11955k.e(iA, 1);
            QMUIGroupListView.e(this).c(this.f11953i, null).c(this.f11954j, null).c(this.f11955k, null).g(iA, iA).h(true).e(this.f11947c);
        }
        if (Y() && b4.a.W().f1934g.isEuropeanRule() && !this.f11951g) {
            this.f11948d.e(this.f11947c);
            this.f11951g = true;
        }
        if (com.uz.navee.utils.d.o()) {
            this.f11952h.getTextView().setTextSize(15.0f);
            this.f11952h.getDetailTextView().setTextSize(13.0f);
            this.f11953i.getTextView().setTextSize(15.0f);
            this.f11953i.getDetailTextView().setTextSize(13.0f);
            this.f11954j.getTextView().setTextSize(15.0f);
            this.f11954j.getDetailTextView().setTextSize(13.0f);
            this.f11955k.getTextView().setTextSize(15.0f);
            this.f11955k.getDetailTextView().setTextSize(13.0f);
            this.f11956l.getTextView().setTextSize(15.0f);
            this.f11956l.getDetailTextView().setTextSize(13.0f);
            this.f11957m.getTextView().setTextSize(15.0f);
            this.f11957m.getDetailTextView().setTextSize(13.0f);
            this.f11958n.getTextView().setTextSize(15.0f);
            this.f11958n.getDetailTextView().setTextSize(13.0f);
            this.f11959o.getTextView().setTextSize(15.0f);
            this.f11959o.getDetailTextView().setTextSize(13.0f);
            this.f11960p.getTextView().setTextSize(15.0f);
            this.f11960p.getDetailTextView().setTextSize(13.0f);
            this.f11961q.getTextView().setTextSize(15.0f);
            this.f11961q.getDetailTextView().setTextSize(13.0f);
            this.f11962r.getTextView().setTextSize(15.0f);
            this.f11962r.getDetailTextView().setTextSize(13.0f);
            this.f11963s.getTextView().setTextSize(15.0f);
            this.f11963s.getDetailTextView().setTextSize(13.0f);
            this.f11964t.getTextView().setTextSize(15.0f);
            this.f11964t.getDetailTextView().setTextSize(13.0f);
            this.f11965u.getTextView().setTextSize(15.0f);
            this.f11965u.getDetailTextView().setTextSize(13.0f);
            this.f11966v.getTextView().setTextSize(15.0f);
            this.f11966v.getDetailTextView().setTextSize(13.0f);
        } else {
            this.f11952h.getTextView().setTextSize(13.0f);
            this.f11952h.getDetailTextView().setTextSize(11.0f);
            this.f11953i.getTextView().setTextSize(13.0f);
            this.f11953i.getDetailTextView().setTextSize(11.0f);
            this.f11954j.getTextView().setTextSize(13.0f);
            this.f11954j.getDetailTextView().setTextSize(11.0f);
            this.f11955k.getTextView().setTextSize(13.0f);
            this.f11955k.getDetailTextView().setTextSize(11.0f);
            this.f11956l.getTextView().setTextSize(13.0f);
            this.f11956l.getDetailTextView().setTextSize(11.0f);
            this.f11957m.getTextView().setTextSize(13.0f);
            this.f11957m.getDetailTextView().setTextSize(11.0f);
            this.f11958n.getTextView().setTextSize(13.0f);
            this.f11958n.getDetailTextView().setTextSize(11.0f);
            this.f11959o.getTextView().setTextSize(13.0f);
            this.f11959o.getDetailTextView().setTextSize(11.0f);
            this.f11960p.getTextView().setTextSize(13.0f);
            this.f11960p.getDetailTextView().setTextSize(11.0f);
            this.f11961q.getTextView().setTextSize(13.0f);
            this.f11961q.getDetailTextView().setTextSize(11.0f);
            this.f11962r.getTextView().setTextSize(13.0f);
            this.f11962r.getDetailTextView().setTextSize(11.0f);
            this.f11963s.getTextView().setTextSize(13.0f);
            this.f11963s.getDetailTextView().setTextSize(11.0f);
            this.f11964t.getTextView().setTextSize(13.0f);
            this.f11964t.getDetailTextView().setTextSize(11.0f);
            this.f11965u.getTextView().setTextSize(13.0f);
            this.f11965u.getDetailTextView().setTextSize(11.0f);
            this.f11966v.getTextView().setTextSize(13.0f);
            this.f11966v.getDetailTextView().setTextSize(11.0f);
        }
        if (com.uz.navee.utils.d.p(this)) {
            com.uz.navee.utils.d.b(this.f11947c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(View view) {
        f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(PropertyChangeEvent propertyChangeEvent) {
        if ("batteryVoltage".equals(propertyChangeEvent.getPropertyName())) {
            this.f11954j.setDetailText(b4.a.W().f1931d.getBatteryVoltage() + " mV");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(PropertyChangeEvent propertyChangeEvent) {
        String str;
        if (!"batteryStatus".equals(propertyChangeEvent.getPropertyName()) || (str = this.f11950f.model.pid) == null || str.startsWith("2322") || str.startsWith("2334")) {
            return;
        }
        this.f11952h.setDetailText(getString(b4.a.W().f1931d.getBatteryStatus() == 0 ? R$string.normal : R$string.abnormal));
    }

    public final boolean Y() {
        VehicleModel vehicleModel;
        Vehicle vehicle = this.f11950f;
        return (vehicle == null || (vehicleModel = vehicle.model) == null || vehicleModel.pid == null || ((vehicle.skuVersion() == SKUVersion.USA || this.f11950f.model.pid.endsWith("1")) && !this.f11950f.model.pid.startsWith("2213") && !this.f11950f.model.pid.startsWith("2353") && !this.f11950f.model.pid.startsWith("2436") && !this.f11950f.model.pid.startsWith("2438") && !this.f11950f.model.pid.startsWith("2437") && !this.f11950f.model.pid.startsWith("2441") && !this.f11950f.model.pid.startsWith("2517") && ((!this.f11950f.model.pid.startsWith("2442") || this.f11950f.areaCode() == AreaCode.US) && !this.f11950f.model.pid.startsWith("2518") && !this.f11950f.model.pid.startsWith("2519") && !this.f11950f.model.pid.startsWith("2509") && !this.f11950f.model.pid.startsWith("2611") && !this.f11950f.model.pid.startsWith("2612") && !this.f11950f.model.pid.startsWith("2643") && !b4.d.d(this.f11950f.model.pid) && !b4.d.m(this.f11950f.model.pid) && !b4.d.l(this.f11950f.model.pid) && !b4.d.e(this.f11950f.model.pid) && !b4.d.c(this.f11950f.model.pid) && !b4.d.k(this.f11950f.model.pid))) || b4.d.i(this.f11950f.model.pid) || b4.a.W().f1931d.getHideE9() != 0) ? false : true;
    }

    public final /* synthetic */ void b0(PropertyChangeEvent propertyChangeEvent) {
        if ("batteryCurrent".equals(propertyChangeEvent.getPropertyName())) {
            int batteryCurrent = b4.a.W().f1931d.getBatteryCurrent();
            if (((batteryCurrent >> 31) & 1) == 0) {
                if (b4.a.W().f1934g.getCurrentState() == 1) {
                }
                this.f11955k.setDetailText(batteryCurrent + " mA");
            }
            batteryCurrent &= Integer.MAX_VALUE;
            batteryCurrent *= -1;
            this.f11955k.setDetailText(batteryCurrent + " mA");
        }
    }

    public final void d0(DeviceHomePageInfo deviceHomePageInfo) {
        this.f11968x = deviceHomePageInfo.addListener("batteryVoltage", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.q2
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12623a.a0(propertyChangeEvent);
            }
        });
        this.f11969y = deviceHomePageInfo.addListener("batteryCurrent", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.r2
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12633a.b0(propertyChangeEvent);
            }
        });
        this.f11970z = deviceHomePageInfo.addListener("batteryStatus", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.s2
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12645a.c0(propertyChangeEvent);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e0() {
        /*
            Method dump skipped, instructions count: 517
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uz.navee.ui.device.DeviceBatteryInfoActivity.e0():void");
    }

    public final void f0() {
        Intent intent = new Intent(this, (Class<?>) QuestionListActivity.class);
        intent.putExtra("position", -1);
        CommonExt.p(intent, this.f11949e, this.f11950f, null);
        startActivity(intent);
    }

    public final void g0(DeviceHomePageInfo deviceHomePageInfo) {
        deviceHomePageInfo.removeListener("batteryVoltage", this.f11968x);
        deviceHomePageInfo.removeListener("batteryCurrent", this.f11969y);
        deviceHomePageInfo.removeListener("batteryStatus", this.f11970z);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_device_battery_info);
        W();
        com.uz.navee.utils.c.e(this, getString(R$string.battery_info), ContextCompat.getColor(this, R$color.nav_title_color));
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        if (bundleExtra != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.f11949e = (BleDevice) bundleExtra.getParcelable("bleDevice", BleDevice.class);
                this.f11950f = (Vehicle) bundleExtra.getSerializable("vehicle", Vehicle.class);
            } else {
                this.f11949e = (BleDevice) bundleExtra.getParcelable("bleDevice");
                this.f11950f = (Vehicle) bundleExtra.getSerializable("vehicle");
            }
        }
        X();
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f11967w, new IntentFilter("BleReadBatterySuccessNotification"));
        d0(b4.a.W().f1931d);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f11967w);
        g0(b4.a.W().f1931d);
        super.onDestroy();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        b4.a.W().f1934g.setCurrentState(0);
        b4.a.W().f1934g.setTemperatureState(0);
        b4.a.F(this.f11949e);
    }
}
