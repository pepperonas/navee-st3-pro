package com.uz.navee.utils;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    public Activity f13293a;

    /* renamed from: b, reason: collision with root package name */
    public b0 f13294b;

    /* renamed from: c, reason: collision with root package name */
    public final BroadcastReceiver f13295c;

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getBooleanExtra("granted", false)) {
                z zVar = z.this;
                zVar.c(zVar.f13293a);
            } else {
                b0 b0Var = z.this.f13294b;
                if (b0Var != null) {
                    b0Var.a(null);
                }
            }
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final z f13297a = new z();
    }

    public static z b() {
        return b.f13297a;
    }

    public void c(Activity activity) {
        if (activity == null) {
            return;
        }
        this.f13293a = activity;
        LocalBroadcastManager.getInstance(activity).unregisterReceiver(this.f13295c);
        LocalBroadcastManager.getInstance(activity).registerReceiver(this.f13295c, new IntentFilter("LocationGrantedNotification"));
        LocationManager locationManager = (LocationManager) activity.getSystemService(FirebaseAnalytics.Param.LOCATION);
        if (ContextCompat.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION") != 0 && ContextCompat.checkSelfPermission(activity, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 303);
            return;
        }
        Iterator<String> it = locationManager.getProviders(true).iterator();
        Location location = null;
        while (it.hasNext()) {
            Location lastKnownLocation = locationManager.getLastKnownLocation(it.next());
            if (lastKnownLocation != null && (location == null || lastKnownLocation.getAccuracy() < location.getAccuracy())) {
                location = lastKnownLocation;
            }
        }
        b0 b0Var = this.f13294b;
        if (b0Var != null) {
            b0Var.a(location);
        }
    }

    public z() {
        this.f13295c = new a();
    }
}
