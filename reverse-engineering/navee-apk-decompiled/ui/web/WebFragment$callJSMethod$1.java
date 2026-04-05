package com.uz.navee.ui.web;

import android.webkit.ValueCallback;
import java.util.Arrays;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.u;
import kotlinx.coroutines.i0;
import q5.p;

@l5.d(c = "com.uz.navee.ui.web.WebFragment$callJSMethod$1", f = "WebFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WebFragment$callJSMethod$1 extends SuspendLambda implements p {
    final /* synthetic */ ValueCallback<String> $callback;
    final /* synthetic */ String $method;
    final /* synthetic */ Object[] $params;
    int label;
    final /* synthetic */ WebFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebFragment$callJSMethod$1(WebFragment webFragment, String str, ValueCallback<String> valueCallback, Object[] objArr, kotlin.coroutines.c<? super WebFragment$callJSMethod$1> cVar) {
        super(2, cVar);
        this.this$0 = webFragment;
        this.$method = str;
        this.$callback = valueCallback;
        this.$params = objArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<u> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new WebFragment$callJSMethod$1(this.this$0, this.$method, this.$callback, this.$params, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.b.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        j.b(obj);
        DefaultWebView defaultWebView = this.this$0.o().webView;
        String str = this.$method;
        ValueCallback<String> valueCallback = this.$callback;
        Object[] objArr = this.$params;
        defaultWebView.b(str, valueCallback, Arrays.copyOf(objArr, objArr.length));
        return u.f15726a;
    }

    @Override // q5.p
    public final Object invoke(i0 i0Var, kotlin.coroutines.c<? super u> cVar) {
        return ((WebFragment$callJSMethod$1) create(i0Var, cVar)).invokeSuspend(u.f15726a);
    }
}
