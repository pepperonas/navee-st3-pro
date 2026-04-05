package com.uz.navee.ui.mine.bean;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class Myfeedback implements Serializable {
    private String carNo;
    private int carStatus;
    private String carUserName;
    private String context;
    private String createDate;
    private String id;
    private String imei;
    private String imgs;
    private String reply;
    private String replyDate;
    private String replyReadStatus;
    private String replyUserId;
    private int status;
    private String title;
    private String vehicleId;
    private int vehicleModelId;
    private String vehicleModelName;
    private String vehicleModelNo;
    private String vehicleModelPid;

    public String getCarNo() {
        return this.carNo;
    }

    public int getCarStatus() {
        return this.carStatus;
    }

    public String getCarUserName() {
        return this.carUserName;
    }

    public String getContext() {
        return this.context;
    }

    public String getCreateDate() {
        return this.createDate;
    }

    public String getId() {
        return this.id;
    }

    public String getImei() {
        return this.imei;
    }

    public String getImgs() {
        return this.imgs;
    }

    public String getReply() {
        return this.reply;
    }

    public String getReplyDate() {
        return this.replyDate;
    }

    public String getReplyReadStatus() {
        return this.replyReadStatus;
    }

    public String getReplyUserId() {
        return this.replyUserId;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public String getVehicleId() {
        return this.vehicleId;
    }

    public int getVehicleModelId() {
        return this.vehicleModelId;
    }

    public String getVehicleModelName() {
        return this.vehicleModelName;
    }

    public String getVehicleModelNo() {
        return this.vehicleModelNo;
    }

    public String getVehicleModelPid() {
        return this.vehicleModelPid;
    }

    public void setCarNo(String str) {
        this.carNo = str;
    }

    public void setCarStatus(int i6) {
        this.carStatus = i6;
    }

    public void setCarUserName(String str) {
        this.carUserName = str;
    }

    public void setContext(String str) {
        this.context = str;
    }

    public void setCreateDate(String str) {
        this.createDate = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setImgs(String str) {
        this.imgs = str;
    }

    public void setReply(String str) {
        this.reply = str;
    }

    public void setReplyDate(String str) {
        this.replyDate = str;
    }

    public void setReplyReadStatus(String str) {
        this.replyReadStatus = str;
    }

    public void setReplyUserId(String str) {
        this.replyUserId = str;
    }

    public void setStatus(int i6) {
        this.status = i6;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVehicleId(String str) {
        this.vehicleId = str;
    }

    public void setVehicleModelId(int i6) {
        this.vehicleModelId = i6;
    }

    public void setVehicleModelName(String str) {
        this.vehicleModelName = str;
    }

    public void setVehicleModelNo(String str) {
        this.vehicleModelNo = str;
    }

    public void setVehicleModelPid(String str) {
        this.vehicleModelPid = str;
    }

    public boolean unread() {
        return "0".equals(this.replyReadStatus);
    }
}
