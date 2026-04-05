package com.uz.navee.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.GsonBuilder;
import com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.base.RecyclerAdapter;
import com.uz.navee.base.RecyclerViewHolder;
import com.uz.navee.ui.mine.bean.MyFeedbackListBean;
import com.uz.navee.ui.mine.bean.Myfeedback;
import d4.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class MyFeedbackListActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public QMUIPullLayout f13054c;

    /* renamed from: d, reason: collision with root package name */
    public RecyclerView f13055d;

    /* renamed from: e, reason: collision with root package name */
    public RecyclerAdapter f13056e;

    /* renamed from: g, reason: collision with root package name */
    public d f13058g;

    /* renamed from: f, reason: collision with root package name */
    public List f13057f = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public boolean f13059h = false;

    /* renamed from: i, reason: collision with root package name */
    public int f13060i = 1;

    /* renamed from: j, reason: collision with root package name */
    public Boolean f13061j = Boolean.FALSE;

    public class a extends LinearLayoutManager {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public RecyclerView.LayoutParams generateDefaultLayoutParams() {
            return new RecyclerView.LayoutParams(-1, -2);
        }
    }

    public class b extends RecyclerAdapter {
        public b(Context context, List list) {
            super(context, list);
        }

        @Override // com.uz.navee.base.RecyclerAdapter
        public int e(int i6) {
            return R$layout.feedback_list_item;
        }

        @Override // com.uz.navee.base.RecyclerAdapter
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void c(RecyclerViewHolder recyclerViewHolder, int i6, Myfeedback myfeedback) {
            recyclerViewHolder.d(R$id.text1, myfeedback.getTitle());
            recyclerViewHolder.d(R$id.tv_gaojing_msg, myfeedback.getCreateDate());
            recyclerViewHolder.getView(R$id.icoUnread).setVisibility(myfeedback.unread() ? 0 : 4);
        }
    }

    public class c implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13064a;

        public c(int i6) {
            this.f13064a = i6;
        }

        @Override // d4.d.h
        public void a(String str) {
            MyFeedbackListActivity.this.B();
            MyFeedbackListBean myFeedbackListBean = (MyFeedbackListBean) new GsonBuilder().create().fromJson(str, MyFeedbackListBean.class);
            if (myFeedbackListBean == null || myFeedbackListBean.getCode() != 200) {
                return;
            }
            int size = myFeedbackListBean.getData().getRows().size();
            int total = myFeedbackListBean.getData().getTotal();
            if (size > 0) {
                for (int i6 = 0; i6 < size; i6++) {
                    MyFeedbackListActivity.this.f13057f.add(myFeedbackListBean.getData().getRows().get(i6));
                }
                if (this.f13064a == 1) {
                    MyFeedbackListActivity myFeedbackListActivity = MyFeedbackListActivity.this;
                    myFeedbackListActivity.f13056e.j(myFeedbackListActivity.f13057f);
                } else {
                    MyFeedbackListActivity myFeedbackListActivity2 = MyFeedbackListActivity.this;
                    myFeedbackListActivity2.f13056e.b(myFeedbackListActivity2.f13057f);
                }
                if (MyFeedbackListActivity.this.f13056e.getItemCount() < total) {
                    MyFeedbackListActivity.this.f13059h = true;
                } else {
                    MyFeedbackListActivity.this.f13059h = false;
                }
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            MyFeedbackListActivity.this.B();
            Toast.makeText(MyFeedbackListActivity.this, exc.getMessage(), 0).show();
        }
    }

    private void V() {
        this.f13054c = (QMUIPullLayout) findViewById(R$id.pull_layout);
        this.f13055d = (RecyclerView) findViewById(R$id.recyclerView);
    }

    private void initView() {
        this.f13058g = d.h();
        this.f13054c.setActionListener(new QMUIPullLayout.b() { // from class: h4.l1
            @Override // com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout.b
            public final void a(QMUIPullLayout.g gVar) {
                this.f13801a.a0(gVar);
            }
        });
        this.f13055d.setLayoutManager(new a(this));
        b bVar = new b(this, null);
        this.f13056e = bVar;
        bVar.setOnItemClickListener(new RecyclerAdapter.a() { // from class: h4.m1
            @Override // com.uz.navee.base.RecyclerAdapter.a
            public final void a(View view, int i6) {
                this.f13804a.b0(view, i6);
            }
        });
        this.f13055d.setAdapter(this.f13056e);
        Y(1);
    }

    public void Y(int i6) {
        K();
        this.f13058g.f(e4.a.a() + "/myOpinion?pageNo=" + i6, new c(i6));
    }

    public final /* synthetic */ void Z(QMUIPullLayout.g gVar) {
        if (gVar.n() == 2) {
            d0();
        } else if (gVar.n() == 8 && this.f13059h) {
            c0();
        }
        this.f13054c.n(gVar);
    }

    public final /* synthetic */ void a0(final QMUIPullLayout.g gVar) {
        this.f13054c.postDelayed(new Runnable() { // from class: h4.n1
            @Override // java.lang.Runnable
            public final void run() {
                this.f13807a.Z(gVar);
            }
        }, 1000L);
    }

    public final /* synthetic */ void b0(View view, int i6) {
        if (this.f13061j.booleanValue()) {
            return;
        }
        this.f13061j = Boolean.TRUE;
        view.findViewById(R$id.icoUnread).setVisibility(4);
        Intent intent = new Intent(this, (Class<?>) FeedbackDetailActivity.class);
        intent.putExtra("feedback", (Serializable) this.f13056e.d().get(i6));
        startActivity(intent);
    }

    public final void c0() {
        int i6 = this.f13060i + 1;
        this.f13060i = i6;
        Y(i6);
    }

    public final void d0() {
        this.f13057f.clear();
        this.f13056e.notifyDataSetChanged();
        Y(1);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_myfeedback_list);
        V();
        com.uz.navee.utils.c.e(this, getString(R$string.my_feedback), ContextCompat.getColor(this, R$color.nav_title_color));
        initView();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f13061j = Boolean.FALSE;
    }
}
