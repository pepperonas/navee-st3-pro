package com.uz.navee.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.uz.navee.R$id;
import com.uz.navee.R$string;

/* loaded from: classes3.dex */
public class ActivityAddDeviceSharerBindingImpl extends ActivityAddDeviceSharerBinding {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @NonNull
    private final ConstraintLayout mboundView0;

    @Nullable
    private final LoadingBinding mboundView01;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R$id.include, 2);
        sparseIntArray.put(R$id.ic_search, 4);
        sparseIntArray.put(R$id.rv_list, 5);
        sparseIntArray.put(R$id.btn_ok, 6);
    }

    public ActivityAddDeviceSharerBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        if ((j6 & 1) != 0) {
            this.etKeyword.setHint(this.etKeyword.getResources().getString(R$string.account_placeholder) + RemoteSettings.FORWARD_SLASH_STRING + this.etKeyword.getResources().getString(R$string.email_placeholder) + "/NAVEEID");
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
    private ActivityAddDeviceSharerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        Button button = (Button) objArr[6];
        AppCompatEditText appCompatEditText = (AppCompatEditText) objArr[1];
        AppCompatImageView appCompatImageView = (AppCompatImageView) objArr[4];
        Object obj = objArr[2];
        super(dataBindingComponent, view, 0, button, appCompatEditText, appCompatImageView, obj != null ? ToolbarBinding.bind((View) obj) : null, (RecyclerView) objArr[5]);
        this.mDirtyFlags = -1L;
        this.etKeyword.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        Object obj2 = objArr[3];
        this.mboundView01 = obj2 != null ? LoadingBinding.bind((View) obj2) : null;
        setRootTag(view);
        invalidateAll();
    }
}
