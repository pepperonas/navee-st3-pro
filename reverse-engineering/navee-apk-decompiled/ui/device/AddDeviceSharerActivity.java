package com.uz.navee.ui.device;

import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseBindingActivity;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.bean.VehicleModel;
import com.uz.navee.bean.VehicleSharer;
import com.uz.navee.databinding.ActivityAddDeviceSharerBinding;
import com.uz.navee.utils.CommonExt;
import d4.d;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;

/* loaded from: classes3.dex */
public final class AddDeviceSharerActivity extends BaseBindingActivity<ActivityAddDeviceSharerBinding> {

    /* renamed from: g, reason: collision with root package name */
    public final kotlin.f f11700g = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.AddDeviceSharerActivity$adapter$2
        @Override // q5.a
        public final DeviceSharerAdapter invoke() {
            return new DeviceSharerAdapter(true);
        }
    });

    /* renamed from: h, reason: collision with root package name */
    public final a f11701h = new a();

    public static final class a implements d.h {

        /* renamed from: com.uz.navee.ui.device.AddDeviceSharerActivity$a$a, reason: collision with other inner class name */
        public static final class C0158a extends TypeToken<HttpResponse<Integer>> {
        }

        public a() {
        }

        @Override // d4.d.h
        public void a(String json) {
            kotlin.jvm.internal.y.f(json, "json");
            AddDeviceSharerActivity.this.B();
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(json, new C0158a().getType());
            if (httpResponse != null) {
                AddDeviceSharerActivity addDeviceSharerActivity = AddDeviceSharerActivity.this;
                if (httpResponse.getCode() != 200) {
                    CommonExt.s(addDeviceSharerActivity, httpResponse.getMsg());
                    return;
                }
                CommonExt.t(addDeviceSharerActivity, R$string.device_share_success);
                addDeviceSharerActivity.setResult(-1);
                addDeviceSharerActivity.finish();
            }
        }

        @Override // d4.d.h
        public void b(Exception e7) {
            kotlin.jvm.internal.y.f(e7, "e");
            AddDeviceSharerActivity.this.B();
            CommonExt.s(AddDeviceSharerActivity.this, e7.getMessage());
        }
    }

    public static final class b implements d.h {

        public static final class a extends TypeToken<HttpResponse<List<? extends VehicleSharer>>> {
        }

        public b() {
        }

        @Override // d4.d.h
        public void a(String json) {
            kotlin.jvm.internal.y.f(json, "json");
            AddDeviceSharerActivity.this.B();
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(json, new a().getType());
            if (httpResponse != null) {
                AddDeviceSharerActivity addDeviceSharerActivity = AddDeviceSharerActivity.this;
                if (httpResponse.getCode() != 200) {
                    CommonExt.s(addDeviceSharerActivity, httpResponse.getMsg());
                    return;
                }
                addDeviceSharerActivity.j0().R((Collection) httpResponse.getData());
                Collection collection = (Collection) httpResponse.getData();
                if (collection != null && !collection.isEmpty()) {
                    Button btnOk = AddDeviceSharerActivity.g0(addDeviceSharerActivity).btnOk;
                    kotlin.jvm.internal.y.e(btnOk, "btnOk");
                    btnOk.setVisibility(0);
                } else {
                    CommonExt.s(addDeviceSharerActivity, addDeviceSharerActivity.getString(R$string.no_user_found));
                    Button btnOk2 = AddDeviceSharerActivity.g0(addDeviceSharerActivity).btnOk;
                    kotlin.jvm.internal.y.e(btnOk2, "btnOk");
                    btnOk2.setVisibility(8);
                }
            }
        }

        @Override // d4.d.h
        public void b(Exception e7) {
            kotlin.jvm.internal.y.f(e7, "e");
            AddDeviceSharerActivity.this.B();
            CommonExt.s(AddDeviceSharerActivity.this, e7.getMessage());
            Button btnOk = AddDeviceSharerActivity.g0(AddDeviceSharerActivity.this).btnOk;
            kotlin.jvm.internal.y.e(btnOk, "btnOk");
            btnOk.setVisibility(8);
        }
    }

    public static final /* synthetic */ ActivityAddDeviceSharerBinding g0(AddDeviceSharerActivity addDeviceSharerActivity) {
        return (ActivityAddDeviceSharerBinding) addDeviceSharerActivity.Q();
    }

    public static final void k0(AddDeviceSharerActivity this$0, View view) {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        Editable text = ((ActivityAddDeviceSharerBinding) this$0.Q()).etKeyword.getText();
        String string = text != null ? text.toString() : null;
        if (string == null || kotlin.text.s.s(string)) {
            com.uz.navee.utils.a.b(((ActivityAddDeviceSharerBinding) this$0.Q()).etKeyword);
            return;
        }
        this$0.n0(string);
        com.uz.navee.utils.t.b(((ActivityAddDeviceSharerBinding) this$0.Q()).etKeyword);
        ((ActivityAddDeviceSharerBinding) this$0.Q()).etKeyword.clearFocus();
        this$0.j0().R(null);
        Button btnOk = ((ActivityAddDeviceSharerBinding) this$0.Q()).btnOk;
        kotlin.jvm.internal.y.e(btnOk, "btnOk");
        btnOk.setVisibility(8);
    }

    public static final boolean l0(AddDeviceSharerActivity this$0, TextView textView, int i6, KeyEvent keyEvent) {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        if (i6 == 6) {
            f4.b.c("setOnEditorActionListener done", new Object[0]);
            ((ActivityAddDeviceSharerBinding) this$0.Q()).icSearch.performClick();
        }
        return false;
    }

    public static final void m0(AddDeviceSharerActivity this$0, View view) {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        int iX = this$0.j0().X();
        if (iX != -1) {
            this$0.i0((VehicleSharer) this$0.j0().p().get(iX));
        }
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public int V() {
        return R$layout.activity_add_device_sharer;
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public String b0() {
        String string = getString(R$string.shared_driver_add);
        kotlin.jvm.internal.y.e(string, "getString(...)");
        return string;
    }

    public final void i0(VehicleSharer vehicleSharer) {
        VehicleModel vehicleModel;
        K();
        d4.d dVarH = d4.d.h();
        String str = e4.a.a() + "/shareVehicle/bindShareVehicleByUser";
        Pair[] pairArr = new Pair[4];
        Vehicle vehicleU = U();
        Integer num = null;
        pairArr[0] = kotlin.k.a("mac", vehicleU != null ? vehicleU.mac : null);
        Vehicle vehicleU2 = U();
        if (vehicleU2 != null && (vehicleModel = vehicleU2.model) != null) {
            num = vehicleModel.id;
        }
        pairArr[1] = kotlin.k.a("vehicleId", num);
        pairArr[2] = kotlin.k.a("userId", vehicleSharer.getId());
        pairArr[3] = kotlin.k.a("email", vehicleSharer.getEmail());
        dVarH.g(str, kotlin.collections.o0.j(pairArr), this.f11701h);
    }

    public final DeviceSharerAdapter j0() {
        return (DeviceSharerAdapter) this.f11700g.getValue();
    }

    public final void n0(String str) {
        K();
        d4.d.h().f(e4.a.a() + "/shareVehicle/getShareUsers?keyword=" + str, new b());
    }

    @Override // com.uz.navee.base.BaseBindingActivity, com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((ActivityAddDeviceSharerBinding) Q()).rvList.setAdapter(j0());
        ((ActivityAddDeviceSharerBinding) Q()).icSearch.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddDeviceSharerActivity.k0(this.f12509a, view);
            }
        });
        ((ActivityAddDeviceSharerBinding) Q()).etKeyword.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.uz.navee.ui.device.g
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i6, KeyEvent keyEvent) {
                return AddDeviceSharerActivity.l0(this.f12520a, textView, i6, keyEvent);
            }
        });
        ((ActivityAddDeviceSharerBinding) Q()).btnOk.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddDeviceSharerActivity.m0(this.f12534a, view);
            }
        });
    }
}
