package com.uz.navee.utils;

import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public abstract class l {
    public static long a(String str) throws ParseException {
        if (Build.VERSION.SDK_INT >= 26) {
            return Math.abs(LocalDate.parse(str).toEpochDay() - LocalDate.now().toEpochDay());
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            Date date = simpleDateFormat.parse(str);
            Date date2 = simpleDateFormat.parse(e("yyyy-MM-dd", TimeZone.getDefault()));
            if (date != null) {
                return Math.abs((date2.getTime() / JConstants.DAY) - (date.getTime() / JConstants.DAY));
            }
        } catch (Exception e7) {
            f4.b.e(e7, "", new Object[0]);
        }
        return 0L;
    }

    public static String b(long j6, String str) {
        return c(j6, str, null);
    }

    public static String c(long j6, String str, String str2) {
        if (str == null || str.isEmpty()) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
        if (!TextUtils.isEmpty(str2)) {
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(str2));
        }
        return simpleDateFormat.format(new Date(j6));
    }

    public static boolean d(long j6, long j7) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j6);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j7);
        return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public static String e(String str, TimeZone timeZone) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(new Date());
    }

    public static Date f(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            str2 = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        try {
            return simpleDateFormat.parse(str);
        } catch (Exception e7) {
            f4.b.e(e7, "", new Object[0]);
            return null;
        }
    }

    public static Date g(String str, String str2, String str3) {
        if (str2 == null || str2.isEmpty()) {
            str2 = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(str3));
        try {
            return simpleDateFormat.parse(str);
        } catch (Exception e7) {
            f4.b.e(e7, "", new Object[0]);
            return null;
        }
    }
}
