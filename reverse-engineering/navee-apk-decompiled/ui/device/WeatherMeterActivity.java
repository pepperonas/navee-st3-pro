package com.uz.navee.ui.device;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.util.Consumer;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.uz.navee.R$color;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseBindingActivity;
import com.uz.navee.databinding.ActivityWeatherMeterBinding;
import com.uz.navee.ui.data.WeatherUpdater;
import com.uz.navee.utils.CommonExt;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class WeatherMeterActivity extends BaseBindingActivity<ActivityWeatherMeterBinding> {

    /* renamed from: g, reason: collision with root package name */
    public final kotlin.f f12460g = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.WeatherMeterActivity$isOn$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Boolean> invoke() {
            return Transformations.distinctUntilChanged(Transformations.map(CommonExt.k(this.this$0, Integer.valueOf(b4.a.W().f1933f.getWeather()), "weather"), new q5.l() { // from class: com.uz.navee.ui.device.WeatherMeterActivity$isOn$2.1
                public final Boolean invoke(int i6) {
                    return Boolean.valueOf((i6 & 128) != 0);
                }

                @Override // q5.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }
            }));
        }
    });

    public static final class a implements Observer, kotlin.jvm.internal.u {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q5.l f12461a;

        public a(q5.l function) {
            kotlin.jvm.internal.y.f(function, "function");
            this.f12461a = function;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.u)) {
                return kotlin.jvm.internal.y.a(getFunctionDelegate(), ((kotlin.jvm.internal.u) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.u
        public final kotlin.c getFunctionDelegate() {
            return this.f12461a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f12461a.invoke(obj);
        }
    }

    public static final /* synthetic */ ActivityWeatherMeterBinding e0(WeatherMeterActivity weatherMeterActivity) {
        return (ActivityWeatherMeterBinding) weatherMeterActivity.Q();
    }

    public static final void i0(WeatherMeterActivity this$0, CompoundButton compoundButton, boolean z6) throws IOException {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        TextView tvState = ((ActivityWeatherMeterBinding) this$0.Q()).tvState;
        kotlin.jvm.internal.y.e(tvState, "tvState");
        tvState.setVisibility(8);
        if (!z6) {
            if (CommonExt.j((Boolean) this$0.h0().getValue())) {
                ((ActivityWeatherMeterBinding) this$0.Q()).tvTip.setText(R$string.meter_weather_tips_normal);
                BaseBindingActivity.Y(this$0, 128, 0, false, 4, null);
                return;
            }
            return;
        }
        if (!this$0.k0() || CommonExt.i((Boolean) this$0.h0().getValue())) {
            ((ActivityWeatherMeterBinding) this$0.Q()).tvTip.setText(R$string.meter_weather_tips_normal);
            this$0.g0().v(this$0, this$0.S(), true);
        }
    }

    public static final void j0(WeatherMeterActivity this$0, boolean z6) throws Resources.NotFoundException {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        ((ActivityWeatherMeterBinding) this$0.Q()).switchCompat.setChecked(CommonExt.j((Boolean) this$0.h0().getValue()));
        if (z6) {
            this$0.k0();
            return;
        }
        TextView textView = ((ActivityWeatherMeterBinding) this$0.Q()).tvState;
        kotlin.jvm.internal.y.c(textView);
        textView.setVisibility(0);
        textView.setText(this$0.getString(R$string.today_update_fail));
        textView.setTextColor(this$0.getColor(R$color.xEC6969));
        ((ActivityWeatherMeterBinding) this$0.Q()).tvTip.setText(R$string.meter_weather_tips_fail);
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public int V() {
        return R$layout.activity_weather_meter;
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public String b0() {
        String string = getString(R$string.meter_weather_title);
        kotlin.jvm.internal.y.e(string, "getString(...)");
        return string;
    }

    public final WeatherUpdater g0() {
        return WeatherUpdater.f11683c.a();
    }

    public final LiveData h0() {
        return (LiveData) this.f12460g.getValue();
    }

    public final boolean k0() {
        String strL = g0().l();
        if (strL == null) {
            return false;
        }
        TextView textView = ((ActivityWeatherMeterBinding) Q()).tvState;
        kotlin.jvm.internal.y.c(textView);
        textView.setVisibility(0);
        textView.setText(getString(R$string.today_updated) + " " + strL);
        textView.setTextColor(getColor(R$color.xFAF4E8_50));
        ((ActivityWeatherMeterBinding) Q()).tvTip.setText(R$string.meter_weather_tips_normal);
        return true;
    }

    @Override // com.uz.navee.base.BaseBindingActivity, com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((ActivityWeatherMeterBinding) Q()).switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.a9
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) throws IOException {
                WeatherMeterActivity.i0(this.f12470a, compoundButton, z6);
            }
        });
        g0().t(new Consumer() { // from class: com.uz.navee.ui.device.b9
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) throws Resources.NotFoundException {
                WeatherMeterActivity.j0(this.f12479a, ((Boolean) obj).booleanValue());
            }
        });
        h0().observe(this, new a(new q5.l() { // from class: com.uz.navee.ui.device.WeatherMeterActivity.onCreate.3
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) throws Resources.NotFoundException {
                invoke((Boolean) obj);
                return kotlin.u.f15726a;
            }

            public final void invoke(Boolean bool) throws Resources.NotFoundException {
                SwitchCompat switchCompat = WeatherMeterActivity.e0(WeatherMeterActivity.this).switchCompat;
                kotlin.jvm.internal.y.c(bool);
                switchCompat.setChecked(bool.booleanValue());
                if (bool.booleanValue()) {
                    TextView tvState = WeatherMeterActivity.e0(WeatherMeterActivity.this).tvState;
                    kotlin.jvm.internal.y.e(tvState, "tvState");
                    tvState.setVisibility(0);
                    WeatherMeterActivity.this.k0();
                }
            }
        }));
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        g0().t(null);
    }
}
