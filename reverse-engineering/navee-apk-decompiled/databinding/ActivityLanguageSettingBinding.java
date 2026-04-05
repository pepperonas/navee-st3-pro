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
public final class ActivityLanguageSettingBinding implements ViewBinding {

    @NonNull
    public final QMUIGroupListView groupListView;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    private final ConstraintLayout rootView;

    private ActivityLanguageSettingBinding(@NonNull ConstraintLayout constraintLayout, @NonNull QMUIGroupListView qMUIGroupListView, @NonNull ToolbarBinding toolbarBinding) {
        this.rootView = constraintLayout;
        this.groupListView = qMUIGroupListView;
        this.include = toolbarBinding;
    }

    @NonNull
    public static ActivityLanguageSettingBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.groupListView;
        QMUIGroupListView qMUIGroupListView = (QMUIGroupListView) ViewBindings.findChildViewById(view, i6);
        if (qMUIGroupListView == null || (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.include))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
        }
        return new ActivityLanguageSettingBinding((ConstraintLayout) view, qMUIGroupListView, ToolbarBinding.bind(viewFindChildViewById));
    }

    @NonNull
    public static ActivityLanguageSettingBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityLanguageSettingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_language_setting, viewGroup, false);
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
