package com.uz.navee.ui.login;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Pair;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintProperties;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.media3.extractor.ts.TsExtractor;
import cn.jiguang.verifysdk.api.AuthPageEventListener;
import cn.jiguang.verifysdk.api.JVerificationInterface;
import cn.jiguang.verifysdk.api.JVerifyUIClickCallback;
import cn.jiguang.verifysdk.api.JVerifyUIConfig;
import cn.jiguang.verifysdk.api.LoginSettings;
import cn.jiguang.verifysdk.api.PreLoginListener;
import cn.jiguang.verifysdk.api.PrivacyBean;
import cn.jiguang.verifysdk.api.VerifyListener;
import com.google.firebase.FirebaseApp;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lxj.xpopup.core.BasePopupView;
import com.mob.MobSDK;
import com.uz.navee.MainActivity;
import com.uz.navee.MyApplication;
import com.uz.navee.R$color;
import com.uz.navee.R$drawable;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.bean.Agreement;
import com.uz.navee.bean.AreaRes;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.bean.UserSession;
import com.uz.navee.ui.login.LoginLaunchActivity;
import com.uz.navee.ui.mine.RegionSettingActivity;
import com.uz.navee.ui.mine.UappPopup;
import com.uz.navee.ui.mine.UserAgreementPPActivity;
import com.uz.navee.ui.mine.bean.AgreeBean;
import com.uz.navee.utils.DensityUtil;
import com.uz.navee.utils.Language;
import com.uz.navee.utils.e0;
import com.uz.navee.utils.g0;
import com.uz.navee.utils.q;
import com.uz.navee.utils.y;
import d4.d;
import e3.a;
import g4.e1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONObject;
import p4.u;
import p4.v;
import p4.x;

@SuppressLint({"NonConstantResourceId", "CustomSplashScreen"})
/* loaded from: classes3.dex */
public class LoginLaunchActivity extends BaseActivity {

    /* renamed from: s, reason: collision with root package name */
    public static boolean f12777s = true;

    /* renamed from: t, reason: collision with root package name */
    public static int f12778t;

    /* renamed from: c, reason: collision with root package name */
    public Button f12779c;

    /* renamed from: d, reason: collision with root package name */
    public Button f12780d;

    /* renamed from: e, reason: collision with root package name */
    public ImageButton f12781e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f12782f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f12783g;

    /* renamed from: h, reason: collision with root package name */
    public View f12784h;

    /* renamed from: i, reason: collision with root package name */
    public View f12785i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f12786j;

    /* renamed from: k, reason: collision with root package name */
    public LinearLayout f12787k;

    /* renamed from: n, reason: collision with root package name */
    public CountDownTimer f12790n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f12791o;

    /* renamed from: p, reason: collision with root package name */
    public io.reactivex.disposables.b f12792p;

    /* renamed from: r, reason: collision with root package name */
    public ProgressBar f12794r;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12788l = true;

    /* renamed from: m, reason: collision with root package name */
    public Boolean f12789m = Boolean.FALSE;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12793q = true;

    public class a implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12795a;

        /* renamed from: com.uz.navee.ui.login.LoginLaunchActivity$a$a, reason: collision with other inner class name */
        public class C0175a extends TypeToken<HttpResponse<ArrayList<AreaRes>>> {
            public C0175a() {
            }
        }

        public a(String str) {
            this.f12795a = str;
        }

