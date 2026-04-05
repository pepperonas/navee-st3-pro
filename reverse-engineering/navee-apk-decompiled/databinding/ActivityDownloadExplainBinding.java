package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public abstract class ActivityDownloadExplainBinding extends ViewDataBinding {

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final TextView tvContent;

    @NonNull
    public final TextView tvTitle;

    public ActivityDownloadExplainBinding(Object obj, View view, int i6, ToolbarBinding toolbarBinding, TextView textView, TextView textView2) {
        super(obj, view, i6);
        this.include = toolbarBinding;
        this.tvContent = textView;
        this.tvTitle = textView2;
    }

    public static ActivityDownloadExplainBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityDownloadExplainBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDownloadExplainBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityDownloadExplainBinding) ViewDataBinding.bind(obj, view, R$layout.activity_download_explain);
    }

    @NonNull
    @Deprecated
    public static ActivityDownloadExplainBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ActivityDownloadExplainBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_download_explain, viewGroup, z6, obj);
    }

    @NonNull
    public static ActivityDownloadExplainBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityDownloadExplainBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityDownloadExplainBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_download_explain, null, false, obj);
    }
}
