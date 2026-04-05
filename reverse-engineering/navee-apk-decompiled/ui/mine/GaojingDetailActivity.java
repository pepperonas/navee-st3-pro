package com.uz.navee.ui.mine;

import android.os.Bundle;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.bean.WarnConfig;
import com.uz.navee.utils.c;
import com.uz.navee.utils.j0;

/* loaded from: classes3.dex */
public class GaojingDetailActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public TextView f13024c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f13025d;

    /* renamed from: e, reason: collision with root package name */
    public WarnConfig f13026e;

    private void Q() {
        this.f13024c = (TextView) findViewById(R$id.tv_warnType);
        this.f13025d = (TextView) findViewById(R$id.tv_warnTime);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_gaojing_detail);
        Q();
        this.f13026e = (WarnConfig) getIntent().getSerializableExtra("config");
        c.e(this, getString(R$string.detail), ContextCompat.getColor(this, R$color.nav_title_color));
        WarnConfig warnConfig = this.f13026e;
        if (warnConfig != null) {
            this.f13024c.setText(warnConfig.getName());
            this.f13025d.setText(j0.a(this.f13026e.getContent()));
        }
    }
}
