package cn.sharesdk.framework.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import cn.jiguang.internal.JConstants;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.a.a.e;
import cn.sharesdk.framework.a.b.j;
import cn.sharesdk.framework.utils.SSDKLog;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.MobSDK;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.ResHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f6245a;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6248d = true;

    /* renamed from: b, reason: collision with root package name */
    private c f6246b = new c();

    /* renamed from: c, reason: collision with root package name */
    private e f6247c = e.a();

    private a() {
    }

    private String c(String str) throws Throwable {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int i6 = byteArrayInputStream.read(bArr, 0, 1024);
            if (i6 == -1) {
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
                return Base64.encodeToString(byteArray, 2);
            }
            gZIPOutputStream.write(bArr, 0, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(cn.sharesdk.framework.a.b.e eVar) {
        try {
            long jB = this.f6247c.b();
            if (jB == 0) {
                jB = this.f6246b.b();
            }
            eVar.f6282e = System.currentTimeMillis() - jB;
            this.f6246b.a(eVar);
        } catch (Throwable th) {
            SSDKLog.b().a("s l" + th, new Object[0]);
        }
    }

    public static a a() {
        if (f6245a == null) {
            f6245a = new a();
        }
        return f6245a;
    }

    public void a(String str) {
        if (this.f6246b == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f6246b.a(str);
    }

    public void b() {
        boolean zA;
        try {
            if (this.f6247c.i()) {
                ArrayList<cn.sharesdk.framework.a.a.c> arrayListC = this.f6246b.c();
                for (int i6 = 0; i6 < arrayListC.size(); i6++) {
                    cn.sharesdk.framework.a.a.c cVar = arrayListC.get(i6);
                    if (cVar.f6266b.size() == 1) {
                        zA = a(cVar.f6265a, false);
                    } else {
                        zA = a(c(cVar.f6265a), true);
                    }
                    if (zA) {
                        this.f6246b.a(cVar.f6266b);
                    }
                }
            }
        } catch (Throwable th) {
            SSDKLog.b().a(th);
        }
    }

    public void a(final ShareSDKCallback<Boolean> shareSDKCallback) {
        DH.requester(MobSDK.getContext()).getNetworkType().request(new DH.DHResponder() { // from class: cn.sharesdk.framework.a.a.1
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    String networkType = dHResponse.getNetworkType();
                    if (!"none".equals(networkType) && !TextUtils.isEmpty(networkType)) {
                        long jLongValue = a.this.f6247c.j().longValue();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(jLongValue);
                        int i6 = calendar.get(5);
                        calendar.setTimeInMillis(jCurrentTimeMillis);
                        int i7 = calendar.get(5);
                        if (jCurrentTimeMillis - jLongValue >= JConstants.DAY && i6 != i7) {
                            HashMap<String, Object> mapA = a.this.f6246b.a();
                            a.this.f6247c.c(mapA.containsKey("res") ? "true".equals(String.valueOf(mapA.get("res"))) : true);
                            if (mapA.size() > 0) {
                                a.this.f6247c.b(System.currentTimeMillis());
                            }
                        }
                        shareSDKCallback.onCallback(Boolean.TRUE);
                    }
                } catch (Throwable th) {
                    shareSDKCallback.onCallback(Boolean.FALSE);
                    SSDKLog.b().a(th);
                }
            }
        });
    }

    public void a(final Handler handler) {
        try {
            if (this.f6247c.i()) {
                this.f6247c.a(System.currentTimeMillis());
                this.f6246b.a(new ShareSDKCallback<HashMap<String, Object>>() { // from class: cn.sharesdk.framework.a.a.2
                    @Override // cn.sharesdk.framework.ShareSDKCallback
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onCallback(HashMap<String, Object> map) {
                        HashMap map2;
                        HashMap map3;
                        HashMap map4;
                        if (map == null || map.isEmpty()) {
                            return;
                        }
                        try {
                            if (map.containsKey(NotificationCompat.CATEGORY_STATUS) && ResHelper.parseInt(String.valueOf(map.get(NotificationCompat.CATEGORY_STATUS))) == -200) {
                                SSDKLog.b().a((String) map.get("error"), new Object[0]);
                                return;
                            }
                        } catch (Throwable th) {
                            SSDKLog.b().a("get status" + th, new Object[0]);
                        }
                        try {
                            if (map.containsKey("timestamp")) {
                                a.this.f6247c.a("service_time", Long.valueOf(System.currentTimeMillis() - ResHelper.parseLong(String.valueOf(map.get("timestamp")))));
                            }
                        } catch (Throwable th2) {
                            SSDKLog.b().a("timestamp" + th2, new Object[0]);
                        }
                        try {
                            if (map.containsKey("specurls") && (map4 = (HashMap) map.get("specurls")) != null && !map4.isEmpty()) {
                                e.a().a("twitter_auth_url", String.valueOf(map4.get("twitterAuthUrl")));
                            }
                        } catch (Throwable th3) {
                            SSDKLog.b().a("specurls" + th3, new Object[0]);
                        }
                        if (map.containsKey("switchs") && (map3 = (HashMap) map.get("switchs")) != null) {
                            String strValueOf = String.valueOf(map3.get("device"));
                            String strValueOf2 = String.valueOf(map3.get(FirebaseAnalytics.Event.SHARE));
                            String strValueOf3 = String.valueOf(map3.get("auth"));
                            String strValueOf4 = String.valueOf(map3.get("backflow"));
                            String strValueOf5 = String.valueOf(map3.get("loginplus"));
                            String strValueOf6 = String.valueOf(map3.get("linkcard"));
                            a.this.f6247c.b(strValueOf);
                            a.this.f6247c.d(strValueOf2);
                            a.this.f6247c.c(strValueOf3);
                            a.this.f6247c.a(strValueOf4);
                            a.this.f6247c.e(strValueOf5);
                            a.this.f6247c.f(strValueOf6);
                        }
                        if (!map.containsKey("serpaths") || (map2 = (HashMap) map.get("serpaths")) == null) {
                            return;
                        }
                        String strValueOf7 = String.valueOf(map2.get("defhost"));
                        String strValueOf8 = String.valueOf(map2.get("defport"));
                        if (!TextUtils.isEmpty(strValueOf7) && !TextUtils.isEmpty(strValueOf8)) {
                            if ("443".equals(strValueOf8) || "80".equals(strValueOf8)) {
                                a.this.f6246b.b(MobSDK.checkRequestUrl(strValueOf7));
                            } else {
                                a.this.f6246b.b(MobSDK.checkRequestUrl(strValueOf7) + ":" + strValueOf8);
                            }
                        }
                        HashMap<String, String> map5 = new HashMap<>();
                        if (map2.containsKey("assigns")) {
                            HashMap map6 = (HashMap) map2.get("assigns");
                            if (map6 == null || map6.size() == 0) {
                                a.this.f6246b.a((HashMap<String, String>) null);
                                return;
                            }
                            for (String str : map6.keySet()) {
                                HashMap map7 = (HashMap) map6.get(str);
                                String strValueOf9 = String.valueOf(map7.get("host"));
                                String strValueOf10 = String.valueOf(map7.get("port"));
                                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(strValueOf9) && !TextUtils.isEmpty(strValueOf10)) {
                                    map5.put(str, "http://" + strValueOf9 + ":" + strValueOf10);
                                }
                            }
                            a.this.f6246b.a(map5);
                            handler.sendEmptyMessageDelayed(4, 600000L);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            SSDKLog.b().a(th);
        }
    }

    public HashMap<String, Object> c() {
        try {
            return this.f6246b.d();
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            return new HashMap<>();
        }
    }

    public void a(cn.sharesdk.framework.a.b.e eVar) {
        try {
            if (this.f6247c.i()) {
                if (!this.f6247c.c()) {
                    eVar.f6289l = null;
                }
                if (eVar instanceof cn.sharesdk.framework.a.b.d) {
                    a((cn.sharesdk.framework.a.b.d) eVar);
                    b(eVar);
                } else if (eVar instanceof j) {
                    a((j) eVar);
                } else {
                    b(eVar);
                }
            }
        } catch (Throwable th) {
            SSDKLog.b().a(th);
        }
    }

    public HashMap<String, Object> b(String str) {
        if (!this.f6247c.i() && this.f6247c.k()) {
            return new HashMap<>();
        }
        try {
            HashMap<String, Object> mapD = this.f6246b.d(str);
            this.f6247c.d(true);
            return mapD;
        } catch (Throwable th) {
            this.f6247c.d(false);
            SSDKLog.b().a(th);
            return new HashMap<>();
        }
    }

    private void a(cn.sharesdk.framework.a.b.d dVar) throws Throwable {
        boolean zD = this.f6247c.d();
        String str = dVar.f6280c;
        if (zD && !TextUtils.isEmpty(str)) {
            dVar.f6280c = Data.Base64AES(str, dVar.f6283f.substring(0, 16));
        } else {
            dVar.f6281d = null;
            dVar.f6280c = null;
        }
    }

    private void a(final j jVar) throws Throwable {
        ArrayList arrayList;
        ArrayList<Bitmap> arrayList2;
        int iF = this.f6247c.f();
        boolean zD = this.f6247c.d();
        final j.a aVar = jVar.f6305d;
        if (!zD) {
            jVar.f6306o = null;
        }
        if (iF == 1) {
            if (aVar != null && aVar.f6312e != null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(aVar.f6312e);
            }
            int size = (aVar == null || (arrayList2 = aVar.f6313f) == null) ? 0 : arrayList2.size();
            for (int i6 = 0; i6 < size; i6++) {
                Bitmap bitmap = aVar.f6313f.get(i6);
                try {
                    File fileCreateTempFile = File.createTempFile("bm_tmp", ".png");
                    FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    arrayList.add(fileCreateTempFile.getAbsolutePath());
                } catch (Throwable th) {
                    SSDKLog.b().a("bit" + th, new Object[0]);
                }
            }
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    a((String) it.next(), b.FINISH_SHARE, new ShareSDKCallback<String>() { // from class: cn.sharesdk.framework.a.a.3
                        @Override // cn.sharesdk.framework.ShareSDKCallback
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public void onCallback(String str) {
                            if (!TextUtils.isEmpty(str)) {
                                aVar.f6311d.add(str);
                            }
                            a.this.b(jVar);
                        }
                    });
                }
                return;
            }
            b(jVar);
            return;
        }
        jVar.f6305d = null;
        b(jVar);
    }

    private void a(String str, b bVar, ShareSDKCallback<String> shareSDKCallback) throws Throwable {
        double dCeil;
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(null);
                return;
            }
            return;
        }
        Bitmap.CompressFormat bmpFormat = BitmapHelper.getBmpFormat(str);
        float f7 = bVar == b.BEFORE_SHARE ? 600.0f : 200.0f;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        int i6 = options.outWidth;
        int i7 = options.outHeight;
        if (i6 >= i7 && i7 > f7) {
            dCeil = Math.ceil(i7 / f7);
        } else if (i6 < i7 && i6 > f7) {
            dCeil = Math.ceil(i6 / f7);
        } else {
            a(str, shareSDKCallback);
            return;
        }
        int i8 = (int) dCeil;
        if (i8 <= 0) {
            i8 = 1;
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inSampleSize = i8;
        options2.inPurgeable = true;
        options2.inInputShareable = true;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options2);
        bitmapDecodeFile.getHeight();
        bitmapDecodeFile.getWidth();
        File fileCreateTempFile = File.createTempFile("bm_tmp2", "." + bmpFormat.name().toLowerCase());
        FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
        bitmapDecodeFile.compress(bmpFormat, 80, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        a(fileCreateTempFile.getAbsolutePath(), shareSDKCallback);
    }

    private void a(final String str, final ShareSDKCallback<String> shareSDKCallback) throws Throwable {
        DH.requester(MobSDK.getContext()).getNetworkType().request(new DH.DHResponder() { // from class: cn.sharesdk.framework.a.a.4
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    String networkType = dHResponse.getNetworkType();
                    if (!"none".equals(networkType) && !TextUtils.isEmpty(networkType)) {
                        HashMap<String, Object> mapC = a.this.f6246b.c(str);
                        if (mapC != null && mapC.size() > 0) {
                            if (!mapC.containsKey(NotificationCompat.CATEGORY_STATUS)) {
                                ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                                if (shareSDKCallback2 != null) {
                                    shareSDKCallback2.onCallback(null);
                                    return;
                                }
                                return;
                            }
                            if (ResHelper.parseInt(String.valueOf(mapC.get(NotificationCompat.CATEGORY_STATUS))) != 200) {
                                ShareSDKCallback shareSDKCallback3 = shareSDKCallback;
                                if (shareSDKCallback3 != null) {
                                    shareSDKCallback3.onCallback(null);
                                    return;
                                }
                                return;
                            }
                            String str2 = mapC.containsKey(ImagesContract.URL) ? (String) mapC.get(ImagesContract.URL) : null;
                            ShareSDKCallback shareSDKCallback4 = shareSDKCallback;
                            if (shareSDKCallback4 != null) {
                                shareSDKCallback4.onCallback(str2);
                                return;
                            }
                            return;
                        }
                        ShareSDKCallback shareSDKCallback5 = shareSDKCallback;
                        if (shareSDKCallback5 != null) {
                            shareSDKCallback5.onCallback(null);
                            return;
                        }
                        return;
                    }
                    ShareSDKCallback shareSDKCallback6 = shareSDKCallback;
                    if (shareSDKCallback6 != null) {
                        shareSDKCallback6.onCallback(null);
                    }
                } catch (Throwable unused) {
                    SSDKLog.b().a("up fi", new Object[0]);
                    ShareSDKCallback shareSDKCallback7 = shareSDKCallback;
                    if (shareSDKCallback7 != null) {
                        shareSDKCallback7.onCallback(null);
                    }
                }
            }
        });
    }

    private boolean a(String str, boolean z6) throws Throwable {
        return this.f6246b.a(str, z6);
    }

    public void a(String str, int i6, boolean z6, String str2, ShareSDKCallback<String> shareSDKCallback) {
        try {
            if (!this.f6247c.i() || !this.f6247c.e()) {
                if (shareSDKCallback != null) {
                    shareSDKCallback.onCallback(str);
                    return;
                }
            }
            SSDKLog.b().c("> SERVER_SHORT_LINK_URL content before replace link ===  %s", str);
            if (z6) {
                a(str, "<a[^>]*?href[\\s]*=[\\s]*[\"']?([^'\">]+?)['\"]?>", i6, str2, shareSDKCallback);
            } else {
                a(str, "(http://|https://){1}[\\w\\.\\-/:\\?&%=,;\\[\\]\\{\\}`~!@#\\$\\^\\*\\(\\)_\\+\\\\\\|]+", i6, str2, shareSDKCallback);
            }
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback("error:" + th.getMessage());
            }
        }
    }

    private void a(final String str, String str2, int i6, String str3, final ShareSDKCallback<String> shareSDKCallback) throws Throwable {
        ArrayList<String> arrayList = new ArrayList<>();
        final Pattern patternCompile = Pattern.compile(str2);
        Matcher matcher = patternCompile.matcher(str);
        while (matcher.find()) {
            String strGroup = matcher.group();
            if (strGroup != null && strGroup.length() > 0) {
                arrayList.add(strGroup);
            }
        }
        if (arrayList.size() != 0) {
            this.f6246b.a(str, arrayList, i6, str3, new ShareSDKCallback<HashMap<String, Object>>() { // from class: cn.sharesdk.framework.a.a.5
                @Override // cn.sharesdk.framework.ShareSDKCallback
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onCallback(HashMap<String, Object> map) {
                    if (map == null || map.size() <= 0) {
                        shareSDKCallback.onCallback(str);
                        return;
                    }
                    if (!map.containsKey("data")) {
                        shareSDKCallback.onCallback(str);
                        return;
                    }
                    ArrayList arrayList2 = (ArrayList) map.get("data");
                    HashMap map2 = new HashMap();
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        HashMap map3 = (HashMap) it.next();
                        map2.put(String.valueOf(map3.get(FirebaseAnalytics.Param.SOURCE)), String.valueOf(map3.get("surl")));
                    }
                    Matcher matcher2 = patternCompile.matcher(str);
                    StringBuilder sb = new StringBuilder();
                    int iEnd = 0;
                    while (matcher2.find()) {
                        sb.append(str.substring(iEnd, matcher2.start()));
                        sb.append((String) map2.get(matcher2.group()));
                        iEnd = matcher2.end();
                    }
                    sb.append(str.substring(iEnd));
                    String string = sb.toString();
                    SSDKLog.b().c("> SERVER_SHORT_LINK_URL content after replace link ===  %s", string);
                    ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                    if (shareSDKCallback2 != null) {
                        shareSDKCallback2.onCallback(string);
                    }
                }
            });
        } else if (shareSDKCallback != null) {
            shareSDKCallback.onCallback(str);
        }
    }

    public void a(HashMap<String, Object> map) {
        try {
            this.f6246b.b(map);
        } catch (Throwable th) {
            SSDKLog.b().a(th);
        }
    }

    public HashMap<String, Object> a(String str, String str2) {
        try {
            return this.f6246b.a(str, str2);
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            return null;
        }
    }

    public String a(String str, int i6, boolean z6, String str2, HashMap<String, String> map) {
        String strA;
        try {
            if (this.f6247c.i() && this.f6247c.e()) {
                String str3 = map.get("nt");
                if (!"none".equals(str3) && !TextUtils.isEmpty(str3)) {
                    if (z6 && (strA = a(str, "<a[^>]*?href[\\s]*=[\\s]*[\"']?([^'\">]+?)['\"]?>", i6, str2, map)) != null && !strA.equals(str)) {
                        return strA;
                    }
                    String strA2 = a(str, "(http://|https://){1}[\\w\\.\\-/:\\?&%=,;\\[\\]\\{\\}`~!@#\\$\\^\\*\\(\\)_\\+\\\\\\|]+", i6, str2, map);
                    if (strA2 != null) {
                        if (!strA2.equals(str)) {
                            return strA2;
                        }
                    }
                }
            }
            return str;
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            return str;
        }
    }

    private String a(String str, String str2, int i6, String str3, HashMap<String, String> map) throws Throwable {
        HashMap<String, Object> mapA;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Pattern patternCompile = Pattern.compile(str2);
        Matcher matcher = patternCompile.matcher(str);
        while (matcher.find()) {
            String strGroup = matcher.group();
            if (strGroup != null && strGroup.length() > 0) {
                arrayList.add(strGroup);
            }
        }
        if (arrayList.size() == 0 || (mapA = this.f6246b.a(str, arrayList, i6, str3, map)) == null || mapA.size() <= 0 || !mapA.containsKey("data")) {
            return str;
        }
        ArrayList arrayList2 = (ArrayList) mapA.get("data");
        HashMap map2 = new HashMap();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            HashMap map3 = (HashMap) it.next();
            map2.put(String.valueOf(map3.get(FirebaseAnalytics.Param.SOURCE)), String.valueOf(map3.get("surl")));
        }
        Matcher matcher2 = patternCompile.matcher(str);
        StringBuilder sb = new StringBuilder();
        int iEnd = 0;
        while (matcher2.find()) {
            sb.append(str.substring(iEnd, matcher2.start()));
            sb.append((String) map2.get(matcher2.group()));
            iEnd = matcher2.end();
        }
        sb.append(str.substring(iEnd, str.length()));
        String string = sb.toString();
        SSDKLog.b().c("> SERVER_SHORT_LINK_URL content after replace link ===  %s", string);
        return string;
    }
}
