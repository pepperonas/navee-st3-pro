package com.uz.navee.ui.device;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.lxj.xpopup.core.BottomPopupView;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.bean.DeviceCarInfo;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.ble.AreaCode;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class MileageAlgorithmPopup extends BottomPopupView {
    public LinearLayout A;
    public ImageButton B;
    public TextView C;
    public TextView D;
    public LinearLayout E;
    public ImageButton F;
    public TextView G;
    public TextView H;
    public LinearLayout I;
    public ImageButton J;
    public TextView L;
    public TextView M;
    public LinearLayout Q;
    public ImageButton R;
    public TextView S;
    public TextView T;
    public Button U;
    public Button V;
    public a W;

    /* renamed from: a0, reason: collision with root package name */
    public Vehicle f12378a0;

    /* renamed from: b0, reason: collision with root package name */
    public PropertyChangeListener f12379b0;

    /* renamed from: w, reason: collision with root package name */
    public LinearLayout f12380w;

    /* renamed from: x, reason: collision with root package name */
    public ImageButton f12381x;

    /* renamed from: y, reason: collision with root package name */
    public TextView f12382y;

    /* renamed from: z, reason: collision with root package name */
    public TextView f12383z;

    public interface a {
        void a(int i6);
    }

    public MileageAlgorithmPopup(@NonNull Context context) {
        super(context);
    }

    private void T() {
        this.f12380w = (LinearLayout) findViewById(R$id.theoryLayout);
        this.f12381x = (ImageButton) findViewById(R$id.theoryButton);
        this.f12382y = (TextView) findViewById(R$id.theoryLabel);
        this.f12383z = (TextView) findViewById(R$id.theorySubLabel);
        this.A = (LinearLayout) findViewById(R$id.actualLayout);
        this.B = (ImageButton) findViewById(R$id.actualButton);
        this.C = (TextView) findViewById(R$id.actualLabel);
        this.D = (TextView) findViewById(R$id.actualSubLabel);
        this.E = (LinearLayout) findViewById(R$id.eGearLayout);
        this.F = (ImageButton) findViewById(R$id.eGearButton);
        this.G = (TextView) findViewById(R$id.eGearLabel);
        this.H = (TextView) findViewById(R$id.eGearSubLabel);
        this.I = (LinearLayout) findViewById(R$id.dGearLayout);
        this.J = (ImageButton) findViewById(R$id.dGearButton);
        this.L = (TextView) findViewById(R$id.dGearLabel);
        this.M = (TextView) findViewById(R$id.dGearSubLabel);
        this.Q = (LinearLayout) findViewById(R$id.sGearLayout);
        this.R = (ImageButton) findViewById(R$id.sGearButton);
        this.S = (TextView) findViewById(R$id.sGearLabel);
        this.T = (TextView) findViewById(R$id.sGearSubLabel);
        this.U = (Button) findViewById(R$id.cancelButton);
        this.V = (Button) findViewById(R$id.confirmButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(View view) {
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z() {
        int i6 = this.B.isSelected() ? 1 : this.J.isSelected() ? 2 : this.R.isSelected() ? 3 : this.F.isSelected() ? 4 : 0;
        a aVar = this.W;
        if (aVar != null) {
            aVar.a(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(View view) {
        o(new Runnable() { // from class: com.uz.navee.ui.device.z7
            @Override // java.lang.Runnable
            public final void run() {
                this.f12722a.Z();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(View view) {
        if (this.f12381x.isSelected()) {
            return;
        }
        j0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(View view) {
        if (this.B.isSelected()) {
            return;
        }
        U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(View view) {
        if (this.F.isSelected()) {
            return;
        }
        W();
    }

    private void g0(DeviceCarInfo deviceCarInfo) {
        this.f12379b0 = deviceCarInfo.addListener("mileageAlgorithm", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.y7
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) throws Resources.NotFoundException {
                this.f12714a.X(propertyChangeEvent);
            }
        });
    }

    private void k0(DeviceCarInfo deviceCarInfo) {
        deviceCarInfo.removeListener("mileageAlgorithm", this.f12379b0);
    }

    private void setLanguageDirection(Context context) {
        if ((context instanceof Activity) && com.uz.navee.utils.d.p((Activity) context)) {
            this.f12382y.setTextDirection(4);
            this.f12383z.setTextDirection(4);
            this.C.setTextDirection(4);
            this.D.setTextDirection(4);
            this.G.setTextDirection(4);
            this.H.setTextDirection(4);
            this.L.setTextDirection(4);
            this.M.setTextDirection(4);
            this.S.setTextDirection(4);
            this.T.setTextDirection(4);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void A() throws Resources.NotFoundException {
        super.A();
        T();
        this.U.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.r7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12637a.Y(view);
            }
        });
        this.V.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.s7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12650a.a0(view);
            }
        });
        this.f12381x.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.t7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12660a.b0(view);
            }
        });
        this.B.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.u7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12671a.c0(view);
            }
        });
        this.F.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.v7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12683a.d0(view);
            }
        });
        this.J.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.w7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12693a.e0(view);
            }
        });
        this.R.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.x7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12704a.f0(view);
            }
        });
        h0();
        g0(b4.a.W().f1933f);
        setLanguageDirection(getContext());
    }

    public final void U() {
        this.f12381x.setSelected(false);
        this.F.setSelected(false);
        this.J.setSelected(false);
        this.R.setSelected(false);
        this.B.setSelected(true);
    }

    public final void V() {
        this.f12381x.setSelected(false);
        this.F.setSelected(false);
        this.J.setSelected(true);
        this.R.setSelected(false);
        this.B.setSelected(false);
    }

    public final void W() {
        this.f12381x.setSelected(false);
        this.F.setSelected(true);
        this.J.setSelected(false);
        this.R.setSelected(false);
        this.B.setSelected(false);
    }

    public final /* synthetic */ void X(PropertyChangeEvent propertyChangeEvent) throws Resources.NotFoundException {
        if ("mileageAlgorithm".equals(propertyChangeEvent.getPropertyName())) {
            h0();
        }
    }

    public final /* synthetic */ void e0(View view) {
        if (this.J.isSelected()) {
            return;
        }
        V();
    }

    public final /* synthetic */ void f0(View view) {
        if (this.R.isSelected()) {
            return;
        }
        i0();
    }

    @Override // com.lxj.xpopup.core.BottomPopupView, com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        return R$layout.popup_mileage_algorithm;
    }

    public final void h0() throws Resources.NotFoundException {
        String str = this.f12378a0.model.pid;
        int i6 = (str == null || !(str.startsWith("2504") || str.startsWith("2505") || (str.startsWith("2506") && (this.f12378a0.areaCode() == AreaCode.EU || this.f12378a0.areaCode() == AreaCode.AU)))) ? 15 : 12;
        if (b4.d.d(this.f12378a0.model.pid)) {
            i6 = 3;
        }
        int mileageUnit = b4.a.W().f1933f.getMileageUnit();
        String string = getResources().getString(R$string.theory_des);
        this.f12383z.setText(mileageUnit == 0 ? string.replace("15", String.valueOf((int) Math.round(i6 * 0.621d))).replace(getResources().getString(R$string.unit_speed_metric), getResources().getString(R$string.unit_speed_imperial)) : string.replace("15", String.valueOf(i6)));
        int mileageAlgorithm = b4.a.W().f1933f.getMileageAlgorithm();
        if (mileageAlgorithm == 0) {
            j0();
        } else if (mileageAlgorithm == 1) {
            U();
        } else if (mileageAlgorithm == 2) {
            V();
        } else if (mileageAlgorithm == 3) {
            i0();
        } else if (mileageAlgorithm == 4) {
            W();
        }
        int mileageAlgorithmMode = b4.a.W().f1933f.getMileageAlgorithmMode();
        if (mileageAlgorithmMode == 0) {
            this.f12380w.setVisibility(0);
            this.E.setVisibility(8);
            this.I.setVisibility(8);
            this.Q.setVisibility(8);
            if (str == null || !(str.startsWith("2213") || str.startsWith("2332"))) {
                this.A.setVisibility(8);
                return;
            } else {
                this.A.setVisibility(0);
                return;
            }
        }
        if (mileageAlgorithmMode == 1) {
            this.f12380w.setVisibility(0);
            this.E.setVisibility(8);
            this.I.setVisibility(0);
            this.Q.setVisibility(0);
            this.A.setVisibility(8);
            return;
        }
        if (mileageAlgorithmMode == 2) {
            this.f12380w.setVisibility(8);
            this.E.setVisibility(0);
            this.I.setVisibility(0);
            this.Q.setVisibility(0);
            this.A.setVisibility(8);
        }
    }

    public final void i0() {
        this.f12381x.setSelected(false);
        this.F.setSelected(false);
        this.J.setSelected(false);
        this.R.setSelected(true);
        this.B.setSelected(false);
    }

    public final void j0() {
        this.f12381x.setSelected(true);
        this.F.setSelected(false);
        this.J.setSelected(false);
        this.R.setSelected(false);
        this.B.setSelected(false);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void onDestroy() {
        k0(b4.a.W().f1933f);
        super.onDestroy();
    }

    public MileageAlgorithmPopup(Context context, Vehicle vehicle, a aVar) {
        super(context);
        this.W = aVar;
        this.f12378a0 = vehicle;
    }
}
