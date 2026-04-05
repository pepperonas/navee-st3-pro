package cn.sharesdk.framework;

import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static volatile c f6369b;

    /* renamed from: a, reason: collision with root package name */
    private boolean f6370a = false;

    private c() {
        new Thread() { // from class: cn.sharesdk.framework.c.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    c.this.f6370a = MobSDK.isForb();
                } catch (Throwable th) {
                    SSDKLog.b().b(th);
                }
            }
        }.start();
    }

    public static c a() {
        synchronized (c.class) {
            try {
                if (f6369b == null) {
                    synchronized (c.class) {
                        try {
                            if (f6369b == null) {
                                f6369b = new c();
                            }
                        } finally {
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f6369b;
    }
}
