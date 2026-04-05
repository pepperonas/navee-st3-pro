package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.ui.mine.ChangeEmailInputView;

/* loaded from: classes3.dex */
public final class ActivityChangeEmailBinding implements ViewBinding {

    @NonNull
    public final ChangeEmailInputView codeInputView;

    @NonNull
    public final ChangeEmailInputView emailInputView;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final Button nextButton;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView tipsView;

    private ActivityChangeEmailBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ChangeEmailInputView changeEmailInputView, @NonNull ChangeEmailInputView changeEmailInputView2, @NonNull ToolbarBinding toolbarBinding, @NonNull Button button, @NonNull TextView textView) {
        this.rootView = constraintLayout;
        this.codeInputView = changeEmailInputView;
        this.emailInputView = changeEmailInputView2;
        this.include = toolbarBinding;
        this.nextButton = button;
        this.tipsView = textView;
    }

    @NonNull
    public static ActivityChangeEmailBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.codeInputView;
        ChangeEmailInputView changeEmailInputView = (ChangeEmailInputView) ViewBindings.findChildViewById(view, i6);
        if (changeEmailInputView != null) {
            i6 = R$id.emailInputView;
            ChangeEmailInputView changeEmailInputView2 = (ChangeEmailInputView) ViewBindings.findChildViewById(view, i6);
            if (changeEmailInputView2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.include))) != null) {
                ToolbarBinding toolbarBindingBind = ToolbarBinding.bind(viewFindChildViewById);
                i6 = R$id.nextButton;
                Button button = (Button) ViewBindings.findChildViewById(view, i6);
                if (button != null) {
                    i6 = R$id.tipsView;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
                    if (textView != null) {
                        return new ActivityChangeEmailBinding((ConstraintLayout) view, changeEmailInputView, changeEmailInputView2, toolbarBindingBind, button, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ActivityChangeEmailBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityChangeEmailBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_change_email, viewGroup, false);
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
