package com.uz.navee.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$id;

/* loaded from: classes3.dex */
public class ActivitySpeedLimitBindingImpl extends ActivitySpeedLimitBinding {

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
        sparseIntArray.put(R$id.include, 1);
        sparseIntArray.put(R$id.gl_start, 2);
        sparseIntArray.put(R$id.gl_end, 3);
        sparseIntArray.put(R$id.sc_limit, 4);
        sparseIntArray.put(R$id.tv_custom_limit, 5);
        sparseIntArray.put(R$id.tv_tip, 6);
        sparseIntArray.put(R$id.layer_limit_setting, 7);
        sparseIntArray.put(R$id.tv_limit_setting, 8);
        sparseIntArray.put(R$id.tv_unit, 9);
        sparseIntArray.put(R$id.tv_speed, 10);
        sparseIntArray.put(R$id.sb_speed, 11);
        sparseIntArray.put(R$id.tv_min, 12);
        sparseIntArray.put(R$id.tv_max, 13);
    }

    public ActivitySpeedLimitBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
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
    private ActivitySpeedLimitBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        Guideline guideline = (Guideline) objArr[3];
        Guideline guideline2 = (Guideline) objArr[2];
        Object obj = objArr[1];
        super(dataBindingComponent, view, 0, guideline, guideline2, obj != null ? ToolbarBinding.bind((View) obj) : null, (Layer) objArr[7], (AppCompatSeekBar) objArr[11], (SwitchCompat) objArr[4], (TextView) objArr[5], (TextView) objArr[8], (TextView) objArr[13], (TextView) objArr[12], (TextView) objArr[10], (TextView) objArr[6], (TextView) objArr[9]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
