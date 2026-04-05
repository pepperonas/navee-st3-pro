package com.uz.navee.ui.device;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.base.BaseActivity;

/* loaded from: classes3.dex */
public class SlideProgressView extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    public AppCompatSeekBar f12417a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f12418b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12419c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean[] f12420d;

    /* renamed from: e, reason: collision with root package name */
    public int f12421e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f12422f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f12423g;

    /* renamed from: h, reason: collision with root package name */
    public b f12424h;

    public class a implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12425a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f12426b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f12427c;

        public a(int i6, int i7, int i8) {
            this.f12425a = i6;
            this.f12426b = i7;
            this.f12427c = i8;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i6, boolean z6) {
            int iMax = i6 / (this.f12425a / 9);
            if (SlideProgressView.this.f12423g) {
                iMax = Math.max(1, iMax);
            }
            int iMin = Math.min(iMax, 9);
            if (iMin != SlideProgressView.this.f12421e) {
                SlideProgressView.this.f12421e = iMin;
                if (SlideProgressView.this.f12424h != null) {
                    SlideProgressView.this.f12424h.c(SlideProgressView.this.f12421e, z6);
                }
                if (z6) {
                    SlideProgressView slideProgressView = SlideProgressView.this;
                    Activity activityO = slideProgressView.o(slideProgressView.getContext());
                    if (activityO instanceof BaseActivity) {
                        ((BaseActivity) activityO).P(30);
                    }
                }
            }
            int i7 = SlideProgressView.this.f12421e * this.f12426b;
            if (SlideProgressView.this.f12421e == 9) {
                i7 = this.f12427c;
            }
            SlideProgressView.this.f12418b.setClipBounds(new Rect(0, 0, i7, SlideProgressView.this.f12418b.getHeight()));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            SlideProgressView.this.f12422f = true;
            if (SlideProgressView.this.f12424h != null) {
                SlideProgressView.this.f12424h.a();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SlideProgressView.this.f12422f = false;
            if (SlideProgressView.this.f12424h != null) {
                SlideProgressView.this.f12424h.b(SlideProgressView.this.f12421e);
            }
        }
    }

    public interface b {
        void a();

        void b(int i6);

        void c(int i6, boolean z6);
    }

    public SlideProgressView(@NonNull Context context) {
        super(context);
        this.f12419c = 10;
        this.f12420d = new boolean[]{false};
        p(context, null, 0);
    }

    private void n() {
        this.f12417a = (AppCompatSeekBar) findViewById(R$id.seekBar);
        this.f12418b = (ImageView) findViewById(R$id.progressView);
    }

    private void p(Context context, AttributeSet attributeSet, int i6) {
        LayoutInflater.from(context).inflate(R$layout.view_slide_progress, this);
        n();
        r();
    }

    public int getCurrentSection() {
        return this.f12421e;
    }

    public final Activity o(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return o(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public final /* synthetic */ void q() {
        int max = this.f12417a.getMax();
        if (!this.f12420d[0]) {
            int measuredWidth = this.f12418b.getMeasuredWidth();
            this.f12417a.setOnSeekBarChangeListener(new a(max, measuredWidth / 9, measuredWidth));
            this.f12420d[0] = true;
        }
        int i6 = (this.f12421e * max) / 9;
        if (Build.VERSION.SDK_INT >= 24) {
            this.f12417a.setProgress(i6, false);
        } else {
            this.f12417a.setProgress(i6);
        }
    }

    public final void r() {
        this.f12418b.postDelayed(new Runnable() { // from class: com.uz.navee.ui.device.e8
            @Override // java.lang.Runnable
            public final void run() {
                this.f12508a.q();
            }
        }, 50L);
    }

    public void setCallBack(b bVar) {
        this.f12424h = bVar;
    }

    public void setCurrentSection(int i6) {
        if (i6 < 0) {
            this.f12421e = 0;
        } else {
            this.f12421e = Math.min(i6, 9);
        }
        r();
    }

    @Override // android.view.View
    public void setEnabled(boolean z6) {
        super.setEnabled(z6);
        this.f12417a.setEnabled(z6);
        this.f12417a.setAlpha(z6 ? 1.0f : 0.4f);
        this.f12418b.setAlpha(z6 ? 1.0f : 0.4f);
    }

    public SlideProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12419c = 10;
        this.f12420d = new boolean[]{false};
        p(context, attributeSet, 0);
    }

    public SlideProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f12419c = 10;
        this.f12420d = new boolean[]{false};
        p(context, attributeSet, i6);
    }
}
