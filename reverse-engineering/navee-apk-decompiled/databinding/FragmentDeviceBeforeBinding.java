package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.youth.banner.Banner;

/* loaded from: classes3.dex */
public final class FragmentDeviceBeforeBinding implements ViewBinding {

    @NonNull
    public final Banner banner;

    @NonNull
    public final Button buttonBind;

    @NonNull
    private final ConstraintLayout rootView;

    private FragmentDeviceBeforeBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Banner banner, @NonNull Button button) {
        this.rootView = constraintLayout;
        this.banner = banner;
        this.buttonBind = button;
    }

    @NonNull
    public static FragmentDeviceBeforeBinding bind(@NonNull View view) {
        int i6 = R$id.banner;
        Banner banner = (Banner) ViewBindings.findChildViewById(view, i6);
        if (banner != null) {
            i6 = R$id.button_bind;
            Button button = (Button) ViewBindings.findChildViewById(view, i6);
            if (button != null) {
                return new FragmentDeviceBeforeBinding((ConstraintLayout) view, banner, button);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static FragmentDeviceBeforeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentDeviceBeforeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_device_before, viewGroup, false);
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
