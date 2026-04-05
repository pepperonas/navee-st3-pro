package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public abstract class ActivityAddDeviceSharerBinding extends ViewDataBinding {

    @NonNull
    public final Button btnOk;

    @NonNull
    public final AppCompatEditText etKeyword;

    @NonNull
    public final AppCompatImageView icSearch;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final RecyclerView rvList;

    public ActivityAddDeviceSharerBinding(Object obj, View view, int i6, Button button, AppCompatEditText appCompatEditText, AppCompatImageView appCompatImageView, ToolbarBinding toolbarBinding, RecyclerView recyclerView) {
        super(obj, view, i6);
        this.btnOk = button;
        this.etKeyword = appCompatEditText;
        this.icSearch = appCompatImageView;
        this.include = toolbarBinding;
        this.rvList = recyclerView;
    }

    public static ActivityAddDeviceSharerBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityAddDeviceSharerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAddDeviceSharerBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityAddDeviceSharerBinding) ViewDataBinding.bind(obj, view, R$layout.activity_add_device_sharer);
    }

    @NonNull
    @Deprecated
    public static ActivityAddDeviceSharerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ActivityAddDeviceSharerBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_add_device_sharer, viewGroup, z6, obj);
    }

    @NonNull
    public static ActivityAddDeviceSharerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityAddDeviceSharerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityAddDeviceSharerBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_add_device_sharer, null, false, obj);
    }
}
