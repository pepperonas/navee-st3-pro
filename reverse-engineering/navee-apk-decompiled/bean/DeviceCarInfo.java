package com.uz.navee.bean;

/* loaded from: classes3.dex */
public class DeviceCarInfo extends Observable {
    int ambientLight;
    int autoSensor;
    int bindingStatus;
    int breakSpeed;
    int ccsStatus;
    int chargeLimit;
    int dayRunLight;
    int driveMode;
    int drivingMode;
    int ersStatus;
    int lightD;
    int lightE;
    int lightS;
    int limitSpeed;
    int logoLight;
    int longRange;
    int lowPower;
    int maxSpeed;
    int mileageAlgorithm;
    int mileageAlgorithmMode;
    int mileageUnit;
    int nightMode;
    int proximityKey;
    int reportLanguage;
    int slopeSup;
    long startChargeTime;
    int tailIsOn;
    int tcsSwitch;
    int timedChargeOn;
    int turnSound;
    int tyreSwitch;
    int volume;
    int weather;
    int lockStatus = 1;
    int startSpeed = 3;
    int lockTime = 1;

    public int getAmbientLight() {
        return this.ambientLight;
    }

    public int getAutoSensor() {
        return this.autoSensor;
    }

    public int getBindingStatus() {
        return this.bindingStatus;
    }

    public int getBreakSpeed() {
        return this.breakSpeed;
    }

    public int getCcsStatus() {
        return this.ccsStatus;
    }

    public int getChargeLimit() {
        return this.chargeLimit;
    }

    public int getDayRunLight() {
        return this.dayRunLight;
    }

    public int getDriveMode() {
        return this.driveMode;
    }

    public int getDrivingMode() {
        return this.drivingMode;
    }

    public int getErsStatus() {
        return this.ersStatus;
    }

    public int getLightD() {
        return this.lightD;
    }

    public int getLightE() {
        return this.lightE;
    }

    public int getLightS() {
        return this.lightS;
    }

    public int getLimitSpeed() {
        return this.limitSpeed;
    }

    public int getLockStatus() {
        return this.lockStatus;
    }

    public int getLockTime() {
        return this.lockTime;
    }

    public int getLogoLight() {
        return this.logoLight;
    }

    public int getLongRange() {
        return this.longRange;
    }

