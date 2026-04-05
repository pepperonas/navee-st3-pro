package com.uz.navee.ui.data;

import android.app.Activity;
import android.location.Location;
import androidx.core.util.Consumer;
import com.clj.fastble.data.BleDevice;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.bean.Weather;
import com.uz.navee.bean.WeatherInfo;
import com.uz.navee.utils.b0;
import com.uz.navee.utils.g0;
import com.uz.navee.utils.l;
import com.uz.navee.utils.z;
import d4.d;
import java.io.IOException;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.o0;
import kotlin.h;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.y;
import kotlin.k;
import kotlin.text.s;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.j0;

/* loaded from: classes3.dex */
public final class WeatherUpdater {

    /* renamed from: c, reason: collision with root package name */
    public static final a f11683c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final kotlin.f f11684d = h.a(LazyThreadSafetyMode.SYNCHRONIZED, new q5.a() { // from class: com.uz.navee.ui.data.WeatherUpdater$Companion$sInstance$2
        @Override // q5.a
        public final WeatherUpdater invoke() {
            return new WeatherUpdater();
        }
    });

    /* renamed from: a, reason: collision with root package name */
    public final i0 f11685a = j0.b();

    /* renamed from: b, reason: collision with root package name */
    public Consumer f11686b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final WeatherUpdater a() {
            return b();
        }

        public final WeatherUpdater b() {
            return (WeatherUpdater) WeatherUpdater.f11684d.getValue();
        }
    }

    public static final class b implements d.h {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BleDevice f11688b;

        public static final class a extends TypeToken<HttpResponse<WeatherInfo>> {
        }

        public b(BleDevice bleDevice) {
            this.f11688b = bleDevice;
        }

        @Override // d4.d.h
        public void a(String json) throws IOException {
            y.f(json, "json");
            HttpResponse httpResponse = (HttpResponse) new Gson().fromJson(json, new a().getType());
            if (httpResponse == null || httpResponse.getCode() != 200 || httpResponse.getData() == null || ((WeatherInfo) httpResponse.getData()).getSkycon() == null) {
                WeatherUpdater.this.i();
                return;
            }
            ((WeatherInfo) httpResponse.getData()).setWeatherTime(Long.valueOf(System.currentTimeMillis()));
            WeatherUpdater weatherUpdater = WeatherUpdater.this;
            Object data = httpResponse.getData();
            y.e(data, "getData(...)");
            weatherUpdater.r((WeatherInfo) data);
            WeatherUpdater weatherUpdater2 = WeatherUpdater.this;
            Weather skycon = ((WeatherInfo) httpResponse.getData()).getSkycon();
            y.c(skycon);
            weatherUpdater2.s(skycon, this.f11688b);
        }

        @Override // d4.d.h
        public void b(Exception e7) {
            y.f(e7, "e");
            WeatherUpdater.this.i();
        }
    }

    public WeatherUpdater() {
        b4.a.W().V(new Consumer() { // from class: com.uz.navee.ui.data.e
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                WeatherUpdater.c(this.f11691a, (Boolean) obj);
            }
        });
    }

    public static final void c(WeatherUpdater this$0, Boolean bool) {
        y.f(this$0, "this$0");
        i.d(this$0.f11685a, null, null, new WeatherUpdater$1$1(bool, this$0, null), 3, null);
    }

    public static final WeatherUpdater k() {
        return f11683c.a();
    }

    public static final void p(WeatherUpdater this$0, BleDevice device, Location location) {
        y.f(this$0, "this$0");
        y.f(device, "$device");
        if (location != null) {
            this$0.q(location, device);
        } else {
            this$0.i();
        }
    }

    public static /* synthetic */ void w(WeatherUpdater weatherUpdater, Activity activity, BleDevice bleDevice, boolean z6, int i6, Object obj) throws IOException {
        if ((i6 & 4) != 0) {
            z6 = false;
        }
        weatherUpdater.v(activity, bleDevice, z6);
    }

    public final void i() {
        Consumer consumer = this.f11686b;
        if (consumer != null) {
            consumer.accept(Boolean.FALSE);
        }
    }

    public final void j() {
        WeatherInfo weatherInfoN = n();
        if (weatherInfoN != null) {
            weatherInfoN.setSendTime(Long.valueOf(System.currentTimeMillis()));
            r(weatherInfoN);
        }
        Consumer consumer = this.f11686b;
        if (consumer != null) {
            consumer.accept(Boolean.TRUE);
        }
    }

    public final String l() {
        WeatherInfo weatherInfoN = n();
        Long sendTime = weatherInfoN != null ? weatherInfoN.getSendTime() : null;
        if (sendTime == null || !l.d(sendTime.longValue(), System.currentTimeMillis())) {
            return null;
        }
        return l.b(sendTime.longValue(), "HH:mm");
    }

    public final WeatherInfo m() {
        String strL = b4.a.L();
        if (strL == null || s.s(strL)) {
            return null;
        }
        return (WeatherInfo) new Gson().fromJson(g0.d("WEATHER_INFO_" + strL), WeatherInfo.class);
    }

    public final WeatherInfo n() {
        return m();
    }

    public final void o(Activity activity, final BleDevice bleDevice) {
        z.b().f13294b = new b0() { // from class: com.uz.navee.ui.data.f
            @Override // com.uz.navee.utils.b0
            public final void a(Location location) {
                WeatherUpdater.p(this.f11692a, bleDevice, location);
            }
        };
        z.b().c(activity);
    }

    public final void q(Location location, BleDevice bleDevice) {
        d4.d.h().g(e4.a.a() + "/weather/get", o0.i(k.a("lat", Double.valueOf(location.getLatitude())), k.a("lng", Double.valueOf(location.getLongitude()))), new b(bleDevice));
    }

    public final void r(WeatherInfo weatherInfo) {
        g0.f("WEATHER_INFO_" + b4.a.L(), new Gson().toJson(weatherInfo));
    }

    public final void s(Weather weather, BleDevice bleDevice) throws IOException {
        if (!b4.a.f(bleDevice)) {
            i();
            return;
        }
        int iOrdinal = weather.ordinal() | 128;
        byte[] bArrK = b4.a.k(128, iOrdinal, false);
        f4.b.c("sendCmd cmd=0X%02X, value=0X%02X", 128, Integer.valueOf(iOrdinal));
        b4.a.c0(bleDevice, bArrK);
    }

    public final void t(Consumer consumer) {
        this.f11686b = consumer;
    }

    public final void u(Activity activity, BleDevice bleDevice) throws IOException {
        y.f(activity, "activity");
        w(this, activity, bleDevice, false, 4, null);
    }

    public final void v(Activity activity, BleDevice bleDevice, boolean z6) throws IOException {
        Weather skycon;
        y.f(activity, "activity");
        WeatherInfo weatherInfoN = n();
        Long weatherTime = weatherInfoN != null ? weatherInfoN.getWeatherTime() : null;
        if (weatherTime == null || !l.d(weatherTime.longValue(), System.currentTimeMillis())) {
            if (bleDevice == null) {
                i();
                return;
            } else {
                o(activity, bleDevice);
                return;
            }
        }
        if ((weatherInfoN.getSendTime() == null || z6) && (skycon = weatherInfoN.getSkycon()) != null) {
            s(skycon, bleDevice);
        }
    }
}
