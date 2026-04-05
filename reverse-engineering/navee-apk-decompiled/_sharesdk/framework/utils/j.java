package cn.sharesdk.framework.utils;

import android.content.Context;
import com.mob.tools.utils.ResHelper;

/* loaded from: classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static float f6476a = 1.5f;

    /* renamed from: b, reason: collision with root package name */
    public static int f6477b = 540;

    /* renamed from: c, reason: collision with root package name */
    private static Context f6478c;

    public static void a(Context context) {
        Context context2 = f6478c;
        if (context2 == null || context2 != context.getApplicationContext()) {
            f6478c = context;
        }
    }

    public static int b(int i6) {
        return ResHelper.designToDevice(f6478c, f6477b, i6);
    }

    public static int a(int i6) {
        return ResHelper.designToDevice(f6478c, f6476a, i6);
    }
}
