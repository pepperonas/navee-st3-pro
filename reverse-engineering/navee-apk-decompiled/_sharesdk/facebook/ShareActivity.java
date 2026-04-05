package cn.sharesdk.facebook;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.ShareSDKFileProvider;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.DH;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ShareActivity extends FakeActivity {
    private String applicationId;
    private PlatformActionListener listener;
    private Platform.ShareParams params;
    private Platform platform;

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i6, int i7, Intent intent) {
        finish();
        try {
            if (this.listener != null) {
                Bundle bundleExtra = intent != null ? intent.getBundleExtra("com.facebook.platform.protocol.RESULT_ARGS") : null;
                if (bundleExtra == null) {
                    if (i6 == 64206 && i7 == 0) {
                        this.listener.onCancel(this.platform, 9);
                        return;
                    } else {
                        this.listener.onError(this.platform, 9, new Throwable("share error!"));
                        return;
                    }
                }
                String string = bundleExtra.getString("completionGesture");
                boolean z6 = bundleExtra.getBoolean("didComplete");
                if (TextUtils.isEmpty(string)) {
                    if (z6) {
                        this.listener.onComplete(this.platform, 9, null);
                        return;
                    } else {
                        this.listener.onCancel(this.platform, 9);
                        return;
                    }
                }
                if (string.equalsIgnoreCase("cancel")) {
                    this.listener.onCancel(this.platform, 9);
                } else if (string.equalsIgnoreCase("post")) {
                    this.listener.onComplete(this.platform, 9, null);
                }
            }
        } catch (Throwable th) {
            SSDKLog.b().a("Facebook onActivityResult error:" + th, new Object[0]);
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        super.onCreate();
        try {
            LinearLayout linearLayout = new LinearLayout(this.activity);
            linearLayout.setOrientation(1);
            this.activity.setContentView(linearLayout);
            startShareIntent();
        } catch (Throwable th) {
            finish();
            this.listener.onError(this.platform, 9, th);
        }
    }

    public void setPlatformActionListener(PlatformActionListener platformActionListener, Platform platform, Platform.ShareParams shareParams, String str) {
        this.listener = platformActionListener;
        this.platform = platform;
        this.params = shareParams;
        this.applicationId = str;
    }

    public void startShareIntent() {
        DH.requester(MobSDK.getContext()).getNetworkTypeForStatic().getAppName().getDeviceKey().getScreenSize().getCarrier().getNetworkType().request(new DH.DHResponder() { // from class: cn.sharesdk.facebook.ShareActivity.1
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("dk", dHResponse.getDeviceKey());
                    map.put("nt", dHResponse.getNetworkType());
                    map.put("dnwktfs", dHResponse.getDetailNetworkTypeForStatic());
                    map.put("srs", dHResponse.getScreenSize());
                    map.put("car", dHResponse.getCarrier());
                    String networkTypeForStatic = dHResponse.getNetworkTypeForStatic();
                    String appName = dHResponse.getAppName();
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("DATA_FAILURES_FATAL", false);
                    bundle.putString("TITLE", ShareActivity.this.params.getTitle());
                    if (!TextUtils.isEmpty(ShareActivity.this.params.getUrl())) {
                        bundle.putString("LINK", ShareActivity.this.platform.getShortLintk(ShareActivity.this.params.getUrl(), false, map));
                        bundle.putString("type", "LINK");
                        if (!TextUtils.isEmpty(ShareActivity.this.params.getQuote())) {
                            bundle.putString("QUOTE", ShareActivity.this.params.getQuote());
                        }
                        if (!TextUtils.isEmpty(ShareActivity.this.params.getHashtag())) {
                            bundle.putString("HASHTAG", ShareActivity.this.params.getHashtag());
                        }
                    } else if (!TextUtils.isEmpty(ShareActivity.this.params.getFilePath())) {
                        File file = new File(ShareActivity.this.params.getFilePath());
                        if (file.exists()) {
                            Uri uriA = ShareSDKFileProvider.a(MobSDK.getContext(), MobSDK.getContext().getPackageName() + ".cn.sharesdk.ShareSDKFileProvider", file);
                            MobSDK.getContext().grantUriPermission("com.facebook.katana", uriA, 3);
                            bundle.putString("VIDEO", uriA.toString());
                        }
                        bundle.putString("type", "VIDEO");
                        bundle.putString("DESCRIPTION", ShareActivity.this.params.getText());
                        bundle.putString("TITLE", ShareActivity.this.params.getTitle());
                        if (!TextUtils.isEmpty(ShareActivity.this.params.getHashtag())) {
                            bundle.putString("HASHTAG", ShareActivity.this.params.getHashtag());
                        }
                    } else if (ShareActivity.this.params.getImageArray() == null || ShareActivity.this.params.getImageArray().length <= 0) {
                        bundle.putString("LINK", "");
                        bundle.putString("type", "LINK");
                        if (!TextUtils.isEmpty(ShareActivity.this.params.getText())) {
                            bundle.putString("HASHTAG", ShareActivity.this.params.getText());
                        }
                    } else {
                        try {
                            ArrayList<String> arrayList = new ArrayList<>();
                            List arrayList2 = new ArrayList();
                            if (ShareActivity.this.params.getImageArray() != null) {
                                arrayList2 = Arrays.asList(ShareActivity.this.params.getImageArray());
                            }
                            Iterator it = arrayList2.iterator();
                            while (it.hasNext()) {
                                File file2 = new File((String) it.next());
                                if (!file2.exists()) {
                                    SSDKLog.b().a("Facebook share iamge ShareActivity file is not exist");
                                } else if (Build.VERSION.SDK_INT >= 24) {
                                    Uri uriA2 = ShareSDKFileProvider.a(MobSDK.getContext(), MobSDK.getContext().getPackageName() + ".cn.sharesdk.ShareSDKFileProvider", file2);
                                    MobSDK.getContext().grantUriPermission("com.facebook.katana", uriA2, 3);
                                    arrayList.add(String.valueOf(uriA2));
                                } else {
                                    arrayList.add(Uri.fromFile(file2).toString());
                                }
                            }
                            if (!TextUtils.isEmpty(ShareActivity.this.params.getHashtag())) {
                                bundle.putString("HASHTAG", ShareActivity.this.params.getHashtag());
                            }
                            bundle.putStringArrayList("PHOTOS", arrayList);
                            bundle.putString("DESCRIPTION", ShareActivity.this.params.getText());
                            bundle.putString("NAME", ShareActivity.this.params.getTitle());
                        } catch (Throwable th) {
                            SSDKLog.b().a(th);
                        }
                    }
                    Intent intent = new Intent("com.facebook.platform.PLATFORM_ACTIVITY");
                    intent.setPackage("com.facebook.katana");
                    intent.addCategory("android.intent.category.DEFAULT");
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("action_id", "cf61947c-a8fe-4fa3-aa7c-fbeb7f291352");
                    if (!TextUtils.isEmpty(appName) && "none".equals(networkTypeForStatic)) {
                        bundle2.putString("app_name", appName);
                    }
                    intent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 20171115).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", "com.facebook.platform.action.request.FEED_DIALOG").putExtra("com.facebook.platform.extra.APPLICATION_ID", ShareActivity.this.applicationId);
                    intent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle2);
                    intent.putExtra("com.facebook.platform.protocol.METHOD_ARGS", bundle);
                    ((FakeActivity) ShareActivity.this).activity.startActivityForResult(intent, 64206);
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2);
                }
            }
        });
    }
}
