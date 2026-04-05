package cn.sharesdk.google;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.google.c;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class ShareActivity extends FakeActivity {
    private static final int CODE_AUTHORIZE = 0;
    private static final int CODE_REVOKEACCSS = 2;
    private static final int CODE_SHARE = 1;
    private static final int REQUEST_CODE_INTERACTIVE_POST = 3;
    private static final int REQUEST_CODE_SIGIN = 0;
    private int action;
    private PlatformDb db;
    private c googlePlusUtil = null;
    private PlatformActionListener listener;
    private Platform platform;

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i6, int i7, Intent intent) {
        finish();
        if (i6 != 3) {
            if (i6 == 0) {
                if (i7 != -1) {
                    if (i7 == 0) {
                        this.listener.onCancel(this.platform, 8);
                        return;
                    }
                    return;
                } else {
                    c cVar = this.googlePlusUtil;
                    if (cVar != null) {
                        cVar.a();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        HashMap<String, Object> map = new HashMap<>();
        if (intent != null && intent.getExtras() != null) {
            for (String str : intent.getExtras().keySet()) {
                map.put(str, intent.getExtras().get(str));
            }
        }
        String strFromHashMap = new Hashon().fromHashMap(map);
        if ((intent == null || intent.getExtras() == null) && i7 == 0) {
            this.listener.onCancel(this.platform, 8);
        } else if (i7 != -1) {
            this.listener.onError(this.platform, 9, new Throwable(strFromHashMap));
        } else {
            this.listener.onComplete(this.platform, 9, map);
        }
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
        Bundle extras = this.activity.getIntent().getExtras();
        String string = extras.getString("text");
        String string2 = extras.getString("imageUrl");
        String string3 = extras.getString("imagePath");
        String string4 = extras.getString("filePath");
        this.action = extras.getInt("action");
        this.googlePlusUtil = null;
        c cVarA = new c.a(getContext()).a(new String[]{"http://schemas.google.com/AddActivity", "http://schemas.google.com/BuyActivity"}).a();
        this.googlePlusUtil = cVarA;
        cVarA.a(this);
        int i6 = this.action;
        if (i6 != 1) {
            if (i6 == 0) {
                this.googlePlusUtil.a(this.platform, this.listener, this.db);
                this.googlePlusUtil.a();
                return;
            } else {
                if (i6 == 2) {
                    this.googlePlusUtil.b(this);
                    return;
                }
                return;
            }
        }
        c.a aVar = new c.a();
        aVar.a("text/plain");
        aVar.a((CharSequence) string);
        if (!TextUtils.isEmpty(string4)) {
            if (Build.VERSION.SDK_INT < 24) {
                aVar.a(Uri.fromFile(new File(string4)));
            }
            aVar.a("video/*");
            aVar.a((CharSequence) string);
        } else if (!string.contains("http") && !TextUtils.isEmpty(string2) && string2.startsWith("http")) {
            aVar.a(Uri.parse(string2));
        } else if (!TextUtils.isEmpty(string3)) {
            if (Build.VERSION.SDK_INT >= 24) {
                aVar.a(ResHelper.pathToContentUri(this.activity, string3));
            } else {
                aVar.a(Uri.fromFile(new File(string3)));
            }
        }
        try {
            startActivityForResult(aVar.b(), 3);
        } catch (Throwable th) {
            SSDKLog.b().a(th);
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        c cVar = this.googlePlusUtil;
        if (cVar != null) {
            if (cVar.c() || this.googlePlusUtil.b()) {
                this.googlePlusUtil.d();
            }
        }
    }

    public void setPlatformActionListener(Platform platform, PlatformActionListener platformActionListener, PlatformDb platformDb) {
        this.platform = platform;
        this.listener = platformActionListener;
        this.db = platformDb;
    }
}
