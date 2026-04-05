package com.uz.navee.bean;

import androidx.annotation.Nullable;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class WarnConfig implements Serializable {
    private String code;
    private String content;
    private String language;
    private String name;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && (obj instanceof WarnConfig) && this.name.equals(((WarnConfig) obj).getName());
    }

    public String getCode() {
        return this.code;
    }

    public String getContent() {
        return this.content;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        return 527 + (str == null ? 0 : str.hashCode());
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
