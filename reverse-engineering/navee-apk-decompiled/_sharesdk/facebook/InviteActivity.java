package cn.sharesdk.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.DH;

/* loaded from: classes2.dex */
public class InviteActivity extends FakeActivity {
    private String applicationId;
    private PlatformActionListener listener;
    private Platform.ShareParams params;
    private Platform platform;

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i6, int i7, Intent intent) {
        finish();
        if (intent == null) {
            if (i6 == 64206 && i7 == 0) {
                this.listener.onCancel(this.platform, 9);
                return;
            } else {
                this.listener.onError(this.platform, 9, new Throwable("share error!"));
                return;
            }
        }
        Bundle bundleExtra = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
        if (bundleExtra != null) {
            for (String str : bundleExtra.keySet()) {
                if (str.equals("error")) {
                    Bundle bundle = (Bundle) bundleExtra.get(str);
                    if (bundle != null) {
                        String str2 = "";
                        for (String str3 : bundle.keySet()) {
                            str2 = str2 + str3 + ":" + bundle.get(str3) + ", ";
                        }
                        if (str2.indexOf("UserCanceled") > -1) {
                            this.listener.onCancel(this.platform, 9);
                        }
                        this.listener.onError(this.platform, 9, new Throwable(str2));
                        return;
                    }
                    return;
                }
            }
        }
        Bundle bundleExtra2 = intent.getBundleExtra("com.facebook.platform.protocol.RESULT_ARGS");
        if (bundleExtra2 != null) {
            boolean z6 = bundleExtra2.getInt("didComplete") == 1;
            String string = bundleExtra2.getString("completionGesture");
            if (TextUtils.isEmpty(string)) {
                if (z6) {
                    this.listener.onComplete(this.platform, 9, null);
                }
            } else if (string.equalsIgnoreCase("cancel")) {
                this.listener.onCancel(this.platform, 9);
            }
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        super.onCreate();
        try {
            LinearLayout linearLayout = new LinearLayout(this.activity);
            linearLayout.setOrientation(1);
            this.activity.setContentView(linearLayout);
        } catch (Exception e7) {
            SSDKLog.b().a(e7);
        }
        try {
            startShareIntent();
        } catch (Throwable th) {
            finish();
            this.listener.onError(this.platform, 9, th);
        }
    }

    public void setInviteParams(String str) {
        this.applicationId = str;
    }

    public void setPlatformActionListener(PlatformActionListener platformActionListener, Platform platform, Platform.ShareParams shareParams) {
        this.listener = platformActionListener;
        this.platform = platform;
        this.params = shareParams;
    }

    public void startShareIntent() {
        DH.requester(MobSDK.getContext()).getNetworkTypeForStatic().getAppName().request(new DH.DHResponder() { // from class: cn.sharesdk.facebook.InviteActivity.1
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    String networkTypeForStatic = dHResponse.getNetworkTypeForStatic();
                    String appName = dHResponse.getAppName();
                    Intent intent = new Intent("com.facebook.platform.PLATFORM_ACTIVITY");
                    intent.setPackage("com.facebook.katana");
                    intent.addCategory("android.intent.category.DEFAULT");
                    Bundle bundle = new Bundle();
                    bundle.putString("app_link_url", InviteActivity.this.params.getUrl());
                    bundle.putString("preview_image_url", InviteActivity.this.params.getImageUrl());
                    intent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 20171115).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", "com.facebook.platform.action.request.APPINVITES_DIALOG").putExtra("com.facebook.platform.extra.APPLICATION_ID", InviteActivity.this.applicationId);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("action_id", "cf61947c-a8fe-4fa3-aa7c-fbeb7f291352");
                    if (!TextUtils.isEmpty(appName) && "none".equals(networkTypeForStatic)) {
                        bundle2.putString("app_name", appName);
                    }
                    intent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle2);
                    intent.putExtra("com.facebook.platform.protocol.METHOD_ARGS", bundle);
                    ((FakeActivity) InviteActivity.this).activity.startActivityForResult(intent, 64206);
                } catch (Throwable th) {
                    SSDKLog.b().a(th);
                }
            }
        });
    }
}
