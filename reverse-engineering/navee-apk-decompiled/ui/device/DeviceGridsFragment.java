package com.uz.navee.ui.device;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;
import com.clj.fastble.data.BleDevice;
import com.uz.navee.MyApplication;
import com.uz.navee.R$dimen;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.base.BaseListFragment;
import com.uz.navee.base.RecyclerViewHolder;
import com.uz.navee.bean.Vehicle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes3.dex */
public class DeviceGridsFragment extends BaseListFragment<Vehicle> {

    /* renamed from: g, reason: collision with root package name */
    public DeviceCategory f12102g;

    public class a implements com.uz.navee.base.h {

        /* renamed from: com.uz.navee.ui.device.DeviceGridsFragment$a$a, reason: collision with other inner class name */
        public class ViewOnClickListenerC0165a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Vehicle f12104a;

            public ViewOnClickListenerC0165a(Vehicle vehicle) {
                this.f12104a = vehicle;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BleDevice bleDeviceY = MyApplication.f11588e.Y();
                if (bleDeviceY == null || !Objects.equals(b4.a.r(bleDeviceY), this.f12104a.mac)) {
                    Intent intent = new Intent("BleDeviceChangedNotification");
                    intent.putExtra("vehicle", this.f12104a);
                    LocalBroadcastManager.getInstance(DeviceGridsFragment.this.requireContext()).sendBroadcast(intent);
                }
                Fragment parentFragment = DeviceGridsFragment.this.getParentFragment();
                if (parentFragment instanceof DeviceCategoryFragment) {
                    ((DeviceCategoryFragment) parentFragment).p();
                }
            }
        }

        public a() {
        }

        @Override // com.uz.navee.base.h
        public int a(int i6) {
            return R$layout.cell_device_grid;
        }

        @Override // com.uz.navee.base.h
        public void b() {
            ArrayList arrayListE = b4.a.e();
            int i6 = b.f12106a[DeviceGridsFragment.this.f12102g.ordinal()];
            if (i6 == 1) {
                DeviceGridsFragment.this.f11608b.j(arrayListE);
                return;
            }
            if (i6 == 2) {
                ArrayList arrayList = new ArrayList();
                Iterator it = arrayListE.iterator();
                while (it.hasNext()) {
                    Vehicle vehicle = (Vehicle) it.next();
                    if (!b4.d.d(vehicle.model.pid)) {
                        arrayList.add(vehicle);
                    }
                }
                DeviceGridsFragment.this.f11608b.j(arrayList);
                return;
            }
            if (i6 != 3) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayListE.iterator();
            while (it2.hasNext()) {
                Vehicle vehicle2 = (Vehicle) it2.next();
                if (b4.d.d(vehicle2.model.pid)) {
                    arrayList2.add(vehicle2);
                }
            }
            DeviceGridsFragment.this.f11608b.j(arrayList2);
        }

        @Override // com.uz.navee.base.h
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void c(RecyclerViewHolder recyclerViewHolder, int i6, Vehicle vehicle) {
            TextView textViewC = recyclerViewHolder.c(R$id.tv_name);
            ImageView imageViewB = recyclerViewHolder.b(R$id.iv_vehicle);
            textViewC.setText(vehicle.displayName());
            com.bumptech.glide.b.t(DeviceGridsFragment.this.requireContext()).t(Uri.parse(vehicle.model.maxImg)).z0(imageViewB);
            recyclerViewHolder.itemView.setOnClickListener(new ViewOnClickListenerC0165a(vehicle));
        }

        @Override // com.uz.navee.base.h
        public /* synthetic */ int getItemViewType(int i6) {
            return com.uz.navee.base.g.a(this, i6);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12106a;

        static {
            int[] iArr = new int[DeviceCategory.values().length];
            f12106a = iArr;
            try {
                iArr[DeviceCategory.all.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12106a[DeviceCategory.scooter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12106a[DeviceCategory.golfCart.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public void f() {
        com.uz.navee.base.h hVar = this.f11609c;
        if (hVar != null) {
            hVar.b();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        this.f11607a = layoutInflater.inflate(R$layout.fragment_device_grids, viewGroup, false);
        this.f12102g = DeviceCategory.all;
        b(new a(), new GridLayoutManager(requireContext(), 2), new DeviceGridItemDecoration(getResources().getDimensionPixelSize(R$dimen.grid_space_horizontal), getResources().getDimensionPixelSize(R$dimen.grid_space_vertical)));
        return this.f11607a;
    }
}
