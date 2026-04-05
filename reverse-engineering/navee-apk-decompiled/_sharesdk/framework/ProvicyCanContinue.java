package cn.sharesdk.framework;

import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.mob.MobSDK;
import com.mob.OperationCallback;
import com.mob.RHolder;
import com.mob.commons.SHARESDK;
import com.mob.commons.dialog.entity.InternalPolicyUi;
import com.mob.tools.utils.ResHelper;

/* loaded from: classes2.dex */
public class ProvicyCanContinue {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ProvicyCanContinue f6172a;

    public interface OnBusinessListener {
        void onContinue();

        void onError(Throwable th);

        void onStop();
    }

    private ProvicyCanContinue() {
        b();
    }

    public static ProvicyCanContinue a() {
        synchronized (ProvicyCanContinue.class) {
            try {
                if (f6172a == null) {
                    synchronized (ProvicyCanContinue.class) {
                        try {
                            if (f6172a == null) {
                                f6172a = new ProvicyCanContinue();
                            }
                        } finally {
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f6172a;
    }

    private void b() {
        RHolder.getInstance().setActivityThemeId(ResHelper.getStyleRes(MobSDK.getContext(), "mobcommon_TranslucentTheme")).setDialogThemeId(ResHelper.getStyleRes(MobSDK.getContext(), "mobcommon_DialogStyle")).setDialogLayoutId(ResHelper.getLayoutRes(MobSDK.getContext(), "mob_authorize_dialog"));
        SSDKLog.b().a(OnekeyShare.SHARESDK_TAG, "ProvicyCanContinue initMobCommonView()");
    }

    public void a(final OnBusinessListener onBusinessListener) {
        MobSDK.canIContinueBusiness(new SHARESDK(), new InternalPolicyUi.Builder().setTitleText(MobSDK.getContext().getResources().getString(ResHelper.getStringRes(MobSDK.getContext(), "mobcommon_authorize_dialog_title"))).setContentText(MobSDK.getContext().getResources().getString(ResHelper.getStringRes(MobSDK.getContext(), "mobcommon_authorize_dialog_content"))).build(), new OperationCallback<Boolean>() { // from class: cn.sharesdk.framework.ProvicyCanContinue.1
            @Override // com.mob.OperationCallback
            public void onFailure(Throwable th) {
                SSDKLog.b().a(OnekeyShare.SHARESDK_TAG, "canIContinueBusiness: onFailure() " + th);
                OnBusinessListener onBusinessListener2 = onBusinessListener;
                if (onBusinessListener2 != null) {
                    onBusinessListener2.onError(th);
                }
            }

            @Override // com.mob.OperationCallback
            public void onComplete(Boolean bool) {
                SSDKLog.b().a(OnekeyShare.SHARESDK_TAG, "canIContinueBusiness: onComplete(), " + bool);
                if (bool.booleanValue()) {
                    OnBusinessListener onBusinessListener2 = onBusinessListener;
                    if (onBusinessListener2 != null) {
                        onBusinessListener2.onContinue();
                    }
                    SSDKLog.b().a(OnekeyShare.SHARESDK_TAG, "MobSDK.canIContinueBusiness if ");
                    return;
                }
                OnBusinessListener onBusinessListener3 = onBusinessListener;
                if (onBusinessListener3 != null) {
                    onBusinessListener3.onStop();
                }
                SSDKLog.b().a(OnekeyShare.SHARESDK_TAG, "MobSDK.canIContinueBusiness else ");
            }
        });
    }
}
