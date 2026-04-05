package cn.sharesdk.framework.utils;

import cn.sharesdk.framework.ShareSDK;
import com.mob.tools.log.NLog;

/* loaded from: classes2.dex */
public class SSDKLog {

    /* renamed from: a, reason: collision with root package name */
    private static SSDKLog f6441a;

    /* renamed from: b, reason: collision with root package name */
    private static NLog f6442b;

    /* renamed from: c, reason: collision with root package name */
    private final int f6443c = -1;

    private SSDKLog() {
        a();
    }

    private boolean a(NLog nLog) {
        return nLog != null;
    }

    public static SSDKLog b() {
        if (f6441a == null) {
            f6441a = new SSDKLog();
        }
        return f6441a;
    }

    public final int c(Throwable th) {
        try {
            if (a(f6442b)) {
                return f6442b.log(4, th);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int d(Throwable th) {
        try {
            if (a(f6442b)) {
                return f6442b.log(6, th);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static NLog a() {
        try {
            try {
                NLog nLog = NLog.getInstance(ShareSDK.SDK_TAG, ShareSDK.SDK_VERSION_CODE, "cn.sharesdk");
                f6442b = nLog;
                return nLog;
            } catch (Throwable unused) {
                return null;
            }
        } catch (Throwable unused2) {
            NLog nLog2 = NLog.getInstance(ShareSDK.SDK_TAG);
            f6442b = nLog2;
            return nLog2;
        }
    }

    public final int c(Object obj, Object... objArr) {
        try {
            if (a(f6442b)) {
                return f6442b.log(4, obj, objArr);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int d(Object obj, Object... objArr) {
        try {
            if (a(f6442b)) {
                return f6442b.log(6, obj, objArr);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int a(Throwable th) {
        try {
            if (a(f6442b)) {
                return f6442b.log(3, th);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int b(Throwable th) {
        try {
            if (a(f6442b)) {
                return f6442b.log(5, th);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int a(Object obj, Object... objArr) {
        try {
            if (a(f6442b)) {
                return f6442b.log(3, obj, objArr);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int b(Object obj, Object... objArr) {
        try {
            if (a(f6442b)) {
                return f6442b.log(5, obj, objArr);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int a(Throwable th, Object obj, Object... objArr) {
        try {
            if (a(f6442b)) {
                return f6442b.log(3, th, obj, objArr);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int b(Throwable th, Object obj, Object... objArr) {
        try {
            if (a(f6442b)) {
                return f6442b.log(5, th, obj, objArr);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int a(String str) {
        try {
            if (a(f6442b)) {
                return f6442b.log(5, str, new Object[0]);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int b(String str) {
        try {
            if (a(f6442b)) {
                return f6442b.log(4, str, new Object[0]);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
