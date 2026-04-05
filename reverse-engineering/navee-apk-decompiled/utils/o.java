package com.uz.navee.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import androidx.camera.video.AudioStats;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* loaded from: classes3.dex */
public abstract class o {
    public static void a(Context context) {
        c(context.getCacheDir());
        c(context.getFilesDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            c(context.getExternalCacheDir());
        }
    }

    public static void b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int i6 = inputStream.read(bArr);
            if (i6 == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i6);
            }
        }
    }

    public static boolean c(File file) {
        String[] list;
        if (file == null) {
            return false;
        }
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!c(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static String d(long j6) {
        double dDoubleValue = new BigDecimal((j6 / 1024.0d) / 1024.0d).setScale(2, RoundingMode.HALF_UP).doubleValue();
        if (dDoubleValue == AudioStats.AUDIO_AMPLITUDE_NONE) {
            dDoubleValue = 0.0d;
        }
        return dDoubleValue + " " + (d.n() ? "ميجابايت" : "M");
    }

    public static File e(Context context, String str, String str2, String str3) throws IOException {
        File fileCreateTempFile = null;
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            fileCreateTempFile = File.createTempFile(str2, str3, context.getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            b(inputStreamOpen, fileOutputStream);
            inputStreamOpen.close();
            fileOutputStream.close();
            return fileCreateTempFile;
        } catch (IOException unused) {
            return fileCreateTempFile;
        }
    }

    public static String f(Context context, Uri uri) {
        int iLastIndexOf;
        int columnIndex;
        String string = null;
        if (FirebaseAnalytics.Param.CONTENT.equals(uri.getScheme())) {
            Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst() && (columnIndex = cursorQuery.getColumnIndex("_display_name")) >= 0) {
                        string = cursorQuery.getString(columnIndex);
                    }
                } catch (Throwable th) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
        return (string != null || uri.getPath() == null || (iLastIndexOf = uri.getPath().lastIndexOf(47)) == -1) ? string : uri.getPath().substring(iLastIndexOf + 1);
    }

    public static long g(File file) {
        long jG = 0;
        try {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (int i6 = 0; i6 < fileArrListFiles.length; i6++) {
                    jG += fileArrListFiles[i6].isDirectory() ? g(fileArrListFiles[i6]) : fileArrListFiles[i6].length();
                }
            }
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        return jG;
    }

    public static String h(Context context) {
        long jG = g(context.getCacheDir()) + g(context.getFilesDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            jG += g(context.getExternalCacheDir());
        }
        return d(jG);
    }

    public static boolean i(Context context, Uri uri) {
        String type = context.getContentResolver().getType(uri);
        return type != null && type.startsWith("video/");
    }

    public static long j(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.length();
        }
        return 0L;
    }
}
