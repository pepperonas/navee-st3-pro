package com.uz.navee.ui.mine;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseListActivity;
import com.uz.navee.base.RecyclerViewHolder;
import com.uz.navee.base.g;
import com.uz.navee.base.h;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.bean.SoldVideo;
import com.uz.navee.ui.device.ExoPlayerPopup;
import com.uz.navee.ui.mine.SoldVideosActivity;
import com.uz.navee.utils.c;
import d4.d;
import e3.a;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class SoldVideosActivity extends BaseListActivity<SoldVideo> {

    public class a implements h {

        /* renamed from: com.uz.navee.ui.mine.SoldVideosActivity$a$a, reason: collision with other inner class name */
        public class C0185a implements d.h {

            /* renamed from: com.uz.navee.ui.mine.SoldVideosActivity$a$a$a, reason: collision with other inner class name */
            public class C0186a extends TypeToken<HttpResponse<ArrayList<SoldVideo>>> {
                public C0186a() {
                }
            }

            public C0185a() {
            }

            @Override // d4.d.h
            public void a(String str) {
                HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new C0186a().getType());
                if (httpResponse == null || httpResponse.getCode() != 200) {
                    return;
                }
                SoldVideosActivity.this.f11599c.j((ArrayList) httpResponse.getData());
            }

            @Override // d4.d.h
            public void b(Exception exc) {
                SoldVideosActivity.this.B();
                Toast.makeText(SoldVideosActivity.this, exc.getMessage(), 0).show();
            }
        }

        public a() {
        }

        @Override // com.uz.navee.base.h
        public int a(int i6) {
            return R$layout.cell_video_sold;
        }

        @Override // com.uz.navee.base.h
        public void b() {
            SoldVideosActivity.this.K();
            d.h().g(e4.a.a() + "/vehicle/modelVideo", new HashMap(), new C0185a());
        }

        @Override // com.uz.navee.base.h
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(RecyclerViewHolder recyclerViewHolder, int i6, final SoldVideo soldVideo) {
            TextView textViewC = recyclerViewHolder.c(R$id.titleLabel);
            final String name = soldVideo.getName() != null ? soldVideo.getName() : SoldVideosActivity.this.getString(R$string.sold_video);
            textViewC.setText(name);
            recyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: h4.e2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f13773a.f(soldVideo, name, view);
                }
            });
        }

        public final /* synthetic */ void f(SoldVideo soldVideo, String str, View view) {
            String video = soldVideo.getVideo();
            if (video == null || video.isEmpty()) {
                return;
            }
            new a.C0192a(SoldVideosActivity.this).f(false).g(Boolean.TRUE).e(Boolean.FALSE).a(new ExoPlayerPopup(SoldVideosActivity.this, video, str, ExoPlayerPopup.VideoType.soldSupport)).G();
        }

        @Override // com.uz.navee.base.h
        public /* synthetic */ int getItemViewType(int i6) {
            return g.a(this, i6);
        }
    }

    public static /* synthetic */ WindowInsetsCompat V(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        return windowInsetsCompat;
    }

    @Override // com.uz.navee.base.BaseListActivity, com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EdgeToEdge.enable(this);
        setContentView(R$layout.activity_sold_videos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R$id.main), new OnApplyWindowInsetsListener() { // from class: h4.d2
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return SoldVideosActivity.V(view, windowInsetsCompat);
            }
        });
        if (Build.VERSION.SDK_INT >= 29) {
            getWindow().setNavigationBarContrastEnforced(false);
        }
        c.e(this, getString(R$string.sold_video), ContextCompat.getColor(this, R$color.nav_title_color));
        Q(new a());
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f11600d.b();
    }

    @Override // com.uz.navee.base.BaseActivity
    public boolean x() {
        return false;
    }

    @Override // com.uz.navee.base.BaseActivity
    public boolean y() {
        return false;
    }
}
