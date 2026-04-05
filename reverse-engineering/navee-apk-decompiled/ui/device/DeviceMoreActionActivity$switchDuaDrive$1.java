package com.uz.navee.ui.device;

import e3.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.DelayKt;

@l5.d(c = "com.uz.navee.ui.device.DeviceMoreActionActivity$switchDuaDrive$1", f = "DeviceMoreActionActivity.kt", l = {677}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DeviceMoreActionActivity$switchDuaDrive$1 extends SuspendLambda implements q5.p {
    int label;
    final /* synthetic */ DeviceMoreActionActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceMoreActionActivity$switchDuaDrive$1(DeviceMoreActionActivity deviceMoreActionActivity, kotlin.coroutines.c<? super DeviceMoreActionActivity$switchDuaDrive$1> cVar) {
        super(2, cVar);
        this.this$0 = deviceMoreActionActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<kotlin.u> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new DeviceMoreActionActivity$switchDuaDrive$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = kotlin.coroutines.intrinsics.b.d();
        int i6 = this.label;
        if (i6 == 0) {
            kotlin.j.b(obj);
            this.label = 1;
            if (DelayKt.b(500L, this) == objD) {
                return objD;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.j.b(obj);
        }
        new a.C0192a(this.this$0).f(false).g(l5.a.a(true)).e(l5.a.a(false)).d(l5.a.a(false)).a(new DualDriveOpenPopup(this.this$0)).G();
        return kotlin.u.f15726a;
    }

    @Override // q5.p
    public final Object invoke(kotlinx.coroutines.i0 i0Var, kotlin.coroutines.c<? super kotlin.u> cVar) {
        return ((DeviceMoreActionActivity$switchDuaDrive$1) create(i0Var, cVar)).invokeSuspend(kotlin.u.f15726a);
    }
}
