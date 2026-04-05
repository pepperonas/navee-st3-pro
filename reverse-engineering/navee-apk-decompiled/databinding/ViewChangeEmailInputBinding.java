package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ViewChangeEmailInputBinding implements ViewBinding {

    @NonNull
    public final TextView codeButton;

    @NonNull
    public final ImageView codeIco;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextInputEditText textInputEditText;

    @NonNull
    public final TextInputLayout textInputLayout;

    private ViewChangeEmailInputBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextInputEditText textInputEditText, @NonNull TextInputLayout textInputLayout) {
        this.rootView = constraintLayout;
        this.codeButton = textView;
        this.codeIco = imageView;
        this.textInputEditText = textInputEditText;
        this.textInputLayout = textInputLayout;
    }

    @NonNull
    public static ViewChangeEmailInputBinding bind(@NonNull View view) {
        int i6 = R$id.codeButton;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
        if (textView != null) {
            i6 = R$id.codeIco;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
            if (imageView != null) {
                i6 = R$id.textInputEditText;
                TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, i6);
                if (textInputEditText != null) {
                    i6 = R$id.textInputLayout;
                    TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, i6);
                    if (textInputLayout != null) {
                        return new ViewChangeEmailInputBinding((ConstraintLayout) view, textView, imageView, textInputEditText, textInputLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ViewChangeEmailInputBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ViewChangeEmailInputBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.view_change_email_input, viewGroup, false);
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
