package com.uz.navee.ui.web;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.uz.navee.R$mipmap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.internal.y;
import kotlin.u;
import kotlinx.coroutines.i0;
import q5.p;

@l5.d(c = "com.uz.navee.ui.web.WebFragment$share$2$file$1", f = "WebFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WebFragment$share$2$file$1 extends SuspendLambda implements p {
    int label;
    final /* synthetic */ WebFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebFragment$share$2$file$1(WebFragment webFragment, kotlin.coroutines.c<? super WebFragment$share$2$file$1> cVar) {
        super(2, cVar);
        this.this$0 = webFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<u> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new WebFragment$share$2$file$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.b.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        j.b(obj);
        Drawable drawable = ContextCompat.getDrawable(this.this$0.requireActivity(), R$mipmap.ic_launcher);
        y.d(drawable, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        File file = new File(this.this$0.requireActivity().getCacheDir(), "images");
        file.mkdirs();
        File file2 = new File(file, "appIcon.png");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                kotlin.io.a.a(fileOutputStream, null);
                return file2;
            } finally {
            }
        } catch (IOException e7) {
            e7.printStackTrace();
            return null;
        }
    }

    @Override // q5.p
    public final Object invoke(i0 i0Var, kotlin.coroutines.c<? super File> cVar) {
        return ((WebFragment$share$2$file$1) create(i0Var, cVar)).invokeSuspend(u.f15726a);
    }
}
