package com.uz.navee.bean;

import androidx.annotation.NonNull;
import java.util.Objects;

/* loaded from: classes3.dex */
public class DeviceSubPageInfo extends Observable implements Cloneable {
    private int averageSpeed;
    private int batteryCharge;
    private int drivingDuration;
    private int drivingMileage;
    private int drivingStatus;
    private int maximumSpeed;
    private int realTimeSpeed;
    private int remainMileage;
    private int totalMileage;
    private int version;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceSubPageInfo)) {
            return false;
        }
        DeviceSubPageInfo deviceSubPageInfo = (DeviceSubPageInfo) obj;
        return this.batteryCharge == deviceSubPageInfo.batteryCharge && this.drivingStatus == deviceSubPageInfo.drivingStatus && this.realTimeSpeed == deviceSubPageInfo.realTimeSpeed && this.remainMileage == deviceSubPageInfo.remainMileage && this.drivingMileage == deviceSubPageInfo.drivingMileage && this.drivingDuration == deviceSubPageInfo.drivingDuration && this.maximumSpeed == deviceSubPageInfo.maximumSpeed && this.averageSpeed == deviceSubPageInfo.averageSpeed && this.totalMileage == deviceSubPageInfo.totalMileage;
    }

    public int getAverageSpeed() {
        return this.averageSpeed;
    }

    public int getBatteryCharge() {
        return this.batteryCharge;
    }

    public int getDrivingDuration() {
        return this.drivingDuration;
    }

    public int getDrivingMileage() {
        return this.drivingMileage;
    }

    public int getDrivingStatus() {
        return this.drivingStatus;
    }

    public int getMaximumSpeed() {
        return this.maximumSpeed;
    }

    public int getRealTimeSpeed() {
        return this.realTimeSpeed;
    }

    public int getRemainMileage() {
        return this.remainMileage;
    }

    public int getTotalMileage() {
        return this.totalMileage;
    }

    public int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.batteryCharge), Integer.valueOf(this.drivingStatus), Integer.valueOf(this.realTimeSpeed), Integer.valueOf(this.remainMileage), Integer.valueOf(this.drivingMileage), Integer.valueOf(this.drivingDuration), Integer.valueOf(this.maximumSpeed), Integer.valueOf(this.averageSpeed), Integer.valueOf(this.totalMileage));
    }

    public void setAverageSpeed(int i6) {
        int i7 = this.averageSpeed;
        this.averageSpeed = i6;
        firePropertyChange("averageSpeed", i7, i6);
    }

    public void setBatteryCharge(int i6) {
        int i7 = this.batteryCharge;
        this.batteryCharge = i6;
        firePropertyChange("batteryCharge", i7, i6);
    }

    public void setDrivingDuration(int i6) {
        int i7 = this.drivingDuration;
        this.drivingDuration = i6;
        firePropertyChange("drivingDuration", i7, i6);
    }

    public void setDrivingMileage(int i6) {
        int i7 = this.drivingMileage;
        this.drivingMileage = i6;
        firePropertyChange("drivingMileage", i7, i6);
    }

    public void setDrivingStatus(int i6) {
        int i7 = this.drivingStatus;
        this.drivingStatus = i6;
        firePropertyChange("drivingStatus", i7, i6);
    }

    public void setMaximumSpeed(int i6) {
        int i7 = this.maximumSpeed;
        this.maximumSpeed = i6;
        firePropertyChange("maximumSpeed", i7, i6);
    }

    public void setRealTimeSpeed(int i6) {
        int i7 = this.realTimeSpeed;
        this.realTimeSpeed = i6;
        firePropertyChange("realTimeSpeed", i7, i6);
    }

    public void setRemainMileage(int i6) {
        int i7 = this.remainMileage;
        this.remainMileage = i6;
        firePropertyChange("remainMileage", i7, i6);
    }

    public void setTotalMileage(int i6) {
        this.totalMileage = i6;
    }

    public void setVersion(int i6) {
        this.version = i6;
    }

    @NonNull
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public DeviceSubPageInfo m121clone() {
        try {
            return (DeviceSubPageInfo) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
