package com.uz.navee.ui.mine;

import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$color;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.databinding.ActivityDownloadExplainBinding;
import com.uz.navee.utils.c;
import kotlin.jvm.internal.y;

/* loaded from: classes3.dex */
public final class DownloadExplainActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public ActivityDownloadExplainBinding f13014c;

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R$layout.activity_download_explain);
        y.e(contentView, "setContentView(...)");
        this.f13014c = (ActivityDownloadExplainBinding) contentView;
        String string = getString(R$string.download_guide);
        y.e(string, "getString(...)");
        c.e(this, string, ContextCompat.getColor(this, R$color.nav_title_color));
    }
}
