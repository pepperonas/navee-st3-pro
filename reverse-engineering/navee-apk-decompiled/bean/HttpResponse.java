package com.uz.navee.bean;

/* loaded from: classes3.dex */
public class HttpResponse<T> {
    private int code;
    private T data;
    private String msg;

    public int getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i6) {
        this.code = i6;
    }

    public void setData(T t6) {
        this.data = t6;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
