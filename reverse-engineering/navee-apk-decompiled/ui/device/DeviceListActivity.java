package com.uz.navee.ui.device;

import android.R;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.clj.fastble.data.BleDevice;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseListActivity;
import com.uz.navee.base.RecyclerViewHolder;
import com.uz.navee.bean.EmptyResponseData;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.ui.data.UserVehicleHelper;
import com.uz.navee.ui.wheel.AlertPopup;
import d4.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public class DeviceListActivity extends BaseListActivity<Vehicle> {

    /* renamed from: h, reason: collision with root package name */
    public ImageView f12165h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f12166i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f12167j;

    /* renamed from: k, reason: collision with root package name */
    public View f12168k;

    /* renamed from: l, reason: collision with root package name */
    public Button f12169l;

    /* renamed from: m, reason: collision with root package name */
    public Button f12170m;

    /* renamed from: o, reason: collision with root package name */
    public BleDevice f12172o;

    /* renamed from: p, reason: collision with root package name */
    public Vehicle f12173p;

    /* renamed from: t, reason: collision with root package name */
    public boolean f12177t;

    /* renamed from: u, reason: collision with root package name */
    public String f12178u;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f12171n = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    public final int f12174q = 0;

    /* renamed from: r, reason: collision with root package name */
    public final int f12175r = 1;

    /* renamed from: s, reason: collision with root package name */
    public boolean f12176s = false;

    /* renamed from: v, reason: collision with root package name */
    public final io.reactivex.disposables.a f12179v = new io.reactivex.disposables.a();

    public class a implements com.uz.navee.base.h {
        public a() {
        }

        @Override // com.uz.navee.base.h
        public int a(int i6) {
            return i6 == 1 ? R$layout.cell_device_add : R$layout.cell_device_bound;
        }

        @Override // com.uz.navee.base.h
        public void b() {
            DeviceListActivity.this.f12171n = b4.a.e();
            if (!DeviceListActivity.this.f12177t) {
                DeviceListActivity.this.f12171n.add(new Vehicle());
            }
            DeviceListActivity.this.f11599c.j(DeviceListActivity.this.f12171n);
        }

        @Override // com.uz.navee.base.h
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void c(RecyclerViewHolder recyclerViewHolder, int i6, final Vehicle vehicle) {
            final String str = vehicle.mac;
            if (str == null) {
                ImageView imageViewB = recyclerViewHolder.b(R$id.indicator);
                if (DeviceListActivity.this.getWindow().getDecorView().getLayoutDirection() == 1) {
                    imageViewB.setImageDrawable(com.uz.navee.utils.d.q(ContextCompat.getDrawable(DeviceListActivity.this, R$mipmap.ic_cell_accessory_m)));
                }
                recyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.h5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f12540a.j(view);
                    }
                });
                return;
            }
            recyclerViewHolder.c(R$id.titleLabel).setText(vehicle.displayName());
            recyclerViewHolder.c(R$id.subtitleLabel).setText(str);
            com.bumptech.glide.b.w(DeviceListActivity.this).t(Uri.parse(vehicle.model.minImg)).z0(recyclerViewHolder.b(R$id.imageView));
            ImageButton imageButtonA = recyclerViewHolder.a(R$id.deleteButton);
            ImageView imageViewB2 = recyclerViewHolder.b(R$id.selectIcon);
            if (vehicle.shareUserId != 0) {
                imageButtonA.setImageResource(R$mipmap.ic_shared);
            } else if (DeviceListActivity.this.f12177t) {
                imageButtonA.setVisibility(8);
                imageViewB2.setSelected(TextUtils.equals(str, DeviceListActivity.this.f12178u));
            } else {
                imageButtonA.setImageResource(R$mipmap.ic_device_delete);
                imageButtonA.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.f5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f12516a.h(vehicle, view);
                    }
                });
                if (DeviceListActivity.this.f12176s) {
                    imageViewB2.setSelected(DeviceListActivity.this.f12170m.isSelected());
                } else {
                    imageViewB2.setSelected(DeviceListActivity.this.f12173p != null && str.equals(DeviceListActivity.this.f12173p.mac));
                }
            }
            recyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.g5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f12528a.i(str, vehicle, view);
                }
            });
        }

        @Override // com.uz.navee.base.h
        public int getItemViewType(int i6) {
            return (DeviceListActivity.this.f12177t || i6 != DeviceListActivity.this.f12171n.size() - 1) ? 0 : 1;
        }

        public final /* synthetic */ void h(Vehicle vehicle, View view) {
            DeviceListActivity.this.E0(vehicle);
        }

        public final /* synthetic */ void i(String str, Vehicle vehicle, View view) {
            if (DeviceListActivity.this.f12177t) {
                Intent intent = new Intent();
                intent.putExtra("mac", str);
                intent.putExtra(AppMeasurementSdk.ConditionalUserProperty.NAME, vehicle.displayName());
                DeviceListActivity.this.setResult(-1, intent);
            } else {
                DeviceListActivity.this.f12173p = vehicle;
                DeviceListActivity.this.t0();
            }
            DeviceListActivity.this.finish();
        }

        public final /* synthetic */ void j(View view) {
            DeviceListActivity.this.startActivity(new Intent(DeviceListActivity.this, (Class<?>) DeviceBindActivity.class));
        }
    }

    public class b implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Vehicle f12181a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f12182b;

        public class a extends TypeToken<HttpResponse<EmptyResponseData>> {
            public a() {
            }
        }

        public b(Vehicle vehicle, String str) {
            this.f12181a = vehicle;
            this.f12182b = str;
        }

        @Override // d4.d.h
        public void a(String str) throws IOException {
            DeviceListActivity.this.B();
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse != null) {
                if (httpResponse.getCode() != 200) {
                    DeviceListActivity.this.I(httpResponse.getMsg());
                    return;
                }
                if (b4.a.f(DeviceListActivity.this.f12172o) && Objects.equals(b4.a.r(DeviceListActivity.this.f12172o), this.f12181a.mac)) {
                    b4.a.c0(DeviceListActivity.this.f12172o, b4.a.k(80, 1, false));
                    b4.a.Q();
                } else {
                    DeviceListActivity.this.I(DeviceListActivity.this.getString(R$string.unbind_vehicle_alarm));
                }
                b4.a.P(this.f12182b);
                ArrayList arrayListE = b4.a.e();
                if (DeviceListActivity.this.f12173p != null && Objects.equals(this.f12181a.mac, DeviceListActivity.this.f12173p.mac)) {
                    if (arrayListE.isEmpty()) {
                        DeviceListActivity.this.f12173p = null;
                    } else {
                        DeviceListActivity.this.f12173p = (Vehicle) arrayListE.get(0);
                    }
                }
                DeviceListActivity.this.f11600d.b();
                DeviceListActivity.this.t0();
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            DeviceListActivity.this.B();
            DeviceListActivity.this.I(exc.getLocalizedMessage());
        }
    }

    public class c implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f12185a;

        public class a extends TypeToken<HttpResponse<EmptyResponseData>> {
            public a() {
            }
        }

        public c(List list) {
            this.f12185a = list;
        }

        @Override // d4.d.h
        public void a(String str) throws IOException {
            DeviceListActivity.this.B();
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse != null) {
                if (httpResponse.getCode() != 200) {
                    DeviceListActivity.this.I(httpResponse.getMsg());
                    return;
                }
                if (b4.a.f(DeviceListActivity.this.f12172o)) {
                    b4.a.c0(DeviceListActivity.this.f12172o, b4.a.k(80, 1, false));
                }
                b4.a.M(this.f12185a);
                DeviceListActivity.this.f12173p = null;
                DeviceListActivity.this.f11600d.b();
                DeviceListActivity.this.t0();
                DeviceListActivity.this.f12170m.setSelected(false);
                DeviceListActivity.this.f12169l.setEnabled(false);
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            DeviceListActivity.this.B();
            DeviceListActivity.this.I(exc.getLocalizedMessage());
        }
    }

    public static /* synthetic */ void A0(Throwable th) {
    }

    private void k0() {
        this.f12165h = (ImageView) findViewById(R$id.logo_toolbar);
        this.f12166i = (TextView) findViewById(R$id.titleView_toolbar);
        this.f12167j = (TextView) findViewById(R$id.tv_right_toolbar);
        this.f12168k = findViewById(R$id.selectAllLayout);
        this.f12169l = (Button) findViewById(R$id.deleteAllButton);
        this.f12170m = (Button) findViewById(R$id.selectAllButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(View view) {
        boolean z6 = !this.f12176s;
        this.f12176s = z6;
        this.f12167j.setText(getString(z6 ? R$string.done : R$string.manage));
        this.f12168k.setVisibility(this.f12176s ? 0 : 8);
        this.f12170m.setSelected(false);
        this.f12169l.setEnabled(false);
        this.f11599c.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(View view) {
        this.f12176s = false;
        this.f12167j.setText(getString(R$string.manage));
        this.f12168k.setVisibility(8);
        this.f12170m.setSelected(false);
        this.f12169l.setEnabled(false);
        this.f11599c.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(View view) {
        s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(View view) {
        this.f12170m.setSelected(!r2.isSelected());
        this.f12169l.setEnabled(this.f12170m.isSelected());
        this.f11599c.i();
    }

    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public final void B0(Vehicle vehicle) {
        K();
        String str = vehicle.mac;
        String str2 = vehicle.model.pid;
        if (str == null || str2 == null) {
            return;
        }
        String str3 = e4.a.a() + "/vehicle/unbind";
        d4.d dVarH = d4.d.h();
        HashMap map = new HashMap();
        map.put("mac", str);
        map.put("pid", str2);
        dVarH.g(str3, map, new b(vehicle, str));
    }

    public final void D0() {
        this.f12179v.b(UserVehicleHelper.f11680a.i().n(new r4.g() { // from class: com.uz.navee.ui.device.c5
            @Override // r4.g
            public final void accept(Object obj) {
                this.f12486a.z0((List) obj);
            }
        }, new r4.g() { // from class: com.uz.navee.ui.device.d5
            @Override // r4.g
            public final void accept(Object obj) {
                DeviceListActivity.A0((Throwable) obj);
            }
        }));
    }

    @Override // com.uz.navee.base.BaseActivity
    public void E() {
        super.E();
        if (com.uz.navee.utils.d.p(this)) {
            this.f12165h.setImageDrawable(com.uz.navee.utils.d.q(ContextCompat.getDrawable(this, R$mipmap.ic_nav_back)));
        }
    }

    public final void E0(final Vehicle vehicle) {
        String str = "\n" + getString(R$string.unbind_vehicle_alarm);
        if (b4.a.f(this.f12172o) && Objects.equals(b4.a.r(this.f12172o), vehicle.mac)) {
            str = "";
        }
        AlertPopup.P(this, getString(R$string.unbind), getString(R$string.unbind_vehicle_message) + str, new AlertPopup.a() { // from class: com.uz.navee.ui.device.e5
            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public /* synthetic */ void a() {
                j4.c.a(this);
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public final void b() {
                this.f12504a.B0(vehicle);
            }
        });
    }

    public final void F0() {
        ArrayList<Vehicle> arrayListE = b4.a.e();
        if (arrayListE.isEmpty()) {
            return;
        }
        K();
        String str = e4.a.a() + "/vehicle/unbind/batch";
        d4.d dVarH = d4.d.h();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Vehicle vehicle : arrayListE) {
            String str2 = vehicle.mac;
            if (str2 == null || vehicle.shareUserId != 0) {
                arrayList2.add(vehicle);
            } else {
                arrayList.add(str2);
            }
        }
        HashMap map = new HashMap();
        map.put("macList", arrayList);
        dVarH.g(str, map, new c(arrayList2));
    }

    @Override // com.uz.navee.base.BaseListActivity, com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_device_list);
        k0();
        this.f12177t = getIntent().getBooleanExtra("selectable", false);
        this.f12178u = getIntent().getStringExtra("selectedMac");
        String string = getString(this.f12177t ? R$string.vehicle_selection : R$string.switching_vehicles);
        this.f12165h.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.w4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12690a.u0(view);
            }
        });
        this.f12166i.setText(string);
        this.f12166i.setTextColor(ContextCompat.getColor(this, R$color.nav_title_color));
        if (!this.f12177t) {
            this.f12167j.setText(getString(R$string.manage));
            this.f12167j.setVisibility(0);
            this.f12167j.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.x4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f12701a.v0(view);
                }
            });
            this.f12168k.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.y4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f12711a.w0(view);
                }
            });
            this.f12169l.setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, new int[]{-16842910}}, new int[]{ContextCompat.getColor(this, R$color.white), ContextCompat.getColor(this, R$color.xFAF4E8_50)}));
            this.f12169l.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.z4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f12720a.x0(view);
                }
            });
            this.f12169l.setEnabled(false);
            this.f12170m.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.a5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f12466a.y0(view);
                }
            });
        }
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        if (bundleExtra != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.f12172o = (BleDevice) bundleExtra.getParcelable("bleDevice", BleDevice.class);
            } else {
                this.f12172o = (BleDevice) bundleExtra.getParcelable("bleDevice");
            }
            this.f12173p = (Vehicle) bundleExtra.getSerializable("vehicle");
        }
        Q(new a());
        E();
        D0();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f12179v.d();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f11600d.b();
        b4.a.W().Z();
    }

    public final void s0() {
        AlertPopup.P(this, getString(R$string.unbind), getString(R$string.unbind_vehicle_message), new AlertPopup.a() { // from class: com.uz.navee.ui.device.b5
            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public /* synthetic */ void a() {
                j4.c.a(this);
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public final void b() {
                this.f12476a.F0();
            }
        });
    }

    public final void t0() {
        if (this.f12173p == null) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("BleDeviceChangedNotification"));
            return;
        }
        BleDevice bleDevice = this.f12172o;
        if (bleDevice == null || !Objects.equals(b4.a.r(bleDevice), this.f12173p.mac)) {
            Intent intent = new Intent("BleDeviceChangedNotification");
            intent.putExtra("vehicle", this.f12173p);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        }
    }

    public final /* synthetic */ void z0(List list) {
        this.f12171n.clear();
        this.f12171n.addAll(list);
        if (!this.f12177t) {
            this.f12171n.add(new Vehicle());
        }
        this.f11599c.j(this.f12171n);
    }
}
