package g4;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.google.GooglePlus;
import com.uz.navee.MyApplication;
import com.uz.navee.bean.Agreement;
import com.uz.navee.bean.UserInfo;
import com.uz.navee.bean.UserSession;
import d4.d;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class e1 {

    /* renamed from: a, reason: collision with root package name */
    public String f13673a;

    /* renamed from: b, reason: collision with root package name */
    public int f13674b;

    /* renamed from: c, reason: collision with root package name */
    public UserInfo f13675c;

    /* renamed from: d, reason: collision with root package name */
    public Agreement f13676d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13677e;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final e1 f13678a = new e1();
    }

    public static void a(String str, int i6, int i7) {
        String str2 = e4.a.a() + "/affirmAgreement";
        HashMap map = new HashMap();
        map.put("agreementId", str);
        map.put("optType", String.valueOf(i6));
        map.put("type", String.valueOf(i7));
        d4.d.h().g(str2, map, new a());
    }

    public static void b() {
        for (String str : com.uz.navee.utils.g0.b().keySet()) {
            if (str.startsWith("modelAgreementId.")) {
                com.uz.navee.utils.g0.g(str);
            }
        }
    }

    public static void c() {
        com.uz.navee.utils.g0.g("user_img");
        com.uz.navee.utils.g0.g("user_name");
        com.uz.navee.utils.g0.g("user_acc");
        com.uz.navee.utils.g0.g("email");
        com.uz.navee.utils.g0.g("user_identifier");
    }

    public static String d() {
        return com.uz.navee.utils.g0.e("appAgreementId", "");
    }

    public static String e() {
        return com.uz.navee.utils.g0.e("recent_acc", "");
    }

    public static String f() {
        return com.uz.navee.utils.g0.e("recent_email", "");
    }

    public static int g() {
        Object objA = com.uz.navee.utils.g0.a("userId", 0);
        if (objA != null) {
            return ((Integer) objA).intValue();
        }
        return 0;
    }

    public static UserInfo h() {
        UserInfo userInfo = new UserInfo();
        userInfo.setHeadImg(com.uz.navee.utils.g0.e("user_img", ""));
        userInfo.setNickName(com.uz.navee.utils.g0.e("user_name", ""));
        userInfo.setUserName(com.uz.navee.utils.g0.e("user_acc", ""));
        userInfo.setEmail(com.uz.navee.utils.g0.e("email", ""));
        userInfo.setNaveeId(com.uz.navee.utils.g0.e("user_identifier", ""));
        return userInfo;
    }

    public static String i() {
        return com.uz.navee.utils.g0.e("Token", "");
    }

    public static Boolean j() {
        String strI = i();
        return Boolean.valueOf((strI == null || strI.isEmpty()) ? false : true);
    }

    public static Boolean k() {
        return (Boolean) com.uz.navee.utils.g0.a("signTypeLatest", Boolean.TRUE);
    }

    public static void m() {
        u().f13673a = "";
        u().f13674b = 0;
        u().f13675c = null;
        u().f13677e = false;
        com.uz.navee.utils.g0.g("userId");
        com.uz.navee.utils.g0.g("Token");
        com.uz.navee.utils.g0.g("appAgreementId");
        b();
        c();
        ShareSDK.getPlatform(GooglePlus.NAME).removeAccount(true);
        b4.a.O();
        b4.a.Q();
        b4.a.n(MyApplication.b());
    }

    public static void n(String str) {
        com.uz.navee.utils.g0.f("appAgreementId", str);
        a(str, 1, 0);
    }

    public static void o(String str, String str2) {
        com.uz.navee.utils.g0.f("modelAgreementId." + str2, str);
        a(str, 1, 1);
    }

    public static void p(boolean z6) {
        com.uz.navee.utils.g0.f("signTypeLatest", Boolean.valueOf(z6));
    }

    public static void q(String str) {
        com.uz.navee.utils.g0.f("recent_acc", str);
    }

    public static void r(String str) {
        com.uz.navee.utils.g0.f("recent_email", str);
    }

    public static void s(UserInfo userInfo) {
        u().f13675c = userInfo;
        com.uz.navee.utils.g0.f("user_name", userInfo.getNickName());
        com.uz.navee.utils.g0.f("user_img", userInfo.getHeadImg());
        com.uz.navee.utils.g0.f("user_acc", userInfo.getUserName());
        com.uz.navee.utils.g0.f("email", userInfo.getEmail());
        com.uz.navee.utils.g0.f("user_identifier", userInfo.getNaveeId());
    }

    public static void t(UserSession userSession) {
        u().f13673a = userSession.token;
        u().f13674b = userSession.userId;
        com.uz.navee.utils.g0.f("Token", userSession.token);
        com.uz.navee.utils.g0.f("userId", Integer.valueOf(userSession.userId));
        if (u().f13676d != null) {
            n(u().f13676d.getId());
        }
    }

    public static e1 u() {
        return b.f13678a;
    }

    public void l() {
        this.f13673a = i();
        this.f13674b = g();
        this.f13675c = h();
    }

    public e1() {
    }

    public class a implements d.h {
        @Override // d4.d.h
        public void a(String str) {
        }

        @Override // d4.d.h
        public void b(Exception exc) {
        }
    }
}
