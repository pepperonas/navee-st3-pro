package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$layout;
import com.uz.navee.ui.wheel.WheelPicker;

/* loaded from: classes3.dex */
public abstract class PopupChargingTimeBinding extends ViewDataBinding {

    @NonNull
    public final Button btnCancel;

    @NonNull
    public final Button btnConfirm;

    @NonNull
    public final TextView tvTitle;

    @NonNull
    public final WheelPicker wpStartTime;

    public PopupChargingTimeBinding(Object obj, View view, int i6, Button button, Button button2, TextView textView, WheelPicker wheelPicker) {
        super(obj, view, i6);
        this.btnCancel = button;
        this.btnConfirm = button2;
        this.tvTitle = textView;
        this.wpStartTime = wheelPicker;
    }

    public static PopupChargingTimeBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static PopupChargingTimeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupChargingTimeBinding bind(@NonNull View view, @Nullable Object obj) {
        return (PopupChargingTimeBinding) ViewDataBinding.bind(obj, view, R$layout.popup_charging_time);
    }

    @NonNull
    @Deprecated
    public static PopupChargingTimeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (PopupChargingTimeBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.popup_charging_time, viewGroup, z6, obj);
    }

    @NonNull
    public static PopupChargingTimeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static PopupChargingTimeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (PopupChargingTimeBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.popup_charging_time, null, false, obj);
    }
}
