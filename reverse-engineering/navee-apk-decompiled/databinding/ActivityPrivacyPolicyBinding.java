package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ActivityPrivacyPolicyBinding implements ViewBinding {

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final ProgressBar progressBar;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final WebView webView;

    private ActivityPrivacyPolicyBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ToolbarBinding toolbarBinding, @NonNull ProgressBar progressBar, @NonNull WebView webView) {
        this.rootView = constraintLayout;
        this.include = toolbarBinding;
        this.progressBar = progressBar;
        this.webView = webView;
    }

    @NonNull
    public static ActivityPrivacyPolicyBinding bind(@NonNull View view) {
        int i6 = R$id.include;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, i6);
        if (viewFindChildViewById != null) {
            ToolbarBinding toolbarBindingBind = ToolbarBinding.bind(viewFindChildViewById);
            int i7 = R$id.progress_bar;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i7);
            if (progressBar != null) {
                i7 = R$id.webView;
                WebView webView = (WebView) ViewBindings.findChildViewById(view, i7);
                if (webView != null) {
                    return new ActivityPrivacyPolicyBinding((ConstraintLayout) view, toolbarBindingBind, progressBar, webView);
                }
            }
            i6 = i7;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ActivityPrivacyPolicyBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityPrivacyPolicyBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_privacy_policy, viewGroup, false);
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
