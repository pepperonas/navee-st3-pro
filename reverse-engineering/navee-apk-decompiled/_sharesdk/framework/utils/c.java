package cn.sharesdk.framework.utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.view.accessibility.AccessibilityEventCompat;

/* loaded from: classes2.dex */
public class c {
    public static PendingIntent a(Context context, int i6, Intent intent, int i7) {
        return PendingIntent.getBroadcast(context, i6, intent, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
    }
}
