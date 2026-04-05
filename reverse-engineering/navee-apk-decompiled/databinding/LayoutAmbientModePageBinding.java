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
public abstract class LayoutAmbientModePageBinding extends ViewDataBinding {

    @NonNull
    public final RadioButton rbBreathing;

    @NonNull
    public final RadioButton rbFlowing;

    @NonNull
    public final RadioButton rbRunning;

    @NonNull
    public final RadioGroup rgMode;

    public LayoutAmbientModePageBinding(Object obj, View view, int i6, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioGroup radioGroup) {
        super(obj, view, i6);
        this.rbBreathing = radioButton;
        this.rbFlowing = radioButton2;
        this.rbRunning = radioButton3;
        this.rgMode = radioGroup;
    }

    public static LayoutAmbientModePageBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LayoutAmbientModePageBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutAmbientModePageBinding bind(@NonNull View view, @Nullable Object obj) {
        return (LayoutAmbientModePageBinding) ViewDataBinding.bind(obj, view, R$layout.layout_ambient_mode_page);
    }

    @NonNull
    @Deprecated
    public static LayoutAmbientModePageBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (LayoutAmbientModePageBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.layout_ambient_mode_page, viewGroup, z6, obj);
    }

    @NonNull
    public static LayoutAmbientModePageBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutAmbientModePageBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LayoutAmbientModePageBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.layout_ambient_mode_page, null, false, obj);
    }
}
