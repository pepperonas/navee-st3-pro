package com.uz.navee.utils;

import android.view.View;
import android.widget.ScrollView;

/* loaded from: classes3.dex */
public abstract class h0 {
    public static void a(ScrollView scrollView, View view) {
        if (scrollView == null || view == null) {
            return;
        }
        int scrollY = scrollView.getScrollY();
        int height = scrollView.getHeight() + scrollY;
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        scrollView.getLocationInWindow(iArr2);
        int i6 = (iArr[1] - iArr2[1]) + scrollY;
        int height2 = view.getHeight() + i6;
        if (i6 < scrollY || height2 > height) {
            scrollView.smoothScrollTo(0, Math.max(height2 - scrollView.getHeight(), 0));
        }
    }
}
