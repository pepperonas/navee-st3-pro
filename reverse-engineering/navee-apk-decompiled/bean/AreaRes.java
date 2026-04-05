package com.uz.navee.bean;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class AreaRes implements Serializable {
    private String areaKey;
    private String areaName;
    private int areaSort;
    private String areaValue;
    private boolean bestArea;
    private boolean defaultFlag;

    public String getAreaKey() {
        return this.areaKey;
    }

    public String getAreaName() {
        return this.areaName;
    }

    public int getAreaSort() {
        return this.areaSort;
    }

    public String getAreaValue() {
        return this.areaValue;
    }

    public boolean isBestArea() {
        return this.bestArea;
    }

    public boolean isDefaultFlag() {
        return this.defaultFlag;
    }

    public boolean isMatch(String str) {
        String str2 = this.areaValue;
        if (str2 == null) {
            return false;
        }
        if (str2.equalsIgnoreCase(str)) {
            return true;
        }
        for (String str3 : this.areaValue.split(",")) {
            if (str.equalsIgnoreCase(str3)) {
                return true;
            }
        }
        return false;
    }

    public void setAreaKey(String str) {
        this.areaKey = str;
    }

    public void setAreaName(String str) {
        this.areaName = str;
    }

    public void setAreaSort(int i6) {
        this.areaSort = i6;
    }

    public void setAreaValue(String str) {
        this.areaValue = str;
    }

    public void setBestArea(boolean z6) {
        this.bestArea = z6;
    }

    public void setDefaultFlag(boolean z6) {
        this.defaultFlag = z6;
    }
}
