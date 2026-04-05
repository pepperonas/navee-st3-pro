package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public abstract class PopupFirmwareUpdateBinding extends ViewDataBinding {

    @NonNull
    public final Button btnCancel;

    @NonNull
    public final Button btnGo;

    @NonNull
    public final AppCompatImageView ivIcon;

    @NonNull
    public final Layer layerVersion;

    @NonNull
    public final TextView tvContent;

    @NonNull
    public final TextView tvCurVersion;

    @NonNull
    public final TextView tvIgnore;

    @NonNull
    public final TextView tvLatestVersion;

    @NonNull
    public final TextView tvMsg;

    @NonNull
    public final TextView tvTitle;

    public PopupFirmwareUpdateBinding(Object obj, View view, int i6, Button button, Button button2, AppCompatImageView appCompatImageView, Layer layer, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i6);
        this.btnCancel = button;
        this.btnGo = button2;
        this.ivIcon = appCompatImageView;
        this.layerVersion = layer;
        this.tvContent = textView;
        this.tvCurVersion = textView2;
        this.tvIgnore = textView3;
        this.tvLatestVersion = textView4;
        this.tvMsg = textView5;
        this.tvTitle = textView6;
    }

    public static PopupFirmwareUpdateBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static PopupFirmwareUpdateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupFirmwareUpdateBinding bind(@NonNull View view, @Nullable Object obj) {
        return (PopupFirmwareUpdateBinding) ViewDataBinding.bind(obj, view, R$layout.popup_firmware_update);
    }

    @NonNull
    @Deprecated
    public static PopupFirmwareUpdateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (PopupFirmwareUpdateBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.popup_firmware_update, viewGroup, z6, obj);
    }

    @NonNull
    public static PopupFirmwareUpdateBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static PopupFirmwareUpdateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (PopupFirmwareUpdateBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.popup_firmware_update, null, false, obj);
    }
}
