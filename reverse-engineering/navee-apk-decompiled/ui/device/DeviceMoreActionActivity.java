package com.uz.navee.ui.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.clj.fastble.data.BleDevice;
import com.qmuiteam.qmui.R$id;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseBindingActivity;
import com.uz.navee.bean.PickTime;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.bean.VehicleModel;
import com.uz.navee.databinding.ActivityDedviceMoreActionBinding;
import com.uz.navee.ui.device.TcsClosePopup;
import com.uz.navee.ui.wheel.AlertPopup;
import com.uz.navee.utils.CommonExt;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;

/* loaded from: classes3.dex */
public final class DeviceMoreActionActivity extends BaseBindingActivity<ActivityDedviceMoreActionBinding> {
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public String F;

    /* renamed from: g, reason: collision with root package name */
    public SwitchCompat f12228g;

    /* renamed from: h, reason: collision with root package name */
    public SwitchCompat f12229h;

    /* renamed from: i, reason: collision with root package name */
    public SwitchCompat f12230i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f12231j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f12232k;

    /* renamed from: l, reason: collision with root package name */
    public TextView f12233l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f12234m;

    /* renamed from: n, reason: collision with root package name */
    public final kotlin.f f12235n = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$drivingMode$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<String> invoke() {
            DeviceMoreActionActivity deviceMoreActionActivity = this.this$0;
            LiveData liveDataK = CommonExt.k(deviceMoreActionActivity, Integer.valueOf(deviceMoreActionActivity.R().getDrivingMode()), "drivingMode");
            final DeviceMoreActionActivity deviceMoreActionActivity2 = this.this$0;
            return Transformations.map(liveDataK, new q5.l() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$drivingMode$2.1
                {
                    super(1);
                }

                @Override // q5.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final String invoke(int i6) {
                    return deviceMoreActionActivity2.getString(i6 == 5 ? R$string.turbo_mode : R$string.eco_mode);
                }
            });
        }
    });

    /* renamed from: o, reason: collision with root package name */
    public final kotlin.f f12236o = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$driveMode$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Integer> invoke() {
            DeviceMoreActionActivity deviceMoreActionActivity = this.this$0;
            return CommonExt.k(deviceMoreActionActivity, Integer.valueOf(deviceMoreActionActivity.R().getDriveMode()), "driveMode");
        }
    });

    /* renamed from: p, reason: collision with root package name */
    public final kotlin.f f12237p = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$lowPower$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Integer> invoke() {
            DeviceMoreActionActivity deviceMoreActionActivity = this.this$0;
            return CommonExt.k(deviceMoreActionActivity, Integer.valueOf(deviceMoreActionActivity.R().getLowPower()), "lowPower");
        }
    });

    /* renamed from: q, reason: collision with root package name */
    public final kotlin.f f12238q = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$tcsState$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Integer> invoke() {
            DeviceMoreActionActivity deviceMoreActionActivity = this.this$0;
            return CommonExt.k(deviceMoreActionActivity, Integer.valueOf(deviceMoreActionActivity.R().getTcsSwitch()), "tcsSwitch");
        }
    });

    /* renamed from: r, reason: collision with root package name */
    public final kotlin.f f12239r = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$longRange$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Boolean> invoke() {
            DeviceMoreActionActivity deviceMoreActionActivity = this.this$0;
            return Transformations.map(CommonExt.k(deviceMoreActionActivity, Integer.valueOf(deviceMoreActionActivity.R().getLongRange()), "longRange"), new q5.l() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$longRange$2.1
                public final Boolean invoke(int i6) {
                    return Boolean.valueOf(i6 == 1);
                }

                @Override // q5.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }
            });
        }
    });

    /* renamed from: s, reason: collision with root package name */
    public final kotlin.f f12240s = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$maxSpeed$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<String> invoke() {
            if (this.this$0.R().getMaxSpeed() == 0) {
                this.this$0.R().setMaxSpeed(MaxSpeedActivity.f12368n.a(this.this$0.U()));
            }
            DeviceMoreActionActivity deviceMoreActionActivity = this.this$0;
            LiveData liveDataK = CommonExt.k(deviceMoreActionActivity, Integer.valueOf(deviceMoreActionActivity.R().getMaxSpeed()), "maxSpeed");
            final DeviceMoreActionActivity deviceMoreActionActivity2 = this.this$0;
            return Transformations.map(liveDataK, new q5.l() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$maxSpeed$2.1
                {
                    super(1);
                }

                @Override // q5.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final String invoke(int i6) {
                    if (deviceMoreActionActivity2.R().getMileageUnit() != 0) {
                        return i6 + deviceMoreActionActivity2.getString(R$string.unit_speed_metric);
                    }
                    return s5.c.a(i6 * 0.621d) + deviceMoreActionActivity2.getString(R$string.unit_speed_imperial);
                }
            });
        }
    });

    /* renamed from: t, reason: collision with root package name */
    public final kotlin.f f12241t = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$startSpeed$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<String> invoke() {
            DeviceMoreActionActivity deviceMoreActionActivity = this.this$0;
            LiveData liveDataK = CommonExt.k(deviceMoreActionActivity, Integer.valueOf(deviceMoreActionActivity.R().getStartSpeed()), "startSpeed");
            final DeviceMoreActionActivity deviceMoreActionActivity2 = this.this$0;
            return Transformations.map(liveDataK, new q5.l() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$startSpeed$2.1
                {
                    super(1);
                }

                @Override // q5.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final String invoke(int i6) {
                    if (deviceMoreActionActivity2.R().getMileageUnit() != 0) {
                        return i6 + deviceMoreActionActivity2.getString(R$string.unit_speed_metric);
                    }
                    return StartupSpeedActivity.f12447j.a(i6) + deviceMoreActionActivity2.getString(R$string.unit_speed_imperial);
                }
            });
        }
    });

    /* renamed from: u, reason: collision with root package name */
    public final kotlin.f f12242u = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$chargeTime$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<String> invoke() {
            DeviceMoreActionActivity deviceMoreActionActivity = this.this$0;
            LiveData liveDataK = CommonExt.k(deviceMoreActionActivity, Long.valueOf(deviceMoreActionActivity.R().getStartChargeTime()), "startChargeTime");
            DeviceMoreActionActivity deviceMoreActionActivity2 = this.this$0;
            LiveData liveDataU = CommonExt.u(liveDataK, CommonExt.k(deviceMoreActionActivity2, Integer.valueOf(deviceMoreActionActivity2.R().getTimedChargeOn()), "timedChargeOn"));
            final DeviceMoreActionActivity deviceMoreActionActivity3 = this.this$0;
            return Transformations.map(liveDataU, new q5.l() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$chargeTime$2.1
                {
                    super(1);
                }

                @Override // q5.l
                public final String invoke(Pair<Long, Integer> it) {
                    kotlin.jvm.internal.y.f(it, "it");
                    boolean z6 = it.getSecond().intValue() == 1;
                    long jLongValue = it.getFirst().longValue();
                    if (!z6 || jLongValue == 0) {
                        return deviceMoreActionActivity3.getString(R$string.not_enabled);
                    }
                    Calendar calendar = Calendar.getInstance();
                    int i6 = calendar.get(6);
                    calendar.setTimeInMillis(1000 * jLongValue);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
                    int i7 = calendar.get(6) - i6;
                    String str = simpleDateFormat.format(calendar.getTime());
                    kotlin.jvm.internal.y.e(str, "format(...)");
                    return new PickTime(jLongValue, str, i7).getTimeDes(deviceMoreActionActivity3);
                }
            });
        }
    });

    /* renamed from: v, reason: collision with root package name */
    public final kotlin.f f12243v = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$chargeLimit$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<String> invoke() {
            DeviceMoreActionActivity deviceMoreActionActivity = this.this$0;
            return Transformations.map(CommonExt.k(deviceMoreActionActivity, Integer.valueOf(deviceMoreActionActivity.R().getChargeLimit()), "chargeLimit"), new q5.l() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$chargeLimit$2.1
                @Override // q5.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final String invoke(int i6) {
                    if (i6 == 0) {
                        return "80%";
                    }
                    return i6 + "%";
                }
            });
        }
    });

    /* renamed from: w, reason: collision with root package name */
    public final kotlin.f f12244w = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$audio$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<String> invoke() {
            DeviceMoreActionActivity deviceMoreActionActivity = this.this$0;
            LiveData liveDataK = CommonExt.k(deviceMoreActionActivity, Integer.valueOf(deviceMoreActionActivity.R().getVolume()), "volume");
            final DeviceMoreActionActivity deviceMoreActionActivity2 = this.this$0;
            return Transformations.map(liveDataK, new q5.l() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$audio$2.1
                {
                    super(1);
                }

                @Override // q5.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final String invoke(int i6) {
                    return deviceMoreActionActivity2.getString(R$string.sound_effects) + (i6 + 1);
                }
            });
        }
    });

    /* renamed from: x, reason: collision with root package name */
    public final kotlin.f f12245x = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$slopSup$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<String> invoke() {
            DeviceMoreActionActivity deviceMoreActionActivity = this.this$0;
            LiveData liveDataK = CommonExt.k(deviceMoreActionActivity, Integer.valueOf(deviceMoreActionActivity.R().getSlopeSup()), "slopeSup");
            final DeviceMoreActionActivity deviceMoreActionActivity2 = this.this$0;
            return Transformations.map(liveDataK, new q5.l() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$slopSup$2.1
                {
                    super(1);
                }

                @Override // q5.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final String invoke(int i6) {
                    return deviceMoreActionActivity2.getString(i6 > 0 ? R$string.open : R$string.not_enabled);
                }
            });
        }
    });

    /* renamed from: y, reason: collision with root package name */
    public final kotlin.f f12246y = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$lineLightOn$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<String> invoke() {
            DeviceMoreActionActivity deviceMoreActionActivity = this.this$0;
            LiveData liveDataK = CommonExt.k(deviceMoreActionActivity, Integer.valueOf(deviceMoreActionActivity.R().getAmbientLight()), "ambientLight");
            final DeviceMoreActionActivity deviceMoreActionActivity2 = this.this$0;
            return Transformations.map(liveDataK, new q5.l() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$lineLightOn$2.1
                {
                    super(1);
                }

                @Override // q5.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final String invoke(int i6) {
                    return deviceMoreActionActivity2.getString(com.uz.navee.utils.f.h(i6, 7) == 1 ? R$string.open : R$string.not_enabled);
                }
            });
        }
    });

    /* renamed from: z, reason: collision with root package name */
    public final kotlin.f f12247z = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$starLightOn$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<String> invoke() {
            DeviceMoreActionActivity deviceMoreActionActivity = this.this$0;
            LiveData liveDataK = CommonExt.k(deviceMoreActionActivity, Integer.valueOf(deviceMoreActionActivity.R().getLightD()), "lightD");
            final DeviceMoreActionActivity deviceMoreActionActivity2 = this.this$0;
            return Transformations.map(liveDataK, new q5.l() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$starLightOn$2.1
                {
                    super(1);
                }

                @Override // q5.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final String invoke(int i6) {
                    return deviceMoreActionActivity2.getString(com.uz.navee.utils.f.h(i6, 7) == 1 ? R$string.open : R$string.not_enabled);
                }
            });
        }
    });
    public final kotlin.f A = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$showDetail$2
        {
            super(0);
        }

        @Override // q5.a
        public final Boolean invoke() {
            return Boolean.valueOf(b4.d.l(this.this$0.T()) || b4.d.k(this.this$0.T()));
        }
    });
    public final BroadcastReceiver G = new BroadcastReceiver() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$disconnectReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            kotlin.jvm.internal.y.f(context, "context");
            kotlin.jvm.internal.y.f(intent, "intent");
            if (com.uz.navee.e.c().b() instanceof DeviceMoreActionActivity) {
                BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
                if (bleDevice == null || this.f12254a.S() == null || !kotlin.jvm.internal.y.a(b4.a.r(bleDevice), b4.a.r(this.f12254a.S()))) {
                    return;
                }
                this.f12254a.g1();
            }
        }
    };
    public final BroadcastReceiver H = new BroadcastReceiver() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$firmwareReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            kotlin.jvm.internal.y.f(context, "context");
            kotlin.jvm.internal.y.f(intent, "intent");
            BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
            if (bleDevice == null || this.f12255a.S() == null || !kotlin.jvm.internal.y.a(b4.a.r(bleDevice), b4.a.r(this.f12255a.S()))) {
                return;
            }
            String stringExtra = intent.getStringExtra("meterVersion");
            this.f12255a.F = stringExtra;
            Vehicle vehicleU = this.f12255a.U();
            kotlin.jvm.internal.y.c(vehicleU);
            String str = vehicleU.model.pid;
            if ((b4.d.g(str) || b4.d.b(str)) && stringExtra != null && stringExtra.compareTo("2.0.0.4") <= 0) {
                this.f12255a.B = true;
                TextView textView = this.f12255a.f12231j;
                if (textView != null) {
                    textView.setTextColor(1728053247);
                }
            }
            if ((b4.d.g(str) || b4.d.b(str)) && stringExtra != null && stringExtra.compareTo("2.0.1.2") < 0) {
                this.f12255a.C = true;
                TextView textView2 = this.f12255a.f12232k;
                if (textView2 != null) {
                    textView2.setTextColor(1728053247);
                }
                this.f12255a.D = true;
                TextView textView3 = this.f12255a.f12233l;
                if (textView3 != null) {
                    textView3.setTextColor(1728053247);
                }
            }
            if (str != null && kotlin.text.s.D(str, "2509", false, 2, null) && stringExtra != null && stringExtra.compareTo("2.0.3.5") < 0) {
                this.f12255a.E = true;
                TextView textView4 = this.f12255a.f12234m;
                if (textView4 != null) {
                    textView4.setTextColor(1728053247);
                }
            }
            if (str == null || !kotlin.text.s.D(str, "2314", false, 2, null) || stringExtra == null) {
                return;
            }
            if (kotlin.text.s.o(str, "1", false, 2, null) && stringExtra.compareTo("0.0.0.8") < 0) {
                this.f12255a.D = true;
                TextView textView5 = this.f12255a.f12233l;
                if (textView5 != null) {
                    textView5.setTextColor(1728053247);
                }
            }
            if (!kotlin.text.s.o(str, "2", false, 2, null) || stringExtra.compareTo("2.0.0.9") >= 0) {
                return;
            }
            this.f12255a.D = true;
            TextView textView6 = this.f12255a.f12233l;
            if (textView6 != null) {
                textView6.setTextColor(1728053247);
            }
        }
    };

    public static final class a implements Observer, kotlin.jvm.internal.u {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q5.l f12248a;

        public a(q5.l function) {
            kotlin.jvm.internal.y.f(function, "function");
            this.f12248a = function;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.u)) {
                return kotlin.jvm.internal.y.a(getFunctionDelegate(), ((kotlin.jvm.internal.u) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.u
        public final kotlin.c getFunctionDelegate() {
            return this.f12248a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f12248a.invoke(obj);
        }
    }

    public static final class b implements AlertPopup.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ byte f12250b;

        public b(byte b7) {
            this.f12250b = b7;
        }

        @Override // com.uz.navee.ui.wheel.AlertPopup.a
        public void a() throws Resources.NotFoundException {
            SwitchCompat switchCompat = DeviceMoreActionActivity.this.f12228g;
            if (switchCompat == null) {
                kotlin.jvm.internal.y.x("dualDriveSwitch");
                switchCompat = null;
            }
            switchCompat.setChecked(true);
        }

        @Override // com.uz.navee.ui.wheel.AlertPopup.a
        public void b() throws IOException {
            BaseBindingActivity.Z(DeviceMoreActionActivity.this, 110, new byte[]{this.f12250b, 0}, false, 4, null);
        }
    }

    public static final class c implements AlertPopup.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ byte f12252b;

        public c(byte b7) {
            this.f12252b = b7;
        }

        @Override // com.uz.navee.ui.wheel.AlertPopup.a
        public void a() throws Resources.NotFoundException {
            SwitchCompat switchCompat = DeviceMoreActionActivity.this.f12229h;
            if (switchCompat == null) {
                kotlin.jvm.internal.y.x("lowPowerSwitch");
                switchCompat = null;
            }
            switchCompat.setChecked(true);
        }

        @Override // com.uz.navee.ui.wheel.AlertPopup.a
        public void b() throws IOException {
            BaseBindingActivity.Z(DeviceMoreActionActivity.this, 111, new byte[]{this.f12252b, 0}, false, 4, null);
            b4.a.W().f1933f.setLowPower(0);
        }
    }

    public static final class d implements TcsClosePopup.a {
        public d() {
        }

        @Override // com.uz.navee.ui.device.TcsClosePopup.a
        public void a() throws Resources.NotFoundException {
            SwitchCompat switchCompat = DeviceMoreActionActivity.this.f12230i;
            if (switchCompat == null) {
                kotlin.jvm.internal.y.x("tcsSwitch");
                switchCompat = null;
            }
            switchCompat.setChecked(b4.a.W().f1933f.getTcsSwitch() == 1);
        }

        @Override // com.uz.navee.ui.device.TcsClosePopup.a
        public void b() throws IOException {
            if (b4.a.W().f1933f.getTcsSwitch() == 1) {
                BaseBindingActivity.Y(DeviceMoreActionActivity.this, 95, 0, false, 4, null);
            }
        }
    }

    public static final void I0(q5.l lVar, View view) {
        lVar.invoke(view);
    }

    public static final void K0(DeviceMoreActionActivity this$0, CompoundButton compoundButton, boolean z6) throws IOException {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        this$0.n1(z6);
    }

    public static final void M0(DeviceMoreActionActivity this$0, CompoundButton compoundButton, boolean z6) throws IOException {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        this$0.o1(z6);
    }

    private final LiveData O0() {
        return (LiveData) this.f12243v.getValue();
    }

    public static final void e1(DeviceMoreActionActivity this$0, CompoundButton compoundButton, boolean z6) throws IOException {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        this$0.l1(z6);
    }

    public static final void f1(DeviceMoreActionActivity this$0, CompoundButton compoundButton, boolean z6) throws IOException {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        this$0.m1(z6);
    }

    public static final void q1() {
    }

    public final void H0(List list) {
        int iB = CommonExt.b(this, 16);
        int iB2 = CommonExt.b(this, 16);
        if (!list.isEmpty()) {
            int size = list.size();
            QMUIGroupListView.a aVarE = QMUIGroupListView.e(this);
            int i6 = 0;
            while (true) {
                if (i6 >= size) {
                    break;
                }
                Pair pair = (Pair) list.get(i6);
                QMUICommonListItemView qMUICommonListItemView = (QMUICommonListItemView) pair.getFirst();
                final q5.l lVar = (q5.l) pair.getSecond();
                aVarE.c(qMUICommonListItemView, lVar != null ? new View.OnClickListener() { // from class: com.uz.navee.ui.device.w5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DeviceMoreActionActivity.I0(lVar, view);
                    }
                } : null);
                if (size == 1) {
                    qMUICommonListItemView.e(iB2, 0);
                    break;
                }
                if (i6 == 0) {
                    qMUICommonListItemView.e(iB2, 3);
                } else if (i6 == size - 1) {
                    qMUICommonListItemView.setRadius(iB2);
                    qMUICommonListItemView.e(iB2, 1);
                }
                i6++;
            }
            aVarE.g(iB, iB).e(((ActivityDedviceMoreActionBinding) Q()).glvAction);
        }
    }

    public final QMUICommonListItemView J0() {
        QMUIGroupListView glvAction = ((ActivityDedviceMoreActionBinding) Q()).glvAction;
        kotlin.jvm.internal.y.e(glvAction, "glvAction");
        Pair pairH = com.uz.navee.utils.l0.h(glvAction, R$string.low_power_mode, 0, 0, 0, 14, null);
        SwitchCompat switchCompat = (SwitchCompat) pairH.getSecond();
        this.f12229h = switchCompat;
        if (switchCompat == null) {
            kotlin.jvm.internal.y.x("lowPowerSwitch");
            switchCompat = null;
        }
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.x5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) throws IOException {
                DeviceMoreActionActivity.K0(this.f12702a, compoundButton, z6);
            }
        });
        U0().observe(this, new a(new q5.l() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$createLowPowerItem$2
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) throws Resources.NotFoundException {
                invoke((Integer) obj);
                return kotlin.u.f15726a;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void invoke(java.lang.Integer r3) throws android.content.res.Resources.NotFoundException {
                /*
                    r2 = this;
                    com.uz.navee.ui.device.DeviceMoreActionActivity r0 = r2.this$0
                    androidx.appcompat.widget.SwitchCompat r0 = com.uz.navee.ui.device.DeviceMoreActionActivity.n0(r0)
                    if (r0 != 0) goto Le
                    java.lang.String r0 = "lowPowerSwitch"
                    kotlin.jvm.internal.y.x(r0)
                    r0 = 0
                Le:
                    if (r3 != 0) goto L11
                    goto L19
                L11:
                    int r3 = r3.intValue()
                    r1 = 1
                    if (r3 != r1) goto L19
                    goto L1a
                L19:
                    r1 = 0
                L1a:
                    r0.setChecked(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uz.navee.ui.device.DeviceMoreActionActivity$createLowPowerItem$2.invoke(java.lang.Integer):void");
            }
        }));
        return (QMUICommonListItemView) pairH.getFirst();
    }

    public final QMUICommonListItemView L0() {
        QMUIGroupListView glvAction = ((ActivityDedviceMoreActionBinding) Q()).glvAction;
        kotlin.jvm.internal.y.e(glvAction, "glvAction");
        Pair pairH = com.uz.navee.utils.l0.h(glvAction, R$string.tcs, 0, 0, 0, 14, null);
        SwitchCompat switchCompat = (SwitchCompat) pairH.getSecond();
        this.f12230i = switchCompat;
        if (switchCompat == null) {
            kotlin.jvm.internal.y.x("tcsSwitch");
            switchCompat = null;
        }
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.y5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) throws IOException {
                DeviceMoreActionActivity.M0(this.f12712a, compoundButton, z6);
            }
        });
        a1().observe(this, new a(new q5.l() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$createTcsItem$2
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) throws Resources.NotFoundException {
                invoke((Integer) obj);
                return kotlin.u.f15726a;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void invoke(java.lang.Integer r3) throws android.content.res.Resources.NotFoundException {
                /*
                    r2 = this;
                    com.uz.navee.ui.device.DeviceMoreActionActivity r0 = r2.this$0
                    androidx.appcompat.widget.SwitchCompat r0 = com.uz.navee.ui.device.DeviceMoreActionActivity.r0(r0)
                    if (r0 != 0) goto Le
                    java.lang.String r0 = "tcsSwitch"
                    kotlin.jvm.internal.y.x(r0)
                    r0 = 0
                Le:
                    if (r3 != 0) goto L11
                    goto L19
                L11:
                    int r3 = r3.intValue()
                    r1 = 1
                    if (r3 != r1) goto L19
                    goto L1a
                L19:
                    r1 = 0
                L1a:
                    r0.setChecked(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uz.navee.ui.device.DeviceMoreActionActivity$createTcsItem$2.invoke(java.lang.Integer):void");
            }
        }));
        return (QMUICommonListItemView) pairH.getFirst();
    }

    public final LiveData N0() {
        return (LiveData) this.f12244w.getValue();
    }

    public final LiveData P0() {
        return (LiveData) this.f12242u.getValue();
    }

    public final LiveData Q0() {
        return (LiveData) this.f12236o.getValue();
    }

    public final LiveData R0() {
        return (LiveData) this.f12235n.getValue();
    }

    public final LiveData S0() {
        return (LiveData) this.f12246y.getValue();
    }

    public final LiveData T0() {
        return (LiveData) this.f12239r.getValue();
    }

    public final LiveData U0() {
        return (LiveData) this.f12237p.getValue();
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public int V() {
        return R$layout.activity_dedvice_more_action;
    }

    public final LiveData V0() {
        return (LiveData) this.f12240s.getValue();
    }

    public final boolean W0() {
        return ((Boolean) this.A.getValue()).booleanValue();
    }

    public final LiveData X0() {
        return (LiveData) this.f12245x.getValue();
    }

    public final LiveData Y0() {
        return (LiveData) this.f12247z.getValue();
    }

    public final LiveData Z0() {
        return (LiveData) this.f12241t.getValue();
    }

    public final LiveData a1() {
        return (LiveData) this.f12238q.getValue();
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public String b0() {
        String string = getString(R$string.more_features);
        kotlin.jvm.internal.y.e(string, "getString(...)");
        return string;
    }

    public final void b1(int i6) {
        AmbientLightV3Activity.f11740p.a(this, i6, S(), U());
    }

    public final void c1(int i6) {
        LightControlActivity.f12360i.a(this, i6, S(), U());
    }

    public final void d1(kotlin.reflect.c cVar) {
        CommonExt.r(this, p5.a.a(cVar), S(), U(), this.F);
    }

    public final void g1() {
        kotlinx.coroutines.i.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DeviceMoreActionActivity$postReconnect$1(this, null), 3, null);
    }

    public final void h1(int i6, int i7, int i8) {
        kotlinx.coroutines.i.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DeviceMoreActionActivity$promptDelay$1(this, i6, i7, i8, null), 3, null);
    }

    public final void i1() {
        if (b4.a.f(S())) {
            b4.a.G(S());
        }
    }

    public final void j1() {
        VehicleModel vehicleModel;
        Vehicle vehicleU = U();
        String str = (vehicleU == null || (vehicleModel = vehicleU.model) == null) ? null : vehicleModel.pid;
        if (str != null) {
            if ((b4.d.g(str) || b4.d.b(str) || kotlin.text.s.D(str, "2509", false, 2, null) || kotlin.text.s.D(str, "2314", false, 2, null) || kotlin.text.s.D(str, "2436", false, 2, null)) && b4.a.f(S())) {
                b4.a.I(S());
            }
        }
    }

    public final void k1(QMUICommonListItemView qMUICommonListItemView, LiveData liveData) {
        if (W0()) {
            final TextView textView = (TextView) qMUICommonListItemView.findViewById(R$id.group_list_item_detailTextView);
            kotlin.jvm.internal.y.c(textView);
            textView.setVisibility(0);
            liveData.observe(this, new a(new q5.l() { // from class: com.uz.navee.ui.device.DeviceMoreActionActivity$showDetail$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // q5.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return kotlin.u.f15726a;
                }

                public final void invoke(String str) {
                    textView.setText(str);
                }
            }));
        }
    }

    public final void l1(boolean z6) throws IOException {
        Integer num = (Integer) Q0().getValue();
        if (z6 == (num != null && num.intValue() == 1)) {
            return;
        }
        if (!z6) {
            AlertPopup.P(this, getString(R$string.dual_drive_mode_close_title), getString(R$string.dual_drive_mode_close_msg), new b((byte) 2));
            return;
        }
        BaseBindingActivity.Z(this, 110, new byte[]{2, 1}, false, 4, null);
        b4.a.W().f1933f.setDriveMode(1);
        if (b4.d.l(T())) {
            kotlinx.coroutines.i.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DeviceMoreActionActivity$switchDuaDrive$1(this, null), 3, null);
        } else {
            h1(R$string.dual_drive_mode_opend_title, R$string.dual_drive_mode_opend_msg, R$string.i_see);
        }
    }

    public final void m1(boolean z6) throws IOException {
        if (kotlin.jvm.internal.y.a(Boolean.valueOf(z6), T0().getValue())) {
            return;
        }
        BaseBindingActivity.Z(this, 111, new byte[]{7, z6 ? (byte) 1 : (byte) 0}, false, 4, null);
        if (z6) {
            h1(R$string.kind_tips, R$string.long_range_mode_des, R$string.i_see);
        }
    }

    public final void n1(boolean z6) throws IOException {
        Integer num = (Integer) U0().getValue();
        if (z6 == (num != null && num.intValue() == 1)) {
            return;
        }
        if (!z6) {
            AlertPopup.P(this, getString(R$string.low_power_mode_close_title), getString(R$string.low_power_mode_close_msg), new c((byte) 5));
            return;
        }
        BaseBindingActivity.Z(this, 111, new byte[]{5, 1}, false, 4, null);
        b4.a.W().f1933f.setLowPower(1);
        h1(R$string.low_power_mode_opend_title, R$string.low_power_mode_opend_msg, R$string.i_see);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o1(boolean r10) throws java.io.IOException {
        /*
            r9 = this;
            androidx.lifecycle.LiveData r0 = r9.a1()
            java.lang.Object r0 = r0.getValue()
            java.lang.Integer r0 = (java.lang.Integer) r0
            r1 = 0
            if (r0 != 0) goto Le
            goto L16
        Le:
            int r0 = r0.intValue()
            r2 = 1
            if (r0 != r2) goto L16
            goto L17
        L16:
            r2 = r1
        L17:
            if (r10 != r2) goto L1a
            return
        L1a:
            if (r10 == 0) goto L28
            r7 = 4
            r8 = 0
            r4 = 95
            r5 = 1
            r6 = 0
            r3 = r9
            com.uz.navee.base.BaseBindingActivity.Y(r3, r4, r5, r6, r7, r8)
            goto Lae
        L28:
            com.uz.navee.bean.Vehicle r10 = r9.U()
            r0 = 0
            if (r10 == 0) goto L36
            com.uz.navee.bean.VehicleModel r10 = r10.model
            if (r10 == 0) goto L36
            java.lang.String r10 = r10.pid
            goto L37
        L36:
            r10 = r0
        L37:
            boolean r2 = b4.d.h(r10)
            if (r2 == 0) goto L40
            int r10 = com.uz.navee.R$mipmap.img_tcs_meter_st5
            goto L7d
        L40:
            boolean r2 = b4.d.m(r10)
            if (r2 == 0) goto L49
            int r10 = com.uz.navee.R$mipmap.img_tcs_meter_ecross
            goto L7d
        L49:
            boolean r2 = b4.d.g(r10)
            if (r2 == 0) goto L52
            int r10 = com.uz.navee.R$mipmap.img_tcs_meter_st3
            goto L7d
        L52:
            boolean r2 = b4.d.k(r10)
            if (r2 == 0) goto L5b
            int r10 = com.uz.navee.R$mipmap.img_tcs_meter_st5
            goto L7d
        L5b:
            boolean r2 = b4.d.l(r10)
            if (r2 == 0) goto L64
            int r10 = com.uz.navee.R$mipmap.img_tcs_meter_ut5
            goto L7d
        L64:
            if (r10 == 0) goto L72
            java.lang.String r2 = "2623"
            r3 = 2
            boolean r10 = kotlin.text.k.D(r10, r2, r1, r3, r0)
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            goto L73
        L72:
            r10 = r0
        L73:
            boolean r10 = com.uz.navee.utils.CommonExt.j(r10)
            if (r10 == 0) goto L7b
            r10 = r1
            goto L7d
        L7b:
            int r10 = com.uz.navee.R$mipmap.img_tcs_meter_gt3
        L7d:
            if (r10 != 0) goto L80
            goto L84
        L80:
            android.graphics.drawable.Drawable r0 = androidx.core.content.ContextCompat.getDrawable(r9, r10)
        L84:
            e3.a$a r10 = new e3.a$a
            r10.<init>(r9)
            e3.a$a r10 = r10.f(r1)
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            e3.a$a r10 = r10.g(r1)
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            e3.a$a r10 = r10.d(r1)
            e3.a$a r10 = r10.e(r1)
            com.uz.navee.ui.device.TcsClosePopup r1 = new com.uz.navee.ui.device.TcsClosePopup
            com.uz.navee.ui.device.DeviceMoreActionActivity$d r2 = new com.uz.navee.ui.device.DeviceMoreActionActivity$d
            r2.<init>()
            r1.<init>(r9, r0, r2)
            com.lxj.xpopup.core.BasePopupView r10 = r10.a(r1)
            r10.G()
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uz.navee.ui.device.DeviceMoreActionActivity.o1(boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0503  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0549  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0569  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x05b2  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x05ca  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0659  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x069b  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0778  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0781  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0789  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x07f8  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0829  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0834  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x083d  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0844  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x087c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0239  */
    @Override // com.uz.navee.base.BaseBindingActivity, com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r32) {
        /*
            Method dump skipped, instructions count: 2216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uz.navee.ui.device.DeviceMoreActionActivity.onCreate(android.os.Bundle):void");
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.H);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.G);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        i1();
        j1();
    }

    public final void p1() {
        AlertPopup.Q(this, getString(R$string.kind_tips), getString(R$string.ble_lock_disable_msg), "", getString(R$string.i_see), new AlertPopup.a() { // from class: com.uz.navee.ui.device.v5
            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public /* synthetic */ void a() {
                j4.c.a(this);
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public final void b() {
                DeviceMoreActionActivity.q1();
            }
        });
    }
}
