package com.uz.navee.ui.wheel;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: classes3.dex */
public class BottomCropImage extends AppCompatImageView {
    public BottomCropImage(Context context) {
        super(context);
        j();
    }

    private void j() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i6, int i7, int i8, int i9) {
        float f7;
        float f8;
        Matrix imageMatrix = getImageMatrix();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int intrinsicWidth = getDrawable().getIntrinsicWidth();
        int intrinsicHeight = getDrawable().getIntrinsicHeight();
        if (intrinsicWidth * height > intrinsicHeight * width) {
            f7 = height;
            f8 = intrinsicHeight;
        } else {
            f7 = width;
            f8 = intrinsicWidth;
        }
        float f9 = intrinsicHeight;
        float f10 = height;
        imageMatrix.setRectToRect(new RectF(0.0f, f9 - (f10 / (f7 / f8)), intrinsicWidth, f9), new RectF(0.0f, 0.0f, width, f10), Matrix.ScaleToFit.FILL);
        setImageMatrix(imageMatrix);
        return super.setFrame(i6, i7, i8, i9);
    }

    public BottomCropImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j();
    }

    public BottomCropImage(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        j();
    }
}
