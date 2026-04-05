package com.uz.navee.ui.device;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.customview.widget.ViewDragHelper;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class SlideLockView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public View f12403a;

    /* renamed from: b, reason: collision with root package name */
    public View f12404b;

    /* renamed from: c, reason: collision with root package name */
    public ViewDragHelper f12405c;

    /* renamed from: d, reason: collision with root package name */
    public d f12406d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f12407e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f12408f;

    public class a extends ViewDragHelper.Callback {

        /* renamed from: a, reason: collision with root package name */
        public int f12409a;

        public a() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i6, int i7) {
            int width = SlideLockView.this.f12403a.getWidth();
            int width2 = SlideLockView.this.getWidth();
            int paddingStart = SlideLockView.this.getPaddingStart();
            int paddingEnd = (width2 - SlideLockView.this.getPaddingEnd()) - width;
            return i6 < paddingStart ? paddingStart : i6 > paddingEnd ? paddingEnd : i6;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i6, int i7) {
            return SlideLockView.this.getPaddingTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i6) {
            super.onViewCaptured(view, i6);
            SlideLockView.this.f12408f = true;
            this.f12409a = view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i6) {
            super.onViewDragStateChanged(i6);
            int width = (SlideLockView.this.getWidth() - SlideLockView.this.getPaddingEnd()) - SlideLockView.this.f12403a.getWidth();
            int paddingStart = SlideLockView.this.getPaddingStart();
            int left = SlideLockView.this.f12403a.getLeft();
            if (i6 == 0) {
                if (left == width) {
                    SlideLockView slideLockView = SlideLockView.this;
                    if (!slideLockView.f12407e) {
                        slideLockView.f12407e = true;
                        slideLockView.f12403a.setSelected(true);
                        SlideLockView.this.f12404b.setScaleX(-1.0f);
                        if (SlideLockView.this.f12406d != null) {
                            SlideLockView.this.f12406d.b(SlideLockView.this.f12408f);
                        }
                    }
                }
                if (left == paddingStart) {
                    SlideLockView slideLockView2 = SlideLockView.this;
                    if (slideLockView2.f12407e) {
                        slideLockView2.f12407e = false;
                        slideLockView2.f12403a.setSelected(false);
                        SlideLockView.this.f12404b.setScaleX(1.0f);
                        if (SlideLockView.this.f12406d != null) {
                            SlideLockView.this.f12406d.a(SlideLockView.this.f12408f);
                        }
                    }
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f7, float f8) {
            super.onViewReleased(view, f7, f8);
            int left = view.getLeft();
            int width = SlideLockView.this.f12403a.getWidth();
            int width2 = SlideLockView.this.getWidth();
            if (left > width2 / 2 || f7 >= 1000.0f) {
                SlideLockView.this.f12405c.settleCapturedViewAt((width2 - SlideLockView.this.getPaddingEnd()) - width, this.f12409a);
            } else {
                SlideLockView.this.f12405c.settleCapturedViewAt(SlideLockView.this.getPaddingStart(), this.f12409a);
            }
            SlideLockView.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i6) {
            return SlideLockView.this.isEnabled() && view == SlideLockView.this.f12403a;
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int[] f12411a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f12412b;

        public b(int[] iArr, int[] iArr2) {
            this.f12411a = iArr;
            this.f12412b = iArr2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12411a[0] = SlideLockView.this.f12403a.getMeasuredWidth();
            int paddingEnd = (this.f12412b[0] - SlideLockView.this.getPaddingEnd()) - this.f12411a[0];
            ViewDragHelper viewDragHelper = SlideLockView.this.f12405c;
            SlideLockView slideLockView = SlideLockView.this;
            viewDragHelper.smoothSlideViewTo(slideLockView.f12403a, paddingEnd, slideLockView.getPaddingTop());
            SlideLockView.this.invalidate();
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int[] f12414a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f12415b;

        public c(int[] iArr, int[] iArr2) {
            this.f12414a = iArr;
            this.f12415b = iArr2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12414a[0] = SlideLockView.this.getMeasuredWidth();
            int paddingEnd = (this.f12414a[0] - SlideLockView.this.getPaddingEnd()) - this.f12415b[0];
            ViewDragHelper viewDragHelper = SlideLockView.this.f12405c;
            SlideLockView slideLockView = SlideLockView.this;
            viewDragHelper.smoothSlideViewTo(slideLockView.f12403a, paddingEnd, slideLockView.getPaddingTop());
            SlideLockView.this.invalidate();
        }
    }

    public interface d {
        void a(boolean z6);

        void b(boolean z6);
    }

    public SlideLockView(@NonNull Context context) {
        super(context);
        this.f12407e = false;
        this.f12408f = false;
        f(context, null, 0);
    }

    private void setLanguageDirection(Context context) {
        if ((context instanceof Activity) && com.uz.navee.utils.d.p((Activity) context)) {
            this.f12403a.setLayoutDirection(0);
            this.f12404b.setLayoutDirection(0);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        ViewDragHelper viewDragHelper = this.f12405c;
        if (viewDragHelper == null || !viewDragHelper.continueSettling(true)) {
            return;
        }
        invalidate();
    }

    public final void e() {
        this.f12403a = findViewById(R$id.lock_btn);
        this.f12404b = findViewById(R$id.trackView);
    }

    public final void f(Context context, AttributeSet attributeSet, int i6) {
        LayoutInflater.from(context).inflate(R$layout.view_slide_lock, this);
        e();
        this.f12405c = ViewDragHelper.create((ViewGroup) getChildAt(0), 1.0f, new a());
        setLanguageDirection(context);
    }

    public void g() {
        this.f12408f = false;
        this.f12404b.setScaleX(1.0f);
        this.f12405c.smoothSlideViewTo(this.f12403a, getPaddingStart(), getPaddingTop());
        invalidate();
    }

    public void h() {
        this.f12408f = false;
        this.f12404b.setScaleX(-1.0f);
        int[] iArr = {this.f12403a.getMeasuredWidth()};
        int[] iArr2 = {getMeasuredWidth()};
        if (iArr[0] == 0) {
            this.f12403a.post(new b(iArr, iArr2));
        }
        if (iArr2[0] == 0) {
            post(new c(iArr2, iArr));
        }
        this.f12405c.smoothSlideViewTo(this.f12403a, (iArr2[0] - getPaddingEnd()) - iArr[0], getPaddingTop());
        invalidate();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (this.f12403a == null) {
            throw new NullPointerException("必须要有一个滑动滑块");
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f12405c.shouldInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f12405c.processTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            performClick();
        }
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void setCallback(d dVar) {
        this.f12406d = dVar;
    }

    @Override // android.view.View
    public void setEnabled(boolean z6) {
        super.setEnabled(z6);
        this.f12403a.setEnabled(z6);
    }

    public SlideLockView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12407e = false;
        this.f12408f = false;
        f(context, attributeSet, 0);
    }

    public SlideLockView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f12407e = false;
        this.f12408f = false;
        f(context, attributeSet, i6);
    }
}
