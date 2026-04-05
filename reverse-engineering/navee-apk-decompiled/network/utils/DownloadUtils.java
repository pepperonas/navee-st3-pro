package com.uz.navee.network.utils;

import android.os.Handler;
import android.os.Message;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
public class DownloadUtils {

    /* renamed from: f, reason: collision with root package name */
    public static DownloadUtils f11672f;

    /* renamed from: a, reason: collision with root package name */
    public b f11673a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11674b = 0;

    /* renamed from: c, reason: collision with root package name */
    public final int f11675c = 1;

    /* renamed from: d, reason: collision with root package name */
    public final int f11676d = 2;

    /* renamed from: e, reason: collision with root package name */
    public Handler f11677e = new Handler(new a());

    public enum DownloadStatus {
        downloading,
        success,
        failed
    }

    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i6 = message.what;
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 == 2 && DownloadUtils.this.f11673a != null) {
                        DownloadUtils.this.f11673a.c(DownloadStatus.downloading, ((Float) message.obj).floatValue(), "");
                    }
                } else if (DownloadUtils.this.f11673a != null) {
                    DownloadUtils.this.f11673a.c(DownloadStatus.failed, 0.0f, "");
                }
            } else if (DownloadUtils.this.f11673a != null) {
                DownloadUtils.this.f11673a.c(DownloadStatus.success, 1.0f, (String) message.obj);
            }
            return true;
        }
    }

    public interface b {
        void c(DownloadStatus downloadStatus, float f7, String str);
    }

    public static DownloadUtils f() {
        if (f11672f == null) {
            synchronized (DownloadUtils.class) {
                try {
                    if (f11672f == null) {
                        f11672f = new DownloadUtils();
                    }
                } finally {
                }
            }
        }
        return f11672f;
    }

    public final void c(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    file2.delete();
                } else if (file2.isDirectory()) {
                    c(file2);
                }
            }
        }
    }

    public void d(String str) {
        c(new File(str));
    }

    public void e(final String str, final String str2, final String str3) {
        new Thread(new Runnable() { // from class: f4.a
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.f13577a.g(str3, str, str2);
            }
        }).start();
    }

    public final /* synthetic */ void g(String str, String str2, String str3) throws IOException {
        try {
            ResponseBody responseBodyBody = new OkHttpClient().newCall(new Request.Builder().url(str).get().build()).execute().body();
            Objects.requireNonNull(responseBodyBody);
            InputStream inputStreamByteStream = responseBodyBody.byteStream();
            long jContentLength = responseBodyBody.contentLength();
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str3);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            int i6 = 0;
            while (true) {
                int i7 = inputStreamByteStream.read(bArr);
                if (i7 == -1) {
                    fileOutputStream.flush();
                    inputStreamByteStream.close();
                    fileOutputStream.close();
                    Message messageObtainMessage = this.f11677e.obtainMessage();
                    messageObtainMessage.obj = file2.getAbsolutePath();
                    messageObtainMessage.what = 0;
                    this.f11677e.sendMessage(messageObtainMessage);
                    return;
                }
                fileOutputStream.write(bArr, 0, i7);
                i6 += i7;
                float f7 = (i6 * 1.0f) / jContentLength;
                if (f7 == 1.0d) {
                    f4.b.g("下载完成" + str3, new Object[0]);
                } else {
                    f4.b.g("下载进度==" + f7, new Object[0]);
                }
                Message messageObtainMessage2 = this.f11677e.obtainMessage();
                messageObtainMessage2.obj = Float.valueOf(f7);
                messageObtainMessage2.what = 2;
                this.f11677e.sendMessage(messageObtainMessage2);
            }
        } catch (IOException e7) {
            e7.printStackTrace();
            this.f11677e.sendEmptyMessage(1);
        }
    }

    public void set0nDownloadListener(b bVar) {
        this.f11673a = bVar;
    }
}
