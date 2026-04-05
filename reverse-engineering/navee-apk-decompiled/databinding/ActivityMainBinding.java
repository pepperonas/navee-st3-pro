package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ActivityMainBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout container;

    @NonNull
    public final BottomNavigationView navView;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final ToolbarBinding toolbarMain;

    private ActivityMainBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull BottomNavigationView bottomNavigationView, @NonNull ToolbarBinding toolbarBinding) {
        this.rootView = constraintLayout;
        this.container = constraintLayout2;
        this.navView = bottomNavigationView;
        this.toolbarMain = toolbarBinding;
    }

    @NonNull
    public static ActivityMainBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i6 = R$id.nav_view;
        BottomNavigationView bottomNavigationView = (BottomNavigationView) ViewBindings.findChildViewById(view, i6);
        if (bottomNavigationView == null || (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.toolbar_main))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
        }
        return new ActivityMainBinding(constraintLayout, constraintLayout, bottomNavigationView, ToolbarBinding.bind(viewFindChildViewById));
    }

    @NonNull
    public static ActivityMainBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityMainBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_main, viewGroup, false);
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
