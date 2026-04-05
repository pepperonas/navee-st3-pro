package com.uz.navee.bean;

import kotlin.jvm.internal.y;

/* loaded from: classes3.dex */
public final class WeatherInfo {
    private final Double maxTemperature;
    private final Double minTemperature;
    private Long sendTime;
    private final Weather skycon;
    private final String skyconDesc;
    private Long weatherTime;
    private final String wind;
    private final String windDirection;

    public WeatherInfo(Double d7, Double d8, Weather weather, String str, String str2, String str3, Long l6, Long l7) {
        this.maxTemperature = d7;
        this.minTemperature = d8;
        this.skycon = weather;
        this.skyconDesc = str;
        this.wind = str2;
        this.windDirection = str3;
        this.weatherTime = l6;
        this.sendTime = l7;
    }

    public final Double component1() {
        return this.maxTemperature;
    }

    public final Double component2() {
        return this.minTemperature;
    }

    public final Weather component3() {
        return this.skycon;
    }

    public final String component4() {
        return this.skyconDesc;
    }

    public final String component5() {
        return this.wind;
    }

    public final String component6() {
        return this.windDirection;
    }

    public final Long component7() {
        return this.weatherTime;
    }

    public final Long component8() {
        return this.sendTime;
    }

    public final WeatherInfo copy(Double d7, Double d8, Weather weather, String str, String str2, String str3, Long l6, Long l7) {
        return new WeatherInfo(d7, d8, weather, str, str2, str3, l6, l7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WeatherInfo)) {
            return false;
        }
        WeatherInfo weatherInfo = (WeatherInfo) obj;
        return y.a(this.maxTemperature, weatherInfo.maxTemperature) && y.a(this.minTemperature, weatherInfo.minTemperature) && this.skycon == weatherInfo.skycon && y.a(this.skyconDesc, weatherInfo.skyconDesc) && y.a(this.wind, weatherInfo.wind) && y.a(this.windDirection, weatherInfo.windDirection) && y.a(this.weatherTime, weatherInfo.weatherTime) && y.a(this.sendTime, weatherInfo.sendTime);
    }

    public final Double getMaxTemperature() {
        return this.maxTemperature;
    }

    public final Double getMinTemperature() {
        return this.minTemperature;
    }

    public final Long getSendTime() {
        return this.sendTime;
    }

    public final Weather getSkycon() {
        return this.skycon;
    }

    public final String getSkyconDesc() {
        return this.skyconDesc;
    }

    public final Long getWeatherTime() {
        return this.weatherTime;
    }

    public final String getWind() {
        return this.wind;
    }

    public final String getWindDirection() {
        return this.windDirection;
    }

    public int hashCode() {
        Double d7 = this.maxTemperature;
        int iHashCode = (d7 == null ? 0 : d7.hashCode()) * 31;
        Double d8 = this.minTemperature;
        int iHashCode2 = (iHashCode + (d8 == null ? 0 : d8.hashCode())) * 31;
        Weather weather = this.skycon;
        int iHashCode3 = (iHashCode2 + (weather == null ? 0 : weather.hashCode())) * 31;
        String str = this.skyconDesc;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.wind;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.windDirection;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l6 = this.weatherTime;
        int iHashCode7 = (iHashCode6 + (l6 == null ? 0 : l6.hashCode())) * 31;
        Long l7 = this.sendTime;
        return iHashCode7 + (l7 != null ? l7.hashCode() : 0);
    }

    public final void setSendTime(Long l6) {
        this.sendTime = l6;
    }

    public final void setWeatherTime(Long l6) {
        this.weatherTime = l6;
    }

    public String toString() {
        return "WeatherInfo(maxTemperature=" + this.maxTemperature + ", minTemperature=" + this.minTemperature + ", skycon=" + this.skycon + ", skyconDesc=" + this.skyconDesc + ", wind=" + this.wind + ", windDirection=" + this.windDirection + ", weatherTime=" + this.weatherTime + ", sendTime=" + this.sendTime + ")";
    }
}
