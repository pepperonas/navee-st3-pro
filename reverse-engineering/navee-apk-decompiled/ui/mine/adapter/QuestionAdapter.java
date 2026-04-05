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
public abstract class QuestionAdapter<QuestionBean> extends RecyclerView.Adapter<RecyclerViewHolder> {

    /* renamed from: a, reason: collision with root package name */
    public List f13173a;

    /* renamed from: b, reason: collision with root package name */
    public Context f13174b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutInflater f13175c;

    /* renamed from: d, reason: collision with root package name */
    public b f13176d;

    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerViewHolder f13177a;

        public a(RecyclerViewHolder recyclerViewHolder) {
            this.f13177a = recyclerViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = QuestionAdapter.this.f13176d;
            RecyclerViewHolder recyclerViewHolder = this.f13177a;
            bVar.a(recyclerViewHolder.itemView, recyclerViewHolder.getLayoutPosition());
        }
    }

    public interface b {
        void a(View view, int i6);
    }

    public interface c {
    }

    public QuestionAdapter(Context context, List list) {
        ArrayList arrayList = new ArrayList();
        this.f13173a = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
        this.f13174b = context;
        this.f13175c = LayoutInflater.from(context);
    }

    public void b(List list) {
        this.f13173a.addAll(list);
        notifyDataSetChanged();
    }

    public abstract void c(RecyclerViewHolder recyclerViewHolder, int i6, Object obj);

    public List d() {
        return this.f13173a;
    }

    public abstract int e(int i6);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(RecyclerViewHolder recyclerViewHolder, int i6) {
        c(recyclerViewHolder, i6, this.f13173a.get(i6));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i6) {
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(this.f13175c.inflate(e(i6), viewGroup, false));
        if (this.f13176d != null) {
            recyclerViewHolder.itemView.setOnClickListener(new a(recyclerViewHolder));
        }
        return recyclerViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f13173a.size();
    }

    public void h(List list) {
        this.f13173a.clear();
        if (list != null) {
            this.f13173a.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(b bVar) {
        this.f13176d = bVar;
    }

    public void setOnItemLongClickListener(c cVar) {
    }
}
