package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$layout;
import com.uz.navee.ui.web.DefaultWebView;

/* loaded from: classes3.dex */
public abstract class FragmentWebBinding extends ViewDataBinding {

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final LinearLayout llRoot;

    @NonNull
    public final ProgressBar progressBar;

    @NonNull
    public final DefaultWebView webView;

    public FragmentWebBinding(Object obj, View view, int i6, ToolbarBinding toolbarBinding, LinearLayout linearLayout, ProgressBar progressBar, DefaultWebView defaultWebView) {
        super(obj, view, i6);
        this.include = toolbarBinding;
        this.llRoot = linearLayout;
        this.progressBar = progressBar;
        this.webView = defaultWebView;
    }

    public static FragmentWebBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentWebBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWebBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentWebBinding) ViewDataBinding.bind(obj, view, R$layout.fragment_web);
    }

    @NonNull
    @Deprecated
    public static FragmentWebBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (FragmentWebBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.fragment_web, viewGroup, z6, obj);
    }

    @NonNull
    public static FragmentWebBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentWebBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentWebBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.fragment_web, null, false, obj);
    }
}
