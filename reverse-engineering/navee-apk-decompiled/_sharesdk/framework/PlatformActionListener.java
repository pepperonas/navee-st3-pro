package cn.sharesdk.framework;

import java.util.HashMap;

/* loaded from: classes2.dex */
public interface PlatformActionListener {
    void onCancel(Platform platform, int i6);

    void onComplete(Platform platform, int i6, HashMap<String, Object> map);

    void onError(Platform platform, int i6, Throwable th);
}
