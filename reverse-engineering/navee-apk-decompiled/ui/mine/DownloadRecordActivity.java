package com.uz.navee.ui.mine;

import android.os.Bundle;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseListActivity;
import com.uz.navee.base.RecyclerViewHolder;
import com.uz.navee.base.h;
import com.uz.navee.databinding.ActivityDownloadRecordBinding;
import com.uz.navee.ui.mine.DownloadRecordActivity;
import com.uz.navee.ui.wheel.DataStatusView;
import com.uz.navee.utils.c;
import com.uz.navee.utils.l;
import d4.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.i0;
import kotlin.collections.u;
import kotlin.jvm.internal.y;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v5.g;
import v5.m;

/* loaded from: classes3.dex */
public final class DownloadRecordActivity extends BaseListActivity<String> {

    /* renamed from: h, reason: collision with root package name */
    public ActivityDownloadRecordBinding f13015h;

    /* renamed from: i, reason: collision with root package name */
    public final List f13016i = new ArrayList();

    public static final class a implements d.h {
        public a() {
        }

        @Override // d4.d.h
        public void a(String str) throws JSONException {
            ArrayList arrayList;
            ActivityDownloadRecordBinding activityDownloadRecordBinding = null;
            if (str != null) {
                try {
                    JSONArray jSONArray = new JSONObject(str).getJSONArray("data");
                    g gVarL = m.l(0, jSONArray.length());
                    arrayList = new ArrayList(u.u(gVarL, 10));
                    Iterator it = gVarL.iterator();
                    while (it.hasNext()) {
                        String string = jSONArray.getString(((i0) it).nextInt());
                        if (string == null) {
                            string = "";
                        } else {
                            y.c(string);
                        }
                        arrayList.add(string);
                    }
                } catch (Exception unused) {
                }
            } else {
                arrayList = null;
            }
            if (arrayList == null) {
                ActivityDownloadRecordBinding activityDownloadRecordBinding2 = DownloadRecordActivity.this.f13015h;
                if (activityDownloadRecordBinding2 == null) {
                    y.x("binding");
                } else {
                    activityDownloadRecordBinding = activityDownloadRecordBinding2;
                }
                activityDownloadRecordBinding.statusView.setStatus(DataStatusView.DataStatus.failure);
                return;
            }
            ActivityDownloadRecordBinding activityDownloadRecordBinding3 = DownloadRecordActivity.this.f13015h;
            if (activityDownloadRecordBinding3 == null) {
                y.x("binding");
            } else {
                activityDownloadRecordBinding = activityDownloadRecordBinding3;
            }
            activityDownloadRecordBinding.statusView.setStatus(DataStatusView.DataStatus.success);
            DownloadRecordActivity.this.f11599c.j(arrayList);
        }

        @Override // d4.d.h
        public void b(Exception e7) {
            y.f(e7, "e");
            ActivityDownloadRecordBinding activityDownloadRecordBinding = DownloadRecordActivity.this.f13015h;
            if (activityDownloadRecordBinding == null) {
                y.x("binding");
                activityDownloadRecordBinding = null;
            }
            activityDownloadRecordBinding.statusView.setStatus(DataStatusView.DataStatus.failure);
        }
    }

    public static final class b implements h {
        public b() {
        }

        @Override // com.uz.navee.base.h
        public int a(int i6) {
            return R$layout.item_download_record;
        }

        @Override // com.uz.navee.base.h
        public void b() {
        }

        @Override // com.uz.navee.base.h
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void c(RecyclerViewHolder holder, int i6, String item) {
            y.f(holder, "holder");
            y.f(item, "item");
            holder.c(R$id.tv_name).setText(DownloadRecordActivity.this.getString(R$string.app_name));
            holder.c(R$id.tv_time).setText(l.b(l.g(item, "yyyy-MM-dd HH:mm:ss", "UTC").getTime(), "yyyy-MM-dd HH:mm:ss"));
        }

        @Override // com.uz.navee.base.h
        public /* synthetic */ int getItemViewType(int i6) {
            return com.uz.navee.base.g.a(this, i6);
        }
    }

    public static final void V(DownloadRecordActivity this$0, View view) {
        y.f(this$0, "this$0");
        this$0.U();
    }

    public final void U() {
        String str = e4.a.a() + "/user/download/record";
        ActivityDownloadRecordBinding activityDownloadRecordBinding = this.f13015h;
        if (activityDownloadRecordBinding == null) {
            y.x("binding");
            activityDownloadRecordBinding = null;
        }
        activityDownloadRecordBinding.statusView.setStatus(DataStatusView.DataStatus.loading);
        d.h().g(str, null, new a());
    }

    @Override // com.uz.navee.base.BaseListActivity, com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R$layout.activity_download_record);
        y.e(contentView, "setContentView(...)");
        this.f13015h = (ActivityDownloadRecordBinding) contentView;
        String string = getString(R$string.download_history);
        y.e(string, "getString(...)");
        c.e(this, string, ContextCompat.getColor(this, R$color.nav_title_color));
        Q(new b());
        ActivityDownloadRecordBinding activityDownloadRecordBinding = this.f13015h;
        if (activityDownloadRecordBinding == null) {
            y.x("binding");
            activityDownloadRecordBinding = null;
        }
        activityDownloadRecordBinding.statusView.setActionButtonClickListener(new View.OnClickListener() { // from class: h4.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadRecordActivity.V(this.f13810a, view);
            }
        });
        U();
    }
}
