package com.uz.navee.ui.device;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseBindingActivity;
import com.uz.navee.ble.AreaCode;
import com.uz.navee.databinding.ActivitySpeedLimitBinding;
import com.uz.navee.utils.CommonExt;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class SpeedLimitActivity extends BaseBindingActivity<ActivitySpeedLimitBinding> {

    /* renamed from: g, reason: collision with root package name */
    public final kotlin.f f12441g = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.SpeedLimitActivity$isMph$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Boolean> invoke() {
            return Transformations.map(CommonExt.k(this.this$0, Integer.valueOf(b4.a.W().f1933f.getMileageUnit()), "mileageUnit"), new q5.l() { // from class: com.uz.navee.ui.device.SpeedLimitActivity$isMph$2.1
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
    public final kotlin.f f12442h = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.SpeedLimitActivity$limitSpeed$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Integer> invoke() {
            return CommonExt.k(this.this$0, Integer.valueOf(b4.a.W().f1933f.getLimitSpeed()), "limitSpeed");
        }
    });

    /* renamed from: i, reason: collision with root package name */
    public final Map f12443i = kotlin.collections.o0.i(kotlin.k.a(5, 8), kotlin.k.a(6, 10), kotlin.k.a(7, 11), kotlin.k.a(8, 13), kotlin.k.a(9, 14), kotlin.k.a(10, 16), kotlin.k.a(11, 18), kotlin.k.a(12, 20), kotlin.k.a(13, 21), kotlin.k.a(14, 22), kotlin.k.a(15, 24), kotlin.k.a(16, 25), kotlin.k.a(17, 27), kotlin.k.a(18, 29), kotlin.k.a(19, 30), kotlin.k.a(20, 32));

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12444a;

        static {
            int[] iArr = new int[AreaCode.values().length];
            try {
                iArr[AreaCode.EU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AreaCode.RU.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f12444a = iArr;
        }
    }

    public static final class b implements SeekBar.OnSeekBarChangeListener {
        public b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar sb, int i6, boolean z6) {
            kotlin.jvm.internal.y.f(sb, "sb");
            SpeedLimitActivity.d0(SpeedLimitActivity.this).tvSpeed.setText(String.valueOf(i6 + Integer.parseInt(SpeedLimitActivity.d0(SpeedLimitActivity.this).tvMin.getText().toString())));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar sb) {
            kotlin.jvm.internal.y.f(sb, "sb");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar sb) throws NumberFormatException, IOException {
            kotlin.jvm.internal.y.f(sb, "sb");
            SpeedLimitActivity.this.n0();
        }
    }

    public static final class c implements Observer, kotlin.jvm.internal.u {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q5.l f12446a;

        public c(q5.l function) {
            kotlin.jvm.internal.y.f(function, "function");
            this.f12446a = function;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.u)) {
                return kotlin.jvm.internal.y.a(getFunctionDelegate(), ((kotlin.jvm.internal.u) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.u
        public final kotlin.c getFunctionDelegate() {
            return this.f12446a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f12446a.invoke(obj);
        }
    }

    public static final /* synthetic */ ActivitySpeedLimitBinding d0(SpeedLimitActivity speedLimitActivity) {
        return (ActivitySpeedLimitBinding) speedLimitActivity.Q();
    }

    private final LiveData k0() {
        return (LiveData) this.f12441g.getValue();
    }

    public static final void l0(SpeedLimitActivity this$0, CompoundButton compoundButton, boolean z6) throws NumberFormatException, IOException {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        Layer layerLimitSetting = ((ActivitySpeedLimitBinding) this$0.Q()).layerLimitSetting;
        kotlin.jvm.internal.y.e(layerLimitSetting, "layerLimitSetting");
        layerLimitSetting.setVisibility(z6 ? 0 : 8);
        this$0.n0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0() throws NumberFormatException, IOException {
        int i6;
        int iIntValue = Integer.parseInt(((ActivitySpeedLimitBinding) Q()).tvSpeed.getText().toString());
        if (CommonExt.j((Boolean) k0().getValue())) {
            Object obj = this.f12443i.get(Integer.valueOf(iIntValue));
            kotlin.jvm.internal.y.c(obj);
            iIntValue = ((Number) obj).intValue();
        }
        if (((ActivitySpeedLimitBinding) Q()).scLimit.isChecked()) {
            iIntValue |= 128;
            i6 = iIntValue;
        } else {
            i6 = 0;
        }
        if (iIntValue == b4.a.W().f1933f.getLimitSpeed()) {
            return;
        }
        BaseBindingActivity.Y(this, 107, i6, false, 4, null);
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public int V() {
        return R$layout.activity_speed_limit;
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public String b0() {
        String string = getString(R$string.custom_speed_limit);
        kotlin.jvm.internal.y.e(string, "getString(...)");
        return string;
    }

    public final int h0(int i6) {
        if (!CommonExt.j((Boolean) k0().getValue())) {
            return i6;
        }
        Iterator it = this.f12443i.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            int iAbs = Math.abs(((Number) ((Map.Entry) next).getValue()).intValue() - i6);
            do {
                Object next2 = it.next();
                int iAbs2 = Math.abs(((Number) ((Map.Entry) next2).getValue()).intValue() - i6);
                if (iAbs > iAbs2) {
                    next = next2;
                    iAbs = iAbs2;
                }
            } while (it.hasNext());
        }
        return ((Number) ((Map.Entry) next).getKey()).intValue();
    }

    public final LiveData i0() {
        return (LiveData) this.f12442h.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j0() throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uz.navee.ui.device.SpeedLimitActivity.j0():void");
    }

    public final void m0(int i6) throws Resources.NotFoundException {
        ActivitySpeedLimitBinding activitySpeedLimitBinding = (ActivitySpeedLimitBinding) Q();
        boolean z6 = ((i6 & 128) >> 7) == 1;
        activitySpeedLimitBinding.sbSpeed.setProgress(v5.m.c(h0(i6 & 127) - Integer.parseInt(activitySpeedLimitBinding.tvMin.getText().toString()), 0));
        activitySpeedLimitBinding.scLimit.setChecked(z6);
    }

    @Override // com.uz.navee.base.BaseBindingActivity, com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((ActivitySpeedLimitBinding) Q()).tvSpeed.setText("8");
        ((ActivitySpeedLimitBinding) Q()).scLimit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.l8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) throws NumberFormatException, IOException {
                SpeedLimitActivity.l0(this.f12582a, compoundButton, z6);
            }
        });
        ((ActivitySpeedLimitBinding) Q()).sbSpeed.setOnSeekBarChangeListener(new b());
        k0().observe(this, new c(new q5.l() { // from class: com.uz.navee.ui.device.SpeedLimitActivity.onCreate.3
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) throws Resources.NotFoundException {
                invoke((Boolean) obj);
                return kotlin.u.f15726a;
            }

            public final void invoke(Boolean bool) throws Resources.NotFoundException {
                SpeedLimitActivity.this.j0();
            }
        }));
        i0().observe(this, new c(new q5.l() { // from class: com.uz.navee.ui.device.SpeedLimitActivity.onCreate.4
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) throws Resources.NotFoundException {
                invoke((Integer) obj);
                return kotlin.u.f15726a;
            }

            public final void invoke(Integer num) throws Resources.NotFoundException {
                SpeedLimitActivity speedLimitActivity = SpeedLimitActivity.this;
                kotlin.jvm.internal.y.c(num);
                speedLimitActivity.m0(num.intValue());
            }
        }));
    }
}