        @Override // d4.d.h
        public void a(String str) {
            System.out.println(this.f12795a + "网络请求==" + str);
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new C0175a().getType());
            if (httpResponse == null || httpResponse.getCode() != 200) {
                if (httpResponse != null) {
                    Toast.makeText(LoginLaunchActivity.this, httpResponse.getMsg(), 0).show();
                    return;
                }
                return;
            }
            String strD = y.d();
            Iterator it = ((ArrayList) httpResponse.getData()).iterator();
            AreaRes areaRes = null;
            AreaRes areaRes2 = null;
            AreaRes areaRes3 = null;
            AreaRes areaRes4 = null;
            while (it.hasNext()) {
                AreaRes areaRes5 = (AreaRes) it.next();
                if (areaRes5 != null) {
                    if (areaRes3 == null) {
                        areaRes3 = areaRes5;
                    }
                    if (areaRes5.isMatch(strD)) {
                        areaRes4 = areaRes5;
                    }
                    if (areaRes5.isBestArea() && areaRes == null) {
                        areaRes = areaRes5;
                    }
                    if (areaRes5.isDefaultFlag() && areaRes2 == null) {
                        areaRes2 = areaRes5;
                    }
                }
            }
            if (areaRes != null) {
                y.e(areaRes);
            } else if (areaRes2 != null) {
                y.e(areaRes2);
            } else if (areaRes4 != null) {
                y.e(areaRes4);
            } else {
                y.e(areaRes3);
            }
            LoginLaunchActivity.this.f12791o = (ArrayList) httpResponse.getData();
            LoginLaunchActivity.this.O0();
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            LoginLaunchActivity.this.s0();
        }
    }

    public class b implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12798a;

        public class a extends TypeToken<HttpResponse<String>> {
            public a() {
            }
        }

        public b(String str) {
            this.f12798a = str;
        }

        @Override // d4.d.h
        public void a(String str) {
            System.out.println(this.f12798a + "网络请求==" + str);
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse == null || httpResponse.getCode() != 200) {
                return;
            }
            ((MyApplication) MyApplication.c()).f11589a = ((String) httpResponse.getData()).equals("1");
        }

        @Override // d4.d.h
        public void b(Exception exc) {
        }
    }

    public class c implements View.OnApplyWindowInsetsListener {
        public c() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            new ConstraintProperties(view).margin(4, DensityUtil.a(LoginLaunchActivity.this, 30.0f) + windowInsets.getInsets(WindowInsets.Type.systemBars()).bottom);
            return windowInsets;
        }
    }

    public class d implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f12802a;

        public d(v vVar) {
            this.f12802a = vVar;
        }

        @Override // d4.d.h
        public void a(String str) {
            AgreeBean agreeBean = (AgreeBean) new GsonBuilder().create().fromJson(str, AgreeBean.class);
            if (agreeBean == null || agreeBean.getCode() != 200) {
                this.f12802a.tryOnError(new Throwable());
                return;
            }
            String policy = agreeBean.getData().getPolicy();
            String user = agreeBean.getData().getUser();
            g0.f("app.policyURL", policy);
            g0.f("app.userURL", user);
            this.f12802a.onSuccess(new Pair(user, policy));
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            this.f12802a.tryOnError(exc);
        }
    }

    public class e implements JVerifyUIClickCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12804a;

        public e(String str) {
            this.f12804a = str;
        }

        @Override // cn.jiguang.verifysdk.api.JVerifyUIClickCallback
        public void onClicked(Context context, View view) {
            if (!e1.u().f13677e) {
                Toast.makeText(LoginLaunchActivity.this, this.f12804a, 0).show();
                return;
            }
            LoginLaunchActivity.this.startActivity(new Intent(LoginLaunchActivity.this, (Class<?>) LoginActivity.class));
            MobSDK.submitPolicyGrantResult(true);
        }
    }

    public class f implements JVerifyUIClickCallback {
        public f() {
        }

        @Override // cn.jiguang.verifysdk.api.JVerifyUIClickCallback
        public void onClicked(Context context, View view) {
            LoginLaunchActivity.this.startActivity(new Intent(LoginLaunchActivity.this, (Class<?>) EnvironmentSettingActivity.class));
        }
    }

    public class g extends AuthPageEventListener {
        public g() {
        }

        @Override // cn.jiguang.verifysdk.api.AuthPageEventListener
        public void onEvent(int i6, String str) {
            if (i6 == 2) {
                LoginLaunchActivity.this.finish();
                LoginLaunchActivity.this.overridePendingTransition(0, 0);
            } else if (i6 == 6) {
                e1.u().f13677e = true;
                LoginLaunchActivity.this.f12788l = true;
            } else if (i6 == 7) {
                e1.u().f13677e = false;
                LoginLaunchActivity.this.f12788l = false;
            }
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
            LoginLaunchActivity.this.f12794r.setVisibility(8);
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse != null) {
                if (httpResponse.getCode() == 200) {
                    e1.t((UserSession) httpResponse.getData());
                    LoginLaunchActivity.this.startActivity(new Intent(LoginLaunchActivity.this, (Class<?>) MainActivity.class).setFlags(268468224));
                    JVerificationInterface.dismissLoginAuthActivity();
                } else {
                    Toast.makeText(LoginLaunchActivity.this, httpResponse.getMsg(), 0).show();
                }
            }
            LoginLaunchActivity.this.f12793q = true;
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            LoginLaunchActivity.this.f12794r.setVisibility(8);
            Toast.makeText(LoginLaunchActivity.this, exc.getMessage(), 0).show();
            LoginLaunchActivity.this.f12793q = true;
        }
    }

    public class i implements d.h {

        public class a extends TypeToken<HttpResponse<Agreement>> {
            public a() {
            }
        }

        public class b extends CountDownTimer {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f12812a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ HttpResponse f12813b;

            public class a extends e0.a {

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ String f12815c;

                /* renamed from: com.uz.navee.ui.login.LoginLaunchActivity$i$b$a$a, reason: collision with other inner class name */
                public class C0176a implements UappPopup.d {
                    public C0176a() {
                    }

                    @Override // com.uz.navee.ui.mine.UappPopup.d
                    public void a() {
                        e1.a(((Agreement) b.this.f12813b.getData()).getId(), 0, 0);
                        e1.m();
                        LoginLaunchActivity.Q0(MyApplication.f11588e);
                    }

                    @Override // com.uz.navee.ui.mine.UappPopup.d
                    public void b() {
                        LoginLaunchActivity.this.startActivity(new Intent(MyApplication.f11588e, (Class<?>) UserAgreementPPActivity.class));
                    }

                    @Override // com.uz.navee.ui.mine.UappPopup.d
                    public void c() {
                        e1.n(((Agreement) b.this.f12813b.getData()).getId());
                    }
                }

                /* renamed from: com.uz.navee.ui.login.LoginLaunchActivity$i$b$a$b, reason: collision with other inner class name */
                public class C0177b extends i3.d {
                    public C0177b() {
                    }

                    @Override // i3.e
                    public void h(BasePopupView basePopupView) {
                        e0.f().e(a.this.f13279b);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(int i6, String str, String str2) {
                    super(i6, str);
                    this.f12815c = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.C0192a c0192aG = new a.C0192a(MyApplication.f11588e).f(false).g(Boolean.TRUE);
                    Boolean bool = Boolean.FALSE;
                    c0192aG.d(bool).e(bool).l(new C0177b()).a(new UappPopup(MyApplication.f11588e, this.f12815c, new C0176a())).G();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(long j6, long j7, String str, HttpResponse httpResponse) {
                super(j6, j7);
                this.f12812a = str;
                this.f12813b = httpResponse;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j6) {
                if (((int) (j6 / 1000)) <= 0) {
                    LoginLaunchActivity.this.f12790n.cancel();
                    if (!e1.j().booleanValue() || this.f12812a.equals(((Agreement) this.f12813b.getData()).getId())) {
                        return;
                    }
                    String desc = ((Agreement) this.f12813b.getData()).getDesc();
                    if (MyApplication.f11588e != null) {
                        e0.f().a(new a(0, "showUappPopup", desc));
                    }
                }
            }
        }

        public i() {
        }

        @Override // d4.d.h
        public void a(String str) {
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse == null || httpResponse.getCode() != 200) {
                return;
            }
            e1.u().f13676d = (Agreement) httpResponse.getData();
            String strD = e1.d();
            String policy = ((Agreement) httpResponse.getData()).getPolicy();
            String user = ((Agreement) httpResponse.getData()).getUser();
            g0.f("app.policyURL", policy);
            g0.f("app.userURL", user);
            LoginLaunchActivity.this.f12790n = new b(1000L, 1000L, strD, httpResponse).start();
        }

        @Override // d4.d.h
        public void b(Exception exc) {
        }
    }

    public class j extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12819a;

        public j(int i6) {
            this.f12819a = i6;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            LoginLaunchActivity.this.U0();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(this.f12819a);
            textPaint.setUnderlineText(true);
        }
    }

    public class k extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12821a;

        public k(int i6) {
            this.f12821a = i6;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            LoginLaunchActivity.this.U0();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(this.f12821a);
            textPaint.setUnderlineText(true);
        }
    }

    public static /* synthetic */ Pair F0(Boolean bool, Pair pair) {
        return pair;
    }

    public static void Q0(Activity activity) {
        if (activity == null) {
            return;
        }
        JVerificationInterface.dismissLoginAuthActivity();
        activity.startActivity(new Intent(activity, (Class<?>) LoginLaunchActivity.class).setFlags(268468224));
        activity.overridePendingTransition(0, 0);
    }

    private void T0() {
        if (!this.f12788l) {
            com.uz.navee.utils.a.b(this.f12787k);
            O();
        } else {
            if (this.f12789m.booleanValue()) {
                return;
            }
            this.f12789m = Boolean.TRUE;
            startActivity(new Intent(this, (Class<?>) RegisterActivity.class));
            MobSDK.submitPolicyGrantResult(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0() {
        if (this.f12789m.booleanValue()) {
            return;
        }
        this.f12789m = Boolean.TRUE;
        startActivity(new Intent(this, (Class<?>) UserAgreementPPActivity.class));
    }

    private void o0() {
        this.f12779c = (Button) findViewById(R$id.login_btn);
        this.f12780d = (Button) findViewById(R$id.register_btn);
        this.f12781e = (ImageButton) findViewById(R$id.agreeButton);
        this.f12782f = (TextView) findViewById(R$id.tv_user_agree);
        this.f12783g = (TextView) findViewById(R$id.tvArea);
        this.f12784h = findViewById(R$id.icoArea);
        this.f12785i = findViewById(R$id.touchArea);
        this.f12787k = (LinearLayout) findViewById(R$id.layout_agree);
        this.f12786j = (TextView) findViewById(R$id.tvEnvironment);
    }

    private void p0() {
        String string = getString(R$string.user_agreement);
        String string2 = getString(R$string.privacy_policy);
        String str = getString(R$string.agree_uapp_tips_prefix) + string + getString(R$string.agree_uapp_tips_and) + string2;
        SpannableString spannableString = new SpannableString(str);
        int color = ContextCompat.getColor(this, R$color.white);
        int color2 = ContextCompat.getColor(this, R$color.xC69D7D);
        if (str.contains(string)) {
            int iIndexOf = str.indexOf(string);
            spannableString.setSpan(new j(color2), iIndexOf, string.length() + iIndexOf, 33);
        }
        if (str.contains(string2)) {
            int iIndexOf2 = str.indexOf(string2);
            spannableString.setSpan(new k(color2), iIndexOf2, string2.length() + iIndexOf2, 33);
        }
        this.f12782f.setText(spannableString);
        this.f12782f.setTextColor(color);
        this.f12782f.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(View view) {
        startActivity(new Intent(this, (Class<?>) EnvironmentSettingActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(View view) {
        S0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(View view) {
        R0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(View view) {
        T0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(View view) {
        this.f12781e.setSelected(!r2.isSelected());
        this.f12788l = this.f12781e.isSelected();
        e1.u().f13677e = this.f12788l;
    }

    public final /* synthetic */ void A0(Pair pair) {
        B();
        r0((String) pair.first, (String) pair.second);
    }

    public final /* synthetic */ void B0(Throwable th) {
        B();
        f4.b.b("preFetch failed");
        N0(Boolean.FALSE);
    }

    public final /* synthetic */ void C0(v vVar, int i6, String str, JSONObject jSONObject) {
        f4.b.c("JVerificationInterface preLogin,code=%d,content=%s,json=%s", Integer.valueOf(i6), str, jSONObject);
        if (i6 == 7000) {
            vVar.onSuccess(Boolean.TRUE);
        } else {
            vVar.tryOnError(new Throwable());
            N0(Boolean.FALSE);
        }
    }

    public final /* synthetic */ void D0(final v vVar) {
        JVerificationInterface.preLogin(this, 5000, new PreLoginListener() { // from class: g4.p
            @Override // cn.jiguang.verifysdk.api.PreLoginListener
            public final void onResult(int i6, String str, JSONObject jSONObject) {
                this.f13698a.C0(vVar, i6, str, jSONObject);
            }
        });
    }

    public final /* synthetic */ void E0(v vVar) {
        d4.d.h().g(e4.a.a() + "/agreement", null, new d(vVar));
    }

    public final /* synthetic */ void G0(io.reactivex.disposables.b bVar) {
        K();
    }

    public final /* synthetic */ void H0(AreaRes areaRes) {
        this.f12783g.setText(areaRes.getAreaName());
        this.f12783g.setVisibility(0);
        this.f12785i.setVisibility(0);
        this.f12784h.setVisibility(0);
    }

    public final void I0() {
        String str = e4.a.a() + "/area?area=" + y.a();
        d4.d.h().f(str, new a(str));
    }

    public final void J0(String str) {
        this.f12793q = false;
        HashMap map = new HashMap();
        map.put("loginToken", str);
        this.f12794r.setVisibility(0);
        d4.d.h().g(e4.a.a() + "/loginByPhone", map, new h());
    }

    public final void K0() {
        String strA = y.a();
        if (!"CN".equals(strA) && !"HK".equals(strA)) {
            f4.b.b("非大陆或香港，不跳转一键登录");
            N0(Boolean.FALSE);
        } else if (!JVerificationInterface.isInitSuccess()) {
            f4.b.b("极光认证SDK未初始化");
            N0(Boolean.FALSE);
        } else if (JVerificationInterface.checkVerifyEnable(this)) {
            this.f12792p = u.q(u.g(new x() { // from class: g4.m
                @Override // p4.x
                public final void a(p4.v vVar) {
                    this.f13692a.D0(vVar);
                }
            }), u.g(new x() { // from class: g4.s
                @Override // p4.x
                public final void a(p4.v vVar) {
                    this.f13706a.E0(vVar);
                }
            }), new r4.c() { // from class: g4.t
                @Override // r4.c
                public final Object apply(Object obj, Object obj2) {
                    return LoginLaunchActivity.F0((Boolean) obj, (Pair) obj2);
                }
            }).h(new r4.g() { // from class: g4.u
                @Override // r4.g
                public final void accept(Object obj) {
                    this.f13709a.G0((io.reactivex.disposables.b) obj);
                }
            }).n(new r4.g() { // from class: g4.v
                @Override // r4.g
                public final void accept(Object obj) {
                    this.f13711a.A0((Pair) obj);
                }
            }, new r4.g() { // from class: g4.w
                @Override // r4.g
                public final void accept(Object obj) {
                    this.f13713a.B0((Throwable) obj);
                }
            });
        } else {
            f4.b.b("当前网络环境不支持一键认证");
            N0(Boolean.FALSE);
        }
    }

    public final void L0() {
        d4.d.h().g(e4.a.a() + "/agreement", new HashMap(), new i());
    }

    public boolean M0(int i6) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") != 0) {
                arrayList.add("android.permission.CAMERA");
            }
            if (ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
            }
            if (ContextCompat.checkSelfPermission(this, "android.permission.INTERNET") != 0) {
                arrayList.add("android.permission.INTERNET");
            }
            if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
            }
            if (ContextCompat.checkSelfPermission(this, "android.permission.MOUNT_UNMOUNT_FILESYSTEMS") != 0) {
                arrayList.add("android.permission.MOUNT_UNMOUNT_FILESYSTEMS");
            }
            if (ContextCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") != 0) {
                arrayList.add("android.permission.BLUETOOTH_CONNECT");
            }
            if (ContextCompat.checkSelfPermission(this, "android.permission.BLUETOOTH") != 0) {
                arrayList.add("android.permission.BLUETOOTH");
            }
            if (ContextCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_ADMIN") != 0) {
                arrayList.add("android.permission.BLUETOOTH_ADMIN");
            }
            if (ContextCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_SCAN") != 0) {
                arrayList.add("android.permission.BLUETOOTH_SCAN");
            }
            if (ContextCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_ADVERTISE") != 0) {
                arrayList.add("android.permission.BLUETOOTH_ADVERTISE");
            }
            if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            }
            if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
            }
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        if (arrayList.size() < 1) {
            return true;
        }
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i7 = 0; i7 < size; i7++) {
            strArr[i7] = (String) arrayList.get(i7);
        }
        ActivityCompat.requestPermissions(this, strArr, i6);
        return false;
    }

    public final void N0(Boolean bool) {
        this.f12779c.setVisibility(bool.booleanValue() ? 4 : 0);
        this.f12780d.setVisibility(bool.booleanValue() ? 4 : 0);
        this.f12787k.setVisibility(bool.booleanValue() ? 4 : 0);
    }

    public final void O0() {
        final AreaRes areaResB = y.b();
        if (areaResB == null) {
            I0();
        } else {
            try {
                this.f12783g.post(new Runnable() { // from class: g4.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f13703a.H0(areaResB);
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    public final void P0() {
        startActivity(new Intent(this, (Class<?>) MainActivity.class).setFlags(268468224));
        overridePendingTransition(0, 0);
    }

    public void R0() {
        if (!this.f12788l) {
            com.uz.navee.utils.a.b(this.f12787k);
            O();
        } else {
            if (this.f12789m.booleanValue()) {
                return;
            }
            this.f12789m = Boolean.TRUE;
            startActivity(new Intent(this, (Class<?>) LoginActivity.class));
            MobSDK.submitPolicyGrantResult(true);
        }
    }

    public void S0() {
        Intent intent = new Intent(this, (Class<?>) RegionSettingActivity.class);
        intent.putExtra("areaList", q.d(this.f12791o));
        startActivity(intent);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_login_launch);
        Language.migrate();
        o0();
        G(true, false);
        if (Build.VERSION.SDK_INT >= 35) {
            getWindow().setNavigationBarContrastEnforced(false);
            this.f12787k.setOnApplyWindowInsetsListener(new c());
        }
        FirebaseApp.initializeApp(this);
        boolean zM0 = M0(99);
        int i6 = f12778t;
        if (i6 == 0) {
            this.f12786j.setVisibility(8);
            if (Locale.getDefault().getCountry().equals("CN")) {
                g0.f("Environment", 1);
            } else {
                g0.g("Environment");
            }
        } else if (i6 == 1) {
            this.f12786j.setVisibility(8);
            g0.f("Environment", 1);
        } else if (i6 == 2) {
            this.f12786j.setVisibility(0);
            this.f12786j.setOnClickListener(new View.OnClickListener() { // from class: g4.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f13715a.v0(view);
                }
            });
        }
        this.f12785i.setOnClickListener(new View.OnClickListener() { // from class: g4.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13717a.w0(view);
            }
        });
        this.f12779c.setOnClickListener(new View.OnClickListener() { // from class: g4.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13719a.x0(view);
            }
        });
        this.f12780d.setOnClickListener(new View.OnClickListener() { // from class: g4.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13661a.y0(view);
            }
        });
        this.f12781e.setOnClickListener(new View.OnClickListener() { // from class: g4.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13694a.z0(view);
            }
        });
        boolean zBooleanValue = e1.j().booleanValue();
        f12777s = zBooleanValue;
        if (zBooleanValue) {
            this.f12779c.setVisibility(8);
            this.f12780d.setVisibility(8);
            this.f12781e.setVisibility(8);
            this.f12787k.setVisibility(8);
            P0();
        } else {
            this.f12779c.setVisibility(0);
            this.f12780d.setVisibility(0);
            this.f12781e.setVisibility(0);
            this.f12787k.setVisibility(0);
            if (zM0) {
                K0();
            }
        }
        L0();
        p0();
        N0(Boolean.TRUE);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        io.reactivex.disposables.b bVar = this.f12792p;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i6, strArr, iArr);
        for (int i7 = 0; i7 < strArr.length; i7++) {
            int i8 = iArr[i7];
        }
        K0();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f12789m = Boolean.FALSE;
        I0();
        q0();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (e1.u().f13677e) {
            this.f12788l = true;
        } else {
            Agreement agreement = e1.u().f13676d;
            String strD = e1.d();
            if (agreement == null || !Objects.equals(agreement.getId(), strD)) {
                this.f12788l = false;
            } else {
                this.f12788l = true;
            }
        }
        e1 e1VarU = e1.u();
        boolean z6 = this.f12788l;
        e1VarU.f13677e = z6;
        this.f12781e.setSelected(z6);
    }

    public final void q0() {
        String str = e4.a.a() + "/configKey/google_third_login";
        d4.d.h().f(str, new b(str));
    }

    public final void r0(String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        if (com.uz.navee.utils.d.o()) {
            str3 = "我已阅读并同意";
            str4 = "、";
            str5 = "用户协议";
            str6 = "隐私政策";
            str7 = "本机号码登录";
            str8 = "其他方式登录";
            str9 = "请点击同意协议";
        } else {
            str3 = "I have read and agree to ";
            str4 = ", ";
            str5 = "User Agreement";
            str6 = "Privacy Policy";
            str7 = "Login";
            str8 = "Other login options";
            str9 = "Please click to agree to the agreement";
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PrivacyBean(str5, str, str4));
        arrayList.add(new PrivacyBean(str6, str2, str4));
        ImageView imageView = new ImageView(this);
        int iA = DensityUtil.a(this, 25.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams.setMarginStart(DensityUtil.a(this, 12.0f));
        layoutParams.addRule(15);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(R$mipmap.ic_nav_back);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int iJ = com.uz.navee.utils.d.j(this);
        int iG = com.uz.navee.utils.d.g(this);
        int iA2 = iJ - DensityUtil.a(this, 30.0f);
        Button button = new Button(this);
        button.setText(str8);
        button.setTextSize(17.0f);
        button.setBackground(ContextCompat.getDrawable(this, R$drawable.bg_round_16_ffffff_80));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(DensityUtil.a(this, 15.0f), iG - DensityUtil.a(this, 175.0f), 0, 0);
        layoutParams2.height = DensityUtil.a(this, 60.0f);
        layoutParams2.width = iA2;
        button.setLayoutParams(layoutParams2);
        this.f12794r = new ProgressBar(this);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        this.f12794r.setLayoutParams(layoutParams3);
        this.f12794r.setVisibility(8);
        JVerifyUIConfig.Builder builderAddCustomView = new JVerifyUIConfig.Builder().setAppLanguageType(com.uz.navee.utils.d.o() ? 0 : 2).setAuthBGImgPath("launch_image_mask").setStatusBarTransparent(true).setVirtualButtonTransparent(true).setNavText("").setNavHidden(true).setLogoWidth(205).setLogoHeight(45).setLogoHidden(false).setLogoImgPath("launch_logo").setLogoOffsetY(100).setNumberColor(-1).setNumberSize(24).setNumFieldOffsetY(TsExtractor.TS_PACKET_SIZE).setSloganTextSize(12).setSloganTextColor(getColor(R$color.xFAF4E8_50)).setSloganOffsetY(227).setLogBtnText(str7).setLogBtnTextColor(getColor(R$color.xF2E1D6)).setLogBtnTextSize(17).setLogBtnImgPath("bg_round_16_gradient_specific").setLogBtnWidth(DensityUtil.b(this, iA2)).setLogBtnHeight(60).setLogBtnOffsetY(DensityUtil.b(this, iG) - 250).setPrivacyNameAndUrlBeanList(arrayList).setAppPrivacyColor(-1, getColor(R$color.xC69D7D)).setPrivacyMarginL(74).setPrivacyMarginR(80).setPrivacyMarginB(50).setPrivacyCheckboxSize(14).enableHintToast(true, Toast.makeText(this, str9, 0)).setPrivacyUnderlineText(true).setUncheckedImgPath("ic_agree_normal").setCheckedImgPath("ic_agree_selected").setPrivacyText(str3, "").setPrivacyState(e1.u().f13677e).setIsPrivacyViewDarkMode(false).setPrivacyNavColor(getColor(R$color.x161514)).setPrivacyNavTitleTextColor(getColor(R$color.nav_title_color)).setPrivacyNavTitleTextSize(18).setPrivacyNavReturnBtn(imageView).setNeedStartAnim(false).addCustomView(button, false, new e(str9)).addCustomView(this.f12794r, false, null);
        if (f12778t == 2) {
            TextView textView = new TextView(this);
            textView.setText("环境");
            textView.setTextSize(13.0f);
            textView.setTypeface(Typeface.defaultFromStyle(1));
            textView.setTextAlignment(4);
            textView.setGravity(17);
            textView.setTextColor(ContextCompat.getColor(this, R$color.white));
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.setMargins(DensityUtil.a(this, 15.0f), DensityUtil.a(this, 45.0f), 0, 0);
            layoutParams4.height = DensityUtil.a(this, 40.0f);
            layoutParams4.width = DensityUtil.a(this, 50.0f);
            textView.setLayoutParams(layoutParams4);
            builderAddCustomView.addCustomView(textView, false, new f());
        }
        JVerificationInterface.setCustomUIWithConfig(builderAddCustomView.build());
        LoginSettings loginSettings = new LoginSettings();
        loginSettings.setAutoFinish(false);
        loginSettings.setTimeout(15000);
        loginSettings.setAuthPageEventListener(new g());
        JVerificationInterface.loginAuth(this, loginSettings, new VerifyListener() { // from class: g4.o
            @Override // cn.jiguang.verifysdk.api.VerifyListener
            public final void onResult(int i6, String str10, String str11, JSONObject jSONObject) {
                this.f13696a.t0(i6, str10, str11, jSONObject);
            }
        });
    }

    public final void s0() {
        try {
            this.f12783g.post(new Runnable() { // from class: g4.q
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13701a.u0();
                }
            });
        } catch (Exception unused) {
        }
    }

    public final /* synthetic */ void t0(int i6, String str, String str2, JSONObject jSONObject) {
        f4.b.c("JVerificationInterface loginAuth,code=%d,content=%s,operator=%s,json=%s", Integer.valueOf(i6), str, str2, jSONObject);
        if (i6 == 6000) {
            if (this.f12793q) {
                J0(str);
            }
        } else if (i6 == 6001) {
            Toast.makeText(this, com.uz.navee.utils.d.o() ? "一键登录失败，请稍后重试或使用其他登录方式" : "Login failed, please try again later or use another login method", 0).show();
        } else if (i6 == 6006 && this.f12793q) {
            Toast.makeText(this, com.uz.navee.utils.d.o() ? "状态已过期，请重试" : "Status expired, please try again", 0).show();
            JVerificationInterface.dismissLoginAuthActivity();
        }
        N0(Boolean.FALSE);
    }

    public final /* synthetic */ void u0() {
        this.f12783g.setVisibility(4);
        this.f12785i.setVisibility(4);
        this.f12784h.setVisibility(4);
    }

    @Override // com.uz.navee.base.BaseActivity
    public boolean x() {
        return false;
    }

    @Override // com.uz.navee.base.BaseActivity
    public boolean y() {
        return false;
    }
}
