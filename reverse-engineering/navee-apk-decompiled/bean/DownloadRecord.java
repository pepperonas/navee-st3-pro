package com.uz.navee.bean;

import java.io.Serializable;
import kotlin.jvm.internal.y;

/* loaded from: classes3.dex */
public final class DownloadRecord implements Serializable {
    private final String appName;
    private final String time;

    public DownloadRecord(String appName, String time) {
        y.f(appName, "appName");
        y.f(time, "time");
        this.appName = appName;
        this.time = time;
    }

    public static /* synthetic */ DownloadRecord copy$default(DownloadRecord downloadRecord, String str, String str2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = downloadRecord.appName;
        }
        if ((i6 & 2) != 0) {
            str2 = downloadRecord.time;
        }
        return downloadRecord.copy(str, str2);
    }

    public final String component1() {
        return this.appName;
    }

    public final String component2() {
        return this.time;
    }

    public final DownloadRecord copy(String appName, String time) {
        y.f(appName, "appName");
        y.f(time, "time");
        return new DownloadRecord(appName, time);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadRecord)) {
            return false;
        }
        DownloadRecord downloadRecord = (DownloadRecord) obj;
        return y.a(this.appName, downloadRecord.appName) && y.a(this.time, downloadRecord.time);
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getTime() {
        return this.time;
    }

    public int hashCode() {
        return (this.appName.hashCode() * 31) + this.time.hashCode();
    }

    public String toString() {
        return "DownloadRecord(appName=" + this.appName + ", time=" + this.time + ")";
    }
}
