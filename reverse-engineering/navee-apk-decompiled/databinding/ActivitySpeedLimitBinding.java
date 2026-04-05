package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public abstract class ActivitySpeedLimitBinding extends ViewDataBinding {

    @NonNull
    public final Guideline glEnd;

    @NonNull
    public final Guideline glStart;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final Layer layerLimitSetting;

    @NonNull
    public final AppCompatSeekBar sbSpeed;

    @NonNull
    public final SwitchCompat scLimit;

    @NonNull
    public final TextView tvCustomLimit;

    @NonNull
    public final TextView tvLimitSetting;

    @NonNull
    public final TextView tvMax;

    @NonNull
    public final TextView tvMin;

    @NonNull
    public final TextView tvSpeed;

    @NonNull
    public final TextView tvTip;

    @NonNull
    public final TextView tvUnit;

    public ActivitySpeedLimitBinding(Object obj, View view, int i6, Guideline guideline, Guideline guideline2, ToolbarBinding toolbarBinding, Layer layer, AppCompatSeekBar appCompatSeekBar, SwitchCompat switchCompat, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, i6);
        this.glEnd = guideline;
        this.glStart = guideline2;
        this.include = toolbarBinding;
        this.layerLimitSetting = layer;
        this.sbSpeed = appCompatSeekBar;
        this.scLimit = switchCompat;
        this.tvCustomLimit = textView;
        this.tvLimitSetting = textView2;
        this.tvMax = textView3;
        this.tvMin = textView4;
        this.tvSpeed = textView5;
        this.tvTip = textView6;
        this.tvUnit = textView7;
    }

    public static ActivitySpeedLimitBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivitySpeedLimitBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySpeedLimitBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivitySpeedLimitBinding) ViewDataBinding.bind(obj, view, R$layout.activity_speed_limit);
    }

    @NonNull
    @Deprecated
    public static ActivitySpeedLimitBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ActivitySpeedLimitBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_speed_limit, viewGroup, z6, obj);
    }

    @NonNull
    public static ActivitySpeedLimitBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivitySpeedLimitBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivitySpeedLimitBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_speed_limit, null, false, obj);
    }
}
