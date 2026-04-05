package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ActivityChangeAccountBinding implements ViewBinding {

    @NonNull
    public final Toolbar2Binding include;

    @NonNull
    public final TextView inputLimitsLabel;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final EditText textInputEditText;

    private ActivityChangeAccountBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Toolbar2Binding toolbar2Binding, @NonNull TextView textView, @NonNull EditText editText) {
        this.rootView = constraintLayout;
        this.include = toolbar2Binding;
        this.inputLimitsLabel = textView;
        this.textInputEditText = editText;
    }

    @NonNull
    public static ActivityChangeAccountBinding bind(@NonNull View view) {
        int i6 = R$id.include;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, i6);
        if (viewFindChildViewById != null) {
            Toolbar2Binding toolbar2BindingBind = Toolbar2Binding.bind(viewFindChildViewById);
            int i7 = R$id.inputLimitsLabel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i7);
            if (textView != null) {
                i7 = R$id.textInputEditText;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, i7);
                if (editText != null) {
                    return new ActivityChangeAccountBinding((ConstraintLayout) view, toolbar2BindingBind, textView, editText);
                }
            }
            i6 = i7;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ActivityChangeAccountBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityChangeAccountBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_change_account, viewGroup, false);
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
