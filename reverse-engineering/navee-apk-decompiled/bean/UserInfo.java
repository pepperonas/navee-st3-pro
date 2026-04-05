package com.uz.navee.bean;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class UserInfo implements Serializable {
    private String email;
    private String facebookEmail;
    private int facebookFlag;
    private String googleEmail;
    private int googleFlag;
    private String headImg;
    private String naveeId;
    private String nickName;
    private int registerType;
    private int uaccountFlag;
    private int unReadOpinion;
    private String userName;

    public String getEmail() {
        String str = this.email;
        return str != null ? str : "";
    }

    public String getFacebookEmail() {
        return this.facebookEmail;
    }

    public int getFacebookFlag() {
        return this.facebookFlag;
    }

    public String getGoogleEmail() {
        return this.googleEmail;
    }

    public int getGoogleFlag() {
        return this.googleFlag;
    }

    public String getHeadImg() {
        String str = this.headImg;
        return str != null ? str : "";
    }

    public String getNaveeId() {
        return this.naveeId;
    }

    public String getNickName() {
        String str = this.nickName;
        return str != null ? str : "";
    }

    public int getRegisterType() {
        return this.registerType;
    }

    public int getUaccountFlag() {
        return this.uaccountFlag;
    }

    public int getUnReadOpinion() {
        return this.unReadOpinion;
    }

    public String getUserName() {
        String str = this.userName;
        return str != null ? str : "";
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setFacebookEmail(String str) {
        this.facebookEmail = str;
    }

    public void setFacebookFlag(int i6) {
        this.facebookFlag = i6;
    }

    public void setGoogleEmail(String str) {
        this.googleEmail = str;
    }

    public void setGoogleFlag(int i6) {
        this.googleFlag = i6;
    }

    public void setHeadImg(String str) {
        this.headImg = str;
    }

    public void setNaveeId(String str) {
        this.naveeId = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setRegisterType(int i6) {
        this.registerType = i6;
    }

    public void setUaccountFlag(int i6) {
        this.uaccountFlag = i6;
    }

    public void setUnReadOpinion(int i6) {
        this.unReadOpinion = i6;
    }

    public void setUserName(String str) {
        this.userName = str;
    }
}
