package com.uz.navee.ui.device;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lxj.xpopup.core.CenterPopupView;
import com.uz.navee.R$drawable;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.bean.CheckCodeRes;
import com.uz.navee.bean.HttpResponse;
import d4.d;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class CheckCodePopup extends CenterPopupView {
    public View A;
    public View B;
    public ImageView C;
    public EditText D;
    public String E;
    public b F;
    public Bitmap G;

    /* renamed from: y, reason: collision with root package name */
    public View f11779y;

    /* renamed from: z, reason: collision with root package name */
    public View f11780z;

    public class a implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11781a;

        /* renamed from: com.uz.navee.ui.device.CheckCodePopup$a$a, reason: collision with other inner class name */
        public class C0159a extends TypeToken<HttpResponse<CheckCodeRes>> {
            public C0159a() {
            }
        }

        public a(String str) {
            this.f11781a = str;
        }

        @Override // d4.d.h
        public void a(String str) {
            CheckCodePopup.this.V();
            System.out.println(this.f11781a + "网络请求==" + str);
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new C0159a().getType());
            if (httpResponse == null || httpResponse.getCode() != 200) {
                if (httpResponse != null) {
                    Toast.makeText(CheckCodePopup.this.getContext(), httpResponse.getMsg(), 0).show();
                }
            } else {
                CheckCodeRes checkCodeRes = (CheckCodeRes) httpResponse.getData();
                if (checkCodeRes != null) {
                    CheckCodePopup.this.E = checkCodeRes.getUuid();
                    CheckCodePopup.this.d0(checkCodeRes.getImg());
                }
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            CheckCodePopup.this.V();
            Toast.makeText(CheckCodePopup.this.getContext(), exc.getMessage(), 0).show();
        }
    }

    public interface b {
        void a(String str, String str2);
    }

    public CheckCodePopup(@NonNull Context context) {
        super(context);
    }

    private void U() {
        this.f11779y = findViewById(R$id.imgClose);
        this.f11780z = findViewById(R$id.tvRefresh);
        this.A = findViewById(R$id.btnSubmit);
        this.B = findViewById(R$id.loading);
        this.C = (ImageView) findViewById(R$id.imgCode);
        this.D = (EditText) findViewById(R$id.etCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        this.B.post(new Runnable() { // from class: com.uz.navee.ui.device.k0
            @Override // java.lang.Runnable
            public final void run() {
                this.f12563a.W();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(View view) {
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(View view) {
        getImageCaptcha();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(View view) {
        this.C.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(View view) {
        String string = this.D.getText().toString();
        if (!TextUtils.isEmpty(string)) {
            b bVar = this.F;
            if (bVar != null) {
                bVar.a(string, this.E);
            }
            m();
            return;
        }
        com.uz.navee.utils.a.b(this.D);
        Activity activity = getActivity();
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).O();
        }
    }

    private void getImageCaptcha() {
        c0();
        this.B.setVisibility(0);
        this.E = null;
        String str = e4.a.a() + "/checkCode";
        d4.d.h().f(str, new a(str));
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void A() {
        super.A();
        U();
        this.f11779y.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12510a.X(view);
            }
        });
        this.C.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12521a.Y(view);
            }
        });
        d3.a.a(this.D).i(new b5.g() { // from class: com.uz.navee.ui.device.h0
            @Override // b5.g
            public final void accept(Object obj) {
                this.f12535a.Z((CharSequence) obj);
            }
        });
        this.f11780z.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12545a.a0(view);
            }
        });
        this.A.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12555a.b0(view);
            }
        });
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void D() {
        super.D();
        try {
            this.C.performClick();
            this.D.requestFocus();
        } catch (Exception unused) {
        }
    }

    public final /* synthetic */ void W() {
        this.B.setVisibility(8);
    }

    public final /* synthetic */ void Z(CharSequence charSequence) {
        this.A.setAlpha(TextUtils.isEmpty(charSequence) ? 0.6f : 1.0f);
    }

    public final void c0() {
        this.C.setImageResource(R$drawable.none);
        Bitmap bitmap = this.G;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.G.recycle();
    }

    public final void d0(String str) {
        if (str == null) {
            return;
        }
        try {
            if (str.contains(",")) {
                str = str.split(",")[1];
            }
            byte[] bArrDecode = Base64.decode(str, 2);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
            this.G = bitmapDecodeByteArray;
            this.C.setImageBitmap(bitmapDecodeByteArray);
        } catch (Exception unused) {
        }
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        return R$layout.popup_check_code;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void onDestroy() {
        c0();
        super.onDestroy();
    }

    public CheckCodePopup(Context context, b bVar) {
        super(context);
        this.F = bVar;
    }
}
