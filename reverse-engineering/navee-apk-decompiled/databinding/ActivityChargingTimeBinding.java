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
public abstract class ActivityChargingTimeBinding extends ViewDataBinding {

    @NonNull
    public final ConstraintLayout clTiming;

    @NonNull
    public final ToolbarBinding included;

    @NonNull
    public final SwitchCompat scFull;

    @NonNull
    public final SwitchCompat scTiming;

    @NonNull
    public final TextView tvTimingDes;

    @NonNull
    public final TextView tvTimingTitle;

    public ActivityChargingTimeBinding(Object obj, View view, int i6, ConstraintLayout constraintLayout, ToolbarBinding toolbarBinding, SwitchCompat switchCompat, SwitchCompat switchCompat2, TextView textView, TextView textView2) {
        super(obj, view, i6);
        this.clTiming = constraintLayout;
        this.included = toolbarBinding;
        this.scFull = switchCompat;
        this.scTiming = switchCompat2;
        this.tvTimingDes = textView;
        this.tvTimingTitle = textView2;
    }

    public static ActivityChargingTimeBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityChargingTimeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityChargingTimeBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityChargingTimeBinding) ViewDataBinding.bind(obj, view, R$layout.activity_charging_time);
    }

    @NonNull
    @Deprecated
    public static ActivityChargingTimeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ActivityChargingTimeBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_charging_time, viewGroup, z6, obj);
    }

    @NonNull
    public static ActivityChargingTimeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityChargingTimeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityChargingTimeBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_charging_time, null, false, obj);
    }
}
