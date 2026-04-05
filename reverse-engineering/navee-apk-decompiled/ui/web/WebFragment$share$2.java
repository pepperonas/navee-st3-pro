package com.uz.navee.ui.web;

import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.u;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.g;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.u0;
import q5.p;

@l5.d(c = "com.uz.navee.ui.web.WebFragment$share$2", f = "WebFragment.kt", l = {456}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WebFragment$share$2 extends SuspendLambda implements p {
    final /* synthetic */ Intent $sendIntent;
    int label;
    final /* synthetic */ WebFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebFragment$share$2(Intent intent, WebFragment webFragment, kotlin.coroutines.c<? super WebFragment$share$2> cVar) {
        super(2, cVar);
        this.$sendIntent = intent;
        this.this$0 = webFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<u> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new WebFragment$share$2(this.$sendIntent, this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Uri uriForFile;
        Object objD = kotlin.coroutines.intrinsics.b.d();
        int i6 = this.label;
        if (i6 == 0) {
            j.b(obj);
            CoroutineDispatcher coroutineDispatcherB = u0.b();
            WebFragment$share$2$file$1 webFragment$share$2$file$1 = new WebFragment$share$2$file$1(this.this$0, null);
            this.label = 1;
            obj = g.g(coroutineDispatcherB, webFragment$share$2$file$1, this);
            if (obj == objD) {
                return objD;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j.b(obj);
        }
        File file = (File) obj;
        if (file != null) {
            WebFragment webFragment = this.this$0;
            uriForFile = FileProvider.getUriForFile(webFragment.requireActivity(), webFragment.requireActivity().getPackageName() + ".fileProvider", file);
        } else {
            uriForFile = null;
        }
        if (uriForFile != null) {
            this.$sendIntent.putExtra("android.intent.extra.STREAM", uriForFile);
        }
        this.$sendIntent.setFlags(1);
        this.this$0.startActivity(Intent.createChooser(this.$sendIntent, null));
        return u.f15726a;
    }

    @Override // q5.p
    public final Object invoke(i0 i0Var, kotlin.coroutines.c<? super u> cVar) {
        return ((WebFragment$share$2) create(i0Var, cVar)).invokeSuspend(u.f15726a);
    }
}
