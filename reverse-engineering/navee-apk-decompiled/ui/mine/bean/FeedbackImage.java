package com.uz.navee.ui.mine.bean;

import com.flyjingfish.openimagelib.beans.OpenImageUrl;
import com.flyjingfish.openimagelib.enums.MediaType;

/* loaded from: classes3.dex */
public class FeedbackImage implements OpenImageUrl {
    private String url;

    @Override // com.flyjingfish.openimagelib.beans.OpenImageUrl
    public String getCoverImageUrl() {
        return "";
    }

    @Override // com.flyjingfish.openimagelib.beans.OpenImageUrl
    public String getImageUrl() {
        return this.url;
    }

    @Override // com.flyjingfish.openimagelib.beans.OpenImageUrl
    public MediaType getType() {
        return MediaType.IMAGE;
    }

    public String getUrl() {
        return this.url;
    }

    @Override // com.flyjingfish.openimagelib.beans.OpenImageUrl
    public String getVideoUrl() {
        return "";
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
