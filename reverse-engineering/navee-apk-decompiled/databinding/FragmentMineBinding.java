package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class FragmentMineBinding implements ViewBinding {

    @NonNull
    public final ImageView avatarView;

    @NonNull
    public final QMUIGroupListView groupListView;

    @NonNull
    public final ImageView ivIdentifierCopy;

    @NonNull
    public final LinearLayout llIdentifier;

    @NonNull
    public final TextView nameView;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView tvIdentifier;

    private FragmentMineBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull QMUIGroupListView qMUIGroupListView, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.avatarView = imageView;
        this.groupListView = qMUIGroupListView;
        this.ivIdentifierCopy = imageView2;
        this.llIdentifier = linearLayout;
        this.nameView = textView;
        this.tvIdentifier = textView2;
    }

    @NonNull
    public static FragmentMineBinding bind(@NonNull View view) {
        int i6 = R$id.avatarView;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
        if (imageView != null) {
            i6 = R$id.groupListView;
            QMUIGroupListView qMUIGroupListView = (QMUIGroupListView) ViewBindings.findChildViewById(view, i6);
            if (qMUIGroupListView != null) {
                i6 = R$id.iv_identifier_copy;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i6);
                if (imageView2 != null) {
                    i6 = R$id.ll_identifier;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                    if (linearLayout != null) {
                        i6 = R$id.nameView;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
                        if (textView != null) {
                            i6 = R$id.tv_identifier;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                            if (textView2 != null) {
                                return new FragmentMineBinding((ConstraintLayout) view, imageView, qMUIGroupListView, imageView2, linearLayout, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static FragmentMineBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentMineBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_mine, viewGroup, false);
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
