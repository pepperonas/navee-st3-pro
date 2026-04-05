package cn.sharesdk.framework.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.media3.exoplayer.ExoPlayer;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.a.b.e;
import cn.sharesdk.framework.a.b.g;
import cn.sharesdk.framework.a.b.j;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.f;
import com.mob.MobSDK;
import com.mob.commons.CSCenter;
import com.mob.commons.SHARESDK;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.FileLocker;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/* loaded from: classes2.dex */
public class d extends f {

    /* renamed from: b, reason: collision with root package name */
    private static d f6330b;

    /* renamed from: d, reason: collision with root package name */
    private Handler f6332d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6333e;

    /* renamed from: f, reason: collision with root package name */
    private long f6334f;

    /* renamed from: g, reason: collision with root package name */
    private File f6335g;

    /* renamed from: c, reason: collision with root package name */
    private a f6331c = a.a();

    /* renamed from: h, reason: collision with root package name */
    private FileLocker f6336h = new FileLocker();

    private d() throws IOException {
        File file = new File(MobSDK.getContext().getFilesDir(), ".statistics");
        this.f6335g = file;
        if (file.exists()) {
            return;
        }
        try {
            this.f6335g.createNewFile();
        } catch (Exception e7) {
            SSDKLog.b().a(e7);
        }
    }

