package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
public final class PopupAlertBinding implements ViewBinding {

    @NonNull
    public final Button cancelButton;

    @NonNull
    public final Button confirmButton;

    @NonNull
    public final LinearLayout layoutAction;

    @NonNull
    public final LinearLayout layoutText;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView tvMessage;

    @NonNull
    public final TextView tvTitle;

    private PopupAlertBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Button button, @NonNull Button button2, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.cancelButton = button;
        this.confirmButton = button2;
        this.layoutAction = linearLayout;
        this.layoutText = linearLayout2;
        this.tvMessage = textView;
        this.tvTitle = textView2;
    }

    @NonNull
    public static PopupAlertBinding bind(@NonNull View view) {
        int i6 = R$id.cancelButton;
        Button button = (Button) ViewBindings.findChildViewById(view, i6);
        if (button != null) {
            i6 = R$id.confirmButton;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i6);
            if (button2 != null) {
                i6 = R$id.layout_action;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                if (linearLayout != null) {
                    i6 = R$id.layout_text;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                    if (linearLayout2 != null) {
                        i6 = R$id.tv_message;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
                        if (textView != null) {
                            i6 = R$id.tv_title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                            if (textView2 != null) {
                                return new PopupAlertBinding((ConstraintLayout) view, button, button2, linearLayout, linearLayout2, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static PopupAlertBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PopupAlertBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.popup_alert, viewGroup, false);
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
