package com.uz.navee.ui.device;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.clj.fastble.data.BleDevice;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.bean.EmptyResponseData;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.bean.Vehicle;
import d4.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.regex.Pattern;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class DeviceNameEditActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public ImageView f12256c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f12257d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f12258e;

    /* renamed from: f, reason: collision with root package name */
    public EditText f12259f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f12260g;

    /* renamed from: h, reason: collision with root package name */
    public BleDevice f12261h;

    /* renamed from: i, reason: collision with root package name */
    public Vehicle f12262i;

    /* renamed from: j, reason: collision with root package name */
    public final int f12263j = 24;

    public class a implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12264a;

        /* renamed from: com.uz.navee.ui.device.DeviceNameEditActivity$a$a, reason: collision with other inner class name */
        public class C0169a extends TypeToken<HttpResponse<EmptyResponseData>> {
            public C0169a() {
            }
        }

        public a(String str) {
            this.f12264a = str;
        }

        @Override // d4.d.h
        public void a(String str) {
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new C0169a().getType());
            if (httpResponse == null || httpResponse.getCode() != 200) {
                DeviceNameEditActivity.this.I(httpResponse == null ? "" : httpResponse.getMsg());
                return;
            }
            DeviceNameEditActivity.this.f12262i.vehicleName = this.f12264a;
            ArrayList arrayListE = b4.a.e();
            Iterator it = arrayListE.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Vehicle vehicle = (Vehicle) it.next();
                if (TextUtils.equals(vehicle.mac, DeviceNameEditActivity.this.f12262i.mac)) {
                    vehicle.vehicleName = this.f12264a;
                    break;
                }
            }
            b4.a.M(arrayListE);
            Intent intent = new Intent("BleVehicleUpdateNotification");
            intent.putExtra("vehicle", DeviceNameEditActivity.this.f12262i);
            LocalBroadcastManager.getInstance(DeviceNameEditActivity.this).sendBroadcast(intent);
            DeviceNameEditActivity.this.finish();
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            DeviceNameEditActivity.this.I(exc.getLocalizedMessage());
        }
    }

    private void V() {
        this.f12256c = (ImageView) findViewById(R$id.logo_toolbar);
        this.f12257d = (TextView) findViewById(R$id.titleView_toolbar);
        this.f12258e = (TextView) findViewById(R$id.tv_right_toolbar);
        this.f12259f = (EditText) findViewById(R$id.textInputEditText);
        this.f12260g = (TextView) findViewById(R$id.inputLimitsLabel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(View view) {
        a0();
    }

    public static /* synthetic */ CharSequence Y(CharSequence charSequence, int i6, int i7, Spanned spanned, int i8, int i9) {
        if (Pattern.compile("[^A-Za-z\\u4E00-\\u9FA5\\d\\s]").matcher(charSequence.toString()).find()) {
            return "";
        }
        return null;
    }

    private void a0() {
        Editable text = this.f12259f.getText();
        Objects.requireNonNull(text);
        String strTrim = text.toString().trim();
        if (strTrim.isEmpty()) {
            com.uz.navee.utils.a.b(this.f12259f);
            return;
        }
        HashMap map = new HashMap();
        map.put("mac", this.f12262i.mac);
        map.put("vehicleName", strTrim);
        d4.d.h().g(e4.a.a() + "/vehicle/updateVehicle/name", map, new a(strTrim));
    }

    @Override // com.uz.navee.base.BaseActivity
    public void E() {
        super.E();
        this.f12259f.setTextDirection(3);
        if (com.uz.navee.utils.d.p(this)) {
            this.f12259f.setGravity(8388629);
        }
    }

    public final /* synthetic */ CharSequence Z(CharSequence charSequence, int i6, int i7, Spanned spanned, int i8, int i9) {
        int iC = com.uz.navee.utils.j0.c(spanned.toString());
        int iC2 = com.uz.navee.utils.j0.c(charSequence.toString());
        int iC3 = (iC + iC2) - com.uz.navee.utils.j0.c(spanned.subSequence(i8, i9).toString());
        if (iC3 > 24) {
            return com.uz.navee.utils.j0.e(charSequence.toString(), (24 - iC3) + iC2);
        }
        return null;
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_device_name_edit);
        V();
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        if (bundleExtra != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.f12261h = (BleDevice) bundleExtra.getParcelable("bleDevice", BleDevice.class);
                this.f12262i = (Vehicle) bundleExtra.getSerializable("vehicle", Vehicle.class);
            } else {
                this.f12261h = (BleDevice) bundleExtra.getParcelable("bleDevice");
                this.f12262i = (Vehicle) bundleExtra.getSerializable("vehicle");
            }
        }
        this.f12256c.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.a6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12467a.W(view);
            }
        });
        this.f12257d.setText(R$string.name_the_device);
        this.f12258e.setText(R$string.save);
        this.f12258e.setVisibility(0);
        this.f12258e.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.b6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12477a.X(view);
            }
        });
        this.f12260g.setText(getString(R$string.input_limits_device_name).replace("10", String.valueOf(24)));
        this.f12259f.setText(this.f12262i.displayName());
        this.f12259f.setFilters(new InputFilter[]{new InputFilter() { // from class: com.uz.navee.ui.device.c6
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i6, int i7, Spanned spanned, int i8, int i9) {
                return DeviceNameEditActivity.Y(charSequence, i6, i7, spanned, i8, i9);
            }
        }, new InputFilter() { // from class: com.uz.navee.ui.device.d6
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i6, int i7, Spanned spanned, int i8, int i9) {
                return this.f12495a.Z(charSequence, i6, i7, spanned, i8, i9);
            }
        }});
        E();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.uz.navee.utils.d.l(this);
    }
}
