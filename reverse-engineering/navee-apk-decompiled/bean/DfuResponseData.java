package com.uz.navee.bean;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class DfuResponseData {
    ArrayList<DfuVerInfo> bldcList;
    ArrayList<DfuVerInfo> bmsList;
    ArrayList<DfuVerInfo> meterList;
    ArrayList<DfuVerInfo> screenList;

    public ArrayList<DfuVerInfo> getBldcList() {
        return this.bldcList;
    }

    public ArrayList<DfuVerInfo> getBmsList() {
        return this.bmsList;
    }

    public ArrayList<DfuVerInfo> getMeterList() {
        return this.meterList;
    }

    public ArrayList<DfuVerInfo> getScreenList() {
        return this.screenList;
    }

    public void setBldcList(ArrayList<DfuVerInfo> arrayList) {
        this.bldcList = arrayList;
    }

    public void setBmsList(ArrayList<DfuVerInfo> arrayList) {
        this.bmsList = arrayList;
    }

    public void setMeterList(ArrayList<DfuVerInfo> arrayList) {
        this.meterList = arrayList;
    }

    public void setScreenList(ArrayList<DfuVerInfo> arrayList) {
        this.screenList = arrayList;
    }
}
