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
public final class FragmentMallBinding implements ViewBinding {

    @NonNull
    public final ProgressBar progressBar;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final WebView webView;

    private FragmentMallBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ProgressBar progressBar, @NonNull WebView webView) {
        this.rootView = constraintLayout;
        this.progressBar = progressBar;
        this.webView = webView;
    }

    @NonNull
    public static FragmentMallBinding bind(@NonNull View view) {
        int i6 = R$id.progress_bar;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i6);
        if (progressBar != null) {
            i6 = R$id.webView;
            WebView webView = (WebView) ViewBindings.findChildViewById(view, i6);
            if (webView != null) {
                return new FragmentMallBinding((ConstraintLayout) view, progressBar, webView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static FragmentMallBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentMallBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_mall, viewGroup, false);
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
