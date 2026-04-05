package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public abstract class ActivityDataDownloadBinding extends ViewDataBinding {

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final AppCompatImageView ivDownload;

    @NonNull
    public final AppCompatImageView ivLogo;

    @NonNull
    public final TextView tvAppName;

    @NonNull
    public final TextView tvDownloadRecord;

    @NonNull
    public final TextView tvTips;

    @NonNull
    public final View vDivider;

    public ActivityDataDownloadBinding(Object obj, View view, int i6, ToolbarBinding toolbarBinding, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView, TextView textView2, TextView textView3, View view2) {
        super(obj, view, i6);
        this.include = toolbarBinding;
        this.ivDownload = appCompatImageView;
        this.ivLogo = appCompatImageView2;
        this.tvAppName = textView;
        this.tvDownloadRecord = textView2;
        this.tvTips = textView3;
        this.vDivider = view2;
    }

    public static ActivityDataDownloadBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityDataDownloadBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDataDownloadBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityDataDownloadBinding) ViewDataBinding.bind(obj, view, R$layout.activity_data_download);
    }

    @NonNull
    @Deprecated
    public static ActivityDataDownloadBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ActivityDataDownloadBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_data_download, viewGroup, z6, obj);
    }

    @NonNull
    public static ActivityDataDownloadBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityDataDownloadBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityDataDownloadBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_data_download, null, false, obj);
    }
}
