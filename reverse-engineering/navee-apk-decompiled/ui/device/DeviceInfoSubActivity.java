package com.uz.navee.ui.device;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.clj.fastble.data.BleDevice;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.bean.DfuResponseData;
import com.uz.navee.bean.EmptyResponseData;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.bean.VehicleModel;
import com.uz.navee.ui.device.ExoPlayerPopup;
import com.uz.navee.ui.mine.GaojingListActivity;
import com.uz.navee.ui.mine.QuestionListActivity;
import com.uz.navee.ui.mine.UserAgreementPPActivity;
import com.uz.navee.ui.wheel.AlertPopup;
import com.uz.navee.utils.CommonExt;
import com.uz.navee.utils.DensityUtil;
import d4.d;
import e3.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class DeviceInfoSubActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public QMUIGroupListView f12136c;

    /* renamed from: d, reason: collision with root package name */
    public BleDevice f12137d;

    /* renamed from: e, reason: collision with root package name */
    public Vehicle f12138e;

    /* renamed from: f, reason: collision with root package name */
    public QMUICommonListItemView f12139f;

    /* renamed from: g, reason: collision with root package name */
    public QMUICommonListItemView f12140g;

    /* renamed from: h, reason: collision with root package name */
    public QMUICommonListItemView f12141h;

    /* renamed from: i, reason: collision with root package name */
    public QMUICommonListItemView f12142i;

    /* renamed from: j, reason: collision with root package name */
    public String f12143j;

    /* renamed from: k, reason: collision with root package name */
    public String f12144k;

    /* renamed from: l, reason: collision with root package name */
    public String f12145l;

    /* renamed from: m, reason: collision with root package name */
    public String f12146m;

    /* renamed from: r, reason: collision with root package name */
    public long f12151r;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f12147n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f12148o = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f12149p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f12150q = new ArrayList();

    /* renamed from: s, reason: collision with root package name */
    public final BroadcastReceiver f12152s = new b();

    /* renamed from: t, reason: collision with root package name */
    public final BroadcastReceiver f12153t = new c();

    /* renamed from: u, reason: collision with root package name */
    public final BroadcastReceiver f12154u = new e();

    /* renamed from: v, reason: collision with root package name */
    public final BroadcastReceiver f12155v = new f();

    public class a implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12156a;

        /* renamed from: com.uz.navee.ui.device.DeviceInfoSubActivity$a$a, reason: collision with other inner class name */
        public class C0167a extends TypeToken<HttpResponse<EmptyResponseData>> {
            public C0167a() {
            }
        }

        public a(String str) {
            this.f12156a = str;
        }

        @Override // d4.d.h
        public void a(String str) throws IOException {
            DeviceInfoSubActivity.this.B();
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new C0167a().getType());
            if (httpResponse != null) {
                if (httpResponse.getCode() != 200) {
                    new QMUITipDialog.a(DeviceInfoSubActivity.this).f(3).g(httpResponse.getMsg()).a().show();
                    return;
                }
                b4.a.c0(DeviceInfoSubActivity.this.f12137d, b4.a.k(80, 1, false));
                b4.a.P(this.f12156a);
                b4.a.Q();
                DeviceInfoSubActivity.this.m1();
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            DeviceInfoSubActivity.this.B();
            new QMUITipDialog.a(DeviceInfoSubActivity.this).f(3).g(exc.getLocalizedMessage()).a().show();
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
            if (bleDevice == null || DeviceInfoSubActivity.this.f12137d == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(DeviceInfoSubActivity.this.f12137d))) {
                return;
            }
            DeviceInfoSubActivity.this.f12139f.setDetailText(intent.getStringExtra("carSN"));
        }
    }

    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
            if (bleDevice == null || DeviceInfoSubActivity.this.f12137d == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(DeviceInfoSubActivity.this.f12137d))) {
                return;
            }
            DeviceInfoSubActivity.this.f12143j = intent.getStringExtra("meterVersion");
            DeviceInfoSubActivity.this.f12144k = intent.getStringExtra("bldcVersion");
            DeviceInfoSubActivity.this.f12145l = intent.getStringExtra("bmsVersion");
            DeviceInfoSubActivity.this.f12146m = intent.getStringExtra("screenVersion");
            if (b4.d.d(DeviceInfoSubActivity.this.f12138e.model.pid)) {
                DeviceInfoSubActivity.this.Y0();
            } else {
                DeviceInfoSubActivity.this.f12140g.setDetailText(DeviceInfoSubActivity.this.f12143j);
                DeviceInfoSubActivity.this.f12141h.setDetailText(DeviceInfoSubActivity.this.f12144k);
            }
        }
    }

    public class d implements d.h {

        public class a extends TypeToken<HttpResponse<DfuResponseData>> {
            public a() {
            }
        }

        public d() {
        }

        @Override // d4.d.h
        public void a(String str) {
            DeviceInfoSubActivity.this.B();
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse == null || httpResponse.getCode() != 200) {
                return;
            }
            DeviceInfoSubActivity.this.f12151r = System.currentTimeMillis();
            DeviceInfoSubActivity.this.f12147n = ((DfuResponseData) httpResponse.getData()).getMeterList();
            DeviceInfoSubActivity.this.f12148o = ((DfuResponseData) httpResponse.getData()).getBldcList();
            DeviceInfoSubActivity.this.f12149p = ((DfuResponseData) httpResponse.getData()).getBmsList();
            DeviceInfoSubActivity.this.f12150q = ((DfuResponseData) httpResponse.getData()).getScreenList();
            if (DeviceInfoSubActivity.this.f12147n.isEmpty() && DeviceInfoSubActivity.this.f12148o.isEmpty() && DeviceInfoSubActivity.this.f12149p.isEmpty() && DeviceInfoSubActivity.this.f12150q.isEmpty()) {
                DeviceInfoSubActivity deviceInfoSubActivity = DeviceInfoSubActivity.this;
                com.uz.navee.utils.d.t(deviceInfoSubActivity, deviceInfoSubActivity.f12142i);
            } else {
                DeviceInfoSubActivity deviceInfoSubActivity2 = DeviceInfoSubActivity.this;
                com.uz.navee.utils.d.u(deviceInfoSubActivity2, deviceInfoSubActivity2.f12142i);
            }
            if (com.uz.navee.utils.d.o()) {
                DeviceInfoSubActivity.this.f12142i.getTextView().setTextSize(15.0f);
            } else {
                DeviceInfoSubActivity.this.f12142i.getTextView().setTextSize(13.0f);
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            DeviceInfoSubActivity.this.B();
        }
    }

    public class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws InterruptedException {
            if (com.uz.navee.e.c().b() instanceof DeviceInfoActivity) {
                BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
                if (bleDevice == null || DeviceInfoSubActivity.this.f12137d == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(DeviceInfoSubActivity.this.f12137d))) {
                    return;
                }
                DeviceInfoSubActivity.this.Z0();
            }
        }
    }

    public class f extends BroadcastReceiver {
        public f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("errorCode", 0);
            BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
            if (bleDevice == null || DeviceInfoSubActivity.this.f12137d == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(DeviceInfoSubActivity.this.f12137d)) || intExtra != 0) {
                return;
            }
            DeviceInfoSubActivity.this.b1();
        }
    }

    private void E0() {
        this.f12136c = (QMUIGroupListView) findViewById(R$id.groupListView);
    }

    private void J0() {
        int iA = DensityUtil.a(this, 16.0f);
        QMUICommonListItemView qMUICommonListItemViewC = this.f12136c.c(null, getString(R$string.device_sn), "", 1, 0);
        this.f12139f = qMUICommonListItemViewC;
        qMUICommonListItemViewC.e(iA, 3);
        QMUICommonListItemView qMUICommonListItemViewC2 = this.f12136c.c(null, getString(R$string.battery_info), "", 1, 1);
        com.uz.navee.utils.d.t(this, qMUICommonListItemViewC2);
        if (b4.d.d(this.f12138e.model.pid)) {
            QMUICommonListItemView qMUICommonListItemViewC3 = this.f12136c.c(null, getString(R$string.driving_history), "", 1, 1);
            com.uz.navee.utils.d.t(this, qMUICommonListItemViewC3);
            QMUICommonListItemView qMUICommonListItemViewC4 = this.f12136c.c(null, getString(R$string.check_dfu), "", 1, 1);
            this.f12142i = qMUICommonListItemViewC4;
            com.uz.navee.utils.d.t(this, qMUICommonListItemViewC4);
            QMUICommonListItemView qMUICommonListItemViewC5 = this.f12136c.c(null, getString(R$string.alarm_list), "", 1, 1);
            com.uz.navee.utils.d.t(this, qMUICommonListItemViewC5);
            QMUICommonListItemView qMUICommonListItemViewC6 = this.f12136c.c(null, getString(R$string.faq), "", 1, 1);
            com.uz.navee.utils.d.t(this, qMUICommonListItemViewC6);
            qMUICommonListItemViewC6.e(iA, 1);
            QMUIGroupListView.e(this).c(this.f12139f, new View.OnClickListener() { // from class: com.uz.navee.ui.device.h4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DeviceInfoSubActivity.K0(view);
                }
            }).c(qMUICommonListItemViewC3, new View.OnClickListener() { // from class: com.uz.navee.ui.device.r4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f12634a.L0(view);
                }
            }).c(qMUICommonListItemViewC2, new View.OnClickListener() { // from class: com.uz.navee.ui.device.s4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f12647a.Q0(view);
                }
            }).c(this.f12142i, new View.OnClickListener() { // from class: com.uz.navee.ui.device.t4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f12657a.R0(view);
                }
            }).c(qMUICommonListItemViewC5, new View.OnClickListener() { // from class: com.uz.navee.ui.device.u4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f12668a.S0(view);
                }
            }).c(qMUICommonListItemViewC6, new View.OnClickListener() { // from class: com.uz.navee.ui.device.v4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f12681a.T0(view);
                }
            }).g(iA, iA).e(this.f12136c);
            QMUICommonListItemView qMUICommonListItemViewC7 = this.f12136c.c(null, getString(R$string.product_manual), "", 1, 1);
            com.uz.navee.utils.d.t(this, qMUICommonListItemViewC7);
            qMUICommonListItemViewC7.e(iA, 3);
            QMUICommonListItemView qMUICommonListItemViewC8 = this.f12136c.c(null, getString(R$string.driving_guide), "", 1, 1);
            com.uz.navee.utils.d.t(this, qMUICommonListItemViewC8);
            String string = getString(R$string.user_agreement);
            String string2 = getString(R$string.privacy_policy);
            QMUICommonListItemView qMUICommonListItemViewC9 = this.f12136c.c(null, string + getString(R$string.agree_uapp_tips_and) + string2, "", 1, 1);
            com.uz.navee.utils.d.t(this, qMUICommonListItemViewC9);
            qMUICommonListItemViewC9.e(iA, 1);
            QMUIGroupListView.e(this).c(qMUICommonListItemViewC7, new View.OnClickListener() { // from class: com.uz.navee.ui.device.i4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f12549a.U0(view);
                }
            }).c(qMUICommonListItemViewC8, new View.OnClickListener() { // from class: com.uz.navee.ui.device.j4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f12559a.V0(view);
                }
            }).c(qMUICommonListItemViewC9, new View.OnClickListener() { // from class: com.uz.navee.ui.device.k4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f12568a.W0(view);
                }
            }).g(iA, iA).e(this.f12136c);
            QMUICommonListItemView qMUICommonListItemViewC10 = this.f12136c.c(null, getString(R$string.unbind), "", 1, 1);
            com.uz.navee.utils.d.t(this, qMUICommonListItemViewC10);
            qMUICommonListItemViewC10.setRadius(iA);
            QMUIGroupListView.e(this).c(qMUICommonListItemViewC10, new View.OnClickListener() { // from class: com.uz.navee.ui.device.l4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f12577a.X0(view);
                }
            }).e(this.f12136c);
            if (com.uz.navee.utils.d.o()) {
                this.f12139f.getTextView().setTextSize(15.0f);
                this.f12139f.getDetailTextView().setTextSize(13.0f);
                qMUICommonListItemViewC3.getTextView().setTextSize(15.0f);
                qMUICommonListItemViewC2.getTextView().setTextSize(15.0f);
                this.f12142i.getTextView().setTextSize(15.0f);
                qMUICommonListItemViewC7.getTextView().setTextSize(15.0f);
                qMUICommonListItemViewC8.getTextView().setTextSize(15.0f);
                qMUICommonListItemViewC9.getTextView().setTextSize(15.0f);
                qMUICommonListItemViewC10.getTextView().setTextSize(15.0f);
            } else {
                this.f12139f.getTextView().setTextSize(13.0f);
                this.f12139f.getDetailTextView().setTextSize(11.0f);
                qMUICommonListItemViewC3.getTextView().setTextSize(13.0f);
                qMUICommonListItemViewC2.getTextView().setTextSize(13.0f);
                this.f12142i.getTextView().setTextSize(13.0f);
                qMUICommonListItemViewC7.getTextView().setTextSize(13.0f);
                qMUICommonListItemViewC8.getTextView().setTextSize(13.0f);
                qMUICommonListItemViewC9.getTextView().setTextSize(13.0f);
                qMUICommonListItemViewC10.getTextView().setTextSize(13.0f);
            }
        } else {
            this.f12140g = this.f12136c.c(null, getString(R$string.meter_version), "", 1, 0);
            QMUICommonListItemView qMUICommonListItemViewC11 = this.f12136c.c(null, getString(R$string.bldc_version), "", 1, 0);
            this.f12141h = qMUICommonListItemViewC11;
            qMUICommonListItemViewC11.e(iA, 1);
            QMUIGroupListView.e(this).c(this.f12139f, new View.OnClickListener() { // from class: com.uz.navee.ui.device.n4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DeviceInfoSubActivity.M0(view);
                }
            }).c(this.f12140g, new View.OnClickListener() { // from class: com.uz.navee.ui.device.o4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DeviceInfoSubActivity.N0(view);
                }
            }).c(this.f12141h, new View.OnClickListener() { // from class: com.uz.navee.ui.device.p4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DeviceInfoSubActivity.O0(view);
                }
            }).g(iA, iA).e(this.f12136c);
            if (com.uz.navee.utils.d.o()) {
                this.f12139f.getTextView().setTextSize(15.0f);
                this.f12139f.getDetailTextView().setTextSize(13.0f);
                this.f12140g.getTextView().setTextSize(15.0f);
                this.f12140g.getDetailTextView().setTextSize(13.0f);
                this.f12141h.getTextView().setTextSize(15.0f);
                this.f12141h.getDetailTextView().setTextSize(13.0f);
                qMUICommonListItemViewC2.getTextView().setTextSize(15.0f);
            } else {
                this.f12139f.getTextView().setTextSize(13.0f);
                this.f12139f.getDetailTextView().setTextSize(11.0f);
                this.f12140g.getTextView().setTextSize(13.0f);
                this.f12140g.getDetailTextView().setTextSize(11.0f);
                this.f12141h.getTextView().setTextSize(13.0f);
                this.f12141h.getDetailTextView().setTextSize(11.0f);
                qMUICommonListItemViewC2.getTextView().setTextSize(13.0f);
            }
            qMUICommonListItemViewC2.setRadius(iA);
            QMUIGroupListView.e(this).c(qMUICommonListItemViewC2, new View.OnClickListener() { // from class: com.uz.navee.ui.device.q4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f12625a.P0(view);
                }
            }).e(this.f12136c);
        }
        if (com.uz.navee.utils.d.p(this)) {
            com.uz.navee.utils.d.b(this.f12136c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0(View view) {
        i1();
    }

    public static /* synthetic */ void M0(View view) {
    }

    public static /* synthetic */ void N0(View view) {
    }

    public static /* synthetic */ void O0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(View view) {
        e1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(View view) {
        f1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(View view) {
        d1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(View view) {
        h1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0(View view) {
        j1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V0(View view) {
        g1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W0(View view) {
        k1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0() {
        K();
        String str = e4.a.a() + "/vehicle/modelSoftware";
        d4.d dVarH = d4.d.h();
        HashMap map = new HashMap();
        map.put("vehicleModelId", String.valueOf(this.f12138e.model.id));
        map.put("meter", this.f12143j);
        map.put("bldc", this.f12144k);
        map.put("bms", this.f12145l);
        map.put("screen", this.f12146m);
        dVarH.g(str, map, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0() throws InterruptedException {
        try {
            Thread.sleep(1500L);
            Intent intent = new Intent("BleReconnectNotification");
            intent.putExtra("bleDevice", this.f12137d);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        } catch (InterruptedException e7) {
            throw new RuntimeException(e7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1() {
        if (b4.a.f(this.f12137d)) {
            b4.a.I(this.f12137d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1() {
        K();
        Vehicle vehicle = this.f12138e;
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
        dVarH.g(str3, map, new a(str));
    }

    private void d1() {
        CommonExt.r(this, GaojingListActivity.class, this.f12137d, this.f12138e, null);
    }

    private void f1() {
        if (b4.a.f(this.f12137d)) {
            Intent intent = new Intent(this, (Class<?>) DeviceFirmwareUpdateActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("bleDevice", this.f12137d);
            bundle.putSerializable("vehicle", this.f12138e);
            bundle.putString("currentMeterVersion", this.f12143j);
            bundle.putString("currentBldcVersion", this.f12144k);
            bundle.putString("currentBmsVersion", this.f12145l);
            bundle.putString("currentScreenVersion", this.f12146m);
            bundle.putParcelableArrayList("meterVersionList", this.f12147n);
            bundle.putParcelableArrayList("bldcVersionList", this.f12148o);
            bundle.putParcelableArrayList("bmsVersionList", this.f12149p);
            bundle.putParcelableArrayList("screenVersionList", this.f12150q);
            bundle.putLong("serverVersionTime", this.f12151r);
            intent.putExtra("data", bundle);
            startActivity(intent);
        }
    }

    private void g1() {
        VehicleModel vehicleModel = this.f12138e.model;
        if (vehicleModel.guideType == 2) {
            String str = vehicleModel.imgTxt;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            new a.C0192a(this).f(false).g(Boolean.TRUE).h(true).k((int) (com.uz.navee.utils.d.g(this) * 0.82d)).e(Boolean.FALSE).a(new DriveGuidePopup(this, str)).G();
            return;
        }
        String str2 = vehicleModel.video;
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        new a.C0192a(this).f(false).g(Boolean.TRUE).e(Boolean.FALSE).a(new ExoPlayerPopup(this, str2, getString(R$string.usage_guidelines), ExoPlayerPopup.VideoType.golfGuide)).G();
    }

    private void h1() {
        CommonExt.r(this, QuestionListActivity.class, this.f12137d, this.f12138e, null);
    }

    private void j1() {
        Intent intent = new Intent(this, (Class<?>) DeviceManualActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(ImagesContract.URL, String.valueOf(this.f12138e.model.book));
        intent.putExtra("data", bundle);
        startActivity(intent);
    }

    private void k1() {
        Intent intent = new Intent(this, (Class<?>) UserAgreementPPActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("vehicleModelId", String.valueOf(this.f12138e.model.id));
        bundle.putParcelable("bleDevice", this.f12137d);
        bundle.putSerializable("vehicle", this.f12138e);
        intent.putExtra("data", bundle);
        startActivity(intent);
    }

    private void l1() {
        AlertPopup.P(this, com.uz.navee.utils.d.a(getString(R$string.unbind)), getString(R$string.confirm_unbinding), new AlertPopup.a() { // from class: com.uz.navee.ui.device.m4
            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public /* synthetic */ void a() {
                j4.c.a(this);
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public final void b() {
                this.f12588a.c1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1() {
        finish();
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("BleDeviceChangedNotification"));
    }

    public final /* synthetic */ void P0(View view) {
        e1();
    }

    public final /* synthetic */ void X0(View view) {
        l1();
    }

    public final void a1() {
        if (b4.a.f(this.f12137d)) {
            b4.a.H(this.f12137d);
        }
    }

    public final void e1() {
        Intent intent = new Intent(this, (Class<?>) DeviceBatteryInfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("bleDevice", this.f12137d);
        bundle.putSerializable("vehicle", this.f12138e);
        intent.putExtra("data", bundle);
        startActivity(intent);
    }

    public final void i1() {
        if (b4.a.f(this.f12137d)) {
            Intent intent = new Intent(this, (Class<?>) DriveHistoryActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("bleDevice", this.f12137d);
            bundle.putSerializable("vehicle", this.f12138e);
            intent.putExtra("data", bundle);
            startActivity(intent);
        }
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_device_info_sub);
        E0();
        com.uz.navee.utils.c.e(this, getString(R$string.device_information), ContextCompat.getColor(this, R$color.nav_title_color));
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        if (bundleExtra != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.f12137d = (BleDevice) bundleExtra.getParcelable("bleDevice", BleDevice.class);
                this.f12138e = (Vehicle) bundleExtra.getSerializable("vehicle", Vehicle.class);
            } else {
                this.f12137d = (BleDevice) bundleExtra.getParcelable("bleDevice");
                this.f12138e = (Vehicle) bundleExtra.getSerializable("vehicle");
            }
        }
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f12152s, new IntentFilter("BleReadCarSNSuccessNotification"));
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f12153t, new IntentFilter("BleReadFirmwareSuccessNotification"));
        if (b4.d.d(this.f12138e.model.pid)) {
            LocalBroadcastManager.getInstance(this).registerReceiver(this.f12154u, new IntentFilter("BleDisconnectNotification"));
            LocalBroadcastManager.getInstance(this).registerReceiver(this.f12155v, new IntentFilter("BleAuthCallbackNotification"));
        }
        J0();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f12152s);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f12153t);
        if (b4.d.d(this.f12138e.model.pid)) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f12154u);
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f12155v);
        }
        super.onDestroy();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        a1();
        b1();
    }
}
