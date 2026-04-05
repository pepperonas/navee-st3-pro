package com.uz.navee.databinding;

import android.content.res.Resources;
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
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundLinearLayout;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$string;
import com.uz.navee.ui.mine.ChangeEmailInputView;

/* loaded from: classes3.dex */
public class ActivityRegisterBindingImpl extends ActivityRegisterBinding {

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
            String textString = TextViewBindingAdapter.getTextString(ActivityRegisterBindingImpl.this.etInputEmail);
            ObservableField<String> observableField = ActivityRegisterBindingImpl.this.mInputIdStr;
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
            String textString = TextViewBindingAdapter.getTextString(ActivityRegisterBindingImpl.this.etInputPwd);
            ObservableField<String> observableField = ActivityRegisterBindingImpl.this.mInputPswStr;
            if (observableField != null) {
                observableField.set(textString);
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R$id.include, 6);
        sparseIntArray.put(R$id.layout_top, 7);
        sparseIntArray.put(R$id.iv_pwd, 8);
        sparseIntArray.put(R$id.layout_agree, 9);
        sparseIntArray.put(R$id.agreeButton, 10);
        sparseIntArray.put(R$id.tv_agree, 11);
        sparseIntArray.put(R$id.btn_submit, 12);
        sparseIntArray.put(R$id.layout_other, 13);
        sparseIntArray.put(R$id.facebookButton, 14);
        sparseIntArray.put(R$id.googleButton, 15);
    }

    public ActivityRegisterBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private boolean onChangeInputCodeStr(ObservableField<String> observableField, int i6) {
        if (i6 != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
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
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeSignTypeEmail(ObservableBoolean observableBoolean, int i6) {
        if (i6 != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() throws Resources.NotFoundException {
        long j6;
        int i6;
        int colorFromResource;
        String string;
        Resources resources;
        int i7;
        TextView textView;
        int i8;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ObservableBoolean observableBoolean = this.mSignTypeEmail;
        ObservableField<String> observableField = this.mInputIdStr;
        ObservableField<String> observableField2 = this.mInputPswStr;
        long j7 = j6 & 18;
        if (j7 != 0) {
            boolean z6 = observableBoolean != null ? observableBoolean.get() : false;
            if (j7 != 0) {
                j6 |= z6 ? 4416L : 2208L;
            }
            int colorFromResource2 = ViewDataBinding.getColorFromResource(this.tvSignWithEmail, z6 ? R$color.xFAF4E8 : R$color.xFAF4E8_50);
            i = z6 ? 0 : 8;
            boolean z7 = !z6;
            if (z6) {
                resources = this.etInputEmail.getResources();
                i7 = R$string.email_placeholder;
            } else {
                resources = this.etInputEmail.getResources();
                i7 = R$string.account_placeholder;
            }
            string = resources.getString(i7);
            if ((j6 & 18) != 0) {
                j6 |= z7 ? 1024L : 512L;
            }
            if (z7) {
                textView = this.tvSignWithAc;
                i8 = R$color.xFAF4E8;
            } else {
                textView = this.tvSignWithAc;
                i8 = R$color.xFAF4E8_50;
            }
            colorFromResource = ViewDataBinding.getColorFromResource(textView, i8);
            int i9 = i;
            i = colorFromResource2;
            i6 = i9;
        } else {
            i6 = 0;
            colorFromResource = 0;
            string = null;
        }
        long j8 = 20 & j6;
        String str = (j8 == 0 || observableField == null) ? null : observableField.get();
        long j9 = 24 & j6;
        String str2 = (j9 == 0 || observableField2 == null) ? null : observableField2.get();
        if ((18 & j6) != 0) {
            this.codeInputView2.setVisibility(i6);
            this.etInputEmail.setHint(string);
            this.tvSignWithAc.setTextColor(colorFromResource);
            this.tvSignWithEmail.setTextColor(i);
        }
        if (j8 != 0) {
            TextViewBindingAdapter.setText(this.etInputEmail, str);
        }
        if ((j6 & 16) != 0) {
            TextViewBindingAdapter.setTextWatcher(this.etInputEmail, null, null, null, this.etInputEmailandroidTextAttrChanged);
            TextViewBindingAdapter.setTextWatcher(this.etInputPwd, null, null, null, this.etInputPwdandroidTextAttrChanged);
        }
        if (j9 != 0) {
            TextViewBindingAdapter.setText(this.etInputPwd, str2);
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
            this.mDirtyFlags = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i6, Object obj, int i7) {
        if (i6 == 0) {
            return onChangeInputCodeStr((ObservableField) obj, i7);
        }
        if (i6 == 1) {
            return onChangeSignTypeEmail((ObservableBoolean) obj, i7);
        }
        if (i6 == 2) {
            return onChangeInputIdStr((ObservableField) obj, i7);
        }
        if (i6 != 3) {
            return false;
        }
        return onChangeInputPswStr((ObservableField) obj, i7);
    }

    @Override // com.uz.navee.databinding.ActivityRegisterBinding
    public void setInputCodeStr(@Nullable ObservableField<String> observableField) {
        this.mInputCodeStr = observableField;
    }

    @Override // com.uz.navee.databinding.ActivityRegisterBinding
    public void setInputIdStr(@Nullable ObservableField<String> observableField) {
        updateRegistration(2, observableField);
        this.mInputIdStr = observableField;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // com.uz.navee.databinding.ActivityRegisterBinding
    public void setInputPswStr(@Nullable ObservableField<String> observableField) {
        updateRegistration(3, observableField);
        this.mInputPswStr = observableField;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // com.uz.navee.databinding.ActivityRegisterBinding
    public void setSignTypeEmail(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(1, observableBoolean);
        this.mSignTypeEmail = observableBoolean;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i6, @Nullable Object obj) {
        if (2 == i6) {
            setInputCodeStr((ObservableField) obj);
        } else if (6 == i6) {
            setSignTypeEmail((ObservableBoolean) obj);
        } else if (3 == i6) {
            setInputIdStr((ObservableField) obj);
        } else {
            if (4 != i6) {
                return false;
            }
            setInputPswStr((ObservableField) obj);
        }
        return true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private ActivityRegisterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        ImageButton imageButton = (ImageButton) objArr[10];
        TextView textView = (TextView) objArr[12];
        ChangeEmailInputView changeEmailInputView = (ChangeEmailInputView) objArr[4];
        EditText editText = (EditText) objArr[3];
        EditText editText2 = (EditText) objArr[5];
        QMUIRoundLinearLayout qMUIRoundLinearLayout = (QMUIRoundLinearLayout) objArr[14];
        QMUIRoundLinearLayout qMUIRoundLinearLayout2 = (QMUIRoundLinearLayout) objArr[15];
        Object obj = objArr[6];
        super(dataBindingComponent, view, 4, imageButton, textView, changeEmailInputView, editText, editText2, qMUIRoundLinearLayout, qMUIRoundLinearLayout2, obj != null ? Toolbar2Binding.bind((View) obj) : null, (ImageView) objArr[8], (LinearLayout) objArr[9], (LinearLayout) objArr[13], (LinearLayout) objArr[7], (TextView) objArr[11], (TextView) objArr[2], (TextView) objArr[1]);
        this.etInputEmailandroidTextAttrChanged = new a();
        this.etInputPwdandroidTextAttrChanged = new b();
        this.mDirtyFlags = -1L;
        this.codeInputView2.setTag(null);
        this.etInputEmail.setTag(null);
        this.etInputPwd.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.tvSignWithAc.setTag(null);
        this.tvSignWithEmail.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
