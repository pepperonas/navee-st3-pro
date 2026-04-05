package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ActivityDeviceDashboardBinding implements ViewBinding {

    @NonNull
    public final TextView averageSpeedLabel;

    @NonNull
    public final TextView averageSpeedTitleLabel;

    @NonNull
    public final TextView averageSpeedUnitLabel;

    @NonNull
    public final TextView chargeLabel;

    @NonNull
    public final TextView chargeTitleLabel;

    @NonNull
    public final TextView chargeUnitLabel;

    @NonNull
    public final TextView durationLabel;

    @NonNull
    public final TextView durationTitleLabel;

    @NonNull
    public final TextView durationUnitLabel;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final TextView maxSpeedLabel;

    @NonNull
    public final TextView maxSpeedTitleLabel;

    @NonNull
    public final TextView maxSpeedUnitLabel;

    @NonNull
    public final TextView mileageLabel;

    @NonNull
    public final TextView mileageTitleLabel;

    @NonNull
    public final TextView mileageUnitLabel;

    @NonNull
    public final TextView rangeLabel;

    @NonNull
    public final TextView rangeTitleLabel;

    @NonNull
    public final TextView rangeUnitLabel;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView speedLabel;

    @NonNull
    public final TextView speedUnitLabel;

    private ActivityDeviceDashboardBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull TextView textView8, @NonNull TextView textView9, @NonNull ToolbarBinding toolbarBinding, @NonNull TextView textView10, @NonNull TextView textView11, @NonNull TextView textView12, @NonNull TextView textView13, @NonNull TextView textView14, @NonNull TextView textView15, @NonNull TextView textView16, @NonNull TextView textView17, @NonNull TextView textView18, @NonNull TextView textView19, @NonNull TextView textView20) {
        this.rootView = constraintLayout;
        this.averageSpeedLabel = textView;
        this.averageSpeedTitleLabel = textView2;
        this.averageSpeedUnitLabel = textView3;
        this.chargeLabel = textView4;
        this.chargeTitleLabel = textView5;
        this.chargeUnitLabel = textView6;
        this.durationLabel = textView7;
        this.durationTitleLabel = textView8;
        this.durationUnitLabel = textView9;
        this.include = toolbarBinding;
        this.maxSpeedLabel = textView10;
        this.maxSpeedTitleLabel = textView11;
        this.maxSpeedUnitLabel = textView12;
        this.mileageLabel = textView13;
        this.mileageTitleLabel = textView14;
        this.mileageUnitLabel = textView15;
        this.rangeLabel = textView16;
        this.rangeTitleLabel = textView17;
        this.rangeUnitLabel = textView18;
        this.speedLabel = textView19;
        this.speedUnitLabel = textView20;
    }

    @NonNull
    public static ActivityDeviceDashboardBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.averageSpeedLabel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
        if (textView != null) {
            i6 = R$id.averageSpeedTitleLabel;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
            if (textView2 != null) {
                i6 = R$id.averageSpeedUnitLabel;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i6);
                if (textView3 != null) {
                    i6 = R$id.chargeLabel;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i6);
                    if (textView4 != null) {
                        i6 = R$id.chargeTitleLabel;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i6);
                        if (textView5 != null) {
                            i6 = R$id.chargeUnitLabel;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i6);
                            if (textView6 != null) {
                                i6 = R$id.durationLabel;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i6);
                                if (textView7 != null) {
                                    i6 = R$id.durationTitleLabel;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i6);
                                    if (textView8 != null) {
                                        i6 = R$id.durationUnitLabel;
                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i6);
                                        if (textView9 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.include))) != null) {
                                            ToolbarBinding toolbarBindingBind = ToolbarBinding.bind(viewFindChildViewById);
                                            i6 = R$id.maxSpeedLabel;
                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i6);
                                            if (textView10 != null) {
                                                i6 = R$id.maxSpeedTitleLabel;
                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                if (textView11 != null) {
                                                    i6 = R$id.maxSpeedUnitLabel;
                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                    if (textView12 != null) {
                                                        i6 = R$id.mileageLabel;
                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                        if (textView13 != null) {
                                                            i6 = R$id.mileageTitleLabel;
                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                            if (textView14 != null) {
                                                                i6 = R$id.mileageUnitLabel;
                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                if (textView15 != null) {
                                                                    i6 = R$id.rangeLabel;
                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                    if (textView16 != null) {
                                                                        i6 = R$id.rangeTitleLabel;
                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                        if (textView17 != null) {
                                                                            i6 = R$id.rangeUnitLabel;
                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                            if (textView18 != null) {
                                                                                i6 = R$id.speedLabel;
                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                if (textView19 != null) {
                                                                                    i6 = R$id.speedUnitLabel;
                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                    if (textView20 != null) {
                                                                                        return new ActivityDeviceDashboardBinding((ConstraintLayout) view, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, toolbarBindingBind, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20);
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
    public static ActivityDeviceDashboardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityDeviceDashboardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_device_dashboard, viewGroup, false);
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
