package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f6365a;

    /* renamed from: b, reason: collision with root package name */
    private NetworkHelper f6366b = new NetworkHelper();

    /* renamed from: c, reason: collision with root package name */
    private String f6367c = MobSDK.checkRequestUrl("api-share.mob.com");

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return this.f6367c + "/conf5";
    }

    public static b a() {
        synchronized (b.class) {
            try {
                if (f6365a == null) {
                    synchronized (b.class) {
                        try {
                            if (f6365a == null) {
                                f6365a = new b();
                            }
                        } finally {
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f6365a;
    }

    public void b() {
        try {
            DH.requester(MobSDK.getContext()).getDeviceKey().getDetailNetworkTypeForStatic().request(new DH.DHResponder() { // from class: cn.sharesdk.framework.b.1
                @Override // com.mob.tools.utils.DH.DHResponder
                public void onResponse(DH.DHResponse dHResponse) {
                    try {
                        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
                        String appkey = MobSDK.getAppkey();
                        if (TextUtils.isEmpty(appkey)) {
                            return;
                        }
                        arrayList.add(new KVPair<>("appkey", appkey));
                        arrayList.add(new KVPair<>("device", dHResponse.getDeviceKey()));
                        arrayList.add(new KVPair<>("plat", String.valueOf(DH.SyncMtd.getPlatformCode())));
                        arrayList.add(new KVPair<>("apppkg", DH.SyncMtd.getPackageName()));
                        arrayList.add(new KVPair<>("appver", String.valueOf(DH.SyncMtd.getAppVersion())));
                        arrayList.add(new KVPair<>("sdkver", String.valueOf(ShareSDK.SDK_VERSION_CODE)));
                        arrayList.add(new KVPair<>("networktype", dHResponse.getDetailNetworkTypeForStatic()));
                        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
                        arrayList2.add(new KVPair<>("User-Identity", cn.sharesdk.framework.network.a.a()));
                        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                        networkTimeOut.readTimout = 10000;
                        networkTimeOut.connectionTimeout = 10000;
                        HashMap mapFromJson = new Hashon().fromJson(b.this.f6366b.httpPost(b.this.c(), arrayList, (KVPair<String>) null, arrayList2, networkTimeOut));
                        if (!mapFromJson.containsKey("error")) {
                            a.f6244b = appkey;
                        } else if (String.valueOf(mapFromJson.get("error")).contains("'appkey' is illegal")) {
                            a.f6243a = true;
                        }
                    } catch (Throwable th) {
                        SSDKLog.b().a("updateServerConfig " + th, new Object[0]);
                    }
                }
            });
        } catch (Throwable th) {
            SSDKLog.b().a(th);
        }
    }
}
