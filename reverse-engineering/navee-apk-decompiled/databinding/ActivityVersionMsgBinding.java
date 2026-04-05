package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public final class ActivityVersionMsgBinding implements ViewBinding {

    @NonNull
    public final ImageView IVLogo;

    @NonNull
    public final TextView TVVersionNo;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView tvCompanyProfile;

    private ActivityVersionMsgBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ToolbarBinding toolbarBinding, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.IVLogo = imageView;
        this.TVVersionNo = textView;
        this.include = toolbarBinding;
        this.tvCompanyProfile = textView2;
    }

    @NonNull
    public static ActivityVersionMsgBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.IV_logo;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
        if (imageView != null) {
            i6 = R$id.TV_version_no;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
            if (textView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.include))) != null) {
                ToolbarBinding toolbarBindingBind = ToolbarBinding.bind(viewFindChildViewById);
                i6 = R$id.tv_company_profile;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                if (textView2 != null) {
                    return new ActivityVersionMsgBinding((ConstraintLayout) view, imageView, textView, toolbarBindingBind, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ActivityVersionMsgBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityVersionMsgBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_version_msg, viewGroup, false);
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
