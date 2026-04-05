package com.uz.navee.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$id;

/* loaded from: classes3.dex */
public class ActivityResetAcPswBindingImpl extends ActivityResetAcPswBinding {

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
        sparseIntArray.put(R$id.tv_title, 2);
        sparseIntArray.put(R$id.tv_content, 3);
    }

    public ActivityResetAcPswBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private boolean onChangeInputCodeStr(ObservableField<String> observableField, int i6) {
        if (i6 != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeInputIdStr(ObservableField<String> observableField, int i6) {
        if (i6 != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeInputPswStr(ObservableField<String> observableField, int i6) {
        if (i6 != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
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
            this.mDirtyFlags = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i6, Object obj, int i7) {
        if (i6 == 0) {
            return onChangeInputPswStr((ObservableField) obj, i7);
        }
        if (i6 == 1) {
            return onChangeInputIdStr((ObservableField) obj, i7);
        }
        if (i6 != 2) {
            return false;
        }
        return onChangeInputCodeStr((ObservableField) obj, i7);
    }

    @Override // com.uz.navee.databinding.ActivityResetAcPswBinding
    public void setInputCodeStr(@Nullable ObservableField<String> observableField) {
        this.mInputCodeStr = observableField;
    }

    @Override // com.uz.navee.databinding.ActivityResetAcPswBinding
    public void setInputIdStr(@Nullable ObservableField<String> observableField) {
        this.mInputIdStr = observableField;
    }

    @Override // com.uz.navee.databinding.ActivityResetAcPswBinding
    public void setInputPswStr(@Nullable ObservableField<String> observableField) {
        this.mInputPswStr = observableField;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i6, @Nullable Object obj) {
        if (4 == i6) {
            setInputPswStr((ObservableField) obj);
        } else if (3 == i6) {
            setInputIdStr((ObservableField) obj);
        } else {
            if (2 != i6) {
                return false;
            }
            setInputCodeStr((ObservableField) obj);
        }
        return true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private ActivityResetAcPswBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        Object obj = objArr[1];
        super(dataBindingComponent, view, 3, obj != null ? Toolbar2Binding.bind((View) obj) : null, (TextView) objArr[3], (TextView) objArr[2]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
