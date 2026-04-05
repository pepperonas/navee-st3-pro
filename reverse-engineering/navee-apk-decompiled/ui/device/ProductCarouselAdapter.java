package com.uz.navee.ui.device;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.uz.navee.MyApplication;
import com.uz.navee.R$layout;
import com.uz.navee.bean.ProductInfo;
import com.youth.banner.adapter.BannerAdapter;
import java.util.List;

/* loaded from: classes3.dex */
public class ProductCarouselAdapter extends BannerAdapter<ProductInfo, ProductCarouselViewHolder> {
    public ProductCarouselAdapter(List list) {
        super(list);
    }

    public static /* synthetic */ void d(ProductInfo productInfo, View view) {
        MyApplication.f11588e.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(productInfo.getHref())));
    }

    @Override // com.youth.banner.holder.IViewHolder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindView(ProductCarouselViewHolder productCarouselViewHolder, final ProductInfo productInfo, int i6, int i7) {
        com.bumptech.glide.b.u(productCarouselViewHolder.f12396a).t(Uri.parse(productInfo.getImgs())).z0(productCarouselViewHolder.f12396a);
        productCarouselViewHolder.f12397b.setText(productInfo.getName());
        productCarouselViewHolder.f12398c.setText(productInfo.getSlogan());
        productCarouselViewHolder.f12399d.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.b8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProductCarouselAdapter.d(productInfo, view);
            }
        });
    }

    @Override // com.youth.banner.holder.IViewHolder
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ProductCarouselViewHolder onCreateHolder(ViewGroup viewGroup, int i6) {
        return new ProductCarouselViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.cell_product_carousel, viewGroup, false));
    }
}
