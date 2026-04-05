package com.uz.navee.utils;

import android.graphics.Insets;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f13286a = new n();

    public static final void b(View targetView, final boolean z6, final boolean z7) {
        kotlin.jvm.internal.y.f(targetView, "targetView");
        if ((z6 || z7) && Build.VERSION.SDK_INT >= 35) {
            targetView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.uz.navee.utils.m
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return n.c(z6, z7, view, windowInsets);
                }
            });
        }
    }

    public static final WindowInsets c(boolean z6, boolean z7, View view, WindowInsets windowInsets) {
        kotlin.jvm.internal.y.f(view, "view");
        kotlin.jvm.internal.y.f(windowInsets, "windowInsets");
        Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
        kotlin.jvm.internal.y.e(insets, "getInsets(...)");
        view.setPadding(view.getPaddingLeft(), z6 ? insets.top : 0, view.getPaddingRight(), z7 ? insets.bottom : 0);
        return windowInsets;
    }
}
