package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ActivityUserAgreementPpBinding implements ViewBinding {

    @NonNull
    public final Button btnRevoke;

    @NonNull
    public final QMUIGroupListView groupListView;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    private final ConstraintLayout rootView;

    private ActivityUserAgreementPpBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Button button, @NonNull QMUIGroupListView qMUIGroupListView, @NonNull ToolbarBinding toolbarBinding) {
        this.rootView = constraintLayout;
        this.btnRevoke = button;
        this.groupListView = qMUIGroupListView;
        this.include = toolbarBinding;
    }

    @NonNull
    public static ActivityUserAgreementPpBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.btn_revoke;
        Button button = (Button) ViewBindings.findChildViewById(view, i6);
        if (button != null) {
            i6 = R$id.groupListView;
            QMUIGroupListView qMUIGroupListView = (QMUIGroupListView) ViewBindings.findChildViewById(view, i6);
            if (qMUIGroupListView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.include))) != null) {
                return new ActivityUserAgreementPpBinding((ConstraintLayout) view, button, qMUIGroupListView, ToolbarBinding.bind(viewFindChildViewById));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ActivityUserAgreementPpBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityUserAgreementPpBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_user_agreement_pp, viewGroup, false);
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
