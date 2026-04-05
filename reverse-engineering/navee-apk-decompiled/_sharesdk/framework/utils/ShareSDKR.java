package cn.sharesdk.framework.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;

/* loaded from: classes2.dex */
public class ShareSDKR {
    public static int getAnimRes(Context context, String str) {
        return getResId(context, "anim", str);
    }

    public static int getBitmapRes(Context context, String str) {
        return getResId(context, "drawable", str);
    }

    public static int getColorRes(Context context, String str) {
        return getResId(context, "color", str);
    }

    public static int getIdRes(Context context, String str) {
        return getResId(context, TtmlNode.ATTR_ID, str);
    }

    public static int getLayoutRes(Context context, String str) {
        return getResId(context, TtmlNode.TAG_LAYOUT, str);
    }

    public static int getPluralsRes(Context context, String str) {
        return getResId(context, "plurals", str);
    }

    public static int getRawRes(Context context, String str) {
        return getResId(context, "raw", str);
    }

    public static int getResId(Context context, String str, String str2) {
        int identifier = 0;
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String packageName = context.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                return 0;
            }
            identifier = context.getResources().getIdentifier(str2, str, packageName);
            if (identifier <= 0) {
                identifier = context.getResources().getIdentifier(str2.toLowerCase(), str, packageName);
            }
            if (identifier <= 0) {
                identifier = context.getResources().getIdentifier("ssdk_" + str2, str, packageName);
                if (identifier <= 0) {
                    identifier = context.getResources().getIdentifier("ssdk_" + str2.toLowerCase(), str, packageName);
                }
            }
            if (identifier <= 0) {
                identifier = context.getResources().getIdentifier("ssdk_oks_" + str2, str, packageName);
                if (identifier <= 0) {
                    identifier = context.getResources().getIdentifier("ssdk_oks_" + str2.toLowerCase(), str, packageName);
                }
            }
            if (identifier <= 0) {
                SSDKLog.b().a("failed to parse " + str + " resource \"" + str2 + "\"");
            }
        }
        return identifier;
    }

    public static int getStringArrayRes(Context context, String str) {
        return getResId(context, "array", str);
    }

    public static int getStringRes(Context context, String str) {
        return getResId(context, TypedValues.Custom.S_STRING, str);
    }

    public static int getStyleRes(Context context, String str) {
        return getResId(context, TtmlNode.TAG_STYLE, str);
    }
}
