package cn.sharesdk.framework.a.b;

import com.mob.MobSDK;

/* loaded from: classes2.dex */
public abstract class e {

    /* renamed from: e, reason: collision with root package name */
    public long f6282e;

    /* renamed from: f, reason: collision with root package name */
    public String f6283f;

    /* renamed from: g, reason: collision with root package name */
    public String f6284g;

    /* renamed from: h, reason: collision with root package name */
    public int f6285h;

    /* renamed from: i, reason: collision with root package name */
    public String f6286i;

    /* renamed from: j, reason: collision with root package name */
    public int f6287j;

    /* renamed from: k, reason: collision with root package name */
    public String f6288k;

    /* renamed from: l, reason: collision with root package name */
    public String f6289l;

    /* renamed from: m, reason: collision with root package name */
    public String f6290m;

    /* renamed from: n, reason: collision with root package name */
    public String f6291n;

    public abstract String a();

    public abstract void a(long j6);

    public abstract int b();

    public abstract int c();

    public abstract long d();

    public abstract long e();

    public abstract void f();

    public boolean g() {
        int iB = b();
        int iC = c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - e() < iB) {
            return d() < ((long) iC);
        }
        a(jCurrentTimeMillis);
        return true;
    }

    public void h() {
        f();
    }

    public String toString() {
        return a() + ':' + this.f6282e + '|' + this.f6283f + '|' + MobSDK.getAppkey() + '|' + this.f6284g + '|' + this.f6285h + '|' + this.f6286i + '|' + this.f6287j + '|' + this.f6288k;
    }
}
