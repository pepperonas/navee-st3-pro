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
public abstract class ActivityDeviceLockTimeBinding extends ViewDataBinding {

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final RadioButton rb12;

    @NonNull
    public final RadioButton rb24;

    @NonNull
    public final RadioButton rb6;

    @NonNull
    public final RadioGroup rgTime;

    public ActivityDeviceLockTimeBinding(Object obj, View view, int i6, ToolbarBinding toolbarBinding, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioGroup radioGroup) {
        super(obj, view, i6);
        this.include = toolbarBinding;
        this.rb12 = radioButton;
        this.rb24 = radioButton2;
        this.rb6 = radioButton3;
        this.rgTime = radioGroup;
    }

    public static ActivityDeviceLockTimeBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityDeviceLockTimeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDeviceLockTimeBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityDeviceLockTimeBinding) ViewDataBinding.bind(obj, view, R$layout.activity_device_lock_time);
    }

    @NonNull
    @Deprecated
    public static ActivityDeviceLockTimeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ActivityDeviceLockTimeBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_device_lock_time, viewGroup, z6, obj);
    }

    @NonNull
    public static ActivityDeviceLockTimeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityDeviceLockTimeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityDeviceLockTimeBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_device_lock_time, null, false, obj);
    }
}
