package com.uz.navee;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.clj.fastble.data.BleDevice;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.internal.ViewUtils;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.bean.UserInfo;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.ui.HelpActivity;
import com.uz.navee.ui.ScanCodeActivity;
import com.uz.navee.ui.device.DeviceFragment;
import com.uz.navee.ui.device.DeviceListActivity;
import com.uz.navee.utils.n;
import d4.d;
import g4.e1;
import java.util.List;
import pub.devrel.easypermissions.EasyPermissions;

/* loaded from: classes3.dex */
public class MainActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks {

    /* renamed from: c, reason: collision with root package name */
    public BottomNavigationView f11568c;

    /* renamed from: d, reason: collision with root package name */
    public Toolbar f11569d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f11570e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f11571f;

    /* renamed from: g, reason: collision with root package name */
    public ImageButton f11572g;

    /* renamed from: h, reason: collision with root package name */
    public Button f11573h;

    /* renamed from: i, reason: collision with root package name */
    public MenuItem f11574i;

    /* renamed from: j, reason: collision with root package name */
    public MenuItem f11575j;

    /* renamed from: k, reason: collision with root package name */
    public BottomNavigationIndex f11576k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f11577l;

    /* renamed from: m, reason: collision with root package name */
    public final BroadcastReceiver f11578m = new c();

    /* renamed from: n, reason: collision with root package name */
    public final BroadcastReceiver f11579n = new d();

    /* renamed from: o, reason: collision with root package name */
    public long f11580o;

    public enum BottomNavigationIndex {
        mall,
        device,
        mine
    }

