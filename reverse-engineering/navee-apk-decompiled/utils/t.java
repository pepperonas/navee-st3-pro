package com.uz.navee.utils;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.uz.navee.MyApplication;

/* loaded from: classes3.dex */
public abstract class t {
    public static void a(View view) {
        InputMethodManager inputMethodManager;
        if (view == null || (inputMethodManager = (InputMethodManager) MyApplication.c().getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void b(EditText editText) {
        InputMethodManager inputMethodManager;
        if (editText == null || (inputMethodManager = (InputMethodManager) MyApplication.c().getSystemService("input_method")) == null) {
            return;
        }
        editText.clearFocus();
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public static void c(EditText editText) {
        InputMethodManager inputMethodManager;
        if (editText == null || (inputMethodManager = (InputMethodManager) MyApplication.c().getSystemService("input_method")) == null) {
            return;
        }
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        inputMethodManager.showSoftInput(editText, 0);
    }
}
