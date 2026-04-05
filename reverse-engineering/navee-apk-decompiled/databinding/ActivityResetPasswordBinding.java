package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$layout;
import com.uz.navee.ui.mine.ChangeEmailInputView;

/* loaded from: classes3.dex */
public abstract class ActivityResetPasswordBinding extends ViewDataBinding {

    @NonNull
    public final ImageButton agreeButton;

    @NonNull
    public final TextView btnSubmit;

    @NonNull
    public final ChangeEmailInputView codeInputView2;

    @NonNull
    public final EditText etInputEmail;

    @NonNull
    public final EditText etInputPwd;

    @NonNull
    public final Toolbar2Binding include;

    @NonNull
    public final ImageView ivPwd;

    @NonNull
    public final LinearLayout layoutAgree;

    @Bindable
    protected ObservableField<String> mInputCodeStr;

    @Bindable
    protected ObservableField<String> mInputIdStr;

    @Bindable
    protected ObservableField<String> mInputPswStr;

    @NonNull
    public final TextView tvAgree;

    public ActivityResetPasswordBinding(Object obj, View view, int i6, ImageButton imageButton, TextView textView, ChangeEmailInputView changeEmailInputView, EditText editText, EditText editText2, Toolbar2Binding toolbar2Binding, ImageView imageView, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i6);
        this.agreeButton = imageButton;
        this.btnSubmit = textView;
        this.codeInputView2 = changeEmailInputView;
        this.etInputEmail = editText;
        this.etInputPwd = editText2;
        this.include = toolbar2Binding;
        this.ivPwd = imageView;
        this.layoutAgree = linearLayout;
        this.tvAgree = textView2;
    }

    public static ActivityResetPasswordBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityResetPasswordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
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
    public static ActivityResetPasswordBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityResetPasswordBinding) ViewDataBinding.bind(obj, view, R$layout.activity_reset_password);
    }

    @NonNull
    @Deprecated
    public static ActivityResetPasswordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ActivityResetPasswordBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_reset_password, viewGroup, z6, obj);
    }

    @NonNull
    public static ActivityResetPasswordBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityResetPasswordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityResetPasswordBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_reset_password, null, false, obj);
    }
}
