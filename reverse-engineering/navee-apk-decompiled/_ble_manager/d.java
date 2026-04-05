package b4;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public abstract class d {
    public static boolean a(String str) {
        return j(str, "2442", "2518", "2519");
    }

    public static boolean b(String str) {
        return j(str, "2402", "2403", "2418");
    }

    public static boolean c(String str) {
        return j(str, "2545", "2566", "2582", "2583", "2546", "2584");
    }

    public static boolean d(String str) {
        return j(str, "2435", "2515", "2700");
    }

    public static boolean e(String str) {
        return j(str, "2540", "2543", "2544", "2449", "2657", "2658", "2707");
    }

    public static boolean f(String str) {
        return (TextUtils.isEmpty(str) || str.startsWith("2213") || str.startsWith("2314") || str.startsWith("2327") || str.startsWith("2328") || str.startsWith("2329") || str.startsWith("2326") || str.startsWith("2322") || str.startsWith("2333") || str.startsWith("2334") || str.startsWith("2332") || str.startsWith("2305") || str.startsWith("2306") || str.startsWith("2315") || str.startsWith("2353") || str.startsWith("2417") || str.startsWith("2422") || i(str)) ? false : true;
    }

    public static boolean g(String str) {
        return j(str, "2401", "2345");
    }

    public static boolean h(String str) {
        return j(str, "2441", "2517");
    }

    public static boolean i(String str) {
        return j(str, "2504", "2505", "2506");
    }

    public static boolean j(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : strArr) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(String str) {
        return j(str, "2619", "2620");
    }

    public static boolean l(String str) {
        return j(str, "2538", "2547", "2585");
    }

    public static boolean m(String str) {
        return j(str, "2416", "2443", "2529");
    }

    public static boolean n(String str) {
        return TextUtils.isEmpty(str) || str.startsWith("2213") || str.startsWith("2327") || str.startsWith("2328") || str.startsWith("2329") || str.startsWith("2326") || str.startsWith("2322") || str.startsWith("2333") || str.startsWith("2334") || str.startsWith("2332") || str.startsWith("2305") || str.startsWith("2306") || str.startsWith("2315") || str.startsWith("2353") || str.startsWith("2417") || str.startsWith("2422");
    }
}
