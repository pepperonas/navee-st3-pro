package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public abstract class PopupDriveGuideBinding extends ViewDataBinding {

    @NonNull
    public final AppCompatImageButton btnClose;

    @NonNull
    public final FrameLayout flContainer;

    @NonNull
    public final TextView tvSkip;

    public PopupDriveGuideBinding(Object obj, View view, int i6, AppCompatImageButton appCompatImageButton, FrameLayout frameLayout, TextView textView) {
        super(obj, view, i6);
        this.btnClose = appCompatImageButton;
        this.flContainer = frameLayout;
        this.tvSkip = textView;
    }

    public static PopupDriveGuideBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static PopupDriveGuideBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupDriveGuideBinding bind(@NonNull View view, @Nullable Object obj) {
        return (PopupDriveGuideBinding) ViewDataBinding.bind(obj, view, R$layout.popup_drive_guide);
    }

    @NonNull
    @Deprecated
    public static PopupDriveGuideBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (PopupDriveGuideBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.popup_drive_guide, viewGroup, z6, obj);
    }

    @NonNull
    public static PopupDriveGuideBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static PopupDriveGuideBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (PopupDriveGuideBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.popup_drive_guide, null, false, obj);
    }
}
