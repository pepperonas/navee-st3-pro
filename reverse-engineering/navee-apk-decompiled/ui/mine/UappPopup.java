package com.uz.navee.ui.mine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.lxj.xpopup.core.CenterPopupView;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class UappPopup extends CenterPopupView {
    public TextView A;
    public TextView B;
    public Button C;
    public Button D;
    public String E;
    public String F;
    public String G;
    public String H;
    public d I;

    /* renamed from: y, reason: collision with root package name */
    public LinearLayout f13125y;

    /* renamed from: z, reason: collision with root package name */
    public LinearLayout f13126z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UappPopup.this.I.b();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UappPopup.this.I.a();
            UappPopup.this.m();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UappPopup.this.I.c();
            UappPopup.this.m();
        }
    }

    public interface d {
        void a();

        void b();

        void c();
    }

    public UappPopup(@NonNull Context context) {
        super(context);
    }

    private void M() {
        this.f13125y = (LinearLayout) findViewById(R$id.textLayout);
        this.f13126z = (LinearLayout) findViewById(R$id.actionLayout);
        this.A = (TextView) findViewById(R$id.titleLabel);
        this.B = (TextView) findViewById(R$id.messageLabel);
        this.C = (Button) findViewById(R$id.cancelButton);
        this.D = (Button) findViewById(R$id.confirmButton);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void A() {
        super.A();
        M();
        String string = getContext().getString(R$string.user_agreement);
        String string2 = getContext().getString(R$string.privacy_policy);
        String string3 = getContext().getString(R$string.agree_uapp_tips_and);
        String str = this.F;
        if (TextUtils.isEmpty(str)) {
            str = string + string3 + string2;
        }
        this.A.setText(str);
        String str2 = this.E;
        if (str2 == null || str2.isEmpty()) {
            this.B.setText(R$string.app_agreement_msg);
        } else {
            this.B.setText(this.E);
        }
        this.B.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.B.setOnClickListener(new a());
        if (!TextUtils.isEmpty(this.G)) {
            this.D.setText(this.G);
        }
        if (!TextUtils.isEmpty(this.H)) {
            this.C.setText(this.H);
        }
        this.C.setOnClickListener(new b());
        this.D.setOnClickListener(new c());
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        return R$layout.popup_uapp;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void onDestroy() {
        super.onDestroy();
    }

    public UappPopup(Context context, String str, d dVar) {
        super(context);
        this.I = dVar;
        this.E = str;
    }
}
