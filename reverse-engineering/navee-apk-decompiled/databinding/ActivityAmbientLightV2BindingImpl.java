package com.uz.navee.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.uz.navee.R$id;

/* loaded from: classes3.dex */
public class ActivityAmbientLightV2BindingImpl extends ActivityAmbientLightV2Binding {

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
        sparseIntArray.put(R$id.lightSelectLayout, 2);
        sparseIntArray.put(R$id.tb_title_gear, 3);
        sparseIntArray.put(R$id.tb_gear, 4);
        sparseIntArray.put(R$id.tv_title_vp, 5);
        sparseIntArray.put(R$id.vp_ambient, 6);
        sparseIntArray.put(R$id.lightSelectForegroundView, 7);
        sparseIntArray.put(R$id.imageLayout, 8);
        sparseIntArray.put(R$id.iv_vehicle, 9);
        sparseIntArray.put(R$id.switchLayout, 10);
        sparseIntArray.put(R$id.switchTitleLabel, 11);
        sparseIntArray.put(R$id.switchSubTitleLabel, 12);
        sparseIntArray.put(R$id.accessoryView, 13);
        sparseIntArray.put(R$id.sc_switch, 14);
    }

    public ActivityAmbientLightV2BindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
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
    private ActivityAmbientLightV2BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        LinearLayout linearLayout = (LinearLayout) objArr[13];
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[8];
        Object obj = objArr[1];
        super(dataBindingComponent, view, 0, linearLayout, constraintLayout, obj != null ? ToolbarBinding.bind((View) obj) : null, (AppCompatImageView) objArr[9], (View) objArr[7], (ConstraintLayout) objArr[2], (SwitchCompat) objArr[14], (ConstraintLayout) objArr[10], (TextView) objArr[12], (TextView) objArr[11], (TabLayout) objArr[4], (TextView) objArr[3], (TextView) objArr[5], (ViewPager2) objArr[6]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout2;
        constraintLayout2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
