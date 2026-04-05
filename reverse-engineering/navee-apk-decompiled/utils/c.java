package com.uz.navee.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.uz.navee.R$id;
import com.uz.navee.R$mipmap;

/* loaded from: classes3.dex */
public abstract class c {

    public static final class a implements ActionMode.Callback {
        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    public static final void b(EditText editText) {
        kotlin.jvm.internal.y.f(editText, "<this>");
        a aVar = new a();
        editText.setCustomSelectionActionModeCallback(aVar);
        editText.setCustomInsertionActionModeCallback(aVar);
    }

    public static final Toolbar c(ComponentActivity componentActivity, String title, int i6, View.OnClickListener onClickListener) {
        kotlin.jvm.internal.y.f(componentActivity, "<this>");
        kotlin.jvm.internal.y.f(title, "title");
        TextView textView = (TextView) componentActivity.findViewById(R$id.titleView_toolbar);
        textView.setText(title);
        if (d.o()) {
            textView.setTextSize(18.0f);
        } else {
            textView.setTextSize(16.0f);
        }
        textView.setTypeface(Typeface.defaultFromStyle(1));
        return i(componentActivity, title, i6, onClickListener);
    }

    public static final Toolbar d(View view, String title, int i6, View.OnClickListener onClickListener) {
        kotlin.jvm.internal.y.f(view, "<this>");
        kotlin.jvm.internal.y.f(title, "title");
        TextView textView = (TextView) view.findViewById(R$id.titleView_toolbar);
        textView.setText(title);
        if (d.o()) {
            textView.setTextSize(18.0f);
        } else {
            textView.setTextSize(16.0f);
        }
        textView.setTextColor(i6);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        ((ImageView) view.findViewById(R$id.logo_toolbar)).setVisibility(8);
        return h(view, title, R$mipmap.ic_nav_back, onClickListener);
    }

    public static final Toolbar e(final ComponentActivity componentActivity, String title, int i6) {
        kotlin.jvm.internal.y.f(componentActivity, "<this>");
        kotlin.jvm.internal.y.f(title, "title");
        return f(componentActivity, title, i6, new View.OnClickListener() { // from class: com.uz.navee.utils.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.g(componentActivity, view);
            }
        });
    }

    public static final Toolbar f(ComponentActivity componentActivity, String title, int i6, View.OnClickListener onClickListener) {
        kotlin.jvm.internal.y.f(componentActivity, "<this>");
        kotlin.jvm.internal.y.f(title, "title");
        TextView textView = (TextView) componentActivity.findViewById(R$id.titleView_toolbar);
        textView.setText(title);
        if (d.o()) {
            textView.setTextSize(18.0f);
        } else {
            textView.setTextSize(16.0f);
        }
        textView.setTextColor(i6);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        ((ImageView) componentActivity.findViewById(R$id.logo_toolbar)).setVisibility(8);
        return i(componentActivity, title, R$mipmap.ic_nav_back, onClickListener);
    }

    public static final void g(ComponentActivity this_run, View view) {
        kotlin.jvm.internal.y.f(this_run, "$this_run");
        this_run.finish();
    }

    public static final Toolbar h(View view, String str, int i6, View.OnClickListener onClickListener) {
        android.view.Window window;
        Toolbar toolbar = (Toolbar) view.findViewById(R$id.toolbar);
        toolbar.setTitle(str);
        if (onClickListener != null) {
            toolbar.setNavigationOnClickListener(onClickListener);
            toolbar.setContentInsetsAbsolute(0, toolbar.getContentInsetStartWithNavigation());
            Drawable drawable = ContextCompat.getDrawable(view.getContext(), i6);
            Context context = view.getContext();
            View decorView = null;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null && (window = activity.getWindow()) != null) {
                decorView = window.getDecorView();
            }
            if (decorView != null && decorView.getLayoutDirection() == 1 && drawable != null) {
                drawable = d.q(drawable);
                toolbar.setContentInsetsAbsolute(toolbar.getContentInsetStartWithNavigation(), 0);
            }
            toolbar.setNavigationIcon(drawable);
        }
        kotlin.jvm.internal.y.c(toolbar);
        return toolbar;
    }

    public static final Toolbar i(ComponentActivity componentActivity, String str, int i6, View.OnClickListener onClickListener) {
        Toolbar toolbar = (Toolbar) componentActivity.findViewById(R$id.toolbar);
        toolbar.setTitle(str);
        if (onClickListener != null) {
            toolbar.setNavigationOnClickListener(onClickListener);
            toolbar.setContentInsetsAbsolute(0, toolbar.getContentInsetStartWithNavigation());
            Drawable drawable = ContextCompat.getDrawable(componentActivity, i6);
            if (componentActivity.getWindow().getDecorView().getLayoutDirection() == 1 && drawable != null) {
                drawable = d.q(drawable);
                toolbar.setContentInsetsAbsolute(toolbar.getContentInsetStartWithNavigation(), 0);
            }
            toolbar.setNavigationIcon(drawable);
        }
        kotlin.jvm.internal.y.c(toolbar);
        return toolbar;
    }
}
