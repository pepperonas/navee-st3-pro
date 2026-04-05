package com.uz.navee.ui.mine;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import b5.g;
import com.google.gson.GsonBuilder;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.ui.device.CheckCodePopup;
import com.uz.navee.ui.mine.ChangeEmailActivity;
import com.uz.navee.ui.mine.bean.Affirmbean;
import com.uz.navee.ui.mine.bean.BaseBean;
import com.uz.navee.ui.wheel.AlertPopup;
import d4.d;
import g4.e1;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import z4.l;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class ChangeEmailActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public ChangeEmailInputView f12972c;

    /* renamed from: d, reason: collision with root package name */
    public ChangeEmailInputView f12973d;

    /* renamed from: e, reason: collision with root package name */
    public View f12974e;

    /* renamed from: f, reason: collision with root package name */
    public Button f12975f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f12976g;

    /* renamed from: h, reason: collision with root package name */
    public ChangeEmailStep f12977h;

    /* renamed from: i, reason: collision with root package name */
    public String f12978i;

    /* renamed from: j, reason: collision with root package name */
    public String f12979j;

    /* renamed from: k, reason: collision with root package name */
    public d4.d f12980k;

    /* renamed from: m, reason: collision with root package name */
    public io.reactivex.rxjava3.disposables.c f12982m;

    /* renamed from: l, reason: collision with root package name */
    public String f12981l = "";

    /* renamed from: n, reason: collision with root package name */
    public final int f12983n = 60;

    public enum ChangeEmailStep {
        oldEmail,
        newEmail,
        addEmail,
        verifyEmail
    }

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ChangeEmailActivity.this.f12973d.f12997c.setAlpha((float) (editable.length() == 0 ? 0.3d : 1.0d));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        }
    }

    public class b implements d.h {
        public b() {
        }

        @Override // d4.d.h
        public void a(String str) {
            ChangeEmailActivity.this.B();
            BaseBean baseBean = (BaseBean) new GsonBuilder().create().fromJson(str, BaseBean.class);
            if (baseBean != null) {
                if (baseBean.getCode() != 200) {
                    ChangeEmailActivity.this.w0(baseBean.getMsg());
                    return;
                }
                ChangeEmailActivity changeEmailActivity = ChangeEmailActivity.this;
                Toast.makeText(changeEmailActivity, changeEmailActivity.getString(R$string.send_code_success), 0).show();
                ChangeEmailActivity.this.o0();
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            ChangeEmailActivity.this.B();
            ChangeEmailActivity.this.w0(exc.getMessage());
        }
    }

    public class c implements d.h {
        public c() {
        }

        @Override // d4.d.h
        public void a(String str) {
            ChangeEmailActivity.this.B();
            Affirmbean affirmbean = (Affirmbean) new GsonBuilder().create().fromJson(str, Affirmbean.class);
            if (affirmbean != null) {
                if (affirmbean.getCode() != 200) {
                    ChangeEmailActivity.this.w0(affirmbean.getMsg());
                    return;
                }
                ChangeEmailActivity.this.f12981l = affirmbean.getData().getKey();
                Intent intent = new Intent(ChangeEmailActivity.this, (Class<?>) ChangeEmailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("step", ChangeEmailStep.newEmail.ordinal());
                intent.putExtra("data", bundle);
                intent.putExtra("key", ChangeEmailActivity.this.f12981l);
                ChangeEmailActivity.this.startActivity(intent);
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            ChangeEmailActivity.this.B();
            ChangeEmailActivity.this.w0(exc.getMessage());
        }
    }

    public class d implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12987a;

        public class a implements AlertPopup.a {
            public a() {
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public /* synthetic */ void a() {
                j4.c.a(this);
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public void b() {
                ChangeEmailActivity changeEmailActivity = (ChangeEmailActivity) com.uz.navee.e.a(ChangeEmailActivity.class);
                if (changeEmailActivity != null) {
                    changeEmailActivity.finish();
                }
                ChangeEmailActivity.this.finish();
            }
        }

        public d(String str) {
            this.f12987a = str;
        }

        @Override // d4.d.h
        public void a(String str) {
            ChangeEmailActivity.this.B();
            BaseBean baseBean = (BaseBean) new GsonBuilder().create().fromJson(str, BaseBean.class);
            if (baseBean != null) {
                if (baseBean.getCode() != 200) {
                    ChangeEmailActivity.this.w0(baseBean.getMsg());
                    return;
                }
                e1.r(this.f12987a);
                e1.u().f13675c.setEmail(this.f12987a);
                ChangeEmailActivity changeEmailActivity = ChangeEmailActivity.this;
                AlertPopup.Q(changeEmailActivity, "", changeEmailActivity.getString(R$string.change_email_success), ChangeEmailActivity.this.getString(R$string.confirm), "", new a());
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            ChangeEmailActivity.this.B();
            ChangeEmailActivity.this.w0(exc.getMessage());
        }
    }

    public class e implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12990a;

        public class a implements AlertPopup.a {
            public a() {
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public /* synthetic */ void a() {
                j4.c.a(this);
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public void b() {
                ChangeEmailActivity.this.finish();
            }
        }

        public e(String str) {
            this.f12990a = str;
        }

        @Override // d4.d.h
        public void a(String str) {
            ChangeEmailActivity.this.B();
            BaseBean baseBean = (BaseBean) new GsonBuilder().create().fromJson(str, BaseBean.class);
            if (baseBean != null) {
                if (baseBean.getCode() != 200) {
                    ChangeEmailActivity.this.w0(baseBean.getMsg());
                    return;
                }
                e1.r(this.f12990a);
                e1.u().f13675c.setEmail(this.f12990a);
                ChangeEmailActivity changeEmailActivity = ChangeEmailActivity.this;
                AlertPopup.Q(changeEmailActivity, "", changeEmailActivity.getString(R$string.bind_email_success), ChangeEmailActivity.this.getString(R$string.confirm), "", new a());
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            ChangeEmailActivity.this.B();
            ChangeEmailActivity.this.w0(exc.getMessage());
        }
    }

    public class f implements d.h {

        public class a implements AlertPopup.a {
            public a() {
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public void a() {
                ChangeEmailActivity.this.finish();
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public void b() {
            }
        }

        public f() {
        }

        @Override // d4.d.h
        public void a(String str) {
            ChangeEmailActivity.this.B();
            BaseBean baseBean = (BaseBean) new GsonBuilder().create().fromJson(str, BaseBean.class);
            if (baseBean != null) {
                if (baseBean.getCode() != 200) {
                    ChangeEmailActivity.this.w0(baseBean.getMsg());
                } else {
                    ChangeEmailActivity changeEmailActivity = ChangeEmailActivity.this;
                    AlertPopup.Q(changeEmailActivity, changeEmailActivity.getString(R$string.download_success_title), ChangeEmailActivity.this.getString(R$string.download_success_msg), null, ChangeEmailActivity.this.getString(R$string.i_see), new a());
                }
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            ChangeEmailActivity.this.B();
            ChangeEmailActivity.this.w0(exc.getMessage());
        }
    }

    private void Y() {
        this.f12972c = (ChangeEmailInputView) findViewById(R$id.emailInputView);
        this.f12973d = (ChangeEmailInputView) findViewById(R$id.codeInputView);
        this.f12974e = findViewById(R$id.codeButton);
        this.f12975f = (Button) findViewById(R$id.nextButton);
        this.f12976g = (TextView) findViewById(R$id.tipsView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(View view) {
        C();
        String string = this.f12972c.f12996b.getText().toString();
        this.f12978i = string;
        if (TextUtils.isEmpty(string)) {
            com.uz.navee.utils.a.b(this.f12972c);
            O();
            return;
        }
        int iOrdinal = this.f12977h.ordinal();
        if (iOrdinal == 0) {
            p0(this.f12978i, "affirm");
            return;
        }
        if (iOrdinal == 1) {
            p0(this.f12978i, "email");
        } else if (iOrdinal == 2) {
            p0(this.f12978i, "bindEmail");
        } else {
            if (iOrdinal != 3) {
                return;
            }
            p0(this.f12978i, "downloadData");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        this.f12973d.k("60 s");
        N(this.f12982m);
        this.f12982m = l.e(0L, 61L, 0L, 1L, TimeUnit.SECONDS).l(g5.a.b()).g(y4.b.c()).j(new g() { // from class: h4.e0
            @Override // b5.g
            public final void accept(Object obj) {
                this.f13771a.s0((Long) obj);
            }
        }, new g() { // from class: h4.f0
            @Override // b5.g
            public final void accept(Object obj) {
                ChangeEmailActivity.t0((Throwable) obj);
            }
        }, new b5.a() { // from class: h4.g0
            @Override // b5.a
            public final void run() {
                this.f13780a.u0();
            }
        });
    }

    private void r0() {
        int iOrdinal = this.f12977h.ordinal();
        if (iOrdinal == 0) {
            this.f12978i = e1.u().f13675c.getEmail();
            this.f12972c.f12996b.setHint(R$string.old_email_placeholder);
            this.f12972c.f12996b.setText(this.f12978i);
            this.f12972c.f12996b.setEnabled(false);
            this.f12972c.f12996b.setTextColor(ContextCompat.getColor(this, R$color.hint));
            this.f12976g.setText(R$string.change_email);
            this.f12975f.setText(R$string.next);
        } else if (iOrdinal == 1) {
            this.f12972c.f12996b.setHint(R$string.new_email_placeholder);
            this.f12972c.f12996b.setEnabled(true);
            this.f12972c.f12996b.setTextColor(ContextCompat.getColor(this, R$color.white));
            this.f12976g.setText(R$string.set_new_email);
            this.f12975f.setText(R$string.confirm);
        } else if (iOrdinal == 2) {
            this.f12972c.f12996b.setHint(R$string.email_placeholder);
            this.f12972c.f12996b.setEnabled(true);
            this.f12972c.f12996b.setTextColor(ContextCompat.getColor(this, R$color.white));
            this.f12976g.setText(R$string.bind_email);
            this.f12975f.setText(R$string.confirm);
        } else if (iOrdinal == 3) {
            this.f12972c.f12996b.setHint(R$string.email_placeholder);
            String email = e1.u().f13675c.getEmail();
            this.f12978i = email;
            if (!TextUtils.isEmpty(email)) {
                this.f12972c.f12996b.setText(this.f12978i);
            }
            this.f12972c.f12996b.setTextColor(ContextCompat.getColor(this, R$color.white));
            this.f12976g.setText(R$string.check_email);
            this.f12975f.setText(R$string.confirm);
        }
        this.f12972c.f12997c.setVisibility(8);
        this.f12972c.f12998d.setVisibility(8);
        this.f12973d.f12996b.setHint(R$string.code_placeholder);
        this.f12975f.setOnClickListener(new View.OnClickListener() { // from class: h4.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13758a.m0(view);
            }
        });
        this.f12973d.f12997c.setOnClickListener(new View.OnClickListener() { // from class: h4.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13762a.n0(view);
            }
        });
        this.f12973d.f12997c.setAlpha((float) (this.f12972c.f12996b.getText().length() == 0 ? 0.3d : 1.0d));
        this.f12972c.f12996b.addTextChangedListener(new a());
    }

    public static /* synthetic */ void t0(Throwable th) {
    }

    public final void j0(String str, String str2) {
        HashMap map = new HashMap();
        map.put("email", str);
        map.put("code", str2);
        String str3 = e4.a.a() + "/affirm";
        K();
        this.f12980k.g(str3, map, new c());
    }

    public final void k0(String str, String str2) {
        HashMap map = new HashMap();
        map.put("email", str);
        map.put("code", str2);
        String str3 = e4.a.a() + "/user/download/addApply";
        K();
        this.f12980k.g(str3, map, new f());
    }

    public final void l0(String str, String str2) {
        HashMap map = new HashMap();
        map.put("email", str);
        map.put("code", str2);
        String str3 = e4.a.a() + "/bindEmail";
        K();
        this.f12980k.g(str3, map, new e(str));
    }

    public final void m0(View view) {
        Editable text = this.f12972c.f12996b.getText();
        Objects.requireNonNull(text);
        this.f12978i = text.toString();
        Editable text2 = this.f12973d.f12996b.getText();
        Objects.requireNonNull(text2);
        this.f12979j = text2.toString();
        C();
        if (TextUtils.isEmpty(this.f12978i)) {
            com.uz.navee.utils.a.b(this.f12972c);
            O();
            return;
        }
        if (TextUtils.isEmpty(this.f12979j)) {
            com.uz.navee.utils.a.b(this.f12972c);
            O();
            return;
        }
        int iOrdinal = this.f12977h.ordinal();
        if (iOrdinal == 0) {
            j0(this.f12978i, this.f12979j);
            return;
        }
        if (iOrdinal == 1) {
            x0(this.f12978i, this.f12979j);
        } else if (iOrdinal == 2) {
            l0(this.f12978i, this.f12979j);
        } else {
            if (iOrdinal != 3) {
                return;
            }
            k0(this.f12978i, this.f12979j);
        }
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_change_email);
        Y();
        getWindow().setBackgroundDrawable(ContextCompat.getDrawable(this, R$mipmap.bg_login));
        com.uz.navee.utils.c.e(this, "", ContextCompat.getColor(this, R$color.clear));
        this.f12977h = ChangeEmailStep.values()[getIntent().getBundleExtra("data").getInt("step")];
        this.f12981l = getIntent().getStringExtra("key");
        r0();
        this.f12980k = d4.d.h();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public final void p0(final String str, final String str2) {
        H(new CheckCodePopup.b() { // from class: h4.d0
            @Override // com.uz.navee.ui.device.CheckCodePopup.b
            public final void a(String str3, String str4) {
                this.f13766a.v0(str, str2, str3, str4);
            }
        });
    }

    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public final void v0(String str, String str2, String str3, String str4) {
        HashMap map = new HashMap();
        map.put("email", str);
        map.put("type", str2);
        map.put("uuid", str4);
        map.put("imgCode", str3);
        String str5 = e4.a.a() + "/sendCode";
        K();
        this.f12980k.g(str5, map, new b());
    }

    public final /* synthetic */ void s0(Long l6) {
        this.f12973d.setText((60 - l6.longValue()) + " s");
    }

    public final /* synthetic */ void u0() {
        this.f12973d.l();
    }

    public final void w0(String str) {
        Toast.makeText(this, str, 0).show();
    }

    public final void x0(String str, String str2) {
        HashMap map = new HashMap();
        map.put("email", str);
        map.put("code", str2);
        map.put("key", this.f12981l);
        String str3 = e4.a.a() + "/updateMail";
        K();
        this.f12980k.g(str3, map, new d(str));
    }
}
