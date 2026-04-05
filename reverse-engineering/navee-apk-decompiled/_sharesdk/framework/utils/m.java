package cn.sharesdk.framework.utils;

import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;

/* loaded from: classes2.dex */
public class m {
    public static ShapeDrawable a(float f7, int i6) {
        float[] fArr = new float[8];
        float[] fArr2 = new float[8];
        for (int i7 = 0; i7 < 8; i7++) {
            fArr[i7] = 0.0f + f7;
            fArr2[i7] = f7;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, new RectF(0.0f, 0.0f, 0.0f, 0.0f), fArr2));
        shapeDrawable.getPaint().setColor(i6);
        return shapeDrawable;
    }
}
