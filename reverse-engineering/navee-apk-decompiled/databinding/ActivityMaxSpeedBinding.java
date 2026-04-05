package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public abstract class ActivityMaxSpeedBinding extends ViewDataBinding {

    @NonNull
    public final ConstraintLayout clSeek;

    @NonNull
    public final ToolbarBinding included;

    @NonNull
    public final RadioGroup rgSpeed;

    @NonNull
    public final AppCompatSeekBar sbSpeed;

    @NonNull
    public final TextView tvSpeed25;

    @NonNull
    public final TextView tvSpeed30;

    @NonNull
    public final TextView tvSpeed32;

    @NonNull
    public final TextView tvSpeed35;

    @NonNull
    public final TextView tvSpeed40;

    @NonNull
    public final TextView tvSpeed45;

    @NonNull
    public final TextView tvSpeed50;

    @NonNull
    public final TextView tvSpeed60;

    @NonNull
    public final TextView tvSpeed70;

    @NonNull
    public final TextView tvTip;

    @NonNull
    public final TextView tvTitle;

    public ActivityMaxSpeedBinding(Object obj, View view, int i6, ConstraintLayout constraintLayout, ToolbarBinding toolbarBinding, RadioGroup radioGroup, AppCompatSeekBar appCompatSeekBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        super(obj, view, i6);
        this.clSeek = constraintLayout;
        this.included = toolbarBinding;
        this.rgSpeed = radioGroup;
        this.sbSpeed = appCompatSeekBar;
        this.tvSpeed25 = textView;
        this.tvSpeed30 = textView2;
        this.tvSpeed32 = textView3;
        this.tvSpeed35 = textView4;
        this.tvSpeed40 = textView5;
        this.tvSpeed45 = textView6;
        this.tvSpeed50 = textView7;
        this.tvSpeed60 = textView8;
        this.tvSpeed70 = textView9;
        this.tvTip = textView10;
        this.tvTitle = textView11;
    }

    public static ActivityMaxSpeedBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityMaxSpeedBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMaxSpeedBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityMaxSpeedBinding) ViewDataBinding.bind(obj, view, R$layout.activity_max_speed);
    }

    @NonNull
    @Deprecated
    public static ActivityMaxSpeedBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ActivityMaxSpeedBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_max_speed, viewGroup, z6, obj);
    }

    @NonNull
    public static ActivityMaxSpeedBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityMaxSpeedBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityMaxSpeedBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_max_speed, null, false, obj);
    }
}
