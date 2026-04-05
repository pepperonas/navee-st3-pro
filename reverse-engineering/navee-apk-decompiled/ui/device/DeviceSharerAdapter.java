package com.uz.navee.ui.device;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.uz.navee.R$layout;
import com.uz.navee.bean.VehicleSharer;
import com.uz.navee.databinding.ItemDeviceSharerBinding;
import java.util.Collection;

/* loaded from: classes3.dex */
public final class DeviceSharerAdapter extends BaseQuickAdapter<VehicleSharer, BaseDataBindingHolder<ItemDeviceSharerBinding>> {

    /* renamed from: u, reason: collision with root package name */
    public final boolean f12297u;

    /* renamed from: v, reason: collision with root package name */
    public int f12298v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f12299w;

    public DeviceSharerAdapter(boolean z6) {
        super(R$layout.item_device_sharer, null, 2, null);
        this.f12297u = z6;
        this.f12298v = -1;
    }

    public static final void W(DeviceSharerAdapter this$0, int i6, CompoundButton compoundButton, boolean z6) {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        if (!z6) {
            this$0.f12298v = -1;
        } else {
            this$0.f12298v = i6;
            this$0.notifyDataSetChanged();
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void R(Collection collection) {
        if (collection == null || collection.size() != 1) {
            this.f12299w = false;
            this.f12298v = -1;
        } else {
            this.f12298v = 0;
            this.f12299w = true;
        }
        super.R(collection);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public void i(BaseDataBindingHolder holder, VehicleSharer item) {
        kotlin.jvm.internal.y.f(holder, "holder");
        kotlin.jvm.internal.y.f(item, "item");
        final int iIndexOf = p().indexOf(item);
        ItemDeviceSharerBinding itemDeviceSharerBinding = (ItemDeviceSharerBinding) holder.getDataBinding();
        if (itemDeviceSharerBinding != null) {
            CheckBox cbSharer = itemDeviceSharerBinding.cbSharer;
            kotlin.jvm.internal.y.e(cbSharer, "cbSharer");
            cbSharer.setVisibility(this.f12297u ? 0 : 8);
            AppCompatImageView ivRemove = itemDeviceSharerBinding.ivRemove;
            kotlin.jvm.internal.y.e(ivRemove, "ivRemove");
            ivRemove.setVisibility(this.f12297u ^ true ? 0 : 8);
            itemDeviceSharerBinding.setItem(item);
            itemDeviceSharerBinding.setChecked(Boolean.valueOf(iIndexOf == this.f12298v));
            itemDeviceSharerBinding.cbSharer.setOnCheckedChangeListener(null);
            if (this.f12299w) {
                itemDeviceSharerBinding.cbSharer.setEnabled(false);
            } else {
                itemDeviceSharerBinding.cbSharer.setEnabled(true);
                itemDeviceSharerBinding.cbSharer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.p6
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) {
                        DeviceSharerAdapter.W(this.f12616a, iIndexOf, compoundButton, z6);
                    }
                });
            }
        }
    }

    public final int X() {
        return this.f12298v;
    }
}
