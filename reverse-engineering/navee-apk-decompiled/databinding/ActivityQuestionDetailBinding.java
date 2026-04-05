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
public final class ActivityQuestionDetailBinding implements ViewBinding {

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView tvIssue;

    @NonNull
    public final TextView tvReply;

    private ActivityQuestionDetailBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ToolbarBinding toolbarBinding, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.include = toolbarBinding;
        this.tvIssue = textView;
        this.tvReply = textView2;
    }

    @NonNull
    public static ActivityQuestionDetailBinding bind(@NonNull View view) {
        int i6 = R$id.include;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, i6);
        if (viewFindChildViewById != null) {
            ToolbarBinding toolbarBindingBind = ToolbarBinding.bind(viewFindChildViewById);
            int i7 = R$id.tv_issue;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i7);
            if (textView != null) {
                i7 = R$id.tv_reply;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i7);
                if (textView2 != null) {
                    return new ActivityQuestionDetailBinding((ConstraintLayout) view, toolbarBindingBind, textView, textView2);
                }
            }
            i6 = i7;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ActivityQuestionDetailBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityQuestionDetailBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_question_detail, viewGroup, false);
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
