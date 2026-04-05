package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.k;
import com.mob.MobSDK;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f6243a = false;

    /* renamed from: b, reason: collision with root package name */
    public static String f6244b;

    public static boolean a() {
        String appkey = MobSDK.getAppkey();
        if (f6243a || TextUtils.isEmpty(appkey)) {
            return false;
        }
        if (!TextUtils.isEmpty(f6244b)) {
            SSDKLog.b().a("CheckAppKeyDetermine whether successAppKey is equal to mobsdk.getappkey", new Object[0]);
            return appkey.equals(f6244b);
        }
        SSDKLog.b().a("CheckAppKeyAsynchronously verify the appkey", new Object[0]);
        k.a(new k.a() { // from class: cn.sharesdk.framework.a.1
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() throws Throwable {
                b.a().b();
            }
        });
        return true;
    }
}
