package com.uz.navee.ui.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.common.PlaybackException;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.dash.DashMediaSource;
import com.clj.fastble.data.BleDevice;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lxj.xpopup.core.BasePopupView;
import com.uz.navee.MyApplication;
import com.uz.navee.R$drawable;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.bean.VehicleModel;
import com.uz.navee.ui.data.UserVehicleHelper;
import com.uz.navee.ui.device.ExoPlayerPopup;
import com.uz.navee.utils.e0;
import d4.d;
import e3.a;
import java.util.ArrayList;
import java.util.List;
import s0.b;

/* loaded from: classes3.dex */
public class DeviceFragment extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public View f12078a;

    /* renamed from: b, reason: collision with root package name */
    public FragmentManager f12079b;

    /* renamed from: c, reason: collision with root package name */
    public DeviceCategoryFragment f12080c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f12082e;

    /* renamed from: d, reason: collision with root package name */
    public final io.reactivex.disposables.a f12081d = new io.reactivex.disposables.a();

    /* renamed from: f, reason: collision with root package name */
    public final BroadcastReceiver f12083f = new a();

    /* renamed from: g, reason: collision with root package name */
    public final BroadcastReceiver f12084g = new b();

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Vehicle vehicle = (Vehicle) intent.getSerializableExtra("vehicle");
            if (vehicle != null) {
                DeviceFragment.this.o(vehicle);
            } else {
                DeviceFragment.this.l();
            }
        }
    }

    public class b extends BroadcastReceiver {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MyApplication.f11588e.g0();
            }
        }

        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
            if (bleDevice != null) {
                b4.a.S(b4.a.r(bleDevice));
                DeviceFragment.this.l();
                DeviceFragment.this.t(b4.a.s(bleDevice));
                new Handler(Looper.getMainLooper()).postDelayed(new a(), 500L);
            }
        }
    }

    public class c implements d.h {

        public class a extends TypeToken<HttpResponse<ArrayList<VehicleModel>>> {
            public a() {
            }
        }

        public c() {
        }

        @Override // d4.d.h
        public void a(String str) {
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse == null || httpResponse.getCode() != 200) {
                return;
            }
            b4.a.N((ArrayList) httpResponse.getData());
        }

        @Override // d4.d.h
        public void b(Exception exc) {
        }
    }

    public class d extends e0.a {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f12090c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ VehicleModel f12091d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f12092e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ExoPlayerPopup.VideoType f12093f;

        public class a extends i3.d {
            public a() {
            }

            @Override // i3.e
            public void h(BasePopupView basePopupView) {
                com.uz.navee.utils.e0.f().e(d.this.f13279b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i6, String str, Context context, VehicleModel vehicleModel, String str2, ExoPlayerPopup.VideoType videoType) {
            super(i6, str);
            this.f12090c = context;
            this.f12091d = vehicleModel;
            this.f12092e = str2;
            this.f12093f = videoType;
        }

        @Override // java.lang.Runnable
        public void run() {
            new a.C0192a(this.f12090c).f(false).g(Boolean.TRUE).e(Boolean.FALSE).l(new a()).a(new ExoPlayerPopup(this.f12090c, this.f12091d.video, this.f12092e, this.f12093f)).G();
        }
    }

    public class e extends e0.a {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f12096c;

        public class a extends i3.d {
            public a() {
            }

            @Override // i3.e
            public void h(BasePopupView basePopupView) {
                com.uz.navee.utils.e0.f().e(e.this.f13279b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i6, String str, String str2) {
            super(i6, str);
            this.f12096c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            new a.C0192a(DeviceFragment.this.requireContext()).f(false).g(Boolean.TRUE).h(true).k((int) (com.uz.navee.utils.d.g(DeviceFragment.this.requireActivity()) * 0.82d)).e(Boolean.FALSE).l(new a()).a(new DriveGuidePopup(DeviceFragment.this.requireContext(), this.f12096c)).G();
        }
    }

    private void k() {
        d4.d.h().f(e4.a.a() + "/vehicle/model", new c());
    }

    public boolean f() {
        return this.f12082e;
    }

    public final boolean g() {
        p0.a.n().u(MyApplication.c());
        if (!p0.a.n().z()) {
            ((BaseActivity) requireActivity()).J(getString(R$string.bluetoothUnavailable_unknown));
            return false;
        }
        p0.a.n().e(false).F(1).I(3, 5000L).J(148).E(DashMediaSource.DEFAULT_FALLBACK_TARGET_LIVE_OFFSET_MS).H(PlaybackException.ERROR_CODE_DRM_UNSPECIFIED);
        p0.a.n().v(new b.a().c(Renderer.DEFAULT_DURATION_TO_PROGRESS_US).b());
        return true;
    }

    public BleDevice h() {
        Fragment fragmentFindFragmentById = this.f12079b.findFragmentById(R$id.fragment_container);
        if (fragmentFindFragmentById instanceof DeviceAfterFragment) {
            return ((DeviceAfterFragment) fragmentFindFragmentById).p0();
        }
        if (fragmentFindFragmentById instanceof DeviceAfterGolfFragment) {
            return ((DeviceAfterGolfFragment) fragmentFindFragmentById).S();
        }
        return null;
    }

    public void i() {
        if (getActivity() == null || this.f12079b == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) requireView().findViewById(R$id.category_container);
        if (frameLayout.getVisibility() == 0) {
            this.f12079b.beginTransaction().hide(this.f12080c).commit();
            frameLayout.setVisibility(8);
        }
        ((FragmentContainerView) requireView().findViewById(R$id.fragment_container)).setVisibility(0);
        this.f12082e = false;
    }

    public final /* synthetic */ void j(List list, Throwable th) {
        n();
    }

    public final void l() {
        this.f12081d.b(UserVehicleHelper.f11680a.i().m(new r4.b() { // from class: com.uz.navee.ui.device.w3
            @Override // r4.b
            public final void accept(Object obj, Object obj2) {
                this.f12689a.j((List) obj, (Throwable) obj2);
            }
        }));
    }

    public final void m() {
        u();
        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(this.f12084g, new IntentFilter("BleBindSuccessNotification"));
        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(this.f12083f, new IntentFilter("BleDeviceChangedNotification"));
    }

    public final void n() {
        ArrayList arrayListE = b4.a.e();
        if (arrayListE.isEmpty()) {
            p();
            return;
        }
        String strL = b4.a.L();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i7 < arrayListE.size()) {
                String str = ((Vehicle) arrayListE.get(i7)).mac;
                if (str != null && str.equals(strL)) {
                    i6 = i7;
                    break;
                }
                i7++;
            } else {
                break;
            }
        }
        o((Vehicle) arrayListE.get(i6));
    }

    public final void o(Vehicle vehicle) {
        FragmentManager fragmentManager;
        if (getActivity() == null || (fragmentManager = this.f12079b) == null) {
            return;
        }
        Fragment fragmentFindFragmentById = fragmentManager.findFragmentById(R$id.fragment_container);
        if (fragmentFindFragmentById instanceof DeviceAfterFragment) {
            ((DeviceAfterFragment) fragmentFindFragmentById).z1();
        } else if (fragmentFindFragmentById instanceof DeviceAfterGolfFragment) {
            ((DeviceAfterGolfFragment) fragmentFindFragmentById).J0();
        }
        if (p0.a.n() != null) {
            for (BleDevice bleDevice : p0.a.n().f()) {
                if (!vehicle.mac.equals(b4.a.r(bleDevice))) {
                    b4.a.m(bleDevice, getActivity());
                }
            }
        }
        FragmentTransaction fragmentTransactionBeginTransaction = this.f12079b.beginTransaction();
        if (b4.d.d(vehicle.model.pid)) {
            fragmentTransactionBeginTransaction.replace(R$id.fragment_container, DeviceAfterGolfFragment.u0(vehicle));
            MyApplication.f11588e.f0(R$id.navigation_device, R$drawable.ic_tab_golf);
        } else {
            fragmentTransactionBeginTransaction.replace(R$id.fragment_container, DeviceAfterFragment.h1(vehicle));
            MyApplication.f11588e.f0(R$id.navigation_device, R$drawable.ic_tab_device);
        }
        fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.f12078a;
        if (view == null) {
            this.f12078a = layoutInflater.inflate(R$layout.fragment_device, viewGroup, false);
            this.f12079b = getChildFragmentManager();
            r();
            if (g()) {
                k();
                l();
            }
        } else {
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.f12078a);
            }
        }
        return this.f12078a;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f12081d.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        m();
    }

    public final void p() {
        FragmentManager fragmentManager;
        if (getActivity() == null || (fragmentManager = this.f12079b) == null) {
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.replace(R$id.fragment_container, new DeviceBeforeFragment());
        fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
        b4.a.n(getActivity());
    }

    public void q() {
        if (getActivity() == null || this.f12079b == null) {
            return;
        }
        if (getChildFragmentManager().findFragmentByTag("DeviceCategoryFragment") == null) {
            if (this.f12080c == null) {
                this.f12080c = new DeviceCategoryFragment();
            }
            getChildFragmentManager().beginTransaction().add(R$id.category_container, this.f12080c, "DeviceCategoryFragment").hide(this.f12080c).commit();
        } else {
            DeviceCategoryFragment deviceCategoryFragment = (DeviceCategoryFragment) getChildFragmentManager().findFragmentByTag("DeviceCategoryFragment");
            this.f12080c = deviceCategoryFragment;
            if (deviceCategoryFragment != null) {
                deviceCategoryFragment.m();
            }
        }
        if (this.f12080c != null) {
            ((FragmentContainerView) requireView().findViewById(R$id.fragment_container)).setVisibility(8);
            FrameLayout frameLayout = (FrameLayout) requireView().findViewById(R$id.category_container);
            if (frameLayout.getVisibility() == 8) {
                this.f12079b.beginTransaction().show(this.f12080c).commit();
                frameLayout.setVisibility(0);
            }
            this.f12082e = true;
        }
    }

    public final void r() {
        FragmentManager fragmentManager;
        if (getActivity() == null || (fragmentManager = this.f12079b) == null) {
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.replace(R$id.fragment_container, new Fragment());
        fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
    }

    public void s(String str) {
        com.uz.navee.utils.e0.f().a(new e(10, "showWebDriveGuide", str));
    }

    public final void t(String str) {
        String string;
        ExoPlayerPopup.VideoType videoType;
        VehicleModel vehicleModelX = b4.a.x(str);
        Context context = getContext();
        if (context == null || vehicleModelX == null) {
            return;
        }
        String str2 = vehicleModelX.video;
        String str3 = vehicleModelX.imgTxt;
        if (vehicleModelX.guideType == 2) {
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            s(str3);
        } else {
            if (str2 == null || str2.isEmpty()) {
                return;
            }
            if (b4.d.d(str)) {
                string = getString(R$string.usage_guidelines);
                videoType = ExoPlayerPopup.VideoType.golfGuide;
            } else {
                string = getString(R$string.driving_guide);
                videoType = ExoPlayerPopup.VideoType.drivingGuide;
            }
            com.uz.navee.utils.e0.f().a(new d(10, "showVideoDriveGuide", context, vehicleModelX, string, videoType));
        }
    }

    public final void u() {
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(this.f12084g);
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(this.f12083f);
    }
}
