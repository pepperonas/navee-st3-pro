package cn.sharesdk.facebook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.LinearLayout;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.mob.tools.FakeActivity;

/* loaded from: classes2.dex */
public class FacebookOfficialShareImage extends FakeActivity implements FacebookCallback<Sharer.Result> {
    private PlatformActionListener actionListener;
    private Bitmap bitmapParams;
    private CallbackManager callbackManager;
    private String hashTag;
    private Platform platform;
    private ShareDialog shareDialog;

    public FacebookOfficialShareImage(Platform platform, PlatformActionListener platformActionListener) {
        try {
            this.platform = platform;
            this.actionListener = platformActionListener;
            SSDKLog.b().a("Facebook doShare official FacebookOfficialShareImage construction");
        } catch (Throwable th) {
            SSDKLog.b().a("Facebook doShare official FacebookOfficialShareImage catch:  " + th);
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i6, int i7, Intent intent) {
        this.callbackManager.onActivityResult(i6, i7, intent);
        super.onActivityResult(i6, i7, intent);
        SSDKLog.b().a("Facebook doShare  FacebookOfficialShareImage onActivityResult ");
    }

    public void onCancel() {
        PlatformActionListener platformActionListener = this.actionListener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this.platform, 9);
        }
        SSDKLog.b().a("Facebook doShare  FacebookOfficialShareImage onCancel ");
        finish();
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        try {
            LinearLayout linearLayout = new LinearLayout(this.activity);
            linearLayout.setOrientation(1);
            this.activity.setContentView(linearLayout);
        } catch (Exception e7) {
            SSDKLog.b().a(e7);
            SSDKLog.b().a("Facebook doShare official FacebookOfficialShareImage onCreate catch  " + e7.getMessage());
        }
        SSDKLog.b().a("Facebook FacebookOfficialHelper onCreate");
        this.callbackManager = CallbackManager.Factory.create();
        ShareDialog shareDialog = new ShareDialog(this.activity);
        this.shareDialog = shareDialog;
        shareDialog.registerCallback(this.callbackManager, this);
        shareImageOfficial(this.bitmapParams, this.hashTag);
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        super.onDestroy();
        SSDKLog.b().a("Facebook doShare  FacebookOfficialShareImage onDestroy ");
    }

    public void onError(FacebookException facebookException) {
        PlatformActionListener platformActionListener = this.actionListener;
        if (platformActionListener != null) {
            platformActionListener.onError(this.platform, 9, facebookException);
        }
        SSDKLog.b().a("Facebook doShare  FacebookOfficialShareImage onError ");
        finish();
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        super.onPause();
        SSDKLog.b().a("Facebook doShare  FacebookOfficialShareImage onPause ");
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        super.onResume();
        SSDKLog.b().a("Facebook doShare  FacebookOfficialShareImage onResume ");
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        super.onStop();
        SSDKLog.b().a("Facebook doShare  FacebookOfficialShareImage onStop ");
    }

    public void setBitmapParams(Bitmap bitmap) {
        this.bitmapParams = bitmap;
    }

    public void setHashTag(String str) {
        this.hashTag = str;
    }

    public void shareImageOfficial(Bitmap bitmap, String str) {
        try {
            SSDKLog.b().a("Facebook FacebookOfficialHelper shareImageOfficial");
            if (bitmap == null) {
                if (this.actionListener != null) {
                    SSDKLog.b().a("Facebook doShare shareImageOfficial set bitmap image is error, please check ");
                    this.actionListener.onError(this.platform, 9, new Throwable("set bitmap image is error, please check"));
                    finish();
                    return;
                }
                return;
            }
            SharePhoto sharePhotoBuild = new SharePhoto.Builder().setBitmap(bitmap).build();
            SharePhotoContent sharePhotoContentBuild = TextUtils.isEmpty(str) ? new SharePhotoContent.Builder().addPhoto(sharePhotoBuild).build() : new SharePhotoContent.Builder().addPhoto(sharePhotoBuild).setShareHashtag(new ShareHashtag.Builder().setHashtag(str).build()).build();
            if (!ShareDialog.canShow(SharePhotoContent.class)) {
                if (this.actionListener != null) {
                    SSDKLog.b().a("Facebook doShare shareImageOfficial ShareDialog.canShow(SharePhotoContent.class) is false, are you login first? ");
                    this.actionListener.onError(this.platform, 9, new Throwable("ShareDialog.canShow(SharePhotoContent.class) is false, are you login first?"));
                    finish();
                    return;
                }
                return;
            }
            ShareDialog shareDialog = this.shareDialog;
            if (shareDialog != null) {
                shareDialog.show(sharePhotoContentBuild);
                SSDKLog.b().a("Facebook FacebookOfficialHelper shareImageOfficial shareDialog.show");
            } else if (this.actionListener != null) {
                SSDKLog.b().a("Facebook doShare shareImageOfficial shareDialog is null ");
                this.actionListener.onError(this.platform, 9, new Throwable("shareDialog is null"));
                finish();
            }
        } catch (Throwable th) {
            SSDKLog.b().a("Facebook doShare shareImageOfficial shareImageOfficial catch ");
            PlatformActionListener platformActionListener = this.actionListener;
            if (platformActionListener != null) {
                platformActionListener.onError(this.platform, 9, th);
            }
            finish();
        }
    }

    public void onSuccess(Sharer.Result result) {
        PlatformActionListener platformActionListener = this.actionListener;
        if (platformActionListener != null) {
            platformActionListener.onComplete(this.platform, 9, null);
        }
        SSDKLog.b().a("Facebook doShare  FacebookOfficialShareImage onSuccess ");
        finish();
    }
}
