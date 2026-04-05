package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.ui.wheel.DataStatusView;

/* loaded from: classes3.dex */
public final class ActivityDriveHistoryBinding implements ViewBinding {

    @NonNull
    public final ImageButton barButton1;

    @NonNull
    public final ImageButton barButton10;

    @NonNull
    public final ImageButton barButton2;

    @NonNull
    public final ImageButton barButton3;

    @NonNull
    public final ImageButton barButton4;

    @NonNull
    public final ImageButton barButton5;

    @NonNull
    public final ImageButton barButton6;

    @NonNull
    public final ImageButton barButton7;

    @NonNull
    public final ImageButton barButton8;

    @NonNull
    public final ImageButton barButton9;

    @NonNull
    public final LinearLayout barLayout1;

    @NonNull
    public final LinearLayout barLayout10;

    @NonNull
    public final LinearLayout barLayout2;

    @NonNull
    public final LinearLayout barLayout3;

    @NonNull
    public final LinearLayout barLayout4;

    @NonNull
    public final LinearLayout barLayout5;

    @NonNull
    public final LinearLayout barLayout6;

    @NonNull
    public final LinearLayout barLayout7;

    @NonNull
    public final LinearLayout barLayout8;

    @NonNull
    public final LinearLayout barLayout9;

    @NonNull
    public final TextView durationLabel;

    @NonNull
    public final TextView durationTitleLabel;

    @NonNull
    public final TextView durationUnitLabel;

    @NonNull
    public final Guideline guideline2;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final TextView mileageLabel;

    @NonNull
    public final TextView mileageTitleLabel;

    @NonNull
    public final TextView mileageUnitLabel;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView speedLabel;

    @NonNull
    public final TextView speedTitleLabel;

    @NonNull
    public final TextView speedUnitLabel;

    @NonNull
    public final HorizontalScrollView stackView;

    @NonNull
    public final DataStatusView statusView;

    @NonNull
    public final TextView titleLabel;

    @NonNull
    public final TextView totalMileageLabel;

    @NonNull
    public final TextView totalMileageTitleLabel;

    @NonNull
    public final TextView totalMileageUnitLabel;

    @NonNull
    public final TextView totalTimeLabel;

    @NonNull
    public final TextView totalTimeTitleLabel;

    @NonNull
    public final TextView totalTimeUnitLabel;

    @NonNull
    public final TextView yaxisLabel0;

    @NonNull
    public final TextView yaxisLabel05;

    @NonNull
    public final TextView yaxisLabel1;

    @NonNull
    public final TextView yaxisLabel15;

    @NonNull
    public final TextView yaxisLabel2;

    @NonNull
    public final TextView yaxisLabel25;

    @NonNull
    public final TextView yaxisLabel3;

    @NonNull
    public final TextView yaxisLabel35;

    @NonNull
    public final TextView yaxisLabel4;

    @NonNull
    public final TextView yaxisLabel45;

    @NonNull
    public final TextView yaxisLabel5;

    @NonNull
    public final TextView yaxisLabel55;

    @NonNull
    public final TextView yaxisLabel6;

    @NonNull
    public final TextView yaxisLabel65;

    @NonNull
    public final TextView yaxisLabelX;

    @NonNull
    public final LinearLayout yaxisLayout;

