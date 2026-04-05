package com.uz.navee.utils;

import android.os.SystemClock;
import androidx.media3.exoplayer.Renderer;
import com.uz.navee.MyApplication;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class FileLog {

    /* renamed from: a, reason: collision with root package name */
    public final ByteArrayOutputStream f13263a = new ByteArrayOutputStream(3072);

    /* renamed from: b, reason: collision with root package name */
    public final kotlin.f f13264b = kotlin.h.b(new q5.a() { // from class: com.uz.navee.utils.FileLog$outputStream$2
        {
            super(0);
        }

        @Override // q5.a
        public final FileOutputStream invoke() {
            return new FileOutputStream(this.this$0.d(), true);
        }
    });

    public FileLog() {
        k5.a.b(false, false, null, null, 0, new q5.a() { // from class: com.uz.navee.utils.FileLog.1
            {
                super(0);
            }

            @Override // q5.a
            public /* bridge */ /* synthetic */ Object invoke() throws IOException {
                m126invoke();
                return kotlin.u.f15726a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m126invoke() throws IOException {
                while (true) {
                    SystemClock.sleep(Renderer.DEFAULT_DURATION_TO_PROGRESS_US);
                    if (FileLog.this.f13263a.size() > 0) {
                        try {
                            FileLog.this.f13263a.writeTo(FileLog.this.e());
                            FileLog.this.f13263a.reset();
                            FileLog.this.e().flush();
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }, 31, null);
    }

    public final File d() throws IOException {
        File externalFilesDir = MyApplication.b().getExternalFilesDir("log");
        if (externalFilesDir != null) {
            externalFilesDir.mkdirs();
        }
        File file = new File(externalFilesDir, l.b(System.currentTimeMillis(), "yyyy-MM-dd") + ".txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    public final FileOutputStream e() {
        return (FileOutputStream) this.f13264b.getValue();
    }

    public final void f(String message) throws IOException {
        kotlin.jvm.internal.y.f(message, "message");
        String str = l.b(System.currentTimeMillis(), null) + ":\t" + message + "\n";
        ByteArrayOutputStream byteArrayOutputStream = this.f13263a;
        byte[] bytes = str.getBytes(kotlin.text.d.f15699b);
        kotlin.jvm.internal.y.e(bytes, "getBytes(...)");
        byteArrayOutputStream.write(bytes);
    }
}
