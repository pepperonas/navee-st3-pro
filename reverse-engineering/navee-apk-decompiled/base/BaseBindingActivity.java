package com.uz.navee.base;

import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.clj.fastble.data.BleDevice;
import com.uz.navee.R$color;
import com.uz.navee.bean.DeviceCarInfo;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.bean.VehicleModel;
import com.uz.navee.utils.CommonExt;
import java.io.IOException;
import java.util.Arrays;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.y;
import q5.l;

/* loaded from: classes3.dex */
public abstract class BaseBindingActivity<DataBinding extends ViewDataBinding> extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public final kotlin.f f11595c = kotlin.h.b(new q5.a(this) { // from class: com.uz.navee.base.BaseBindingActivity$device$2
        final /* synthetic */ BaseBindingActivity<DataBinding> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        @Override // q5.a
        public final BleDevice invoke() {
            return CommonExt.e(this.this$0);
        }
    });

    /* renamed from: d, reason: collision with root package name */
    public final kotlin.f f11596d = kotlin.h.b(new q5.a(this) { // from class: com.uz.navee.base.BaseBindingActivity$vehicle$2
        final /* synthetic */ BaseBindingActivity<DataBinding> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        @Override // q5.a
        public final Vehicle invoke() {
            return CommonExt.h(this.this$0);
        }
    });

    /* renamed from: e, reason: collision with root package name */
    public final kotlin.f f11597e = kotlin.h.b(new q5.a(this) { // from class: com.uz.navee.base.BaseBindingActivity$pid$2
        final /* synthetic */ BaseBindingActivity<DataBinding> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        @Override // q5.a
        public final String invoke() {
            VehicleModel vehicleModel;
            Vehicle vehicleU = this.this$0.U();
            if (vehicleU == null || (vehicleModel = vehicleU.model) == null) {
                return null;
            }
            return vehicleModel.pid;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    public ViewDataBinding f11598f;

    public static /* synthetic */ void Y(BaseBindingActivity baseBindingActivity, int i6, int i7, boolean z6, int i8, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendCmd");
        }
        if ((i8 & 4) != 0) {
            z6 = false;
        }
        baseBindingActivity.W(i6, i7, z6);
    }

    public static /* synthetic */ void Z(BaseBindingActivity baseBindingActivity, int i6, byte[] bArr, boolean z6, int i7, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendCmd");
        }
        if ((i7 & 4) != 0) {
            z6 = false;
        }
        baseBindingActivity.X(i6, bArr, z6);
    }

    public final ViewDataBinding Q() {
        ViewDataBinding viewDataBinding = this.f11598f;
        if (viewDataBinding != null) {
            return viewDataBinding;
        }
        y.x("binding");
        return null;
    }

    public final DeviceCarInfo R() {
        return b4.a.W().f1933f;
    }

    public final BleDevice S() {
        return (BleDevice) this.f11595c.getValue();
    }

    public final String T() {
        return (String) this.f11597e.getValue();
    }

    public final Vehicle U() {
        return (Vehicle) this.f11596d.getValue();
    }

    public abstract int V();

    public final void W(int i6, int i7, boolean z6) throws IOException {
        byte[] bArrK = b4.a.k(i6, i7, z6);
        f4.b.c("sendCmd cmd=0X%02X, value=0X%02X", Integer.valueOf(i6), Integer.valueOf(i7));
        b4.a.c0(S(), bArrK);
    }

    public final void X(int i6, byte[] values, boolean z6) throws IOException {
        y.f(values, "values");
        byte[] bArrL = b4.a.l(i6, values, z6);
        f4.b.c("sendCmd cmd=0X%02X, value=%s", Integer.valueOf(i6), ArraysKt___ArraysKt.e0(values, ",", null, null, 0, null, new l() { // from class: com.uz.navee.base.BaseBindingActivity$sendCmd$1
            public final CharSequence invoke(byte b7) {
                String str = String.format("0X%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b7)}, 1));
                y.e(str, "format(...)");
                return str;
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).byteValue());
            }
        }, 30, null));
        b4.a.c0(S(), bArrL);
    }

    public final void a0(ViewDataBinding viewDataBinding) {
        y.f(viewDataBinding, "<set-?>");
        this.f11598f = viewDataBinding;
    }

    public abstract String b0();

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, V());
        contentView.setLifecycleOwner(this);
        y.e(contentView, "also(...)");
        a0(contentView);
        String strB0 = b0();
        if (strB0 != null) {
            com.uz.navee.utils.c.e(this, strB0, ContextCompat.getColor(this, R$color.nav_title_color));
        }
    }
}