    private ActivityDriveHistoryBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageButton imageButton, @NonNull ImageButton imageButton2, @NonNull ImageButton imageButton3, @NonNull ImageButton imageButton4, @NonNull ImageButton imageButton5, @NonNull ImageButton imageButton6, @NonNull ImageButton imageButton7, @NonNull ImageButton imageButton8, @NonNull ImageButton imageButton9, @NonNull ImageButton imageButton10, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull LinearLayout linearLayout5, @NonNull LinearLayout linearLayout6, @NonNull LinearLayout linearLayout7, @NonNull LinearLayout linearLayout8, @NonNull LinearLayout linearLayout9, @NonNull LinearLayout linearLayout10, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull Guideline guideline, @NonNull ToolbarBinding toolbarBinding, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull TextView textView8, @NonNull TextView textView9, @NonNull HorizontalScrollView horizontalScrollView, @NonNull DataStatusView dataStatusView, @NonNull TextView textView10, @NonNull TextView textView11, @NonNull TextView textView12, @NonNull TextView textView13, @NonNull TextView textView14, @NonNull TextView textView15, @NonNull TextView textView16, @NonNull TextView textView17, @NonNull TextView textView18, @NonNull TextView textView19, @NonNull TextView textView20, @NonNull TextView textView21, @NonNull TextView textView22, @NonNull TextView textView23, @NonNull TextView textView24, @NonNull TextView textView25, @NonNull TextView textView26, @NonNull TextView textView27, @NonNull TextView textView28, @NonNull TextView textView29, @NonNull TextView textView30, @NonNull TextView textView31, @NonNull LinearLayout linearLayout11) {
        this.rootView = constraintLayout;
        this.barButton1 = imageButton;
        this.barButton10 = imageButton2;
        this.barButton2 = imageButton3;
        this.barButton3 = imageButton4;
        this.barButton4 = imageButton5;
        this.barButton5 = imageButton6;
        this.barButton6 = imageButton7;
        this.barButton7 = imageButton8;
        this.barButton8 = imageButton9;
        this.barButton9 = imageButton10;
        this.barLayout1 = linearLayout;
        this.barLayout10 = linearLayout2;
        this.barLayout2 = linearLayout3;
        this.barLayout3 = linearLayout4;
        this.barLayout4 = linearLayout5;
        this.barLayout5 = linearLayout6;
        this.barLayout6 = linearLayout7;
        this.barLayout7 = linearLayout8;
        this.barLayout8 = linearLayout9;
        this.barLayout9 = linearLayout10;
        this.durationLabel = textView;
        this.durationTitleLabel = textView2;
        this.durationUnitLabel = textView3;
        this.guideline2 = guideline;
        this.include = toolbarBinding;
        this.mileageLabel = textView4;
        this.mileageTitleLabel = textView5;
        this.mileageUnitLabel = textView6;
        this.speedLabel = textView7;
        this.speedTitleLabel = textView8;
        this.speedUnitLabel = textView9;
        this.stackView = horizontalScrollView;
        this.statusView = dataStatusView;
        this.titleLabel = textView10;
        this.totalMileageLabel = textView11;
        this.totalMileageTitleLabel = textView12;
        this.totalMileageUnitLabel = textView13;
        this.totalTimeLabel = textView14;
        this.totalTimeTitleLabel = textView15;
        this.totalTimeUnitLabel = textView16;
        this.yaxisLabel0 = textView17;
        this.yaxisLabel05 = textView18;
        this.yaxisLabel1 = textView19;
        this.yaxisLabel15 = textView20;
        this.yaxisLabel2 = textView21;
        this.yaxisLabel25 = textView22;
        this.yaxisLabel3 = textView23;
        this.yaxisLabel35 = textView24;
        this.yaxisLabel4 = textView25;
        this.yaxisLabel45 = textView26;
        this.yaxisLabel5 = textView27;
        this.yaxisLabel55 = textView28;
        this.yaxisLabel6 = textView29;
        this.yaxisLabel65 = textView30;
        this.yaxisLabelX = textView31;
        this.yaxisLayout = linearLayout11;
    }

    @NonNull
    public static ActivityDriveHistoryBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.barButton1;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i6);
        if (imageButton != null) {
            i6 = R$id.barButton10;
            ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, i6);
            if (imageButton2 != null) {
                i6 = R$id.barButton2;
                ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                if (imageButton3 != null) {
                    i6 = R$id.barButton3;
                    ImageButton imageButton4 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                    if (imageButton4 != null) {
                        i6 = R$id.barButton4;
                        ImageButton imageButton5 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                        if (imageButton5 != null) {
                            i6 = R$id.barButton5;
                            ImageButton imageButton6 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                            if (imageButton6 != null) {
                                i6 = R$id.barButton6;
                                ImageButton imageButton7 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                if (imageButton7 != null) {
                                    i6 = R$id.barButton7;
                                    ImageButton imageButton8 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                    if (imageButton8 != null) {
                                        i6 = R$id.barButton8;
                                        ImageButton imageButton9 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                        if (imageButton9 != null) {
                                            i6 = R$id.barButton9;
                                            ImageButton imageButton10 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                                            if (imageButton10 != null) {
                                                i6 = R$id.barLayout1;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                if (linearLayout != null) {
                                                    i6 = R$id.barLayout10;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                    if (linearLayout2 != null) {
                                                        i6 = R$id.barLayout2;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                        if (linearLayout3 != null) {
                                                            i6 = R$id.barLayout3;
                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                            if (linearLayout4 != null) {
                                                                i6 = R$id.barLayout4;
                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                                if (linearLayout5 != null) {
                                                                    i6 = R$id.barLayout5;
                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                                    if (linearLayout6 != null) {
                                                                        i6 = R$id.barLayout6;
                                                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                                        if (linearLayout7 != null) {
                                                                            i6 = R$id.barLayout7;
                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                                            if (linearLayout8 != null) {
                                                                                i6 = R$id.barLayout8;
                                                                                LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                                                if (linearLayout9 != null) {
                                                                                    i6 = R$id.barLayout9;
                                                                                    LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                                                    if (linearLayout10 != null) {
                                                                                        i6 = R$id.durationLabel;
                                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                        if (textView != null) {
                                                                                            i6 = R$id.durationTitleLabel;
                                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                            if (textView2 != null) {
                                                                                                i6 = R$id.durationUnitLabel;
                                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                if (textView3 != null) {
                                                                                                    i6 = R$id.guideline2;
                                                                                                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i6);
                                                                                                    if (guideline != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.include))) != null) {
                                                                                                        ToolbarBinding toolbarBindingBind = ToolbarBinding.bind(viewFindChildViewById);
                                                                                                        i6 = R$id.mileageLabel;
                                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                        if (textView4 != null) {
                                                                                                            i6 = R$id.mileageTitleLabel;
                                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                            if (textView5 != null) {
                                                                                                                i6 = R$id.mileageUnitLabel;
                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                if (textView6 != null) {
                                                                                                                    i6 = R$id.speedLabel;
                                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                    if (textView7 != null) {
                                                                                                                        i6 = R$id.speedTitleLabel;
                                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                        if (textView8 != null) {
                                                                                                                            i6 = R$id.speedUnitLabel;
                                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                            if (textView9 != null) {
                                                                                                                                i6 = R$id.stackView;
                                                                                                                                HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                if (horizontalScrollView != null) {
                                                                                                                                    i6 = R$id.statusView;
                                                                                                                                    DataStatusView dataStatusView = (DataStatusView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                    if (dataStatusView != null) {
                                                                                                                                        i6 = R$id.titleLabel;
                                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                        if (textView10 != null) {
                                                                                                                                            i6 = R$id.totalMileageLabel;
                                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                            if (textView11 != null) {
                                                                                                                                                i6 = R$id.totalMileageTitleLabel;
                                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                if (textView12 != null) {
                                                                                                                                                    i6 = R$id.totalMileageUnitLabel;
                                                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                    if (textView13 != null) {
                                                                                                                                                        i6 = R$id.totalTimeLabel;
                                                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                        if (textView14 != null) {
                                                                                                                                                            i6 = R$id.totalTimeTitleLabel;
                                                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                            if (textView15 != null) {
                                                                                                                                                                i6 = R$id.totalTimeUnitLabel;
                                                                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                                if (textView16 != null) {
                                                                                                                                                                    i6 = R$id.yaxisLabel0;
                                                                                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                                    if (textView17 != null) {
                                                                                                                                                                        i6 = R$id.yaxisLabel0_5;
                                                                                                                                                                        TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                                        if (textView18 != null) {
                                                                                                                                                                            i6 = R$id.yaxisLabel1;
                                                                                                                                                                            TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                                            if (textView19 != null) {
                                                                                                                                                                                i6 = R$id.yaxisLabel1_5;
                                                                                                                                                                                TextView textView20 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                                                if (textView20 != null) {
                                                                                                                                                                                    i6 = R$id.yaxisLabel2;
                                                                                                                                                                                    TextView textView21 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                                                    if (textView21 != null) {
                                                                                                                                                                                        i6 = R$id.yaxisLabel2_5;
                                                                                                                                                                                        TextView textView22 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                                                        if (textView22 != null) {
                                                                                                                                                                                            i6 = R$id.yaxisLabel3;
                                                                                                                                                                                            TextView textView23 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                                                            if (textView23 != null) {
                                                                                                                                                                                                i6 = R$id.yaxisLabel3_5;
                                                                                                                                                                                                TextView textView24 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                                                                if (textView24 != null) {
                                                                                                                                                                                                    i6 = R$id.yaxisLabel4;
                                                                                                                                                                                                    TextView textView25 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                                                                    if (textView25 != null) {
                                                                                                                                                                                                        i6 = R$id.yaxisLabel4_5;
                                                                                                                                                                                                        TextView textView26 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                                                                        if (textView26 != null) {
                                                                                                                                                                                                            i6 = R$id.yaxisLabel5;
                                                                                                                                                                                                            TextView textView27 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                                                                            if (textView27 != null) {
                                                                                                                                                                                                                i6 = R$id.yaxisLabel5_5;
                                                                                                                                                                                                                TextView textView28 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                                                                                if (textView28 != null) {
                                                                                                                                                                                                                    i6 = R$id.yaxisLabel6;
                                                                                                                                                                                                                    TextView textView29 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                                                                                    if (textView29 != null) {
                                                                                                                                                                                                                        i6 = R$id.yaxisLabel6_5;
                                                                                                                                                                                                                        TextView textView30 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                                                                                        if (textView30 != null) {
                                                                                                                                                                                                                            i6 = R$id.yaxisLabelX;
                                                                                                                                                                                                                            TextView textView31 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                                                                                            if (textView31 != null) {
                                                                                                                                                                                                                                i6 = R$id.yaxisLayout;
                                                                                                                                                                                                                                LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                                                                                                                                                                                                if (linearLayout11 != null) {
                                                                                                                                                                                                                                    return new ActivityDriveHistoryBinding((ConstraintLayout) view, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8, imageButton9, imageButton10, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10, textView, textView2, textView3, guideline, toolbarBindingBind, textView4, textView5, textView6, textView7, textView8, textView9, horizontalScrollView, dataStatusView, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, textView29, textView30, textView31, linearLayout11);
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
    public static ActivityDriveHistoryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityDriveHistoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_drive_history, viewGroup, false);
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
