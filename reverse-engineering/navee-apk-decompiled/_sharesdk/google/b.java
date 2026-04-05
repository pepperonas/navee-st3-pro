package cn.sharesdk.google;

import cn.sharesdk.framework.utils.SSDKLog;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.mob.MobSDK;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class b {
    /* JADX WARN: Multi-variable type inference failed */
    public void a() {
        try {
            GoogleSignIn.getClient(MobSDK.getContext(), new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestProfile().requestId().build()).signOut().addOnCompleteListener((Executor) this, new OnCompleteListener<Void>() { // from class: cn.sharesdk.google.b.1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public void onComplete(Task<Void> task) {
                    SSDKLog.b().a(" GoogleOfficialHelper revokeAccess is ok ");
                }
            });
        } catch (Throwable unused) {
            SSDKLog.b().a(" GoogleOfficialHelper revokeAccess is failed ");
        }
    }
}
