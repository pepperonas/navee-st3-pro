package com.uz.navee.base;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.extractor.ts.TsExtractor;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.uz.navee.R$id;
import com.uz.navee.R$mipmap;
import com.uz.navee.ui.device.CheckCodePopup;
import com.uz.navee.utils.n;
import e3.a;

/* loaded from: classes3.dex */
public class BaseActivity extends AppCompatActivity {

    /* renamed from: a, reason: collision with root package name */
    public ConstraintLayout f11593a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11594b;

    public static void F(EditText editText, boolean z6) {
        if (editText != null) {
            int selectionEnd = editText.getSelectionEnd();
            int length = editText.getText().toString().length();
            editText.setInputType(z6 ? 145 : TsExtractor.TS_STREAM_TYPE_AC3);
            editText.setSelection(Math.min(selectionEnd, length));
        }
    }

    public boolean A(int[] iArr) {
        for (int i6 : iArr) {
            if (i6 == -1) {
                return false;
            }
        }
        return true;
    }

    public void B() {
        ConstraintLayout constraintLayout = this.f11593a;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
    }

    public void C() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    public int D(int i6) {
        if (Build.VERSION.SDK_INT <= 23) {
            return 0;
        }
        int iCheckSelfPermission = checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") + checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION");
        if (iCheckSelfPermission != 0) {
            requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, i6);
        }
        return iCheckSelfPermission;
    }

    public void E() {
    }

    public void G(boolean z6, boolean z7) {
        View decorView = getWindow().getDecorView();
        int i6 = z7 ? 8192 : 256;
        if (z6) {
            i6 |= 1024;
        }
        decorView.setSystemUiVisibility(i6);
    }

    public void H(CheckCodePopup.b bVar) {
        a.C0192a c0192a = new a.C0192a(this);
        Boolean bool = Boolean.TRUE;
        c0192a.c(bool).b(true).j(bool).f(false).a(new CheckCodePopup(this, bVar)).G();
    }

    public void I(String str) {
        L(str, 3);
    }

    public void J(String str) {
        L(str, 4);
    }

    public void K() {
        ConstraintLayout constraintLayout = this.f11593a;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
    }

    public final void L(String str, int i6) {
        final QMUITipDialog qMUITipDialogA = new QMUITipDialog.a(this).f(i6).g(str).a();
        qMUITipDialogA.show();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.uz.navee.base.f
            @Override // java.lang.Runnable
            public final void run() {
                qMUITipDialogA.dismiss();
            }
        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    public void M(String str) {
        L(str, 2);
    }

    public void N(io.reactivex.rxjava3.disposables.c cVar) {
        if (cVar == null || cVar.isDisposed()) {
            return;
        }
        cVar.dispose();
    }

    public void O() {
        P(200);
    }

    public void P(int i6) {
        if (Build.VERSION.SDK_INT >= 31) {
            a.a(getSystemService("vibrator_manager")).getDefaultVibrator().vibrate(VibrationEffect.createWaveform(new long[]{0, i6, 0}, -1));
            return;
        }
        Vibrator vibrator = (Vibrator) getSystemService("vibrator");
        if (vibrator.hasVibrator()) {
            long j6 = i6;
            vibrator.vibrate(new long[]{j6, j6}, -1);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.uz.navee.e.c().e(this);
        setRequestedOrientation(1);
        getWindow().setBackgroundDrawable(ContextCompat.getDrawable(this, R$mipmap.bg_base));
        getWindow().setSoftInputMode(34);
        this.f11594b = false;
        G(false, false);
        w();
        View decorView = getWindow().getDecorView();
        if (com.uz.navee.utils.d.e().startsWith("ar")) {
            decorView.setLayoutDirection(1);
            decorView.setTextDirection(4);
        } else {
            decorView.setLayoutDirection(0);
            decorView.setTextDirection(3);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.uz.navee.e.c().d(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.f11594b) {
            this.f11593a = (ConstraintLayout) findViewById(R$id.loading);
            n.b(z(), y(), x());
            this.f11594b = true;
        }
        B();
    }

    public void traverseViews(View view) {
        if (view == null) {
            return;
        }
        if (view instanceof EditText) {
            EditText editText = (EditText) view;
            editText.setTextDirection(3);
            if (getWindow().getDecorView().getLayoutDirection() == 1) {
                editText.setGravity(8388629);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
                traverseViews(viewGroup.getChildAt(i6));
            }
        }
    }

    public final void w() {
        getWindow().getDecorView().setImportantForAutofill(8);
    }

    public boolean x() {
        return true;
    }

    public boolean y() {
        return true;
    }

    public View z() {
        return getWindow().getDecorView();
    }
}
