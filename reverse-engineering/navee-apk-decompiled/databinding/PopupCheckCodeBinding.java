package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class PopupCheckCodeBinding implements ViewBinding {

    @NonNull
    public final TextView btnSubmit;

    @NonNull
    public final EditText etCode;

    @NonNull
    public final ImageButton imgClose;

    @NonNull
    public final ImageView imgCode;

    @NonNull
    public final ProgressBar loading;

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final TextView titleLabel;

    @NonNull
    public final ImageButton tvRefresh;

    private PopupCheckCodeBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull EditText editText, @NonNull ImageButton imageButton, @NonNull ImageView imageView, @NonNull ProgressBar progressBar, @NonNull TextView textView2, @NonNull ImageButton imageButton2) {
        this.rootView = relativeLayout;
        this.btnSubmit = textView;
        this.etCode = editText;
        this.imgClose = imageButton;
        this.imgCode = imageView;
        this.loading = progressBar;
        this.titleLabel = textView2;
        this.tvRefresh = imageButton2;
    }

    @NonNull
    public static PopupCheckCodeBinding bind(@NonNull View view) {
        int i6 = R$id.btnSubmit;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
        if (textView != null) {
            i6 = R$id.etCode;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i6);
            if (editText != null) {
                i6 = R$id.imgClose;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i6);
                if (imageButton != null) {
                    i6 = R$id.imgCode;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
                    if (imageView != null) {
                        i6 = R$id.loading;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i6);
                        if (progressBar != null) {
                            i6 = R$id.titleLabel;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                            if (textView2 != null) {
                                i6 = R$id.tvRefresh;
                                ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                if (imageButton2 != null) {
                                    return new PopupCheckCodeBinding((RelativeLayout) view, textView, editText, imageButton, imageView, progressBar, textView2, imageButton2);
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
    public static PopupCheckCodeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PopupCheckCodeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.popup_check_code, viewGroup, false);
        if (z6) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
