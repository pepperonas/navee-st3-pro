package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ActivityPolicyRevokeBinding implements ViewBinding {

    @NonNull
    public final Button confirmButton;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final ConstraintLayout main;

    @NonNull
    public final ProgressBar progressBar;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final WebView webView;

    private ActivityPolicyRevokeBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Button button, @NonNull ToolbarBinding toolbarBinding, @NonNull ConstraintLayout constraintLayout2, @NonNull ProgressBar progressBar, @NonNull WebView webView) {
        this.rootView = constraintLayout;
        this.confirmButton = button;
        this.include = toolbarBinding;
        this.main = constraintLayout2;
        this.progressBar = progressBar;
        this.webView = webView;
    }

    @NonNull
    public static ActivityPolicyRevokeBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.confirmButton;
        Button button = (Button) ViewBindings.findChildViewById(view, i6);
        if (button != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.include))) != null) {
            ToolbarBinding toolbarBindingBind = ToolbarBinding.bind(viewFindChildViewById);
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i6 = R$id.progress_bar;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i6);
            if (progressBar != null) {
                i6 = R$id.webView;
                WebView webView = (WebView) ViewBindings.findChildViewById(view, i6);
                if (webView != null) {
                    return new ActivityPolicyRevokeBinding(constraintLayout, button, toolbarBindingBind, constraintLayout, progressBar, webView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ActivityPolicyRevokeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityPolicyRevokeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_policy_revoke, viewGroup, false);
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
