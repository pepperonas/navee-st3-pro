package com.uz.navee.ui.wheel;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.lxj.xpopup.core.CenterPopupView;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import e3.a;

/* loaded from: classes3.dex */
public class AlertPopup extends CenterPopupView {
    public String A;
    public String B;
    public a C;

    /* renamed from: y, reason: collision with root package name */
    public String f13199y;

    /* renamed from: z, reason: collision with root package name */
    public CharSequence f13200z;

    public interface a {
        void a();

        void b();
    }

    public AlertPopup(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(View view) {
        this.C.a();
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(View view) {
        this.C.b();
        m();
    }

    public static void P(Context context, String str, CharSequence charSequence, a aVar) {
        a.C0192a c0192aG = new a.C0192a(context).f(false).g(Boolean.TRUE);
        Boolean bool = Boolean.FALSE;
        c0192aG.d(bool).e(bool).a(new AlertPopup(context, str, charSequence, aVar)).G();
    }

    public static void Q(Context context, String str, CharSequence charSequence, String str2, String str3, a aVar) {
        a.C0192a c0192aG = new a.C0192a(context).f(false).g(Boolean.TRUE);
        Boolean bool = Boolean.FALSE;
        c0192aG.d(bool).e(bool).a(new AlertPopup(context, str, charSequence, str2, str3, aVar)).G();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void A() {
        super.A();
        TextView textView = (TextView) findViewById(R$id.tv_title);
        String str = this.f13199y;
        if (str == null || str.isEmpty()) {
            textView.setVisibility(8);
        } else {
            textView.setText(this.f13199y);
            textView.setVisibility(0);
        }
        TextView textView2 = (TextView) findViewById(R$id.tv_message);
        CharSequence charSequence = this.f13200z;
        if (charSequence == null || charSequence.length() <= 0) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(this.f13200z);
            textView2.setVisibility(0);
            if (this.f13200z instanceof SpannableString) {
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        Button button = (Button) findViewById(R$id.cancelButton);
        Button button2 = (Button) findViewById(R$id.confirmButton);
        String str2 = this.B;
        if (str2 == null || str2.isEmpty()) {
            button.setVisibility(8);
        } else {
            button.setText(this.B);
            button.setVisibility(0);
            button.setOnClickListener(new View.OnClickListener() { // from class: j4.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f15415a.N(view);
                }
            });
        }
        String str3 = this.A;
        if (str3 == null || str3.isEmpty()) {
            button2.setVisibility(8);
            return;
        }
        button2.setText(this.A);
        button2.setVisibility(0);
        button2.setOnClickListener(new View.OnClickListener() { // from class: j4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15416a.O(view);
            }
        });
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        return R$layout.popup_alert;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void onDestroy() {
        super.onDestroy();
    }

    public AlertPopup(Context context, String str, CharSequence charSequence, a aVar) {
        super(context);
        this.f13199y = str;
        this.f13200z = charSequence;
        this.C = aVar;
        this.A = context.getString(R$string.confirm);
        this.B = context.getString(R$string.cancel);
    }

    public AlertPopup(Context context, String str, CharSequence charSequence, String str2, String str3, a aVar) {
        super(context);
        this.f13199y = str;
        this.f13200z = charSequence;
        this.A = str2;
        this.B = str3;
        this.C = aVar;
    }
}
