package com.uz.navee.bean;

import androidx.annotation.NonNull;
import java.util.Objects;

/* loaded from: classes3.dex */
public class DeviceHomePageInfo extends Observable implements Cloneable {
    private int batteryCharge;
    private int batteryCurrent;
    private int batteryStatus;
    private int batteryVoltage;
    private int chargingState;
    private int drivingMode;
    private int hideE9;
    private int lockPushWarn;
    private int lockStatus;
    private int remainMileage;
    private int warningCode;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceHomePageInfo)) {
            return false;
        }
        DeviceHomePageInfo deviceHomePageInfo = (DeviceHomePageInfo) obj;
        return this.warningCode == deviceHomePageInfo.warningCode && this.drivingMode == deviceHomePageInfo.drivingMode && this.batteryCharge == deviceHomePageInfo.batteryCharge && this.batteryStatus == deviceHomePageInfo.batteryStatus && this.chargingState == deviceHomePageInfo.chargingState && this.lockPushWarn == deviceHomePageInfo.lockPushWarn && this.remainMileage == deviceHomePageInfo.remainMileage && this.lockStatus == deviceHomePageInfo.lockStatus && this.batteryVoltage == deviceHomePageInfo.batteryVoltage && this.batteryCurrent == deviceHomePageInfo.batteryCurrent && this.hideE9 == deviceHomePageInfo.hideE9;
    }

    public int getBatteryCharge() {
        return this.batteryCharge;
    }

    public int getBatteryCurrent() {
        return this.batteryCurrent;
    }

    public int getBatteryStatus() {
        return this.batteryStatus;
    }

    public int getBatteryVoltage() {
        return this.batteryVoltage;
    }

    public int getChargingState() {
        return this.chargingState;
    }

    public int getDrivingMode() {
        return this.drivingMode;
    }

    public int getHideE9() {
        return this.hideE9;
    }

    public int getLockPushWarn() {
        return this.lockPushWarn;
    }

    public int getLockStatus() {
        return this.lockStatus;
    }

    public int getRemainMileage() {
        return this.remainMileage;
    }

    public int getWarningCode() {
        return this.warningCode;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.warningCode), Integer.valueOf(this.drivingMode), Integer.valueOf(this.batteryCharge), Integer.valueOf(this.batteryStatus), Integer.valueOf(this.chargingState), Integer.valueOf(this.lockPushWarn), Integer.valueOf(this.remainMileage), Integer.valueOf(this.lockStatus), Integer.valueOf(this.batteryVoltage), Integer.valueOf(this.batteryCurrent), Integer.valueOf(this.hideE9));
    }

    public void setBatteryCharge(int i6) {
        int i7 = this.batteryCharge;
        this.batteryCharge = i6;
        firePropertyChange("batteryCharge", i7, i6);
    }

    public void setBatteryCurrent(int i6) {
        int i7 = this.batteryCurrent;
        this.batteryCurrent = i6;
        firePropertyChange("batteryCurrent", i7, i6);
    }

    public void setBatteryStatus(int i6) {
        int i7 = this.batteryStatus;
        this.batteryStatus = i6;
        firePropertyChange("batteryStatus", i7, i6);
    }

    public void setBatteryVoltage(int i6) {
        int i7 = this.batteryVoltage;
        this.batteryVoltage = i6;
        firePropertyChange("batteryVoltage", i7, i6);
    }

    public void setChargingState(int i6) {
        int i7 = this.chargingState;
        this.chargingState = i6;
        firePropertyChange("chargingState", i7, i6);
    }

    public void setDrivingMode(int i6) {
        int i7 = this.drivingMode;
        this.drivingMode = i6;
        firePropertyChange("drivingMode", i7, i6);
    }

    public void setHideE9(int i6) {
        int i7 = this.hideE9;
        this.hideE9 = i6;
        firePropertyChange("hideE9", i7, i6);
    }

    public void setLockPushWarn(int i6) {
        int i7 = this.lockPushWarn;
        this.lockPushWarn = i6;
        firePropertyChange("lockPushWarn", i7, i6);
    }

    public void setLockStatus(int i6) {
        int i7 = this.lockStatus;
        this.lockStatus = i6;
        firePropertyChange("lockStatus", i7, i6);
    }

    public void setRemainMileage(int i6) {
        int i7 = this.remainMileage;
        this.remainMileage = i6;
        firePropertyChange("remainMileage", i7, i6);
    }

    public void setWarningCode(int i6) {
        int i7 = this.warningCode;
        this.warningCode = i6;
        firePropertyChange("warningCode", i7, i6);
    }

    @NonNull
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public DeviceHomePageInfo m120clone() {
        try {
            return (DeviceHomePageInfo) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
