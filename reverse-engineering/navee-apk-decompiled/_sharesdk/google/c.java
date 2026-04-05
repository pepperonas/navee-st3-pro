package cn.sharesdk.google;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Base64;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.media3.extractor.ts.TsExtractor;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.i;
import cn.sharesdk.google.GoogleOutIinterface;
import cn.sharesdk.google.UserData;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ImagesContract;
import com.mob.MobSDK;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static IBinder f6578a;

    /* renamed from: b, reason: collision with root package name */
    public static IBinder f6579b;

    /* renamed from: c, reason: collision with root package name */
    private static final byte[][] f6580c = {Base64.decode("MIIEQzCCAyugAwIBAgIJAMLgh0ZkSjCNMA0GCSqGSIb3DQEBBAUAMHQxCzAJBgNVBAYTAlVTMRMwEQYDVQQIEwpDYWxpZm9ybmlhMRYwFAYDVQQHEw1Nb3VudGFpbiBWaWV3MRQwEgYDVQQKEwtHb29nbGUgSW5jLjEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDAeFw0wODA4MjEyMzEzMzRaFw0zNjAxMDcyMzEzMzRaMHQxCzAJBgNVBAYTAlVTMRMwEQYDVQQIEwpDYWxpZm9ybmlhMRYwFAYDVQQHEw1Nb3VudGFpbiBWaWV3MRQwEgYDVQQKEwtHb29nbGUgSW5jLjEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDCCASAwDQYJKoZIhvcNAQEBBQADggENADCCAQgCggEBAKtWLgDYO6IIrgqWbxJOKdoR8qtW0I9Y4sypEwPpt1TTcvZApxsdyxMJZ2JORland2qSGT2y5b+3JKkedxiLDmpHpDsz2WCbdxgxRczfey5YZnTJ4VZbH0xqWVW/8lGmPav5xVwnIiJS6HXk+BVKZF+JcWjAsb/GEuq/eFdpuzSqeYTcfi6idkyugwfYwXFU1+5fZKUaRKYCwkkFQVfcAs1fXA5V+++FGfvjJ/CxURaSxaBvGdGDhfXE28LWuT9ozCl5xw4Yq5OGazvV24mZVSoOO0yZ31j7kYvtwYK6NeADwbSxDdJEqO4k//0zOHKrUiGYXtqw/A0LFFtqoZKFjnkCAQOjgdkwgdYwHQYDVR0OBBYEFMd9jMIhF1Ylmn/Tgt9r45jk14alMIGmBgNVHSMEgZ4wgZuAFMd9jMIhF1Ylmn/Tgt9r45jk14aloXikdjB0MQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEUMBIGA1UEChMLR29vZ2xlIEluYy4xEDAOBgNVBAsTB0FuZHJvaWQxEDAOBgNVBAMTB0FuZHJvaWSCCQDC4IdGZEowjTAMBgNVHRMEBTADAQH/MA0GCSqGSIb3DQEBBAUAA4IBAQBt0lLO74UwLDYKqs6Tm8/yzKkEu116FmH4rkaymUIE0P9KaMftGlMexFlaYjzmB2OxZyl6euNXEsQH8gjwyxCUKRJNexBiGcCEyj6z+a1fuHHvkiaai+KL8W1EyNmgjmyy8AW7P+LLlkR+ho5zEHatRbM/YAnqGcFh5iZBqpknHf1SKMXFh4dd239FJ1jWYfbMDMy3NS5CTMQ2XFI1MvcyUTdZPErjQfTbQe3aDQsQcafEQPD+nqActifKZ0Np0IS9L9kR/wbNvyz6ENwPiTrjV2KRkEjH78ZMcUQXg0L3BYHJ3lc69Vs5Ddf9uUGGMYldX3WfMBEmh/9iFBDAaTCK", 0), Base64.decode("MIIEqDCCA5CgAwIBAgIJANWFuGx90071MA0GCSqGSIb3DQEBBAUAMIGUMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEQMA4GA1UEChMHQW5kcm9pZDEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDEiMCAGCSqGSIb3DQEJARYTYW5kcm9pZEBhbmRyb2lkLmNvbTAeFw0wODA0MTUyMzM2NTZaFw0zNTA5MDEyMzM2NTZaMIGUMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEQMA4GA1UEChMHQW5kcm9pZDEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDEiMCAGCSqGSIb3DQEJARYTYW5kcm9pZEBhbmRyb2lkLmNvbTCCASAwDQYJKoZIhvcNAQEBBQADggENADCCAQgCggEBANbOLggKv+IxTdGNs8/TGFy0PTP6DHThvbbR24kT9ixcOd9W+EaBPWW+wPPKQmsHxajtWjmQwWfna8mZuSeJS48LIgAZlKkpFeVyxW0qMBujb8X8ETrWy550NaFtI6t9+u7hZeTfHwqNvacKhp1RbE6dBRGWynwMVX8XW8N1+UjFaq6GCJukT4qmpN2afb8sCjUigq0GuMwYXrFVee74bQgLHWGJwPmvmLHC69EH6kWr22ijx4OKXlSIx2xT1AsSHee70w5iDBiK4aph27yH3TxkXy9V89TDdexAcKk/cVHYNnDBapcavl7y0RiQ4biu8ymM8Ga/nmzhRKya6G0cGw8CAQOjgfwwgfkwHQYDVR0OBBYEFI0cxb6VTEM8YYY6FbBMvAPyT+CyMIHJBgNVHSMEgcEwgb6AFI0cxb6VTEM8YYY6FbBMvAPyT+CyoYGapIGXMIGUMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEQMA4GA1UEChMHQW5kcm9pZDEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDEiMCAGCSqGSIb3DQEJARYTYW5kcm9pZEBhbmRyb2lkLmNvbYIJANWFuGx90071MAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEEBQADggEBABnTDPEF+3iSP0wNfdIjIz1AlnrPzgAIHVvXxunW7SBrDhEglQZBbKJEk5kT0mtKoOD1JMrSu1xuTKEBahWRbqHsXclaXjoBADb0kkjVEJu/Lh5hgYZnOjvlba8Ld7HCKePCVePoTJBdI4fvugnL8TsgK05aIskyY0hKI9L8KfqfGTl1lzOv2KoWD0KWwtAWPoGChZxmQ+nBli+gwYMzM1vAkP+aayLe0a1EQimlOalO762r0GXO0ks+UeXde2Z4e+8S/pf7pITEI/tP+MxJTALw9QUWEv9lKTk+jkbqxbsh8nfBUapfKqYn0eidpwq2AzVp3juYl7//fKnaPhJD9gs=", 0)};

    /* renamed from: s, reason: collision with root package name */
    private static boolean f6581s = false;

    /* renamed from: d, reason: collision with root package name */
    private String f6582d;

    /* renamed from: e, reason: collision with root package name */
    private Context f6583e;

    /* renamed from: f, reason: collision with root package name */
    private String[] f6584f;

    /* renamed from: g, reason: collision with root package name */
    private String[] f6585g;

    /* renamed from: h, reason: collision with root package name */
    private b f6586h;

    /* renamed from: i, reason: collision with root package name */
    private String[] f6587i;

    /* renamed from: k, reason: collision with root package name */
    private PlatformActionListener f6589k;

    /* renamed from: l, reason: collision with root package name */
    private Platform f6590l;

    /* renamed from: m, reason: collision with root package name */
    private PlatformDb f6591m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f6592n;

    /* renamed from: o, reason: collision with root package name */
    private ShareActivity f6593o;

    /* renamed from: j, reason: collision with root package name */
    private boolean f6588j = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f6596r = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f6594p = true;

    /* renamed from: q, reason: collision with root package name */
    private int f6595q = NetworkHelper.connectionTimeout;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Intent f6600a;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<Uri> f6601b;

        /* renamed from: c, reason: collision with root package name */
        private String f6602c;

        /* renamed from: d, reason: collision with root package name */
        private ArrayList<String> f6603d;

        /* renamed from: e, reason: collision with root package name */
        private String[] f6604e;

        /* renamed from: f, reason: collision with root package name */
        private Context f6605f;

        public a() {
            this("android.intent.action.SEND");
        }

        public a a(String[] strArr) {
            this.f6604e = strArr;
            return this;
        }

        public Intent b() {
            ArrayList<Uri> arrayList = this.f6601b;
            boolean z6 = true;
            boolean z7 = arrayList != null && arrayList.size() > 1;
            boolean zEquals = this.f6600a.getAction().equals("android.intent.action.SEND_MULTIPLE");
            boolean booleanExtra = this.f6600a.getBooleanExtra("com.google.android.apps.plus.GOOGLE_INTERACTIVE_POST", false);
            if (z7 && booleanExtra) {
                z6 = false;
            }
            c.a(z6, "Call-to-action buttons are only available for URLs.");
            if (booleanExtra && !this.f6600a.hasExtra("com.google.android.apps.plus.CONTENT_URL")) {
                throw new IllegalStateException("The content URL is required for interactive posts.");
            }
            if (!z7 && zEquals) {
                this.f6600a.setAction("android.intent.action.SEND");
                ArrayList<Uri> arrayList2 = this.f6601b;
                if (arrayList2 == null || arrayList2.isEmpty()) {
                    this.f6600a.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.f6600a.putExtra("android.intent.extra.STREAM", this.f6601b.get(0));
                }
                this.f6601b = null;
            }
            if (z7 && !zEquals) {
                this.f6600a.setAction("android.intent.action.SEND_MULTIPLE");
                ArrayList<Uri> arrayList3 = this.f6601b;
                if (arrayList3 == null || arrayList3.isEmpty()) {
                    this.f6600a.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.f6600a.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f6601b);
                }
            }
            if (booleanExtra && !this.f6600a.hasExtra("com.google.android.apps.plus.CONTENT_URL") && !this.f6600a.hasExtra("com.google.android.apps.plus.CONTENT_DEEP_LINK_ID")) {
                throw new IllegalStateException("Must set content URL or content deep-link ID to use a call-to-action button.");
            }
            this.f6600a.setPackage("com.google.android.apps.plus");
            return this.f6600a;
        }

        public a(String str) {
            this.f6600a = new Intent().setAction(str);
        }

        public c a() {
            if (this.f6602c == null) {
                this.f6602c = "<<default account>>";
            }
            ArrayList<String> arrayList = this.f6603d;
            return new c(this.f6605f, this.f6602c, this.f6603d, this.f6604e, null, (String[]) arrayList.toArray(new String[arrayList.size()]));
        }

        public a(Context context) {
            this.f6600a = new Intent().setAction("android.intent.action.SEND");
            this.f6605f = context;
            ArrayList<String> arrayList = new ArrayList<>();
            this.f6603d = arrayList;
            arrayList.add(Scopes.PLUS_LOGIN);
        }

        public a a(String str) {
            this.f6600a.setType(str);
            return this;
        }

        public a a(CharSequence charSequence) {
            this.f6600a.putExtra("android.intent.extra.TEXT", charSequence);
            return this;
        }

        public a a(Uri uri) {
            this.f6601b = null;
            this.f6600a.putExtra("android.intent.extra.STREAM", uri);
            return this;
        }
    }

    public final class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws RemoteException {
            c.f6578a = iBinder;
            boolean unused = c.f6581s = true;
            c.this.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            boolean unused = c.f6581s = false;
            c.f6578a = null;
        }
    }

    /* renamed from: cn.sharesdk.google.c$c, reason: collision with other inner class name */
    public final class BinderC0090c extends GoogleOutIinterface.a {
        public BinderC0090c() {
        }

        @Override // cn.sharesdk.google.GoogleOutIinterface
        public void Callback(int i6, IBinder iBinder, Bundle bundle) {
            c.this.f6596r = true;
            c.f6579b = iBinder;
            SSDKLog.b().a("SignCallbacks" + c.this.a(i6), new Object[0]);
            if (i6 == 0 && bundle != null && bundle.containsKey("loaded_person")) {
                if (c.this.f6592n) {
                    c.this.f();
                    c.this.f6592n = false;
                    return;
                }
                byte[] byteArray = bundle.getByteArray("loaded_person");
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.unmarshall(byteArray, 0, byteArray.length);
                parcelObtain.setDataPosition(0);
                try {
                    c.this.a(parcelObtain);
                } catch (Throwable th) {
                    SSDKLog.b().a(th);
                }
                parcelObtain.recycle();
                return;
            }
            if (i6 != 4 || !c.this.f6594p) {
                if (c.this.f6593o != null) {
                    c.this.f6593o.finish();
                }
                c cVar = c.this;
                cVar.a(cVar.a(i6), (HashMap<String, Object>) null, 3);
                return;
            }
            c.this.f6591m.put("isSigin", "false");
            try {
                c.this.a(i6, 0, (PendingIntent) bundle.getParcelable(BaseGmsClient.KEY_PENDING_INTENT));
            } catch (IntentSender.SendIntentException unused) {
                c.this.a();
            }
        }
    }

    public c(Context context, String str, ArrayList<String> arrayList, String[] strArr, String[] strArr2, String[] strArr3) {
        this.f6582d = str;
        this.f6583e = context;
        this.f6584f = strArr;
        this.f6585g = strArr3;
        this.f6587i = strArr2;
        f6579b = null;
    }

    public boolean a(int i6, PendingIntent pendingIntent) {
        return (i6 == 0 || pendingIntent == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (!b()) {
            ShareActivity shareActivity = this.f6593o;
            if (shareActivity != null) {
                shareActivity.finish();
                return;
            }
            return;
        }
        try {
            g();
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                parcelObtain.writeStrongBinder(null);
                f6579b.transact(19, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                ShareActivity shareActivity2 = this.f6593o;
                if (shareActivity2 != null) {
                    shareActivity2.finish();
                }
                parcelObtain2.recycle();
                parcelObtain.recycle();
            } catch (Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        } catch (RemoteException e7) {
            SSDKLog.b().a(e7);
        }
    }

    private void g() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            f6579b.transact(6, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public boolean c() {
        return this.f6588j;
    }

    public void d() {
        b bVar = this.f6586h;
        if (bVar != null) {
            a(bVar);
            this.f6586h = null;
            SSDKLog.b().a("google", "desConnectServer");
        }
    }

    public boolean b() {
        return this.f6586h != null && f6581s;
    }

    public void b(ShareActivity shareActivity) {
        this.f6592n = true;
        this.f6593o = shareActivity;
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(PackageInfo packageInfo, byte[][] bArr) throws CertificateException {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X509");
            if (packageInfo.signatures.length != 1) {
                SSDKLog.b().a("GooglePlayServicesUtil", "Package has more than one signature.");
                return null;
            }
            try {
                try {
                    ((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).checkValidity();
                    byte[] byteArray = packageInfo.signatures[0].toByteArray();
                    for (byte[] bArr2 : bArr) {
                        if (Arrays.equals(bArr2, byteArray)) {
                            return bArr2;
                        }
                    }
                    SSDKLog.b().a("GooglePlayServicesUtil", "Signature not valid.  Found: \n" + Base64.encodeToString(byteArray, 0));
                    return null;
                } catch (CertificateExpiredException unused) {
                    SSDKLog.b().a("GooglePlayServicesUtil", "Certificate has expired.");
                    return null;
                } catch (CertificateNotYetValidException unused2) {
                    SSDKLog.b().a("GooglePlayServicesUtil", "Certificate is not yet valid.");
                    return null;
                }
            } catch (CertificateException unused3) {
                SSDKLog.b().a("GooglePlayServicesUtil", "Could not generate certificate.");
                return null;
            }
        } catch (CertificateException unused4) {
            SSDKLog.b().a("GooglePlayServicesUtil", "Could not get certificate instance.");
            return null;
        }
    }

    public void a(ShareActivity shareActivity) {
        this.f6593o = shareActivity;
    }

    public void a() {
        a(new ShareSDKCallback<Boolean>() { // from class: cn.sharesdk.google.c.1
            @Override // cn.sharesdk.framework.ShareSDKCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onCallback(Boolean bool) {
                if (!bool.booleanValue()) {
                    c.this.a("Google Play services is missing", (HashMap<String, Object>) null, 3);
                    return;
                }
                if (c.this.f6586h != null) {
                    c cVar = c.this;
                    cVar.a(cVar.f6586h);
                } else {
                    c cVar2 = c.this;
                    cVar2.f6586h = cVar2.new b();
                }
                c cVar3 = c.this;
                if (cVar3.a("com.google.android.gms.plus.service.START", cVar3.f6586h)) {
                    new Thread(new Runnable() { // from class: cn.sharesdk.google.c.1.1
                        @Override // java.lang.Runnable
                        public void run() throws InterruptedException {
                            try {
                                if (c.this.f6595q < 5000) {
                                    Thread.sleep(5000L);
                                } else {
                                    Thread.sleep(c.this.f6595q);
                                }
                                if (c.this.f6596r) {
                                    return;
                                }
                                c.this.a("INTERNAL_ERROR", (HashMap<String, Object>) null, 3);
                            } catch (InterruptedException e7) {
                                SSDKLog.b().a(e7);
                            }
                        }
                    }).start();
                } else {
                    SSDKLog.b().a("GmsClient", "unable to connect to service: com.google.android.gms.plus.service.START");
                    c.this.a("unable to connect to service: com.google.android.gms.plus.service.START", (HashMap<String, Object>) null, 3);
                }
            }
        });
    }

    public boolean a(String str, b bVar) {
        boolean zBindService;
        synchronized (this) {
            this.f6588j = true;
            zBindService = this.f6583e.bindService(new Intent(str).setPackage("com.google.android.gms"), bVar, TsExtractor.TS_STREAM_TYPE_AC3);
            this.f6588j = false;
        }
        return zBindService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        synchronized (this) {
            this.f6583e.unbindService(bVar);
        }
    }

    public static void a(final ShareSDKCallback<Boolean> shareSDKCallback) {
        DH.requester(MobSDK.getContext()).getPInfoForce(true, "com.android.vending", 64).getPInfoForce(true, "com.google.android.gms", 64).getAInfoForPkg("com.google.android.gms", 0).request(new DH.DHResponder() { // from class: cn.sharesdk.google.c.2
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    PackageInfo pInfoForce = dHResponse.getPInfoForce(0);
                    if (pInfoForce == null) {
                        pInfoForce = i.a("com.android.vending", 64);
                    }
                    if (pInfoForce == null) {
                        SSDKLog.b().a("GooglePlayServicesUtil", "Google Play Store is missing.");
                        ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                        if (shareSDKCallback2 != null) {
                            shareSDKCallback2.onCallback(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                    byte[] bArrB = c.b(pInfoForce, c.f6580c);
                    if (bArrB == null) {
                        SSDKLog.b().a("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                        ShareSDKCallback shareSDKCallback3 = shareSDKCallback;
                        if (shareSDKCallback3 != null) {
                            shareSDKCallback3.onCallback(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                    PackageInfo pInfoForce2 = dHResponse.getPInfoForce(1);
                    if (pInfoForce2 == null) {
                        pInfoForce2 = i.a("com.google.android.gms", 64);
                    }
                    if (pInfoForce2 == null) {
                        SSDKLog.b().a("GooglePlayServicesUtil", "Google Play services is missing.");
                        ShareSDKCallback shareSDKCallback4 = shareSDKCallback;
                        if (shareSDKCallback4 != null) {
                            shareSDKCallback4.onCallback(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                    if (c.b(pInfoForce2, new byte[][]{bArrB}) == null) {
                        SSDKLog.b().a("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        ShareSDKCallback shareSDKCallback5 = shareSDKCallback;
                        if (shareSDKCallback5 != null) {
                            shareSDKCallback5.onCallback(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                    if (pInfoForce2.versionCode < 3136100) {
                        SSDKLog.b().a("GooglePlayServicesUtil", "Google Play services out of date.  Requires 3136100 but found " + pInfoForce2.versionCode);
                        ShareSDKCallback shareSDKCallback6 = shareSDKCallback;
                        if (shareSDKCallback6 != null) {
                            shareSDKCallback6.onCallback(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                    ApplicationInfo aInfoForPkg = dHResponse.getAInfoForPkg(new int[0]);
                    if (aInfoForPkg == null) {
                        SSDKLog.b().a("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
                        ShareSDKCallback shareSDKCallback7 = shareSDKCallback;
                        if (shareSDKCallback7 != null) {
                            shareSDKCallback7.onCallback(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                    if (aInfoForPkg.enabled) {
                        ShareSDKCallback shareSDKCallback8 = shareSDKCallback;
                        if (shareSDKCallback8 != null) {
                            shareSDKCallback8.onCallback(Boolean.TRUE);
                            return;
                        }
                        return;
                    }
                    SSDKLog.b().a("enabled false", new Object[0]);
                    ShareSDKCallback shareSDKCallback9 = shareSDKCallback;
                    if (shareSDKCallback9 != null) {
                        shareSDKCallback9.onCallback(Boolean.FALSE);
                    }
                } catch (Throwable th) {
                    SSDKLog.b().a("check google" + th, new Object[0]);
                    ShareSDKCallback shareSDKCallback10 = shareSDKCallback;
                    if (shareSDKCallback10 != null) {
                        shareSDKCallback10.onCallback(Boolean.FALSE);
                    }
                }
            }
        });
    }

    public final void a(IBinder iBinder) throws RemoteException {
        try {
            BinderC0090c binderC0090c = new BinderC0090c();
            Bundle bundle = new Bundle();
            bundle.putBoolean("skip_oob", false);
            bundle.putStringArray("request_visible_actions", this.f6584f);
            String[] strArr = this.f6587i;
            if (strArr != null) {
                bundle.putStringArray("required_features", strArr);
            }
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(binderC0090c.asBinder());
            parcelObtain.writeInt(3136100);
            parcelObtain.writeString(this.f6583e.getPackageName());
            parcelObtain.writeString(this.f6583e.getPackageName());
            parcelObtain.writeStringArray(this.f6585g);
            parcelObtain.writeString(this.f6582d);
            parcelObtain.writeInt(1);
            bundle.writeToParcel(parcelObtain, 0);
            iBinder.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            parcelObtain.recycle();
            parcelObtain2.recycle();
        } catch (RemoteException unused) {
            SSDKLog.b().a("GmsClient", "service died");
            a("google service died", (HashMap<String, Object>) null, 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, HashMap<String, Object> map, int i6) {
        PlatformActionListener platformActionListener;
        if (this.f6594p) {
            this.f6594p = false;
            if (i6 == 1) {
                PlatformActionListener platformActionListener2 = this.f6589k;
                if (platformActionListener2 != null) {
                    platformActionListener2.onComplete(this.f6590l, 8, map);
                    return;
                }
                return;
            }
            if (i6 != 2) {
                if (i6 == 3 && (platformActionListener = this.f6589k) != null) {
                    platformActionListener.onError(this.f6590l, 8, new Throwable(str));
                    return;
                }
                return;
            }
            PlatformActionListener platformActionListener3 = this.f6589k;
            if (platformActionListener3 != null) {
                platformActionListener3.onCancel(this.f6590l, 8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Parcel parcel) throws Throwable {
        String strC;
        int iB = e.b(parcel);
        String strE = null;
        String strE2 = null;
        UserData.AgeRange ageRange = null;
        String strE3 = null;
        String strE4 = null;
        String strE5 = null;
        int iD = 0;
        String strE6 = null;
        ArrayList arrayListB = null;
        UserData.Image image = null;
        int iD2 = 0;
        boolean zC = false;
        String strE7 = null;
        int iD3 = 0;
        String strE8 = null;
        String strE9 = null;
        boolean zC2 = false;
        while (parcel.dataPosition() < iB) {
            int iA = e.a(parcel);
            switch (e.a(iA)) {
                case 1:
                    e.d(parcel, iA);
                    break;
                case 2:
                    strE3 = e.e(parcel, iA);
                    break;
                case 3:
                    ageRange = (UserData.AgeRange) e.a(parcel, iA, UserData.AgeRange.f6501a);
                    break;
                case 4:
                    strE4 = e.e(parcel, iA);
                    break;
                case 5:
                    strE5 = e.e(parcel, iA);
                    break;
                case 6:
                    iD = e.d(parcel, iA);
                    break;
                case 7:
                    break;
                case 8:
                    strE6 = e.e(parcel, iA);
                    break;
                case 9:
                    strE2 = e.e(parcel, iA);
                    break;
                case 10:
                    arrayListB = e.b(parcel, iA, UserData.Emails.f6523a);
                    break;
                case 11:
                    e.e(parcel, iA);
                    break;
                case 12:
                    iD2 = e.d(parcel, iA);
                    break;
                case 13:
                    e.c(parcel, iA);
                    break;
                case 14:
                    strE = e.e(parcel, iA);
                    break;
                case 15:
                    image = (UserData.Image) e.a(parcel, iA, UserData.Image.f6529a);
                    break;
                case 16:
                    zC = e.c(parcel, iA);
                    break;
                case 17:
                default:
                    e.b(parcel, iA);
                    break;
                case 18:
                    strE7 = e.e(parcel, iA);
                    break;
                case 19:
                    break;
                case 20:
                    e.e(parcel, iA);
                    break;
                case 21:
                    e.d(parcel, iA);
                    break;
                case 22:
                    e.b(parcel, iA, UserData.Organizations.f6542a);
                    break;
                case 23:
                    e.b(parcel, iA, UserData.PlacesLived.f6554a);
                    break;
                case 24:
                    e.d(parcel, iA);
                    break;
                case 25:
                    iD3 = e.d(parcel, iA);
                    break;
                case 26:
                    strE8 = e.e(parcel, iA);
                    break;
                case 27:
                    strE9 = e.e(parcel, iA);
                    break;
                case 28:
                    e.b(parcel, iA, UserData.Urls.f6559a);
                    break;
                case 29:
                    zC2 = e.c(parcel, iA);
                    break;
            }
        }
        if (parcel.dataPosition() == iB) {
            SSDKLog.b().a("googleinitPerson,", new Object[0]);
            HashMap<String, Object> map = new HashMap<>();
            map.put(TtmlNode.ATTR_ID, strE);
            map.put("DisplayName", strE2);
            map.put("ageRange_Max", ageRange == null ? null : Integer.valueOf(ageRange.c()));
            map.put("ageRange_Min", ageRange == null ? null : Integer.valueOf(ageRange.d()));
            map.put("aboutMe", strE3);
            map.put("birthday", strE4);
            map.put("braggingRights", strE5);
            map.put("circledByCount", Integer.valueOf(iD));
            map.put("currentLocation", strE6);
            if (arrayListB != null) {
                map.put("Emails", arrayListB.size() == 0 ? null : ((UserData.Emails) arrayListB.get(0)).e());
                strC = null;
            } else {
                strC = null;
                map.put("Emails", null);
            }
            map.put("gender", Integer.valueOf(iD2));
            if (image != null) {
                strC = image.c();
            }
            map.put("image", strC);
            map.put("isPlusUser", Boolean.valueOf(zC));
            map.put("Language", strE7);
            map.put("RelationshipStatus", Integer.valueOf(iD3));
            map.put("Tagline", strE8);
            map.put(ImagesContract.URL, strE9);
            map.put("isVerified", Boolean.valueOf(zC2));
            a("", map, 1);
            return;
        }
        throw new Throwable("Overread allowed size end=" + iB);
    }

    public void a(int i6, int i7, PendingIntent pendingIntent) throws IntentSender.SendIntentException {
        if (a(i6, pendingIntent)) {
            ((Activity) this.f6583e).startIntentSenderForResult(pendingIntent.getIntentSender(), i7, null, 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i6) {
        switch (i6) {
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            default:
                return "unknown status code " + i6;
        }
    }

    public static void a(boolean z6, Object obj) {
        if (!z6) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public void a(Platform platform, PlatformActionListener platformActionListener, PlatformDb platformDb) {
        this.f6589k = platformActionListener;
        this.f6590l = platform;
        this.f6591m = platformDb;
    }
}
