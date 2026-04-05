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
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.mob.tools.FakeActivity;

/* loaded from: classes2.dex */
public class FacebookOfficialShareWebPage extends FakeActivity implements FacebookCallback<Sharer.Result> {
    private PlatformActionListener actionListener;
    private CallbackManager callbackManager;
    private Platform platform;
    private ShareDialog shareDialog;

    public FacebookOfficialShareWebPage(Platform platform, PlatformActionListener platformActionListener) {
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
        Intent intent = this.activity.getIntent();
        String stringExtra = intent.getStringExtra(Facebook.PARAMS_LINKURL);
        String stringExtra2 = intent.getStringExtra(Facebook.PARAMS_HASHTAG);
        String stringExtra3 = intent.getStringExtra(Facebook.PARAMS_QUOTE);
        SSDKLog.b().a("Share params url is: " + stringExtra + " hashtag: " + stringExtra2 + " quote: " + stringExtra3);
        shareLinkOfficial(stringExtra, stringExtra2, stringExtra3);
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        super.onDestroy();
        SSDKLog.b().a("FacebookOfficialShareWebPage onDestroy");
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
        SSDKLog.b().a("FacebookOfficialShareWebPage onPause");
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        super.onResume();
        SSDKLog.b().a("FacebookOfficialShareWebPage onResume");
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        super.onStop();
        SSDKLog.b().a("FacebookOfficialShareWebPage onStop");
    }

    public void shareLinkOfficial(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ShareLinkContent shareLinkContentBuild = (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) ? !TextUtils.isEmpty(str2) ? new ShareLinkContent.Builder().setContentUrl(Uri.parse(str)).setShareHashtag(new ShareHashtag.Builder().setHashtag(str2).build()).build() : !TextUtils.isEmpty(str3) ? new ShareLinkContent.Builder().setContentUrl(Uri.parse(str)).setQuote(str3).build() : new ShareLinkContent.Builder().setContentUrl(Uri.parse(str)).build() : new ShareLinkContent.Builder().setContentUrl(Uri.parse(str)).setShareHashtag(new ShareHashtag.Builder().setHashtag(str2).build()).setQuote(str3).build();
                if (!ShareDialog.canShow(ShareLinkContent.class)) {
                    PlatformActionListener platformActionListener = this.actionListener;
                    if (platformActionListener != null) {
                        platformActionListener.onError(this.platform, 9, new Throwable("ShareDialog.canShow(ShareLinkContent.class) is false, are you login first?"));
                        finish();
                        return;
                    }
                    return;
                }
                ShareDialog shareDialog = this.shareDialog;
                if (shareDialog != null) {
                    shareDialog.show(shareLinkContentBuild);
                    return;
                }
                PlatformActionListener platformActionListener2 = this.actionListener;
                if (platformActionListener2 != null) {
                    platformActionListener2.onError(this.platform, 9, new Throwable("shareDialog is null"));
                    finish();
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(str2)) {
                PlatformActionListener platformActionListener3 = this.actionListener;
                if (platformActionListener3 != null) {
                    platformActionListener3.onError(this.platform, 9, new Throwable("share link params is null"));
                    finish();
                    return;
                }
                return;
            }
            if (!ShareDialog.canShow(ShareLinkContent.class)) {
                PlatformActionListener platformActionListener4 = this.actionListener;
                if (platformActionListener4 != null) {
                    platformActionListener4.onError(this.platform, 9, new Throwable("ShareDialog.canShow(ShareLinkContent.class) is false, are you login first?"));
                    finish();
                    return;
                }
                return;
            }
            ShareLinkContent shareLinkContentBuild2 = new ShareLinkContent.Builder().setContentUrl(Uri.parse(str)).setShareHashtag(new ShareHashtag.Builder().setHashtag(str2).build()).build();
            ShareDialog shareDialog2 = this.shareDialog;
            if (shareDialog2 != null) {
                shareDialog2.show(shareLinkContentBuild2);
                return;
            }
            PlatformActionListener platformActionListener5 = this.actionListener;
            if (platformActionListener5 != null) {
                platformActionListener5.onError(this.platform, 9, new Throwable("shareDialog is null"));
                finish();
            }
        } catch (Throwable th) {
            SSDKLog.b().a("shareLinkOfficial catch ");
            PlatformActionListener platformActionListener6 = this.actionListener;
            if (platformActionListener6 != null) {
                platformActionListener6.onError(this.platform, 9, th);
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
