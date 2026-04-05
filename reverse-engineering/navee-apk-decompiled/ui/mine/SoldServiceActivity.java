package com.uz.navee.ui.mine;

import android.os.Bundle;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.utils.c;

/* loaded from: classes3.dex */
public class SoldServiceActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public TextView f13117c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f13118d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f13119e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f13120f;

    private void Q() {
        this.f13117c = (TextView) findViewById(R$id.titleLabel);
        this.f13118d = (TextView) findViewById(R$id.officialLabel);
        this.f13119e = (TextView) findViewById(R$id.timeLabel);
        this.f13120f = (TextView) findViewById(R$id.desLabel);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_sold_service);
        Q();
        c.e(this, getString(R$string.service_title), ContextCompat.getColor(this, R$color.nav_title_color));
        this.f13117c.setText(R$string.service_title);
        this.f13118d.setText(getString(R$string.service_official) + "：400-699-9700");
        this.f13119e.setText(getString(R$string.service_time) + "：9:00-18:00");
        this.f13120f.setText(R$string.service_des);
    }
}
