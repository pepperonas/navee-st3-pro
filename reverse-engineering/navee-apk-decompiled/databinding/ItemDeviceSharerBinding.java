package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$layout;
import com.uz.navee.bean.VehicleSharer;

/* loaded from: classes3.dex */
public abstract class ItemDeviceSharerBinding extends ViewDataBinding {

    @NonNull
    public final CheckBox cbSharer;

    @NonNull
    public final ImageFilterView ivAvatar;

    @NonNull
    public final AppCompatImageView ivRemove;

    @Bindable
    protected Boolean mChecked;

    @Bindable
    protected VehicleSharer mItem;

    @NonNull
    public final TextView tvEmail;

    @NonNull
    public final TextView tvIdentifier;

    @NonNull
    public final TextView tvName;

    public ItemDeviceSharerBinding(Object obj, View view, int i6, CheckBox checkBox, ImageFilterView imageFilterView, AppCompatImageView appCompatImageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i6);
        this.cbSharer = checkBox;
        this.ivAvatar = imageFilterView;
        this.ivRemove = appCompatImageView;
        this.tvEmail = textView;
        this.tvIdentifier = textView2;
        this.tvName = textView3;
    }

    public static ItemDeviceSharerBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemDeviceSharerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public Boolean getChecked() {
        return this.mChecked;
    }

    @Nullable
    public VehicleSharer getItem() {
        return this.mItem;
    }

    public abstract void setChecked(@Nullable Boolean bool);

    public abstract void setItem(@Nullable VehicleSharer vehicleSharer);

    @Deprecated
    public static ItemDeviceSharerBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ItemDeviceSharerBinding) ViewDataBinding.bind(obj, view, R$layout.item_device_sharer);
    }

    @NonNull
    @Deprecated
    public static ItemDeviceSharerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ItemDeviceSharerBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.item_device_sharer, viewGroup, z6, obj);
    }

    @NonNull
    public static ItemDeviceSharerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemDeviceSharerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemDeviceSharerBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.item_device_sharer, null, false, obj);
    }
}
