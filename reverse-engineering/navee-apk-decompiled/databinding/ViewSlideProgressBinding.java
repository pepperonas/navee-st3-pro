package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ViewSlideProgressBinding implements ViewBinding {

    @NonNull
    public final ImageView progressView;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final AppCompatSeekBar seekBar;

    private ViewSlideProgressBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull AppCompatSeekBar appCompatSeekBar) {
        this.rootView = constraintLayout;
        this.progressView = imageView;
        this.seekBar = appCompatSeekBar;
    }

    @NonNull
    public static ViewSlideProgressBinding bind(@NonNull View view) {
        int i6 = R$id.progressView;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
        if (imageView != null) {
            i6 = R$id.seekBar;
            AppCompatSeekBar appCompatSeekBar = (AppCompatSeekBar) ViewBindings.findChildViewById(view, i6);
            if (appCompatSeekBar != null) {
                return new ViewSlideProgressBinding((ConstraintLayout) view, imageView, appCompatSeekBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ViewSlideProgressBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ViewSlideProgressBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.view_slide_progress, viewGroup, false);
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
