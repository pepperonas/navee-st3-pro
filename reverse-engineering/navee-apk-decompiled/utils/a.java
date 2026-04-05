package com.uz.navee.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/* loaded from: classes3.dex */
public abstract class a {
    public static ObjectAnimator a(Object obj, String str, long j6, int i6, float... fArr) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(obj, str, fArr).setDuration(j6);
        duration.setRepeatCount(i6);
        return duration;
    }

    public static void b(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(c(view));
        animatorSet.start();
    }

    public static ObjectAnimator c(Object obj) {
        return a(obj, "translationX", 500L, 1, 0.0f, -5.0f, 5.0f, 0.0f, -5.0f, 5.0f, 0.0f, -5.0f, 5.0f, 0.0f);
    }
}
