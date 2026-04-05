package com.uz.navee.ui.mine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uz.navee.base.RecyclerViewHolder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class GaojingAdapter<WarnConfig> extends RecyclerView.Adapter<RecyclerViewHolder> {

    /* renamed from: a, reason: collision with root package name */
    public List f13146a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f13147b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutInflater f13148c;

    /* renamed from: d, reason: collision with root package name */
    public a f13149d;

    public interface a {
        void a(View view, int i6);
    }

    public interface b {
    }

    public GaojingAdapter(Context context, List list) {
        ArrayList arrayList = new ArrayList();
        this.f13146a = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
        this.f13147b = context;
        this.f13148c = LayoutInflater.from(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(RecyclerViewHolder recyclerViewHolder, View view) {
        this.f13149d.a(recyclerViewHolder.itemView, recyclerViewHolder.getLayoutPosition());
    }

    public abstract void b(RecyclerViewHolder recyclerViewHolder, int i6, Object obj);

    public List c() {
        return this.f13146a;
    }

    public abstract int d(int i6);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(RecyclerViewHolder recyclerViewHolder, int i6) {
        b(recyclerViewHolder, i6, this.f13146a.get(i6));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i6) {
        final RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(this.f13148c.inflate(d(i6), viewGroup, false));
        if (this.f13149d != null) {
            recyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: i4.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f13983a.e(recyclerViewHolder, view);
                }
            });
        }
        return recyclerViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f13146a.size();
    }

    public void h(List list) {
        this.f13146a.clear();
        if (list != null) {
            this.f13146a.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(a aVar) {
        this.f13149d = aVar;
    }

    public void setOnItemLongClickListener(b bVar) {
    }
}
