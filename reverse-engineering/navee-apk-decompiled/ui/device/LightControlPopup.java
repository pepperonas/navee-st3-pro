package com.uz.navee.ui.device;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import com.lxj.xpopup.core.BottomPopupView;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.bean.DeviceCarInfo;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class LightControlPopup extends BottomPopupView {
    public TextView A;
    public SwitchCompat B;
    public ImageButton C;
    public TextView D;
    public TextView E;
    public SwitchCompat F;
    public ImageButton G;
    public TextView H;
    public SwitchCompat I;
    public a J;
    public boolean L;
    public boolean M;
    public boolean Q;
    public PropertyChangeListener R;
    public PropertyChangeListener S;
    public PropertyChangeListener T;

    /* renamed from: w, reason: collision with root package name */
    public LinearLayout f12364w;

    /* renamed from: x, reason: collision with root package name */
    public LinearLayout f12365x;

    /* renamed from: y, reason: collision with root package name */
    public LinearLayout f12366y;

    /* renamed from: z, reason: collision with root package name */
    public ImageButton f12367z;

    public interface a {
        void a(boolean z6);

        void b(boolean z6);

        void c(boolean z6);
    }

    public LightControlPopup(@NonNull Context context) {
        super(context);
    }

    private void Q() {
        this.f12364w = (LinearLayout) findViewById(R$id.tailLightLayout);
        this.f12365x = (LinearLayout) findViewById(R$id.autoLightLayout);
        this.f12366y = (LinearLayout) findViewById(R$id.turnSoundLayout);
        this.f12367z = (ImageButton) findViewById(R$id.tailLightButton);
        this.A = (TextView) findViewById(R$id.tailLightLabel);
        this.B = (SwitchCompat) findViewById(R$id.tailLightSwitch);
        this.C = (ImageButton) findViewById(R$id.autoLightButton);
        this.D = (TextView) findViewById(R$id.autoLightLabel);
        this.E = (TextView) findViewById(R$id.autoLightSubLabel);
        this.F = (SwitchCompat) findViewById(R$id.autoLightSwitch);
        this.G = (ImageButton) findViewById(R$id.turnSoundButton);
        this.H = (TextView) findViewById(R$id.turnSoundLabel);
        this.I = (SwitchCompat) findViewById(R$id.turnSoundSwitch);
    }

    private void X(DeviceCarInfo deviceCarInfo) {
        this.R = deviceCarInfo.addListener("tailIsOn", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.n7
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) throws Resources.NotFoundException {
                this.f12601a.R(propertyChangeEvent);
            }
        });
        this.S = deviceCarInfo.addListener("autoSensor", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.o7
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) throws Resources.NotFoundException {
                this.f12609a.S(propertyChangeEvent);
            }
        });
        this.T = deviceCarInfo.addListener("turnSound", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.p7
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) throws Resources.NotFoundException {
                this.f12618a.T(propertyChangeEvent);
            }
        });
    }

    private void b0(DeviceCarInfo deviceCarInfo) {
        deviceCarInfo.removeListener("tailIsOn", this.R);
        deviceCarInfo.removeListener("autoSensor", this.S);
        deviceCarInfo.removeListener("turnSound", this.T);
    }

    private void setLanguageDirection(Context context) {
        if ((context instanceof Activity) && com.uz.navee.utils.d.p((Activity) context)) {
            this.A.setTextDirection(4);
            this.D.setTextDirection(4);
            this.E.setTextDirection(4);
            this.H.setTextDirection(4);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void A() throws Resources.NotFoundException {
        super.A();
        Q();
        if (this.L) {
            this.f12364w.setVisibility(8);
        }
        if (this.M) {
            this.f12365x.setVisibility(8);
        }
        if (this.Q) {
            this.f12366y.setVisibility(8);
        }
        this.B.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.k7
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) {
                this.f12570a.U(compoundButton, z6);
            }
        });
        this.F.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.l7
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) {
                this.f12581a.V(compoundButton, z6);
            }
        });
        this.I.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.m7
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) {
                this.f12592a.W(compoundButton, z6);
            }
        });
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[]{-16842913}}, new int[]{ContextCompat.getColor(getContext(), R$color.xC69D7D), ContextCompat.getColor(getContext(), R$color.xC69D7D_40)});
        this.A.setTextColor(colorStateList);
        this.D.setTextColor(colorStateList);
        this.H.setTextColor(colorStateList);
        this.E.setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[]{-16842913}}, new int[]{ContextCompat.getColor(getContext(), R$color.xFAF4E8_50), ContextCompat.getColor(getContext(), R$color.xFAF4E8_30)}));
        a0();
        Y();
        Z();
        X(b4.a.W().f1933f);
        setLanguageDirection(getContext());
    }

    public final /* synthetic */ void R(PropertyChangeEvent propertyChangeEvent) throws Resources.NotFoundException {
        if ("tailIsOn".equals(propertyChangeEvent.getPropertyName())) {
            a0();
        }
    }

    public final /* synthetic */ void S(PropertyChangeEvent propertyChangeEvent) throws Resources.NotFoundException {
        if ("autoSensor".equals(propertyChangeEvent.getPropertyName())) {
            Y();
        }
    }

    public final /* synthetic */ void T(PropertyChangeEvent propertyChangeEvent) throws Resources.NotFoundException {
        if ("turnSound".equals(propertyChangeEvent.getPropertyName())) {
            Z();
        }
    }

    public final /* synthetic */ void U(CompoundButton compoundButton, boolean z6) {
        if (this.J != null) {
            int tailIsOn = b4.a.W().f1933f.getTailIsOn();
            if (z6) {
                if (tailIsOn == 0) {
                    this.J.c(true);
                }
            } else if (tailIsOn != 0) {
                this.J.c(false);
            }
        }
    }

    public final /* synthetic */ void V(CompoundButton compoundButton, boolean z6) {
        if (this.J != null) {
            int autoSensor = b4.a.W().f1933f.getAutoSensor();
            if (z6) {
                if (autoSensor == 0) {
                    this.J.b(true);
                }
            } else if (autoSensor != 0) {
                this.J.b(false);
            }
        }
    }

    public final /* synthetic */ void W(CompoundButton compoundButton, boolean z6) {
        if (this.J != null) {
            int turnSound = b4.a.W().f1933f.getTurnSound();
            if (z6) {
                if (turnSound == 0) {
                    this.J.a(true);
                }
            } else if (turnSound != 0) {
                this.J.a(false);
            }
        }
    }

    public final void Y() throws Resources.NotFoundException {
        if (b4.a.W().f1933f.getAutoSensor() == 0) {
            this.D.setSelected(false);
            this.E.setSelected(false);
            this.C.setSelected(false);
            if (this.F.isChecked()) {
                this.F.setChecked(false);
                return;
            }
            return;
        }
        this.D.setSelected(true);
        this.E.setSelected(true);
        this.C.setSelected(true);
        if (this.F.isChecked()) {
            return;
        }
        this.F.setChecked(true);
    }

    public final void Z() throws Resources.NotFoundException {
        if (b4.a.W().f1933f.getTurnSound() == 0) {
            this.H.setSelected(false);
            this.G.setSelected(false);
            if (this.I.isChecked()) {
                this.I.setChecked(false);
                return;
            }
            return;
        }
        this.H.setSelected(true);
        this.G.setSelected(true);
        if (this.I.isChecked()) {
            return;
        }
        this.I.setChecked(true);
    }

    public final void a0() throws Resources.NotFoundException {
        if (b4.a.W().f1933f.getTailIsOn() == 0) {
            this.A.setSelected(false);
            this.f12367z.setSelected(false);
            if (this.B.isChecked()) {
                this.B.setChecked(false);
                return;
            }
            return;
        }
        this.A.setSelected(true);
        this.f12367z.setSelected(true);
        if (this.B.isChecked()) {
            return;
        }
        this.B.setChecked(true);
    }

    @Override // com.lxj.xpopup.core.BottomPopupView, com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        return R$layout.popup_light_control;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void onDestroy() {
        b0(b4.a.W().f1933f);
        super.onDestroy();
    }

    public LightControlPopup(Context context, boolean z6, boolean z7, boolean z8, a aVar) {
        super(context);
        this.J = aVar;
        this.L = z6;
        this.M = z7;
        this.Q = z8;
    }
}
