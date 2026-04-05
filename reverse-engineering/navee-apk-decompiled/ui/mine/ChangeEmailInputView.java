package com.uz.navee.ui.mine;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class ChangeEmailInputView extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    public TextInputLayout f12995a;

    /* renamed from: b, reason: collision with root package name */
    public TextInputEditText f12996b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f12997c;

    /* renamed from: d, reason: collision with root package name */
    public View f12998d;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        }
    }

    public ChangeEmailInputView(Context context) {
        super(context);
        j(context);
    }

    private void b() {
        this.f12995a = (TextInputLayout) findViewById(R$id.textInputLayout);
        this.f12996b = (TextInputEditText) findViewById(R$id.textInputEditText);
        this.f12997c = (TextView) findViewById(R$id.codeButton);
        this.f12998d = findViewById(R$id.codeIco);
    }

    public void e() {
        this.f12998d.setVisibility(4);
    }

    public final void j(Context context) {
        LayoutInflater.from(context).inflate(R$layout.view_change_email_input, this);
        b();
        this.f12996b.addTextChangedListener(new a());
        this.f12996b.setTextDirection(3);
        if ((context instanceof Activity) && ((Activity) context).getWindow().getDecorView().getLayoutDirection() == 1) {
            this.f12996b.setGravity(8388629);
        }
    }

    public void k(String str) {
        e();
        this.f12997c.setEnabled(false);
        this.f12997c.setAlpha(0.3f);
        this.f12997c.setText(str);
    }

    public void l() {
        this.f12998d.setVisibility(0);
        this.f12997c.setAlpha(1.0f);
        this.f12997c.setText("");
        this.f12997c.setEnabled(true);
    }

    public void setText(String str) {
        this.f12997c.setText(str);
    }

    public ChangeEmailInputView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j(context);
    }
}
