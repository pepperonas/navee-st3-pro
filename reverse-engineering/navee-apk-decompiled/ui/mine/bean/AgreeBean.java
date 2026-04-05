package com.uz.navee.ui.mine.bean;

/* loaded from: classes3.dex */
public class AgreeBean {
    private int code;
    private Data data;
    private String msg;

    public class Data {
        private String language;
        private String policy;
        private String revoke;
        private String user;

        public Data() {
        }

        public String getLanguage() {
            return this.language;
        }

        public String getPolicy() {
            return this.policy;
        }

        public String getRevoke() {
            return this.revoke;
        }

        public String getUser() {
            return this.user;
        }

        public void setLanguage(String str) {
            this.language = str;
        }

        public void setPolicy(String str) {
            this.policy = str;
        }

        public void setRevoke(String str) {
            this.revoke = str;
        }

        public void setUser(String str) {
            this.user = str;
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
