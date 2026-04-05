package c4;

import com.uz.navee.network.utils.DownloadUtils;
import com.uz.navee.utils.h;

/* loaded from: classes3.dex */
public class a extends h implements DownloadUtils.b {

    /* renamed from: b, reason: collision with root package name */
    public final String f2038b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2039c;

    /* renamed from: d, reason: collision with root package name */
    public final String f2040d;

    /* renamed from: e, reason: collision with root package name */
    public b f2041e;

    public a(String str, String str2, String str3) {
        this.f2038b = str;
        this.f2039c = str2;
        this.f2040d = str3;
    }

    @Override // com.uz.navee.utils.h
    public void a() {
        super.a();
        DownloadUtils.f().set0nDownloadListener(this);
        DownloadUtils.f().e(this.f2039c, this.f2040d, this.f2038b);
    }

    @Override // com.uz.navee.utils.h
    public void b() {
        super.b();
        DownloadUtils.f().set0nDownloadListener(null);
    }

    @Override // com.uz.navee.network.utils.DownloadUtils.b
    public void c(DownloadUtils.DownloadStatus downloadStatus, float f7, String str) {
        if (downloadStatus == DownloadUtils.DownloadStatus.success) {
            this.f2041e.b(this, Boolean.TRUE);
        } else if (downloadStatus == DownloadUtils.DownloadStatus.failed) {
            this.f2041e.b(this, Boolean.FALSE);
        } else {
            this.f2041e.a(this, (int) (f7 * 100.0f));
        }
    }
}
