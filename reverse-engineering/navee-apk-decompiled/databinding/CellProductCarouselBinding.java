package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class CellProductCarouselBinding implements ViewBinding {

    @NonNull
    public final TextView describeLabel;

    @NonNull
    public final SimpleDraweeView imageView;

    @NonNull
    public final Button moreButton;

    @NonNull
    public final TextView nameLabel;

    @NonNull
    private final LinearLayout rootView;

    private CellProductCarouselBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull Button button, @NonNull TextView textView2) {
        this.rootView = linearLayout;
        this.describeLabel = textView;
        this.imageView = simpleDraweeView;
        this.moreButton = button;
        this.nameLabel = textView2;
    }

    @NonNull
    public static CellProductCarouselBinding bind(@NonNull View view) {
        int i6 = R$id.describeLabel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
        if (textView != null) {
            i6 = R$id.imageView;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) ViewBindings.findChildViewById(view, i6);
            if (simpleDraweeView != null) {
                i6 = R$id.moreButton;
                Button button = (Button) ViewBindings.findChildViewById(view, i6);
                if (button != null) {
                    i6 = R$id.nameLabel;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                    if (textView2 != null) {
                        return new CellProductCarouselBinding((LinearLayout) view, textView, simpleDraweeView, button, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static CellProductCarouselBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static CellProductCarouselBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.cell_product_carousel, viewGroup, false);
        if (z6) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
