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
public final class ActivityOpenPictureBinding implements ViewBinding {

    @NonNull
    public final ImageView imageView;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    private final ConstraintLayout rootView;

    private ActivityOpenPictureBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ToolbarBinding toolbarBinding) {
        this.rootView = constraintLayout;
        this.imageView = imageView;
        this.include = toolbarBinding;
    }

    @NonNull
    public static ActivityOpenPictureBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.imageView;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
        if (imageView == null || (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.include))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
        }
        return new ActivityOpenPictureBinding((ConstraintLayout) view, imageView, ToolbarBinding.bind(viewFindChildViewById));
    }

    @NonNull
    public static ActivityOpenPictureBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityOpenPictureBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_open_picture, viewGroup, false);
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
