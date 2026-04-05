package com.uz.navee.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class DfuVerInfo implements Parcelable {
    public static final Parcelable.Creator<DfuVerInfo> CREATOR = new Parcelable.Creator<DfuVerInfo>() { // from class: com.uz.navee.bean.DfuVerInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DfuVerInfo createFromParcel(Parcel parcel) {
            return new DfuVerInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DfuVerInfo[] newArray(int i6) {
            return new DfuVerInfo[i6];
        }
    };
    private String context;
    private String fileUrl;
    private String id;
    private int reminder;
    private int status;
    private String vn;

    public DfuVerInfo(Parcel parcel) {
        this.vn = parcel.readString();
        this.fileUrl = parcel.readString();
        this.context = parcel.readString();
        this.reminder = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getContext() {
        return this.context;
    }

    public String getFileUrl() {
        return this.fileUrl;
    }

    public String getId() {
        return this.id;
    }

    public int getStatus() {
        return this.status;
    }

    public String getVn() {
        return this.vn;
    }

    public boolean isReminder() {
        return this.reminder == 1;
    }

    public void setContext(String str) {
        this.context = str;
    }

    public void setFileUrl(String str) {
        this.fileUrl = str;
    }

    public void setReminder(int i6) {
        this.reminder = i6;
    }

    public void setVn(String str) {
        this.vn = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.vn);
        parcel.writeString(this.fileUrl);
        parcel.writeString(this.context);
        parcel.writeInt(this.reminder);
    }
}
