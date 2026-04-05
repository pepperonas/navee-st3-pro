package com.uz.navee.utils;

import android.util.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import kotlin.LazyThreadSafetyMode;

/* loaded from: classes3.dex */
public final class Window {

    /* renamed from: a, reason: collision with root package name */
    public static final Window f13267a = new Window();

    /* renamed from: b, reason: collision with root package name */
    public static final kotlin.f f13268b;

    /* renamed from: c, reason: collision with root package name */
    public static final kotlin.f f13269c;

    /* renamed from: d, reason: collision with root package name */
    public static final kotlin.f f13270d;

    /* renamed from: e, reason: collision with root package name */
    public static final kotlin.f f13271e;

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        f13268b = kotlin.h.a(lazyThreadSafetyMode, new q5.a() { // from class: com.uz.navee.utils.Window$windowManagerClass$2
            @Override // q5.a
            public final Class<?> invoke() {
                try {
                    return Class.forName("android.view.WindowManagerGlobal");
                } catch (Throwable th) {
                    Log.w("WindowManagerSpy", th);
                    return null;
                }
            }
        });
        f13269c = kotlin.h.a(lazyThreadSafetyMode, new q5.a() { // from class: com.uz.navee.utils.Window$windowManagerInstance$2
            @Override // q5.a
            public final Object invoke() {
                Class clsF = Window.f13267a.f();
                if (clsF != null) {
                    return clsF.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                }
                return null;
            }
        });
        f13270d = kotlin.h.a(lazyThreadSafetyMode, new q5.a() { // from class: com.uz.navee.utils.Window$mViewsField$2
            @Override // q5.a
            public final Field invoke() throws NoSuchFieldException, SecurityException {
                Class clsF = Window.f13267a.f();
                if (clsF == null) {
                    return null;
                }
                Field declaredField = clsF.getDeclaredField("mViews");
                declaredField.setAccessible(true);
                return declaredField;
            }
        });
        f13271e = kotlin.h.a(lazyThreadSafetyMode, new q5.a() { // from class: com.uz.navee.utils.Window$mParams$2
            @Override // q5.a
            public final Field invoke() throws NoSuchFieldException, SecurityException {
                Class clsF = Window.f13267a.f();
                if (clsF == null) {
                    return null;
                }
                Field declaredField = clsF.getDeclaredField("mParams");
                declaredField.setAccessible(true);
                return declaredField;
            }
        });
    }

    public final Field b() {
        return (Field) f13271e.getValue();
    }

    public final Field c() {
        return (Field) f13270d.getValue();
    }

    public final List d() {
        Field fieldB;
        try {
            Object objG = g();
            if (objG != null && (fieldB = f13267a.b()) != null) {
                Object obj = fieldB.get(objG);
                kotlin.jvm.internal.y.d(obj, "null cannot be cast to non-null type java.util.ArrayList<android.view.WindowManager.LayoutParams>{ kotlin.collections.TypeAliasesKt.ArrayList<android.view.WindowManager.LayoutParams> }");
                return (ArrayList) obj;
            }
        } catch (Throwable th) {
            Log.w("WindowManagerSpy", th);
        }
        return new ArrayList();
    }

    public final List e() {
        Field fieldC;
        try {
            Object objG = g();
            if (objG != null && (fieldC = f13267a.c()) != null) {
                Object obj = fieldC.get(objG);
                kotlin.jvm.internal.y.d(obj, "null cannot be cast to non-null type java.util.ArrayList<android.view.View>{ kotlin.collections.TypeAliasesKt.ArrayList<android.view.View> }");
                return (ArrayList) obj;
            }
        } catch (Throwable th) {
            Log.w("WindowManagerSpy", th);
        }
        return new ArrayList();
    }

    public final Class f() {
        return (Class) f13268b.getValue();
    }

    public final Object g() {
        return f13269c.getValue();
    }
}
