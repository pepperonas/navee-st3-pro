package com.uz.navee.utils;

import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import com.uz.navee.MyApplication;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class g0 {
    public static Object a(String str, Object obj) {
        if (obj instanceof String) {
            return c().getString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(c().getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(c().getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(c().getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(c().getLong(str, ((Long) obj).longValue()));
        }
        return null;
    }

    public static Map b() {
        return c().getAll();
    }

    public static SharedPreferences c() {
        return PreferenceManager.getDefaultSharedPreferences(MyApplication.b());
    }

    public static String d(String str) {
        return c().getString(str, null);
    }

    public static String e(String str, String str2) {
        return c().getString(str, str2);
    }

    public static void f(String str, Object obj) {
        SharedPreferences.Editor editorEdit = c().edit();
        if (obj instanceof String) {
            editorEdit.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            editorEdit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            editorEdit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            editorEdit.putLong(str, ((Long) obj).longValue());
        } else {
            editorEdit.putString(str, obj == null ? "" : obj.toString());
        }
        editorEdit.apply();
    }

    public static void g(String str) {
        SharedPreferences.Editor editorEdit = c().edit();
        editorEdit.remove(str);
        editorEdit.apply();
    }
}
