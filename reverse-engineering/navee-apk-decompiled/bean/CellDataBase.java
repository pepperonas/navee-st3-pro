package com.uz.navee.bean;

import android.view.View;
import android.widget.CompoundButton;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class CellDataBase implements Serializable {
    protected View.OnClickListener callback;
    protected int customType;
    protected String subtitle;
    protected CompoundButton.OnCheckedChangeListener switchCallback;
    protected String title;
    protected CellAccessoryType accessoryType = CellAccessoryType.NONE;
    protected boolean isChecked = false;

    public CellAccessoryType getAccessoryType() {
        return this.accessoryType;
    }

    public View.OnClickListener getCallback() {
        return this.callback;
    }

    public int getCustomType() {
        return this.customType;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public CompoundButton.OnCheckedChangeListener getSwitchCallback() {
        return this.switchCallback;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setAccessoryType(CellAccessoryType cellAccessoryType) {
        this.accessoryType = cellAccessoryType;
    }

    public void setCallback(View.OnClickListener onClickListener) {
        this.callback = onClickListener;
    }

    public void setChecked(boolean z6) {
        this.isChecked = z6;
    }

    public void setCustomType(int i6) {
        this.customType = i6;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public void setSwitchCallback(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.switchCallback = onCheckedChangeListener;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
