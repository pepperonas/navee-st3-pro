package com.uz.navee.bean;

import b4.a;
import b4.d;
import com.uz.navee.ble.AreaCode;
import com.uz.navee.ble.SKUVersion;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class Vehicle implements Serializable {
    public String activateDate;
    public String bindDate;
    public Integer bindType;
    public String carNo;
    public String latlngCountryName;
    public int latlngCountryValue;
    public String mac;
    public VehicleModel model;
    public String shareDate;
    public int shareUserId;
    public String shareUserName;
    public String vehicleName;

    public AreaCode areaCode() {
        return a.b(this.carNo);
    }

    public String displayName() {
        String strDisplayName = this.model.displayName();
        String str = this.vehicleName;
        return (str == null || str.isEmpty()) ? (strDisplayName == null || strDisplayName.isEmpty()) ? "NAVEE" : strDisplayName : this.vehicleName;
    }

    public String getValidBluetoothAddress() {
        return a.w(this.mac);
    }

    public Boolean showActivateDate() {
        String str = this.model.pid;
        return Boolean.valueOf(((d.j(str, "2213", "2314", "2327", "2328", "2329", "2326", "2322", "2333", "2334", "2332", "2305", "2306", "2315", "2353", "2417", "2422", "2548", "2549") || d.g(str) || d.b(str)) && skuVersion() == SKUVersion.USA) ? false : true);
    }

    public SKUVersion skuVersion() {
        return a.X(areaCode());
    }
}
