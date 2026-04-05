package com.uz.navee.utils;

import android.view.View;

/* loaded from: classes3.dex */
public abstract class c0 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public long f13273a = 0;

    public abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f13273a > 500) {
            this.f13273a = jCurrentTimeMillis;
            a(view);
        }
    }
}
