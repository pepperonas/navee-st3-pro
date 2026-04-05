package cn.sharesdk.onekeyshare.themes.classic;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import cn.sharesdk.onekeyshare.OnekeySharePage;
import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import com.mob.tools.gui.ScaledImageView;

/* loaded from: classes2.dex */
public class PicViewerPage extends OnekeySharePage implements ViewTreeObserver.OnGlobalLayoutListener {
    private Bitmap pic;
    private ScaledImageView sivViewer;

    public PicViewerPage(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        super(onekeyShareThemeImpl);
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        this.activity.getWindow().setBackgroundDrawable(new ColorDrawable(1275068416));
        ScaledImageView scaledImageView = new ScaledImageView(this.activity);
        this.sivViewer = scaledImageView;
        scaledImageView.setScaleType(ImageView.ScaleType.MATRIX);
        OnekeySharePage.setViewFitsSystemWindows(this.sivViewer);
        this.activity.setContentView(this.sivViewer);
        if (this.pic != null) {
            this.sivViewer.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.sivViewer.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        this.sivViewer.post(new Runnable() { // from class: cn.sharesdk.onekeyshare.themes.classic.PicViewerPage.1
            @Override // java.lang.Runnable
            public void run() {
                PicViewerPage.this.sivViewer.setBitmap(PicViewerPage.this.pic);
            }
        });
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.pic = bitmap;
    }
}
