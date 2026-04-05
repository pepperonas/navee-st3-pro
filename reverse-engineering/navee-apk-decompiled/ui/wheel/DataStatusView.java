package com.uz.navee.ui.wheel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class DataStatusView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public View f13201a;

    /* renamed from: b, reason: collision with root package name */
    public View f13202b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f13203c;

    /* renamed from: d, reason: collision with root package name */
    public Button f13204d;

    /* renamed from: e, reason: collision with root package name */
    public View.OnClickListener f13205e;

    /* renamed from: f, reason: collision with root package name */
    public DataStatus f13206f;

    public enum DataStatus {
        empty,
        loading,
        success,
        failure
    }

    public DataStatusView(@NonNull Context context) {
        super(context);
        this.f13206f = DataStatus.empty;
        b(context, null, 0);
    }

    public final void a() {
        this.f13201a = findViewById(R$id.leftLine);
        this.f13202b = findViewById(R$id.rightLine);
        this.f13203c = (TextView) findViewById(R$id.textLabel);
        this.f13204d = (Button) findViewById(R$id.actionButton);
    }

    public final void b(Context context, AttributeSet attributeSet, int i6) {
        LayoutInflater.from(context).inflate(R$layout.view_data_status, this);
        a();
        this.f13204d.setOnClickListener(this.f13205e);
    }

    public DataStatus getStatus() {
        return this.f13206f;
    }

    public void setActionButtonClickListener(View.OnClickListener onClickListener) {
        this.f13205e = onClickListener;
        this.f13204d.setOnClickListener(onClickListener);
    }

    public void setStatus(DataStatus dataStatus) {
        this.f13206f = dataStatus;
        int iOrdinal = dataStatus.ordinal();
        if (iOrdinal == 0) {
            this.f13203c.setText(getContext().getString(R$string.data_status_empty));
            this.f13203c.setVisibility(0);
            this.f13204d.setVisibility(8);
            this.f13201a.setVisibility(0);
            this.f13202b.setVisibility(0);
            return;
        }
        if (iOrdinal == 1) {
            this.f13203c.setText(getContext().getString(R$string.data_status_loading));
            this.f13203c.setVisibility(0);
            this.f13204d.setVisibility(8);
            this.f13201a.setVisibility(8);
            this.f13202b.setVisibility(8);
            return;
        }
        if (iOrdinal == 2) {
            this.f13203c.setVisibility(8);
            this.f13204d.setVisibility(8);
            this.f13201a.setVisibility(8);
            this.f13202b.setVisibility(8);
            return;
        }
        if (iOrdinal != 3) {
            return;
        }
        this.f13203c.setText(getContext().getString(R$string.data_status_fail));
        this.f13203c.setVisibility(0);
        this.f13204d.setVisibility(0);
        this.f13201a.setVisibility(8);
        this.f13202b.setVisibility(8);
    }

    public void setText(String str) {
        this.f13203c.setText(str);
    }

    public DataStatusView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13206f = DataStatus.empty;
        b(context, attributeSet, 0);
    }

    public DataStatusView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f13206f = DataStatus.empty;
        b(context, attributeSet, i6);
    }
}
