package com.uz.navee.ui.device;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.uz.navee.R$id;
import s1.o;

/* loaded from: classes3.dex */
public class ProductCarouselViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public SimpleDraweeView f12396a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f12397b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f12398c;

    /* renamed from: d, reason: collision with root package name */
    public Button f12399d;

    public ProductCarouselViewHolder(View view) {
        super(view);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.imageView);
        this.f12396a = simpleDraweeView;
        simpleDraweeView.getHierarchy().s(o.b.f17064e);
        this.f12397b = (TextView) view.findViewById(R$id.nameLabel);
        this.f12398c = (TextView) view.findViewById(R$id.describeLabel);
        this.f12399d = (Button) view.findViewById(R$id.moreButton);
    }
}
