package com.uz.navee.ui.device;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.os.BundleKt;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseBindingActivity;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.bean.ShareVehicle;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.bean.VehicleSharer;
import com.uz.navee.databinding.ActivityDeviceShareBinding;
import com.uz.navee.utils.CommonExt;
import d4.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class DeviceShareActivity extends BaseBindingActivity<ActivityDeviceShareBinding> {

    /* renamed from: g, reason: collision with root package name */
    public final List f12289g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final kotlin.f f12290h = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.DeviceShareActivity$adapter$2
        @Override // q5.a
        public final DeviceSharerAdapter invoke() {
            return new DeviceSharerAdapter(false);
        }
    });

    /* renamed from: i, reason: collision with root package name */
    public final ActivityResultLauncher f12291i = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.uz.navee.ui.device.o6
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            DeviceShareActivity.p0(this.f12608a, (ActivityResult) obj);
        }
    });

    /* renamed from: j, reason: collision with root package name */
    public int f12292j = 3;

    public static final class a implements d.h {

        /* renamed from: com.uz.navee.ui.device.DeviceShareActivity$a$a, reason: collision with other inner class name */
        public static final class C0170a extends TypeToken<HttpResponse<Integer>> {
        }

        public a() {
        }

        @Override // d4.d.h
        public void a(String json) {
            kotlin.jvm.internal.y.f(json, "json");
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(json, new C0170a().getType());
            if (httpResponse != null) {
                DeviceShareActivity deviceShareActivity = DeviceShareActivity.this;
                Object data = httpResponse.getData();
                kotlin.jvm.internal.y.e(data, "getData(...)");
                deviceShareActivity.f12292j = ((Number) data).intValue();
                deviceShareActivity.r0();
            }
        }

        @Override // d4.d.h
        public void b(Exception e7) {
            kotlin.jvm.internal.y.f(e7, "e");
        }
    }

    public static final class b implements d.h {

        public static final class a extends TypeToken<HttpResponse<List<? extends ShareVehicle>>> {
        }

        public b() {
        }

        @Override // d4.d.h
        public void a(String json) {
            kotlin.jvm.internal.y.f(json, "json");
            DeviceShareActivity.this.B();
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(json, new a().getType());
            if (httpResponse != null) {
                DeviceShareActivity deviceShareActivity = DeviceShareActivity.this;
                if (httpResponse.getCode() != 200) {
                    CommonExt.s(deviceShareActivity, httpResponse.getMsg());
                    return;
                }
                deviceShareActivity.f12289g.clear();
                List list = (List) httpResponse.getData();
                if (list != null) {
                    deviceShareActivity.f12289g.addAll(list);
                }
                DeviceSharerAdapter deviceSharerAdapterK0 = deviceShareActivity.k0();
                List<ShareVehicle> list2 = deviceShareActivity.f12289g;
                ArrayList arrayList = new ArrayList(kotlin.collections.u.u(list2, 10));
                for (ShareVehicle shareVehicle : list2) {
                    arrayList.add(new VehicleSharer(shareVehicle.getEmail(), shareVehicle.getHeadImg(), null, shareVehicle.getNaveeId(), shareVehicle.getNickName(), shareVehicle.getBindUserId(), shareVehicle.getBindUserName()));
                }
                deviceSharerAdapterK0.R(arrayList);
                deviceShareActivity.r0();
            }
        }

        @Override // d4.d.h
        public void b(Exception e7) {
            kotlin.jvm.internal.y.f(e7, "e");
            DeviceShareActivity.this.B();
            CommonExt.s(DeviceShareActivity.this, e7.getMessage());
        }
    }

    public static final class c implements d.h {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f12296b;

        public static final class a extends TypeToken<HttpResponse<Integer>> {
        }

        public c(int i6) {
            this.f12296b = i6;
        }

        @Override // d4.d.h
        public void a(String json) {
            kotlin.jvm.internal.y.f(json, "json");
            DeviceShareActivity.this.B();
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(json, new a().getType());
            if (httpResponse != null) {
                DeviceShareActivity deviceShareActivity = DeviceShareActivity.this;
                int i6 = this.f12296b;
                if (httpResponse.getCode() != 200) {
                    CommonExt.s(deviceShareActivity, httpResponse.getMsg());
                    return;
                }
                deviceShareActivity.f12289g.remove(i6);
                deviceShareActivity.k0().N(i6);
                deviceShareActivity.r0();
            }
        }

        @Override // d4.d.h
        public void b(Exception e7) {
            kotlin.jvm.internal.y.f(e7, "e");
            DeviceShareActivity.this.B();
            CommonExt.s(DeviceShareActivity.this, e7.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceSharerAdapter k0() {
        return (DeviceSharerAdapter) this.f12290h.getValue();
    }

    public static final void n0(DeviceShareActivity this$0, BaseQuickAdapter baseQuickAdapter, View view, int i6) {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        kotlin.jvm.internal.y.f(baseQuickAdapter, "<anonymous parameter 0>");
        kotlin.jvm.internal.y.f(view, "view");
        if (view.getId() == R$id.iv_remove) {
            this$0.q0(i6);
        }
    }

    public static final void o0(DeviceShareActivity this$0, View view) {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        if (this$0.f12289g.size() >= this$0.f12292j) {
            CommonExt.t(this$0, R$string.share_limited_msg);
            return;
        }
        ActivityResultLauncher activityResultLauncher = this$0.f12291i;
        Intent intent = new Intent(this$0, (Class<?>) AddDeviceSharerActivity.class);
        intent.putExtra("data", BundleKt.bundleOf(kotlin.k.a("vehicle", this$0.U())));
        activityResultLauncher.launch(intent);
    }

    public static final void p0(DeviceShareActivity this$0, ActivityResult result) {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        kotlin.jvm.internal.y.f(result, "result");
        if (result.getResultCode() == -1) {
            this$0.m0();
        }
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public int V() {
        return R$layout.activity_device_share;
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public String b0() {
        String string = getString(R$string.device_sharing);
        kotlin.jvm.internal.y.e(string, "getString(...)");
        return string;
    }

    public final void l0() {
        d4.d.h().f(e4.a.a() + "/shareVehicle/getShareVehicleNum", new a());
    }

    public final void m0() {
        K();
        String strA = e4.a.a();
        Vehicle vehicleU = U();
        d4.d.h().f(strA + "/shareVehicle/getShareVehicle?mac=" + (vehicleU != null ? vehicleU.mac : null), new b());
    }

    @Override // com.uz.navee.base.BaseBindingActivity, com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((ActivityDeviceShareBinding) Q()).rvList.setAdapter(k0());
        r0();
        k0().d(R$id.iv_remove);
        k0().setOnItemChildClickListener(new m0.b() { // from class: com.uz.navee.ui.device.m6
            @Override // m0.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i6) {
                DeviceShareActivity.n0(this.f12591a, baseQuickAdapter, view, i6);
            }
        });
        ((ActivityDeviceShareBinding) Q()).ivAdd.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.n6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeviceShareActivity.o0(this.f12600a, view);
            }
        });
        m0();
        l0();
    }

    public final void q0(int i6) {
        K();
        String id = ((ShareVehicle) this.f12289g.get(i6)).getId();
        d4.d.h().f(e4.a.a() + "/shareVehicle/unbindingShareVehicle?id=" + id, new c(i6));
    }

    public final void r0() {
        ((ActivityDeviceShareBinding) Q()).tvShareCount.setText(getString(R$string.shared_driver) + " (" + this.f12289g.size() + RemoteSettings.FORWARD_SLASH_STRING + this.f12292j + ")");
    }
}
