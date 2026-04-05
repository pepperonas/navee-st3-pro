package com.uz.navee.ui.device;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.Renderer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.data.BleScanState;
import com.clj.fastble.exception.BleException;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.uz.navee.MainActivity;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.base.RecyclerAdapter;
import com.uz.navee.base.RecyclerViewHolder;
import com.uz.navee.bean.Agreement;
import com.uz.navee.bean.EmptyResponseData;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.bean.VehicleModel;
import com.uz.navee.ui.mine.UappPopup;
import com.uz.navee.ui.mine.UserAgreementPPActivity;
import d4.d;
import e3.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class DeviceBindActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public RecyclerView f11976c;

    /* renamed from: d, reason: collision with root package name */
    public LinearLayout f11977d;

    /* renamed from: e, reason: collision with root package name */
    public LinearLayout f11978e;

    /* renamed from: f, reason: collision with root package name */
    public Button f11979f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f11980g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f11981h;

    /* renamed from: i, reason: collision with root package name */
    public ImageView f11982i;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f11983j;

    /* renamed from: k, reason: collision with root package name */
    public ImageView f11984k;

    /* renamed from: l, reason: collision with root package name */
    public ImageButton f11985l;

    /* renamed from: m, reason: collision with root package name */
    public RecyclerAdapter f11986m;

    /* renamed from: o, reason: collision with root package name */
    public CountDownTimer f11988o;

    /* renamed from: q, reason: collision with root package name */
    public Vehicle f11990q;

    /* renamed from: r, reason: collision with root package name */
    public AnimatorSet f11991r;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f11987n = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    public final BroadcastReceiver f11989p = new g();

    public class a implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BleDevice f11992a;

        /* renamed from: com.uz.navee.ui.device.DeviceBindActivity$a$a, reason: collision with other inner class name */
        public class C0164a extends TypeToken<HttpResponse<Agreement>> {
            public C0164a() {
            }
        }

        public a(BleDevice bleDevice) {
            this.f11992a = bleDevice;
        }

        @Override // d4.d.h
        public void a(String str) {
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new C0164a().getType());
            if (httpResponse == null || httpResponse.getCode() != 200) {
                DeviceBindActivity.this.I0(this.f11992a, null);
            } else {
                DeviceBindActivity.this.I0(this.f11992a, (Agreement) httpResponse.getData());
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            DeviceBindActivity.this.I0(this.f11992a, null);
        }
    }

    public class b implements UappPopup.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11995a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f11996b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BleDevice f11997c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Integer f11998d;

        public b(String str, String str2, BleDevice bleDevice, Integer num) {
            this.f11995a = str;
            this.f11996b = str2;
            this.f11997c = bleDevice;
            this.f11998d = num;
        }

        @Override // com.uz.navee.ui.mine.UappPopup.d
        public void a() {
            g4.e1.a(this.f11995a, 0, 1);
        }

        @Override // com.uz.navee.ui.mine.UappPopup.d
        public void b() {
            Intent intent = new Intent(DeviceBindActivity.this, (Class<?>) UserAgreementPPActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("vehicleModelId", String.valueOf(this.f11998d));
            intent.putExtra("data", bundle);
            DeviceBindActivity.this.startActivity(intent);
        }

        @Override // com.uz.navee.ui.mine.UappPopup.d
        public void c() {
            String str = this.f11995a;
            if (str != null) {
                g4.e1.o(str, this.f11996b);
            }
            com.uz.navee.utils.z zVarB = com.uz.navee.utils.z.b();
            final BleDevice bleDevice = this.f11997c;
            zVarB.f13294b = new com.uz.navee.utils.b0() { // from class: com.uz.navee.ui.device.x2
                @Override // com.uz.navee.utils.b0
                public final void a(Location location) {
                    this.f12698a.e(bleDevice, location);
                }
            };
            com.uz.navee.utils.z.b().c(DeviceBindActivity.this);
        }

        public final /* synthetic */ void e(BleDevice bleDevice, Location location) {
            DeviceBindActivity.this.B0(bleDevice, location);
        }
    }

    public class c extends LinearLayoutManager {
        public c(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public RecyclerView.LayoutParams generateDefaultLayoutParams() {
            return new RecyclerView.LayoutParams(-1, -2);
        }
    }

    public class d extends RecyclerAdapter {

        public class a extends com.uz.navee.utils.c0 {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ BleDevice f12002b;

            public a(BleDevice bleDevice) {
                this.f12002b = bleDevice;
            }

            @Override // com.uz.navee.utils.c0
            public void a(View view) {
                DeviceBindActivity.this.D0(this.f12002b);
            }
        }

        public d(Context context, List list) {
            super(context, list);
        }

        @Override // com.uz.navee.base.RecyclerAdapter
        public int e(int i6) {
            return R$layout.list_view_item_scanned;
        }

        @Override // com.uz.navee.base.RecyclerAdapter
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void c(RecyclerViewHolder recyclerViewHolder, int i6, BleDevice bleDevice) {
            VehicleModel vehicleModelX = b4.a.x(b4.a.s(bleDevice));
            String strR = b4.a.r(bleDevice);
            recyclerViewHolder.d(R$id.nameLabel, vehicleModelX.displayName());
            recyclerViewHolder.d(R$id.tipsLabel, strR);
            com.bumptech.glide.b.w(DeviceBindActivity.this).t(Uri.parse(vehicleModelX.minImg)).z0(recyclerViewHolder.b(R$id.iconView));
            recyclerViewHolder.a(R$id.bindButton).setOnClickListener(new a(bleDevice));
        }
    }

    public class e implements d.h {

        public class a extends TypeToken<HttpResponse<ArrayList<VehicleModel>>> {
            public a() {
            }
        }

        public e() {
        }

        @Override // d4.d.h
        public void a(String str) throws InterruptedException {
            DeviceBindActivity.this.B();
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse != null && httpResponse.getCode() == 200) {
                b4.a.N((ArrayList) httpResponse.getData());
            }
            DeviceBindActivity.this.E0();
        }

        @Override // d4.d.h
        public void b(Exception exc) throws InterruptedException {
            DeviceBindActivity.this.B();
            DeviceBindActivity.this.E0();
        }
    }

    public class f extends q0.b {
        public f() {
        }

        @Override // q0.b
        public void c(BleDevice bleDevice, BleException bleException) {
            f4.b.c("Connect Fail (%s)", b4.a.r(bleDevice));
            DeviceBindActivity.this.B();
            DeviceBindActivity deviceBindActivity = DeviceBindActivity.this;
            deviceBindActivity.I(deviceBindActivity.getString(R$string.ble_peripheralFailedToConnectReasonUnknown));
        }

        @Override // q0.b
        public void d(BleDevice bleDevice, BluetoothGatt bluetoothGatt, int i6) throws InterruptedException {
            DeviceBindActivity.this.t0(bleDevice);
        }

        @Override // q0.b
        public void e(boolean z6, BleDevice bleDevice, BluetoothGatt bluetoothGatt, int i6) {
            DeviceBindActivity.this.B();
            f4.b.c("DisConnected %s isActiveDisConnected = %s", b4.a.r(bleDevice), Boolean.toString(z6));
        }

        @Override // q0.b
        public void f() {
            f4.b.b("Start Connect");
            DeviceBindActivity.this.K();
        }
    }

    public class g extends BroadcastReceiver {
        public g() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws IOException {
            int intExtra = intent.getIntExtra("errorCode", 0);
            final BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
            if (bleDevice != null) {
                if (intExtra == 0) {
                    if (DeviceBindActivity.this.f11990q != null && Objects.equals(DeviceBindActivity.this.f11990q.mac, b4.a.r(bleDevice))) {
                        final byte[] bArrL = b4.a.l(111, new byte[]{8, (byte) DeviceBindActivity.this.f11990q.latlngCountryValue}, false);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.uz.navee.ui.device.y2
                            @Override // java.lang.Runnable
                            public final void run() {
                                b4.a.c0(bleDevice, bArrL);
                            }
                        }, 1000L);
                    }
                    Intent intent2 = new Intent("BleBindSuccessNotification");
                    intent2.putExtra("bleDevice", bleDevice);
                    LocalBroadcastManager.getInstance(context).sendBroadcast(intent2);
                    DeviceBindActivity.this.v0();
                } else {
                    DeviceBindActivity.this.C0(bleDevice);
                }
            }
            DeviceBindActivity.this.B();
        }
    }

    public class h implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BleDevice f12008a;

        public class a extends TypeToken<HttpResponse<Vehicle>> {
            public a() {
            }
        }

        public h(BleDevice bleDevice) {
            this.f12008a = bleDevice;
        }

        @Override // d4.d.h
        public void a(String str) throws InterruptedException {
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            DeviceBindActivity.this.B();
            if (httpResponse == null || httpResponse.getCode() != 200) {
                if (httpResponse != null) {
                    DeviceBindActivity.this.I(httpResponse.getMsg());
                }
            } else {
                DeviceBindActivity.this.f11990q = (Vehicle) httpResponse.getData();
                DeviceBindActivity.this.u0(this.f12008a);
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            DeviceBindActivity.this.B();
            DeviceBindActivity.this.I(exc.getLocalizedMessage());
        }
    }

    public class i implements d.h {

        public class a extends TypeToken<HttpResponse<EmptyResponseData>> {
            public a() {
            }
        }

        public i() {
        }

        @Override // d4.d.h
        public void a(String str) {
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            DeviceBindActivity.this.B();
            if (httpResponse != null && httpResponse.getCode() == 200) {
                DeviceBindActivity deviceBindActivity = DeviceBindActivity.this;
                deviceBindActivity.J(deviceBindActivity.getString(R$string.bind_failure_msg));
            } else if (httpResponse != null) {
                DeviceBindActivity.this.I(httpResponse.getMsg());
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            DeviceBindActivity.this.B();
            DeviceBindActivity.this.I(exc.getLocalizedMessage());
        }
    }

    public class j extends CountDownTimer {
        public j(long j6, long j7) {
            super(j6, j7);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            DeviceBindActivity.this.f11980g.setText(R$string.device_scanning_text);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j6) {
            int i6 = (int) (j6 / 1000);
            if (i6 <= 0) {
                DeviceBindActivity.this.f11980g.setText(R$string.device_scanning_text);
                DeviceBindActivity.this.f11988o.cancel();
                return;
            }
            DeviceBindActivity.this.f11980g.setText(DeviceBindActivity.this.getString(R$string.device_scanning_text) + " (" + i6 + "s)");
        }
    }

    public class k extends q0.g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f12014a;

        public class a implements Comparator {
            public a() {
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(BleDevice bleDevice, BleDevice bleDevice2) {
                return Integer.compare(bleDevice2.getRssi(), bleDevice.getRssi());
            }
        }

        public k(ArrayList arrayList) {
            this.f12014a = arrayList;
        }

        @Override // q0.h
        public void a(boolean z6) {
            f4.b.g("Scan started", new Object[0]);
            DeviceBindActivity.this.f11988o.start();
            DeviceBindActivity.this.f11991r.start();
            DeviceBindActivity.this.f11985l.setClickable(false);
        }

        @Override // q0.h
        public void b(BleDevice bleDevice) {
            String name = bleDevice.getName();
            if (name == null) {
                name = "N/A";
            }
            if (!name.startsWith("NAVEE") || b4.a.y(b4.a.s(bleDevice), this.f12014a) == null) {
                return;
            }
            String strR = b4.a.r(bleDevice);
            if (strR.isEmpty() || b4.a.A(strR)) {
                return;
            }
            if (DeviceBindActivity.this.f11987n == null) {
                DeviceBindActivity.this.f11987n = new ArrayList();
            }
            DeviceBindActivity.this.f11987n.add(bleDevice);
            if (Build.VERSION.SDK_INT >= 24) {
                DeviceBindActivity.this.f11987n.sort(Comparator.comparing(new Function() { // from class: com.uz.navee.ui.device.b3
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return Integer.valueOf(((BleDevice) obj).getRssi());
                    }
                }).reversed());
            } else {
                Collections.sort(DeviceBindActivity.this.f11987n, new a());
            }
            DeviceBindActivity.this.f11986m.j(DeviceBindActivity.this.f11987n);
        }

        @Override // q0.g
        public void d(List list) {
            f4.b.g("onScanFinished, result count: " + list.size(), new Object[0]);
            DeviceBindActivity.this.f11988o.onFinish();
            DeviceBindActivity.this.f11991r.end();
            DeviceBindActivity.this.f11985l.setClickable(true);
            if (DeviceBindActivity.this.f11987n.isEmpty()) {
                DeviceBindActivity.this.J0();
            }
        }
    }

    private void i0() {
        this.f11976c = (RecyclerView) findViewById(R$id.recyclerView);
        this.f11977d = (LinearLayout) findViewById(R$id.scanningView);
        this.f11978e = (LinearLayout) findViewById(R$id.unScannedView);
        this.f11979f = (Button) findViewById(R$id.scanDeviceButton);
        this.f11980g = (TextView) findViewById(R$id.scanningTextLabel);
        this.f11981h = (ImageView) findViewById(R$id.ovalView1);
        this.f11982i = (ImageView) findViewById(R$id.ovalView2);
        this.f11983j = (ImageView) findViewById(R$id.ovalView3);
        this.f11984k = (ImageView) findViewById(R$id.ovalView4);
        this.f11985l = (ImageButton) findViewById(R$id.bluetoothButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(View view) throws InterruptedException {
        A0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(View view) throws InterruptedException {
        A0();
    }

    public final void A0() throws InterruptedException {
        this.f11978e.setVisibility(4);
        this.f11979f.setVisibility(4);
        this.f11977d.setVisibility(0);
        this.f11976c.setVisibility(0);
        F0();
    }

    public final void B0(BleDevice bleDevice, Location location) {
        K();
        String strR = b4.a.r(bleDevice);
        String strS = b4.a.s(bleDevice);
        if (strR == null) {
            return;
        }
        String str = e4.a.a() + "/vehicle/bind";
        d4.d dVarH = d4.d.h();
        HashMap map = new HashMap();
        map.put("mac", strR);
        map.put("pid", strS);
        if (location != null) {
            map.put("latitude", String.valueOf(location.getLatitude()));
            map.put("longitude", String.valueOf(location.getLongitude()));
        }
        dVarH.g(str, map, new h(bleDevice));
    }

    public final void C0(BleDevice bleDevice) {
        K();
        String strR = b4.a.r(bleDevice);
        if (strR == null) {
            return;
        }
        String str = e4.a.a() + "/vehicle/unbind";
        d4.d dVarH = d4.d.h();
        String strS = b4.a.s(bleDevice);
        HashMap map = new HashMap();
        map.put("mac", strR);
        map.put("pid", strS);
        dVarH.g(str, map, new i());
    }

    public final void D0(BleDevice bleDevice) {
        Integer num = b4.a.x(b4.a.s(bleDevice)).id;
        String str = e4.a.a() + "/vehicle/modelAgreement";
        HashMap map = new HashMap();
        map.put("vehicleModelId", String.valueOf(num));
        d4.d.h().g(str, map, new a(bleDevice));
    }

    public final void E0() throws InterruptedException {
        if (ContextCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_SCAN") != -1) {
            if (p0.a.n().w()) {
                F0();
                return;
            } else {
                startActivityIfNeeded(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 302);
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 31) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN"}, 302);
        } else if (D(302) == 0) {
            if (p0.a.n().w()) {
                F0();
            } else {
                startActivityIfNeeded(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 302);
            }
        }
    }

    public final void F0() throws InterruptedException {
        try {
            Thread.sleep(100L);
            if (s0.c.b().c() != BleScanState.STATE_IDLE) {
                p0.a.n().a();
            }
            if (!this.f11987n.isEmpty()) {
                this.f11987n.clear();
            }
            p0.a.n().D(new k(b4.a.b0()));
        } catch (InterruptedException e7) {
            throw new RuntimeException(e7);
        }
    }

    public final void G0() {
        AnimatorSet animatorSet = new AnimatorSet();
        this.f11991r = animatorSet;
        animatorSet.playTogether(H0(this.f11981h, "scaleX"), H0(this.f11981h, "scaleY"), H0(this.f11982i, "scaleX"), H0(this.f11982i, "scaleY"), H0(this.f11983j, "scaleX"), H0(this.f11983j, "scaleY"), H0(this.f11984k, "scaleX"), H0(this.f11984k, "scaleY"));
    }

    public final ObjectAnimator H0(Object obj, String str) {
        return com.uz.navee.utils.a.a(obj, str, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, -1, 0.95f, 1.0f, 1.08f, 1.0f, 0.95f);
    }

    public final void I0(BleDevice bleDevice, Agreement agreement) {
        String str;
        String id;
        String strS = b4.a.s(bleDevice);
        Integer num = b4.a.x(strS).id;
        if (agreement != null) {
            String desc = agreement.getDesc();
            id = agreement.getId();
            str = desc;
        } else {
            str = null;
            id = null;
        }
        new a.C0192a(this).f(false).g(Boolean.TRUE).e(Boolean.FALSE).a(new UappPopup(this, str, new b(id, strS, bleDevice, num))).G();
    }

    public final void J0() {
        this.f11978e.setVisibility(0);
        this.f11979f.setVisibility(0);
        this.f11977d.setVisibility(4);
        this.f11976c.setVisibility(4);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i6, int i7, Intent intent) throws InterruptedException {
        super.onActivityResult(i6, i7, intent);
        if (i6 != 302 || i7 == 0) {
            return;
        }
        F0();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws InterruptedException {
        super.onCreate(bundle);
        setContentView(R$layout.activity_device_bind);
        i0();
        com.uz.navee.utils.c.e(this, getString(R$string.bind_device), ContextCompat.getColor(this, R$color.nav_title_color));
        this.f11978e.setVisibility(4);
        this.f11979f.setVisibility(4);
        this.f11979f.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.v2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws InterruptedException {
                this.f12679a.x0(view);
            }
        });
        this.f11985l.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.w2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws InterruptedException {
                this.f12688a.y0(view);
            }
        });
        w0();
        G0();
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f11989p, new IntentFilter("BleAuthCallbackNotification"));
        if (b4.a.b0().isEmpty()) {
            z0();
        } else {
            E0();
        }
        this.f11976c.setLayoutManager(new c(this));
        d dVar = new d(this, null);
        this.f11986m = dVar;
        this.f11976c.setAdapter(dVar);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f11989p);
        try {
            p0.a.n().a();
        } catch (Throwable unused) {
        }
        this.f11991r.end();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) throws InterruptedException {
        super.onRequestPermissionsResult(i6, strArr, iArr);
        if (i6 == 302) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                J(getString(R$string.bluetoothUnavailable_unauthorized));
            } else {
                F0();
            }
        }
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        b4.a.W().Z();
    }

    public final void t0(BleDevice bleDevice) throws InterruptedException {
        try {
            Thread.sleep(100L);
            b4.a.U(bleDevice, this);
        } catch (InterruptedException e7) {
            throw new RuntimeException(e7);
        }
    }

    public final void u0(BleDevice bleDevice) throws InterruptedException {
        b4.a.n(this);
        try {
            Thread.sleep(100L);
            p0.a.n().b(bleDevice, new f());
        } catch (InterruptedException e7) {
            throw new RuntimeException(e7);
        }
    }

    public final void v0() {
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
    }

    public final void w0() {
        this.f11988o = new j(Renderer.DEFAULT_DURATION_TO_PROGRESS_US, 1000L);
    }

    public final void z0() {
        K();
        d4.d.h().f(e4.a.a() + "/vehicle/model", new e());
    }
}
