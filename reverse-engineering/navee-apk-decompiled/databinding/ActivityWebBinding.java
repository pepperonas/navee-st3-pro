package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public abstract class ActivityWebBinding extends ViewDataBinding {

    @NonNull
    public final FrameLayout flContainer;

    public ActivityWebBinding(Object obj, View view, int i6, FrameLayout frameLayout) {
        super(obj, view, i6);
        this.flContainer = frameLayout;
    }

    public static ActivityWebBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityWebBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWebBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityWebBinding) ViewDataBinding.bind(obj, view, R$layout.activity_web);
    }

    @NonNull
    @Deprecated
    public static ActivityWebBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ActivityWebBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_web, viewGroup, z6, obj);
    }

    @NonNull
    public static ActivityWebBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityWebBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityWebBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_web, null, false, obj);
    }
}
