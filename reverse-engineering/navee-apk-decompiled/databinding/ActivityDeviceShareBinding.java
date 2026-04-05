package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public abstract class ActivityDeviceShareBinding extends ViewDataBinding {

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final AppCompatImageView ivAdd;

    @NonNull
    public final RecyclerView rvList;

    @NonNull
    public final TextView tvShareCount;

    public ActivityDeviceShareBinding(Object obj, View view, int i6, ToolbarBinding toolbarBinding, AppCompatImageView appCompatImageView, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i6);
        this.include = toolbarBinding;
        this.ivAdd = appCompatImageView;
        this.rvList = recyclerView;
        this.tvShareCount = textView;
    }

    public static ActivityDeviceShareBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityDeviceShareBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDeviceShareBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityDeviceShareBinding) ViewDataBinding.bind(obj, view, R$layout.activity_device_share);
    }

    @NonNull
    @Deprecated
    public static ActivityDeviceShareBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ActivityDeviceShareBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_device_share, viewGroup, z6, obj);
    }

    @NonNull
    public static ActivityDeviceShareBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityDeviceShareBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityDeviceShareBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_device_share, null, false, obj);
    }
}
