package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.uz.navee.ui.device.SlideLockView;

/* loaded from: classes3.dex */
public final class FragmentDeviceAfterBinding implements ViewBinding {

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
    public final QMUIEmptyView bluetoothConnectingView;

    @NonNull
    public final ImageButton bluetoothStatusButton;

    @NonNull
    public final TextView controlTextView;

    @NonNull
    public final ImageButton cruiseButton;

    @NonNull
    public final LinearLayout cruiseLayout;

    @NonNull
    public final TextView cruiseTextView;

    @NonNull
    public final ImageView deviceImageView;

    @NonNull
    public final ImageButton energyButton;

    @NonNull
    public final LinearLayout energyLayout;

    @NonNull
    public final TextView energyTextView;

    @NonNull
    public final ImageButton historyButton;

    @NonNull
    public final TextView historyTextView;

    @NonNull
    public final ImageView indicator;

    @NonNull
    public final ImageButton infoButton;

    @NonNull
    public final TextView infoTextView;

    @NonNull
    public final LinearLayout layoutTips;

    @NonNull
    public final ImageButton lightButton;

    @NonNull
    public final LinearLayout lightLayout;

    @NonNull
    public final TextView lightTextView;

    @NonNull
    public final TextView lockTextView;

    @NonNull
    public final SlideLockView lockView;

    @NonNull
    public final ConstraintLayout mLayout;

    @NonNull
    public final TextView mileageButton;

    @NonNull
    public final TextView mileageLabel;

    @NonNull
    public final ConstraintLayout mileageLayout;

    @NonNull
    public final ImageView pluginIcon;

    @NonNull
    public final TextView pluginLabel;

    @NonNull
    public final ConstraintLayout pluginLayout;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final NestedScrollView scrollView;

    @NonNull
    public final TextView textView;

    @NonNull
    public final TextView tvNews;

    @NonNull
    public final TextView tvPet;

    @NonNull
    public final LinearLayout tyreWarningView;

    @NonNull
    public final ImageButton unitButton;

    @NonNull
    public final LinearLayout unitLayout;

    @NonNull
    public final TextView unitTextView;

    @NonNull
    public final TextView warningTextView;

    @NonNull
    public final LinearLayout warningView;

