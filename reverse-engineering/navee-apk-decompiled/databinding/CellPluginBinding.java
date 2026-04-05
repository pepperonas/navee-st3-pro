package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class CellPluginBinding implements ViewBinding {

    @NonNull
    public final LinearLayout accessoryView;

    @NonNull
    public final ConstraintLayout contentLayout;

    @NonNull
    public final ImageView indicator;

    @NonNull
    public final SwitchCompat mSwitch;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView subtitleLabel;

    @NonNull
    public final TextView titleLabel;

    @NonNull
    public final LinearLayout titleLayout;

    private CellPluginBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView, @NonNull SwitchCompat switchCompat, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2) {
        this.rootView = constraintLayout;
        this.accessoryView = linearLayout;
        this.contentLayout = constraintLayout2;
        this.indicator = imageView;
        this.mSwitch = switchCompat;
        this.subtitleLabel = textView;
        this.titleLabel = textView2;
        this.titleLayout = linearLayout2;
    }

    @NonNull
    public static CellPluginBinding bind(@NonNull View view) {
        int i6 = R$id.accessoryView;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i6);
        if (linearLayout != null) {
            i6 = R$id.contentLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i6);
            if (constraintLayout != null) {
                i6 = R$id.indicator;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
                if (imageView != null) {
                    i6 = R$id.mSwitch;
                    SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i6);
                    if (switchCompat != null) {
                        i6 = R$id.subtitleLabel;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
                        if (textView != null) {
                            i6 = R$id.titleLabel;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                            if (textView2 != null) {
                                i6 = R$id.titleLayout;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                if (linearLayout2 != null) {
                                    return new CellPluginBinding((ConstraintLayout) view, linearLayout, constraintLayout, imageView, switchCompat, textView, textView2, linearLayout2);
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
    public static CellPluginBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static CellPluginBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.cell_plugin, viewGroup, false);
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
