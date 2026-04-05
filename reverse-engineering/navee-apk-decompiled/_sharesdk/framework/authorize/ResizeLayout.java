package cn.sharesdk.framework.authorize;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes2.dex */
public class ResizeLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private OnResizeListener f6353a;

    public interface OnResizeListener {
        void OnResize(int i6, int i7, int i8, int i9);
    }

    public ResizeLayout(Context context) {
        super(context);
    }

    public void a(OnResizeListener onResizeListener) {
        this.f6353a = onResizeListener;
    }

    @Override // android.view.View
    public void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        OnResizeListener onResizeListener = this.f6353a;
        if (onResizeListener != null) {
            onResizeListener.OnResize(i6, i7, i8, i9);
        }
    }

    public ResizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
