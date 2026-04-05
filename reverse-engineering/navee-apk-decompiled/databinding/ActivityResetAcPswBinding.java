package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public abstract class ActivityResetAcPswBinding extends ViewDataBinding {

    @NonNull
    public final Toolbar2Binding include;

    @Bindable
    protected ObservableField<String> mInputCodeStr;

    @Bindable
    protected ObservableField<String> mInputIdStr;

    @Bindable
    protected ObservableField<String> mInputPswStr;

    @NonNull
    public final TextView tvContent;

    @NonNull
    public final TextView tvTitle;

    public ActivityResetAcPswBinding(Object obj, View view, int i6, Toolbar2Binding toolbar2Binding, TextView textView, TextView textView2) {
        super(obj, view, i6);
        this.include = toolbar2Binding;
        this.tvContent = textView;
        this.tvTitle = textView2;
    }

    public static ActivityResetAcPswBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityResetAcPswBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public ObservableField<String> getInputCodeStr() {
        return this.mInputCodeStr;
    }

    @Nullable
    public ObservableField<String> getInputIdStr() {
        return this.mInputIdStr;
    }

    @Nullable
    public ObservableField<String> getInputPswStr() {
        return this.mInputPswStr;
    }

    public abstract void setInputCodeStr(@Nullable ObservableField<String> observableField);

    public abstract void setInputIdStr(@Nullable ObservableField<String> observableField);

    public abstract void setInputPswStr(@Nullable ObservableField<String> observableField);

    @Deprecated
    public static ActivityResetAcPswBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityResetAcPswBinding) ViewDataBinding.bind(obj, view, R$layout.activity_reset_ac_psw);
    }

    @NonNull
    @Deprecated
    public static ActivityResetAcPswBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ActivityResetAcPswBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_reset_ac_psw, viewGroup, z6, obj);
    }

    @NonNull
    public static ActivityResetAcPswBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityResetAcPswBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityResetAcPswBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_reset_ac_psw, null, false, obj);
    }
}
