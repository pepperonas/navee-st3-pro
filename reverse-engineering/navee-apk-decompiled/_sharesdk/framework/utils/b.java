package cn.sharesdk.framework.utils;

import android.util.Base64;
import com.google.common.net.HttpHeaders;
import com.mob.tools.network.KVPair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private C0088b f6453a = new C0088b();

    /* renamed from: b, reason: collision with root package name */
    private d f6454b = new d("-._~", false);

    /* renamed from: cn.sharesdk.framework.utils.b$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6455a;

        static {
            int[] iArr = new int[a.values().length];
            f6455a = iArr;
            try {
                iArr[a.HMAC_SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6455a[a.PLAINTEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum a {
        HMAC_SHA1,
        PLAINTEXT
    }

    /* renamed from: cn.sharesdk.framework.utils.b$b, reason: collision with other inner class name */
    public static class C0088b {

        /* renamed from: a, reason: collision with root package name */
        public String f6459a;

        /* renamed from: b, reason: collision with root package name */
        public String f6460b;

        /* renamed from: c, reason: collision with root package name */
        public String f6461c;

        /* renamed from: d, reason: collision with root package name */
        public String f6462d;

        /* renamed from: e, reason: collision with root package name */
        public String f6463e;
    }

    public void a(String str, String str2, String str3) {
        C0088b c0088b = this.f6453a;
        c0088b.f6459a = str;
        c0088b.f6460b = str2;
        c0088b.f6463e = str3;
    }

    public ArrayList<KVPair<String>> b(String str, ArrayList<KVPair<String>> arrayList) throws Throwable {
        return b(str, arrayList, a.HMAC_SHA1);
    }

    public ArrayList<KVPair<String>> c(String str, ArrayList<KVPair<String>> arrayList, a aVar) throws Throwable {
        return a(str, "PUT", arrayList, aVar);
    }

    public ArrayList<KVPair<String>> b(String str, ArrayList<KVPair<String>> arrayList, a aVar) throws Throwable {
        return a(str, "GET", arrayList, aVar);
    }

    private String b(ArrayList<KVPair<String>> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder();
            Iterator<KVPair<String>> it = arrayList.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                if (i6 > 0) {
                    sb.append('&');
                }
                sb.append(next.name);
                sb.append('=');
                sb.append(next.value);
                i6++;
            }
            return sb.toString();
        }
        return "";
    }

    public C0088b a() {
        return this.f6453a;
    }

    public ArrayList<KVPair<String>> a(String str, ArrayList<KVPair<String>> arrayList) throws Throwable {
        return a(str, arrayList, a.HMAC_SHA1);
    }

    public ArrayList<KVPair<String>> a(String str, ArrayList<KVPair<String>> arrayList, a aVar) throws Throwable {
        return a(str, "POST", arrayList, aVar);
    }

    public void a(String str, String str2) {
        C0088b c0088b = this.f6453a;
        c0088b.f6461c = str;
        c0088b.f6462d = str2;
    }

    private ArrayList<KVPair<String>> a(String str, String str2, ArrayList<KVPair<String>> arrayList, a aVar) throws Throwable {
        String strTrim;
        String str3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i6 = AnonymousClass1.f6455a[aVar.ordinal()];
        if (i6 == 1) {
            SecretKeySpec secretKeySpec = new SecretKeySpec((a(this.f6453a.f6460b) + '&' + a(this.f6453a.f6462d)).getBytes("utf-8"), "HMAC-SHA1");
            Mac mac = Mac.getInstance("HMAC-SHA1");
            mac.init(secretKeySpec);
            strTrim = new String(Base64.encode(mac.doFinal((str2 + '&' + a(str) + '&' + a(b(a(jCurrentTimeMillis, arrayList, "HMAC-SHA1")))).getBytes("utf-8")), 0)).trim();
            str3 = "HMAC-SHA1";
        } else if (i6 != 2) {
            str3 = null;
            strTrim = null;
        } else {
            strTrim = a(this.f6453a.f6460b) + '&' + a(this.f6453a.f6462d);
            str3 = "PLAINTEXT";
        }
        ArrayList<KVPair<String>> arrayListA = a(jCurrentTimeMillis, str3);
        arrayListA.add(new KVPair<>("oauth_signature", strTrim));
        return arrayListA;
    }

    public String a(String str) {
        if (str == null) {
            return "";
        }
        return this.f6454b.escape(str);
    }

    private ArrayList<KVPair<String>> a(long j6, ArrayList<KVPair<String>> arrayList, String str) {
        HashMap map = new HashMap();
        if (arrayList != null) {
            Iterator<KVPair<String>> it = arrayList.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                map.put(a(next.name), a(next.value));
            }
        }
        ArrayList<KVPair<String>> arrayListA = a(j6, str);
        if (arrayListA != null) {
            Iterator<KVPair<String>> it2 = arrayListA.iterator();
            while (it2.hasNext()) {
                KVPair<String> next2 = it2.next();
                map.put(a(next2.name), a(next2.value));
            }
        }
        int size = map.size();
        String[] strArr = new String[size];
        Iterator it3 = map.entrySet().iterator();
        int i6 = 0;
        while (it3.hasNext()) {
            strArr[i6] = (String) ((Map.Entry) it3.next()).getKey();
            i6++;
        }
        Arrays.sort(strArr);
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        for (int i7 = 0; i7 < size; i7++) {
            String str2 = strArr[i7];
            arrayList2.add(new KVPair<>(str2, map.get(str2)));
        }
        return arrayList2;
    }

    private ArrayList<KVPair<String>> a(long j6, String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("oauth_consumer_key", this.f6453a.f6459a));
        arrayList.add(new KVPair<>("oauth_signature_method", str));
        arrayList.add(new KVPair<>("oauth_timestamp", String.valueOf(j6 / 1000)));
        arrayList.add(new KVPair<>("oauth_nonce", String.valueOf(j6)));
        arrayList.add(new KVPair<>("oauth_version", "1.0"));
        String str2 = this.f6453a.f6461c;
        if (str2 != null && str2.length() > 0) {
            arrayList.add(new KVPair<>("oauth_token", str2));
        }
        return arrayList;
    }

    public ArrayList<KVPair<String>> a(ArrayList<KVPair<String>> arrayList) {
        StringBuilder sb = new StringBuilder("OAuth ");
        Iterator<KVPair<String>> it = arrayList.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            KVPair<String> next = it.next();
            if (i6 > 0) {
                sb.append(',');
            }
            String strA = a(next.value);
            sb.append(next.name);
            sb.append("=\"");
            sb.append(strA);
            sb.append("\"");
            i6++;
        }
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>(HttpHeaders.AUTHORIZATION, sb.toString()));
        arrayList2.add(new KVPair<>(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded"));
        return arrayList2;
    }
}
