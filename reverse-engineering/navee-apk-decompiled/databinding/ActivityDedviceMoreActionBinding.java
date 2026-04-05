package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.uz.navee.R$layout;
import com.uz.navee.ui.wheel.DataStatusView;

/* loaded from: classes3.dex */
public abstract class ActivityDedviceMoreActionBinding extends ViewDataBinding {

    @NonNull
    public final QMUIGroupListView glvAction;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final DataStatusView statusView;

    public ActivityDedviceMoreActionBinding(Object obj, View view, int i6, QMUIGroupListView qMUIGroupListView, ToolbarBinding toolbarBinding, DataStatusView dataStatusView) {
        super(obj, view, i6);
        this.glvAction = qMUIGroupListView;
        this.include = toolbarBinding;
        this.statusView = dataStatusView;
    }

    public static ActivityDedviceMoreActionBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityDedviceMoreActionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDedviceMoreActionBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityDedviceMoreActionBinding) ViewDataBinding.bind(obj, view, R$layout.activity_dedvice_more_action);
    }

    @NonNull
    @Deprecated
    public static ActivityDedviceMoreActionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ActivityDedviceMoreActionBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_dedvice_more_action, viewGroup, z6, obj);
    }

    @NonNull
    public static ActivityDedviceMoreActionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityDedviceMoreActionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityDedviceMoreActionBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_dedvice_more_action, null, false, obj);
    }
}
