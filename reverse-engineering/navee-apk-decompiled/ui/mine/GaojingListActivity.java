package com.uz.navee.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.base.RecyclerViewHolder;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.bean.WarnConfig;
import com.uz.navee.ui.mine.adapter.GaojingAdapter;
import d4.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class GaojingListActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public RecyclerView f13027c;

    /* renamed from: d, reason: collision with root package name */
    public GaojingAdapter f13028d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f13029e = Boolean.FALSE;

    /* renamed from: f, reason: collision with root package name */
    public Vehicle f13030f;

    public class a extends LinearLayoutManager {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public RecyclerView.LayoutParams generateDefaultLayoutParams() {
            return new RecyclerView.LayoutParams(-1, -2);
        }
    }

    public class b extends GaojingAdapter {
        public b(Context context, List list) {
            super(context, list);
        }

        @Override // com.uz.navee.ui.mine.adapter.GaojingAdapter
        public int d(int i6) {
            return R$layout.gaojing_list_item;
        }

        @Override // com.uz.navee.ui.mine.adapter.GaojingAdapter
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void b(RecyclerViewHolder recyclerViewHolder, int i6, WarnConfig warnConfig) {
            recyclerViewHolder.d(R$id.textLabel, warnConfig.getName());
        }
    }

    public class c implements d.h {

        public class a extends TypeToken<HttpResponse<ArrayList<WarnConfig>>> {
            public a() {
            }
        }

        public c() {
        }

        @Override // d4.d.h
        public void a(String str) {
            GaojingListActivity.this.B();
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse == null || httpResponse.getCode() != 200) {
                return;
            }
            b4.a.W().f1935h = (ArrayList) httpResponse.getData();
            GaojingListActivity.this.f13028d.h((ArrayList) httpResponse.getData());
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            GaojingListActivity.this.B();
        }
    }

    private void S() {
        this.f13027c = (RecyclerView) findViewById(R$id.recyclerView);
    }

    private void initData() {
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        if (bundleExtra != null) {
            this.f13030f = (Vehicle) bundleExtra.getSerializable("vehicle");
        }
        this.f13027c.setLayoutManager(new a(this));
        b bVar = new b(this, null);
        this.f13028d = bVar;
        bVar.setOnItemClickListener(new GaojingAdapter.a() { // from class: h4.w0
            @Override // com.uz.navee.ui.mine.adapter.GaojingAdapter.a
            public final void a(View view, int i6) {
                this.f13832a.W(view, i6);
            }
        });
        this.f13027c.setAdapter(this.f13028d);
        V();
    }

    public final void V() {
        if (this.f13030f == null) {
            return;
        }
        String str = e4.a.a() + "/getWarnCfg?category=" + this.f13030f.model.category;
        d dVarH = d.h();
        K();
        dVarH.f(str, new c());
    }

    public final /* synthetic */ void W(View view, int i6) {
        if (this.f13029e.booleanValue()) {
            return;
        }
        this.f13029e = Boolean.TRUE;
        Intent intent = new Intent(this, (Class<?>) GaojingDetailActivity.class);
        intent.putExtra("config", (Serializable) this.f13028d.c().get(i6));
        startActivity(intent);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_gaojing_list);
        S();
        com.uz.navee.utils.c.e(this, getString(R$string.alarm_list), ContextCompat.getColor(this, R$color.nav_title_color));
        initData();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f13029e = Boolean.FALSE;
    }
}
