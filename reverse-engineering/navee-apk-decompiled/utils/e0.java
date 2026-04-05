package com.uz.navee.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.PriorityQueue;

/* loaded from: classes3.dex */
public class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final PriorityQueue f13275a;

    /* renamed from: b, reason: collision with root package name */
    public a f13276b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f13277c;

    public static abstract class a implements Runnable, Comparable {

        /* renamed from: a, reason: collision with root package name */
        public int f13278a;

        /* renamed from: b, reason: collision with root package name */
        public String f13279b;

        public a(int i6, String str) {
            this.f13278a = i6;
            this.f13279b = str;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            if (aVar == null) {
                return 1;
            }
            return this.f13278a - aVar.f13278a;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final e0 f13280a = new e0();
    }

    public static e0 f() {
        return b.f13280a;
    }

    public void a(a aVar) {
        if (aVar == null || b(aVar.f13279b)) {
            return;
        }
        if (this.f13276b != null) {
            this.f13275a.add(aVar);
        } else {
            c(aVar);
        }
    }

    public boolean b(String str) {
        a aVar = this.f13276b;
        boolean z6 = aVar != null && TextUtils.equals(str, aVar.f13279b);
        if (!z6) {
            Iterator it = this.f13275a.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(((a) it.next()).f13279b, str)) {
                    return true;
                }
            }
        }
        return z6;
    }

    public final void c(a aVar) {
        this.f13276b = aVar;
        this.f13277c.post(aVar);
    }

    public void d(a aVar) {
        if (this.f13275a.isEmpty() || !this.f13275a.remove(aVar)) {
            if (this.f13276b == aVar) {
                this.f13276b = null;
            }
            if (this.f13276b == null) {
                c((a) this.f13275a.poll());
            }
        }
    }

    public void e(String str) {
        a aVar = this.f13276b;
        if (aVar != null && TextUtils.equals(str, aVar.f13279b)) {
            d(this.f13276b);
            return;
        }
        Iterator it = this.f13275a.iterator();
        while (it.hasNext()) {
            a aVar2 = (a) it.next();
            if (TextUtils.equals(str, aVar2.f13279b)) {
                this.f13275a.remove(aVar2);
                return;
            }
        }
    }

    public e0() {
        this.f13275a = new PriorityQueue();
        this.f13277c = new Handler(Looper.getMainLooper());
    }
}
