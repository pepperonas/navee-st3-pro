package com.uz.navee.ui.device;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.bean.ProductInfo;
import com.youth.banner.Banner;
import com.youth.banner.indicator.RectangleIndicator;
import d4.d;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class DeviceBeforeFragment extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public Banner f11972a;

    /* renamed from: b, reason: collision with root package name */
    public View f11973b;

    public class a implements d.h {

        /* renamed from: com.uz.navee.ui.device.DeviceBeforeFragment$a$a, reason: collision with other inner class name */
        public class C0163a extends TypeToken<HttpResponse<ArrayList<ProductInfo>>> {
            public C0163a() {
            }
        }

        public a() {
        }

        @Override // d4.d.h
        public void a(String str) {
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new C0163a().getType());
            if (httpResponse == null || httpResponse.getCode() != 200) {
                return;
            }
            DeviceBeforeFragment.this.f11972a.setAdapter(new ProductCarouselAdapter((ArrayList) httpResponse.getData()));
        }

        @Override // d4.d.h
        public void b(Exception exc) {
        }
    }

    public final void d() {
        d4.d.h().f(e4.a.a() + "/getIndexRecommend", new a());
    }

    public final void e(View view) {
        startActivity(new Intent(getActivity(), (Class<?>) DeviceBindActivity.class));
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.f11973b;
        if (view == null) {
            View viewInflate = layoutInflater.inflate(R$layout.fragment_device_before, viewGroup, false);
            this.f11973b = viewInflate;
            ((Button) viewInflate.findViewById(R$id.button_bind)).setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.u2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f12666a.e(view2);
                }
            });
            Banner banner = (Banner) this.f11973b.findViewById(R$id.banner);
            this.f11972a = banner;
            banner.addBannerLifecycleObserver(this).setIndicator(new RectangleIndicator(getContext()));
        } else {
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.f11973b);
            }
        }
        d();
        return this.f11973b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(new Intent("BleDeviceBeforeNotification"));
    }
}
