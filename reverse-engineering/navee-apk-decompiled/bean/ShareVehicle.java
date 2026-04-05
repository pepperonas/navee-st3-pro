package com.uz.navee.bean;

import kotlin.jvm.internal.r;
import kotlin.jvm.internal.y;

/* loaded from: classes3.dex */
public final class ShareVehicle {
    private final String areaKey;
    private final String bindDate;
    private final Integer bindUserId;
    private final String bindUserName;
    private final String createDate;
    private final String email;
    private final String headImg;
    private final String id;
    private final String mac;
    private final String naveeId;
    private final String nickName;
    private final Integer shareVehicleNum;
    private final Integer status;
    private final Integer userId;
    private final String userName;
    private final Integer vehicleId;

    public ShareVehicle() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    public final String component1() {
        return this.areaKey;
    }

    public final String component10() {
        return this.nickName;
    }

    public final Integer component11() {
        return this.shareVehicleNum;
    }

    public final Integer component12() {
        return this.status;
    }

    public final Integer component13() {
        return this.userId;
    }

    public final String component14() {
        return this.userName;
    }

    public final Integer component15() {
        return this.vehicleId;
    }

    public final String component16() {
        return this.naveeId;
    }

    public final String component2() {
        return this.bindDate;
    }

    public final Integer component3() {
        return this.bindUserId;
    }

    public final String component4() {
        return this.bindUserName;
    }

    public final String component5() {
        return this.createDate;
    }

    public final String component6() {
        return this.email;
    }

    public final String component7() {
        return this.headImg;
    }

    public final String component8() {
        return this.id;
    }

    public final String component9() {
        return this.mac;
    }

    public final ShareVehicle copy(String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num2, Integer num3, Integer num4, String str10, Integer num5, String str11) {
        return new ShareVehicle(str, str2, num, str3, str4, str5, str6, str7, str8, str9, num2, num3, num4, str10, num5, str11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShareVehicle)) {
            return false;
        }
        ShareVehicle shareVehicle = (ShareVehicle) obj;
        return y.a(this.areaKey, shareVehicle.areaKey) && y.a(this.bindDate, shareVehicle.bindDate) && y.a(this.bindUserId, shareVehicle.bindUserId) && y.a(this.bindUserName, shareVehicle.bindUserName) && y.a(this.createDate, shareVehicle.createDate) && y.a(this.email, shareVehicle.email) && y.a(this.headImg, shareVehicle.headImg) && y.a(this.id, shareVehicle.id) && y.a(this.mac, shareVehicle.mac) && y.a(this.nickName, shareVehicle.nickName) && y.a(this.shareVehicleNum, shareVehicle.shareVehicleNum) && y.a(this.status, shareVehicle.status) && y.a(this.userId, shareVehicle.userId) && y.a(this.userName, shareVehicle.userName) && y.a(this.vehicleId, shareVehicle.vehicleId) && y.a(this.naveeId, shareVehicle.naveeId);
    }

    public final String getAreaKey() {
        return this.areaKey;
    }

    public final String getBindDate() {
        return this.bindDate;
    }

    public final Integer getBindUserId() {
        return this.bindUserId;
    }

    public final String getBindUserName() {
        return this.bindUserName;
    }

    public final String getCreateDate() {
        return this.createDate;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getHeadImg() {
        return this.headImg;
    }

    public final String getId() {
        return this.id;
    }

    public final String getMac() {
        return this.mac;
    }

    public final String getNaveeId() {
        return this.naveeId;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final Integer getShareVehicleNum() {
        return this.shareVehicleNum;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final Integer getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final Integer getVehicleId() {
        return this.vehicleId;
    }

    public int hashCode() {
        String str = this.areaKey;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.bindDate;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.bindUserId;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.bindUserName;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.createDate;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.email;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.headImg;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.id;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.mac;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.nickName;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Integer num2 = this.shareVehicleNum;
        int iHashCode11 = (iHashCode10 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.status;
        int iHashCode12 = (iHashCode11 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.userId;
        int iHashCode13 = (iHashCode12 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str10 = this.userName;
        int iHashCode14 = (iHashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Integer num5 = this.vehicleId;
        int iHashCode15 = (iHashCode14 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str11 = this.naveeId;
        return iHashCode15 + (str11 != null ? str11.hashCode() : 0);
    }

    public String toString() {
        return "ShareVehicle(areaKey=" + this.areaKey + ", bindDate=" + this.bindDate + ", bindUserId=" + this.bindUserId + ", bindUserName=" + this.bindUserName + ", createDate=" + this.createDate + ", email=" + this.email + ", headImg=" + this.headImg + ", id=" + this.id + ", mac=" + this.mac + ", nickName=" + this.nickName + ", shareVehicleNum=" + this.shareVehicleNum + ", status=" + this.status + ", userId=" + this.userId + ", userName=" + this.userName + ", vehicleId=" + this.vehicleId + ", naveeId=" + this.naveeId + ")";
    }

    public ShareVehicle(String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num2, Integer num3, Integer num4, String str10, Integer num5, String str11) {
        this.areaKey = str;
        this.bindDate = str2;
        this.bindUserId = num;
        this.bindUserName = str3;
        this.createDate = str4;
        this.email = str5;
        this.headImg = str6;
        this.id = str7;
        this.mac = str8;
        this.nickName = str9;
        this.shareVehicleNum = num2;
        this.status = num3;
        this.userId = num4;
        this.userName = str10;
        this.vehicleId = num5;
        this.naveeId = str11;
    }

    public /* synthetic */ ShareVehicle(String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num2, Integer num3, Integer num4, String str10, Integer num5, String str11, int i6, r rVar) {
        this((i6 & 1) != 0 ? null : str, (i6 & 2) != 0 ? null : str2, (i6 & 4) != 0 ? null : num, (i6 & 8) != 0 ? null : str3, (i6 & 16) != 0 ? null : str4, (i6 & 32) != 0 ? null : str5, (i6 & 64) != 0 ? null : str6, (i6 & 128) != 0 ? null : str7, (i6 & 256) != 0 ? null : str8, (i6 & 512) != 0 ? null : str9, (i6 & 1024) != 0 ? null : num2, (i6 & 2048) != 0 ? null : num3, (i6 & 4096) != 0 ? null : num4, (i6 & 8192) != 0 ? null : str10, (i6 & 16384) != 0 ? null : num5, (i6 & 32768) != 0 ? null : str11);
    }
}
