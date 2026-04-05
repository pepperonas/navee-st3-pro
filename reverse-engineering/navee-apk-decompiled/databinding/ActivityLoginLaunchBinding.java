package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ActivityLoginLaunchBinding implements ViewBinding {

    @NonNull
    public final ImageButton agreeButton;

    @NonNull
    public final ImageView icoArea;

    @NonNull
    public final ImageView launchLogo;

    @NonNull
    public final LinearLayout layoutAgree;

    @NonNull
    public final Button loginBtn;

    @NonNull
    public final Button registerBtn;

    @NonNull
    public final ConstraintLayout root;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final View touchArea;

    @NonNull
    public final TextView tvArea;

    @NonNull
    public final TextView tvEnvironment;

    @NonNull
    public final TextView tvUserAgree;

    private ActivityLoginLaunchBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageButton imageButton, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull Button button2, @NonNull ConstraintLayout constraintLayout2, @NonNull View view, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = constraintLayout;
        this.agreeButton = imageButton;
        this.icoArea = imageView;
        this.launchLogo = imageView2;
        this.layoutAgree = linearLayout;
        this.loginBtn = button;
        this.registerBtn = button2;
        this.root = constraintLayout2;
        this.touchArea = view;
        this.tvArea = textView;
        this.tvEnvironment = textView2;
        this.tvUserAgree = textView3;
    }

    @NonNull
    public static ActivityLoginLaunchBinding bind(@NonNull View view) {
        int i6 = R$id.agreeButton;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i6);
        if (imageButton != null) {
            i6 = R$id.icoArea;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
            if (imageView != null) {
                i6 = R$id.launchLogo;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i6);
                if (imageView2 != null) {
                    i6 = R$id.layout_agree;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                    if (linearLayout != null) {
                        i6 = R$id.login_btn;
                        Button button = (Button) ViewBindings.findChildViewById(view, i6);
                        if (button != null) {
                            i6 = R$id.register_btn;
                            Button button2 = (Button) ViewBindings.findChildViewById(view, i6);
                            if (button2 != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                i6 = R$id.touchArea;
                                View viewFindChildViewById = ViewBindings.findChildViewById(view, i6);
                                if (viewFindChildViewById != null) {
                                    i6 = R$id.tvArea;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
                                    if (textView != null) {
                                        i6 = R$id.tvEnvironment;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                                        if (textView2 != null) {
                                            i6 = R$id.tv_user_agree;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i6);
                                            if (textView3 != null) {
                                                return new ActivityLoginLaunchBinding(constraintLayout, imageButton, imageView, imageView2, linearLayout, button, button2, constraintLayout, viewFindChildViewById, textView, textView2, textView3);
                                            }
                                        }
                                    }
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
    public static ActivityLoginLaunchBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityLoginLaunchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_login_launch, viewGroup, false);
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
