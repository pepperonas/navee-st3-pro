package cn.sharesdk.onekeyshare.themes.classic.port;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import cn.sharesdk.onekeyshare.OnekeySharePage;
import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.onekeyshare.themes.classic.EditPage;
import cn.sharesdk.onekeyshare.themes.classic.XView;
import com.mob.tools.gui.AsyncImageView;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.ResHelper;
import java.io.File;

/* loaded from: classes2.dex */
public class EditPagePort extends EditPage {
    private static final int DESIGN_BOTTOM_HEIGHT = 75;
    private static final int DESIGN_LEFT_PADDING = 40;
    private static final int DESIGN_REMOVE_THUMB_HEIGHT = 70;
    private static final int DESIGN_SCREEN_HEIGHT = 1280;
    private static final int DESIGN_THUMB_HEIGHT = 300;
    private static final int DESIGN_TITLE_HEIGHT = 96;

    public EditPagePort(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        super(onekeyShareThemeImpl);
    }

    private void initBody(RelativeLayout relativeLayout, float f7) {
        ScrollView scrollView = new ScrollView(this.activity);
        this.svContent = scrollView;
        relativeLayout.addView(scrollView, new RelativeLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(this.activity);
        linearLayout.setOrientation(1);
        this.svContent.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        EditText editText = new EditText(this.activity);
        this.etContent = editText;
        int i6 = (int) (40.0f * f7);
        editText.setPadding(i6, i6, i6, i6);
        this.etContent.setBackgroundDrawable(null);
        this.etContent.setTextColor(-12895429);
        this.etContent.setTextSize(2, 21.0f);
        this.etContent.setText(this.sp.getText());
        linearLayout.addView(this.etContent, new LinearLayout.LayoutParams(-1, -2));
        this.etContent.addTextChangedListener(this);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.activity);
        this.rlThumb = relativeLayout2;
        relativeLayout2.setBackgroundColor(-13553359);
        int i7 = (int) (300.0f * f7);
        int i8 = (int) (70.0f * f7);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i7, i7);
        layoutParams.topMargin = i6;
        layoutParams.bottomMargin = i6;
        layoutParams.rightMargin = i6;
        layoutParams.leftMargin = i6;
        linearLayout.addView(this.rlThumb, layoutParams);
        AsyncImageView asyncImageView = new AsyncImageView(this.activity) { // from class: cn.sharesdk.onekeyshare.themes.classic.port.EditPagePort.1
            @Override // com.mob.tools.gui.AsyncImageView, com.mob.tools.gui.BitmapProcessor.BitmapCallback
            public void onImageGot(String str, Bitmap bitmap) {
                ((EditPage) EditPagePort.this).thumb = bitmap;
                super.onImageGot(str, bitmap);
            }
        };
        this.aivThumb = asyncImageView;
        asyncImageView.setScaleToCropCenter(true);
        this.rlThumb.addView(this.aivThumb, new RelativeLayout.LayoutParams(i7, i7));
        this.aivThumb.setOnClickListener(this);
        initThumb(this.aivThumb);
        XView xView = new XView(this.activity);
        this.xvRemove = xView;
        xView.setRatio(f7);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i8, i8);
        layoutParams2.addRule(10);
        layoutParams2.addRule(11);
        this.rlThumb.addView(this.xvRemove, layoutParams2);
        this.xvRemove.setOnClickListener(this);
    }

    private void initBottom(LinearLayout linearLayout, float f7) {
        LinearLayout linearLayout2 = new LinearLayout(this.activity);
        linearLayout2.setPadding(0, 0, 0, 5);
        linearLayout2.setBackgroundColor(-1);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, (int) (75.0f * f7)));
        TextView textView = new TextView(this.activity);
        this.tvAt = textView;
        textView.setTextColor(-12895429);
        this.tvAt.setTextSize(2, 22.0f);
        this.tvAt.setGravity(80);
        this.tvAt.setText("@");
        int i6 = (int) (40.0f * f7);
        this.tvAt.setPadding(i6, 0, i6, 0);
        linearLayout2.addView(this.tvAt, new LinearLayout.LayoutParams(-2, -1));
        this.tvAt.setOnClickListener(this);
        if (isShowAtUserLayout(this.platform.getName())) {
            this.tvAt.setVisibility(0);
        } else {
            this.tvAt.setVisibility(4);
        }
        TextView textView2 = new TextView(this.activity);
        this.tvTextCouter = textView2;
        textView2.setTextColor(-12895429);
        this.tvTextCouter.setTextSize(2, 21.0f);
        this.tvTextCouter.setGravity(85);
        onTextChanged(this.etContent.getText(), 0, 0, 0);
        this.tvTextCouter.setPadding(i6, 0, i6, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        linearLayout2.addView(this.tvTextCouter, layoutParams);
        View view = new View(this.activity);
        view.setBackgroundColor(-3355444);
        linearLayout.addView(view, new LinearLayout.LayoutParams(-1, f7 > 1.0f ? (int) f7 : 1));
    }

    private void initShadow(LinearLayout linearLayout, float f7) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, f7 > 1.0f ? (int) f7 : 1);
        View view = new View(this.activity);
        view.setBackgroundColor(687865856);
        linearLayout.addView(view, layoutParams);
        View view2 = new View(this.activity);
        view2.setBackgroundColor(335544320);
        linearLayout.addView(view2, layoutParams);
        View view3 = new View(this.activity);
        view3.setBackgroundColor(117440512);
        linearLayout.addView(view3, layoutParams);
    }

    private void initThumb(AsyncImageView asyncImageView) {
        Bitmap bitmap;
        String imageUrl = this.sp.getImageUrl();
        String imagePath = this.sp.getImagePath();
        String[] imageArray = this.sp.getImageArray();
        this.rlThumb.setVisibility(0);
        if (TextUtils.isEmpty(imagePath) || !new File(imagePath).exists()) {
            bitmap = null;
        } else {
            try {
                bitmap = BitmapHelper.getBitmap(imagePath);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (bitmap != null) {
            this.thumb = bitmap;
            asyncImageView.setBitmap(bitmap);
        } else if (imageArray != null && imageArray.length > 0 && !TextUtils.isEmpty(imageArray[0]) && new File(imageArray[0]).exists()) {
            try {
                bitmap = BitmapHelper.getBitmap(imagePath);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        if (bitmap != null) {
            this.thumb = bitmap;
            asyncImageView.setBitmap(bitmap);
        } else if (bitmap != null || TextUtils.isEmpty(imageUrl)) {
            this.rlThumb.setVisibility(8);
        } else {
            asyncImageView.execute(imageUrl, 0);
        }
    }

    private void initTitle(RelativeLayout relativeLayout, float f7) {
        TextView textView = new TextView(this.activity);
        this.tvCancel = textView;
        textView.setTextColor(-12895429);
        this.tvCancel.setTextSize(2, 18.0f);
        this.tvCancel.setGravity(17);
        int stringRes = ResHelper.getStringRes(this.activity, "ssdk_oks_cancel");
        if (stringRes > 0) {
            this.tvCancel.setText(stringRes);
        }
        int i6 = (int) (f7 * 40.0f);
        this.tvCancel.setPadding(i6, 0, i6, 0);
        relativeLayout.addView(this.tvCancel, new RelativeLayout.LayoutParams(-2, -1));
        this.tvCancel.setOnClickListener(this);
        TextView textView2 = new TextView(this.activity);
        textView2.setTextColor(-12895429);
        textView2.setTextSize(2, 22.0f);
        textView2.setGravity(17);
        int stringRes2 = ResHelper.getStringRes(this.activity, "ssdk_oks_multi_share");
        if (stringRes2 > 0) {
            textView2.setText(stringRes2);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(13);
        relativeLayout.addView(textView2, layoutParams);
        TextView textView3 = new TextView(this.activity);
        this.tvShare = textView3;
        textView3.setTextColor(-37615);
        this.tvShare.setTextSize(2, 18.0f);
        this.tvShare.setGravity(17);
        int stringRes3 = ResHelper.getStringRes(this.activity, "ssdk_oks_share");
        if (stringRes3 > 0) {
            this.tvShare.setText(stringRes3);
        }
        this.tvShare.setPadding(i6, 0, i6, 0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(11);
        relativeLayout.addView(this.tvShare, layoutParams2);
        this.tvShare.setOnClickListener(this);
    }

    @Override // cn.sharesdk.onekeyshare.themes.classic.EditPage, com.mob.tools.FakeActivity
    public void onCreate() {
        super.onCreate();
        float screenHeight = ResHelper.getScreenHeight(this.activity) / 1280.0f;
        this.maxBodyHeight = 0;
        LinearLayout linearLayout = new LinearLayout(this.activity);
        this.llPage = linearLayout;
        linearLayout.setOrientation(1);
        OnekeySharePage.setViewFitsSystemWindows(this.llPage);
        this.activity.setContentView(this.llPage);
        RelativeLayout relativeLayout = new RelativeLayout(this.activity);
        this.rlTitle = relativeLayout;
        relativeLayout.setBackgroundColor(-1644052);
        this.llPage.addView(this.rlTitle, new LinearLayout.LayoutParams(-1, (int) (96.0f * screenHeight)));
        initTitle(this.rlTitle, screenHeight);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.activity);
        relativeLayout2.setBackgroundColor(-1);
        this.llPage.addView(relativeLayout2, new LinearLayout.LayoutParams(-1, -2));
        initBody(relativeLayout2, screenHeight);
        LinearLayout linearLayout2 = new LinearLayout(this.activity);
        linearLayout2.setOrientation(1);
        relativeLayout2.addView(linearLayout2, new RelativeLayout.LayoutParams(-1, -2));
        initShadow(linearLayout2, screenHeight);
        LinearLayout linearLayout3 = new LinearLayout(this.activity);
        this.llBottom = linearLayout3;
        linearLayout3.setOrientation(1);
        this.llPage.addView(this.llBottom, new LinearLayout.LayoutParams(-1, -2));
        initBottom(this.llBottom, screenHeight);
    }
}
