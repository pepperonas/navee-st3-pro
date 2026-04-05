package com.uz.navee.network.exception;

/* loaded from: classes3.dex */
public class ServerException extends RuntimeException {
    private int code;
    private String msg;

    public ServerException(int i6, String str) {
        this.code = i6;
        this.msg = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
