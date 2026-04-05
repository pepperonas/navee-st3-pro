package com.uz.navee.ui.mine;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.GsonBuilder;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.ui.device.CheckCodePopup;
import com.uz.navee.ui.mine.ChangeAccountActivity;
import com.uz.navee.ui.mine.bean.BaseBean;
import com.uz.navee.utils.j0;
import d4.d;
import g4.e1;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Pattern;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class ChangeAccountActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public ImageView f12964c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f12965d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f12966e;

    /* renamed from: f, reason: collision with root package name */
    public EditText f12967f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f12968g;

    /* renamed from: h, reason: collision with root package name */
    public final int f12969h = 24;

    public class a implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12970a;

        public a(String str) {
            this.f12970a = str;
        }

        @Override // d4.d.h
        public void a(String str) {
            BaseBean baseBean = (BaseBean) new GsonBuilder().create().fromJson(str, BaseBean.class);
            if (baseBean != null) {
                if (baseBean.getCode() != 200) {
                    Toast.makeText(ChangeAccountActivity.this, baseBean.getMsg(), 0).show();
                    return;
                }
                e1.q(this.f12970a);
                ChangeAccountActivity.this.M("");
                ChangeAccountActivity.this.setResult(-1);
                ChangeAccountActivity.this.finish();
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            ChangeAccountActivity.this.I(exc.getLocalizedMessage());
        }
    }

    private void V() {
        this.f12964c = (ImageView) findViewById(R$id.logo_toolbar);
        this.f12965d = (TextView) findViewById(R$id.titleView_toolbar);
        this.f12966e = (TextView) findViewById(R$id.tv_right_toolbar);
        this.f12967f = (EditText) findViewById(R$id.textInputEditText);
        this.f12968g = (TextView) findViewById(R$id.inputLimitsLabel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(View view) {
        b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CharSequence Y(CharSequence charSequence, int i6, int i7, Spanned spanned, int i8, int i9) {
        if (Pattern.compile("[^A-Za-z\\u4E00-\\u9FA5\\d\\s]").matcher(charSequence.toString()).find()) {
            return "";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CharSequence Z(CharSequence charSequence, int i6, int i7, Spanned spanned, int i8, int i9) {
        int iC = j0.c(spanned.toString());
        int iC2 = j0.c(charSequence.toString());
        int iC3 = (iC + iC2) - j0.c(spanned.subSequence(i8, i9).toString());
        if (iC3 > 24) {
            return j0.e(charSequence.toString(), (24 - iC3) + iC2);
        }
        return null;
    }

    private void b0() {
        Editable text = this.f12967f.getText();
        Objects.requireNonNull(text);
        final String strTrim = text.toString().trim();
        if (strTrim.isEmpty()) {
            com.uz.navee.utils.a.b(this.f12967f);
        } else {
            H(new CheckCodePopup.b() { // from class: h4.a0
                @Override // com.uz.navee.ui.device.CheckCodePopup.b
                public final void a(String str, String str2) {
                    this.f13753a.a0(strTrim, str, str2);
                }
            });
        }
    }

    public final /* synthetic */ void a0(String str, String str2, String str3) {
        HashMap map = new HashMap();
        map.put("userName", str);
        map.put("uuid", str3);
        map.put("imgCode", str2);
        d.h().g(e4.a.a() + "/updateAccount", map, new a(str));
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_change_account);
        V();
        this.f12964c.setOnClickListener(new View.OnClickListener() { // from class: h4.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13831a.W(view);
            }
        });
        this.f12965d.setText(R$string.change_account);
        this.f12966e.setText(R$string.save);
        this.f12966e.setVisibility(0);
        this.f12966e.setOnClickListener(new View.OnClickListener() { // from class: h4.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13834a.X(view);
            }
        });
        this.f12968g.setText(getString(R$string.input_limits_device_name).replace("10", String.valueOf(24)));
        this.f12967f.setText(e1.u().f13675c.getUserName());
        this.f12967f.setFilters(new InputFilter[]{new InputFilter() { // from class: h4.y
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i6, int i7, Spanned spanned, int i8, int i9) {
                return ChangeAccountActivity.Y(charSequence, i6, i7, spanned, i8, i9);
            }
        }, new InputFilter() { // from class: h4.z
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i6, int i7, Spanned spanned, int i8, int i9) {
                return this.f13838a.Z(charSequence, i6, i7, spanned, i8, i9);
            }
        }});
    }
}
