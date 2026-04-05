package cn.sharesdk.framework.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.sharesdk.framework.utils.SSDKLog;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static b f6263b;

    /* renamed from: a, reason: collision with root package name */
    private a f6264a = new a();

    private b() {
    }

    public static synchronized b a() {
        try {
            if (f6263b == null) {
                f6263b = new b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f6263b;
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        SQLiteDatabase writableDatabase = this.f6264a.getWritableDatabase();
        SSDKLog.b().a("Query table: %s", str);
        try {
            return writableDatabase.query(str, strArr, str2, strArr2, null, null, str3);
        } catch (Exception e7) {
            SSDKLog.b().b(e7, "when query database occur error table:%s,", str);
            return null;
        }
    }

    public long a(String str, ContentValues contentValues) {
        try {
            return this.f6264a.getWritableDatabase().replace(str, null, contentValues);
        } catch (Exception e7) {
            SSDKLog.b().b(e7, "when insert database occur error table:%s,", str);
            return -1L;
        }
    }

    public int a(String str, String str2, String[] strArr) {
        int iDelete;
        try {
            iDelete = this.f6264a.getWritableDatabase().delete(str, str2, strArr);
        } catch (Exception e7) {
            e = e7;
            iDelete = 0;
        }
        try {
            SSDKLog.b().a("Deleted %d rows from table: %s", Integer.valueOf(iDelete), str);
        } catch (Exception e8) {
            e = e8;
            SSDKLog.b().b(e, "when delete database occur error table:%s,", str);
            return iDelete;
        }
        return iDelete;
    }

    public int a(String str) throws Throwable {
        Exception e7;
        Cursor cursor;
        int i6 = 0;
        Cursor cursor2 = null;
        try {
            SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) this.f6264a.getClass().getMethod("getWritableDatabase", new Class[0]).invoke(this.f6264a, new Object[0]);
            cursor = (Cursor) sQLiteDatabase.getClass().getDeclaredMethod("rawQuery", String.class, String[].class).invoke(sQLiteDatabase, "select count(*) from " + str, null);
            try {
                try {
                    if (cursor.moveToNext()) {
                        i6 = cursor.getInt(0);
                    }
                } catch (Exception e8) {
                    e7 = e8;
                    SSDKLog.b().b(e7);
                    cursor.close();
                    return i6;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                cursor2.close();
                throw th;
            }
        } catch (Exception e9) {
            e7 = e9;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor2.close();
            throw th;
        }
        cursor.close();
        return i6;
    }
}
