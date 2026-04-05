package cn.sharesdk.onekeyshare;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import cn.sharesdk.framework.CustomPlatform;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.ShareSDKCallback;
import com.google.android.gms.common.internal.ImagesContract;
import com.mob.MobSDK;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public abstract class OnekeyShareThemeImpl implements PlatformActionListener, Handler.Callback {
    public PlatformActionListener callback = this;
    protected Context context;
    protected ArrayList<CustomerLogo> customerLogos;
    protected ShareContentCustomizeCallback customizeCallback;
    protected boolean dialogMode;
    protected boolean disableSSO;
    protected HashMap<String, String> hiddenPlatforms;
    protected HashMap<String, Object> shareParamsMap;
    protected boolean silent;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void dealShareParamsMap(boolean r12) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.onekeyshare.OnekeyShareThemeImpl.dealShareParamsMap(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareForEditPage(final Platform platform) {
        formateShareData(platform, new ShareSDKCallback<Boolean>() { // from class: cn.sharesdk.onekeyshare.OnekeyShareThemeImpl.5
            @Override // cn.sharesdk.framework.ShareSDKCallback
            public void onCallback(Boolean bool) {
                Platform.ShareParams shareParamsShareDataToShareParams;
                if (!bool.booleanValue() || (shareParamsShareDataToShareParams = OnekeyShareThemeImpl.this.shareDataToShareParams(platform)) == null) {
                    return;
                }
                ShareSDK.logDemoEvent(3, platform);
                shareParamsShareDataToShareParams.setOpenCustomEven(true);
                ShareContentCustomizeCallback shareContentCustomizeCallback = OnekeyShareThemeImpl.this.customizeCallback;
                if (shareContentCustomizeCallback != null) {
                    shareContentCustomizeCallback.onShare(platform, shareParamsShareDataToShareParams);
                }
                OnekeyShareThemeImpl onekeyShareThemeImpl = OnekeyShareThemeImpl.this;
                onekeyShareThemeImpl.showEditPage(onekeyShareThemeImpl.context, platform, shareParamsShareDataToShareParams);
                OnekeyShareThemeImpl.this.customizeCallback = null;
            }
        });
    }

    private void realCallback(Platform platform, final ShareSDKCallback<Boolean> shareSDKCallback, final boolean z6, final String str) {
        platform.isClientValid(new ShareSDKCallback<Boolean>() { // from class: cn.sharesdk.onekeyshare.OnekeyShareThemeImpl.6
            @Override // cn.sharesdk.framework.ShareSDKCallback
            public void onCallback(Boolean bool) {
                if (bool.booleanValue()) {
                    OnekeyShareThemeImpl.this.dealShareParamsMap(z6);
                    ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                    if (shareSDKCallback2 != null) {
                        shareSDKCallback2.onCallback(Boolean.TRUE);
                        return;
                    }
                    return;
                }
                OnekeyShareThemeImpl.this.toast(str);
                ShareSDKCallback shareSDKCallback3 = shareSDKCallback;
                if (shareSDKCallback3 != null) {
                    shareSDKCallback3.onCallback(Boolean.FALSE);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toast(final String str) {
        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.sharesdk.onekeyshare.OnekeyShareThemeImpl.7
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int stringRes = ResHelper.getStringRes(OnekeyShareThemeImpl.this.context, str);
                if (stringRes > 0) {
                    Toast.makeText(OnekeyShareThemeImpl.this.context, stringRes, 0).show();
                } else {
                    Toast.makeText(OnekeyShareThemeImpl.this.context, str, 0).show();
                }
                return false;
            }
        });
    }

    public final void disableSSO() {
        this.disableSSO = true;
    }

    public final void formateShareData(Platform platform, ShareSDKCallback<Boolean> shareSDKCallback) {
        String name = platform.getName();
        if ("Alipay".equals(name) || "AlipayMoments".equals(name)) {
            realCallback(platform, shareSDKCallback, false, "ssdk_alipay_client_inavailable");
            return;
        }
        if ("KakaoTalk".equals(name)) {
            realCallback(platform, shareSDKCallback, false, "ssdk_kakaotalk_client_inavailable");
            return;
        }
        if ("KakaoStory".equals(name)) {
            realCallback(platform, shareSDKCallback, false, "ssdk_kakaostory_client_inavailable");
            return;
        }
        if ("Line".equals(name)) {
            realCallback(platform, shareSDKCallback, false, "ssdk_line_client_inavailable");
            return;
        }
        if ("WhatsApp".equals(name)) {
            realCallback(platform, shareSDKCallback, false, "ssdk_whatsapp_client_inavailable");
            return;
        }
        if ("Pinterest".equals(name)) {
            realCallback(platform, shareSDKCallback, false, "ssdk_pinterest_client_inavailable");
            return;
        }
        if ("Instagram".equals(name)) {
            realCallback(platform, shareSDKCallback, false, "ssdk_instagram_client_inavailable");
            return;
        }
        if ("QZone".equals(name)) {
            realCallback(platform, shareSDKCallback, false, "ssdk_qq_client_inavailable");
            return;
        }
        if ("Laiwang".equals(name) || "LaiwangMoments".equals(name)) {
            realCallback(platform, shareSDKCallback, false, "ssdk_laiwang_client_inavailable");
            return;
        }
        if ("YixinMoments".equals(name) || "Yixin".equals(name)) {
            realCallback(platform, shareSDKCallback, false, "ssdk_yixin_client_inavailable");
            return;
        }
        if ("WechatFavorite".equals(name) || "Wechat".equals(name) || "WechatMoments".equals(name)) {
            realCallback(platform, shareSDKCallback, true, "ssdk_wechat_client_inavailable");
            return;
        }
        if ("FacebookMessenger".equals(name)) {
            realCallback(platform, shareSDKCallback, true, "ssdk_facebookmessenger_client_inavailable");
            return;
        }
        if ("Telegram".equals(name)) {
            realCallback(platform, shareSDKCallback, true, "ssdk_telegram_client_inavailable");
            return;
        }
        dealShareParamsMap(false);
        if (shareSDKCallback != null) {
            shareSDKCallback.onCallback(Boolean.TRUE);
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i6 = message.arg1;
        if (i6 == 1) {
            int stringRes = ResHelper.getStringRes(this.context, "ssdk_oks_share_completed");
            if (stringRes <= 0) {
                return false;
            }
            toast(this.context.getString(stringRes));
            return false;
        }
        if (i6 != 2) {
            if (i6 != 3) {
                return false;
            }
            toast("ssdk_oks_share_canceled");
            return false;
        }
        String simpleName = message.obj.getClass().getSimpleName();
        if ("WechatClientNotExistException".equals(simpleName) || "WechatTimelineNotSupportedException".equals(simpleName) || "WechatFavoriteNotSupportedException".equals(simpleName)) {
            toast("ssdk_wechat_client_inavailable");
            return false;
        }
        if ("GooglePlusClientNotExistException".equals(simpleName)) {
            toast("ssdk_google_plus_client_inavailable");
            return false;
        }
        if ("QQClientNotExistException".equals(simpleName)) {
            toast("ssdk_qq_client_inavailable");
            return false;
        }
        if ("YixinClientNotExistException".equals(simpleName) || "YixinTimelineNotSupportedException".equals(simpleName)) {
            toast("ssdk_yixin_client_inavailable");
            return false;
        }
        if ("KakaoTalkClientNotExistException".equals(simpleName)) {
            toast("ssdk_kakaotalk_client_inavailable");
            return false;
        }
        if ("KakaoStoryClientNotExistException".equals(simpleName)) {
            toast("ssdk_kakaostory_client_inavailable");
            return false;
        }
        if ("WhatsAppClientNotExistException".equals(simpleName)) {
            toast("ssdk_whatsapp_client_inavailable");
            return false;
        }
        if ("FacebookMessengerClientNotExistException".equals(simpleName)) {
            toast("ssdk_facebookmessenger_client_inavailable");
            return false;
        }
        toast("ssdk_oks_share_failed");
        return false;
    }

    public final void isUseClientToShare(Platform platform, final ShareSDKCallback<Boolean> shareSDKCallback) {
        if (platform == null) {
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(Boolean.FALSE);
                return;
            }
            return;
        }
        String name = platform.getName();
        if ("SinaWeibo".equals(name) || "Wechat".equals(name) || "WechatMoments".equals(name) || "WechatFavorite".equals(name) || "ShortMessage".equals(name) || "Email".equals(name) || "Qzone".equals(name) || "QQ".equals(name) || "Pinterest".equals(name) || "Instagram".equals(name) || "Yixin".equals(name) || "YixinMoments".equals(name) || "QZone".equals(name) || "Mingdao".equals(name) || "Line".equals(name) || "KakaoStory".equals(name) || "KakaoTalk".equals(name) || "Bluetooth".equals(name) || "WhatsApp".equals(name) || "BaiduTieba".equals(name) || "Laiwang".equals(name) || "LaiwangMoments".equals(name) || "Alipay".equals(name) || "AlipayMoments".equals(name) || "FacebookMessenger".equals(name) || "GooglePlus".equals(name) || "Dingding".equals(name) || "Youtube".equals(name) || "Meipai".equals(name) || "Telegram".equals(name) || "Douyin".equals(name) || "Oasis".equals(name) || "Tiktok".equals(name) || "Pocket".equals(name)) {
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(Boolean.TRUE);
                return;
            }
            return;
        }
        if ("Evernote".equals(name)) {
            if ("true".equals(platform.getDevinfo("ShareByAppClient"))) {
                if (shareSDKCallback != null) {
                    shareSDKCallback.onCallback(Boolean.TRUE);
                    return;
                }
                return;
            } else {
                if (shareSDKCallback != null) {
                    shareSDKCallback.onCallback(Boolean.FALSE);
                    return;
                }
                return;
            }
        }
        if ("Facebook".equals(name)) {
            final boolean zEquals = "true".equals(platform.getDevinfo("ShareByAppClient"));
            platform.isClientValid(new ShareSDKCallback<Boolean>() { // from class: cn.sharesdk.onekeyshare.OnekeyShareThemeImpl.2
                @Override // cn.sharesdk.framework.ShareSDKCallback
                public void onCallback(Boolean bool) {
                    if (zEquals && bool.booleanValue()) {
                        ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                        if (shareSDKCallback2 != null) {
                            shareSDKCallback2.onCallback(Boolean.TRUE);
                            return;
                        }
                        return;
                    }
                    if (!OnekeyShareThemeImpl.this.shareParamsMap.containsKey(ImagesContract.URL) || TextUtils.isEmpty((String) OnekeyShareThemeImpl.this.shareParamsMap.get(ImagesContract.URL))) {
                        ShareSDKCallback shareSDKCallback3 = shareSDKCallback;
                        if (shareSDKCallback3 != null) {
                            shareSDKCallback3.onCallback(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                    ShareSDKCallback shareSDKCallback4 = shareSDKCallback;
                    if (shareSDKCallback4 != null) {
                        shareSDKCallback4.onCallback(Boolean.TRUE);
                    }
                }
            });
        } else if ("LinkedIn".equals(name)) {
            final boolean zEquals2 = "true".equals(platform.getDevinfo("ShareByAppClient"));
            platform.isClientValid(new ShareSDKCallback<Boolean>() { // from class: cn.sharesdk.onekeyshare.OnekeyShareThemeImpl.3
                @Override // cn.sharesdk.framework.ShareSDKCallback
                public void onCallback(Boolean bool) {
                    if (zEquals2 && bool.booleanValue()) {
                        ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                        if (shareSDKCallback2 != null) {
                            shareSDKCallback2.onCallback(Boolean.TRUE);
                            return;
                        }
                        return;
                    }
                    ShareSDKCallback shareSDKCallback3 = shareSDKCallback;
                    if (shareSDKCallback3 != null) {
                        shareSDKCallback3.onCallback(Boolean.FALSE);
                    }
                }
            });
        } else if (shareSDKCallback != null) {
            shareSDKCallback.onCallback(Boolean.FALSE);
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public final void onCancel(Platform platform, int i6) {
        Message message = new Message();
        message.arg1 = 3;
        message.arg2 = i6;
        message.obj = platform;
        UIHandler.sendMessage(message, this);
        ShareSDK.logDemoEvent(5, platform);
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public final void onComplete(Platform platform, int i6, HashMap<String, Object> map) {
        Message message = new Message();
        message.arg1 = 1;
        message.arg2 = i6;
        message.obj = platform;
        UIHandler.sendMessage(message, this);
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public final void onError(Platform platform, int i6, Throwable th) {
        th.printStackTrace();
        Message message = new Message();
        message.arg1 = 2;
        message.arg2 = i6;
        message.obj = th;
        UIHandler.sendMessage(message, this);
        ShareSDK.logDemoEvent(4, platform);
    }

    public final void setCustomerLogos(ArrayList<CustomerLogo> arrayList) {
        this.customerLogos = arrayList;
    }

    public final void setDialogMode(boolean z6) {
        this.dialogMode = z6;
    }

    public final void setHiddenPlatforms(HashMap<String, String> map) {
        this.hiddenPlatforms = map;
    }

    public final void setPlatformActionListener(PlatformActionListener platformActionListener) {
        if (platformActionListener == null) {
            platformActionListener = this;
        }
        this.callback = platformActionListener;
    }

    public final void setShareContentCustomizeCallback(ShareContentCustomizeCallback shareContentCustomizeCallback) {
        this.customizeCallback = shareContentCustomizeCallback;
    }

    public final void setShareParamsMap(HashMap<String, Object> map) {
        this.shareParamsMap = map;
    }

    public final void setSilent(boolean z6) {
        this.silent = z6;
    }

    public final Platform.ShareParams shareDataToShareParams(Platform platform) {
        HashMap<String, Object> map;
        if (platform == null || (map = this.shareParamsMap) == null) {
            toast("ssdk_oks_share_failed");
            return null;
        }
        try {
            String str = (String) ResHelper.forceCast(map.get("imagePath"));
            Bitmap bitmap = (Bitmap) ResHelper.forceCast(this.shareParamsMap.get("viewToShare"));
            if (TextUtils.isEmpty(str) && bitmap != null && !bitmap.isRecycled()) {
                File file = new File(ResHelper.getCachePath(MobSDK.getContext(), "screenshot"), String.valueOf(System.currentTimeMillis()) + ".jpg");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                this.shareParamsMap.put("imagePath", file.getAbsolutePath());
            }
            return new Platform.ShareParams(this.shareParamsMap);
        } catch (Throwable th) {
            th.printStackTrace();
            toast("ssdk_oks_share_failed");
            return null;
        }
    }

    public final void shareSilently(final Platform platform) {
        formateShareData(platform, new ShareSDKCallback<Boolean>() { // from class: cn.sharesdk.onekeyshare.OnekeyShareThemeImpl.4
            @Override // cn.sharesdk.framework.ShareSDKCallback
            public void onCallback(Boolean bool) {
                Platform.ShareParams shareParamsShareDataToShareParams;
                if (!bool.booleanValue() || (shareParamsShareDataToShareParams = OnekeyShareThemeImpl.this.shareDataToShareParams(platform)) == null) {
                    return;
                }
                HashMap<String, Object> map = OnekeyShareThemeImpl.this.shareParamsMap;
                if (map != null) {
                    if (!(map.containsKey("disappearsharetoast") ? ((Boolean) OnekeyShareThemeImpl.this.shareParamsMap.get("disappearsharetoast")).booleanValue() : false)) {
                        OnekeyShareThemeImpl.this.toast("ssdk_oks_sharing");
                    }
                }
                ShareContentCustomizeCallback shareContentCustomizeCallback = OnekeyShareThemeImpl.this.customizeCallback;
                if (shareContentCustomizeCallback != null) {
                    shareContentCustomizeCallback.onShare(platform, shareParamsShareDataToShareParams);
                }
                boolean z6 = OnekeyShareThemeImpl.this.disableSSO;
                if (z6) {
                    platform.SSOSetting(z6);
                }
                platform.setPlatformActionListener(OnekeyShareThemeImpl.this.callback);
                platform.share(shareParamsShareDataToShareParams);
                OnekeyShareThemeImpl onekeyShareThemeImpl = OnekeyShareThemeImpl.this;
                onekeyShareThemeImpl.callback = null;
                onekeyShareThemeImpl.customizeCallback = null;
            }
        });
    }

    public final void show(Context context) {
        final Platform platform;
        this.context = context;
        if (!this.shareParamsMap.containsKey("platform")) {
            showPlatformPage(context);
            return;
        }
        try {
            platform = ShareSDK.getPlatform(String.valueOf(this.shareParamsMap.get("platform")));
        } catch (Throwable unused) {
            platform = null;
        }
        final boolean z6 = platform instanceof CustomPlatform;
        isUseClientToShare(platform, new ShareSDKCallback<Boolean>() { // from class: cn.sharesdk.onekeyshare.OnekeyShareThemeImpl.1
            @Override // cn.sharesdk.framework.ShareSDKCallback
            public void onCallback(Boolean bool) {
                if (OnekeyShareThemeImpl.this.silent || z6 || bool.booleanValue()) {
                    OnekeyShareThemeImpl.this.shareSilently(platform);
                } else {
                    OnekeyShareThemeImpl.this.prepareForEditPage(platform);
                }
            }
        });
    }

    public abstract void showEditPage(Context context, Platform platform, Platform.ShareParams shareParams);

    public abstract void showPlatformPage(Context context);
}
