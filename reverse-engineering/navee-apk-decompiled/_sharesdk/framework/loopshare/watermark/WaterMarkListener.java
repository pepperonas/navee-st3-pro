package cn.sharesdk.framework.loopshare.watermark;

@Deprecated
/* loaded from: classes2.dex */
public interface WaterMarkListener {
    void onCancel();

    void onEnd(int i6);

    void onFailed(String str, int i6);

    void onProgress(int i6);

    void onStart();
}
