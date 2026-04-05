package cn.sharesdk.framework.a.a;

import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.tools.utils.SharePrefrenceHelper;

/* loaded from: classes2.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private static e f6267b;

    /* renamed from: a, reason: collision with root package name */
    private SharePrefrenceHelper f6268a;

    private e() {
        SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(MobSDK.getContext());
        this.f6268a = sharePrefrenceHelper;
        sharePrefrenceHelper.open("share_sdk", 1);
    }

    public static e a() {
        if (f6267b == null) {
            f6267b = new e();
        }
        return f6267b;
    }

    public long b() {
        return this.f6268a.getLong("service_time");
    }

    public boolean c() {
        String string = this.f6268a.getString("upload_device_info");
        if (TextUtils.isEmpty(string)) {
            return true;
        }
        return Boolean.parseBoolean(string);
    }

    public boolean d() {
        String string = this.f6268a.getString("upload_user_info");
        if (TextUtils.isEmpty(string)) {
            return true;
        }
        return Boolean.parseBoolean(string);
    }

    public boolean e() {
        String string = this.f6268a.getString("trans_short_link");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        return Boolean.parseBoolean(string);
    }

    public int f() {
        String string = this.f6268a.getString("upload_share_content");
        if ("true".equals(string)) {
            return 1;
        }
        return "false".equals(string) ? -1 : 0;
    }

    public void g(String str) {
        this.f6268a.putString("buffered_snsconf_" + MobSDK.getAppkey(), str);
    }

    public Long h() {
        return Long.valueOf(this.f6268a.getLong("device_time"));
    }

    public boolean i() {
        return this.f6268a.getBoolean("connect_server");
    }

    public Long j() {
        return Long.valueOf(this.f6268a.getLong("connect_server_time"));
    }

    public boolean k() {
        return this.f6268a.getBoolean("sns_info_buffered");
    }

    public Object l(String str) {
        return this.f6268a.get(str);
    }

    public void b(String str) {
        this.f6268a.putString("upload_device_info", str);
    }

    public String g() {
        return this.f6268a.getString("buffered_snsconf_" + MobSDK.getAppkey());
    }

    public String h(String str) {
        return this.f6268a.getString(str);
    }

    public boolean i(String str) {
        return this.f6268a.getBoolean(str);
    }

    public long j(String str) {
        return this.f6268a.getLong(str);
    }

    public int k(String str) {
        return this.f6268a.getInt(str);
    }

    public void b(boolean z6) {
        this.f6268a.putBoolean("no_use_gpp", Boolean.valueOf(z6));
    }

    public void a(String str) {
        this.f6268a.putString("trans_short_link", str);
    }

    public void b(long j6) {
        this.f6268a.putLong("connect_server_time", Long.valueOf(j6));
    }

    public void c(String str) {
        this.f6268a.putString("upload_user_info", str);
    }

    public void d(String str) {
        this.f6268a.putString("upload_share_content", str);
    }

    public void e(String str) {
        this.f6268a.putString("open_login_plus", str);
    }

    public void f(String str) {
        this.f6268a.putString("open_sina_link_card", str);
    }

    public void a(boolean z6) {
        this.f6268a.putBoolean("gpp_ver_sent", Boolean.valueOf(z6));
    }

    public void c(boolean z6) {
        this.f6268a.putBoolean("connect_server", Boolean.valueOf(z6));
    }

    public void d(boolean z6) {
        this.f6268a.putBoolean("sns_info_buffered", Boolean.valueOf(z6));
    }

    public void a(long j6) {
        this.f6268a.putLong("device_time", Long.valueOf(j6));
    }

    public void a(String str, String str2) {
        this.f6268a.putString(str, str2);
    }

    public void a(String str, Long l6) {
        this.f6268a.putLong(str, l6);
    }

    public void a(String str, int i6) {
        this.f6268a.putInt(str, Integer.valueOf(i6));
    }

    public void a(String str, Object obj) {
        this.f6268a.put(str, obj);
    }
}
