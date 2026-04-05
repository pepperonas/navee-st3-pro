package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/* loaded from: classes2.dex */
public class XView extends View {
    private float ratio;

    public XView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-6250336);
        float f7 = width;
        canvas.drawRect(f7, 0.0f, getWidth(), height, paint);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(this.ratio * 3.0f);
        paint2.setColor(-1);
        float f8 = 8.0f * this.ratio;
        float f9 = f7 + f8;
        float f10 = f7 - f8;
        canvas.drawLine(f9, f8, getWidth() - f8, f10, paint2);
        canvas.drawLine(f9, f10, getWidth() - f8, f8, paint2);
    }

    public void setRatio(float f7) {
        this.ratio = f7;
    }
}
