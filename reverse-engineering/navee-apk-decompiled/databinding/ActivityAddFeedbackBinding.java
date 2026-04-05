package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ActivityAddFeedbackBinding implements ViewBinding {

    @NonNull
    public final Button btnSubmit;

    @NonNull
    public final ConstraintLayout clInvoiceFile;

    @NonNull
    public final EditText etChannel;

    @NonNull
    public final EditText etInputEmail;

    @NonNull
    public final EditText etQuestionMsg;

    @NonNull
    public final EditText etTitle;

    @NonNull
    public final Toolbar2Binding include;

    @NonNull
    public final ImageView ivInvoiceOperator;

    @NonNull
    public final LinearLayout llHasInvoice;

    @NonNull
    public final LinearLayout llayoutMsg;

    @NonNull
    public final LinearLayout llayoutTitle;

    @NonNull
    public final LinearLayout lyVehicle;

    @NonNull
    public final RadioButton rbHas;

    @NonNull
    public final RadioButton rbNot;

    @NonNull
    public final RadioGroup rgInvoice;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final RecyclerView rvPhoto;

    @NonNull
    public final ScrollView scrollView;

    @NonNull
    public final TextView tvAmount;

    @NonNull
    public final TextView tvCountry;

    @NonNull
    public final TextView tvInvoiceText;

    @NonNull
    public final TextView tvInvoiceTitle;

    @NonNull
    public final TextView tvVehicleName;

    @NonNull
    public final ImageView vehicleIndicator;

    private ActivityAddFeedbackBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Button button, @NonNull ConstraintLayout constraintLayout2, @NonNull EditText editText, @NonNull EditText editText2, @NonNull EditText editText3, @NonNull EditText editText4, @NonNull Toolbar2Binding toolbar2Binding, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull RadioGroup radioGroup, @NonNull RecyclerView recyclerView, @NonNull ScrollView scrollView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull ImageView imageView2) {
        this.rootView = constraintLayout;
        this.btnSubmit = button;
        this.clInvoiceFile = constraintLayout2;
        this.etChannel = editText;
        this.etInputEmail = editText2;
        this.etQuestionMsg = editText3;
        this.etTitle = editText4;
        this.include = toolbar2Binding;
        this.ivInvoiceOperator = imageView;
        this.llHasInvoice = linearLayout;
        this.llayoutMsg = linearLayout2;
        this.llayoutTitle = linearLayout3;
        this.lyVehicle = linearLayout4;
        this.rbHas = radioButton;
        this.rbNot = radioButton2;
        this.rgInvoice = radioGroup;
        this.rvPhoto = recyclerView;
        this.scrollView = scrollView;
        this.tvAmount = textView;
        this.tvCountry = textView2;
        this.tvInvoiceText = textView3;
        this.tvInvoiceTitle = textView4;
        this.tvVehicleName = textView5;
        this.vehicleIndicator = imageView2;
    }

    @NonNull
    public static ActivityAddFeedbackBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.btn_submit;
        Button button = (Button) ViewBindings.findChildViewById(view, i6);
        if (button != null) {
            i6 = R$id.cl_invoice_file;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i6);
            if (constraintLayout != null) {
                i6 = R$id.et_channel;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, i6);
                if (editText != null) {
                    i6 = R$id.et_input_email;
                    EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i6);
                    if (editText2 != null) {
                        i6 = R$id.et_question_msg;
                        EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i6);
                        if (editText3 != null) {
                            i6 = R$id.et_title;
                            EditText editText4 = (EditText) ViewBindings.findChildViewById(view, i6);
                            if (editText4 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.include))) != null) {
                                Toolbar2Binding toolbar2BindingBind = Toolbar2Binding.bind(viewFindChildViewById);
                                i6 = R$id.iv_invoice_operator;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
                                if (imageView != null) {
                                    i6 = R$id.ll_has_invoice;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                    if (linearLayout != null) {
                                        i6 = R$id.llayout_msg;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                        if (linearLayout2 != null) {
                                            i6 = R$id.llayout_title;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                            if (linearLayout3 != null) {
                                                i6 = R$id.lyVehicle;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                if (linearLayout4 != null) {
                                                    i6 = R$id.rb_has;
                                                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i6);
                                                    if (radioButton != null) {
                                                        i6 = R$id.rb_not;
                                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i6);
                                                        if (radioButton2 != null) {
                                                            i6 = R$id.rg_invoice;
                                                            RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, i6);
                                                            if (radioGroup != null) {
                                                                i6 = R$id.rv_photo;
                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i6);
                                                                if (recyclerView != null) {
                                                                    i6 = R$id.scrollView;
                                                                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i6);
                                                                    if (scrollView != null) {
                                                                        i6 = R$id.tv_amount;
                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                        if (textView != null) {
                                                                            i6 = R$id.tv_country;
                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                            if (textView2 != null) {
                                                                                i6 = R$id.tv_invoice_text;
                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                if (textView3 != null) {
                                                                                    i6 = R$id.tv_invoice_title;
                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                    if (textView4 != null) {
                                                                                        i6 = R$id.tvVehicleName;
                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                                        if (textView5 != null) {
                                                                                            i6 = R$id.vehicleIndicator;
                                                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i6);
                                                                                            if (imageView2 != null) {
                                                                                                return new ActivityAddFeedbackBinding((ConstraintLayout) view, button, constraintLayout, editText, editText2, editText3, editText4, toolbar2BindingBind, imageView, linearLayout, linearLayout2, linearLayout3, linearLayout4, radioButton, radioButton2, radioGroup, recyclerView, scrollView, textView, textView2, textView3, textView4, textView5, imageView2);
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
    public static ActivityAddFeedbackBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityAddFeedbackBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_add_feedback, viewGroup, false);
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
