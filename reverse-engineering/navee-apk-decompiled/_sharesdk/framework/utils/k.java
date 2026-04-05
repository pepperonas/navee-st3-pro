package cn.sharesdk.framework.utils;

import android.text.TextUtils;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static ThreadPoolExecutor f6479a;

    /* renamed from: b, reason: collision with root package name */
    private static ScheduledExecutorService f6480b = Executors.newSingleThreadScheduledExecutor();

    public static abstract class a implements Runnable {
        public abstract void a() throws Throwable;

        public void a(Throwable th) {
        }

        public String b() {
            return "";
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (!TextUtils.isEmpty(b())) {
                    Thread.currentThread().setName(b());
                }
                a();
            } catch (Throwable th) {
                try {
                    a(th);
                } catch (Throwable unused) {
                }
                SSDKLog.b().d(th);
            }
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 3L, TimeUnit.MINUTES, new LinkedBlockingQueue());
        f6479a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static void a(Runnable runnable) {
        try {
            f6479a.execute(runnable);
        } catch (Throwable th) {
            SSDKLog.b().d(th);
        }
    }

    public static <T extends a> void a(T t6) {
        try {
            f6480b.execute(t6);
        } catch (Throwable th) {
            SSDKLog.b().d(th);
        }
    }
}
