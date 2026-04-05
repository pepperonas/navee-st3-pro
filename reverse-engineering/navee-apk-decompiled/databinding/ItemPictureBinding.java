package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ItemPictureBinding implements ViewBinding {

    @NonNull
    public final Layer delete;

    @NonNull
    public final AppCompatImageView image;

    @NonNull
    public final ImageView ivDel;

    @NonNull
    private final CardView rootView;

    @NonNull
    public final View vDelBg;

    private ItemPictureBinding(@NonNull CardView cardView, @NonNull Layer layer, @NonNull AppCompatImageView appCompatImageView, @NonNull ImageView imageView, @NonNull View view) {
        this.rootView = cardView;
        this.delete = layer;
        this.image = appCompatImageView;
        this.ivDel = imageView;
        this.vDelBg = view;
    }

    @NonNull
    public static ItemPictureBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.delete;
        Layer layer = (Layer) ViewBindings.findChildViewById(view, i6);
        if (layer != null) {
            i6 = R$id.image;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i6);
            if (appCompatImageView != null) {
                i6 = R$id.iv_del;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
                if (imageView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.v_del_bg))) != null) {
                    return new ItemPictureBinding((CardView) view, layer, appCompatImageView, imageView, viewFindChildViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ItemPictureBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemPictureBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.item_picture, viewGroup, false);
        if (z6) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CardView getRoot() {
        return this.rootView;
    }
}
