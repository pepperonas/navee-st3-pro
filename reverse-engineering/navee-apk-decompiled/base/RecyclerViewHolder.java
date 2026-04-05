package com.uz.navee.base;

import android.util.SparseArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public SparseArray f11620a;

    public RecyclerViewHolder(View view) {
        super(view);
        this.f11620a = new SparseArray();
    }

    private View findViewById(int i6) {
        View view = (View) this.f11620a.get(i6);
        if (view != null) {
            return view;
        }
        View viewFindViewById = this.itemView.findViewById(i6);
        this.f11620a.put(i6, viewFindViewById);
        return viewFindViewById;
    }

    public ImageButton a(int i6) {
        return (ImageButton) getView(i6);
    }

    public ImageView b(int i6) {
        return (ImageView) getView(i6);
    }

    public TextView c(int i6) {
        return (TextView) getView(i6);
    }

    public RecyclerViewHolder d(int i6, String str) {
        ((TextView) findViewById(i6)).setText(str);
        return this;
    }

    public View getView(int i6) {
        return findViewById(i6);
    }
}
