package cn.sharesdk.framework.utils;

import android.os.Handler;
import android.os.Message;
import com.mob.tools.MobHandlerThread;

/* loaded from: classes2.dex */
public abstract class f implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    protected final Handler f6468a = MobHandlerThread.newHandler(this);

    public void a(Message message) {
    }

    public abstract void b(Message message);

    public void c(Message message) {
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i6 = message.what;
        if (i6 == -2) {
            c(message);
            return false;
        }
        if (i6 != -1) {
            b(message);
            return false;
        }
        a(message);
        return false;
    }

    public void a(int i6, int i7, Object obj) {
        Message message = new Message();
        message.what = -1;
        message.arg1 = i6;
        message.arg2 = i7;
        message.obj = obj;
        this.f6468a.sendMessage(message);
    }

    public void c() {
        a(0, 0, null);
    }
}
