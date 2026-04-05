package com.uz.navee.ui.mine;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.b;
import com.bumptech.glide.h;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$mipmap;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.utils.c;

/* loaded from: classes3.dex */
public class OpenPictureActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public ImageView f13066c;

    /* renamed from: d, reason: collision with root package name */
    public String f13067d;

    private void Q() {
        this.f13066c = (ImageView) findViewById(R$id.imageView);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_open_picture);
        Q();
        c.e(this, "", ContextCompat.getColor(this, R$color.clear));
        this.f13067d = getIntent().getStringExtra("uri");
        ((h) b.w(this).v(this.f13067d).i(R$mipmap.nim_default_img)).z0(this.f13066c);
    }
}
