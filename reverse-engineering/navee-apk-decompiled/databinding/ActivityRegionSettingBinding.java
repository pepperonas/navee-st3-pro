package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ActivityRegionSettingBinding implements ViewBinding {

    @NonNull
    public final QMUIGroupListView groupListView;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final SearchView searchView;

    private ActivityRegionSettingBinding(@NonNull ConstraintLayout constraintLayout, @NonNull QMUIGroupListView qMUIGroupListView, @NonNull ToolbarBinding toolbarBinding, @NonNull SearchView searchView) {
        this.rootView = constraintLayout;
        this.groupListView = qMUIGroupListView;
        this.include = toolbarBinding;
        this.searchView = searchView;
    }

    @NonNull
    public static ActivityRegionSettingBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.groupListView;
        QMUIGroupListView qMUIGroupListView = (QMUIGroupListView) ViewBindings.findChildViewById(view, i6);
        if (qMUIGroupListView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.include))) != null) {
            ToolbarBinding toolbarBindingBind = ToolbarBinding.bind(viewFindChildViewById);
            int i7 = R$id.searchView;
            SearchView searchView = (SearchView) ViewBindings.findChildViewById(view, i7);
            if (searchView != null) {
                return new ActivityRegionSettingBinding((ConstraintLayout) view, qMUIGroupListView, toolbarBindingBind, searchView);
            }
            i6 = i7;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ActivityRegionSettingBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityRegionSettingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_region_setting, viewGroup, false);
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
