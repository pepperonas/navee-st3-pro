package com.uz.navee.ui.mine.bean;

import java.util.List;

/* loaded from: classes3.dex */
public class GaojingListBean {
    private int code;
    private Data data;
    private String msg;

    public class Data {
        private int code;
        private String msg;
        private List<GaojingBean> rows;
        private int total;

        public Data() {
        }

        public int getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }

        public List<GaojingBean> getRows() {
            return this.rows;
        }

        public int getTotal() {
            return this.total;
        }

        public void setCode(int i6) {
            this.code = i6;
        }

        public void setMsg(String str) {
            this.msg = str;
        }

        public void setRows(List<GaojingBean> list) {
            this.rows = list;
        }

        public void setTotal(int i6) {
            this.total = i6;
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
