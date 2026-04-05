package com.uz.navee.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$id;

/* loaded from: classes3.dex */
public class ActivityMaxSpeedBindingImpl extends ActivityMaxSpeedBinding {

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
        sparseIntArray.put(R$id.included, 4);
        sparseIntArray.put(R$id.cl_seek, 5);
        sparseIntArray.put(R$id.tv_title, 6);
        sparseIntArray.put(R$id.sb_speed, 7);
        sparseIntArray.put(R$id.tv_speed_32, 8);
        sparseIntArray.put(R$id.tv_speed_40, 9);
        sparseIntArray.put(R$id.tv_speed_45, 10);
        sparseIntArray.put(R$id.tv_speed_50, 11);
        sparseIntArray.put(R$id.tv_speed_60, 12);
        sparseIntArray.put(R$id.tv_speed_70, 13);
        sparseIntArray.put(R$id.rg_speed, 14);
        sparseIntArray.put(R$id.tv_tip, 15);
    }

    public ActivityMaxSpeedBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        if ((j6 & 1) != 0) {
            this.tvSpeed25.setSelected(true);
            this.tvSpeed30.setSelected(true);
            this.tvSpeed35.setSelected(true);
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
    private ActivityMaxSpeedBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[5];
        Object obj = objArr[4];
        super(dataBindingComponent, view, 0, constraintLayout, obj != null ? ToolbarBinding.bind((View) obj) : null, (RadioGroup) objArr[14], (AppCompatSeekBar) objArr[7], (TextView) objArr[1], (TextView) objArr[2], (TextView) objArr[8], (TextView) objArr[3], (TextView) objArr[9], (TextView) objArr[10], (TextView) objArr[11], (TextView) objArr[12], (TextView) objArr[13], (TextView) objArr[15], (TextView) objArr[6]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.tvSpeed25.setTag(null);
        this.tvSpeed30.setTag(null);
        this.tvSpeed35.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
