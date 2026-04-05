package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ActivityChangePwdBinding implements ViewBinding {

    @NonNull
    public final Button btnOk;

    @NonNull
    public final EditText etNewPwd;

    @NonNull
    public final EditText etOldPwd;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final ImageView ivNewPwd;

    @NonNull
    public final ImageView ivOldPwd;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView tipsView;

    @NonNull
    public final TextView tvForgetPwd;

    private ActivityChangePwdBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Button button, @NonNull EditText editText, @NonNull EditText editText2, @NonNull ToolbarBinding toolbarBinding, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.btnOk = button;
        this.etNewPwd = editText;
        this.etOldPwd = editText2;
        this.include = toolbarBinding;
        this.ivNewPwd = imageView;
        this.ivOldPwd = imageView2;
        this.tipsView = textView;
        this.tvForgetPwd = textView2;
    }

    @NonNull
    public static ActivityChangePwdBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.btn_ok;
        Button button = (Button) ViewBindings.findChildViewById(view, i6);
        if (button != null) {
            i6 = R$id.et_new_pwd;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i6);
            if (editText != null) {
                i6 = R$id.et_old_pwd;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i6);
                if (editText2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.include))) != null) {
                    ToolbarBinding toolbarBindingBind = ToolbarBinding.bind(viewFindChildViewById);
                    i6 = R$id.iv_new_pwd;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
                    if (imageView != null) {
                        i6 = R$id.iv_old_pwd;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i6);
                        if (imageView2 != null) {
                            i6 = R$id.tipsView;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
                            if (textView != null) {
                                i6 = R$id.tv_forget_pwd;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                                if (textView2 != null) {
                                    return new ActivityChangePwdBinding((ConstraintLayout) view, button, editText, editText2, toolbarBindingBind, imageView, imageView2, textView, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ActivityChangePwdBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityChangePwdBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_change_pwd, viewGroup, false);
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
