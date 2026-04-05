package com.uz.navee.dfu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.CountDownTimer;
import androidx.camera.core.RetryPolicy;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.common.C;
import com.clj.fastble.data.BleDevice;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.uz.navee.MyApplication;
import com.uz.navee.utils.h;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

/* loaded from: classes3.dex */
public class DFUProcessor extends h {

    /* renamed from: f, reason: collision with root package name */
    public DataInputStream f11639f;

    /* renamed from: n, reason: collision with root package name */
    public final BleDevice f11647n;

    /* renamed from: o, reason: collision with root package name */
    public final String f11648o;

    /* renamed from: p, reason: collision with root package name */
    public final DFUMcuType f11649p;

    /* renamed from: r, reason: collision with root package name */
    public CountDownTimer f11651r;

    /* renamed from: s, reason: collision with root package name */
    public CountDownTimer f11652s;

    /* renamed from: t, reason: collision with root package name */
    public CountDownTimer f11653t;

    /* renamed from: u, reason: collision with root package name */
    public Timer f11654u;

    /* renamed from: v, reason: collision with root package name */
    public Timer f11655v;

    /* renamed from: w, reason: collision with root package name */
    public Timer f11656w;

    /* renamed from: x, reason: collision with root package name */
    public c4.e f11657x;

    /* renamed from: y, reason: collision with root package name */
    public volatile boolean f11658y;

    /* renamed from: b, reason: collision with root package name */
    public final int f11635b = 128;

    /* renamed from: c, reason: collision with root package name */
    public final int f11636c = 10;

    /* renamed from: d, reason: collision with root package name */
    public final long f11637d = 500;

    /* renamed from: e, reason: collision with root package name */
    public final long f11638e = RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS;

    /* renamed from: g, reason: collision with root package name */
    public int f11640g = 0;

    /* renamed from: h, reason: collision with root package name */
    public boolean f11641h = false;

    /* renamed from: i, reason: collision with root package name */
    public int f11642i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f11643j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f11644k = 0;

    /* renamed from: l, reason: collision with root package name */
    public final long f11645l = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;

    /* renamed from: m, reason: collision with root package name */
    public final long f11646m = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;

    /* renamed from: q, reason: collision with root package name */
    public DFUProcessState f11650q = DFUProcessState.none;

    /* renamed from: z, reason: collision with root package name */
    public final BroadcastReceiver f11659z = new a();

    public enum DFUMcuType {
        bms,
        bldc,
        meter,
        screen
    }

