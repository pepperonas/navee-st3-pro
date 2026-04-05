package com.uz.navee.ui;

import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.uz.navee.R$color;
import com.uz.navee.R$layout;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.utils.c;

/* loaded from: classes3.dex */
public class HelpActivity extends BaseActivity {
    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_help);
        c.e(this, "Help", ContextCompat.getColor(this, R$color.nav_title_color));
    }
}
