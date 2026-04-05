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
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class CellDeviceAddBinding implements ViewBinding {

    @NonNull
    public final ImageView addIcon;

    @NonNull
    public final ImageView indicator;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView titleLabel;

    private CellDeviceAddBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView) {
        this.rootView = constraintLayout;
        this.addIcon = imageView;
        this.indicator = imageView2;
        this.titleLabel = textView;
    }

    @NonNull
    public static CellDeviceAddBinding bind(@NonNull View view) {
        int i6 = R$id.addIcon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
        if (imageView != null) {
            i6 = R$id.indicator;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i6);
            if (imageView2 != null) {
                i6 = R$id.titleLabel;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
                if (textView != null) {
                    return new CellDeviceAddBinding((ConstraintLayout) view, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static CellDeviceAddBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static CellDeviceAddBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.cell_device_add, viewGroup, false);
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
