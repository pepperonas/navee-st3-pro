package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.ui.wheel.BottomCropImage;

/* loaded from: classes3.dex */
public final class ActivityAmbientLightBinding implements ViewBinding {

    @NonNull
    public final LinearLayout accessoryView;

    @NonNull
    public final TextView colorTitleLabel;

    @NonNull
    public final ViewPager2 colorViewPager;

    @NonNull
    public final ConstraintLayout imageLayout;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final View lightSelectForegroundView;

    @NonNull
    public final ConstraintLayout lightSelectLayout;

    @NonNull
    public final SwitchCompat mSwitch;

    @NonNull
    public final TabLayout modeTabLayout;

    @NonNull
    public final TextView modeTitleLabel;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final ConstraintLayout switchLayout;

    @NonNull
    public final TextView switchSubTitleLabel;

    @NonNull
    public final TextView switchTitleLabel;

    @NonNull
    public final BottomCropImage vehicleImageView;

    private ActivityAmbientLightBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ViewPager2 viewPager2, @NonNull ConstraintLayout constraintLayout2, @NonNull ToolbarBinding toolbarBinding, @NonNull View view, @NonNull ConstraintLayout constraintLayout3, @NonNull SwitchCompat switchCompat, @NonNull TabLayout tabLayout, @NonNull TextView textView2, @NonNull ConstraintLayout constraintLayout4, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull BottomCropImage bottomCropImage) {
        this.rootView = constraintLayout;
        this.accessoryView = linearLayout;
        this.colorTitleLabel = textView;
        this.colorViewPager = viewPager2;
        this.imageLayout = constraintLayout2;
        this.include = toolbarBinding;
        this.lightSelectForegroundView = view;
        this.lightSelectLayout = constraintLayout3;
        this.mSwitch = switchCompat;
        this.modeTabLayout = tabLayout;
        this.modeTitleLabel = textView2;
        this.switchLayout = constraintLayout4;
        this.switchSubTitleLabel = textView3;
        this.switchTitleLabel = textView4;
        this.vehicleImageView = bottomCropImage;
    }

    @NonNull
    public static ActivityAmbientLightBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.accessoryView;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i6);
        if (linearLayout != null) {
            i6 = R$id.colorTitleLabel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
            if (textView != null) {
                i6 = R$id.colorViewPager;
                ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i6);
                if (viewPager2 != null) {
                    i6 = R$id.imageLayout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i6);
                    if (constraintLayout != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.include))) != null) {
                        ToolbarBinding toolbarBindingBind = ToolbarBinding.bind(viewFindChildViewById);
                        i6 = R$id.lightSelectForegroundView;
                        View viewFindChildViewById2 = ViewBindings.findChildViewById(view, i6);
                        if (viewFindChildViewById2 != null) {
                            i6 = R$id.lightSelectLayout;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i6);
                            if (constraintLayout2 != null) {
                                i6 = R$id.mSwitch;
                                SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i6);
                                if (switchCompat != null) {
                                    i6 = R$id.modeTabLayout;
                                    TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, i6);
                                    if (tabLayout != null) {
                                        i6 = R$id.modeTitleLabel;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                                        if (textView2 != null) {
                                            i6 = R$id.switchLayout;
                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i6);
                                            if (constraintLayout3 != null) {
                                                i6 = R$id.switchSubTitleLabel;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                if (textView3 != null) {
                                                    i6 = R$id.switchTitleLabel;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                    if (textView4 != null) {
                                                        i6 = R$id.vehicleImageView;
                                                        BottomCropImage bottomCropImage = (BottomCropImage) ViewBindings.findChildViewById(view, i6);
                                                        if (bottomCropImage != null) {
                                                            return new ActivityAmbientLightBinding((ConstraintLayout) view, linearLayout, textView, viewPager2, constraintLayout, toolbarBindingBind, viewFindChildViewById2, constraintLayout2, switchCompat, tabLayout, textView2, constraintLayout3, textView3, textView4, bottomCropImage);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ActivityAmbientLightBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityAmbientLightBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_ambient_light, viewGroup, false);
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
