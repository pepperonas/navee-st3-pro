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
import com.uz.navee.base.RecyclerViewHolder;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.ui.mine.adapter.QuestionAdapter;
import com.uz.navee.ui.mine.bean.QuestionBean;
import com.uz.navee.ui.mine.bean.QuestionListBean;
import com.uz.navee.utils.j0;
import d4.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class QuestionListActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public QMUIPullLayout f13079c;

    /* renamed from: d, reason: collision with root package name */
    public RecyclerView f13080d;

    /* renamed from: e, reason: collision with root package name */
    public QuestionAdapter f13081e;

    /* renamed from: g, reason: collision with root package name */
    public d4.d f13083g;

    /* renamed from: k, reason: collision with root package name */
    public Vehicle f13087k;

    /* renamed from: f, reason: collision with root package name */
    public List f13082f = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public boolean f13084h = false;

    /* renamed from: i, reason: collision with root package name */
    public int f13085i = 1;

    /* renamed from: j, reason: collision with root package name */
    public Boolean f13086j = Boolean.FALSE;

    /* renamed from: l, reason: collision with root package name */
    public int f13088l = 0;

    public class a implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13089a;

        /* renamed from: com.uz.navee.ui.mine.QuestionListActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0184a implements Runnable {
            public RunnableC0184a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (QuestionListActivity.this.f13088l < 0 || QuestionListActivity.this.f13088l >= QuestionListActivity.this.f13082f.size()) {
                    QuestionListActivity.this.f13080d.scrollToPosition(r0.f13082f.size() - 1);
                } else {
                    QuestionListActivity questionListActivity = QuestionListActivity.this;
                    questionListActivity.f13080d.scrollToPosition(questionListActivity.f13088l);
                }
            }
        }

        public a(int i6) {
            this.f13089a = i6;
        }

        @Override // d4.d.h
        public void a(String str) {
            QuestionListActivity.this.B();
            QuestionListBean questionListBean = (QuestionListBean) new GsonBuilder().create().fromJson(str, QuestionListBean.class);
            if (questionListBean == null || questionListBean.getCode() != 200) {
                return;
            }
            for (int i6 = 0; i6 < questionListBean.getData().size(); i6++) {
                QuestionListActivity.this.f13082f.add(questionListBean.getData().get(i6));
            }
            if (this.f13089a == 1) {
                QuestionListActivity questionListActivity = QuestionListActivity.this;
                questionListActivity.f13081e.h(questionListActivity.f13082f);
            } else {
                QuestionListActivity questionListActivity2 = QuestionListActivity.this;
                questionListActivity2.f13081e.b(questionListActivity2.f13082f);
            }
            if (questionListBean.getData().size() == 10) {
                QuestionListActivity.this.f13084h = true;
            }
            QuestionListActivity.this.f13080d.post(new RunnableC0184a());
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            QuestionListActivity.this.B();
            Toast.makeText(QuestionListActivity.this, exc.getMessage(), 0).show();
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ QMUIPullLayout.g f13092a;

        public b(QMUIPullLayout.g gVar) {
            this.f13092a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f13092a.n() == 2) {
                QuestionListActivity.this.e0();
            } else if (this.f13092a.n() == 8 && QuestionListActivity.this.f13084h) {
                QuestionListActivity.this.d0();
            }
            QuestionListActivity.this.f13079c.n(this.f13092a);
        }
    }

    public class c extends LinearLayoutManager {
        public c(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public RecyclerView.LayoutParams generateDefaultLayoutParams() {
            return new RecyclerView.LayoutParams(-1, -2);
        }
    }

    public class d extends QuestionAdapter {
        public d(Context context, List list) {
            super(context, list);
        }

        @Override // com.uz.navee.ui.mine.adapter.QuestionAdapter
        public int e(int i6) {
            return R$layout.list_view_item_question;
        }

        @Override // com.uz.navee.ui.mine.adapter.QuestionAdapter
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void c(RecyclerViewHolder recyclerViewHolder, int i6, QuestionBean questionBean) {
            if (com.uz.navee.utils.d.p(QuestionListActivity.this)) {
                recyclerViewHolder.d(R$id.text1, "Q: \u202b" + questionBean.getIssue() + "\u202c");
            } else {
                recyclerViewHolder.d(R$id.text1, "Q: " + questionBean.getIssue());
            }
            recyclerViewHolder.d(R$id.tv_msg, j0.a(questionBean.getReply()));
        }
    }

    private void X() {
        this.f13079c = (QMUIPullLayout) findViewById(R$id.pull_layout);
        this.f13080d = (RecyclerView) findViewById(R$id.recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(QMUIPullLayout.g gVar) {
        this.f13079c.postDelayed(new b(gVar), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        int i6 = this.f13085i + 1;
        this.f13085i = i6;
        a0(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        this.f13082f.clear();
        this.f13081e.notifyDataSetChanged();
        a0(1);
        this.f13080d.scrollToPosition(0);
    }

    public void a0(int i6) {
        if (this.f13087k == null) {
            return;
        }
        K();
        this.f13083g.f(e4.a.a() + "/getIssue?category=" + this.f13087k.model.category, new a(i6));
    }

    public final /* synthetic */ void c0(View view, int i6) {
        if (this.f13086j.booleanValue()) {
            return;
        }
        this.f13086j = Boolean.TRUE;
        Intent intent = new Intent(this, (Class<?>) QuestionDetailActivity.class);
        intent.putExtra("title", ((QuestionBean) this.f13081e.d().get(i6)).getTitle());
        intent.putExtra("issue", ((QuestionBean) this.f13081e.d().get(i6)).getIssue());
        intent.putExtra("reply", ((QuestionBean) this.f13081e.d().get(i6)).getReply());
        intent.putExtra("language", ((QuestionBean) this.f13081e.d().get(i6)).getLanguage());
        startActivity(intent);
    }

    public void initView() {
        this.f13083g = d4.d.h();
        this.f13079c.setActionListener(new QMUIPullLayout.b() { // from class: h4.o1
            @Override // com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout.b
            public final void a(QMUIPullLayout.g gVar) {
                this.f13811a.b0(gVar);
            }
        });
        this.f13080d.setLayoutManager(new c(this));
        d dVar = new d(this, null);
        this.f13081e = dVar;
        dVar.setOnItemClickListener(new QuestionAdapter.b() { // from class: h4.p1
            @Override // com.uz.navee.ui.mine.adapter.QuestionAdapter.b
            public final void a(View view, int i6) {
                this.f13813a.c0(view, i6);
            }
        });
        this.f13080d.setAdapter(this.f13081e);
        a0(1);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_question_list);
        X();
        com.uz.navee.utils.c.e(this, getString(R$string.faq), ContextCompat.getColor(this, R$color.nav_title_color));
        this.f13088l = getIntent().getIntExtra("position", 0);
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        if (bundleExtra != null) {
            this.f13087k = (Vehicle) bundleExtra.getSerializable("vehicle");
        }
        initView();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f13086j = Boolean.FALSE;
    }
}
