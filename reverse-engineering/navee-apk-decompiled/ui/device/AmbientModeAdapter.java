package com.uz.navee.ui.device;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.uz.navee.ui.device.AmbientModeFragment;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class AmbientModeAdapter extends FragmentStateAdapter {

    /* renamed from: a, reason: collision with root package name */
    public b f11757a;

    /* renamed from: b, reason: collision with root package name */
    public Map f11758b;

    public class a implements AmbientModeFragment.a {
        public a() {
        }

        @Override // com.uz.navee.ui.device.AmbientModeFragment.a
        public void a(int i6) {
            b bVar = AmbientModeAdapter.this.f11757a;
            if (bVar != null) {
                bVar.a(i6);
            }
        }

        @Override // com.uz.navee.ui.device.AmbientModeFragment.a
        public void b(int i6, int i7) {
            b bVar = AmbientModeAdapter.this.f11757a;
            if (bVar != null) {
                bVar.b(i6, i7);
            }
        }
    }

    public interface b {
        void a(int i6);

        void b(int i6, int i7);
    }

    public AmbientModeAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.f11758b = new HashMap();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int i6) {
        AmbientModeFragment ambientModeFragment = new AmbientModeFragment();
        if (i6 == 0) {
            ambientModeFragment.f11766g = AmbientModeFragment.AmbientMode.alwaysOn;
        } else if (i6 == 1) {
            ambientModeFragment.f11766g = AmbientModeFragment.AmbientMode.breathing;
        } else if (i6 == 2) {
            ambientModeFragment.f11766g = AmbientModeFragment.AmbientMode.flowingWater;
        } else if (i6 == 3) {
            ambientModeFragment.f11766g = AmbientModeFragment.AmbientMode.horseRacing;
        }
        ambientModeFragment.f11767h = new a();
        this.f11758b.put(ambientModeFragment.f11766g, ambientModeFragment);
        return ambientModeFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 4;
    }
}
