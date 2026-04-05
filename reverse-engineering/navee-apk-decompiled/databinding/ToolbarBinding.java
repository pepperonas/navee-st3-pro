package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
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
public final class ToolbarBinding implements ViewBinding {

    @NonNull
    public final ImageButton backToolbar;

    @NonNull
    public final ImageView logoToolbar;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final Button switchToolbar;

    @NonNull
    public final TextView titleViewToolbar;

    @NonNull
    public final Toolbar toolbar;

    private ToolbarBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageButton imageButton, @NonNull ImageView imageView, @NonNull Button button, @NonNull TextView textView, @NonNull Toolbar toolbar) {
        this.rootView = constraintLayout;
        this.backToolbar = imageButton;
        this.logoToolbar = imageView;
        this.switchToolbar = button;
        this.titleViewToolbar = textView;
        this.toolbar = toolbar;
    }

    @NonNull
    public static ToolbarBinding bind(@NonNull View view) {
        int i6 = R$id.back_toolbar;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i6);
        if (imageButton != null) {
            i6 = R$id.logo_toolbar;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
            if (imageView != null) {
                i6 = R$id.switch_toolbar;
                Button button = (Button) ViewBindings.findChildViewById(view, i6);
                if (button != null) {
                    i6 = R$id.titleView_toolbar;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
                    if (textView != null) {
                        i6 = R$id.toolbar;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i6);
                        if (toolbar != null) {
                            return new ToolbarBinding((ConstraintLayout) view, imageButton, imageView, button, textView, toolbar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ToolbarBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ToolbarBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.toolbar, viewGroup, false);
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
