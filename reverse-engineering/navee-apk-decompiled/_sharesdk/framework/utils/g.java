package cn.sharesdk.framework.utils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDKCallback;
import com.mob.MobSDK;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private String f6469a;

    /* renamed from: b, reason: collision with root package name */
    private String f6470b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6471c = true;

    public void a(String str) {
        this.f6469a = str;
        this.f6470b = "";
    }

    public void a(String str, String str2) {
        this.f6469a = str;
        this.f6470b = str2;
    }

    public void a(final Platform.ShareParams shareParams, Platform platform) throws Throwable {
        SSDKLog.b().a("ShareSDK QQ ShareBypassApproval toShare", new Object[0]);
        final Intent intent = new Intent();
        final String text = shareParams.getText();
        if (!TextUtils.isEmpty(text)) {
            platform.getShortLintk(text, false, new ShareSDKCallback<String>() { // from class: cn.sharesdk.framework.utils.g.1
                @Override // cn.sharesdk.framework.ShareSDKCallback
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onCallback(String str) {
                    if (TextUtils.isEmpty(str)) {
                        shareParams.setText(text);
                    } else {
                        shareParams.setText(str);
                    }
                    intent.putExtra("android.intent.extra.TEXT", str);
                    intent.putExtra("Kdescription", str);
                    g.this.a(shareParams, intent);
                }
            });
        } else {
            a(shareParams, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Platform.ShareParams shareParams, Intent intent) {
        try {
            String imagePath = shareParams.getImagePath();
            String imageUrl = shareParams.getImageUrl();
            List<String> arrayList = new ArrayList();
            if (shareParams.getImageArray() != null) {
                arrayList = Arrays.asList(shareParams.getImageArray());
            }
            if (arrayList == null || arrayList.size() <= 0) {
                if (TextUtils.isEmpty(imagePath) || !new File(imagePath).exists()) {
                    Bitmap imageData = shareParams.getImageData();
                    if (imageData != null && !imageData.isRecycled()) {
                        File file = new File(ResHelper.getCachePath(MobSDK.getContext(), "images"), System.currentTimeMillis() + ".png");
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        imageData.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        imagePath = file.getAbsolutePath();
                    } else if (!TextUtils.isEmpty(imageUrl)) {
                        imagePath = BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl);
                    }
                }
                if (!TextUtils.isEmpty(imagePath)) {
                    arrayList.add(imagePath);
                }
            }
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
            for (String strDownloadBitmap : arrayList) {
                if (strDownloadBitmap.startsWith("http")) {
                    strDownloadBitmap = BitmapHelper.downloadBitmap(MobSDK.getContext(), strDownloadBitmap);
                }
                File file2 = new File(strDownloadBitmap);
                if (file2.exists()) {
                    if (strDownloadBitmap.startsWith("/data/")) {
                        File file3 = new File(ResHelper.getCachePath(MobSDK.getContext(), "images"), System.currentTimeMillis() + file2.getName());
                        String absolutePath = file3.getAbsolutePath();
                        file3.createNewFile();
                        if (ResHelper.copyFile(strDownloadBitmap, absolutePath)) {
                            file2 = file3;
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 24) {
                        try {
                            Uri uriA = ShareSDKFileProvider.a(MobSDK.getContext(), MobSDK.getContext().getPackageName() + ".cn.sharesdk.ShareSDKFileProvider", file2);
                            MobSDK.getContext().grantUriPermission(this.f6469a, uriA, 3);
                            arrayList2.add(uriA);
                        } catch (Throwable th) {
                            SSDKLog.b().a(th, "ShareSDK ShareBypassApproval getUriForFile exception", new Object[0]);
                        }
                    } else {
                        arrayList2.add(Uri.fromFile(file2));
                    }
                }
            }
            if (arrayList2.size() <= 0) {
                intent.setAction("android.intent.action.SEND");
                intent.setType("text/plain");
            } else {
                String str = "image/*";
                if (arrayList2.size() == 1 && arrayList2.get(0) != null) {
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.STREAM", arrayList2.get(0));
                    String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(((Uri) arrayList2.get(0)).toString());
                    if (contentTypeFor != null && contentTypeFor.length() > 0) {
                        str = contentTypeFor;
                    }
                    intent.setType(str);
                } else {
                    intent.setAction("android.intent.action.SEND_MULTIPLE");
                    intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList2);
                    intent.setType("image/*");
                }
            }
            if (TextUtils.isEmpty(this.f6470b)) {
                intent.setPackage(this.f6469a);
            } else {
                intent.setClassName(this.f6469a, this.f6470b);
            }
            intent.addFlags(335544320);
            try {
                MobSDK.getContext().startActivity(intent);
            } catch (Throwable th2) {
                SSDKLog.b().a(th2, "ShareSDK  QQ ShareBypassApproval toShare catch", new Object[0]);
            }
        } catch (Throwable th3) {
            SSDKLog.b().a(th3);
        }
    }

    public void a(Uri uri, Platform platform, PlatformActionListener platformActionListener) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("video/*");
        intent.setPackage(this.f6469a);
        intent.putExtra("android.intent.extra.STREAM", uri);
        if (TextUtils.isEmpty(this.f6470b)) {
            intent.setPackage(this.f6469a);
        } else {
            intent.setClassName(this.f6469a, this.f6470b);
        }
        try {
            intent.addFlags(268435456);
            MobSDK.getContext().startActivity(intent);
        } catch (Throwable th) {
            SSDKLog.b().a(th);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("ShareParams", null);
        if (platformActionListener != null) {
            platformActionListener.onComplete(platform, 9, map);
        }
    }

    public void a(String str, Platform platform, PlatformActionListener platformActionListener) {
        Intent intent = new Intent("android.intent.action.SEND");
        if (str.endsWith("mp4") || str.endsWith("mkv")) {
            intent.setType("video/*");
        }
        if (TextUtils.isEmpty(this.f6470b)) {
            intent.setPackage(this.f6469a);
        } else {
            intent.setClassName(this.f6469a, this.f6470b);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    File file = new File(str);
                    Uri uriA = ShareSDKFileProvider.a(MobSDK.getContext(), MobSDK.getContext().getPackageName() + ".cn.sharesdk.ShareSDKFileProvider", file);
                    MobSDK.getContext().grantUriPermission(this.f6469a, uriA, 3);
                    intent.putExtra("android.intent.extra.STREAM", uriA);
                } catch (Throwable th) {
                    SSDKLog.b().a(th, "ShareSDK ShareBypassApproval getUriForFile exception", new Object[0]);
                }
            }
        } else {
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
        }
        try {
            intent.addFlags(268435456);
            MobSDK.getContext().startActivity(intent);
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("ShareParams", null);
        if (platformActionListener != null) {
            platformActionListener.onComplete(platform, 9, map);
        }
    }
}
