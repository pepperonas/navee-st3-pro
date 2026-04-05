package com.uz.navee.bean;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class DriveHistory implements Serializable {
    private int averageSpeed;
    private int duration;
    private int maximumSpeed;
    private int mileage;

    public int getAverageSpeed() {
        return this.averageSpeed;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getMaximumSpeed() {
        return this.maximumSpeed;
    }

    public int getMileage() {
        return this.mileage;
    }

    public void setAverageSpeed(int i6) {
        this.averageSpeed = i6;
    }

    public void setDuration(int i6) {
        this.duration = i6;
    }

    public void setMaximumSpeed(int i6) {
        this.maximumSpeed = i6;
    }

    public void setMileage(int i6) {
        this.mileage = i6;
    }
}
