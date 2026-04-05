package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public abstract class ActivityWeatherMeterBinding extends ViewDataBinding {

    @NonNull
    public final ConstraintLayout clSwitch;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final SwitchCompat switchCompat;

    @NonNull
    public final TextView tvState;

    @NonNull
    public final TextView tvTip;

    @NonNull
    public final TextView tvWeatherTitle;

    public ActivityWeatherMeterBinding(Object obj, View view, int i6, ConstraintLayout constraintLayout, ToolbarBinding toolbarBinding, SwitchCompat switchCompat, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i6);
        this.clSwitch = constraintLayout;
        this.include = toolbarBinding;
        this.switchCompat = switchCompat;
        this.tvState = textView;
        this.tvTip = textView2;
        this.tvWeatherTitle = textView3;
    }

    public static ActivityWeatherMeterBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityWeatherMeterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWeatherMeterBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityWeatherMeterBinding) ViewDataBinding.bind(obj, view, R$layout.activity_weather_meter);
    }

    @NonNull
    @Deprecated
    public static ActivityWeatherMeterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ActivityWeatherMeterBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_weather_meter, viewGroup, z6, obj);
    }

    @NonNull
    public static ActivityWeatherMeterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityWeatherMeterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityWeatherMeterBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_weather_meter, null, false, obj);
    }
}
