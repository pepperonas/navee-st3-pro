package com.uz.navee.bean;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class VehicleModel implements Serializable {
    public String book;
    public String category;
    public int guideType;
    public Integer id;
    public String imgTxt;
    public String language;
    public String maxImg;
    public String minImg;
    public String model;
    public String name;
    public String pid;
    public String series;
    public String subtitle;
    public String type;
    public String video;

    public String displayName() {
        String str = this.name;
        String str2 = this.type;
        return (str == null || str.isEmpty()) ? (str2 == null || str2.isEmpty()) ? "NAVEE" : str2 : str;
    }
}
