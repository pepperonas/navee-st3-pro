package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ActivitySoldOutletsBinding implements ViewBinding {

    @NonNull
    public final Toolbar2Binding include;

    @NonNull
    public final ConstraintLayout main;

    @NonNull
    public final ImageView qrImageView;

    @NonNull
    private final ConstraintLayout rootView;

    private ActivitySoldOutletsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Toolbar2Binding toolbar2Binding, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView) {
        this.rootView = constraintLayout;
        this.include = toolbar2Binding;
        this.main = constraintLayout2;
        this.qrImageView = imageView;
    }

    @NonNull
    public static ActivitySoldOutletsBinding bind(@NonNull View view) {
        int i6 = R$id.include;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, i6);
        if (viewFindChildViewById != null) {
            Toolbar2Binding toolbar2BindingBind = Toolbar2Binding.bind(viewFindChildViewById);
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            int i7 = R$id.qrImageView;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i7);
            if (imageView != null) {
                return new ActivitySoldOutletsBinding(constraintLayout, toolbar2BindingBind, constraintLayout, imageView);
            }
            i6 = i7;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ActivitySoldOutletsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivitySoldOutletsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_sold_outlets, viewGroup, false);
        if (z6) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
