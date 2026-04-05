package com.uz.navee.ui.device;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class DeviceGridItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final int f12099a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12100b;

    public DeviceGridItemDecoration(int i6, int i7) {
        this.f12099a = i6;
        this.f12100b = i7;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i6 = childAdapterPosition % 2;
        int i7 = this.f12099a;
        rect.left = i7 - ((i6 * i7) / 2);
        rect.right = ((i6 + 1) * i7) / 2;
        if (childAdapterPosition >= 2) {
            rect.top = this.f12100b;
        }
    }
}
