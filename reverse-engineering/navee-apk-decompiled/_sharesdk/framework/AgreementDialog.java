package cn.sharesdk.framework;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.ResHelper;

/* loaded from: classes2.dex */
public class AgreementDialog extends FakeActivity {
    private Dialog dialog;
    private OnDialogDismiss onDialogDismiss;

    public interface OnDialogDismiss {
        void consent();

        void refuse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refuse() {
        Dialog dialog = this.dialog;
        if (dialog != null && dialog.isShowing()) {
            this.dialog.dismiss();
            OnDialogDismiss onDialogDismiss = this.onDialogDismiss;
            if (onDialogDismiss != null) {
                onDialogDismiss.refuse();
            }
        }
        this.activity.finish();
    }

    @Override // com.mob.tools.FakeActivity
    public void setActivity(final Activity activity) {
        super.setActivity(activity);
        try {
            this.dialog = new Dialog(activity, ResHelper.getStyleRes(activity, "mobcommon_DialogStyle"));
            View viewInflate = LayoutInflater.from(activity).inflate(ResHelper.getLayoutRes(activity, "sharesdk_agreement_dialog"), (ViewGroup) null);
            this.dialog.setCanceledOnTouchOutside(false);
            this.dialog.setContentView(viewInflate);
            Window window = this.dialog.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            window.setGravity(17);
            window.setAttributes(attributes);
            this.dialog.setCancelable(true);
            viewInflate.findViewById(ResHelper.getIdRes(activity, "sharesdk_agreement_dialog_reject_tv")).setOnClickListener(new View.OnClickListener() { // from class: cn.sharesdk.framework.AgreementDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AgreementDialog.this.refuse();
                }
            });
            viewInflate.findViewById(ResHelper.getIdRes(activity, "sharesdk_agreement_dialog_accept_tv")).setOnClickListener(new View.OnClickListener() { // from class: cn.sharesdk.framework.AgreementDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AgreementDialog.this.dialog != null && AgreementDialog.this.dialog.isShowing()) {
                        AgreementDialog.this.dialog.dismiss();
                        if (AgreementDialog.this.onDialogDismiss != null) {
                            AgreementDialog.this.onDialogDismiss.consent();
                        }
                        cn.sharesdk.framework.a.a.e.a().a(true);
                    }
                    activity.finish();
                }
            });
            this.dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: cn.sharesdk.framework.AgreementDialog.3
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
                    if (i6 != 4) {
                        return false;
                    }
                    AgreementDialog.this.refuse();
                    return false;
                }
            });
            this.dialog.show();
        } catch (Throwable unused) {
        }
    }

    public void setShareParam(OnDialogDismiss onDialogDismiss) {
        this.onDialogDismiss = onDialogDismiss;
    }
}
