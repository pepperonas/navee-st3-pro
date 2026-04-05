package com.uz.navee.utils;

import android.os.Build;
import android.text.Html;
import com.google.common.primitives.UnsignedBytes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public abstract class j0 {
    public static String a(String str) {
        if (str == null) {
            return "";
        }
        return (Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(str, 63) : Html.fromHtml(str)).toString().trim();
    }

    public static boolean b(String str) {
        return Pattern.compile("\\d+").matcher(str).matches();
    }

    public static int c(String str) {
        Pattern patternCompile = Pattern.compile("[\\u4E00-\\u9FA5]");
        int i6 = 0;
        int i7 = 0;
        while (i6 < str.length()) {
            int i8 = i6 + 1;
            i7 = patternCompile.matcher(str.substring(i6, i8)).find() ? i7 + 2 : i7 + 1;
            i6 = i8;
        }
        return i7;
    }

    public static String d(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b7 : bArrDigest) {
                int i6 = b7 & UnsignedBytes.MAX_VALUE;
                if (i6 < 16) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(i6));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e7) {
            throw new RuntimeException("NoSuchAlgorithmException", e7);
        }
    }

    public static String e(String str, int i6) {
        Pattern patternCompile = Pattern.compile("[\\u4E00-\\u9FA5]");
        StringBuilder sb = new StringBuilder("");
        int i7 = 0;
        while (i7 < str.length()) {
            int i8 = i7 + 1;
            String strSubstring = str.substring(i7, i8);
            i6 = patternCompile.matcher(strSubstring).find() ? i6 - 2 : i6 - 1;
            if (i6 < 0) {
                break;
            }
            sb.append(strSubstring);
            i7 = i8;
        }
        return sb.toString();
    }

    public static String[] f(String str, String str2) {
        return (str == null || str.isEmpty()) ? new String[0] : str.split(str2);
    }
}
