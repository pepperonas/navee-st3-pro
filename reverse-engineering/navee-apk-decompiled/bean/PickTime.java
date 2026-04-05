package com.uz.navee.bean;

import android.content.Context;
import androidx.camera.camera2.internal.compat.params.e;
import com.uz.navee.R$string;
import kotlin.jvm.internal.y;

/* loaded from: classes3.dex */
public final class PickTime {
    private final int dayOffset;
    private final String time;
    private final long timestamp;

    public PickTime(long j6, String time, int i6) {
        y.f(time, "time");
        this.timestamp = j6;
        this.time = time;
        this.dayOffset = i6;
    }

    public static /* synthetic */ PickTime copy$default(PickTime pickTime, long j6, String str, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            j6 = pickTime.timestamp;
        }
        if ((i7 & 2) != 0) {
            str = pickTime.time;
        }
        if ((i7 & 4) != 0) {
            i6 = pickTime.dayOffset;
        }
        return pickTime.copy(j6, str, i6);
    }

    public final long component1() {
        return this.timestamp;
    }

    public final String component2() {
        return this.time;
    }

    public final int component3() {
        return this.dayOffset;
    }

    public final PickTime copy(long j6, String time, int i6) {
        y.f(time, "time");
        return new PickTime(j6, time, i6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PickTime)) {
            return false;
        }
        PickTime pickTime = (PickTime) obj;
        return this.timestamp == pickTime.timestamp && y.a(this.time, pickTime.time) && this.dayOffset == pickTime.dayOffset;
    }

    public final int getDayOffset() {
        return this.dayOffset;
    }

    public final String getTime() {
        return this.time;
    }

    public final String getTimeDes(Context context) {
        y.f(context, "context");
        if (this.dayOffset != 1) {
            return this.time;
        }
        return this.time + "(" + context.getString(R$string.second_day) + ")";
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (((e.a(this.timestamp) * 31) + this.time.hashCode()) * 31) + this.dayOffset;
    }

    public String toString() {
        return "PickTime(timestamp=" + this.timestamp + ", time=" + this.time + ", dayOffset=" + this.dayOffset + ")";
    }
}
