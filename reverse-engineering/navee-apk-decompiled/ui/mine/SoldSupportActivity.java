package com.uz.navee.ui.mine;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.utils.DensityUtil;
import com.uz.navee.utils.c;
import com.uz.navee.utils.d;
import com.uz.navee.utils.s;
import com.uz.navee.utils.y;

/* loaded from: classes3.dex */
public class SoldSupportActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public QMUIGroupListView f13121c;

    private void U() {
        this.f13121c = (QMUIGroupListView) findViewById(R$id.groupListView);
    }

    private void V() {
        int iA = DensityUtil.a(this, 16.0f);
        QMUICommonListItemView qMUICommonListItemViewC = this.f13121c.c(null, getString(R$string.feedback_usage), "", 1, 1);
        d.t(this, qMUICommonListItemViewC);
        qMUICommonListItemViewC.setRadius(iA);
        QMUICommonListItemView qMUICommonListItemViewC2 = this.f13121c.c(null, getString(R$string.feedback_quality), "", 1, 1);
        d.t(this, qMUICommonListItemViewC2);
        qMUICommonListItemViewC2.setRadius(iA);
        QMUIGroupListView.e(this).c(qMUICommonListItemViewC, new View.OnClickListener() { // from class: h4.z1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13841a.W(view);
            }
        }).e(this.f13121c);
        QMUIGroupListView.e(this).c(qMUICommonListItemViewC2, new View.OnClickListener() { // from class: h4.a2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13756a.X(view);
            }
        }).e(this.f13121c);
        if (y.a().equals("CN")) {
            findViewById(R$id.ll_sold_foreign).setVisibility(8);
            TextView textView = (TextView) findViewById(R$id.titleLabel);
            TextView textView2 = (TextView) findViewById(R$id.officialLabel);
            TextView textView3 = (TextView) findViewById(R$id.timeLabel);
            TextView textView4 = (TextView) findViewById(R$id.desLabel);
            textView.setText(R$string.service_title);
            textView2.setText(getString(R$string.service_official) + "：400-699-9700");
            textView3.setText(getString(R$string.service_time) + "：9:00-18:00");
            textView4.setText(R$string.service_des);
        } else {
            findViewById(R$id.ll_sold_inland).setVisibility(8);
            ((TextView) findViewById(R$id.titleLabel2)).setText(R$string.service_title);
            ((ImageView) findViewById(R$id.qrImageView)).setOnLongClickListener(new View.OnLongClickListener() { // from class: h4.b2
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return this.f13760a.Y(view);
                }
            });
        }
        if (d.p(this)) {
            d.b(this.f13121c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(View view) {
        b0(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(View view) {
        b0(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(QMUIBottomSheet qMUIBottomSheet, View view, int i6, String str) {
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

    private void a0() {
        QMUIBottomSheet.e eVar = new QMUIBottomSheet.e(this);
        ((QMUIBottomSheet.e) ((QMUIBottomSheet.e) ((QMUIBottomSheet.e) ((QMUIBottomSheet.e) eVar.q(true).l(QMUISkinManager.e(this))).i(true)).k(getString(R$string.cancel))).j(true)).s(new QMUIBottomSheet.e.c() { // from class: h4.c2
            @Override // com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet.e.c
            public final void a(QMUIBottomSheet qMUIBottomSheet, View view, int i6, String str) {
                this.f13764a.Z(qMUIBottomSheet, view, i6, str);
            }
        });
        eVar.o(getString(R$string.save_pic));
        eVar.o(getString(R$string.identify_qr_code));
        eVar.a().show();
    }

    public final /* synthetic */ boolean Y(View view) {
        a0();
        return false;
    }

    public final void b0(int i6) {
        AddFeedbackActivity.D0(this, i6);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_sold_support);
        U();
        c.e(this, getString(R$string.sold_support), ContextCompat.getColor(this, R$color.nav_title_color));
        V();
    }
}
