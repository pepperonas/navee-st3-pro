package com.uz.navee.ui.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.media3.extractor.ts.TsExtractor;
import b5.g;
import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.google.GooglePlus;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.uz.navee.MainActivity;
import com.uz.navee.MyApplication;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.bean.UserSession;
import com.uz.navee.databinding.ActivityLoginBinding;
import com.uz.navee.ui.device.CheckCodePopup;
import com.uz.navee.ui.mine.UserAgreementPPActivity;
import d4.d;
import g4.e1;
import java.util.HashMap;
import kotlin.u;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class LoginActivity extends BaseActivity {

    /* renamed from: f, reason: collision with root package name */
    public ImageView f12731f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f12732g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f12733h;

    /* renamed from: i, reason: collision with root package name */
    public ImageButton f12734i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f12735j;

    /* renamed from: k, reason: collision with root package name */
    public LinearLayout f12736k;

    /* renamed from: l, reason: collision with root package name */
    public TextView f12737l;

    /* renamed from: n, reason: collision with root package name */
    public String f12739n;

    /* renamed from: o, reason: collision with root package name */
    public EditText f12740o;

    /* renamed from: p, reason: collision with root package name */
    public EditText f12741p;

    /* renamed from: q, reason: collision with root package name */
    public LinearLayout f12742q;

    /* renamed from: r, reason: collision with root package name */
    public View f12743r;

    /* renamed from: s, reason: collision with root package name */
    public View f12744s;

    /* renamed from: t, reason: collision with root package name */
    public ImageView f12745t;

    /* renamed from: w, reason: collision with root package name */
    public d4.d f12748w;

    /* renamed from: x, reason: collision with root package name */
    public ProgressBar f12749x;

    /* renamed from: c, reason: collision with root package name */
    public ObservableBoolean f12728c = new ObservableBoolean(true);

    /* renamed from: d, reason: collision with root package name */
    public ObservableField f12729d = new ObservableField("");

    /* renamed from: e, reason: collision with root package name */
    public ObservableField f12730e = new ObservableField("");

    /* renamed from: m, reason: collision with root package name */
    public boolean f12738m = true;

    /* renamed from: u, reason: collision with root package name */
    public boolean f12746u = true;

    /* renamed from: v, reason: collision with root package name */
    public boolean f12747v = false;

    /* renamed from: y, reason: collision with root package name */
    public Boolean f12750y = Boolean.FALSE;

    public class a implements View.OnClickListener {

        /* renamed from: com.uz.navee.ui.login.LoginActivity$a$a, reason: collision with other inner class name */
        public class C0171a implements PlatformActionListener {

            /* renamed from: com.uz.navee.ui.login.LoginActivity$a$a$a, reason: collision with other inner class name */
            public class RunnableC0172a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f12753a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ String f12754b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ String f12755c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ String f12756d;

                public RunnableC0172a(String str, String str2, String str3, String str4) {
                    this.f12753a = str;
                    this.f12754b = str2;
                    this.f12755c = str3;
                    this.f12756d = str4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    LoginActivity.this.o0(2, this.f12753a, this.f12754b, this.f12755c, this.f12756d);
                }
            }

            /* renamed from: com.uz.navee.ui.login.LoginActivity$a$a$b */
            public class b implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f12758a;

                public b(String str) {
                    this.f12758a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(LoginActivity.this, this.f12758a, 1).show();
                }
            }

            public C0171a() {
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onCancel(Platform platform, int i6) {
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onComplete(Platform platform, int i6, HashMap map) {
                String strExportData = platform.getDb().exportData();
                String userId = platform.getDb().getUserId();
                String userName = platform.getDb().getUserName();
                String userIcon = platform.getDb().getUserIcon();
                Log.e(OnekeyShare.SHARESDK_TAG, "==========================" + strExportData + "\nuserId:" + userId + "\nuserName:" + userName + "\nuserIcon:" + userIcon);
                if (map != null) {
                    Log.e(OnekeyShare.SHARESDK_TAG, "==========================" + map.toString());
                }
                new Handler(Looper.getMainLooper()).post(new RunnableC0172a(userId, userName, userIcon, strExportData));
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onError(Platform platform, int i6, Throwable th) {
                new Handler(Looper.getMainLooper()).post(new b(th.getMessage()));
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Platform platform = ShareSDK.getPlatform(GooglePlus.NAME);
            platform.removeAccount(true);
            platform.setPlatformActionListener(new C0171a());
            platform.SSOSetting(false);
            platform.authorize();
        }
    }

    public class b implements View.OnClickListener {

        public class a implements PlatformActionListener {

            /* renamed from: com.uz.navee.ui.login.LoginActivity$b$a$a, reason: collision with other inner class name */
            public class RunnableC0173a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f12762a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ String f12763b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ String f12764c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ String f12765d;

                public RunnableC0173a(String str, String str2, String str3, String str4) {
                    this.f12762a = str;
                    this.f12763b = str2;
                    this.f12764c = str3;
                    this.f12765d = str4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    LoginActivity.this.o0(1, this.f12762a, this.f12763b, this.f12764c, this.f12765d);
                }
            }

            /* renamed from: com.uz.navee.ui.login.LoginActivity$b$a$b, reason: collision with other inner class name */
            public class RunnableC0174b implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f12767a;

                public RunnableC0174b(String str) {
                    this.f12767a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(LoginActivity.this, this.f12767a, 1).show();
                }
            }

            public a() {
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onCancel(Platform platform, int i6) {
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onComplete(Platform platform, int i6, HashMap map) {
                String strExportData = platform.getDb().exportData();
                String userId = platform.getDb().getUserId();
                String userName = platform.getDb().getUserName();
                String userIcon = platform.getDb().getUserIcon();
                Log.e(OnekeyShare.SHARESDK_TAG, "==========================" + strExportData + "\nuserId:" + userId + "\nuserName:" + userName + "\nuserIcon:" + userIcon);
                if (map != null) {
                    Log.e(OnekeyShare.SHARESDK_TAG, "==========================" + map.toString());
                }
                new Handler(Looper.getMainLooper()).post(new RunnableC0173a(userId, userName, userIcon, strExportData));
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onError(Platform platform, int i6, Throwable th) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0174b(th.getMessage()));
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Platform platform = ShareSDK.getPlatform(Facebook.NAME);
            platform.removeAccount(true);
            platform.setPlatformActionListener(new a());
            platform.SSOSetting(false);
            platform.authorize();
        }
    }

    public class c extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12769a;

        public c(int i6) {
            this.f12769a = i6;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            LoginActivity.this.t0();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(this.f12769a);
            textPaint.setUnderlineText(true);
        }
    }

    public class d extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12771a;

        public d(int i6) {
            this.f12771a = i6;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            LoginActivity.this.t0();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(this.f12771a);
            textPaint.setUnderlineText(true);
        }
    }

    public class e implements d.h {

        public class a extends TypeToken<HttpResponse<UserSession>> {
            public a() {
            }
        }

        public e() {
        }

        @Override // d4.d.h
        public void a(String str) {
            LoginActivity.this.f12749x.setVisibility(8);
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse != null) {
                if (httpResponse.getCode() != 200) {
                    Toast.makeText(LoginActivity.this, httpResponse.getMsg(), 0).show();
                    return;
                }
                LoginActivity.this.f12747v = true;
                e1.t((UserSession) httpResponse.getData());
                if (LoginActivity.this.f12728c.get()) {
                    e1.r((String) LoginActivity.this.f12729d.get());
                } else {
                    e1.q((String) LoginActivity.this.f12729d.get());
                }
                e1.p(LoginActivity.this.f12728c.get());
                LoginActivity.this.startActivity(new Intent(LoginActivity.this, (Class<?>) MainActivity.class).setFlags(268468224));
                LoginActivity.this.finish();
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            LoginActivity.this.f12749x.setVisibility(8);
            Toast.makeText(LoginActivity.this, exc.getMessage(), 0).show();
        }
    }

    public class f implements d.h {

        public class a extends TypeToken<HttpResponse<UserSession>> {
            public a() {
            }
        }

        public f() {
        }

        @Override // d4.d.h
        public void a(String str) {
            LoginActivity.this.f12749x.setVisibility(8);
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse != null) {
                if (httpResponse.getCode() != 200) {
                    Toast.makeText(LoginActivity.this, httpResponse.getMsg(), 0).show();
                    return;
                }
                LoginActivity.this.f12747v = true;
                e1.t((UserSession) httpResponse.getData());
                LoginActivity.this.startActivity(new Intent(LoginActivity.this, (Class<?>) MainActivity.class));
                LoginActivity.this.finish();
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            LoginActivity.this.f12749x.setVisibility(8);
            Toast.makeText(LoginActivity.this, exc.getMessage(), 0).show();
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

    private void f0() {
        this.f12731f = (ImageView) findViewById(R$id.logo_toolbar);
        this.f12732g = (TextView) findViewById(R$id.titleView_toolbar);
        this.f12733h = (TextView) findViewById(R$id.tv_right_toolbar);
        this.f12734i = (ImageButton) findViewById(R$id.agreeButton);
        this.f12735j = (TextView) findViewById(R$id.tv_agree);
        this.f12736k = (LinearLayout) findViewById(R$id.layout_agree);
        this.f12737l = (TextView) findViewById(R$id.tv_forget_pwd);
        this.f12740o = (EditText) findViewById(R$id.et_input_email);
        this.f12741p = (EditText) findViewById(R$id.et_input_pwd);
        this.f12745t = (ImageView) findViewById(R$id.iv_pwd);
        this.f12743r = findViewById(R$id.googleButton);
        this.f12744s = findViewById(R$id.facebookButton);
        this.f12742q = (LinearLayout) findViewById(R$id.layout_other);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(View view) {
        this.f12734i.setSelected(!r2.isSelected());
        this.f12738m = this.f12734i.isSelected();
        e1.u().f13677e = this.f12738m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(View view) {
        s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(View view) {
        r0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(View view) {
        r0(false);
    }

    @Override // com.uz.navee.base.BaseActivity
    public void E() {
        super.E();
        this.f12740o.setTextDirection(3);
        this.f12741p.setTextDirection(3);
        if (com.uz.navee.utils.d.p(this)) {
            this.f12740o.setGravity(8388629);
            this.f12741p.setGravity(8388629);
            this.f12731f.setImageDrawable(com.uz.navee.utils.d.q(ContextCompat.getDrawable(this, R$mipmap.ic_nav_back)));
        }
    }

    public final void e0(String str, String str2) {
        this.f12749x.setVisibility(0);
        StringBuilder sb = new StringBuilder();
        sb.append(e4.a.a());
        sb.append(this.f12728c.get() ? "/login" : "/loginByUserName");
        String string = sb.toString();
        HashMap map = new HashMap();
        if (this.f12728c.get()) {
            map.put("email", (String) this.f12729d.get());
        } else {
            map.put("userName", (String) this.f12729d.get());
        }
        map.put("passwd", this.f12739n);
        map.put("uuid", str2);
        map.put("imgCode", str);
        this.f12748w.g(string, map, new e());
    }

    public final void g0() {
        String string = getString(R$string.user_agreement);
        String string2 = getString(R$string.privacy_policy);
        String str = getString(R$string.agree_uapp_tips_prefix) + string + getString(R$string.agree_uapp_tips_and) + string2;
        SpannableString spannableString = new SpannableString(str);
        int color = ContextCompat.getColor(this, R$color.white);
        int color2 = ContextCompat.getColor(this, R$color.xC69D7D);
        if (str.contains(string)) {
            int iIndexOf = str.indexOf(string);
            spannableString.setSpan(new c(color2), iIndexOf, string.length() + iIndexOf, 33);
        }
        if (str.contains(string2)) {
            int iIndexOf2 = str.indexOf(string2);
            spannableString.setSpan(new d(color2), iIndexOf2, string2.length() + iIndexOf2, 33);
        }
        this.f12735j.setText(spannableString);
        this.f12735j.setTextColor(color);
        this.f12735j.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void h0(View view) {
        if (this.f12750y.booleanValue()) {
            return;
        }
        this.f12750y = Boolean.TRUE;
        startActivity(new Intent(this, (Class<?>) (this.f12728c.get() ? ResetPasswordActivity.class : ResetAcAndPswActivity.class)));
    }

    public final /* synthetic */ void l0(u uVar) {
        q0();
    }

    public final void o0(int i6, String str, String str2, String str3, String str4) {
        this.f12749x.setVisibility(0);
        String str5 = e4.a.a() + "/loginByOther";
        HashMap map = new HashMap();
        map.put("loginType", String.valueOf(i6));
        map.put("uid", str);
        map.put("raw", str4);
        if (str2 != null) {
            map.put("nickName", str2);
        }
        if (str3 != null) {
            map.put("icon", str3);
        }
        this.f12748w.g(str5, map, new f());
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityLoginBinding activityLoginBindingInflate = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(activityLoginBindingInflate.getRoot());
        activityLoginBindingInflate.setSignTypeEmail(this.f12728c);
        activityLoginBindingInflate.setInputIdStr(this.f12729d);
        activityLoginBindingInflate.setInputPswStr(this.f12730e);
        getWindow().setBackgroundDrawable(ContextCompat.getDrawable(this, R$mipmap.bg_login));
        f0();
        this.f12734i.setOnClickListener(new View.OnClickListener() { // from class: g4.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13669a.i0(view);
            }
        });
        this.f12732g.setText("");
        this.f12733h.setText(getString(R$string.register));
        this.f12733h.setVisibility(0);
        this.f12733h.setOnClickListener(new View.OnClickListener() { // from class: g4.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13671a.j0(view);
            }
        });
        this.f12731f.setOnClickListener(new View.OnClickListener() { // from class: g4.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13679a.k0(view);
            }
        });
        c3.a.a(activityLoginBindingInflate.btnSubmit).i(new g() { // from class: g4.g
            @Override // b5.g
            public final void accept(Object obj) {
                this.f13681a.l0((kotlin.u) obj);
            }
        });
        this.f12745t.setOnClickListener(new View.OnClickListener() { // from class: g4.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13683a.p0(view);
            }
        });
        activityLoginBindingInflate.tvSignWithEmail.setOnClickListener(new View.OnClickListener() { // from class: g4.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13684a.m0(view);
            }
        });
        activityLoginBindingInflate.tvSignWithAc.setOnClickListener(new View.OnClickListener() { // from class: g4.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13686a.n0(view);
            }
        });
        this.f12737l.getPaint().setFlags(8);
        this.f12737l.setText(com.uz.navee.utils.d.a(getString(this.f12728c.get() ? R$string.forgot_pwd : R$string.forgot_account_pwd)));
        this.f12737l.setOnClickListener(new View.OnClickListener() { // from class: g4.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13688a.h0(view);
            }
        });
        r0(e1.k().booleanValue());
        g0();
        this.f12749x = (ProgressBar) findViewById(R$id.login_loading);
        this.f12748w = d4.d.h();
        this.f12743r.setOnClickListener(new a());
        this.f12744s.setOnClickListener(new b());
        this.f12744s.setVisibility(8);
        this.f12742q.setVisibility(8);
        E();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f12750y = Boolean.FALSE;
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        boolean z6 = e1.u().f13677e;
        this.f12738m = z6;
        this.f12734i.setSelected(z6);
        MyApplication myApplication = (MyApplication) MyApplication.c();
        if (!myApplication.f11589a && !myApplication.f11590b) {
            this.f12742q.setVisibility(8);
            return;
        }
        this.f12742q.setVisibility(0);
        this.f12743r.setVisibility(myApplication.f11589a ? 0 : 8);
        this.f12744s.setVisibility(myApplication.f11590b ? 0 : 8);
    }

    public final void p0(View view) {
        F(this.f12741p, this.f12746u);
        if (this.f12746u) {
            this.f12745t.setImageResource(R$mipmap.ic_switch_pwd_open);
            this.f12746u = false;
        } else {
            this.f12745t.setImageResource(R$mipmap.ic_switch_pwd_close);
            this.f12746u = true;
        }
    }

    public final void q0() {
        this.f12739n = this.f12741p.getText().toString();
        C();
        if (TextUtils.isEmpty((CharSequence) this.f12729d.get())) {
            com.uz.navee.utils.a.b(this.f12740o);
            O();
            return;
        }
        String str = this.f12739n;
        if (str == null || TextUtils.isEmpty(str)) {
            com.uz.navee.utils.a.b(this.f12741p);
            O();
        } else if (this.f12738m) {
            H(new CheckCodePopup.b() { // from class: g4.l
                @Override // com.uz.navee.ui.device.CheckCodePopup.b
                public final void a(String str2, String str3) {
                    this.f13690a.e0(str2, str3);
                }
            });
        } else {
            com.uz.navee.utils.a.b(this.f12736k);
            O();
        }
    }

    public final void r0(boolean z6) {
        this.f12728c.set(z6);
        this.f12729d.set(null);
        this.f12730e.set(null);
        if (z6) {
            this.f12740o.setInputType(33);
            this.f12729d.set(e1.f());
        } else {
            this.f12740o.setInputType(1);
            this.f12729d.set(e1.e());
        }
    }

    public final void s0() {
        startActivity(new Intent(this, (Class<?>) RegisterActivity.class));
        finish();
    }

    public final void t0() {
        if (this.f12750y.booleanValue()) {
            return;
        }
        this.f12750y = Boolean.TRUE;
        startActivity(new Intent(this, (Class<?>) UserAgreementPPActivity.class));
    }
}
