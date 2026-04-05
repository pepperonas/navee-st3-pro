package com.uz.navee.ui.web;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.clj.fastble.data.BleDevice;
import com.google.android.gms.common.internal.ImagesContract;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.base.BaseBindingActivity;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.databinding.ActivityWebBinding;
import com.uz.navee.utils.CommonExt;
import com.uz.navee.utils.e;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.y;

/* loaded from: classes3.dex */
public final class WebActivity extends BaseBindingActivity<ActivityWebBinding> {

    /* renamed from: h, reason: collision with root package name */
    public static final a f13179h = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public boolean f13180g = true;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public static /* synthetic */ void c(a aVar, Context context, String str, String str2, boolean z6, BleDevice bleDevice, Vehicle vehicle, int i6, Object obj) {
            if ((i6 & 8) != 0) {
                z6 = false;
            }
            aVar.b(context, str, str2, z6, (i6 & 16) != 0 ? null : bleDevice, (i6 & 32) != 0 ? null : vehicle);
        }

        public final void a(Context context, String title, String url) {
            y.f(context, "context");
            y.f(title, "title");
            y.f(url, "url");
            c(this, context, title, url, false, null, null, 56, null);
        }

        public final void b(Context context, String title, String url, boolean z6, BleDevice bleDevice, Vehicle vehicle) {
            y.f(context, "context");
            y.f(title, "title");
            y.f(url, "url");
            Intent intent = new Intent(context, (Class<?>) WebActivity.class);
            intent.putExtra("title", title);
            intent.putExtra(ImagesContract.URL, url);
            intent.putExtra("show_title_bar", z6);
            CommonExt.q(intent, bleDevice, vehicle, null, 4, null);
            context.startActivity(intent);
        }
    }

    public static final void c0(Context context, String str, String str2, boolean z6, BleDevice bleDevice, Vehicle vehicle) {
        f13179h.b(context, str, str2, z6, bleDevice, vehicle);
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public int V() {
        return R$layout.activity_web;
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public /* bridge */ /* synthetic */ String b0() {
        return (String) d0();
    }

    public Void d0() {
        return null;
    }

    @Override // com.uz.navee.base.BaseBindingActivity, com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String stringExtra;
        boolean booleanExtra;
        super.onCreate(bundle);
        Intent intent = getIntent();
        String str = "";
        if (intent.getData() != null) {
            Uri data = intent.getData();
            stringExtra = data != null ? data.getQueryParameter("title") : null;
            if (stringExtra == null) {
                stringExtra = "";
            } else {
                y.c(stringExtra);
            }
            Uri data2 = intent.getData();
            String queryParameter = data2 != null ? data2.getQueryParameter(ImagesContract.URL) : null;
            if (queryParameter != null) {
                y.c(queryParameter);
                str = queryParameter;
            }
            booleanExtra = stringExtra.length() > 0;
        } else {
            stringExtra = intent.getStringExtra("title");
            if (stringExtra == null) {
                stringExtra = "";
            } else {
                y.c(stringExtra);
            }
            String stringExtra2 = intent.getStringExtra(ImagesContract.URL);
            if (stringExtra2 != null) {
                y.c(stringExtra2);
                str = stringExtra2;
            }
            booleanExtra = intent.getBooleanExtra("show_title_bar", false);
        }
        getSupportFragmentManager().beginTransaction().add(R$id.fl_container, WebFragment.f13181g.a(stringExtra, str, booleanExtra, S(), U())).commit();
        if (booleanExtra) {
            return;
        }
        this.f13180g = false;
        e.a(this);
    }

    @Override // com.uz.navee.base.BaseActivity
    public boolean y() {
        return this.f13180g;
    }
}
