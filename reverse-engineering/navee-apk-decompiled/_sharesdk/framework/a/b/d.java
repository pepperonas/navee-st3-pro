package cn.sharesdk.framework.a.b;

import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.utils.Data;

/* loaded from: classes2.dex */
public class d extends e {

    /* renamed from: o, reason: collision with root package name */
    private static int f6276o;

    /* renamed from: p, reason: collision with root package name */
    private static long f6277p;

    /* renamed from: a, reason: collision with root package name */
    public int f6278a;

    /* renamed from: b, reason: collision with root package name */
    public String f6279b;

    /* renamed from: c, reason: collision with root package name */
    public String f6280c;

    /* renamed from: d, reason: collision with root package name */
    public String f6281d;

    @Override // cn.sharesdk.framework.a.b.e
    public String a() {
        return "[AUT]";
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
        return f6276o;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public long e() {
        return f6277p;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public void f() {
        f6276o++;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('|');
        sb.append(this.f6278a);
        sb.append('|');
        sb.append(this.f6279b);
        sb.append('|');
        if (!TextUtils.isEmpty(this.f6281d)) {
            try {
                String strEncodeToString = Base64.encodeToString(Data.AES128Encode(this.f6283f.substring(0, 16), this.f6281d), 0);
                if (!TextUtils.isEmpty(strEncodeToString) && strEncodeToString.contains("\n")) {
                    strEncodeToString = strEncodeToString.replace("\n", "");
                }
                sb.append(strEncodeToString);
            } catch (Throwable th) {
                SSDKLog.b().a(th);
            }
        }
        sb.append('|');
        if (!TextUtils.isEmpty(this.f6289l)) {
            sb.append(this.f6289l);
        }
        sb.append('|');
        if (!TextUtils.isEmpty(this.f6280c)) {
            sb.append(this.f6280c);
        }
        return sb.toString();
    }

    @Override // cn.sharesdk.framework.a.b.e
    public void a(long j6) {
        f6277p = j6;
    }
}
