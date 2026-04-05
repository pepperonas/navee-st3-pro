package com.uz.navee.ui.device;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseBindingActivity;
import com.uz.navee.bean.PickTime;
import com.uz.navee.databinding.ActivityChargingTimeBinding;
import com.uz.navee.ui.wheel.AlertPopup;
import com.uz.navee.utils.CommonExt;
import e3.a;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.collections.ArraysKt___ArraysKt;

/* loaded from: classes3.dex */
public final class ChargingTimeActivity extends BaseBindingActivity<ActivityChargingTimeBinding> {

    /* renamed from: g, reason: collision with root package name */
    public final kotlin.f f11772g = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.ChargingTimeActivity$timedOn$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Integer> invoke() {
            return CommonExt.l(this.this$0.getLifecycle(), Integer.valueOf(b4.a.W().f1933f.getTimedChargeOn()), "timedChargeOn");
        }
    });

    /* renamed from: h, reason: collision with root package name */
    public final kotlin.f f11773h = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.ChargingTimeActivity$startTime$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Long> invoke() {
            return CommonExt.l(this.this$0.getLifecycle(), Long.valueOf(b4.a.W().f1933f.getStartChargeTime()), "startChargeTime");
        }
    });

    public static final class a implements AlertPopup.a {
        public a() {
        }

        @Override // com.uz.navee.ui.wheel.AlertPopup.a
        public void a() {
            ChargingTimeActivity.this.q0(true);
        }

        @Override // com.uz.navee.ui.wheel.AlertPopup.a
        public void b() {
        }
    }

    public static final class b implements Observer, kotlin.jvm.internal.u {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q5.l f11775a;

        public b(q5.l function) {
            kotlin.jvm.internal.y.f(function, "function");
            this.f11775a = function;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.u)) {
                return kotlin.jvm.internal.y.a(getFunctionDelegate(), ((kotlin.jvm.internal.u) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.u
        public final kotlin.c getFunctionDelegate() {
            return this.f11775a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f11775a.invoke(obj);
        }
    }

    public static final /* synthetic */ ActivityChargingTimeBinding e0(ChargingTimeActivity chargingTimeActivity) {
        return (ActivityChargingTimeBinding) chargingTimeActivity.Q();
    }

    public static final void l0(ChargingTimeActivity this$0, View view) {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        if (((ActivityChargingTimeBinding) this$0.Q()).scTiming.isChecked()) {
            this$0.q0(false);
        }
    }

    public static final void m0(ChargingTimeActivity this$0, CompoundButton compoundButton, boolean z6) throws IOException {
        Integer num;
        kotlin.jvm.internal.y.f(this$0, "this$0");
        TextView tvTimingDes = ((ActivityChargingTimeBinding) this$0.Q()).tvTimingDes;
        kotlin.jvm.internal.y.e(tvTimingDes, "tvTimingDes");
        tvTimingDes.setVisibility(z6 ? 0 : 8);
        if (z6 && ((num = (Integer) this$0.k0().getValue()) == null || num.intValue() != 1)) {
            AlertPopup.Q(this$0, this$0.getResources().getString(R$string.kind_tips), this$0.getResources().getString(R$string.charging_time_setting_des), null, this$0.getResources().getString(R$string.i_see), this$0.new a());
        }
        this$0.p0(z6);
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public int V() {
        return R$layout.activity_charging_time;
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public String b0() {
        String string = getString(R$string.charging_time_setting);
        kotlin.jvm.internal.y.e(string, "getString(...)");
        return string;
    }

    public final LiveData j0() {
        return (LiveData) this.f11773h.getValue();
    }

    public final LiveData k0() {
        return (LiveData) this.f11772g.getValue();
    }

    public final void n0(PickTime pickTime) {
        ((ActivityChargingTimeBinding) Q()).tvTimingDes.setText(getString(R$string.charging_time_start) + "：" + pickTime.getTimeDes(this));
    }

    public final void o0(long j6) throws IOException {
        Long l6 = (Long) j0().getValue();
        if (l6 != null && l6.longValue() == j6) {
            return;
        }
        byte[] bArrO = com.uz.navee.utils.f.o(j6, true);
        kotlin.jvm.internal.y.e(bArrO, "toBytes(...)");
        BaseBindingActivity.Z(this, 111, kotlin.collections.m.w(new byte[]{3}, ArraysKt___ArraysKt.Q(bArrO, 4)), false, 4, null);
    }

    @Override // com.uz.navee.base.BaseBindingActivity, com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((ActivityChargingTimeBinding) Q()).clTiming.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChargingTimeActivity.l0(this.f12472a, view);
            }
        });
        ((ActivityChargingTimeBinding) Q()).scTiming.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.c0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) throws IOException {
                ChargingTimeActivity.m0(this.f12481a, compoundButton, z6);
            }
        });
        k0().observe(this, new b(new q5.l() { // from class: com.uz.navee.ui.device.ChargingTimeActivity.onCreate.3
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) throws Resources.NotFoundException {
                invoke((Integer) obj);
                return kotlin.u.f15726a;
            }

            /* JADX WARN: Removed duplicated region for block: B:8:0x0013  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void invoke(java.lang.Integer r3) throws android.content.res.Resources.NotFoundException {
                /*
                    r2 = this;
                    com.uz.navee.ui.device.ChargingTimeActivity r0 = com.uz.navee.ui.device.ChargingTimeActivity.this
                    com.uz.navee.databinding.ActivityChargingTimeBinding r0 = com.uz.navee.ui.device.ChargingTimeActivity.e0(r0)
                    androidx.appcompat.widget.SwitchCompat r0 = r0.scTiming
                    if (r3 != 0) goto Lb
                    goto L13
                Lb:
                    int r3 = r3.intValue()
                    r1 = 1
                    if (r3 != r1) goto L13
                    goto L14
                L13:
                    r1 = 0
                L14:
                    r0.setChecked(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uz.navee.ui.device.ChargingTimeActivity.AnonymousClass3.invoke(java.lang.Integer):void");
            }
        }));
        j0().observe(this, new b(new q5.l() { // from class: com.uz.navee.ui.device.ChargingTimeActivity.onCreate.4
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Long) obj);
                return kotlin.u.f15726a;
            }

            public final void invoke(Long l6) {
                if (l6 == null || l6.longValue() == 0) {
                    return;
                }
                Calendar calendar = Calendar.getInstance();
                int i6 = calendar.get(6);
                calendar.setTimeInMillis(l6.longValue() * 1000);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
                int i7 = calendar.get(6) - i6;
                ChargingTimeActivity chargingTimeActivity = ChargingTimeActivity.this;
                long jLongValue = l6.longValue();
                String str = simpleDateFormat.format(calendar.getTime());
                kotlin.jvm.internal.y.e(str, "format(...)");
                chargingTimeActivity.n0(new PickTime(jLongValue, str, i7));
            }
        }));
    }

    public final void p0(boolean z6) throws IOException {
        Integer num = (Integer) k0().getValue();
        if (num != null && z6 == num.intValue()) {
            return;
        }
        BaseBindingActivity.Z(this, 111, new byte[]{1, z6 ? (byte) 1 : (byte) 0}, false, 4, null);
        b4.a.W().f1933f.setTimedChargeOn(z6 ? 1 : 0);
    }

    public final void q0(final boolean z6) {
        a.C0192a c0192aG = new a.C0192a(this).f(false).g(Boolean.TRUE);
        Boolean bool = Boolean.FALSE;
        a.C0192a c0192aE = c0192aG.d(bool).e(bool);
        Long l6 = (Long) j0().getValue();
        if (l6 == null) {
            l6 = 0L;
        }
        c0192aE.a(new ChargingTimePopup(this, l6.longValue(), new q5.l() { // from class: com.uz.navee.ui.device.ChargingTimeActivity$settingTime$1
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) throws IOException {
                invoke((PickTime) obj);
                return kotlin.u.f15726a;
            }

            public final void invoke(PickTime start) throws IOException {
                kotlin.jvm.internal.y.f(start, "start");
                this.this$0.n0(start);
                this.this$0.o0(start.getTimestamp());
            }
        }, new q5.a() { // from class: com.uz.navee.ui.device.ChargingTimeActivity$settingTime$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // q5.a
            public /* bridge */ /* synthetic */ Object invoke() throws IOException {
                m122invoke();
                return kotlin.u.f15726a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m122invoke() throws IOException {
                if (z6) {
                    this.p0(false);
                }
            }
        })).G();
    }
}
