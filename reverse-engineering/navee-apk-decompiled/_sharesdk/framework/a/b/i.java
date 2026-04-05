package cn.sharesdk.framework.a.b;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public class i extends j {
    @Override // cn.sharesdk.framework.a.b.j, cn.sharesdk.framework.a.b.e
    public String a() {
        return "[SHE]";
    }

    @Override // cn.sharesdk.framework.a.b.j, cn.sharesdk.framework.a.b.e
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('|');
        if (!TextUtils.isEmpty(this.f6290m)) {
            sb.append(this.f6290m);
        }
        sb.append('|');
        if (!TextUtils.isEmpty(this.f6291n)) {
            sb.append(this.f6291n);
        }
        return sb.toString();
    }
}
