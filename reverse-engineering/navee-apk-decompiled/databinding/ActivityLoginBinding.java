package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundLinearLayout;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public abstract class ActivityLoginBinding extends ViewDataBinding {

    @NonNull
    public final ImageButton agreeButton;

    @NonNull
    public final TextView btnSubmit;

    @NonNull
    public final EditText etInputEmail;

    @NonNull
    public final EditText etInputPwd;

    @NonNull
    public final QMUIRoundLinearLayout facebookButton;

    @NonNull
    public final Guideline glCenter;

    @NonNull
    public final QMUIRoundLinearLayout googleButton;

    @NonNull
    public final Toolbar2Binding include;

    @NonNull
    public final ImageView ivPwd;

    @NonNull
    public final LinearLayout layoutAgree;

    @NonNull
    public final LinearLayout layoutOther;

    @NonNull
    public final LinearLayout layoutTop;

    @NonNull
    public final ProgressBar loginLoading;

    @Bindable
    protected ObservableField<String> mInputIdStr;

    @Bindable
    protected ObservableField<String> mInputPswStr;

    @Bindable
    protected ObservableBoolean mSignTypeEmail;

    @NonNull
    public final TextView tipsView;

    @NonNull
    public final TextView tvAgree;

    @NonNull
    public final TextView tvForgetPwd;

    @NonNull
    public final TextView tvSignWithAc;

    @NonNull
    public final TextView tvSignWithEmail;

    @NonNull
    public final View vDivider;

    public ActivityLoginBinding(Object obj, View view, int i6, ImageButton imageButton, TextView textView, EditText editText, EditText editText2, QMUIRoundLinearLayout qMUIRoundLinearLayout, Guideline guideline, QMUIRoundLinearLayout qMUIRoundLinearLayout2, Toolbar2Binding toolbar2Binding, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ProgressBar progressBar, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, View view2) {
        super(obj, view, i6);
        this.agreeButton = imageButton;
        this.btnSubmit = textView;
        this.etInputEmail = editText;
        this.etInputPwd = editText2;
        this.facebookButton = qMUIRoundLinearLayout;
        this.glCenter = guideline;
        this.googleButton = qMUIRoundLinearLayout2;
        this.include = toolbar2Binding;
        this.ivPwd = imageView;
        this.layoutAgree = linearLayout;
        this.layoutOther = linearLayout2;
        this.layoutTop = linearLayout3;
        this.loginLoading = progressBar;
        this.tipsView = textView2;
        this.tvAgree = textView3;
        this.tvForgetPwd = textView4;
        this.tvSignWithAc = textView5;
        this.tvSignWithEmail = textView6;
        this.vDivider = view2;
    }

    public static ActivityLoginBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityLoginBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public ObservableField<String> getInputIdStr() {
        return this.mInputIdStr;
    }

    @Nullable
    public ObservableField<String> getInputPswStr() {
        return this.mInputPswStr;
    }

    @Nullable
    public ObservableBoolean getSignTypeEmail() {
        return this.mSignTypeEmail;
    }

    public abstract void setInputIdStr(@Nullable ObservableField<String> observableField);

    public abstract void setInputPswStr(@Nullable ObservableField<String> observableField);

    public abstract void setSignTypeEmail(@Nullable ObservableBoolean observableBoolean);

    @Deprecated
    public static ActivityLoginBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityLoginBinding) ViewDataBinding.bind(obj, view, R$layout.activity_login);
    }

    @NonNull
    @Deprecated
    public static ActivityLoginBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ActivityLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_login, viewGroup, z6, obj);
    }

    @NonNull
    public static ActivityLoginBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityLoginBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_login, null, false, obj);
    }
}
