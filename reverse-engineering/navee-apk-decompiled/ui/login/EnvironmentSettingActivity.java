package com.uz.navee.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$mipmap;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.utils.DensityUtil;
import com.uz.navee.utils.c;
import com.uz.navee.utils.d;
import com.uz.navee.utils.g0;

/* loaded from: classes3.dex */
public class EnvironmentSettingActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public QMUIGroupListView f12723c;

    /* renamed from: d, reason: collision with root package name */
    public QMUICommonListItemView f12724d;

    /* renamed from: e, reason: collision with root package name */
    public QMUICommonListItemView f12725e;

    /* renamed from: f, reason: collision with root package name */
    public QMUICommonListItemView f12726f;

    /* renamed from: g, reason: collision with root package name */
    public int f12727g;

    private void T() {
        this.f12723c = (QMUIGroupListView) findViewById(R$id.groupListView);
    }

    private void U() {
        int iA = DensityUtil.a(this, 16.0f);
        QMUICommonListItemView qMUICommonListItemViewC = this.f12723c.c(null, "正式1", "https://lj.naveetech.com", 1, 3);
        this.f12724d = qMUICommonListItemViewC;
        qMUICommonListItemViewC.e(iA, 3);
        this.f12725e = this.f12723c.c(null, "正式2", "https://alb.chejiyou.com", 1, 3);
        QMUICommonListItemView qMUICommonListItemViewC2 = this.f12723c.c(null, "测试", "http://naveeap.chejiyou.com", 1, 3);
        this.f12726f = qMUICommonListItemViewC2;
        qMUICommonListItemViewC2.e(iA, 1);
        Y();
        QMUIGroupListView.e(this).c(this.f12724d, new View.OnClickListener() { // from class: g4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13660a.V(view);
            }
        }).c(this.f12725e, new View.OnClickListener() { // from class: g4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13663a.W(view);
            }
        }).c(this.f12726f, new View.OnClickListener() { // from class: g4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13666a.X(view);
            }
        }).e(this.f12723c);
        if (d.p(this)) {
            d.b(this.f12723c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(View view) {
        Z(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(View view) {
        Z(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(View view) {
        Z(2);
    }

    private void Y() {
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, R$mipmap.ic_check));
        int i6 = this.f12727g;
        if (i6 == 0) {
            this.f12724d.setAccessoryType(3);
            this.f12725e.setAccessoryType(0);
            this.f12726f.setAccessoryType(0);
            this.f12724d.l(imageView);
            return;
        }
        if (i6 == 1) {
            this.f12724d.setAccessoryType(0);
            this.f12725e.setAccessoryType(3);
            this.f12726f.setAccessoryType(0);
            this.f12725e.l(imageView);
            return;
        }
        if (i6 == 2) {
            this.f12724d.setAccessoryType(0);
            this.f12725e.setAccessoryType(0);
            this.f12726f.setAccessoryType(3);
            this.f12726f.l(imageView);
        }
    }

    public final void Z(int i6) {
        this.f12727g = i6;
        Y();
        g0.f("Environment", Integer.valueOf(i6));
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_environment_setting);
        T();
        c.e(this, "环境", ContextCompat.getColor(this, R$color.nav_title_color));
        this.f12727g = 0;
        Object objA = g0.a("Environment", 0);
        if (objA != null) {
            this.f12727g = ((Integer) objA).intValue();
        }
        U();
    }
}
