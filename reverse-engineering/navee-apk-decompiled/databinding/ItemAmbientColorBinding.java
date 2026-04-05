package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public abstract class ItemAmbientColorBinding extends ViewDataBinding {

    @NonNull
    public final ImageFilterView ivColor;

    public ItemAmbientColorBinding(Object obj, View view, int i6, ImageFilterView imageFilterView) {
        super(obj, view, i6);
        this.ivColor = imageFilterView;
    }

    public static ItemAmbientColorBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemAmbientColorBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAmbientColorBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ItemAmbientColorBinding) ViewDataBinding.bind(obj, view, R$layout.item_ambient_color);
    }

    @NonNull
    @Deprecated
    public static ItemAmbientColorBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ItemAmbientColorBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.item_ambient_color, viewGroup, z6, obj);
    }

    @NonNull
    public static ItemAmbientColorBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemAmbientColorBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemAmbientColorBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.item_ambient_color, null, false, obj);
    }
}
