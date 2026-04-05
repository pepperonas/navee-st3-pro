package com.uz.navee.ui.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
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
import com.uz.navee.ble.AreaCode;
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

/* loaded from: classes3.dex */
public class DeviceInfoActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public QMUIGroupListView f12107c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f12108d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f12109e;

    /* renamed from: f, reason: collision with root package name */
    public ImageButton f12110f;

    /* renamed from: g, reason: collision with root package name */
    public BleDevice f12111g;

    /* renamed from: h, reason: collision with root package name */
    public Vehicle f12112h;

    /* renamed from: i, reason: collision with root package name */
    public QMUICommonListItemView f12113i;

    /* renamed from: j, reason: collision with root package name */
    public String f12114j;

    /* renamed from: k, reason: collision with root package name */
    public String f12115k;

    /* renamed from: l, reason: collision with root package name */
    public String f12116l;

    /* renamed from: m, reason: collision with root package name */
    public String f12117m;

    /* renamed from: r, reason: collision with root package name */
    public long f12122r;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f12118n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f12119o = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f12120p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f12121q = new ArrayList();

    /* renamed from: s, reason: collision with root package name */
    public final BroadcastReceiver f12123s = new b();

    /* renamed from: t, reason: collision with root package name */
    public final BroadcastReceiver f12124t = new d();

    /* renamed from: u, reason: collision with root package name */
    public final BroadcastReceiver f12125u = new e();

    /* renamed from: v, reason: collision with root package name */
    public final BroadcastReceiver f12126v = new f();

    public class a implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12127a;

        /* renamed from: com.uz.navee.ui.device.DeviceInfoActivity$a$a, reason: collision with other inner class name */
        public class C0166a extends TypeToken<HttpResponse<EmptyResponseData>> {
            public C0166a() {
            }
        }

        public a(String str) {
            this.f12127a = str;
        }

        @Override // d4.d.h
        public void a(String str) throws IOException {
            DeviceInfoActivity.this.B();
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new C0166a().getType());
            if (httpResponse != null) {
                if (httpResponse.getCode() != 200) {
                    new QMUITipDialog.a(DeviceInfoActivity.this).f(3).g(httpResponse.getMsg()).a().show();
                    return;
                }
                b4.a.c0(DeviceInfoActivity.this.f12111g, b4.a.k(80, 1, false));
                b4.a.P(this.f12127a);
                b4.a.Q();
                DeviceInfoActivity.this.Z0();
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            DeviceInfoActivity.this.B();
            new QMUITipDialog.a(DeviceInfoActivity.this).f(3).g(exc.getLocalizedMessage()).a().show();
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
            if (bleDevice == null || DeviceInfoActivity.this.f12111g == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(DeviceInfoActivity.this.f12111g))) {
                return;
            }
            DeviceInfoActivity.this.f12114j = intent.getStringExtra("meterVersion");
            DeviceInfoActivity.this.f12115k = intent.getStringExtra("bldcVersion");
            DeviceInfoActivity.this.f12116l = intent.getStringExtra("bmsVersion");
            DeviceInfoActivity.this.f12117m = intent.getStringExtra("screenVersion");
            DeviceInfoActivity.this.M0();
        }
    }

    public class c implements d.h {

        public class a extends TypeToken<HttpResponse<DfuResponseData>> {
            public a() {
            }
        }

        public c() {
        }

        @Override // d4.d.h
        public void a(String str) {
            DeviceInfoActivity.this.B();
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse == null || httpResponse.getCode() != 200) {
                return;
            }
            DeviceInfoActivity.this.f12122r = System.currentTimeMillis();
            DeviceInfoActivity.this.f12118n = ((DfuResponseData) httpResponse.getData()).getMeterList();
            DeviceInfoActivity.this.f12119o = ((DfuResponseData) httpResponse.getData()).getBldcList();
            DeviceInfoActivity.this.f12120p = ((DfuResponseData) httpResponse.getData()).getBmsList();
            DeviceInfoActivity.this.f12121q = ((DfuResponseData) httpResponse.getData()).getScreenList();
            String str2 = DeviceInfoActivity.this.f12112h.model.pid;
            if ((str2.startsWith("2417") || str2.startsWith("2422")) && DeviceInfoActivity.this.f12114j.equals("2.0.0.5")) {
                DeviceInfoActivity.this.f12120p.clear();
            }
            if (str2.startsWith("2442") && DeviceInfoActivity.this.f12112h.areaCode() == AreaCode.US) {
                DeviceInfoActivity.this.f12120p.clear();
            }
            if (DeviceInfoActivity.this.f12118n.isEmpty() && DeviceInfoActivity.this.f12119o.isEmpty() && DeviceInfoActivity.this.f12120p.isEmpty() && DeviceInfoActivity.this.f12121q.isEmpty()) {
                DeviceInfoActivity deviceInfoActivity = DeviceInfoActivity.this;
                com.uz.navee.utils.d.t(deviceInfoActivity, deviceInfoActivity.f12113i);
            } else {
                DeviceInfoActivity deviceInfoActivity2 = DeviceInfoActivity.this;
                com.uz.navee.utils.d.u(deviceInfoActivity2, deviceInfoActivity2.f12113i);
            }
            if (com.uz.navee.utils.d.o()) {
                DeviceInfoActivity.this.f12113i.getTextView().setTextSize(15.0f);
            } else {
                DeviceInfoActivity.this.f12113i.getTextView().setTextSize(13.0f);
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            DeviceInfoActivity.this.B();
        }
    }

    public class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Vehicle vehicle = (Vehicle) intent.getSerializableExtra("vehicle");
            if (vehicle != null) {
                DeviceInfoActivity.this.f12112h = vehicle;
            }
        }
    }

    public class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws InterruptedException {
            if (com.uz.navee.e.c().b() instanceof DeviceInfoActivity) {
                BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
                if (bleDevice == null || DeviceInfoActivity.this.f12111g == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(DeviceInfoActivity.this.f12111g))) {
                    return;
                }
                DeviceInfoActivity.this.N0();
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
            if (bleDevice == null || DeviceInfoActivity.this.f12111g == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(DeviceInfoActivity.this.f12111g)) || intExtra != 0) {
                return;
            }
            DeviceInfoActivity.this.O0();
        }
    }

    private void C0() {
        int iA = DensityUtil.a(this, 16.0f);
        QMUICommonListItemView qMUICommonListItemViewC = this.f12107c.c(null, getString(R$string.product_manual), "", 1, 1);
        com.uz.navee.utils.d.t(this, qMUICommonListItemViewC);
        qMUICommonListItemViewC.e(iA, 3);
        QMUICommonListItemView qMUICommonListItemViewC2 = this.f12107c.c(null, getString(R$string.driving_guide), "", 1, 1);
        com.uz.navee.utils.d.t(this, qMUICommonListItemViewC2);
        String string = getString(R$string.user_agreement);
        String string2 = getString(R$string.privacy_policy);
        QMUICommonListItemView qMUICommonListItemViewC3 = this.f12107c.c(null, string + getString(R$string.agree_uapp_tips_and) + string2, "", 1, 1);
        com.uz.navee.utils.d.t(this, qMUICommonListItemViewC3);
        QMUICommonListItemView qMUICommonListItemViewC4 = this.f12107c.c(null, getString(R$string.device_information), "", 1, 1);
        com.uz.navee.utils.d.t(this, qMUICommonListItemViewC4);
        QMUICommonListItemView qMUICommonListItemViewC5 = this.f12107c.c(null, getString(R$string.check_dfu), "", 1, 1);
        this.f12113i = qMUICommonListItemViewC5;
        com.uz.navee.utils.d.t(this, qMUICommonListItemViewC5);
        QMUICommonListItemView qMUICommonListItemViewC6 = this.f12107c.c(null, getString(R$string.alarm_list), "", 1, 1);
        com.uz.navee.utils.d.t(this, qMUICommonListItemViewC6);
        QMUICommonListItemView qMUICommonListItemViewC7 = this.f12107c.c(null, getString(R$string.faq), "", 1, 1);
        com.uz.navee.utils.d.t(this, qMUICommonListItemViewC7);
        qMUICommonListItemViewC7.e(iA, 1);
        QMUIGroupListView.e(this).c(qMUICommonListItemViewC, new View.OnClickListener() { // from class: com.uz.navee.ui.device.y3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12710a.D0(view);
            }
        }).c(qMUICommonListItemViewC2, new View.OnClickListener() { // from class: com.uz.navee.ui.device.z3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12719a.E0(view);
            }
        }).c(qMUICommonListItemViewC3, new View.OnClickListener() { // from class: com.uz.navee.ui.device.a4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12465a.F0(view);
            }
        }).c(qMUICommonListItemViewC4, new View.OnClickListener() { // from class: com.uz.navee.ui.device.b4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12475a.G0(view);
            }
        }).c(this.f12113i, new View.OnClickListener() { // from class: com.uz.navee.ui.device.c4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12485a.H0(view);
            }
        }).c(qMUICommonListItemViewC6, new View.OnClickListener() { // from class: com.uz.navee.ui.device.d4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12494a.I0(view);
            }
        }).c(qMUICommonListItemViewC7, new View.OnClickListener() { // from class: com.uz.navee.ui.device.e4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12503a.J0(view);
            }
        }).g(iA, iA).e(this.f12107c);
        if (com.uz.navee.utils.d.o()) {
            qMUICommonListItemViewC.getTextView().setTextSize(15.0f);
            qMUICommonListItemViewC2.getTextView().setTextSize(15.0f);
            qMUICommonListItemViewC3.getTextView().setTextSize(15.0f);
            qMUICommonListItemViewC4.getTextView().setTextSize(15.0f);
            this.f12113i.getTextView().setTextSize(15.0f);
            qMUICommonListItemViewC6.getTextView().setTextSize(15.0f);
            qMUICommonListItemViewC7.getTextView().setTextSize(15.0f);
        } else {
            qMUICommonListItemViewC.getTextView().setTextSize(13.0f);
            qMUICommonListItemViewC2.getTextView().setTextSize(13.0f);
            qMUICommonListItemViewC3.getTextView().setTextSize(13.0f);
            qMUICommonListItemViewC4.getTextView().setTextSize(13.0f);
            this.f12113i.getTextView().setTextSize(13.0f);
            qMUICommonListItemViewC6.getTextView().setTextSize(13.0f);
            qMUICommonListItemViewC7.getTextView().setTextSize(13.0f);
        }
        if (this.f12112h.shareUserId == 0) {
            QMUICommonListItemView qMUICommonListItemViewC8 = this.f12107c.c(null, getString(R$string.unbind), "", 1, 1);
            com.uz.navee.utils.d.t(this, qMUICommonListItemViewC8);
            qMUICommonListItemViewC8.setRadius(iA);
            QMUIGroupListView.e(this).c(qMUICommonListItemViewC8, new View.OnClickListener() { // from class: com.uz.navee.ui.device.f4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f12515a.K0(view);
                }
            }).e(this.f12107c);
            if (com.uz.navee.utils.d.o()) {
                qMUICommonListItemViewC8.getTextView().setTextSize(15.0f);
            } else {
                qMUICommonListItemViewC8.getTextView().setTextSize(13.0f);
            }
        }
        if (com.uz.navee.utils.d.p(this)) {
            com.uz.navee.utils.d.b(this.f12107c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(View view) {
        V0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0(View view) {
        T0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() throws InterruptedException {
        try {
            Thread.sleep(1500L);
            Intent intent = new Intent("BleReconnectNotification");
            intent.putExtra("bleDevice", this.f12111g);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        } catch (InterruptedException e7) {
            throw new RuntimeException(e7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0() {
        if (b4.a.f(this.f12111g)) {
            b4.a.I(this.f12111g);
        }
    }

    private void w0() {
        this.f12107c = (QMUIGroupListView) findViewById(R$id.groupListView);
        this.f12108d = (TextView) findViewById(R$id.deviceNameLabel);
        this.f12109e = (TextView) findViewById(R$id.activeTimeLabel);
        this.f12110f = (ImageButton) findViewById(R$id.editButton);
    }

    public final String B0(String str) {
        return com.uz.navee.utils.l.b(com.uz.navee.utils.l.g(str, "yyyy-MM-dd HH:mm:ss", "UTC").getTime(), "yyyy-MM-dd");
    }

    public final /* synthetic */ void E0(View view) {
        S0();
    }

    public final /* synthetic */ void F0(View view) {
        X0();
    }

    public final /* synthetic */ void G0(View view) {
        W0();
    }

    public final /* synthetic */ void H0(View view) {
        R0();
    }

    public final /* synthetic */ void I0(View view) {
        Q0();
    }

    public final /* synthetic */ void J0(View view) {
        U0();
    }

    public final /* synthetic */ void K0(View view) {
        Y0();
    }

    public final void M0() {
        K();
        String str = e4.a.a() + "/vehicle/modelSoftware";
        d4.d dVarH = d4.d.h();
        HashMap map = new HashMap();
        map.put("vehicleModelId", String.valueOf(this.f12112h.model.id));
        map.put("meter", this.f12114j);
        map.put("bldc", this.f12115k);
        map.put("bms", this.f12116l);
        map.put("screen", this.f12117m);
        dVarH.g(str, map, new c());
    }

    public final void P0() {
        K();
        Vehicle vehicle = this.f12112h;
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

    public final void Q0() {
        CommonExt.r(this, GaojingListActivity.class, this.f12111g, this.f12112h, null);
    }

    public final void R0() {
        if (b4.a.f(this.f12111g)) {
            Intent intent = new Intent(this, (Class<?>) DeviceFirmwareUpdateActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("bleDevice", this.f12111g);
            bundle.putSerializable("vehicle", this.f12112h);
            bundle.putString("currentMeterVersion", this.f12114j);
            bundle.putString("currentBldcVersion", this.f12115k);
            bundle.putString("currentBmsVersion", this.f12116l);
            bundle.putString("currentScreenVersion", this.f12117m);
            bundle.putParcelableArrayList("meterVersionList", this.f12118n);
            bundle.putParcelableArrayList("bldcVersionList", this.f12119o);
            bundle.putParcelableArrayList("bmsVersionList", this.f12120p);
            bundle.putParcelableArrayList("screenVersionList", this.f12121q);
            bundle.putLong("serverVersionTime", this.f12122r);
            intent.putExtra("data", bundle);
            startActivity(intent);
        }
    }

    public final void S0() {
        VehicleModel vehicleModel = this.f12112h.model;
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
        new a.C0192a(this).f(false).g(Boolean.TRUE).e(Boolean.FALSE).a(new ExoPlayerPopup(this, str2, getString(R$string.driving_guide), ExoPlayerPopup.VideoType.drivingGuide)).G();
    }

    public final void T0() {
        Intent intent = new Intent(this, (Class<?>) DeviceNameEditActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("bleDevice", this.f12111g);
        bundle.putSerializable("vehicle", this.f12112h);
        intent.putExtra("data", bundle);
        startActivity(intent);
    }

    public final void U0() {
        CommonExt.r(this, QuestionListActivity.class, this.f12111g, this.f12112h, null);
    }

    public final void V0() {
        Intent intent = new Intent(this, (Class<?>) DeviceManualActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(ImagesContract.URL, String.valueOf(this.f12112h.model.book));
        intent.putExtra("data", bundle);
        startActivity(intent);
    }

    public final void W0() {
        Intent intent = new Intent(this, (Class<?>) DeviceInfoSubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("bleDevice", this.f12111g);
        bundle.putSerializable("vehicle", this.f12112h);
        intent.putExtra("data", bundle);
        startActivity(intent);
    }

    public final void X0() {
        Intent intent = new Intent(this, (Class<?>) UserAgreementPPActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("vehicleModelId", String.valueOf(this.f12112h.model.id));
        bundle.putParcelable("bleDevice", this.f12111g);
        bundle.putSerializable("vehicle", this.f12112h);
        intent.putExtra("data", bundle);
        startActivity(intent);
    }

    public final void Y0() {
        AlertPopup.P(this, getString(R$string.unbind), getString(R$string.unbind_vehicle_message), new AlertPopup.a() { // from class: com.uz.navee.ui.device.g4
            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public /* synthetic */ void a() {
                j4.c.a(this);
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public final void b() {
                this.f12527a.P0();
            }
        });
    }

    public final void Z0() {
        finish();
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("BleDeviceChangedNotification"));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i6, int i7, Intent intent) {
        super.onActivityResult(i6, i7, intent);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_device_info);
        w0();
        com.uz.navee.utils.c.e(this, getString(R$string.explore_vehicle), ContextCompat.getColor(this, R$color.nav_title_color));
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        if (bundleExtra != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.f12111g = (BleDevice) bundleExtra.getParcelable("bleDevice", BleDevice.class);
                this.f12112h = (Vehicle) bundleExtra.getSerializable("vehicle", Vehicle.class);
            } else {
                this.f12111g = (BleDevice) bundleExtra.getParcelable("bleDevice");
                this.f12112h = (Vehicle) bundleExtra.getSerializable("vehicle");
            }
        }
        this.f12110f.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.x3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12700a.L0(view);
            }
        });
        this.f12109e.setVisibility(8);
        Vehicle vehicle = this.f12112h;
        if (vehicle != null && vehicle.showActivateDate().booleanValue()) {
            Vehicle vehicle2 = this.f12112h;
            if (vehicle2.shareUserId != -1 && vehicle2.shareDate != null) {
                this.f12109e.setVisibility(0);
                this.f12109e.setText(getString(R$string.share_time) + ": " + B0(this.f12112h.shareDate));
            } else if (vehicle2.bindDate != null) {
                this.f12109e.setVisibility(0);
                this.f12109e.setText(getString(R$string.bind_time) + ": " + B0(this.f12112h.bindDate));
            }
        }
        C0();
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f12124t, new IntentFilter("BleVehicleUpdateNotification"));
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f12125u, new IntentFilter("BleDisconnectNotification"));
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f12126v, new IntentFilter("BleAuthCallbackNotification"));
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f12124t);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f12125u);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f12126v);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f12123s);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i6, strArr, iArr);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f12123s, new IntentFilter("BleReadFirmwareSuccessNotification"));
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        O0();
        this.f12108d.setText(this.f12112h.displayName());
        com.uz.navee.utils.d.v(this.f12108d, new int[]{-3760771, -330520, -3760771}, new float[]{0.0f, 0.5f, 1.0f});
    }
}
