package cn.sharesdk.facebook;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.a.b.j;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.g;
import com.facebook.login.LoginManager;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mob.MobSDK;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class Facebook extends Platform {
    public static final String NAME = "Facebook";
    public static final String PARAMS_HASHTAG = "params_Hashtag";
    public static final String PARAMS_LINKURL = "params_linkurl";
    public static final String PARAMS_QUOTE = "params_Quote";

    /* renamed from: a, reason: collision with root package name */
    private String f6088a;

    /* renamed from: b, reason: collision with root package name */
    private String f6089b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6090c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6091d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6092e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6093f;

    public static class ShareParams extends Platform.ShareParams {
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i6, Object obj) {
        SSDKLog.b().a("Facebook checkAuthorize ");
        SSDKLog.b().a("Facebook checkAuthorize action == " + String.valueOf(i6));
        SSDKLog.b().a("Facebook checkAuthorize shareByAppClient == " + String.valueOf(this.f6090c));
        SSDKLog.b().a("Facebook checkAuthorize isClientValid == " + String.valueOf(this.isClientValid));
        if (i6 == 9 && this.f6090c && this.isClientValid) {
            SSDKLog.b().a("Facebook checkAuthorize ACTION_SHARE return true");
            return true;
        }
        if (i6 == 6) {
            SSDKLog.b().a("Facebook checkAuthorize ACTION_FOLLOWING_USER return true");
            return true;
        }
        if (isAuthValid()) {
            SSDKLog.b().a("Facebook checkAuthorize isAuthValid return true");
            d dVarA = d.a(this);
            dVarA.a(this.f6088a);
            String token = this.db.getToken();
            String strValueOf = String.valueOf(this.db.getExpiresIn());
            if (token != null && strValueOf != null) {
                dVarA.a(token, strValueOf);
                if (dVarA.a()) {
                    return true;
                }
            }
        } else if ((obj instanceof Platform.ShareParams) && ((Platform.ShareParams) obj).getShareType() == 4) {
            SSDKLog.b().a("Facebook checkAuthorize SHARE_WEBPAGE return true");
            return true;
        }
        innerAuthorize(i6, obj);
        SSDKLog.b().a("Facebook checkAuthorize return false");
        return false;
    }

    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        if (!this.f6091d) {
            SSDKLog.b().a("Facebook doAuthorize by origianl");
            final d dVarA = d.a(this);
            dVarA.a(this.f6088a);
            dVarA.b(this.f6089b);
            dVarA.a(strArr);
            dVarA.a(new AuthorizeListener() { // from class: cn.sharesdk.facebook.Facebook.1
                @Override // cn.sharesdk.framework.authorize.AuthorizeListener
                public void onCancel() {
                    if (((Platform) Facebook.this).listener != null) {
                        ((Platform) Facebook.this).listener.onCancel(Facebook.this, 1);
                    }
                    SSDKLog.b().a("Facebook doAuthorize by origianl onCancel ");
                }

                @Override // cn.sharesdk.framework.authorize.AuthorizeListener
                public void onComplete(Bundle bundle) {
                    SSDKLog.b().a("Facebook doAuthorize by origianl onComplete ");
                    String string = bundle.getString("oauth_token");
                    int i6 = bundle.getInt("oauth_token_expires");
                    if (i6 == 0) {
                        try {
                            i6 = ResHelper.parseInt(String.valueOf(bundle.get("expires_in")));
                        } catch (Throwable th) {
                            SSDKLog.b().a(th);
                            i6 = 0;
                        }
                    }
                    if (TextUtils.isEmpty(string)) {
                        string = bundle.getString("access_token");
                    }
                    ((Platform) Facebook.this).db.putToken(string);
                    ((Platform) Facebook.this).db.putExpiresIn(i6);
                    dVarA.a(string, String.valueOf(i6));
                    Facebook.this.afterRegister(1, null);
                }

                @Override // cn.sharesdk.framework.authorize.AuthorizeListener
                public void onError(Throwable th) {
                    if (((Platform) Facebook.this).listener != null) {
                        ((Platform) Facebook.this).listener.onError(Facebook.this, 1, th);
                    }
                    SSDKLog.b().a("Facebook doAuthorize by origianl onError " + th);
                }
            }, isSSODisable());
            return;
        }
        try {
            SSDKLog.b().a("Facebook doAuthorize by official");
            new FacebookOfficialAuth(this.listener, this).show(MobSDK.getContext(), null);
            SSDKLog.b().a("Facebook doAuthorize ");
        } catch (Throwable th) {
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onError(this, 1, th);
            }
            SSDKLog.b().a("Facebook doAuthorize catch: " + th);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void doCustomerProtocol(String str, String str2, int i6, HashMap<String, Object> map, HashMap<String, String> map2) {
        try {
            HashMap<String, Object> mapA = d.a(this).a(str, str2, map, map2);
            if (mapA != null && mapA.size() > 0) {
                if (!mapA.containsKey("error_code") && !mapA.containsKey("error")) {
                    PlatformActionListener platformActionListener = this.listener;
                    if (platformActionListener != null) {
                        platformActionListener.onComplete(this, i6, mapA);
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onError(this, i6, new Throwable(new Hashon().fromHashMap(mapA)));
                    return;
                }
                return;
            }
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(this, i6, new Throwable("response is null"));
            }
        } catch (Throwable th) {
            PlatformActionListener platformActionListener3 = this.listener;
            if (platformActionListener3 != null) {
                platformActionListener3.onError(this, i6, th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:186:0x0560  */
    /* JADX WARN: Removed duplicated region for block: B:206:? A[RETURN, SYNTHETIC] */
    @Override // cn.sharesdk.framework.Platform
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void doShare(final cn.sharesdk.framework.Platform.ShareParams r14) {
        /*
            Method dump skipped, instructions count: 1380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.facebook.Facebook.doShare(cn.sharesdk.framework.Platform$ShareParams):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0235  */
    @Override // cn.sharesdk.framework.Platform
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.HashMap<java.lang.String, java.lang.Object> filterFriendshipInfo(int r24, java.util.HashMap<java.lang.String, java.lang.Object> r25) {
        /*
            Method dump skipped, instructions count: 843
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.facebook.Facebook.filterFriendshipInfo(int, java.util.HashMap):java.util.HashMap");
    }

    @Override // cn.sharesdk.framework.Platform
    public j.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> map) {
        j.a aVar = new j.a();
        aVar.f6309b = shareParams.getText();
        if (map != null) {
            if (map.containsKey(FirebaseAnalytics.Param.SOURCE)) {
                aVar.f6311d.add(String.valueOf(map.get(FirebaseAnalytics.Param.SOURCE)));
            } else if (4 == shareParams.getShareType()) {
                aVar.f6311d.add(shareParams.getImageUrl());
                String titleUrl = shareParams.getTitleUrl();
                if (TextUtils.isEmpty(titleUrl)) {
                    titleUrl = shareParams.getUrl();
                }
                aVar.f6310c.add(titleUrl);
            }
            Object obj = map.get("post_id");
            aVar.f6308a = obj == null ? null : String.valueOf(obj);
            aVar.f6314g = map;
        }
        return aVar;
    }

    @Override // cn.sharesdk.framework.Platform
    public void follow(String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 7);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getBilaterals(int i6, int i7, String str) {
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getFollowers(int i6, int i7, String str) {
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getFollowings(int i6, int i7, String str) {
        try {
            HashMap<String, Object> mapA = d.a(this).a(i6, i7, str);
            if (mapA != null && mapA.size() > 0 && !mapA.containsKey("error_code") && !mapA.containsKey("error")) {
                mapA.put("current_limit", Integer.valueOf(i6));
                mapA.put("current_cursor", Integer.valueOf(i7));
                return filterFriendshipInfo(2, mapA);
            }
            return null;
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            return null;
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void getFriendList(int i6, int i7, String str) {
        try {
            HashMap<String, Object> mapA = d.a(this).a(i6, i7 * i6, str);
            if (mapA != null && mapA.size() > 0) {
                if (!mapA.containsKey("error_code") && !mapA.containsKey("error")) {
                    PlatformActionListener platformActionListener = this.listener;
                    if (platformActionListener != null) {
                        platformActionListener.onComplete(this, 2, mapA);
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onError(this, 2, new Throwable(new Hashon().fromHashMap(mapA)));
                    return;
                }
                return;
            }
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(this, 2, new Throwable("response is null"));
            }
        } catch (Throwable th) {
            PlatformActionListener platformActionListener3 = this.listener;
            if (platformActionListener3 != null) {
                platformActionListener3.onError(this, 2, th);
            }
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public String getName() {
        return NAME;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getPlatformId() {
        return 10;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 2;
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return true;
    }

    @Override // cn.sharesdk.framework.Platform
    public void initDevInfo(String str) {
        this.f6088a = getDevinfo("ConsumerKey");
        this.f6089b = getDevinfo("RedirectUrl");
        this.f6090c = "true".equals(getDevinfo("ShareByAppClient"));
        this.f6092e = "true".equals(getDevinfo("BypassApproval"));
        SSDKLog.b().a("Facebook initDevInfo ShareByAppClient value is: " + getDevinfo("ShareByAppClient"));
        if (TextUtils.isEmpty(getDevinfo("FaceBookAppType"))) {
            this.f6093f = false;
        } else {
            this.f6093f = true;
            SSDKLog.b().a("Facebook AppType is: " + getDevinfo("Official"));
        }
        if (TextUtils.isEmpty(getDevinfo("OfficialVersion"))) {
            this.f6091d = false;
            return;
        }
        this.f6091d = true;
        SSDKLog.b().a("Facebook Official value is: " + getDevinfo("Official"));
    }

    @Override // cn.sharesdk.framework.Platform
    public void isClientValid(ShareSDKCallback<Boolean> shareSDKCallback) {
        try {
            d dVarA = d.a(this);
            dVarA.a(this.f6088a);
            dVarA.a(shareSDKCallback);
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(Boolean.FALSE);
            }
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void removeAccount(boolean z6) {
        super.removeAccount(z6);
        if (this.f6091d) {
            LoginManager.getInstance().logOut();
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
        this.f6088a = getNetworkDevinfo("api_key", "ConsumerKey");
        String networkDevinfo = getNetworkDevinfo("redirect_uri", "RedirectUrl");
        this.f6089b = networkDevinfo;
        if (TextUtils.isEmpty(networkDevinfo)) {
            this.f6089b = "fbconnect://success";
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void timeline(int i6, int i7, String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 7);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void userInfor(String str) {
        String str2;
        Object obj;
        HashMap map;
        Object obj2 = FirebaseAnalytics.Param.END_DATE;
        String str3 = "-";
        try {
            HashMap<String, Object> mapA = d.a(this).a(str, Boolean.valueOf(this.f6093f));
            if (mapA != null && mapA.size() > 0) {
                if (!mapA.containsKey("error_code") && !mapA.containsKey("error")) {
                    if (str == null) {
                        this.db.putUserId(String.valueOf(mapA.get(TtmlNode.ATTR_ID)));
                        PlatformDb platformDb = this.db;
                        Object obj3 = mapA.get(AppMeasurementSdk.ConditionalUserProperty.NAME);
                        Object obj4 = FirebaseAnalytics.Param.START_DATE;
                        platformDb.put("nickname", String.valueOf(obj3));
                        String str4 = "1";
                        this.db.put("gender", "male".equals(String.valueOf(mapA.get("gender"))) ? "0" : "1");
                        this.db.put("token_for_business", (String) mapA.get("token_for_business"));
                        HashMap map2 = mapA.containsKey("picture") ? (HashMap) mapA.get("picture") : null;
                        if (map2 != null && (map = (HashMap) map2.get("data")) != null) {
                            this.db.put("icon", String.valueOf(map.get(ImagesContract.URL)));
                        }
                        try {
                            if (mapA.containsKey("birthday")) {
                                String[] strArrSplit = String.valueOf(mapA.get("birthday")).split(RemoteSettings.FORWARD_SLASH_STRING);
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(1, ResHelper.parseInt(strArrSplit[2]));
                                calendar.set(2, ResHelper.parseInt(strArrSplit[0]) - 1);
                                calendar.set(5, ResHelper.parseInt(strArrSplit[1]));
                                this.db.put("birthday", String.valueOf(calendar.getTimeInMillis()));
                            }
                        } catch (Throwable th) {
                            SSDKLog.b().a(th);
                        }
                        PlatformDb platformDb2 = this.db;
                        if (!"true".equals(String.valueOf(mapA.get("verified")))) {
                            str4 = "0";
                        }
                        platformDb2.put("secretType", str4);
                        this.db.put("snsUserUrl", String.valueOf(mapA.get("link")));
                        this.db.put("resume", String.valueOf(mapA.get("link")));
                        ArrayList arrayList = mapA.containsKey("education") ? (ArrayList) mapA.get("education") : null;
                        if (arrayList != null) {
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                HashMap map3 = (HashMap) it.next();
                                HashMap map4 = new HashMap();
                                map4.put("school_type", 0);
                                HashMap map5 = map3.containsKey("school") ? (HashMap) map3.get("school") : null;
                                if (map5 != null) {
                                    map4.put("school", String.valueOf(map5.get(AppMeasurementSdk.ConditionalUserProperty.NAME)));
                                }
                                try {
                                    map4.put("year", Integer.valueOf(ResHelper.parseInt(String.valueOf((map3.containsKey("year") ? (HashMap) map3.get("year") : null).get(AppMeasurementSdk.ConditionalUserProperty.NAME)))));
                                } catch (Throwable th2) {
                                    SSDKLog.b().a(th2);
                                }
                                map4.put("background", 0);
                                arrayList2.add(map4);
                            }
                            HashMap map6 = new HashMap();
                            map6.put("list", arrayList2);
                            String strFromHashMap = new Hashon().fromHashMap(map6);
                            this.db.put("educationJSONArrayStr", strFromHashMap.substring(8, strFromHashMap.length() - 1));
                        }
                        ArrayList arrayList3 = mapA.containsKey("work") ? (ArrayList) mapA.get("work") : null;
                        if (arrayList3 != null) {
                            ArrayList arrayList4 = new ArrayList();
                            Iterator it2 = arrayList3.iterator();
                            while (it2.hasNext()) {
                                HashMap map7 = (HashMap) it2.next();
                                HashMap map8 = new HashMap();
                                HashMap map9 = (HashMap) map7.get("employer");
                                if (map9 != null) {
                                    map8.put("company", String.valueOf(map9.get(AppMeasurementSdk.ConditionalUserProperty.NAME)));
                                }
                                HashMap map10 = (HashMap) map7.get("position");
                                if (map10 != null) {
                                    map8.put("position", String.valueOf(map10.get(AppMeasurementSdk.ConditionalUserProperty.NAME)));
                                }
                                Object obj5 = obj4;
                                try {
                                    str2 = str3;
                                    try {
                                        String[] strArrSplit2 = String.valueOf(map7.get(obj5)).split(str2);
                                        map8.put(obj5, Integer.valueOf((ResHelper.parseInt(strArrSplit2[0]) * 100) + ResHelper.parseInt(strArrSplit2[1])));
                                    } catch (Throwable th3) {
                                        th = th3;
                                        SSDKLog.b().a(th);
                                        obj = obj2;
                                        String[] strArrSplit3 = String.valueOf(map7.get(obj)).split(str2);
                                        map8.put(obj, Integer.valueOf((ResHelper.parseInt(strArrSplit3[0]) * 100) + ResHelper.parseInt(strArrSplit3[1])));
                                        arrayList4.add(map8);
                                        obj4 = obj5;
                                        str3 = str2;
                                        obj2 = obj;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    str2 = str3;
                                }
                                obj = obj2;
                                try {
                                    String[] strArrSplit32 = String.valueOf(map7.get(obj)).split(str2);
                                    map8.put(obj, Integer.valueOf((ResHelper.parseInt(strArrSplit32[0]) * 100) + ResHelper.parseInt(strArrSplit32[1])));
                                } catch (Throwable th5) {
                                    SSDKLog.b().a(th5);
                                    map8.put(obj, 0);
                                }
                                arrayList4.add(map8);
                                obj4 = obj5;
                                str3 = str2;
                                obj2 = obj;
                            }
                            HashMap map11 = new HashMap();
                            map11.put("list", arrayList4);
                            String strFromHashMap2 = new Hashon().fromHashMap(map11);
                            this.db.put("workJSONArrayStr", strFromHashMap2.substring(8, strFromHashMap2.length() - 1));
                        }
                    }
                    PlatformActionListener platformActionListener = this.listener;
                    if (platformActionListener != null) {
                        platformActionListener.onComplete(this, 8, mapA);
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onError(this, 8, new Throwable(new Hashon().fromHashMap(mapA)));
                    return;
                }
                return;
            }
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(this, 8, new Throwable("response is null"));
            }
        } catch (Throwable th6) {
            PlatformActionListener platformActionListener3 = this.listener;
            if (platformActionListener3 != null) {
                platformActionListener3.onError(this, 8, th6);
            }
        }
    }

    private void a(Platform platform, Platform.ShareParams shareParams, PlatformActionListener platformActionListener) {
        try {
            g gVar = new g();
            gVar.a("com.facebook.katana", "com.facebook.composer.shareintent.ImplicitShareIntentHandlerDefaultAlias");
            if (shareParams.getShareType() == 6) {
                if (TextUtils.isEmpty(shareParams.getFilePath())) {
                    if (platformActionListener != null) {
                        platformActionListener.onError(platform, 9, new Throwable("Share type is VIDEO, But FilePath is null"));
                        return;
                    }
                    return;
                }
                gVar.a(shareParams.getFilePath(), platform, platformActionListener);
            } else {
                gVar.a(shareParams, platform);
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("ShareParams", shareParams);
            platformActionListener.onComplete(platform, 9, map);
        } catch (Throwable th) {
            if (platformActionListener != null) {
                platformActionListener.onError(platform, 9, th);
            }
            SSDKLog.b().a(th, "Facebook share byPassShare catch ", new Object[0]);
        }
    }
}
