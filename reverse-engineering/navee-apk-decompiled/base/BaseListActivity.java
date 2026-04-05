package com.uz.navee.base;

import android.content.Context;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uz.navee.R$id;
import java.util.List;

/* loaded from: classes3.dex */
public class BaseListActivity<T> extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public RecyclerAdapter f11599c;

    /* renamed from: d, reason: collision with root package name */
    public h f11600d;

    /* renamed from: e, reason: collision with root package name */
    public int f11601e = 1;

    /* renamed from: f, reason: collision with root package name */
    public final int f11602f = 20;

    /* renamed from: g, reason: collision with root package name */
    public boolean f11603g = false;

    public class a extends LinearLayoutManager {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public RecyclerView.LayoutParams generateDefaultLayoutParams() {
            return new RecyclerView.LayoutParams(-1, -2);
        }
    }

    public class b extends RecyclerAdapter {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ h f11605e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, List list, h hVar) {
            super(context, list);
            this.f11605e = hVar;
        }

        @Override // com.uz.navee.base.RecyclerAdapter
        public void c(RecyclerViewHolder recyclerViewHolder, int i6, Object obj) {
            this.f11605e.c(recyclerViewHolder, i6, obj);
        }

        @Override // com.uz.navee.base.RecyclerAdapter
        public int e(int i6) {
            return this.f11605e.a(i6);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i6) {
            return this.f11605e.getItemViewType(i6);
        }
    }

    public void Q(h hVar) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R$id.recyclerView);
        recyclerView.setLayoutManager(new a(this));
        b bVar = new b(this, null, hVar);
        this.f11599c = bVar;
        this.f11600d = hVar;
        recyclerView.setAdapter(bVar);
        hVar.b();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
