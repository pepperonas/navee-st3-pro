package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public abstract class ActivityAmbientLightV3Binding extends ViewDataBinding {

    @NonNull
    public final LinearLayout accessoryView;

    @NonNull
    public final ConstraintLayout imageLayout;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final AppCompatImageView ivVehicle;

    @NonNull
    public final View lightSelectForegroundView;

    @NonNull
    public final ConstraintLayout lightSelectLayout;

    @NonNull
    public final RecyclerView rvBoost;

    @NonNull
    public final RecyclerView rvGeneral;

    @NonNull
    public final SwitchCompat scSwitch;

    @NonNull
    public final ConstraintLayout switchLayout;

    @NonNull
    public final TextView switchSubTitleLabel;

    @NonNull
    public final TextView switchTitleLabel;

    @NonNull
    public final TabLayout tbMode;

    @NonNull
    public final TextView tvTitleBoost;

    @NonNull
    public final TextView tvTitleGeneral;

    @NonNull
    public final TextView tvTitleMode;

    public ActivityAmbientLightV3Binding(Object obj, View view, int i6, LinearLayout linearLayout, ConstraintLayout constraintLayout, ToolbarBinding toolbarBinding, AppCompatImageView appCompatImageView, View view2, ConstraintLayout constraintLayout2, RecyclerView recyclerView, RecyclerView recyclerView2, SwitchCompat switchCompat, ConstraintLayout constraintLayout3, TextView textView, TextView textView2, TabLayout tabLayout, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i6);
        this.accessoryView = linearLayout;
        this.imageLayout = constraintLayout;
        this.include = toolbarBinding;
        this.ivVehicle = appCompatImageView;
        this.lightSelectForegroundView = view2;
        this.lightSelectLayout = constraintLayout2;
        this.rvBoost = recyclerView;
        this.rvGeneral = recyclerView2;
        this.scSwitch = switchCompat;
        this.switchLayout = constraintLayout3;
        this.switchSubTitleLabel = textView;
        this.switchTitleLabel = textView2;
        this.tbMode = tabLayout;
        this.tvTitleBoost = textView3;
        this.tvTitleGeneral = textView4;
        this.tvTitleMode = textView5;
    }

    public static ActivityAmbientLightV3Binding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityAmbientLightV3Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAmbientLightV3Binding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityAmbientLightV3Binding) ViewDataBinding.bind(obj, view, R$layout.activity_ambient_light_v3);
    }

    @NonNull
    @Deprecated
    public static ActivityAmbientLightV3Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ActivityAmbientLightV3Binding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_ambient_light_v3, viewGroup, z6, obj);
    }

    @NonNull
    public static ActivityAmbientLightV3Binding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityAmbientLightV3Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityAmbientLightV3Binding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_ambient_light_v3, null, false, obj);
    }
}
