package com.uz.navee.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.uz.navee.R$id;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.databinding.ActivityResetAcPswBinding;
import com.uz.navee.utils.d;

/* loaded from: classes3.dex */
public class ResetAcAndPswActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public ImageView f12874c;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(View view) {
        finish();
    }

    @Override // com.uz.navee.base.BaseActivity
    public void E() {
        super.E();
        if (d.p(this)) {
            this.f12874c.setImageDrawable(d.q(ContextCompat.getDrawable(this, R$mipmap.ic_nav_back)));
        }
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityResetAcPswBinding activityResetAcPswBindingInflate = ActivityResetAcPswBinding.inflate(getLayoutInflater());
        setContentView(activityResetAcPswBindingInflate.getRoot());
        activityResetAcPswBindingInflate.include.titleViewToolbar.setVisibility(0);
        activityResetAcPswBindingInflate.include.titleViewToolbar.setText(R$string.forgot_account_pwd);
        activityResetAcPswBindingInflate.include.logoToolbar.setOnClickListener(new View.OnClickListener() { // from class: g4.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13707a.R(view);
            }
        });
        activityResetAcPswBindingInflate.tvTitle.setText(d.a(getString(R$string.forgot_account_pwd)));
        this.f12874c = (ImageView) findViewById(R$id.logo_toolbar);
        E();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C();
    }
}
