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
import com.uz.navee.utils.j0;

/* loaded from: classes3.dex */
public class QuestionDetailActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public String f13072c;

    /* renamed from: d, reason: collision with root package name */
    public String f13073d;

    /* renamed from: e, reason: collision with root package name */
    public String f13074e;

    /* renamed from: f, reason: collision with root package name */
    public String f13075f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f13076g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f13077h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f13078i;

    private void Q() {
        this.f13076g = (TextView) findViewById(R$id.tv_issue);
        this.f13077h = (TextView) findViewById(R$id.tv_reply);
        this.f13078i = (TextView) findViewById(R$id.titleView_toolbar);
    }

    private void initData() {
        this.f13072c = getIntent().getStringExtra("title");
        if (d.p(this)) {
            this.f13073d = "Q: \u202b" + getIntent().getStringExtra("issue") + "\u202c";
        } else {
            this.f13073d = "Q: " + getIntent().getStringExtra("issue");
        }
        this.f13074e = getIntent().getStringExtra("reply");
        this.f13075f = getIntent().getStringExtra("language");
        this.f13078i.setText(R$string.question_detail);
        this.f13076g.setText(this.f13073d);
        this.f13077h.setText(j0.a(this.f13074e));
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_question_detail);
        Q();
        c.e(this, getString(R$string.question_detail), ContextCompat.getColor(this, R$color.nav_title_color));
        initData();
    }
}
