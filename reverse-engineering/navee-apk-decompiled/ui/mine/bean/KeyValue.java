package com.uz.navee.ui.mine.bean;

/* loaded from: classes3.dex */
public class KeyValue {
    private String id;
    private String key;
    private String name;
    private String value;

    public KeyValue(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public String getId() {
        return this.id;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
