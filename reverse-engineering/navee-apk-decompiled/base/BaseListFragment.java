package com.uz.navee.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uz.navee.R$id;
import java.util.List;

/* loaded from: classes3.dex */
public class BaseListFragment<T> extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public View f11607a;

    /* renamed from: b, reason: collision with root package name */
    public RecyclerAdapter f11608b;

    /* renamed from: c, reason: collision with root package name */
    public h f11609c;

    /* renamed from: d, reason: collision with root package name */
    public int f11610d = 1;

    /* renamed from: e, reason: collision with root package name */
    public final int f11611e = 20;

    /* renamed from: f, reason: collision with root package name */
    public boolean f11612f = false;

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
        public final /* synthetic */ h f11614e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, List list, h hVar) {
            super(context, list);
            this.f11614e = hVar;
        }

        @Override // com.uz.navee.base.RecyclerAdapter
        public void c(RecyclerViewHolder recyclerViewHolder, int i6, Object obj) {
            this.f11614e.c(recyclerViewHolder, i6, obj);
        }

        @Override // com.uz.navee.base.RecyclerAdapter
        public int e(int i6) {
            return this.f11614e.a(i6);
        }
    }

    public void b(h hVar, RecyclerView.LayoutManager layoutManager, RecyclerView.ItemDecoration itemDecoration) {
        RecyclerView recyclerView = (RecyclerView) this.f11607a.findViewById(R$id.recyclerView);
        if (layoutManager == null) {
            layoutManager = new a(requireContext());
        }
        recyclerView.setLayoutManager(layoutManager);
        if (itemDecoration != null) {
            recyclerView.addItemDecoration(itemDecoration);
        }
        b bVar = new b(requireContext(), null, hVar);
        this.f11608b = bVar;
        this.f11609c = hVar;
        recyclerView.setAdapter(bVar);
        hVar.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