    public class a implements ViewUtils.OnApplyWindowInsetsListener {
        public a() {
        }

        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
            return windowInsetsCompat;
        }
    }

    public class b implements d.h {

        public class a extends TypeToken<HttpResponse<UserInfo>> {
            public a() {
            }
        }

        public b() {
        }

        @Override // d4.d.h
        public void a(String str) {
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new a().getType());
            if (httpResponse == null || httpResponse.getCode() != 200 || httpResponse.getData() == null) {
                return;
            }
            e1.s((UserInfo) httpResponse.getData());
        }

        @Override // d4.d.h
        public void b(Exception exc) {
        }
    }

    public class c extends BroadcastReceiver {
        public c() {
        }

        public final /* synthetic */ void c(Vehicle vehicle, BleDevice bleDevice, View view) {
            MainActivity.this.i0(vehicle, bleDevice);
        }

        public final /* synthetic */ void d(View view) {
            MainActivity.this.h0();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (MainActivity.this.f11576k == BottomNavigationIndex.device) {
                Fragment fragmentFindFragmentById = MainActivity.this.getSupportFragmentManager().findFragmentById(R$id.nav_host_fragment_activity_main);
                if (fragmentFindFragmentById != null) {
                    Fragment primaryNavigationFragment = fragmentFindFragmentById.getChildFragmentManager().getPrimaryNavigationFragment();
                    if (primaryNavigationFragment instanceof DeviceFragment) {
                        if (((DeviceFragment) primaryNavigationFragment).f()) {
                            MainActivity.this.d0();
                        } else {
                            MainActivity.this.c0();
                        }
                    }
                }
                MainActivity.this.f11577l = true;
                MainActivity.this.e0(R$mipmap.bg_after);
            }
            final BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
            final Vehicle vehicle = (Vehicle) intent.getSerializableExtra("vehicle");
            if (vehicle != null) {
                MainActivity.this.f11573h.setText(vehicle.displayName());
                MainActivity.this.f11573h.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f11625a.c(vehicle, bleDevice, view);
                    }
                });
            }
            MainActivity.this.f11572g.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f11628a.d(view);
                }
            });
        }
    }

    public class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (MainActivity.this.f11576k == BottomNavigationIndex.device) {
                MainActivity.this.b0();
                MainActivity.this.f11577l = false;
                MainActivity.this.e0(R$mipmap.bg_before);
            }
        }
    }

    private void X() {
        this.f11568c = (BottomNavigationView) findViewById(R$id.nav_view);
    }

    public BleDevice Y() {
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R$id.nav_host_fragment_activity_main);
        if (fragmentFindFragmentById != null) {
            Fragment primaryNavigationFragment = fragmentFindFragmentById.getChildFragmentManager().getPrimaryNavigationFragment();
            if (primaryNavigationFragment instanceof DeviceFragment) {
                return ((DeviceFragment) primaryNavigationFragment).h();
            }
        }
        return null;
    }

    public final void Z() {
        if (e1.u().f13675c == null || TextUtils.isEmpty(e1.u().f13675c.getNaveeId())) {
            d4.d.h().f(e4.a.a() + "/getUser", new b());
        }
    }

    public final /* synthetic */ void a0(NavController navController, NavDestination navDestination, Bundle bundle) {
        if (navDestination.getId() == R$id.navigation_mall) {
            this.f11576k = BottomNavigationIndex.mall;
            this.f11570e.setVisibility(8);
            this.f11572g.setVisibility(8);
            this.f11573h.setVisibility(8);
            this.f11571f.setText(R$string.mall);
            e0(R$mipmap.bg_base);
        } else if (navDestination.getId() == R$id.navigation_device) {
            this.f11576k = BottomNavigationIndex.device;
            e0(this.f11577l ? R$mipmap.bg_after : R$mipmap.bg_before);
        } else if (navDestination.getId() == R$id.navigation_mine) {
            this.f11576k = BottomNavigationIndex.mine;
            this.f11570e.setVisibility(8);
            this.f11572g.setVisibility(8);
            this.f11573h.setVisibility(8);
            this.f11571f.setText("");
            e0(R$mipmap.bg_base);
        }
        invalidateOptionsMenu();
    }

    @Override // pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
    public void b(int i6, List list) {
    }

    public void b0() {
        this.f11570e.setVisibility(0);
        this.f11572g.setVisibility(8);
        this.f11573h.setVisibility(8);
        this.f11571f.setText("");
    }

    public void c0() {
        this.f11570e.setVisibility(8);
        this.f11572g.setVisibility(0);
        this.f11573h.setVisibility(0);
        this.f11571f.setText("");
    }

    public void d0() {
        this.f11570e.setVisibility(8);
        this.f11572g.setVisibility(8);
        this.f11573h.setVisibility(8);
        this.f11571f.setText(R$string.my_devices);
    }

    public final void e0(int i6) {
        getWindow().getDecorView().setBackgroundResource(i6);
    }

    public void f0(int i6, int i7) {
        this.f11568c.getMenu().findItem(i6).setIcon(i7);
    }

    public void g0() {
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R$id.nav_host_fragment_activity_main);
        if (fragmentFindFragmentById != null) {
            Fragment primaryNavigationFragment = fragmentFindFragmentById.getChildFragmentManager().getPrimaryNavigationFragment();
            if (primaryNavigationFragment instanceof DeviceFragment) {
                ((DeviceFragment) primaryNavigationFragment).i();
            }
            c0();
        }
    }

    public void h0() {
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R$id.nav_host_fragment_activity_main);
        if (fragmentFindFragmentById != null) {
            Fragment primaryNavigationFragment = fragmentFindFragmentById.getChildFragmentManager().getPrimaryNavigationFragment();
            if (primaryNavigationFragment instanceof DeviceFragment) {
                ((DeviceFragment) primaryNavigationFragment).q();
            }
            d0();
        }
    }

    public final void i0(Vehicle vehicle, BleDevice bleDevice) {
        Intent intent = new Intent(this, (Class<?>) DeviceListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("bleDevice", bleDevice);
        bundle.putSerializable("vehicle", vehicle);
        intent.putExtra("data", bundle);
        startActivity(intent);
    }

    @Override // pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
    public void l(int i6, List list) {
        Fragment fragmentFindFragmentById;
        if (i6 != 2 || (fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R$id.nav_host_fragment_activity_main)) == null) {
            return;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i6, int i7, Intent intent) {
        super.onActivityResult(i6, i7, intent);
        if (i6 == 303) {
            if (i7 != 0) {
                Intent intent2 = new Intent("BleOpenNotification");
                intent2.putExtra("accessType", 303);
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent2);
                return;
            }
            return;
        }
        if ((i6 == 307 || i6 == 308) && i7 != 0) {
            Intent intent3 = new Intent("BleOpenNotification");
            intent3.putExtra("accessType", i6);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent3);
        }
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f11578m, new IntentFilter("BleDeviceAfterNotification"));
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f11579n, new IntentFilter("BleDeviceBeforeNotification"));
        setContentView(R$layout.activity_main);
        X();
        FirebaseCrashlytics.getInstance().setUserId(String.valueOf(e1.u().f13674b));
        Toolbar toolbarC = com.uz.navee.utils.c.c(this, "", 0, null);
        this.f11569d = toolbarC;
        setSupportActionBar(toolbarC);
        this.f11572g = (ImageButton) this.f11569d.findViewById(R$id.back_toolbar);
        this.f11573h = (Button) this.f11569d.findViewById(R$id.switch_toolbar);
        this.f11570e = (ImageView) this.f11569d.findViewById(R$id.logo_toolbar);
        this.f11571f = (TextView) this.f11569d.findViewById(R$id.titleView_toolbar);
        this.f11568c.setItemIconTintList(null);
        AppBarConfiguration appBarConfigurationBuild = new AppBarConfiguration.Builder(R$id.navigation_mall, R$id.navigation_device, R$id.navigation_mine).build();
        NavController navControllerFindNavController = Navigation.findNavController(this, R$id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navControllerFindNavController, appBarConfigurationBuild);
        NavigationUI.setupWithNavController(this.f11568c, navControllerFindNavController);
        navControllerFindNavController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() { // from class: com.uz.navee.a
            @Override // androidx.navigation.NavController.OnDestinationChangedListener
            public final void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle2) {
                this.f11592a.a0(navController, navDestination, bundle2);
            }
        });
        if (Build.VERSION.SDK_INT >= 35) {
            ViewUtils.doOnApplyWindowInsets(this.f11568c, new a());
            n.b(getWindow().getDecorView(), false, true);
        }
        MyApplication.f11588e = this;
        Z();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R$menu.toolbar_menu, menu);
        this.f11574i = menu.findItem(R$id.menu_scan);
        this.f11575j = menu.findItem(R$id.menu_help);
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        if (i6 != 4) {
            return super.onKeyDown(i6, keyEvent);
        }
        if (this.f11576k == BottomNavigationIndex.device && this.f11572g.getVisibility() == 0) {
            h0();
            return true;
        }
        if (System.currentTimeMillis() - this.f11580o <= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            System.exit(0);
            return true;
        }
        Toast.makeText(this, getString(R$string.toast_onKeyDown), 0).show();
        this.f11580o = System.currentTimeMillis();
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R$id.menu_scan) {
            startActivity(new Intent(this, (Class<?>) ScanCodeActivity.class));
        } else if (menuItem.getItemId() == R$id.menu_help) {
            startActivity(new Intent(this, (Class<?>) HelpActivity.class));
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        int iOrdinal = this.f11576k.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2) {
            this.f11574i.setVisible(false);
            this.f11575j.setVisible(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i6, strArr, iArr);
        EasyPermissions.d(i6, strArr, iArr, this);
        if (i6 == 303) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                J(getString(R$string.bluetoothUnavailable_unauthorized));
                return;
            }
            Intent intent = new Intent("BleOpenNotification");
            intent.putExtra("accessType", 303);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
            return;
        }
        if (i6 == 304) {
            if (A(iArr)) {
                f4.b.g("onRequestPermissionsResult: 用户允许搜索设备权限", new Object[0]);
                Intent intent2 = new Intent("LocationGrantedNotification");
                intent2.putExtra("granted", true);
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent2);
                return;
            }
            f4.b.g("onRequestPermissionsResult: 拒绝搜索设备权限", new Object[0]);
            Intent intent3 = new Intent("LocationGrantedNotification");
            intent3.putExtra("granted", false);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent3);
            return;
        }
        if (i6 == 307 || i6 == 308) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                J(getString(R$string.bluetoothUnavailable_unauthorized));
                return;
            }
            Intent intent4 = new Intent("BleOpenNotification");
            intent4.putExtra("accessType", i6);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent4);
        }
    }

    @Override // com.uz.navee.base.BaseActivity
    public boolean x() {
        return false;
    }

    @Override // com.uz.navee.base.BaseActivity
    public View z() {
        return findViewById(R$id.container);
    }
}
