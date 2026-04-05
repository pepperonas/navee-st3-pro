package com.uz.navee.ui.mine.bean;

/* loaded from: classes3.dex */
public class Affirmbean {
    private int code;
    private Data data;
    private String msg;

    public class Data {
        private String key;

        public Data() {
        }

        public String getKey() {
            return this.key;
        }

        public void setKey(String str) {
            this.key = str;
        }
    }

    public int getCode() {
        return this.code;
    }

    public Data getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i6) {
        this.code = i6;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
