package cn.sharesdk.facebook;

import android.content.Intent;
import android.net.Uri;
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
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.ShareDialog;
import com.mob.tools.FakeActivity;

/* loaded from: classes2.dex */
public class FacebookOfficialShareVideo extends FakeActivity implements FacebookCallback<Sharer.Result> {
    private PlatformActionListener actionListener;
    private CallbackManager callbackManager;
    private String hashTag;
    private Platform platform;
    private ShareDialog shareDialog;
    private Uri videoUri;

    public FacebookOfficialShareVideo(Platform platform, PlatformActionListener platformActionListener) {
        try {
            this.platform = platform;
            this.actionListener = platformActionListener;
        } catch (Throwable th) {
            SSDKLog.b().a("FacebookOfficialShare catch " + th, new Object[0]);
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i6, int i7, Intent intent) {
        this.callbackManager.onActivityResult(i6, i7, intent);
        super.onActivityResult(i6, i7, intent);
    }

    public void onCancel() {
        PlatformActionListener platformActionListener = this.actionListener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this.platform, 9);
        }
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
        }
        SSDKLog.b().a("FacebookOfficialHelper onCreate");
        this.callbackManager = CallbackManager.Factory.create();
        ShareDialog shareDialog = new ShareDialog(this.activity);
        this.shareDialog = shareDialog;
        shareDialog.registerCallback(this.callbackManager, this);
        shareVideoOfficial(this.videoUri, this.hashTag);
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        super.onDestroy();
        SSDKLog.b().a("FacebookOfficialShareVideo onDestroy");
    }

    public void onError(FacebookException facebookException) {
        PlatformActionListener platformActionListener = this.actionListener;
        if (platformActionListener != null) {
            platformActionListener.onError(this.platform, 9, facebookException);
        }
        finish();
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        super.onPause();
        SSDKLog.b().a("FacebookOfficialShareVideo onPause");
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        super.onResume();
        SSDKLog.b().a("FacebookOfficialShareVideo onResume");
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        super.onStop();
        SSDKLog.b().a("FacebookOfficialShareVideo onStop");
    }

    public void setHashTag(String str) {
        this.hashTag = str;
    }

    public void setVideoUri(Uri uri) {
        this.videoUri = uri;
    }

    public void shareVideoOfficial(Uri uri, String str) {
        try {
            if (uri == null) {
                PlatformActionListener platformActionListener = this.actionListener;
                if (platformActionListener != null) {
                    platformActionListener.onError(this.platform, 9, new Throwable("share video paramas is null"));
                    finish();
                    return;
                }
                return;
            }
            ShareVideo shareVideoBuild = new ShareVideo.Builder().setLocalUrl(uri).build();
            ShareVideoContent shareVideoContentBuild = TextUtils.isEmpty(str) ? new ShareVideoContent.Builder().setVideo(shareVideoBuild).build() : new ShareVideoContent.Builder().setVideo(shareVideoBuild).setShareHashtag(new ShareHashtag.Builder().setHashtag(str).build()).setContentTitle("contentTitle").setContentDescription("contentText").build();
            if (!ShareDialog.canShow(ShareVideoContent.class)) {
                PlatformActionListener platformActionListener2 = this.actionListener;
                if (platformActionListener2 != null) {
                    platformActionListener2.onError(this.platform, 9, new Throwable("ShareDialog.canShow(ShareVideoContent.class) is false, are you login first?"));
                    finish();
                    return;
                }
                return;
            }
            ShareDialog shareDialog = this.shareDialog;
            if (shareDialog != null) {
                shareDialog.show(shareVideoContentBuild);
                return;
            }
            PlatformActionListener platformActionListener3 = this.actionListener;
            if (platformActionListener3 != null) {
                platformActionListener3.onError(this.platform, 9, new Throwable("shareDialog is null"));
                finish();
            }
        } catch (Throwable th) {
            SSDKLog.b().a("shareVideoOfficial catch ");
            PlatformActionListener platformActionListener4 = this.actionListener;
            if (platformActionListener4 != null) {
                platformActionListener4.onError(this.platform, 9, th);
            }
            finish();
        }
    }

    public void onSuccess(Sharer.Result result) {
        PlatformActionListener platformActionListener = this.actionListener;
        if (platformActionListener != null) {
            platformActionListener.onComplete(this.platform, 9, null);
        }
        finish();
    }
}
