package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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
public final class ActivityAccountSettingBinding implements ViewBinding {

    @NonNull
    public final Button btnLogout;

    @NonNull
    public final QMUIGroupListView groupListView;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final ImageView ivUserImg;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView tipsView;

    @NonNull
    public final TextView tvNickname;

    private ActivityAccountSettingBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Button button, @NonNull QMUIGroupListView qMUIGroupListView, @NonNull ToolbarBinding toolbarBinding, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.btnLogout = button;
        this.groupListView = qMUIGroupListView;
        this.include = toolbarBinding;
        this.ivUserImg = imageView;
        this.tipsView = textView;
        this.tvNickname = textView2;
    }

    @NonNull
    public static ActivityAccountSettingBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.btn_logout;
        Button button = (Button) ViewBindings.findChildViewById(view, i6);
        if (button != null) {
            i6 = R$id.groupListView;
            QMUIGroupListView qMUIGroupListView = (QMUIGroupListView) ViewBindings.findChildViewById(view, i6);
            if (qMUIGroupListView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.include))) != null) {
                ToolbarBinding toolbarBindingBind = ToolbarBinding.bind(viewFindChildViewById);
                i6 = R$id.iv_user_img;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
                if (imageView != null) {
                    i6 = R$id.tipsView;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
                    if (textView != null) {
                        i6 = R$id.tv_nickname;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                        if (textView2 != null) {
                            return new ActivityAccountSettingBinding((ConstraintLayout) view, button, qMUIGroupListView, toolbarBindingBind, imageView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ActivityAccountSettingBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityAccountSettingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_account_setting, viewGroup, false);
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
