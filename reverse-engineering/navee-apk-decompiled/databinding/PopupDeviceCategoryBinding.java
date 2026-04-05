package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class PopupDeviceCategoryBinding implements ViewBinding {

    @NonNull
    public final TextView itemCountOne;

    @NonNull
    public final TextView itemCountThree;

    @NonNull
    public final TextView itemCountTwo;

    @NonNull
    public final TextView itemNameOne;

    @NonNull
    public final TextView itemNameThree;

    @NonNull
    public final TextView itemNameTwo;

    @NonNull
    public final LinearLayout layoutItemOne;

    @NonNull
    public final LinearLayout layoutItemThree;

    @NonNull
    public final LinearLayout layoutItemTwo;

    @NonNull
    private final LinearLayout rootView;

    private PopupDeviceCategoryBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4) {
        this.rootView = linearLayout;
        this.itemCountOne = textView;
        this.itemCountThree = textView2;
        this.itemCountTwo = textView3;
        this.itemNameOne = textView4;
        this.itemNameThree = textView5;
        this.itemNameTwo = textView6;
        this.layoutItemOne = linearLayout2;
        this.layoutItemThree = linearLayout3;
        this.layoutItemTwo = linearLayout4;
    }

    @NonNull
    public static PopupDeviceCategoryBinding bind(@NonNull View view) {
        int i6 = R$id.item_count_one;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
        if (textView != null) {
            i6 = R$id.item_count_three;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
            if (textView2 != null) {
                i6 = R$id.item_count_two;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i6);
                if (textView3 != null) {
                    i6 = R$id.item_name_one;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i6);
                    if (textView4 != null) {
                        i6 = R$id.item_name_three;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i6);
                        if (textView5 != null) {
                            i6 = R$id.item_name_two;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i6);
                            if (textView6 != null) {
                                i6 = R$id.layout_item_one;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                if (linearLayout != null) {
                                    i6 = R$id.layout_item_three;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                    if (linearLayout2 != null) {
                                        i6 = R$id.layout_item_two;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                        if (linearLayout3 != null) {
                                            return new PopupDeviceCategoryBinding((LinearLayout) view, textView, textView2, textView3, textView4, textView5, textView6, linearLayout, linearLayout2, linearLayout3);
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
    public static PopupDeviceCategoryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PopupDeviceCategoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.popup_device_category, viewGroup, false);
        if (z6) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
