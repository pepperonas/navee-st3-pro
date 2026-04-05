package cn.sharesdk.framework.a.b;

/* loaded from: classes2.dex */
public class a extends e {

    /* renamed from: c, reason: collision with root package name */
    private static int f6272c;

    /* renamed from: d, reason: collision with root package name */
    private static long f6273d;

    /* renamed from: a, reason: collision with root package name */
    public int f6274a;

    /* renamed from: b, reason: collision with root package name */
    public String f6275b;

    @Override // cn.sharesdk.framework.a.b.e
    public String a() {
        return "[API]";
    }

    @Override // cn.sharesdk.framework.a.b.e
    public int b() {
        return 5000;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public int c() {
        return 50;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public long d() {
        return f6272c;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public long e() {
        return f6273d;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public void f() {
        f6272c++;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public String toString() {
        return super.toString() + '|' + this.f6274a + '|' + this.f6275b;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public void a(long j6) {
        f6273d = j6;
    }
}
