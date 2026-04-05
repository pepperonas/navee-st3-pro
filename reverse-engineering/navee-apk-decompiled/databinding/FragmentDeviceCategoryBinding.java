package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class FragmentDeviceCategoryBinding implements ViewBinding {

    @NonNull
    public final Button buttonAdd;

    @NonNull
    public final ImageButton ibMenu;

    @NonNull
    public final TabItem itemDoing;

    @NonNull
    public final TabItem itemNoStart;

    @NonNull
    public final TabItem itemOver;

    @NonNull
    public final TabLayout layoutTab;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final ViewPager2 vpFragment;

    private FragmentDeviceCategoryBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Button button, @NonNull ImageButton imageButton, @NonNull TabItem tabItem, @NonNull TabItem tabItem2, @NonNull TabItem tabItem3, @NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.buttonAdd = button;
        this.ibMenu = imageButton;
        this.itemDoing = tabItem;
        this.itemNoStart = tabItem2;
        this.itemOver = tabItem3;
        this.layoutTab = tabLayout;
        this.vpFragment = viewPager2;
    }

    @NonNull
    public static FragmentDeviceCategoryBinding bind(@NonNull View view) {
        int i6 = R$id.button_add;
        Button button = (Button) ViewBindings.findChildViewById(view, i6);
        if (button != null) {
            i6 = R$id.ib_menu;
            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i6);
            if (imageButton != null) {
                i6 = R$id.item_doing;
                TabItem tabItem = (TabItem) ViewBindings.findChildViewById(view, i6);
                if (tabItem != null) {
                    i6 = R$id.item_no_start;
                    TabItem tabItem2 = (TabItem) ViewBindings.findChildViewById(view, i6);
                    if (tabItem2 != null) {
                        i6 = R$id.item_over;
                        TabItem tabItem3 = (TabItem) ViewBindings.findChildViewById(view, i6);
                        if (tabItem3 != null) {
                            i6 = R$id.layout_tab;
                            TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, i6);
                            if (tabLayout != null) {
                                i6 = R$id.vp_fragment;
                                ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i6);
                                if (viewPager2 != null) {
                                    return new FragmentDeviceCategoryBinding((ConstraintLayout) view, button, imageButton, tabItem, tabItem2, tabItem3, tabLayout, viewPager2);
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
    public static FragmentDeviceCategoryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentDeviceCategoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_device_category, viewGroup, false);
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
