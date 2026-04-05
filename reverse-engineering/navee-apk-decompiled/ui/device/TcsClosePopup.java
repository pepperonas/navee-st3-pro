package com.uz.navee.ui.device;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.lxj.xpopup.core.BottomPopupView;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class TcsClosePopup extends BottomPopupView {
    public Drawable A;

    /* renamed from: w, reason: collision with root package name */
    public Button f12452w;

    /* renamed from: x, reason: collision with root package name */
    public Button f12453x;

    /* renamed from: y, reason: collision with root package name */
    public ImageView f12454y;

    /* renamed from: z, reason: collision with root package name */
    public a f12455z;

    public interface a {
        void a();

        void b();
    }

    public TcsClosePopup(@NonNull Context context) {
        super(context);
    }

    private void M() {
        this.f12452w = (Button) findViewById(R$id.cancelButton);
        this.f12453x = (Button) findViewById(R$id.confirmButton);
        this.f12454y = (ImageView) findViewById(R$id.imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(View view) {
        this.f12455z.a();
        m();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void A() {
        super.A();
        M();
        this.f12452w.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.o8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12610a.N(view);
            }
        });
        this.f12453x.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.p8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12619a.O(view);
            }
        });
        this.f12454y.setImageDrawable(this.A);
    }

    public final /* synthetic */ void O(View view) {
        this.f12455z.b();
        m();
    }

    @Override // com.lxj.xpopup.core.BottomPopupView, com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        return R$layout.popup_tcs_close;
    }

    public TcsClosePopup(Context context, Drawable drawable, a aVar) {
        super(context);
        this.f12455z = aVar;
        this.A = drawable;
    }
}
