package com.uz.navee.ui.device;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import com.clj.fastble.data.BleDevice;
import com.lxj.xpopup.core.BottomPopupView;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class TyreSettingPopup extends BottomPopupView {
    public Button A;
    public Button B;
    public QMUIRoundButton C;
    public QMUIRoundButton D;
    public long E;
    public BleDevice F;

    /* renamed from: w, reason: collision with root package name */
    public Button f12456w;

    /* renamed from: x, reason: collision with root package name */
    public Button f12457x;

    /* renamed from: y, reason: collision with root package name */
    public Button f12458y;

    /* renamed from: z, reason: collision with root package name */
    public Button f12459z;

    public TyreSettingPopup(@NonNull Context context) {
        super(context);
    }

    private void T() {
        this.f12456w = (Button) findViewById(R$id.weeks2Button);
        this.f12457x = (Button) findViewById(R$id.month1Button);
        this.f12458y = (Button) findViewById(R$id.months2Button);
        this.f12459z = (Button) findViewById(R$id.months3Button);
        this.A = (Button) findViewById(R$id.months6Button);
        this.B = (Button) findViewById(R$id.unTyreButton);
        this.C = (QMUIRoundButton) findViewById(R$id.cancelButton);
        this.D = (QMUIRoundButton) findViewById(R$id.confirmButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(View view) {
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W() {
        if (this.E > 0) {
            b4.a.T(com.uz.navee.utils.l.b(System.currentTimeMillis() + this.E, "yyyy-MM-dd"), b4.a.r(this.F), String.valueOf(this.E));
        } else {
            b4.a.T("", b4.a.r(this.F), String.valueOf(this.E));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(View view) {
        o(new Runnable() { // from class: com.uz.navee.ui.device.y8
            @Override // java.lang.Runnable
            public final void run() {
                this.f12715a.W();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(View view) {
        i0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(View view) {
        e0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(View view) {
        f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(View view) {
        g0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(View view) {
        h0();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void A() {
        super.A();
        T();
        i0();
        this.C.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.q8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12629a.V(view);
            }
        });
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.r8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12638a.X(view);
            }
        });
        this.f12456w.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.s8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12651a.Y(view);
            }
        });
        this.f12457x.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.t8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12661a.Z(view);
            }
        });
        this.f12458y.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.u8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12672a.a0(view);
            }
        });
        this.f12459z.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.v8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12684a.b0(view);
            }
        });
        this.A.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.w8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12694a.c0(view);
            }
        });
        this.B.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.x8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12705a.d0(view);
            }
        });
    }

    public final void U() {
        this.f12456w.setSelected(false);
        this.f12457x.setSelected(false);
        this.f12458y.setSelected(false);
        this.f12459z.setSelected(false);
        this.A.setSelected(false);
        this.B.setSelected(true);
        this.E = 0L;
    }

    public final /* synthetic */ void d0(View view) {
        U();
    }

    public final void e0() {
        this.f12456w.setSelected(false);
        this.f12457x.setSelected(true);
        this.f12458y.setSelected(false);
        this.f12459z.setSelected(false);
        this.A.setSelected(false);
        this.B.setSelected(false);
        this.E = 2592000000L;
    }

    public final void f0() {
        this.f12456w.setSelected(false);
        this.f12457x.setSelected(false);
        this.f12458y.setSelected(true);
        this.f12459z.setSelected(false);
        this.A.setSelected(false);
        this.B.setSelected(false);
        this.E = 5184000000L;
    }

    public final void g0() {
        this.f12456w.setSelected(false);
        this.f12457x.setSelected(false);
        this.f12458y.setSelected(false);
        this.f12459z.setSelected(true);
        this.A.setSelected(false);
        this.B.setSelected(false);
        this.E = 7776000000L;
    }

    @Override // com.lxj.xpopup.core.BottomPopupView, com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        return R$layout.popup_tyre_setting;
    }

    public final void h0() {
        this.f12456w.setSelected(false);
        this.f12457x.setSelected(false);
        this.f12458y.setSelected(false);
        this.f12459z.setSelected(false);
        this.A.setSelected(true);
        this.B.setSelected(false);
        this.E = 15552000000L;
    }

    public final void i0() {
        this.f12456w.setSelected(true);
        this.f12457x.setSelected(false);
        this.f12458y.setSelected(false);
        this.f12459z.setSelected(false);
        this.A.setSelected(false);
        this.B.setSelected(false);
        this.E = 1209600000L;
    }
}
