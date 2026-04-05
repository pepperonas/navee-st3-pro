package com.uz.navee.ui.wheel;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.media3.extractor.ts.TsExtractor;
import com.uz.navee.R$drawable;
import com.uz.navee.R$styleable;
import com.uz.navee.utils.c;
import com.uz.navee.utils.j0;
import com.uz.navee.utils.t;
import j4.d;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class GridCodeEditView extends LinearLayout implements TextWatcher, View.OnKeyListener, View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public Context f13207a;

    /* renamed from: b, reason: collision with root package name */
    public a f13208b;

    /* renamed from: c, reason: collision with root package name */
    public int f13209c;

    /* renamed from: d, reason: collision with root package name */
    public VCInputType f13210d;

    /* renamed from: e, reason: collision with root package name */
    public int f13211e;

    /* renamed from: f, reason: collision with root package name */
    public int f13212f;

    /* renamed from: g, reason: collision with root package name */
    public int f13213g;

    /* renamed from: h, reason: collision with root package name */
    public float f13214h;

    /* renamed from: i, reason: collision with root package name */
    public int f13215i;

    /* renamed from: j, reason: collision with root package name */
    public int f13216j;

    /* renamed from: k, reason: collision with root package name */
    public int f13217k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f13218l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f13219m;

    /* renamed from: n, reason: collision with root package name */
    public int f13220n;

    /* renamed from: o, reason: collision with root package name */
    public int f13221o;

    public enum VCInputType {
        NUMBER,
        NUMBERPASSWORD,
        TEXT,
        TEXTPASSWORD
    }

    public interface a {
        void d(View view, String str);

        void k(View view, String str);
    }

    public GridCodeEditView(Context context, @Nullable AttributeSet attributeSet) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super(context, attributeSet);
        this.f13207a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.GridCodeEditView);
        this.f13209c = typedArrayObtainStyledAttributes.getInteger(R$styleable.GridCodeEditView_grid_code_et_number, 4);
        this.f13210d = VCInputType.values()[typedArrayObtainStyledAttributes.getInt(R$styleable.GridCodeEditView_grid_code_et_inputType, VCInputType.NUMBER.ordinal())];
        float f7 = context.getResources().getDisplayMetrics().scaledDensity;
        this.f13211e = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.GridCodeEditView_grid_code_et_width, 120);
        this.f13212f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.GridCodeEditView_grid_code_et_height, 120);
        this.f13213g = typedArrayObtainStyledAttributes.getColor(R$styleable.GridCodeEditView_grid_code_et_text_color, ViewCompat.MEASURED_STATE_MASK);
        this.f13214h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.GridCodeEditView_grid_code_et_text_size, 48) / f7;
        this.f13215i = typedArrayObtainStyledAttributes.getResourceId(R$styleable.GridCodeEditView_grid_code_et_bg, R$drawable.grid_code_et_bg);
        this.f13220n = typedArrayObtainStyledAttributes.getResourceId(R$styleable.GridCodeEditView_grid_code_et_cursor, R$drawable.grid_code_et_cursor);
        this.f13219m = typedArrayObtainStyledAttributes.getBoolean(R$styleable.GridCodeEditView_grid_code_et_cursor_visible, true);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R$styleable.GridCodeEditView_grid_code_et_spacing);
        this.f13218l = zHasValue;
        if (zHasValue) {
            this.f13216j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.GridCodeEditView_grid_code_et_spacing, 0);
        }
        e();
        typedArrayObtainStyledAttributes.recycle();
    }

    private String getResult() {
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < this.f13209c; i6++) {
            sb.append((CharSequence) ((EditText) getChildAt(i6)).getText());
        }
        return sb.toString();
    }

    public final void a() {
        for (int i6 = this.f13209c - 1; i6 >= 0; i6--) {
            EditText editText = (EditText) getChildAt(i6);
            if (editText.getText().length() >= 1) {
                editText.setText("");
                editText.setCursorVisible(this.f13219m);
                editText.requestFocus();
                return;
            }
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable.length() != 0) {
            b();
        }
        a aVar = this.f13208b;
        if (aVar != null) {
            aVar.d(this, getResult());
            EditText editText = (EditText) getChildAt(this.f13209c - 1);
            if (editText.getText().length() > 0) {
                editText.clearFocus();
                this.f13208b.k(this, getResult());
            }
        }
    }

    public final void b() {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            EditText editText = (EditText) getChildAt(i6);
            if (editText.getText().length() < 1) {
                editText.setCursorVisible(this.f13219m);
                editText.requestFocus();
                t.c(editText);
                return;
            } else {
                if (this.f13219m) {
                    editText.setCursorVisible(editText.isFocused());
                } else {
                    editText.setCursorVisible(false);
                }
                if (i6 == childCount - 1) {
                    editText.requestFocus();
                    t.c(editText);
                }
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
    }

    public LinearLayout.LayoutParams c(int i6) {
        LinearLayout.LayoutParams layoutParams;
        if (this.f13218l) {
            int i7 = this.f13221o;
            int i8 = this.f13216j;
            int i9 = this.f13209c;
            this.f13211e = (i7 - (i8 * (i9 - 1))) / i9;
            layoutParams = new LinearLayout.LayoutParams(this.f13211e, this.f13212f);
            if (i6 < this.f13209c - 1) {
                layoutParams.rightMargin = this.f13216j;
            }
        } else {
            layoutParams = new LinearLayout.LayoutParams(this.f13211e, this.f13212f);
            int i10 = this.f13221o;
            int i11 = this.f13209c;
            int i12 = (i10 - (this.f13211e * i11)) / (i11 + 1);
            this.f13217k = i12;
            if (i6 == 0) {
                layoutParams.leftMargin = i12;
                layoutParams.rightMargin = i12 / 2;
            } else if (i6 == i11 - 1) {
                layoutParams.leftMargin = i12 / 2;
                layoutParams.rightMargin = i12;
            } else {
                layoutParams.leftMargin = i12 / 2;
                layoutParams.rightMargin = i12 / 2;
            }
        }
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public final void d(EditText editText, int i6) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        editText.setLayoutParams(c(i6));
        editText.setTextAlignment(4);
        editText.setGravity(17);
        editText.setId(i6);
        editText.setMaxEms(1);
        editText.setTextColor(this.f13213g);
        editText.setTextSize(this.f13214h);
        editText.setCursorVisible(this.f13219m);
        editText.setMaxLines(1);
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
        int iOrdinal = this.f13210d.ordinal();
        if (iOrdinal == 0) {
            editText.setInputType(2);
            editText.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
        } else if (iOrdinal == 1) {
            editText.setInputType(18);
            editText.setTransformationMethod(new d());
            editText.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
        } else if (iOrdinal == 2) {
            editText.setInputType(1);
        } else if (iOrdinal == 3) {
            editText.setInputType(TsExtractor.TS_STREAM_TYPE_AC3);
            editText.setTransformationMethod(new d());
        }
        editText.setPadding(0, 0, 0, 0);
        editText.setBackgroundResource(this.f13215i);
        setEditTextCursorDrawable(editText);
        editText.addTextChangedListener(this);
        editText.setOnKeyListener(this);
        editText.setOnFocusChangeListener(this);
        c.b(editText);
    }

    public final void e() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        for (int i6 = 0; i6 < this.f13209c; i6++) {
            EditText editText = new EditText(this.f13207a);
            d(editText, i6);
            addView(editText);
            if (i6 == 0) {
                editText.setFocusable(true);
            }
        }
    }

    public final void f() {
        for (int i6 = 0; i6 < this.f13209c; i6++) {
            ((EditText) getChildAt(i6)).setLayoutParams(c(i6));
        }
    }

    public EditText getEditText() {
        int childCount = getChildCount();
        EditText editText = null;
        for (int i6 = 0; i6 < childCount; i6++) {
            editText = (EditText) getChildAt(i6);
            if (editText.getText().length() < 1) {
                break;
            }
        }
        return editText;
    }

    public a getOnCodeFinishListener() {
        return this.f13208b;
    }

    public int getmCursorDrawable() {
        return this.f13220n;
    }

    public int getmEtHeight() {
        return this.f13212f;
    }

    public VCInputType getmEtInputType() {
        return this.f13210d;
    }

    public int getmEtNumber() {
        return this.f13209c;
    }

    public int getmEtTextBg() {
        return this.f13215i;
    }

    public int getmEtTextColor() {
        return this.f13213g;
    }

    public float getmEtTextSize() {
        return this.f13214h;
    }

    public int getmEtWidth() {
        return this.f13211e;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z6) {
        if (z6) {
            b();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i6, KeyEvent keyEvent) {
        if (i6 != 67 || keyEvent.getAction() != 0) {
            return false;
        }
        a();
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        this.f13221o = getMeasuredWidth();
        f();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
    }

    public void setEditTextCursorDrawable(EditText editText) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (this.f13219m) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(editText, Integer.valueOf(this.f13220n));
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z6) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            getChildAt(i6).setEnabled(z6);
        }
    }

    public void setOnCodeFinishListener(a aVar) {
        this.f13208b = aVar;
    }

    public void setText(String str) {
        EditText editText;
        if (str == null || str.isEmpty()) {
            return;
        }
        VCInputType vCInputType = this.f13210d;
        if ((vCInputType == VCInputType.NUMBER || vCInputType == VCInputType.NUMBERPASSWORD) && !j0.b(str)) {
            return;
        }
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            if (i6 < str.length() && (editText = (EditText) getChildAt(i6)) != null) {
                editText.setText(str.substring(i6, i6 + 1));
            }
        }
    }

    public void setmCursorDrawable(int i6) {
        this.f13220n = i6;
    }

    public void setmEtHeight(int i6) {
        this.f13212f = i6;
    }

    public void setmEtInputType(VCInputType vCInputType) {
        this.f13210d = vCInputType;
    }

    public void setmEtNumber(int i6) {
        this.f13209c = i6;
    }

    public void setmEtTextBg(int i6) {
        this.f13215i = i6;
    }

    public void setmEtTextColor(int i6) {
        this.f13213g = i6;
    }

    public void setmEtTextSize(float f7) {
        this.f13214h = f7;
    }

    public void setmEtWidth(int i6) {
        this.f13211e = i6;
    }
}
