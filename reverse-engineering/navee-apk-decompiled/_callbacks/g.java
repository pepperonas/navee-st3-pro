package c4;

import com.uz.navee.utils.h;

/* loaded from: classes3.dex */
public class g extends h {

    /* renamed from: b, reason: collision with root package name */
    public final long f2045b;

    /* renamed from: c, reason: collision with root package name */
    public f f2046c;

    public g(long j6) {
        this.f2045b = j6;
    }

    @Override // com.uz.navee.utils.h
    public void a() throws InterruptedException {
        super.a();
        try {
            Thread.sleep(this.f2045b);
            this.f2046c.a(this);
        } catch (InterruptedException e7) {
            throw new RuntimeException(e7);
        }
    }
}
