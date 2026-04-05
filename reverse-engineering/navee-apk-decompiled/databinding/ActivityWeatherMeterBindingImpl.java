package com.uz.navee.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$id;

/* loaded from: classes3.dex */
public class ActivityWeatherMeterBindingImpl extends ActivityWeatherMeterBinding {

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
        sparseIntArray.put(R$id.cl_switch, 2);
        sparseIntArray.put(R$id.switchCompat, 3);
        sparseIntArray.put(R$id.tv_weather_title, 4);
        sparseIntArray.put(R$id.tv_state, 5);
        sparseIntArray.put(R$id.tv_tip, 6);
    }

    public ActivityWeatherMeterBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
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
    private ActivityWeatherMeterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[2];
        Object obj = objArr[1];
        super(dataBindingComponent, view, 0, constraintLayout, obj != null ? ToolbarBinding.bind((View) obj) : null, (SwitchCompat) objArr[3], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[4]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout2;
        constraintLayout2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
