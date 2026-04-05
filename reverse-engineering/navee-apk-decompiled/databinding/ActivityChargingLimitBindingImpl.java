package com.uz.navee.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$id;

/* loaded from: classes3.dex */
public class ActivityChargingLimitBindingImpl extends ActivityChargingLimitBinding {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @NonNull
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R$id.included, 2);
        sparseIntArray.put(R$id.tv_title, 3);
        sparseIntArray.put(R$id.sb_limit, 4);
        sparseIntArray.put(R$id.tv_percent_85, 5);
        sparseIntArray.put(R$id.tv_percent_90, 6);
        sparseIntArray.put(R$id.tv_percent_95, 7);
        sparseIntArray.put(R$id.tv_percent_100, 8);
    }

    public ActivityChargingLimitBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        if ((j6 & 1) != 0) {
            this.tvPercent80.setSelected(true);
        }
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
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i6, Object obj, int i7) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i6, @Nullable Object obj) {
        return true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private ActivityChargingLimitBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        Object obj = objArr[2];
        super(dataBindingComponent, view, 0, obj != null ? ToolbarBinding.bind((View) obj) : null, (AppCompatSeekBar) objArr[4], (TextView) objArr[8], (TextView) objArr[1], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[7], (TextView) objArr[3]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.tvPercent80.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
