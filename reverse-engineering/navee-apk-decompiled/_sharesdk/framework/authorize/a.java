package cn.sharesdk.framework.authorize;

import android.app.Activity;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f6359a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f6360b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6361c;

    public static a c() {
        synchronized (a.class) {
            try {
                if (f6359a == null) {
                    synchronized (a.class) {
                        try {
                            if (f6359a == null) {
                                f6359a = new a();
                            }
                        } finally {
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f6359a;
    }

    public boolean a() {
        return this.f6361c;
    }

    public Activity b() {
        return this.f6360b;
    }

    public void a(boolean z6) {
        this.f6361c = z6;
    }

    public void a(Activity activity) {
        this.f6360b = activity;
    }
}
