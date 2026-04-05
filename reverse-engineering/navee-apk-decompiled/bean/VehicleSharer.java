package com.uz.navee.bean;

import kotlin.jvm.internal.y;

/* loaded from: classes3.dex */
public final class VehicleSharer {
    private final String email;
    private final String headImg;
    private final Integer id;
    private final String naveeId;
    private final String nickName;
    private final Integer userId;
    private final String userName;

    public VehicleSharer(String str, String str2, Integer num, String str3, String str4, Integer num2, String str5) {
        this.email = str;
        this.headImg = str2;
        this.id = num;
        this.naveeId = str3;
        this.nickName = str4;
        this.userId = num2;
        this.userName = str5;
    }

    public static /* synthetic */ VehicleSharer copy$default(VehicleSharer vehicleSharer, String str, String str2, Integer num, String str3, String str4, Integer num2, String str5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = vehicleSharer.email;
        }
        if ((i6 & 2) != 0) {
            str2 = vehicleSharer.headImg;
        }
        String str6 = str2;
        if ((i6 & 4) != 0) {
            num = vehicleSharer.id;
        }
        Integer num3 = num;
        if ((i6 & 8) != 0) {
            str3 = vehicleSharer.naveeId;
        }
        String str7 = str3;
        if ((i6 & 16) != 0) {
            str4 = vehicleSharer.nickName;
        }
        String str8 = str4;
        if ((i6 & 32) != 0) {
            num2 = vehicleSharer.userId;
        }
        Integer num4 = num2;
        if ((i6 & 64) != 0) {
            str5 = vehicleSharer.userName;
        }
        return vehicleSharer.copy(str, str6, num3, str7, str8, num4, str5);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.headImg;
    }

    public final Integer component3() {
        return this.id;
    }

    public final String component4() {
        return this.naveeId;
    }

    public final String component5() {
        return this.nickName;
    }

    public final Integer component6() {
        return this.userId;
    }

    public final String component7() {
        return this.userName;
    }

    public final VehicleSharer copy(String str, String str2, Integer num, String str3, String str4, Integer num2, String str5) {
        return new VehicleSharer(str, str2, num, str3, str4, num2, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VehicleSharer)) {
            return false;
        }
        VehicleSharer vehicleSharer = (VehicleSharer) obj;
        return y.a(this.email, vehicleSharer.email) && y.a(this.headImg, vehicleSharer.headImg) && y.a(this.id, vehicleSharer.id) && y.a(this.naveeId, vehicleSharer.naveeId) && y.a(this.nickName, vehicleSharer.nickName) && y.a(this.userId, vehicleSharer.userId) && y.a(this.userName, vehicleSharer.userName);
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getHeadImg() {
        return this.headImg;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getNaveeId() {
        return this.naveeId;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final Integer getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        String str = this.email;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.headImg;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.id;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.naveeId;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.nickName;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num2 = this.userId;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str5 = this.userName;
        return iHashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "VehicleSharer(email=" + this.email + ", headImg=" + this.headImg + ", id=" + this.id + ", naveeId=" + this.naveeId + ", nickName=" + this.nickName + ", userId=" + this.userId + ", userName=" + this.userName + ")";
    }
}
