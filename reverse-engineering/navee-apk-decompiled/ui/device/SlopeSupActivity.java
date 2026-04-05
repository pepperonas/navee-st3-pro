package com.uz.navee.ui.device;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.media3.extractor.ts.TsExtractor;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseBindingActivity;
import com.uz.navee.databinding.ActivitySlopeSupBinding;
import com.uz.navee.utils.CommonExt;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class SlopeSupActivity extends BaseBindingActivity<ActivitySlopeSupBinding> {

    /* renamed from: g, reason: collision with root package name */
    public SwitchCompat f12429g;

    /* renamed from: h, reason: collision with root package name */
    public SwitchCompat f12430h;

    /* renamed from: i, reason: collision with root package name */
    public SwitchCompat f12431i;

    /* renamed from: j, reason: collision with root package name */
    public final kotlin.f f12432j = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.SlopeSupActivity$slopeSup$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Integer> invoke() {
            SlopeSupActivity slopeSupActivity = this.this$0;
            return CommonExt.k(slopeSupActivity, Integer.valueOf(slopeSupActivity.R().getSlopeSup()), "slopeSup");
        }
    });

    /* renamed from: k, reason: collision with root package name */
    public final kotlin.f f12433k = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.SlopeSupActivity$hacOn$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Boolean> invoke() {
            return Transformations.distinctUntilChanged(Transformations.map(this.this$0.n0(), new q5.l() { // from class: com.uz.navee.ui.device.SlopeSupActivity$hacOn$2.1
                @Override // q5.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final Boolean invoke(int i6) {
                    return Boolean.valueOf(com.uz.navee.utils.f.h(i6, 0) == 1);
                }
            }));
        }
    });

    /* renamed from: l, reason: collision with root package name */
    public final kotlin.f f12434l = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.SlopeSupActivity$pasOn$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Boolean> invoke() {
            return Transformations.distinctUntilChanged(Transformations.map(this.this$0.n0(), new q5.l() { // from class: com.uz.navee.ui.device.SlopeSupActivity$pasOn$2.1
                @Override // q5.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final Boolean invoke(int i6) {
                    return Boolean.valueOf(com.uz.navee.utils.f.h(i6, 1) == 1);
                }
            }));
        }
    });

    /* renamed from: m, reason: collision with root package name */
    public final kotlin.f f12435m = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.SlopeSupActivity$hdcOn$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Boolean> invoke() {
            return Transformations.distinctUntilChanged(Transformations.map(this.this$0.n0(), new q5.l() { // from class: com.uz.navee.ui.device.SlopeSupActivity$hdcOn$2.1
                @Override // q5.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final Boolean invoke(int i6) {
                    return Boolean.valueOf(com.uz.navee.utils.f.h(i6, 2) == 1);
                }
            }));
        }
    });

    public static final class a implements Observer, kotlin.jvm.internal.u {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q5.l f12436a;

        public a(q5.l function) {
            kotlin.jvm.internal.y.f(function, "function");
            this.f12436a = function;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.u)) {
                return kotlin.jvm.internal.y.a(getFunctionDelegate(), ((kotlin.jvm.internal.u) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.u
        public final kotlin.c getFunctionDelegate() {
            return this.f12436a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f12436a.invoke(obj);
        }
    }

    public static final void o0(SlopeSupActivity this$0, CompoundButton compoundButton, boolean z6) throws IOException {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        if (kotlin.jvm.internal.y.a(Boolean.valueOf(z6), this$0.k0().getValue())) {
            return;
        }
        this$0.r0(1, z6);
    }

    public static final void p0(SlopeSupActivity this$0, CompoundButton compoundButton, boolean z6) throws IOException {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        if (kotlin.jvm.internal.y.a(Boolean.valueOf(z6), this$0.m0().getValue())) {
            return;
        }
        this$0.r0(2, z6);
    }

    public static final void q0(SlopeSupActivity this$0, CompoundButton compoundButton, boolean z6) throws IOException {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        if (kotlin.jvm.internal.y.a(Boolean.valueOf(z6), this$0.l0().getValue())) {
            return;
        }
        this$0.r0(3, z6);
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public int V() {
        return R$layout.activity_slope_sup;
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public String b0() {
        String string = getString(R$string.HSA);
        kotlin.jvm.internal.y.e(string, "getString(...)");
        return string;
    }

    public final LiveData k0() {
        return (LiveData) this.f12433k.getValue();
    }

    public final LiveData l0() {
        return (LiveData) this.f12435m.getValue();
    }

    public final LiveData m0() {
        return (LiveData) this.f12434l.getValue();
    }

    public final LiveData n0() {
        return (LiveData) this.f12432j.getValue();
    }

    @Override // com.uz.navee.base.BaseBindingActivity, com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SwitchCompat scHac = ((ActivitySlopeSupBinding) Q()).scHac;
        kotlin.jvm.internal.y.e(scHac, "scHac");
        this.f12429g = scHac;
        SwitchCompat scPas = ((ActivitySlopeSupBinding) Q()).scPas;
        kotlin.jvm.internal.y.e(scPas, "scPas");
        this.f12430h = scPas;
        SwitchCompat scHdc = ((ActivitySlopeSupBinding) Q()).scHdc;
        kotlin.jvm.internal.y.e(scHdc, "scHdc");
        this.f12431i = scHdc;
        SwitchCompat switchCompat = this.f12429g;
        SwitchCompat switchCompat2 = null;
        if (switchCompat == null) {
            kotlin.jvm.internal.y.x("hacSwitch");
            switchCompat = null;
        }
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.g8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) throws IOException {
                SlopeSupActivity.o0(this.f12533a, compoundButton, z6);
            }
        });
        SwitchCompat switchCompat3 = this.f12430h;
        if (switchCompat3 == null) {
            kotlin.jvm.internal.y.x("pasSwitch");
            switchCompat3 = null;
        }
        switchCompat3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.h8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) throws IOException {
                SlopeSupActivity.p0(this.f12543a, compoundButton, z6);
            }
        });
        SwitchCompat switchCompat4 = this.f12431i;
        if (switchCompat4 == null) {
            kotlin.jvm.internal.y.x("hdcSwitch");
        } else {
            switchCompat2 = switchCompat4;
        }
        switchCompat2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.i8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) throws IOException {
                SlopeSupActivity.q0(this.f12553a, compoundButton, z6);
            }
        });
        k0().observe(this, new a(new q5.l() { // from class: com.uz.navee.ui.device.SlopeSupActivity.onCreate.4
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) throws Resources.NotFoundException {
                invoke((Boolean) obj);
                return kotlin.u.f15726a;
            }

            public final void invoke(Boolean bool) throws Resources.NotFoundException {
                SwitchCompat switchCompat5 = SlopeSupActivity.this.f12429g;
                if (switchCompat5 == null) {
                    kotlin.jvm.internal.y.x("hacSwitch");
                    switchCompat5 = null;
                }
                kotlin.jvm.internal.y.c(bool);
                switchCompat5.setChecked(bool.booleanValue());
            }
        }));
        m0().observe(this, new a(new q5.l() { // from class: com.uz.navee.ui.device.SlopeSupActivity.onCreate.5
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) throws Resources.NotFoundException {
                invoke((Boolean) obj);
                return kotlin.u.f15726a;
            }

            public final void invoke(Boolean bool) throws Resources.NotFoundException {
                SwitchCompat switchCompat5 = SlopeSupActivity.this.f12430h;
                if (switchCompat5 == null) {
                    kotlin.jvm.internal.y.x("pasSwitch");
                    switchCompat5 = null;
                }
                kotlin.jvm.internal.y.c(bool);
                switchCompat5.setChecked(bool.booleanValue());
            }
        }));
        l0().observe(this, new a(new q5.l() { // from class: com.uz.navee.ui.device.SlopeSupActivity.onCreate.6
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) throws Resources.NotFoundException {
                invoke((Boolean) obj);
                return kotlin.u.f15726a;
            }

            public final void invoke(Boolean bool) throws Resources.NotFoundException {
                SwitchCompat switchCompat5 = SlopeSupActivity.this.f12431i;
                if (switchCompat5 == null) {
                    kotlin.jvm.internal.y.x("hdcSwitch");
                    switchCompat5 = null;
                }
                kotlin.jvm.internal.y.c(bool);
                switchCompat5.setChecked(bool.booleanValue());
            }
        }));
    }

    public final void r0(int i6, boolean z6) throws IOException {
        BaseBindingActivity.Z(this, TsExtractor.TS_STREAM_TYPE_AC3, new byte[]{(byte) i6, z6 ? (byte) 1 : (byte) 0}, false, 4, null);
    }
}
