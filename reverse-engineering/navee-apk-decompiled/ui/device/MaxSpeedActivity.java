package com.uz.navee.ui.device;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.R$style;
import com.uz.navee.base.BaseBindingActivity;
import com.uz.navee.bean.DeviceCarInfo;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.bean.VehicleModel;
import com.uz.navee.ble.AreaCode;
import com.uz.navee.databinding.ActivityMaxSpeedBinding;
import com.uz.navee.utils.CommonExt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class MaxSpeedActivity extends BaseBindingActivity<ActivityMaxSpeedBinding> {

    /* renamed from: n, reason: collision with root package name */
    public static final a f12368n = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public final kotlin.f f12369g = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.MaxSpeedActivity$showSeekbar$2
        {
            super(0);
        }

        @Override // q5.a
        public final Boolean invoke() {
            return Boolean.valueOf(!b4.d.e(this.this$0.T()));
        }
    });

    /* renamed from: h, reason: collision with root package name */
    public final kotlin.f f12370h = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.MaxSpeedActivity$speeds$2
        {
            super(0);
        }

        @Override // q5.a
        public final List<Integer> invoke() {
            return MaxSpeedActivity.f12368n.b(this.this$0.U());
        }
    });

    /* renamed from: i, reason: collision with root package name */
    public final kotlin.f f12371i = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.MaxSpeedActivity$speedTvs$2
        {
            super(0);
        }

        @Override // q5.a
        public final List<TextView> invoke() {
            List listS0 = this.this$0.s0();
            MaxSpeedActivity maxSpeedActivity = this.this$0;
            ArrayList arrayList = new ArrayList(kotlin.collections.u.u(listS0, 10));
            Iterator it = listS0.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                arrayList.add(iIntValue != 30 ? iIntValue != 32 ? iIntValue != 35 ? iIntValue != 40 ? iIntValue != 45 ? iIntValue != 50 ? iIntValue != 60 ? iIntValue != 70 ? MaxSpeedActivity.d0(maxSpeedActivity).tvSpeed25 : MaxSpeedActivity.d0(maxSpeedActivity).tvSpeed70 : MaxSpeedActivity.d0(maxSpeedActivity).tvSpeed60 : MaxSpeedActivity.d0(maxSpeedActivity).tvSpeed50 : MaxSpeedActivity.d0(maxSpeedActivity).tvSpeed45 : MaxSpeedActivity.d0(maxSpeedActivity).tvSpeed40 : MaxSpeedActivity.d0(maxSpeedActivity).tvSpeed35 : MaxSpeedActivity.d0(maxSpeedActivity).tvSpeed32 : MaxSpeedActivity.d0(maxSpeedActivity).tvSpeed30);
            }
            return arrayList;
        }
    });

    /* renamed from: j, reason: collision with root package name */
    public final kotlin.f f12372j = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.MaxSpeedActivity$speedRbs$2
        {
            super(0);
        }

        @Override // q5.a
        public final List<RadioButton> invoke() {
            List listS0 = this.this$0.s0();
            MaxSpeedActivity maxSpeedActivity = this.this$0;
            ArrayList arrayList = new ArrayList(kotlin.collections.u.u(listS0, 10));
            int i6 = 0;
            for (Object obj : listS0) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    kotlin.collections.t.t();
                }
                ((Number) obj).intValue();
                RadioButton radioButton = new RadioButton(maxSpeedActivity, null, 0, R$style.RadioButton_TransItem);
                radioButton.setId(View.generateViewId());
                MaxSpeedActivity.d0(maxSpeedActivity).rgSpeed.addView(radioButton, new RadioGroup.LayoutParams(-1, CommonExt.d(radioButton, 60)));
                radioButton.setClickable(true);
                arrayList.add(radioButton);
                i6 = i7;
            }
            return arrayList;
        }
    });

    /* renamed from: k, reason: collision with root package name */
    public final kotlin.f f12373k = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.MaxSpeedActivity$defaultSpeed$2
        {
            super(0);
        }

        @Override // q5.a
        public final Integer invoke() {
            return Integer.valueOf(MaxSpeedActivity.f12368n.a(this.this$0.U()));
        }
    });

    /* renamed from: l, reason: collision with root package name */
    public final kotlin.f f12374l = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.MaxSpeedActivity$isMph$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Boolean> invoke() {
            return Transformations.map(CommonExt.k(this.this$0, Integer.valueOf(b4.a.W().f1933f.getMileageUnit()), "mileageUnit"), new q5.l() { // from class: com.uz.navee.ui.device.MaxSpeedActivity$isMph$2.1
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

    /* renamed from: m, reason: collision with root package name */
    public final kotlin.f f12375m = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.MaxSpeedActivity$maxSpeed$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Integer> invoke() {
            DeviceCarInfo deviceCarInfo = b4.a.W().f1933f;
            if (deviceCarInfo.getMaxSpeed() == 0) {
                deviceCarInfo.setMaxSpeed(this.this$0.n0());
            }
            return CommonExt.k(this.this$0, Integer.valueOf(deviceCarInfo.getMaxSpeed()), "maxSpeed");
        }
    });

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.r rVar) {
            this();
        }

        public final int a(Vehicle vehicle) {
            VehicleModel vehicleModel;
            List listB = b(vehicle);
            String str = (vehicle == null || (vehicleModel = vehicle.model) == null) ? null : vehicleModel.pid;
            if (CommonExt.j(str != null ? Boolean.valueOf(kotlin.text.s.D(str, "2509", false, 2, null)) : null)) {
                return 40;
            }
            if (b4.d.m(str) || b4.d.l(str)) {
                return 50;
            }
            if (b4.d.e(str)) {
                return ((Number) listB.get(listB.size() - 1)).intValue();
            }
            return 32;
        }

        public final List b(Vehicle vehicle) {
            VehicleModel vehicleModel;
            String str = (vehicle == null || (vehicleModel = vehicle.model) == null) ? null : vehicleModel.pid;
            if (!b4.d.b(str) && !b4.d.a(str)) {
                if (!CommonExt.j(str != null ? Boolean.valueOf(kotlin.text.s.D(str, "2611", false, 2, null)) : null)) {
                    if (!CommonExt.j(str != null ? Boolean.valueOf(kotlin.text.s.D(str, "2612", false, 2, null)) : null)) {
                        if (!CommonExt.j(str != null ? Boolean.valueOf(kotlin.text.s.D(str, "2643", false, 2, null)) : null)) {
                            if (!CommonExt.j(str != null ? Boolean.valueOf(kotlin.text.s.D(str, "2416", false, 2, null)) : null)) {
                                if (!CommonExt.j(str != null ? Boolean.valueOf(kotlin.text.s.D(str, "2538", false, 2, null)) : null)) {
                                    if (b4.d.m(str)) {
                                        return kotlin.collections.t.n(25, 32, 45, 50);
                                    }
                                    if (CommonExt.j(str != null ? Boolean.valueOf(kotlin.text.s.D(str, "2547", false, 2, null)) : null)) {
                                        return kotlin.collections.t.n(25, 32, 40, 50, 60);
                                    }
                                    if (CommonExt.j(str != null ? Boolean.valueOf(kotlin.text.s.D(str, "2585", false, 2, null)) : null)) {
                                        return kotlin.collections.t.n(25, 32, 40, 50, 70);
                                    }
                                    if (!CommonExt.j(str != null ? Boolean.valueOf(kotlin.text.s.D(str, "2509", false, 2, null)) : null)) {
                                        if (!CommonExt.j(str != null ? Boolean.valueOf(kotlin.text.s.D(str, "2540", false, 2, null)) : null)) {
                                            if (!CommonExt.j(str != null ? Boolean.valueOf(kotlin.text.s.D(str, "2543", false, 2, null)) : null)) {
                                                if (!CommonExt.j(str != null ? Boolean.valueOf(kotlin.text.s.D(str, "2657", false, 2, null)) : null)) {
                                                    if (!CommonExt.j(str != null ? Boolean.valueOf(kotlin.text.s.D(str, "2658", false, 2, null)) : null)) {
                                                        if (!CommonExt.j(str != null ? Boolean.valueOf(kotlin.text.s.D(str, "2707", false, 2, null)) : null)) {
                                                            if (CommonExt.j(str != null ? Boolean.valueOf(kotlin.text.s.D(str, "2544", false, 2, null)) : null)) {
                                                                return kotlin.collections.t.n(25, 30, 35, 40, 45, 50, 55, 60);
                                                            }
                                                            return CommonExt.j(str != null ? Boolean.valueOf(kotlin.text.s.D(str, "2449", false, 2, null)) : null) ? kotlin.collections.t.n(25, 30, 35, 40, 45, 50, 55, 60, 65) : kotlin.collections.t.n(25, 32, 40);
                                                        }
                                                    }
                                                }
                                            }
                                            return (vehicle != null ? vehicle.areaCode() : null) == AreaCode.US ? kotlin.collections.t.n(25, 30, 35, 40, 45, 50) : kotlin.collections.t.n(25, 30, 35, 40);
                                        }
                                    }
                                    return kotlin.collections.t.n(25, 30, 35, 40);
                                }
                            }
                            return kotlin.collections.t.n(25, 32, 40, 50);
                        }
                    }
                }
            }
            return kotlin.collections.t.n(25, 32);
        }
    }

    public static final class b implements SeekBar.OnSeekBarChangeListener {
        public b() {
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
            int progress = MaxSpeedActivity.d0(MaxSpeedActivity.this).sbSpeed.getProgress();
            int i6 = 0;
            for (Object obj : MaxSpeedActivity.this.r0()) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    kotlin.collections.t.t();
                }
                ((TextView) obj).setSelected(i6 == progress);
                i6 = i7;
            }
            MaxSpeedActivity.this.w0(progress);
            MaxSpeedActivity.this.v0(progress);
        }
    }

    public static final class c implements Observer, kotlin.jvm.internal.u {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q5.l f12377a;

        public c(q5.l function) {
            kotlin.jvm.internal.y.f(function, "function");
            this.f12377a = function;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.u)) {
                return kotlin.jvm.internal.y.a(getFunctionDelegate(), ((kotlin.jvm.internal.u) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.u
        public final kotlin.c getFunctionDelegate() {
            return this.f12377a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f12377a.invoke(obj);
        }
    }

    public static final /* synthetic */ ActivityMaxSpeedBinding d0(MaxSpeedActivity maxSpeedActivity) {
        return (ActivityMaxSpeedBinding) maxSpeedActivity.Q();
    }

    private final LiveData o0() {
        return (LiveData) this.f12375m.getValue();
    }

    public static final void u0(MaxSpeedActivity this$0, RadioGroup radioGroup, int i6) throws IOException {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        int iIndexOfChild = radioGroup.indexOfChild((RadioButton) radioGroup.findViewById(i6));
        if (iIndexOfChild == -1) {
            return;
        }
        this$0.w0(iIndexOfChild);
        this$0.v0(iIndexOfChild);
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public int V() {
        return R$layout.activity_max_speed;
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public String b0() {
        String string = getString(R$string.max_speed_setting);
        kotlin.jvm.internal.y.e(string, "getString(...)");
        return string;
    }

    public final int n0() {
        return ((Number) this.f12373k.getValue()).intValue();
    }

    @Override // com.uz.navee.base.BaseBindingActivity, com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (p0()) {
            RadioGroup rgSpeed = ((ActivityMaxSpeedBinding) Q()).rgSpeed;
            kotlin.jvm.internal.y.e(rgSpeed, "rgSpeed");
            rgSpeed.setVisibility(8);
            ((ActivityMaxSpeedBinding) Q()).sbSpeed.setMax(s0().size() - 1);
            ((ActivityMaxSpeedBinding) Q()).sbSpeed.setOnSeekBarChangeListener(new b());
            for (TextView textView : r0()) {
                kotlin.jvm.internal.y.c(textView);
                textView.setVisibility(0);
            }
        } else {
            ConstraintLayout clSeek = ((ActivityMaxSpeedBinding) Q()).clSeek;
            kotlin.jvm.internal.y.e(clSeek, "clSeek");
            clSeek.setVisibility(8);
            ((ActivityMaxSpeedBinding) Q()).rgSpeed.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.q7
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup, int i6) throws IOException {
                    MaxSpeedActivity.u0(this.f12628a, radioGroup, i6);
                }
            });
        }
        t0().observe(this, new c(new q5.l() { // from class: com.uz.navee.ui.device.MaxSpeedActivity.onCreate.4
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return kotlin.u.f15726a;
            }

            public final void invoke(Boolean bool) {
                if (!MaxSpeedActivity.this.p0()) {
                    List listQ0 = MaxSpeedActivity.this.q0();
                    MaxSpeedActivity maxSpeedActivity = MaxSpeedActivity.this;
                    int i6 = 0;
                    for (Object obj : listQ0) {
                        int i7 = i6 + 1;
                        if (i6 < 0) {
                            kotlin.collections.t.t();
                        }
                        RadioButton radioButton = (RadioButton) obj;
                        int iIntValue = ((Number) maxSpeedActivity.s0().get(i6)).intValue();
                        kotlin.jvm.internal.y.c(bool);
                        radioButton.setText(bool.booleanValue() ? s5.c.a(iIntValue * 0.621d) + maxSpeedActivity.getString(R$string.unit_speed_imperial) : iIntValue + maxSpeedActivity.getString(R$string.unit_speed_metric));
                        i6 = i7;
                    }
                    return;
                }
                kotlin.jvm.internal.y.c(bool);
                if (!bool.booleanValue()) {
                    MaxSpeedActivity.d0(MaxSpeedActivity.this).tvSpeed25.setText("25" + MaxSpeedActivity.this.getString(R$string.unit_speed_metric));
                    MaxSpeedActivity.d0(MaxSpeedActivity.this).tvSpeed30.setText("30" + MaxSpeedActivity.this.getString(R$string.unit_speed_metric));
                    MaxSpeedActivity.d0(MaxSpeedActivity.this).tvSpeed32.setText("32" + MaxSpeedActivity.this.getString(R$string.unit_speed_metric));
                    MaxSpeedActivity.d0(MaxSpeedActivity.this).tvSpeed35.setText("35" + MaxSpeedActivity.this.getString(R$string.unit_speed_metric));
                    MaxSpeedActivity.d0(MaxSpeedActivity.this).tvSpeed40.setText("40" + MaxSpeedActivity.this.getString(R$string.unit_speed_metric));
                    MaxSpeedActivity.d0(MaxSpeedActivity.this).tvSpeed45.setText("45" + MaxSpeedActivity.this.getString(R$string.unit_speed_metric));
                    MaxSpeedActivity.d0(MaxSpeedActivity.this).tvSpeed50.setText("50" + MaxSpeedActivity.this.getString(R$string.unit_speed_metric));
                    MaxSpeedActivity.d0(MaxSpeedActivity.this).tvSpeed60.setText("60" + MaxSpeedActivity.this.getString(R$string.unit_speed_metric));
                    MaxSpeedActivity.d0(MaxSpeedActivity.this).tvSpeed70.setText("70" + MaxSpeedActivity.this.getString(R$string.unit_speed_metric));
                    return;
                }
                MaxSpeedActivity.d0(MaxSpeedActivity.this).tvSpeed25.setText(s5.c.a(25 * 0.621d) + MaxSpeedActivity.this.getString(R$string.unit_speed_imperial));
                MaxSpeedActivity.d0(MaxSpeedActivity.this).tvSpeed30.setText(s5.c.a(((double) 30) * 0.621d) + MaxSpeedActivity.this.getString(R$string.unit_speed_imperial));
                MaxSpeedActivity.d0(MaxSpeedActivity.this).tvSpeed32.setText(s5.c.a(((double) 32) * 0.621d) + MaxSpeedActivity.this.getString(R$string.unit_speed_imperial));
                MaxSpeedActivity.d0(MaxSpeedActivity.this).tvSpeed35.setText(s5.c.a(((double) 35) * 0.621d) + MaxSpeedActivity.this.getString(R$string.unit_speed_imperial));
                MaxSpeedActivity.d0(MaxSpeedActivity.this).tvSpeed40.setText(s5.c.a(((double) 40) * 0.621d) + MaxSpeedActivity.this.getString(R$string.unit_speed_imperial));
                MaxSpeedActivity.d0(MaxSpeedActivity.this).tvSpeed45.setText(s5.c.a(((double) 45) * 0.621d) + MaxSpeedActivity.this.getString(R$string.unit_speed_imperial));
                MaxSpeedActivity.d0(MaxSpeedActivity.this).tvSpeed50.setText(s5.c.a(((double) 50) * 0.621d) + MaxSpeedActivity.this.getString(R$string.unit_speed_imperial));
                MaxSpeedActivity.d0(MaxSpeedActivity.this).tvSpeed60.setText(s5.c.a(((double) 60) * 0.621d) + MaxSpeedActivity.this.getString(R$string.unit_speed_imperial));
                MaxSpeedActivity.d0(MaxSpeedActivity.this).tvSpeed70.setText(s5.c.a(((double) 70) * 0.621d) + MaxSpeedActivity.this.getString(R$string.unit_speed_imperial));
            }
        }));
        o0().observe(this, new c(new q5.l() { // from class: com.uz.navee.ui.device.MaxSpeedActivity.onCreate.5
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return kotlin.u.f15726a;
            }

            public final void invoke(Integer num) {
                int iIndexOf = MaxSpeedActivity.this.s0().indexOf(num);
                if (iIndexOf != -1) {
                    if (MaxSpeedActivity.this.p0()) {
                        MaxSpeedActivity.d0(MaxSpeedActivity.this).sbSpeed.setProgress(iIndexOf);
                        int i6 = 0;
                        for (Object obj : MaxSpeedActivity.this.r0()) {
                            int i7 = i6 + 1;
                            if (i6 < 0) {
                                kotlin.collections.t.t();
                            }
                            ((TextView) obj).setSelected(iIndexOf == i6);
                            i6 = i7;
                        }
                    } else {
                        ((RadioButton) MaxSpeedActivity.this.q0().get(iIndexOf)).setChecked(true);
                    }
                    MaxSpeedActivity.this.w0(iIndexOf);
                }
            }
        }));
    }

    public final boolean p0() {
        return ((Boolean) this.f12369g.getValue()).booleanValue();
    }

    public final List q0() {
        return (List) this.f12372j.getValue();
    }

    public final List r0() {
        return (List) this.f12371i.getValue();
    }

    public final List s0() {
        return (List) this.f12370h.getValue();
    }

    public final LiveData t0() {
        return (LiveData) this.f12374l.getValue();
    }

    public final void v0(int i6) throws IOException {
        int iIntValue = ((Number) s0().get(i6)).intValue();
        Integer num = (Integer) o0().getValue();
        if (num != null && iIntValue == num.intValue()) {
            return;
        }
        BaseBindingActivity.Z(this, 110, new byte[]{1, (byte) ((Number) s0().get(i6)).intValue()}, false, 4, null);
    }

    public final void w0(int i6) {
        String string = getString(R$string.max_speed_setting_des);
        kotlin.jvm.internal.y.e(string, "getString(...)");
        if (((Number) s0().get(i6)).intValue() >= 50) {
            string = string + getString(R$string.max_speed_setting_des_extra);
        }
        ((ActivityMaxSpeedBinding) Q()).tvTip.setText(string);
    }
}
