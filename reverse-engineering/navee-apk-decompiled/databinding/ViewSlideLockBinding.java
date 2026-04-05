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
public final class ViewSlideLockBinding implements ViewBinding {

    @NonNull
    public final ImageView lockBtn;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final ConstraintLayout trackView;

    private ViewSlideLockBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.lockBtn = imageView;
        this.trackView = constraintLayout2;
    }

    @NonNull
    public static ViewSlideLockBinding bind(@NonNull View view) {
        int i6 = R$id.lock_btn;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
        if (imageView != null) {
            i6 = R$id.trackView;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i6);
            if (constraintLayout != null) {
                return new ViewSlideLockBinding((ConstraintLayout) view, imageView, constraintLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ViewSlideLockBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ViewSlideLockBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.view_slide_lock, viewGroup, false);
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
