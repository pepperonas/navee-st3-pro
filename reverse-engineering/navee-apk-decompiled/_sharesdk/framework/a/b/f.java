package cn.sharesdk.framework.a.b;

/* loaded from: classes2.dex */
public class f extends e {

    /* renamed from: d, reason: collision with root package name */
    private static int f6292d;

    /* renamed from: o, reason: collision with root package name */
    private static long f6293o;

    /* renamed from: a, reason: collision with root package name */
    public String f6294a;

    /* renamed from: b, reason: collision with root package name */
    public int f6295b;

    /* renamed from: c, reason: collision with root package name */
    public String f6296c = "";

    @Override // cn.sharesdk.framework.a.b.e
    public String a() {
        return "[EVT]";
    }

    @Override // cn.sharesdk.framework.a.b.e
    public int b() {
        return 5000;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public int c() {
        return 30;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public long d() {
        return f6292d;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public long e() {
        return f6293o;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public void f() {
        f6292d++;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public String toString() {
        return super.toString() + '|' + this.f6294a + '|' + this.f6295b + '|' + this.f6296c;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public void a(long j6) {
        f6293o = j6;
    }
}
