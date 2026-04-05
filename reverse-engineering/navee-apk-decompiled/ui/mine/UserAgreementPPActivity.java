package com.uz.navee.ui.mine;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.clj.fastble.data.BleDevice;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.GsonBuilder;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.ui.device.PolicyRevokeActivity;
import com.uz.navee.ui.login.LoginLaunchActivity;
import com.uz.navee.ui.mine.bean.AgreeBean;
import com.uz.navee.ui.wheel.AlertPopup;
import com.uz.navee.utils.DensityUtil;
import com.uz.navee.utils.c;
import com.uz.navee.utils.g0;
import d4.d;
import g4.e1;
import java.util.HashMap;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class UserAgreementPPActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public String f13134c;

    /* renamed from: d, reason: collision with root package name */
    public QMUIGroupListView f13135d;

    /* renamed from: e, reason: collision with root package name */
    public Button f13136e;

    /* renamed from: f, reason: collision with root package name */
    public Boolean f13137f = Boolean.FALSE;

    /* renamed from: g, reason: collision with root package name */
    public String f13138g;

    /* renamed from: h, reason: collision with root package name */
    public String f13139h;

    /* renamed from: i, reason: collision with root package name */
    public String f13140i;

    /* renamed from: j, reason: collision with root package name */
    public BleDevice f13141j;

    /* renamed from: k, reason: collision with root package name */
    public Vehicle f13142k;

    public class a implements d.h {
        public a() {
        }

        @Override // d4.d.h
        public void a(String str) {
            UserAgreementPPActivity.this.B();
            AgreeBean agreeBean = (AgreeBean) new GsonBuilder().create().fromJson(str, AgreeBean.class);
            if (agreeBean == null || agreeBean.getCode() != 200) {
                return;
            }
            UserAgreementPPActivity.this.f13138g = agreeBean.getData().getPolicy();
            UserAgreementPPActivity.this.f13139h = agreeBean.getData().getUser();
            UserAgreementPPActivity.this.f13140i = agreeBean.getData().getRevoke();
            if (UserAgreementPPActivity.this.f13134c == null || UserAgreementPPActivity.this.f13134c.isEmpty()) {
                g0.f("app.policyURL", UserAgreementPPActivity.this.f13138g);
                g0.f("app.userURL", UserAgreementPPActivity.this.f13139h);
            } else {
                g0.f(UserAgreementPPActivity.this.f13134c + ".vehicleModel.policyURL", UserAgreementPPActivity.this.f13138g);
                g0.f(UserAgreementPPActivity.this.f13134c + ".vehicleModel.userURL", UserAgreementPPActivity.this.f13139h);
            }
            UserAgreementPPActivity.this.g0();
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            UserAgreementPPActivity.this.B();
            Toast.makeText(UserAgreementPPActivity.this, exc.getMessage(), 0).show();
        }
    }

    private void c0() {
        this.f13135d = (QMUIGroupListView) findViewById(R$id.groupListView);
        this.f13136e = (Button) findViewById(R$id.btn_revoke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        this.f13135d.removeAllViews();
        int iA = DensityUtil.a(this, 16.0f);
        QMUICommonListItemView qMUICommonListItemViewC = this.f13135d.c(null, getString(R$string.user_agreement), "", 1, 1);
        com.uz.navee.utils.d.t(this, qMUICommonListItemViewC);
        qMUICommonListItemViewC.setRadius(iA);
        QMUIGroupListView.e(this).c(qMUICommonListItemViewC, new View.OnClickListener() { // from class: h4.g2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13782a.l0(view);
            }
        }).g(iA, iA).e(this.f13135d);
        QMUICommonListItemView qMUICommonListItemViewC2 = this.f13135d.c(null, getString(R$string.privacy_policy), "", 1, 1);
        com.uz.navee.utils.d.t(this, qMUICommonListItemViewC2);
        qMUICommonListItemViewC2.setRadius(iA);
        QMUIGroupListView.e(this).c(qMUICommonListItemViewC2, new View.OnClickListener() { // from class: h4.h2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13786a.j0(view);
            }
        }).g(iA, iA).e(this.f13135d);
        if (!TextUtils.isEmpty(this.f13134c) && !TextUtils.isEmpty(this.f13140i)) {
            QMUICommonListItemView qMUICommonListItemViewC3 = this.f13135d.c(null, getString(R$string.revoke_policy), "", 1, 1);
            com.uz.navee.utils.d.t(this, qMUICommonListItemViewC3);
            qMUICommonListItemViewC3.setRadius(iA);
            QMUIGroupListView.e(this).c(qMUICommonListItemViewC3, new View.OnClickListener() { // from class: h4.i2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f13790a.k0(view);
                }
            }).g(iA, iA).e(this.f13135d);
        }
        if (com.uz.navee.utils.d.p(this)) {
            com.uz.navee.utils.d.b(this.f13135d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0() {
        e1.m();
        LoginLaunchActivity.Q0(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(View view) {
        AlertPopup.Q(this, getString(R$string.action_prompt), getString(R$string.app_revoke_policy_msg), getString(R$string.confirm), getString(R$string.cancel), new AlertPopup.a() { // from class: h4.j2
            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public /* synthetic */ void a() {
                j4.c.a(this);
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public final void b() {
                this.f13794a.h0();
            }
        });
    }

    public void f0() {
        d dVarH = d.h();
        HashMap map = new HashMap();
        String str = e4.a.a() + "/agreement";
        String str2 = this.f13134c;
        if (str2 != null && !str2.isEmpty()) {
            str = e4.a.a() + "/vehicle/modelAgreement";
            map.put("vehicleModelId", this.f13134c);
            this.f13136e.setVisibility(8);
        }
        K();
        dVarH.g(str, map, new a());
    }

    public final void j0(View view) {
        if (this.f13137f.booleanValue()) {
            return;
        }
        this.f13137f = Boolean.TRUE;
        Intent intent = new Intent(this, (Class<?>) PrivacyPolicyActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("vehicleModelId", this.f13134c);
        intent.putExtra("data", bundle);
        startActivity(intent);
    }

    public final void k0(View view) {
        if (this.f13137f.booleanValue()) {
            return;
        }
        this.f13137f = Boolean.TRUE;
        Intent intent = new Intent(this, (Class<?>) PolicyRevokeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("bleDevice", this.f13141j);
        bundle.putSerializable("vehicle", this.f13142k);
        bundle.putString(ImagesContract.URL, this.f13140i);
        intent.putExtra("data", bundle);
        startActivity(intent);
    }

    public final void l0(View view) {
        if (this.f13137f.booleanValue()) {
            return;
        }
        this.f13137f = Boolean.TRUE;
        Intent intent = new Intent(this, (Class<?>) UserAgreementActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("vehicleModelId", this.f13134c);
        intent.putExtra("data", bundle);
        startActivity(intent);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_user_agreement_pp);
        c0();
        String string = getString(R$string.user_agreement);
        String string2 = getString(R$string.privacy_policy);
        c.e(this, string + getString(R$string.agree_uapp_tips_and) + string2, ContextCompat.getColor(this, R$color.nav_title_color));
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        if (bundleExtra != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.f13141j = (BleDevice) bundleExtra.getParcelable("bleDevice", BleDevice.class);
                this.f13142k = (Vehicle) bundleExtra.getSerializable("vehicle", Vehicle.class);
            } else {
                this.f13141j = (BleDevice) bundleExtra.getParcelable("bleDevice");
                this.f13142k = (Vehicle) bundleExtra.getSerializable("vehicle");
            }
            this.f13134c = bundleExtra.getString("vehicleModelId", null);
        }
        this.f13136e.setOnClickListener(new View.OnClickListener() { // from class: h4.f2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13778a.i0(view);
            }
        });
        g0();
        f0();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f13137f = Boolean.FALSE;
    }
}
