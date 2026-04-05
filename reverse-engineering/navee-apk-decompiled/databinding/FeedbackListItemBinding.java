package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class FeedbackListItemBinding implements ViewBinding {

    @NonNull
    public final TextView icoUnread;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final TextView text1;

    @NonNull
    public final TextView tvGaojingMsg;

    private FeedbackListItemBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = linearLayout;
        this.icoUnread = textView;
        this.text1 = textView2;
        this.tvGaojingMsg = textView3;
    }

    @NonNull
    public static FeedbackListItemBinding bind(@NonNull View view) {
        int i6 = R$id.icoUnread;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
        if (textView != null) {
            i6 = R$id.text1;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
            if (textView2 != null) {
                i6 = R$id.tv_gaojing_msg;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i6);
                if (textView3 != null) {
                    return new FeedbackListItemBinding((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static FeedbackListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FeedbackListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.feedback_list_item, viewGroup, false);
        if (z6) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
