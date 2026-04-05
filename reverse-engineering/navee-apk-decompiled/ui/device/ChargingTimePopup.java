package com.uz.navee.ui.device;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import com.lxj.xpopup.core.BottomPopupView;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.bean.PickTime;
import com.uz.navee.ui.wheel.WheelPicker;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class ChargingTimePopup extends BottomPopupView {

    /* renamed from: w, reason: collision with root package name */
    public long f11776w;

    /* renamed from: x, reason: collision with root package name */
    public q5.l f11777x;

    /* renamed from: y, reason: collision with root package name */
    public q5.a f11778y;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChargingTimePopup(Context context, long j6, q5.l pickCallback, q5.a cancelCallback) {
        this(context);
        kotlin.jvm.internal.y.f(context, "context");
        kotlin.jvm.internal.y.f(pickCallback, "pickCallback");
        kotlin.jvm.internal.y.f(cancelCallback, "cancelCallback");
        this.f11776w = j6;
        this.f11777x = pickCallback;
        this.f11778y = cancelCallback;
    }

    public static final void M(ChargingTimePopup this$0, View view) {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        q5.a aVar = this$0.f11778y;
        if (aVar != null) {
            aVar.invoke();
        }
        this$0.m();
    }

    public static final void N(ChargingTimePopup this$0, List startList, WheelPicker wheelPicker, View view) {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        kotlin.jvm.internal.y.f(startList, "$startList");
        q5.l lVar = this$0.f11777x;
        if (lVar != null) {
            lVar.invoke(startList.get(wheelPicker.getCurrentPosition()));
        }
        this$0.m();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void A() {
        super.A();
        final WheelPicker wheelPicker = (WheelPicker) findViewById(R$id.wp_start_time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        int i6 = calendar.get(6);
        final ArrayList arrayList = new ArrayList();
        Object objClone = calendar.clone();
        kotlin.jvm.internal.y.d(objClone, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar2 = (Calendar) objClone;
        int size = 0;
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        if (calendar.get(12) > 0 || calendar.get(13) > 0) {
            calendar2.add(11, 1);
        }
        Object objClone2 = calendar.clone();
        kotlin.jvm.internal.y.d(objClone2, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar3 = (Calendar) objClone2;
        calendar3.add(6, 1);
        calendar3.set(11, 23);
        calendar3.set(12, 0);
        calendar3.set(13, 0);
        calendar3.set(14, 0);
        Object objClone3 = calendar2.clone();
        kotlin.jvm.internal.y.d(objClone3, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar4 = (Calendar) objClone3;
        while (calendar4.getTimeInMillis() <= calendar3.getTimeInMillis()) {
            long j6 = 1000;
            if (calendar4.getTime().getTime() / j6 == this.f11776w) {
                size = arrayList.size();
            }
            int i7 = calendar4.get(6) - i6;
            long time = calendar4.getTime().getTime() / j6;
            String str = simpleDateFormat.format(calendar4.getTime());
            kotlin.jvm.internal.y.e(str, "format(...)");
            arrayList.add(new PickTime(time, str, i7));
            calendar4.add(11, 1);
        }
        wheelPicker.setDataList(arrayList);
        wheelPicker.setCurrentPosition(size);
        ((Button) findViewById(R$id.btn_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChargingTimePopup.M(this.f12490a, view);
            }
        });
        ((Button) findViewById(R$id.btn_confirm)).setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChargingTimePopup.N(this.f12497a, arrayList, wheelPicker, view);
            }
        });
    }

    @Override // com.lxj.xpopup.core.BottomPopupView, com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        return R$layout.popup_charging_time;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChargingTimePopup(Context context) {
        super(context);
        kotlin.jvm.internal.y.f(context, "context");
    }
}
