package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public abstract class ActivityChargingLimitBinding extends ViewDataBinding {

    @NonNull
    public final ToolbarBinding included;

    @NonNull
    public final AppCompatSeekBar sbLimit;

    @NonNull
    public final TextView tvPercent100;

    @NonNull
    public final TextView tvPercent80;

    @NonNull
    public final TextView tvPercent85;

    @NonNull
    public final TextView tvPercent90;

    @NonNull
    public final TextView tvPercent95;

    @NonNull
    public final TextView tvTitle;

    public ActivityChargingLimitBinding(Object obj, View view, int i6, ToolbarBinding toolbarBinding, AppCompatSeekBar appCompatSeekBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i6);
        this.included = toolbarBinding;
        this.sbLimit = appCompatSeekBar;
        this.tvPercent100 = textView;
        this.tvPercent80 = textView2;
        this.tvPercent85 = textView3;
        this.tvPercent90 = textView4;
        this.tvPercent95 = textView5;
        this.tvTitle = textView6;
    }

    public static ActivityChargingLimitBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityChargingLimitBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityChargingLimitBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityChargingLimitBinding) ViewDataBinding.bind(obj, view, R$layout.activity_charging_limit);
    }

    @NonNull
    @Deprecated
    public static ActivityChargingLimitBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ActivityChargingLimitBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_charging_limit, viewGroup, z6, obj);
    }

    @NonNull
    public static ActivityChargingLimitBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityChargingLimitBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityChargingLimitBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_charging_limit, null, false, obj);
    }
}