    public enum DFUProcessState {
        none,
        sendStart,
        requestRand,
        sendRand,
        xmodemReady,
        xmodemSendPack,
        xmodemSendPackWaiting,
        xmodemSendPackSending,
        xmodemSendPackSuccess,
        xmodemSendPackFailure,
        xmodemSendEOT,
        xmodemFinished,
        success,
        failure
    }

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws IOException {
            if (DFUProcessor.this.f11658y) {
                return;
            }
            DFUProcessor.this.C(intent.getByteArrayExtra("data"));
        }
    }

    public class b extends CountDownTimer {
        public b(long j6, long j7) {
            super(j6, j7);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
        @Override // android.os.CountDownTimer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onTick(long r3) throws java.io.IOException {
            /*
                r2 = this;
                com.uz.navee.dfu.DFUProcessor r0 = com.uz.navee.dfu.DFUProcessor.this
                com.uz.navee.dfu.DFUProcessor$DFUProcessState r0 = com.uz.navee.dfu.DFUProcessor.k(r0)
                com.uz.navee.dfu.DFUProcessor$DFUProcessState r1 = com.uz.navee.dfu.DFUProcessor.DFUProcessState.none
                if (r0 == r1) goto L15
                com.uz.navee.dfu.DFUProcessor r0 = com.uz.navee.dfu.DFUProcessor.this
                com.uz.navee.dfu.DFUProcessor$DFUProcessState r0 = com.uz.navee.dfu.DFUProcessor.k(r0)
                com.uz.navee.dfu.DFUProcessor$DFUProcessState r1 = com.uz.navee.dfu.DFUProcessor.DFUProcessState.sendStart
                if (r0 == r1) goto L15
                return
            L15:
                r0 = 3000(0xbb8, double:1.482E-320)
                long r3 = r3 / r0
                int r3 = (int) r3
                if (r3 > 0) goto L38
                com.uz.navee.dfu.DFUProcessor r3 = com.uz.navee.dfu.DFUProcessor.this
                android.os.CountDownTimer r3 = com.uz.navee.dfu.DFUProcessor.j(r3)
                if (r3 == 0) goto L32
                com.uz.navee.dfu.DFUProcessor r3 = com.uz.navee.dfu.DFUProcessor.this
                android.os.CountDownTimer r3 = com.uz.navee.dfu.DFUProcessor.j(r3)
                r3.cancel()
                com.uz.navee.dfu.DFUProcessor r3 = com.uz.navee.dfu.DFUProcessor.this
                r4 = 0
                com.uz.navee.dfu.DFUProcessor.p(r3, r4)
            L32:
                com.uz.navee.dfu.DFUProcessor r3 = com.uz.navee.dfu.DFUProcessor.this
                com.uz.navee.dfu.DFUProcessor.r(r3)
                goto L64
            L38:
                r4 = 2
                int r3 = r3 % r4
                if (r3 != 0) goto L5d
                com.uz.navee.dfu.DFUProcessor r3 = com.uz.navee.dfu.DFUProcessor.this
                com.uz.navee.dfu.DFUProcessor$DFUMcuType r3 = com.uz.navee.dfu.DFUProcessor.h(r3)
                int r3 = r3.ordinal()
                if (r3 == 0) goto L5a
                r0 = 1
                if (r3 == r0) goto L57
                if (r3 == r4) goto L54
                r4 = 3
                if (r3 == r4) goto L51
                goto L5d
            L51:
                java.lang.String r3 = "down dfu_start 4\r"
                goto L5f
            L54:
                java.lang.String r3 = "down dfu_start 1\r"
                goto L5f
            L57:
                java.lang.String r3 = "down dfu_start 2\r"
                goto L5f
            L5a:
                java.lang.String r3 = "down dfu_start 3\r"
                goto L5f
            L5d:
                java.lang.String r3 = "down dfu_start\r"
            L5f:
                com.uz.navee.dfu.DFUProcessor r4 = com.uz.navee.dfu.DFUProcessor.this
                com.uz.navee.dfu.DFUProcessor.t(r4, r3)
            L64:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uz.navee.dfu.DFUProcessor.b.onTick(long):void");
        }
    }

    public class c extends CountDownTimer {
        public c(long j6, long j7) {
            super(j6, j7);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j6) throws IOException {
            if (DFUProcessor.this.f11650q == DFUProcessState.sendStart || DFUProcessor.this.f11650q == DFUProcessState.requestRand) {
                if (((int) (j6 / C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS)) <= 0) {
                    if (DFUProcessor.this.f11652s != null) {
                        DFUProcessor.this.f11652s.cancel();
                        DFUProcessor.this.f11652s = null;
                    }
                    DFUProcessor.this.y();
                    return;
                }
                DFUProcessor.this.f11650q = DFUProcessState.requestRand;
                f4.b.f("DFU state down ble_rand", new Object[0]);
                b4.a.c0(DFUProcessor.this.f11647n, "down ble_rand\r".getBytes(StandardCharsets.UTF_8));
            }
        }
    }

    public class d extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f11663a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(long j6, long j7, byte[] bArr) {
            super(j6, j7);
            this.f11663a = bArr;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j6) throws IOException {
            if (DFUProcessor.this.f11650q == DFUProcessState.requestRand || DFUProcessor.this.f11650q == DFUProcessState.sendRand) {
                if (((int) (j6 / C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS)) <= 0) {
                    if (DFUProcessor.this.f11653t != null) {
                        DFUProcessor.this.f11653t.cancel();
                        DFUProcessor.this.f11653t = null;
                    }
                    DFUProcessor.this.y();
                    return;
                }
                DFUProcessor.this.f11650q = DFUProcessState.sendRand;
                byte[] bytes = "down ble_key \r".getBytes(StandardCharsets.UTF_8);
                byte[] bArrK = com.uz.navee.utils.f.k(bytes, this.f11663a, bytes.length - 1);
                f4.b.f("DFU ble key: " + com.uz.navee.utils.f.c(this.f11663a), new Object[0]);
                f4.b.f("DFU state down ble_key " + com.uz.navee.utils.f.c(bytes), new Object[0]);
                b4.a.c0(DFUProcessor.this.f11647n, bArrK);
            }
        }
    }

    public class e extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int[] f11665a;

        public e(int[] iArr) {
            this.f11665a = iArr;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int[] iArr = this.f11665a;
            int i6 = iArr[0] - 1;
            iArr[0] = i6;
            if (i6 > 0) {
                b4.a.c0(DFUProcessor.this.f11647n, new byte[]{4});
            } else if (DFUProcessor.this.f11655v != null) {
                DFUProcessor.this.f11655v.cancel();
                DFUProcessor.this.f11655v = null;
            }
        }
    }

    public class f extends TimerTask {
        public f() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() throws IOException {
            DFUProcessor.this.y();
        }
    }

    public class g extends TimerTask {
        public g() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() throws IOException {
            DFUProcessor.this.y();
        }
    }

    public DFUProcessor(BleDevice bleDevice, String str, DFUMcuType dFUMcuType) {
        this.f11647n = bleDevice;
        this.f11648o = str;
        this.f11649p = dFUMcuType;
    }

    public boolean A() {
        return this.f11658y;
    }

    public final /* synthetic */ void B(byte[] bArr, int i6) throws IOException {
        int i7 = bArr[0] & UnsignedBytes.MAX_VALUE;
        if (i7 != 6) {
            if (i7 != 21) {
                if (i7 == 67 && this.f11650q == DFUProcessState.xmodemReady) {
                    this.f11641h = true;
                    F();
                    return;
                }
                return;
            }
            DFUProcessState dFUProcessState = this.f11650q;
            if (dFUProcessState == DFUProcessState.xmodemSendPack) {
                this.f11640g++;
                this.f11650q = DFUProcessState.xmodemSendPackFailure;
                this.f11641h = true;
                return;
            } else {
                if (dFUProcessState == DFUProcessState.xmodemSendEOT) {
                    this.f11640g++;
                    this.f11641h = true;
                    return;
                }
                return;
            }
        }
        DFUProcessState dFUProcessState2 = this.f11650q;
        if (dFUProcessState2 != DFUProcessState.xmodemSendPackWaiting) {
            if (dFUProcessState2 == DFUProcessState.xmodemSendEOT) {
                this.f11641h = true;
                Timer timer = this.f11655v;
                if (timer != null) {
                    timer.cancel();
                    this.f11655v = null;
                }
                f4.b.f("ACK EOT", new Object[0]);
                return;
            }
            return;
        }
        if (i6 == 2) {
            Timer timer2 = this.f11654u;
            if (timer2 != null) {
                timer2.cancel();
                this.f11654u = null;
            }
            int i8 = ((bArr[1] & UnsignedBytes.MAX_VALUE) + 1) % 256;
            if (i8 == 0) {
                i8++;
            }
            if (i8 == this.f11642i) {
                this.f11657x.a(this, this.f11644k);
                this.f11641h = true;
                this.f11650q = DFUProcessState.xmodemSendPackSuccess;
                f4.b.f("ACK " + i8, new Object[0]);
            }
        }
    }

    public final void C(final byte[] bArr) throws IOException {
        byte[] bArrG;
        final int length = bArr.length;
        if (length <= 2) {
            f4.b.f("dfu data: " + com.uz.navee.utils.f.c(bArr), new Object[0]);
            new Thread(new Runnable() { // from class: c4.d
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    this.f2042a.B(bArr, length);
                }
            }).start();
            return;
        }
        if (length > 4 && bArr[0] == 111 && bArr[1] == 107 && bArr[2] == 32) {
            int i6 = length - 1;
            if (bArr[i6] == 13) {
                f4.b.f("dfu data: " + com.uz.navee.utils.f.c(bArr), new Object[0]);
                if (this.f11650q == DFUProcessState.requestRand) {
                    try {
                        CountDownTimer countDownTimer = this.f11652s;
                        if (countDownTimer != null) {
                            countDownTimer.cancel();
                            this.f11652s = null;
                        }
                        int iC = b4.a.C();
                        if (length <= 20) {
                            bArrG = com.uz.navee.utils.f.f(Arrays.copyOfRange(bArr, 3, i6), b4.a.f1923l[iC]);
                        } else {
                            byte b7 = bArr[3];
                            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 4, i6);
                            bArrG = b7 == 0 ? com.uz.navee.utils.f.g(bArrCopyOfRange, b4.a.f1923l[iC]) : com.uz.navee.utils.f.f(bArrCopyOfRange, b4.a.f1923l[iC]);
                        }
                        G(bArrG);
                        return;
                    } catch (Exception e7) {
                        throw new RuntimeException(e7);
                    }
                }
                return;
            }
        }
        String str = new String(bArr, StandardCharsets.UTF_8);
        if (str.equals("ok\r")) {
            f4.b.f("dfu result: " + str + "\n dfu data: " + com.uz.navee.utils.f.c(bArr), new Object[0]);
            DFUProcessState dFUProcessState = this.f11650q;
            if (dFUProcessState == DFUProcessState.sendStart) {
                CountDownTimer countDownTimer2 = this.f11651r;
                if (countDownTimer2 != null) {
                    countDownTimer2.cancel();
                    this.f11651r = null;
                }
                D();
                return;
            }
            if (dFUProcessState == DFUProcessState.sendRand) {
                CountDownTimer countDownTimer3 = this.f11653t;
                if (countDownTimer3 != null) {
                    countDownTimer3.cancel();
                    this.f11653t = null;
                }
                this.f11650q = DFUProcessState.xmodemReady;
                f4.b.f("DFU state xmodemReady", new Object[0]);
                return;
            }
            return;
        }
        if (str.equals("rsq dfu_ok\r")) {
            f4.b.f("dfu result: " + str + "\n dfu data: " + com.uz.navee.utils.f.c(bArr), new Object[0]);
            if (this.f11650q == DFUProcessState.xmodemFinished) {
                Timer timer = this.f11656w;
                if (timer != null) {
                    timer.cancel();
                    this.f11656w = null;
                }
                Timer timer2 = this.f11655v;
                if (timer2 != null) {
                    timer2.cancel();
                    this.f11655v = null;
                }
                z();
                return;
            }
            return;
        }
        if (str.equals("rsq dfu_error\r")) {
            f4.b.f("dfu result: " + str + "\n dfu data: " + com.uz.navee.utils.f.c(bArr), new Object[0]);
            if (this.f11650q == DFUProcessState.xmodemFinished) {
                Timer timer3 = this.f11656w;
                if (timer3 != null) {
                    timer3.cancel();
                    this.f11656w = null;
                }
                Timer timer4 = this.f11655v;
                if (timer4 != null) {
                    timer4.cancel();
                    this.f11655v = null;
                }
                y();
            }
        }
    }

    public final void D() {
        c cVar = new c(6 * C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        this.f11652s = cVar;
        cVar.start();
    }

    public final void E() {
        Timer timer = new Timer();
        this.f11655v = timer;
        timer.schedule(new e(new int[]{5}), 0L, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }

    public final void F() throws IOException {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                this.f11639f = new DataInputStream(Files.newInputStream(Paths.get(this.f11648o, new String[0]), new OpenOption[0]));
            } catch (IOException e7) {
                throw new RuntimeException(e7);
            }
        } else {
            try {
                this.f11639f = new DataInputStream(new FileInputStream(this.f11648o));
            } catch (FileNotFoundException e8) {
                throw new RuntimeException(e8);
            }
        }
        p0.a.n().i(this.f11647n).getService(UUID.fromString("0000d0ff-3c17-d293-8e48-14fe2e4da212")).getCharacteristic(UUID.fromString("0000b002-0000-1000-8000-00805f9b34fb")).setWriteType(1);
        byte[] bArr = new byte[128];
        this.f11642i = 1;
        this.f11643j = 1;
        while (true) {
            try {
                int i6 = this.f11639f.read(bArr);
                if (i6 <= 0) {
                    try {
                        this.f11639f.close();
                        this.f11650q = DFUProcessState.xmodemSendEOT;
                        this.f11640g = 0;
                        boolean z6 = false;
                        while (this.f11640g < 10 && !z6) {
                            if (this.f11641h || this.f11658y) {
                                if (this.f11658y) {
                                    return;
                                }
                                this.f11641h = false;
                                E();
                                z6 = true;
                            }
                        }
                        this.f11641h = true;
                        if (!z6 || this.f11658y) {
                            return;
                        }
                        f4.b.f("success send mcu " + this.f11649p, new Object[0]);
                        this.f11650q = DFUProcessState.xmodemFinished;
                        u();
                        return;
                    } catch (IOException e9) {
                        throw new RuntimeException(e9);
                    }
                }
                if (i6 < 128) {
                    for (int i7 = i6; i7 < 128; i7++) {
                        bArr[i7] = Ascii.SUB;
                    }
                }
                this.f11644k = i6;
                int i8 = this.f11642i;
                byte[] bArrA = com.uz.navee.utils.f.a(com.uz.navee.utils.f.a(new byte[]{1, (byte) (i8 & 255), (byte) ((~i8) & 255)}, bArr), com.uz.navee.utils.f.l(x(bArr, 128)));
                this.f11640g = 0;
                f4.b.f("start send mcu " + this.f11649p + " blockNumber: " + this.f11642i, new Object[0]);
                this.f11650q = DFUProcessState.xmodemSendPackWaiting;
                boolean z7 = false;
                while (this.f11640g < 10 && !z7) {
                    if (this.f11641h || this.f11658y) {
                        this.f11641h = false;
                        if (this.f11658y) {
                            return;
                        }
                        v();
                        this.f11650q = DFUProcessState.xmodemSendPackSending;
                        f4.b.f("send block_" + this.f11642i + " " + bArrA.length + " bytes: " + com.uz.navee.utils.f.c(bArrA), new Object[0]);
                        b4.a.c0(this.f11647n, bArrA);
                        z7 = true;
                    }
                }
                int i9 = (this.f11642i + 1) % 256;
                this.f11642i = i9;
                if (i9 == 0) {
                    this.f11642i = i9 + 1;
                    this.f11643j++;
                }
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    public final void G(byte[] bArr) {
        d dVar = new d(6 * C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, bArr);
        this.f11653t = dVar;
        dVar.start();
    }

    public final void H(String str) throws IOException {
        this.f11650q = DFUProcessState.sendStart;
        b4.a.c0(this.f11647n, str.getBytes(StandardCharsets.UTF_8));
        f4.b.f("DFU state " + str, new Object[0]);
    }

    @Override // com.uz.navee.utils.h
    public void a() throws IOException {
        super.a();
        b();
        this.f11658y = false;
        LocalBroadcastManager.getInstance(MyApplication.b()).registerReceiver(this.f11659z, new IntentFilter("BleDeviceNotifyNotification"));
        w();
        this.f11651r.start();
    }

    @Override // com.uz.navee.utils.h
    public void b() throws IOException {
        super.b();
        this.f11658y = true;
        try {
            DataInputStream dataInputStream = this.f11639f;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            this.f11641h = false;
            this.f11650q = DFUProcessState.none;
            CountDownTimer countDownTimer = this.f11651r;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.f11651r = null;
            }
            CountDownTimer countDownTimer2 = this.f11652s;
            if (countDownTimer2 != null) {
                countDownTimer2.cancel();
                this.f11652s = null;
            }
            CountDownTimer countDownTimer3 = this.f11653t;
            if (countDownTimer3 != null) {
                countDownTimer3.cancel();
                this.f11653t = null;
            }
            Timer timer = this.f11654u;
            if (timer != null) {
                timer.cancel();
                this.f11654u = null;
            }
            Timer timer2 = this.f11655v;
            if (timer2 != null) {
                timer2.cancel();
                this.f11655v = null;
            }
            Timer timer3 = this.f11656w;
            if (timer3 != null) {
                timer3.cancel();
                this.f11656w = null;
            }
            LocalBroadcastManager.getInstance(MyApplication.b()).unregisterReceiver(this.f11659z);
        } catch (IOException e7) {
            throw new RuntimeException(e7);
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        b();
    }

    public final void u() {
        Timer timer = this.f11656w;
        if (timer != null) {
            timer.cancel();
            this.f11656w = null;
        }
        Timer timer2 = new Timer();
        this.f11656w = timer2;
        timer2.schedule(new g(), C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }

    public final void v() {
        Timer timer = this.f11654u;
        if (timer != null) {
            timer.cancel();
            this.f11654u = null;
        }
        Timer timer2 = new Timer();
        this.f11654u = timer2;
        timer2.schedule(new f(), C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }

    public final void w() {
        this.f11651r = new b(11 * C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }

    public final int x(byte[] bArr, int i6) {
        int i7 = 0;
        for (byte b7 : bArr) {
            i7 ^= b7 << 8;
            for (int i8 = 0; i8 < 8; i8++) {
                int i9 = 32768 & i7;
                int i10 = i7 << 1;
                if (i9 > 0) {
                    i10 ^= 4129;
                }
                i7 = i10 & 65535;
            }
        }
        return i7;
    }

    public final void y() throws IOException {
        this.f11650q = DFUProcessState.failure;
        b();
        this.f11657x.b(this, Boolean.FALSE);
        f4.b.f("DFU state failure", new Object[0]);
    }

    public final void z() throws IOException {
        this.f11650q = DFUProcessState.success;
        this.f11657x.b(this, Boolean.TRUE);
        f4.b.f("DFU state success", new Object[0]);
    }
}
