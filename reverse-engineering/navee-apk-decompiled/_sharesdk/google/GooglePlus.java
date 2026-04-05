package cn.sharesdk.google;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.a.b.j;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.MobSDK;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class GooglePlus extends Platform {
    public static final String NAME = "GooglePlus";

    /* renamed from: a, reason: collision with root package name */
    private a f6489a = a.a(this);

    /* renamed from: b, reason: collision with root package name */
    private String f6490b;

    /* renamed from: c, reason: collision with root package name */
    private String f6491c;

    /* renamed from: d, reason: collision with root package name */
    private String f6492d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6493e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6494f;

    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i6, Object obj) {
        if (i6 == 9) {
            return true;
        }
        if (super.isAuthValid()) {
            this.f6489a.a(this.f6490b, this.f6492d);
            this.f6489a.a(this.f6491c);
            this.f6489a.c(this.db.getToken());
            String token = this.db.getToken();
            if (!TextUtils.isEmpty(token)) {
                this.f6489a.c(token);
                return true;
            }
        } else if (this.isClientValid && this.db.get("isSigin").equals("true")) {
            return true;
        }
        innerAuthorize(i6, obj);
        return false;
    }

    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        if (!this.isClientValid || isSSODisable()) {
            doWebAuthorize(strArr);
            return;
        }
        if (!this.f6494f) {
            this.f6489a.a(strArr, new PlatformActionListener() { // from class: cn.sharesdk.google.GooglePlus.1
                @Override // cn.sharesdk.framework.PlatformActionListener
                public void onCancel(Platform platform, int i6) {
                    if (((Platform) GooglePlus.this).listener != null) {
                        ((Platform) GooglePlus.this).listener.onCancel(platform, i6);
                    }
                    GooglePlus.this.f6489a.c();
                }

                @Override // cn.sharesdk.framework.PlatformActionListener
                public void onComplete(Platform platform, int i6, HashMap<String, Object> map) {
                    try {
                        String str = map.containsKey("DisplayName") ? (String) map.get("DisplayName") : "";
                        String str2 = map.containsKey("image") ? (String) map.get("image") : "";
                        String strValueOf = map.containsKey("gender") ? String.valueOf(map.get("gender")) : "";
                        String str3 = map.containsKey(ImagesContract.URL) ? (String) map.get(ImagesContract.URL) : "";
                        String str4 = map.containsKey("birthday") ? (String) map.get("birthday") : "";
                        GooglePlus.this.a(map, "Tagline");
                        GooglePlus.this.a(map, "isVerified");
                        GooglePlus.this.a(map, "Language");
                        GooglePlus.this.a(map, "Emails");
                        ((Platform) GooglePlus.this).db.putUserId((String) map.get(TtmlNode.ATTR_ID));
                        ((Platform) GooglePlus.this).db.put("nickname", str);
                        ((Platform) GooglePlus.this).db.put("icon", str2);
                        ((Platform) GooglePlus.this).db.put("gender", strValueOf);
                        ((Platform) GooglePlus.this).db.put("snsUserUrl", str3);
                        ((Platform) GooglePlus.this).db.put("birthday", str4);
                        ((Platform) GooglePlus.this).db.put("isSigin", "true");
                        if (((Platform) GooglePlus.this).listener != null) {
                            ((Platform) GooglePlus.this).listener.onComplete(platform, i6, map);
                        }
                        GooglePlus.this.f6489a.c();
                    } catch (Throwable th) {
                        SSDKLog.b().a("Googleplus doAuthorize() onComplete catch" + th, new Object[0]);
                    }
                }

                @Override // cn.sharesdk.framework.PlatformActionListener
                public void onError(Platform platform, int i6, Throwable th) {
                    if (((Platform) GooglePlus.this).listener != null) {
                        ((Platform) GooglePlus.this).listener.onError(platform, i6, th);
                    }
                    GooglePlus.this.f6489a.c();
                }
            }, this.db);
            return;
        }
        try {
            new GoogleOfficialHelper(this.listener, this).show(MobSDK.getContext(), null);
        } catch (Throwable th) {
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onError(this, 1, th);
            }
            SSDKLog.b().a("Googleplus GoogleOfficialHelper catch: " + th, new Object[0]);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void doCustomerProtocol(String str, String str2, int i6, HashMap<String, Object> map, HashMap<String, String> map2) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, i6);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void doShare(Platform.ShareParams shareParams) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 9);
        }
    }

    public void doWebAuthorize(String[] strArr) {
        this.f6489a.a(this.f6490b, this.f6492d);
        this.f6489a.a(this.f6491c);
        this.f6489a.a(strArr);
        this.f6489a.a(new AuthorizeListener() { // from class: cn.sharesdk.google.GooglePlus.2
            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onCancel() {
                if (((Platform) GooglePlus.this).listener != null) {
                    ((Platform) GooglePlus.this).listener.onCancel(GooglePlus.this, 1);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onComplete(Bundle bundle) {
                long j6;
                String string = bundle.getString("access_token");
                String string2 = bundle.getString("expires_in");
                String string3 = bundle.getString("token_type");
                String string4 = bundle.getString("refresh_token");
                String string5 = bundle.getString("id_token");
                ((Platform) GooglePlus.this).db.putToken(string);
                ((Platform) GooglePlus.this).db.put("token_type", string3);
                ((Platform) GooglePlus.this).db.put("refresh_token", string4);
                ((Platform) GooglePlus.this).db.put("id_token", string5);
                try {
                    j6 = ResHelper.parseLong(string2);
                } catch (Throwable unused) {
                    j6 = 0;
                }
                ((Platform) GooglePlus.this).db.putExpiresIn(j6);
                GooglePlus.this.f6489a.c(string);
                GooglePlus.this.afterRegister(1, null);
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onError(Throwable th) {
                if (((Platform) GooglePlus.this).listener != null) {
                    ((Platform) GooglePlus.this).listener.onError(GooglePlus.this, 1, th);
                }
            }
        });
    }

    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> filterFriendshipInfo(int i6, HashMap<String, Object> map) {
        Object obj;
        ArrayList arrayList;
        Iterator it;
        boolean z6;
        HashMap<String, Object> map2 = new HashMap<>();
        HashMap map3 = null;
        if (i6 == 2) {
            map2.put("type", "FOLLOWING");
        } else if (i6 == 10) {
            map2.put("type", "FRIENDS");
        } else {
            if (i6 != 11) {
                return null;
            }
            map2.put("type", "FOLLOWERS");
        }
        map2.put("snsplat", Integer.valueOf(getPlatformId()));
        map2.put("snsuid", this.db.getUserId());
        if (Integer.parseInt(String.valueOf(map.get("totalItems"))) == 0 || (obj = map.get(FirebaseAnalytics.Param.ITEMS)) == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = (ArrayList) obj;
        if (arrayList3.size() <= 0) {
            return null;
        }
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            HashMap map4 = (HashMap) it2.next();
            if (map4 != null) {
                HashMap map5 = new HashMap();
                map5.put("snsuid", String.valueOf(map4.get(TtmlNode.ATTR_ID)));
                map5.put("nickname", String.valueOf(map4.get("displayName")));
                HashMap map6 = map4.containsKey("image") ? (HashMap) map4.get("image") : map3;
                if (map6 != null) {
                    map5.put("icon", String.valueOf(map6.get(ImagesContract.URL)));
                }
                if (String.valueOf(map4.get("verified")).equals("true")) {
                    map5.put("secretType", "1");
                } else {
                    map5.put("secretType", "0");
                }
                if (String.valueOf(map4.get("gender")).equals("male")) {
                    map5.put("gender", "0");
                } else {
                    map5.put("gender", "1");
                }
                map5.put("snsUserUrl", String.valueOf(map4.get(ImagesContract.URL)));
                map5.put("resume", String.valueOf(map4.get("aboutMe")));
                if (map4.containsKey("birthday")) {
                    try {
                        String[] strArrSplit = String.valueOf(map4.get("birthday")).split("-");
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(1, ResHelper.parseInt(strArrSplit[0]));
                        calendar.set(2, ResHelper.parseInt(strArrSplit[1]) - 1);
                        calendar.set(5, ResHelper.parseInt(strArrSplit[2]));
                        map5.put("birthday", String.valueOf(calendar.getTimeInMillis()));
                    } catch (Throwable th) {
                        SSDKLog.b().a("Googleplus userInfo get birthday catch", new Object[0]);
                        SSDKLog.b().a(th);
                    }
                }
                if (map4.containsKey("organizations") && (arrayList = (ArrayList) map4.get("organizations")) != null && arrayList.size() > 0) {
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        HashMap map7 = (HashMap) it3.next();
                        String str = (String) map7.get("type");
                        if (Pattern.compile("school|college|university").matcher(str.toLowerCase()).find()) {
                            HashMap map8 = new HashMap();
                            z6 = false;
                            it = it3;
                            map8.put("school_type", 0);
                            map8.put("school", String.valueOf(map7.get(AppMeasurementSdk.ConditionalUserProperty.NAME)));
                            map8.put("background", 0);
                            arrayList4.add(map8);
                        } else {
                            it = it3;
                            z6 = false;
                            if (Pattern.compile("work|company|firm|enterprise").matcher(str.toLowerCase()).find()) {
                                HashMap map9 = new HashMap();
                                map9.put("company", String.valueOf(map7.get(AppMeasurementSdk.ConditionalUserProperty.NAME)));
                                map9.put("dept", String.valueOf(map7.get("department")));
                                map9.put("position", String.valueOf(map7.get("title")));
                                arrayList5.add(map9);
                            }
                        }
                        it3 = it;
                    }
                    if (arrayList4.size() > 0) {
                        HashMap map10 = new HashMap();
                        map10.put("list", arrayList4);
                        String strFromHashMap = new Hashon().fromHashMap(map10);
                        map5.put("educationJSONArrayStr", strFromHashMap.substring(8, strFromHashMap.length() - 1));
                    }
                    if (arrayList5.size() > 0) {
                        HashMap map11 = new HashMap();
                        map11.put("list", arrayList5);
                        String strFromHashMap2 = new Hashon().fromHashMap(map11);
                        map5.put("workJSONArrayStr", strFromHashMap2.substring(8, strFromHashMap2.length() - 1));
                    }
                }
                arrayList2.add(map5);
                map3 = null;
            }
        }
        if (arrayList2.size() <= 0) {
            return null;
        }
        if (2 == i6) {
            map2.put("nextPageToken", map.get("nextPageToken"));
        }
        map2.put("list", arrayList2);
        return map2;
    }

    @Override // cn.sharesdk.framework.Platform
    public j.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> map) {
        j.a aVar = new j.a();
        aVar.f6309b = shareParams.getText();
        String imagePath = shareParams.getImagePath();
        String imageUrl = shareParams.getImageUrl();
        if (!TextUtils.isEmpty(imagePath)) {
            aVar.f6312e.add(imagePath);
        } else if (!TextUtils.isEmpty(imageUrl)) {
            aVar.f6311d.add(imageUrl);
        }
        return aVar;
    }

    @Override // cn.sharesdk.framework.Platform
    public void follow(String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 6);
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
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    public void getFriendList(int i6, int i7, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.db.getUserId();
        }
        if (TextUtils.isEmpty(str)) {
            str = "me";
        }
        try {
            HashMap<String, Object> mapE = this.f6489a.e(str);
            if (mapE == null) {
                PlatformActionListener platformActionListener = this.listener;
                if (platformActionListener != null) {
                    platformActionListener.onError(this, 2, new Throwable());
                    return;
                }
                return;
            }
            if (!mapE.containsKey("error_code") || ((Integer) mapE.get("error_code")).intValue() == 0) {
                PlatformActionListener platformActionListener2 = this.listener;
                if (platformActionListener2 != null) {
                    platformActionListener2.onComplete(this, 2, mapE);
                    return;
                }
                return;
            }
            if (this.listener != null) {
                this.listener.onError(this, 2, new Throwable(new Hashon().fromHashMap(mapE)));
            }
        } catch (Throwable th) {
            this.listener.onError(this, 2, th);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public String getName() {
        return NAME;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getPlatformId() {
        return 14;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 1;
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return false;
    }

    @Override // cn.sharesdk.framework.Platform
    public void initDevInfo(String str) {
        this.f6490b = getDevinfo("ClientID");
        this.f6491c = getDevinfo("RedirectUrl");
        this.f6492d = getDevinfo("AppSecret");
        this.f6493e = "true".equals(getDevinfo("ShareByAppClient"));
        if (TextUtils.isEmpty(getDevinfo("OfficialVersion"))) {
            this.f6494f = false;
            return;
        }
        this.f6494f = true;
        SSDKLog.b().a("Googleplus Official value: " + getDevinfo("Official"));
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean isAuthValid() {
        if (super.isAuthValid()) {
            return true;
        }
        return this.isClientValid && this.db.get("isSigin").equals("true");
    }

    @Override // cn.sharesdk.framework.Platform
    public void isClientValid(ShareSDKCallback<Boolean> shareSDKCallback) {
        try {
            c.a(shareSDKCallback);
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
        try {
            this.db.put("isSigin", "false");
            if (this.f6494f) {
                new b().a();
            } else {
                this.f6489a.a();
            }
        } catch (Throwable th) {
            SSDKLog.b().a("Googleplus removeAccount catch", new Object[0]);
            SSDKLog.b().a(th);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
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
        String str3;
        Object obj;
        Object obj2;
        Object obj3;
        String str4;
        String str5;
        Object obj4;
        if (this.isClientValid && this.db.get("isSigin").equals("true")) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("DisplayName", this.db.get("nickname"));
            map.put("image", this.db.get("icon"));
            map.put("gender", this.db.get("gender"));
            map.put(ImagesContract.URL, this.db.get("snsUserUrl"));
            map.put("birthday", this.db.get("birthday"));
            map.put(TtmlNode.ATTR_ID, this.db.getUserId());
            map.put("token", this.db.getToken());
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onComplete(this, 8, map);
                return;
            }
            return;
        }
        if (this.f6494f && this.isClientValid && !isSSODisable()) {
            String str6 = this.db.get("nickname");
            String str7 = this.db.get("email");
            str5 = "birthday";
            String str8 = this.db.get("family_name");
            obj = "true";
            String str9 = this.db.get("given_name");
            str2 = "snsUserUrl";
            str4 = "gender";
            String str10 = this.db.get("requestedScopes");
            str3 = "icon";
            String str11 = this.db.get("picture");
            obj2 = ImagesContract.URL;
            String userId = this.db.getUserId();
            obj3 = "image";
            HashMap<String, Object> map2 = new HashMap<>();
            map2.put("nickname", str6);
            map2.put("email", str7);
            map2.put("family_name", str8);
            map2.put("given_name", str9);
            map2.put("requestedScopes", str10);
            map2.put("picture", str11);
            map2.put(TtmlNode.ATTR_ID, userId);
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onComplete(this, 8, map2);
                return;
            }
        } else {
            str2 = "snsUserUrl";
            str3 = "icon";
            obj = "true";
            obj2 = ImagesContract.URL;
            obj3 = "image";
            str4 = "gender";
            str5 = "birthday";
        }
        String userId2 = TextUtils.isEmpty(str) ? this.db.getUserId() : str;
        if (TextUtils.isEmpty(userId2)) {
            userId2 = "me";
        }
        try {
            HashMap<String, Object> mapD = this.f6489a.d(userId2);
            if (mapD == null || mapD.size() <= 0) {
                return;
            }
            this.db.putUserId(String.valueOf(mapD.get(TtmlNode.ATTR_ID)));
            this.db.put("nickname", String.valueOf(mapD.get("displayName")));
            Object obj5 = obj3;
            HashMap map3 = mapD.containsKey(obj5) ? (HashMap) mapD.get(obj5) : null;
            if (map3 != null) {
                obj4 = obj2;
                this.db.put(str3, String.valueOf(map3.get(obj4)));
            } else {
                obj4 = obj2;
            }
            String str12 = str4;
            this.db.put(str12, "male".equals(String.valueOf(mapD.get(str12))) ? "0" : "1");
            this.db.put(str2, String.valueOf(mapD.get(obj4)));
            this.db.put("resume", String.valueOf(mapD.get("aboutMe")));
            if (String.valueOf(mapD.get("verified")).equals(obj)) {
                this.db.put("secretType", "1");
            } else {
                this.db.put("secretType", "0");
            }
            String str13 = str5;
            if (mapD.containsKey(str13) && mapD.get(str13) != null) {
                try {
                    String[] strArrSplit = String.valueOf(mapD.get(str13)).split("-");
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(1, ResHelper.parseInt(strArrSplit[0]));
                    calendar.set(2, ResHelper.parseInt(strArrSplit[1]) - 1);
                    calendar.set(5, ResHelper.parseInt(strArrSplit[2]));
                    this.db.put(str13, String.valueOf(calendar.getTimeInMillis()));
                } catch (Throwable th) {
                    SSDKLog.b().a("Googleplus userInfo catct ", new Object[0]);
                    SSDKLog.b().a(th);
                }
            }
            if (mapD.containsKey("organizations")) {
                try {
                    ArrayList arrayList = (ArrayList) mapD.get("organizations");
                    if (arrayList != null && arrayList.size() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            HashMap map4 = (HashMap) it.next();
                            String str14 = (String) map4.get("type");
                            if (Pattern.compile("school|college|university").matcher(str14.toLowerCase()).find()) {
                                HashMap map5 = new HashMap();
                                map5.put("school_type", 0);
                                map5.put("school", String.valueOf(map4.get(AppMeasurementSdk.ConditionalUserProperty.NAME)));
                                map5.put("background", 0);
                                arrayList2.add(map5);
                            } else if (Pattern.compile("work|company|firm|enterprise").matcher(str14.toLowerCase()).find()) {
                                HashMap map6 = new HashMap();
                                map6.put("company", String.valueOf(map4.get(AppMeasurementSdk.ConditionalUserProperty.NAME)));
                                map6.put("dept", String.valueOf(map4.get("department")));
                                map6.put("position", String.valueOf(map4.get("title")));
                                arrayList3.add(map6);
                            }
                        }
                        if (arrayList2.size() > 0) {
                            HashMap map7 = new HashMap();
                            map7.put("list", arrayList2);
                            String strFromHashMap = new Hashon().fromHashMap(map7);
                            this.db.put("educationJSONArrayStr", strFromHashMap.substring(8, strFromHashMap.length() - 1));
                        }
                        if (arrayList3.size() > 0) {
                            HashMap map8 = new HashMap();
                            map8.put("list", arrayList3);
                            String strFromHashMap2 = new Hashon().fromHashMap(map8);
                            this.db.put("workJSONArrayStr", strFromHashMap2.substring(8, strFromHashMap2.length() - 1));
                        }
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a("Googleplus userInfo get organizations catch", new Object[0]);
                    SSDKLog.b().a(th2);
                }
            }
            if (mapD.containsKey("sub")) {
                this.db.putUserId(String.valueOf(mapD.get("sub")));
            }
            if (mapD.containsKey("email_verified")) {
                this.db.put("email_verified", String.valueOf(mapD.get("email_verified")));
            }
            if (mapD.containsKey(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                this.db.put(AppMeasurementSdk.ConditionalUserProperty.NAME, String.valueOf(mapD.get(AppMeasurementSdk.ConditionalUserProperty.NAME)));
            }
            if (mapD.containsKey("given_name")) {
                this.db.put("given_name", String.valueOf(mapD.get("given_name")));
            }
            if (mapD.containsKey("locale")) {
                this.db.put("locale", String.valueOf(mapD.get("locale")));
            }
            if (mapD.containsKey("family_name")) {
                this.db.put("family_name", String.valueOf(mapD.get("family_name")));
            }
            if (mapD.containsKey("picture")) {
                this.db.put("picture", String.valueOf(mapD.get("picture")));
            }
            if (mapD.containsKey("email")) {
                this.db.put("email", String.valueOf(mapD.get("email")));
            }
            PlatformActionListener platformActionListener3 = this.listener;
            if (platformActionListener3 != null) {
                platformActionListener3.onComplete(this, 8, mapD);
            }
        } catch (Throwable th3) {
            PlatformActionListener platformActionListener4 = this.listener;
            if (platformActionListener4 != null) {
                platformActionListener4.onError(this, 8, th3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HashMap<String, Object> map, String str) {
        if (map.containsKey(str)) {
            String strValueOf = String.valueOf(map.get(str));
            if (TextUtils.isEmpty(strValueOf)) {
                return;
            }
            this.db.put(str, strValueOf);
        }
    }
}
