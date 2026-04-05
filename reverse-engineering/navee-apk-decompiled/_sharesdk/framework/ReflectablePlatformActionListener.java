package cn.sharesdk.framework;

import android.os.Handler;
import android.os.Message;
import com.mob.tools.utils.UIHandler;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class ReflectablePlatformActionListener implements PlatformActionListener {

    /* renamed from: a, reason: collision with root package name */
    private int f6175a;

    /* renamed from: b, reason: collision with root package name */
    private Handler.Callback f6176b;

    /* renamed from: c, reason: collision with root package name */
    private int f6177c;

    /* renamed from: d, reason: collision with root package name */
    private Handler.Callback f6178d;

    /* renamed from: e, reason: collision with root package name */
    private int f6179e;

    /* renamed from: f, reason: collision with root package name */
    private Handler.Callback f6180f;

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onCancel(Platform platform, int i6) {
        if (this.f6180f != null) {
            Message message = new Message();
            message.what = this.f6179e;
            message.obj = new Object[]{platform, Integer.valueOf(i6)};
            UIHandler.sendMessage(message, this.f6180f);
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onComplete(Platform platform, int i6, HashMap<String, Object> map) {
        if (this.f6176b != null) {
            Message message = new Message();
            message.what = this.f6175a;
            message.obj = new Object[]{platform, Integer.valueOf(i6), map};
            UIHandler.sendMessage(message, this.f6176b);
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onError(Platform platform, int i6, Throwable th) {
        if (this.f6178d != null) {
            Message message = new Message();
            message.what = this.f6177c;
            message.obj = new Object[]{platform, Integer.valueOf(i6), th};
            UIHandler.sendMessage(message, this.f6178d);
        }
    }

    public void setOnCancelCallback(int i6, Handler.Callback callback) {
        this.f6179e = i6;
        this.f6180f = callback;
    }

    public void setOnCompleteCallback(int i6, Handler.Callback callback) {
        this.f6175a = i6;
        this.f6176b = callback;
    }

    public void setOnErrorCallback(int i6, Handler.Callback callback) {
        this.f6177c = i6;
        this.f6178d = callback;
    }
}
