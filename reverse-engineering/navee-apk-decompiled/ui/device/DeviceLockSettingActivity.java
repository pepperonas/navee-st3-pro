package com.uz.navee.ui.device;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
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
import com.uz.navee.utils.CommonExt;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public class DeviceLockSettingActivity extends BaseListActivity<CellDataBase> {

    /* renamed from: h, reason: collision with root package name */
    public BleDevice f12188h;

    /* renamed from: i, reason: collision with root package name */
    public Vehicle f12189i;

    /* renamed from: j, reason: collision with root package name */
    public String f12190j;

    /* renamed from: k, reason: collision with root package name */
    public String f12191k;

    /* renamed from: l, reason: collision with root package name */
    public int f12192l;

    /* renamed from: p, reason: collision with root package name */
    public Runnable f12196p;

    /* renamed from: q, reason: collision with root package name */
    public PropertyChangeListener f12197q;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12193m = true;

    /* renamed from: n, reason: collision with root package name */
    public boolean f12194n = true;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12195o = false;

    /* renamed from: r, reason: collision with root package name */
    public final BroadcastReceiver f12198r = new b();

    /* renamed from: s, reason: collision with root package name */
    public final BroadcastReceiver f12199s = new c();

    /* renamed from: t, reason: collision with root package name */
    public final BroadcastReceiver f12200t = new d();

    public class a implements com.uz.navee.base.h {

        /* renamed from: com.uz.navee.ui.device.DeviceLockSettingActivity$a$a, reason: collision with other inner class name */
        public class C0168a implements AlertPopup.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CompoundButton f12202a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CellDataBase f12203b;

            public C0168a(CompoundButton compoundButton, CellDataBase cellDataBase) {
                this.f12202a = compoundButton;
                this.f12203b = cellDataBase;
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public void a() {
                this.f12202a.setOnCheckedChangeListener(null);
                this.f12202a.toggle();
                this.f12202a.setOnCheckedChangeListener(this.f12203b.getSwitchCallback());
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public void b() {
            }
        }

        public class b implements AlertPopup.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CompoundButton f12205a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CellDataBase f12206b;

            public b(CompoundButton compoundButton, CellDataBase cellDataBase) {
                this.f12205a = compoundButton;
                this.f12206b = cellDataBase;
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public void a() {
                this.f12205a.setOnCheckedChangeListener(null);
                this.f12205a.toggle();
                this.f12205a.setOnCheckedChangeListener(this.f12206b.getSwitchCallback());
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public void b() {
            }
        }

        public class c implements AlertPopup.a {
            public c() {
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public void a() {
                if (DeviceLockSettingActivity.this.f11599c != null) {
                    DeviceLockSettingActivity.this.f11599c.i();
                }
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public void b() throws IOException {
                if ((b4.a.W().f1933f.getProximityKey() & 1) != 1) {
                    b4.a.c0(DeviceLockSettingActivity.this.f12188h, b4.a.k(97, 1, false));
                    DeviceLockSettingActivity.this.f12196p = new Runnable() { // from class: com.uz.navee.ui.device.p5
                        @Override // java.lang.Runnable
                        public final void run() throws IOException {
                            this.f12615a.d();
                        }
                    };
                    new Handler(Looper.getMainLooper()).postDelayed(DeviceLockSettingActivity.this.f12196p, 1000L);
                }
            }

            public final /* synthetic */ void d() throws IOException {
                DeviceLockSettingActivity deviceLockSettingActivity = DeviceLockSettingActivity.this;
                b4.a.i(deviceLockSettingActivity, deviceLockSettingActivity.f12188h);
            }
        }

        public class d implements AlertPopup.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CompoundButton f12209a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CellDataBase f12210b;

            public d(CompoundButton compoundButton, CellDataBase cellDataBase) {
                this.f12209a = compoundButton;
                this.f12210b = cellDataBase;
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public void a() {
                this.f12209a.setOnCheckedChangeListener(null);
                this.f12209a.toggle();
                this.f12209a.setOnCheckedChangeListener(this.f12210b.getSwitchCallback());
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public void b() throws IOException {
                if (b4.a.f(DeviceLockSettingActivity.this.f12188h)) {
                    b4.a.c0(DeviceLockSettingActivity.this.f12188h, b4.a.l(99, new byte[]{0, 0, 0, 0, 0, 0}, false));
                    if ((b4.a.W().f1933f.getProximityKey() & 1) == 1) {
                        b4.a.c0(DeviceLockSettingActivity.this.f12188h, b4.a.k(97, 0, false));
                    }
                }
            }
        }

        public a() {
        }

        @Override // com.uz.navee.base.h
        public int a(int i6) {
            return i6 == 0 ? R$layout.cell_plugin : i6 == 1 ? R$layout.cell_password_lock : R$layout.cell_password_manual;
        }

        @Override // com.uz.navee.base.h
        public void b() {
            ArrayList arrayList = new ArrayList();
            if (DeviceLockSettingActivity.this.f12194n) {
                CellDataBase cellDataBase = new CellDataBase();
                cellDataBase.setTitle(DeviceLockSettingActivity.this.getString(R$string.lock_time_setting));
                cellDataBase.setAccessoryType(CellAccessoryType.INDICATOR);
                cellDataBase.setCallback(new View.OnClickListener() { // from class: com.uz.navee.ui.device.k5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f12569a.l(view);
                    }
                });
                cellDataBase.setCustomType(0);
                arrayList.add(cellDataBase);
            }
            final CellDataBase cellDataBase2 = new CellDataBase();
            cellDataBase2.setTitle(DeviceLockSettingActivity.this.getString(R$string.ble_proximity_unlock));
            if (DeviceLockSettingActivity.this.f12193m) {
                cellDataBase2.setSubtitle(DeviceLockSettingActivity.this.getString(R$string.ble_proximity_unlock_tips));
            }
            CellAccessoryType cellAccessoryType = CellAccessoryType.SWITCH;
            cellDataBase2.setAccessoryType(cellAccessoryType);
            cellDataBase2.setChecked((b4.a.W().f1933f.getProximityKey() & 1) == 1);
            cellDataBase2.setSwitchCallback(new CompoundButton.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.l5
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) throws IOException {
                    this.f12578a.m(cellDataBase2, compoundButton, z6);
                }
            });
            cellDataBase2.setCustomType(1);
            arrayList.add(cellDataBase2);
            if (DeviceLockSettingActivity.this.f12193m) {
                final CellDataBase cellDataBase3 = new CellDataBase();
                cellDataBase3.setTitle(DeviceLockSettingActivity.this.getString(R$string.lock_pwd_title));
                cellDataBase3.setAccessoryType(cellAccessoryType);
                cellDataBase3.setChecked(DeviceLockSettingActivity.this.f12192l == 1);
                cellDataBase3.setSwitchCallback(new CompoundButton.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.m5
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) throws IOException {
                        this.f12589a.n(cellDataBase3, compoundButton, z6);
                    }
                });
                cellDataBase3.setCustomType(2);
                arrayList.add(cellDataBase3);
                if (DeviceLockSettingActivity.this.f12192l == 1) {
                    CellDataBase cellDataBase4 = new CellDataBase();
                    cellDataBase4.setTitle(DeviceLockSettingActivity.this.getString(R$string.lock_manual_title));
                    cellDataBase4.setAccessoryType(CellAccessoryType.NONE);
                    cellDataBase4.setCustomType(3);
                    arrayList.add(cellDataBase4);
                }
            }
            DeviceLockSettingActivity.this.f11599c.j(arrayList);
        }

        @Override // com.uz.navee.base.h
        public int getItemViewType(int i6) {
            int customType = ((CellDataBase) DeviceLockSettingActivity.this.f11599c.getItem(i6)).getCustomType();
            if (customType == 2) {
                return 1;
            }
            return customType == 3 ? 2 : 0;
        }

        @Override // com.uz.navee.base.h
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
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
            String title = cellDataBase.getTitle();
            if (title != null) {
                textViewC.setText(title);
                textViewC.setVisibility(0);
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
            int i7 = e.f12215a[cellDataBase.getAccessoryType().ordinal()];
            if (i7 == 1) {
                imageViewB.setVisibility(8);
                switchCompat.setVisibility(8);
            } else if (i7 == 2) {
                imageViewB.setVisibility(0);
                switchCompat.setVisibility(8);
                View.OnClickListener callback = cellDataBase.getCallback();
                if (callback != null) {
                    recyclerViewHolder.itemView.setOnClickListener(callback);
                }
            } else if (i7 == 3) {
                imageViewB.setVisibility(8);
                switchCompat.setVisibility(0);
                switchCompat.setChecked(cellDataBase.isChecked());
                CompoundButton.OnCheckedChangeListener switchCallback = cellDataBase.getSwitchCallback();
                if (switchCallback != null) {
                    switchCompat.setOnCheckedChangeListener(switchCallback);
                }
            }
            int customType = cellDataBase.getCustomType();
            if (customType == 0) {
                if (DeviceLockSettingActivity.this.f12195o) {
                    textViewC.setTextColor(1728053247);
                } else {
                    textViewC.setTextColor(-1);
                }
            }
            if (customType == 1) {
                textViewC.setTextColor(ContextCompat.getColor(DeviceLockSettingActivity.this, R$color.white));
                switchCompat.setChecked((b4.a.W().f1933f.getProximityKey() & 1) == 1);
                switchCompat.setEnabled(true);
                switchCompat.setClickable(true);
                CompoundButton.OnCheckedChangeListener switchCallback2 = cellDataBase.getSwitchCallback();
                if (switchCallback2 != null) {
                    switchCompat.setOnCheckedChangeListener(switchCallback2);
                }
            }
            if (customType == 2) {
                View view = recyclerViewHolder.getView(R$id.pwdViewLayout);
                View view2 = recyclerViewHolder.getView(R$id.pwdChangeLayout);
                View view3 = recyclerViewHolder.getView(R$id.separatorLine);
                view.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.n5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        this.f12599a.j(view4);
                    }
                });
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.o5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        this.f12607a.k(view4);
                    }
                });
                if (DeviceLockSettingActivity.this.f12192l == 1) {
                    view.setVisibility(0);
                    view2.setVisibility(0);
                    view3.setVisibility(0);
                } else {
                    view.setVisibility(8);
                    view2.setVisibility(8);
                    view3.setVisibility(8);
                }
                TextView textViewC3 = recyclerViewHolder.c(R$id.pwdViewTitleLabel);
                TextView textViewC4 = recyclerViewHolder.c(R$id.pwdChangeTitleLabel);
                if (com.uz.navee.utils.d.o()) {
                    textViewC3.setTextSize(14.0f);
                    textViewC4.setTextSize(14.0f);
                } else {
                    textViewC3.setTextSize(12.0f);
                    textViewC4.setTextSize(12.0f);
                }
            }
            if (customType != 3 || DeviceLockSettingActivity.this.f12189i == null) {
                return;
            }
            ImageView imageViewB2 = recyclerViewHolder.b(R$id.iv_lock_1);
            ImageView imageViewB3 = recyclerViewHolder.b(R$id.iv_lock_2);
            ImageView imageViewB4 = recyclerViewHolder.b(R$id.iv_lock_3);
            TextView textViewC5 = recyclerViewHolder.c(R$id.tv_lock_1);
            String str = DeviceLockSettingActivity.this.f12189i.model.pid;
            if (b4.d.m(str)) {
                imageViewB2.setImageResource(R$mipmap.img_lock_manual_ecross_1);
                imageViewB3.setImageResource(R$mipmap.img_lock_manual_ecross_2);
                imageViewB4.setImageResource(R$mipmap.img_lock_manual_ecross_3);
            } else {
                if (b4.d.h(str) || b4.d.k(str)) {
                    imageViewB2.setImageResource(R$mipmap.img_lock_manual_st5_1);
                    imageViewB3.setImageResource(R$mipmap.img_lock_manual_st5_2);
                    imageViewB4.setImageResource(R$mipmap.img_lock_manual_st5_3);
                    textViewC5.setText(R$string.lock_manual_tip1_st5);
                    return;
                }
                if (b4.d.l(str)) {
                    imageViewB2.setImageResource(R$mipmap.img_lock_manual_ut5_1);
                    imageViewB3.setImageResource(R$mipmap.img_lock_manual_ut5_2);
                    imageViewB4.setImageResource(R$mipmap.img_lock_manual_ut5_3);
                    textViewC5.setText(R$string.lock_manual_tip1_st5);
                }
            }
        }

        public final /* synthetic */ void j(View view) {
            Intent intent = new Intent(DeviceLockSettingActivity.this, (Class<?>) DevicePasswordActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("bleDevice", DeviceLockSettingActivity.this.f12188h);
            bundle.putInt("viewType", 1);
            bundle.putString("password", DeviceLockSettingActivity.this.f12191k);
            intent.putExtra("data", bundle);
            DeviceLockSettingActivity.this.startActivity(intent);
        }

        public final /* synthetic */ void k(View view) {
            Intent intent = new Intent(DeviceLockSettingActivity.this, (Class<?>) DevicePasswordActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("bleDevice", DeviceLockSettingActivity.this.f12188h);
            bundle.putInt("viewType", 2);
            intent.putExtra("data", bundle);
            DeviceLockSettingActivity.this.startActivity(intent);
        }

        public final /* synthetic */ void l(View view) {
            DeviceLockSettingActivity.this.r0();
        }

        public final /* synthetic */ void m(CellDataBase cellDataBase, CompoundButton compoundButton, boolean z6) throws IOException {
            float realTimeSpeed = b4.a.W().f1932e.getRealTimeSpeed();
            if (b4.a.W().f1932e.getVersion() == 1) {
                realTimeSpeed = (float) (realTimeSpeed / 10.0d);
            }
            if (b4.a.W().f1932e.getDrivingStatus() != 0 || realTimeSpeed > 3.0f) {
                DeviceLockSettingActivity deviceLockSettingActivity = DeviceLockSettingActivity.this;
                AlertPopup.Q(deviceLockSettingActivity, deviceLockSettingActivity.getString(R$string.kind_tips), DeviceLockSettingActivity.this.getString(R$string.driving_unable_msg), null, DeviceLockSettingActivity.this.getString(R$string.i_see), new C0168a(compoundButton, cellDataBase));
                return;
            }
            int proximityKey = b4.a.W().f1933f.getProximityKey() & 1;
            if (!z6) {
                if (proximityKey == 1) {
                    b4.a.c0(DeviceLockSettingActivity.this.f12188h, b4.a.k(97, 0, false));
                    return;
                }
                return;
            }
            if (proximityKey != 1) {
                if (DeviceLockSettingActivity.this.f12193m && DeviceLockSettingActivity.this.f12192l == 0) {
                    DeviceLockSettingActivity deviceLockSettingActivity2 = DeviceLockSettingActivity.this;
                    AlertPopup.Q(deviceLockSettingActivity2, deviceLockSettingActivity2.getString(R$string.kind_tips), DeviceLockSettingActivity.this.getString(R$string.ble_proximity_open_msg), null, DeviceLockSettingActivity.this.getString(R$string.i_see), new b(compoundButton, cellDataBase));
                    return;
                }
                String string = DeviceLockSettingActivity.this.getString(R$string.ble_proximity_unlock_confirm);
                if (b4.d.i(DeviceLockSettingActivity.this.f12189i.model.pid)) {
                    string = DeviceLockSettingActivity.this.getString(R$string.ble_proximity_unlock_confirm_k100);
                } else if (DeviceLockSettingActivity.this.f12194n) {
                    string = DeviceLockSettingActivity.this.getString(R$string.ble_proximity_unlock_confirm_with_time);
                }
                DeviceLockSettingActivity deviceLockSettingActivity3 = DeviceLockSettingActivity.this;
                AlertPopup.P(deviceLockSettingActivity3, deviceLockSettingActivity3.getString(R$string.ble_proximity_unlock), string, new c());
            }
        }

        public final /* synthetic */ void n(CellDataBase cellDataBase, CompoundButton compoundButton, boolean z6) throws IOException {
            if (!z6) {
                if (DeviceLockSettingActivity.this.f12192l == 0) {
                    return;
                }
                DeviceLockSettingActivity deviceLockSettingActivity = DeviceLockSettingActivity.this;
                AlertPopup.Q(deviceLockSettingActivity, deviceLockSettingActivity.getString(R$string.kind_tips), DeviceLockSettingActivity.this.getString(R$string.ble_pwd_close_msg), DeviceLockSettingActivity.this.getString(R$string.confirm), DeviceLockSettingActivity.this.getString(R$string.cancel), new d(compoundButton, cellDataBase));
                return;
            }
            if (DeviceLockSettingActivity.this.f12192l == 1) {
                return;
            }
            if (DeviceLockSettingActivity.this.f12191k != null && !DeviceLockSettingActivity.this.f12191k.isEmpty()) {
                if (b4.a.f(DeviceLockSettingActivity.this.f12188h)) {
                    b4.a.c0(DeviceLockSettingActivity.this.f12188h, b4.a.l(99, new byte[]{1, 0, 0, 0, 0, 0}, false));
                    return;
                }
                return;
            }
            Intent intent = new Intent(DeviceLockSettingActivity.this, (Class<?>) DevicePasswordActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("bleDevice", DeviceLockSettingActivity.this.f12188h);
            bundle.putInt("viewType", 0);
            intent.putExtra("data", bundle);
            DeviceLockSettingActivity.this.startActivity(intent);
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            byte[] byteArrayExtra;
            BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
            if (bleDevice == null || DeviceLockSettingActivity.this.f12188h == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(DeviceLockSettingActivity.this.f12188h))) {
                return;
            }
            if (intent.getIntExtra("errorCode", 0) == 0 && intent.hasExtra("values") && (byteArrayExtra = intent.getByteArrayExtra("values")) != null && byteArrayExtra.length == 5) {
                DeviceLockSettingActivity.this.f12192l = com.uz.navee.utils.f.j(byteArrayExtra, 0, 1, false);
                int iJ = com.uz.navee.utils.f.j(byteArrayExtra, 1, 1, false);
                int iJ2 = com.uz.navee.utils.f.j(byteArrayExtra, 2, 1, false);
                int iJ3 = com.uz.navee.utils.f.j(byteArrayExtra, 3, 1, false);
                int iJ4 = com.uz.navee.utils.f.j(byteArrayExtra, 4, 1, false);
                if (iJ >= 10 || iJ2 >= 10 || iJ3 >= 10 || iJ4 >= 10) {
                    DeviceLockSettingActivity.this.f12191k = null;
                } else {
                    DeviceLockSettingActivity.this.f12191k = String.valueOf(iJ) + iJ2 + iJ3 + iJ4;
                }
            }
            DeviceLockSettingActivity.this.f11600d.b();
            DeviceLockSettingActivity.this.f11599c.i();
        }
    }

    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws InterruptedException {
            if (com.uz.navee.e.c().b() instanceof DeviceLockSettingActivity) {
                BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
                if (bleDevice == null || DeviceLockSettingActivity.this.f12188h == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(DeviceLockSettingActivity.this.f12188h))) {
                    return;
                }
                if (DeviceLockSettingActivity.this.f12196p != null) {
                    new Handler(Looper.getMainLooper()).removeCallbacks(DeviceLockSettingActivity.this.f12196p);
                    DeviceLockSettingActivity.this.f12196p = null;
                }
                DeviceLockSettingActivity.this.p0();
            }
        }
    }

    public class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws IOException {
            if ("android.bluetooth.device.action.BOND_STATE_CHANGED".equals(intent.getAction())) {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", 10);
                BluetoothDevice device = DeviceLockSettingActivity.this.f12188h.getDevice();
                if (device == null || bluetoothDevice == null || !device.getAddress().equals(bluetoothDevice.getAddress()) || intExtra != 10) {
                    return;
                }
                b4.a.c0(DeviceLockSettingActivity.this.f12188h, b4.a.k(97, 0, false));
            }
        }
    }

    public static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12215a;

        static {
            int[] iArr = new int[CellAccessoryType.values().length];
            f12215a = iArr;
            try {
                iArr[CellAccessoryType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12215a[CellAccessoryType.INDICATOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12215a[CellAccessoryType.SWITCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static /* synthetic */ void n0() {
    }

    private void o0(DeviceCarInfo deviceCarInfo) {
        this.f12197q = deviceCarInfo.addListener("proximityKey", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.i5
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                this.f12550a.m0(propertyChangeEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() throws InterruptedException {
        try {
            Thread.sleep(500L);
            Intent intent = new Intent("BleReconnectNotification");
            intent.putExtra("bleDevice", this.f12188h);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        } catch (InterruptedException e7) {
            throw new RuntimeException(e7);
        }
    }

    public final /* synthetic */ void m0(PropertyChangeEvent propertyChangeEvent) {
        if ("proximityKey".equals(propertyChangeEvent.getPropertyName())) {
            List listD = this.f11599c.d();
            boolean z6 = this.f12194n;
            CellDataBase cellDataBase = (CellDataBase) listD.get(z6 ? 1 : 0);
            cellDataBase.setChecked((b4.a.W().f1933f.getProximityKey() & 1) == 1);
            this.f11599c.k(z6 ? 1 : 0, cellDataBase, false);
        }
    }

    @Override // com.uz.navee.base.BaseListActivity, com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IOException {
        String str;
        super.onCreate(bundle);
        setContentView(R$layout.activity_device_lock_setting);
        com.uz.navee.utils.c.e(this, getString(R$string.lock_ble_title), ContextCompat.getColor(this, R$color.nav_title_color));
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        if (bundleExtra != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.f12188h = (BleDevice) bundleExtra.getParcelable("bleDevice", BleDevice.class);
                this.f12189i = (Vehicle) bundleExtra.getSerializable("vehicle", Vehicle.class);
            } else {
                this.f12188h = (BleDevice) bundleExtra.getParcelable("bleDevice");
                this.f12189i = (Vehicle) bundleExtra.getSerializable("vehicle");
            }
            this.f12190j = bundleExtra.getString("meterVer");
        }
        Vehicle vehicle = this.f12189i;
        if (vehicle != null && (str = vehicle.model.pid) != null) {
            boolean z6 = false;
            if (str.startsWith("2506")) {
                this.f12193m = false;
                this.f12194n = false;
            }
            if (this.f12189i.model.pid.startsWith("2436") || this.f12189i.model.pid.startsWith("2438") || this.f12189i.model.pid.startsWith("2437") || this.f12189i.model.pid.startsWith("2509") || b4.d.h(this.f12189i.model.pid) || b4.d.m(this.f12189i.model.pid)) {
                this.f12194n = false;
            }
            if (b4.d.g(this.f12189i.model.pid) || b4.d.b(this.f12189i.model.pid)) {
                String str2 = this.f12190j;
                this.f12195o = str2 != null && str2.compareTo("2.0.1.1") <= 0;
            }
            if (b4.d.a(this.f12189i.model.pid)) {
                String str3 = this.f12190j;
                if (str3 != null && str3.compareTo("2.0.5.3") <= 0) {
                    z6 = true;
                }
                this.f12195o = z6;
            }
        }
        if (this.f12193m) {
            LocalBroadcastManager.getInstance(this).registerReceiver(this.f12198r, new IntentFilter("BleReadPasswordNotification"));
        }
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f12199s, new IntentFilter("BleDisconnectNotification"));
        registerReceiver(this.f12200t, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
        if ((b4.a.W().f1933f.getProximityKey() & 1) == 1) {
            b4.a.g(this, this.f12188h);
        }
        o0(b4.a.W().f1933f);
        Q(new a());
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.f12193m) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f12198r);
        }
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f12199s);
        unregisterReceiver(this.f12200t);
        s0(b4.a.W().f1933f);
        super.onDestroy();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.f12193m) {
            q0();
        }
    }

    public final void q0() {
        if (b4.a.f(this.f12188h)) {
            b4.a.K(this.f12188h);
        }
    }

    public final void r0() {
        if (this.f12195o) {
            AlertPopup.Q(this, getString(R$string.kind_tips), getString(R$string.ble_lock_disable_msg), "", getString(R$string.i_see), new AlertPopup.a() { // from class: com.uz.navee.ui.device.j5
                @Override // com.uz.navee.ui.wheel.AlertPopup.a
                public /* synthetic */ void a() {
                    j4.c.a(this);
                }

                @Override // com.uz.navee.ui.wheel.AlertPopup.a
                public final void b() {
                    DeviceLockSettingActivity.n0();
                }
            });
        } else {
            CommonExt.r(this, DeviceLockTimeActivity.class, this.f12188h, this.f12189i, null);
        }
    }

    public final void s0(DeviceCarInfo deviceCarInfo) {
        deviceCarInfo.removeListener("proximityKey", this.f12197q);
    }
}
