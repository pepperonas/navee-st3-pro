package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public abstract class ActivitySlopeSupBinding extends ViewDataBinding {

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final SwitchCompat scHac;

    @NonNull
    public final SwitchCompat scHdc;

    @NonNull
    public final SwitchCompat scPas;

    public ActivitySlopeSupBinding(Object obj, View view, int i6, ToolbarBinding toolbarBinding, SwitchCompat switchCompat, SwitchCompat switchCompat2, SwitchCompat switchCompat3) {
        super(obj, view, i6);
        this.include = toolbarBinding;
        this.scHac = switchCompat;
        this.scHdc = switchCompat2;
        this.scPas = switchCompat3;
    }

    public static ActivitySlopeSupBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivitySlopeSupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySlopeSupBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivitySlopeSupBinding) ViewDataBinding.bind(obj, view, R$layout.activity_slope_sup);
    }

    @NonNull
    @Deprecated
    public static ActivitySlopeSupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ActivitySlopeSupBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_slope_sup, viewGroup, z6, obj);
    }

    @NonNull
    public static ActivitySlopeSupBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivitySlopeSupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivitySlopeSupBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_slope_sup, null, false, obj);
    }
}
