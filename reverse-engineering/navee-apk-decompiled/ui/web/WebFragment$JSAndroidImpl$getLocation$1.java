package com.uz.navee.ui.web;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.u;
import kotlinx.coroutines.i0;
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.b;
import q5.p;

@l5.d(c = "com.uz.navee.ui.web.WebFragment$JSAndroidImpl$getLocation$1", f = "WebFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WebFragment$JSAndroidImpl$getLocation$1 extends SuspendLambda implements p {
    int label;
    final /* synthetic */ WebFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebFragment$JSAndroidImpl$getLocation$1(WebFragment webFragment, kotlin.coroutines.c<? super WebFragment$JSAndroidImpl$getLocation$1> cVar) {
        super(2, cVar);
        this.this$0 = webFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<u> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new WebFragment$JSAndroidImpl$getLocation$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.b.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        j.b(obj);
        EasyPermissions.f(new b.C0243b(this.this$0, 1001, "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION").a());
        return u.f15726a;
    }

    @Override // q5.p
    public final Object invoke(i0 i0Var, kotlin.coroutines.c<? super u> cVar) {
        return ((WebFragment$JSAndroidImpl$getLocation$1) create(i0Var, cVar)).invokeSuspend(u.f15726a);
    }
}
