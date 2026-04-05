package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public abstract class LayoutRecyclerviewBinding extends ViewDataBinding {

    @NonNull
    public final RecyclerView recyclerView;

    public LayoutRecyclerviewBinding(Object obj, View view, int i6, RecyclerView recyclerView) {
        super(obj, view, i6);
        this.recyclerView = recyclerView;
    }

    public static LayoutRecyclerviewBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LayoutRecyclerviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutRecyclerviewBinding bind(@NonNull View view, @Nullable Object obj) {
        return (LayoutRecyclerviewBinding) ViewDataBinding.bind(obj, view, R$layout.layout_recyclerview);
    }

    @NonNull
    @Deprecated
    public static LayoutRecyclerviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (LayoutRecyclerviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.layout_recyclerview, viewGroup, z6, obj);
    }

    @NonNull
    public static LayoutRecyclerviewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutRecyclerviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LayoutRecyclerviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.layout_recyclerview, null, false, obj);
    }
}
