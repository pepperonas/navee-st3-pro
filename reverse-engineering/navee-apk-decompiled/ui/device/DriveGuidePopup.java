package com.uz.navee.ui.device;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.lxj.xpopup.core.CenterPopupView;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.databinding.PopupDriveGuideBinding;
import com.uz.navee.ui.web.WebFragment;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public final class DriveGuidePopup extends CenterPopupView {

    /* renamed from: y, reason: collision with root package name */
    public final String f12300y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DriveGuidePopup(Context context, String url) {
        super(context);
        kotlin.jvm.internal.y.f(context, "context");
        kotlin.jvm.internal.y.f(url, "url");
        this.f12300y = url;
    }

    public static final void N(DriveGuidePopup this$0, View view) {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        this$0.m();
    }

    public static final void O(DriveGuidePopup this$0, View view) {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        this$0.m();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void A() {
        FragmentManager supportFragmentManager;
        FragmentTransaction fragmentTransactionBeginTransaction;
        FragmentTransaction fragmentTransactionAdd;
        PopupDriveGuideBinding popupDriveGuideBindingBind = PopupDriveGuideBinding.bind(getPopupImplView());
        popupDriveGuideBindingBind.tvSkip.getPaint().setFlags(8);
        popupDriveGuideBindingBind.tvSkip.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.q6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DriveGuidePopup.N(this.f12627a, view);
            }
        });
        popupDriveGuideBindingBind.btnClose.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.r6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DriveGuidePopup.O(this.f12636a, view);
            }
        });
        Activity activity = getActivity();
        FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
        if (fragmentActivity == null || (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) == null || (fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction()) == null || (fragmentTransactionAdd = fragmentTransactionBeginTransaction.add(R$id.fl_container, WebFragment.a.b(WebFragment.f13181g, "", this.f12300y, false, null, null, 28, null))) == null) {
            return;
        }
        fragmentTransactionAdd.commit();
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        return R$layout.popup_drive_guide;
    }

    public final String getUrl() {
        return this.f12300y;
    }
}
