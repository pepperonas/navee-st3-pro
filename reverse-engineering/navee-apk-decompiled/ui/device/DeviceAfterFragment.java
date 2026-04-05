package com.uz.navee.ui.device;

import android.R;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewKt;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.exoplayer.ExoPlayer;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.data.BleScanState;
import com.clj.fastble.exception.BleException;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lxj.xpopup.core.BasePopupView;
import com.qmuiteam.qmui.widget.QMUIEmptyView;
import com.uz.navee.MainActivity;
import com.uz.navee.MyApplication;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.bean.DeviceCarInfo;
import com.uz.navee.bean.DeviceHomePageInfo;
import com.uz.navee.bean.DfuResponseData;
import com.uz.navee.bean.DfuVerInfo;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.bean.PetGameInfo;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.bean.VehicleModel;
import com.uz.navee.bean.WarnConfig;
import com.uz.navee.ble.AreaCode;
import com.uz.navee.ble.SKUVersion;
import com.uz.navee.ui.data.WeatherUpdater;
import com.uz.navee.ui.device.DeviceAfterFragment;
import com.uz.navee.ui.device.EnergyRecoveryPopup;
import com.uz.navee.ui.device.FirmwareUpdatePopup;
import com.uz.navee.ui.device.LightControlPopup;
import com.uz.navee.ui.device.MileageAlgorithmPopup;
import com.uz.navee.ui.device.SlideLockView;
import com.uz.navee.ui.mine.GaojingDetailActivity;
import com.uz.navee.ui.web.WebActivity;
import com.uz.navee.ui.wheel.AlertPopup;
import com.uz.navee.utils.CommonExt;
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

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class DeviceAfterFragment extends Fragment {
    public ImageButton A;
    public TextView B;
    public ImageButton C;
    public TextView D;
    public View E;
    public ImageView F;
    public TextView G;
    public ImageView H;
    public ImageView I;
    public ImageView J;
    public NestedScrollView L;
    public TextView M;
    public TextView Q;
    public View R;
    public Runnable T;
    public String U;

    /* renamed from: a, reason: collision with root package name */
    public BleDevice f11784a;

    /* renamed from: b, reason: collision with root package name */
    public Vehicle f11786b;

    /* renamed from: c, reason: collision with root package name */
    public LinearLayout f11788c;

    /* renamed from: d, reason: collision with root package name */
    public LinearLayout f11790d;

    /* renamed from: d0, reason: collision with root package name */
    public PropertyChangeListener f11791d0;

    /* renamed from: e, reason: collision with root package name */
    public TextView f11792e;

    /* renamed from: e0, reason: collision with root package name */
    public PropertyChangeListener f11793e0;

    /* renamed from: f, reason: collision with root package name */
    public ImageButton f11794f;

    /* renamed from: f0, reason: collision with root package name */
    public PropertyChangeListener f11795f0;

    /* renamed from: g, reason: collision with root package name */
    public QMUIEmptyView f11796g;

    /* renamed from: g0, reason: collision with root package name */
    public PropertyChangeListener f11797g0;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f11798h;

    /* renamed from: h0, reason: collision with root package name */
    public PropertyChangeListener f11799h0;

    /* renamed from: i, reason: collision with root package name */
    public TextView f11800i;

    /* renamed from: i0, reason: collision with root package name */
    public PropertyChangeListener f11801i0;

    /* renamed from: j, reason: collision with root package name */
    public TextView f11802j;

    /* renamed from: j0, reason: collision with root package name */
    public PropertyChangeListener f11803j0;

    /* renamed from: k, reason: collision with root package name */
    public TextView f11804k;

    /* renamed from: k0, reason: collision with root package name */
    public PropertyChangeListener f11805k0;

    /* renamed from: l, reason: collision with root package name */
    public TextView f11806l;

    /* renamed from: l0, reason: collision with root package name */
    public PropertyChangeListener f11807l0;

    /* renamed from: m, reason: collision with root package name */
    public LinearLayout f11808m;

    /* renamed from: m0, reason: collision with root package name */
    public PropertyChangeListener f11809m0;

    /* renamed from: n, reason: collision with root package name */
    public ImageButton f11810n;

    /* renamed from: n0, reason: collision with root package name */
    public PropertyChangeListener f11811n0;

    /* renamed from: o, reason: collision with root package name */
    public TextView f11812o;

    /* renamed from: o0, reason: collision with root package name */
    public PropertyChangeListener f11813o0;

    /* renamed from: p, reason: collision with root package name */
    public LinearLayout f11814p;

    /* renamed from: p0, reason: collision with root package name */
    public PropertyChangeListener f11815p0;

    /* renamed from: q, reason: collision with root package name */
    public ImageButton f11816q;

    /* renamed from: r, reason: collision with root package name */
    public TextView f11817r;

    /* renamed from: s, reason: collision with root package name */
    public LinearLayout f11818s;

    /* renamed from: t, reason: collision with root package name */
    public ImageButton f11819t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f11820u;

    /* renamed from: v, reason: collision with root package name */
    public LinearLayout f11821v;

    /* renamed from: w, reason: collision with root package name */
    public ImageButton f11822w;

    /* renamed from: x, reason: collision with root package name */
    public TextView f11823x;

    /* renamed from: y, reason: collision with root package name */
    public SlideLockView f11824y;

    /* renamed from: z, reason: collision with root package name */
    public TextView f11825z;
    public boolean S = false;
    public final BroadcastReceiver V = new b();
    public final BroadcastReceiver W = new c();
    public final BroadcastReceiver X = new d();
    public final BroadcastReceiver Y = new e();
    public final BroadcastReceiver Z = new f();

    /* renamed from: a0, reason: collision with root package name */
    public final BroadcastReceiver f11785a0 = new g();

    /* renamed from: b0, reason: collision with root package name */
    public final BroadcastReceiver f11787b0 = new i();

    /* renamed from: c0, reason: collision with root package name */
    public final BroadcastReceiver f11789c0 = new k();

    public class a implements SlideLockView.d {

        /* renamed from: com.uz.navee.ui.device.DeviceAfterFragment$a$a, reason: collision with other inner class name */
        public class C0160a implements AlertPopup.a {
            public C0160a() {
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public void a() {
                DeviceAfterFragment.this.f11824y.h();
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public void b() {
            }
        }

        public class b implements AlertPopup.a {
            public b() {
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public void a() {
                DeviceAfterFragment.this.f11824y.h();
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public void b() {
            }
        }

        public a() {
        }

        @Override // com.uz.navee.ui.device.SlideLockView.d
        public void a(boolean z6) throws IOException {
            DeviceAfterFragment deviceAfterFragment = DeviceAfterFragment.this;
            deviceAfterFragment.f11825z.setText(deviceAfterFragment.getString(R$string.one_click_unlock));
            if (z6) {
                FragmentActivity activity = DeviceAfterFragment.this.getActivity();
                float realTimeSpeed = b4.a.W().f1932e.getRealTimeSpeed();
                if (b4.a.W().f1932e.getVersion() == 1) {
                    realTimeSpeed = (float) (realTimeSpeed / 10.0d);
                }
                if (b4.a.W().f1932e.getDrivingStatus() != 0 || realTimeSpeed > 3.0f) {
                    if (activity == null) {
                        return;
                    }
                    AlertPopup.Q(activity, DeviceAfterFragment.this.getString(R$string.kind_tips), DeviceAfterFragment.this.getString(R$string.lock_driving_msg), null, DeviceAfterFragment.this.getString(R$string.i_see), new C0160a());
                } else if (b4.a.W().f1931d.getWarningCode() != 0) {
                    if (activity == null) {
                        return;
                    }
                    AlertPopup.Q(activity, DeviceAfterFragment.this.getString(R$string.kind_tips), DeviceAfterFragment.this.getString(R$string.lock_warning_msg), null, DeviceAfterFragment.this.getString(R$string.i_see), new b());
                } else {
                    b4.a.c0(DeviceAfterFragment.this.f11784a, b4.a.k(81, 1, false));
                    if (activity instanceof BaseActivity) {
                        ((BaseActivity) activity).O();
                    }
                }
            }
        }

        @Override // com.uz.navee.ui.device.SlideLockView.d
        public void b(boolean z6) throws IOException {
            DeviceAfterFragment deviceAfterFragment = DeviceAfterFragment.this;
            deviceAfterFragment.f11825z.setText(deviceAfterFragment.getString(R$string.one_click_lock));
            if (z6) {
                b4.a.c0(DeviceAfterFragment.this.f11784a, b4.a.k(81, 0, false));
                FragmentActivity activity = DeviceAfterFragment.this.getActivity();
                if (activity instanceof BaseActivity) {
                    ((BaseActivity) activity).O();
                }
            }
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws InterruptedException {
            BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
            if (bleDevice == null || DeviceAfterFragment.this.f11784a == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(DeviceAfterFragment.this.f11784a))) {
                return;
            }
            DeviceAfterFragment.this.j0();
        }
    }

    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws InterruptedException, IOException {
            int intExtra = intent.getIntExtra("accessType", 0);
            if (intExtra == 303) {
                DeviceAfterFragment.this.j0();
                return;
            }
            if (intExtra == 307) {
                if (DeviceAfterFragment.this.f11784a != null) {
                    b4.a.i(DeviceAfterFragment.this.getActivity(), DeviceAfterFragment.this.f11784a);
                }
            } else {
                if (intExtra != 308 || DeviceAfterFragment.this.f11784a == null) {
                    return;
                }
                b4.a.g(DeviceAfterFragment.this.getActivity(), DeviceAfterFragment.this.f11784a);
            }
        }
    }

    public class d extends BroadcastReceiver {
        public d() {
        }

        public final /* synthetic */ void b(BleDevice bleDevice) throws IOException {
            b4.a.i(DeviceAfterFragment.this.getActivity(), bleDevice);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws NumberFormatException {
            int intExtra = intent.getIntExtra("errorCode", 0);
            final BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
            String strR = b4.a.r(bleDevice);
            if (bleDevice == null || DeviceAfterFragment.this.f11786b == null || !Objects.equals(DeviceAfterFragment.this.f11786b.mac, strR)) {
                return;
            }
            if (intExtra != 0) {
                DeviceAfterFragment.this.r0();
                return;
            }
            DeviceAfterFragment.this.f11784a = bleDevice;
            b4.a.S(strR);
            DeviceAfterFragment.this.m0();
            DeviceAfterFragment.this.o1();
            DeviceAfterFragment.this.i0();
            String str = DeviceAfterFragment.this.f11786b.model.pid;
            if (b4.d.g(str) || b4.d.b(str) || str.startsWith("2436") || str.startsWith("2438") || str.startsWith("2437") || str.startsWith("2611") || str.startsWith("2612") || str.startsWith("2643")) {
                DeviceAfterFragment.this.T = new Runnable() { // from class: com.uz.navee.ui.device.s1
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        this.f12643a.b(bleDevice);
                    }
                };
                new Handler(Looper.getMainLooper()).postDelayed(DeviceAfterFragment.this.T, 1000L);
            }
        }
    }

    public class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Vehicle vehicle = (Vehicle) intent.getSerializableExtra("vehicle");
            if (vehicle != null) {
                DeviceAfterFragment.this.D1(vehicle);
                Intent intent2 = new Intent("BleDeviceAfterNotification");
                intent2.putExtra("vehicle", vehicle);
                intent2.putExtra("bleDevice", DeviceAfterFragment.this.f11784a);
                LocalBroadcastManager.getInstance(DeviceAfterFragment.this.requireContext()).sendBroadcast(intent2);
            }
        }
    }

    public class f extends BroadcastReceiver {
        public f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws InterruptedException {
            BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
            if (bleDevice == null || DeviceAfterFragment.this.f11784a == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(DeviceAfterFragment.this.f11784a))) {
                return;
            }
            String stringExtra = intent.getStringExtra("carSN");
            if (stringExtra != null && b4.a.h(stringExtra)) {
                if (DeviceAfterFragment.this.f11786b.carNo == null || !DeviceAfterFragment.this.f11786b.carNo.equals(stringExtra)) {
                    DeviceAfterFragment.this.N1(stringExtra);
                }
                DeviceAfterFragment.this.f11786b.carNo = stringExtra;
                DeviceAfterFragment.this.r1();
                DeviceAfterFragment.this.t1();
                return;
            }
            if (DeviceAfterFragment.this.S) {
                try {
                    Thread.sleep(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                    DeviceAfterFragment.this.n1();
                    DeviceAfterFragment.this.S = false;
                } catch (InterruptedException e7) {
                    throw new RuntimeException(e7);
                }
            }
        }
    }

    public class g extends BroadcastReceiver {
        public g() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
            if (bleDevice == null || DeviceAfterFragment.this.f11784a == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(DeviceAfterFragment.this.f11784a))) {
                return;
            }
            DeviceAfterFragment.this.e1(intent.getStringExtra("meterVersion"), intent.getStringExtra("bldcVersion"), intent.getStringExtra("bmsVersion"), intent.getStringExtra("screenVersion"));
        }
    }

    public class h implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11835a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f11836b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f11837c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f11838d;

        public class a extends TypeToken<HttpResponse<DfuResponseData>> {
            public a() {
            }
        }

        public class b extends e0.a {

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11841c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11842d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11843e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11844f;

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ StringBuilder f11845g;

            /* renamed from: h, reason: collision with root package name */
            public final /* synthetic */ long f11846h;

            /* renamed from: i, reason: collision with root package name */
            public final /* synthetic */ String f11847i;

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ StringBuilder f11848j;

            public class a implements FirmwareUpdatePopup.a {
                public a() {
                }

                @Override // com.uz.navee.ui.device.FirmwareUpdatePopup.a
                public void a(BasePopupView basePopupView) {
                    if (!b4.a.f(DeviceAfterFragment.this.f11784a)) {
                        Toast.makeText(DeviceAfterFragment.this.requireActivity(), R$string.ble_disconnect_alert, 1).show();
                        return;
                    }
                    if (b4.a.W().f1931d.getBatteryCharge() < 20) {
                        Toast.makeText(DeviceAfterFragment.this.requireActivity(), R$string.low_battery_alert, 1).show();
                        return;
                    }
                    float realTimeSpeed = b4.a.W().f1932e.getRealTimeSpeed();
                    if (b4.a.W().f1932e.getVersion() == 1) {
                        realTimeSpeed = (float) (realTimeSpeed / 10.0d);
                    }
                    if (b4.a.W().f1932e.getDrivingStatus() != 0 || realTimeSpeed > 3.0f) {
                        Toast.makeText(DeviceAfterFragment.this.requireActivity(), R$string.driving_alert, 1).show();
                        return;
                    }
                    Intent intent = new Intent(DeviceAfterFragment.this.requireContext(), (Class<?>) DeviceFirmwareUpdateActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("bleDevice", DeviceAfterFragment.this.f11784a);
                    bundle.putSerializable("vehicle", DeviceAfterFragment.this.f11786b);
                    bundle.putString("currentMeterVersion", h.this.f11835a);
                    bundle.putString("currentBldcVersion", h.this.f11836b);
                    bundle.putString("currentBmsVersion", h.this.f11837c);
                    bundle.putString("currentScreenVersion", h.this.f11838d);
                    bundle.putParcelableArrayList("meterVersionList", b.this.f11841c);
                    bundle.putParcelableArrayList("bldcVersionList", b.this.f11842d);
                    bundle.putParcelableArrayList("bmsVersionList", b.this.f11843e);
                    bundle.putParcelableArrayList("screenVersionList", b.this.f11844f);
                    bundle.putLong("serverVersionTime", b.this.f11846h);
                    intent.putExtra("data", bundle);
                    DeviceAfterFragment.this.startActivity(intent);
                    basePopupView.m();
                }

                @Override // com.uz.navee.ui.device.FirmwareUpdatePopup.a
                public void b() {
                    b bVar = b.this;
                    com.uz.navee.utils.g0.f(bVar.f11847i, bVar.f11848j.toString());
                }
            }

            /* renamed from: com.uz.navee.ui.device.DeviceAfterFragment$h$b$b, reason: collision with other inner class name */
            public class C0161b extends i3.d {
                public C0161b() {
                }

                @Override // i3.e
                public void h(BasePopupView basePopupView) {
                    com.uz.navee.utils.e0.f().e(b.this.f13279b);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(int i6, String str, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, StringBuilder sb, long j6, String str2, StringBuilder sb2) {
                super(i6, str);
                this.f11841c = arrayList;
                this.f11842d = arrayList2;
                this.f11843e = arrayList3;
                this.f11844f = arrayList4;
                this.f11845g = sb;
                this.f11846h = j6;
                this.f11847i = str2;
                this.f11848j = sb2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.C0192a c0192aL = new a.C0192a(DeviceAfterFragment.this.requireContext()).f(false).g(Boolean.TRUE).i((com.uz.navee.utils.d.g(DeviceAfterFragment.this.requireActivity()) * 2) / 3).e(Boolean.FALSE).l(new C0161b());
                Context contextRequireContext = DeviceAfterFragment.this.requireContext();
                Vehicle vehicle = DeviceAfterFragment.this.f11786b;
                h hVar = h.this;
                c0192aL.a(new FirmwareUpdatePopup(contextRequireContext, vehicle, hVar.f11835a, hVar.f11836b, hVar.f11837c, hVar.f11838d, this.f11841c, this.f11842d, this.f11843e, this.f11844f, this.f11845g.toString(), new a())).G();
            }
        }

        public h(String str, String str2, String str3, String str4) {
            this.f11835a = str;
            this.f11836b = str2;
            this.f11837c = str3;
            this.f11838d = str4;
        }

        @Override // d4.d.h
        public void a(String str) {
            boolean zIsReminder;
            if (DeviceAfterFragment.this.isAdded()) {
                HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
                if (httpResponse == null || httpResponse.getCode() != 200) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                ArrayList<DfuVerInfo> meterList = ((DfuResponseData) httpResponse.getData()).getMeterList();
                ArrayList<DfuVerInfo> bldcList = ((DfuResponseData) httpResponse.getData()).getBldcList();
                ArrayList<DfuVerInfo> bmsList = ((DfuResponseData) httpResponse.getData()).getBmsList();
                ArrayList<DfuVerInfo> screenList = ((DfuResponseData) httpResponse.getData()).getScreenList();
                String str2 = DeviceAfterFragment.this.f11786b.model.pid;
                if ((str2.startsWith("2417") || str2.startsWith("2422")) && this.f11835a.equals("2.0.0.5")) {
                    bmsList.clear();
                }
                if (str2.startsWith("2442") && DeviceAfterFragment.this.f11786b.areaCode() == AreaCode.US) {
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
                        sb2.append(DeviceAfterFragment.this.getString(R$string.meter));
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
                        sb2.append(DeviceAfterFragment.this.getString(R$string.bldc));
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
                        sb2.append(DeviceAfterFragment.this.getString(R$string.bms));
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
                        sb2.append(DeviceAfterFragment.this.getString(R$string.screen));
                        sb2.append("\n");
                        sb2.append(dfuVerInfo4.getContext());
                    }
                    zIsReminder = z6;
                }
                if (zIsReminder) {
                    String str3 = "ignore_firmware_version_" + g4.e1.u().f13674b + DeviceAfterFragment.this.f11786b.mac;
                    if (TextUtils.equals(com.uz.navee.utils.g0.d(str3), sb.toString())) {
                        return;
                    }
                    if (sb2.length() > 0) {
                        sb2.insert(0, DeviceAfterFragment.this.getString(R$string.update_notes) + ":\n");
                    }
                    com.uz.navee.utils.e0.f().a(new b(100, "showFirmwareUpdate", meterList, bldcList, bmsList, screenList, sb2, jCurrentTimeMillis, str3, sb));
                }
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
        }
    }

    public class i extends BroadcastReceiver {
        public i() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
            if (bleDevice == null || DeviceAfterFragment.this.f11784a == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(DeviceAfterFragment.this.f11784a))) {
                return;
            }
            DeviceAfterFragment.this.o0(bleDevice, intent.getIntExtra("errorCode", 0));
        }
    }

    public class j implements LightControlPopup.a {

        public class a implements Runnable {
            public a() {
            }

            public static /* synthetic */ void b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AlertPopup.Q(DeviceAfterFragment.this.getContext(), DeviceAfterFragment.this.getResources().getString(R$string.auto_sensor_on_title), DeviceAfterFragment.this.getResources().getString(R$string.auto_sensor_on_msg), null, DeviceAfterFragment.this.getResources().getString(R$string.i_see), new AlertPopup.a() { // from class: com.uz.navee.ui.device.t1
                    @Override // com.uz.navee.ui.wheel.AlertPopup.a
                    public /* synthetic */ void a() {
                        j4.c.a(this);
                    }

                    @Override // com.uz.navee.ui.wheel.AlertPopup.a
                    public final void b() {
                        DeviceAfterFragment.j.a.b();
                    }
                });
            }
        }

        public j() {
        }

        @Override // com.uz.navee.ui.device.LightControlPopup.a
        public void a(boolean z6) {
            DeviceAfterFragment.this.Q1(96, z6 ? 1 : 0);
        }

        @Override // com.uz.navee.ui.device.LightControlPopup.a
        public void b(boolean z6) {
            DeviceAfterFragment.this.Q1(87, z6 ? 1 : 0);
            if (z6) {
                new Handler(Looper.getMainLooper()).postDelayed(new a(), 500L);
            }
        }

        @Override // com.uz.navee.ui.device.LightControlPopup.a
        public void c(boolean z6) {
            DeviceAfterFragment.this.Q1(84, z6 ? 1 : 0);
        }
    }

    public class k extends BroadcastReceiver {
        public k() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            DeviceAfterFragment.this.m1();
        }
    }

    public class l implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        public float f11856a = 0.0f;

        /* renamed from: b, reason: collision with root package name */
        public float f11857b = 0.0f;

        public l() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f11856a = motionEvent.getX();
                this.f11857b = motionEvent.getY();
            }
            if (action == 2) {
                DeviceAfterFragment.this.L.requestDisallowInterceptTouchEvent(Math.abs(motionEvent.getX() - this.f11856a) > Math.abs(motionEvent.getY() - this.f11857b));
            }
            if (action == 1) {
                DeviceAfterFragment.this.f11824y.performClick();
                DeviceAfterFragment.this.L.requestDisallowInterceptTouchEvent(false);
            }
            return false;
        }
    }

    public class m implements d.h {

        public class a extends TypeToken<HttpResponse<Integer>> {
            public a() {
            }
        }

        public m() {
        }

        @Override // d4.d.h
        public void a(String str) {
            if (DeviceAfterFragment.this.isAdded()) {
                HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
                if (httpResponse == null || httpResponse.getCode() != 200) {
                    return;
                }
                ViewKt.setVisible(DeviceAfterFragment.this.Q, ((Integer) httpResponse.getData()).intValue() > 0);
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
        }
    }

    public class n implements d.h {

        public class a extends TypeToken<HttpResponse<PetGameInfo>> {
            public a() {
            }
        }

        public n() {
        }

        @Override // d4.d.h
        public void a(String str) {
            if (DeviceAfterFragment.this.isAdded()) {
                HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
                if (httpResponse == null || httpResponse.getCode() != 200 || httpResponse.getData() == null) {
                    return;
                }
                PetGameInfo petGameInfo = (PetGameInfo) httpResponse.getData();
                if (!petGameInfo.getFlag().booleanValue()) {
                    DeviceAfterFragment.this.M.setVisibility(8);
                    return;
                }
                DeviceAfterFragment.this.M.setVisibility(0);
                DeviceAfterFragment.this.U = petGameInfo.getUrl();
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
        }
    }

    public class o implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f11863a;

        public class a extends TypeToken<HttpResponse<ArrayList<WarnConfig>>> {
            public a() {
            }
        }

        public o(int i6) {
            this.f11863a = i6;
        }

        @Override // d4.d.h
        public void a(String str) {
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse != null && httpResponse.getCode() == 200) {
                b4.a.W().f1935h = (ArrayList) httpResponse.getData();
            }
            DeviceAfterFragment.this.F1(this.f11863a);
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            DeviceAfterFragment.this.F1(this.f11863a);
        }
    }

    public class p implements d.h {
        public p() {
        }

        @Override // d4.d.h
        public void a(String str) {
        }

        @Override // d4.d.h
        public void b(Exception exc) {
        }
    }

    public class q implements d.h {
        public q() {
        }

        @Override // d4.d.h
        public void a(String str) {
        }

        @Override // d4.d.h
        public void b(Exception exc) {
        }
    }

    public class r extends q0.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11868a;

        public r(String str) {
            this.f11868a = str;
        }

        @Override // q0.b
        public void c(BleDevice bleDevice, BleException bleException) throws IOException {
            f4.b.f("Connect mac fail (%s)，error = %s", bleDevice.getMac(), bleException.toString());
            DeviceAfterFragment.this.A1();
        }

        @Override // q0.b
        public void d(BleDevice bleDevice, BluetoothGatt bluetoothGatt, int i6) throws InterruptedException, IOException {
            f4.b.f("Connect mac success (%s)", bleDevice.getMac());
            b4.a.W().f1930c = DeviceAfterFragment.this.f11786b.shareUserId;
            DeviceAfterFragment.this.h0(bleDevice);
        }

        @Override // q0.b
        public void e(boolean z6, BleDevice bleDevice, BluetoothGatt bluetoothGatt, int i6) throws IOException {
            com.clj.fastble.bluetooth.b bVarP;
            f4.b.f("DisConnected mac (%s) isActive: (%b)", bleDevice.getMac(), Boolean.valueOf(z6));
            if (!z6 && (bVarP = p0.a.n().p()) != null) {
                bVarP.i(bVarP.d(bleDevice));
            }
            b4.a.W().f1930c = 0;
            DeviceAfterFragment.this.l1(z6, bleDevice);
            if (DeviceAfterFragment.this.getActivity() != null) {
                DeviceAfterFragment.this.r0();
            }
            b4.a.W().f1929b = false;
        }

        @Override // q0.b
        public void f() throws IOException {
            f4.b.f("Connect mac start (%s)", this.f11868a);
            DeviceAfterFragment.this.f11796g.k(true);
        }
    }

    public class s extends q0.g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean[] f11870a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f11871b;

        public class a extends q0.b {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BleDevice f11873a;

            public a(BleDevice bleDevice) {
                this.f11873a = bleDevice;
            }

            @Override // q0.b
            public void c(BleDevice bleDevice, BleException bleException) throws IOException {
                f4.b.f("Connect device fail (%s)，error = %s", b4.a.r(bleDevice), bleException.toString());
                if (DeviceAfterFragment.this.getActivity() != null) {
                    DeviceAfterFragment.this.r0();
                }
                b4.a.W().f1929b = false;
            }

            @Override // q0.b
            public void d(BleDevice bleDevice, BluetoothGatt bluetoothGatt, int i6) throws InterruptedException, IOException {
                f4.b.f("Connect device success (%s)", b4.a.r(bleDevice));
                b4.a.W().f1930c = DeviceAfterFragment.this.f11786b.shareUserId;
                DeviceAfterFragment.this.h0(bleDevice);
            }

            @Override // q0.b
            public void e(boolean z6, BleDevice bleDevice, BluetoothGatt bluetoothGatt, int i6) throws IOException {
                com.clj.fastble.bluetooth.b bVarP;
                f4.b.f("DisConnected device (%s)", b4.a.r(bleDevice));
                if (!z6 && (bVarP = p0.a.n().p()) != null) {
                    bVarP.i(bVarP.d(DeviceAfterFragment.this.f11784a));
                }
                b4.a.W().f1930c = 0;
                DeviceAfterFragment.this.l1(z6, bleDevice);
                if (DeviceAfterFragment.this.getActivity() != null) {
                    DeviceAfterFragment.this.r0();
                }
                b4.a.W().f1929b = false;
            }

            @Override // q0.b
            public void f() throws IOException {
                f4.b.f("Connect device start (%s)", b4.a.r(this.f11873a));
            }
        }

        public s(boolean[] zArr, String str) {
            this.f11870a = zArr;
            this.f11871b = str;
        }

        @Override // q0.h
        public void a(boolean z6) {
            f4.b.g("onScanStarted, b: " + z6, new Object[0]);
            DeviceAfterFragment.this.f11796g.k(true);
        }

        @Override // q0.h
        public void b(BleDevice bleDevice) throws InterruptedException {
            String name = bleDevice.getName();
            if (name == null) {
                name = "N/A";
            }
            if (name.startsWith("NAVEE") && Objects.equals(b4.a.r(bleDevice), this.f11871b)) {
                this.f11870a[0] = true;
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
            if (this.f11870a[0]) {
                return;
            }
            FragmentActivity activity = DeviceAfterFragment.this.getActivity();
            if (activity != null) {
                DeviceAfterFragment.this.r0();
                Toast.makeText(activity, DeviceAfterFragment.this.getString(R$string.ble_scan_nothing), 0).show();
            }
            b4.a.W().f1929b = false;
        }
    }

    public static /* synthetic */ void B0() {
    }

    private void C1() {
        this.f11804k.setTextDirection(3);
        if (com.uz.navee.utils.d.p(getActivity())) {
            this.f11802j.setCompoundDrawablesWithIntrinsicBounds(com.uz.navee.utils.d.q(ContextCompat.getDrawable(requireContext(), R$mipmap.ic_indicator_small)), (Drawable) null, (Drawable) null, (Drawable) null);
            Drawable drawableQ = com.uz.navee.utils.d.q(ContextCompat.getDrawable(requireContext(), R$mipmap.ic_arrow_right));
            Drawable drawableQ2 = com.uz.navee.utils.d.q(ContextCompat.getDrawable(requireContext(), R$mipmap.ic_arrow_right_gray));
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{R.attr.state_enabled}, drawableQ);
            stateListDrawable.addState(new int[]{-16842910}, drawableQ2);
            this.H.setImageDrawable(stateListDrawable);
        }
    }

    private void I1() {
        if (b4.a.f(this.f11784a)) {
            Intent intent = new Intent(getActivity(), (Class<?>) DriveHistoryActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("bleDevice", this.f11784a);
            bundle.putSerializable("vehicle", this.f11786b);
            intent.putExtra("data", bundle);
            startActivity(intent);
        }
    }

    private void L1(DeviceCarInfo deviceCarInfo) {
        deviceCarInfo.removeListener("ccsStatus", this.f11801i0);
        deviceCarInfo.removeListener("lockStatus", this.f11803j0);
        deviceCarInfo.removeListener("mileageAlgorithm", this.f11805k0);
        deviceCarInfo.removeListener("mileageUnit", this.f11807l0);
        deviceCarInfo.removeListener("tyreSwitch", this.f11809m0);
        deviceCarInfo.removeListener("ersStatus", this.f11811n0);
        deviceCarInfo.removeListener("breakSpeed", this.f11813o0);
        deviceCarInfo.removeListener("weather", this.f11815p0);
    }

    private void M1(DeviceHomePageInfo deviceHomePageInfo) {
        deviceHomePageInfo.removeListener("remainMileage", this.f11791d0);
        deviceHomePageInfo.removeListener("batteryCharge", this.f11793e0);
        deviceHomePageInfo.removeListener("warningCode", this.f11795f0);
        deviceHomePageInfo.removeListener("lockStatus", this.f11797g0);
        deviceHomePageInfo.removeListener("chargingState", this.f11799h0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(View view) throws InterruptedException {
        if (b4.a.f(this.f11784a)) {
            return;
        }
        j0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(View view) throws IOException {
        n0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0(View view) {
        u0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V0(View view) {
        d1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W0(View view) {
        K1();
    }

    private void g0(View view) {
        this.f11788c = (LinearLayout) view.findViewById(R$id.tyreWarningView);
        this.f11790d = (LinearLayout) view.findViewById(R$id.warningView);
        this.f11792e = (TextView) view.findViewById(R$id.warningTextView);
        this.f11794f = (ImageButton) view.findViewById(R$id.bluetoothStatusButton);
        this.f11796g = (QMUIEmptyView) view.findViewById(R$id.bluetoothConnectingView);
        this.f11798h = (ImageView) view.findViewById(R$id.deviceImageView);
        this.f11800i = (TextView) view.findViewById(R$id.mileageLabel);
        this.f11802j = (TextView) view.findViewById(R$id.mileageButton);
        this.f11804k = (TextView) view.findViewById(R$id.batteryLabel);
        this.f11806l = (TextView) view.findViewById(R$id.controlTextView);
        this.f11808m = (LinearLayout) view.findViewById(R$id.cruiseLayout);
        this.f11810n = (ImageButton) view.findViewById(R$id.cruiseButton);
        this.f11812o = (TextView) view.findViewById(R$id.cruiseTextView);
        this.f11814p = (LinearLayout) view.findViewById(R$id.energyLayout);
        this.f11816q = (ImageButton) view.findViewById(R$id.energyButton);
        this.f11817r = (TextView) view.findViewById(R$id.energyTextView);
        this.f11818s = (LinearLayout) view.findViewById(R$id.lightLayout);
        this.f11819t = (ImageButton) view.findViewById(R$id.lightButton);
        this.f11820u = (TextView) view.findViewById(R$id.lightTextView);
        this.f11821v = (LinearLayout) view.findViewById(R$id.unitLayout);
        this.f11822w = (ImageButton) view.findViewById(R$id.unitButton);
        this.f11823x = (TextView) view.findViewById(R$id.unitTextView);
        this.f11824y = (SlideLockView) view.findViewById(R$id.lockView);
        this.f11825z = (TextView) view.findViewById(R$id.lockTextView);
        this.A = (ImageButton) view.findViewById(R$id.infoButton);
        this.B = (TextView) view.findViewById(R$id.infoTextView);
        this.C = (ImageButton) view.findViewById(R$id.historyButton);
        this.D = (TextView) view.findViewById(R$id.historyTextView);
        this.E = view.findViewById(R$id.pluginLayout);
        this.F = (ImageView) view.findViewById(R$id.pluginIcon);
        this.G = (TextView) view.findViewById(R$id.pluginLabel);
        this.H = (ImageView) view.findViewById(R$id.indicator);
        this.I = (ImageView) view.findViewById(R$id.batteryChargeIcon);
        this.J = (ImageView) view.findViewById(R$id.batteryFill);
        this.L = (NestedScrollView) view.findViewById(R$id.scrollView);
        this.M = (TextView) view.findViewById(R$id.tv_pet);
        this.Q = (TextView) view.findViewById(R$id.tv_news);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(BleDevice bleDevice) throws InterruptedException {
        try {
            Thread.sleep(100L);
            b4.a.U(bleDevice, getContext());
        } catch (InterruptedException e7) {
            throw new RuntimeException(e7);
        }
    }

    public static DeviceAfterFragment h1(Vehicle vehicle) {
        DeviceAfterFragment deviceAfterFragment = new DeviceAfterFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("param1", vehicle);
        deviceAfterFragment.setArguments(bundle);
        return deviceAfterFragment;
    }

    private void i1(DeviceCarInfo deviceCarInfo) {
        this.f11810n.setSelected(b4.a.W().f1933f.getCcsStatus() != 0);
        this.f11801i0 = deviceCarInfo.addListener("ccsStatus", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.a1
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12463a.I0(propertyChangeEvent);
            }
        });
        u1(b4.a.W().f1933f.getLockStatus());
        this.f11803j0 = deviceCarInfo.addListener("lockStatus", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.b1
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12473a.J0(propertyChangeEvent);
            }
        });
        v1();
        this.f11805k0 = deviceCarInfo.addListener("mileageAlgorithm", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.c1
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12482a.K0(propertyChangeEvent);
            }
        });
        this.f11807l0 = deviceCarInfo.addListener("mileageUnit", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.d1
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12491a.L0(propertyChangeEvent);
            }
        });
        this.f11809m0 = deviceCarInfo.addListener("tyreSwitch", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.e1
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12500a.M0(propertyChangeEvent);
            }
        });
        s1();
        this.f11811n0 = deviceCarInfo.addListener("ersStatus", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.f1
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12511a.N0(propertyChangeEvent);
            }
        });
        this.f11813o0 = deviceCarInfo.addListener("breakSpeed", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.g1
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12522a.O0(propertyChangeEvent);
            }
        });
        this.f11815p0 = deviceCarInfo.addListener("weather", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.i1
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) throws IOException {
                this.f12546a.P0(propertyChangeEvent);
            }
        });
    }

    private void j1(final DeviceHomePageInfo deviceHomePageInfo) {
        v1();
        this.f11791d0 = deviceHomePageInfo.addListener("remainMileage", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.p0
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12612a.C0(propertyChangeEvent);
            }
        });
        q1();
        this.f11793e0 = deviceHomePageInfo.addListener("batteryCharge", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.q0
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12621a.D0(propertyChangeEvent);
            }
        });
        int warningCode = b4.a.W().f1931d.getWarningCode();
        if (warningCode != 0) {
            O1(warningCode, null);
        }
        x1(warningCode);
        this.f11795f0 = deviceHomePageInfo.addListener("warningCode", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.r0
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12631a.E0(propertyChangeEvent);
            }
        });
        u1(b4.a.W().f1931d.getLockStatus());
        this.f11797g0 = deviceHomePageInfo.addListener("lockStatus", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.s0
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12642a.F0(propertyChangeEvent);
            }
        });
        this.I.setVisibility(b4.a.W().f1931d.getChargingState() == 1 ? 0 : 8);
        this.f11799h0 = deviceHomePageInfo.addListener("chargingState", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.t0
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12654a.G0(propertyChangeEvent);
            }
        });
        CommonExt.o(getLifecycle(), Integer.valueOf(deviceHomePageInfo.getHideE9()), "hideE9").observe(getViewLifecycleOwner(), new Observer() { // from class: com.uz.navee.ui.device.u0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f12663a.H0(deviceHomePageInfo, (Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1() {
        if (b4.a.f(this.f11784a)) {
            b4.a.G(this.f11784a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1() {
        this.S = true;
        if (b4.a.f(this.f11784a)) {
            b4.a.H(this.f11784a);
        }
    }

    private void p1() {
        if (b4.a.f(this.f11784a)) {
            b4.a.I(this.f11784a);
        }
    }

    public final /* synthetic */ void A0() {
        P1(1);
    }

    public final void A1() {
        String str = this.f11786b.mac;
        if (str == null) {
            return;
        }
        if (s0.c.b().c() != BleScanState.STATE_IDLE) {
            p0.a.n().a();
        }
        p0.a.n().D(new s(new boolean[]{false}, str));
    }

    public final void B1(Boolean bool) {
        this.f11810n.setEnabled(bool.booleanValue());
        this.f11812o.setEnabled(bool.booleanValue());
        this.f11816q.setEnabled(bool.booleanValue());
        this.f11817r.setEnabled(bool.booleanValue());
        this.f11819t.setEnabled(bool.booleanValue());
        this.f11820u.setEnabled(bool.booleanValue());
    }

    public final /* synthetic */ void C0(PropertyChangeEvent propertyChangeEvent) {
        if ("remainMileage".equals(propertyChangeEvent.getPropertyName())) {
            v1();
        }
    }

    public final /* synthetic */ void D0(PropertyChangeEvent propertyChangeEvent) {
        if ("batteryCharge".equals(propertyChangeEvent.getPropertyName())) {
            q1();
        }
    }

    public void D1(Vehicle vehicle) {
        this.f11786b = vehicle;
    }

    public final /* synthetic */ void E0(PropertyChangeEvent propertyChangeEvent) {
        if ("warningCode".equals(propertyChangeEvent.getPropertyName())) {
            int iIntValue = ((Integer) propertyChangeEvent.getNewValue()).intValue();
            if (iIntValue != 0) {
                O1(iIntValue, null);
            }
            x1(iIntValue);
        }
    }

    public final void E1(int i6) {
        this.J.setVisibility(0);
        this.J.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        int intrinsicWidth = this.J.getDrawable().getIntrinsicWidth();
        float intrinsicHeight = this.J.getDrawable().getIntrinsicHeight();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight), new RectF(0.0f, 0.0f, (float) ((i6 * intrinsicWidth) / 100.0d), intrinsicHeight), Matrix.ScaleToFit.FILL);
        this.J.setImageMatrix(matrix);
    }

    public final /* synthetic */ void F0(PropertyChangeEvent propertyChangeEvent) {
        if ("lockStatus".equals(propertyChangeEvent.getPropertyName())) {
            u1(((Integer) propertyChangeEvent.getNewValue()).intValue());
        }
    }

    public final void F1(int i6) {
        if (i6 == 33 && b4.a.W().f1931d.getHideE9() == 1) {
            this.f11790d.setVisibility(8);
            return;
        }
        final WarnConfig warnConfigZ = b4.a.z(String.valueOf(i6));
        if (warnConfigZ == null) {
            this.f11790d.setVisibility(8);
            return;
        }
        this.f11790d.setVisibility(0);
        this.f11792e.setText(warnConfigZ.getName());
        this.f11792e.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.k1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12564a.c1(warnConfigZ, view);
            }
        });
    }

    public final /* synthetic */ void G0(PropertyChangeEvent propertyChangeEvent) {
        if ("chargingState".equals(propertyChangeEvent.getPropertyName())) {
            this.I.setVisibility(((Integer) propertyChangeEvent.getNewValue()).intValue() == 1 ? 0 : 8);
        }
    }

    public final void G1() {
        CommonExt.r(requireActivity(), AmbientLightV2Activity.class, this.f11784a, this.f11786b, null);
    }

    public final /* synthetic */ void H0(DeviceHomePageInfo deviceHomePageInfo, Integer num) {
        x1(deviceHomePageInfo.getWarningCode());
    }

    public final void H1() {
        if (b4.a.f(this.f11784a)) {
            Intent intent = new Intent(getActivity(), (Class<?>) DeviceInfoActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("bleDevice", this.f11784a);
            bundle.putSerializable("vehicle", this.f11786b);
            intent.putExtra("data", bundle);
            startActivity(intent);
        }
    }

    public final /* synthetic */ void I0(PropertyChangeEvent propertyChangeEvent) {
        if ("ccsStatus".equals(propertyChangeEvent.getPropertyName())) {
            this.f11810n.setSelected(((Integer) propertyChangeEvent.getNewValue()).intValue() != 0);
        }
    }

    public final /* synthetic */ void J0(PropertyChangeEvent propertyChangeEvent) {
        if ("lockStatus".equals(propertyChangeEvent.getPropertyName())) {
            u1(((Integer) propertyChangeEvent.getNewValue()).intValue());
        }
    }

    public final void J1() {
        CommonExt.r(requireActivity(), b4.d.i(this.f11786b.model.pid) ? DevicePluginsActivity.class : DeviceMoreActionActivity.class, this.f11784a, this.f11786b, null);
    }

    public final /* synthetic */ void K0(PropertyChangeEvent propertyChangeEvent) {
        if ("mileageAlgorithm".equals(propertyChangeEvent.getPropertyName())) {
            v1();
        }
    }

    public final void K1() {
        if (b4.a.f(this.f11784a)) {
            Intent intent = new Intent(getActivity(), (Class<?>) DeviceMileageUnitActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("bleDevice", this.f11784a);
            intent.putExtra("data", bundle);
            startActivity(intent);
        }
    }

    public final /* synthetic */ void L0(PropertyChangeEvent propertyChangeEvent) {
        if ("mileageUnit".equals(propertyChangeEvent.getPropertyName())) {
            v1();
        }
    }

    public final /* synthetic */ void M0(PropertyChangeEvent propertyChangeEvent) {
        if ("tyreSwitch".equals(propertyChangeEvent.getPropertyName())) {
            w1(((Integer) propertyChangeEvent.getNewValue()).intValue());
        }
    }

    public final /* synthetic */ void N0(PropertyChangeEvent propertyChangeEvent) {
        if ("ersStatus".equals(propertyChangeEvent.getPropertyName())) {
            s1();
        }
    }

    public final void N1(String str) {
        HashMap map = new HashMap();
        map.put("mac", this.f11786b.mac);
        map.put("carNo", str);
        d4.d.h().g(e4.a.a() + "/vehicle/updateVehicle", map, new q());
    }

    public final /* synthetic */ void O0(PropertyChangeEvent propertyChangeEvent) {
        if ("weather".equals(propertyChangeEvent.getPropertyName())) {
            r1();
        }
    }

    public final void O1(int i6, Location location) {
        if (this.f11786b == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("mac", this.f11786b.mac);
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
        d4.d.h().g(e4.a.a() + "/uploadWarn", arrayList, new p());
    }

    public final /* synthetic */ void P0(PropertyChangeEvent propertyChangeEvent) throws IOException {
        if (b4.d.i(this.f11786b.model.pid) && "weather".equals(propertyChangeEvent.getPropertyName()) && (((Integer) propertyChangeEvent.getNewValue()).intValue() & 128) != 0) {
            WeatherUpdater.k().u(requireActivity(), this.f11784a);
        }
    }

    public final void P1(int i6) {
        if (b4.a.f(this.f11784a)) {
            b4.a.c0(this.f11784a, b4.a.k(83, i6, false));
        }
    }

    public final void Q1(int i6, int i7) {
        if (b4.a.f(this.f11784a)) {
            b4.a.c0(this.f11784a, b4.a.k(i6, i7, false));
        }
    }

    public final void R1(int i6) {
        if (b4.a.f(this.f11784a)) {
            b4.a.c0(this.f11784a, b4.a.k(86, i6, false));
        }
    }

    public final /* synthetic */ void S0(View view) {
        if (TextUtils.isEmpty(this.U)) {
            WebActivity.c0(requireContext(), "", "https://cg.naveetech.com", false, this.f11784a, this.f11786b);
        } else {
            WebActivity.c0(requireContext(), "", this.U, false, this.f11784a, this.f11786b);
        }
    }

    public final /* synthetic */ void T0(View view) {
        WebActivity.c0(requireContext(), "", "https://ou.naveetech.com", false, this.f11784a, this.f11786b);
    }

    public final /* synthetic */ void X0(View view) {
        H1();
    }

    public final /* synthetic */ void Y0(View view) {
        I1();
    }

    public final /* synthetic */ void Z0(View view) {
        g1();
    }

    public final /* synthetic */ void a1(View view) {
        J1();
    }

    public final /* synthetic */ void b1(View view) {
        k1();
    }

    public final /* synthetic */ void c1(WarnConfig warnConfig, View view) {
        Intent intent = new Intent(getActivity(), (Class<?>) GaojingDetailActivity.class);
        intent.putExtra("config", warnConfig);
        startActivity(intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006c A[PHI: r1
      0x006c: PHI (r1v7 boolean) = (r1v6 boolean), (r1v15 boolean), (r1v15 boolean), (r1v15 boolean) binds: [B:20:0x0042, B:26:0x0057, B:28:0x005f, B:30:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d1() {
        /*
            r12 = this;
            r12.m1()
            com.uz.navee.bean.Vehicle r0 = r12.f11786b
            com.uz.navee.bean.VehicleModel r0 = r0.model
            java.lang.String r0 = r0.pid
            boolean r1 = b4.d.i(r0)
            if (r1 == 0) goto L13
            r12.G1()
            return
        L13:
            java.lang.String r1 = "2332"
            boolean r1 = r0.startsWith(r1)
            java.lang.String r2 = "2422"
            java.lang.String r3 = "2417"
            r4 = 1
            r5 = 0
            if (r1 != 0) goto L30
            boolean r1 = r0.startsWith(r3)
            if (r1 != 0) goto L30
            boolean r1 = r0.startsWith(r2)
            if (r1 == 0) goto L2e
            goto L30
        L2e:
            r9 = r5
            goto L31
        L30:
            r9 = r4
        L31:
            com.uz.navee.bean.Vehicle r1 = r12.f11786b
            com.uz.navee.ble.SKUVersion r1 = r1.skuVersion()
            com.uz.navee.ble.SKUVersion r6 = com.uz.navee.ble.SKUVersion.ITA
            if (r1 != r6) goto L3d
            r1 = r4
            goto L3e
        L3d:
            r1 = r5
        L3e:
            boolean r6 = b4.d.f(r0)
            if (r6 == 0) goto L6c
            com.uz.navee.bean.Vehicle r1 = r12.f11786b
            com.uz.navee.ble.AreaCode r1 = r1.areaCode()
            com.uz.navee.ble.AreaCode r6 = com.uz.navee.ble.AreaCode.DE
            if (r1 != r6) goto L50
            r1 = r4
            goto L51
        L50:
            r1 = r5
        L51:
            java.lang.String r6 = "2573"
            boolean r6 = r0.startsWith(r6)
            if (r6 != 0) goto L6c
            java.lang.String r6 = "2634"
            boolean r6 = r0.startsWith(r6)
            if (r6 != 0) goto L6c
            java.lang.String r6 = "2623"
            boolean r6 = r0.startsWith(r6)
            if (r6 == 0) goto L6a
            goto L6c
        L6a:
            r10 = r5
            goto L6d
        L6c:
            r10 = r4
        L6d:
            boolean r3 = r0.startsWith(r3)
            if (r3 != 0) goto L7c
            boolean r0 = r0.startsWith(r2)
            if (r0 == 0) goto L7a
            goto L7c
        L7a:
            r8 = r1
            goto L89
        L7c:
            com.uz.navee.bean.Vehicle r0 = r12.f11786b
            com.uz.navee.ble.AreaCode r0 = r0.areaCode()
            com.uz.navee.ble.AreaCode r1 = com.uz.navee.ble.AreaCode.DE
            if (r0 != r1) goto L87
            goto L88
        L87:
            r4 = r5
        L88:
            r8 = r4
        L89:
            e3.a$a r0 = new e3.a$a
            android.content.Context r1 = r12.getContext()
            r0.<init>(r1)
            e3.a$a r0 = r0.f(r5)
            com.uz.navee.ui.device.LightControlPopup r1 = new com.uz.navee.ui.device.LightControlPopup
            android.content.Context r7 = r12.requireContext()
            com.uz.navee.ui.device.DeviceAfterFragment$j r11 = new com.uz.navee.ui.device.DeviceAfterFragment$j
            r11.<init>()
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11)
            com.lxj.xpopup.core.BasePopupView r0 = r0.a(r1)
            r0.G()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uz.navee.ui.device.DeviceAfterFragment.d1():void");
    }

    public final void e1(String str, String str2, String str3, String str4) {
        String str5 = e4.a.a() + "/vehicle/modelSoftware";
        d4.d dVarH = d4.d.h();
        HashMap map = new HashMap();
        map.put("vehicleModelId", String.valueOf(this.f11786b.model.id));
        map.put("meter", str);
        map.put("bldc", str2);
        map.put("bms", str3);
        map.put("screen", str4);
        dVarH.g(str5, map, new h(str, str2, str3, str4));
    }

    public final void f1() throws InterruptedException, NumberFormatException {
        if (getActivity() != null) {
            com.bumptech.glide.b.v(this).t(Uri.parse(this.f11786b.model.maxImg)).z0(this.f11798h);
        }
        String str = this.f11786b.carNo;
        if (str != null && !str.isEmpty()) {
            r1();
            t1();
        }
        if (this.f11784a == null) {
            for (BleDevice bleDevice : p0.a.n().f()) {
                if (Objects.equals(this.f11786b.mac, b4.a.r(bleDevice))) {
                    this.f11784a = bleDevice;
                }
            }
        }
        if (!b4.a.f(this.f11784a)) {
            j0();
        } else if (Objects.equals(this.f11786b.mac, b4.a.r(this.f11784a))) {
            m0();
        } else {
            q0();
            j0();
        }
    }

    public final void g1() {
        new a.C0192a(getContext()).f(false).a(new MileageAlgorithmPopup(requireContext(), this.f11786b, new MileageAlgorithmPopup.a() { // from class: com.uz.navee.ui.device.j1
            @Override // com.uz.navee.ui.device.MileageAlgorithmPopup.a
            public final void a(int i6) {
                this.f12556a.R1(i6);
            }
        })).G();
        m1();
    }

    public final void i0() {
        if (b4.d.i(this.f11786b.model.pid)) {
            d4.d.h().f(e4.a.a() + "/dev/e-pet", new n());
        }
    }

    public final void j0() throws InterruptedException {
        if (ContextCompat.checkSelfPermission(requireContext(), "android.permission.BLUETOOTH_SCAN") != -1) {
            if (p0.a.n().w()) {
                k0();
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
                k0();
            } else {
                MyApplication.f11588e.startActivityIfNeeded(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 303);
            }
        }
    }

    public final void k0() throws InterruptedException {
        try {
            Thread.sleep(100L);
            l0();
        } catch (InterruptedException e7) {
            throw new RuntimeException(e7);
        }
    }

    public final void k1() {
    }

    public final void l0() {
        r0();
        String validBluetoothAddress = this.f11786b.getValidBluetoothAddress();
        if (validBluetoothAddress == null) {
            return;
        }
        p0.a.n().c(validBluetoothAddress, new r(validBluetoothAddress));
    }

    public final void l1(boolean z6, BleDevice bleDevice) {
        if (!z6 && !(com.uz.navee.e.c().b() instanceof MainActivity) && getContext() != null) {
            Intent intent = new Intent("BleDisconnectNotification");
            intent.putExtra("bleDevice", bleDevice);
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent);
        }
        if (this.T != null) {
            new Handler(Looper.getMainLooper()).removeCallbacks(this.T);
            this.T = null;
        }
    }

    public final void m0() throws NumberFormatException {
        boolean z6 = true;
        this.f11794f.setSelected(true);
        this.f11796g.k(false);
        b4.a.W().R(this.f11784a, requireContext());
        this.f11810n.setEnabled(true);
        this.f11812o.setEnabled(true);
        this.f11816q.setEnabled(true);
        this.f11817r.setEnabled(true);
        this.f11819t.setEnabled(true);
        this.f11820u.setEnabled(true);
        this.f11822w.setEnabled(true);
        this.f11823x.setEnabled(true);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.uz.navee.ui.device.z0
            @Override // java.lang.Runnable
            public final void run() {
                this.f12717a.x0();
            }
        }, 1000L);
        this.f11825z.setEnabled(true);
        this.A.setEnabled(true);
        this.B.setEnabled(true);
        this.C.setEnabled(true);
        this.D.setEnabled(true);
        this.f11802j.setEnabled(true);
        this.E.setEnabled(true);
        this.F.setEnabled(true);
        this.G.setEnabled(true);
        this.H.setEnabled(true);
        this.f11800i.setEnabled(true);
        this.f11804k.setEnabled(true);
        this.f11806l.setEnabled(true);
        this.I.setVisibility(b4.a.W().f1931d.getChargingState() == 1 ? 0 : 8);
        u1(b4.a.W().f1933f.getLockStatus());
        this.f11810n.setSelected(b4.a.W().f1933f.getCcsStatus() != 0);
        ImageButton imageButton = this.f11816q;
        if (b4.d.i(this.f11786b.model.pid) && b4.a.W().f1933f.getErsStatus() != 1) {
            z6 = false;
        }
        imageButton.setSelected(z6);
        v1();
        q1();
        Intent intent = new Intent("BleDeviceAfterNotification");
        intent.putExtra("vehicle", this.f11786b);
        intent.putExtra("bleDevice", this.f11784a);
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent);
        TyreSettingReceiver.b(requireContext(), b4.a.r(this.f11784a));
    }

    public final void n0() throws IOException {
        if (!this.f11810n.isSelected()) {
            AlertPopup.P(getContext(), getString(R$string.cruise_control), getString(R$string.cruise_control_on_confirm), new AlertPopup.a() { // from class: com.uz.navee.ui.device.o0
                @Override // com.uz.navee.ui.wheel.AlertPopup.a
                public /* synthetic */ void a() {
                    j4.c.a(this);
                }

                @Override // com.uz.navee.ui.wheel.AlertPopup.a
                public final void b() throws IOException {
                    this.f12603a.y0();
                }
            });
            return;
        }
        this.f11810n.setClickable(false);
        b4.a.c0(this.f11784a, b4.a.k(82, 0, false));
    }

    public final void o0(BleDevice bleDevice, int i6) {
        if (bleDevice == null || this.f11784a == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(this.f11784a))) {
            return;
        }
        if (i6 == 0) {
            this.f11810n.setSelected(!r3.isSelected());
        }
        this.f11810n.setClickable(true);
        m1();
    }

    public void o1() {
        m1();
        n1();
        p1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f11786b = (Vehicle) getArguments().getSerializable("param1");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws InterruptedException, NumberFormatException {
        View view = this.R;
        if (view == null) {
            View viewInflate = layoutInflater.inflate(R$layout.fragment_device_after, viewGroup, false);
            this.R = viewInflate;
            g0(viewInflate);
            this.f11794f.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.l0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) throws InterruptedException {
                    this.f12573a.Q0(view2);
                }
            });
            this.f11810n.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.l1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) throws IOException {
                    this.f12574a.R0(view2);
                }
            });
            this.f11816q.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.m1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f12585a.U0(view2);
                }
            });
            this.f11819t.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.n1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f12596a.V0(view2);
                }
            });
            this.f11822w.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.o1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f12604a.W0(view2);
                }
            });
            this.f11824y.setCallback(new a());
            this.f11824y.setOnTouchListener(new l());
            this.A.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.p1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f12613a.X0(view2);
                }
            });
            this.C.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.q1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f12622a.Y0(view2);
                }
            });
            this.f11802j.setText("/ " + getString(R$string.mileage_algorithm_title));
            this.f11802j.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.r1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f12632a.Z0(view2);
                }
            });
            this.E.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.m0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f12584a.a1(view2);
                }
            });
            ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, new int[]{-16842910}}, new int[]{ContextCompat.getColor(requireContext(), R$color.xC69D7D), ContextCompat.getColor(requireContext(), R$color.xC69D7D_40)});
            this.f11812o.setTextColor(colorStateList);
            this.f11817r.setTextColor(colorStateList);
            this.f11820u.setTextColor(colorStateList);
            this.f11823x.setTextColor(colorStateList);
            this.B.setTextColor(colorStateList);
            this.D.setTextColor(colorStateList);
            int color = ContextCompat.getColor(requireContext(), R$color.xFAF4E8);
            ColorStateList colorStateList2 = new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, new int[]{-16842910}}, new int[]{color, ContextCompat.getColor(requireContext(), R$color.xFAF4E8_40)});
            this.f11825z.setTextColor(colorStateList2);
            this.G.setTextColor(colorStateList2);
            this.f11806l.setTextColor(colorStateList2);
            this.f11800i.setTextColor(color);
            this.f11802j.setTextColor(color);
            this.f11804k.setTextColor(color);
            if (com.uz.navee.utils.d.o()) {
                this.f11800i.setTextSize(24.0f);
                this.f11802j.setTextSize(12.0f);
                this.f11812o.setTextSize(12.0f);
                this.f11817r.setTextSize(12.0f);
                this.f11820u.setTextSize(12.0f);
                this.f11823x.setTextSize(12.0f);
                this.f11825z.setTextSize(12.0f);
                this.B.setTextSize(12.0f);
                this.D.setTextSize(12.0f);
                this.G.setTextSize(15.0f);
                this.f11806l.setTextSize(15.0f);
                this.f11804k.setTextSize(18.0f);
            } else {
                this.f11800i.setTextSize(22.0f);
                this.f11802j.setTextSize(10.0f);
                this.f11812o.setTextSize(10.0f);
                this.f11817r.setTextSize(10.0f);
                this.f11820u.setTextSize(10.0f);
                this.f11823x.setTextSize(10.0f);
                this.f11825z.setTextSize(10.0f);
                this.B.setTextSize(10.0f);
                this.D.setTextSize(10.0f);
                this.G.setTextSize(13.0f);
                this.f11806l.setTextSize(13.0f);
                this.f11804k.setTextSize(16.0f);
            }
            this.f11808m.setVisibility(8);
            this.f11788c.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.n0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f12595a.b1(view2);
                }
            });
            this.M.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.w0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f12686a.S0(view2);
                }
            });
            this.Q.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.h1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f12536a.T0(view2);
                }
            });
            y1();
            r0();
        } else {
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.R);
            }
        }
        if (b4.d.n(this.f11786b.model.pid)) {
            this.E.setVisibility(8);
        } else {
            this.E.setVisibility(0);
        }
        this.M.setVisibility(8);
        f1();
        C1();
        return this.R;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        z1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(this.f11785a0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (b4.a.f(this.f11784a)) {
            u1(b4.a.W().f1933f.getLockStatus());
            b4.a.W().R(this.f11784a, requireContext());
        }
        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(this.f11785a0, new IntentFilter("BleReadFirmwareSuccessNotification"));
        v0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Intent intent = new Intent("BleDeviceAfterNotification");
        intent.putExtra("vehicle", this.f11786b);
        intent.putExtra("bleDevice", this.f11784a);
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent);
        m1();
    }

    public BleDevice p0() {
        return this.f11784a;
    }

    public void q0() {
        p0.a aVarN = p0.a.n();
        if (b4.a.f(this.f11784a)) {
            aVarN.d(this.f11784a);
        }
    }

    public final void q1() {
        if (b4.a.f(this.f11784a)) {
            int batteryCharge = b4.a.W().f1931d.getBatteryCharge();
            s0(String.valueOf(batteryCharge));
            E1(batteryCharge);
        }
    }

    public final void r0() {
        b4.a.W().Z();
        this.f11794f.setSelected(false);
        this.f11796g.k(false);
        this.f11810n.setEnabled(false);
        this.f11812o.setEnabled(false);
        this.f11816q.setEnabled(false);
        this.f11817r.setEnabled(false);
        this.f11819t.setEnabled(false);
        this.f11820u.setEnabled(false);
        this.f11822w.setEnabled(false);
        this.f11823x.setEnabled(false);
        this.f11824y.setEnabled(false);
        this.f11825z.setEnabled(false);
        this.A.setEnabled(false);
        this.B.setEnabled(false);
        this.C.setEnabled(false);
        this.D.setEnabled(false);
        this.f11802j.setEnabled(false);
        this.E.setEnabled(false);
        this.F.setEnabled(false);
        this.G.setEnabled(false);
        this.H.setEnabled(false);
        t0("--");
        this.f11800i.setEnabled(false);
        s0("--");
        this.f11804k.setEnabled(false);
        this.f11806l.setEnabled(false);
        this.I.setVisibility(8);
        this.J.setVisibility(8);
        this.f11824y.g();
        this.f11825z.setText(R$string.one_click_unlock);
    }

    public final void r1() {
        String str;
        Vehicle vehicle = this.f11786b;
        if (vehicle == null || (str = vehicle.model.pid) == null) {
            this.f11808m.setVisibility(8);
            return;
        }
        if (b4.d.i(str) || str.startsWith("2573") || str.startsWith("2634")) {
            this.f11808m.setVisibility(8);
        } else if (this.f11786b.skuVersion() == SKUVersion.USA || b4.a.W().f1933f.getBreakSpeed() == 1) {
            this.f11808m.setVisibility(0);
        } else {
            this.f11808m.setVisibility(8);
        }
    }

    public final void s0(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(18, true), 0, str.length(), 33);
        spannableStringBuilder.setSpan(new StyleSpan(0), 0, str.length(), 33);
        spannableStringBuilder.append((CharSequence) "%");
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(12, true), str.length(), spannableStringBuilder.length(), 33);
        spannableStringBuilder.setSpan(new StyleSpan(0), str.length(), spannableStringBuilder.length(), 33);
        this.f11804k.setText(spannableStringBuilder);
    }

    public final void s1() {
        if (b4.d.i(this.f11786b.model.pid)) {
            this.f11816q.setSelected(b4.a.W().f1933f.getErsStatus() == 1);
        }
    }

    public final void t0(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(24, true), 0, str.length(), 33);
        spannableStringBuilder.setSpan(new StyleSpan(1), 0, str.length(), 33);
        String string = getString(R$string.unit_mileage_metric);
        if (b4.a.f(this.f11784a) && b4.a.W().f1933f.getMileageUnit() == 0) {
            string = getString(R$string.unit_mileage_imperial);
        }
        spannableStringBuilder.append((CharSequence) string);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(15, true), str.length(), spannableStringBuilder.length(), 33);
        spannableStringBuilder.setSpan(new StyleSpan(0), str.length(), spannableStringBuilder.length(), 33);
        this.f11800i.setText(spannableStringBuilder);
    }

    public final void t1() {
        this.f11818s.setVisibility(0);
        Vehicle vehicle = this.f11786b;
        if (vehicle != null) {
            if (vehicle.model.pid.startsWith("2332") && this.f11786b.skuVersion() == SKUVersion.ITA) {
                this.f11818s.setVisibility(8);
            }
            if ((this.f11786b.model.pid.startsWith("2417") || this.f11786b.model.pid.startsWith("2422")) && this.f11786b.areaCode() == AreaCode.DE) {
                this.f11818s.setVisibility(8);
            }
            if ((this.f11786b.model.pid.startsWith("2403") || this.f11786b.model.pid.startsWith("2345")) && this.f11786b.areaCode() == AreaCode.NL) {
                this.f11818s.setVisibility(8);
            }
        }
    }

    public final void u0() {
        if (!b4.d.i(this.f11786b.model.pid)) {
            new a.C0192a(getContext()).f(false).a(new EnergyRecoveryPopup(requireContext(), new EnergyRecoveryPopup.b() { // from class: com.uz.navee.ui.device.v0
                @Override // com.uz.navee.ui.device.EnergyRecoveryPopup.b
                public final void a(int i6) {
                    this.f12677a.z0(i6);
                }
            })).G();
            m1();
        } else if (b4.a.W().f1933f.getErsStatus() != 1) {
            AlertPopup.Q(requireContext(), getString(R$string.energy_recovery), getString(R$string.energy_recovery_on_confirm), getString(R$string.confirm), getString(R$string.cancel), new AlertPopup.a() { // from class: com.uz.navee.ui.device.x0
                @Override // com.uz.navee.ui.wheel.AlertPopup.a
                public /* synthetic */ void a() {
                    j4.c.a(this);
                }

                @Override // com.uz.navee.ui.wheel.AlertPopup.a
                public final void b() {
                    this.f12696a.A0();
                }
            });
        } else {
            AlertPopup.Q(requireContext(), getString(R$string.kind_tips), getString(R$string.energy_recovery_off_tips), null, getString(R$string.i_see), new AlertPopup.a() { // from class: com.uz.navee.ui.device.y0
                @Override // com.uz.navee.ui.wheel.AlertPopup.a
                public /* synthetic */ void a() {
                    j4.c.a(this);
                }

                @Override // com.uz.navee.ui.wheel.AlertPopup.a
                public final void b() {
                    DeviceAfterFragment.B0();
                }
            });
            P1(0);
        }
    }

    public final void u1(int i6) {
        if (b4.a.f(this.f11784a)) {
            if (i6 == 0) {
                this.f11824y.h();
                this.f11825z.setText(getString(R$string.one_click_lock));
                B1(Boolean.TRUE);
            } else {
                this.f11824y.g();
                this.f11825z.setText(R$string.one_click_unlock);
                B1(Boolean.FALSE);
            }
        }
        b4.a.W().f1929b = i6 == 0;
    }

    public final void v0() {
        VehicleModel vehicleModel;
        Vehicle vehicle = this.f11786b;
        if (vehicle == null || (vehicleModel = vehicle.model) == null || TextUtils.isEmpty(vehicleModel.pid)) {
            return;
        }
        d4.d.h().f(e4.a.a() + "/theme/count/" + this.f11786b.model.pid, new m());
    }

    public final void v1() {
        if (b4.a.f(this.f11784a)) {
            int remainMileage = b4.a.W().f1931d.getRemainMileage();
            if (b4.a.W().f1933f.getMileageUnit() == 0) {
                remainMileage = (int) Math.round(remainMileage * 0.621d);
            }
            t0(String.valueOf(remainMileage));
        }
    }

    public final void w0(int i6) {
        String str = e4.a.a() + "/getWarnCfg";
        if (this.f11786b != null) {
            str = str + "?category=" + this.f11786b.model.category;
        }
        d4.d.h().f(str, new o(i6));
    }

    public final void w1(int i6) {
        if (i6 == 0) {
            this.f11788c.setVisibility(8);
        } else {
            this.f11788c.setVisibility(0);
        }
    }

    public final /* synthetic */ void x0() {
        this.f11824y.setEnabled(true);
    }

    public final void x1(int i6) {
        if (i6 == 33 && b4.a.W().f1931d.getHideE9() == 1) {
            this.f11790d.setVisibility(8);
            return;
        }
        if (i6 == 0) {
            this.f11790d.setVisibility(8);
        } else if (b4.a.W().f1935h.isEmpty()) {
            w0(i6);
        } else {
            F1(i6);
        }
    }

    public final /* synthetic */ void y0() throws IOException {
        b4.a.c0(this.f11784a, b4.a.k(82, 1, false));
    }

    public final void y1() {
        z1();
        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(this.X, new IntentFilter("BleAuthCallbackNotification"));
        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(this.f11787b0, new IntentFilter("BleCruiseControlNotification"));
        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(this.f11789c0, new IntentFilter("BleLockControlCarNotification"));
        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(this.W, new IntentFilter("BleOpenNotification"));
        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(this.V, new IntentFilter("BleReconnectNotification"));
        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(this.Z, new IntentFilter("BleReadCarSNSuccessNotification"));
        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(this.Y, new IntentFilter("BleVehicleUpdateNotification"));
        j1(b4.a.W().f1931d);
        i1(b4.a.W().f1933f);
    }

    public final /* synthetic */ void z0(int i6) {
        if (i6 != 0) {
            P1(i6);
        }
    }

    public void z1() {
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(this.X);
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(this.f11787b0);
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(this.f11789c0);
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(this.W);
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(this.V);
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(this.Z);
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(this.Y);
        M1(b4.a.W().f1931d);
        L1(b4.a.W().f1933f);
    }
}
