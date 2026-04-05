package com.uz.navee.utils;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.uz.navee.utils.gson.DateAdapter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static Gson f13288a;

    public static class a implements ParameterizedType {

        /* renamed from: a, reason: collision with root package name */
        public Class f13289a;

        public a(Class cls) {
            this.f13289a = cls;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return new Type[]{this.f13289a};
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return null;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return List.class;
        }
    }

    public static Object a(String str, Class cls) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return b().fromJson(str, cls);
    }

    public static Gson b() {
        if (f13288a == null) {
            synchronized (q.class) {
                try {
                    if (f13288a == null) {
                        f13288a = new GsonBuilder().disableHtmlEscaping().setDateFormat("yyyy-MM-dd HH:mm:ss").registerTypeAdapter(Date.class, new DateAdapter()).create();
                    }
                } finally {
                }
            }
        }
        return f13288a;
    }

    public static List c(String str, Class cls) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (List) b().fromJson(str, new a(cls));
    }

    public static String d(Object obj) {
        return obj == null ? "" : b().toJson(obj);
    }
}