    public int getLowPower() {
        return this.lowPower;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public int getMileageAlgorithm() {
        return this.mileageAlgorithm;
    }

    public int getMileageAlgorithmMode() {
        return this.mileageAlgorithmMode;
    }

    public int getMileageUnit() {
        return this.mileageUnit;
    }

    public int getNightMode() {
        return this.nightMode;
    }

    public int getProximityKey() {
        return this.proximityKey;
    }

    public int getReportLanguage() {
        return this.reportLanguage;
    }

    public int getSlopeSup() {
        return this.slopeSup;
    }

    public long getStartChargeTime() {
        return this.startChargeTime;
    }

    public int getStartSpeed() {
        return this.startSpeed;
    }

    public int getTailIsOn() {
        return this.tailIsOn;
    }

    public int getTcsSwitch() {
        return this.tcsSwitch;
    }

    public int getTimedChargeOn() {
        return this.timedChargeOn;
    }

    public int getTurnSound() {
        return this.turnSound;
    }

    public int getTyreSwitch() {
        return this.tyreSwitch;
    }

    public int getVolume() {
        return this.volume;
    }

    public int getWeather() {
        return this.weather;
    }

    public void setAmbientLight(int i6) {
        int i7 = this.ambientLight;
        this.ambientLight = i6;
        firePropertyChange("ambientLight", i7, i6);
    }

    public void setAutoSensor(int i6) {
        int i7 = this.autoSensor;
        this.autoSensor = i6;
        firePropertyChange("autoSensor", i7, i6);
    }

    public void setBindingStatus(int i6) {
        int i7 = this.bindingStatus;
        this.bindingStatus = i6;
        firePropertyChange("bindingStatus", i7, i6);
    }

    public void setBreakSpeed(int i6) {
        int i7 = this.breakSpeed;
        this.breakSpeed = i6;
        firePropertyChange("breakSpeed", i7, i6);
    }

    public void setCcsStatus(int i6) {
        int i7 = this.ccsStatus;
        this.ccsStatus = i6;
        firePropertyChange("ccsStatus", i7, i6);
    }

    public void setChargeLimit(int i6) {
        int i7 = this.chargeLimit;
        this.chargeLimit = i6;
        firePropertyChange("chargeLimit", i7, i6);
    }

    public void setDayRunLight(int i6) {
        int i7 = this.dayRunLight;
        this.dayRunLight = i6;
        firePropertyChange("dayRunLight", i7, i6);
    }

    public void setDriveMode(int i6) {
        int i7 = this.driveMode;
        this.driveMode = i6;
        firePropertyChange("driveMode", i7, i6);
    }

    public void setDrivingMode(int i6) {
        int i7 = this.drivingMode;
        this.drivingMode = i6;
        firePropertyChange("drivingMode", i7, i6);
    }

    public void setErsStatus(int i6) {
        int i7 = this.ersStatus;
        this.ersStatus = i6;
        firePropertyChange("ersStatus", i7, i6);
    }

    public void setLightD(int i6) {
        int i7 = this.lightD;
        this.lightD = i6;
        firePropertyChange("lightD", i7, i6);
    }

    public void setLightE(int i6) {
        int i7 = this.lightE;
        this.lightE = i6;
        firePropertyChange("lightE", i7, i6);
    }

    public void setLightS(int i6) {
        int i7 = this.lightS;
        this.lightS = i6;
        firePropertyChange("lightS", i7, i6);
    }

    public void setLimitSpeed(int i6) {
        int i7 = this.limitSpeed;
        this.limitSpeed = i6;
        firePropertyChange("limitSpeed", i7, i6);
    }

    public void setLockStatus(int i6) {
        int i7 = this.lockStatus;
        this.lockStatus = i6;
        firePropertyChange("lockStatus", i7, i6);
    }

    public void setLockTime(int i6) {
        int i7 = this.lockTime;
        this.lockTime = i6;
        firePropertyChange("lockTime", i7, i6);
    }

    public void setLogoLight(int i6) {
        int i7 = this.logoLight;
        this.logoLight = i6;
        firePropertyChange("logoLight", i7, i6);
    }

    public void setLongRange(int i6) {
        int i7 = this.longRange;
        this.longRange = i6;
        firePropertyChange("longRange", i7, i6);
    }

    public void setLowPower(int i6) {
        int i7 = this.lowPower;
        this.lowPower = i6;
        firePropertyChange("lowPower", i7, i6);
    }

    public void setMaxSpeed(int i6) {
        int i7 = this.maxSpeed;
        this.maxSpeed = i6;
        firePropertyChange("maxSpeed", i7, i6);
    }

    public void setMileageAlgorithm(int i6) {
        int i7 = this.mileageAlgorithm;
        this.mileageAlgorithm = i6;
        firePropertyChange("mileageAlgorithm", i7, i6);
    }

    public void setMileageAlgorithmMode(int i6) {
        int i7 = this.mileageAlgorithmMode;
        this.mileageAlgorithmMode = i6;
        firePropertyChange("mileageAlgorithmMode", i7, i6);
    }

    public void setMileageUnit(int i6) {
        int i7 = this.mileageUnit;
        this.mileageUnit = i6;
        firePropertyChange("mileageUnit", i7, i6);
    }

    public void setNightMode(int i6) {
        int i7 = this.nightMode;
        this.nightMode = i6;
        firePropertyChange("nightMode", i7, i6);
    }

    public void setProximityKey(int i6) {
        int i7 = this.proximityKey;
        this.proximityKey = i6;
        firePropertyChange("proximityKey", i7, i6);
    }

    public void setReportLanguage(int i6) {
        int i7 = this.reportLanguage;
        this.reportLanguage = i6;
        firePropertyChange("reportLanguage", i7, i6);
    }

    public void setSlopeSup(int i6) {
        int i7 = this.slopeSup;
        this.slopeSup = i6;
        firePropertyChange("slopeSup", i7, i6);
    }

    public void setStartChargeTime(long j6) {
        long j7 = this.startChargeTime;
        this.startChargeTime = j6;
        firePropertyChange("startChargeTime", Long.valueOf(j7), Long.valueOf(j6));
    }

    public void setStartSpeed(int i6) {
        int i7 = this.startSpeed;
        this.startSpeed = i6;
        firePropertyChange("startSpeed", i7, i6);
    }

    public void setTailIsOn(int i6) {
        int i7 = this.tailIsOn;
        this.tailIsOn = i6;
        firePropertyChange("tailIsOn", i7, i6);
    }

    public void setTcsSwitch(int i6) {
        int i7 = this.tcsSwitch;
        this.tcsSwitch = i6;
        firePropertyChange("tcsSwitch", i7, i6);
    }

    public void setTimedChargeOn(int i6) {
        int i7 = this.timedChargeOn;
        this.timedChargeOn = i6;
        firePropertyChange("timedChargeOn", i7, i6);
    }

    public void setTurnSound(int i6) {
        int i7 = this.turnSound;
        this.turnSound = i6;
        firePropertyChange("turnSound", i7, i6);
    }

    public void setTyreSwitch(int i6) {
        int i7 = this.tyreSwitch;
        this.tyreSwitch = i6;
        firePropertyChange("tyreSwitch", i7, i6);
    }

    public void setVolume(int i6) {
        int i7 = this.volume;
        this.volume = i6;
        firePropertyChange("volume", i7, i6);
    }

    public void setWeather(int i6) {
        int i7 = this.weather;
        this.weather = i6;
        firePropertyChange("weather", i7, i6);
    }
}
