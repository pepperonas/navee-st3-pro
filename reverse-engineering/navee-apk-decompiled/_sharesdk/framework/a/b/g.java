package cn.sharesdk.framework.a.b;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public class g extends e {

    /* renamed from: b, reason: collision with root package name */
    private static int f6297b;

    /* renamed from: c, reason: collision with root package name */
    private static long f6298c;

    /* renamed from: a, reason: collision with root package name */
    public long f6299a;

    @Override // cn.sharesdk.framework.a.b.e
    public String a() {
        return "[EXT]";
    }

    @Override // cn.sharesdk.framework.a.b.e
    public int b() {
        return 5000;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public int c() {
        return 5;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public long d() {
        return f6297b;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public long e() {
        return f6298c;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public void f() {
        f6297b++;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public boolean g() {
        cn.sharesdk.framework.a.a.e eVarA = cn.sharesdk.framework.a.a.e.a();
        f6297b = eVarA.k("insertExitEventCount");
        f6298c = eVarA.j("lastInsertExitEventTime");
        return super.g();
    }

    @Override // cn.sharesdk.framework.a.b.e
    public void h() {
        super.h();
        cn.sharesdk.framework.a.a.e eVarA = cn.sharesdk.framework.a.a.e.a();
        eVarA.a("lastInsertExitEventTime", Long.valueOf(f6298c));
        eVarA.a("insertExitEventCount", f6297b);
    }

    @Override // cn.sharesdk.framework.a.b.e
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('|');
        if (!TextUtils.isEmpty(this.f6289l)) {
            sb.append(this.f6289l);
        }
        sb.append('|');
        sb.append(Math.round(this.f6299a / 1000.0f));
        return sb.toString();
    }

    @Override // cn.sharesdk.framework.a.b.e
    public void a(long j6) {
        f6298c = j6;
    }
}
