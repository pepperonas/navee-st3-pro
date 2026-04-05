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
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ListViewItemScannedBinding implements ViewBinding {

    @NonNull
    public final ImageButton bindButton;

    @NonNull
    public final ImageView iconView;

    @NonNull
    public final TextView nameLabel;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final LinearLayout textLayout;

    @NonNull
    public final TextView tipsLabel;

    private ListViewItemScannedBinding(@NonNull LinearLayout linearLayout, @NonNull ImageButton imageButton, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2) {
        this.rootView = linearLayout;
        this.bindButton = imageButton;
        this.iconView = imageView;
        this.nameLabel = textView;
        this.textLayout = linearLayout2;
        this.tipsLabel = textView2;
    }

    @NonNull
    public static ListViewItemScannedBinding bind(@NonNull View view) {
        int i6 = R$id.bindButton;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i6);
        if (imageButton != null) {
            i6 = R$id.iconView;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
            if (imageView != null) {
                i6 = R$id.nameLabel;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
                if (textView != null) {
                    i6 = R$id.textLayout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                    if (linearLayout != null) {
                        i6 = R$id.tipsLabel;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                        if (textView2 != null) {
                            return new ListViewItemScannedBinding((LinearLayout) view, imageButton, imageView, textView, linearLayout, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ListViewItemScannedBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListViewItemScannedBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.list_view_item_scanned, viewGroup, false);
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
