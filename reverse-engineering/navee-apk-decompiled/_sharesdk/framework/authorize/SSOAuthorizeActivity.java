package cn.sharesdk.framework.authorize;

import android.content.Intent;
import cn.sharesdk.framework.utils.SSDKLog;

/* loaded from: classes2.dex */
public class SSOAuthorizeActivity extends AbstractAuthorizeActivity {
    private static final int DEFAULT_AUTH_ACTIVITY_CODE = 32973;
    protected SSOListener listener;
    private c sso;

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i6, int i7, Intent intent) {
        try {
            this.sso.a(i6, i7, intent);
        } catch (Throwable th) {
            finish();
            SSDKLog.b().a(th);
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        try {
            c sSOProcessor = this.helper.getSSOProcessor(this);
            this.sso = sSOProcessor;
            if (sSOProcessor != null) {
                sSOProcessor.a(DEFAULT_AUTH_ACTIVITY_CODE);
                this.sso.a();
                return;
            }
            finish();
            AuthorizeListener authorizeListener = this.helper.getAuthorizeListener();
            if (authorizeListener != null) {
                authorizeListener.onError(new Throwable("Failed to start SSO for " + this.helper.getPlatform().getName()));
            }
        } catch (Throwable th) {
            finish();
            SSDKLog.b().a(th);
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onNewIntent(Intent intent) {
        try {
            this.sso.a(intent);
        } catch (Throwable th) {
            finish();
            SSDKLog.b().a(th);
        }
    }

    public void setSSOListener(SSOListener sSOListener) {
        this.listener = sSOListener;
    }
}
