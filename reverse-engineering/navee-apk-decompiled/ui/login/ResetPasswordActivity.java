package com.uz.navee.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import b5.g;
import com.google.gson.GsonBuilder;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.databinding.ActivityResetPasswordBinding;
import com.uz.navee.ui.device.CheckCodePopup;
import com.uz.navee.ui.login.ResetPasswordActivity;
import com.uz.navee.ui.mine.UserAgreementPPActivity;
import com.uz.navee.ui.mine.bean.BaseBean;
import com.uz.navee.ui.wheel.AlertPopup;
import d4.d;
import g4.e1;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.u;
import z4.l;

/* loaded from: classes3.dex */
public class ResetPasswordActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public ActivityResetPasswordBinding f12875c;

    /* renamed from: h, reason: collision with root package name */
    public QMUITipDialog f12880h;

    /* renamed from: i, reason: collision with root package name */
    public d4.d f12881i;

    /* renamed from: l, reason: collision with root package name */
    public io.reactivex.rxjava3.disposables.c f12884l;

    /* renamed from: n, reason: collision with root package name */
    public ImageView f12886n;

    /* renamed from: o, reason: collision with root package name */
    public EditText f12887o;

    /* renamed from: p, reason: collision with root package name */
    public EditText f12888p;

    /* renamed from: d, reason: collision with root package name */
    public ObservableField f12876d = new ObservableField("");

    /* renamed from: e, reason: collision with root package name */
    public ObservableField f12877e = new ObservableField("");

    /* renamed from: f, reason: collision with root package name */
    public ObservableField f12878f = new ObservableField("");

    /* renamed from: g, reason: collision with root package name */
    public boolean f12879g = true;

    /* renamed from: j, reason: collision with root package name */
    public Boolean f12882j = Boolean.FALSE;

    /* renamed from: k, reason: collision with root package name */
    public boolean f12883k = true;

    /* renamed from: m, reason: collision with root package name */
    public final int f12885m = 60;

    public class a extends Observable.OnPropertyChangedCallback {
        public a() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i6) {
            ResetPasswordActivity.this.f12875c.codeInputView2.f12997c.setAlpha(TextUtils.isEmpty((CharSequence) ResetPasswordActivity.this.f12876d.get()) ? 0.3f : 1.0f);
        }
    }

    public class b extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12890a;

        public b(int i6) {
            this.f12890a = i6;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            ResetPasswordActivity.this.x0();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(this.f12890a);
            textPaint.setUnderlineText(true);
        }
    }

    public class c extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12892a;

        public c(int i6) {
            this.f12892a = i6;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            ResetPasswordActivity.this.x0();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(this.f12892a);
            textPaint.setUnderlineText(true);
        }
    }

    public class d implements d.h {
        public d() {
        }

        @Override // d4.d.h
        public void a(String str) {
            ResetPasswordActivity.this.f12880h.dismiss();
            BaseBean baseBean = (BaseBean) new GsonBuilder().create().fromJson(str, BaseBean.class);
            if (baseBean != null) {
                if (baseBean.getCode() != 200) {
                    Toast.makeText(ResetPasswordActivity.this, baseBean.getMsg(), 0).show();
                    return;
                }
                ResetPasswordActivity resetPasswordActivity = ResetPasswordActivity.this;
                Toast.makeText(resetPasswordActivity, resetPasswordActivity.getString(R$string.send_code_success), 0).show();
                ResetPasswordActivity.this.k0();
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            ResetPasswordActivity.this.f12880h.dismiss();
            Toast.makeText(ResetPasswordActivity.this, exc.getMessage(), 0).show();
        }
    }

    public class e implements d.h {
        public e() {
        }

        @Override // d4.d.h
        public void a(String str) {
            ResetPasswordActivity.this.f12880h.dismiss();
            BaseBean baseBean = (BaseBean) new GsonBuilder().create().fromJson(str, BaseBean.class);
            if (baseBean != null) {
                if (baseBean.getCode() != 200) {
                    Toast.makeText(ResetPasswordActivity.this, baseBean.getMsg(), 0).show();
                } else {
                    ResetPasswordActivity resetPasswordActivity = ResetPasswordActivity.this;
                    resetPasswordActivity.v0(resetPasswordActivity.getString(R$string.reset_password_success), true);
                }
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            ResetPasswordActivity.this.f12880h.dismiss();
            Toast.makeText(ResetPasswordActivity.this, exc.getMessage(), 0).show();
        }
    }

    private void j0() {
        String string = getString(R$string.user_agreement);
        String string2 = getString(R$string.privacy_policy);
        String str = getString(R$string.agree_uapp_tips_prefix) + string + getString(R$string.agree_uapp_tips_and) + string2;
        SpannableString spannableString = new SpannableString(str);
        int color = ContextCompat.getColor(this, R$color.white);
        int color2 = ContextCompat.getColor(this, R$color.xC69D7D);
        if (str.contains(string)) {
            int iIndexOf = str.indexOf(string);
            spannableString.setSpan(new b(color2), iIndexOf, string.length() + iIndexOf, 33);
        }
        if (str.contains(string2)) {
            int iIndexOf2 = str.indexOf(string2);
            spannableString.setSpan(new c(color2), iIndexOf2, string2.length() + iIndexOf2, 33);
        }
        this.f12875c.tvAgree.setText(spannableString);
        this.f12875c.tvAgree.setTextColor(color);
        this.f12875c.tvAgree.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        this.f12875c.codeInputView2.k("60 s");
        N(this.f12884l);
        this.f12884l = l.e(0L, 61L, 0L, 1L, TimeUnit.SECONDS).l(g5.a.b()).g(y4.b.c()).j(new g() { // from class: g4.c1
            @Override // b5.g
            public final void accept(Object obj) {
                this.f13668a.m0((Long) obj);
            }
        }, new g() { // from class: g4.d1
            @Override // b5.g
            public final void accept(Object obj) {
                ResetPasswordActivity.n0((Throwable) obj);
            }
        }, new b5.a() { // from class: g4.u0
            @Override // b5.a
            public final void run() {
                this.f13710a.o0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(String str, String str2) {
        HashMap map = new HashMap();
        map.put("email", (String) this.f12876d.get());
        map.put("type", "passwd");
        map.put("uuid", str2);
        map.put("imgCode", str);
        String str3 = e4.a.a() + "/sendCode";
        this.f12880h.show();
        this.f12881i.g(str3, map, new d());
    }

    public static /* synthetic */ void n0(Throwable th) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(View view) {
        i0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        if (this.f12882j.booleanValue()) {
            return;
        }
        this.f12882j = Boolean.TRUE;
        startActivity(new Intent(this, (Class<?>) UserAgreementPPActivity.class));
    }

    @Override // com.uz.navee.base.BaseActivity
    public void E() {
        super.E();
        this.f12888p.setTextDirection(3);
        this.f12887o.setTextDirection(3);
        if (com.uz.navee.utils.d.p(this)) {
            this.f12888p.setGravity(8388629);
            this.f12887o.setGravity(8388629);
            this.f12886n.setImageDrawable(com.uz.navee.utils.d.q(ContextCompat.getDrawable(this, R$mipmap.ic_nav_back)));
        }
    }

    public final void h0() {
        HashMap map = new HashMap();
        map.put("email", (String) this.f12876d.get());
        map.put("code", (String) this.f12877e.get());
        map.put("passwd", (String) this.f12878f.get());
        String str = e4.a.a() + "/resetPasswd";
        this.f12880h.show();
        this.f12881i.g(str, map, new e());
    }

    public final void i0() {
        if (!TextUtils.isEmpty((CharSequence) this.f12876d.get())) {
            H(new CheckCodePopup.b() { // from class: g4.a1
                @Override // com.uz.navee.ui.device.CheckCodePopup.b
                public final void a(String str, String str2) {
                    this.f13662a.l0(str, str2);
                }
            });
        } else {
            com.uz.navee.utils.a.b(this.f12875c.etInputEmail);
            O();
        }
    }

    public void initView() {
        this.f12875c.setInputIdStr(this.f12876d);
        this.f12875c.setInputCodeStr(this.f12877e);
        this.f12875c.setInputPswStr(this.f12878f);
        this.f12875c.include.titleViewToolbar.setVisibility(4);
        this.f12875c.include.logoToolbar.setOnClickListener(new View.OnClickListener() { // from class: g4.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13708a.p0(view);
            }
        });
        this.f12875c.include.tvRightToolbar.setVisibility(8);
        this.f12875c.codeInputView2.f12996b.setHint(R$string.code_placeholder);
        this.f12875c.codeInputView2.f12997c.setAlpha(0.3f);
        this.f12875c.codeInputView2.f12997c.setOnClickListener(new View.OnClickListener() { // from class: g4.v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13712a.q0(view);
            }
        });
        this.f12876d.addOnPropertyChangedCallback(new a());
        d3.a.a(this.f12875c.codeInputView2.f12996b).i(new g() { // from class: g4.w0
            @Override // b5.g
            public final void accept(Object obj) {
                this.f13714a.r0((CharSequence) obj);
            }
        });
        if (e1.j().booleanValue()) {
            this.f12875c.layoutAgree.setVisibility(8);
            String email = e1.u().f13675c.getEmail();
            if (email != null && !email.isEmpty()) {
                this.f12876d.set(email);
                this.f12875c.etInputEmail.setEnabled(false);
            }
        } else {
            this.f12876d.set(e1.f());
            j0();
        }
        this.f12875c.btnSubmit.setOnClickListener(new View.OnClickListener() { // from class: g4.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13716a.w0(view);
            }
        });
        c3.a.a(this.f12875c.agreeButton).i(new g() { // from class: g4.y0
            @Override // b5.g
            public final void accept(Object obj) {
                this.f13718a.s0((kotlin.u) obj);
            }
        });
        c3.a.a(this.f12875c.ivPwd).i(new g() { // from class: g4.z0
            @Override // b5.g
            public final void accept(Object obj) {
                this.f13720a.t0((kotlin.u) obj);
            }
        });
        this.f12881i = d4.d.h();
        this.f12880h = new QMUITipDialog.a(this).f(1).a();
        this.f12886n = (ImageView) findViewById(R$id.logo_toolbar);
        this.f12888p = (EditText) findViewById(R$id.et_input_email);
        this.f12887o = (EditText) findViewById(R$id.et_input_pwd);
        E();
    }

    public final /* synthetic */ void m0(Long l6) {
        this.f12875c.codeInputView2.setText((60 - l6.longValue()) + " s");
    }

    public final /* synthetic */ void o0() {
        this.f12875c.codeInputView2.l();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityResetPasswordBinding activityResetPasswordBindingInflate = ActivityResetPasswordBinding.inflate(getLayoutInflater());
        this.f12875c = activityResetPasswordBindingInflate;
        setContentView(activityResetPasswordBindingInflate.getRoot());
        getWindow().setBackgroundDrawable(ContextCompat.getDrawable(this, R$mipmap.bg_login));
        initView();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        N(this.f12884l);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f12882j = Boolean.FALSE;
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        boolean z6 = e1.u().f13677e;
        this.f12879g = z6;
        this.f12875c.agreeButton.setSelected(z6);
    }

    public final /* synthetic */ void r0(CharSequence charSequence) {
        this.f12877e.set(charSequence.toString());
    }

    public final /* synthetic */ void s0(u uVar) {
        this.f12875c.agreeButton.setSelected(!r2.isSelected());
        this.f12879g = this.f12875c.agreeButton.isSelected();
        e1.u().f13677e = this.f12879g;
    }

    public final /* synthetic */ void t0(u uVar) {
        BaseActivity.F(this.f12875c.etInputPwd, this.f12883k);
        if (this.f12883k) {
            this.f12875c.ivPwd.setImageResource(R$mipmap.ic_switch_pwd_open);
            this.f12883k = false;
        } else {
            this.f12875c.ivPwd.setImageResource(R$mipmap.ic_switch_pwd_close);
            this.f12883k = true;
        }
    }

    public final /* synthetic */ void u0(boolean z6) {
        if (z6) {
            LoginLaunchActivity.Q0(this);
        }
    }

    public final void v0(String str, final boolean z6) {
        AlertPopup.Q(this, "", str, getString(R$string.confirm), "", new AlertPopup.a() { // from class: g4.b1
            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public /* synthetic */ void a() {
                j4.c.a(this);
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public final void b() {
                this.f13664a.u0(z6);
            }
        });
    }

    public final void w0(View view) {
        if (TextUtils.isEmpty((CharSequence) this.f12876d.get())) {
            com.uz.navee.utils.a.b(this.f12875c.etInputEmail);
            O();
            return;
        }
        if (TextUtils.isEmpty((CharSequence) this.f12877e.get())) {
            com.uz.navee.utils.a.b(this.f12875c.codeInputView2);
            O();
        } else if (TextUtils.isEmpty((CharSequence) this.f12878f.get())) {
            com.uz.navee.utils.a.b(this.f12875c.etInputPwd);
            O();
        } else if (this.f12879g) {
            h0();
        } else {
            com.uz.navee.utils.a.b(this.f12875c.layoutAgree);
            O();
        }
    }
}
