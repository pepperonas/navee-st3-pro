package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public abstract class PopupDualDriveOpenBinding extends ViewDataBinding {

    @NonNull
    public final Button btnOk;

    public PopupDualDriveOpenBinding(Object obj, View view, int i6, Button button) {
        super(obj, view, i6);
        this.btnOk = button;
    }

    public static PopupDualDriveOpenBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static PopupDualDriveOpenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupDualDriveOpenBinding bind(@NonNull View view, @Nullable Object obj) {
        return (PopupDualDriveOpenBinding) ViewDataBinding.bind(obj, view, R$layout.popup_dual_drive_open);
    }

    @NonNull
    @Deprecated
    public static PopupDualDriveOpenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (PopupDualDriveOpenBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.popup_dual_drive_open, viewGroup, z6, obj);
    }

    @NonNull
    public static PopupDualDriveOpenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static PopupDualDriveOpenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (PopupDualDriveOpenBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.popup_dual_drive_open, null, false, obj);
    }
}
