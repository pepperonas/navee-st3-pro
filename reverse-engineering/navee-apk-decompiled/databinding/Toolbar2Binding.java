package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class Toolbar2Binding implements ViewBinding {

    @NonNull
    public final ImageView logoToolbar;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final View tagRedToolbar;

    @NonNull
    public final TextView titleViewToolbar;

    @NonNull
    public final Toolbar toolbar;

    @NonNull
    public final TextView tvRightToolbar;

    private Toolbar2Binding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull View view, @NonNull TextView textView, @NonNull Toolbar toolbar, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.logoToolbar = imageView;
        this.tagRedToolbar = view;
        this.titleViewToolbar = textView;
        this.toolbar = toolbar;
        this.tvRightToolbar = textView2;
    }

    @NonNull
    public static Toolbar2Binding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.logo_toolbar;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
        if (imageView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.tag_red_toolbar))) != null) {
            i6 = R$id.titleView_toolbar;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
            if (textView != null) {
                i6 = R$id.toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i6);
                if (toolbar != null) {
                    i6 = R$id.tv_right_toolbar;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                    if (textView2 != null) {
                        return new Toolbar2Binding((ConstraintLayout) view, imageView, viewFindChildViewById, textView, toolbar, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static Toolbar2Binding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static Toolbar2Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.toolbar2, viewGroup, false);
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
