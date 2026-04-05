package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class PopupEnergyRecoveryBinding implements ViewBinding {

    @NonNull
    public final LinearLayout bottomLayout;

    @NonNull
    public final Button cancelButton;

    @NonNull
    public final Button confirmButton;

    @NonNull
    public final ImageButton highBatteryButton;

    @NonNull
    public final TextView highBatteryLabel;

    @NonNull
    public final ImageButton lowBatteryButton;

    @NonNull
    public final TextView lowBatteryLabel;

    @NonNull
    public final ImageButton mediumBatteryButton;

    @NonNull
    public final TextView mediumBatteryLabel;

    @NonNull
    public final LinearLayout middleLayout;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView titleLabel;

    private PopupEnergyRecoveryBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull Button button2, @NonNull ImageButton imageButton, @NonNull TextView textView, @NonNull ImageButton imageButton2, @NonNull TextView textView2, @NonNull ImageButton imageButton3, @NonNull TextView textView3, @NonNull LinearLayout linearLayout2, @NonNull TextView textView4) {
        this.rootView = constraintLayout;
        this.bottomLayout = linearLayout;
        this.cancelButton = button;
        this.confirmButton = button2;
        this.highBatteryButton = imageButton;
        this.highBatteryLabel = textView;
        this.lowBatteryButton = imageButton2;
        this.lowBatteryLabel = textView2;
        this.mediumBatteryButton = imageButton3;
        this.mediumBatteryLabel = textView3;
        this.middleLayout = linearLayout2;
        this.titleLabel = textView4;
    }

    @NonNull
    public static PopupEnergyRecoveryBinding bind(@NonNull View view) {
        int i6 = R$id.bottomLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i6);
        if (linearLayout != null) {
            i6 = R$id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, i6);
            if (button != null) {
                i6 = R$id.confirmButton;
                Button button2 = (Button) ViewBindings.findChildViewById(view, i6);
                if (button2 != null) {
                    i6 = R$id.highBatteryButton;
                    ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i6);
                    if (imageButton != null) {
                        i6 = R$id.highBatteryLabel;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
                        if (textView != null) {
                            i6 = R$id.lowBatteryButton;
                            ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                            if (imageButton2 != null) {
                                i6 = R$id.lowBatteryLabel;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                                if (textView2 != null) {
                                    i6 = R$id.mediumBatteryButton;
                                    ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                    if (imageButton3 != null) {
                                        i6 = R$id.mediumBatteryLabel;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i6);
                                        if (textView3 != null) {
                                            i6 = R$id.middleLayout;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                            if (linearLayout2 != null) {
                                                i6 = R$id.titleLabel;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                if (textView4 != null) {
                                                    return new PopupEnergyRecoveryBinding((ConstraintLayout) view, linearLayout, button, button2, imageButton, textView, imageButton2, textView2, imageButton3, textView3, linearLayout2, textView4);
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
    public static PopupEnergyRecoveryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PopupEnergyRecoveryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.popup_energy_recovery, viewGroup, false);
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
