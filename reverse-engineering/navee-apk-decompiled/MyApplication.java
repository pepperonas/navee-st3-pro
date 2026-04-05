package com.uz.navee;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import cn.jiguang.verifysdk.api.JVerificationInterface;
import cn.jiguang.verifysdk.api.RequestCallback;
import g4.e1;

/* loaded from: classes3.dex */
public class MyApplication extends Application {

    /* renamed from: c, reason: collision with root package name */
    public static Context f11586c;

    /* renamed from: d, reason: collision with root package name */
    public static Application f11587d;

    /* renamed from: e, reason: collision with root package name */
    public static MainActivity f11588e;

    /* renamed from: a, reason: collision with root package name */
    public boolean f11589a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11590b;

    public class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            e.c().f(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            e.c().f(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    public static Context b() {
        return f11586c;
    }

    public static Application c() {
        return f11587d;
    }

    public static /* synthetic */ void e(int i6, String str) {
        f4.b.c("JVerificationInterface init,code=%d,result=%s", Integer.valueOf(i6), str);
    }

    public final void d() {
        registerActivityLifecycleCallbacks(new a());
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        k1.c.a(this);
        f11586c = getApplicationContext();
        f11587d = this;
        d();
        JVerificationInterface.setDebugMode(false);
        JVerificationInterface.init(this, new RequestCallback() { // from class: com.uz.navee.f
            @Override // cn.jiguang.verifysdk.api.RequestCallback
            public final void onResult(int i6, Object obj) {
                MyApplication.e(i6, (String) obj);
            }
        });
        e1.u().l();
    }
}
