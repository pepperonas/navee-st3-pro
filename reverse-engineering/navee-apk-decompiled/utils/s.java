package com.uz.navee.utils;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import androidx.media3.common.MimeTypes;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13290a = Environment.DIRECTORY_PICTURES;

    public static final void a(Uri uri, Context context, ContentResolver contentResolver, File file) {
        ContentValues contentValues = new ContentValues();
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("is_pending", (Integer) 0);
            contentResolver.update(uri, contentValues, null, null);
        } else {
            if (file != null) {
                contentValues.put("_size", Long.valueOf(file.length()));
            }
            contentResolver.update(uri, contentValues, null, null);
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", uri));
        }
    }

    public static final Bitmap.CompressFormat b(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.y.e(lowerCase, "toLowerCase(...)");
        return kotlin.text.s.o(lowerCase, ".png", false, 2, null) ? Bitmap.CompressFormat.PNG : (kotlin.text.s.o(lowerCase, ".jpg", false, 2, null) || kotlin.text.s.o(lowerCase, ".jpeg", false, 2, null)) ? Bitmap.CompressFormat.JPEG : kotlin.text.s.o(lowerCase, ".webp", false, 2, null) ? Build.VERSION.SDK_INT >= 30 ? Bitmap.CompressFormat.WEBP_LOSSLESS : Bitmap.CompressFormat.WEBP : Bitmap.CompressFormat.PNG;
    }

    public static final String c(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.y.e(lowerCase, "toLowerCase(...)");
        if (kotlin.text.s.o(lowerCase, ".png", false, 2, null)) {
            return MimeTypes.IMAGE_PNG;
        }
        if (kotlin.text.s.o(lowerCase, ".jpg", false, 2, null) || kotlin.text.s.o(lowerCase, ".jpeg", false, 2, null)) {
            return MimeTypes.IMAGE_JPEG;
        }
        if (kotlin.text.s.o(lowerCase, ".webp", false, 2, null)) {
            return MimeTypes.IMAGE_WEBP;
        }
        if (kotlin.text.s.o(lowerCase, ".gif", false, 2, null)) {
            return "image/gif";
        }
        return null;
    }

    public static final Uri d(ContentResolver contentResolver, String str, String str2, d0 d0Var) throws IOException {
        Uri EXTERNAL_CONTENT_URI;
        String str3;
        ContentValues contentValues = new ContentValues();
        String strC = c(str);
        if (strC != null) {
            contentValues.put("mime_type", strC);
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        contentValues.put("date_added", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("date_modified", Long.valueOf(jCurrentTimeMillis));
        int i6 = 1;
        if (Build.VERSION.SDK_INT >= 29) {
            if (str2 != null) {
                str3 = f13290a + RemoteSettings.FORWARD_SLASH_STRING + str2;
            } else {
                str3 = f13290a;
            }
            contentValues.put("_display_name", str);
            contentValues.put("relative_path", str3);
            contentValues.put("is_pending", (Integer) 1);
            EXTERNAL_CONTENT_URI = MediaStore.Images.Media.getContentUri("external_primary");
            kotlin.jvm.internal.y.e(EXTERNAL_CONTENT_URI, "getContentUri(...)");
        } else {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(f13290a);
            if (str2 != null) {
                externalStoragePublicDirectory = new File(externalStoragePublicDirectory, str2);
            }
            if (!externalStoragePublicDirectory.exists() && !externalStoragePublicDirectory.mkdirs()) {
                Log.e("ImageExt", "save: error: can't create Pictures directory");
                return null;
            }
            File file = new File(externalStoragePublicDirectory, str);
            String strE = kotlin.io.h.e(file);
            String strD = kotlin.io.h.d(file);
            String absolutePath = file.getAbsolutePath();
            kotlin.jvm.internal.y.e(absolutePath, "getAbsolutePath(...)");
            Uri uriF = f(contentResolver, absolutePath);
            while (uriF != null) {
                int i7 = i6 + 1;
                File file2 = new File(externalStoragePublicDirectory, strE + "(" + i6 + ")." + strD);
                String absolutePath2 = file2.getAbsolutePath();
                kotlin.jvm.internal.y.e(absolutePath2, "getAbsolutePath(...)");
                Uri uriF2 = f(contentResolver, absolutePath2);
                i6 = i7;
                file = file2;
                uriF = uriF2;
            }
            contentValues.put("_display_name", file.getName());
            String absolutePath3 = file.getAbsolutePath();
            Log.v("ImageExt", "save file: " + absolutePath3);
            contentValues.put("_data", absolutePath3);
            if (d0Var != null) {
                d0Var.b(file);
            }
            EXTERNAL_CONTENT_URI = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            kotlin.jvm.internal.y.e(EXTERNAL_CONTENT_URI, "EXTERNAL_CONTENT_URI");
        }
        return contentResolver.insert(EXTERNAL_CONTENT_URI, contentValues);
    }

    public static final OutputStream e(Uri uri, ContentResolver contentResolver) {
        try {
            return contentResolver.openOutputStream(uri);
        } catch (FileNotFoundException e7) {
            Log.e("ImageExt", "save: open stream error: " + e7);
            return null;
        }
    }

    public static final Uri f(ContentResolver contentResolver, String str) throws IOException {
        if (Build.VERSION.SDK_INT >= 29) {
            return null;
        }
        File file = new File(str);
        if (file.canRead() && file.exists()) {
            Log.v("ImageExt", "query: path: " + str + " exists");
            return Uri.fromFile(file);
        }
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor cursorQuery = contentResolver.query(uri, new String[]{"_id", "_data"}, "_data == ?", new String[]{str}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToNext()) {
                    Uri uriWithAppendedId = ContentUris.withAppendedId(uri, cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id")));
                    kotlin.jvm.internal.y.e(uriWithAppendedId, "withAppendedId(...)");
                    Log.v("ImageExt", "query: path: " + str + " exists uri: " + uriWithAppendedId);
                    kotlin.io.a.a(cursorQuery, null);
                    return uriWithAppendedId;
                }
                kotlin.u uVar = kotlin.u.f15726a;
                kotlin.io.a.a(cursorQuery, null);
            } finally {
            }
        }
        return null;
    }

    public static final Uri g(Bitmap bitmap, Context context, String fileName, String str, int i6) throws IOException {
        kotlin.jvm.internal.y.f(bitmap, "<this>");
        kotlin.jvm.internal.y.f(context, "context");
        kotlin.jvm.internal.y.f(fileName, "fileName");
        ContentResolver contentResolver = context.getContentResolver();
        d0 d0Var = new d0(null, 1, null);
        kotlin.jvm.internal.y.c(contentResolver);
        Uri uriD = d(contentResolver, fileName, str, d0Var);
        if (uriD == null) {
            Log.w("ImageExt", "insert: error: uri == null");
            return null;
        }
        OutputStream outputStreamE = e(uriD, contentResolver);
        if (outputStreamE == null) {
            return null;
        }
        try {
            bitmap.compress(b(fileName), i6, outputStreamE);
            a(uriD, context, contentResolver, d0Var.a());
            kotlin.u uVar = kotlin.u.f15726a;
            kotlin.io.a.a(outputStreamE, null);
            return uriD;
        } finally {
        }
    }

    public static /* synthetic */ Uri h(Bitmap bitmap, Context context, String str, String str2, int i6, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            str2 = null;
        }
        if ((i7 & 8) != 0) {
            i6 = 75;
        }
        return g(bitmap, context, str, str2, i6);
    }
}
