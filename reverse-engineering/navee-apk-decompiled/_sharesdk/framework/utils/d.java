package cn.sharesdk.framework.utils;

/* loaded from: classes2.dex */
public class d extends l {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f6464a = {'+'};

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f6465b = "0123456789ABCDEF".toCharArray();

    /* renamed from: c, reason: collision with root package name */
    private final boolean f6466c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean[] f6467d;

    public d(String str, boolean z6) {
        if (str.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        }
        if (z6 && str.contains(" ")) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        }
        if (str.contains("%")) {
            throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
        }
        this.f6466c = z6;
        this.f6467d = a(str);
    }

    private static boolean[] a(String str) {
        char[] charArray = str.toCharArray();
        int iMax = 122;
        for (char c7 : charArray) {
            iMax = Math.max((int) c7, iMax);
        }
        boolean[] zArr = new boolean[iMax + 1];
        for (int i6 = 48; i6 <= 57; i6++) {
            zArr[i6] = true;
        }
        for (int i7 = 65; i7 <= 90; i7++) {
            zArr[i7] = true;
        }
        for (int i8 = 97; i8 <= 122; i8++) {
            zArr[i8] = true;
        }
        for (char c8 : charArray) {
            zArr[c8] = true;
        }
        return zArr;
    }

    @Override // cn.sharesdk.framework.utils.l, cn.sharesdk.framework.utils.Escaper
    public String escape(String str) {
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            char cCharAt = str.charAt(i6);
            boolean[] zArr = this.f6467d;
            if (cCharAt >= zArr.length || !zArr[cCharAt]) {
                return a(str, i6);
            }
        }
        return str;
    }

    @Override // cn.sharesdk.framework.utils.l
    public int a(CharSequence charSequence, int i6, int i7) {
        while (i6 < i7) {
            char cCharAt = charSequence.charAt(i6);
            boolean[] zArr = this.f6467d;
            if (cCharAt >= zArr.length || !zArr[cCharAt]) {
                break;
            }
            i6++;
        }
        return i6;
    }

    @Override // cn.sharesdk.framework.utils.l
    public char[] a(int i6) {
        boolean[] zArr = this.f6467d;
        if (i6 < zArr.length && zArr[i6]) {
            return null;
        }
        if (i6 == 32 && this.f6466c) {
            return f6464a;
        }
        if (i6 <= 127) {
            char[] cArr = f6465b;
            return new char[]{'%', cArr[i6 >>> 4], cArr[i6 & 15]};
        }
        if (i6 <= 2047) {
            char[] cArr2 = f6465b;
            char c7 = cArr2[i6 & 15];
            return new char[]{'%', cArr2[(i6 >>> 10) | 12], cArr2[(i6 >>> 6) & 15], '%', cArr2[8 | ((i6 >>> 4) & 3)], c7};
        }
        if (i6 <= 65535) {
            char[] cArr3 = f6465b;
            char c8 = cArr3[i6 & 15];
            char c9 = cArr3[((i6 >>> 4) & 3) | 8];
            return new char[]{'%', 'E', cArr3[i6 >>> 12], '%', cArr3[((i6 >>> 10) & 3) | 8], cArr3[(i6 >>> 6) & 15], '%', c9, c8};
        }
        if (i6 <= 1114111) {
            char[] cArr4 = f6465b;
            char c10 = cArr4[i6 & 15];
            char c11 = cArr4[((i6 >>> 4) & 3) | 8];
            char c12 = cArr4[(i6 >>> 6) & 15];
            char c13 = cArr4[((i6 >>> 10) & 3) | 8];
            return new char[]{'%', 'F', cArr4[(i6 >>> 18) & 7], '%', cArr4[((i6 >>> 16) & 3) | 8], cArr4[(i6 >>> 12) & 15], '%', c13, c12, '%', c11, c10};
        }
        throw new IllegalArgumentException("Invalid unicode character value " + i6);
    }
}
