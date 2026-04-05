package cn.sharesdk.facebook;

import android.content.Intent;
import android.widget.LinearLayout;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.mob.tools.FakeActivity;
import java.util.Collections;

/* loaded from: classes2.dex */
public class FacebookOfficialAuth extends FakeActivity {
    private PlatformActionListener actionListener;
    private CallbackManager callbackManager;
    private Platform platform;

    public FacebookOfficialAuth(PlatformActionListener platformActionListener, Platform platform) {
        try {
            this.callbackManager = CallbackManager.Factory.create();
            this.actionListener = platformActionListener;
            this.platform = platform;
            SSDKLog.b().a("FacebookOfficialAuth constuction ");
        } catch (Throwable th) {
            SSDKLog.b().a("FacebookOfficialAuth catch " + th, new Object[0]);
        }
    }

    public void loginManager() {
        SSDKLog.b().a("FacebookOfficialAuth loginManager");
        LoginManager.getInstance().logIn(this.activity, Collections.singleton("email"));
        LoginManager.getInstance().registerCallback(this.callbackManager, new FacebookCallback<LoginResult>() { // from class: cn.sharesdk.facebook.FacebookOfficialAuth.1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(LoginResult loginResult) {
                String strValueOf = String.valueOf(loginResult.getAccessToken().getToken());
                String strValueOf2 = String.valueOf(loginResult.getAccessToken().getExpires());
                String strValueOf3 = String.valueOf(loginResult.getAccessToken().getUserId());
                String strValueOf4 = String.valueOf(loginResult.getAccessToken().getGraphDomain());
                String strValueOf5 = String.valueOf(loginResult.getAccessToken().getPermissions());
                String strValueOf6 = String.valueOf(loginResult.getAccessToken().getApplicationId());
                if (FacebookOfficialAuth.this.platform.getDb() != null) {
                    FacebookOfficialAuth.this.platform.getDb().putToken(strValueOf);
                    FacebookOfficialAuth.this.platform.getDb().put("expires", strValueOf2);
                    FacebookOfficialAuth.this.platform.getDb().putUserId(strValueOf3);
                    FacebookOfficialAuth.this.platform.getDb().put("GraphDomain", strValueOf4);
                    FacebookOfficialAuth.this.platform.getDb().put("Permissions", strValueOf5);
                    FacebookOfficialAuth.this.platform.getDb().put("ApplicationId", strValueOf6);
                }
                if (FacebookOfficialAuth.this.actionListener != null) {
                    FacebookOfficialAuth.this.actionListener.onComplete(FacebookOfficialAuth.this.platform, 1, null);
                }
                SSDKLog.b().a("FacebookOfficialAuth onSuccess finish");
                FacebookOfficialAuth.this.finish();
            }

            public void onCancel() {
                if (FacebookOfficialAuth.this.actionListener != null) {
                    FacebookOfficialAuth.this.actionListener.onCancel(FacebookOfficialAuth.this.platform, 1);
                }
                SSDKLog.b().a("FacebookOfficialAuth onCancel finish");
                FacebookOfficialAuth.this.finish();
            }

            public void onError(FacebookException facebookException) {
                if (FacebookOfficialAuth.this.actionListener != null) {
                    FacebookOfficialAuth.this.actionListener.onError(FacebookOfficialAuth.this.platform, 1, facebookException);
                }
                SSDKLog.b().a("FacebookOfficialAuth onError finish");
                FacebookOfficialAuth.this.finish();
            }
        });
    }

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i6, int i7, Intent intent) {
        this.callbackManager.onActivityResult(i6, i7, intent);
        super.onActivityResult(i6, i7, intent);
        SSDKLog.b().a("FacebookOfficialAuth onActivityResult");
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        SSDKLog.b().a("FacebookOfficialAuth onCreate ");
        try {
            LinearLayout linearLayout = new LinearLayout(this.activity);
            linearLayout.setOrientation(1);
            this.activity.setContentView(linearLayout);
        } catch (Exception e7) {
            SSDKLog.b().a(e7);
            SSDKLog.b().a("FacebookOfficialAuth onCreate exception " + e7.getMessage());
        }
        try {
            loginManager();
            SSDKLog.b().a("FacebookOfficialAuth onCreate loginManager() ");
        } catch (Throwable th) {
            PlatformActionListener platformActionListener = this.actionListener;
            if (platformActionListener != null) {
                platformActionListener.onError(this.platform, 1, th);
            }
            SSDKLog.b().a("FacebookOfficialAuth onCreate catch: " + th);
            finish();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        super.onDestroy();
        SSDKLog.b().a("FacebookOfficialAuth onDestroy");
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        super.onPause();
        SSDKLog.b().a("FacebookOfficialAuth onPause");
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        super.onResume();
        SSDKLog.b().a("FacebookOfficialAuth onResume");
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        super.onStop();
        SSDKLog.b().a("FacebookOfficialAuth onStop");
    }
}
