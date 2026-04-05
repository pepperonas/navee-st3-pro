package com.uz.navee.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.uz.navee.R$id;
import com.uz.navee.ui.mine.ChangeEmailInputView;

/* loaded from: classes3.dex */
public class ActivityResetPasswordBindingImpl extends ActivityResetPasswordBinding {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private InverseBindingListener etInputEmailandroidTextAttrChanged;
    private InverseBindingListener etInputPwdandroidTextAttrChanged;
    private long mDirtyFlags;

    @NonNull
    private final ConstraintLayout mboundView0;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(ActivityResetPasswordBindingImpl.this.etInputEmail);
            ObservableField<String> observableField = ActivityResetPasswordBindingImpl.this.mInputIdStr;
            if (observableField != null) {
                observableField.set(textString);
            }
        }
    }

    public class b implements InverseBindingListener {
        public b() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(ActivityResetPasswordBindingImpl.this.etInputPwd);
            ObservableField<String> observableField = ActivityResetPasswordBindingImpl.this.mInputPswStr;
            if (observableField != null) {
                observableField.set(textString);
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R$id.include, 3);
        sparseIntArray.put(R$id.codeInputView2, 4);
        sparseIntArray.put(R$id.iv_pwd, 5);
        sparseIntArray.put(R$id.layout_agree, 6);
        sparseIntArray.put(R$id.agreeButton, 7);
        sparseIntArray.put(R$id.tv_agree, 8);
        sparseIntArray.put(R$id.btn_submit, 9);
    }

    public ActivityResetPasswordBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private boolean onChangeInputCodeStr(ObservableField<String> observableField, int i6) {
        if (i6 != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeInputIdStr(ObservableField<String> observableField, int i6) {
        if (i6 != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
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
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ObservableField<String> observableField = this.mInputPswStr;
        ObservableField<String> observableField2 = this.mInputIdStr;
        long j7 = 9 & j6;
        String str = (j7 == 0 || observableField == null) ? null : observableField.get();
        long j8 = 12 & j6;
        String str2 = (j8 == 0 || observableField2 == null) ? null : observableField2.get();
        if (j8 != 0) {
            TextViewBindingAdapter.setText(this.etInputEmail, str2);
        }
        if ((j6 & 8) != 0) {
            TextViewBindingAdapter.setTextWatcher(this.etInputEmail, null, null, null, this.etInputEmailandroidTextAttrChanged);
            TextViewBindingAdapter.setTextWatcher(this.etInputPwd, null, null, null, this.etInputPwdandroidTextAttrChanged);
        }
        if (j7 != 0) {
            TextViewBindingAdapter.setText(this.etInputPwd, str);
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
            return onChangeInputCodeStr((ObservableField) obj, i7);
        }
        if (i6 != 2) {
            return false;
        }
        return onChangeInputIdStr((ObservableField) obj, i7);
    }

    @Override // com.uz.navee.databinding.ActivityResetPasswordBinding
    public void setInputCodeStr(@Nullable ObservableField<String> observableField) {
        this.mInputCodeStr = observableField;
    }

    @Override // com.uz.navee.databinding.ActivityResetPasswordBinding
    public void setInputIdStr(@Nullable ObservableField<String> observableField) {
        updateRegistration(2, observableField);
        this.mInputIdStr = observableField;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // com.uz.navee.databinding.ActivityResetPasswordBinding
    public void setInputPswStr(@Nullable ObservableField<String> observableField) {
        updateRegistration(0, observableField);
        this.mInputPswStr = observableField;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i6, @Nullable Object obj) {
        if (4 == i6) {
            setInputPswStr((ObservableField) obj);
        } else if (2 == i6) {
            setInputCodeStr((ObservableField) obj);
        } else {
            if (3 != i6) {
                return false;
            }
            setInputIdStr((ObservableField) obj);
        }
        return true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private ActivityResetPasswordBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        ImageButton imageButton = (ImageButton) objArr[7];
        TextView textView = (TextView) objArr[9];
        ChangeEmailInputView changeEmailInputView = (ChangeEmailInputView) objArr[4];
        EditText editText = (EditText) objArr[1];
        EditText editText2 = (EditText) objArr[2];
        Object obj = objArr[3];
        super(dataBindingComponent, view, 3, imageButton, textView, changeEmailInputView, editText, editText2, obj != null ? Toolbar2Binding.bind((View) obj) : null, (ImageView) objArr[5], (LinearLayout) objArr[6], (TextView) objArr[8]);
        this.etInputEmailandroidTextAttrChanged = new a();
        this.etInputPwdandroidTextAttrChanged = new b();
        this.mDirtyFlags = -1L;
        this.etInputEmail.setTag(null);
        this.etInputPwd.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
