package com.uz.navee.ui.device;

import android.content.Context;
import android.view.View;
import com.lxj.xpopup.core.CenterPopupView;
import com.uz.navee.R$layout;
import com.uz.navee.databinding.PopupDualDriveOpenBinding;

/* loaded from: classes3.dex */
public final class DualDriveOpenPopup extends CenterPopupView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DualDriveOpenPopup(Context context) {
        super(context);
        kotlin.jvm.internal.y.f(context, "context");
    }

    public static final void M(DualDriveOpenPopup this$0, View view) {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        this$0.m();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void A() {
        PopupDualDriveOpenBinding.bind(getPopupImplView()).btnOk.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.t6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DualDriveOpenPopup.M(this.f12659a, view);
            }
        });
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        return R$layout.popup_dual_drive_open;
    }
}
