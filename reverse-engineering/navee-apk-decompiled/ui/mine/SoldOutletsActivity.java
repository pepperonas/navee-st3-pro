package com.uz.navee.ui.mine;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.utils.s;

/* loaded from: classes3.dex */
public class SoldOutletsActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public View f13113c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f13114d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f13115e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f13116f;

    private void U() {
        this.f13113c = findViewById(R$id.logo_toolbar);
        this.f13114d = (TextView) findViewById(R$id.titleView_toolbar);
        this.f13115e = (TextView) findViewById(R$id.tv_right_toolbar);
        this.f13116f = (ImageView) findViewById(R$id.qrImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(View view) {
        Z();
    }

    public final /* synthetic */ boolean X(View view) {
        Z();
        return false;
    }

    public final /* synthetic */ void Y(QMUIBottomSheet qMUIBottomSheet, View view, int i6, String str) {
        qMUIBottomSheet.dismiss();
        if (i6 == 0) {
            if (s.g(BitmapFactory.decodeResource(getResources(), R$mipmap.img_qr_outlets), this, "navee_outlets_qr.jpg", null, 75) != null) {
                Toast.makeText(this, getString(R$string.save_pic_success), 0).show();
                return;
            } else {
                Toast.makeText(this, getString(R$string.save_pic_failure), 0).show();
                return;
            }
        }
        if (i6 == 1) {
            Uri uri = Uri.parse("https://service.naveetech.com");
            if (uri != null) {
                startActivity(new Intent("android.intent.action.VIEW", uri));
            } else {
                Toast.makeText(this, getString(R$string.identify_qr_code_failure), 0).show();
            }
        }
    }

    public final void Z() {
        QMUIBottomSheet.e eVar = new QMUIBottomSheet.e(this);
        ((QMUIBottomSheet.e) ((QMUIBottomSheet.e) ((QMUIBottomSheet.e) ((QMUIBottomSheet.e) eVar.q(true).l(QMUISkinManager.e(this))).i(true)).k(getString(R$string.cancel))).j(true)).s(new QMUIBottomSheet.e.c() { // from class: h4.y1
            @Override // com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet.e.c
            public final void a(QMUIBottomSheet qMUIBottomSheet, View view, int i6, String str) {
                this.f13837a.Y(qMUIBottomSheet, view, i6, str);
            }
        });
        eVar.o(getString(R$string.save_pic));
        eVar.o(getString(R$string.identify_qr_code));
        eVar.a().show();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_sold_outlets);
        U();
        this.f13113c.setOnClickListener(new View.OnClickListener() { // from class: h4.v1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13830a.V(view);
            }
        });
        this.f13114d.setText(getString(R$string.sold_website));
        this.f13114d.setTextColor(ContextCompat.getColor(this, R$color.nav_title_color));
        this.f13115e.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R$mipmap.ic_more), (Drawable) null, (Drawable) null, (Drawable) null);
        this.f13115e.setCompoundDrawablePadding(20);
        this.f13115e.setVisibility(0);
        this.f13115e.setOnClickListener(new View.OnClickListener() { // from class: h4.w1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13833a.W(view);
            }
        });
        this.f13116f.setOnLongClickListener(new View.OnLongClickListener() { // from class: h4.x1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f13836a.X(view);
            }
        });
    }
}
