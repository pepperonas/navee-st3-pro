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
public final class PopupMileageAlgorithmBinding implements ViewBinding {

    @NonNull
    public final ImageButton actualButton;

    @NonNull
    public final TextView actualLabel;

    @NonNull
    public final LinearLayout actualLayout;

    @NonNull
    public final TextView actualSubLabel;

    @NonNull
    public final LinearLayout bottomLayout;

    @NonNull
    public final Button cancelButton;

    @NonNull
    public final Button confirmButton;

    @NonNull
    public final ImageButton dGearButton;

    @NonNull
    public final TextView dGearLabel;

    @NonNull
    public final LinearLayout dGearLayout;

    @NonNull
    public final TextView dGearSubLabel;

    @NonNull
    public final ImageButton eGearButton;

    @NonNull
    public final TextView eGearLabel;

    @NonNull
    public final LinearLayout eGearLayout;

    @NonNull
    public final TextView eGearSubLabel;

    @NonNull
    public final LinearLayout llRoot;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final ImageButton sGearButton;

    @NonNull
    public final TextView sGearLabel;

    @NonNull
    public final LinearLayout sGearLayout;

    @NonNull
    public final TextView sGearSubLabel;

    @NonNull
    public final ImageButton theoryButton;

    @NonNull
    public final TextView theoryLabel;

    @NonNull
    public final LinearLayout theoryLayout;

    @NonNull
    public final TextView theorySubLabel;

    @NonNull
    public final TextView titleLabel;

    private PopupMileageAlgorithmBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageButton imageButton, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull Button button2, @NonNull ImageButton imageButton2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout3, @NonNull TextView textView4, @NonNull ImageButton imageButton3, @NonNull TextView textView5, @NonNull LinearLayout linearLayout4, @NonNull TextView textView6, @NonNull LinearLayout linearLayout5, @NonNull ImageButton imageButton4, @NonNull TextView textView7, @NonNull LinearLayout linearLayout6, @NonNull TextView textView8, @NonNull ImageButton imageButton5, @NonNull TextView textView9, @NonNull LinearLayout linearLayout7, @NonNull TextView textView10, @NonNull TextView textView11) {
        this.rootView = constraintLayout;
        this.actualButton = imageButton;
        this.actualLabel = textView;
        this.actualLayout = linearLayout;
        this.actualSubLabel = textView2;
        this.bottomLayout = linearLayout2;
        this.cancelButton = button;
        this.confirmButton = button2;
        this.dGearButton = imageButton2;
        this.dGearLabel = textView3;
        this.dGearLayout = linearLayout3;
        this.dGearSubLabel = textView4;
        this.eGearButton = imageButton3;
        this.eGearLabel = textView5;
        this.eGearLayout = linearLayout4;
        this.eGearSubLabel = textView6;
        this.llRoot = linearLayout5;
        this.sGearButton = imageButton4;
        this.sGearLabel = textView7;
        this.sGearLayout = linearLayout6;
        this.sGearSubLabel = textView8;
        this.theoryButton = imageButton5;
        this.theoryLabel = textView9;
        this.theoryLayout = linearLayout7;
        this.theorySubLabel = textView10;
        this.titleLabel = textView11;
    }

    @NonNull
    public static PopupMileageAlgorithmBinding bind(@NonNull View view) {
        int i6 = R$id.actualButton;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i6);
        if (imageButton != null) {
            i6 = R$id.actualLabel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
            if (textView != null) {
                i6 = R$id.actualLayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                if (linearLayout != null) {
                    i6 = R$id.actualSubLabel;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                    if (textView2 != null) {
                        i6 = R$id.bottomLayout;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                        if (linearLayout2 != null) {
                            i6 = R$id.cancelButton;
                            Button button = (Button) ViewBindings.findChildViewById(view, i6);
                            if (button != null) {
                                i6 = R$id.confirmButton;
                                Button button2 = (Button) ViewBindings.findChildViewById(view, i6);
                                if (button2 != null) {
                                    i6 = R$id.dGearButton;
                                    ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                    if (imageButton2 != null) {
                                        i6 = R$id.dGearLabel;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i6);
                                        if (textView3 != null) {
                                            i6 = R$id.dGearLayout;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                            if (linearLayout3 != null) {
                                                i6 = R$id.dGearSubLabel;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                if (textView4 != null) {
                                                    i6 = R$id.eGearButton;
                                                    ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                                    if (imageButton3 != null) {
                                                        i6 = R$id.eGearLabel;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                        if (textView5 != null) {
                                                            i6 = R$id.eGearLayout;
                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                            if (linearLayout4 != null) {
                                                                i6 = R$id.eGearSubLabel;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                if (textView6 != null) {
                                                                    i6 = R$id.ll_root;
                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                                    if (linearLayout5 != null) {
                                                                        i6 = R$id.sGearButton;
                                                                        ImageButton imageButton4 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                                                        if (imageButton4 != null) {
                                                                            i6 = R$id.sGearLabel;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                            if (textView7 != null) {
                                                                                i6 = R$id.sGearLayout;
                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                                                if (linearLayout6 != null) {
                                                                                    i6 = R$id.sGearSubLabel;
                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                    if (textView8 != null) {
                                                                                        i6 = R$id.theoryButton;
                                                                                        ImageButton imageButton5 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                                                                        if (imageButton5 != null) {
                                                                                            i6 = R$id.theoryLabel;
                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                            if (textView9 != null) {
                                                                                                i6 = R$id.theoryLayout;
                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                                                                if (linearLayout7 != null) {
                                                                                                    i6 = R$id.theorySubLabel;
                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                    if (textView10 != null) {
                                                                                                        i6 = R$id.titleLabel;
                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                        if (textView11 != null) {
                                                                                                            return new PopupMileageAlgorithmBinding((ConstraintLayout) view, imageButton, textView, linearLayout, textView2, linearLayout2, button, button2, imageButton2, textView3, linearLayout3, textView4, imageButton3, textView5, linearLayout4, textView6, linearLayout5, imageButton4, textView7, linearLayout6, textView8, imageButton5, textView9, linearLayout7, textView10, textView11);
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
    public static PopupMileageAlgorithmBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PopupMileageAlgorithmBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.popup_mileage_algorithm, viewGroup, false);
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
