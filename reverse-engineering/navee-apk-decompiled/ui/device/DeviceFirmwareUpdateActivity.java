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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.clj.fastble.data.BleDevice;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.bean.DfuVerInfo;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.bean.VehicleModel;
import com.uz.navee.ble.AreaCode;
import com.uz.navee.ble.SKUVersion;
import com.uz.navee.dfu.DFUProcessor;
import com.uz.navee.network.utils.DownloadUtils;
import com.uz.navee.utils.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class DeviceFirmwareUpdateActivity extends BaseActivity {
    public com.uz.navee.utils.x B;
    public com.uz.navee.utils.x C;
    public long H;
    public int I;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f12048c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f12049d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f12050e;

    /* renamed from: f, reason: collision with root package name */
    public RecyclerView f12051f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f12052g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f12053h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f12054i;

    /* renamed from: j, reason: collision with root package name */
    public Button f12055j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f12056k;

    /* renamed from: l, reason: collision with root package name */
    public BleDevice f12057l;

    /* renamed from: m, reason: collision with root package name */
    public Vehicle f12058m;

    /* renamed from: r, reason: collision with root package name */
    public String f12063r;

    /* renamed from: s, reason: collision with root package name */
    public String f12064s;

    /* renamed from: t, reason: collision with root package name */
    public String f12065t;

    /* renamed from: u, reason: collision with root package name */
    public String f12066u;

    /* renamed from: v, reason: collision with root package name */
    public long f12067v;

    /* renamed from: w, reason: collision with root package name */
    public String f12068w;

    /* renamed from: x, reason: collision with root package name */
    public String f12069x;

    /* renamed from: y, reason: collision with root package name */
    public long f12070y;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f12059n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f12060o = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f12061p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f12062q = new ArrayList();

    /* renamed from: z, reason: collision with root package name */
    public final AtomicInteger f12071z = new AtomicInteger(0);
    public UpdateStatus A = UpdateStatus.noUpdate;
    public final String D = "meter_app_dfu.bin";
    public final String E = "bldc_app_dfu.bin";
    public final String F = "bms_app_dfu.bin";
    public final String G = "screen_app_dfu.bin";
    public final BroadcastReceiver J = new e();

    public static class UpdateContentAdapter extends BaseQuickAdapter<Pair<String, String>, BaseViewHolder> {
        public UpdateContentAdapter(List list) {
            super(R$layout.item_update_content, list);
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: U, reason: merged with bridge method [inline-methods] */
        public void i(BaseViewHolder baseViewHolder, Pair pair) {
            baseViewHolder.setText(R$id.tv_title, (CharSequence) pair.getFirst());
            baseViewHolder.setText(R$id.tv_content, (CharSequence) pair.getSecond());
        }
    }

    public enum UpdateStatus {
        noUpdate,
        needUpdate,
        updating,
        updateSuccess,
        updateFailure
    }

    public class a implements c4.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12072a;

        public a(String str) {
            this.f12072a = str;
        }

        @Override // c4.b
        public void a(c4.a aVar, int i6) {
            if (this.f12072a.isEmpty()) {
                DeviceFirmwareUpdateActivity.this.f12056k.setText(DeviceFirmwareUpdateActivity.this.getResources().getString(R$string.downloading) + "..." + DeviceFirmwareUpdateActivity.this.getResources().getString(R$string.progress) + " " + i6 + "%");
                return;
            }
            DeviceFirmwareUpdateActivity.this.f12056k.setText(DeviceFirmwareUpdateActivity.this.getResources().getString(R$string.downloading) + " " + this.f12072a + "..." + DeviceFirmwareUpdateActivity.this.getResources().getString(R$string.progress) + " " + i6 + "%");
        }

        @Override // c4.b
        public void b(c4.a aVar, Boolean bool) {
            if (bool.booleanValue()) {
                if (DeviceFirmwareUpdateActivity.this.C != null) {
                    DeviceFirmwareUpdateActivity.this.C.e(aVar);
                }
            } else {
                DeviceFirmwareUpdateActivity.this.A = UpdateStatus.updateFailure;
                DeviceFirmwareUpdateActivity.this.I0(false);
                DeviceFirmwareUpdateActivity.this.G0();
            }
        }
    }

    public class b implements c4.e {
        public b() {
        }

        @Override // c4.e
        public void a(DFUProcessor dFUProcessor, int i6) {
            if (dFUProcessor.A()) {
                return;
            }
            DeviceFirmwareUpdateActivity.this.I += i6;
            DeviceFirmwareUpdateActivity.this.runOnUiThread(new Runnable() { // from class: com.uz.navee.ui.device.v3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12680a.f();
                }
            });
        }

        @Override // c4.e
        public void b(DFUProcessor dFUProcessor, Boolean bool) throws IOException {
            if (!bool.booleanValue()) {
                DeviceFirmwareUpdateActivity.this.A = UpdateStatus.updateFailure;
                DeviceFirmwareUpdateActivity.this.runOnUiThread(new Runnable() { // from class: com.uz.navee.ui.device.u3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f12667a.e();
                    }
                });
                DeviceFirmwareUpdateActivity.this.J0(0);
                return;
            }
            DeviceFirmwareUpdateActivity.this.f12071z.incrementAndGet();
            dFUProcessor.b();
            if (DeviceFirmwareUpdateActivity.this.B != null) {
                DeviceFirmwareUpdateActivity.this.B.e(dFUProcessor);
            }
        }

        public final /* synthetic */ void e() {
            DeviceFirmwareUpdateActivity.this.I0(false);
            DeviceFirmwareUpdateActivity.this.G0();
        }

        public final /* synthetic */ void f() {
            DeviceFirmwareUpdateActivity.this.k0();
        }
    }

    public class c implements x.a {
        public c() {
        }

        @Override // com.uz.navee.utils.x.a
        public void a() {
            DeviceFirmwareUpdateActivity.this.J0(0);
            DeviceFirmwareUpdateActivity.this.f12056k.setText(DeviceFirmwareUpdateActivity.this.getResources().getString(R$string.updating) + "..." + DeviceFirmwareUpdateActivity.this.getResources().getString(R$string.progress) + " 100%");
            DeviceFirmwareUpdateActivity.this.A = UpdateStatus.updateSuccess;
            DeviceFirmwareUpdateActivity.this.G0();
            DeviceFirmwareUpdateActivity.this.I0(true);
            DeviceFirmwareUpdateActivity.this.H0();
        }

        @Override // com.uz.navee.utils.x.a
        public void b(com.uz.navee.utils.h hVar) {
            hVar.a();
        }
    }

    public class d implements x.a {
        public d() {
        }

        @Override // com.uz.navee.utils.x.a
        public void a() {
            DeviceFirmwareUpdateActivity deviceFirmwareUpdateActivity = DeviceFirmwareUpdateActivity.this;
            deviceFirmwareUpdateActivity.f12056k.setText(deviceFirmwareUpdateActivity.getResources().getString(R$string.download_completed));
            DeviceFirmwareUpdateActivity.this.o0();
        }

        @Override // com.uz.navee.utils.x.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(c4.a aVar) {
            aVar.a();
        }
    }

    public class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws InterruptedException {
            if (com.uz.navee.e.c().b() instanceof DeviceFirmwareUpdateActivity) {
                BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
                if (bleDevice == null || DeviceFirmwareUpdateActivity.this.f12057l == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(DeviceFirmwareUpdateActivity.this.f12057l))) {
                    return;
                }
                DeviceFirmwareUpdateActivity.this.E0();
            }
        }
    }

    public static /* synthetic */ void B0(View view) {
    }

    private String D0() {
        String vn;
        String vn2;
        String vn3;
        String str;
        String vn4 = "";
        if (this.f12059n.isEmpty()) {
            vn = this.f12063r;
            if (vn == null) {
                vn = "";
            }
        } else {
            vn = ((DfuVerInfo) this.f12059n.get(0)).getVn();
        }
        if (this.f12060o.isEmpty()) {
            vn2 = this.f12064s;
            if (vn2 == null) {
                vn2 = "";
            }
        } else {
            vn2 = ((DfuVerInfo) this.f12060o.get(0)).getVn();
        }
        if (this.f12061p.isEmpty()) {
            vn3 = this.f12065t;
            if (vn3 == null) {
                vn3 = "";
            }
        } else {
            vn3 = ((DfuVerInfo) this.f12061p.get(0)).getVn();
        }
        if (this.f12062q.isEmpty()) {
            String str2 = this.f12066u;
            if (str2 != null) {
                vn4 = str2;
            }
        } else {
            vn4 = ((DfuVerInfo) this.f12062q.get(0)).getVn();
        }
        if (L0()) {
            str = vn + RemoteSettings.FORWARD_SLASH_STRING + vn2 + RemoteSettings.FORWARD_SLASH_STRING + vn3;
        } else {
            str = vn + RemoteSettings.FORWARD_SLASH_STRING + vn2;
        }
        if (com.uz.navee.utils.j0.f(vn4, "\\.").length > 0) {
            str = str + RemoteSettings.FORWARD_SLASH_STRING + vn4;
        }
        this.f12069x = str;
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() throws InterruptedException {
        try {
            Thread.sleep(1500L);
            Intent intent = new Intent("BleReconnectNotification");
            intent.putExtra("bleDevice", this.f12057l);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        } catch (InterruptedException e7) {
            throw new RuntimeException(e7);
        }
    }

    private boolean L0() {
        VehicleModel vehicleModel;
        Vehicle vehicle = this.f12058m;
        return (vehicle == null || (vehicleModel = vehicle.model) == null || vehicleModel.pid == null || ((vehicle.skuVersion() == SKUVersion.USA || this.f12058m.model.pid.endsWith("1")) && !this.f12058m.model.pid.startsWith("2213") && !this.f12058m.model.pid.startsWith("2353") && !this.f12058m.model.pid.startsWith("2345") && !this.f12058m.model.pid.startsWith("2418") && !this.f12058m.model.pid.startsWith("2417") && !this.f12058m.model.pid.startsWith("2422") && !this.f12058m.model.pid.startsWith("2436") && !this.f12058m.model.pid.startsWith("2438") && !this.f12058m.model.pid.startsWith("2437") && !this.f12058m.model.pid.startsWith("2441") && !this.f12058m.model.pid.startsWith("2517") && ((!this.f12058m.model.pid.startsWith("2442") || this.f12058m.areaCode() == AreaCode.US) && !this.f12058m.model.pid.startsWith("2518") && !this.f12058m.model.pid.startsWith("2519") && !this.f12058m.model.pid.startsWith("2548") && !this.f12058m.model.pid.startsWith("2549") && !this.f12058m.model.pid.startsWith("2509") && !this.f12058m.model.pid.startsWith("2611") && !this.f12058m.model.pid.startsWith("2612") && !this.f12058m.model.pid.startsWith("2643") && !b4.d.d(this.f12058m.model.pid) && !b4.d.m(this.f12058m.model.pid) && !b4.d.l(this.f12058m.model.pid) && !b4.d.e(this.f12058m.model.pid) && !b4.d.c(this.f12058m.model.pid) && !b4.d.k(this.f12058m.model.pid))) || b4.d.i(this.f12058m.model.pid)) ? false : true;
    }

    private void j0() {
        this.f12048c = (ImageView) findViewById(R$id.imageView);
        this.f12049d = (TextView) findViewById(R$id.textLabel);
        this.f12050e = (TextView) findViewById(R$id.subTextLabel);
        this.f12055j = (Button) findViewById(R$id.updateButton);
        this.f12056k = (TextView) findViewById(R$id.progressLabel);
        this.f12053h = (TextView) findViewById(R$id.failTextLabel);
        this.f12054i = (TextView) findViewById(R$id.failSubTextLabel);
        this.f12052g = (TextView) findViewById(R$id.tvUpdate);
        this.f12051f = (RecyclerView) findViewById(R$id.rvContent);
    }

    private String n0() {
        String str;
        String str2 = this.f12063r;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.f12064s;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = this.f12065t;
        if (str4 == null) {
            str4 = "";
        }
        String str5 = this.f12066u;
        String str6 = str5 != null ? str5 : "";
        if (L0()) {
            str = str2 + RemoteSettings.FORWARD_SLASH_STRING + str3 + RemoteSettings.FORWARD_SLASH_STRING + str4;
        } else {
            str = str2 + RemoteSettings.FORWARD_SLASH_STRING + str3;
        }
        if (com.uz.navee.utils.j0.f(str6, "\\.").length > 0) {
            str = str + RemoteSettings.FORWARD_SLASH_STRING + str6;
        }
        this.f12068w = str;
        return str;
    }

    public final /* synthetic */ void A0(View view) {
        M0();
    }

    public final /* synthetic */ void C0(View view) {
        F0();
    }

    public final void F0() {
        M0();
    }

    public final void G0() {
        int iOrdinal = this.A.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                this.f12048c.setImageResource(R$mipmap.img_dfu_can);
                this.f12049d.setText(getResources().getString(R$string.latest_version) + ": " + D0());
                this.f12049d.setTextColor(ContextCompat.getColor(this, R$color.white));
                this.f12050e.setText(getResources().getString(R$string.current_version) + ": " + n0());
                this.f12056k.setVisibility(4);
                K0(R$string.upgrade_now, R$color.xF2E1D6, true);
                this.f12055j.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.q3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f12624a.A0(view);
                    }
                });
                this.f12050e.setVisibility(0);
                this.f12053h.setVisibility(8);
                this.f12054i.setVisibility(8);
                this.f12052g.setVisibility(0);
                this.f12051f.setVisibility(0);
                return;
            }
            if (iOrdinal == 2) {
                this.f12048c.setImageResource(R$mipmap.img_dfu_updating);
                this.f12049d.setText(getResources().getString(R$string.latest_version) + ": " + D0());
                this.f12049d.setTextColor(ContextCompat.getColor(this, R$color.white));
                this.f12050e.setText(getResources().getString(R$string.current_version) + ": " + n0());
                this.f12056k.setVisibility(0);
                this.f12056k.setText(getResources().getString(R$string.downloading));
                K0(R$string.upgrading, R$color.xF2E1D6_40, false);
                this.f12055j.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.r3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DeviceFirmwareUpdateActivity.B0(view);
                    }
                });
                this.f12050e.setVisibility(0);
                this.f12053h.setVisibility(8);
                this.f12054i.setVisibility(8);
                this.f12052g.setVisibility(0);
                this.f12051f.setVisibility(0);
                return;
            }
            if (iOrdinal != 3) {
                if (iOrdinal != 4) {
                    return;
                }
                this.f12048c.setImageResource(R$mipmap.img_dfu_error);
                this.f12049d.setText(R$string.update_failed);
                this.f12049d.setTextColor(ContextCompat.getColor(this, R$color.xEC6969));
                this.f12056k.setVisibility(4);
                K0(R$string.re_upgrade, R$color.xF2E1D6, true);
                this.f12055j.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.s3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f12646a.C0(view);
                    }
                });
                this.f12050e.setVisibility(8);
                this.f12053h.setVisibility(0);
                this.f12054i.setVisibility(0);
                this.f12052g.setVisibility(8);
                this.f12051f.setVisibility(8);
                return;
            }
        }
        this.f12048c.setImageResource(R$mipmap.img_dfu_success);
        this.f12049d.setText(R$string.update_completed);
        this.f12049d.setTextColor(ContextCompat.getColor(this, R$color.x42DC8E));
        this.f12050e.setText(getResources().getString(R$string.update_completed_des) + ": " + D0());
        this.f12056k.setVisibility(4);
        K0(R$string.confirm, R$color.xF2E1D6, true);
        this.f12055j.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.p3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12614a.z0(view);
            }
        });
        this.f12050e.setVisibility(0);
        this.f12053h.setVisibility(8);
        this.f12054i.setVisibility(8);
        this.f12052g.setVisibility(8);
        this.f12051f.setVisibility(8);
    }

    public final void H0() {
        DownloadUtils.f().d(r0());
    }

    public final void I0(boolean z6) {
    }

    public final void J0(int i6) {
        if (p0.a.n().C(this.f12057l, i6)) {
            f4.b.b("Ble requestConnectionPriority high success");
        }
    }

    public final void K0(int i6, int i7, boolean z6) {
        this.f12055j.setEnabled(z6);
        this.f12055j.setText(getResources().getString(i6));
        this.f12055j.setTextColor(ContextCompat.getColor(this, i7));
    }

    public final void M0() {
        if (!b4.a.f(this.f12057l)) {
            Toast.makeText(this, R$string.ble_disconnect_alert, 1).show();
            return;
        }
        float realTimeSpeed = b4.a.W().f1932e.getRealTimeSpeed();
        if (b4.a.W().f1932e.getVersion() == 1) {
            realTimeSpeed = (float) (realTimeSpeed / 10.0d);
        }
        if (b4.a.W().f1932e.getDrivingStatus() != 0 || realTimeSpeed > 3.0f) {
            Toast.makeText(this, R$string.driving_alert, 1).show();
            return;
        }
        if (b4.a.W().f1931d.getBatteryCharge() < 20) {
            Toast.makeText(this, R$string.low_battery_alert, 1).show();
            return;
        }
        Toast.makeText(this, R$string.updating_toast, 0).show();
        this.A = UpdateStatus.updating;
        this.f12070y = System.currentTimeMillis();
        this.f12071z.set(0);
        G0();
        t0();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        l0();
    }

    public final void k0() {
        TextView textView = this.f12056k;
        textView.setText(getResources().getString(R$string.updating) + "..." + getResources().getString(R$string.progress) + " " + ((int) ((this.I * 100.0d) / this.H)) + "%");
    }

    public final void l0() {
        com.uz.navee.utils.x xVar = this.B;
        if (xVar != null) {
            xVar.b();
            this.B = null;
        }
        com.uz.navee.utils.x xVar2 = this.C;
        if (xVar2 != null) {
            xVar2.b();
            this.C = null;
        }
        if (this.A == UpdateStatus.updating) {
            this.A = UpdateStatus.updateFailure;
            I0(false);
        }
    }

    public final void m0() {
        finish();
    }

    public final void o0() {
        this.B = new com.uz.navee.utils.x();
        w0();
        J0(1);
        this.H = 0L;
        this.I = 0;
        String str = getFilesDir().getAbsolutePath() + "/dfu";
        String str2 = str + RemoteSettings.FORWARD_SLASH_STRING + "meter_app_dfu.bin";
        String str3 = str + RemoteSettings.FORWARD_SLASH_STRING + "bldc_app_dfu.bin";
        String str4 = str + RemoteSettings.FORWARD_SLASH_STRING + "bms_app_dfu.bin";
        String str5 = str + RemoteSettings.FORWARD_SLASH_STRING + "screen_app_dfu.bin";
        long jQ0 = q0(str5);
        long jQ02 = q0(str4);
        long jQ03 = q0(str3);
        long jQ04 = q0(str2);
        DFUProcessor.DFUMcuType dFUMcuType = DFUProcessor.DFUMcuType.screen;
        p0(str5, dFUMcuType);
        if (jQ0 > 0 && (jQ02 > 0 || jQ03 > 0 || jQ04 > 0)) {
            s0(3500L, dFUMcuType);
        }
        DFUProcessor.DFUMcuType dFUMcuType2 = DFUProcessor.DFUMcuType.bms;
        p0(str4, dFUMcuType2);
        if (jQ02 > 0 && (jQ03 > 0 || jQ04 > 0)) {
            s0(3500L, dFUMcuType2);
        }
        DFUProcessor.DFUMcuType dFUMcuType3 = DFUProcessor.DFUMcuType.bldc;
        p0(str3, dFUMcuType3);
        if (jQ03 > 0 && jQ04 > 0) {
            s0(3500L, dFUMcuType3);
        }
        p0(str2, DFUProcessor.DFUMcuType.meter);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_device_firmware_update);
        j0();
        com.uz.navee.utils.c.e(this, getString(R$string.dfu_title), ContextCompat.getColor(this, R$color.nav_title_color));
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        if (bundleExtra != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.f12057l = (BleDevice) bundleExtra.getParcelable("bleDevice", BleDevice.class);
                this.f12058m = (Vehicle) bundleExtra.getSerializable("vehicle", Vehicle.class);
            } else {
                this.f12057l = (BleDevice) bundleExtra.getParcelable("bleDevice");
                this.f12058m = (Vehicle) bundleExtra.getSerializable("vehicle");
            }
            this.f12063r = bundleExtra.getString("currentMeterVersion");
            this.f12064s = bundleExtra.getString("currentBldcVersion");
            this.f12065t = bundleExtra.getString("currentBmsVersion");
            this.f12066u = bundleExtra.getString("currentScreenVersion");
            this.f12059n = bundleExtra.getParcelableArrayList("meterVersionList");
            this.f12060o = bundleExtra.getParcelableArrayList("bldcVersionList");
            this.f12061p = bundleExtra.getParcelableArrayList("bmsVersionList");
            this.f12062q = bundleExtra.getParcelableArrayList("screenVersionList");
            this.f12067v = bundleExtra.getLong("serverVersionTime");
        }
        LocalBroadcastManager.getInstance(this).registerReceiver(this.J, new IntentFilter("BleDisconnectNotification"));
        if (this.f12059n.isEmpty() && this.f12060o.isEmpty() && this.f12061p.isEmpty() && this.f12062q.isEmpty()) {
            this.A = UpdateStatus.noUpdate;
        } else {
            this.A = UpdateStatus.needUpdate;
        }
        G0();
        x0();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        l0();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.J);
        super.onDestroy();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        b4.a.W().Z();
    }

    public final void p0(String str, DFUProcessor.DFUMcuType dFUMcuType) {
        long jQ0 = q0(str);
        if (jQ0 > 0) {
            this.H += jQ0;
            DFUProcessor dFUProcessor = new DFUProcessor(this.f12057l, str, dFUMcuType);
            dFUProcessor.f13283a = dFUMcuType.name() + ".DFUProcessor";
            dFUProcessor.f11657x = new b();
            this.B.a(dFUProcessor);
        }
    }

    public final long q0(String str) {
        return com.uz.navee.utils.o.j(str);
    }

    public final String r0() {
        return getFilesDir().getAbsolutePath() + "/dfu";
    }

    public final void s0(long j6, DFUProcessor.DFUMcuType dFUMcuType) {
        c4.g gVar = new c4.g(j6);
        gVar.f13283a = dFUMcuType.name() + ".DFUWaiting";
        gVar.f2046c = new c4.f() { // from class: com.uz.navee.ui.device.t3
            @Override // c4.f
            public final void a(c4.g gVar2) {
                this.f12656a.y0(gVar2);
            }
        };
        this.B.a(gVar);
    }

    public final void t0() {
        H0();
        this.C = new com.uz.navee.utils.x();
        v0();
        String str = getFilesDir().getAbsolutePath() + "/dfu";
        if (!this.f12062q.isEmpty()) {
            u0(((DfuVerInfo) this.f12062q.get(0)).getFileUrl(), str, "screen_app_dfu.bin");
        }
        if (!this.f12061p.isEmpty()) {
            u0(((DfuVerInfo) this.f12061p.get(0)).getFileUrl(), str, "bms_app_dfu.bin");
        }
        if (!this.f12060o.isEmpty()) {
            u0(((DfuVerInfo) this.f12060o.get(0)).getFileUrl(), str, "bldc_app_dfu.bin");
        }
        if (this.f12059n.isEmpty()) {
            return;
        }
        u0(((DfuVerInfo) this.f12059n.get(0)).getFileUrl(), str, "meter_app_dfu.bin");
    }

    public final void u0(String str, String str2, String str3) {
        c4.a aVar = new c4.a(str, str2, str3);
        aVar.f13283a = "dfuDownloaderTask_" + str3;
        String[] strArrSplit = str3.split("_");
        aVar.f2041e = new a(strArrSplit.length > 0 ? strArrSplit[0] : "");
        this.C.a(aVar);
    }

    public final void v0() {
        this.C.setOnTaskListener(new d());
    }

    public final void w0() {
        this.B.setOnTaskListener(new c());
    }

    public final void x0() {
        ArrayList arrayList = new ArrayList();
        if (!this.f12059n.isEmpty()) {
            String context = ((DfuVerInfo) this.f12059n.get(0)).getContext();
            if (!TextUtils.isEmpty(context)) {
                arrayList.add(new Pair(getString(R$string.meter), context));
            }
        }
        if (!this.f12060o.isEmpty()) {
            String context2 = ((DfuVerInfo) this.f12060o.get(0)).getContext();
            if (!TextUtils.isEmpty(context2)) {
                arrayList.add(new Pair(getString(R$string.bldc), context2));
            }
        }
        if (!this.f12061p.isEmpty()) {
            String context3 = ((DfuVerInfo) this.f12061p.get(0)).getContext();
            if (!TextUtils.isEmpty(context3)) {
                arrayList.add(new Pair(getString(R$string.bms), context3));
            }
        }
        if (!this.f12062q.isEmpty()) {
            String context4 = ((DfuVerInfo) this.f12062q.get(0)).getContext();
            if (!TextUtils.isEmpty(context4)) {
                arrayList.add(new Pair(getString(R$string.screen), context4));
            }
        }
        this.f12051f.setAdapter(new UpdateContentAdapter(arrayList));
        this.f12051f.setOverScrollMode(2);
        if (arrayList.isEmpty()) {
            this.f12052g.setText("");
        }
    }

    public final /* synthetic */ void y0(c4.g gVar) {
        this.B.e(gVar);
    }

    public final /* synthetic */ void z0(View view) {
        m0();
    }
}
