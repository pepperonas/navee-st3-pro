package com.uz.navee.ui.mine;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.b;
import com.bumptech.glide.h;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.uz.navee.R$drawable;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.bean.UserInfo;
import com.uz.navee.ui.login.LoginLaunchActivity;
import com.uz.navee.ui.web.WebActivity;
import com.uz.navee.ui.wheel.AlertPopup;
import com.uz.navee.utils.DensityUtil;
import com.uz.navee.utils.g0;
import com.uz.navee.utils.l0;
import com.uz.navee.utils.o;
import com.youth.banner.util.BannerUtils;
import d4.d;
import g4.e1;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class MineFragment extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public QMUIGroupListView f13040a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f13041b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f13042c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f13043d;

    /* renamed from: f, reason: collision with root package name */
    public QMUICommonListItemView f13045f;

    /* renamed from: g, reason: collision with root package name */
    public QMUICommonListItemView f13046g;

    /* renamed from: h, reason: collision with root package name */
    public LinearLayout f13047h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f13048i;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f13049j;

    /* renamed from: l, reason: collision with root package name */
    public String f13051l;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f13044e = Boolean.FALSE;

    /* renamed from: k, reason: collision with root package name */
    public String f13050k = "";

    public class a implements d.h {

        /* renamed from: com.uz.navee.ui.mine.MineFragment$a$a, reason: collision with other inner class name */
        public class C0183a extends TypeToken<HttpResponse<UserInfo>> {
            public C0183a() {
            }
        }

        public a() {
        }

        @Override // d4.d.h
        public void a(String str) {
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new C0183a().getType());
            if (httpResponse != null) {
                if (httpResponse.getCode() != 200) {
                    if (httpResponse.getCode() == 500 && httpResponse.getData() == null) {
                        e1.m();
                        LoginLaunchActivity.Q0(MineFragment.this.getActivity());
                        return;
                    }
                    FragmentActivity activity = MineFragment.this.getActivity();
                    if (activity == null || httpResponse.getMsg().isEmpty()) {
                        return;
                    }
                    Toast.makeText(activity, httpResponse.getMsg(), 0).show();
                    return;
                }
                if (httpResponse.getData() == null) {
                    e1.m();
                    LoginLaunchActivity.Q0(MineFragment.this.getActivity());
                    return;
                }
                UserInfo userInfo = (UserInfo) httpResponse.getData();
                e1.s(userInfo);
                if (userInfo.getUserName().isEmpty()) {
                    MineFragment.this.f13042c.setText(userInfo.getNickName());
                } else {
                    MineFragment.this.f13042c.setText(userInfo.getUserName());
                }
                if (userInfo.getHeadImg() != null && !userInfo.getHeadImg().isEmpty() && MineFragment.this.getActivity() != null) {
                    ((h) ((h) b.v(MineFragment.this).t(Uri.parse(userInfo.getHeadImg())).d()).V(R$mipmap.img_avatar_default)).z0(MineFragment.this.f13041b);
                }
                if (!TextUtils.isEmpty(userInfo.getNaveeId())) {
                    MineFragment.this.f13051l = userInfo.getNaveeId();
                    MineFragment.this.f13047h.setVisibility(0);
                    MineFragment.this.f13048i.setText("Navee ID：" + MineFragment.this.f13051l);
                }
                MineFragment.this.t(String.valueOf(userInfo.getUnReadOpinion()));
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            FragmentActivity activity = MineFragment.this.getActivity();
            if (activity != null) {
                Toast.makeText(activity, exc.getMessage(), 0).show();
            }
        }
    }

    private void n(View view) {
        this.f13040a = (QMUIGroupListView) view.findViewById(R$id.groupListView);
        this.f13041b = (ImageView) view.findViewById(R$id.avatarView);
        this.f13042c = (TextView) view.findViewById(R$id.nameView);
        this.f13047h = (LinearLayout) view.findViewById(R$id.ll_identifier);
        this.f13048i = (TextView) view.findViewById(R$id.tv_identifier);
        this.f13049j = (ImageView) view.findViewById(R$id.iv_identifier_copy);
    }

    private void o() {
        try {
            this.f13050k = o.h(requireContext());
        } catch (Exception unused) {
        }
        int iA = DensityUtil.a(requireContext(), 15.0f);
        QMUICommonListItemView qMUICommonListItemViewC = this.f13040a.c(ContextCompat.getDrawable(requireContext(), R$mipmap.ic_mine_account), getString(R$string.account_information), "", 1, 1);
        com.uz.navee.utils.d.t(requireContext(), qMUICommonListItemViewC);
        qMUICommonListItemViewC.e(iA, 3);
        QMUICommonListItemView qMUICommonListItemViewC2 = this.f13040a.c(ContextCompat.getDrawable(requireContext(), R$mipmap.ic_mine_inter), getString(R$string.switch_region), "", 1, 1);
        com.uz.navee.utils.d.t(requireContext(), qMUICommonListItemViewC2);
        QMUICommonListItemView qMUICommonListItemViewC3 = this.f13040a.c(ContextCompat.getDrawable(requireContext(), R$mipmap.ic_mine_language), getString(R$string.language_selection), "", 1, 1);
        com.uz.navee.utils.d.t(requireContext(), qMUICommonListItemViewC3);
        qMUICommonListItemViewC3.e(iA, 1);
        QMUIGroupListView.e(getContext()).c(qMUICommonListItemViewC, new View.OnClickListener() { // from class: h4.c1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13763a.u(view);
            }
        }).c(qMUICommonListItemViewC2, new View.OnClickListener() { // from class: h4.f1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13777a.x(view);
            }
        }).c(qMUICommonListItemViewC3, new View.OnClickListener() { // from class: h4.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13781a.w(view);
            }
        }).g(iA, iA).e(this.f13040a);
        if (com.uz.navee.utils.d.o()) {
            qMUICommonListItemViewC.getTextView().setTextSize(15.0f);
            qMUICommonListItemViewC2.getTextView().setTextSize(15.0f);
            qMUICommonListItemViewC3.getTextView().setTextSize(15.0f);
        } else {
            qMUICommonListItemViewC.getTextView().setTextSize(13.0f);
            qMUICommonListItemViewC2.getTextView().setTextSize(15.0f);
            qMUICommonListItemViewC3.getTextView().setTextSize(15.0f);
        }
        QMUICommonListItemView qMUICommonListItemViewC4 = this.f13040a.c(ContextCompat.getDrawable(requireContext(), R$mipmap.ic_mine_support), getString(R$string.sold_support), "", 1, 1);
        com.uz.navee.utils.d.t(requireContext(), qMUICommonListItemViewC4);
        qMUICommonListItemViewC4.e(iA, 3);
        String string = getString(R$string.user_agreement);
        String string2 = getString(R$string.privacy_policy);
        QMUICommonListItemView qMUICommonListItemViewC5 = this.f13040a.c(ContextCompat.getDrawable(requireContext(), R$mipmap.ic_mine_sapp), string + getString(R$string.agree_uapp_tips_and) + string2, "", 1, 1);
        com.uz.navee.utils.d.t(requireContext(), qMUICommonListItemViewC5);
        this.f13046g = this.f13040a.c(ContextCompat.getDrawable(requireContext(), R$mipmap.ic_mine_clear), getString(R$string.clear_cache), this.f13050k, 1, 1);
        com.uz.navee.utils.d.t(requireContext(), this.f13046g);
        this.f13045f = this.f13040a.c(ContextCompat.getDrawable(requireContext(), R$mipmap.ic_mine_info), getString(R$string.version_info), com.uz.navee.utils.d.c(), 1, 1);
        com.uz.navee.utils.d.t(requireContext(), this.f13045f);
        if (LoginLaunchActivity.f12778t == 2) {
            QMUIGroupListView.e(getContext()).c(qMUICommonListItemViewC4, new View.OnClickListener() { // from class: h4.h1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f13785a.z(view);
                }
            }).c(qMUICommonListItemViewC5, new View.OnClickListener() { // from class: h4.i1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f13789a.y(view);
                }
            }).c(this.f13046g, new View.OnClickListener() { // from class: h4.d1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f13769a.v(view);
                }
            }).c(this.f13045f, new View.OnClickListener() { // from class: h4.e1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f13772a.A(view);
                }
            }).c(l0.b(this.f13040a, "记分卡", "", 15, 1), new View.OnClickListener() { // from class: h4.j1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f13793a.p(view);
                }
            }).g(iA, iA).e(this.f13040a);
        } else {
            this.f13045f.e(iA, 1);
            QMUIGroupListView.e(getContext()).c(qMUICommonListItemViewC4, new View.OnClickListener() { // from class: h4.h1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f13785a.z(view);
                }
            }).c(qMUICommonListItemViewC5, new View.OnClickListener() { // from class: h4.i1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f13789a.y(view);
                }
            }).c(this.f13046g, new View.OnClickListener() { // from class: h4.d1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f13769a.v(view);
                }
            }).c(this.f13045f, new View.OnClickListener() { // from class: h4.e1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f13772a.A(view);
                }
            }).g(iA, iA).e(this.f13040a);
        }
        if (com.uz.navee.utils.d.o()) {
            qMUICommonListItemViewC4.getTextView().setTextSize(15.0f);
            qMUICommonListItemViewC5.getTextView().setTextSize(15.0f);
            this.f13046g.getTextView().setTextSize(15.0f);
            this.f13045f.getTextView().setTextSize(15.0f);
        } else {
            qMUICommonListItemViewC4.getTextView().setTextSize(13.0f);
            qMUICommonListItemViewC5.getTextView().setTextSize(13.0f);
            this.f13046g.getTextView().setTextSize(13.0f);
            this.f13045f.getTextView().setTextSize(13.0f);
        }
        if (com.uz.navee.utils.d.p(getActivity())) {
            com.uz.navee.utils.d.b(this.f13040a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(View view) {
        Object objA = g0.a("Environment", 0);
        if (objA == null || ((Integer) objA).intValue() != 2) {
            WebActivity.f13179h.a(requireContext(), "", "https://sc.naveetech.com");
        } else {
            WebActivity.f13179h.a(requireContext(), "", "http://naveescore.chejiyou.com");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(View view) {
        com.uz.navee.utils.d.d(requireContext(), this.f13051l);
        Toast.makeText(requireContext(), getString(R$string.copy_success), 0).show();
    }

    public final void A(View view) {
        if (this.f13044e.booleanValue()) {
            return;
        }
        this.f13044e = Boolean.TRUE;
        startActivity(new Intent(getActivity(), (Class<?>) VersionMsgActivity.class));
    }

    public void initData() {
        d.h().f(e4.a.a() + "/getUser", new a());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_mine, viewGroup, false);
        n(viewInflate);
        o();
        this.f13049j.setOnClickListener(new View.OnClickListener() { // from class: h4.a1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13755a.q(view);
            }
        });
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f13044e = Boolean.FALSE;
        try {
            initData();
            String headImg = e1.u().f13675c.getHeadImg();
            if (headImg == null || headImg.isEmpty() || getActivity() == null) {
                return;
            }
            ((h) ((h) b.v(this).t(Uri.parse(headImg)).d()).V(R$mipmap.img_avatar_default)).z0(this.f13041b);
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }

    public final /* synthetic */ void r(String str) {
        if (TextUtils.isEmpty(str) || "0".equalsIgnoreCase(str)) {
            this.f13043d.setVisibility(4);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f13043d.getLayoutParams();
        int iDp2px = BannerUtils.dp2px(20.0f);
        layoutParams.height = iDp2px;
        layoutParams.width = iDp2px;
        this.f13043d.setLayoutParams(layoutParams);
        this.f13043d.setText(str);
        this.f13043d.setGravity(17);
        this.f13043d.setTextColor(-1);
        this.f13043d.setBackgroundResource(R$drawable.round_red);
        this.f13043d.setVisibility(0);
    }

    public final /* synthetic */ void s() {
        o.a(requireContext());
        StringBuilder sb = new StringBuilder();
        sb.append("0 ");
        sb.append(com.uz.navee.utils.d.n() ? "ميجابايت" : "M");
        this.f13046g.setDetailText(sb.toString());
    }

    public final void t(final String str) {
        TextView textView = this.f13043d;
        if (textView != null) {
            textView.post(new Runnable() { // from class: h4.k1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13797a.r(str);
                }
            });
        }
    }

    public final void u(View view) {
        if (this.f13044e.booleanValue()) {
            return;
        }
        startActivity(new Intent(getActivity(), (Class<?>) AccountSettingActivity.class));
        this.f13044e = Boolean.TRUE;
    }

    public final void v(View view) {
        AlertPopup.P(getActivity(), getString(R$string.clear_cache), getString(R$string.clear_cache_message), new AlertPopup.a() { // from class: h4.b1
            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public /* synthetic */ void a() {
                j4.c.a(this);
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public final void b() {
                this.f13759a.s();
            }
        });
    }

    public final void w(View view) {
        if (this.f13044e.booleanValue()) {
            return;
        }
        startActivity(new Intent(getActivity(), (Class<?>) LanguageSettingActivity.class));
        this.f13044e = Boolean.TRUE;
    }

    public final void x(View view) {
        if (this.f13044e.booleanValue()) {
            return;
        }
        startActivity(new Intent(getActivity(), (Class<?>) RegionSettingActivity.class));
        this.f13044e = Boolean.TRUE;
    }

    public final void y(View view) {
        if (this.f13044e.booleanValue()) {
            return;
        }
        startActivity(new Intent(getActivity(), (Class<?>) UserAgreementPPActivity.class));
        this.f13044e = Boolean.TRUE;
    }

    public final void z(View view) {
        if (this.f13044e.booleanValue()) {
            return;
        }
        startActivity(new Intent(getActivity(), (Class<?>) SoldSupportActivity.class));
        this.f13044e = Boolean.TRUE;
    }
}
