package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ActivityDeviceListBinding implements ViewBinding {

    @NonNull
    public final Button deleteAllButton;

    @NonNull
    public final Toolbar2Binding include;

    @NonNull
    public final RecyclerView recyclerView;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final Button selectAllButton;

    @NonNull
    public final ConstraintLayout selectAllLayout;

    private ActivityDeviceListBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Button button, @NonNull Toolbar2Binding toolbar2Binding, @NonNull RecyclerView recyclerView, @NonNull Button button2, @NonNull ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.deleteAllButton = button;
        this.include = toolbar2Binding;
        this.recyclerView = recyclerView;
        this.selectAllButton = button2;
        this.selectAllLayout = constraintLayout2;
    }

    @NonNull
    public static ActivityDeviceListBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.deleteAllButton;
        Button button = (Button) ViewBindings.findChildViewById(view, i6);
        if (button != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.include))) != null) {
            Toolbar2Binding toolbar2BindingBind = Toolbar2Binding.bind(viewFindChildViewById);
            i6 = R$id.recyclerView;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i6);
            if (recyclerView != null) {
                i6 = R$id.selectAllButton;
                Button button2 = (Button) ViewBindings.findChildViewById(view, i6);
                if (button2 != null) {
                    i6 = R$id.selectAllLayout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i6);
                    if (constraintLayout != null) {
                        return new ActivityDeviceListBinding((ConstraintLayout) view, button, toolbar2BindingBind, recyclerView, button2, constraintLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ActivityDeviceListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityDeviceListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_device_list, viewGroup, false);
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
