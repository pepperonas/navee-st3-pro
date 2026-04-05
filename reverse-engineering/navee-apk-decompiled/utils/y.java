package com.uz.navee.utils;

import android.text.TextUtils;
import com.uz.navee.bean.AreaRes;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class y {
    public static String a() {
        String areaValue;
        AreaRes areaResB = b();
        if (areaResB != null) {
            String[] strArrSplit = areaResB.getAreaValue().split(",");
            areaValue = strArrSplit.length > 0 ? strArrSplit[0] : areaResB.getAreaValue();
        } else {
            areaValue = null;
        }
        return TextUtils.isEmpty(areaValue) ? Locale.getDefault().getCountry() : areaValue;
    }

    public static AreaRes b() {
        return (AreaRes) q.a(g0.d("current_area_json"), AreaRes.class);
    }

    public static String c() {
        AreaRes areaResB = b();
        String areaKey = areaResB == null ? null : areaResB.getAreaKey();
        return TextUtils.isEmpty(areaKey) ? Locale.getDefault().getCountry() : areaKey;
    }

    public static String d() {
        return Locale.getDefault().getCountry();
    }

    public static void e(AreaRes areaRes) {
        g0.f("current_area_json", q.d(areaRes));
    }
}
