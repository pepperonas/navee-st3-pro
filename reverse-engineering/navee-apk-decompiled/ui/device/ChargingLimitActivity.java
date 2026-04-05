package com.uz.navee.ui.device;

import android.os.Bundle;
import android.widget.SeekBar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseBindingActivity;
import com.uz.navee.databinding.ActivityChargingLimitBinding;
import com.uz.navee.utils.CommonExt;
import java.io.IOException;
import kotlin.collections.ArraysKt___ArraysKt;

/* loaded from: classes3.dex */
public final class ChargingLimitActivity extends BaseBindingActivity<ActivityChargingLimitBinding> {

    /* renamed from: g, reason: collision with root package name */
    public final Integer[] f11768g = {80, 85, 90, 95, 100};

    /* renamed from: h, reason: collision with root package name */
    public final kotlin.f f11769h = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.ChargingLimitActivity$chargeLimit$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Integer> invoke() {
            return CommonExt.l(this.this$0.getLifecycle(), Integer.valueOf(b4.a.W().f1933f.getChargeLimit()), "chargeLimit");
        }
    });

    public static final class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i6, boolean z6) {
            kotlin.jvm.internal.y.f(seekBar, "seekBar");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            kotlin.jvm.internal.y.f(seekBar, "seekBar");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) throws IOException {
            kotlin.jvm.internal.y.f(seekBar, "seekBar");
            int progress = ChargingLimitActivity.c0(ChargingLimitActivity.this).sbLimit.getProgress();
            ChargingLimitActivity.this.g0(progress);
            ChargingLimitActivity chargingLimitActivity = ChargingLimitActivity.this;
            BaseBindingActivity.Z(chargingLimitActivity, 111, new byte[]{4, (byte) chargingLimitActivity.f11768g[progress].intValue()}, false, 4, null);
        }
    }

    public static final class b implements Observer, kotlin.jvm.internal.u {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q5.l f11771a;

        public b(q5.l function) {
            kotlin.jvm.internal.y.f(function, "function");
            this.f11771a = function;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.u)) {
                return kotlin.jvm.internal.y.a(getFunctionDelegate(), ((kotlin.jvm.internal.u) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.u
        public final kotlin.c getFunctionDelegate() {
            return this.f11771a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f11771a.invoke(obj);
        }
    }

    public static final /* synthetic */ ActivityChargingLimitBinding c0(ChargingLimitActivity chargingLimitActivity) {
        return (ActivityChargingLimitBinding) chargingLimitActivity.Q();
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public int V() {
        return R$layout.activity_charging_limit;
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public String b0() {
        String string = getString(R$string.charging_limit);
        kotlin.jvm.internal.y.e(string, "getString(...)");
        return string;
    }

    public final LiveData f0() {
        return (LiveData) this.f11769h.getValue();
    }

    public final void g0(int i6) {
        ((ActivityChargingLimitBinding) Q()).tvPercent80.setSelected(i6 == 0);
        ((ActivityChargingLimitBinding) Q()).tvPercent85.setSelected(i6 == 1);
        ((ActivityChargingLimitBinding) Q()).tvPercent90.setSelected(i6 == 2);
        ((ActivityChargingLimitBinding) Q()).tvPercent95.setSelected(i6 == 3);
        ((ActivityChargingLimitBinding) Q()).tvPercent100.setSelected(i6 == 4);
    }

    @Override // com.uz.navee.base.BaseBindingActivity, com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((ActivityChargingLimitBinding) Q()).sbLimit.setOnSeekBarChangeListener(new a());
        f0().observe(this, new b(new q5.l() { // from class: com.uz.navee.ui.device.ChargingLimitActivity.onCreate.2
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return kotlin.u.f15726a;
            }

            public final void invoke(Integer num) {
                int iA0 = ArraysKt___ArraysKt.a0(ChargingLimitActivity.this.f11768g, num);
                if (iA0 != -1) {
                    ChargingLimitActivity.c0(ChargingLimitActivity.this).sbLimit.setProgress(iA0);
                    ChargingLimitActivity.this.g0(iA0);
                }
            }
        }));
    }
}
