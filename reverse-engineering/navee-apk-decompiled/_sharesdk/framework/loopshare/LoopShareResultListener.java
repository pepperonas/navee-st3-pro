package cn.sharesdk.framework.loopshare;

@Deprecated
/* loaded from: classes2.dex */
public interface LoopShareResultListener<T> {
    void onError(Throwable th);

    void onResult(T t6);
}
