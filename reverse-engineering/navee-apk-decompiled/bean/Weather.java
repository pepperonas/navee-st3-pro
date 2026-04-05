package com.uz.navee.bean;

import kotlin.enums.a;
import kotlin.enums.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class Weather {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ Weather[] $VALUES;
    public static final Weather SUNNY = new Weather("SUNNY", 0);
    public static final Weather CLOUDY = new Weather("CLOUDY", 1);
    public static final Weather OVERCAST = new Weather("OVERCAST", 2);
    public static final Weather RAINY = new Weather("RAINY", 3);

    private static final /* synthetic */ Weather[] $values() {
        return new Weather[]{SUNNY, CLOUDY, OVERCAST, RAINY};
    }

    static {
        Weather[] weatherArr$values = $values();
        $VALUES = weatherArr$values;
        $ENTRIES = b.a(weatherArr$values);
    }

    private Weather(String str, int i6) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static Weather valueOf(String str) {
        return (Weather) Enum.valueOf(Weather.class, str);
    }

    public static Weather[] values() {
        return (Weather[]) $VALUES.clone();
    }
}
