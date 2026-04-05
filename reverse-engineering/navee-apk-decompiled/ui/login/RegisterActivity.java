package com.uz.navee.ui.login;

import android.content.Intent;
import android.graphics.drawable.Drawable;
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
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.google.GooglePlus;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.uz.navee.MainActivity;
import com.uz.navee.MyApplication;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.bean.UserSession;
import com.uz.navee.databinding.ActivityRegisterBinding;
import com.uz.navee.ui.device.CheckCodePopup;
import com.uz.navee.ui.login.RegisterActivity;
import com.uz.navee.ui.mine.UserAgreementPPActivity;
import com.uz.navee.ui.mine.bean.BaseBean;
import d4.d;
import g4.e1;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import z4.l;

/* loaded from: classes3.dex */
public class RegisterActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public ImageView f12823c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f12824d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f12825e;

    /* renamed from: f, reason: collision with root package name */
    public EditText f12826f;

    /* renamed from: g, reason: collision with root package name */
    public EditText f12827g;

    /* renamed from: h, reason: collision with root package name */
    public ImageButton f12828h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f12829i;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f12830j;

    /* renamed from: k, reason: collision with root package name */
    public LinearLayout f12831k;

    /* renamed from: l, reason: collision with root package name */
    public View f12832l;

    /* renamed from: m, reason: collision with root package name */
    public View f12833m;

    /* renamed from: o, reason: collision with root package name */
    public QMUITipDialog f12835o;

    /* renamed from: p, reason: collision with root package name */
    public d4.d f12836p;

    /* renamed from: s, reason: collision with root package name */
    public io.reactivex.rxjava3.disposables.c f12839s;

    /* renamed from: y, reason: collision with root package name */
    public ActivityRegisterBinding f12845y;

    /* renamed from: n, reason: collision with root package name */
    public boolean f12834n = true;

    /* renamed from: q, reason: collision with root package name */
    public Boolean f12837q = Boolean.FALSE;

    /* renamed from: r, reason: collision with root package name */
    public boolean f12838r = true;

    /* renamed from: t, reason: collision with root package name */
    public final int f12840t = 60;

    /* renamed from: u, reason: collision with root package name */
    public ObservableBoolean f12841u = new ObservableBoolean(true);

    /* renamed from: v, reason: collision with root package name */
    public ObservableField f12842v = new ObservableField("");

    /* renamed from: w, reason: collision with root package name */
    public ObservableField f12843w = new ObservableField("");

    /* renamed from: x, reason: collision with root package name */
    public ObservableField f12844x = new ObservableField("");

    public class a extends Observable.OnPropertyChangedCallback {
        public a() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i6) {
            RegisterActivity.this.f12845y.codeInputView2.f12997c.setAlpha(TextUtils.isEmpty((CharSequence) RegisterActivity.this.f12842v.get()) ? 0.3f : 1.0f);
        }
    }

    public class b implements View.OnClickListener {

        public class a implements PlatformActionListener {

            /* renamed from: com.uz.navee.ui.login.RegisterActivity$b$a$a, reason: collision with other inner class name */
            public class RunnableC0178a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f12849a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ String f12850b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ String f12851c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ String f12852d;

                public RunnableC0178a(String str, String str2, String str3, String str4) {
                    this.f12849a = str;
                    this.f12850b = str2;
                    this.f12851c = str3;
                    this.f12852d = str4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    RegisterActivity.this.F0(2, this.f12849a, this.f12850b, this.f12851c, this.f12852d);
                }
            }

            /* renamed from: com.uz.navee.ui.login.RegisterActivity$b$a$b, reason: collision with other inner class name */
            public class RunnableC0179b implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f12854a;

                public RunnableC0179b(String str) {
                    this.f12854a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(RegisterActivity.this, this.f12854a, 1).show();
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
                new Handler(Looper.getMainLooper()).post(new RunnableC0178a(userId, userName, userIcon, strExportData));
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onError(Platform platform, int i6, Throwable th) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0179b(th.getMessage()));
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Platform platform = ShareSDK.getPlatform(GooglePlus.NAME);
            platform.removeAccount(true);
            platform.setPlatformActionListener(new a());
            platform.SSOSetting(false);
            platform.authorize();
        }
    }

    public class c implements View.OnClickListener {

        public class a implements PlatformActionListener {

            /* renamed from: com.uz.navee.ui.login.RegisterActivity$c$a$a, reason: collision with other inner class name */
            public class RunnableC0180a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f12858a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ String f12859b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ String f12860c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ String f12861d;

                public RunnableC0180a(String str, String str2, String str3, String str4) {
                    this.f12858a = str;
                    this.f12859b = str2;
                    this.f12860c = str3;
                    this.f12861d = str4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    RegisterActivity.this.F0(1, this.f12858a, this.f12859b, this.f12860c, this.f12861d);
                }
            }

            public class b implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f12863a;

                public b(String str) {
                    this.f12863a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(RegisterActivity.this, this.f12863a, 1).show();
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
                new Handler(Looper.getMainLooper()).post(new RunnableC0180a(userId, userName, userIcon, strExportData));
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onError(Platform platform, int i6, Throwable th) {
                new Handler(Looper.getMainLooper()).post(new b(th.getMessage()));
            }
        }

        public c() {
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

    public class d extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12865a;

        public d(int i6) {
            this.f12865a = i6;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            RegisterActivity.this.J0();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(this.f12865a);
            textPaint.setUnderlineText(true);
        }
    }

    public class e extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12867a;

        public e(int i6) {
            this.f12867a = i6;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            RegisterActivity.this.J0();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(this.f12867a);
            textPaint.setUnderlineText(true);
        }
    }

    public class f implements d.h {
        public f() {
        }

        @Override // d4.d.h
        public void a(String str) {
            RegisterActivity.this.f12835o.dismiss();
            BaseBean baseBean = (BaseBean) new GsonBuilder().create().fromJson(str, BaseBean.class);
            if (baseBean != null) {
                if (baseBean.getCode() != 200) {
                    Toast.makeText(RegisterActivity.this, baseBean.getMsg(), 0).show();
                    return;
                }
                RegisterActivity registerActivity = RegisterActivity.this;
                Toast.makeText(registerActivity, registerActivity.getString(R$string.send_code_success), 0).show();
                RegisterActivity.this.r0();
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            RegisterActivity.this.f12835o.dismiss();
            Toast.makeText(RegisterActivity.this, exc.getMessage(), 0).show();
        }
    }

    public class g implements d.h {

        public class a extends TypeToken<HttpResponse<UserSession>> {
            public a() {
            }
        }

        public g() {
        }

        @Override // d4.d.h
        public void a(String str) {
            RegisterActivity.this.f12835o.dismiss();
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse != null) {
                if (httpResponse.getCode() != 200) {
                    Toast.makeText(RegisterActivity.this, httpResponse.getMsg(), 0).show();
                    return;
                }
                e1.t((UserSession) httpResponse.getData());
                if (RegisterActivity.this.f12841u.get()) {
                    e1.r((String) RegisterActivity.this.f12842v.get());
                } else {
                    e1.q((String) RegisterActivity.this.f12842v.get());
                }
                e1.p(RegisterActivity.this.f12841u.get());
                RegisterActivity.this.startActivity(new Intent(RegisterActivity.this, (Class<?>) MainActivity.class));
                RegisterActivity.this.finish();
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            RegisterActivity.this.f12835o.dismiss();
            Toast.makeText(RegisterActivity.this, exc.getMessage(), 0).show();
        }
    }

    public class h implements d.h {

        public class a extends TypeToken<HttpResponse<UserSession>> {
            public a() {
            }
        }

        public h() {
        }

        @Override // d4.d.h
        public void a(String str) {
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse != null) {
                if (httpResponse.getCode() != 200) {
                    Toast.makeText(RegisterActivity.this, httpResponse.getMsg(), 0).show();
                    return;
                }
                e1.t((UserSession) httpResponse.getData());
                RegisterActivity.this.startActivity(new Intent(RegisterActivity.this, (Class<?>) MainActivity.class));
                RegisterActivity.this.finish();
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            Toast.makeText(RegisterActivity.this, exc.getMessage(), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(int i6, String str, String str2, String str3, String str4) {
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
        this.f12836p.g(str5, map, new h());
    }

    private void G0(boolean z6) {
        this.f12841u.set(z6);
        this.f12842v.set(null);
        this.f12843w.set(null);
        this.f12844x.set(null);
        if (z6) {
            this.f12845y.etInputEmail.setInputType(33);
        } else {
            this.f12845y.etInputEmail.setInputType(1);
        }
    }

    private void H0() {
        startActivity(new Intent(this, (Class<?>) LoginActivity.class));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        if (this.f12837q.booleanValue()) {
            return;
        }
        this.f12837q = Boolean.TRUE;
        startActivity(new Intent(this, (Class<?>) UserAgreementPPActivity.class));
    }

    private void o0() {
        this.f12823c = (ImageView) findViewById(R$id.logo_toolbar);
        this.f12824d = (TextView) findViewById(R$id.titleView_toolbar);
        this.f12825e = (TextView) findViewById(R$id.tv_right_toolbar);
        this.f12827g = (EditText) findViewById(R$id.et_input_email);
        this.f12826f = (EditText) findViewById(R$id.et_input_pwd);
        this.f12828h = (ImageButton) findViewById(R$id.agreeButton);
        this.f12829i = (TextView) findViewById(R$id.tv_agree);
        this.f12830j = (ImageView) findViewById(R$id.iv_pwd);
        this.f12832l = findViewById(R$id.googleButton);
        this.f12833m = findViewById(R$id.facebookButton);
        this.f12831k = (LinearLayout) findViewById(R$id.layout_other);
    }

    private void q0() {
        String string = getString(R$string.user_agreement);
        String string2 = getString(R$string.privacy_policy);
        String str = getString(R$string.agree_uapp_tips_prefix) + string + getString(R$string.agree_uapp_tips_and) + string2;
        SpannableString spannableString = new SpannableString(str);
        int color = ContextCompat.getColor(this, R$color.white);
        int color2 = ContextCompat.getColor(this, R$color.xC69D7D);
        if (str.contains(string)) {
            int iIndexOf = str.indexOf(string);
            spannableString.setSpan(new d(color2), iIndexOf, string.length() + iIndexOf, 33);
        }
        if (str.contains(string2)) {
            int iIndexOf2 = str.indexOf(string2);
            spannableString.setSpan(new e(color2), iIndexOf2, string2.length() + iIndexOf2, 33);
        }
        this.f12829i.setText(spannableString);
        this.f12829i.setTextColor(color);
        this.f12829i.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static /* synthetic */ void t0(Throwable th) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(View view) {
        H0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(View view) {
        G0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(View view) {
        G0(false);
    }

    public final /* synthetic */ void A0(CharSequence charSequence) {
        this.f12843w.set(charSequence.toString());
    }

    public final /* synthetic */ void B0(View view) {
        G0(true);
    }

    public final /* synthetic */ void C0(View view) {
        G0(false);
    }

    public final /* synthetic */ void D0(View view) {
        this.f12828h.setSelected(!r2.isSelected());
        this.f12834n = this.f12828h.isSelected();
        e1.u().f13677e = this.f12834n;
    }

    @Override // com.uz.navee.base.BaseActivity
    public void E() {
        super.E();
        this.f12827g.setTextDirection(3);
        this.f12826f.setTextDirection(3);
        if (com.uz.navee.utils.d.p(this)) {
            this.f12827g.setGravity(8388629);
            this.f12826f.setGravity(8388629);
            this.f12823c.setImageDrawable(com.uz.navee.utils.d.q(ContextCompat.getDrawable(this, R$mipmap.ic_nav_back)));
        }
    }

    public final /* synthetic */ void E0(View view) {
        BaseActivity.F(this.f12826f, this.f12838r);
        if (this.f12838r) {
            this.f12830j.setImageResource(R$mipmap.ic_switch_pwd_open);
            this.f12838r = false;
        } else {
            this.f12830j.setImageResource(R$mipmap.ic_switch_pwd_close);
            this.f12838r = true;
        }
    }

    public final void I0(View view) {
        if (TextUtils.isEmpty((CharSequence) this.f12842v.get())) {
            com.uz.navee.utils.a.b(this.f12845y.etInputEmail);
            O();
            return;
        }
        if (this.f12841u.get() && TextUtils.isEmpty((CharSequence) this.f12843w.get())) {
            com.uz.navee.utils.a.b(this.f12845y.codeInputView2);
            O();
            return;
        }
        if (TextUtils.isEmpty((CharSequence) this.f12844x.get())) {
            com.uz.navee.utils.a.b(this.f12845y.etInputPwd);
            O();
        } else if (!this.f12834n) {
            com.uz.navee.utils.a.b(this.f12845y.layoutAgree);
            O();
        } else if (this.f12841u.get()) {
            n0(null, null);
        } else {
            H(new CheckCodePopup.b() { // from class: g4.e0
                @Override // com.uz.navee.ui.device.CheckCodePopup.b
                public final void a(String str, String str2) {
                    this.f13672a.n0(str, str2);
                }
            });
        }
    }

    public void initView() {
        this.f12824d.setVisibility(4);
        this.f12825e.setText(getString(R$string.login));
        this.f12825e.setVisibility(0);
        this.f12825e.setOnClickListener(new View.OnClickListener() { // from class: g4.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13667a.w0(view);
            }
        });
        this.f12823c.setOnClickListener(new View.OnClickListener() { // from class: g4.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13689a.x0(view);
            }
        });
        Drawable drawable = ContextCompat.getDrawable(this, R$mipmap.ic_nav_back);
        if (drawable != null && getWindow().getDecorView().getLayoutDirection() == 1) {
            drawable = com.uz.navee.utils.d.q(drawable);
        }
        this.f12823c.setImageDrawable(drawable);
        this.f12845y.tvSignWithEmail.setOnClickListener(new View.OnClickListener() { // from class: g4.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13691a.y0(view);
            }
        });
        this.f12845y.tvSignWithAc.setOnClickListener(new View.OnClickListener() { // from class: g4.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13693a.z0(view);
            }
        });
        G0(true);
        this.f12845y.codeInputView2.f12997c.setAlpha(0.3f);
        this.f12842v.addOnPropertyChangedCallback(new a());
        d3.a.a(this.f12845y.codeInputView2.f12996b).i(new b5.g() { // from class: g4.n0
            @Override // b5.g
            public final void accept(Object obj) {
                this.f13695a.A0((CharSequence) obj);
            }
        });
        this.f12845y.tvSignWithEmail.setOnClickListener(new View.OnClickListener() { // from class: g4.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13697a.B0(view);
            }
        });
        this.f12845y.tvSignWithAc.setOnClickListener(new View.OnClickListener() { // from class: g4.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13700a.C0(view);
            }
        });
        this.f12828h.setOnClickListener(new View.OnClickListener() { // from class: g4.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13702a.D0(view);
            }
        });
        this.f12845y.codeInputView2.f12996b.setHint(R$string.code_placeholder);
        this.f12845y.codeInputView2.f12997c.setOnClickListener(new View.OnClickListener() { // from class: g4.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13705a.p0(view);
            }
        });
        this.f12845y.btnSubmit.setOnClickListener(new View.OnClickListener() { // from class: g4.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13670a.I0(view);
            }
        });
        this.f12830j.setOnClickListener(new View.OnClickListener() { // from class: g4.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13687a.E0(view);
            }
        });
        this.f12836p = d4.d.h();
        this.f12835o = new QMUITipDialog.a(this).f(1).a();
        q0();
        this.f12832l.setOnClickListener(new b());
        this.f12833m.setOnClickListener(new c());
        this.f12833m.setVisibility(8);
        this.f12831k.setVisibility(8);
        E();
    }

    public final void n0(String str, String str2) {
        HashMap map = new HashMap();
        if (this.f12841u.get()) {
            map.put("email", (String) this.f12842v.get());
            map.put("code", (String) this.f12843w.get());
        } else {
            map.put("userName", (String) this.f12842v.get());
        }
        if (str != null) {
            map.put("imgCode", str);
        }
        if (str2 != null) {
            map.put("uuid", str2);
        }
        map.put("passwd", (String) this.f12844x.get());
        StringBuilder sb = new StringBuilder();
        sb.append(e4.a.a());
        sb.append(this.f12841u.get() ? "/register" : "/registerByUserName");
        String string = sb.toString();
        this.f12835o.show();
        this.f12836p.g(string, map, new g());
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityRegisterBinding activityRegisterBindingInflate = ActivityRegisterBinding.inflate(getLayoutInflater());
        this.f12845y = activityRegisterBindingInflate;
        setContentView(activityRegisterBindingInflate.getRoot());
        this.f12845y.setSignTypeEmail(this.f12841u);
        this.f12845y.setInputIdStr(this.f12842v);
        this.f12845y.setInputCodeStr(this.f12843w);
        this.f12845y.setInputPswStr(this.f12844x);
        getWindow().setBackgroundDrawable(ContextCompat.getDrawable(this, R$mipmap.bg_login));
        o0();
        initView();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        N(this.f12839s);
        super.onDestroy();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        boolean z6 = e1.u().f13677e;
        this.f12834n = z6;
        this.f12828h.setSelected(z6);
        MyApplication myApplication = (MyApplication) MyApplication.c();
        if (!myApplication.f11589a && !myApplication.f11590b) {
            this.f12831k.setVisibility(8);
            return;
        }
        this.f12831k.setVisibility(0);
        this.f12832l.setVisibility(myApplication.f11589a ? 0 : 8);
        this.f12833m.setVisibility(myApplication.f11590b ? 0 : 8);
    }

    public final void p0(View view) {
        if (!TextUtils.isEmpty((CharSequence) this.f12842v.get())) {
            H(new CheckCodePopup.b() { // from class: g4.f0
                @Override // com.uz.navee.ui.device.CheckCodePopup.b
                public final void a(String str, String str2) {
                    this.f13680a.s0(str, str2);
                }
            });
        } else {
            com.uz.navee.utils.a.b(this.f12845y.etInputEmail);
            O();
        }
    }

    public final void r0() {
        this.f12845y.codeInputView2.k("60 s");
        N(this.f12839s);
        this.f12839s = l.e(0L, 61L, 0L, 1L, TimeUnit.SECONDS).l(g5.a.b()).g(y4.b.c()).j(new b5.g() { // from class: g4.g0
            @Override // b5.g
            public final void accept(Object obj) {
                this.f13682a.v0((Long) obj);
            }
        }, new b5.g() { // from class: g4.h0
            @Override // b5.g
            public final void accept(Object obj) {
                RegisterActivity.t0((Throwable) obj);
            }
        }, new b5.a() { // from class: g4.i0
            @Override // b5.a
            public final void run() {
                this.f13685a.u0();
            }
        });
    }

    public final void s0(String str, String str2) {
        HashMap map = new HashMap();
        map.put("email", (String) this.f12842v.get());
        map.put("type", "register");
        map.put("uuid", str2);
        map.put("imgCode", str);
        String str3 = e4.a.a() + "/sendCode";
        this.f12835o.show();
        this.f12836p.g(str3, map, new f());
    }

    public final /* synthetic */ void u0() {
        this.f12845y.codeInputView2.l();
    }

    public final /* synthetic */ void v0(Long l6) {
        this.f12845y.codeInputView2.setText((60 - l6.longValue()) + " s");
    }
}
