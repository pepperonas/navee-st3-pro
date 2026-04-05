package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ViewDataStatusBinding implements ViewBinding {

    @NonNull
    public final Button actionButton;

    @NonNull
    public final View leftLine;

    @NonNull
    public final View rightLine;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final TextView textLabel;

    private ViewDataStatusBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull View view, @NonNull View view2, @NonNull TextView textView) {
        this.rootView = linearLayout;
        this.actionButton = button;
        this.leftLine = view;
        this.rightLine = view2;
        this.textLabel = textView;
    }

    @NonNull
    public static ViewDataStatusBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i6 = R$id.actionButton;
        Button button = (Button) ViewBindings.findChildViewById(view, i6);
        if (button != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.leftLine))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i6 = R$id.rightLine))) != null) {
            i6 = R$id.textLabel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
            if (textView != null) {
                return new ViewDataStatusBinding((LinearLayout) view, button, viewFindChildViewById, viewFindChildViewById2, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ViewDataStatusBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ViewDataStatusBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.view_data_status, viewGroup, false);
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
