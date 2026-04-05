package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ActivitySoldSupportBinding implements ViewBinding {

    @NonNull
    public final TextView desLabel;

    @NonNull
    public final QMUIGroupListView groupListView;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final LinearLayout llSoldForeign;

    @NonNull
    public final LinearLayout llSoldInland;

    @NonNull
    public final ConstraintLayout main;

    @NonNull
    public final TextView officialLabel;

    @NonNull
    public final ImageView qrImageView;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView timeLabel;

    @NonNull
    public final TextView titleLabel;

    @NonNull
    public final TextView titleLabel2;

    private ActivitySoldSupportBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull QMUIGroupListView qMUIGroupListView, @NonNull ToolbarBinding toolbarBinding, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.rootView = constraintLayout;
        this.desLabel = textView;
        this.groupListView = qMUIGroupListView;
        this.include = toolbarBinding;
        this.llSoldForeign = linearLayout;
        this.llSoldInland = linearLayout2;
        this.main = constraintLayout2;
        this.officialLabel = textView2;
        this.qrImageView = imageView;
        this.timeLabel = textView3;
        this.titleLabel = textView4;
        this.titleLabel2 = textView5;
    }

    @NonNull
    public static ActivitySoldSupportBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.desLabel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
        if (textView != null) {
            i6 = R$id.groupListView;
            QMUIGroupListView qMUIGroupListView = (QMUIGroupListView) ViewBindings.findChildViewById(view, i6);
            if (qMUIGroupListView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.include))) != null) {
                ToolbarBinding toolbarBindingBind = ToolbarBinding.bind(viewFindChildViewById);
                i6 = R$id.ll_sold_foreign;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                if (linearLayout != null) {
                    i6 = R$id.ll_sold_inland;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                    if (linearLayout2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i6 = R$id.officialLabel;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                        if (textView2 != null) {
                            i6 = R$id.qrImageView;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
                            if (imageView != null) {
                                i6 = R$id.timeLabel;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i6);
                                if (textView3 != null) {
                                    i6 = R$id.titleLabel;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i6);
                                    if (textView4 != null) {
                                        i6 = R$id.titleLabel2;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i6);
                                        if (textView5 != null) {
                                            return new ActivitySoldSupportBinding(constraintLayout, textView, qMUIGroupListView, toolbarBindingBind, linearLayout, linearLayout2, constraintLayout, textView2, imageView, textView3, textView4, textView5);
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
    public static ActivitySoldSupportBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivitySoldSupportBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_sold_support, viewGroup, false);
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
