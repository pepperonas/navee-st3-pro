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
public final class CellPasswordLockBinding implements ViewBinding {

    @NonNull
    public final ImageView indicator;

    @NonNull
    public final SwitchCompat mSwitch;

    @NonNull
    public final LinearLayout pwdChangeAccessoryView;

    @NonNull
    public final ConstraintLayout pwdChangeLayout;

    @NonNull
    public final TextView pwdChangeTitleLabel;

    @NonNull
    public final LinearLayout pwdSetAccessoryView;

    @NonNull
    public final ConstraintLayout pwdSetLayout;

    @NonNull
    public final LinearLayout pwdViewAccessoryView;

    @NonNull
    public final ConstraintLayout pwdViewLayout;

    @NonNull
    public final TextView pwdViewTitleLabel;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final View separatorLine;

    @NonNull
    public final TextView subtitleLabel;

    @NonNull
    public final TextView titleLabel;

    private CellPasswordLockBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull SwitchCompat switchCompat, @NonNull LinearLayout linearLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull LinearLayout linearLayout3, @NonNull ConstraintLayout constraintLayout4, @NonNull TextView textView2, @NonNull View view, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.rootView = constraintLayout;
        this.indicator = imageView;
        this.mSwitch = switchCompat;
        this.pwdChangeAccessoryView = linearLayout;
        this.pwdChangeLayout = constraintLayout2;
        this.pwdChangeTitleLabel = textView;
        this.pwdSetAccessoryView = linearLayout2;
        this.pwdSetLayout = constraintLayout3;
        this.pwdViewAccessoryView = linearLayout3;
        this.pwdViewLayout = constraintLayout4;
        this.pwdViewTitleLabel = textView2;
        this.separatorLine = view;
        this.subtitleLabel = textView3;
        this.titleLabel = textView4;
    }

    @NonNull
    public static CellPasswordLockBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.indicator;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
        if (imageView != null) {
            i6 = R$id.mSwitch;
            SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i6);
            if (switchCompat != null) {
                i6 = R$id.pwdChangeAccessoryView;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                if (linearLayout != null) {
                    i6 = R$id.pwdChangeLayout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i6);
                    if (constraintLayout != null) {
                        i6 = R$id.pwdChangeTitleLabel;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
                        if (textView != null) {
                            i6 = R$id.pwdSetAccessoryView;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                            if (linearLayout2 != null) {
                                i6 = R$id.pwdSetLayout;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i6);
                                if (constraintLayout2 != null) {
                                    i6 = R$id.pwdViewAccessoryView;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                    if (linearLayout3 != null) {
                                        i6 = R$id.pwdViewLayout;
                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i6);
                                        if (constraintLayout3 != null) {
                                            i6 = R$id.pwdViewTitleLabel;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                                            if (textView2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.separatorLine))) != null) {
                                                i6 = R$id.subtitleLabel;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                if (textView3 != null) {
                                                    i6 = R$id.titleLabel;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                    if (textView4 != null) {
                                                        return new CellPasswordLockBinding((ConstraintLayout) view, imageView, switchCompat, linearLayout, constraintLayout, textView, linearLayout2, constraintLayout2, linearLayout3, constraintLayout3, textView2, viewFindChildViewById, textView3, textView4);
                                                    }
                                                }
                                            }
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
    public static CellPasswordLockBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static CellPasswordLockBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.cell_password_lock, viewGroup, false);
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
