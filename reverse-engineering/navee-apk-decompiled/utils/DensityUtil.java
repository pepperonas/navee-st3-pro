package com.uz.navee.utils;

import android.content.Context;

/* loaded from: classes3.dex */
public abstract class DensityUtil {

    public enum LayoutType {
        WIDTH,
        HEIGHT
    }

    public static int a(Context context, float f7) {
        return (int) ((f7 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Context context, float f7) {
        return (int) ((f7 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int c(Context context, float f7) {
        return (int) ((f7 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
