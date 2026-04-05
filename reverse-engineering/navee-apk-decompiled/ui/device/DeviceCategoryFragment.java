package com.uz.navee.ui.device;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.uz.navee.MyApplication;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.bean.Vehicle;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class DeviceCategoryFragment extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public View f12017a;

    /* renamed from: b, reason: collision with root package name */
    public String f12018b;

    /* renamed from: c, reason: collision with root package name */
    public String f12019c;

    /* renamed from: d, reason: collision with root package name */
    public TabLayout f12020d;

    /* renamed from: e, reason: collision with root package name */
    public ViewPager2 f12021e;

    /* renamed from: f, reason: collision with root package name */
    public DeviceGridsAdapter f12022f;

    public class a extends ViewPager2.OnPageChangeCallback {
        public a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i6) {
            super.onPageScrollStateChanged(i6);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i6) {
            super.onPageSelected(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        startActivity(new Intent(getActivity(), (Class<?>) DeviceBindActivity.class));
    }

    public static /* synthetic */ void i(String[] strArr, TabLayout.Tab tab, int i6) {
        tab.setText(strArr[i6]);
    }

    public final /* synthetic */ void j(PopupWindow popupWindow, View view) {
        o(0, popupWindow);
    }

    public final /* synthetic */ void k(PopupWindow popupWindow, View view) {
        o(1, popupWindow);
    }

    public final /* synthetic */ void l(PopupWindow popupWindow, View view) {
        o(2, popupWindow);
    }

    public void m() {
        DeviceGridsAdapter deviceGridsAdapter = this.f12022f;
        if (deviceGridsAdapter != null) {
            deviceGridsAdapter.b();
        }
    }

    public final void n(View view) {
        View viewInflate = getLayoutInflater().inflate(R$layout.popup_device_category, (ViewGroup) null);
        final PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2, true);
        ArrayList arrayListE = b4.a.e();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayListE.iterator();
        while (it.hasNext()) {
            Vehicle vehicle = (Vehicle) it.next();
            if (b4.d.d(vehicle.model.pid)) {
                arrayList2.add(vehicle);
            } else {
                arrayList.add(vehicle);
            }
        }
        TextView textView = (TextView) viewInflate.findViewById(R$id.item_count_one);
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.item_count_two);
        TextView textView3 = (TextView) viewInflate.findViewById(R$id.item_count_three);
        textView.setText(String.valueOf(arrayListE.size()));
        textView2.setText(String.valueOf(arrayList.size()));
        textView3.setText(String.valueOf(arrayList2.size()));
        View viewFindViewById = viewInflate.findViewById(R$id.layout_item_one);
        View viewFindViewById2 = viewInflate.findViewById(R$id.layout_item_two);
        View viewFindViewById3 = viewInflate.findViewById(R$id.layout_item_three);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.f3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f12513a.j(popupWindow, view2);
            }
        });
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.g3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f12525a.k(popupWindow, view2);
            }
        });
        viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.h3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f12538a.l(popupWindow, view2);
            }
        });
        popupWindow.showAsDropDown(view);
    }

    public final void o(int i6, PopupWindow popupWindow) {
        TabLayout.Tab tabAt = this.f12020d.getTabAt(i6);
        if (tabAt != null) {
            if (this.f12020d.getSelectedTabPosition() != i6) {
                tabAt.select();
            }
            popupWindow.dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f12018b = getArguments().getString("param1");
            this.f12019c = getArguments().getString("param2");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_device_category, viewGroup, false);
        this.f12017a = viewInflate;
        ((Button) viewInflate.findViewById(R$id.button_add)).setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.c3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12484a.h(view);
            }
        });
        ((ImageButton) this.f12017a.findViewById(R$id.ib_menu)).setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.d3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12493a.n(view);
            }
        });
        this.f12021e = (ViewPager2) this.f12017a.findViewById(R$id.vp_fragment);
        this.f12020d = (TabLayout) this.f12017a.findViewById(R$id.layout_tab);
        if (this.f12021e.getAdapter() == null) {
            DeviceGridsAdapter deviceGridsAdapter = new DeviceGridsAdapter(this);
            this.f12022f = deviceGridsAdapter;
            this.f12021e.setAdapter(deviceGridsAdapter);
        }
        this.f12021e.registerOnPageChangeCallback(new a());
        final String[] strArr = {getString(R$string.vehicle_all), getString(R$string.vehicle_scooter), getString(R$string.vehicle_golf_cart)};
        new TabLayoutMediator(this.f12020d, this.f12021e, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.uz.navee.ui.device.e3
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i6) {
                DeviceCategoryFragment.i(strArr, tab, i6);
            }
        }).attach();
        return this.f12017a;
    }

    public void p() {
        MyApplication.f11588e.g0();
    }
}
