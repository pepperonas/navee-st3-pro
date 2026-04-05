package cn.sharesdk.framework;

import android.app.Activity;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.k;
import com.mob.MobSDK;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes2.dex */
public class j extends cn.sharesdk.framework.utils.f {

    /* renamed from: b, reason: collision with root package name */
    private a f6422b;

    /* renamed from: k, reason: collision with root package name */
    private boolean f6431k;

    /* renamed from: j, reason: collision with root package name */
    private boolean f6430j = true;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, HashMap<String, String>> f6423c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<Platform> f6424d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, Integer> f6425e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private HashMap<Integer, String> f6426f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private HashMap<Integer, CustomPlatform> f6427g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private HashMap<Integer, HashMap<String, Object>> f6428h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private HashMap<Integer, Service> f6429i = new HashMap<>();

    public enum a {
        INITIALIZING,
        READY
    }

    private void h() {
        InputStream inputStreamOpen;
        synchronized (this.f6423c) {
            this.f6423c.clear();
            try {
                XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
                xmlPullParserFactoryNewInstance.setNamespaceAware(true);
                XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
                try {
                    inputStreamOpen = MobSDK.getContext().getAssets().open("ShareSDK.xml");
                } catch (Throwable th) {
                    SSDKLog.b().a(th);
                    inputStreamOpen = null;
                }
                xmlPullParserNewPullParser.setInput(inputStreamOpen, "utf-8");
                for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                    if (eventType == 2) {
                        String name = xmlPullParserNewPullParser.getName();
                        HashMap<String, String> map = new HashMap<>();
                        int attributeCount = xmlPullParserNewPullParser.getAttributeCount();
                        for (int i6 = 0; i6 < attributeCount; i6++) {
                            map.put(xmlPullParserNewPullParser.getAttributeName(i6), xmlPullParserNewPullParser.getAttributeValue(i6).trim());
                        }
                        this.f6423c.put(name, map);
                    }
                }
                inputStreamOpen.close();
            } catch (Throwable th2) {
                SSDKLog.b().a(th2);
            }
        }
    }

    @Override // cn.sharesdk.framework.utils.f
    public void b(Message message) {
    }

    @Override // cn.sharesdk.framework.utils.f
    public void c() {
        this.f6422b = a.INITIALIZING;
        SSDKLog.a();
        EventRecorder.prepare();
        h();
        super.c();
    }

    public void d(Class<? extends CustomPlatform> cls) {
        synchronized (this.f6427g) {
            if (this.f6427g.containsKey(Integer.valueOf(cls.hashCode()))) {
                return;
            }
            try {
                CustomPlatform customPlatformNewInstance = cls.newInstance();
                this.f6427g.put(Integer.valueOf(cls.hashCode()), customPlatformNewInstance);
                if (customPlatformNewInstance != null && customPlatformNewInstance.b()) {
                    this.f6426f.put(Integer.valueOf(customPlatformNewInstance.getPlatformId()), customPlatformNewInstance.getName());
                    this.f6425e.put(customPlatformNewInstance.getName(), Integer.valueOf(customPlatformNewInstance.getPlatformId()));
                }
            } catch (Throwable th) {
                SSDKLog.b().b(th);
            }
        }
    }

    public void e(Class<? extends CustomPlatform> cls) {
        int iHashCode = cls.hashCode();
        synchronized (this.f6427g) {
            this.f6427g.remove(Integer.valueOf(iHashCode));
        }
    }

    public boolean f() {
        synchronized (this.f6428h) {
            try {
                HashMap<Integer, HashMap<String, Object>> map = this.f6428h;
                return map != null && map.size() > 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void g() {
        try {
            ResHelper.clearCache(MobSDK.getContext());
        } catch (Throwable th) {
            SSDKLog.b().b(th);
        }
    }

    public boolean b() {
        return i.c();
    }

    public void b(Class<? extends Service> cls) {
        synchronized (this.f6429i) {
            try {
                int iHashCode = cls.hashCode();
                if (this.f6429i.containsKey(Integer.valueOf(iHashCode))) {
                    this.f6429i.get(Integer.valueOf(iHashCode)).onUnbind();
                    this.f6429i.remove(Integer.valueOf(iHashCode));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(Activity activity) {
        i.a(activity);
    }

    public Activity a() {
        return i.b();
    }

    public boolean e() {
        return this.f6431k;
    }

    public void a(boolean z6) {
        i.a(z6);
    }

    public <T extends Service> T c(Class<T> cls) {
        T tCast;
        synchronized (this.f6429i) {
            if (this.f6422b == a.INITIALIZING) {
                try {
                    this.f6429i.wait();
                } catch (Throwable th) {
                    SSDKLog.b().b(th);
                }
                try {
                    tCast = cls.cast(this.f6429i.get(Integer.valueOf(cls.hashCode())));
                } catch (Throwable th2) {
                    SSDKLog.b().b(th2);
                    return null;
                }
            } else {
                tCast = cls.cast(this.f6429i.get(Integer.valueOf(cls.hashCode())));
            }
        }
        return tCast;
    }

    @Override // cn.sharesdk.framework.utils.f
    public void a(Message message) {
        HashMap<Integer, Service> map;
        synchronized (this.f6429i) {
            synchronized (this.f6424d) {
                try {
                    try {
                        String strCheckRecord = EventRecorder.checkRecord(ShareSDK.SDK_TAG);
                        if (!TextUtils.isEmpty(strCheckRecord)) {
                            cn.sharesdk.framework.a.a.a().a((HashMap<String, Object>) null);
                            SSDKLog.b().a("EventRecorder checkRecord result ==" + strCheckRecord);
                            g();
                        }
                        EventRecorder.clear();
                    } catch (Throwable th) {
                        SSDKLog.b().b(th);
                    }
                    this.f6424d.clear();
                    ArrayList<Platform> arrayListA = i.a();
                    if (arrayListA != null) {
                        this.f6424d.addAll(arrayListA);
                    }
                    Iterator<Platform> it = this.f6424d.iterator();
                    while (it.hasNext()) {
                        Platform next = it.next();
                        this.f6426f.put(Integer.valueOf(next.getPlatformId()), next.getName());
                        this.f6425e.put(next.getName(), Integer.valueOf(next.getPlatformId()));
                    }
                    i.a(this.f6468a);
                    a aVar = a.READY;
                    this.f6422b = aVar;
                    new Thread() { // from class: cn.sharesdk.framework.j.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            j.this.a((ShareSDKCallback<Boolean>) null);
                        }
                    }.start();
                    this.f6422b = aVar;
                    this.f6424d.notify();
                    map = this.f6429i;
                } catch (Throwable th2) {
                    try {
                        SSDKLog.b().b(th2);
                        this.f6422b = a.READY;
                        this.f6424d.notify();
                        map = this.f6429i;
                    } catch (Throwable th3) {
                        this.f6422b = a.READY;
                        this.f6424d.notify();
                        this.f6429i.notify();
                        throw th3;
                    }
                }
                map.notify();
            }
        }
    }

    public void b(int i6) {
        NetworkHelper.readTimout = i6;
    }

    public void b(boolean z6) {
        this.f6431k = z6;
    }

    public Platform[] d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.f6424d) {
            try {
                if (this.f6422b == a.INITIALIZING) {
                    try {
                        this.f6424d.wait();
                    } catch (Throwable th) {
                        SSDKLog.b().b(th);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Platform> it = this.f6424d.iterator();
        while (it.hasNext()) {
            Platform next = it.next();
            if (next != null && next.b()) {
                next.a();
                arrayList.add(next);
            }
        }
        i.a((ArrayList<Platform>) arrayList);
        Iterator<Map.Entry<Integer, CustomPlatform>> it2 = this.f6427g.entrySet().iterator();
        while (it2.hasNext()) {
            CustomPlatform value = it2.next().getValue();
            if (value != null && value.b()) {
                arrayList.add(value);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        int size = arrayList.size();
        Platform[] platformArr = new Platform[size];
        for (int i6 = 0; i6 < size; i6++) {
            platformArr[i6] = (Platform) arrayList.get(i6);
        }
        SSDKLog.b().c("sort list use time: %s", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        return platformArr;
    }

    public int b(String str) {
        synchronized (this.f6424d) {
            synchronized (this.f6427g) {
                if (!this.f6425e.containsKey(str)) {
                    return 0;
                }
                return this.f6425e.get(str).intValue();
            }
        }
    }

    public String c(int i6) {
        String str;
        synchronized (this.f6424d) {
            synchronized (this.f6427g) {
                str = this.f6426f.get(Integer.valueOf(i6));
            }
        }
        return str;
    }

    public String b(String str, String str2) {
        synchronized (this.f6423c) {
            try {
                HashMap<String, String> map = this.f6423c.get(str);
                if (map == null) {
                    return null;
                }
                return map.get(str2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(Class<? extends Service> cls) {
        synchronized (this.f6429i) {
            if (this.f6429i.containsKey(Integer.valueOf(cls.hashCode()))) {
                return;
            }
            try {
                Service serviceNewInstance = cls.newInstance();
                this.f6429i.put(Integer.valueOf(cls.hashCode()), serviceNewInstance);
                serviceNewInstance.onBind();
            } catch (Throwable th) {
                SSDKLog.b().b(th);
            }
        }
    }

    public Platform a(String str) {
        Platform[] platformArrD;
        if (str == null || (platformArrD = d()) == null) {
            return null;
        }
        for (Platform platform : platformArrD) {
            if (str.equals(platform.getName())) {
                return platform;
            }
        }
        return null;
    }

    public void a(int i6) {
        NetworkHelper.connectionTimeout = i6;
    }

    public void a(int i6, Platform platform) {
        i.a(i6, platform);
    }

    public void a(String str, int i6) {
        i.a(str, i6);
    }

    public void a(String str, HashMap<String, Object> map) {
        synchronized (this.f6423c) {
            try {
                HashMap<String, String> map2 = this.f6423c.get(str);
                if (map2 == null) {
                    map2 = new HashMap<>();
                }
                synchronized (map2) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value != null) {
                            map2.put(key, String.valueOf(value));
                        }
                    }
                }
                this.f6423c.put(str, map2);
            } catch (Throwable th) {
                throw th;
            } finally {
            }
        }
        synchronized (this.f6424d) {
            try {
                if (this.f6422b == a.INITIALIZING) {
                    this.f6424d.wait();
                }
            } catch (Throwable th2) {
                SSDKLog.b().b(th2);
            } finally {
            }
        }
        Iterator<Platform> it = this.f6424d.iterator();
        while (it.hasNext()) {
            Platform next = it.next();
            if (next != null && next.getName().equals(str)) {
                next.a();
                return;
            }
        }
    }

    public void a(List<HashMap<String, Object>> list) {
        synchronized (this.f6423c) {
            try {
                for (HashMap<String, Object> map : list) {
                    HashMap<String, String> map2 = new HashMap<>();
                    String strValueOf = null;
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (key.equals("platformName")) {
                            strValueOf = String.valueOf(entry.getValue());
                        }
                        if (value != null) {
                            map2.put(key, String.valueOf(value));
                        }
                    }
                    this.f6423c.put(strValueOf, map2);
                }
            } finally {
            }
        }
        synchronized (this.f6424d) {
            try {
                if (this.f6422b == a.INITIALIZING) {
                    this.f6424d.wait();
                }
            } catch (Throwable th) {
                SSDKLog.b().b(th);
            } finally {
            }
        }
    }

    public void a(String str, String str2) {
        synchronized (this.f6423c) {
            this.f6423c.put(str2, this.f6423c.get(str));
        }
    }

    public void a(int i6, int i7) {
        synchronized (this.f6428h) {
            this.f6428h.put(Integer.valueOf(i7), this.f6428h.get(Integer.valueOf(i6)));
        }
    }

    public String a(int i6, String str) {
        synchronized (this.f6428h) {
            try {
                HashMap<String, Object> map = this.f6428h.get(Integer.valueOf(i6));
                String strValueOf = null;
                if (map == null) {
                    return null;
                }
                Object obj = map.get(str);
                if (obj != null) {
                    strValueOf = String.valueOf(obj);
                }
                return strValueOf;
            } finally {
            }
        }
    }

    public void a(final ShareSDKCallback<Boolean> shareSDKCallback) {
        try {
            if (a.READY != this.f6422b) {
                SSDKLog.b().a("Statistics module unopened", new Object[0]);
                if (shareSDKCallback != null) {
                    shareSDKCallback.onCallback(Boolean.FALSE);
                    return;
                }
                return;
            }
            DH.requester(MobSDK.getContext()).getDeviceKey().request(new DH.DHResponder() { // from class: cn.sharesdk.framework.j.2
                @Override // com.mob.tools.utils.DH.DHResponder
                public void onResponse(DH.DHResponse dHResponse) {
                    try {
                        final String deviceKey = dHResponse.getDeviceKey();
                        if (TextUtils.isEmpty(deviceKey)) {
                            SSDKLog.b().a("dk null", new Object[0]);
                            ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                            if (shareSDKCallback2 != null) {
                                shareSDKCallback2.onCallback(Boolean.FALSE);
                                return;
                            }
                            return;
                        }
                        final cn.sharesdk.framework.a.a aVarA = cn.sharesdk.framework.a.a.a();
                        HashMap mapA = j.this.a(aVarA, aVarA.c(), deviceKey);
                        if (mapA == null || mapA.size() <= 0 || !j.this.a((HashMap<String, Object>) mapA)) {
                            j.this.a(aVarA, (ShareSDKCallback<Boolean>) shareSDKCallback, deviceKey);
                        } else {
                            k.a(new k.a() { // from class: cn.sharesdk.framework.j.2.1
                                @Override // cn.sharesdk.framework.utils.k.a
                                public void a() throws Throwable {
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    j.this.a(aVarA, (ShareSDKCallback<Boolean>) shareSDKCallback, deviceKey);
                                }
                            });
                        }
                    } catch (Throwable th) {
                        SSDKLog.b().a(th);
                        ShareSDKCallback shareSDKCallback3 = shareSDKCallback;
                        if (shareSDKCallback3 != null) {
                            shareSDKCallback3.onCallback(Boolean.FALSE);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(Boolean.FALSE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(cn.sharesdk.framework.a.a aVar, ShareSDKCallback<Boolean> shareSDKCallback, String str) {
        try {
            HashMap<String, Object> mapB = aVar.b(str);
            HashMap<String, Object> mapA = a(aVar, mapB, str);
            if (mapA != null && mapA.size() > 0) {
                if (a(mapA)) {
                    aVar.a(mapB);
                    if (shareSDKCallback != null) {
                        shareSDKCallback.onCallback(Boolean.TRUE);
                    }
                }
            } else {
                SSDKLog.b().a("d i n");
                if (shareSDKCallback != null) {
                    shareSDKCallback.onCallback(Boolean.FALSE);
                }
            }
        } catch (Throwable th) {
            SSDKLog.b().b(th);
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(Boolean.FALSE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> a(cn.sharesdk.framework.a.a aVar, HashMap<String, Object> map, String str) {
        try {
            if (map.containsKey("error")) {
                SSDKLog.b().c("ShareSDK parse sns config ==>>", new Hashon().fromHashMap(map));
                return null;
            }
            if (!map.containsKey("res")) {
                SSDKLog.b().a("ShareSDK platform config result ==>>", "SNS configuration is empty");
                return null;
            }
            String str2 = (String) map.get("res");
            if (str2 == null) {
                return null;
            }
            return aVar.a(str2, str);
        } catch (Throwable th) {
            SSDKLog.b().b(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(HashMap<String, Object> map) {
        synchronized (this.f6428h) {
            try {
                HashMap<Integer, HashMap<String, Object>> mapA = i.a(map);
                if (mapA == null || mapA.size() <= 0) {
                    return false;
                }
                this.f6428h.clear();
                this.f6428h = mapA;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(String str, boolean z6, int i6, String str2, ShareSDKCallback<String> shareSDKCallback) {
        if (a.READY == this.f6422b) {
            cn.sharesdk.framework.a.a.a().a(str, i6, z6, str2, shareSDKCallback);
        } else if (shareSDKCallback != null) {
            shareSDKCallback.onCallback(str);
        }
    }
}
