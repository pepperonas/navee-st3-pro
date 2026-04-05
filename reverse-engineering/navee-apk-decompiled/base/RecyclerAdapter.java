package com.uz.navee.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class RecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder> {

    /* renamed from: a, reason: collision with root package name */
    public List f11616a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f11617b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutInflater f11618c;

    /* renamed from: d, reason: collision with root package name */
    public a f11619d;

    public interface a {
        void a(View view, int i6);
    }

    public interface b {
    }

    public RecyclerAdapter(Context context, List list) {
        ArrayList arrayList = new ArrayList();
        this.f11616a = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
        this.f11617b = context;
        this.f11618c = LayoutInflater.from(context);
    }

    public void b(List list) {
        this.f11616a.addAll(list);
        notifyDataSetChanged();
    }

    public abstract void c(RecyclerViewHolder recyclerViewHolder, int i6, Object obj);

    public List d() {
        return this.f11616a;
    }

    public abstract int e(int i6);

    public final /* synthetic */ void f(RecyclerViewHolder recyclerViewHolder, View view) {
        this.f11619d.a(recyclerViewHolder.itemView, recyclerViewHolder.getLayoutPosition());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(RecyclerViewHolder recyclerViewHolder, int i6) {
        c(recyclerViewHolder, i6, this.f11616a.get(i6));
    }

    public Object getItem(int i6) {
        return this.f11616a.get(i6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f11616a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i6) {
        final RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(this.f11618c.inflate(e(i6), viewGroup, false));
        if (this.f11619d != null) {
            recyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.base.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f11623a.f(recyclerViewHolder, view);
                }
            });
        }
        return recyclerViewHolder;
    }

    public void i() {
        notifyDataSetChanged();
    }

    public void j(List list) {
        this.f11616a.clear();
        if (list != null) {
            this.f11616a.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void k(int i6, Object obj, boolean z6) {
        this.f11616a.set(i6, obj);
        if (z6) {
            notifyItemChanged(i6);
        } else {
            notifyDataSetChanged();
        }
    }

    public void setOnItemClickListener(a aVar) {
        this.f11619d = aVar;
    }

    public void setOnItemLongClickListener(b bVar) {
    }
}