    public static synchronized d a() {
        try {
            if (f6330b == null) {
                f6330b = new d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f6330b;
    }

    public void b(e eVar) {
        try {
            if (MobSDK.isMob() && this.f6333e) {
                a(eVar, new ShareSDKCallback<e>() { // from class: cn.sharesdk.framework.a.d.4
                    @Override // cn.sharesdk.framework.ShareSDKCallback
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onCallback(e eVar2) {
                        if (!eVar2.g()) {
                            SSDKLog.b().a("Drop event: " + eVar2.toString(), new Object[0]);
                            return;
                        }
                        Message message = new Message();
                        message.what = 3;
                        message.obj = eVar2;
                        try {
                            ((f) d.this).f6468a.sendMessage(message);
                        } catch (Throwable th) {
                            SSDKLog.b().a(th);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            SSDKLog.b().a("logStart " + th, new Object[0]);
        }
    }

    @Override // cn.sharesdk.framework.utils.f
    public void c(Message message) {
        if (this.f6333e) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f6334f;
            g gVar = new g();
            gVar.f6299a = jCurrentTimeMillis;
            a(gVar);
            this.f6333e = false;
            try {
                this.f6332d.sendEmptyMessage(1);
            } catch (Throwable th) {
                SSDKLog.b().a(th);
            }
            f6330b = null;
            this.f6468a.getLooper().quit();
        }
    }

    public void a(Handler handler) {
        this.f6332d = handler;
    }

    @Override // cn.sharesdk.framework.utils.f
    public void a(Message message) {
        if (this.f6333e) {
            return;
        }
        this.f6333e = true;
        try {
            this.f6336h.setLockFile(this.f6335g.getAbsolutePath());
            if (this.f6336h.lock(false)) {
                new Thread(new Runnable() { // from class: cn.sharesdk.framework.a.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            d.this.f6331c.a(DeviceAuthorizer.authorize(new SHARESDK()));
                        } catch (Exception e7) {
                            SSDKLog.b().a(e7);
                        }
                    }
                }).start();
                this.f6331c.a(new ShareSDKCallback<Boolean>() { // from class: cn.sharesdk.framework.a.d.2
                    @Override // cn.sharesdk.framework.ShareSDKCallback
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onCallback(Boolean bool) {
                        if (bool == null || !bool.booleanValue()) {
                            return;
                        }
                        d.this.f6331c.a(((f) d.this).f6468a);
                    }
                });
            }
        } catch (Throwable th) {
            SSDKLog.b().a(th);
        }
    }

    @Override // cn.sharesdk.framework.utils.f
    public void b(Message message) {
        int i6 = message.what;
        if (i6 == 2) {
            try {
                DH.requester(MobSDK.getContext()).getNetworkType().request(new DH.DHResponder() { // from class: cn.sharesdk.framework.a.d.6
                    @Override // com.mob.tools.utils.DH.DHResponder
                    public void onResponse(DH.DHResponse dHResponse) {
                        String networkType = dHResponse.getNetworkType();
                        if ("none".equals(networkType) || TextUtils.isEmpty(networkType)) {
                            return;
                        }
                        d.this.f6331c.b();
                    }
                });
                return;
            } catch (Throwable th) {
                SSDKLog.b().a(th);
                return;
            }
        }
        if (i6 == 3) {
            Object obj = message.obj;
            if (obj != null) {
                c((e) obj);
                this.f6468a.removeMessages(2);
                this.f6468a.sendEmptyMessageDelayed(2, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                return;
            }
            return;
        }
        if (i6 != 4) {
            return;
        }
        long jLongValue = cn.sharesdk.framework.a.a.e.a().h().longValue();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(jLongValue);
        int i7 = calendar.get(1);
        int i8 = calendar.get(2);
        int i9 = calendar.get(5);
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i10 = calendar.get(1);
        int i11 = calendar.get(2);
        int i12 = calendar.get(5);
        if (i7 == i10 && i8 == i11 && i9 == i12) {
            return;
        }
        this.f6331c.a(this.f6468a);
    }

    private void c(e eVar) {
        try {
            try {
                boolean zB = b();
                if ((eVar instanceof j) || (eVar instanceof cn.sharesdk.framework.a.b.d)) {
                    if (!zB) {
                        SSDKLog.b().b("SH AU LOG FALSE");
                        return;
                    }
                }
            } catch (Throwable th) {
                SSDKLog.b().a(th);
            }
            this.f6331c.a(eVar);
            eVar.h();
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
            SSDKLog.b().a(eVar.toString(), new Object[0]);
        }
    }

    public void a(final e eVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new Thread() { // from class: cn.sharesdk.framework.a.d.3
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    d.this.b(eVar);
                }
            }.start();
        } else {
            b(eVar);
        }
    }

    private void a(final e eVar, final ShareSDKCallback<e> shareSDKCallback) {
        DH.requester(MobSDK.getContext()).getDeviceData().getDetailNetworkTypeForStatic().request(new DH.DHResponder() { // from class: cn.sharesdk.framework.a.d.5
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    eVar.f6283f = DeviceAuthorizer.authorize(new SHARESDK());
                    eVar.f6284g = DH.SyncMtd.getPackageName();
                    eVar.f6285h = DH.SyncMtd.getAppVersion();
                    eVar.f6286i = String.valueOf(ShareSDK.SDK_VERSION_CODE);
                    eVar.f6287j = DH.SyncMtd.getPlatformCode();
                    eVar.f6288k = dHResponse.getDetailNetworkTypeForStatic();
                    if (TextUtils.isEmpty(MobSDK.getAppkey())) {
                        SSDKLog.b().b("ShareSDKCore", "Your appKey of ShareSDK is null , this will cause its data won't be count!");
                    } else if (!"cn.sharesdk.demo".equals(eVar.f6284g) && ("api20".equals(MobSDK.getAppkey()) || "androidv1101".equals(MobSDK.getAppkey()))) {
                        SSDKLog.b().b("ShareSDKCore", "Your app is using the appkey of ShareSDK Demo, this will cause its data won't be count!");
                    }
                    eVar.f6289l = dHResponse.getDeviceData();
                    shareSDKCallback.onCallback(eVar);
                } catch (Throwable th) {
                    SSDKLog.b().a(th);
                }
            }
        });
    }

    private boolean b() {
        try {
            boolean zIsSocietyPlatformDataEnable = CSCenter.getInstance().isSocietyPlatformDataEnable();
            SSDKLog.b().a("platformDataEnable:" + zIsSocietyPlatformDataEnable, new Object[0]);
            return zIsSocietyPlatformDataEnable;
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            return true;
        }
    }
}
