package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class CellVideoSoldBinding implements ViewBinding {

    @NonNull
    public final ImageView indicator;

    @NonNull
    private final FrameLayout rootView;

    @NonNull
    public final TextView titleLabel;

    private CellVideoSoldBinding(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.rootView = frameLayout;
        this.indicator = imageView;
        this.titleLabel = textView;
    }

    @NonNull
    public static CellVideoSoldBinding bind(@NonNull View view) {
        int i6 = R$id.indicator;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
        if (imageView != null) {
            i6 = R$id.titleLabel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
            if (textView != null) {
                return new CellVideoSoldBinding((FrameLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static CellVideoSoldBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static CellVideoSoldBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.cell_video_sold, viewGroup, false);
        if (z6) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
