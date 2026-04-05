package com.uz.navee.ui.device;

import android.os.Bundle;
import android.widget.RadioGroup;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseBindingActivity;
import com.uz.navee.databinding.ActivityDeviceLockTimeBinding;
import com.uz.navee.utils.CommonExt;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class DeviceLockTimeActivity extends BaseBindingActivity<ActivityDeviceLockTimeBinding> {

    /* renamed from: h, reason: collision with root package name */
    public static final a f12216h = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public final kotlin.f f12217g = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.DeviceLockTimeActivity$lockTime$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Integer> invoke() {
            return CommonExt.k(this.this$0, Integer.valueOf(b4.a.W().f1933f.getLockTime()), "lockTime");
        }
    });

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.r rVar) {
            this();
        }
    }

    public static final class b implements Observer, kotlin.jvm.internal.u {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q5.l f12218a;

        public b(q5.l function) {
            kotlin.jvm.internal.y.f(function, "function");
            this.f12218a = function;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.u)) {
                return kotlin.jvm.internal.y.a(getFunctionDelegate(), ((kotlin.jvm.internal.u) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.u
        public final kotlin.c getFunctionDelegate() {
            return this.f12218a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f12218a.invoke(obj);
        }
    }

    public static final /* synthetic */ ActivityDeviceLockTimeBinding d0(DeviceLockTimeActivity deviceLockTimeActivity) {
        return (ActivityDeviceLockTimeBinding) deviceLockTimeActivity.Q();
    }

    public static final void f0(DeviceLockTimeActivity this$0, RadioGroup radioGroup, int i6) throws IOException {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        int i7 = i6 == R$id.rb_12 ? 2 : i6 == R$id.rb_24 ? 3 : 1;
        Integer num = (Integer) this$0.e0().getValue();
        if (num != null && i7 == num.intValue()) {
            return;
        }
        BaseBindingActivity.Z(this$0, 111, new byte[]{2, (byte) i7}, false, 4, null);
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public int V() {
        return R$layout.activity_device_lock_time;
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public String b0() {
        String string = getString(R$string.lock_time_setting);
        kotlin.jvm.internal.y.e(string, "getString(...)");
        return string;
    }

    public final LiveData e0() {
        return (LiveData) this.f12217g.getValue();
    }

    @Override // com.uz.navee.base.BaseBindingActivity, com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((ActivityDeviceLockTimeBinding) Q()).rgTime.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.q5
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i6) throws IOException {
                DeviceLockTimeActivity.f0(this.f12626a, radioGroup, i6);
            }
        });
        e0().observe(this, new b(new q5.l() { // from class: com.uz.navee.ui.device.DeviceLockTimeActivity.onCreate.2
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return kotlin.u.f15726a;
            }

            public final void invoke(Integer num) {
                ((num != null && num.intValue() == 2) ? DeviceLockTimeActivity.d0(DeviceLockTimeActivity.this).rb12 : (num != null && num.intValue() == 3) ? DeviceLockTimeActivity.d0(DeviceLockTimeActivity.this).rb24 : DeviceLockTimeActivity.d0(DeviceLockTimeActivity.this).rb6).setChecked(true);
            }
        }));
    }
}
