package cn.sharesdk.framework.utils;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.utils.k;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.mob.MobSDK;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.ReflectHelper;

/* loaded from: classes2.dex */
public class i {
    public static void a() {
        k.a(new k.a() { // from class: cn.sharesdk.framework.utils.i.1
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() {
                try {
                    DH.SyncMtd.getBrand();
                } catch (Throwable unused) {
                    SSDKLog.b().a("DH F", new Object[0]);
                    Log.e(OnekeyShare.SHARESDK_TAG, "ShareSDK 3.10.7 进行了架构升级优化，为保证正常使用SDK，请确保相关架包升级到了最新版本，或者可至官网联系技术支持");
                }
            }
        });
    }

    private static int b() {
        try {
            return ((Integer) ReflectHelper.invokeStaticMethod(ReflectHelper.importClass("android.os.UserHandle"), "getUserId", new Object[]{Integer.valueOf(Process.myUid())}, new Class[]{Integer.TYPE})).intValue();
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            return 0;
        }
    }

    public static String a(String str) {
        if (str != null) {
            str = str.replace(' ', '+');
        }
        try {
            return Data.AES128Decode(ShareSDK.SDK_TAG, Base64.decode(str, 2)).trim();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static PackageInfo a(String str, int i6) {
        try {
            if (b() <= 0) {
                return null;
            }
            SSDKLog.b().b("checkUidPinfo");
            return MobSDK.getContext().getPackageManager().getPackageInfo(str, i6);
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            return null;
        }
    }

    public static void a(View view) {
        try {
            if (Build.VERSION.SDK_INT >= 35) {
                view.setFitsSystemWindows(true);
            }
        } catch (Throwable th) {
            SSDKLog.b().a(th);
        }
    }
}
