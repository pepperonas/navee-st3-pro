package com.uz.navee.ui.wheel;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.y;

/* loaded from: classes3.dex */
public final class GridItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final int f13222a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13223b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13224c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f13225d;

    public GridItemDecoration(int i6, int i7, int i8) {
        this.f13222a = i6;
        this.f13223b = i7;
        this.f13224c = i8;
        Paint paint = new Paint();
        paint.setColor(i8);
        paint.setStyle(Paint.Style.FILL);
        this.f13225d = paint;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        y.f(outRect, "outRect");
        y.f(view, "view");
        y.f(parent, "parent");
        y.f(state, "state");
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        int i6 = this.f13222a;
        int i7 = childAdapterPosition % i6;
        int i8 = this.f13223b;
        outRect.left = i8 - ((i7 * i8) / i6);
        outRect.right = ((i7 + 1) * i8) / i6;
        outRect.top = i8;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas c7, RecyclerView parent, RecyclerView.State state) {
        y.f(c7, "c");
        y.f(parent, "parent");
        y.f(state, "state");
        int childCount = parent.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = parent.getChildAt(i6);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            y.d(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            float bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
            c7.drawRect(childAt.getLeft(), bottom, childAt.getRight(), bottom + this.f13223b, this.f13225d);
            float right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
            c7.drawRect(right, childAt.getTop(), right + this.f13223b, childAt.getBottom(), this.f13225d);
        }
    }
}
