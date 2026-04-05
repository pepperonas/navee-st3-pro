package com.uz.navee.ui.mine;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$color;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.databinding.ActivityDataDownloadBinding;
import com.uz.navee.ui.mine.ChangeEmailActivity;
import com.uz.navee.ui.mine.DataDownloadActivity;
import com.uz.navee.utils.c;
import kotlin.jvm.internal.y;
import kotlin.k;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes3.dex */
public final class DataDownloadActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public ActivityDataDownloadBinding f13012c;

    public static final class a extends ClickableSpan {
        public a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            y.f(view, "view");
            DataDownloadActivity.T(DataDownloadActivity.this, DownloadExplainActivity.class, null, 2, null);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            y.f(ds, "ds");
            ds.setColor(DataDownloadActivity.this.getColor(R$color.xC69D7D));
        }
    }

    public static /* synthetic */ void T(DataDownloadActivity dataDownloadActivity, Class cls, Bundle bundle, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            bundle = null;
        }
        dataDownloadActivity.S(cls, bundle);
    }

    public static final void V(DataDownloadActivity this$0, View view) {
        y.f(this$0, "this$0");
        this$0.S(ChangeEmailActivity.class, BundleKt.bundleOf(k.a("step", Integer.valueOf(ChangeEmailActivity.ChangeEmailStep.verifyEmail.ordinal()))));
    }

    public static final void W(DataDownloadActivity this$0, View view) {
        y.f(this$0, "this$0");
        T(this$0, DownloadRecordActivity.class, null, 2, null);
    }

    public final void S(Class cls, Bundle bundle) {
        Intent intent = new Intent(this, (Class<?>) cls);
        if (bundle != null) {
            intent.putExtra("data", bundle);
        }
        startActivity(intent);
    }

    public final void U() {
        String string = getString(R$string.more_detail);
        y.e(string, "getString(...)");
        String str = getString(R$string.download_guide_simple) + string;
        int iT = StringsKt__StringsKt.T(str, string, 0, false, 6, null);
        int length = string.length() + iT;
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new a(), iT, length, 33);
        ActivityDataDownloadBinding activityDataDownloadBinding = this.f13012c;
        ActivityDataDownloadBinding activityDataDownloadBinding2 = null;
        if (activityDataDownloadBinding == null) {
            y.x("binding");
            activityDataDownloadBinding = null;
        }
        activityDataDownloadBinding.tvTips.setMovementMethod(LinkMovementMethod.getInstance());
        ActivityDataDownloadBinding activityDataDownloadBinding3 = this.f13012c;
        if (activityDataDownloadBinding3 == null) {
            y.x("binding");
            activityDataDownloadBinding3 = null;
        }
        activityDataDownloadBinding3.tvTips.setText(spannableString);
        ActivityDataDownloadBinding activityDataDownloadBinding4 = this.f13012c;
        if (activityDataDownloadBinding4 == null) {
            y.x("binding");
        } else {
            activityDataDownloadBinding2 = activityDataDownloadBinding4;
        }
        activityDataDownloadBinding2.tvTips.setHighlightColor(0);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R$layout.activity_data_download);
        y.e(contentView, "setContentView(...)");
        this.f13012c = (ActivityDataDownloadBinding) contentView;
        String string = getString(R$string.download_data);
        y.e(string, "getString(...)");
        c.e(this, string, ContextCompat.getColor(this, R$color.nav_title_color));
        ActivityDataDownloadBinding activityDataDownloadBinding = this.f13012c;
        if (activityDataDownloadBinding == null) {
            y.x("binding");
            activityDataDownloadBinding = null;
        }
        activityDataDownloadBinding.ivDownload.setOnClickListener(new View.OnClickListener() { // from class: h4.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DataDownloadActivity.V(this.f13803a, view);
            }
        });
        activityDataDownloadBinding.tvDownloadRecord.setOnClickListener(new View.OnClickListener() { // from class: h4.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DataDownloadActivity.W(this.f13806a, view);
            }
        });
        U();
    }
}
