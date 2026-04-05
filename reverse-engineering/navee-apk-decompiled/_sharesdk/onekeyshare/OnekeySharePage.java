package cn.sharesdk.onekeyshare;

import android.os.Build;
import android.view.View;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDKCallback;
import com.mob.tools.FakeActivity;
import com.mob.tools.MobLog;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class OnekeySharePage extends FakeActivity {
    private OnekeyShareThemeImpl impl;

    public OnekeySharePage(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        this.impl = onekeyShareThemeImpl;
    }

    public static void setViewFitsSystemWindows(View view) {
        try {
            if (Build.VERSION.SDK_INT >= 35) {
                view.setFitsSystemWindows(true);
            }
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }

    public void formateShareData(final Platform platform, final ShareSDKCallback<Platform.ShareParams> shareSDKCallback) {
        this.impl.formateShareData(platform, new ShareSDKCallback<Boolean>() { // from class: cn.sharesdk.onekeyshare.OnekeySharePage.1
            @Override // cn.sharesdk.framework.ShareSDKCallback
            public void onCallback(Boolean bool) {
                if (bool.booleanValue()) {
                    ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                    if (shareSDKCallback2 != null) {
                        shareSDKCallback2.onCallback(OnekeySharePage.this.impl.shareDataToShareParams(platform));
                        return;
                    }
                    return;
                }
                ShareSDKCallback shareSDKCallback3 = shareSDKCallback;
                if (shareSDKCallback3 != null) {
                    shareSDKCallback3.onCallback(null);
                }
            }
        });
    }

    public final PlatformActionListener getCallback() {
        return this.impl.callback;
    }

    public final ArrayList<CustomerLogo> getCustomerLogos() {
        return this.impl.customerLogos;
    }

    public final ShareContentCustomizeCallback getCustomizeCallback() {
        return this.impl.customizeCallback;
    }

    public final HashMap<String, String> getHiddenPlatforms() {
        return this.impl.hiddenPlatforms;
    }

    public final HashMap<String, Object> getShareParamsMap() {
        return this.impl.shareParamsMap;
    }

    public final boolean isDialogMode() {
        return this.impl.dialogMode;
    }

    public final boolean isDisableSSO() {
        return this.impl.disableSSO;
    }

    public final boolean isSilent() {
        return this.impl.silent;
    }

    public void isUseClientToShare(Platform platform, ShareSDKCallback<Boolean> shareSDKCallback) {
        this.impl.isUseClientToShare(platform, shareSDKCallback);
    }

    public final void shareSilently(Platform platform) {
        this.impl.shareSilently(platform);
    }
}
