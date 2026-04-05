package com.uz.navee.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$id;

/* loaded from: classes3.dex */
public class ActivitySoundEffectBindingImpl extends ActivitySoundEffectBinding {

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
        sparseIntArray.put(R$id.sc_volume, 2);
        sparseIntArray.put(R$id.layer_volume_setting, 3);
        sparseIntArray.put(R$id.tv_volume_setting, 4);
        sparseIntArray.put(R$id.tv_unit, 5);
        sparseIntArray.put(R$id.tv_volume, 6);
        sparseIntArray.put(R$id.iv_volume, 7);
        sparseIntArray.put(R$id.sb_volume, 8);
        sparseIntArray.put(R$id.tv_title_language, 9);
        sparseIntArray.put(R$id.rg_language, 10);
        sparseIntArray.put(R$id.rb_chinese, 11);
        sparseIntArray.put(R$id.rb_english, 12);
        sparseIntArray.put(R$id.group_setting, 13);
    }

    public ActivitySoundEffectBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
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
    private ActivitySoundEffectBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        Group group = (Group) objArr[13];
        Object obj = objArr[1];
        super(dataBindingComponent, view, 0, group, obj != null ? ToolbarBinding.bind((View) obj) : null, (AppCompatImageView) objArr[7], (Layer) objArr[3], (RadioButton) objArr[11], (RadioButton) objArr[12], (RadioGroup) objArr[10], (AppCompatSeekBar) objArr[8], (SwitchCompat) objArr[2], (TextView) objArr[9], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[4]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
