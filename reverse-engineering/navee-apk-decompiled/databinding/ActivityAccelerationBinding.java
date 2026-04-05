package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ActivityAccelerationBinding implements ViewBinding {

    @NonNull
    public final QMUIGroupListView groupListView;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final ConstraintLayout main;

    @NonNull
    private final ConstraintLayout rootView;

    private ActivityAccelerationBinding(@NonNull ConstraintLayout constraintLayout, @NonNull QMUIGroupListView qMUIGroupListView, @NonNull ToolbarBinding toolbarBinding, @NonNull ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.groupListView = qMUIGroupListView;
        this.include = toolbarBinding;
        this.main = constraintLayout2;
    }

    @NonNull
    public static ActivityAccelerationBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.groupListView;
        QMUIGroupListView qMUIGroupListView = (QMUIGroupListView) ViewBindings.findChildViewById(view, i6);
        if (qMUIGroupListView == null || (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.include))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        return new ActivityAccelerationBinding(constraintLayout, qMUIGroupListView, ToolbarBinding.bind(viewFindChildViewById), constraintLayout);
    }

    @NonNull
    public static ActivityAccelerationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityAccelerationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_acceleration, viewGroup, false);
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
