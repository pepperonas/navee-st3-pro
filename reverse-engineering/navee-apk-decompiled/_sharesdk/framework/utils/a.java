package cn.sharesdk.framework.utils;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f6451a;

    /* renamed from: b, reason: collision with root package name */
    private static String f6452b;

    public static boolean a() {
        return a("MIUI");
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0053: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:84), block:B:11:0x0053 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(java.lang.String r8) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "CheckRomAll getProp finally catch "
            r1 = 0
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r4.<init>()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            java.lang.String r5 = "getprop "
            r4.append(r5)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r4.append(r8)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            java.lang.Process r3 = r3.exec(r4)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r3 = 1024(0x400, float:1.435E-42)
            r4.<init>(r5, r3)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            java.lang.String r3 = r4.readLine()     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L55
            r4.close()     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L55
            r4.close()     // Catch: java.io.IOException -> L38
            goto L51
        L38:
            r8 = move-exception
            cn.sharesdk.framework.utils.SSDKLog r2 = cn.sharesdk.framework.utils.SSDKLog.b()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            java.lang.Object[] r0 = new java.lang.Object[r1]
            r2.a(r8, r0)
        L51:
            return r3
        L52:
            r8 = move-exception
            r2 = r4
            goto L9d
        L55:
            r3 = move-exception
            goto L5b
        L57:
            r8 = move-exception
            goto L9d
        L59:
            r3 = move-exception
            r4 = r2
        L5b:
            cn.sharesdk.framework.utils.SSDKLog r5 = cn.sharesdk.framework.utils.SSDKLog.b()     // Catch: java.lang.Throwable -> L52
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
            r6.<init>()     // Catch: java.lang.Throwable -> L52
            java.lang.String r7 = "CheckRomAll unable to read prop "
            r6.append(r7)     // Catch: java.lang.Throwable -> L52
            r6.append(r8)     // Catch: java.lang.Throwable -> L52
            java.lang.String r8 = " ex "
            r6.append(r8)     // Catch: java.lang.Throwable -> L52
            r6.append(r3)     // Catch: java.lang.Throwable -> L52
            java.lang.String r8 = r6.toString()     // Catch: java.lang.Throwable -> L52
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L52
            r5.a(r8, r3)     // Catch: java.lang.Throwable -> L52
            if (r4 == 0) goto L9c
            r4.close()     // Catch: java.io.IOException -> L83
            goto L9c
        L83:
            r8 = move-exception
            cn.sharesdk.framework.utils.SSDKLog r3 = cn.sharesdk.framework.utils.SSDKLog.b()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            java.lang.Object[] r0 = new java.lang.Object[r1]
            r3.a(r8, r0)
        L9c:
            return r2
        L9d:
            if (r2 == 0) goto Lbc
            r2.close()     // Catch: java.io.IOException -> La3
            goto Lbc
        La3:
            r2 = move-exception
            cn.sharesdk.framework.utils.SSDKLog r3 = cn.sharesdk.framework.utils.SSDKLog.b()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r3.a(r0, r1)
        Lbc:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.utils.a.b(java.lang.String):java.lang.String");
    }

    public static boolean a(String str) throws Throwable {
        String str2 = f6451a;
        if (str2 != null) {
            return str2.equals(str);
        }
        String strB = b("ro.miui.ui.version.name");
        f6452b = strB;
        if (TextUtils.isEmpty(strB)) {
            String strB2 = b("ro.build.version.emui");
            f6452b = strB2;
            if (TextUtils.isEmpty(strB2)) {
                String strB3 = b("ro.build.version.opporom");
                f6452b = strB3;
                if (TextUtils.isEmpty(strB3)) {
                    String strB4 = b("ro.vivo.os.version");
                    f6452b = strB4;
                    if (TextUtils.isEmpty(strB4)) {
                        String strB5 = b("ro.smartisan.version");
                        f6452b = strB5;
                        if (TextUtils.isEmpty(strB5)) {
                            String str3 = Build.DISPLAY;
                            f6452b = str3;
                            if (str3.toUpperCase().contains("FLYME")) {
                                f6451a = "FLYME";
                            } else {
                                f6452b = EnvironmentCompat.MEDIA_UNKNOWN;
                                f6451a = Build.MANUFACTURER.toUpperCase();
                            }
                        } else {
                            f6451a = "SMARTISAN";
                        }
                    } else {
                        f6451a = "VIVO";
                    }
                } else {
                    f6451a = "OPPO";
                }
            } else {
                f6451a = "EMUI";
            }
        } else {
            f6451a = "MIUI";
        }
        return f6451a.equals(str);
    }
}
