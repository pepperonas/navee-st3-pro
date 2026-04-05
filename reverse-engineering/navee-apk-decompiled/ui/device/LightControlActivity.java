package com.uz.navee.ui.device;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.clj.fastble.data.BleDevice;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseBindingActivity;
import com.uz.navee.bean.DeviceCarInfo;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.databinding.ActivityLightControlBinding;
import com.uz.navee.utils.CommonExt;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class LightControlActivity extends BaseBindingActivity<ActivityLightControlBinding> {

    /* renamed from: i, reason: collision with root package name */
    public static final a f12360i = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public final kotlin.f f12361g = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.LightControlActivity$lightType$2
        {
            super(0);
        }

        @Override // q5.a
        public final Integer invoke() {
            return Integer.valueOf(this.this$0.getIntent().getIntExtra("LIGHT_TYPE", 0));
        }
    });

    /* renamed from: h, reason: collision with root package name */
    public final kotlin.f f12362h = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.LightControlActivity$curState$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Integer> invoke() {
            DeviceCarInfo deviceCarInfo = b4.a.W().f1933f;
            int iG0 = this.this$0.g0();
            return iG0 != 2 ? iG0 != 3 ? CommonExt.l(this.this$0.getLifecycle(), Integer.valueOf(deviceCarInfo.getAmbientLight()), "ambientLight") : CommonExt.l(this.this$0.getLifecycle(), Integer.valueOf(deviceCarInfo.getDayRunLight()), "dayRunLight") : CommonExt.l(this.this$0.getLifecycle(), Integer.valueOf(deviceCarInfo.getLogoLight()), "logoLight");
        }
    });

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.r rVar) {
            this();
        }

        public final void a(Context context, int i6, BleDevice bleDevice, Vehicle vehicle) {
            kotlin.jvm.internal.y.f(context, "context");
            if (b4.a.f(bleDevice)) {
                Intent intent = new Intent(context, (Class<?>) LightControlActivity.class);
                intent.putExtra("LIGHT_TYPE", i6);
                CommonExt.q(intent, bleDevice, vehicle, null, 4, null);
                context.startActivity(intent);
            }
        }
    }

    public static final class b implements Observer, kotlin.jvm.internal.u {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q5.l f12363a;

        public b(q5.l function) {
            kotlin.jvm.internal.y.f(function, "function");
            this.f12363a = function;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.u)) {
                return kotlin.jvm.internal.y.a(getFunctionDelegate(), ((kotlin.jvm.internal.u) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.u
        public final kotlin.c getFunctionDelegate() {
            return this.f12363a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f12363a.invoke(obj);
        }
    }

    public static final /* synthetic */ ActivityLightControlBinding d0(LightControlActivity lightControlActivity) {
        return (ActivityLightControlBinding) lightControlActivity.Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int g0() {
        return ((Number) this.f12361g.getValue()).intValue();
    }

    public static final void h0(LightControlActivity this$0, RadioGroup radioGroup, int i6) throws IOException {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        int i7 = i6 == R$id.rb_open ? 1 : i6 == R$id.rb_follow ? 2 : 0;
        Integer num = (Integer) this$0.f0().getValue();
        if (num != null && i7 == num.intValue()) {
            return;
        }
        BaseBindingActivity.Z(this$0, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, new byte[]{(byte) this$0.g0(), (byte) i7}, false, 4, null);
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public int V() {
        return R$layout.activity_light_control;
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public String b0() {
        int iG0 = g0();
        String string = getString(iG0 != 2 ? iG0 != 3 ? R$string.ambient_light : R$string.light_run_day : R$string.light_logo);
        kotlin.jvm.internal.y.e(string, "getString(...)");
        return string;
    }

    public final LiveData f0() {
        return (LiveData) this.f12362h.getValue();
    }

    @Override // com.uz.navee.base.BaseBindingActivity, com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((ActivityLightControlBinding) Q()).rgControl.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.j7
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i6) throws IOException {
                LightControlActivity.h0(this.f12561a, radioGroup, i6);
            }
        });
        f0().observe(this, new b(new q5.l() { // from class: com.uz.navee.ui.device.LightControlActivity.onCreate.2
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return kotlin.u.f15726a;
            }

            public final void invoke(Integer num) {
                RadioButton radioButton = (num != null && num.intValue() == 1) ? LightControlActivity.d0(LightControlActivity.this).rbOpen : (num != null && num.intValue() == 2) ? LightControlActivity.d0(LightControlActivity.this).rbFollow : LightControlActivity.d0(LightControlActivity.this).rbClose;
                kotlin.jvm.internal.y.c(radioButton);
                radioButton.setChecked(true);
            }
        }));
    }
}
