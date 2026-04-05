package cn.sharesdk.onekeyshare;

import cn.sharesdk.onekeyshare.themes.classic.ClassicTheme;

/* loaded from: classes2.dex */
public enum OnekeyShareTheme {
    CLASSIC(0, new ClassicTheme());

    private final OnekeyShareThemeImpl impl;
    private final int value;

    OnekeyShareTheme(int i6, OnekeyShareThemeImpl onekeyShareThemeImpl) {
        this.value = i6;
        this.impl = onekeyShareThemeImpl;
    }

    public static OnekeyShareTheme fromValue(int i6) {
        for (OnekeyShareTheme onekeyShareTheme : values()) {
            if (onekeyShareTheme.value == i6) {
                return onekeyShareTheme;
            }
        }
        return CLASSIC;
    }

    public OnekeyShareThemeImpl getImpl() {
        return this.impl;
    }

    public int getValue() {
        return this.value;
    }
}
