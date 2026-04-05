package cn.sharesdk.facebook;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOAuthorizeActivity;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.authorize.WebAuthorizeActivity;
import cn.sharesdk.framework.f;
import cn.sharesdk.framework.network.SSDKNetworkHelper;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.i;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mob.MobSDK;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class d extends f {

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f6122b = {"email", "public_profile"};

    /* renamed from: c, reason: collision with root package name */
    private static d f6123c;

    /* renamed from: d, reason: collision with root package name */
    private String f6124d;

    /* renamed from: e, reason: collision with root package name */
    private String f6125e;

    /* renamed from: f, reason: collision with root package name */
    private long f6126f;

    /* renamed from: g, reason: collision with root package name */
    private String f6127g;

    /* renamed from: h, reason: collision with root package name */
    private SSDKNetworkHelper f6128h;

    /* renamed from: i, reason: collision with root package name */
    private String[] f6129i;

    /* renamed from: j, reason: collision with root package name */
    private String f6130j;

    private d(Platform platform) {
        super(platform);
        this.f6128h = SSDKNetworkHelper.getInstance();
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getAuthorizeUrl() {
        Bundle bundle = new Bundle();
        bundle.putString("app_id", this.f6127g);
        bundle.putString("client_id", this.f6127g);
        bundle.putString("auth_type", "rerequest");
        bundle.putString("default_audience", "friends");
        bundle.putString("display", "touch");
        bundle.putString("fbapp_pres", "1");
        bundle.putString("redirect_uri", this.f6130j);
        bundle.putString("response_type", "token,signed_request");
        bundle.putString("return_scopes", "true");
        bundle.putString("sdk", "android");
        bundle.putString("sdk_version", "5.4.0");
        bundle.putString("state", "{\"challenge\":\"G/I5SknMfRmyvIr/q5bFJNwIqI8=\"}");
        bundle.putString("title", "Log In");
        bundle.putString("type", "user_agent");
        String[] strArr = this.f6129i;
        if (strArr == null) {
            strArr = f6122b;
        }
        for (String str : strArr) {
        }
        this.f6124d = "https://m.facebook.com/v13.0/dialog/oauth?" + ResHelper.encodeUrl(bundle);
        ShareSDK.logApiEvent("/dialog/oauth", b());
        SSDKLog.b().a("FbHelper===> " + this.f6124d);
        return this.f6124d;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public cn.sharesdk.framework.authorize.b getAuthorizeWebviewClient(WebAuthorizeActivity webAuthorizeActivity) {
        return new c(webAuthorizeActivity);
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getRedirectUri() {
        return this.f6130j;
    }

    @Override // cn.sharesdk.framework.f, cn.sharesdk.framework.authorize.AuthorizeHelper
    public cn.sharesdk.framework.authorize.c getSSOProcessor(SSOAuthorizeActivity sSOAuthorizeActivity) {
        b bVar = new b(sSOAuthorizeActivity);
        bVar.a(32525);
        String str = this.f6127g;
        String[] strArr = this.f6129i;
        if (strArr == null) {
            strArr = f6122b;
        }
        bVar.a(str, strArr);
        return bVar;
    }

    public void b(String str) {
        this.f6130j = str;
    }

    public static d a(Platform platform) {
        if (f6123c == null) {
            f6123c = new d(platform);
        }
        return f6123c;
    }

    public void a(String str) {
        this.f6127g = str;
    }

    public void a(String str, String str2) {
        this.f6125e = str;
        if (str2 == null || str2.equals("0")) {
            return;
        }
        try {
            this.f6126f = System.currentTimeMillis() + (Long.valueOf(str2).longValue() * 1000);
        } catch (Throwable th) {
            SSDKLog.b().a(th);
        }
    }

    public boolean a() {
        return this.f6125e != null && (this.f6126f == 0 || System.currentTimeMillis() < this.f6126f);
    }

    public void a(String[] strArr) {
        this.f6129i = strArr;
    }

    public void a(final ShareSDKCallback<Boolean> shareSDKCallback) {
        Intent intent = new Intent();
        intent.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
        intent.putExtra("client_id", this.f6127g);
        String[] strArr = this.f6129i;
        if (strArr != null && strArr.length > 0) {
            intent.putExtra("scope", TextUtils.join(",", strArr));
        }
        DH.requester(MobSDK.getContext()).getPInfoForce(true, "com.facebook.katana", 64).resolveActivity(intent, 0).request(new DH.DHResponder() { // from class: cn.sharesdk.facebook.d.1
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                ShareSDKCallback shareSDKCallback2;
                try {
                    if (dHResponse.resolveActivity(new int[0]) == null) {
                        ShareSDKCallback shareSDKCallback3 = shareSDKCallback;
                        if (shareSDKCallback3 != null) {
                            shareSDKCallback3.onCallback(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                    try {
                        PackageInfo pInfoForce = dHResponse.getPInfoForce(new int[0]);
                        if (pInfoForce == null) {
                            pInfoForce = i.a("com.facebook.katana", 64);
                        }
                        if (pInfoForce == null) {
                            ShareSDKCallback shareSDKCallback4 = shareSDKCallback;
                            if (shareSDKCallback4 != null) {
                                shareSDKCallback4.onCallback(Boolean.FALSE);
                                return;
                            }
                            return;
                        }
                        for (Signature signature : pInfoForce.signatures) {
                            if ("30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2".equals(signature.toCharsString()) && (shareSDKCallback2 = shareSDKCallback) != null) {
                                shareSDKCallback2.onCallback(Boolean.TRUE);
                            }
                        }
                    } catch (Throwable unused) {
                        ShareSDKCallback shareSDKCallback5 = shareSDKCallback;
                        if (shareSDKCallback5 != null) {
                            shareSDKCallback5.onCallback(Boolean.FALSE);
                        }
                    }
                } catch (Throwable unused2) {
                    ShareSDKCallback shareSDKCallback6 = shareSDKCallback;
                    if (shareSDKCallback6 != null) {
                        shareSDKCallback6.onCallback(Boolean.FALSE);
                    }
                }
            }
        });
    }

    public void a(final AuthorizeListener authorizeListener, boolean z6) {
        if (z6) {
            b(authorizeListener);
        } else {
            a(new SSOListener() { // from class: cn.sharesdk.facebook.d.2
                @Override // cn.sharesdk.framework.authorize.SSOListener
                public void onCancel() {
                    authorizeListener.onCancel();
                }

                @Override // cn.sharesdk.framework.authorize.SSOListener
                public void onComplete(Bundle bundle) {
                    authorizeListener.onComplete(bundle);
                }

                @Override // cn.sharesdk.framework.authorize.SSOListener
                public void onFailed(Throwable th) {
                    SSDKLog.b().a(th);
                    d.this.b(authorizeListener);
                }
            });
        }
    }

    public void a(final Platform.ShareParams shareParams, final PlatformActionListener platformActionListener) throws Throwable {
        DH.requester(MobSDK.getContext()).getDeviceKey().getDetailNetworkTypeForStatic().getScreenSize().getCarrier().getNetworkType().request(new DH.DHResponder() { // from class: cn.sharesdk.facebook.d.3
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("dk", dHResponse.getDeviceKey());
                    map.put("nt", dHResponse.getNetworkType());
                    map.put("dnwktfs", dHResponse.getDetailNetworkTypeForStatic());
                    map.put("srs", dHResponse.getScreenSize());
                    map.put("car", dHResponse.getCarrier());
                    String imageUrl = shareParams.getImageUrl();
                    String title = shareParams.getTitle();
                    String text = shareParams.getText();
                    String musicUrl = shareParams.getMusicUrl();
                    String url = shareParams.getUrl();
                    String titleUrl = shareParams.getTitleUrl();
                    if (!TextUtils.isEmpty(titleUrl)) {
                        titleUrl = ((f) d.this).f6385a.getShortLintk(titleUrl, false, map);
                        shareParams.setTitleUrl(titleUrl);
                    } else if (!TextUtils.isEmpty(url)) {
                        titleUrl = ((f) d.this).f6385a.getShortLintk(url, false, map);
                        shareParams.setUrl(titleUrl);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("https://www.facebook.com/dialog/feed?");
                    sb.append("app_id=");
                    sb.append(d.this.f6127g);
                    sb.append("&redirect_uri=fbconnect://success");
                    sb.append("&link=");
                    sb.append(Data.urlEncode(titleUrl, "utf-8"));
                    if (!TextUtils.isEmpty(shareParams.getQuote())) {
                        sb.append("&quote=");
                        sb.append(Data.urlEncode(shareParams.getQuote(), "utf-8"));
                    }
                    if (!TextUtils.isEmpty(imageUrl)) {
                        sb.append("&picture=");
                        sb.append(Data.urlEncode(imageUrl, "utf-8"));
                    }
                    if (!TextUtils.isEmpty(title)) {
                        sb.append("&caption=");
                        sb.append(Data.urlEncode(title, "utf-8"));
                    }
                    if (!TextUtils.isEmpty(text)) {
                        sb.append("&description=");
                        sb.append(Data.urlEncode(text, "utf-8"));
                    }
                    if (!TextUtils.isEmpty(musicUrl)) {
                        sb.append("&source=");
                        sb.append(Data.urlEncode(musicUrl, "utf-8"));
                        if (!TextUtils.isEmpty(text)) {
                            sb.append("&name=");
                            sb.append(Data.urlEncode(text, "utf-8"));
                        }
                    }
                    WebShareActivity webShareActivity = new WebShareActivity();
                    webShareActivity.setScheme(sb.toString());
                    webShareActivity.setSharedCallback(platformActionListener);
                    webShareActivity.show(MobSDK.getContext(), null);
                } catch (Throwable th) {
                    PlatformActionListener platformActionListener2 = platformActionListener;
                    if (platformActionListener2 != null) {
                        platformActionListener2.onError(((f) d.this).f6385a, 9, th);
                    }
                }
            }
        });
    }

    public HashMap<String, Object> a(String str, Boolean bool) throws Throwable {
        String str2;
        if (str != null) {
            str2 = RemoteSettings.FORWARD_SLASH_STRING + str;
        } else {
            str2 = "/me";
        }
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("access_token", this.f6125e));
        arrayList.add(new KVPair<>("format", "json"));
        if (bool.booleanValue()) {
            arrayList.add(new KVPair<>("fields", "id,name,first_name,middle_name,last_name,gender,locale,link,age_range,birthday,currency,email,picture.type(large)"));
        } else {
            arrayList.add(new KVPair<>("fields", "id,name,first_name,middle_name,last_name,gender,locale,languages,link,age_range,third_party_id,installed,timezone,updated_time,verified,birthday,currency,devices,education,email,hometown,interested_in,location,political,payment_pricepoints,favorite_athletes,favorite_teams,picture.type(large),quotes,relationship_status,religion,significant_other,video_upload_limits,website,work"));
        }
        String strHttpGet = this.f6128h.httpGet("https://graph.facebook.com/v13.0" + str2, arrayList, "get_user_info", b());
        SSDKLog.b().b("facebook helper getUser");
        if (strHttpGet == null || strHttpGet.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strHttpGet);
    }

    public HashMap<String, Object> a(int i6, int i7, String str) throws Throwable {
        String str2;
        String str3 = str != null ? str : "me";
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("access_token", this.f6125e));
        arrayList.add(new KVPair<>("format", "json"));
        arrayList.add(new KVPair<>("limit", String.valueOf(i6)));
        arrayList.add(new KVPair<>(TypedValues.CycleType.S_WAVE_OFFSET, String.valueOf(i7)));
        arrayList.add(new KVPair<>("fields", "id,name,first_name,middle_name,last_name,gender,locale,languages,link,age_range,third_party_id,installed,timezone,updated_time,verified,birthday,cover,currency,devices,education,email,hometown,interested_in,location,political,payment_pricepoints,favorite_athletes,favorite_teams,picture,quotes,relationship_status,religion,significant_other,video_upload_limits,website,work"));
        if (!TextUtils.isEmpty(str)) {
            str2 = "/taggable_friends";
        } else {
            str2 = "/friends";
        }
        String strHttpGet = this.f6128h.httpGet("https://graph.facebook.com/v13.0/" + str3 + str2, arrayList, "friends", b());
        if (strHttpGet == null || strHttpGet.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strHttpGet);
    }

    public HashMap<String, Object> a(String str, String str2, HashMap<String, Object> map, HashMap<String, String> map2) throws Throwable {
        KVPair<String> kVPair;
        String strHttpPost;
        if (str2 == null) {
            return null;
        }
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                arrayList.add(new KVPair<>(entry.getKey(), String.valueOf(entry.getValue())));
            }
        }
        arrayList.add(new KVPair<>("access_token", this.f6125e));
        arrayList.add(new KVPair<>("format", "json"));
        if (map2 == null || map2.size() <= 0) {
            kVPair = null;
        } else {
            KVPair<String> kVPair2 = null;
            for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                kVPair2 = new KVPair<>(entry2.getKey(), entry2.getValue());
            }
            kVPair = kVPair2;
        }
        if ("GET".equals(str2.toUpperCase())) {
            strHttpPost = this.f6128h.httpGet(str, arrayList, (ArrayList<KVPair<String>>) null, (NetworkHelper.NetworkTimeOut) null);
        } else {
            strHttpPost = "POST".equals(str2.toUpperCase()) ? this.f6128h.httpPost(str, arrayList, kVPair, (ArrayList<KVPair<String>>) null, (NetworkHelper.NetworkTimeOut) null) : null;
        }
        if (strHttpPost == null || strHttpPost.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strHttpPost);
    }

    public void a(PlatformActionListener platformActionListener, Platform.ShareParams shareParams) {
        SSDKLog.b().a("Facebook share by primordial appClientShare", new Object[0]);
        Intent intent = new Intent();
        intent.putExtra("TITLE", shareParams.getTitle());
        ShareActivity shareActivity = new ShareActivity();
        shareActivity.setPlatformActionListener(platformActionListener, this.f6385a, shareParams, this.f6127g);
        shareActivity.show(MobSDK.getContext(), intent);
    }
}
