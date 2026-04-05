package com.uz.navee.ui.mine;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.google.GooglePlus;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.bean.EmptyResponseData;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.bean.UserInfo;
import com.uz.navee.ui.login.LoginLaunchActivity;
import com.uz.navee.ui.mine.ChangeEmailActivity;
import com.uz.navee.ui.mine.bean.BaseBean;
import com.uz.navee.ui.mine.bean.UploadBean;
import com.uz.navee.ui.wheel.AlertPopup;
import com.uz.navee.utils.DensityUtil;
import d4.d;
import g4.e1;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class AccountSettingActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public QMUIGroupListView f12903c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f12904d;

    /* renamed from: e, reason: collision with root package name */
    public Button f12905e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f12906f;

    /* renamed from: h, reason: collision with root package name */
    public QMUITipDialog f12908h;

    /* renamed from: i, reason: collision with root package name */
    public d4.d f12909i;

    /* renamed from: k, reason: collision with root package name */
    public ActivityResultLauncher f12911k;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f12907g = Boolean.FALSE;

    /* renamed from: j, reason: collision with root package name */
    public String f12910j = "";

    public class a implements d.h {
        public a() {
        }

        @Override // d4.d.h
        public void a(String str) {
            AccountSettingActivity.this.f12908h.dismiss();
            BaseBean baseBean = (BaseBean) new GsonBuilder().create().fromJson(str, BaseBean.class);
            if (baseBean != null) {
                if (baseBean.getCode() != 200) {
                    Toast.makeText(AccountSettingActivity.this, baseBean.getMsg(), 0).show();
                } else {
                    e1.m();
                    LoginLaunchActivity.Q0(AccountSettingActivity.this);
                }
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            AccountSettingActivity.this.f12908h.dismiss();
            Toast.makeText(AccountSettingActivity.this, exc.getMessage(), 0).show();
        }
    }

    public class b implements d.h {
        public b() {
        }

        @Override // d4.d.h
        public void a(String str) {
            AccountSettingActivity.this.f12908h.dismiss();
            UploadBean uploadBean = (UploadBean) new GsonBuilder().create().fromJson(str, UploadBean.class);
            if (uploadBean != null) {
                if (uploadBean.getCode() != 200) {
                    Toast.makeText(AccountSettingActivity.this, uploadBean.getMsg(), 0).show();
                    return;
                }
                e1.u().f13675c.setHeadImg(uploadBean.getData().getUrl());
                e1.s(e1.u().f13675c);
                AccountSettingActivity.this.C0(uploadBean.getData().getUrl());
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            AccountSettingActivity.this.f12908h.dismiss();
            Toast.makeText(AccountSettingActivity.this, exc.getMessage(), 0).show();
        }
    }

    public class c implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ QMUITipDialog f12914a;

        public c(QMUITipDialog qMUITipDialog) {
            this.f12914a = qMUITipDialog;
        }

        @Override // d4.d.h
        public void a(String str) {
            this.f12914a.dismiss();
            BaseBean baseBean = (BaseBean) new GsonBuilder().create().fromJson(str, BaseBean.class);
            if (baseBean != null) {
                if (baseBean.getCode() == 200) {
                    Toast.makeText(AccountSettingActivity.this, baseBean.getMsg(), 0).show();
                } else {
                    Toast.makeText(AccountSettingActivity.this, baseBean.getMsg(), 0).show();
                }
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            this.f12914a.dismiss();
            Toast.makeText(AccountSettingActivity.this, exc.getMessage(), 0).show();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccountSettingActivity.this.u0(false, "", true);
        }
    }

    public class e implements AlertPopup.a {
        public e() {
        }

        @Override // com.uz.navee.ui.wheel.AlertPopup.a
        public void a() {
            AccountSettingActivity.this.f12907g = Boolean.FALSE;
        }

        @Override // com.uz.navee.ui.wheel.AlertPopup.a
        public void b() {
            AccountSettingActivity.this.f12907g = Boolean.FALSE;
            e1.m();
            LoginLaunchActivity.Q0(AccountSettingActivity.this);
        }
    }

    public class f implements AlertPopup.a {
        public f() {
        }

        @Override // com.uz.navee.ui.wheel.AlertPopup.a
        public void a() {
            AccountSettingActivity.this.f12907g = Boolean.FALSE;
        }

        @Override // com.uz.navee.ui.wheel.AlertPopup.a
        public void b() {
            AccountSettingActivity accountSettingActivity = AccountSettingActivity.this;
            accountSettingActivity.f12907g = Boolean.FALSE;
            accountSettingActivity.q0();
        }
    }

    public class g implements PlatformActionListener {

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f12920a;

            public a(String str) {
                this.f12920a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(AccountSettingActivity.this, this.f12920a, 1).show();
            }
        }

        public g() {
        }

        @Override // cn.sharesdk.framework.PlatformActionListener
        public void onCancel(Platform platform, int i6) {
        }

        @Override // cn.sharesdk.framework.PlatformActionListener
        public void onComplete(Platform platform, int i6, HashMap map) {
            String strExportData = platform.getDb().exportData();
            String userId = platform.getDb().getUserId();
            String userName = platform.getDb().getUserName();
            String userIcon = platform.getDb().getUserIcon();
            Log.e(OnekeyShare.SHARESDK_TAG, "==========================" + strExportData + "\nuserId:" + userId + "\nuserName:" + userName + "\nuserIcon:" + userIcon);
            if (map != null) {
                Log.e(OnekeyShare.SHARESDK_TAG, "==========================" + map.toString());
            }
            AccountSettingActivity.this.j0(2, userId, userName, userIcon, strExportData);
        }

        @Override // cn.sharesdk.framework.PlatformActionListener
        public void onError(Platform platform, int i6, Throwable th) {
            new Handler(Looper.getMainLooper()).post(new a(th.getMessage()));
        }
    }

    public class h implements d.h {

        public class a extends TypeToken<HttpResponse<EmptyResponseData>> {
            public a() {
            }
        }

        public h() {
        }

        @Override // d4.d.h
        public void a(String str) {
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse != null) {
                if (httpResponse.getCode() == 200) {
                    AccountSettingActivity.this.k0();
                } else {
                    Toast.makeText(AccountSettingActivity.this, httpResponse.getMsg(), 0).show();
                }
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            Toast.makeText(AccountSettingActivity.this, exc.getMessage(), 0).show();
        }
    }

    public class i implements d.h {

        public class a extends TypeToken<HttpResponse<EmptyResponseData>> {
            public a() {
            }
        }

        public i() {
        }

        @Override // d4.d.h
        public void a(String str) {
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse != null) {
                if (httpResponse.getCode() == 200) {
                    AccountSettingActivity.this.k0();
                } else {
                    Toast.makeText(AccountSettingActivity.this, httpResponse.getMsg(), 0).show();
                }
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            Toast.makeText(AccountSettingActivity.this, exc.getMessage(), 0).show();
        }
    }

    public class j implements d.h {

        public class a extends TypeToken<HttpResponse<UserInfo>> {
            public a() {
            }
        }

        public j() {
        }

        @Override // d4.d.h
        public void a(String str) {
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse != null) {
                if (httpResponse.getCode() != 200) {
                    if (httpResponse.getMsg().isEmpty()) {
                        return;
                    }
                    Toast.makeText(AccountSettingActivity.this, httpResponse.getMsg(), 0).show();
                } else if (httpResponse.getData() != null) {
                    e1.s((UserInfo) httpResponse.getData());
                    AccountSettingActivity.this.l0();
                }
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            Toast.makeText(AccountSettingActivity.this, exc.getMessage(), 0).show();
        }
    }

    public class k implements AlertPopup.a {
        public k() {
        }

        @Override // com.uz.navee.ui.wheel.AlertPopup.a
        public void a() {
            AccountSettingActivity.this.f12907g = Boolean.FALSE;
        }

        @Override // com.uz.navee.ui.wheel.AlertPopup.a
        public void b() {
            AccountSettingActivity.this.f12907g = Boolean.FALSE;
            AccountSettingActivity.this.f12911k.launch(new Intent(AccountSettingActivity.this, (Class<?>) ChangeAccountActivity.class));
        }
    }

    private void i0() {
        this.f12903c = (QMUIGroupListView) findViewById(R$id.groupListView);
        this.f12904d = (ImageView) findViewById(R$id.iv_user_img);
        this.f12905e = (Button) findViewById(R$id.btn_logout);
        this.f12906f = (TextView) findViewById(R$id.tv_nickname);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        this.f12903c.removeAllViews();
        int iA = DensityUtil.a(this, 16.0f);
        ArrayList<Pair> arrayList = new ArrayList();
        final String naveeId = e1.u().f13675c.getNaveeId();
        if (!TextUtils.isEmpty(naveeId)) {
            QMUICommonListItemView qMUICommonListItemViewC = this.f12903c.c(null, "Navee ID", naveeId, 1, 1);
            com.uz.navee.utils.d.s(this, qMUICommonListItemViewC, R$mipmap.ic_copy, new View.OnClickListener() { // from class: h4.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f13751a.m0(naveeId, view);
                }
            });
            QMUIGroupListView.e(this).c(qMUICommonListItemViewC, null).g(iA, iA).e(this.f12903c);
        }
        int registerType = e1.u().f13675c.getRegisterType();
        String str = "Google";
        if (registerType == 1 || registerType == 2 || registerType == 5) {
            String email = e1.u().f13675c.getEmail();
            QMUICommonListItemView qMUICommonListItemViewC2 = this.f12903c.c(null, getString(R$string.email), getString(email != null && !email.isEmpty() ? R$string.change : R$string.bind), 1, 1);
            com.uz.navee.utils.d.t(this, qMUICommonListItemViewC2);
            qMUICommonListItemViewC2.e(iA, 3);
            int googleFlag = e1.u().f13675c.getGoogleFlag();
            String googleEmail = e1.u().f13675c.getGoogleEmail();
            if (googleFlag == 1 && googleEmail != null && !googleEmail.isEmpty()) {
                str = "Google\n(" + googleEmail + ")";
            }
            QMUICommonListItemView qMUICommonListItemViewC3 = this.f12903c.c(null, str, getString(googleFlag == 1 ? R$string.unbind : R$string.bind), 1, 1);
            com.uz.navee.utils.d.t(this, qMUICommonListItemViewC3);
            qMUICommonListItemViewC3.e(iA, 1);
            qMUICommonListItemViewC3.getTextView().setMaxLines(2);
            qMUICommonListItemViewC3.getTextView().setEllipsize(TextUtils.TruncateAt.END);
            QMUIGroupListView.e(this).c(qMUICommonListItemViewC2, new View.OnClickListener() { // from class: h4.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f13757a.w0(view);
                }
            }).c(qMUICommonListItemViewC3, new View.OnClickListener() { // from class: h4.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f13761a.A0(view);
                }
            }).g(iA, iA).e(this.f12903c);
            QMUICommonListItemView qMUICommonListItemViewC4 = this.f12903c.c(null, getString(R$string.change_pwd), "", 1, 1);
            com.uz.navee.utils.d.t(this, qMUICommonListItemViewC4);
            if (e1.u().f13675c.getUaccountFlag() == 0) {
                QMUICommonListItemView qMUICommonListItemViewC5 = this.f12903c.c(null, getString(R$string.change_account), "", 1, 1);
                com.uz.navee.utils.d.t(this, qMUICommonListItemViewC5);
                qMUICommonListItemViewC5.e(iA, 3);
                arrayList.add(new Pair(qMUICommonListItemViewC5, new View.OnClickListener() { // from class: h4.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f13765a.v0(view);
                    }
                }));
                arrayList.add(new Pair(qMUICommonListItemViewC4, new View.OnClickListener() { // from class: h4.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f13770a.x0(view);
                    }
                }));
            } else {
                qMUICommonListItemViewC4.e(iA, 3);
                arrayList.add(new Pair(qMUICommonListItemViewC4, new View.OnClickListener() { // from class: h4.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f13770a.x0(view);
                    }
                }));
            }
        } else if (registerType == 3) {
            String facebookEmail = e1.u().f13675c.getFacebookEmail();
            QMUICommonListItemView qMUICommonListItemViewC6 = this.f12903c.c(null, (facebookEmail == null || facebookEmail.isEmpty()) ? "Facebook" : "Facebook\n(" + facebookEmail + ")", getString(R$string.bound), 1, 0);
            qMUICommonListItemViewC6.setRadius(iA);
            qMUICommonListItemViewC6.getTextView().setMaxLines(2);
            qMUICommonListItemViewC6.getTextView().setEllipsize(TextUtils.TruncateAt.END);
            QMUIGroupListView.e(this).c(qMUICommonListItemViewC6, null).g(iA, iA).e(this.f12903c);
        } else if (registerType == 4) {
            String googleEmail2 = e1.u().f13675c.getGoogleEmail();
            if (googleEmail2 != null && !googleEmail2.isEmpty()) {
                str = "Google\n(" + googleEmail2 + ")";
            }
            QMUICommonListItemView qMUICommonListItemViewC7 = this.f12903c.c(null, str, getString(R$string.bound), 1, 0);
            qMUICommonListItemViewC7.setRadius(iA);
            qMUICommonListItemViewC7.getTextView().setMaxLines(2);
            qMUICommonListItemViewC7.getTextView().setEllipsize(TextUtils.TruncateAt.END);
            QMUIGroupListView.e(this).c(qMUICommonListItemViewC7, null).g(iA, iA).e(this.f12903c);
        }
        QMUIGroupListView.a aVarE = QMUIGroupListView.e(this);
        for (Pair pair : arrayList) {
            aVarE.c((QMUICommonListItemView) pair.first, (View.OnClickListener) pair.second);
        }
        QMUICommonListItemView qMUICommonListItemViewC8 = this.f12903c.c(null, getString(R$string.download_user_data), "", 1, 1);
        com.uz.navee.utils.d.t(this, qMUICommonListItemViewC8);
        if (arrayList.isEmpty()) {
            qMUICommonListItemViewC8.e(iA, 3);
        }
        QMUICommonListItemView qMUICommonListItemViewC9 = this.f12903c.c(null, getString(R$string.delete_account), "", 1, 1);
        com.uz.navee.utils.d.t(this, qMUICommonListItemViewC9);
        qMUICommonListItemViewC9.e(iA, 1);
        aVarE.c(qMUICommonListItemViewC8, new View.OnClickListener() { // from class: h4.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13776a.y0(view);
            }
        }).c(qMUICommonListItemViewC9, new View.OnClickListener() { // from class: h4.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13779a.z0(view);
            }
        }).g(iA, iA).e(this.f12903c);
        this.f12904d.setOnClickListener(new d());
        this.f12905e.setOnClickListener(new View.OnClickListener() { // from class: h4.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13783a.p0(view);
            }
        });
        String headImg = e1.u().f13675c.getHeadImg();
        if (!TextUtils.isEmpty(headImg)) {
            ((com.bumptech.glide.h) ((com.bumptech.glide.h) com.bumptech.glide.b.w(this).t(Uri.parse(headImg)).d()).V(R$mipmap.img_avatar_default)).z0(this.f12904d);
        }
        this.f12909i = d4.d.h();
        this.f12908h = new QMUITipDialog.a(this).f(1).g(getString(R$string.delete_account)).a();
        if (com.uz.navee.utils.d.p(this)) {
            com.uz.navee.utils.d.b(this.f12903c);
        }
    }

    public final void A0(View view) {
        int registerType = e1.u().f13675c.getRegisterType();
        int googleFlag = e1.u().f13675c.getGoogleFlag();
        if (registerType == 1 || registerType == 2) {
            if (googleFlag != 0) {
                B0(2);
                return;
            }
            Platform platform = ShareSDK.getPlatform(GooglePlus.NAME);
            platform.removeAccount(true);
            platform.setPlatformActionListener(new g());
            platform.SSOSetting(false);
            platform.authorize();
        }
    }

    public final void B0(int i6) {
        String str = e4.a.a() + "/unbindThirdParty";
        HashMap map = new HashMap();
        map.put("loginType", String.valueOf(i6));
        this.f12909i.g(str, map, new i());
    }

    public final void C0(String str) {
        QMUITipDialog qMUITipDialogA = new QMUITipDialog.a(this).f(1).a();
        HashMap map = new HashMap();
        map.put("headImg", str);
        String str2 = e4.a.a() + "/updateUser";
        qMUITipDialogA.show();
        this.f12909i.g(str2, map, new c(qMUITipDialogA));
    }

    public void D0(String str) {
        String str2 = e4.a.a() + "/upload";
        QMUITipDialog qMUITipDialogA = new QMUITipDialog.a(this).f(1).a();
        this.f12908h = qMUITipDialogA;
        qMUITipDialogA.show();
        this.f12909i.d(str2, str, new b());
    }

    public final void j0(int i6, String str, String str2, String str3, String str4) {
        String str5 = e4.a.a() + "/bindThirdParty";
        HashMap map = new HashMap();
        map.put("loginType", String.valueOf(i6));
        map.put("uid", str);
        map.put("raw", str4);
        if (str2 != null) {
            map.put("nickName", str2);
        }
        if (str3 != null) {
            map.put("icon", str3);
        }
        this.f12909i.g(str5, map, new h());
    }

    public final void k0() {
        d4.d.h().f(e4.a.a() + "/getUser", new j());
    }

    public final /* synthetic */ void m0(String str, View view) {
        com.uz.navee.utils.d.d(this, str);
        Toast.makeText(this, getString(R$string.copy_success), 0).show();
    }

    public final /* synthetic */ void n0(ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            k0();
        }
    }

    public final /* synthetic */ void o0(QMUIBottomSheet qMUIBottomSheet, View view, int i6, String str) {
        qMUIBottomSheet.dismiss();
        if (str.equals("1")) {
            new Intent().putExtra("return-data", true);
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            Intent intent = new Intent("android.intent.action.PICK", uri);
            intent.setDataAndType(uri, "image/*");
            startActivityIfNeeded(intent, 1);
            return;
        }
        if (str.equals("2")) {
            if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == -1) {
                requestPermissions(new String[]{"android.permission.CAMERA"}, 306);
            } else {
                r0();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v15, types: [android.graphics.Bitmap] */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i6, int i7, Intent intent) throws Throwable {
        super.onActivityResult(i6, i7, intent);
        if (i7 != -1 || intent == null) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            if (i6 == 1) {
                Uri data = intent.getData();
                if (data != null) {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data);
                    this.f12910j = getExternalFilesDir(null).getPath() + "/images" + File.separator + System.currentTimeMillis() + ".jpg";
                    File file = new File(this.f12910j);
                    if (!file.exists()) {
                        file.getParentFile().mkdirs();
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 70, fileOutputStream2);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    D0(this.f12910j);
                    ((com.bumptech.glide.h) com.bumptech.glide.b.w(this).s(bitmap).d()).z0(this.f12904d);
                    return;
                }
                return;
            }
            if (i6 != 2) {
                return;
            }
            try {
                i6 = (Bitmap) intent.getExtras().get("data");
                try {
                    FileOutputStream fileOutputStream3 = new FileOutputStream(new File(this.f12910j));
                    try {
                        i6.compress(Bitmap.CompressFormat.JPEG, 70, fileOutputStream3);
                        fileOutputStream3.flush();
                        fileOutputStream3.close();
                    } catch (Exception unused) {
                        fileOutputStream = fileOutputStream3;
                        if (fileOutputStream != null) {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        }
                        ((com.bumptech.glide.h) com.bumptech.glide.b.w(this).s(i6).d()).z0(this.f12904d);
                        D0(this.f12910j);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream3;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused3) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception unused4) {
            }
            ((com.bumptech.glide.h) com.bumptech.glide.b.w(this).s(i6).d()).z0(this.f12904d);
            D0(this.f12910j);
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_account_setting);
        i0();
        com.uz.navee.utils.c.e(this, "", ContextCompat.getColor(this, R$color.clear));
        s0(99);
        this.f12906f.setText(e1.u().f13675c.getNickName());
        this.f12911k = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: h4.i
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.f13787a.n0((ActivityResult) obj);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i6, strArr, iArr);
        for (int i7 = 0; i7 < strArr.length; i7++) {
            int i8 = iArr[i7];
        }
        if (i6 == 306) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                J(getString(R$string.camera_no_auth1));
            } else {
                r0();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f12907g = Boolean.FALSE;
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        l0();
    }

    public final void p0(View view) {
        if (this.f12907g.booleanValue()) {
            return;
        }
        this.f12907g = Boolean.TRUE;
        boolean zO = com.uz.navee.utils.d.o();
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R$string.confirm));
        sb.append(zO ? "" : " ");
        sb.append(com.uz.navee.utils.d.a(getString(R$string.logout)));
        AlertPopup.P(this, getString(R$string.logout), sb.toString(), new e());
    }

    public final void q0() {
        HashMap map = new HashMap();
        String str = e4.a.a() + "/cancellation";
        this.f12908h.show();
        this.f12909i.g(str, map, new a());
    }

    public final void r0() {
        this.f12910j = getExternalFilesDir(null).getPath() + "/images" + File.separator + System.currentTimeMillis() + ".jpg";
        File file = new File(this.f12910j);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        startActivityIfNeeded(new Intent("android.media.action.IMAGE_CAPTURE"), 2);
    }

    public void s0(int i6) {
        try {
            ArrayList arrayList = new ArrayList();
            if (checkSelfPermission("android.permission.CAMERA") != 0) {
                arrayList.add("android.permission.CAMERA");
            }
            if (checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
                arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
            }
            if (checkSelfPermission("android.permission.INTERNET") != 0) {
                arrayList.add("android.permission.INTERNET");
            }
            if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
            }
            if (checkSelfPermission("android.permission.MOUNT_UNMOUNT_FILESYSTEMS") != 0) {
                arrayList.add("android.permission.MOUNT_UNMOUNT_FILESYSTEMS");
            }
            if (checkSelfPermission("android.permission.REQUEST_INSTALL_PACKAGES") != 0) {
                arrayList.add("android.permission.REQUEST_INSTALL_PACKAGES");
            }
            if (arrayList.size() >= 1) {
                int size = arrayList.size();
                String[] strArr = new String[size];
                for (int i7 = 0; i7 < size; i7++) {
                    strArr[i7] = (String) arrayList.get(i7);
                }
                requestPermissions(strArr, i6);
            }
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }

    public final void t0() {
        AlertPopup.P(this, getString(R$string.change_account), getString(R$string.change_account_message), new k());
    }

    public final void u0(boolean z6, CharSequence charSequence, boolean z7) {
        QMUIBottomSheet.e eVar = new QMUIBottomSheet.e(this);
        ((QMUIBottomSheet.e) ((QMUIBottomSheet.e) ((QMUIBottomSheet.e) ((QMUIBottomSheet.e) ((QMUIBottomSheet.e) eVar.q(z6).l(QMUISkinManager.e(this))).m(charSequence)).i(true)).k(getString(R$string.cancel))).j(z7)).r(false).s(new QMUIBottomSheet.e.c() { // from class: h4.j
            @Override // com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet.e.c
            public final void a(QMUIBottomSheet qMUIBottomSheet, View view, int i6, String str) {
                this.f13791a.o0(qMUIBottomSheet, view, i6, str);
            }
        });
        eVar.p(getString(R$string.select_from_album), "1");
        eVar.p(getString(R$string.take_picture), "2");
        eVar.a().show();
    }

    public final void v0(View view) {
        if (this.f12907g.booleanValue()) {
            return;
        }
        this.f12907g = Boolean.TRUE;
        t0();
    }

    public final void w0(View view) {
        if (this.f12907g.booleanValue()) {
            return;
        }
        this.f12907g = Boolean.TRUE;
        Intent intent = new Intent(this, (Class<?>) ChangeEmailActivity.class);
        Bundle bundle = new Bundle();
        String email = e1.u().f13675c.getEmail();
        if (email == null || email.isEmpty()) {
            bundle.putInt("step", ChangeEmailActivity.ChangeEmailStep.addEmail.ordinal());
        } else {
            bundle.putInt("step", ChangeEmailActivity.ChangeEmailStep.oldEmail.ordinal());
        }
        intent.putExtra("data", bundle);
        startActivity(intent);
    }

    public final void x0(View view) {
        if (this.f12907g.booleanValue()) {
            return;
        }
        this.f12907g = Boolean.TRUE;
        startActivity(new Intent(this, (Class<?>) ChangePwdActivity.class));
    }

    public final void y0(View view) {
        if (this.f12907g.booleanValue()) {
            return;
        }
        this.f12907g = Boolean.TRUE;
        startActivity(new Intent(this, (Class<?>) DataDownloadActivity.class));
    }

    public final void z0(View view) {
        if (this.f12907g.booleanValue()) {
            return;
        }
        this.f12907g = Boolean.TRUE;
        AlertPopup.P(this, getString(R$string.delete_account), getString(R$string.delete_account_message), new f());
    }
}
