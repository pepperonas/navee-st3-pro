package cn.sharesdk.google;

import android.content.Intent;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.WebAuthorizeActivity;
import cn.sharesdk.framework.f;
import cn.sharesdk.framework.network.SSDKNetworkHelper;
import cn.sharesdk.framework.utils.SSDKLog;
import com.google.android.gms.common.Scopes;
import com.mob.MobSDK;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class a extends f {

    /* renamed from: b, reason: collision with root package name */
    private static a f6569b;

    /* renamed from: c, reason: collision with root package name */
    private SSDKNetworkHelper f6570c;

    /* renamed from: d, reason: collision with root package name */
    private ShareActivity f6571d;

    /* renamed from: e, reason: collision with root package name */
    private String f6572e;

    /* renamed from: f, reason: collision with root package name */
    private String f6573f;

    /* renamed from: g, reason: collision with root package name */
    private String f6574g;

    /* renamed from: h, reason: collision with root package name */
    private String f6575h;

    /* renamed from: i, reason: collision with root package name */
    private String[] f6576i;

    private a(Platform platform) {
        super(platform);
        this.f6576i = new String[]{Scopes.OPEN_ID, Scopes.PROFILE, "email"};
        this.f6571d = new ShareActivity();
        this.f6570c = SSDKNetworkHelper.getInstance();
    }

    public static synchronized a a(Platform platform) {
        try {
            if (f6569b == null) {
                f6569b = new a(platform);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f6569b;
    }

    public String b(String str) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("code", str));
        arrayList.add(new KVPair<>("client_id", this.f6572e));
        arrayList.add(new KVPair<>("redirect_uri", this.f6574g));
        arrayList.add(new KVPair<>("client_secret", this.f6573f));
        arrayList.add(new KVPair<>("grant_type", "authorization_code"));
        return this.f6570c.httpPost("https://www.googleapis.com/oauth2/v4/token", arrayList, "/oauth2/v4/token", b());
    }

    public void c(String str) {
        this.f6575h = str;
    }

    public HashMap<String, Object> d(String str) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(this.f6575h)) {
            SSDKLog.b().a("GoogleHelper getUserInfo access_token is null");
        } else {
            arrayList.add(new KVPair<>("access_token", this.f6575h));
        }
        String strHttpGet = this.f6570c.httpGet("https://www.googleapis.com/oauth2/v3/userinfo", arrayList, "/oauth2/v3/userinfo", b());
        if (strHttpGet != null) {
            return new Hashon().fromJson(strHttpGet);
        }
        return null;
    }

    public HashMap<String, Object> e(String str) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        String str2 = this.f6575h;
        if (str2 != null) {
            arrayList.add(new KVPair<>("access_token", str2));
        }
        String strHttpGet = this.f6570c.httpGet("https://www.googleapis.com/plus/v1/people/" + str + "/people/visible", arrayList, "/people/visible", b());
        if (strHttpGet != null) {
            return new Hashon().fromJson(strHttpGet);
        }
        return null;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getAuthorizeUrl() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("response_type", "code"));
        arrayList.add(new KVPair("client_id", this.f6572e));
        arrayList.add(new KVPair("redirect_uri", this.f6574g));
        String[] strArr = this.f6576i;
        if (strArr != null && strArr.length > 0) {
            arrayList.add(new KVPair("scope", TextUtils.join(" ", strArr)));
        }
        return "https://accounts.google.com/o/oauth2/auth?" + ResHelper.encodeUrl((ArrayList<KVPair<String>>) arrayList);
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public cn.sharesdk.framework.authorize.b getAuthorizeWebviewClient(WebAuthorizeActivity webAuthorizeActivity) {
        return new GooglePlusAuthorizeWebviewClient(webAuthorizeActivity);
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getRedirectUri() {
        return this.f6574g;
    }

    public void c() {
        ShareActivity shareActivity = this.f6571d;
        if (shareActivity != null) {
            shareActivity.finish();
        }
    }

    public void a(String str, String str2) {
        this.f6572e = str;
        this.f6573f = str2;
    }

    public void a(String str) {
        this.f6574g = str;
    }

    public void a(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.f6576i = strArr;
    }

    public void a(AuthorizeListener authorizeListener) {
        b(authorizeListener);
    }

    public void a(String[] strArr, PlatformActionListener platformActionListener, PlatformDb platformDb) {
        Intent intent = new Intent();
        intent.putExtra("action", 0);
        this.f6571d.setPlatformActionListener(this.f6385a, platformActionListener, platformDb);
        this.f6571d.show(MobSDK.getContext(), intent);
    }

    public void a() {
        Intent intent = new Intent();
        intent.putExtra("action", 2);
        this.f6571d.show(MobSDK.getContext(), intent);
    }
}
