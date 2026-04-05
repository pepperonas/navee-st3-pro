package com.uz.navee.databinding;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
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

/* loaded from: classes3.dex */
public class ActivityLoginBindingImpl extends ActivityLoginBinding {

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
            String textString = TextViewBindingAdapter.getTextString(ActivityLoginBindingImpl.this.etInputEmail);
            ObservableField<String> observableField = ActivityLoginBindingImpl.this.mInputIdStr;
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
            String textString = TextViewBindingAdapter.getTextString(ActivityLoginBindingImpl.this.etInputPwd);
            ObservableField<String> observableField = ActivityLoginBindingImpl.this.mInputPswStr;
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
        sparseIntArray.put(R$id.tipsView, 8);
        sparseIntArray.put(R$id.gl_center, 9);
        sparseIntArray.put(R$id.v_divider, 10);
        sparseIntArray.put(R$id.login_loading, 11);
        sparseIntArray.put(R$id.iv_pwd, 12);
        sparseIntArray.put(R$id.layout_agree, 13);
        sparseIntArray.put(R$id.agreeButton, 14);
        sparseIntArray.put(R$id.tv_agree, 15);
        sparseIntArray.put(R$id.btn_submit, 16);
        sparseIntArray.put(R$id.layout_other, 17);
        sparseIntArray.put(R$id.facebookButton, 18);
        sparseIntArray.put(R$id.googleButton, 19);
    }

    public ActivityLoginBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 20, sIncludes, sViewsWithIds));
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
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeSignTypeEmail(ObservableBoolean observableBoolean, int i6) {
        if (i6 != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() throws Resources.NotFoundException {
        long j6;
        int colorFromResource;
        String str;
        String string;
        Resources resources;
        int i6;
        TextView textView;
        int i7;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ObservableBoolean observableBoolean = this.mSignTypeEmail;
        ObservableField<String> observableField = this.mInputIdStr;
        ObservableField<String> observableField2 = this.mInputPswStr;
        long j7 = j6 & 9;
        int i8 = 0;
        if (j7 != 0) {
            boolean z6 = observableBoolean != null ? observableBoolean.get() : 0;
            if (j7 != 0) {
                j6 |= z6 != 0 ? 2592L : 1296L;
            }
            int colorFromResource2 = ViewDataBinding.getColorFromResource(this.tvSignWithEmail, z6 != 0 ? R$color.xFAF4E8 : R$color.xFAF4E8_50);
            int i9 = !z6;
            string = this.etInputEmail.getResources().getString(z6 != 0 ? R$string.email_placeholder : R$string.account_placeholder);
            if (z6 != 0) {
                resources = this.tvForgetPwd.getResources();
                i6 = R$string.forgot_pwd;
            } else {
                resources = this.tvForgetPwd.getResources();
                i6 = R$string.forgot_account_pwd;
            }
            String string2 = resources.getString(i6);
            if ((j6 & 9) != 0) {
                j6 |= i9 != 0 ? 128L : 64L;
            }
            if (i9 != 0) {
                textView = this.tvSignWithAc;
                i7 = R$color.xFAF4E8;
            } else {
                textView = this.tvSignWithAc;
                i7 = R$color.xFAF4E8_50;
            }
            colorFromResource = ViewDataBinding.getColorFromResource(textView, i7);
            i8 = colorFromResource2;
            str = string2;
        } else {
            colorFromResource = 0;
            str = null;
            string = null;
        }
        long j8 = 10 & j6;
        String str2 = (j8 == 0 || observableField == null) ? null : observableField.get();
        long j9 = 12 & j6;
        String str3 = (j9 == 0 || observableField2 == null) ? null : observableField2.get();
        if ((9 & j6) != 0) {
            this.etInputEmail.setHint(string);
            TextViewBindingAdapter.setText(this.tvForgetPwd, str);
            this.tvSignWithAc.setTextColor(colorFromResource);
            this.tvSignWithEmail.setTextColor(i8);
        }
        if (j8 != 0) {
            TextViewBindingAdapter.setText(this.etInputEmail, str2);
        }
        if ((j6 & 8) != 0) {
            TextViewBindingAdapter.setTextWatcher(this.etInputEmail, null, null, null, this.etInputEmailandroidTextAttrChanged);
            TextViewBindingAdapter.setTextWatcher(this.etInputPwd, null, null, null, this.etInputPwdandroidTextAttrChanged);
        }
        if (j9 != 0) {
            TextViewBindingAdapter.setText(this.etInputPwd, str3);
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
            return onChangeSignTypeEmail((ObservableBoolean) obj, i7);
        }
        if (i6 == 1) {
            return onChangeInputIdStr((ObservableField) obj, i7);
        }
        if (i6 != 2) {
            return false;
        }
        return onChangeInputPswStr((ObservableField) obj, i7);
    }

    @Override // com.uz.navee.databinding.ActivityLoginBinding
    public void setInputIdStr(@Nullable ObservableField<String> observableField) {
        updateRegistration(1, observableField);
        this.mInputIdStr = observableField;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // com.uz.navee.databinding.ActivityLoginBinding
    public void setInputPswStr(@Nullable ObservableField<String> observableField) {
        updateRegistration(2, observableField);
        this.mInputPswStr = observableField;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // com.uz.navee.databinding.ActivityLoginBinding
    public void setSignTypeEmail(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(0, observableBoolean);
        this.mSignTypeEmail = observableBoolean;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i6, @Nullable Object obj) {
        if (6 == i6) {
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
    private ActivityLoginBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        ImageButton imageButton = (ImageButton) objArr[14];
        TextView textView = (TextView) objArr[16];
        EditText editText = (EditText) objArr[3];
        EditText editText2 = (EditText) objArr[4];
        QMUIRoundLinearLayout qMUIRoundLinearLayout = (QMUIRoundLinearLayout) objArr[18];
        Guideline guideline = (Guideline) objArr[9];
        QMUIRoundLinearLayout qMUIRoundLinearLayout2 = (QMUIRoundLinearLayout) objArr[19];
        Object obj = objArr[6];
        super(dataBindingComponent, view, 3, imageButton, textView, editText, editText2, qMUIRoundLinearLayout, guideline, qMUIRoundLinearLayout2, obj != null ? Toolbar2Binding.bind((View) obj) : null, (ImageView) objArr[12], (LinearLayout) objArr[13], (LinearLayout) objArr[17], (LinearLayout) objArr[7], (ProgressBar) objArr[11], (TextView) objArr[8], (TextView) objArr[15], (TextView) objArr[5], (TextView) objArr[2], (TextView) objArr[1], (View) objArr[10]);
        this.etInputEmailandroidTextAttrChanged = new a();
        this.etInputPwdandroidTextAttrChanged = new b();
        this.mDirtyFlags = -1L;
        this.etInputEmail.setTag(null);
        this.etInputPwd.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.tvForgetPwd.setTag(null);
        this.tvSignWithAc.setTag(null);
        this.tvSignWithEmail.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
