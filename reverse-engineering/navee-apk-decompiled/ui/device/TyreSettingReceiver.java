package com.uz.navee.ui.device;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.clj.fastble.data.BleDevice;
import com.uz.navee.MainActivity;
import com.uz.navee.MyApplication;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.ui.wheel.AlertPopup;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TyreSettingReceiver extends BroadcastReceiver {
    public static void b(Context context, String str) throws NumberFormatException {
        Date dateF;
        long j6;
        String strU = b4.a.u(str);
        if (strU == null || (dateF = com.uz.navee.utils.l.f(strU, "yyyy-MM-dd")) == null || dateF.compareTo(new Date()) > 0) {
            return;
        }
        String strV = b4.a.v(str);
        if (strV != null) {
            try {
                j6 = Long.parseLong(strV);
            } catch (NumberFormatException unused) {
            }
        } else {
            j6 = 1209600000;
        }
        int i6 = (j6 > 2592000000L ? 1 : (j6 == 2592000000L ? 0 : -1));
        d(context, str, "");
    }

    public static /* synthetic */ void c() {
    }

    public static void d(Context context, String str, String str2) {
        List<BleDevice> listF;
        p0.a aVarN = p0.a.n();
        if (aVarN == null || str == null || (listF = aVarN.f()) == null || listF.isEmpty() || !aVarN.y(str)) {
            return;
        }
        for (BleDevice bleDevice : listF) {
            if (Objects.equals(b4.a.r(bleDevice), str)) {
                AlertPopup.Q(MyApplication.f11588e, "", "", "", context.getString(R$string.i_see), new AlertPopup.a() { // from class: com.uz.navee.ui.device.z8
                    @Override // com.uz.navee.ui.wheel.AlertPopup.a
                    public /* synthetic */ void a() {
                        j4.c.a(this);
                    }

                    @Override // com.uz.navee.ui.wheel.AlertPopup.a
                    public final void b() {
                        TyreSettingReceiver.c();
                    }
                });
                b4.a.c0(bleDevice, b4.a.k(90, 1, false));
                b4.a.T("", b4.a.r(bleDevice), str2);
                return;
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("des");
        String stringExtra2 = intent.getStringExtra("mac");
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(androidx.media3.common.util.k.a("tyre-setting-notification-channel", "tyreSettingNotification", 4));
        }
        Intent intent2 = new Intent(context, (Class<?>) MainActivity.class);
        intent2.putExtra("notification", 103);
        intent2.putExtra("des", stringExtra);
        intent2.putExtra("mac", stringExtra2);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent2, 201326592);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "tyre-setting-notification-channel");
        builder.setSmallIcon(R$mipmap.ic_launcher).setTicker("").setContentTitle("").setContentText("").setContentIntent(activity).setAutoCancel(true);
        notificationManager.notify(103, builder.build());
        d(context, stringExtra2, stringExtra);
    }
}
