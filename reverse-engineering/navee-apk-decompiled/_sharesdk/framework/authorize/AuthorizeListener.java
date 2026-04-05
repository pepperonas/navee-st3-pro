package cn.sharesdk.framework.authorize;

import android.os.Bundle;

/* loaded from: classes2.dex */
public interface AuthorizeListener {
    void onCancel();

    void onComplete(Bundle bundle);

    void onError(Throwable th);
}
