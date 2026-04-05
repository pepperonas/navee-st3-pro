package com.uz.navee.network.exception;

import android.net.ParseException;
import com.google.gson.JsonParseException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.json.JSONException;
import retrofit2.HttpException;

/* loaded from: classes3.dex */
public class ApiException extends Exception {
    private int code;
    private String displayMessage;

    public ApiException(int i6, String str) {
        this.code = i6;
        this.displayMessage = str;
    }

    public static ApiException handleException(Throwable th) {
        return th instanceof ApiException ? (ApiException) th : th instanceof HttpException ? new ApiException(1003, th.getMessage()) : ((th instanceof JsonParseException) || (th instanceof JSONException) || (th instanceof ParseException)) ? new ApiException(1001, th.getMessage()) : th instanceof ConnectException ? new ApiException(1002, th.getMessage()) : ((th instanceof UnknownHostException) || (th instanceof SocketTimeoutException)) ? new ApiException(1002, th.getMessage()) : new ApiException(1000, th.getMessage());
    }

    public int getCode() {
        return this.code;
    }

    public String getDisplayMessage() {
        return this.displayMessage;
    }

    public void setCode(int i6) {
        this.code = i6;
    }

    public void setDisplayMessage(String str) {
        this.displayMessage = str;
    }
}
