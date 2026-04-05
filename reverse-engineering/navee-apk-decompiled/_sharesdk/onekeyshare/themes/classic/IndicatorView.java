package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/* loaded from: classes2.dex */
public class IndicatorView extends View {
    private static final int DESIGN_BOTTOM_HEIGHT = 52;
    private static final int DESIGN_INDICATOR_DISTANCE = 14;
    private static final int DESIGN_INDICATOR_RADIUS = 6;
    private int count;
    private int current;

    public IndicatorView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.count <= 1) {
            setVisibility(8);
            return;
        }
        float height = getHeight();
        float f7 = (6.0f * height) / 52.0f;
        float f8 = (14.0f * height) / 52.0f;
        float f9 = f7 * 2.0f;
        float width = (getWidth() - ((this.count * f9) + ((r6 - 1) * f8))) / 2.0f;
        float f10 = height / 2.0f;
        canvas.drawColor(-1);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        for (int i6 = 0; i6 < this.count; i6++) {
            if (i6 == this.current) {
                paint.setColor(-10653280);
            } else {
                paint.setColor(-5262921);
            }
            canvas.drawCircle(((f9 + f8) * i6) + width, f10, f7, paint);
        }
    }

    public void onScreenChange(int i6, int i7) {
        if (i6 != this.current) {
            this.current = i6;
            postInvalidate();
        }
    }

    public void setScreenCount(int i6) {
        this.count = i6;
    }
}
