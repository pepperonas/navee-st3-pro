package com.uz.navee.ui.wheel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Range;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import androidx.core.view.ViewCompat;
import com.uz.navee.R$styleable;
import com.uz.navee.bean.PickTime;
import com.uz.navee.utils.DensityUtil;
import j4.e;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class WheelPicker extends View {
    public boolean A;
    public int B;
    public Rect C;
    public RectF D;
    public int E;
    public int F;
    public int G;
    public Scroller H;
    public int I;
    public boolean J;
    public VelocityTracker L;
    public int M;
    public int Q;
    public int R;
    public boolean S;
    public int T;
    public int U;
    public int V;
    public int W;

    /* renamed from: a, reason: collision with root package name */
    public List f13226a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f13227a0;

    /* renamed from: b, reason: collision with root package name */
    public Format f13228b;

    /* renamed from: b0, reason: collision with root package name */
    public e f13229b0;

    /* renamed from: c, reason: collision with root package name */
    public int f13230c;

    /* renamed from: c0, reason: collision with root package name */
    public Handler f13231c0;

    /* renamed from: d, reason: collision with root package name */
    public int f13232d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f13233d0;

    /* renamed from: e, reason: collision with root package name */
    public TextPaint f13234e;

    /* renamed from: e0, reason: collision with root package name */
    public Range f13235e0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13236f;

    /* renamed from: f0, reason: collision with root package name */
    public Runnable f13237f0;

    /* renamed from: g, reason: collision with root package name */
    public int f13238g;

    /* renamed from: h, reason: collision with root package name */
    public int f13239h;

    /* renamed from: i, reason: collision with root package name */
    public TextPaint f13240i;

    /* renamed from: j, reason: collision with root package name */
    public String f13241j;

    /* renamed from: k, reason: collision with root package name */
    public int f13242k;

    /* renamed from: l, reason: collision with root package name */
    public int f13243l;

    /* renamed from: m, reason: collision with root package name */
    public TextPaint f13244m;

    /* renamed from: n, reason: collision with root package name */
    public Paint f13245n;

    /* renamed from: o, reason: collision with root package name */
    public Paint f13246o;

    /* renamed from: p, reason: collision with root package name */
    public int f13247p;

    /* renamed from: q, reason: collision with root package name */
    public int f13248q;

    /* renamed from: r, reason: collision with root package name */
    public String f13249r;

    /* renamed from: s, reason: collision with root package name */
    public int f13250s;

    /* renamed from: t, reason: collision with root package name */
    public int f13251t;

    /* renamed from: u, reason: collision with root package name */
    public int f13252u;

    /* renamed from: v, reason: collision with root package name */
    public int f13253v;

    /* renamed from: w, reason: collision with root package name */
    public int f13254w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f13255x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f13256y;

    /* renamed from: z, reason: collision with root package name */
    public int f13257z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int iIntValue;
            if (WheelPicker.this.H.computeScrollOffset()) {
                WheelPicker wheelPicker = WheelPicker.this;
                wheelPicker.Q = wheelPicker.H.getCurrY();
                WheelPicker.this.postInvalidate();
                WheelPicker.this.f13231c0.postDelayed(this, 16L);
            }
            if ((WheelPicker.this.H.isFinished() || (WheelPicker.this.H.getFinalY() == WheelPicker.this.H.getCurrY() && WheelPicker.this.H.getFinalX() == WheelPicker.this.H.getCurrX())) && WheelPicker.this.f13253v != 0) {
                int iP = WheelPicker.this.p((-WheelPicker.this.Q) / WheelPicker.this.f13253v);
                if (WheelPicker.this.f13235e0 == null || iP == (iIntValue = ((Integer) WheelPicker.this.f13235e0.clamp(Integer.valueOf(iP))).intValue()) || WheelPicker.this.J) {
                    if (WheelPicker.this.f13254w != iP) {
                        WheelPicker.this.f13254w = iP;
                        WheelPicker.d(WheelPicker.this);
                        return;
                    }
                    return;
                }
                if (!WheelPicker.this.H.isFinished()) {
                    WheelPicker.this.H.abortAnimation();
                }
                WheelPicker.this.H.startScroll(0, WheelPicker.this.Q, 0, (iP - iIntValue) * WheelPicker.this.f13253v);
                WheelPicker.this.H.setFinalY((-iIntValue) * WheelPicker.this.f13253v);
                WheelPicker.this.f13231c0.post(WheelPicker.this.f13237f0);
            }
        }
    }

    public interface b {
    }

    public WheelPicker(Context context) {
        this(context, null);
    }

    public static /* bridge */ /* synthetic */ b d(WheelPicker wheelPicker) {
        wheelPicker.getClass();
        return null;
    }

    public int getCurrentPosition() {
        return this.f13254w;
    }

    public int getCurtainBorderColor() {
        return this.B;
    }

    public int getCurtainColor() {
        return this.f13257z;
    }

    public Format getDataFormat() {
        return this.f13228b;
    }

    public List<PickTime> getDataList() {
        return this.f13226a;
    }

    public int getDataListSize() {
        List list = this.f13226a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public int getHalfVisibleItemCount() {
        return this.f13250s;
    }

    public Paint getIndicatorPaint() {
        return this.f13244m;
    }

    public int getItemHeightSpace() {
        return this.f13251t;
    }

    public String getItemMaximumWidthText() {
        return this.f13249r;
    }

    public int getItemWidthSpace() {
        return this.f13252u;
    }

    public int getMaximumVelocity() {
        return this.W;
    }

    public int getMinimumVelocity() {
        return this.V;
    }

    public Paint getPaint() {
        return this.f13245n;
    }

    public Paint getSelectedItemPaint() {
        return this.f13240i;
    }

    public int getSelectedItemTextColor() {
        return this.f13238g;
    }

    public int getSelectedItemTextSize() {
        return this.f13239h;
    }

    public int getTextColor() {
        return this.f13230c;
    }

    public Paint getTextPaint() {
        return this.f13234e;
    }

    public int getTextSize() {
        return this.f13232d;
    }

    public int getVisibleItemCount() {
        return (this.f13250s * 2) + 1;
    }

    public final int m(int i6) {
        int iAbs = Math.abs(i6);
        int i7 = this.f13253v;
        return iAbs > i7 / 2 ? this.Q < 0 ? (-i7) - i6 : i7 - i6 : -i6;
    }

    public final void n() {
        this.U = this.S ? Integer.MIN_VALUE : (-this.f13253v) * (this.f13226a.size() - 1);
        this.T = this.S ? Integer.MAX_VALUE : 0;
    }

    public final void o() {
        this.f13248q = 0;
        this.f13247p = 0;
        if (this.f13226a.size() == 0) {
            return;
        }
        Paint paint = this.f13245n;
        int i6 = this.f13239h;
        int i7 = this.f13232d;
        paint.setTextSize(i6 > i7 ? i6 : i7);
        if (TextUtils.isEmpty(this.f13249r)) {
            this.f13247p = (int) this.f13245n.measureText(((PickTime) this.f13226a.get(0)).toString());
        } else {
            this.f13247p = (int) this.f13245n.measureText(this.f13249r);
        }
        Paint.FontMetrics fontMetrics = this.f13245n.getFontMetrics();
        this.f13248q = (int) (fontMetrics.bottom - fontMetrics.top);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x01aa  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDraw(android.graphics.Canvas r20) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uz.navee.ui.wheel.WheelPicker.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public void onMeasure(int i6, int i7) {
        int size = View.MeasureSpec.getSize(i6);
        int mode = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i7);
        int mode2 = View.MeasureSpec.getMode(i7);
        int i8 = this.f13247p + this.f13252u;
        int visibleItemCount = (this.f13248q + this.f13251t) * getVisibleItemCount();
        setMeasuredDimension(s(mode, size, i8 + getPaddingLeft() + getPaddingRight()), s(mode2, size2, visibleItemCount + getPaddingTop() + getPaddingBottom()));
    }

    @Override // android.view.View
    public void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.C.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.f13253v = this.C.height() / getVisibleItemCount();
        this.E = this.C.centerX();
        this.F = 0;
        this.G = this.f13253v * this.f13250s;
        Paint.FontMetrics fontMetrics = this.f13240i.getFontMetrics();
        float f7 = fontMetrics.bottom - fontMetrics.top;
        this.D.set(getPaddingLeft(), this.G - ((this.f13253v - f7) / 2.0f), getWidth() - getPaddingRight(), (this.G + r2) - ((this.f13253v - f7) / 2.0f));
        n();
        this.Q = (-this.f13253v) * this.f13254w;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uz.navee.ui.wheel.WheelPicker.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final int p(int i6) {
        if (i6 < 0) {
            i6 = (i6 % this.f13226a.size()) + this.f13226a.size();
        }
        return i6 >= this.f13226a.size() ? i6 % this.f13226a.size() : i6;
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public final void q(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.WheelPicker);
        this.f13232d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.WheelPicker_itemTextSize, 80);
        this.f13230c = typedArrayObtainStyledAttributes.getColor(R$styleable.WheelPicker_itemTextColor, ViewCompat.MEASURED_STATE_MASK);
        this.f13236f = typedArrayObtainStyledAttributes.getBoolean(R$styleable.WheelPicker_textGradual, true);
        this.S = typedArrayObtainStyledAttributes.getBoolean(R$styleable.WheelPicker_wheelCyclic, false);
        this.f13250s = typedArrayObtainStyledAttributes.getInteger(R$styleable.WheelPicker_halfVisibleItemCount, 2);
        this.f13249r = typedArrayObtainStyledAttributes.getString(R$styleable.WheelPicker_itemMaximumWidthText);
        this.f13238g = typedArrayObtainStyledAttributes.getColor(R$styleable.WheelPicker_selectedTextColor, Color.parseColor("#33aaff"));
        this.f13239h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.WheelPicker_selectedTextSize, 100);
        this.f13254w = typedArrayObtainStyledAttributes.getInteger(R$styleable.WheelPicker_currentItemPosition, 0);
        this.f13252u = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.WheelPicker_itemWidthSpace, 20);
        this.f13251t = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.WheelPicker_itemHeightSpace, 20);
        this.f13255x = typedArrayObtainStyledAttributes.getBoolean(R$styleable.WheelPicker_zoomInSelectedItem, true);
        this.f13256y = typedArrayObtainStyledAttributes.getBoolean(R$styleable.WheelPicker_wheelCurtain, true);
        this.f13257z = typedArrayObtainStyledAttributes.getColor(R$styleable.WheelPicker_wheelCurtainColor, Color.parseColor("#303d3d3d"));
        this.A = typedArrayObtainStyledAttributes.getBoolean(R$styleable.WheelPicker_wheelCurtainBorder, true);
        this.B = typedArrayObtainStyledAttributes.getColor(R$styleable.WheelPicker_wheelCurtainBorderColor, ViewCompat.MEASURED_STATE_MASK);
        this.f13241j = typedArrayObtainStyledAttributes.getString(R$styleable.WheelPicker_indicatorText);
        this.f13242k = typedArrayObtainStyledAttributes.getColor(R$styleable.WheelPicker_indicatorTextColor, this.f13238g);
        this.f13243l = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.WheelPicker_indicatorTextSize, this.f13232d);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void r() {
        Paint paint = new Paint(69);
        this.f13245n = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        Paint paint2 = this.f13245n;
        Paint.Align align = Paint.Align.CENTER;
        paint2.setTextAlign(align);
        TextPaint textPaint = new TextPaint(69);
        this.f13234e = textPaint;
        textPaint.setStyle(style);
        this.f13234e.setTextAlign(align);
        this.f13234e.setColor(this.f13230c);
        this.f13234e.setTextSize(this.f13232d);
        TextPaint textPaint2 = new TextPaint(69);
        this.f13240i = textPaint2;
        textPaint2.setStyle(style);
        this.f13240i.setTextAlign(align);
        this.f13240i.setColor(this.f13238g);
        this.f13240i.setTextSize(this.f13239h);
        TextPaint textPaint3 = new TextPaint(69);
        this.f13244m = textPaint3;
        textPaint3.setStyle(style);
        TextPaint textPaint4 = this.f13244m;
        Paint.Align align2 = Paint.Align.LEFT;
        textPaint4.setTextAlign(align2);
        this.f13244m.setColor(this.f13242k);
        this.f13244m.setTextSize(this.f13243l);
        TextPaint textPaint5 = new TextPaint(69);
        this.f13246o = textPaint5;
        textPaint5.setStyle(style);
        this.f13246o.setTextAlign(align2);
        this.f13246o.setColor(this.f13230c);
        this.f13246o.setTextSize(DensityUtil.c(getContext(), 10.0f));
    }

    public final int s(int i6, int i7, int i8) {
        return i6 == 1073741824 ? i7 : Math.min(i7, i8);
    }

    public void setCurrentPosition(int i6) {
        u(i6, true, true);
    }

    public void setCurtainBorderColor(int i6) {
        if (this.B == i6) {
            return;
        }
        this.B = i6;
        postInvalidate();
    }

    public void setCurtainColor(int i6) {
        if (this.f13257z == i6) {
            return;
        }
        this.f13257z = i6;
        postInvalidate();
    }

    public void setCyclic(boolean z6) {
        if (this.S == z6) {
            return;
        }
        this.S = z6;
        n();
        requestLayout();
    }

    public void setDataFormat(Format format) {
        this.f13228b = format;
        postInvalidate();
    }

    public void setDataList(List<PickTime> list) {
        this.f13226a = list;
        if (list.size() == 0) {
            return;
        }
        o();
        n();
        requestLayout();
        postInvalidate();
    }

    public void setHalfVisibleItemCount(int i6) {
        if (this.f13250s == i6) {
            return;
        }
        this.f13250s = i6;
        requestLayout();
    }

    public void setIndicatorText(String str) {
        this.f13241j = str;
        postInvalidate();
    }

    public void setIndicatorTextColor(int i6) {
        this.f13242k = i6;
        this.f13244m.setColor(i6);
        postInvalidate();
    }

    public void setIndicatorTextSize(int i6) {
        this.f13243l = i6;
        this.f13244m.setTextSize(i6);
        postInvalidate();
    }

    public void setItemHeightSpace(int i6) {
        if (this.f13251t == i6) {
            return;
        }
        this.f13251t = i6;
        requestLayout();
    }

    public void setItemMaximumWidthText(String str) {
        this.f13249r = str;
        requestLayout();
        postInvalidate();
    }

    public void setItemWidthSpace(int i6) {
        if (this.f13252u == i6) {
            return;
        }
        this.f13252u = i6;
        requestLayout();
    }

    public void setMaximumVelocity(int i6) {
        this.W = i6;
    }

    public void setMinimumVelocity(int i6) {
        this.V = i6;
    }

    public void setOnWheelChangeListener(b bVar) {
    }

    public void setScrollEnable(boolean z6) {
        this.f13233d0 = z6;
    }

    public void setSelectRange(Range<Integer> range) {
        this.f13235e0 = range;
        if (this.f13254w < ((Integer) range.getLower()).intValue()) {
            setCurrentPosition(((Integer) range.getLower()).intValue());
        } else if (this.f13254w > ((Integer) range.getUpper()).intValue()) {
            setCurrentPosition(((Integer) range.getUpper()).intValue());
        }
    }

    public void setSelectedItemTextColor(int i6) {
        if (this.f13238g == i6) {
            return;
        }
        this.f13240i.setColor(i6);
        this.f13238g = i6;
        this.f13229b0.b(i6);
        postInvalidate();
    }

    public void setSelectedItemTextSize(int i6) {
        if (this.f13239h == i6) {
            return;
        }
        this.f13240i.setTextSize(i6);
        this.f13239h = i6;
        o();
        postInvalidate();
    }

    public void setShowCurtain(boolean z6) {
        if (this.f13256y == z6) {
            return;
        }
        this.f13256y = z6;
        postInvalidate();
    }

    public void setShowCurtainBorder(boolean z6) {
        if (this.A == z6) {
            return;
        }
        this.A = z6;
        postInvalidate();
    }

    public void setTextColor(int i6) {
        if (this.f13230c == i6) {
            return;
        }
        this.f13234e.setColor(i6);
        this.f13230c = i6;
        this.f13229b0.c(i6);
        postInvalidate();
    }

    public void setTextGradual(boolean z6) {
        if (this.f13236f == z6) {
            return;
        }
        this.f13236f = z6;
        postInvalidate();
    }

    public void setTextSize(int i6) {
        if (this.f13232d == i6) {
            return;
        }
        this.f13232d = i6;
        this.f13234e.setTextSize(i6);
        o();
        postInvalidate();
    }

    public void setZoomInSelectedItem(boolean z6) {
        if (this.f13255x == z6) {
            return;
        }
        this.f13255x = z6;
        postInvalidate();
    }

    public final void t() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    public synchronized void u(int i6, boolean z6, boolean z7) {
        int i7;
        try {
            if (i6 > this.f13226a.size() - 1) {
                i6 = this.f13226a.size() - 1;
            }
            if (i6 < 0) {
                i6 = 0;
            }
            if (this.f13254w == i6) {
                return;
            }
            if (!this.H.isFinished()) {
                this.H.abortAnimation();
            }
            if (!z6 || (i7 = this.f13253v) <= 0) {
                this.f13254w = i6;
                this.Q = (-this.f13253v) * i6;
                postInvalidate();
            } else {
                this.H.startScroll(0, this.Q, 0, (this.f13254w - i6) * i7);
                this.H.setFinalY((-i6) * this.f13253v);
                this.f13231c0.post(this.f13237f0);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public WheelPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WheelPicker(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f13226a = new ArrayList();
        this.S = true;
        this.V = 50;
        this.W = 12000;
        this.f13231c0 = new Handler();
        this.f13233d0 = true;
        this.f13237f0 = new a();
        q(context, attributeSet);
        r();
        this.f13229b0 = new e(this.f13230c, this.f13238g);
        this.C = new Rect();
        this.D = new RectF();
        this.H = new Scroller(context);
        this.I = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