    private FragmentDeviceAfterBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull QMUIEmptyView qMUIEmptyView, @NonNull ImageButton imageButton, @NonNull TextView textView2, @NonNull ImageButton imageButton2, @NonNull LinearLayout linearLayout2, @NonNull TextView textView3, @NonNull ImageView imageView4, @NonNull ImageButton imageButton3, @NonNull LinearLayout linearLayout3, @NonNull TextView textView4, @NonNull ImageButton imageButton4, @NonNull TextView textView5, @NonNull ImageView imageView5, @NonNull ImageButton imageButton5, @NonNull TextView textView6, @NonNull LinearLayout linearLayout4, @NonNull ImageButton imageButton6, @NonNull LinearLayout linearLayout5, @NonNull TextView textView7, @NonNull TextView textView8, @NonNull SlideLockView slideLockView, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView9, @NonNull TextView textView10, @NonNull ConstraintLayout constraintLayout3, @NonNull ImageView imageView6, @NonNull TextView textView11, @NonNull ConstraintLayout constraintLayout4, @NonNull NestedScrollView nestedScrollView, @NonNull TextView textView12, @NonNull TextView textView13, @NonNull TextView textView14, @NonNull LinearLayout linearLayout6, @NonNull ImageButton imageButton7, @NonNull LinearLayout linearLayout7, @NonNull TextView textView15, @NonNull TextView textView16, @NonNull LinearLayout linearLayout8) {
        this.rootView = constraintLayout;
        this.batteryChargeIcon = imageView;
        this.batteryFill = imageView2;
        this.batteryIcon = imageView3;
        this.batteryLabel = textView;
        this.batteryLayout = linearLayout;
        this.bluetoothConnectingView = qMUIEmptyView;
        this.bluetoothStatusButton = imageButton;
        this.controlTextView = textView2;
        this.cruiseButton = imageButton2;
        this.cruiseLayout = linearLayout2;
        this.cruiseTextView = textView3;
        this.deviceImageView = imageView4;
        this.energyButton = imageButton3;
        this.energyLayout = linearLayout3;
        this.energyTextView = textView4;
        this.historyButton = imageButton4;
        this.historyTextView = textView5;
        this.indicator = imageView5;
        this.infoButton = imageButton5;
        this.infoTextView = textView6;
        this.layoutTips = linearLayout4;
        this.lightButton = imageButton6;
        this.lightLayout = linearLayout5;
        this.lightTextView = textView7;
        this.lockTextView = textView8;
        this.lockView = slideLockView;
        this.mLayout = constraintLayout2;
        this.mileageButton = textView9;
        this.mileageLabel = textView10;
        this.mileageLayout = constraintLayout3;
        this.pluginIcon = imageView6;
        this.pluginLabel = textView11;
        this.pluginLayout = constraintLayout4;
        this.scrollView = nestedScrollView;
        this.textView = textView12;
        this.tvNews = textView13;
        this.tvPet = textView14;
        this.tyreWarningView = linearLayout6;
        this.unitButton = imageButton7;
        this.unitLayout = linearLayout7;
        this.unitTextView = textView15;
        this.warningTextView = textView16;
        this.warningView = linearLayout8;
    }

    @NonNull
    public static FragmentDeviceAfterBinding bind(@NonNull View view) {
        int i6 = R$id.batteryChargeIcon;
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
                            i6 = R$id.bluetoothConnectingView;
                            QMUIEmptyView qMUIEmptyView = (QMUIEmptyView) ViewBindings.findChildViewById(view, i6);
                            if (qMUIEmptyView != null) {
                                i6 = R$id.bluetoothStatusButton;
                                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                if (imageButton != null) {
                                    i6 = R$id.controlTextView;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                                    if (textView2 != null) {
                                        i6 = R$id.cruiseButton;
                                        ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                        if (imageButton2 != null) {
                                            i6 = R$id.cruiseLayout;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                            if (linearLayout2 != null) {
                                                i6 = R$id.cruiseTextView;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                if (textView3 != null) {
                                                    i6 = R$id.deviceImageView;
                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i6);
                                                    if (imageView4 != null) {
                                                        i6 = R$id.energyButton;
                                                        ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                                        if (imageButton3 != null) {
                                                            i6 = R$id.energyLayout;
                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                            if (linearLayout3 != null) {
                                                                i6 = R$id.energyTextView;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                if (textView4 != null) {
                                                                    i6 = R$id.historyButton;
                                                                    ImageButton imageButton4 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                                                    if (imageButton4 != null) {
                                                                        i6 = R$id.historyTextView;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                        if (textView5 != null) {
                                                                            i6 = R$id.indicator;
                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i6);
                                                                            if (imageView5 != null) {
                                                                                i6 = R$id.infoButton;
                                                                                ImageButton imageButton5 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                                                                if (imageButton5 != null) {
                                                                                    i6 = R$id.infoTextView;
                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                    if (textView6 != null) {
                                                                                        i6 = R$id.layout_tips;
                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                                                        if (linearLayout4 != null) {
                                                                                            i6 = R$id.lightButton;
                                                                                            ImageButton imageButton6 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                                                                            if (imageButton6 != null) {
                                                                                                i6 = R$id.lightLayout;
                                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                                                                if (linearLayout5 != null) {
                                                                                                    i6 = R$id.lightTextView;
                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                    if (textView7 != null) {
                                                                                                        i6 = R$id.lockTextView;
                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                        if (textView8 != null) {
                                                                                                            i6 = R$id.lockView;
                                                                                                            SlideLockView slideLockView = (SlideLockView) ViewBindings.findChildViewById(view, i6);
                                                                                                            if (slideLockView != null) {
                                                                                                                i6 = R$id.mLayout;
                                                                                                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i6);
                                                                                                                if (constraintLayout != null) {
                                                                                                                    i6 = R$id.mileageButton;
                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                    if (textView9 != null) {
                                                                                                                        i6 = R$id.mileageLabel;
                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                        if (textView10 != null) {
                                                                                                                            i6 = R$id.mileageLayout;
                                                                                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i6);
                                                                                                                            if (constraintLayout2 != null) {
                                                                                                                                i6 = R$id.pluginIcon;
                                                                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                if (imageView6 != null) {
                                                                                                                                    i6 = R$id.pluginLabel;
                                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                    if (textView11 != null) {
                                                                                                                                        i6 = R$id.pluginLayout;
                                                                                                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i6);
                                                                                                                                        if (constraintLayout3 != null) {
                                                                                                                                            i6 = R$id.scrollView;
                                                                                                                                            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                            if (nestedScrollView != null) {
                                                                                                                                                i6 = R$id.textView;
                                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                if (textView12 != null) {
                                                                                                                                                    i6 = R$id.tv_news;
                                                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                    if (textView13 != null) {
                                                                                                                                                        i6 = R$id.tv_pet;
                                                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                        if (textView14 != null) {
                                                                                                                                                            i6 = R$id.tyreWarningView;
                                                                                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                            if (linearLayout6 != null) {
                                                                                                                                                                i6 = R$id.unitButton;
                                                                                                                                                                ImageButton imageButton7 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                                if (imageButton7 != null) {
                                                                                                                                                                    i6 = R$id.unitLayout;
                                                                                                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                                    if (linearLayout7 != null) {
                                                                                                                                                                        i6 = R$id.unitTextView;
                                                                                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                                        if (textView15 != null) {
                                                                                                                                                                            i6 = R$id.warningTextView;
                                                                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                                            if (textView16 != null) {
                                                                                                                                                                                i6 = R$id.warningView;
                                                                                                                                                                                LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                                                if (linearLayout8 != null) {
                                                                                                                                                                                    return new FragmentDeviceAfterBinding((ConstraintLayout) view, imageView, imageView2, imageView3, textView, linearLayout, qMUIEmptyView, imageButton, textView2, imageButton2, linearLayout2, textView3, imageView4, imageButton3, linearLayout3, textView4, imageButton4, textView5, imageView5, imageButton5, textView6, linearLayout4, imageButton6, linearLayout5, textView7, textView8, slideLockView, constraintLayout, textView9, textView10, constraintLayout2, imageView6, textView11, constraintLayout3, nestedScrollView, textView12, textView13, textView14, linearLayout6, imageButton7, linearLayout7, textView15, textView16, linearLayout8);
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
    public static FragmentDeviceAfterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentDeviceAfterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_device_after, viewGroup, false);
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
