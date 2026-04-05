package com.uz.navee.ui.mine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.h;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$mipmap;
import com.uz.navee.ui.mine.bean.AttachmentItem;
import java.util.List;

/* loaded from: classes3.dex */
public class PhotoAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a, reason: collision with root package name */
    public Context f13150a;

    /* renamed from: b, reason: collision with root package name */
    public List f13151b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13152c = true;

    /* renamed from: d, reason: collision with root package name */
    public int f13153d = 3;

    /* renamed from: e, reason: collision with root package name */
    public c f13154e;

    /* renamed from: f, reason: collision with root package name */
    public View.OnClickListener f13155f;

    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public ImageView f13156a;

        /* renamed from: b, reason: collision with root package name */
        public View f13157b;

        public ViewHolder(View view) {
            super(view);
            this.f13156a = (ImageView) view.findViewById(R$id.image);
            this.f13157b = view.findViewById(R$id.delete);
        }
    }

    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewHolder f13159a;

        public a(ViewHolder viewHolder) {
            this.f13159a = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhotoAdapter.this.f13154e.a(this.f13159a.f13156a, this.f13159a.getLayoutPosition());
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewHolder f13161a;

        public b(ViewHolder viewHolder) {
            this.f13161a = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhotoAdapter.this.f13154e.b(this.f13161a.f13156a, this.f13161a.getLayoutPosition());
        }
    }

    public interface c {
        void a(View view, int i6);

        void b(View view, int i6);
    }

    public PhotoAdapter(List list, Context context) {
        this.f13150a = context;
        this.f13151b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ViewHolder viewHolder, int i6) {
        if (i6 == this.f13151b.size()) {
            viewHolder.f13157b.setVisibility(8);
            com.bumptech.glide.b.t(this.f13150a).u(Integer.valueOf(R$mipmap.ic_feedback_img_add)).z0(viewHolder.f13156a);
            viewHolder.f13156a.setOnClickListener(this.f13155f);
            return;
        }
        ((h) com.bumptech.glide.b.t(this.f13150a).t(((AttachmentItem) this.f13151b.get(i6)).uri).i(R$mipmap.nim_default_img)).z0(viewHolder.f13156a);
        viewHolder.f13156a.setOnClickListener(new a(viewHolder));
        viewHolder.f13157b.setOnClickListener(new b(viewHolder));
        if (this.f13152c) {
            viewHolder.f13157b.setVisibility(0);
        } else {
            viewHolder.f13157b.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i6) {
        return this.f13152c ? new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_picture, viewGroup, false)) : new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_picture2, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f13151b.size() == this.f13153d ? this.f13151b.size() : this.f13151b.size() + 1;
    }

    public void setOnAddClickListener(View.OnClickListener onClickListener) {
        this.f13155f = onClickListener;
    }

    public void setOnItemClickListener(c cVar) {
        this.f13154e = cVar;
    }
}
