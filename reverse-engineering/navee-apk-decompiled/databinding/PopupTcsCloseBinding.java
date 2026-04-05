package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class PopupTcsCloseBinding implements ViewBinding {

    @NonNull
    public final LinearLayout bottomLayout;

    @NonNull
    public final Button cancelButton;

    @NonNull
    public final Button confirmButton;

    @NonNull
    public final ImageView imageView;

    @NonNull
    public final TextView messageLabel;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView titleLabel;

    private PopupTcsCloseBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull Button button2, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.bottomLayout = linearLayout;
        this.cancelButton = button;
        this.confirmButton = button2;
        this.imageView = imageView;
        this.messageLabel = textView;
        this.titleLabel = textView2;
    }

    @NonNull
    public static PopupTcsCloseBinding bind(@NonNull View view) {
        int i6 = R$id.bottomLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i6);
        if (linearLayout != null) {
            i6 = R$id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, i6);
            if (button != null) {
                i6 = R$id.confirmButton;
                Button button2 = (Button) ViewBindings.findChildViewById(view, i6);
                if (button2 != null) {
                    i6 = R$id.imageView;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
                    if (imageView != null) {
                        i6 = R$id.messageLabel;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
                        if (textView != null) {
                            i6 = R$id.titleLabel;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                            if (textView2 != null) {
                                return new PopupTcsCloseBinding((ConstraintLayout) view, linearLayout, button, button2, imageView, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static PopupTcsCloseBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PopupTcsCloseBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.popup_tcs_close, viewGroup, false);
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
