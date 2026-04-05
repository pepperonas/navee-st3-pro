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
import com.wildma.pictureselector.PictureBean;
import java.util.List;

/* loaded from: classes3.dex */
public class PictureAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a, reason: collision with root package name */
    public List f13163a;

    /* renamed from: b, reason: collision with root package name */
    public Context f13164b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13165c;

    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public ImageView f13166a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f13167b;

        public ViewHolder(View view) {
            super(view);
            this.f13166a = (ImageView) view.findViewById(R$id.image);
            this.f13167b = (ImageView) view.findViewById(R$id.delete);
        }
    }

    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewHolder f13169a;

        public a(ViewHolder viewHolder) {
            this.f13169a = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f13169a.getLayoutPosition();
            PictureAdapter.a(PictureAdapter.this);
            ImageView imageView = this.f13169a.f13166a;
            throw null;
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewHolder f13171a;

        public b(ViewHolder viewHolder) {
            this.f13171a = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f13171a.getLayoutPosition();
            PictureAdapter.a(PictureAdapter.this);
            ImageView imageView = this.f13171a.f13166a;
            throw null;
        }
    }

    public interface c {
    }

    public static /* bridge */ /* synthetic */ c a(PictureAdapter pictureAdapter) {
        pictureAdapter.getClass();
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ViewHolder viewHolder, int i6) {
        ((h) com.bumptech.glide.b.t(this.f13164b).t(((PictureBean) this.f13163a.get(i6)).getUri()).i(R$mipmap.nim_default_img)).z0(viewHolder.f13166a);
        viewHolder.f13166a.setOnClickListener(new a(viewHolder));
        viewHolder.f13167b.setOnClickListener(new b(viewHolder));
        if (this.f13165c) {
            viewHolder.f13167b.setVisibility(0);
        } else {
            viewHolder.f13167b.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i6) {
        return this.f13165c ? new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_picture, viewGroup, false)) : new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_picture2, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f13163a.size();
    }

    public void setOnItemClickListener(c cVar) {
    }
}
