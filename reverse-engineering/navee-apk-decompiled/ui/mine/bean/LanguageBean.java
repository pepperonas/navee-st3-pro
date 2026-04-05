package com.uz.navee.ui.mine.bean;

import java.util.List;

/* loaded from: classes3.dex */
public class LanguageBean {
    private int code;
    private List<Data> data;
    private String msg;

    public class Data {
        private String code;
        private String name;

        public Data() {
        }

        public String getCode() {
            return this.code;
        }

        public String getName() {
            return this.name;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    public int getCode() {
        return this.code;
    }

    public List<Data> getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i6) {
        this.code = i6;
    }

    public void setData(List<Data> list) {
        this.data = list;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
