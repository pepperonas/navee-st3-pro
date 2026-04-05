package cn.sharesdk.framework.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import cn.sharesdk.framework.utils.SSDKLog;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class d {
    public static synchronized long a(String str, long j6) {
        if (str != null) {
            if (str.trim() != "") {
                b bVarA = b.a();
                ContentValues contentValues = new ContentValues();
                contentValues.put("post_time", Long.valueOf(j6));
                contentValues.put("message_data", str);
                return bVarA.a("message", contentValues);
            }
        }
        return -1L;
    }

    public static synchronized long a(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return 0L;
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                sb.append("'");
                sb.append(arrayList.get(i6));
                sb.append("'");
                sb.append(",");
            }
            String strSubstring = sb.toString().substring(0, sb.length() - 1);
            int iA = b.a().a("message", "_id in ( " + strSubstring + " )", null);
            SSDKLog.b().c("delete COUNT == %s", Integer.valueOf(iA));
            return iA;
        } catch (Throwable th) {
            throw th;
        }
    }

    private static synchronized ArrayList<c> a(String str, String[] strArr) {
        ArrayList<c> arrayList;
        try {
            arrayList = new ArrayList<>();
            c cVar = new c();
            StringBuilder sb = new StringBuilder();
            Cursor cursorA = b.a().a("message", new String[]{"_id", "post_time", "message_data"}, str, strArr, null);
            while (cursorA != null && cursorA.moveToNext()) {
                cVar.f6266b.add(cursorA.getString(0));
                if (cVar.f6266b.size() == 100) {
                    sb.append(cursorA.getString(2));
                    cVar.f6265a = sb.toString();
                    arrayList.add(cVar);
                    cVar = new c();
                    sb = new StringBuilder();
                } else {
                    sb.append(cursorA.getString(2) + "\n");
                }
            }
            cursorA.close();
            if (cVar.f6266b.size() != 0) {
                cVar.f6265a = sb.toString().substring(0, sb.length() - 1);
                arrayList.add(cVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public static synchronized ArrayList<c> a() {
        if (b.a().a("message") > 0) {
            return a((String) null, (String[]) null);
        }
        return new ArrayList<>();
    }
}
