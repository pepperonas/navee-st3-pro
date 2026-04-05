package com.uz.navee.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$id;
import com.uz.navee.bean.VehicleSharer;

/* loaded from: classes3.dex */
public class ItemDeviceSharerBindingImpl extends ItemDeviceSharerBinding {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @NonNull
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R$id.iv_remove, 6);
    }

    public ItemDeviceSharerBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00b7 A[PHI: r17
      0x00b7: PHI (r17v2 java.lang.String) = (r17v1 java.lang.String), (r17v7 java.lang.String), (r17v7 java.lang.String) binds: [B:43:0x009d, B:49:0x00ae, B:50:0x00b0] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uz.navee.databinding.ItemDeviceSharerBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.mDirtyFlags != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i6, Object obj, int i7) {
        return false;
    }

    @Override // com.uz.navee.databinding.ItemDeviceSharerBinding
    public void setChecked(@Nullable Boolean bool) {
        this.mChecked = bool;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // com.uz.navee.databinding.ItemDeviceSharerBinding
    public void setItem(@Nullable VehicleSharer vehicleSharer) {
        this.mItem = vehicleSharer;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(5);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i6, @Nullable Object obj) {
        if (5 == i6) {
            setItem((VehicleSharer) obj);
            return true;
        }
        if (1 != i6) {
            return false;
        }
        setChecked((Boolean) obj);
        return true;
    }

    private ItemDeviceSharerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CheckBox) objArr[5], (ImageFilterView) objArr[1], (AppCompatImageView) objArr[6], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[2]);
        this.mDirtyFlags = -1L;
        this.cbSharer.setTag(null);
        this.ivAvatar.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.tvEmail.setTag(null);
        this.tvIdentifier.setTag(null);
        this.tvName.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
