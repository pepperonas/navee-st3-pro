package b4;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.media3.extractor.ts.TsExtractor;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.exception.BleException;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.uz.navee.MyApplication;
import com.uz.navee.bean.DeviceBatteryInfo;
import com.uz.navee.bean.DeviceCarInfo;
import com.uz.navee.bean.DeviceHomePageInfo;
import com.uz.navee.bean.DeviceSubPageInfo;
import com.uz.navee.bean.DriveHistory;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.bean.VehicleModel;
import com.uz.navee.bean.WarnConfig;
import com.uz.navee.ble.AreaCode;
import com.uz.navee.ble.SKUVersion;
import com.uz.navee.ui.device.DeviceBindActivity;
import com.uz.navee.ui.device.DeviceFirmwareUpdateActivity;
import com.uz.navee.ui.device.DeviceListActivity;
import com.uz.navee.utils.g0;
import g4.e1;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: l, reason: collision with root package name */
    public static final byte[][] f1923l = {new byte[]{-96, -95, -94, -93, -92, -91, -90, -89, -88, -87, -86, -85, -84, -83, -82, -81}, new byte[]{68, 109, Ascii.DLE, 114, 109, -66, 5, -10, 98, -33, -86, -16, 19, 39, 48, 63}, new byte[]{-94, -123, -52, -20, -127, 79, -23, 97, 116, 41, -107, -24, -21, -87, 34, 71}, new byte[]{63, -18, UnsignedBytes.MAX_POWER_OF_TWO, -1, -106, -33, 92, -11, 66, -22, -84, -109, 40, Ascii.US, -27, 41}, new byte[]{78, -76, -44, 100, -42, -17, 83, -19, 108, -23, 69, 88, -34, -102, 94, -29}};

    /* renamed from: m, reason: collision with root package name */
    public static final String f1924m = com.uz.navee.utils.d.r() + ".BleVehicleModelsKey";

    /* renamed from: n, reason: collision with root package name */
    public static final String f1925n = com.uz.navee.utils.d.r() + ".BleBoundVehiclesKey";

    /* renamed from: o, reason: collision with root package name */
    public static final String f1926o = com.uz.navee.utils.d.r() + ".BleRecentMacAddressKey";

    /* renamed from: p, reason: collision with root package name */
    public static final String f1927p = com.uz.navee.utils.d.r() + ".BleTyreSettingDateKey";

    /* renamed from: a, reason: collision with root package name */
    public int f1928a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1929b;

    /* renamed from: c, reason: collision with root package name */
    public int f1930c;

    /* renamed from: d, reason: collision with root package name */
    public DeviceHomePageInfo f1931d;

    /* renamed from: e, reason: collision with root package name */
    public DeviceSubPageInfo f1932e;

    /* renamed from: f, reason: collision with root package name */
    public DeviceCarInfo f1933f;

    /* renamed from: g, reason: collision with root package name */
    public DeviceBatteryInfo f1934g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f1935h;

    /* renamed from: i, reason: collision with root package name */
    public Consumer f1936i;

    /* renamed from: j, reason: collision with root package name */
    public Timer f1937j;

    /* renamed from: k, reason: collision with root package name */
    public final long f1938k;

    /* renamed from: b4.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0018a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1939a;

        static {
            int[] iArr = new int[AreaCode.values().length];
            f1939a = iArr;
            try {
                iArr[AreaCode.IT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1939a[AreaCode.DE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1939a[AreaCode.NE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1939a[AreaCode.US.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1939a[AreaCode.CN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1939a[AreaCode.RU.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public class b extends q0.i {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BleDevice f1940c;

        public b(BleDevice bleDevice) {
            this.f1940c = bleDevice;
        }

        @Override // q0.i
        public void e(BleException bleException) throws IOException {
            f4.b.f("Write failure: " + bleException.toString(), new Object[0]);
            if (bleException.getCode() == 102 && Objects.equals(bleException.getDescription(), "This device not connect!")) {
                Intent intent = new Intent("BleReconnectNotification");
                intent.putExtra("bleDevice", this.f1940c);
                LocalBroadcastManager.getInstance(MyApplication.b()).sendBroadcast(intent);
            }
        }

        @Override // q0.i
        public void f(int i6, int i7, byte[] bArr) throws IOException {
            f4.b.f("Write success: " + com.uz.navee.utils.f.c(bArr), new Object[0]);
        }
    }

    public class c extends q0.c {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BleDevice f1941c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f1942d;

        public c(BleDevice bleDevice, Context context) {
            this.f1941c = bleDevice;
            this.f1942d = context;
        }

        @Override // q0.c
        public void e(int i6) throws InterruptedException, IOException {
            f4.b.f("setMTUSuccess: mtu = " + i6, new Object[0]);
            a.d(this.f1941c, this.f1942d);
        }

        @Override // q0.c
        public void f(BleException bleException) throws IOException {
            f4.b.f("SetMTUFailure: " + bleException.getDescription(), new Object[0]);
            Intent intent = new Intent("BleReconnectNotification");
            intent.putExtra("bleDevice", this.f1941c);
            LocalBroadcastManager.getInstance(this.f1942d).sendBroadcast(intent);
        }
    }

    public class d extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BleDevice f1943a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f1944b;

        public d(BleDevice bleDevice, Context context) {
            this.f1943a = bleDevice;
            this.f1944b = context;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() throws IOException {
            f4.b.f("reconnect after no notify in 3s", new Object[0]);
            Intent intent = new Intent("BleReconnectNotification");
            intent.putExtra("bleDevice", this.f1943a);
            LocalBroadcastManager.getInstance(this.f1944b).sendBroadcast(intent);
        }
    }

    public class e extends q0.d {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BleDevice f1946c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f1947d;

        public e(BleDevice bleDevice, Context context) {
            this.f1946c = bleDevice;
            this.f1947d = context;
        }

        @Override // q0.d
        public void e(byte[] bArr) throws InterruptedException, IOException {
            byte[] bArrG;
            String str;
            int iJ;
            String str2 = "副页信息上报";
            Intent intent = new Intent("BleDeviceNotifyNotification");
            intent.putExtra("data", bArr);
            LocalBroadcastManager.getInstance(this.f1947d).sendBroadcast(intent);
            if (bArr.length >= 9 && bArr[0] == 85 && bArr[1] == -86 && bArr[bArr.length - 1] == -3 && bArr[bArr.length - 2] == -2) {
                int i6 = bArr[4] & 255;
                int i7 = bArr[5] & UnsignedBytes.MAX_VALUE;
                int i8 = i6 - 1;
                byte[] bArrCopyOf = new byte[i8];
                int i9 = i6 + 6;
                int i10 = i6 + 5;
                byte b7 = bArr[i10];
                if (bArr.length > i9) {
                    bArrCopyOf = Arrays.copyOfRange(bArr, 6, i10);
                }
                String str3 = "Data length: " + i6 + "\nError: " + i7 + "\nUpdate Data: " + com.uz.navee.utils.f.c(bArrCopyOf) + "\nCheckSum: " + Long.toString(b7 & 4294967295L, 16) + "\n";
                int i11 = bArr[3] & UnsignedBytes.MAX_VALUE;
                if (i11 == 48) {
                    if (i7 != 0) {
                        Intent intent2 = new Intent("BleAuthCallbackNotification");
                        intent2.putExtra("bleDevice", this.f1946c);
                        intent2.putExtra("errorCode", i7);
                        LocalBroadcastManager.getInstance(this.f1947d).sendBroadcast(intent2);
                    } else if (i6 > 1) {
                        try {
                            Thread.sleep(200L);
                            int iC = a.C();
                            if (i6 <= 17) {
                                bArrG = com.uz.navee.utils.f.f(bArrCopyOf, a.f1923l[iC]);
                            } else {
                                int i12 = bArrCopyOf[0] & UnsignedBytes.MAX_VALUE;
                                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrCopyOf, 1, i8);
                                bArrG = i12 == 0 ? com.uz.navee.utils.f.g(bArrCopyOfRange, a.f1923l[iC]) : com.uz.navee.utils.f.f(bArrCopyOfRange, a.f1923l[iC]);
                            }
                            a.c0(this.f1946c, a.p(bArrG));
                        } catch (Exception e7) {
                            throw new RuntimeException(e7);
                        }
                    } else {
                        Intent intent3 = new Intent("BleAuthCallbackNotification");
                        intent3.putExtra("bleDevice", this.f1946c);
                        intent3.putExtra("errorCode", i7);
                        LocalBroadcastManager.getInstance(this.f1947d).sendBroadcast(intent3);
                        a.c0(this.f1946c, a.l(111, ByteBuffer.allocate(5).put((byte) 6).put(com.uz.navee.utils.f.o(System.currentTimeMillis() / 1000, true), 4, 4).array(), false));
                    }
                    str2 = "下发身份信息";
                } else if (i11 == 49) {
                    if (i7 == 0) {
                        try {
                            Thread.sleep(100L);
                            a.d0(this.f1946c);
                        } catch (InterruptedException e8) {
                            throw new RuntimeException(e8);
                        }
                    } else {
                        Intent intent4 = new Intent("BleAuthCallbackNotification");
                        intent4.putExtra("bleDevice", this.f1946c);
                        intent4.putExtra("errorCode", i7);
                        LocalBroadcastManager.getInstance(this.f1947d).sendBroadcast(intent4);
                    }
                    str2 = "下发加密数";
                } else if (i11 == 89) {
                    str2 = "还原车辆";
                } else if (i11 == 90) {
                    a.G(this.f1946c);
                    str2 = "轮胎保养";
                } else if (i11 == 99) {
                    a.K(this.f1946c);
                    Intent intent5 = new Intent("BleSetPasswordNotification");
                    intent5.putExtra("bleDevice", this.f1946c);
                    intent5.putExtra("errorCode", i7);
                    LocalBroadcastManager.getInstance(this.f1947d).sendBroadcast(intent5);
                    str2 = "设置数字密码";
                } else if (i11 == 102) {
                    a.G(this.f1946c);
                    str2 = "设置高尔夫球车档位";
                } else if (i11 == 121) {
                    if (i7 == 0) {
                        a.W().f1934g.setTemperatureState(com.uz.navee.utils.f.j(bArrCopyOf, 0, 1, false));
                        a.W().f1934g.setCurrentState(com.uz.navee.utils.f.j(bArrCopyOf, 1, 1, false));
                        Intent intent6 = new Intent("BleReadBatterySuccessNotification");
                        intent6.putExtra("bleDevice", this.f1946c);
                        LocalBroadcastManager.getInstance(this.f1947d).sendBroadcast(intent6);
                    }
                    str2 = "读取电池额外信息";
                } else if (i11 == 122) {
                    Intent intent7 = new Intent("BleReadPasswordNotification");
                    intent7.putExtra("bleDevice", this.f1946c);
                    intent7.putExtra("errorCode", i7);
                    if (i7 == 0) {
                        intent7.putExtra("values", bArrCopyOf);
                    }
                    LocalBroadcastManager.getInstance(this.f1947d).sendBroadcast(intent7);
                    str2 = "读取数字密码和开关状态";
                } else if (i11 == 128) {
                    if (a.W().f1936i != null) {
                        a.W().f1936i.accept(Boolean.valueOf(i7 == 0));
                    }
                    a.G(this.f1946c);
                    str2 = "更新天气";
                } else {
                    if (i11 != 129) {
                        switch (i11) {
                            case 80:
                                str2 = "解绑车辆";
                                break;
                            case 81:
                                Intent intent8 = new Intent("BleLockControlCarNotification");
                                intent8.putExtra("bleDevice", this.f1946c);
                                intent8.putExtra("errorCode", i7);
                                LocalBroadcastManager.getInstance(this.f1947d).sendBroadcast(intent8);
                                str2 = "车锁控制";
                                break;
                            case 82:
                                Intent intent9 = new Intent("BleCruiseControlNotification");
                                intent9.putExtra("bleDevice", this.f1946c);
                                intent9.putExtra("errorCode", i7);
                                LocalBroadcastManager.getInstance(this.f1947d).sendBroadcast(intent9);
                                str2 = "定速巡航";
                                break;
                            case 83:
                                a.G(this.f1946c);
                                str2 = "能量回收";
                                break;
                            case 84:
                                a.G(this.f1946c);
                                str2 = "车灯控制";
                                break;
                            case 85:
                                str2 = "里程单位";
                                break;
                            case 86:
                                str2 = "里程算法";
                                break;
                            case 87:
                                a.G(this.f1946c);
                                str2 = "光敏开关";
                                break;
                            default:
                                switch (i11) {
                                    case 94:
                                        a.G(this.f1946c);
                                        str2 = "氛围灯";
                                        break;
                                    case 95:
                                        a.G(this.f1946c);
                                        Intent intent10 = new Intent("BleTcsSwitchNotification");
                                        intent10.putExtra("bleDevice", this.f1946c);
                                        intent10.putExtra("errorCode", i7);
                                        LocalBroadcastManager.getInstance(this.f1947d).sendBroadcast(intent10);
                                        str2 = "TCS开关";
                                        break;
                                    case 96:
                                        a.G(this.f1946c);
                                        Intent intent11 = new Intent("BleTurnSoundSwitchNotification");
                                        intent11.putExtra("bleDevice", this.f1946c);
                                        intent11.putExtra("errorCode", i7);
                                        LocalBroadcastManager.getInstance(this.f1947d).sendBroadcast(intent11);
                                        str2 = "转向灯声音";
                                        break;
                                    case 97:
                                        a.G(this.f1946c);
                                        Intent intent12 = new Intent("BleProximityKeyNotification");
                                        intent12.putExtra("bleDevice", this.f1946c);
                                        intent12.putExtra("errorCode", i7);
                                        LocalBroadcastManager.getInstance(this.f1947d).sendBroadcast(intent12);
                                        str2 = "近场解锁开关";
                                        break;
                                    default:
                                        switch (i11) {
                                            case 106:
                                                a.G(this.f1946c);
                                                str2 = "启动速度";
                                                break;
                                            case 107:
                                                a.G(this.f1946c);
                                                str2 = "自定义限速";
                                                break;
                                            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                                                a.G(this.f1946c);
                                                str2 = "音效设置";
                                                break;
                                            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
                                                a.G(this.f1946c);
                                                str2 = "设置灯光";
                                                break;
                                            case 110:
                                                a.G(this.f1946c);
                                                str2 = "设置速度或模式";
                                                break;
                                            case 111:
                                                a.G(this.f1946c);
                                                str2 = "设置滑板车参数";
                                                break;
                                            case 112:
                                                if (i7 == 0) {
                                                    a.W().f1933f.setBindingStatus(com.uz.navee.utils.f.j(bArrCopyOf, 0, 1, false));
                                                    a.W().f1933f.setDrivingMode(com.uz.navee.utils.f.j(bArrCopyOf, 1, 1, false));
                                                    a.W().f1933f.setLockStatus(com.uz.navee.utils.f.j(bArrCopyOf, 2, 1, false));
                                                    a.W().f1933f.setCcsStatus(com.uz.navee.utils.f.j(bArrCopyOf, 3, 1, false));
                                                    a.W().f1933f.setTailIsOn(com.uz.navee.utils.f.j(bArrCopyOf, 4, 1, false));
                                                    a.W().f1933f.setErsStatus(com.uz.navee.utils.f.j(bArrCopyOf, 5, 1, false));
                                                    a.W().f1933f.setMileageAlgorithm(com.uz.navee.utils.f.j(bArrCopyOf, 6, 1, false));
                                                    a.W().f1933f.setMileageUnit(com.uz.navee.utils.f.j(bArrCopyOf, 7, 1, false));
                                                    a.W().f1933f.setAutoSensor(com.uz.navee.utils.f.j(bArrCopyOf, 8, 1, false));
                                                    a.W().f1933f.setTyreSwitch(com.uz.navee.utils.f.j(bArrCopyOf, 9, 1, false));
                                                    a.W().f1933f.setAmbientLight(com.uz.navee.utils.f.j(bArrCopyOf, 10, 1, false));
                                                    a.W().f1933f.setTcsSwitch(com.uz.navee.utils.f.j(bArrCopyOf, 11, 1, false));
                                                    a.W().f1933f.setTurnSound(com.uz.navee.utils.f.j(bArrCopyOf, 12, 1, false));
                                                    a.W().f1933f.setProximityKey(com.uz.navee.utils.f.j(bArrCopyOf, 13, 1, false));
                                                    a.W().f1933f.setNightMode(com.uz.navee.utils.f.j(bArrCopyOf, 14, 1, false));
                                                    a.W().f1933f.setMileageAlgorithmMode(com.uz.navee.utils.f.j(bArrCopyOf, 15, 1, false));
                                                    a.W().f1933f.setLightE(com.uz.navee.utils.f.j(bArrCopyOf, 16, 1, false));
                                                    a.W().f1933f.setLightD(com.uz.navee.utils.f.j(bArrCopyOf, 17, 1, false));
                                                    a.W().f1933f.setLightS(com.uz.navee.utils.f.j(bArrCopyOf, 18, 1, false));
                                                    a.W().f1933f.setStartSpeed(com.uz.navee.utils.f.j(bArrCopyOf, 19, 1, false));
                                                    a.W().f1933f.setLimitSpeed(com.uz.navee.utils.f.j(bArrCopyOf, 20, 1, false));
                                                    a.W().f1933f.setVolume(com.uz.navee.utils.f.j(bArrCopyOf, 21, 1, false));
                                                    a.W().f1933f.setReportLanguage(com.uz.navee.utils.f.j(bArrCopyOf, 22, 1, false));
                                                    a.W().f1933f.setLogoLight(com.uz.navee.utils.f.j(bArrCopyOf, 23, 1, false));
                                                    a.W().f1933f.setDayRunLight(com.uz.navee.utils.f.j(bArrCopyOf, 24, 1, false));
                                                    a.W().f1933f.setMaxSpeed(com.uz.navee.utils.f.j(bArrCopyOf, 25, 1, false));
                                                    a.W().f1933f.setDriveMode(com.uz.navee.utils.f.j(bArrCopyOf, 26, 1, false));
                                                    a.W().f1933f.setStartChargeTime(com.uz.navee.utils.f.i(bArrCopyOf, 27, 4, true));
                                                    a.W().f1933f.setChargeLimit(com.uz.navee.utils.f.j(bArrCopyOf, 31, 1, false));
                                                    a.W().f1933f.setLowPower(com.uz.navee.utils.f.j(bArrCopyOf, 32, 1, false));
                                                    a.W().f1933f.setTimedChargeOn(com.uz.navee.utils.f.j(bArrCopyOf, 33, 1, false));
                                                    a.W().f1933f.setLockTime(com.uz.navee.utils.f.j(bArrCopyOf, 34, 1, false));
                                                    a.W().f1933f.setBreakSpeed(com.uz.navee.utils.f.j(bArrCopyOf, 35, 1, false));
                                                    a.W().f1933f.setWeather(com.uz.navee.utils.f.j(bArrCopyOf, 36, 1, false));
                                                    a.W().f1933f.setSlopeSup(com.uz.navee.utils.f.j(bArrCopyOf, 37, 1, false));
                                                    a.W().f1933f.setLongRange(com.uz.navee.utils.f.j(bArrCopyOf, 38, 1, false));
                                                }
                                                str2 = "读取车辆";
                                                break;
                                            case 113:
                                                str2 = "读取行驶";
                                                break;
                                            case 114:
                                                if (i7 == 0) {
                                                    a.W().f1934g.setBatteryStatus(com.uz.navee.utils.f.j(bArrCopyOf, 0, 1, false));
                                                    a.W().f1934g.setBatteryCharge(com.uz.navee.utils.f.j(bArrCopyOf, 1, 1, false));
                                                    a.W().f1934g.setBatteryVoltage(com.uz.navee.utils.f.j(bArrCopyOf, 2, 4, false));
                                                    a.W().f1934g.setBatteryCurrent(com.uz.navee.utils.f.j(bArrCopyOf, 6, 4, false));
                                                    a.W().f1934g.setBatteryHealth(com.uz.navee.utils.f.j(bArrCopyOf, 10, 1, false));
                                                    a.W().f1934g.setBatteryTemp(com.uz.navee.utils.f.j(bArrCopyOf, 11, 1, false));
                                                    a.W().f1934g.setChargingState(com.uz.navee.utils.f.j(bArrCopyOf, 12, 1, false));
                                                    a.W().f1934g.setChargeTimes(com.uz.navee.utils.f.j(bArrCopyOf, 13, 2, false));
                                                    a.W().f1934g.setEuropeanRule(bArrCopyOf.length > 15);
                                                    a.W().f1934g.setEnergyThroughput(com.uz.navee.utils.f.j(bArrCopyOf, 15, 3, true));
                                                    a.W().f1934g.setCapacityThroughput(com.uz.navee.utils.f.j(bArrCopyOf, 18, 2, true));
                                                    a.W().f1934g.setDeepDischarge(com.uz.navee.utils.f.j(bArrCopyOf, 20, 2, true));
                                                    a.W().f1934g.setSelfDischargeRate(com.uz.navee.utils.f.j(bArrCopyOf, 22, 1, false));
                                                    a.W().f1934g.setRatedCapacity(com.uz.navee.utils.f.j(bArrCopyOf, 23, 2, true));
                                                    a.W().f1934g.setGenerationDate(String.format(Locale.getDefault(), "20%02d-%02d-%02d", Integer.valueOf(com.uz.navee.utils.f.j(bArrCopyOf, 25, 1, false)), Integer.valueOf(com.uz.navee.utils.f.j(bArrCopyOf, 26, 1, false)), Integer.valueOf(com.uz.navee.utils.f.j(bArrCopyOf, 27, 1, false))));
                                                    int iJ2 = com.uz.navee.utils.f.j(bArrCopyOf, 28, 1, false);
                                                    int iJ3 = com.uz.navee.utils.f.j(bArrCopyOf, 29, 1, false);
                                                    int iJ4 = com.uz.navee.utils.f.j(bArrCopyOf, 30, 1, false);
                                                    int iJ5 = com.uz.navee.utils.f.j(bArrCopyOf, 31, 1, false);
                                                    int iJ6 = com.uz.navee.utils.f.j(bArrCopyOf, 32, 1, false);
                                                    com.uz.navee.utils.f.j(bArrCopyOf, 33, 1, false);
                                                    int i13 = (iJ2 * 8760) + (iJ3 * 720) + (iJ4 * 24) + iJ5;
                                                    a.W().f1934g.setHighTemperatureDuration(i13 > 0 ? String.format(Locale.getDefault(), "%d h %d min", Integer.valueOf(i13), Integer.valueOf(iJ6)) : String.format(Locale.getDefault(), "%d min", Integer.valueOf(iJ6)));
                                                    a.W().f1934g.setExtremeWeatherChargingTime(com.uz.navee.utils.f.j(bArrCopyOf, 34, 2, true));
                                                    Intent intent13 = new Intent("BleReadBatterySuccessNotification");
                                                    intent13.putExtra("bleDevice", this.f1946c);
                                                    LocalBroadcastManager.getInstance(this.f1947d).sendBroadcast(intent13);
                                                }
                                                str2 = "读取电池";
                                                break;
                                            case 115:
                                                if (i7 == 0) {
                                                    String strQ = bArrCopyOf.length >= 4 ? a.q(Arrays.copyOfRange(bArrCopyOf, 0, 4)) : "";
                                                    String strQ2 = bArrCopyOf.length >= 8 ? a.q(Arrays.copyOfRange(bArrCopyOf, 4, 8)) : "";
                                                    String strQ3 = bArrCopyOf.length >= 12 ? a.q(Arrays.copyOfRange(bArrCopyOf, 8, 12)) : "";
                                                    String strQ4 = bArrCopyOf.length >= 16 ? a.q(Arrays.copyOfRange(bArrCopyOf, 12, 16)) : "";
                                                    Intent intent14 = new Intent("BleReadFirmwareSuccessNotification");
                                                    intent14.putExtra("bleDevice", this.f1946c);
                                                    intent14.putExtra("meterVersion", strQ);
                                                    intent14.putExtra("bldcVersion", strQ2);
                                                    intent14.putExtra("bmsVersion", strQ3);
                                                    intent14.putExtra("screenVersion", strQ4);
                                                    LocalBroadcastManager.getInstance(this.f1947d).sendBroadcast(intent14);
                                                }
                                                str2 = "读取固件版本";
                                                break;
                                            case AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID /* 116 */:
                                                if (i7 == 0) {
                                                    if (bArrCopyOf.length > 17) {
                                                        bArrCopyOf = Arrays.copyOf(bArrCopyOf, 17);
                                                    }
                                                    String str4 = new String(bArrCopyOf, StandardCharsets.UTF_8);
                                                    Intent intent15 = new Intent("BleReadCarSNSuccessNotification");
                                                    intent15.putExtra("bleDevice", this.f1946c);
                                                    intent15.putExtra("carSN", str4);
                                                    LocalBroadcastManager.getInstance(this.f1947d).sendBroadcast(intent15);
                                                }
                                                str2 = "读取车辆SN";
                                                break;
                                            case 117:
                                                str2 = "读取电池SN";
                                                break;
                                            case 118:
                                                ArrayList arrayListO = a.o(bArrCopyOf);
                                                Intent intent16 = new Intent("BleReadDriveHistoryNotification");
                                                intent16.putExtra("bleDevice", this.f1946c);
                                                intent16.putExtra("errorCode", i7);
                                                intent16.putExtra("history", arrayListO);
                                                if (bArrCopyOf.length % 8 == 0) {
                                                    intent16.putExtra("version", 0);
                                                } else {
                                                    intent16.putExtra("version", bArrCopyOf[bArrCopyOf.length - 1] & UnsignedBytes.MAX_VALUE);
                                                }
                                                LocalBroadcastManager.getInstance(this.f1947d).sendBroadcast(intent16);
                                                str2 = "读取行驶记录";
                                                break;
                                            default:
                                                switch (i11) {
                                                    case 144:
                                                        a.W().R(this.f1946c, this.f1947d);
                                                        if (i7 == 0) {
                                                            a.W().f1931d.setWarningCode(com.uz.navee.utils.f.j(bArrCopyOf, 0, 1, false));
                                                            a.W().f1931d.setDrivingMode(com.uz.navee.utils.f.j(bArrCopyOf, 1, 1, false));
                                                            a.W().f1931d.setBatteryCharge(com.uz.navee.utils.f.j(bArrCopyOf, 2, 1, false));
                                                            a.W().f1931d.setBatteryStatus(com.uz.navee.utils.f.j(bArrCopyOf, 3, 1, false));
                                                            a.W().f1931d.setChargingState(com.uz.navee.utils.f.j(bArrCopyOf, 4, 1, false));
                                                            a.W().f1931d.setLockPushWarn(com.uz.navee.utils.f.j(bArrCopyOf, 5, 1, false));
                                                            a.W().f1931d.setRemainMileage(com.uz.navee.utils.f.j(bArrCopyOf, 6, 1, false));
                                                            int iJ7 = com.uz.navee.utils.f.j(bArrCopyOf, 7, 1, false);
                                                            if (iJ7 > 0) {
                                                                a.W().f1931d.setLockStatus(iJ7 - 1);
                                                            }
                                                            if (bArrCopyOf.length >= 16) {
                                                                int iJ8 = com.uz.navee.utils.f.j(bArrCopyOf, 8, 4, false);
                                                                if (iJ8 > 0) {
                                                                    a.W().f1931d.setBatteryVoltage(iJ8);
                                                                }
                                                                int iJ9 = com.uz.navee.utils.f.j(bArrCopyOf, 12, 4, false);
                                                                if (iJ9 > 0) {
                                                                    a.W().f1931d.setBatteryCurrent(iJ9);
                                                                }
                                                                a.W().f1931d.setHideE9(com.uz.navee.utils.f.j(bArrCopyOf, 14, 1, false));
                                                            }
                                                        }
                                                        str2 = "首页信息上报";
                                                        break;
                                                    case 145:
                                                        if (i7 == 0) {
                                                            a.W().f1932e.setVersion(0);
                                                            a.W().f1932e.setBatteryCharge(com.uz.navee.utils.f.j(bArrCopyOf, 0, 1, false));
                                                            a.W().f1932e.setDrivingStatus(com.uz.navee.utils.f.j(bArrCopyOf, 1, 1, false));
                                                            a.W().f1932e.setRealTimeSpeed(com.uz.navee.utils.f.j(bArrCopyOf, 2, 1, false));
                                                            a.W().f1932e.setRemainMileage(com.uz.navee.utils.f.j(bArrCopyOf, 3, 1, false));
                                                            a.W().f1932e.setDrivingMileage(com.uz.navee.utils.f.j(bArrCopyOf, 4, 1, false));
                                                            a.W().f1932e.setDrivingDuration(com.uz.navee.utils.f.j(bArrCopyOf, 5, 1, false));
                                                            a.W().f1932e.setMaximumSpeed(com.uz.navee.utils.f.j(bArrCopyOf, 6, 1, false));
                                                            a.W().f1932e.setAverageSpeed(com.uz.navee.utils.f.j(bArrCopyOf, 7, 1, false));
                                                            a.W().f1932e.setTotalMileage(com.uz.navee.utils.f.j(bArrCopyOf, 8, 1, false));
                                                            break;
                                                        }
                                                        break;
                                                    case 146:
                                                        if (i7 == 0) {
                                                            a.W().f1932e.setVersion(1);
                                                            a.W().f1932e.setBatteryCharge(com.uz.navee.utils.f.j(bArrCopyOf, 0, 1, false));
                                                            a.W().f1932e.setDrivingStatus(com.uz.navee.utils.f.j(bArrCopyOf, 1, 1, false));
                                                            a.W().f1932e.setRealTimeSpeed(com.uz.navee.utils.f.j(bArrCopyOf, 2, 2, false));
                                                            a.W().f1932e.setRemainMileage(com.uz.navee.utils.f.j(bArrCopyOf, 4, 1, false));
                                                            a.W().f1932e.setDrivingMileage(com.uz.navee.utils.f.j(bArrCopyOf, 5, 2, false));
                                                            a.W().f1932e.setDrivingDuration(com.uz.navee.utils.f.j(bArrCopyOf, 7, 1, false));
                                                            a.W().f1932e.setMaximumSpeed(com.uz.navee.utils.f.j(bArrCopyOf, 8, 2, false));
                                                            a.W().f1932e.setAverageSpeed(com.uz.navee.utils.f.j(bArrCopyOf, 10, 2, false));
                                                            a.W().f1932e.setTotalMileage(com.uz.navee.utils.f.j(bArrCopyOf, 12, 2, false));
                                                            if (bArrCopyOf.length >= 18 && (iJ = com.uz.navee.utils.f.j(bArrCopyOf, 14, 4, false)) > 0) {
                                                                a.W().f1932e.setTotalMileage(iJ);
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    default:
                                                        str = "";
                                                        break;
                                                }
                                        }
                                }
                        }
                        if (i11 != 144 || i11 == 145 || i11 == 146) {
                            return;
                        }
                        f4.b.f(str + " " + str3, new Object[0]);
                        return;
                    }
                    a.G(this.f1946c);
                    str2 = "坡度辅助";
                }
                str = str2;
                if (i11 != 144) {
                }
            }
        }

        @Override // q0.d
        public void f(BleException bleException) throws IOException {
            f4.b.f("Notify failure: " + bleException.getDescription(), new Object[0]);
        }

        @Override // q0.d
        public void g() throws InterruptedException, IOException {
            f4.b.f("Notify success", new Object[0]);
            try {
                Thread.sleep(100L);
                a.d0(this.f1946c);
            } catch (InterruptedException e7) {
                throw new RuntimeException(e7);
            }
        }
    }

    public class f extends TypeToken<ArrayList<Vehicle>> {
    }

    public class g extends TypeToken<ArrayList<VehicleModel>> {
    }

    public class h extends TypeToken<HashMap<String, String>> {
    }

    public class i extends TypeToken<HashMap<String, String>> {
    }

    public class j extends TypeToken<HashMap<String, String>> {
    }

    public static class k {

        /* renamed from: a, reason: collision with root package name */
        public static final a f1948a = new a();
    }

    public static boolean A(String str) {
        ArrayList arrayListE = e();
        int i6 = 0;
        while (i6 < arrayListE.size()) {
            if (((Vehicle) arrayListE.get(i6)).mac.equals(str)) {
                return i6 >= 0;
            }
            i6++;
        }
        return false;
    }

    public static Boolean B(String str) {
        return str == null ? Boolean.FALSE : Boolean.valueOf(str.matches("([\\dA-Fa-f]{2}[:-]){5}[\\dA-Fa-f]{2}"));
    }

    public static int C() {
        int i6 = W().f1928a;
        if (i6 < 0 || i6 > 4) {
            return 0;
        }
        return i6;
    }

    public static void D(BleDevice bleDevice, Context context) {
        p0.a.n().A(bleDevice, "0000d0ff-3c17-d293-8e48-14fe2e4da212", "0000b003-0000-1000-8000-00805f9b34fb", new e(bleDevice, context));
    }

    public static int E(int i6, int i7) {
        return new SecureRandom().nextInt((i7 - i6) + 1) + i6;
    }

    public static void F(BleDevice bleDevice) {
        c0(bleDevice, j(114, false));
    }

    public static void G(BleDevice bleDevice) {
        c0(bleDevice, j(112, false));
    }

    public static void H(BleDevice bleDevice) {
        c0(bleDevice, j(AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID, false));
    }

    public static void I(BleDevice bleDevice) {
        c0(bleDevice, j(115, false));
    }

    public static void J(BleDevice bleDevice) {
        c0(bleDevice, j(118, false));
    }

    public static void K(BleDevice bleDevice) {
        c0(bleDevice, j(ModuleDescriptor.MODULE_VERSION, false));
    }

    public static String L() {
        String strE = g0.e(f1926o, "");
        return B(strE).booleanValue() ? t(strE) : strE;
    }

    public static void M(List list) {
        g0.f(f1925n, new Gson().toJson(list));
    }

    public static void N(ArrayList arrayList) {
        g0.f(f1924m, new Gson().toJson(arrayList));
    }

    public static void O() {
        g0.g(f1925n);
    }

    public static void P(String str) {
        ArrayList arrayListE = e();
        int i6 = 0;
        while (true) {
            if (i6 >= arrayListE.size()) {
                i6 = -1;
                break;
            } else if (((Vehicle) arrayListE.get(i6)).mac.equals(str)) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 >= 0) {
            arrayListE.remove(i6);
            M(arrayListE);
        }
    }

    public static void Q() {
        g0.g(f1926o);
    }

    public static void S(String str) {
        g0.f(f1926o, str);
    }

    public static void T(String str, String str2, String str3) {
        String str4 = f1927p;
        String strE = g0.e(str4, "");
        HashMap map = new HashMap();
        if (!strE.isEmpty()) {
            map = (HashMap) new Gson().fromJson(strE, new h().getType());
        }
        map.put(str2, str + "_" + str3);
        g0.f(str4, new Gson().toJson(map));
    }

    public static void U(BleDevice bleDevice, Context context) {
        p0.a.n().G(bleDevice, 148, new c(bleDevice, context));
    }

    public static a W() {
        return k.f1948a;
    }

    public static SKUVersion X(AreaCode areaCode) {
        if (areaCode == null) {
            return SKUVersion.EUR;
        }
        switch (C0018a.f1939a[areaCode.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return SKUVersion.ITA;
            case 4:
            case 5:
            case 6:
                return SKUVersion.USA;
            default:
                return SKUVersion.EUR;
        }
    }

    public static void Y(BleDevice bleDevice) {
        p0.a.n().K(bleDevice, "0000d0ff-3c17-d293-8e48-14fe2e4da212", "0000b003-0000-1000-8000-00805f9b34fb");
    }

    public static int a0(byte[] bArr) {
        int i6 = 0;
        for (byte b7 : bArr) {
            i6 += b7;
        }
        return i6 & 255;
    }

    public static AreaCode b(Object obj) {
        if (obj instanceof String) {
            String strValueOf = String.valueOf(obj);
            if (h(strValueOf)) {
                try {
                    return AreaCode.valueOf(strValueOf.substring(8, 10));
                } catch (IllegalArgumentException unused) {
                }
            }
        }
        return null;
    }

    public static ArrayList b0() {
        String strE = g0.e(f1924m, "");
        return !strE.isEmpty() ? (ArrayList) new Gson().fromJson(strE, new g().getType()) : new ArrayList();
    }

    public static byte[] c(byte[] bArr, int i6, boolean z6) throws IOException {
        W().f1928a = E(0, 4);
        byte[] bArrB = com.uz.navee.utils.f.b(com.uz.navee.utils.f.a(new byte[]{85, -86, (byte) ((z6 ? 1 : 0) & 255), 48, (byte) ((bArr.length + 3) & 255), (byte) (W().f1928a & 255), (byte) (i6 & 255)}, bArr), (byte) 0);
        byte[] bArrA = com.uz.navee.utils.f.a(bArrB, new byte[]{(byte) (a0(bArrB) & 255), -2, -3});
        f4.b.f("Send authData: " + com.uz.navee.utils.f.c(bArrA), new Object[0]);
        return bArrA;
    }

    public static void c0(BleDevice bleDevice, byte[] bArr) {
        if (f(bleDevice)) {
            p0.a.n().M(bleDevice, "0000d0ff-3c17-d293-8e48-14fe2e4da212", "0000b002-0000-1000-8000-00805f9b34fb", bArr, false, new b(bleDevice));
        }
    }

    public static void d(BleDevice bleDevice, Context context) throws InterruptedException {
        try {
            Thread.sleep(100L);
            D(bleDevice, context);
        } catch (InterruptedException e7) {
            throw new RuntimeException(e7);
        }
    }

    public static void d0(BleDevice bleDevice) {
        long j6 = W().f1930c;
        if (j6 == 0) {
            j6 = e1.u().f13674b;
            if (j6 == 0) {
                e1.u().l();
                j6 = e1.u().f13674b;
            }
        }
        c0(bleDevice, c(com.uz.navee.utils.f.m(j6, TsExtractor.TS_STREAM_TYPE_DTS_HD), W().f1930c == 0 ? 0 : 1, false));
    }

    public static ArrayList e() {
        String strE = g0.e(f1925n, "");
        return !strE.isEmpty() ? (ArrayList) new Gson().fromJson(strE, new f().getType()) : new ArrayList();
    }

    public static boolean f(BleDevice bleDevice) {
        p0.a aVarN = p0.a.n();
        return (bleDevice == null || aVarN == null || aVarN.j() == null || !aVarN.x(bleDevice)) ? false : true;
    }

    public static void g(Activity activity, BleDevice bleDevice) throws IOException {
        if (activity != null && (W().f1933f.getProximityKey() & 1) == 1) {
            if (ContextCompat.checkSelfPermission(activity, "android.permission.BLUETOOTH_CONNECT") == -1) {
                if (Build.VERSION.SDK_INT >= 31) {
                    ActivityCompat.requestPermissions(activity, new String[]{"android.permission.BLUETOOTH_CONNECT"}, 308);
                    f4.b.f("Can`t create Bond with " + r(bleDevice) + "; BLUETOOTH_CONNECT permission denied", new Object[0]);
                    return;
                }
                if (MyApplication.f11588e.D(308) == -1) {
                    f4.b.f("Can`t create Bond with " + r(bleDevice) + "; Location permission denied", new Object[0]);
                    return;
                }
            }
            Set<BluetoothDevice> bondedDevices = p0.a.n().h().getBondedDevices();
            String mac = bleDevice.getMac();
            String strR = r(bleDevice);
            for (BluetoothDevice bluetoothDevice : bondedDevices) {
                if (Objects.equals(bluetoothDevice.getAddress(), mac) || Objects.equals(t(bluetoothDevice.getAddress()), strR)) {
                    return;
                }
            }
            c0(bleDevice, k(97, 0, false));
        }
    }

    public static boolean h(String str) {
        return str.matches("^[A-Za-z][A-Za-z\\d]{16}$");
    }

    public static void i(Activity activity, BleDevice bleDevice) throws IOException {
        if (activity != null && (W().f1933f.getProximityKey() & 1) == 1) {
            if (ContextCompat.checkSelfPermission(activity, "android.permission.BLUETOOTH_CONNECT") == -1) {
                if (Build.VERSION.SDK_INT >= 31) {
                    ActivityCompat.requestPermissions(activity, new String[]{"android.permission.BLUETOOTH_CONNECT"}, 307);
                    f4.b.f("Can`t create Bond with " + r(bleDevice) + "; BLUETOOTH_CONNECT permission denied", new Object[0]);
                    return;
                }
                if (MyApplication.f11588e.D(307) == -1) {
                    f4.b.f("Can`t create Bond with " + r(bleDevice) + "; Location permission denied", new Object[0]);
                    return;
                }
            }
            Set<BluetoothDevice> bondedDevices = p0.a.n().h().getBondedDevices();
            String mac = bleDevice.getMac();
            String strR = r(bleDevice);
            for (BluetoothDevice bluetoothDevice : bondedDevices) {
                if (Objects.equals(bluetoothDevice.getAddress(), mac) || Objects.equals(t(bluetoothDevice.getAddress()), strR)) {
                    return;
                }
            }
            f4.b.f("Create Bond (%s)", r(bleDevice));
            bleDevice.getDevice().createBond();
        }
    }

    public static byte[] j(int i6, boolean z6) throws IOException {
        byte[] bArr = {85, -86, (byte) ((z6 ? 1 : 0) & 255), (byte) (i6 & 255)};
        byte[] bArrA = com.uz.navee.utils.f.a(bArr, new byte[]{(byte) (a0(bArr) & 255), -2, -3});
        f4.b.f("Send read command: " + com.uz.navee.utils.f.c(bArrA), new Object[0]);
        return bArrA;
    }

    public static byte[] k(int i6, int i7, boolean z6) throws IOException {
        byte[] bArr = {85, -86, (byte) ((z6 ? 1 : 0) & 255), (byte) (i6 & 255), 1, (byte) (i7 & 255)};
        byte[] bArrA = com.uz.navee.utils.f.a(bArr, new byte[]{(byte) (a0(bArr) & 255), -2, -3});
        f4.b.f("Send write command: " + com.uz.navee.utils.f.c(bArrA), new Object[0]);
        return bArrA;
    }

    public static byte[] l(int i6, byte[] bArr, boolean z6) throws IOException {
        byte[] bArrA = com.uz.navee.utils.f.a(new byte[]{85, -86, (byte) ((z6 ? 1 : 0) & 255), (byte) (i6 & 255), (byte) (bArr.length & 255)}, bArr);
        byte[] bArrA2 = com.uz.navee.utils.f.a(bArrA, new byte[]{(byte) (a0(bArrA) & 255), -2, -3});
        f4.b.f("Send write command: " + com.uz.navee.utils.f.c(bArrA2), new Object[0]);
        return bArrA2;
    }

    public static void m(BleDevice bleDevice, Context context) {
        BluetoothGatt bluetoothGattI;
        Y(bleDevice);
        p0.a aVarN = p0.a.n();
        if (aVarN == null || (bluetoothGattI = aVarN.i(bleDevice)) == null || ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_CONNECT") != 0) {
            return;
        }
        bluetoothGattI.disconnect();
    }

    public static void n(Context context) {
        p0.a aVarN = p0.a.n();
        if (aVarN == null) {
            return;
        }
        Iterator it = aVarN.f().iterator();
        while (it.hasNext()) {
            m((BleDevice) it.next(), context);
        }
    }

    public static ArrayList o(byte[] bArr) {
        int length = bArr.length;
        int i6 = length % 8 == 0 ? length / 8 : (length / 8) + 1;
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = i7 * 8;
            int iJ = length > i8 + 1 ? com.uz.navee.utils.f.j(bArr, i8, 2, false) : 0;
            int iJ2 = length > i8 + 3 ? com.uz.navee.utils.f.j(bArr, i8 + 2, 2, false) : 0;
            int iJ3 = length > i8 + 5 ? com.uz.navee.utils.f.j(bArr, i8 + 4, 2, false) : 0;
            int iJ4 = length > i8 + 7 ? com.uz.navee.utils.f.j(bArr, i8 + 6, 2, false) : 0;
            if (iJ2 > 0) {
                DriveHistory driveHistory = new DriveHistory();
                driveHistory.setDuration(iJ);
                driveHistory.setMileage(iJ2);
                driveHistory.setAverageSpeed(iJ3);
                driveHistory.setMaximumSpeed(iJ4);
                arrayList.add(driveHistory);
            }
        }
        return arrayList;
    }

    public static byte[] p(byte[] bArr) throws IOException {
        byte[] bArrA = com.uz.navee.utils.f.a(new byte[]{85, -86, 0, 49, (byte) (bArr.length & 255)}, bArr);
        byte[] bArrA2 = com.uz.navee.utils.f.a(bArrA, new byte[]{(byte) (a0(bArrA) & 255), -2, -3});
        f4.b.f("Send encryptData: " + com.uz.navee.utils.f.c(bArrA2), new Object[0]);
        return bArrA2;
    }

    public static String q(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        for (byte b7 : bArr) {
            arrayList.add(String.valueOf((char) b7));
        }
        return TextUtils.join(".", arrayList);
    }

    public static String r(BleDevice bleDevice) {
        if (bleDevice == null) {
            return null;
        }
        byte[] scanRecord = bleDevice.getScanRecord();
        if (scanRecord == null || scanRecord.length <= 14) {
            return t(bleDevice.getMac());
        }
        byte[] bArrE = com.uz.navee.utils.f.e(Arrays.copyOfRange(scanRecord, 8, 14));
        StringBuilder sb = new StringBuilder();
        for (byte b7 : bArrE) {
            sb.append(String.format("%02X", Byte.valueOf(b7)));
        }
        return sb.toString();
    }

    public static String s(BleDevice bleDevice) {
        byte[] scanRecord;
        if (bleDevice == null || (scanRecord = bleDevice.getScanRecord()) == null || scanRecord.length <= 8) {
            return null;
        }
        return String.valueOf(com.uz.navee.utils.f.d(com.uz.navee.utils.f.e(Arrays.copyOfRange(scanRecord, 6, 8))));
    }

    public static String t(String str) {
        if (str == null) {
            return null;
        }
        return str.replace(":", "");
    }

    public static String u(String str) {
        String str2;
        String strE = g0.e(f1927p, "");
        HashMap map = new HashMap();
        if (!strE.isEmpty()) {
            map = (HashMap) new Gson().fromJson(strE, new i().getType());
        }
        if (!map.containsKey(str) || (str2 = (String) map.get(str)) == null) {
            return null;
        }
        String[] strArrSplit = str2.split("_");
        if (strArrSplit.length > 0) {
            return strArrSplit[0];
        }
        return null;
    }

    public static String v(String str) {
        String str2;
        String strE = g0.e(f1927p, "");
        HashMap map = new HashMap();
        if (!strE.isEmpty()) {
            map = (HashMap) new Gson().fromJson(strE, new j().getType());
        }
        if (!map.containsKey(str) || (str2 = (String) map.get(str)) == null) {
            return null;
        }
        String[] strArrSplit = str2.split("_");
        if (strArrSplit.length > 1) {
            return strArrSplit[1];
        }
        return null;
    }

    public static String w(String str) {
        if (str == null || !str.matches("([\\dA-Fa-f]{2}){6}")) {
            return null;
        }
        Matcher matcher = Pattern.compile(".{1,2}").matcher(str);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            arrayList.add(str.substring(matcher.start(), matcher.end()));
        }
        return TextUtils.join(":", arrayList);
    }

    public static VehicleModel x(String str) {
        Iterator it = b0().iterator();
        VehicleModel vehicleModel = null;
        while (it.hasNext()) {
            VehicleModel vehicleModel2 = (VehicleModel) it.next();
            if (vehicleModel2.pid.equals(str)) {
                vehicleModel = vehicleModel2;
            }
        }
        return vehicleModel;
    }

    public static VehicleModel y(String str, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        VehicleModel vehicleModel = null;
        while (it.hasNext()) {
            VehicleModel vehicleModel2 = (VehicleModel) it.next();
            if (vehicleModel2.pid.equals(str)) {
                vehicleModel = vehicleModel2;
            }
        }
        return vehicleModel;
    }

    public static WarnConfig z(String str) {
        Iterator it = W().f1935h.iterator();
        while (it.hasNext()) {
            WarnConfig warnConfig = (WarnConfig) it.next();
            if (Objects.equals(warnConfig.getCode(), str)) {
                return warnConfig;
            }
        }
        return null;
    }

    public void R(BleDevice bleDevice, Context context) {
        Timer timer = this.f1937j;
        if (timer != null) {
            timer.cancel();
            this.f1937j = null;
        }
        if (f(bleDevice)) {
            Activity activityB = com.uz.navee.e.c().b();
            if ((activityB instanceof DeviceBindActivity) || (activityB instanceof DeviceListActivity) || (activityB instanceof DeviceFirmwareUpdateActivity)) {
                return;
            }
            Timer timer2 = new Timer();
            this.f1937j = timer2;
            timer2.schedule(new d(bleDevice, context), 7000L);
        }
    }

    public void V(Consumer consumer) {
        this.f1936i = consumer;
    }

    public void Z() {
        Timer timer = this.f1937j;
        if (timer != null) {
            timer.cancel();
            this.f1937j = null;
        }
    }

    public a() {
        this.f1928a = 0;
        this.f1929b = false;
        this.f1931d = new DeviceHomePageInfo();
        this.f1932e = new DeviceSubPageInfo();
        this.f1933f = new DeviceCarInfo();
        this.f1934g = new DeviceBatteryInfo();
        this.f1935h = new ArrayList();
        this.f1938k = 7000L;
    }
}
