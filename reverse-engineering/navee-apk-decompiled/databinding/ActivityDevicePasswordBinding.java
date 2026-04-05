package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.ui.wheel.GridCodeEditView;

/* loaded from: classes3.dex */
public final class ActivityDevicePasswordBinding implements ViewBinding {

    @NonNull
    public final GridCodeEditView codeEditView;

    @NonNull
    public final Button confirmButton;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final ConstraintLayout main;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView titleLabel;

    private ActivityDevicePasswordBinding(@NonNull ConstraintLayout constraintLayout, @NonNull GridCodeEditView gridCodeEditView, @NonNull Button button, @NonNull ToolbarBinding toolbarBinding, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView) {
        this.rootView = constraintLayout;
        this.codeEditView = gridCodeEditView;
        this.confirmButton = button;
        this.include = toolbarBinding;
        this.main = constraintLayout2;
        this.titleLabel = textView;
    }

    @NonNull
    public static ActivityDevicePasswordBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.codeEditView;
        GridCodeEditView gridCodeEditView = (GridCodeEditView) ViewBindings.findChildViewById(view, i6);
        if (gridCodeEditView != null) {
            i6 = R$id.confirmButton;
            Button button = (Button) ViewBindings.findChildViewById(view, i6);
            if (button != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.include))) != null) {
                ToolbarBinding toolbarBindingBind = ToolbarBinding.bind(viewFindChildViewById);
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i6 = R$id.titleLabel;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
                if (textView != null) {
                    return new ActivityDevicePasswordBinding(constraintLayout, gridCodeEditView, button, toolbarBindingBind, constraintLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ActivityDevicePasswordBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityDevicePasswordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_device_password, viewGroup, false);
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
