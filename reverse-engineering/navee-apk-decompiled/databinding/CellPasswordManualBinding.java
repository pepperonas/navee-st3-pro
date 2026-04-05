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
public final class CellPasswordManualBinding implements ViewBinding {

    @NonNull
    public final ImageView indicator;

    @NonNull
    public final ImageView ivLock1;

    @NonNull
    public final ImageView ivLock2;

    @NonNull
    public final ImageView ivLock3;

    @NonNull
    public final SwitchCompat mSwitch;

    @NonNull
    public final LinearLayout pwdSetAccessoryView;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView subtitleLabel;

    @NonNull
    public final TextView titleLabel;

    @NonNull
    public final TextView tvLock1;

    private CellPasswordManualBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull SwitchCompat switchCompat, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = constraintLayout;
        this.indicator = imageView;
        this.ivLock1 = imageView2;
        this.ivLock2 = imageView3;
        this.ivLock3 = imageView4;
        this.mSwitch = switchCompat;
        this.pwdSetAccessoryView = linearLayout;
        this.subtitleLabel = textView;
        this.titleLabel = textView2;
        this.tvLock1 = textView3;
    }

    @NonNull
    public static CellPasswordManualBinding bind(@NonNull View view) {
        int i6 = R$id.indicator;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
        if (imageView != null) {
            i6 = R$id.iv_lock_1;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i6);
            if (imageView2 != null) {
                i6 = R$id.iv_lock_2;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i6);
                if (imageView3 != null) {
                    i6 = R$id.iv_lock_3;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i6);
                    if (imageView4 != null) {
                        i6 = R$id.mSwitch;
                        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i6);
                        if (switchCompat != null) {
                            i6 = R$id.pwdSetAccessoryView;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                            if (linearLayout != null) {
                                i6 = R$id.subtitleLabel;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
                                if (textView != null) {
                                    i6 = R$id.titleLabel;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                                    if (textView2 != null) {
                                        i6 = R$id.tv_lock_1;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i6);
                                        if (textView3 != null) {
                                            return new CellPasswordManualBinding((ConstraintLayout) view, imageView, imageView2, imageView3, imageView4, switchCompat, linearLayout, textView, textView2, textView3);
                                        }
                                    }
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
    public static CellPasswordManualBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static CellPasswordManualBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.cell_password_manual, viewGroup, false);
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
