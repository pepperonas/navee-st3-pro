package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ActivityGaojingListBinding implements ViewBinding {

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final RecyclerView recyclerView;

    @NonNull
    private final ConstraintLayout rootView;

    private ActivityGaojingListBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ToolbarBinding toolbarBinding, @NonNull RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.include = toolbarBinding;
        this.recyclerView = recyclerView;
    }

    @NonNull
    public static ActivityGaojingListBinding bind(@NonNull View view) {
        int i6 = R$id.include;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, i6);
        if (viewFindChildViewById != null) {
            ToolbarBinding toolbarBindingBind = ToolbarBinding.bind(viewFindChildViewById);
            int i7 = R$id.recyclerView;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i7);
            if (recyclerView != null) {
                return new ActivityGaojingListBinding((ConstraintLayout) view, toolbarBindingBind, recyclerView);
            }
            i6 = i7;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ActivityGaojingListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityGaojingListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_gaojing_list, viewGroup, false);
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
