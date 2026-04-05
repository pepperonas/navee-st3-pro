package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class PopupTyreSettingBinding implements ViewBinding {

    @NonNull
    public final QMUIRoundButton cancelButton;

    @NonNull
    public final QMUIRoundButton confirmButton;

    @NonNull
    public final Button month1Button;

    @NonNull
    public final Button months2Button;

    @NonNull
    public final Button months3Button;

    @NonNull
    public final Button months6Button;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView subTitleLabel;

    @NonNull
    public final TextView titleLabel;

    @NonNull
    public final Button unTyreButton;

    @NonNull
    public final Button weeks2Button;

    private PopupTyreSettingBinding(@NonNull ConstraintLayout constraintLayout, @NonNull QMUIRoundButton qMUIRoundButton, @NonNull QMUIRoundButton qMUIRoundButton2, @NonNull Button button, @NonNull Button button2, @NonNull Button button3, @NonNull Button button4, @NonNull TextView textView, @NonNull TextView textView2, @NonNull Button button5, @NonNull Button button6) {
        this.rootView = constraintLayout;
        this.cancelButton = qMUIRoundButton;
        this.confirmButton = qMUIRoundButton2;
        this.month1Button = button;
        this.months2Button = button2;
        this.months3Button = button3;
        this.months6Button = button4;
        this.subTitleLabel = textView;
        this.titleLabel = textView2;
        this.unTyreButton = button5;
        this.weeks2Button = button6;
    }

    @NonNull
    public static PopupTyreSettingBinding bind(@NonNull View view) {
        int i6 = R$id.cancelButton;
        QMUIRoundButton qMUIRoundButton = (QMUIRoundButton) ViewBindings.findChildViewById(view, i6);
        if (qMUIRoundButton != null) {
            i6 = R$id.confirmButton;
            QMUIRoundButton qMUIRoundButton2 = (QMUIRoundButton) ViewBindings.findChildViewById(view, i6);
            if (qMUIRoundButton2 != null) {
                i6 = R$id.month1Button;
                Button button = (Button) ViewBindings.findChildViewById(view, i6);
                if (button != null) {
                    i6 = R$id.months2Button;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, i6);
                    if (button2 != null) {
                        i6 = R$id.months3Button;
                        Button button3 = (Button) ViewBindings.findChildViewById(view, i6);
                        if (button3 != null) {
                            i6 = R$id.months6Button;
                            Button button4 = (Button) ViewBindings.findChildViewById(view, i6);
                            if (button4 != null) {
                                i6 = R$id.subTitleLabel;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
                                if (textView != null) {
                                    i6 = R$id.titleLabel;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                                    if (textView2 != null) {
                                        i6 = R$id.unTyreButton;
                                        Button button5 = (Button) ViewBindings.findChildViewById(view, i6);
                                        if (button5 != null) {
                                            i6 = R$id.weeks2Button;
                                            Button button6 = (Button) ViewBindings.findChildViewById(view, i6);
                                            if (button6 != null) {
                                                return new PopupTyreSettingBinding((ConstraintLayout) view, qMUIRoundButton, qMUIRoundButton2, button, button2, button3, button4, textView, textView2, button5, button6);
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
    public static PopupTyreSettingBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PopupTyreSettingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.popup_tyre_setting, viewGroup, false);
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
