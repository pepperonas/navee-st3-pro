package com.uz.navee.ui.web;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;
import com.uz.navee.utils.s;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.internal.y;
import kotlin.u;
import kotlinx.coroutines.i0;
import q5.p;

@l5.d(c = "com.uz.navee.ui.web.WebFragment$captureWeb$1$1$1", f = "WebFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WebFragment$captureWeb$1$1$1 extends SuspendLambda implements p {
    final /* synthetic */ Bitmap $bitmap;
    int label;
    final /* synthetic */ WebFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebFragment$captureWeb$1$1$1(Bitmap bitmap, WebFragment webFragment, kotlin.coroutines.c<? super WebFragment$captureWeb$1$1$1> cVar) {
        super(2, cVar);
        this.$bitmap = bitmap;
        this.this$0 = webFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<u> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new WebFragment$captureWeb$1$1$1(this.$bitmap, this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.b.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        j.b(obj);
        String str = "Screenshot_" + System.currentTimeMillis() + ".jpeg";
        String str2 = Build.VERSION.SDK_INT >= 29 ? Environment.DIRECTORY_SCREENSHOTS : null;
        Bitmap bitmap = this.$bitmap;
        Context contextRequireContext = this.this$0.requireContext();
        y.e(contextRequireContext, "requireContext(...)");
        s.h(bitmap, contextRequireContext, str, str2, 0, 8, null);
        return u.f15726a;
    }

    @Override // q5.p
    public final Object invoke(i0 i0Var, kotlin.coroutines.c<? super u> cVar) {
        return ((WebFragment$captureWeb$1$1$1) create(i0Var, cVar)).invokeSuspend(u.f15726a);
    }
}
