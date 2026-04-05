package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class FragmentDeviceBinding implements ViewBinding {

    @NonNull
    public final FrameLayout categoryContainer;

    @NonNull
    public final FragmentContainerView fragmentContainer;

    @NonNull
    private final ConstraintLayout rootView;

    private FragmentDeviceBinding(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull FragmentContainerView fragmentContainerView) {
        this.rootView = constraintLayout;
        this.categoryContainer = frameLayout;
        this.fragmentContainer = fragmentContainerView;
    }

    @NonNull
    public static FragmentDeviceBinding bind(@NonNull View view) {
        int i6 = R$id.category_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i6);
        if (frameLayout != null) {
            i6 = R$id.fragment_container;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i6);
            if (fragmentContainerView != null) {
                return new FragmentDeviceBinding((ConstraintLayout) view, frameLayout, fragmentContainerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static FragmentDeviceBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentDeviceBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_device, viewGroup, false);
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
