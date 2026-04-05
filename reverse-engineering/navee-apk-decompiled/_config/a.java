package e4;

import com.uz.navee.utils.g0;

/* loaded from: classes3.dex */
public abstract class a {
    public static String a() {
        Object objA = g0.a("Environment", 0);
        int iIntValue = objA != null ? ((Integer) objA).intValue() : 0;
        return iIntValue == 0 ? "https://lj.naveetech.com/tundra-api" : iIntValue == 1 ? "https://alb.chejiyou.com/tundra-api" : iIntValue == 2 ? "http://naveeap.chejiyou.com/tundra-api" : "https://lj.naveetech.com/tundra-api";
    }
}
