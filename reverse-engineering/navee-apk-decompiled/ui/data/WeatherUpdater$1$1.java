package com.uz.navee.ui.data;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.internal.y;
import kotlin.u;
import kotlinx.coroutines.i0;
import q5.p;

@l5.d(c = "com.uz.navee.ui.data.WeatherUpdater$1$1", f = "WeatherUpdater.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WeatherUpdater$1$1 extends SuspendLambda implements p {
    final /* synthetic */ Boolean $success;
    int label;
    final /* synthetic */ WeatherUpdater this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeatherUpdater$1$1(Boolean bool, WeatherUpdater weatherUpdater, kotlin.coroutines.c<? super WeatherUpdater$1$1> cVar) {
        super(2, cVar);
        this.$success = bool;
        this.this$0 = weatherUpdater;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<u> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new WeatherUpdater$1$1(this.$success, this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.b.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        j.b(obj);
        Boolean success = this.$success;
        y.e(success, "$success");
        if (success.booleanValue()) {
            this.this$0.j();
        } else {
            this.this$0.i();
        }
        return u.f15726a;
    }

    @Override // q5.p
    public final Object invoke(i0 i0Var, kotlin.coroutines.c<? super u> cVar) {
        return ((WeatherUpdater$1$1) create(i0Var, cVar)).invokeSuspend(u.f15726a);
    }
}
