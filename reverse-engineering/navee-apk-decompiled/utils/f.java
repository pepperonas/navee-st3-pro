package com.uz.navee.utils;

import com.google.android.gms.stats.CodePackage;
import com.google.common.primitives.UnsignedBytes;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public abstract class f {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        try {
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        } catch (Exception unused) {
        }
        return bArr3;
    }

    public static byte[] b(byte[] bArr, byte b7) {
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length + 1);
        bArrCopyOf[bArrCopyOf.length - 1] = b7;
        return bArrCopyOf;
    }

    public static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (byte b7 : bArr) {
            String hexString = Integer.toHexString(b7 & UnsignedBytes.MAX_VALUE);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
            sb.append(" ");
        }
        if (bArr.length > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    public static int d(byte[] bArr) {
        int length = 0;
        for (int i6 = 0; i6 < bArr.length; i6++) {
            length += (bArr[i6] & UnsignedBytes.MAX_VALUE) << (((bArr.length - 1) - i6) * 8);
        }
        return length;
    }

    public static byte[] e(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        for (int length = bArr.length - 1; length >= 0; length--) {
            bArr2[(bArr.length - 1) - length] = bArr[length];
        }
        return bArr2;
    }

    public static byte[] f(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding".replace(CodePackage.GCM, "ECB"));
            cipher.init(1, secretKeySpec);
            return cipher.doFinal(bArr);
        } catch (Exception e7) {
            e7.printStackTrace();
            return new byte[0];
        }
    }

    public static byte[] g(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        if (bArr.length == bArr2.length) {
            for (int i6 = 0; i6 < bArr.length; i6++) {
                bArr3[i6] = (byte) (bArr[i6] ^ bArr2[i6]);
            }
        }
        return bArr3;
    }

    public static int h(int i6, int i7) {
        return (i6 >> i7) & 1;
    }

    public static long i(byte[] bArr, int i6, int i7, boolean z6) {
        if (i7 < 1 || i7 > 8 || i6 < 0 || i6 + i7 > bArr.length) {
            return 0L;
        }
        byte[] bArr2 = new byte[8];
        if (z6) {
            System.arraycopy(bArr, i6, bArr2, 8 - i7, i7);
        } else {
            System.arraycopy(bArr, i6, bArr2, 0, i7);
        }
        return p(bArr2[0], bArr2[1], bArr2[2], bArr2[3], bArr2[4], bArr2[5], bArr2[6], bArr2[7], z6);
    }

    public static int j(byte[] bArr, int i6, int i7, boolean z6) {
        int i8 = i6 + i7;
        if (bArr.length < i8) {
            return 0;
        }
        if (i7 == 1) {
            return bArr[i6] & UnsignedBytes.MAX_VALUE;
        }
        if (i7 <= 1) {
            return 0;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i6, i8);
        if (!z6) {
            bArrCopyOfRange = e(bArrCopyOfRange);
        }
        return d(bArrCopyOfRange);
    }

    public static byte[] k(byte[] bArr, byte[] bArr2, int i6) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        try {
            System.arraycopy(Arrays.copyOfRange(bArr, 0, i6), 0, bArr3, 0, i6);
            System.arraycopy(bArr2, 0, bArr3, i6, bArr2.length);
            System.arraycopy(Arrays.copyOfRange(bArr, i6, bArr.length), 0, bArr3, bArr2.length + i6, bArr.length - i6);
        } catch (Exception unused) {
        }
        return bArr3;
    }

    public static byte[] l(int i6) {
        return new byte[]{(byte) ((i6 >>> 8) & 255), (byte) (i6 & 255)};
    }

    public static byte[] m(long j6, int i6) {
        byte[] bArr = new byte[6];
        byte b7 = (byte) ((j6 >>> 40) & 255);
        if (b7 <= 0) {
            b7 = (byte) (i6 & 255);
        }
        bArr[0] = b7;
        bArr[1] = (byte) ((j6 >>> 32) & 255);
        bArr[2] = (byte) ((j6 >>> 24) & 255);
        bArr[3] = (byte) ((j6 >>> 16) & 255);
        bArr[4] = (byte) ((j6 >>> 8) & 255);
        bArr[5] = (byte) (j6 & 255);
        return bArr;
    }

    public static long n(byte b7, byte b8, byte b9, byte b10, byte b11, byte b12, byte b13, byte b14) {
        return ((b8 & UnsignedBytes.MAX_VALUE) << 48) | ((b7 & UnsignedBytes.MAX_VALUE) << 56) | ((b9 & UnsignedBytes.MAX_VALUE) << 40) | ((b10 & UnsignedBytes.MAX_VALUE) << 32) | ((b11 & UnsignedBytes.MAX_VALUE) << 24) | ((b12 & UnsignedBytes.MAX_VALUE) << 16) | ((b13 & UnsignedBytes.MAX_VALUE) << 8) | (b14 & UnsignedBytes.MAX_VALUE);
    }

    public static byte[] o(long j6, boolean z6) {
        byte[] bArr = new byte[8];
        if (z6) {
            bArr[0] = (byte) (j6 >> 56);
            bArr[1] = (byte) (j6 >> 48);
            bArr[2] = (byte) (j6 >> 40);
            bArr[3] = (byte) (j6 >> 32);
            bArr[4] = (byte) (j6 >> 24);
            bArr[5] = (byte) (j6 >> 16);
            bArr[6] = (byte) (j6 >> 8);
            bArr[7] = (byte) j6;
        } else {
            bArr[7] = (byte) (j6 >> 56);
            bArr[6] = (byte) (j6 >> 48);
            bArr[5] = (byte) (j6 >> 40);
            bArr[4] = (byte) (j6 >> 32);
            bArr[3] = (byte) (j6 >> 24);
            bArr[2] = (byte) (j6 >> 16);
            bArr[1] = (byte) (j6 >> 8);
            bArr[0] = (byte) j6;
        }
        return bArr;
    }

    public static long p(byte b7, byte b8, byte b9, byte b10, byte b11, byte b12, byte b13, byte b14, boolean z6) {
        return z6 ? n(b7, b8, b9, b10, b11, b12, b13, b14) : n(b14, b13, b12, b11, b10, b9, b8, b7);
    }
}
