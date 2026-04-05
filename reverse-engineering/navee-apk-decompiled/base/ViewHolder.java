package com.uz.navee.base;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.y;

/* loaded from: classes3.dex */
public final class ViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final ViewDataBinding f11621a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        y.f(binding, "binding");
        this.f11621a = binding;
    }

    public final ViewDataBinding getBinding() {
        return this.f11621a;
    }
}
