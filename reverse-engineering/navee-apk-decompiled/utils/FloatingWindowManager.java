package com.uz.navee.utils;

import android.app.Activity;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class FloatingWindowManager {

    /* renamed from: a, reason: collision with root package name */
    public static final FloatingWindowManager f13265a = new FloatingWindowManager();

    /* renamed from: b, reason: collision with root package name */
    public static final kotlin.f f13266b = kotlin.h.b(new q5.a() { // from class: com.uz.navee.utils.FloatingWindowManager$lifecycle$2
        @Override // q5.a
        public final p invoke() {
            return new p();
        }
    });

    public final List a(Activity activity) {
        kotlin.jvm.internal.y.f(activity, "activity");
        View decorView = activity.getWindow().getDecorView();
        kotlin.jvm.internal.y.e(decorView, "getDecorView(...)");
        IBinder windowToken = decorView.getWindowToken();
        List listE = Window.f13267a.e();
        ArrayList arrayList = new ArrayList(kotlin.collections.u.u(listE, 10));
        Iterator it = listE.iterator();
        while (it.hasNext()) {
            arrayList.add((View) it.next());
        }
        List listZ0 = kotlin.collections.b0.z0(arrayList);
        Iterator it2 = listZ0.iterator();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i7 = -1;
                break;
            }
            if (kotlin.jvm.internal.y.a((View) it2.next(), decorView)) {
                break;
            }
            i7++;
        }
        List listD = Window.f13267a.d();
        IBinder iBinder = ((WindowManager.LayoutParams) listD.get(i7)).token;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listD) {
            int i8 = i6 + 1;
            if (i6 < 0) {
                kotlin.collections.t.t();
            }
            IBinder iBinder2 = ((WindowManager.LayoutParams) obj).token;
            if (i6 != i7 && (kotlin.jvm.internal.y.a(iBinder2, windowToken) || iBinder2 == null || kotlin.jvm.internal.y.a(iBinder2, iBinder))) {
                arrayList2.add(listZ0.get(i6));
            }
            i6 = i8;
        }
        return arrayList2;
    }
}
