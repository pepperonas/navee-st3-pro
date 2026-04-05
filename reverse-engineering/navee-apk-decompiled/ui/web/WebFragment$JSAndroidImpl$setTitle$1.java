package com.uz.navee.ui.web;

import androidx.appcompat.widget.Toolbar;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.internal.y;
import kotlin.u;
import kotlinx.coroutines.i0;
import q5.p;

@l5.d(c = "com.uz.navee.ui.web.WebFragment$JSAndroidImpl$setTitle$1", f = "WebFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WebFragment$JSAndroidImpl$setTitle$1 extends SuspendLambda implements p {
    final /* synthetic */ String $title;
    int label;
    final /* synthetic */ WebFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebFragment$JSAndroidImpl$setTitle$1(WebFragment webFragment, String str, kotlin.coroutines.c<? super WebFragment$JSAndroidImpl$setTitle$1> cVar) {
        super(2, cVar);
        this.this$0 = webFragment;
        this.$title = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<u> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new WebFragment$JSAndroidImpl$setTitle$1(this.this$0, this.$title, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.b.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        j.b(obj);
        Toolbar toolbar = this.this$0.o().include.toolbar;
        y.e(toolbar, "toolbar");
        toolbar.setVisibility(0);
        this.this$0.o().include.titleViewToolbar.setText(this.$title);
        return u.f15726a;
    }

    @Override // q5.p
    public final Object invoke(i0 i0Var, kotlin.coroutines.c<? super u> cVar) {
        return ((WebFragment$JSAndroidImpl$setTitle$1) create(i0Var, cVar)).invokeSuspend(u.f15726a);
    }
}
