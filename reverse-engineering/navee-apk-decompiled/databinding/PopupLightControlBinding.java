package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class PopupLightControlBinding implements ViewBinding {

    @NonNull
    public final ImageButton autoLightButton;

    @NonNull
    public final TextView autoLightLabel;

    @NonNull
    public final LinearLayout autoLightLayout;

    @NonNull
    public final TextView autoLightSubLabel;

    @NonNull
    public final SwitchCompat autoLightSwitch;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final ImageButton tailLightButton;

    @NonNull
    public final TextView tailLightLabel;

    @NonNull
    public final LinearLayout tailLightLayout;

    @NonNull
    public final SwitchCompat tailLightSwitch;

    @NonNull
    public final TextView titleLabel;

    @NonNull
    public final ImageButton turnSoundButton;

    @NonNull
    public final TextView turnSoundLabel;

    @NonNull
    public final LinearLayout turnSoundLayout;

    @NonNull
    public final SwitchCompat turnSoundSwitch;

    private PopupLightControlBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageButton imageButton, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull SwitchCompat switchCompat, @NonNull ImageButton imageButton2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout2, @NonNull SwitchCompat switchCompat2, @NonNull TextView textView4, @NonNull ImageButton imageButton3, @NonNull TextView textView5, @NonNull LinearLayout linearLayout3, @NonNull SwitchCompat switchCompat3) {
        this.rootView = constraintLayout;
        this.autoLightButton = imageButton;
        this.autoLightLabel = textView;
        this.autoLightLayout = linearLayout;
        this.autoLightSubLabel = textView2;
        this.autoLightSwitch = switchCompat;
        this.tailLightButton = imageButton2;
        this.tailLightLabel = textView3;
        this.tailLightLayout = linearLayout2;
        this.tailLightSwitch = switchCompat2;
        this.titleLabel = textView4;
        this.turnSoundButton = imageButton3;
        this.turnSoundLabel = textView5;
        this.turnSoundLayout = linearLayout3;
        this.turnSoundSwitch = switchCompat3;
    }

    @NonNull
    public static PopupLightControlBinding bind(@NonNull View view) {
        int i6 = R$id.autoLightButton;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i6);
        if (imageButton != null) {
            i6 = R$id.autoLightLabel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
            if (textView != null) {
                i6 = R$id.autoLightLayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                if (linearLayout != null) {
                    i6 = R$id.autoLightSubLabel;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                    if (textView2 != null) {
                        i6 = R$id.autoLightSwitch;
                        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i6);
                        if (switchCompat != null) {
                            i6 = R$id.tailLightButton;
                            ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                            if (imageButton2 != null) {
                                i6 = R$id.tailLightLabel;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i6);
                                if (textView3 != null) {
                                    i6 = R$id.tailLightLayout;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                    if (linearLayout2 != null) {
                                        i6 = R$id.tailLightSwitch;
                                        SwitchCompat switchCompat2 = (SwitchCompat) ViewBindings.findChildViewById(view, i6);
                                        if (switchCompat2 != null) {
                                            i6 = R$id.titleLabel;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i6);
                                            if (textView4 != null) {
                                                i6 = R$id.turnSoundButton;
                                                ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                                if (imageButton3 != null) {
                                                    i6 = R$id.turnSoundLabel;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                    if (textView5 != null) {
                                                        i6 = R$id.turnSoundLayout;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                        if (linearLayout3 != null) {
                                                            i6 = R$id.turnSoundSwitch;
                                                            SwitchCompat switchCompat3 = (SwitchCompat) ViewBindings.findChildViewById(view, i6);
                                                            if (switchCompat3 != null) {
                                                                return new PopupLightControlBinding((ConstraintLayout) view, imageButton, textView, linearLayout, textView2, switchCompat, imageButton2, textView3, linearLayout2, switchCompat2, textView4, imageButton3, textView5, linearLayout3, switchCompat3);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static PopupLightControlBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PopupLightControlBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.popup_light_control, viewGroup, false);
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
