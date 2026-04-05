package com.uz.navee.bean;

/* loaded from: classes3.dex */
public class DeviceBatteryInfo extends Observable {
    int batteryCharge;
    int batteryCurrent;
    int batteryHealth;
    int batteryStatus;
    int batteryTemp;
    int batteryVoltage;
    int capacityThroughput;
    int chargeTimes;
    int chargingState;
    int currentState;
    int deepDischarge;
    int energyThroughput;
    boolean europeanRule;
    int extremeWeatherChargingTime;
    String generationDate;
    String highTemperatureDuration;
    int ratedCapacity;
    int selfDischargeRate;
    int temperatureState;

    public int getBatteryCharge() {
        return this.batteryCharge;
    }

    public int getBatteryCurrent() {
        return this.batteryCurrent;
    }

    public int getBatteryHealth() {
        return this.batteryHealth;
    }

    public int getBatteryStatus() {
        return this.batteryStatus;
    }

    public int getBatteryTemp() {
        return this.batteryTemp;
    }

    public int getBatteryVoltage() {
        return this.batteryVoltage;
    }

    public int getCapacityThroughput() {
        return this.capacityThroughput;
    }

    public int getChargeTimes() {
        return this.chargeTimes;
    }

    public int getChargingState() {
        return this.chargingState;
    }

    public int getCurrentState() {
        return this.currentState;
    }

    public int getDeepDischarge() {
        return this.deepDischarge;
    }

    public int getEnergyThroughput() {
        return this.energyThroughput;
    }

    public int getExtremeWeatherChargingTime() {
        return this.extremeWeatherChargingTime;
    }

    public String getGenerationDate() {
        return this.generationDate;
    }

    public String getHighTemperatureDuration() {
        return this.highTemperatureDuration;
    }

    public int getRatedCapacity() {
        return this.ratedCapacity;
    }

    public int getSelfDischargeRate() {
        return this.selfDischargeRate;
    }

    public int getTemperatureState() {
        return this.temperatureState;
    }

    public boolean isEuropeanRule() {
        return this.europeanRule;
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

    public void setBatteryHealth(int i6) {
        int i7 = this.batteryHealth;
        this.batteryHealth = i6;
        firePropertyChange("batteryHealth", i7, i6);
    }

    public void setBatteryStatus(int i6) {
        int i7 = this.batteryStatus;
        this.batteryStatus = i6;
        firePropertyChange("batteryStatus", i7, i6);
    }

    public void setBatteryTemp(int i6) {
        int i7 = this.batteryTemp;
        this.batteryTemp = i6;
        firePropertyChange("batteryTemp", i7, i6);
    }

    public void setBatteryVoltage(int i6) {
        int i7 = this.batteryVoltage;
        this.batteryVoltage = i6;
        firePropertyChange("batteryVoltage", i7, i6);
    }

    public void setCapacityThroughput(int i6) {
        int i7 = this.capacityThroughput;
        this.capacityThroughput = i6;
        firePropertyChange("capacityThroughput", i7, i6);
    }

    public void setChargeTimes(int i6) {
        int i7 = this.chargeTimes;
        this.chargeTimes = i6;
        firePropertyChange("chargeTimes", i7, i6);
    }

    public void setChargingState(int i6) {
        int i7 = this.chargingState;
        this.chargingState = i6;
        firePropertyChange("chargingState", i7, i6);
    }

    public void setCurrentState(int i6) {
        int i7 = this.currentState;
        this.currentState = i6;
        firePropertyChange("currentState", i7, i6);
    }

    public void setDeepDischarge(int i6) {
        int i7 = this.deepDischarge;
        this.deepDischarge = i6;
        firePropertyChange("deepDischarge", i7, i6);
    }

    public void setEnergyThroughput(int i6) {
        int i7 = this.energyThroughput;
        this.energyThroughput = i6;
        firePropertyChange("energyThroughput", i7, i6);
    }

    public void setEuropeanRule(boolean z6) {
        boolean z7 = this.europeanRule;
        this.europeanRule = z6;
        firePropertyChange("europeanRule", z7, z6);
    }

    public void setExtremeWeatherChargingTime(int i6) {
        int i7 = this.extremeWeatherChargingTime;
        this.extremeWeatherChargingTime = i6;
        firePropertyChange("extremeWeatherChargingTime", i7, i6);
    }

    public void setGenerationDate(String str) {
        String str2 = this.generationDate;
        this.generationDate = str;
        firePropertyChange("generationDate", str2, str);
    }

    public void setHighTemperatureDuration(String str) {
        String str2 = this.highTemperatureDuration;
        this.highTemperatureDuration = str;
        firePropertyChange("highTemperatureDuration", str2, str);
    }

    public void setRatedCapacity(int i6) {
        int i7 = this.ratedCapacity;
        this.ratedCapacity = i6;
        firePropertyChange("ratedCapacity", i7, i6);
    }

    public void setSelfDischargeRate(int i6) {
        int i7 = this.selfDischargeRate;
        this.selfDischargeRate = i6;
        firePropertyChange("selfDischargeRate", i7, i6);
    }

    public void setTemperatureState(int i6) {
        int i7 = this.temperatureState;
        this.temperatureState = i6;
        firePropertyChange("temperatureState", i7, i6);
    }
}
