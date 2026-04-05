package com.uz.navee.ui.device;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;
import com.clj.fastble.data.BleDevice;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.bean.DeviceCarInfo;
import com.uz.navee.ui.device.AmbientModeAdapter;
import com.uz.navee.ui.wheel.AlertPopup;
import com.uz.navee.ui.wheel.BottomCropImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class AmbientLightActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public TextView f11704c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f11705d;

    /* renamed from: e, reason: collision with root package name */
    public SwitchCompat f11706e;

    /* renamed from: f, reason: collision with root package name */
    public BottomCropImage f11707f;

    /* renamed from: g, reason: collision with root package name */
    public TabLayout f11708g;

    /* renamed from: h, reason: collision with root package name */
    public ViewPager2 f11709h;

    /* renamed from: i, reason: collision with root package name */
    public View f11710i;

    /* renamed from: j, reason: collision with root package name */
    public BleDevice f11711j;

    /* renamed from: k, reason: collision with root package name */
    public AmbientModeAdapter f11712k;

    /* renamed from: l, reason: collision with root package name */
    public int f11713l = 0;

    /* renamed from: m, reason: collision with root package name */
    public final int[][] f11714m = {new int[]{1, 4, 7, 10}, new int[]{2, 5, 8, 11, 14}, new int[]{3, 6, 9, 12, 13}, new int[]{15}};

    /* renamed from: n, reason: collision with root package name */
    public int[] f11715n = {0, 0};

    /* renamed from: o, reason: collision with root package name */
    public PropertyChangeListener f11716o;

    public class a implements AmbientModeAdapter.b {
        public a() {
        }

        @Override // com.uz.navee.ui.device.AmbientModeAdapter.b
        public void a(int i6) throws Resources.NotFoundException {
            if (i6 == AmbientLightActivity.this.f11715n[0]) {
                int ambientLight = b4.a.W().f1933f.getAmbientLight();
                int i7 = ambientLight & 15;
                for (int i8 : AmbientLightActivity.this.f11714m[i6]) {
                    if (i8 == i7) {
                        AmbientLightActivity.this.g0(ambientLight);
                        return;
                    }
                }
            }
        }

        @Override // com.uz.navee.ui.device.AmbientModeAdapter.b
        public void b(int i6, int i7) throws IOException {
            AmbientLightActivity.this.h0(AmbientLightActivity.this.f11714m[i6][i7]);
        }
    }

    public class b extends ViewPager2.OnPageChangeCallback {
        public b() {
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

    private void Y() {
        this.f11704c = (TextView) findViewById(R$id.switchTitleLabel);
        this.f11705d = (TextView) findViewById(R$id.switchSubTitleLabel);
        this.f11706e = (SwitchCompat) findViewById(R$id.mSwitch);
        this.f11707f = (BottomCropImage) findViewById(R$id.vehicleImageView);
        this.f11708g = (TabLayout) findViewById(R$id.modeTabLayout);
        this.f11709h = (ViewPager2) findViewById(R$id.colorViewPager);
        this.f11710i = findViewById(R$id.lightSelectForegroundView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(PropertyChangeEvent propertyChangeEvent) throws Resources.NotFoundException {
        if ("ambientLight".equals(propertyChangeEvent.getPropertyName())) {
            g0(b4.a.W().f1933f.getAmbientLight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(CompoundButton compoundButton, boolean z6) throws IOException {
        if (z6 == (((b4.a.W().f1933f.getAmbientLight() & 240) >> 4) != 0)) {
            return;
        }
        if (!z6) {
            h0(0);
        } else {
            h0(this.f11713l);
            AlertPopup.Q(this, getResources().getString(R$string.kind_tips), getResources().getString(R$string.ambient_light_tips), null, getResources().getString(R$string.i_see), new AlertPopup.a() { // from class: com.uz.navee.ui.device.k
                @Override // com.uz.navee.ui.wheel.AlertPopup.a
                public /* synthetic */ void a() {
                    j4.c.a(this);
                }

                @Override // com.uz.navee.ui.wheel.AlertPopup.a
                public final void b() {
                    AmbientLightActivity.b0();
                }
            });
        }
    }

    public static /* synthetic */ void d0(String[] strArr, TabLayout.Tab tab, int i6) {
        tab.setText(strArr[i6]);
    }

    private void e0(DeviceCarInfo deviceCarInfo) {
        this.f11716o = deviceCarInfo.addListener("ambientLight", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.l
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) throws Resources.NotFoundException {
                this.f12572a.a0(propertyChangeEvent);
            }
        });
    }

    private void f0() {
        if (b4.a.f(this.f11711j)) {
            b4.a.G(this.f11711j);
        }
    }

    private void i0(DeviceCarInfo deviceCarInfo) {
        deviceCarInfo.removeListener("ambientLight", this.f11716o);
    }

    public final int[] Z() {
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int[][] iArr = this.f11714m;
            if (i6 >= iArr.length) {
                return new int[]{i7, i8};
            }
            int[] iArr2 = iArr[i6];
            int i9 = 0;
            while (true) {
                if (i9 >= iArr2.length) {
                    break;
                }
                if (iArr2[i9] == this.f11713l) {
                    i7 = i6;
                    i8 = i9;
                    break;
                }
                i9++;
            }
            i6++;
        }
    }

    public final void g0(int i6) throws Resources.NotFoundException {
        boolean z6 = ((i6 & 240) >> 4) != 0;
        int i7 = i6 & 15;
        this.f11713l = i7;
        if (i7 == 0) {
            this.f11713l = 1;
        }
        this.f11706e.setChecked(z6);
        this.f11705d.setText(getString(z6 ? R$string.opened : R$string.closed));
        if (z6) {
            int i8 = this.f11713l;
            if (i8 <= 3) {
                this.f11707f.setImageDrawable(ContextCompat.getDrawable(this, R$mipmap.img_ambient_red_st3p));
            } else if (i8 <= 6) {
                this.f11707f.setImageDrawable(ContextCompat.getDrawable(this, R$mipmap.img_ambient_green_st3p));
            } else if (i8 <= 9) {
                this.f11707f.setImageDrawable(ContextCompat.getDrawable(this, R$mipmap.img_ambient_blue_st3p));
            } else if (i8 <= 12) {
                this.f11707f.setImageDrawable(ContextCompat.getDrawable(this, R$mipmap.img_ambient_purple_st3p));
            } else if (i8 <= 15) {
                this.f11707f.setImageDrawable(ContextCompat.getDrawable(this, R$mipmap.img_ambient_colors_st3p));
            }
        } else {
            this.f11707f.setImageDrawable(ContextCompat.getDrawable(this, R$mipmap.img_ambient_close_st3p));
        }
        this.f11710i.setVisibility(z6 ? 8 : 0);
        this.f11710i.setOnClickListener(null);
        int[] iArrZ = Z();
        this.f11715n = iArrZ;
        TabLayout.Tab tabAt = this.f11708g.getTabAt(iArrZ[0]);
        if (tabAt != null) {
            tabAt.select();
        }
        for (AmbientModeFragment ambientModeFragment : this.f11712k.f11758b.values()) {
            int[] iArr = this.f11715n;
            ambientModeFragment.m(iArr[0], iArr[1]);
        }
    }

    public final void h0(int i6) throws IOException {
        if (b4.a.f(this.f11711j)) {
            b4.a.c0(this.f11711j, b4.a.k(94, i6, false));
        }
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_ambient_light);
        getWindow().setBackgroundDrawable(ContextCompat.getDrawable(this, R$mipmap.bg_ambient));
        Y();
        com.uz.navee.utils.c.e(this, getString(R$string.ambient_light), ContextCompat.getColor(this, R$color.nav_title_color));
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        if (bundleExtra != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.f11711j = (BleDevice) bundleExtra.getParcelable("bleDevice", BleDevice.class);
            } else {
                this.f11711j = (BleDevice) bundleExtra.getParcelable("bleDevice");
            }
        }
        this.f11706e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.i
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) throws IOException {
                this.f12544a.c0(compoundButton, z6);
            }
        });
        AmbientModeAdapter ambientModeAdapter = new AmbientModeAdapter(this);
        this.f11712k = ambientModeAdapter;
        ambientModeAdapter.f11757a = new a();
        this.f11709h.setAdapter(this.f11712k);
        this.f11709h.registerOnPageChangeCallback(new b());
        final String[] strArr = {getString(R$string.always_on), getString(R$string.breathing), getString(R$string.flowing_water), getString(R$string.horse_racing)};
        new TabLayoutMediator(this.f11708g, this.f11709h, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.uz.navee.ui.device.j
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i6) {
                AmbientLightActivity.d0(strArr, tab, i6);
            }
        }).attach();
        e0(b4.a.W().f1933f);
        f0();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        i0(b4.a.W().f1933f);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() throws Resources.NotFoundException {
        super.onStart();
        g0(b4.a.W().f1933f.getAmbientLight());
    }
}
