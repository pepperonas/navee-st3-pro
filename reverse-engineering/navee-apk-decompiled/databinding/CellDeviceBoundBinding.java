package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
public final class CellDeviceBoundBinding implements ViewBinding {

    @NonNull
    public final ImageButton deleteButton;

    @NonNull
    public final LinearLayout imageLayout;

    @NonNull
    public final ImageView imageView;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final ImageView selectIcon;

    @NonNull
    public final TextView subtitleLabel;

    @NonNull
    public final TextView titleLabel;

    @NonNull
    public final LinearLayout titleLayout;

    private CellDeviceBoundBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageButton imageButton, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2) {
        this.rootView = constraintLayout;
        this.deleteButton = imageButton;
        this.imageLayout = linearLayout;
        this.imageView = imageView;
        this.selectIcon = imageView2;
        this.subtitleLabel = textView;
        this.titleLabel = textView2;
        this.titleLayout = linearLayout2;
    }

    @NonNull
    public static CellDeviceBoundBinding bind(@NonNull View view) {
        int i6 = R$id.deleteButton;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i6);
        if (imageButton != null) {
            i6 = R$id.imageLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i6);
            if (linearLayout != null) {
                i6 = R$id.imageView;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
                if (imageView != null) {
                    i6 = R$id.selectIcon;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i6);
                    if (imageView2 != null) {
                        i6 = R$id.subtitleLabel;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
                        if (textView != null) {
                            i6 = R$id.titleLabel;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                            if (textView2 != null) {
                                i6 = R$id.titleLayout;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                if (linearLayout2 != null) {
                                    return new CellDeviceBoundBinding((ConstraintLayout) view, imageButton, linearLayout, imageView, imageView2, textView, textView2, linearLayout2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static CellDeviceBoundBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static CellDeviceBoundBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.cell_device_bound, viewGroup, false);
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
