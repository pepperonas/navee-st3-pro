package com.uz.navee.ui.mine;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.flyjingfish.openimagelib.e0;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.ui.mine.FeedbackDetailActivity;
import com.uz.navee.ui.mine.bean.FeedbackImage;
import com.uz.navee.ui.mine.bean.Myfeedback;
import com.uz.navee.utils.DensityUtil;
import com.uz.navee.utils.c;
import com.uz.navee.utils.j0;
import d4.d;
import java.util.ArrayList;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class FeedbackDetailActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public QMUIGroupListView f13019c;

    /* renamed from: d, reason: collision with root package name */
    public Myfeedback f13020d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f13021e = Boolean.FALSE;

    public class a implements d.h {

        /* renamed from: com.uz.navee.ui.mine.FeedbackDetailActivity$a$a, reason: collision with other inner class name */
        public class C0182a extends TypeToken<HttpResponse<Myfeedback>> {
            public C0182a() {
            }
        }

        public a() {
        }

        @Override // d4.d.h
        public void a(String str) {
            FeedbackDetailActivity.this.B();
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new C0182a().getType());
            if (httpResponse != null && httpResponse.getCode() == 200 && httpResponse.getData() != null) {
                FeedbackDetailActivity.this.f13020d = (Myfeedback) httpResponse.getData();
            }
            FeedbackDetailActivity.this.b0();
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            FeedbackDetailActivity.this.B();
            FeedbackDetailActivity.this.b0();
        }
    }

    private void X() {
        this.f13019c = (QMUIGroupListView) findViewById(R$id.groupListView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        int iA = DensityUtil.a(this, 16.0f);
        QMUICommonListItemView qMUICommonListItemViewC = this.f13019c.c(null, getString(R$string.question_title), this.f13020d.getTitle(), 1, 0);
        qMUICommonListItemViewC.e(iA, 3);
        String vehicleModelName = this.f13020d.getVehicleModelName();
        if (vehicleModelName == null) {
            vehicleModelName = this.f13020d.getVehicleModelNo();
        }
        if (vehicleModelName == null) {
            vehicleModelName = b4.a.x(this.f13020d.getVehicleModelPid()).name;
        }
        QMUICommonListItemView qMUICommonListItemViewC2 = this.f13019c.c(null, getString(R$string.vehicle_model), vehicleModelName, 1, 0);
        QMUICommonListItemView qMUICommonListItemViewC3 = this.f13019c.c(null, getString(R$string.time), this.f13020d.getCreateDate(), 1, 0);
        QMUICommonListItemView qMUICommonListItemViewC4 = this.f13019c.c(null, getString(R$string.view_picture), String.valueOf(this.f13020d.getImgs() != null ? this.f13020d.getImgs().split(";").length : 0), 1, 1);
        com.uz.navee.utils.d.t(this, qMUICommonListItemViewC4);
        QMUICommonListItemView qMUICommonListItemViewC5 = this.f13019c.c(null, getString(R$string.question_description), this.f13020d.getContext(), 0, 0);
        QMUICommonListItemView qMUICommonListItemViewC6 = this.f13019c.c(null, getString(R$string.feedback_reply), j0.a(this.f13020d.getReply()), 0, 0);
        qMUICommonListItemViewC6.e(iA, 1);
        QMUIGroupListView.e(this).c(qMUICommonListItemViewC, new View.OnClickListener() { // from class: h4.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedbackDetailActivity.c0(view);
            }
        }).c(qMUICommonListItemViewC2, new View.OnClickListener() { // from class: h4.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedbackDetailActivity.d0(view);
            }
        }).c(qMUICommonListItemViewC3, new View.OnClickListener() { // from class: h4.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedbackDetailActivity.e0(view);
            }
        }).c(qMUICommonListItemViewC4, new View.OnClickListener() { // from class: h4.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13822a.h0(view);
            }
        }).c(qMUICommonListItemViewC5, new View.OnClickListener() { // from class: h4.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedbackDetailActivity.f0(view);
            }
        }).c(qMUICommonListItemViewC6, new View.OnClickListener() { // from class: h4.v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedbackDetailActivity.g0(view);
            }
        }).g(iA, iA).e(this.f13019c);
        if (com.uz.navee.utils.d.p(this)) {
            com.uz.navee.utils.d.b(this.f13019c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g0(View view) {
    }

    private void initData() {
        if (Build.VERSION.SDK_INT >= 33) {
            this.f13020d = (Myfeedback) getIntent().getSerializableExtra("feedback", Myfeedback.class);
        } else {
            this.f13020d = (Myfeedback) getIntent().getSerializableExtra("feedback");
        }
        a0();
    }

    public void a0() {
        K();
        d.h().f(e4.a.a() + "/myOpinion/info?id=" + this.f13020d.getId(), new a());
    }

    public final void h0(View view) {
        if (TextUtils.isEmpty(this.f13020d.getImgs()) || this.f13021e.booleanValue()) {
            return;
        }
        this.f13021e = Boolean.TRUE;
        String[] strArrSplit = this.f13020d.getImgs().split(";");
        if (strArrSplit.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArrSplit) {
                FeedbackImage feedbackImage = new FeedbackImage();
                feedbackImage.setUrl(str);
                arrayList.add(feedbackImage);
            }
            e0.C(this).A().z(arrayList).B();
        }
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_feedback_detail);
        X();
        c.e(this, getString(R$string.feedback_detail), ContextCompat.getColor(this, R$color.nav_title_color));
        initData();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f13021e = Boolean.FALSE;
    }
}
