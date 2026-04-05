package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
public final class ActivityDeviceInfoBinding implements ViewBinding {

    @NonNull
    public final TextView activeTimeLabel;

    @NonNull
    public final TextView deviceNameLabel;

    @NonNull
    public final ImageButton editButton;

    @NonNull
    public final QMUIGroupListView groupListView;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    private final ConstraintLayout rootView;

    private ActivityDeviceInfoBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageButton imageButton, @NonNull QMUIGroupListView qMUIGroupListView, @NonNull ToolbarBinding toolbarBinding) {
        this.rootView = constraintLayout;
        this.activeTimeLabel = textView;
        this.deviceNameLabel = textView2;
        this.editButton = imageButton;
        this.groupListView = qMUIGroupListView;
        this.include = toolbarBinding;
    }

    @NonNull
    public static ActivityDeviceInfoBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.activeTimeLabel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
        if (textView != null) {
            i6 = R$id.deviceNameLabel;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
            if (textView2 != null) {
                i6 = R$id.editButton;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i6);
                if (imageButton != null) {
                    i6 = R$id.groupListView;
                    QMUIGroupListView qMUIGroupListView = (QMUIGroupListView) ViewBindings.findChildViewById(view, i6);
                    if (qMUIGroupListView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.include))) != null) {
                        return new ActivityDeviceInfoBinding((ConstraintLayout) view, textView, textView2, imageButton, qMUIGroupListView, ToolbarBinding.bind(viewFindChildViewById));
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ActivityDeviceInfoBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityDeviceInfoBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_device_info, viewGroup, false);
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
