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
import com.uz.navee.utils.d;

/* loaded from: classes3.dex */
public class VersionMsgActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public TextView f13144c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f13145d;

    private void Q() {
        this.f13144c = (TextView) findViewById(R$id.TV_version_no);
        this.f13145d = (TextView) findViewById(R$id.tv_company_profile);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_version_msg);
        Q();
        c.e(this, getString(R$string.version_info), ContextCompat.getColor(this, R$color.nav_title_color));
        this.f13144c.setText("V " + d.c());
    }
}
