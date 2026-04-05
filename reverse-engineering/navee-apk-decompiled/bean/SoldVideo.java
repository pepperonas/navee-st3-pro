package com.uz.navee.bean;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class SoldVideo implements Serializable {
    private String language;
    private String name;
    private String video;

    public String getLanguage() {
        return this.language;
    }

    public String getName() {
        return this.name;
    }

    public String getVideo() {
        return this.video;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setVideo(String str) {
        this.video = str;
    }
}
