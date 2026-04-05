package com.uz.navee.ui.mine;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.bean.AreaRes;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.ui.mine.RegionSettingActivity;
import com.uz.navee.ui.wheel.AlertPopup;
import com.uz.navee.utils.DensityUtil;
import com.uz.navee.utils.q;
import com.uz.navee.utils.y;
import d4.d;
import g4.e1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class RegionSettingActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public SearchView f13096c;

    /* renamed from: d, reason: collision with root package name */
    public QMUIGroupListView f13097d;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f13100g;

    /* renamed from: h, reason: collision with root package name */
    public int f13101h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f13103j;

    /* renamed from: k, reason: collision with root package name */
    public String f13104k;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f13098e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f13099f = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f13102i = new ArrayList();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class b implements SearchView.OnQueryTextListener {
        public b() {
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            RegionSettingActivity.this.l0(str);
            return false;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            RegionSettingActivity.this.f13096c.clearFocus();
            return false;
        }
    }

    public class c implements SearchView.OnCloseListener {
        public c() {
        }

        @Override // android.widget.SearchView.OnCloseListener
        public boolean onClose() {
            return false;
        }
    }

    public class d implements AlertPopup.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AreaRes f13108a;

        public d(AreaRes areaRes) {
            this.f13108a = areaRes;
        }

        @Override // com.uz.navee.ui.wheel.AlertPopup.a
        public void a() {
            RegionSettingActivity.this.m0(this.f13108a);
        }

        @Override // com.uz.navee.ui.wheel.AlertPopup.a
        public void b() {
        }
    }

    public class e implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13110a;

        public class a extends TypeToken<HttpResponse<ArrayList<AreaRes>>> {
            public a() {
            }
        }

        public e(String str) {
            this.f13110a = str;
        }

        @Override // d4.d.h
        public void a(String str) {
            RegionSettingActivity.this.B();
            System.out.println(this.f13110a + "网络请求==" + str);
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse == null || httpResponse.getCode() != 200 || httpResponse.getData() == null) {
                if (httpResponse != null) {
                    Toast.makeText(RegionSettingActivity.this, httpResponse.getMsg(), 0).show();
                }
            } else {
                RegionSettingActivity.this.f13100g = (ArrayList) httpResponse.getData();
                RegionSettingActivity.this.e0();
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            RegionSettingActivity.this.B();
            Toast.makeText(RegionSettingActivity.this, exc.getMessage(), 0).show();
        }
    }

    private void a0() {
        this.f13096c = (SearchView) findViewById(R$id.searchView);
        this.f13097d = (QMUIGroupListView) findViewById(R$id.groupListView);
    }

    public static /* synthetic */ int g0(AreaRes areaRes, AreaRes areaRes2) {
        if (areaRes == null || areaRes2 == null) {
            return 0;
        }
        return areaRes.getAreaSort() - areaRes2.getAreaSort();
    }

    public final void d0(AreaRes areaRes) {
        AlertPopup.Q(this, getString(R$string.area_alert_title), getString(R$string.area_alert_msg), null, getString(R$string.i_see), new d(areaRes));
    }

    public final void e0() {
        this.f13098e.clear();
        ArrayList arrayList = this.f13100g;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Collections.sort(this.f13100g, new Comparator() { // from class: h4.q1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return RegionSettingActivity.g0((AreaRes) obj, (AreaRes) obj2);
            }
        });
        int iA = DensityUtil.a(this, 16.0f);
        AreaRes areaResB = y.b();
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, R$mipmap.ic_check));
        String strD = y.d();
        QMUIGroupListView.a aVarE = QMUIGroupListView.e(this);
        QMUICommonListItemView qMUICommonListItemView = null;
        QMUICommonListItemView qMUICommonListItemView2 = null;
        QMUICommonListItemView qMUICommonListItemView3 = null;
        QMUICommonListItemView qMUICommonListItemView4 = null;
        QMUICommonListItemView qMUICommonListItemView5 = null;
        for (int i6 = 0; i6 < this.f13100g.size(); i6++) {
            final AreaRes areaRes = (AreaRes) this.f13100g.get(i6);
            if (areaRes != null) {
                QMUICommonListItemView qMUICommonListItemViewC = this.f13097d.c(null, areaRes.getAreaName(), null, 1, 0);
                if (i6 == 0) {
                    qMUICommonListItemViewC.e(iA, 3);
                }
                if (i6 == this.f13100g.size() - 1) {
                    qMUICommonListItemViewC.e(iA, 1);
                }
                if (qMUICommonListItemView5 == null) {
                    qMUICommonListItemView5 = qMUICommonListItemViewC;
                }
                if (this.f13103j && TextUtils.equals(this.f13104k, areaRes.getAreaKey())) {
                    qMUICommonListItemView = qMUICommonListItemViewC;
                }
                if (qMUICommonListItemView == null && areaResB != null && areaResB.getAreaKey() != null && areaResB.getAreaKey().equalsIgnoreCase(areaRes.getAreaKey())) {
                    qMUICommonListItemView = qMUICommonListItemViewC;
                }
                if (areaRes.isMatch(strD)) {
                    qMUICommonListItemView4 = qMUICommonListItemViewC;
                }
                if (areaRes.isBestArea() && qMUICommonListItemView2 == null) {
                    qMUICommonListItemView2 = qMUICommonListItemViewC;
                }
                if (areaRes.isDefaultFlag() && qMUICommonListItemView3 == null) {
                    qMUICommonListItemView3 = qMUICommonListItemViewC;
                }
                qMUICommonListItemViewC.setAccessoryType(0);
                this.f13098e.add(qMUICommonListItemViewC);
                aVarE.c(qMUICommonListItemViewC, new View.OnClickListener() { // from class: h4.r1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f13816a.h0(areaRes, view);
                    }
                });
            }
        }
        if (qMUICommonListItemView == null) {
            qMUICommonListItemView = qMUICommonListItemView2 != null ? qMUICommonListItemView2 : qMUICommonListItemView3 != null ? qMUICommonListItemView3 : qMUICommonListItemView4 != null ? qMUICommonListItemView4 : qMUICommonListItemView5;
        }
        if (qMUICommonListItemView != null) {
            qMUICommonListItemView.setAccessoryType(3);
            qMUICommonListItemView.l(imageView);
            this.f13101h = this.f13098e.indexOf(qMUICommonListItemView);
        }
        aVarE.g(iA, iA).e(this.f13097d);
    }

    public final void f0() {
        K();
        String str = e4.a.a() + "/area?area=" + y.a();
        d4.d.h().f(str, new e(str));
    }

    public final /* synthetic */ void h0(AreaRes areaRes, View view) {
        d0(areaRes);
    }

    public final /* synthetic */ void i0(AreaRes areaRes, View view) {
        d0(areaRes);
    }

    public final /* synthetic */ void j0(AreaRes areaRes) {
        Iterator it = this.f13099f.iterator();
        while (it.hasNext()) {
            QMUICommonListItemView qMUICommonListItemView = (QMUICommonListItemView) it.next();
            CharSequence text = qMUICommonListItemView.getText();
            if (text == null || !text.toString().equals(areaRes.getAreaName())) {
                qMUICommonListItemView.setAccessoryType(0);
            } else {
                qMUICommonListItemView.setAccessoryType(3);
                ImageView imageView = new ImageView(this);
                imageView.setImageDrawable(ContextCompat.getDrawable(this, R$mipmap.ic_check));
                qMUICommonListItemView.l(imageView);
                this.f13101h = this.f13100g.indexOf(areaRes);
            }
        }
    }

    public final /* synthetic */ void k0(AreaRes areaRes) {
        Iterator it = this.f13098e.iterator();
        while (it.hasNext()) {
            QMUICommonListItemView qMUICommonListItemView = (QMUICommonListItemView) it.next();
            CharSequence text = qMUICommonListItemView.getText();
            if (text == null || !text.toString().equals(areaRes.getAreaName())) {
                qMUICommonListItemView.setAccessoryType(0);
            } else {
                qMUICommonListItemView.setAccessoryType(3);
                ImageView imageView = new ImageView(this);
                imageView.setImageDrawable(ContextCompat.getDrawable(this, R$mipmap.ic_check));
                qMUICommonListItemView.l(imageView);
                this.f13101h = this.f13098e.indexOf(qMUICommonListItemView);
            }
        }
    }

    public final void l0(String str) {
        if (this.f13100g == null) {
            return;
        }
        this.f13097d.removeAllViews();
        if (str.isEmpty()) {
            this.f13096c.clearFocus();
            e0();
            return;
        }
        this.f13102i.clear();
        this.f13099f.clear();
        Iterator it = this.f13100g.iterator();
        while (it.hasNext()) {
            AreaRes areaRes = (AreaRes) it.next();
            if (areaRes.getAreaName().toLowerCase().contains(str.toLowerCase())) {
                this.f13102i.add(areaRes);
            }
        }
        AreaRes areaRes2 = (AreaRes) this.f13100g.get(this.f13101h);
        int iA = DensityUtil.a(this, 16.0f);
        QMUIGroupListView.a aVarE = QMUIGroupListView.e(this);
        for (int i6 = 0; i6 < this.f13102i.size(); i6++) {
            final AreaRes areaRes3 = (AreaRes) this.f13102i.get(i6);
            QMUICommonListItemView qMUICommonListItemViewC = this.f13097d.c(null, areaRes3.getAreaName(), null, 1, 0);
            if (i6 == 0) {
                qMUICommonListItemViewC.e(iA, 3);
            }
            if (i6 == this.f13102i.size() - 1) {
                qMUICommonListItemViewC.e(iA, 1);
            }
            if (areaRes3.getAreaName().equals(areaRes2.getAreaName())) {
                qMUICommonListItemViewC.setAccessoryType(3);
                ImageView imageView = new ImageView(this);
                imageView.setImageDrawable(ContextCompat.getDrawable(this, R$mipmap.ic_check));
                qMUICommonListItemViewC.l(imageView);
            } else {
                qMUICommonListItemViewC.setAccessoryType(0);
            }
            this.f13099f.add(qMUICommonListItemViewC);
            aVarE.c(qMUICommonListItemViewC, new View.OnClickListener() { // from class: h4.s1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f13819a.i0(areaRes3, view);
                }
            });
        }
        aVarE.g(iA, iA).e(this.f13097d);
    }

    public final void m0(final AreaRes areaRes) {
        if (areaRes == null) {
            return;
        }
        if (this.f13103j) {
            Intent intent = new Intent();
            intent.putExtra("areaCode", areaRes.getAreaKey());
            intent.putExtra("areaName", areaRes.getAreaName());
            setResult(-1, intent);
            finish();
            return;
        }
        y.e(areaRes);
        if (this.f13096c.getQuery().length() > 0) {
            runOnUiThread(new Runnable() { // from class: h4.t1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13823a.j0(areaRes);
                }
            });
        } else {
            runOnUiThread(new Runnable() { // from class: h4.u1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13827a.k0(areaRes);
                }
            });
        }
        if (e1.j().booleanValue()) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("BleDeviceChangedNotification"));
        }
    }

    public final void n0() {
        TextView textView = (TextView) this.f13096c.findViewById(this.f13096c.getContext().getResources().getIdentifier("android:id/search_src_text", null, null));
        if (textView != null) {
            textView.setTextSize(2, 12.0f);
            textView.setTextColor(ContextCompat.getColor(this, R$color.white));
            textView.setHintTextColor(ContextCompat.getColor(this, R$color.xFAF4E8_30));
        }
        this.f13096c.setOnSearchClickListener(new a());
        this.f13096c.setOnQueryTextListener(new b());
        this.f13096c.setOnCloseListener(new c());
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_region_setting);
        a0();
        com.uz.navee.utils.c.e(this, getString(R$string.switch_region), ContextCompat.getColor(this, R$color.nav_title_color));
        n0();
        String stringExtra = getIntent().getStringExtra("areaList");
        if (stringExtra != null) {
            this.f13100g = (ArrayList) q.c(stringExtra, AreaRes.class);
        }
        this.f13103j = getIntent().getBooleanExtra("selectable", false);
        this.f13104k = getIntent().getStringExtra("selectedCode");
        ArrayList arrayList = this.f13100g;
        if (arrayList == null || arrayList.isEmpty()) {
            f0();
        } else {
            e0();
        }
    }
}
