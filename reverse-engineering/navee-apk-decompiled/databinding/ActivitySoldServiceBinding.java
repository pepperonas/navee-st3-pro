package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ActivitySoldServiceBinding implements ViewBinding {

    @NonNull
    public final TextView desLabel;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final ConstraintLayout main;

    @NonNull
    public final TextView officialLabel;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView timeLabel;

    @NonNull
    public final TextView titleLabel;

    private ActivitySoldServiceBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ToolbarBinding toolbarBinding, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.rootView = constraintLayout;
        this.desLabel = textView;
        this.include = toolbarBinding;
        this.main = constraintLayout2;
        this.officialLabel = textView2;
        this.timeLabel = textView3;
        this.titleLabel = textView4;
    }

    @NonNull
    public static ActivitySoldServiceBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.desLabel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
        if (textView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.include))) != null) {
            ToolbarBinding toolbarBindingBind = ToolbarBinding.bind(viewFindChildViewById);
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i6 = R$id.officialLabel;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
            if (textView2 != null) {
                i6 = R$id.timeLabel;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i6);
                if (textView3 != null) {
                    i6 = R$id.titleLabel;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i6);
                    if (textView4 != null) {
                        return new ActivitySoldServiceBinding(constraintLayout, textView, toolbarBindingBind, constraintLayout, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ActivitySoldServiceBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivitySoldServiceBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_sold_service, viewGroup, false);
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
