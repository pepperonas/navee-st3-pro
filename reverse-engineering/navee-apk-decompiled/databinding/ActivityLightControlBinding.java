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
public abstract class ActivityLightControlBinding extends ViewDataBinding {

    @NonNull
    public final ToolbarBinding included;

    @NonNull
    public final RadioButton rbClose;

    @NonNull
    public final RadioButton rbFollow;

    @NonNull
    public final RadioButton rbOpen;

    @NonNull
    public final RadioGroup rgControl;

    public ActivityLightControlBinding(Object obj, View view, int i6, ToolbarBinding toolbarBinding, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioGroup radioGroup) {
        super(obj, view, i6);
        this.included = toolbarBinding;
        this.rbClose = radioButton;
        this.rbFollow = radioButton2;
        this.rbOpen = radioButton3;
        this.rgControl = radioGroup;
    }

    public static ActivityLightControlBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityLightControlBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityLightControlBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityLightControlBinding) ViewDataBinding.bind(obj, view, R$layout.activity_light_control);
    }

    @NonNull
    @Deprecated
    public static ActivityLightControlBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ActivityLightControlBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_light_control, viewGroup, z6, obj);
    }

    @NonNull
    public static ActivityLightControlBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityLightControlBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityLightControlBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_light_control, null, false, obj);
    }
}
