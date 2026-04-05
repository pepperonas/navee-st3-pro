package com.uz.navee;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: classes3.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    public static Stack f11669b;

    /* renamed from: c, reason: collision with root package name */
    public static final e f11670c = new e();

    /* renamed from: a, reason: collision with root package name */
    public WeakReference f11671a;

    public static Activity a(Class cls) {
        Stack stack = f11669b;
        if (stack == null) {
            return null;
        }
        Iterator it = stack.iterator();
        while (it.hasNext()) {
            Activity activity = (Activity) it.next();
            if (activity.getClass().equals(cls) && !activity.equals(f11669b.lastElement())) {
                return activity;
            }
        }
        return null;
    }

    public static e c() {
        return f11670c;
    }

    public Activity b() {
        WeakReference weakReference = this.f11671a;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return (Activity) this.f11671a.get();
    }

    public void d(Activity activity) {
        if (activity != null) {
            f11669b.remove(activity);
        }
    }

    public void e(Activity activity) {
        if (f11669b == null) {
            f11669b = new Stack();
        }
        f11669b.add(activity);
    }

    public void f(Activity activity) {
        this.f11671a = new WeakReference(activity);
    }
}
