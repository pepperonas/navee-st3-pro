package cn.sharesdk.framework;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import cn.sharesdk.framework.loopshare.LoopSharePasswordListener;
import cn.sharesdk.framework.loopshare.LoopShareResultListener;
import cn.sharesdk.framework.loopshare.MoblinkActionListener;
import cn.sharesdk.framework.loopshare.watermark.ReadQrImageListener;
import cn.sharesdk.framework.loopshare.watermark.WaterMarkListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.k;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.mob.MobSDK;
import com.mob.commons.ForbThrowable;
import com.mob.commons.dialog.PolicyThrowable;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class ShareSDK {
    public static final String SDK_TAG = "SHARESDK";
    public static final int SDK_VERSION_CODE;
    public static final String SDK_VERSION_NAME = "3.10.31";
    public static final String SHARESDK_MOBLINK_RESTORE = "sharesdk_moblink_restore";

    /* renamed from: a, reason: collision with root package name */
    private static j f6185a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f6186b = true;

    /* renamed from: c, reason: collision with root package name */
    private static String f6187c = null;

    /* renamed from: d, reason: collision with root package name */
    private static HashMap<String, Object> f6188d = null;

    /* renamed from: e, reason: collision with root package name */
    private static List<HashMap<String, Object>> f6189e = null;

    /* renamed from: f, reason: collision with root package name */
    private static int f6190f = 0;

    /* renamed from: g, reason: collision with root package name */
    private static volatile boolean f6191g = false;

    static {
        int i6 = 0;
        for (String str : SDK_VERSION_NAME.split("\\.")) {
            i6 = (i6 * 100) + Integer.parseInt(str);
        }
        SDK_VERSION_CODE = i6;
    }

    public static void closeDebug() {
        f6186b = false;
    }

    public static void deleteCache() {
        try {
            l();
            j jVar = f6185a;
            if (jVar != null) {
                jVar.g();
            }
        } catch (Throwable th) {
            SSDKLog.b().a(th, "ShareSDK deleteCache catch ", new Object[0]);
        }
    }

    public static void deleteCacheAsync() {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.2
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f6185a != null) {
                        ShareSDK.f6185a.g();
                    }
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK deleteCache catch ", new Object[0]);
                }
            }
        });
    }

    public static Activity getAuthActivity() {
        try {
            l();
        } catch (Throwable th) {
            SSDKLog.b().a(th, "ShareSDK getAuthActivity catch ", new Object[0]);
        }
        j jVar = f6185a;
        if (jVar != null) {
            return jVar.a();
        }
        return null;
    }

    public static void getAuthActivityAsync(final ShareSDKCallback<Activity> shareSDKCallback) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.15
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK getAuthActivity catch ", new Object[0]);
                }
                Activity activityA = ShareSDK.f6185a != null ? ShareSDK.f6185a.a() : null;
                ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                if (shareSDKCallback2 != null) {
                    shareSDKCallback2.onCallback(activityA);
                }
            }
        });
    }

    @Deprecated
    public static HashMap<String, Object> getCustomDataFromLoopShare() {
        return null;
    }

    public static String getDevinfo(String str, String str2) {
        try {
            l();
        } catch (Throwable th) {
            SSDKLog.b().a(th, "ShareSDK getDevinfo catch ", new Object[0]);
        }
        j jVar = f6185a;
        if (jVar != null) {
            return jVar.b(str, str2);
        }
        return null;
    }

    public static void getDevinfoAsync(final String str, final String str2, final ShareSDKCallback<String> shareSDKCallback) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.20
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK getDevinfo catch ", new Object[0]);
                }
                String strB = ShareSDK.f6185a != null ? ShareSDK.f6185a.b(str, str2) : "";
                ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                if (shareSDKCallback2 != null) {
                    shareSDKCallback2.onCallback(strB);
                }
            }
        });
    }

    @Deprecated
    public static boolean getEnableAuthTag() {
        return false;
    }

    @Deprecated
    public static void getFirstQrImage(Context context, ReadQrImageListener readQrImageListener) {
    }

    public static void getNetworkDevinfoAsync(final int i6, final String str, final ShareSDKCallback<String> shareSDKCallback) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.21
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK getNetworkDevinfo catch ", new Object[0]);
                }
                String strA = ShareSDK.f6185a != null ? ShareSDK.f6185a.a(i6, str) : "";
                ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                if (shareSDKCallback2 != null) {
                    shareSDKCallback2.onCallback(strA);
                }
            }
        });
    }

    public static Platform getPlatform(String str) {
        try {
            l();
        } catch (Throwable th) {
            SSDKLog.b().a(th, "ShareSDK ensureInit getPlatform catch", new Object[0]);
        }
        j jVar = f6185a;
        if (jVar != null) {
            return jVar.a(str);
        }
        SSDKLog.b().a("ShareSDK use defaultPlatform", new Object[0]);
        return Platform.getDefaultPlatform();
    }

    public static void getPlatformAsync(final String str, final ShareSDKCallback<Platform> shareSDKCallback) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.4
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK ensureInit getPlatform catch", new Object[0]);
                }
                Platform defaultPlatform = Platform.getDefaultPlatform();
                if (ShareSDK.f6185a != null) {
                    defaultPlatform = ShareSDK.f6185a.a(str);
                } else {
                    SSDKLog.b().a("ShareSDK use defaultPlatform", new Object[0]);
                }
                ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                if (shareSDKCallback2 != null) {
                    shareSDKCallback2.onCallback(defaultPlatform);
                }
            }
        });
    }

    public static Platform[] getPlatformList() {
        try {
            l();
        } catch (Throwable th) {
            SSDKLog.b().a(th, "ShareSDK getPlatformList catch ", new Object[0]);
        }
        j jVar = f6185a;
        if (jVar != null) {
            return jVar.d();
        }
        return null;
    }

    public static void getPlatformListAsync(final ShareSDKCallback<Platform[]> shareSDKCallback) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.3
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    Platform[] platformArrD = ShareSDK.f6185a != null ? ShareSDK.f6185a.d() : null;
                    ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                    if (shareSDKCallback2 != null) {
                        shareSDKCallback2.onCallback(platformArrD);
                    }
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK getPlatformList catch ", new Object[0]);
                }
            }
        });
    }

    @Deprecated
    public static Bitmap getQRCodeBitmap(String str, int i6, int i7) throws Throwable {
        return null;
    }

    public static <T extends Service> T getService(Class<T> cls) throws Throwable {
        l();
        j jVar = f6185a;
        if (jVar != null) {
            return (T) jVar.c(cls);
        }
        return null;
    }

    public static <T extends Service> void getServiceAsync(final Class<T> cls, final ShareSDKCallback<T> shareSDKCallback) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.27
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f6185a != null) {
                        ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                        if (shareSDKCallback2 != null) {
                            shareSDKCallback2.onCallback(ShareSDK.f6185a.c(cls));
                        }
                    } else {
                        ShareSDKCallback shareSDKCallback3 = shareSDKCallback;
                        if (shareSDKCallback3 != null) {
                            shareSDKCallback3.onCallback(null);
                        }
                    }
                } catch (Throwable th) {
                    SSDKLog.b().a("ShareSDK getServiceAsync" + th, new Object[0]);
                }
            }
        });
    }

    public static /* synthetic */ int i() {
        int i6 = f6190f;
        f6190f = i6 + 1;
        return i6;
    }

    public static boolean isDebug() {
        return f6186b;
    }

    public static boolean isFBInstagram() {
        try {
            l();
        } catch (Throwable th) {
            SSDKLog.b().a("ShareSDK isFBInstagram catch: " + th, new Object[0]);
        }
        j jVar = f6185a;
        if (jVar != null) {
            return jVar.b();
        }
        return false;
    }

    public static void isFBInstagramAsync(final ShareSDKCallback<Boolean> shareSDKCallback) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.17
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                } catch (Throwable th) {
                    SSDKLog.b().a("ShareSDK isFBInstagram catch: " + th, new Object[0]);
                }
                boolean zB = ShareSDK.f6185a != null ? ShareSDK.f6185a.b() : false;
                ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                if (shareSDKCallback2 != null) {
                    shareSDKCallback2.onCallback(Boolean.valueOf(zB));
                }
            }
        });
    }

    public static void isNetworkDevinfoRequestedAsync(final ShareSDKCallback<Boolean> shareSDKCallback) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.22
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK isNetworkDevinfoRequested is catch ", new Object[0]);
                }
                boolean zF = ShareSDK.f6185a != null ? ShareSDK.f6185a.f() : false;
                ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                if (shareSDKCallback2 != null) {
                    shareSDKCallback2.onCallback(Boolean.valueOf(zF));
                }
            }
        });
    }

    public static boolean isRemoveCookieOnAuthorize() {
        try {
            l();
        } catch (Throwable th) {
            SSDKLog.b().a("ShareSDK isRemoveCookieOnAuthorize catch: " + th, new Object[0]);
        }
        j jVar = f6185a;
        if (jVar != null) {
            return jVar.e();
        }
        return false;
    }

    public static void isRemoveCookieOnAuthorizeAsync(final ShareSDKCallback<Boolean> shareSDKCallback) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.13
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                } catch (Throwable th) {
                    SSDKLog.b().a("ShareSDK isRemoveCookieOnAuthorize catch: " + th, new Object[0]);
                }
                boolean zE = ShareSDK.f6185a != null ? ShareSDK.f6185a.e() : false;
                ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                if (shareSDKCallback2 != null) {
                    shareSDKCallback2.onCallback(Boolean.valueOf(zE));
                }
            }
        });
    }

    private static boolean k() throws Throwable {
        if (MobSDK.isForb()) {
            throw new ForbThrowable();
        }
        if (!f6191g) {
            f6191g = true;
            cn.sharesdk.framework.utils.i.a();
        }
        int iIsAuth = MobSDK.isAuth();
        if (iIsAuth == 1 || iIsAuth == 2) {
            return true;
        }
        throw new PolicyThrowable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void l() throws Throwable {
        k();
        if (f6185a == null) {
            j jVar = new j();
            jVar.c();
            f6185a = jVar;
        }
    }

    public static void logApiEvent(final String str, final int i6) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.6
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f6185a != null) {
                        ShareSDK.f6185a.a(str, i6);
                    }
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK logApiEvent catch ", new Object[0]);
                }
            }
        });
    }

    public static void logDemoEvent(final int i6, final Platform platform) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.5
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f6185a != null) {
                        ShareSDK.f6185a.a(i6, platform);
                    }
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK logDemoEvent catch ", new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m() {
        new Thread(new Runnable() { // from class: cn.sharesdk.framework.ShareSDK.9
            @Override // java.lang.Runnable
            public void run() {
                Looper.prepare();
                final Handler handler = new Handler(Looper.myLooper()) { // from class: cn.sharesdk.framework.ShareSDK.9.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        super.handleMessage(message);
                        if (message == null || message.what != 3) {
                            return;
                        }
                        try {
                            ShareSDK.l();
                            if (ShareSDK.f6185a != null) {
                                if (ShareSDK.f6188d == null || ShareSDK.f6188d.size() <= 0) {
                                    ShareSDK.f6185a.a(ShareSDK.f6189e);
                                } else {
                                    ShareSDK.f6185a.a(ShareSDK.f6187c, ShareSDK.f6188d);
                                }
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                };
                handler.post(new Runnable() { // from class: cn.sharesdk.framework.ShareSDK.9.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int iIsAuth = MobSDK.isAuth();
                        if (iIsAuth == 0) {
                            ShareSDK.i();
                            if (ShareSDK.f6190f == 90) {
                                handler.removeCallbacks(this);
                                return;
                            } else {
                                SSDKLog.b().d("ShareSDK , Privacy Agreement is not agree, Please agree to the privacy agreement first ", new Object[0]);
                                handler.postDelayed(this, 500L);
                                return;
                            }
                        }
                        if (iIsAuth != 1 && iIsAuth != 2) {
                            handler.removeCallbacks(this);
                        } else {
                            if (MobSDK.isForb()) {
                                return;
                            }
                            handler.removeCallbacks(this);
                            Message messageObtain = Message.obtain();
                            messageObtain.what = 3;
                            handler.sendMessage(messageObtain);
                        }
                    }
                });
                Looper.loop();
            }
        }).start();
    }

    @Deprecated
    public static void makeVideoWaterMark(String str, String str2, String str3, String str4, WaterMarkListener waterMarkListener) {
    }

    @Deprecated
    public static void mobLinkGetMobID(HashMap<String, Object> map, MoblinkActionListener moblinkActionListener) {
    }

    public static String platformIdToName(int i6) {
        try {
            l();
        } catch (Throwable th) {
            SSDKLog.b().a("ShareSDK platformIdToName catch: " + th, new Object[0]);
        }
        j jVar = f6185a;
        if (jVar != null) {
            return jVar.c(i6);
        }
        return null;
    }

    public static void platformIdToNameAsync(final int i6, final ShareSDKCallback<String> shareSDKCallback) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.10
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                } catch (Throwable th) {
                    SSDKLog.b().a("ShareSDK platformIdToName catch: " + th, new Object[0]);
                }
                String strC = ShareSDK.f6185a != null ? ShareSDK.f6185a.c(i6) : "";
                ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                if (shareSDKCallback2 != null) {
                    shareSDKCallback2.onCallback(strC);
                }
            }
        });
    }

    public static int platformNameToId(String str) {
        try {
            l();
        } catch (Throwable th) {
            SSDKLog.b().a(th, "ShareSDK platformNameToId catch ", new Object[0]);
        }
        j jVar = f6185a;
        if (jVar != null) {
            return jVar.b(str);
        }
        return -1;
    }

    public static void platformNameToIdAsync(final String str, final ShareSDKCallback<Integer> shareSDKCallback) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.11
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK platformNameToId catch ", new Object[0]);
                }
                int iB = ShareSDK.f6185a != null ? ShareSDK.f6185a.b(str) : -1;
                ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                if (shareSDKCallback2 != null) {
                    shareSDKCallback2.onCallback(Integer.valueOf(iB));
                }
            }
        });
    }

    @Deprecated
    public static void prepareLoopShare(LoopShareResultListener loopShareResultListener) {
    }

    @Deprecated
    public static void preparePassWord(HashMap<String, Object> map, String str, LoopSharePasswordListener loopSharePasswordListener) {
    }

    @Deprecated
    public static void readPassWord(boolean z6, LoopSharePasswordListener loopSharePasswordListener) {
    }

    public static void registerPlatformAsync(final Class<? extends CustomPlatform> cls) throws Throwable {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.28
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                ShareSDK.l();
                if (ShareSDK.f6185a != null) {
                    ShareSDK.f6185a.d(cls);
                }
            }
        });
    }

    public static void registerService(final Class<? extends Service> cls) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.12
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f6185a != null) {
                        ShareSDK.f6185a.a(cls);
                    }
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK  registerService catch ", new Object[0]);
                }
            }
        });
    }

    public static void removeCookieOnAuthorize(boolean z6) {
        try {
            l();
            j jVar = f6185a;
            if (jVar != null) {
                jVar.b(z6);
            }
        } catch (Throwable th) {
            SSDKLog.b().a(th, "ShareSDK removeCookieOnAuthorize catch ", new Object[0]);
        }
    }

    public static void removeCookieOnAuthorizeAsync(final boolean z6) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.32
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f6185a != null) {
                        ShareSDK.f6185a.b(z6);
                    }
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK removeCookieOnAuthorize catch ", new Object[0]);
                }
            }
        });
    }

    public static void setActivity(Activity activity) {
        try {
            l();
            j jVar = f6185a;
            if (jVar != null) {
                jVar.a(activity);
            }
        } catch (Throwable th) {
            SSDKLog.b().a(th, "ShareSDK setActivity is catch ", new Object[0]);
        }
    }

    public static void setActivityAsync(final Activity activity) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.14
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f6185a != null) {
                        ShareSDK.f6185a.a(activity);
                    }
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK setActivity is catch ", new Object[0]);
                }
            }
        });
    }

    public static void setCloseGppService(final boolean z6) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.26
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    cn.sharesdk.framework.a.a.e.a().b(z6);
                } catch (Throwable th) {
                    SSDKLog.b().a(th);
                }
            }
        });
    }

    public static void setConnTimeout(int i6) {
        try {
            l();
            j jVar = f6185a;
            if (jVar != null) {
                jVar.a(i6);
            }
        } catch (Throwable th) {
            SSDKLog.b().a(th, "ShareSDK setConnTimeout catch", new Object[0]);
        }
    }

    public static void setConnTimeoutAsync(final int i6) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.30
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f6185a != null) {
                        ShareSDK.f6185a.a(i6);
                    }
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK setConnTimeout catch", new Object[0]);
                }
            }
        });
    }

    @Deprecated
    public static void setEnableAuthTag(boolean z6) {
    }

    public static void setFBInstagram(boolean z6) {
        try {
            l();
            j jVar = f6185a;
            if (jVar != null) {
                jVar.a(z6);
            }
        } catch (Throwable th) {
            SSDKLog.b().a(th, "ShareSDK setFBInstagram catch ", new Object[0]);
        }
    }

    public static void setFBInstagramAsync(final boolean z6) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.16
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f6185a != null) {
                        ShareSDK.f6185a.a(z6);
                    }
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK setFBInstagram catch ", new Object[0]);
                }
            }
        });
    }

    public static void setPlatformDevInfo(String str, HashMap<String, Object> map) {
        try {
            f6187c = str;
            f6188d = map;
            if (MobSDK.isForb() || MobSDK.isAuth() != 1) {
                m();
            } else {
                l();
                j jVar = f6185a;
                if (jVar != null) {
                    jVar.a(str, map);
                }
            }
        } catch (Throwable th) {
            SSDKLog.b().a(th, "ShareSDK setPlatformDevInfo catch ", new Object[0]);
        }
    }

    public static void setPlatformDevInfoAsync(final String str, final HashMap<String, Object> map) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.7
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    String unused = ShareSDK.f6187c = str;
                    HashMap unused2 = ShareSDK.f6188d = map;
                    if (MobSDK.isForb() || MobSDK.isAuth() != 1) {
                        ShareSDK.m();
                    } else {
                        ShareSDK.l();
                        if (ShareSDK.f6185a != null) {
                            ShareSDK.f6185a.a(str, map);
                        }
                    }
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK setPlatformDevInfo catch ", new Object[0]);
                }
            }
        });
    }

    public static void setPlatformDevInfos(List<HashMap<String, Object>> list) {
        try {
            f6189e = list;
            if (MobSDK.isForb() || MobSDK.isAuth() != 1) {
                m();
            } else {
                l();
                j jVar = f6185a;
                if (jVar != null) {
                    jVar.a(f6189e);
                }
            }
        } catch (Throwable th) {
            SSDKLog.b().a(th, "ShareSDK setPlatformDevInfo catch ", new Object[0]);
        }
    }

    public static void setPlatformDevInfosAsync(final List<HashMap<String, Object>> list) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.8
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    List unused = ShareSDK.f6189e = list;
                    if (MobSDK.isForb() || MobSDK.isAuth() != 1) {
                        ShareSDK.m();
                    } else {
                        ShareSDK.l();
                        if (ShareSDK.f6185a != null) {
                            ShareSDK.f6185a.a(ShareSDK.f6189e);
                        }
                    }
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK setPlatformDevInfo catch ", new Object[0]);
                }
            }
        });
    }

    public static void setReadTimeout(int i6) {
        try {
            l();
            j jVar = f6185a;
            if (jVar != null) {
                jVar.b(i6);
            }
        } catch (Throwable th) {
            SSDKLog.b().a(th, "ShareSDK setReadTimeout catch", new Object[0]);
        }
    }

    public static void setReadTimeoutAsync(final int i6) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.31
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f6185a != null) {
                        ShareSDK.f6185a.b(i6);
                    }
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK setReadTimeout catch", new Object[0]);
                }
            }
        });
    }

    public static void unregisterPlatform(final Class<? extends CustomPlatform> cls) throws Throwable {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.29
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                ShareSDK.l();
                if (ShareSDK.f6185a != null) {
                    ShareSDK.f6185a.e(cls);
                }
            }
        });
    }

    public static void unregisterService(final Class<? extends Service> cls) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.23
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f6185a != null) {
                        ShareSDK.f6185a.b(cls);
                    }
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK  unregisterService catch ", new Object[0]);
                }
            }
        });
    }

    public static boolean b() {
        try {
            l();
        } catch (Throwable th) {
            SSDKLog.b().a(th, "ShareSDK isNetworkDevinfoRequested is catch ", new Object[0]);
        }
        j jVar = f6185a;
        if (jVar != null) {
            return jVar.f();
        }
        return false;
    }

    public static void a() {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.1
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() {
                try {
                    ShareSDK.l();
                } catch (Throwable th) {
                    SSDKLog.b().d(th);
                }
            }
        });
    }

    public static void a(final String str, final String str2) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.18
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f6185a != null) {
                        ShareSDK.f6185a.a(str, str2);
                    }
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK copyDevinfo ", new Object[0]);
                }
            }
        });
    }

    public static void a(final int i6, final int i7) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.19
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f6185a != null) {
                        ShareSDK.f6185a.a(i6, i7);
                    }
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK copyNetworkDevinfo catch ", new Object[0]);
                }
            }
        });
    }

    public static String a(int i6, String str) {
        try {
            l();
        } catch (Throwable th) {
            SSDKLog.b().a(th, "ShareSDK getNetworkDevinfo catch ", new Object[0]);
        }
        j jVar = f6185a;
        if (jVar != null) {
            return jVar.a(i6, str);
        }
        return null;
    }

    public static void a(final ShareSDKCallback<Boolean> shareSDKCallback) throws Throwable {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.24
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                ShareSDK.l();
                if (ShareSDK.f6185a != null) {
                    ShareSDK.f6185a.a(shareSDKCallback);
                    return;
                }
                ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                if (shareSDKCallback2 != null) {
                    shareSDKCallback2.onCallback(Boolean.FALSE);
                }
            }
        });
    }

    public static void a(final String str, final boolean z6, final int i6, final String str2, final ShareSDKCallback<String> shareSDKCallback) {
        k.a(new k.a() { // from class: cn.sharesdk.framework.ShareSDK.25
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK getShortLink catch ", new Object[0]);
                }
                if (ShareSDK.f6185a != null) {
                    ShareSDK.f6185a.a(str, z6, i6, str2, shareSDKCallback);
                    return;
                }
                ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                if (shareSDKCallback2 != null) {
                    shareSDKCallback2.onCallback(str);
                }
            }
        });
    }

    @Deprecated
    public static String a(String str) {
        Log.e(OnekeyShare.SHARESDK_TAG, "This method is deprecated , please use uploadImageToFileServer(String imagePath,ShareSDKCallback<String> callback)");
        return null;
    }

    @Deprecated
    public static String a(Bitmap bitmap) {
        Log.e(OnekeyShare.SHARESDK_TAG, "This method is deprecated , please use uploadImageToFileServer(String imagePath,ShareSDKCallback<String> callback)");
        return null;
    }
}
