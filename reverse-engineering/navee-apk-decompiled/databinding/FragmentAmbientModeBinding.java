package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class FragmentAmbientModeBinding implements ViewBinding {

    @NonNull
    public final ImageButton blueButton;

    @NonNull
    public final ConstraintLayout colorLayout;

    @NonNull
    public final ImageButton colorsButton;

    @NonNull
    public final ImageButton greenButton;

    @NonNull
    public final ImageButton purpleButton;

    @NonNull
    public final ImageButton redButton;

    @NonNull
    private final ConstraintLayout rootView;

    private FragmentAmbientModeBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageButton imageButton, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageButton imageButton2, @NonNull ImageButton imageButton3, @NonNull ImageButton imageButton4, @NonNull ImageButton imageButton5) {
        this.rootView = constraintLayout;
        this.blueButton = imageButton;
        this.colorLayout = constraintLayout2;
        this.colorsButton = imageButton2;
        this.greenButton = imageButton3;
        this.purpleButton = imageButton4;
        this.redButton = imageButton5;
    }

    @NonNull
    public static FragmentAmbientModeBinding bind(@NonNull View view) {
        int i6 = R$id.blueButton;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i6);
        if (imageButton != null) {
            i6 = R$id.colorLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i6);
            if (constraintLayout != null) {
                i6 = R$id.colorsButton;
                ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                if (imageButton2 != null) {
                    i6 = R$id.greenButton;
                    ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                    if (imageButton3 != null) {
                        i6 = R$id.purpleButton;
                        ImageButton imageButton4 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                        if (imageButton4 != null) {
                            i6 = R$id.redButton;
                            ImageButton imageButton5 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                            if (imageButton5 != null) {
                                return new FragmentAmbientModeBinding((ConstraintLayout) view, imageButton, constraintLayout, imageButton2, imageButton3, imageButton4, imageButton5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static FragmentAmbientModeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentAmbientModeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_ambient_mode, viewGroup, false);
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
