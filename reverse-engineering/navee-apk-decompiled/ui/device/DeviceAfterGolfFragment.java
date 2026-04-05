package com.uz.navee.ui.device;

import android.R;
import android.bluetooth.BluetoothGatt;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.location.LocationRequestCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.exoplayer.ExoPlayer;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.data.BleScanState;
import com.clj.fastble.exception.BleException;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lxj.xpopup.core.BasePopupView;
import com.qmuiteam.qmui.widget.QMUIEmptyView;
import com.uz.navee.MainActivity;
import com.uz.navee.MyApplication;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.bean.DeviceCarInfo;
import com.uz.navee.bean.DeviceHomePageInfo;
import com.uz.navee.bean.DeviceSubPageInfo;
import com.uz.navee.bean.DfuResponseData;
import com.uz.navee.bean.DfuVerInfo;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.bean.WarnConfig;
import com.uz.navee.ble.AreaCode;
import com.uz.navee.ui.device.FirmwareUpdatePopup;
import com.uz.navee.ui.device.MileageAlgorithmPopup;
import com.uz.navee.ui.device.SlideProgressView;
import com.uz.navee.ui.mine.GaojingDetailActivity;
import com.uz.navee.ui.web.WebActivity;
import com.uz.navee.ui.wheel.AlertPopup;
import com.uz.navee.utils.e0;
import d4.d;
import e3.a;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class DeviceAfterGolfFragment extends Fragment {
    public ImageButton A;
    public ImageButton B;
    public ImageButton C;
    public ImageButton D;
    public SlideProgressView E;
    public TextView F;
    public TextView G;
    public ArrayList H;
    public View I;
    public String L;

    /* renamed from: a, reason: collision with root package name */
    public BleDevice f11875a;

    /* renamed from: a0, reason: collision with root package name */
    public PropertyChangeListener f11876a0;

    /* renamed from: b, reason: collision with root package name */
    public Vehicle f11877b;

    /* renamed from: b0, reason: collision with root package name */
    public PropertyChangeListener f11878b0;

    /* renamed from: c, reason: collision with root package name */
    public LinearLayout f11879c;

    /* renamed from: c0, reason: collision with root package name */
    public PropertyChangeListener f11880c0;

    /* renamed from: d, reason: collision with root package name */
    public LinearLayout f11881d;

    /* renamed from: d0, reason: collision with root package name */
    public PropertyChangeListener f11882d0;

    /* renamed from: e, reason: collision with root package name */
    public TextView f11883e;

    /* renamed from: e0, reason: collision with root package name */
    public PropertyChangeListener f11884e0;

    /* renamed from: f, reason: collision with root package name */
    public ImageButton f11885f;

    /* renamed from: f0, reason: collision with root package name */
    public PropertyChangeListener f11886f0;

    /* renamed from: g, reason: collision with root package name */
    public QMUIEmptyView f11887g;

    /* renamed from: g0, reason: collision with root package name */
    public PropertyChangeListener f11888g0;

    /* renamed from: h, reason: collision with root package name */
    public NestedScrollView f11889h;

    /* renamed from: h0, reason: collision with root package name */
    public PropertyChangeListener f11890h0;

    /* renamed from: i, reason: collision with root package name */
    public ImageView f11891i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f11892j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f11893k;

    /* renamed from: l, reason: collision with root package name */
    public TextView f11894l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f11895m;

    /* renamed from: n, reason: collision with root package name */
    public TextView f11896n;

    /* renamed from: o, reason: collision with root package name */
    public ImageView f11897o;

    /* renamed from: p, reason: collision with root package name */
    public ImageView f11898p;

    /* renamed from: q, reason: collision with root package name */
    public ImageButton f11899q;

    /* renamed from: r, reason: collision with root package name */
    public TextView f11900r;

    /* renamed from: s, reason: collision with root package name */
    public ImageButton f11901s;

    /* renamed from: t, reason: collision with root package name */
    public TextView f11902t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f11903u;

    /* renamed from: v, reason: collision with root package name */
    public TextView f11904v;

    /* renamed from: w, reason: collision with root package name */
    public Button f11905w;

    /* renamed from: x, reason: collision with root package name */
    public TextView f11906x;

    /* renamed from: y, reason: collision with root package name */
    public View f11907y;

    /* renamed from: z, reason: collision with root package name */
    public ImageButton f11908z;
    public boolean J = false;
    public final int M = 32;
    public final int Q = 33;
    public final int R = 35;
    public final int S = 36;
    public final int T = 37;
    public final int[] U = {32, 33, 35, 36, 37};
    public final BroadcastReceiver V = new l();
    public final BroadcastReceiver W = new m();
    public final BroadcastReceiver X = new a();
    public final BroadcastReceiver Y = new b();
    public final BroadcastReceiver Z = new c();

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws NumberFormatException {
            int intExtra = intent.getIntExtra("errorCode", 0);
            BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
            String strR = b4.a.r(bleDevice);
            if (bleDevice == null || DeviceAfterGolfFragment.this.f11877b == null || !Objects.equals(DeviceAfterGolfFragment.this.f11877b.mac, strR)) {
                return;
            }
            if (intExtra != 0) {
                DeviceAfterGolfFragment.this.U();
                return;
            }
            DeviceAfterGolfFragment.this.f11875a = bleDevice;
            b4.a.S(strR);
            DeviceAfterGolfFragment.this.R();
            DeviceAfterGolfFragment.this.B0();
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws InterruptedException {
            BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
            if (bleDevice == null || DeviceAfterGolfFragment.this.f11875a == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(DeviceAfterGolfFragment.this.f11875a))) {
                return;
            }
            String stringExtra = intent.getStringExtra("carSN");
            if (stringExtra != null && b4.a.h(stringExtra)) {
                if (DeviceAfterGolfFragment.this.f11877b.carNo == null || !DeviceAfterGolfFragment.this.f11877b.carNo.equals(stringExtra)) {
                    DeviceAfterGolfFragment.this.V0(stringExtra);
                }
                DeviceAfterGolfFragment.this.f11877b.carNo = stringExtra;
                return;
            }
            if (DeviceAfterGolfFragment.this.J) {
                try {
                    Thread.sleep(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                    DeviceAfterGolfFragment.this.A0();
                    DeviceAfterGolfFragment.this.J = false;
                } catch (InterruptedException e7) {
                    throw new RuntimeException(e7);
                }
            }
        }
    }

    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
            if (bleDevice == null || DeviceAfterGolfFragment.this.f11875a == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(DeviceAfterGolfFragment.this.f11875a))) {
                return;
            }
            DeviceAfterGolfFragment.this.q0(intent.getStringExtra("meterVersion"), intent.getStringExtra("bldcVersion"), intent.getStringExtra("bmsVersion"), intent.getStringExtra("screenVersion"));
        }
    }

    public class d implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11912a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f11913b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f11914c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f11915d;

        public class a extends TypeToken<HttpResponse<DfuResponseData>> {
            public a() {
            }
        }

        public class b extends e0.a {

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11918c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11919d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11920e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11921f;

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ StringBuilder f11922g;

            /* renamed from: h, reason: collision with root package name */
            public final /* synthetic */ long f11923h;

            /* renamed from: i, reason: collision with root package name */
            public final /* synthetic */ String f11924i;

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ StringBuilder f11925j;

            public class a implements FirmwareUpdatePopup.a {
                public a() {
                }

                @Override // com.uz.navee.ui.device.FirmwareUpdatePopup.a
                public void a(BasePopupView basePopupView) {
                    if (!b4.a.f(DeviceAfterGolfFragment.this.f11875a)) {
                        Toast.makeText(DeviceAfterGolfFragment.this.requireActivity(), R$string.ble_disconnect_alert, 1).show();
                        return;
                    }
                    if (b4.a.W().f1931d.getBatteryCharge() < 20) {
                        Toast.makeText(DeviceAfterGolfFragment.this.requireActivity(), R$string.low_battery_alert, 1).show();
                        return;
                    }
                    float realTimeSpeed = b4.a.W().f1932e.getRealTimeSpeed();
                    if (b4.a.W().f1932e.getVersion() == 1) {
                        realTimeSpeed = (float) (realTimeSpeed / 10.0d);
                    }
                    if (b4.a.W().f1932e.getDrivingStatus() != 0 || realTimeSpeed > 3.0f) {
                        Toast.makeText(DeviceAfterGolfFragment.this.requireActivity(), R$string.driving_alert, 1).show();
                        return;
                    }
                    Intent intent = new Intent(DeviceAfterGolfFragment.this.requireContext(), (Class<?>) DeviceFirmwareUpdateActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("bleDevice", DeviceAfterGolfFragment.this.f11875a);
                    bundle.putSerializable("vehicle", DeviceAfterGolfFragment.this.f11877b);
                    bundle.putString("currentMeterVersion", d.this.f11912a);
                    bundle.putString("currentBldcVersion", d.this.f11913b);
                    bundle.putString("currentBmsVersion", d.this.f11914c);
                    bundle.putString("currentScreenVersion", d.this.f11915d);
                    bundle.putParcelableArrayList("meterVersionList", b.this.f11918c);
                    bundle.putParcelableArrayList("bldcVersionList", b.this.f11919d);
                    bundle.putParcelableArrayList("bmsVersionList", b.this.f11920e);
                    bundle.putParcelableArrayList("screenVersionList", b.this.f11921f);
                    bundle.putLong("serverVersionTime", b.this.f11923h);
                    intent.putExtra("data", bundle);
                    DeviceAfterGolfFragment.this.startActivity(intent);
                    basePopupView.m();
                }

                @Override // com.uz.navee.ui.device.FirmwareUpdatePopup.a
                public void b() {
                    b bVar = b.this;
                    com.uz.navee.utils.g0.f(bVar.f11924i, bVar.f11925j.toString());
                }
            }

            /* renamed from: com.uz.navee.ui.device.DeviceAfterGolfFragment$d$b$b, reason: collision with other inner class name */
            public class C0162b extends i3.d {
                public C0162b() {
                }

                @Override // i3.e
                public void h(BasePopupView basePopupView) {
                    com.uz.navee.utils.e0.f().e(b.this.f13279b);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(int i6, String str, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, StringBuilder sb, long j6, String str2, StringBuilder sb2) {
                super(i6, str);
                this.f11918c = arrayList;
                this.f11919d = arrayList2;
                this.f11920e = arrayList3;
                this.f11921f = arrayList4;
                this.f11922g = sb;
                this.f11923h = j6;
                this.f11924i = str2;
                this.f11925j = sb2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.C0192a c0192aL = new a.C0192a(DeviceAfterGolfFragment.this.requireContext()).f(false).g(Boolean.TRUE).i((com.uz.navee.utils.d.g(DeviceAfterGolfFragment.this.requireActivity()) * 2) / 3).e(Boolean.FALSE).l(new C0162b());
                Context contextRequireContext = DeviceAfterGolfFragment.this.requireContext();
                Vehicle vehicle = DeviceAfterGolfFragment.this.f11877b;
                d dVar = d.this;
                c0192aL.a(new FirmwareUpdatePopup(contextRequireContext, vehicle, dVar.f11912a, dVar.f11913b, dVar.f11914c, dVar.f11915d, this.f11918c, this.f11919d, this.f11920e, this.f11921f, this.f11922g.toString(), new a())).G();
            }
        }

        public d(String str, String str2, String str3, String str4) {
            this.f11912a = str;
            this.f11913b = str2;
            this.f11914c = str3;
            this.f11915d = str4;
        }

        @Override // d4.d.h
        public void a(String str) {
            boolean zIsReminder;
            if (DeviceAfterGolfFragment.this.isAdded()) {
                HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
                if (httpResponse == null || httpResponse.getCode() != 200) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                ArrayList<DfuVerInfo> meterList = ((DfuResponseData) httpResponse.getData()).getMeterList();
                ArrayList<DfuVerInfo> bldcList = ((DfuResponseData) httpResponse.getData()).getBldcList();
                ArrayList<DfuVerInfo> bmsList = ((DfuResponseData) httpResponse.getData()).getBmsList();
                ArrayList<DfuVerInfo> screenList = ((DfuResponseData) httpResponse.getData()).getScreenList();
                String str2 = DeviceAfterGolfFragment.this.f11877b.model.pid;
                if ((str2.startsWith("2417") || str2.startsWith("2422")) && this.f11912a.equals("2.0.0.5")) {
                    bmsList.clear();
                }
                if (str2.startsWith("2442") && DeviceAfterGolfFragment.this.f11877b.areaCode() == AreaCode.US) {
                    bmsList.clear();
                }
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                if (meterList.isEmpty()) {
                    zIsReminder = false;
                } else {
                    DfuVerInfo dfuVerInfo = meterList.get(0);
                    zIsReminder = dfuVerInfo.isReminder();
                    sb.append(dfuVerInfo.getVn());
                    if (!TextUtils.isEmpty(dfuVerInfo.getContext())) {
                        sb2.append(DeviceAfterGolfFragment.this.getString(R$string.meter));
                        sb2.append("\n");
                        sb2.append(dfuVerInfo.getContext());
                    }
                }
                sb.append(",");
                if (!bldcList.isEmpty()) {
                    DfuVerInfo dfuVerInfo2 = bldcList.get(0);
                    if (dfuVerInfo2.isReminder()) {
                        zIsReminder = true;
                    }
                    sb.append(dfuVerInfo2.getVn());
                    if (!TextUtils.isEmpty(dfuVerInfo2.getContext())) {
                        if (sb2.length() > 0) {
                            sb2.append("\n\n\n");
                        }
                        sb2.append(DeviceAfterGolfFragment.this.getString(R$string.bldc));
                        sb2.append("\n");
                        sb2.append(dfuVerInfo2.getContext());
                    }
                }
                sb.append(",");
                if (!bmsList.isEmpty()) {
                    DfuVerInfo dfuVerInfo3 = bmsList.get(0);
                    if (dfuVerInfo3.isReminder()) {
                        zIsReminder = true;
                    }
                    sb.append(dfuVerInfo3.getVn());
                    if (!TextUtils.isEmpty(dfuVerInfo3.getContext())) {
                        if (sb2.length() > 0) {
                            sb2.append("\n\n\n");
                        }
                        sb2.append(DeviceAfterGolfFragment.this.getString(R$string.bms));
                        sb2.append("\n");
                        sb2.append(dfuVerInfo3.getContext());
                    }
                }
                sb.append(",");
                if (!screenList.isEmpty()) {
                    DfuVerInfo dfuVerInfo4 = screenList.get(0);
                    boolean z6 = dfuVerInfo4.isReminder() ? true : zIsReminder;
                    sb.append(dfuVerInfo4.getVn());
                    if (!TextUtils.isEmpty(dfuVerInfo4.getContext())) {
                        if (sb2.length() > 0) {
                            sb2.append("\n\n\n");
                        }
                        sb2.append(DeviceAfterGolfFragment.this.getString(R$string.screen));
                        sb2.append("\n");
                        sb2.append(dfuVerInfo4.getContext());
                    }
                    zIsReminder = z6;
                }
                if (zIsReminder) {
                    String str3 = "ignore_firmware_version_" + g4.e1.u().f13674b + DeviceAfterGolfFragment.this.f11877b.mac;
                    if (TextUtils.equals(com.uz.navee.utils.g0.d(str3), sb.toString())) {
                        return;
                    }
                    if (sb2.length() > 0) {
                        sb2.insert(0, DeviceAfterGolfFragment.this.getString(R$string.update_notes) + ":\n");
                    }
                    com.uz.navee.utils.e0.f().a(new b(100, "showFirmwareUpdate", meterList, bldcList, bmsList, screenList, sb2, jCurrentTimeMillis, str3, sb));
                }
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
        }
    }

    public class e implements AlertPopup.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f11929a;

        public e(View view) {
            this.f11929a = view;
        }

        @Override // com.uz.navee.ui.wheel.AlertPopup.a
        public /* synthetic */ void a() {
            j4.c.a(this);
        }

        @Override // com.uz.navee.ui.wheel.AlertPopup.a
        public void b() {
            this.f11929a.setSelected(!r0.isSelected());
            DeviceAfterGolfFragment.this.f11905w.setText(this.f11929a.isSelected() ? R$string.distance_clear : R$string.distance_measure);
            if (b4.a.f(DeviceAfterGolfFragment.this.f11875a)) {
                b4.a.c0(DeviceAfterGolfFragment.this.f11875a, b4.a.k(LocationRequestCompat.QUALITY_LOW_POWER, this.f11929a.isSelected() ? 1 : 0, false));
            }
        }
    }

    public class f implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f11931a;

        public class a extends TypeToken<HttpResponse<ArrayList<WarnConfig>>> {
            public a() {
            }
        }

        public f(int i6) {
            this.f11931a = i6;
        }

        @Override // d4.d.h
        public void a(String str) {
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse != null && httpResponse.getCode() == 200) {
                b4.a.W().f1935h = (ArrayList) httpResponse.getData();
            }
            DeviceAfterGolfFragment.this.O0(this.f11931a);
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            DeviceAfterGolfFragment.this.O0(this.f11931a);
        }
    }

    public class g implements d.h {
        public g() {
        }

        @Override // d4.d.h
        public void a(String str) {
        }

        @Override // d4.d.h
        public void b(Exception exc) {
        }
    }

    public class h implements d.h {
        public h() {
        }

        @Override // d4.d.h
        public void a(String str) {
        }

        @Override // d4.d.h
        public void b(Exception exc) {
        }
    }

    public class i implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11936a;

        public class a extends TypeToken<HttpResponse<String>> {
            public a() {
            }
        }

        public i(String str) {
            this.f11936a = str;
        }

        @Override // d4.d.h
        public void a(String str) {
            System.out.println(this.f11936a + "网络请求==" + str);
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse == null) {
                DeviceAfterGolfFragment.this.f11899q.setEnabled(false);
                DeviceAfterGolfFragment.this.f11900r.setEnabled(false);
                return;
            }
            String str2 = (String) httpResponse.getData();
            if (str2 == null || !(str2.startsWith("http:") || str2.startsWith("https:"))) {
                DeviceAfterGolfFragment.this.f11899q.setEnabled(false);
                DeviceAfterGolfFragment.this.f11900r.setEnabled(false);
            } else {
                DeviceAfterGolfFragment.this.L = str2;
                DeviceAfterGolfFragment.this.f11899q.setEnabled(true);
                DeviceAfterGolfFragment.this.f11900r.setEnabled(true);
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            DeviceAfterGolfFragment.this.f11899q.setEnabled(false);
            DeviceAfterGolfFragment.this.f11900r.setEnabled(false);
        }
    }

    public class j extends q0.b {
        public j() {
        }

        @Override // q0.b
        public void c(BleDevice bleDevice, BleException bleException) {
            f4.b.c("Connect fail (%s)，error = %s", bleDevice.getMac(), bleException.toString());
            DeviceAfterGolfFragment.this.K0();
        }

        @Override // q0.b
        public void d(BleDevice bleDevice, BluetoothGatt bluetoothGatt, int i6) throws InterruptedException {
            f4.b.c("Connect success (%s)", bleDevice.getMac());
            b4.a.W().f1930c = DeviceAfterGolfFragment.this.f11877b.shareUserId;
            DeviceAfterGolfFragment.this.N(bleDevice);
        }

        @Override // q0.b
        public void e(boolean z6, BleDevice bleDevice, BluetoothGatt bluetoothGatt, int i6) {
            com.clj.fastble.bluetooth.b bVarP;
            f4.b.c("DisConnected (%s)", bleDevice.getMac());
            if (!z6 && (bVarP = p0.a.n().p()) != null) {
                bVarP.i(bVarP.d(bleDevice));
            }
            b4.a.W().f1930c = 0;
            DeviceAfterGolfFragment.this.y0(z6, bleDevice);
            if (DeviceAfterGolfFragment.this.getActivity() != null) {
                DeviceAfterGolfFragment.this.U();
            }
            b4.a.W().f1929b = false;
        }

        @Override // q0.b
        public void f() {
            DeviceAfterGolfFragment.this.f11887g.k(true);
        }
    }

    public class k extends q0.g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean[] f11940a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f11941b;

        public class a extends q0.b {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BleDevice f11943a;

            public a(BleDevice bleDevice) {
                this.f11943a = bleDevice;
            }

            @Override // q0.b
            public void c(BleDevice bleDevice, BleException bleException) {
                f4.b.c("Connect fail (%s)，error = %s", b4.a.r(bleDevice), bleException.toString());
                if (DeviceAfterGolfFragment.this.getActivity() != null) {
                    DeviceAfterGolfFragment.this.U();
                }
                b4.a.W().f1929b = false;
            }

            @Override // q0.b
            public void d(BleDevice bleDevice, BluetoothGatt bluetoothGatt, int i6) throws InterruptedException {
                f4.b.c("Connect success (%s)", b4.a.r(bleDevice));
                DeviceAfterGolfFragment.this.N(bleDevice);
            }

            @Override // q0.b
            public void e(boolean z6, BleDevice bleDevice, BluetoothGatt bluetoothGatt, int i6) {
                com.clj.fastble.bluetooth.b bVarP;
                f4.b.c("DisConnected (%s)", b4.a.r(bleDevice));
                if (!z6 && (bVarP = p0.a.n().p()) != null) {
                    bVarP.i(bVarP.d(DeviceAfterGolfFragment.this.f11875a));
                }
                DeviceAfterGolfFragment.this.y0(z6, bleDevice);
                if (DeviceAfterGolfFragment.this.getActivity() != null) {
                    DeviceAfterGolfFragment.this.U();
                }
                b4.a.W().f1929b = false;
            }

            @Override // q0.b
            public void f() {
                f4.b.c("Connect start (%s)", b4.a.r(this.f11943a));
            }
        }

        public k(boolean[] zArr, String str) {
            this.f11940a = zArr;
            this.f11941b = str;
        }

        @Override // q0.h
        public void a(boolean z6) {
            DeviceAfterGolfFragment.this.f11887g.k(true);
        }

        @Override // q0.h
        public void b(BleDevice bleDevice) throws InterruptedException {
            String name = bleDevice.getName();
            if (name == null) {
                name = "N/A";
            }
            if (name.startsWith("NAVEE") && Objects.equals(b4.a.r(bleDevice), this.f11941b)) {
                this.f11940a[0] = true;
                p0.a.n().a();
                try {
                    Thread.sleep(100L);
                    p0.a.n().b(bleDevice, new a(bleDevice));
                } catch (InterruptedException e7) {
                    throw new RuntimeException(e7);
                }
            }
        }

        @Override // q0.g
        public void d(List list) {
            f4.b.g("onScanFinished, result count: " + list.size(), new Object[0]);
            if (this.f11940a[0]) {
                return;
            }
            FragmentActivity activity = DeviceAfterGolfFragment.this.getActivity();
            if (activity != null) {
                DeviceAfterGolfFragment.this.U();
                Toast.makeText(activity, DeviceAfterGolfFragment.this.getString(R$string.ble_scan_nothing), 0).show();
            }
            b4.a.W().f1929b = false;
        }
    }

    public class l extends BroadcastReceiver {
        public l() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws InterruptedException {
            BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
            if (bleDevice == null || DeviceAfterGolfFragment.this.f11875a == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(DeviceAfterGolfFragment.this.f11875a))) {
                return;
            }
            DeviceAfterGolfFragment.this.O();
        }
    }

    public class m extends BroadcastReceiver {
        public m() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws InterruptedException {
            if (intent.getIntExtra("accessType", 0) == 303) {
                DeviceAfterGolfFragment.this.O();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        this.J = true;
        if (b4.a.f(this.f11875a)) {
            b4.a.H(this.f11875a);
        }
    }

    private void C0() {
        if (b4.a.f(this.f11875a)) {
            b4.a.I(this.f11875a);
        }
    }

    private void D0() {
        if (b4.a.f(this.f11875a)) {
            int batteryCharge = b4.a.W().f1931d.getBatteryCharge();
            this.f11895m.setText(String.valueOf(batteryCharge));
            N0(batteryCharge);
        }
    }

    private void E0(int i6) {
        this.f11903u.setText(String.valueOf(i6));
        if (this.f11905w.isSelected()) {
            return;
        }
        this.f11905w.setSelected(i6 > 0);
        this.f11905w.setText(i6 > 0 ? R$string.distance_clear : R$string.distance_measure);
    }

    private void G0() {
        if (b4.a.f(this.f11875a)) {
            String string = getString(R$string.unit_mileage_metric);
            int remainMileage = b4.a.W().f1931d.getRemainMileage();
            if (b4.a.W().f1933f.getMileageUnit() == 0) {
                string = getString(R$string.unit_mileage_imperial);
                remainMileage = (int) Math.round(remainMileage * 0.621d);
            }
            this.f11892j.setText(String.valueOf(remainMileage));
            this.f11893k.setText(string);
        }
    }

    private void H0(int i6) {
        if (i6 == 0) {
            this.f11881d.setVisibility(8);
        } else if (b4.a.W().f1935h.isEmpty()) {
            W(i6);
        } else {
            O0(i6);
        }
    }

    private void I0() {
        J0();
        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(this.X, new IntentFilter("BleAuthCallbackNotification"));
        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(this.W, new IntentFilter("BleOpenNotification"));
        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(this.V, new IntentFilter("BleReconnectNotification"));
        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(this.Y, new IntentFilter("BleReadCarSNSuccessNotification"));
        w0(b4.a.W().f1931d);
        x0(b4.a.W().f1932e);
        v0(b4.a.W().f1933f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0() {
        String str = this.f11877b.mac;
        if (str == null) {
            return;
        }
        if (s0.c.b().c() != BleScanState.STATE_IDLE) {
            p0.a.n().a();
        }
        p0.a.n().D(new k(new boolean[]{false}, str));
    }

    private void M(View view) {
        this.f11879c = (LinearLayout) view.findViewById(R$id.tyreWarningView);
        this.f11881d = (LinearLayout) view.findViewById(R$id.warningView);
        this.f11883e = (TextView) view.findViewById(R$id.warningTextView);
        this.f11885f = (ImageButton) view.findViewById(R$id.bluetoothStatusButton);
        this.f11887g = (QMUIEmptyView) view.findViewById(R$id.bluetoothConnectingView);
        this.f11889h = (NestedScrollView) view.findViewById(R$id.scrollView);
        this.f11891i = (ImageView) view.findViewById(R$id.deviceImageView);
        this.f11892j = (TextView) view.findViewById(R$id.mileageLabel);
        this.f11893k = (TextView) view.findViewById(R$id.mileageUnitLabel);
        this.f11894l = (TextView) view.findViewById(R$id.mileageButton);
        this.f11895m = (TextView) view.findViewById(R$id.batteryLabel);
        this.f11896n = (TextView) view.findViewById(R$id.batteryUnitLabel);
        this.f11897o = (ImageView) view.findViewById(R$id.batteryChargeIcon);
        this.f11898p = (ImageView) view.findViewById(R$id.batteryFill);
        this.f11899q = (ImageButton) view.findViewById(R$id.scoreButton);
        this.f11900r = (TextView) view.findViewById(R$id.scoreTextView);
        this.f11901s = (ImageButton) view.findViewById(R$id.infoButton);
        this.f11902t = (TextView) view.findViewById(R$id.infoTextView);
        this.f11905w = (Button) view.findViewById(R$id.distanceButton);
        this.f11903u = (TextView) view.findViewById(R$id.distanceTextView);
        this.f11904v = (TextView) view.findViewById(R$id.distanceUnitTextView);
        this.f11906x = (TextView) view.findViewById(R$id.controlTextView);
        this.f11907y = view.findViewById(R$id.remoteControlLayout);
        this.f11908z = (ImageButton) view.findViewById(R$id.pauseButton);
        this.A = (ImageButton) view.findViewById(R$id.forwardButton);
        this.B = (ImageButton) view.findViewById(R$id.backwardButton);
        this.C = (ImageButton) view.findViewById(R$id.leftButton);
        this.D = (ImageButton) view.findViewById(R$id.rightButton);
        this.E = (SlideProgressView) view.findViewById(R$id.speedProgressView);
        this.F = (TextView) view.findViewById(R$id.speedLabel);
        this.G = (TextView) view.findViewById(R$id.speedUnitLabel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(BleDevice bleDevice) throws InterruptedException {
        try {
            Thread.sleep(100L);
            b4.a.U(bleDevice, getContext());
        } catch (InterruptedException e7) {
            throw new RuntimeException(e7);
        }
    }

    private void N0(int i6) {
        this.f11898p.setVisibility(0);
        this.f11898p.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        int intrinsicWidth = this.f11898p.getDrawable().getIntrinsicWidth();
        float intrinsicHeight = this.f11898p.getDrawable().getIntrinsicHeight();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight), new RectF(0.0f, 0.0f, (float) ((i6 * intrinsicWidth) / 100.0d), intrinsicHeight), Matrix.ScaleToFit.FILL);
        this.f11898p.setImageMatrix(matrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() throws InterruptedException {
        if (ContextCompat.checkSelfPermission(requireContext(), "android.permission.BLUETOOTH_SCAN") != -1) {
            if (p0.a.n().w()) {
                P();
                return;
            } else {
                MyApplication.f11588e.startActivityIfNeeded(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 303);
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 31) {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN"}, 303);
            return;
        }
        if (MyApplication.f11588e.D(303) == 0) {
            if (p0.a.n().w()) {
                P();
            } else {
                MyApplication.f11588e.startActivityIfNeeded(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 303);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(int i6) {
        final WarnConfig warnConfigZ = b4.a.z(String.valueOf(i6));
        if (warnConfigZ == null) {
            this.f11881d.setVisibility(8);
            return;
        }
        this.f11881d.setVisibility(0);
        this.f11883e.setText(warnConfigZ.getName());
        this.f11883e.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.g2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12523a.p0(warnConfigZ, view);
            }
        });
    }

    private void P() throws InterruptedException {
        try {
            Thread.sleep(100L);
            Q();
        } catch (InterruptedException e7) {
            throw new RuntimeException(e7);
        }
    }

    private void Q() {
        String validBluetoothAddress = this.f11877b.getValidBluetoothAddress();
        if (validBluetoothAddress == null) {
            return;
        }
        p0.a.n().c(validBluetoothAddress, new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() throws NumberFormatException {
        this.f11885f.setSelected(true);
        this.f11887g.k(false);
        b4.a.W().R(this.f11875a, requireContext());
        this.f11901s.setEnabled(true);
        this.f11902t.setEnabled(true);
        this.f11905w.setEnabled(true);
        this.f11905w.setAlpha(1.0f);
        this.f11903u.setEnabled(true);
        this.f11904v.setEnabled(true);
        this.f11906x.setEnabled(true);
        this.f11907y.setAlpha(1.0f);
        this.A.setEnabled(true);
        this.B.setEnabled(true);
        this.C.setEnabled(true);
        this.D.setEnabled(true);
        this.f11908z.setEnabled(true);
        this.E.setEnabled(true);
        this.f11894l.setEnabled(true);
        this.f11892j.setEnabled(true);
        this.f11893k.setEnabled(true);
        this.f11895m.setEnabled(true);
        this.f11896n.setEnabled(true);
        this.f11897o.setVisibility(b4.a.W().f1931d.getChargingState() != 1 ? 8 : 0);
        G0();
        D0();
        F0();
        Intent intent = new Intent("BleDeviceAfterNotification");
        intent.putExtra("vehicle", this.f11877b);
        intent.putExtra("bleDevice", this.f11875a);
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent);
        TyreSettingReceiver.b(requireContext(), b4.a.r(this.f11875a));
        V();
    }

    private void R0() {
        if (b4.a.f(this.f11875a)) {
            Intent intent = new Intent(getActivity(), (Class<?>) DeviceInfoSubActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("bleDevice", this.f11875a);
            bundle.putSerializable("vehicle", this.f11877b);
            intent.putExtra("data", bundle);
            startActivity(intent);
        }
    }

    private void S0(DeviceCarInfo deviceCarInfo) {
        deviceCarInfo.removeListener("mileageAlgorithm", this.f11876a0);
        deviceCarInfo.removeListener("mileageUnit", this.f11878b0);
    }

    private void T0(DeviceHomePageInfo deviceHomePageInfo) {
        deviceHomePageInfo.removeListener("remainMileage", this.f11880c0);
        deviceHomePageInfo.removeListener("batteryCharge", this.f11882d0);
        deviceHomePageInfo.removeListener("warningCode", this.f11884e0);
        deviceHomePageInfo.removeListener("chargingState", this.f11886f0);
        deviceHomePageInfo.removeListener("drivingMode", this.f11888g0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        b4.a.W().Z();
        this.f11885f.setSelected(false);
        this.f11887g.k(false);
        this.f11901s.setEnabled(false);
        this.f11902t.setEnabled(false);
        this.f11899q.setEnabled(false);
        this.f11900r.setEnabled(false);
        this.f11905w.setEnabled(false);
        this.f11905w.setAlpha(0.4f);
        this.f11903u.setEnabled(false);
        this.f11904v.setEnabled(false);
        this.f11906x.setEnabled(false);
        this.f11907y.setAlpha(0.4f);
        this.A.setEnabled(false);
        this.B.setEnabled(false);
        this.C.setEnabled(false);
        this.D.setEnabled(false);
        this.f11908z.setEnabled(false);
        this.E.setEnabled(false);
        this.f11894l.setEnabled(false);
        this.f11892j.setText("--");
        this.f11892j.setEnabled(false);
        this.f11893k.setEnabled(false);
        this.f11895m.setText("--");
        this.f11895m.setEnabled(false);
        this.f11896n.setEnabled(false);
        this.f11897o.setVisibility(8);
        this.f11898p.setVisibility(8);
        this.f11905w.setSelected(false);
        this.f11905w.setText(R$string.distance_measure);
        this.f11903u.setText("0");
        this.F.setText("--");
    }

    private void U0(DeviceSubPageInfo deviceSubPageInfo) {
        deviceSubPageInfo.removeListener("drivingMileage", this.f11890h0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(String str) {
        HashMap map = new HashMap();
        map.put("mac", this.f11877b.mac);
        map.put("carNo", str);
        d4.d.h().g(e4.a.a() + "/vehicle/updateVehicle", map, new h());
    }

    private void W(int i6) {
        String str = e4.a.a() + "/getWarnCfg";
        if (this.f11877b != null) {
            str = str + "?category=" + this.f11877b.model.category;
        }
        d4.d.h().f(str, new f(i6));
    }

    private void W0(int i6, Location location) {
        if (this.f11877b == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("mac", this.f11877b.mac);
        map.put("code", String.valueOf(i6));
        map.put("warnTime", com.uz.navee.utils.l.e("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("UTC")));
        if (location != null) {
            String strValueOf = String.valueOf(location.getLatitude());
            String strValueOf2 = String.valueOf(location.getLongitude());
            map.put("lat", strValueOf);
            map.put("lng", strValueOf2);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(map);
        d4.d.h().g(e4.a.a() + "/uploadWarn", arrayList, new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(int i6) {
        if (b4.a.f(this.f11875a)) {
            b4.a.c0(this.f11875a, b4.a.k(86, i6, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(PropertyChangeEvent propertyChangeEvent) {
        if ("drivingMileage".equals(propertyChangeEvent.getPropertyName())) {
            E0(((Integer) propertyChangeEvent.getNewValue()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(View view) throws InterruptedException {
        if (b4.a.f(this.f11875a)) {
            return;
        }
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(View view) {
        R0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(View view) {
        WebActivity.f13179h.a(requireContext(), "", this.L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(View view) {
        s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(View view) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        AlertPopup.P(activity, getString(view.isSelected() ? R$string.distance_clear_title : R$string.distance_measure_title), getString(view.isSelected() ? R$string.distance_clear_msg : R$string.distance_measure_msg), new e(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(String str, String str2, String str3, String str4) {
        String str5 = e4.a.a() + "/vehicle/modelSoftware";
        d4.d dVarH = d4.d.h();
        HashMap map = new HashMap();
        map.put("vehicleModelId", String.valueOf(this.f11877b.model.id));
        map.put("meter", str);
        map.put("bldc", str2);
        map.put("bms", str3);
        map.put("screen", str4);
        dVarH.g(str5, map, new d(str, str2, str3, str4));
    }

    private void r0() throws InterruptedException, NumberFormatException {
        if (getActivity() != null) {
            com.bumptech.glide.b.v(this).t(Uri.parse(this.f11877b.model.maxImg)).z0(this.f11891i);
        }
        if (this.f11875a == null) {
            for (BleDevice bleDevice : p0.a.n().f()) {
                if (Objects.equals(this.f11877b.mac, b4.a.r(bleDevice))) {
                    this.f11875a = bleDevice;
                }
            }
        }
        if (!b4.a.f(this.f11875a)) {
            O();
        } else if (Objects.equals(this.f11877b.mac, b4.a.r(this.f11875a))) {
            R();
        } else {
            T();
            O();
        }
    }

    private void s0() {
        String str = this.f11877b.model.pid;
        if (str != null && !str.startsWith("2213")) {
            str.startsWith("2332");
        }
        new a.C0192a(getContext()).f(false).a(new MileageAlgorithmPopup(requireContext(), this.f11877b, new MileageAlgorithmPopup.a() { // from class: com.uz.navee.ui.device.c2
            @Override // com.uz.navee.ui.device.MileageAlgorithmPopup.a
            public final void a(int i6) {
                this.f12483a.X0(i6);
            }
        })).G();
        z0();
    }

    public static DeviceAfterGolfFragment u0(Vehicle vehicle) {
        DeviceAfterGolfFragment deviceAfterGolfFragment = new DeviceAfterGolfFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("param1", vehicle);
        deviceAfterGolfFragment.setArguments(bundle);
        return deviceAfterGolfFragment;
    }

    private void v0(DeviceCarInfo deviceCarInfo) {
        this.f11876a0 = deviceCarInfo.addListener("mileageAlgorithm", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.d2
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12492a.X(propertyChangeEvent);
            }
        });
        this.f11878b0 = deviceCarInfo.addListener("mileageUnit", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.e2
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12501a.Y(propertyChangeEvent);
            }
        });
    }

    private void w0(DeviceHomePageInfo deviceHomePageInfo) {
        this.f11880c0 = deviceHomePageInfo.addListener("remainMileage", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.x1
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12697a.Z(propertyChangeEvent);
            }
        });
        this.f11882d0 = deviceHomePageInfo.addListener("batteryCharge", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.y1
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12707a.a0(propertyChangeEvent);
            }
        });
        this.f11884e0 = deviceHomePageInfo.addListener("warningCode", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.z1
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12718a.b0(propertyChangeEvent);
            }
        });
        this.f11886f0 = deviceHomePageInfo.addListener("chargingState", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.a2
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12464a.c0(propertyChangeEvent);
            }
        });
        this.f11888g0 = deviceHomePageInfo.addListener("drivingMode", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.b2
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12474a.d0(propertyChangeEvent);
            }
        });
    }

    private void x0(DeviceSubPageInfo deviceSubPageInfo) {
        this.f11890h0 = deviceSubPageInfo.addListener("drivingMileage", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.w1
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12687a.e0(propertyChangeEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(boolean z6, BleDevice bleDevice) {
        if (z6 || (com.uz.navee.e.c().b() instanceof MainActivity) || getContext() == null) {
            return;
        }
        Intent intent = new Intent("BleDisconnectNotification");
        intent.putExtra("bleDevice", bleDevice);
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent);
    }

    private void z0() {
        if (b4.a.f(this.f11875a)) {
            b4.a.G(this.f11875a);
        }
    }

    public void B0() {
        z0();
        A0();
        C0();
    }

    public final void F0() {
        this.F.setText(String.valueOf(b4.a.W().f1931d.getDrivingMode()));
        this.G.setText(getString(R$string.unit_speed_metric));
    }

    public void J0() {
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(this.X);
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(this.W);
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(this.V);
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(this.Y);
        T0(b4.a.W().f1931d);
        U0(b4.a.W().f1932e);
        S0(b4.a.W().f1933f);
    }

    public final void L0(byte[] bArr) throws IOException {
        if (b4.a.f(this.f11875a)) {
            b4.a.c0(this.f11875a, b4.a.l(103, bArr, false));
        }
    }

    public final void M0(int i6) throws IOException {
        if (b4.a.f(this.f11875a)) {
            b4.a.c0(this.f11875a, b4.a.k(102, i6, false));
        }
    }

    public final void P0(int i6) throws IOException {
        L0(new byte[]{(byte) i6, 1});
    }

    public final void Q0(int i6) throws IOException {
        L0(new byte[]{(byte) i6, 0});
    }

    public BleDevice S() {
        return this.f11875a;
    }

    public void T() {
        p0.a aVarN = p0.a.n();
        if (b4.a.f(this.f11875a)) {
            aVarN.d(this.f11875a);
        }
    }

    public final void V() {
        String str = e4.a.a() + "/configKey/score_url";
        d4.d.h().f(str, new i(str));
    }

    public final /* synthetic */ void X(PropertyChangeEvent propertyChangeEvent) {
        if ("mileageAlgorithm".equals(propertyChangeEvent.getPropertyName())) {
            G0();
        }
    }

    public final /* synthetic */ void Y(PropertyChangeEvent propertyChangeEvent) {
        if ("mileageUnit".equals(propertyChangeEvent.getPropertyName())) {
            G0();
        }
    }

    public final /* synthetic */ void Z(PropertyChangeEvent propertyChangeEvent) {
        if ("remainMileage".equals(propertyChangeEvent.getPropertyName())) {
            G0();
        }
    }

    public final /* synthetic */ void a0(PropertyChangeEvent propertyChangeEvent) {
        if ("batteryCharge".equals(propertyChangeEvent.getPropertyName())) {
            D0();
        }
    }

    public final /* synthetic */ void b0(PropertyChangeEvent propertyChangeEvent) {
        if ("warningCode".equals(propertyChangeEvent.getPropertyName())) {
            int iIntValue = ((Integer) propertyChangeEvent.getNewValue()).intValue();
            if (iIntValue != 0) {
                W0(iIntValue, null);
            }
            H0(iIntValue);
        }
    }

    public final /* synthetic */ void c0(PropertyChangeEvent propertyChangeEvent) {
        if ("chargingState".equals(propertyChangeEvent.getPropertyName())) {
            this.f11897o.setVisibility(((Integer) propertyChangeEvent.getNewValue()).intValue() == 1 ? 0 : 8);
        }
    }

    public final /* synthetic */ void d0(PropertyChangeEvent propertyChangeEvent) {
        if ("drivingMode".equals(propertyChangeEvent.getPropertyName())) {
            this.E.setCurrentSection(((Integer) propertyChangeEvent.getNewValue()).intValue());
            F0();
        }
    }

    public final /* synthetic */ boolean k0(View view, MotionEvent motionEvent) {
        return t0(view, motionEvent, 32);
    }

    public final /* synthetic */ boolean l0(View view, MotionEvent motionEvent) {
        return t0(view, motionEvent, 33);
    }

    public final /* synthetic */ boolean m0(View view, MotionEvent motionEvent) {
        return t0(view, motionEvent, 37);
    }

    public final /* synthetic */ boolean n0(View view, MotionEvent motionEvent) {
        return t0(view, motionEvent, 35);
    }

    public final /* synthetic */ boolean o0(View view, MotionEvent motionEvent) {
        return t0(view, motionEvent, 36);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f11877b = (Vehicle) getArguments().getSerializable("param1");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws InterruptedException, NumberFormatException {
        View view = this.I;
        if (view == null) {
            View viewInflate = layoutInflater.inflate(R$layout.fragment_device_after_golf, viewGroup, false);
            this.I = viewInflate;
            M(viewInflate);
            this.f11885f.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.u1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) throws InterruptedException {
                    this.f12665a.f0(view2);
                }
            });
            this.f11901s.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.h2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f12537a.g0(view2);
                }
            });
            this.f11899q.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.i2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f12547a.h0(view2);
                }
            });
            this.f11894l.setText(RemoteSettings.FORWARD_SLASH_STRING + getString(R$string.mileage_algorithm_title));
            this.f11894l.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.j2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f12557a.i0(view2);
                }
            });
            ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, new int[]{-16842910}}, new int[]{ContextCompat.getColor(requireContext(), R$color.xC69D7D), ContextCompat.getColor(requireContext(), R$color.xC69D7D_40)});
            this.f11902t.setTextColor(colorStateList);
            this.f11900r.setTextColor(colorStateList);
            int color = ContextCompat.getColor(requireContext(), R$color.xFAF4E8);
            ColorStateList colorStateList2 = new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, new int[]{-16842910}}, new int[]{color, ContextCompat.getColor(requireContext(), R$color.xFAF4E8_40)});
            this.f11903u.setTextColor(colorStateList2);
            this.f11904v.setTextColor(colorStateList2);
            this.f11906x.setTextColor(colorStateList2);
            this.f11892j.setTextColor(color);
            this.f11893k.setTextColor(color);
            this.f11894l.setTextColor(color);
            this.f11895m.setTextColor(color);
            this.f11896n.setTextColor(color);
            this.f11905w.setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[]{-16842913}}, new int[]{ContextCompat.getColor(requireContext(), R$color.xF2E1D6_50), ContextCompat.getColor(requireContext(), R$color.x3A342E)}));
            this.f11905w.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.k2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f12566a.j0(view2);
                }
            });
            this.A.setOnTouchListener(new View.OnTouchListener() { // from class: com.uz.navee.ui.device.l2
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return this.f12575a.k0(view2, motionEvent);
                }
            });
            this.B.setOnTouchListener(new View.OnTouchListener() { // from class: com.uz.navee.ui.device.m2
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return this.f12586a.l0(view2, motionEvent);
                }
            });
            this.f11908z.setOnTouchListener(new View.OnTouchListener() { // from class: com.uz.navee.ui.device.n2
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return this.f12597a.m0(view2, motionEvent);
                }
            });
            this.C.setOnTouchListener(new View.OnTouchListener() { // from class: com.uz.navee.ui.device.o2
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return this.f12605a.n0(view2, motionEvent);
                }
            });
            this.D.setOnTouchListener(new View.OnTouchListener() { // from class: com.uz.navee.ui.device.v1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return this.f12678a.o0(view2, motionEvent);
                }
            });
            if (this.H == null) {
                ArrayList arrayList = new ArrayList();
                this.H = arrayList;
                arrayList.add(this.A);
                this.H.add(this.B);
                this.H.add(this.C);
                this.H.add(this.D);
                this.H.add(this.f11908z);
            }
            this.E.setCurrentSection(b4.a.W().f1931d.getDrivingMode());
            SlideProgressView slideProgressView = this.E;
            slideProgressView.f12423g = true;
            slideProgressView.setCallBack(new SlideProgressView.b() { // from class: com.uz.navee.ui.device.f2
                @Override // com.uz.navee.ui.device.SlideProgressView.b
                public /* synthetic */ void a() {
                    f8.a(this);
                }

                @Override // com.uz.navee.ui.device.SlideProgressView.b
                public final void b(int i6) throws IOException {
                    this.f12512a.M0(i6);
                }

                @Override // com.uz.navee.ui.device.SlideProgressView.b
                public /* synthetic */ void c(int i6, boolean z6) {
                    f8.b(this, i6, z6);
                }
            });
            if (com.uz.navee.utils.d.o()) {
                this.f11892j.setTextSize(24.0f);
                this.f11893k.setTextSize(15.0f);
                this.f11894l.setTextSize(12.0f);
                this.f11903u.setTextSize(24.0f);
                this.f11904v.setTextSize(15.0f);
                this.f11902t.setTextSize(12.0f);
                this.f11900r.setTextSize(12.0f);
                this.f11906x.setTextSize(15.0f);
                this.f11895m.setTextSize(18.0f);
            } else {
                this.f11892j.setTextSize(22.0f);
                this.f11893k.setTextSize(13.0f);
                this.f11894l.setTextSize(10.0f);
                this.f11903u.setTextSize(22.0f);
                this.f11904v.setTextSize(13.0f);
                this.f11902t.setTextSize(10.0f);
                this.f11900r.setTextSize(10.0f);
                this.f11906x.setTextSize(13.0f);
                this.f11895m.setTextSize(16.0f);
            }
            I0();
            U();
        } else {
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.I);
            }
        }
        r0();
        return this.I;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        J0();
        T();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(this.Z);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (b4.a.f(this.f11875a)) {
            b4.a.W().R(this.f11875a, requireContext());
        }
        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(this.Z, new IntentFilter("BleReadFirmwareSuccessNotification"));
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Intent intent = new Intent("BleDeviceAfterNotification");
        intent.putExtra("vehicle", this.f11877b);
        intent.putExtra("bleDevice", this.f11875a);
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent);
        z0();
    }

    public final /* synthetic */ void p0(WarnConfig warnConfig, View view) {
        Intent intent = new Intent(getActivity(), (Class<?>) GaojingDetailActivity.class);
        intent.putExtra("config", warnConfig);
        startActivity(intent);
    }

    public final boolean t0(View view, MotionEvent motionEvent, int i6) throws IOException {
        FragmentActivity activity = getActivity();
        int action = motionEvent.getAction();
        if (action == 0) {
            view.setAlpha(0.5f);
            if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).P(30);
            }
            P0(i6);
        } else if (action == 1 || action == 3) {
            view.setAlpha(1.0f);
            Q0(i6);
            for (int i7 = 0; i7 < this.H.size(); i7++) {
                ImageButton imageButton = (ImageButton) this.H.get(i7);
                if (imageButton.getAlpha() == 0.5f && !imageButton.equals(view)) {
                    P0(this.U[i7]);
                }
            }
        }
        return false;
    }
}
