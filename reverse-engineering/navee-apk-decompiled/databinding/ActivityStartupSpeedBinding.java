package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public abstract class ActivityStartupSpeedBinding extends ViewDataBinding {

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final RadioButton rbFive;

    @NonNull
    public final RadioButton rbFour;

    @NonNull
    public final RadioButton rbOne;

    @NonNull
    public final RadioButton rbThree;

    @NonNull
    public final RadioButton rbTwo;

    @NonNull
    public final RadioButton rbZero;

    @NonNull
    public final RadioGroup rgSpeed;

    public ActivityStartupSpeedBinding(Object obj, View view, int i6, ToolbarBinding toolbarBinding, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, RadioGroup radioGroup) {
        super(obj, view, i6);
        this.include = toolbarBinding;
        this.rbFive = radioButton;
        this.rbFour = radioButton2;
        this.rbOne = radioButton3;
        this.rbThree = radioButton4;
        this.rbTwo = radioButton5;
        this.rbZero = radioButton6;
        this.rgSpeed = radioGroup;
    }

    public static ActivityStartupSpeedBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityStartupSpeedBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityStartupSpeedBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityStartupSpeedBinding) ViewDataBinding.bind(obj, view, R$layout.activity_startup_speed);
    }

    @NonNull
    @Deprecated
    public static ActivityStartupSpeedBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ActivityStartupSpeedBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_startup_speed, viewGroup, z6, obj);
    }

    @NonNull
    public static ActivityStartupSpeedBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityStartupSpeedBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityStartupSpeedBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_startup_speed, null, false, obj);
    }
}
