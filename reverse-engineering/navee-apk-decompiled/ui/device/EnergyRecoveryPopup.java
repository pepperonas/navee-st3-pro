package com.uz.navee.ui.device;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.text.SpannableString;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.lxj.xpopup.core.BottomPopupView;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.bean.DeviceCarInfo;
import com.uz.navee.ui.device.EnergyRecoveryPopup;
import com.uz.navee.ui.wheel.AlertPopup;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class EnergyRecoveryPopup extends BottomPopupView {
    public ImageButton A;
    public TextView B;
    public TextView C;
    public Button D;
    public Button E;
    public b F;
    public PropertyChangeListener G;

    /* renamed from: w, reason: collision with root package name */
    public ImageButton f12351w;

    /* renamed from: x, reason: collision with root package name */
    public TextView f12352x;

    /* renamed from: y, reason: collision with root package name */
    public ImageButton f12353y;

    /* renamed from: z, reason: collision with root package name */
    public TextView f12354z;

    public class a implements View.OnClickListener {
        public a() {
        }

        public static /* synthetic */ void b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertPopup.Q(EnergyRecoveryPopup.this.getContext(), EnergyRecoveryPopup.this.getResources().getString(R$string.kind_tips), EnergyRecoveryPopup.this.getResources().getString(R$string.energy_recovery_tips), null, EnergyRecoveryPopup.this.getResources().getString(R$string.i_see), new AlertPopup.a() { // from class: com.uz.navee.ui.device.b7
                @Override // com.uz.navee.ui.wheel.AlertPopup.a
                public /* synthetic */ void a() {
                    j4.c.a(this);
                }

                @Override // com.uz.navee.ui.wheel.AlertPopup.a
                public final void b() {
                    EnergyRecoveryPopup.a.b();
                }
            });
        }
    }

    public interface b {
        void a(int i6);
    }

    public EnergyRecoveryPopup(@NonNull Context context) {
        super(context);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void A() {
        super.A();
        R();
        String str = getResources().getString(R$string.energy_recovery) + " icon";
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new j4.f(getContext(), R$mipmap.ic_help), str.length() - 4, str.length(), 33);
        this.C.setText(spannableString);
        this.C.setOnClickListener(new a());
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[]{-16842913}}, new int[]{ContextCompat.getColor(getContext(), R$color.xC69D7D), ContextCompat.getColor(getContext(), R$color.xC69D7D_40)});
        this.f12352x.setTextColor(colorStateList);
        this.f12354z.setTextColor(colorStateList);
        this.B.setTextColor(colorStateList);
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.u6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12670a.T(view);
            }
        });
        this.E.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.v6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12682a.V(view);
            }
        });
        this.f12351w.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.w6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12692a.W(view);
            }
        });
        this.f12353y.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.x6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12703a.X(view);
            }
        });
        this.A.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.y6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12713a.Y(view);
            }
        });
        a0();
        Z(b4.a.W().f1933f);
    }

    public final void R() {
        this.f12351w = (ImageButton) findViewById(R$id.lowBatteryButton);
        this.f12352x = (TextView) findViewById(R$id.lowBatteryLabel);
        this.f12353y = (ImageButton) findViewById(R$id.mediumBatteryButton);
        this.f12354z = (TextView) findViewById(R$id.mediumBatteryLabel);
        this.A = (ImageButton) findViewById(R$id.highBatteryButton);
        this.B = (TextView) findViewById(R$id.highBatteryLabel);
        this.C = (TextView) findViewById(R$id.titleLabel);
        this.D = (Button) findViewById(R$id.cancelButton);
        this.E = (Button) findViewById(R$id.confirmButton);
    }

    public final /* synthetic */ void S(PropertyChangeEvent propertyChangeEvent) {
        if ("ersStatus".equals(propertyChangeEvent.getPropertyName())) {
            a0();
        }
    }

    public final /* synthetic */ void T(View view) {
        m();
    }

    public final /* synthetic */ void U() {
        int i6 = this.f12351w.isSelected() ? 30 : this.f12353y.isSelected() ? 60 : this.A.isSelected() ? 90 : 0;
        b bVar = this.F;
        if (bVar != null) {
            bVar.a(i6);
        }
    }

    public final /* synthetic */ void V(View view) {
        o(new Runnable() { // from class: com.uz.navee.ui.device.z6
            @Override // java.lang.Runnable
            public final void run() {
                this.f12721a.U();
            }
        });
    }

    public final /* synthetic */ void W(View view) {
        if (this.f12351w.isSelected()) {
            return;
        }
        c0();
    }

    public final /* synthetic */ void X(View view) {
        if (this.f12353y.isSelected()) {
            return;
        }
        d0();
    }

    public final /* synthetic */ void Y(View view) {
        if (this.A.isSelected()) {
            return;
        }
        b0();
    }

    public final void Z(DeviceCarInfo deviceCarInfo) {
        this.G = deviceCarInfo.addListener("ersStatus", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.a7
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12468a.S(propertyChangeEvent);
            }
        });
    }

    public final void a0() {
        int ersStatus = b4.a.W().f1933f.getErsStatus();
        if (ersStatus == 30) {
            c0();
            return;
        }
        if (ersStatus == 60) {
            d0();
        } else if (ersStatus != 90) {
            f0();
        } else {
            b0();
        }
    }

    public final void b0() {
        this.f12351w.setSelected(false);
        this.f12352x.setSelected(false);
        this.f12353y.setSelected(false);
        this.f12354z.setSelected(false);
        this.A.setSelected(true);
        this.B.setSelected(true);
    }

    public final void c0() {
        this.f12351w.setSelected(true);
        this.f12352x.setSelected(true);
        this.f12353y.setSelected(false);
        this.f12354z.setSelected(false);
        this.A.setSelected(false);
        this.B.setSelected(false);
    }

    public final void d0() {
        this.f12351w.setSelected(false);
        this.f12352x.setSelected(false);
        this.f12353y.setSelected(true);
        this.f12354z.setSelected(true);
        this.A.setSelected(false);
        this.B.setSelected(false);
    }

    public final void e0(DeviceCarInfo deviceCarInfo) {
        deviceCarInfo.removeListener("ersStatus", this.G);
    }

    public final void f0() {
        this.f12351w.setSelected(false);
        this.f12352x.setSelected(false);
        this.f12353y.setSelected(false);
        this.f12354z.setSelected(false);
        this.A.setSelected(false);
        this.B.setSelected(false);
    }

    @Override // com.lxj.xpopup.core.BottomPopupView, com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        return R$layout.popup_energy_recovery;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getMaxHeight() {
        return super.getMaxHeight();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getMaxWidth() {
        return super.getMaxWidth();
    }

    @Override // com.lxj.xpopup.core.BottomPopupView, com.lxj.xpopup.core.BasePopupView
    public f3.c getPopupAnimator() {
        return super.getPopupAnimator();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getPopupHeight() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getPopupWidth() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void onDestroy() {
        e0(b4.a.W().f1933f);
        super.onDestroy();
    }

    public EnergyRecoveryPopup(Context context, b bVar) {
        super(context);
        this.F = bVar;
    }
}
