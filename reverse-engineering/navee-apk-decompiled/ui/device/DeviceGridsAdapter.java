package com.uz.navee.ui.device;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class DeviceGridsAdapter extends FragmentStateAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final Map f12101a;

    public DeviceGridsAdapter(Fragment fragment) {
        super(fragment);
        this.f12101a = new HashMap();
    }

    public Fragment a(int i6) {
        return (Fragment) this.f12101a.get(Integer.valueOf(i6));
    }

    public void b() {
        for (int i6 = 0; i6 < getItemCount(); i6++) {
            Fragment fragmentA = a(i6);
            if (fragmentA instanceof DeviceGridsFragment) {
                ((DeviceGridsFragment) fragmentA).f();
            }
        }
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int i6) {
        DeviceGridsFragment deviceGridsFragment = new DeviceGridsFragment();
        if (i6 == 0) {
            deviceGridsFragment.f12102g = DeviceCategory.all;
        } else if (i6 == 1) {
            deviceGridsFragment.f12102g = DeviceCategory.scooter;
        } else if (i6 == 2) {
            deviceGridsFragment.f12102g = DeviceCategory.golfCart;
        }
        this.f12101a.put(Integer.valueOf(i6), deviceGridsFragment);
        return deviceGridsFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 3;
    }
}
