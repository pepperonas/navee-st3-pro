package com.uz.navee.ui.device;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.core.CenterPopupView;
import com.uz.navee.R$layout;
import com.uz.navee.bean.DfuVerInfo;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.databinding.PopupFirmwareUpdateBinding;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class FirmwareUpdatePopup extends CenterPopupView {
    public String A;
    public String B;
    public String C;
    public final List D;
    public final List E;
    public final List F;
    public ArrayList G;
    public String H;
    public a I;

    /* renamed from: y, reason: collision with root package name */
    public Vehicle f12358y;

    /* renamed from: z, reason: collision with root package name */
    public String f12359z;

    public interface a {
        void a(BasePopupView basePopupView);

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirmwareUpdatePopup(Context context) {
        super(context);
        kotlin.jvm.internal.y.f(context, "context");
        this.D = new ArrayList();
        this.E = new ArrayList();
        this.F = new ArrayList();
        this.G = new ArrayList();
        this.H = "";
    }

    public static final void Q(FirmwareUpdatePopup this$0, View view) {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        this$0.m();
    }

    public static final void R(FirmwareUpdatePopup this$0, View view) {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        a aVar = this$0.I;
        if (aVar != null) {
            aVar.a(this$0);
        }
    }

    public static final void S(FirmwareUpdatePopup this$0, View view) {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        a aVar = this$0.I;
        if (aVar != null) {
            aVar.b();
        }
        this$0.m();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void A() {
        PopupFirmwareUpdateBinding popupFirmwareUpdateBindingBind = PopupFirmwareUpdateBinding.bind(getPopupImplView());
        popupFirmwareUpdateBindingBind.tvContent.setText(this.H);
        popupFirmwareUpdateBindingBind.tvContent.setMovementMethod(ScrollingMovementMethod.getInstance());
        popupFirmwareUpdateBindingBind.tvCurVersion.setText(O());
        popupFirmwareUpdateBindingBind.tvLatestVersion.setText(P());
        popupFirmwareUpdateBindingBind.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.g7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FirmwareUpdatePopup.Q(this.f12532a, view);
            }
        });
        popupFirmwareUpdateBindingBind.btnGo.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.h7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FirmwareUpdatePopup.R(this.f12542a, view);
            }
        });
        popupFirmwareUpdateBindingBind.tvIgnore.getPaint().setFlags(8);
        popupFirmwareUpdateBindingBind.tvIgnore.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.i7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FirmwareUpdatePopup.S(this.f12552a, view);
            }
        });
    }

    public final String O() {
        String str;
        String str2 = this.f12359z;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.A;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = this.B;
        if (str4 == null) {
            str4 = "";
        }
        String str5 = this.C;
        String str6 = str5 != null ? str5 : "";
        if (T()) {
            str = str2 + RemoteSettings.FORWARD_SLASH_STRING + str3 + RemoteSettings.FORWARD_SLASH_STRING + str4;
        } else {
            str = str2 + RemoteSettings.FORWARD_SLASH_STRING + str3;
        }
        String[] strArrF = com.uz.navee.utils.j0.f(str6, "\\.");
        kotlin.jvm.internal.y.c(strArrF);
        if (!(!(strArrF.length == 0))) {
            return str;
        }
        return str + RemoteSettings.FORWARD_SLASH_STRING + str6;
    }

    public final String P() {
        String vn;
        String vn2;
        String vn3;
        String str;
        String vn4 = "";
        if (this.D.isEmpty()) {
            vn = this.f12359z;
            if (vn == null) {
                vn = "";
            }
        } else {
            vn = ((DfuVerInfo) this.D.get(0)).getVn();
        }
        if (this.E.isEmpty()) {
            vn2 = this.A;
            if (vn2 == null) {
                vn2 = "";
            }
        } else {
            vn2 = ((DfuVerInfo) this.E.get(0)).getVn();
        }
        if (this.F.isEmpty()) {
            vn3 = this.B;
            if (vn3 == null) {
                vn3 = "";
            }
        } else {
            vn3 = ((DfuVerInfo) this.F.get(0)).getVn();
        }
        if (this.G.isEmpty()) {
            String str2 = this.C;
            if (str2 != null) {
                vn4 = str2;
            }
        } else {
            vn4 = ((DfuVerInfo) this.G.get(0)).getVn();
        }
        if (T()) {
            str = vn + RemoteSettings.FORWARD_SLASH_STRING + vn2 + RemoteSettings.FORWARD_SLASH_STRING + vn3;
        } else {
            str = vn + RemoteSettings.FORWARD_SLASH_STRING + vn2;
        }
        String[] strArrF = com.uz.navee.utils.j0.f(vn4, "\\.");
        kotlin.jvm.internal.y.c(strArrF);
        if (!(!(strArrF.length == 0))) {
            return str;
        }
        return str + RemoteSettings.FORWARD_SLASH_STRING + vn4;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean T() {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uz.navee.ui.device.FirmwareUpdatePopup.T():boolean");
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        return R$layout.popup_firmware_update;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FirmwareUpdatePopup(Context context, Vehicle vehicle, String currentMeterVersion, String currentBldcVersion, String currentBmsVersion, String currentScreenVersion, List meterVersionList, List bldcVersionList, List bmsVersionList, List screenVersionList, String updateContent, a callback) {
        this(context);
        kotlin.jvm.internal.y.f(context, "context");
        kotlin.jvm.internal.y.f(vehicle, "vehicle");
        kotlin.jvm.internal.y.f(currentMeterVersion, "currentMeterVersion");
        kotlin.jvm.internal.y.f(currentBldcVersion, "currentBldcVersion");
        kotlin.jvm.internal.y.f(currentBmsVersion, "currentBmsVersion");
        kotlin.jvm.internal.y.f(currentScreenVersion, "currentScreenVersion");
        kotlin.jvm.internal.y.f(meterVersionList, "meterVersionList");
        kotlin.jvm.internal.y.f(bldcVersionList, "bldcVersionList");
        kotlin.jvm.internal.y.f(bmsVersionList, "bmsVersionList");
        kotlin.jvm.internal.y.f(screenVersionList, "screenVersionList");
        kotlin.jvm.internal.y.f(updateContent, "updateContent");
        kotlin.jvm.internal.y.f(callback, "callback");
        this.f12358y = vehicle;
        this.f12359z = currentMeterVersion;
        this.A = currentBldcVersion;
        this.B = currentBmsVersion;
        this.C = currentScreenVersion;
        this.D.addAll(meterVersionList);
        this.E.addAll(bldcVersionList);
        this.F.addAll(bmsVersionList);
        this.G.addAll(screenVersionList);
        this.H = updateContent;
        this.I = callback;
    }
}
