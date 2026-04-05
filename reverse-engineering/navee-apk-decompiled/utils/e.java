package com.uz.navee.utils;

import android.app.Activity;
import androidx.core.view.accessibility.AccessibilityEventCompat;

/* loaded from: classes3.dex */
public abstract class e {
    public static boolean a(Activity activity) {
        return b(activity.getWindow());
    }

    public static boolean b(android.view.Window window) {
        if (window == null) {
            return false;
        }
        window.clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1280);
        window.setStatusBarColor(0);
        return true;
    }
}
