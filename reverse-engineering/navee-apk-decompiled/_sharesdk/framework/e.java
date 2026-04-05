package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.a.b.j;
import cn.sharesdk.framework.utils.SSDKLog;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.HashonHelper;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class e implements PlatformActionListener {

    /* renamed from: c, reason: collision with root package name */
    private PlatformActionListener f6374c;

    /* renamed from: e, reason: collision with root package name */
    private int f6376e;

    /* renamed from: a, reason: collision with root package name */
    Pattern f6372a = Pattern.compile("(?:errorCode|code|errCode|error_code)\\s*[=:]\\s*(\\d+)", 2);

    /* renamed from: b, reason: collision with root package name */
    Pattern f6373b = Pattern.compile("(?:errorMsg|msg|errorMessage|errMsg|errStr|errorDesc|message)\\s*[=:]\\s*([^,\\n]+)", 2);

    /* renamed from: d, reason: collision with root package name */
    private HashMap<Platform, Platform.ShareParams> f6375d = new HashMap<>();

    private void b(Platform platform, int i6, HashMap<String, Object> map) {
        HashMap<String, Object> map2;
        Platform platform2;
        Platform.ShareParams shareParamsRemove = this.f6375d.remove(platform);
        if (map != null) {
            shareParamsRemove = (Platform.ShareParams) map.remove("ShareParams");
        }
        try {
            map2 = (HashMap) map.clone();
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            map2 = map;
        }
        if (shareParamsRemove != null) {
            cn.sharesdk.framework.a.b.j jVar = new cn.sharesdk.framework.a.b.j();
            jVar.f6307p = shareParamsRemove.getCustomFlag();
            String userId = platform.getDb().getUserId();
            if (("WechatMoments".equals(platform.getName()) || "WechatFavorite".equals(platform.getName())) && TextUtils.isEmpty(userId)) {
                try {
                    platform2 = ShareSDK.getPlatform("Wechat");
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "InnerPlatformActionListener wechat is null", new Object[0]);
                    platform2 = null;
                }
                if (platform2 != null) {
                    userId = platform2.getDb().getUserId();
                }
            } else if ("TencentWeibo".equals(platform.getName())) {
                userId = platform.getDb().get(AppMeasurementSdk.ConditionalUserProperty.NAME);
            }
            jVar.f6303b = userId;
            jVar.f6302a = platform.getPlatformId();
            String strFilterShareContent = platform.filterShareContent(shareParamsRemove);
            if (TextUtils.isEmpty(strFilterShareContent)) {
                j.a aVarFilterShareContent = platform.filterShareContent(shareParamsRemove, map2);
                if (aVarFilterShareContent != null) {
                    jVar.f6304c = aVarFilterShareContent.f6308a;
                    jVar.f6305d = aVarFilterShareContent;
                }
            } else {
                try {
                    jVar.f6305d = (j.a) HashonHelper.fromJson(strFilterShareContent, j.a.class);
                } catch (Throwable th3) {
                    SSDKLog.b().a(th3);
                }
            }
            jVar.f6306o = b(platform);
            cn.sharesdk.framework.a.d dVarA = cn.sharesdk.framework.a.d.a();
            if (dVarA != null) {
                dVarA.a(jVar);
            }
        }
        PlatformActionListener platformActionListener = this.f6374c;
        if (platformActionListener != null) {
            try {
                platformActionListener.onComplete(platform, i6, map);
                this.f6374c = null;
                this.f6376e = 0;
            } catch (Throwable th4) {
                SSDKLog.b().a(th4);
            }
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onCancel(Platform platform, int i6) {
        try {
            a(2, i6, platform, null);
        } catch (Throwable th) {
            SSDKLog.b().a(th);
        }
        PlatformActionListener platformActionListener = this.f6374c;
        if (platformActionListener != null) {
            platformActionListener.onCancel(platform, i6);
            this.f6374c = null;
            this.f6376e = 0;
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onComplete(Platform platform, int i6, HashMap<String, Object> map) {
        if (platform instanceof CustomPlatform) {
            PlatformActionListener platformActionListener = this.f6374c;
            if (platformActionListener != null) {
                platformActionListener.onComplete(platform, i6, map);
                this.f6374c = null;
                this.f6376e = 0;
                return;
            }
            return;
        }
        if (i6 == 1) {
            a(platform, i6, map);
            return;
        }
        if (i6 == 9) {
            b(platform, i6, map);
            return;
        }
        PlatformActionListener platformActionListener2 = this.f6374c;
        if (platformActionListener2 != null) {
            platformActionListener2.onComplete(platform, i6, map);
            if ("Wechat".equals(platform.getName())) {
                return;
            }
            int i7 = this.f6376e;
            if (i7 == 0 || i7 == i6) {
                this.f6374c = null;
                this.f6376e = 0;
            }
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onError(Platform platform, int i6, Throwable th) {
        try {
            a(1, i6, platform, th);
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
        }
        PlatformActionListener platformActionListener = this.f6374c;
        if (platformActionListener != null) {
            platformActionListener.onError(platform, i6, th);
            this.f6374c = null;
            this.f6376e = 0;
        }
    }

    public void a(PlatformActionListener platformActionListener) {
        this.f6374c = platformActionListener;
    }

    public PlatformActionListener a() {
        return this.f6374c;
    }

    public void a(Platform platform, Platform.ShareParams shareParams) {
        this.f6375d.put(platform, shareParams);
    }

    private void a(int i6, int i7, Platform platform, Throwable th) {
        cn.sharesdk.framework.a.b.d bVar = null;
        cn.sharesdk.framework.a.b.j hVar = null;
        cn.sharesdk.framework.a.b.d dVar = null;
        if (i7 == 1) {
            if (i6 == 1) {
                bVar = new cn.sharesdk.framework.a.b.c();
            } else if (i6 == 2) {
                bVar = new cn.sharesdk.framework.a.b.b();
            }
            a(bVar, platform);
            dVar = bVar;
        } else if (i7 == 9) {
            if (i6 == 1) {
                hVar = new cn.sharesdk.framework.a.b.i();
            } else if (i6 == 2) {
                hVar = new cn.sharesdk.framework.a.b.h();
            }
            a(hVar, platform);
            dVar = hVar;
        }
        if (dVar == null || cn.sharesdk.framework.a.d.a() == null) {
            return;
        }
        if (th != null) {
            String string = TextUtils.isEmpty(th.getMessage()) ? th.toString() : th.getMessage();
            dVar.f6290m = a(string);
            dVar.f6291n = b(string);
        }
        cn.sharesdk.framework.a.d.a().a(dVar);
    }

    private void a(cn.sharesdk.framework.a.b.d dVar, Platform platform) {
        try {
            dVar.f6278a = platform.getPlatformId();
            dVar.f6279b = "TencentWeibo".equals(platform.getName()) ? platform.getDb().get(AppMeasurementSdk.ConditionalUserProperty.NAME) : platform.getDb().getUserId();
            dVar.f6281d = a(platform);
        } catch (Throwable th) {
            SSDKLog.b().a(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0048 A[Catch: all -> 0x0021, TryCatch #1 {all -> 0x0021, blocks: (B:2:0x0000, B:4:0x0014, B:16:0x0048, B:18:0x0054, B:19:0x005e, B:21:0x0076, B:27:0x009a, B:29:0x00a5, B:26:0x0092, B:9:0x0024, B:15:0x003b, B:23:0x0086, B:11:0x002a, B:13:0x0032), top: B:35:0x0000, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(cn.sharesdk.framework.a.b.j r5, cn.sharesdk.framework.Platform r6) {
        /*
            r4 = this;
            cn.sharesdk.framework.PlatformDb r0 = r6.getDb()     // Catch: java.lang.Throwable -> L21
            java.lang.String r0 = r0.getUserId()     // Catch: java.lang.Throwable -> L21
            java.lang.String r1 = "WechatMoments"
            java.lang.String r2 = r6.getName()     // Catch: java.lang.Throwable -> L21
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L21
            if (r1 != 0) goto L24
            java.lang.String r1 = "WechatFavorite"
            java.lang.String r2 = r6.getName()     // Catch: java.lang.Throwable -> L21
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L21
            if (r1 == 0) goto L48
            goto L24
        L21:
            r5 = move-exception
            goto Lac
        L24:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L21
            if (r1 == 0) goto L48
            java.lang.String r1 = "Wechat"
            cn.sharesdk.framework.Platform r1 = cn.sharesdk.framework.ShareSDK.getPlatform(r1)     // Catch: java.lang.Throwable -> L3b
            if (r1 == 0) goto L5e
            cn.sharesdk.framework.PlatformDb r1 = r1.getDb()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r0 = r1.getUserId()     // Catch: java.lang.Throwable -> L3b
            goto L5e
        L3b:
            cn.sharesdk.framework.utils.SSDKLog r1 = cn.sharesdk.framework.utils.SSDKLog.b()     // Catch: java.lang.Throwable -> L21
            java.lang.String r2 = "InnerPlatformActionListener wechat is null"
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L21
            r1.a(r2, r3)     // Catch: java.lang.Throwable -> L21
            goto L5e
        L48:
            java.lang.String r1 = "TencentWeibo"
            java.lang.String r2 = r6.getName()     // Catch: java.lang.Throwable -> L21
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L21
            if (r1 == 0) goto L5e
            cn.sharesdk.framework.PlatformDb r0 = r6.getDb()     // Catch: java.lang.Throwable -> L21
            java.lang.String r1 = "name"
            java.lang.String r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L21
        L5e:
            int r1 = r6.getPlatformId()     // Catch: java.lang.Throwable -> L21
            r5.f6302a = r1     // Catch: java.lang.Throwable -> L21
            r5.f6303b = r0     // Catch: java.lang.Throwable -> L21
            java.lang.String r0 = r4.b(r6)     // Catch: java.lang.Throwable -> L21
            r5.f6306o = r0     // Catch: java.lang.Throwable -> L21
            java.util.HashMap<cn.sharesdk.framework.Platform, cn.sharesdk.framework.Platform$ShareParams> r0 = r4.f6375d     // Catch: java.lang.Throwable -> L21
            java.lang.Object r0 = r0.remove(r6)     // Catch: java.lang.Throwable -> L21
            cn.sharesdk.framework.Platform$ShareParams r0 = (cn.sharesdk.framework.Platform.ShareParams) r0     // Catch: java.lang.Throwable -> L21
            if (r0 == 0) goto Lb3
            java.lang.String[] r1 = r0.getCustomFlag()     // Catch: java.lang.Throwable -> L21
            r5.f6307p = r1     // Catch: java.lang.Throwable -> L21
            java.lang.String r1 = r6.filterShareContent(r0)     // Catch: java.lang.Throwable -> L21
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L21
            if (r2 != 0) goto L9a
            java.lang.Class<cn.sharesdk.framework.a.b.j$a> r6 = cn.sharesdk.framework.a.b.j.a.class
            java.lang.Object r6 = com.mob.tools.utils.HashonHelper.fromJson(r1, r6)     // Catch: java.lang.Throwable -> L91
            cn.sharesdk.framework.a.b.j$a r6 = (cn.sharesdk.framework.a.b.j.a) r6     // Catch: java.lang.Throwable -> L91
            r5.f6305d = r6     // Catch: java.lang.Throwable -> L91
            goto Lb3
        L91:
            r5 = move-exception
            cn.sharesdk.framework.utils.SSDKLog r6 = cn.sharesdk.framework.utils.SSDKLog.b()     // Catch: java.lang.Throwable -> L21
            r6.a(r5)     // Catch: java.lang.Throwable -> L21
            goto Lb3
        L9a:
            java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L21
            r1.<init>()     // Catch: java.lang.Throwable -> L21
            cn.sharesdk.framework.a.b.j$a r6 = r6.filterShareContent(r0, r1)     // Catch: java.lang.Throwable -> L21
            if (r6 == 0) goto Lb3
            java.lang.String r0 = r6.f6308a     // Catch: java.lang.Throwable -> L21
            r5.f6304c = r0     // Catch: java.lang.Throwable -> L21
            r5.f6305d = r6     // Catch: java.lang.Throwable -> L21
            goto Lb3
        Lac:
            cn.sharesdk.framework.utils.SSDKLog r6 = cn.sharesdk.framework.utils.SSDKLog.b()
            r6.a(r5)
        Lb3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.e.a(cn.sharesdk.framework.a.b.j, cn.sharesdk.framework.Platform):void");
    }

    private String b(Platform platform) {
        Platform platform2;
        PlatformDb db = platform.getDb();
        if (("WechatMoments".equals(platform.getName()) || "WechatFavorite".equals(platform.getName())) && TextUtils.isEmpty(db.getUserGender())) {
            try {
                platform2 = ShareSDK.getPlatform("Wechat");
            } catch (Throwable th) {
                SSDKLog.b().a(th, "InnerPlatformActionListener getUserDataBrief catch ", new Object[0]);
                platform2 = null;
            }
            if (platform2 != null) {
                db = platform2.getDb();
            }
        }
        try {
            return a(db, new String[]{"gender", "birthday", "secretType", "educationJSONArrayStr", "workJSONArrayStr"});
        } catch (Throwable th2) {
            SSDKLog.b().b(th2);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String b(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = "errorDesc"
            java.lang.String r1 = "msg"
            java.lang.String r2 = "errStr"
            java.lang.String r3 = "errMsg"
            java.lang.String r4 = "errorMessage"
            java.lang.String r5 = "errorMsg"
            java.lang.String r6 = ""
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: java.lang.Exception -> L55
            r7.<init>(r10)     // Catch: java.lang.Exception -> L55
            boolean r8 = r7.has(r5)     // Catch: java.lang.Exception -> L55
            if (r8 == 0) goto L1e
            java.lang.String r6 = r7.optString(r5)     // Catch: java.lang.Exception -> L55
            goto L54
        L1e:
            boolean r5 = r7.has(r4)     // Catch: java.lang.Exception -> L55
            if (r5 == 0) goto L29
            java.lang.String r6 = r7.optString(r4)     // Catch: java.lang.Exception -> L55
            goto L54
        L29:
            boolean r4 = r7.has(r3)     // Catch: java.lang.Exception -> L55
            if (r4 == 0) goto L34
            java.lang.String r6 = r7.optString(r3)     // Catch: java.lang.Exception -> L55
            goto L54
        L34:
            boolean r3 = r7.has(r2)     // Catch: java.lang.Exception -> L55
            if (r3 == 0) goto L3f
            java.lang.String r6 = r7.optString(r2)     // Catch: java.lang.Exception -> L55
            goto L54
        L3f:
            boolean r2 = r7.has(r1)     // Catch: java.lang.Exception -> L55
            if (r2 == 0) goto L4a
            java.lang.String r6 = r7.optString(r1)     // Catch: java.lang.Exception -> L55
            goto L54
        L4a:
            boolean r1 = r7.has(r0)     // Catch: java.lang.Exception -> L55
            if (r1 == 0) goto L54
            java.lang.String r6 = r7.optString(r0)     // Catch: java.lang.Exception -> L55
        L54:
            return r6
        L55:
            java.util.regex.Pattern r0 = r9.f6373b     // Catch: java.lang.Throwable -> L74
            java.util.regex.Matcher r0 = r0.matcher(r10)     // Catch: java.lang.Throwable -> L74
            boolean r1 = r0.find()     // Catch: java.lang.Throwable -> L74
            if (r1 == 0) goto L74
            r1 = 1
            java.lang.String r2 = r0.group(r1)     // Catch: java.lang.Throwable -> L74
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L74
            if (r2 != 0) goto L74
            java.lang.String r0 = r0.group(r1)     // Catch: java.lang.Throwable -> L74
            java.lang.String r6 = r0.trim()     // Catch: java.lang.Throwable -> L74
        L74:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L7b
            goto L7c
        L7b:
            r10 = r6
        L7c:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.e.b(java.lang.String):java.lang.String");
    }

    private void a(Platform platform, final int i6, final HashMap<String, Object> map) {
        final PlatformActionListener platformActionListener = this.f6374c;
        this.f6374c = new PlatformActionListener() { // from class: cn.sharesdk.framework.e.1
            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onCancel(Platform platform2, int i7) {
                e.this.f6374c = platformActionListener;
                if (e.this.f6374c != null) {
                    e.this.f6374c.onComplete(platform2, i6, map);
                }
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onComplete(Platform platform2, int i7, HashMap<String, Object> map2) {
                e.this.f6374c = platformActionListener;
                if (e.this.f6374c != null) {
                    e.this.f6374c.onComplete(platform2, i6, map);
                }
                cn.sharesdk.framework.a.b.d dVar = new cn.sharesdk.framework.a.b.d();
                dVar.f6278a = platform2.getPlatformId();
                dVar.f6279b = "TencentWeibo".equals(platform2.getName()) ? platform2.getDb().get(AppMeasurementSdk.ConditionalUserProperty.NAME) : platform2.getDb().getUserId();
                dVar.f6280c = new Hashon().fromHashMap(map2);
                dVar.f6281d = e.this.a(platform2);
                cn.sharesdk.framework.a.d dVarA = cn.sharesdk.framework.a.d.a();
                if (dVarA != null) {
                    dVarA.a(dVar);
                }
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onError(Platform platform2, int i7, Throwable th) {
                SSDKLog.b().b(th);
                e.this.f6374c = platformActionListener;
                if (e.this.f6374c != null) {
                    e.this.f6374c.onComplete(platform2, i6, map);
                }
            }
        };
        platform.innerShowUser(null);
    }

    public void a(Platform platform, final int i6, final Object obj) {
        this.f6376e = i6;
        final PlatformActionListener platformActionListener = this.f6374c;
        this.f6374c = new PlatformActionListener() { // from class: cn.sharesdk.framework.e.2
            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onCancel(Platform platform2, int i7) {
                e.this.f6374c = platformActionListener;
                if (e.this.f6374c != null) {
                    e.this.f6374c.onCancel(platform2, i6);
                }
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onComplete(Platform platform2, int i7, HashMap<String, Object> map) {
                e.this.f6374c = platformActionListener;
                platform2.afterRegister(i6, obj);
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onError(Platform platform2, int i7, Throwable th) {
                e.this.f6374c = platformActionListener;
                if (e.this.f6374c != null) {
                    e.this.f6374c.onError(platform2, i7, th);
                }
            }
        };
        platform.doAuthorize(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Platform platform) {
        try {
            return a(platform.getDb(), new String[]{"nickname", "icon", "gender", "snsUserUrl", "resume", "secretType", "secret", "birthday", "followerCount", "favouriteCount", "shareCount", "snsregat", "snsUserLevel", "educationJSONArrayStr", "workJSONArrayStr"});
        } catch (Throwable th) {
            SSDKLog.b().b(th);
            return null;
        }
    }

    private String a(PlatformDb platformDb, String[] strArr) throws Throwable {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i6 = 0;
        for (String str : strArr) {
            if (i6 > 0) {
                sb2.append('|');
                sb.append('|');
            }
            i6++;
            String str2 = platformDb.get(str);
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2);
                sb2.append(Data.urlEncode(str2, "utf-8"));
            }
        }
        SSDKLog.b().b("======UserData: " + sb.toString());
        return sb2.toString();
    }

    private String a(String str) {
        try {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("errorCode")) {
                    return jSONObject.optString("errorCode");
                }
                if (jSONObject.has("errCode")) {
                    return jSONObject.optString("errCode");
                }
                if (jSONObject.has("code")) {
                    return jSONObject.optString("code");
                }
                return jSONObject.has("error_code") ? jSONObject.optString("error_code") : "";
            } catch (Exception unused) {
                Matcher matcher = this.f6372a.matcher(str);
                return (!matcher.find() || TextUtils.isEmpty(matcher.group(1))) ? "" : matcher.group(1).trim();
            }
        } catch (Throwable unused2) {
            return "";
        }
    }
}
