package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.uz.navee.R$layout;
import com.uz.navee.ui.wheel.DataStatusView;

/* loaded from: classes3.dex */
public abstract class ActivityDownloadRecordBinding extends ViewDataBinding {

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final RecyclerView recyclerView;

    @NonNull
    public final DataStatusView statusView;

    public ActivityDownloadRecordBinding(Object obj, View view, int i6, ToolbarBinding toolbarBinding, RecyclerView recyclerView, DataStatusView dataStatusView) {
        super(obj, view, i6);
        this.include = toolbarBinding;
        this.recyclerView = recyclerView;
        this.statusView = dataStatusView;
    }

    public static ActivityDownloadRecordBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityDownloadRecordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDownloadRecordBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityDownloadRecordBinding) ViewDataBinding.bind(obj, view, R$layout.activity_download_record);
    }

    @NonNull
    @Deprecated
    public static ActivityDownloadRecordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ActivityDownloadRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_download_record, viewGroup, z6, obj);
    }

    @NonNull
    public static ActivityDownloadRecordBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityDownloadRecordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityDownloadRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_download_record, null, false, obj);
    }
}
