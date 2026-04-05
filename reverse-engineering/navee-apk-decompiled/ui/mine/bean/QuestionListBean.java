package com.uz.navee.ui.mine.bean;

import java.util.List;

/* loaded from: classes3.dex */
public class QuestionListBean {
    private int code;
    private List<QuestionBean> data;
    private String msg;

    public int getCode() {
        return this.code;
    }

    public List<QuestionBean> getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i6) {
        this.code = i6;
    }

    public void setData(List<QuestionBean> list) {
        this.data = list;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
