package com.uz.navee.utils;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.uz.navee.MyApplication;
import com.uz.navee.R$color;
import com.uz.navee.R$drawable;
import com.uz.navee.R$mipmap;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class d {
    public static String a(String str) {
        String language = Locale.getDefault().getLanguage();
        Object objA = g0.a("is_follow_system", Boolean.TRUE);
        if (objA != null && !((Boolean) objA).booleanValue()) {
            language = g0.e("current_language", "en");
        }
        if (!language.equals("es")) {
            return str + "?";
        }
        return "¿" + str + "?";
    }

    public static void b(QMUIGroupListView qMUIGroupListView) {
        for (int i6 = 0; i6 < qMUIGroupListView.getChildCount(); i6++) {
            View childAt = qMUIGroupListView.getChildAt(i6);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.startToStart = layoutParams2.leftToLeft;
                layoutParams2.startToEnd = layoutParams2.leftToRight;
                layoutParams2.endToStart = layoutParams2.rightToLeft;
                layoutParams2.endToEnd = layoutParams2.rightToRight;
                layoutParams2.leftToLeft = -1;
                layoutParams2.leftToRight = -1;
                layoutParams2.rightToLeft = -1;
                layoutParams2.rightToRight = -1;
                layoutParams2.setMarginStart(((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin);
                layoutParams2.setMarginEnd(((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = 0;
                ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = 0;
                childAt.setLayoutParams(layoutParams2);
            } else if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMarginStart(marginLayoutParams.leftMargin);
                marginLayoutParams.setMarginEnd(marginLayoutParams.rightMargin);
                marginLayoutParams.leftMargin = 0;
                marginLayoutParams.rightMargin = 0;
                childAt.setLayoutParams(marginLayoutParams);
            }
            if (childAt instanceof ViewGroup) {
                int i7 = 0;
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) childAt;
                    if (i7 < viewGroup.getChildCount()) {
                        View childAt2 = viewGroup.getChildAt(i7);
                        ViewGroup.LayoutParams layoutParams3 = childAt2.getLayoutParams();
                        if (layoutParams3 instanceof ConstraintLayout.LayoutParams) {
                            ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
                            layoutParams4.startToStart = layoutParams4.leftToLeft;
                            layoutParams4.startToEnd = layoutParams4.leftToRight;
                            layoutParams4.endToStart = layoutParams4.rightToLeft;
                            layoutParams4.endToEnd = layoutParams4.rightToRight;
                            layoutParams4.leftToLeft = -1;
                            layoutParams4.leftToRight = -1;
                            layoutParams4.rightToLeft = -1;
                            layoutParams4.rightToRight = -1;
                            layoutParams4.setMarginStart(((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin);
                            layoutParams4.setMarginEnd(((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin);
                            ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = 0;
                            ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = 0;
                            childAt2.setLayoutParams(layoutParams4);
                        } else if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams3;
                            marginLayoutParams2.setMarginStart(marginLayoutParams2.leftMargin);
                            marginLayoutParams2.setMarginEnd(marginLayoutParams2.rightMargin);
                            marginLayoutParams2.leftMargin = 0;
                            marginLayoutParams2.rightMargin = 0;
                            childAt2.setLayoutParams(marginLayoutParams2);
                        }
                        i7++;
                    }
                }
            }
        }
    }

    public static String c() {
        try {
            return MyApplication.b().getPackageManager().getPackageInfo(r(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e7) {
            e7.printStackTrace();
            return "1.0";
        }
    }

    public static void d(Context context, String str) {
        ((ClipboardManager) context.getSystemService(ClipboardManager.class)).setPrimaryClip(ClipData.newPlainText("label", str));
    }

    public static String e() {
        String language = Locale.getDefault().getLanguage();
        Object objA = g0.a("is_follow_system", Boolean.TRUE);
        return (objA == null || ((Boolean) objA).booleanValue()) ? language : g0.e("current_language", "en");
    }

    public static String f() {
        String strE = e();
        return strE.startsWith("zh") ? "zh" : strE.startsWith("fr") ? "fr" : strE.startsWith("de") ? "de" : strE.startsWith("it") ? "it" : strE.startsWith("es") ? "es" : strE.startsWith("nl") ? "nl" : strE.startsWith("pt") ? "pt" : strE.startsWith("tr") ? "tr" : strE.startsWith("ru") ? "ru" : strE.startsWith("in") ? "in" : strE.startsWith("pl") ? "pl" : strE.startsWith("ro") ? "ro" : strE.startsWith("el") ? "el" : strE.startsWith("bj") ? "bj" : strE.startsWith("hu") ? "hu" : strE.startsWith("ar") ? "ar" : "en";
    }

    public static int g(Activity activity) {
        int i6;
        WindowManager windowManager = (WindowManager) activity.getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            i6 = point.y;
        } else {
            i6 = 0;
        }
        int iH = h(activity);
        return iH > 0 ? i6 - iH : i6;
    }

    public static int h(Activity activity) {
        int identifier = activity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
        return rootWindowInsets != null ? rootWindowInsets.getSystemWindowInsetBottom() : dimensionPixelSize;
    }

    public static Rect i(Activity activity) {
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(activity.getWindow().getDecorView());
        if (rootWindowInsets == null) {
            return new Rect(0, k(activity), 0, h(activity));
        }
        Insets insets = rootWindowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
        return new Rect(insets.left, insets.top, insets.right, insets.bottom);
    }

    public static int j(Context context) {
        return Build.VERSION.SDK_INT >= 30 ? ((WindowManager) context.getSystemService("window")).getCurrentWindowMetrics().getBounds().width() : context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int k(Activity activity) {
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return activity.getResources().getDimensionPixelSize(identifier);
        }
        WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
        if (rootWindowInsets != null) {
            return rootWindowInsets.getSystemWindowInsetTop();
        }
        return 0;
    }

    public static void l(Activity activity) {
        InputMethodManager inputMethodManager;
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null || (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    public static boolean m(Context context) {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        networkCapabilities.hasTransport(0);
        networkCapabilities.hasTransport(1);
        return true;
    }

    public static boolean n() {
        return e().startsWith("ar");
    }

    public static boolean o() {
        return e().startsWith("zh");
    }

    public static boolean p(Activity activity) {
        return activity != null && activity.getWindow().getDecorView().getLayoutDirection() == 1;
    }

    public static Drawable q(Drawable drawable) {
        if (!(drawable instanceof BitmapDrawable)) {
            return drawable;
        }
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        return new BitmapDrawable(Resources.getSystem(), Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false));
    }

    public static String r() {
        Context contextB = MyApplication.b();
        return contextB != null ? contextB.getPackageName() : "com.navee.ucaret";
    }

    public static void s(Context context, QMUICommonListItemView qMUICommonListItemView, int i6, View.OnClickListener onClickListener) {
        Drawable drawable = ContextCompat.getDrawable(context, i6);
        if (drawable != null) {
            if ((context instanceof Activity) && p((Activity) context)) {
                drawable = q(drawable);
            }
            drawable.setBounds(0, 0, 16, 16);
            ImageView imageView = new ImageView(context);
            imageView.setImageDrawable(drawable);
            if (onClickListener != null) {
                imageView.setOnClickListener(onClickListener);
            }
            qMUICommonListItemView.setAccessoryType(3);
            qMUICommonListItemView.l(imageView);
        }
    }

    public static void t(Context context, QMUICommonListItemView qMUICommonListItemView) {
        s(context, qMUICommonListItemView, R$mipmap.ic_cell_accessory_m, null);
    }

    public static void u(Context context, QMUICommonListItemView qMUICommonListItemView) {
        Drawable drawable = ContextCompat.getDrawable(context, R$drawable.bg_dfu_badge);
        if (drawable != null) {
            TextView textView = new TextView(context);
            textView.setBackground(drawable);
            textView.setText("1");
            textView.setTextSize(13.0f);
            textView.setTextAlignment(4);
            textView.setTextColor(ContextCompat.getColor(context, R$color.white));
            qMUICommonListItemView.setAccessoryType(3);
            qMUICommonListItemView.l(textView);
        }
    }

    public static void v(TextView textView, int[] iArr, float[] fArr) {
        textView.getPaint().setShader(new LinearGradient(0.0f, 0.0f, textView.getPaint().getTextSize() * textView.getText().length(), 0.0f, iArr, fArr, Shader.TileMode.CLAMP));
        textView.invalidate();
    }
}
