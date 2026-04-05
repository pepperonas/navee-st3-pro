package com.uz.navee.ui.device;

import com.uz.navee.ui.wheel.AlertPopup;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.DelayKt;

@l5.d(c = "com.uz.navee.ui.device.DeviceMoreActionActivity$promptDelay$1", f = "DeviceMoreActionActivity.kt", l = {795}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DeviceMoreActionActivity$promptDelay$1 extends SuspendLambda implements q5.p {
    final /* synthetic */ int $btnText;
    final /* synthetic */ int $msgRes;
    final /* synthetic */ int $titleRes;
    int label;
    final /* synthetic */ DeviceMoreActionActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceMoreActionActivity$promptDelay$1(DeviceMoreActionActivity deviceMoreActionActivity, int i6, int i7, int i8, kotlin.coroutines.c<? super DeviceMoreActionActivity$promptDelay$1> cVar) {
        super(2, cVar);
        this.this$0 = deviceMoreActionActivity;
        this.$titleRes = i6;
        this.$msgRes = i7;
        this.$btnText = i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0() {
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<kotlin.u> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new DeviceMoreActionActivity$promptDelay$1(this.this$0, this.$titleRes, this.$msgRes, this.$btnText, cVar);
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
        DeviceMoreActionActivity deviceMoreActionActivity = this.this$0;
        AlertPopup.Q(deviceMoreActionActivity, deviceMoreActionActivity.getString(this.$titleRes), this.this$0.getString(this.$msgRes), null, this.this$0.getString(this.$btnText), new AlertPopup.a() { // from class: com.uz.navee.ui.device.z5
            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public /* synthetic */ void a() {
                j4.c.a(this);
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public final void b() {
                DeviceMoreActionActivity$promptDelay$1.invokeSuspend$lambda$0();
            }
        });
        return kotlin.u.f15726a;
    }

    @Override // q5.p
    public final Object invoke(kotlinx.coroutines.i0 i0Var, kotlin.coroutines.c<? super kotlin.u> cVar) {
        return ((DeviceMoreActionActivity$promptDelay$1) create(i0Var, cVar)).invokeSuspend(kotlin.u.f15726a);
    }
}
