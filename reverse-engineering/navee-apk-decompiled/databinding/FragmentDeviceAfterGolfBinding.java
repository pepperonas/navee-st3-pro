package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.qmuiteam.qmui.widget.QMUIEmptyView;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.ui.device.SlideProgressView;

/* loaded from: classes3.dex */
public final class FragmentDeviceAfterGolfBinding implements ViewBinding {

    @NonNull
    public final ImageButton backwardButton;

    @NonNull
    public final ImageView batteryChargeIcon;

    @NonNull
    public final ImageView batteryFill;

    @NonNull
    public final ImageView batteryIcon;

    @NonNull
    public final TextView batteryLabel;

    @NonNull
    public final LinearLayout batteryLayout;

    @NonNull
    public final TextView batteryUnitLabel;

    @NonNull
    public final QMUIEmptyView bluetoothConnectingView;

    @NonNull
    public final ImageButton bluetoothStatusButton;

    @NonNull
    public final TextView controlTextView;

    @NonNull
    public final ImageView deviceImageView;

    @NonNull
    public final Button distanceButton;

    @NonNull
    public final TextView distanceTextView;

    @NonNull
    public final TextView distanceUnitTextView;

    @NonNull
    public final ImageButton forwardButton;

    @NonNull
    public final ImageButton infoButton;

    @NonNull
    public final TextView infoTextView;

    @NonNull
    public final LinearLayout layoutTips;

    @NonNull
    public final ImageButton leftButton;

    @NonNull
    public final TextView mileageButton;

    @NonNull
    public final TextView mileageLabel;

    @NonNull
    public final ConstraintLayout mileageLayout;

    @NonNull
    public final TextView mileageUnitLabel;

    @NonNull
    public final ImageButton pauseButton;

    @NonNull
    public final ConstraintLayout remoteControlLayout;

    @NonNull
    public final ImageButton rightButton;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final ImageButton scoreButton;

    @NonNull
    public final TextView scoreTextView;

    @NonNull
    public final NestedScrollView scrollView;

    @NonNull
    public final TextView speedLabel;

    @NonNull
    public final SlideProgressView speedProgressView;

    @NonNull
    public final TextView speedUnitLabel;

    @NonNull
    public final TextView textView;

    @NonNull
    public final LinearLayout tyreWarningView;

    @NonNull
    public final TextView warningTextView;

    @NonNull
    public final LinearLayout warningView;

    private FragmentDeviceAfterGolfBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageButton imageButton, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull QMUIEmptyView qMUIEmptyView, @NonNull ImageButton imageButton2, @NonNull TextView textView3, @NonNull ImageView imageView4, @NonNull Button button, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull ImageButton imageButton3, @NonNull ImageButton imageButton4, @NonNull TextView textView6, @NonNull LinearLayout linearLayout2, @NonNull ImageButton imageButton5, @NonNull TextView textView7, @NonNull TextView textView8, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView9, @NonNull ImageButton imageButton6, @NonNull ConstraintLayout constraintLayout3, @NonNull ImageButton imageButton7, @NonNull ImageButton imageButton8, @NonNull TextView textView10, @NonNull NestedScrollView nestedScrollView, @NonNull TextView textView11, @NonNull SlideProgressView slideProgressView, @NonNull TextView textView12, @NonNull TextView textView13, @NonNull LinearLayout linearLayout3, @NonNull TextView textView14, @NonNull LinearLayout linearLayout4) {
        this.rootView = constraintLayout;
        this.backwardButton = imageButton;
        this.batteryChargeIcon = imageView;
        this.batteryFill = imageView2;
        this.batteryIcon = imageView3;
        this.batteryLabel = textView;
        this.batteryLayout = linearLayout;
        this.batteryUnitLabel = textView2;
        this.bluetoothConnectingView = qMUIEmptyView;
        this.bluetoothStatusButton = imageButton2;
        this.controlTextView = textView3;
        this.deviceImageView = imageView4;
        this.distanceButton = button;
        this.distanceTextView = textView4;
        this.distanceUnitTextView = textView5;
        this.forwardButton = imageButton3;
        this.infoButton = imageButton4;
        this.infoTextView = textView6;
        this.layoutTips = linearLayout2;
        this.leftButton = imageButton5;
        this.mileageButton = textView7;
        this.mileageLabel = textView8;
        this.mileageLayout = constraintLayout2;
        this.mileageUnitLabel = textView9;
        this.pauseButton = imageButton6;
        this.remoteControlLayout = constraintLayout3;
        this.rightButton = imageButton7;
        this.scoreButton = imageButton8;
        this.scoreTextView = textView10;
        this.scrollView = nestedScrollView;
        this.speedLabel = textView11;
        this.speedProgressView = slideProgressView;
        this.speedUnitLabel = textView12;
        this.textView = textView13;
        this.tyreWarningView = linearLayout3;
        this.warningTextView = textView14;
        this.warningView = linearLayout4;
    }

    @NonNull
    public static FragmentDeviceAfterGolfBinding bind(@NonNull View view) {
        int i6 = R$id.backwardButton;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i6);
        if (imageButton != null) {
            i6 = R$id.batteryChargeIcon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
            if (imageView != null) {
                i6 = R$id.batteryFill;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i6);
                if (imageView2 != null) {
                    i6 = R$id.batteryIcon;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i6);
                    if (imageView3 != null) {
                        i6 = R$id.batteryLabel;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
                        if (textView != null) {
                            i6 = R$id.batteryLayout;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                            if (linearLayout != null) {
                                i6 = R$id.batteryUnitLabel;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                                if (textView2 != null) {
                                    i6 = R$id.bluetoothConnectingView;
                                    QMUIEmptyView qMUIEmptyView = (QMUIEmptyView) ViewBindings.findChildViewById(view, i6);
                                    if (qMUIEmptyView != null) {
                                        i6 = R$id.bluetoothStatusButton;
                                        ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                        if (imageButton2 != null) {
                                            i6 = R$id.controlTextView;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i6);
                                            if (textView3 != null) {
                                                i6 = R$id.deviceImageView;
                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i6);
                                                if (imageView4 != null) {
                                                    i6 = R$id.distanceButton;
                                                    Button button = (Button) ViewBindings.findChildViewById(view, i6);
                                                    if (button != null) {
                                                        i6 = R$id.distanceTextView;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                        if (textView4 != null) {
                                                            i6 = R$id.distanceUnitTextView;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                            if (textView5 != null) {
                                                                i6 = R$id.forwardButton;
                                                                ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                                                if (imageButton3 != null) {
                                                                    i6 = R$id.infoButton;
                                                                    ImageButton imageButton4 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                                                    if (imageButton4 != null) {
                                                                        i6 = R$id.infoTextView;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                        if (textView6 != null) {
                                                                            i6 = R$id.layout_tips;
                                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                                            if (linearLayout2 != null) {
                                                                                i6 = R$id.leftButton;
                                                                                ImageButton imageButton5 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                                                                if (imageButton5 != null) {
                                                                                    i6 = R$id.mileageButton;
                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                    if (textView7 != null) {
                                                                                        i6 = R$id.mileageLabel;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                        if (textView8 != null) {
                                                                                            i6 = R$id.mileageLayout;
                                                                                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i6);
                                                                                            if (constraintLayout != null) {
                                                                                                i6 = R$id.mileageUnitLabel;
                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                if (textView9 != null) {
                                                                                                    i6 = R$id.pauseButton;
                                                                                                    ImageButton imageButton6 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                                                                                    if (imageButton6 != null) {
                                                                                                        i6 = R$id.remoteControlLayout;
                                                                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i6);
                                                                                                        if (constraintLayout2 != null) {
                                                                                                            i6 = R$id.rightButton;
                                                                                                            ImageButton imageButton7 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                                                                                            if (imageButton7 != null) {
                                                                                                                i6 = R$id.scoreButton;
                                                                                                                ImageButton imageButton8 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                                                                                                if (imageButton8 != null) {
                                                                                                                    i6 = R$id.scoreTextView;
                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                    if (textView10 != null) {
                                                                                                                        i6 = R$id.scrollView;
                                                                                                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i6);
                                                                                                                        if (nestedScrollView != null) {
                                                                                                                            i6 = R$id.speedLabel;
                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                            if (textView11 != null) {
                                                                                                                                i6 = R$id.speedProgressView;
                                                                                                                                SlideProgressView slideProgressView = (SlideProgressView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                if (slideProgressView != null) {
                                                                                                                                    i6 = R$id.speedUnitLabel;
                                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                    if (textView12 != null) {
                                                                                                                                        i6 = R$id.textView;
                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                        if (textView13 != null) {
                                                                                                                                            i6 = R$id.tyreWarningView;
                                                                                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                                                                                                            if (linearLayout3 != null) {
                                                                                                                                                i6 = R$id.warningTextView;
                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                if (textView14 != null) {
                                                                                                                                                    i6 = R$id.warningView;
                                                                                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                    if (linearLayout4 != null) {
                                                                                                                                                        return new FragmentDeviceAfterGolfBinding((ConstraintLayout) view, imageButton, imageView, imageView2, imageView3, textView, linearLayout, textView2, qMUIEmptyView, imageButton2, textView3, imageView4, button, textView4, textView5, imageButton3, imageButton4, textView6, linearLayout2, imageButton5, textView7, textView8, constraintLayout, textView9, imageButton6, constraintLayout2, imageButton7, imageButton8, textView10, nestedScrollView, textView11, slideProgressView, textView12, textView13, linearLayout3, textView14, linearLayout4);
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
    public static FragmentDeviceAfterGolfBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentDeviceAfterGolfBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_device_after_golf, viewGroup, false);
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
