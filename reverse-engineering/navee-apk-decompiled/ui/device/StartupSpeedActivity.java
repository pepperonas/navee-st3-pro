package com.uz.navee.ui.device;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseBindingActivity;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.bean.VehicleModel;
import com.uz.navee.ble.SKUVersion;
import com.uz.navee.databinding.ActivityStartupSpeedBinding;
import com.uz.navee.utils.CommonExt;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class StartupSpeedActivity extends BaseBindingActivity<ActivityStartupSpeedBinding> {

    /* renamed from: j, reason: collision with root package name */
    public static final a f12447j = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public final kotlin.f f12448g = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.StartupSpeedActivity$isMph$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Boolean> invoke() {
            return Transformations.map(CommonExt.k(this.this$0, Integer.valueOf(b4.a.W().f1933f.getMileageUnit()), "mileageUnit"), new q5.l() { // from class: com.uz.navee.ui.device.StartupSpeedActivity$isMph$2.1
                public final Boolean invoke(int i6) {
                    return Boolean.valueOf(i6 == 0);
                }

                @Override // q5.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }
            });
        }
    });

    /* renamed from: h, reason: collision with root package name */
    public final kotlin.f f12449h = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.StartupSpeedActivity$startSpeed$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Integer> invoke() {
            return CommonExt.l(this.this$0.getLifecycle(), Integer.valueOf(b4.a.W().f1933f.getStartSpeed()), "startSpeed");
        }
    });

    /* renamed from: i, reason: collision with root package name */
    public int f12450i = 3;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.r rVar) {
            this();
        }

        public final String a(int i6) {
            return i6 != 0 ? i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? ExifInterface.GPS_MEASUREMENT_3D : "2.4" : "1.8" : "1.2" : "0.6" : "0";
        }
    }

    public static final class b implements Observer, kotlin.jvm.internal.u {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q5.l f12451a;

        public b(q5.l function) {
            kotlin.jvm.internal.y.f(function, "function");
            this.f12451a = function;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.u)) {
                return kotlin.jvm.internal.y.a(getFunctionDelegate(), ((kotlin.jvm.internal.u) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.u
        public final kotlin.c getFunctionDelegate() {
            return this.f12451a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f12451a.invoke(obj);
        }
    }

    private final LiveData h0() {
        return (LiveData) this.f12449h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0() {
        ((ActivityStartupSpeedBinding) Q()).rbZero.setText(g0(0));
        ((ActivityStartupSpeedBinding) Q()).rbOne.setText(g0(1));
        ((ActivityStartupSpeedBinding) Q()).rbTwo.setText(g0(2));
        ((ActivityStartupSpeedBinding) Q()).rbThree.setText(g0(3));
        ((ActivityStartupSpeedBinding) Q()).rbFour.setText(g0(4));
        ((ActivityStartupSpeedBinding) Q()).rbFive.setText(g0(5));
    }

    private final LiveData j0() {
        return (LiveData) this.f12448g.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0034 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void k0(com.uz.navee.ui.device.StartupSpeedActivity r11, android.widget.RadioGroup r12, int r13) throws java.io.IOException {
        /*
            java.lang.String r12 = "this$0"
            kotlin.jvm.internal.y.f(r11, r12)
            int r12 = com.uz.navee.R$id.rb_zero
            r0 = 2
            r1 = 1
            if (r13 != r12) goto Le
            r12 = 0
        Lc:
            r4 = r12
            goto L28
        Le:
            int r12 = com.uz.navee.R$id.rb_one
            if (r13 != r12) goto L14
            r4 = r1
            goto L28
        L14:
            int r12 = com.uz.navee.R$id.rb_two
            if (r13 != r12) goto L1a
            r4 = r0
            goto L28
        L1a:
            int r12 = com.uz.navee.R$id.rb_three
            if (r13 != r12) goto L20
            r12 = 3
            goto Lc
        L20:
            int r12 = com.uz.navee.R$id.rb_four
            if (r13 != r12) goto L26
            r12 = 4
            goto Lc
        L26:
            r12 = 5
            goto Lc
        L28:
            b4.a r12 = b4.a.W()
            com.uz.navee.bean.DeviceCarInfo r12 = r12.f1933f
            int r12 = r12.getStartSpeed()
            if (r4 != r12) goto L35
            return
        L35:
            if (r4 == 0) goto L3c
            if (r4 == r1) goto L3c
            if (r4 == r0) goto L3c
            goto L58
        L3c:
            int r12 = com.uz.navee.R$string.action_prompt
            java.lang.String r6 = r11.getString(r12)
            int r12 = com.uz.navee.R$string.p_action_prompt_msg
            java.lang.String r7 = r11.getString(r12)
            int r12 = com.uz.navee.R$string.i_see
            java.lang.String r9 = r11.getString(r12)
            com.uz.navee.ui.device.n8 r10 = new com.uz.navee.ui.device.n8
            r10.<init>()
            r8 = 0
            r5 = r11
            com.uz.navee.ui.wheel.AlertPopup.Q(r5, r6, r7, r8, r9, r10)
        L58:
            r6 = 4
            r7 = 0
            r3 = 106(0x6a, float:1.49E-43)
            r5 = 0
            r2 = r11
            com.uz.navee.base.BaseBindingActivity.Y(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uz.navee.ui.device.StartupSpeedActivity.k0(com.uz.navee.ui.device.StartupSpeedActivity, android.widget.RadioGroup, int):void");
    }

    public static final void l0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(int i6) {
        ActivityStartupSpeedBinding activityStartupSpeedBinding = (ActivityStartupSpeedBinding) Q();
        RadioButton radioButton = i6 != 0 ? i6 != 1 ? i6 != 2 ? i6 != 4 ? i6 != 5 ? activityStartupSpeedBinding.rbThree : activityStartupSpeedBinding.rbFive : activityStartupSpeedBinding.rbFour : activityStartupSpeedBinding.rbTwo : activityStartupSpeedBinding.rbOne : activityStartupSpeedBinding.rbZero;
        kotlin.jvm.internal.y.e(radioButton, "run(...)");
        radioButton.setChecked(true);
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public int V() {
        return R$layout.activity_startup_speed;
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public String b0() {
        String string = getString(R$string.startup_speed_settings);
        kotlin.jvm.internal.y.e(string, "getString(...)");
        return string;
    }

    public final String g0(int i6) {
        String str;
        if (CommonExt.j((Boolean) j0().getValue())) {
            str = f12447j.a(i6) + getString(R$string.unit_speed_imperial);
        } else {
            str = i6 + getString(R$string.unit_speed_metric);
        }
        if (i6 != this.f12450i) {
            return str;
        }
        String string = getString(R$string.default_str);
        kotlin.jvm.internal.y.e(string, "getString(...)");
        return str + " (" + string + ")";
    }

    @Override // com.uz.navee.base.BaseBindingActivity, com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        VehicleModel vehicleModel;
        super.onCreate(bundle);
        Vehicle vehicleU = U();
        if (!b4.d.i((vehicleU == null || (vehicleModel = vehicleU.model) == null) ? null : vehicleModel.pid)) {
            Vehicle vehicleU2 = U();
            if ((vehicleU2 != null ? vehicleU2.skuVersion() : null) == SKUVersion.USA) {
                RadioButton rbZero = ((ActivityStartupSpeedBinding) Q()).rbZero;
                kotlin.jvm.internal.y.e(rbZero, "rbZero");
                rbZero.setVisibility(0);
                RadioButton rbOne = ((ActivityStartupSpeedBinding) Q()).rbOne;
                kotlin.jvm.internal.y.e(rbOne, "rbOne");
                rbOne.setVisibility(0);
                RadioButton rbTwo = ((ActivityStartupSpeedBinding) Q()).rbTwo;
                kotlin.jvm.internal.y.e(rbTwo, "rbTwo");
                rbTwo.setVisibility(0);
            }
        }
        ((ActivityStartupSpeedBinding) Q()).rgSpeed.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.m8
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i6) throws IOException {
                StartupSpeedActivity.k0(this.f12593a, radioGroup, i6);
            }
        });
        j0().observe(this, new b(new q5.l() { // from class: com.uz.navee.ui.device.StartupSpeedActivity.onCreate.2
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return kotlin.u.f15726a;
            }

            public final void invoke(Boolean bool) {
                StartupSpeedActivity.this.i0();
            }
        }));
        h0().observe(this, new b(new q5.l() { // from class: com.uz.navee.ui.device.StartupSpeedActivity.onCreate.3
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return kotlin.u.f15726a;
            }

            public final void invoke(Integer num) {
                StartupSpeedActivity startupSpeedActivity = StartupSpeedActivity.this;
                kotlin.jvm.internal.y.c(num);
                startupSpeedActivity.m0(num.intValue());
            }
        }));
    }
}
