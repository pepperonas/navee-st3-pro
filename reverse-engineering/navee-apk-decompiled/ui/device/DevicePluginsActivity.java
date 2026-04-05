package com.uz.navee.ui.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.exoplayer.ExoPlayer;
import com.clj.fastble.data.BleDevice;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseListActivity;
import com.uz.navee.base.RecyclerViewHolder;
import com.uz.navee.bean.CellAccessoryType;
import com.uz.navee.bean.CellDataBase;
import com.uz.navee.bean.DeviceCarInfo;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.ui.wheel.AlertPopup;
import com.uz.navee.ui.wheel.DataStatusView;
import com.uz.navee.utils.CommonExt;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public class DevicePluginsActivity extends BaseListActivity<CellDataBase> {

    /* renamed from: h, reason: collision with root package name */
    public BleDevice f12277h;

    /* renamed from: i, reason: collision with root package name */
    public Vehicle f12278i;

    /* renamed from: j, reason: collision with root package name */
    public DataStatusView f12279j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f12280k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12281l;

    /* renamed from: m, reason: collision with root package name */
    public PropertyChangeListener f12282m;

    /* renamed from: n, reason: collision with root package name */
    public final BroadcastReceiver f12283n = new b();

    /* renamed from: o, reason: collision with root package name */
    public final BroadcastReceiver f12284o = new c();

    public class a implements com.uz.navee.base.h {
        public a() {
        }

        @Override // com.uz.navee.base.h
        public int a(int i6) {
            return R$layout.cell_plugin;
        }

        @Override // com.uz.navee.base.h
        public void b() {
            String str = DevicePluginsActivity.this.f12278i.model.pid;
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                DevicePluginsActivity.this.r0(arrayList);
                DevicePluginsActivity.this.s0(arrayList);
                if (str.startsWith("2506")) {
                    DevicePluginsActivity.this.q0(arrayList);
                }
                if (!str.startsWith("2504") && !str.startsWith("2505")) {
                    CellDataBase cellDataBase = new CellDataBase();
                    cellDataBase.setTitle(DevicePluginsActivity.this.getString(R$string.lock_ble_title));
                    cellDataBase.setAccessoryType(CellAccessoryType.INDICATOR);
                    cellDataBase.setCallback(new View.OnClickListener() { // from class: com.uz.navee.ui.device.l6
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f12580a.f(view);
                        }
                    });
                    arrayList.add(cellDataBase);
                }
                if (DevicePluginsActivity.this.f12278i.shareUserId == 0) {
                    DevicePluginsActivity.this.p0(arrayList);
                }
                DevicePluginsActivity.this.f11599c.j(arrayList);
                DevicePluginsActivity.this.f12279j.setVisibility(8);
            }
        }

        @Override // com.uz.navee.base.h
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(RecyclerViewHolder recyclerViewHolder, int i6, CellDataBase cellDataBase) throws Resources.NotFoundException {
            TextView textViewC = recyclerViewHolder.c(R$id.titleLabel);
            TextView textViewC2 = recyclerViewHolder.c(R$id.subtitleLabel);
            if (com.uz.navee.utils.d.o()) {
                textViewC.setTextSize(15.0f);
                textViewC2.setTextSize(13.0f);
            } else {
                textViewC.setTextSize(13.0f);
                textViewC2.setTextSize(11.0f);
            }
            ImageView imageViewB = recyclerViewHolder.b(R$id.indicator);
            SwitchCompat switchCompat = (SwitchCompat) recyclerViewHolder.getView(R$id.mSwitch);
            if (DevicePluginsActivity.this.getWindow().getDecorView().getLayoutDirection() == 1) {
                imageViewB.setImageDrawable(com.uz.navee.utils.d.q(ContextCompat.getDrawable(DevicePluginsActivity.this, R$mipmap.ic_cell_accessory_m)));
            }
            String title = cellDataBase.getTitle();
            if (title != null) {
                textViewC.setText(title);
                textViewC.setVisibility(0);
                if (title.equals(DevicePluginsActivity.this.getString(R$string.lock_ble_title))) {
                    if (DevicePluginsActivity.this.f12280k) {
                        textViewC.setTextColor(1728053247);
                    } else {
                        textViewC.setTextColor(-1);
                    }
                }
                if (title.equals(DevicePluginsActivity.this.getString(R$string.meter_weather_title))) {
                    if (DevicePluginsActivity.this.f12281l) {
                        textViewC.setTextColor(1728053247);
                    } else {
                        textViewC.setTextColor(-1);
                    }
                }
            } else {
                textViewC.setVisibility(8);
            }
            String subtitle = cellDataBase.getSubtitle();
            if (subtitle != null) {
                textViewC2.setText(subtitle);
                textViewC2.setVisibility(0);
            } else {
                textViewC2.setVisibility(8);
            }
            int i7 = d.f12288a[cellDataBase.getAccessoryType().ordinal()];
            if (i7 == 1) {
                imageViewB.setVisibility(8);
                switchCompat.setVisibility(8);
                return;
            }
            if (i7 == 2) {
                imageViewB.setVisibility(0);
                switchCompat.setVisibility(8);
                View.OnClickListener callback = cellDataBase.getCallback();
                if (callback != null) {
                    recyclerViewHolder.itemView.setOnClickListener(callback);
                    return;
                }
                return;
            }
            if (i7 != 3) {
                return;
            }
            imageViewB.setVisibility(8);
            switchCompat.setVisibility(0);
            switchCompat.setChecked(cellDataBase.isChecked());
            CompoundButton.OnCheckedChangeListener switchCallback = cellDataBase.getSwitchCallback();
            if (switchCallback != null) {
                switchCompat.setOnCheckedChangeListener(switchCallback);
            }
        }

        public final /* synthetic */ void f(View view) {
            DevicePluginsActivity.this.E0();
        }

        @Override // com.uz.navee.base.h
        public /* synthetic */ int getItemViewType(int i6) {
            return com.uz.navee.base.g.a(this, i6);
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws InterruptedException {
            if (com.uz.navee.e.c().b() instanceof DevicePluginsActivity) {
                BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
                if (bleDevice == null || DevicePluginsActivity.this.f12277h == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(DevicePluginsActivity.this.f12277h))) {
                    return;
                }
                DevicePluginsActivity.this.A0();
            }
        }
    }

    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
            if (bleDevice == null || DevicePluginsActivity.this.f12277h == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(DevicePluginsActivity.this.f12277h))) {
                return;
            }
            String stringExtra = intent.getStringExtra("meterVersion");
            String str = DevicePluginsActivity.this.f12278i.model.pid;
            if (str != null && ((b4.d.g(str) || b4.d.b(str)) && stringExtra != null && stringExtra.compareTo("2.0.0.4") <= 0)) {
                DevicePluginsActivity.this.f12280k = true;
                DevicePluginsActivity.this.f11600d.b();
                DevicePluginsActivity.this.f11599c.i();
            }
            if (str == null || !b4.d.i(str) || stringExtra == null || stringExtra.compareTo("0.0.1.0") > 0) {
                return;
            }
            DevicePluginsActivity.this.f12281l = true;
            DevicePluginsActivity.this.f11600d.b();
            DevicePluginsActivity.this.f11599c.i();
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12288a;

        static {
            int[] iArr = new int[CellAccessoryType.values().length];
            f12288a = iArr;
            try {
                iArr[CellAccessoryType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12288a[CellAccessoryType.INDICATOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12288a[CellAccessoryType.SWITCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() throws InterruptedException {
        try {
            Thread.sleep(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            Intent intent = new Intent("BleReconnectNotification");
            intent.putExtra("bleDevice", this.f12277h);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        } catch (InterruptedException e7) {
            throw new RuntimeException(e7);
        }
    }

    private void B0() {
        if (b4.a.f(this.f12277h)) {
            b4.a.G(this.f12277h);
        }
    }

    private void C0() {
        String str = this.f12278i.model.pid;
        if (str != null) {
            if ((str.startsWith("2345") || str.startsWith("2401") || str.startsWith("2402") || str.startsWith("2403") || str.startsWith("2418")) && b4.a.f(this.f12277h)) {
                b4.a.I(this.f12277h);
            }
        }
    }

    private void F0(DeviceCarInfo deviceCarInfo) {
        deviceCarInfo.removeListener("tcsSwitch", this.f12282m);
    }

    public static /* synthetic */ void y0() {
    }

    private void z0(DeviceCarInfo deviceCarInfo) {
        this.f12282m = deviceCarInfo.addListener("tcsSwitch", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.f6
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12518a.x0(propertyChangeEvent);
            }
        });
    }

    public final void D0(Class cls) {
        CommonExt.r(this, cls, this.f12277h, this.f12278i, null);
    }

    public final void E0() {
        if (this.f12280k) {
            AlertPopup.Q(this, getString(R$string.kind_tips), getString(R$string.ble_lock_disable_msg), "", getString(R$string.i_see), new AlertPopup.a() { // from class: com.uz.navee.ui.device.k6
                @Override // com.uz.navee.ui.wheel.AlertPopup.a
                public /* synthetic */ void a() {
                    j4.c.a(this);
                }

                @Override // com.uz.navee.ui.wheel.AlertPopup.a
                public final void b() {
                    DevicePluginsActivity.y0();
                }
            });
            return;
        }
        if (b4.a.f(this.f12277h)) {
            Intent intent = new Intent(this, (Class<?>) DeviceLockSettingActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("bleDevice", this.f12277h);
            bundle.putSerializable("vehicle", this.f12278i);
            intent.putExtra("data", bundle);
            startActivity(intent);
        }
    }

    @Override // com.uz.navee.base.BaseListActivity, com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_device_plugins);
        com.uz.navee.utils.c.e(this, getString(R$string.more_features), ContextCompat.getColor(this, R$color.nav_title_color));
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        if (bundleExtra != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.f12277h = (BleDevice) bundleExtra.getParcelable("bleDevice", BleDevice.class);
                this.f12278i = (Vehicle) bundleExtra.getSerializable("vehicle", Vehicle.class);
            } else {
                this.f12277h = (BleDevice) bundleExtra.getParcelable("bleDevice");
                this.f12278i = (Vehicle) bundleExtra.getSerializable("vehicle");
            }
        }
        DataStatusView dataStatusView = (DataStatusView) findViewById(R$id.statusView);
        this.f12279j = dataStatusView;
        dataStatusView.setStatus(DataStatusView.DataStatus.empty);
        this.f12279j.setText(getString(R$string.no_plugins));
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f12284o, new IntentFilter("BleReadFirmwareSuccessNotification"));
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f12283n, new IntentFilter("BleDisconnectNotification"));
        z0(b4.a.W().f1933f);
        Q(new a());
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f12284o);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f12283n);
        F0(b4.a.W().f1933f);
        super.onDestroy();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        B0();
        C0();
    }

    public final void p0(List list) {
        CellDataBase cellDataBase = new CellDataBase();
        cellDataBase.setTitle(getString(R$string.device_sharing));
        cellDataBase.setAccessoryType(CellAccessoryType.INDICATOR);
        cellDataBase.setCallback(new View.OnClickListener() { // from class: com.uz.navee.ui.device.h6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12541a.t0(view);
            }
        });
        list.add(cellDataBase);
    }

    public final void q0(List list) {
        CellDataBase cellDataBase = new CellDataBase();
        cellDataBase.setTitle(getString(R$string.sound_effect_settings));
        cellDataBase.setAccessoryType(CellAccessoryType.INDICATOR);
        cellDataBase.setCallback(new View.OnClickListener() { // from class: com.uz.navee.ui.device.j6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12560a.u0(view);
            }
        });
        list.add(cellDataBase);
    }

    public final void r0(List list) {
        CellDataBase cellDataBase = new CellDataBase();
        cellDataBase.setTitle(getString(R$string.custom_speed_limit));
        cellDataBase.setAccessoryType(CellAccessoryType.INDICATOR);
        cellDataBase.setCallback(new View.OnClickListener() { // from class: com.uz.navee.ui.device.i6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12551a.v0(view);
            }
        });
        list.add(cellDataBase);
    }

    public final void s0(List list) {
        CellDataBase cellDataBase = new CellDataBase();
        cellDataBase.setTitle(getString(R$string.startup_speed_settings));
        cellDataBase.setAccessoryType(CellAccessoryType.INDICATOR);
        cellDataBase.setCallback(new View.OnClickListener() { // from class: com.uz.navee.ui.device.g6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12531a.w0(view);
            }
        });
        list.add(cellDataBase);
    }

    public final /* synthetic */ void t0(View view) {
        D0(DeviceShareActivity.class);
    }

    public final /* synthetic */ void u0(View view) {
        D0(SoundEffectActivity.class);
    }

    public final /* synthetic */ void v0(View view) {
        D0(SpeedLimitActivity.class);
    }

    public final /* synthetic */ void w0(View view) {
        D0(StartupSpeedActivity.class);
    }

    public final /* synthetic */ void x0(PropertyChangeEvent propertyChangeEvent) {
        if ("tcsSwitch".equals(propertyChangeEvent.getPropertyName())) {
            this.f11600d.b();
            this.f11599c.i();
        }
    }
}
