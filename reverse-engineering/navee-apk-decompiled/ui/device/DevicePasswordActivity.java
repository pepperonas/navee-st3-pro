package com.uz.navee.ui.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.clj.fastble.data.BleDevice;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.ui.wheel.GridCodeEditView;
import java.util.Objects;

/* loaded from: classes3.dex */
public class DevicePasswordActivity extends BaseActivity implements GridCodeEditView.a {

    /* renamed from: c, reason: collision with root package name */
    public TextView f12267c;

    /* renamed from: d, reason: collision with root package name */
    public GridCodeEditView f12268d;

    /* renamed from: e, reason: collision with root package name */
    public Button f12269e;

    /* renamed from: f, reason: collision with root package name */
    public BleDevice f12270f;

    /* renamed from: g, reason: collision with root package name */
    public int f12271g;

    /* renamed from: h, reason: collision with root package name */
    public String f12272h;

    /* renamed from: i, reason: collision with root package name */
    public final BroadcastReceiver f12273i = new b();

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f12274a;

        public a(EditText editText) {
            this.f12274a = editText;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.uz.navee.utils.t.c(this.f12274a);
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (com.uz.navee.e.c().b() instanceof DevicePasswordActivity) {
                BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
                if (bleDevice == null || DevicePasswordActivity.this.f12270f == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(DevicePasswordActivity.this.f12270f))) {
                    return;
                }
                if (intent.getIntExtra("errorCode", 0) != 0) {
                    DevicePasswordActivity devicePasswordActivity = DevicePasswordActivity.this;
                    Toast.makeText(devicePasswordActivity, devicePasswordActivity.getString(R$string.pwd_set_fail), 0).show();
                } else {
                    DevicePasswordActivity devicePasswordActivity2 = DevicePasswordActivity.this;
                    Toast.makeText(devicePasswordActivity2, devicePasswordActivity2.getString(R$string.pwd_set_success), 0).show();
                    DevicePasswordActivity.this.finish();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(View view) {
        String str;
        if (b4.a.f(this.f12270f) && (str = this.f12272h) != null && str.length() == 4 && com.uz.navee.utils.j0.b(this.f12272h)) {
            b4.a.c0(this.f12270f, b4.a.l(99, new byte[]{1, 1, Byte.parseByte(this.f12272h.substring(0, 1)), Byte.parseByte(this.f12272h.substring(1, 2)), Byte.parseByte(this.f12272h.substring(2, 3)), Byte.parseByte(this.f12272h.substring(3, 4))}, false));
        }
    }

    @Override // com.uz.navee.base.BaseActivity
    public void E() {
        super.E();
        this.f12268d.setTextDirection(3);
        this.f12268d.setLayoutDirection(0);
    }

    public final void T() {
        new Handler(Looper.getMainLooper()).postDelayed(new a(this.f12268d.getEditText()), 500L);
    }

    @Override // com.uz.navee.ui.wheel.GridCodeEditView.a
    public void d(View view, String str) {
        if (str.length() < 4) {
            this.f12269e.setEnabled(false);
            this.f12269e.setAlpha(0.3f);
        }
    }

    @Override // com.uz.navee.ui.wheel.GridCodeEditView.a
    public void k(View view, String str) {
        com.uz.navee.utils.t.a(view);
        this.f12269e.setEnabled(true);
        this.f12269e.setAlpha(1.0f);
        this.f12272h = str;
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_device_password);
        this.f12267c = (TextView) findViewById(R$id.titleLabel);
        GridCodeEditView gridCodeEditView = (GridCodeEditView) findViewById(R$id.codeEditView);
        this.f12268d = gridCodeEditView;
        gridCodeEditView.setOnCodeFinishListener(this);
        Button button = (Button) findViewById(R$id.confirmButton);
        this.f12269e = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.e6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12506a.S(view);
            }
        });
        com.uz.navee.utils.c.e(this, "", ContextCompat.getColor(this, R$color.nav_title_color));
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        if (bundleExtra != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.f12270f = (BleDevice) bundleExtra.getParcelable("bleDevice", BleDevice.class);
            } else {
                this.f12270f = (BleDevice) bundleExtra.getParcelable("bleDevice");
            }
            this.f12271g = bundleExtra.getInt("viewType", 0);
            this.f12272h = bundleExtra.getString("password", "");
        }
        int i6 = this.f12271g;
        if (i6 == 0) {
            this.f12267c.setText(R$string.pwd_set);
            T();
            this.f12269e.setEnabled(false);
            this.f12269e.setAlpha(0.3f);
        } else if (i6 == 1) {
            this.f12267c.setText(R$string.pwd_view);
            if (com.uz.navee.utils.j0.b(this.f12272h)) {
                this.f12268d.setText(this.f12272h);
            }
            this.f12268d.setEnabled(false);
            this.f12269e.setVisibility(8);
        } else if (i6 == 2) {
            this.f12267c.setText(R$string.change_pwd);
            T();
            this.f12269e.setEnabled(false);
            this.f12269e.setAlpha(0.3f);
        }
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f12273i, new IntentFilter("BleSetPasswordNotification"));
        E();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f12273i);
        super.onDestroy();
    }
}
