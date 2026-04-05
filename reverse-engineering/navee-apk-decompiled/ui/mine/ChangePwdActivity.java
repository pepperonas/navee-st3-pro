package com.uz.navee.ui.mine;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.gson.GsonBuilder;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.ui.login.LoginLaunchActivity;
import com.uz.navee.ui.login.ResetPasswordActivity;
import com.uz.navee.ui.mine.bean.BaseBean;
import com.uz.navee.ui.wheel.AlertPopup;
import com.uz.navee.utils.c;
import d4.d;
import g4.e1;
import java.util.HashMap;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class ChangePwdActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public EditText f13000c;

    /* renamed from: d, reason: collision with root package name */
    public EditText f13001d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f13002e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f13003f;

    /* renamed from: g, reason: collision with root package name */
    public Button f13004g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f13005h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f13006i = true;

    /* renamed from: j, reason: collision with root package name */
    public boolean f13007j = true;

    /* renamed from: k, reason: collision with root package name */
    public String f13008k;

    /* renamed from: l, reason: collision with root package name */
    public String f13009l;

    /* renamed from: m, reason: collision with root package name */
    public d f13010m;

    public class a implements d.h {
        public a() {
        }

        @Override // d4.d.h
        public void a(String str) {
            ChangePwdActivity.this.B();
            BaseBean baseBean = (BaseBean) new GsonBuilder().create().fromJson(str, BaseBean.class);
            if (baseBean != null) {
                if (baseBean.getCode() != 200) {
                    Toast.makeText(ChangePwdActivity.this, baseBean.getMsg(), 0).show();
                } else {
                    ChangePwdActivity changePwdActivity = ChangePwdActivity.this;
                    AlertPopup.Q(changePwdActivity, "", changePwdActivity.getString(R$string.change_password_success), ChangePwdActivity.this.getString(R$string.confirm), "", new AlertPopup.a() { // from class: h4.l0
                        @Override // com.uz.navee.ui.wheel.AlertPopup.a
                        public /* synthetic */ void a() {
                            j4.c.a(this);
                        }

                        @Override // com.uz.navee.ui.wheel.AlertPopup.a
                        public final void b() {
                            this.f13800a.d();
                        }
                    });
                }
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            ChangePwdActivity.this.B();
            Toast.makeText(ChangePwdActivity.this, exc.getMessage(), 0).show();
        }

        public final /* synthetic */ void d() {
            e1.m();
            LoginLaunchActivity.Q0(ChangePwdActivity.this);
        }
    }

    public static void F(EditText editText, boolean z6) {
        if (editText != null) {
            int selectionEnd = editText.getSelectionEnd();
            int length = editText.getText().toString().length();
            editText.setInputType(z6 ? 145 : TsExtractor.TS_STREAM_TYPE_AC3);
            editText.setSelection(Math.min(selectionEnd, length));
        }
    }

    private void W() {
        this.f13000c = (EditText) findViewById(R$id.et_old_pwd);
        this.f13001d = (EditText) findViewById(R$id.et_new_pwd);
        this.f13002e = (ImageView) findViewById(R$id.iv_old_pwd);
        this.f13003f = (ImageView) findViewById(R$id.iv_new_pwd);
        this.f13004g = (Button) findViewById(R$id.btn_ok);
        this.f13005h = (TextView) findViewById(R$id.tv_forget_pwd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(View view) {
        startActivity(new Intent(this, (Class<?>) ResetPasswordActivity.class));
    }

    private void initView() {
        this.f13002e.setOnClickListener(new View.OnClickListener() { // from class: h4.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13784a.V(view);
            }
        });
        this.f13003f.setOnClickListener(new View.OnClickListener() { // from class: h4.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13788a.U(view);
            }
        });
        this.f13004g.setOnClickListener(new View.OnClickListener() { // from class: h4.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13792a.a0(view);
            }
        });
        String email = e1.u().f13675c.getEmail();
        if (email == null || email.isEmpty()) {
            this.f13005h.setVisibility(8);
            return;
        }
        this.f13005h.setVisibility(0);
        this.f13005h.getPaint().setFlags(8);
        this.f13005h.setText(com.uz.navee.utils.d.a(getString(R$string.forgot_pwd)));
        this.f13005h.setOnClickListener(new View.OnClickListener() { // from class: h4.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13796a.Z(view);
            }
        });
    }

    public final void U(View view) {
        F(this.f13001d, this.f13007j);
        if (this.f13007j) {
            this.f13003f.setImageResource(R$mipmap.ic_switch_pwd_open);
            this.f13007j = false;
        } else {
            this.f13003f.setImageResource(R$mipmap.ic_switch_pwd_close);
            this.f13007j = true;
        }
    }

    public final void V(View view) {
        F(this.f13000c, this.f13006i);
        if (this.f13006i) {
            this.f13002e.setImageResource(R$mipmap.ic_switch_pwd_open);
            this.f13006i = false;
        } else {
            this.f13002e.setImageResource(R$mipmap.ic_switch_pwd_close);
            this.f13006i = true;
        }
    }

    public final void a0(View view) {
        this.f13008k = this.f13000c.getText().toString();
        this.f13009l = this.f13001d.getText().toString();
        C();
        if (TextUtils.isEmpty(this.f13008k)) {
            com.uz.navee.utils.a.b(this.f13000c);
            O();
            return;
        }
        if (TextUtils.isEmpty(this.f13009l)) {
            com.uz.navee.utils.a.b(this.f13001d);
            O();
            return;
        }
        this.f13010m = d.h();
        HashMap map = new HashMap();
        map.put("passwd", this.f13008k);
        map.put("newPasswd", this.f13009l);
        String str = e4.a.a() + "/updatePasswd";
        K();
        this.f13010m.g(str, map, new a());
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_change_pwd);
        W();
        getWindow().setBackgroundDrawable(ContextCompat.getDrawable(this, R$mipmap.bg_login));
        c.e(this, "", ContextCompat.getColor(this, R$color.clear));
        initView();
    }
}
