package cn.sharesdk.framework.a.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.utils.SSDKLog;
import com.google.android.gms.common.internal.ImagesContract;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class j extends e {

    /* renamed from: q, reason: collision with root package name */
    private static int f6300q;

    /* renamed from: r, reason: collision with root package name */
    private static long f6301r;

    /* renamed from: a, reason: collision with root package name */
    public int f6302a;

    /* renamed from: b, reason: collision with root package name */
    public String f6303b;

    /* renamed from: c, reason: collision with root package name */
    public String f6304c;

    /* renamed from: d, reason: collision with root package name */
    public a f6305d = new a();

    /* renamed from: o, reason: collision with root package name */
    public String f6306o;

    /* renamed from: p, reason: collision with root package name */
    public String[] f6307p;

    public static class a {

        /* renamed from: b, reason: collision with root package name */
        public String f6309b;

        /* renamed from: g, reason: collision with root package name */
        public HashMap<String, Object> f6314g;

        /* renamed from: a, reason: collision with root package name */
        public String f6308a = "";

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<String> f6310c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<String> f6311d = new ArrayList<>();

        /* renamed from: e, reason: collision with root package name */
        public ArrayList<String> f6312e = new ArrayList<>();

        /* renamed from: f, reason: collision with root package name */
        public ArrayList<Bitmap> f6313f = new ArrayList<>();

        public String toString() {
            HashMap map = new HashMap();
            if (!TextUtils.isEmpty(this.f6309b)) {
                String strReplaceAll = this.f6309b.trim().replaceAll("\r", "");
                this.f6309b = strReplaceAll;
                String strReplaceAll2 = strReplaceAll.trim().replaceAll("\n", "");
                this.f6309b = strReplaceAll2;
                this.f6309b = strReplaceAll2.trim().replaceAll("\r\n", "");
            }
            map.put("text", this.f6309b);
            map.put(ImagesContract.URL, this.f6310c);
            ArrayList<String> arrayList = this.f6311d;
            if (arrayList != null && arrayList.size() > 0) {
                map.put("imgs", this.f6311d);
            }
            if (this.f6314g != null) {
                map.put("attch", new Hashon().fromHashMap(this.f6314g));
            }
            return new Hashon().fromHashMap(map);
        }
    }

    @Override // cn.sharesdk.framework.a.b.e
    public String a() {
        return "[SHR]";
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
        return f6300q;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public long e() {
        return f6301r;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public void f() {
        f6300q++;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('|');
        sb.append(this.f6302a);
        sb.append('|');
        sb.append(this.f6303b);
        sb.append('|');
        sb.append(TextUtils.isEmpty(this.f6304c) ? "" : this.f6304c);
        String[] strArr = this.f6307p;
        if (strArr == null || strArr.length <= 0) {
            str = "";
        } else {
            str = "[\"" + TextUtils.join("\",\"", this.f6307p) + "\"]";
        }
        sb.append('|');
        sb.append(str);
        sb.append('|');
        a aVar = this.f6305d;
        if (aVar != null) {
            try {
                String strEncodeToString = Base64.encodeToString(Data.AES128Encode(this.f6283f.substring(0, 16), aVar.toString()), 0);
                if (strEncodeToString.contains("\n")) {
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
        if (!TextUtils.isEmpty(this.f6306o)) {
            try {
                String strEncodeToString2 = Base64.encodeToString(Data.AES128Encode(this.f6283f.substring(0, 16), this.f6306o), 0);
                if (!TextUtils.isEmpty(strEncodeToString2) && strEncodeToString2.contains("\n")) {
                    strEncodeToString2 = strEncodeToString2.replace("\n", "");
                }
                sb.append(strEncodeToString2);
            } catch (Throwable th2) {
                SSDKLog.b().b(th2);
            }
        }
        return sb.toString();
    }

    @Override // cn.sharesdk.framework.a.b.e
    public void a(long j6) {
        f6301r = j6;
    }
}
