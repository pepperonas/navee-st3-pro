package com.uz.navee.ui.device;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.clj.fastble.data.BleDevice;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.bean.DriveHistory;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.ui.wheel.DataStatusView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class DriveHistoryActivity extends BaseActivity {
    public ImageButton A;
    public ImageButton B;
    public ImageButton C;
    public ImageButton D;
    public ImageButton E;
    public ImageButton F;
    public ImageButton G;
    public TextView H;
    public TextView I;
    public TextView J;
    public TextView L;
    public TextView M;
    public TextView Q;
    public TextView R;
    public TextView S;
    public TextView T;
    public TextView U;
    public TextView V;
    public TextView W;
    public TextView X;
    public TextView Y;
    public TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    public DataStatusView f12301a0;

    /* renamed from: b0, reason: collision with root package name */
    public ArrayList f12302b0;

    /* renamed from: c, reason: collision with root package name */
    public HorizontalScrollView f12303c;

    /* renamed from: c0, reason: collision with root package name */
    public ArrayList f12304c0;

    /* renamed from: d, reason: collision with root package name */
    public LinearLayout f12305d;

    /* renamed from: d0, reason: collision with root package name */
    public ArrayList f12306d0;

    /* renamed from: e, reason: collision with root package name */
    public TextView f12307e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f12309f;

    /* renamed from: f0, reason: collision with root package name */
    public BleDevice f12310f0;

    /* renamed from: g, reason: collision with root package name */
    public TextView f12311g;

    /* renamed from: g0, reason: collision with root package name */
    public Vehicle f12312g0;

    /* renamed from: h, reason: collision with root package name */
    public TextView f12313h;

    /* renamed from: h0, reason: collision with root package name */
    public int f12314h0;

    /* renamed from: i, reason: collision with root package name */
    public TextView f12315i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f12317j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f12319k;

    /* renamed from: l, reason: collision with root package name */
    public TextView f12321l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f12323m;

    /* renamed from: n, reason: collision with root package name */
    public LinearLayout f12324n;

    /* renamed from: o, reason: collision with root package name */
    public LinearLayout f12325o;

    /* renamed from: p, reason: collision with root package name */
    public LinearLayout f12326p;

    /* renamed from: q, reason: collision with root package name */
    public LinearLayout f12327q;

    /* renamed from: r, reason: collision with root package name */
    public LinearLayout f12328r;

    /* renamed from: s, reason: collision with root package name */
    public LinearLayout f12329s;

    /* renamed from: t, reason: collision with root package name */
    public LinearLayout f12330t;

    /* renamed from: u, reason: collision with root package name */
    public LinearLayout f12331u;

    /* renamed from: v, reason: collision with root package name */
    public LinearLayout f12332v;

    /* renamed from: w, reason: collision with root package name */
    public LinearLayout f12333w;

    /* renamed from: x, reason: collision with root package name */
    public ImageButton f12334x;

    /* renamed from: y, reason: collision with root package name */
    public ImageButton f12335y;

    /* renamed from: z, reason: collision with root package name */
    public ImageButton f12336z;

    /* renamed from: e0, reason: collision with root package name */
    public ArrayList f12308e0 = new ArrayList();

    /* renamed from: i0, reason: collision with root package name */
    public int f12316i0 = 0;

    /* renamed from: j0, reason: collision with root package name */
    public int f12318j0 = 10;

    /* renamed from: k0, reason: collision with root package name */
    public int f12320k0 = 20;

    /* renamed from: l0, reason: collision with root package name */
    public final BroadcastReceiver f12322l0 = new a();

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BleDevice bleDevice = Build.VERSION.SDK_INT >= 33 ? (BleDevice) intent.getParcelableExtra("bleDevice", BleDevice.class) : (BleDevice) intent.getParcelableExtra("bleDevice");
            if (bleDevice == null || DriveHistoryActivity.this.f12310f0 == null || !Objects.equals(b4.a.r(bleDevice), b4.a.r(DriveHistoryActivity.this.f12310f0))) {
                return;
            }
            DriveHistoryActivity.this.B();
            if (intent.getIntExtra("errorCode", 0) != 0) {
                DriveHistoryActivity.this.f12301a0.setStatus(DataStatusView.DataStatus.failure);
                DriveHistoryActivity driveHistoryActivity = DriveHistoryActivity.this;
                driveHistoryActivity.I(driveHistoryActivity.getString(R$string.drive_history_error));
                return;
            }
            DriveHistoryActivity.this.f12308e0 = (ArrayList) intent.getSerializableExtra("history");
            DriveHistoryActivity.this.f12314h0 = intent.getIntExtra("version", 0);
            DriveHistoryActivity.this.e0();
            DriveHistoryActivity.this.f0();
            if (DriveHistoryActivity.this.f12308e0.isEmpty()) {
                DriveHistoryActivity.this.f12301a0.setStatus(DataStatusView.DataStatus.empty);
            } else {
                DriveHistoryActivity.this.f12301a0.setStatus(DataStatusView.DataStatus.success);
            }
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12338a;

        public b(int i6) {
            this.f12338a = i6;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = DriveHistoryActivity.this.f12304c0.iterator();
            while (it.hasNext()) {
                ((ImageButton) it.next()).setSelected(false);
            }
            view.setSelected(true);
            DriveHistoryActivity.this.f12316i0 = this.f12338a;
            DriveHistoryActivity.this.f0();
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageButton f12340a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f12341b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f12342c;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                cVar.f12340a.setSelected(cVar.f12342c == DriveHistoryActivity.this.f12316i0);
            }
        }

        public c(ImageButton imageButton, int i6, int i7) {
            this.f12340a = imageButton;
            this.f12341b = i6;
            this.f12342c = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            int measuredWidth = this.f12340a.getMeasuredWidth();
            ViewGroup.LayoutParams layoutParams = this.f12340a.getLayoutParams();
            layoutParams.width = measuredWidth;
            layoutParams.height = this.f12341b;
            this.f12340a.setLayoutParams(layoutParams);
            this.f12340a.post(new a());
        }
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageButton f12345a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f12346b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f12347c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ View f12348d;

        public d(ImageButton imageButton, int i6, int i7, View view) {
            this.f12345a = imageButton;
            this.f12346b = i6;
            this.f12347c = i7;
            this.f12348d = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Rect rect = new Rect();
            this.f12345a.getHitRect(rect);
            rect.top -= this.f12346b - this.f12347c;
            rect.bottom += 20;
            this.f12348d.setTouchDelegate(new TouchDelegate(rect, this.f12345a));
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DriveHistoryActivity.this.f12303c.fullScroll(66);
        }
    }

    private void a0() {
        this.f12303c = (HorizontalScrollView) findViewById(R$id.stackView);
        this.f12305d = (LinearLayout) findViewById(R$id.yaxisLayout);
        this.f12307e = (TextView) findViewById(R$id.mileageLabel);
        this.f12309f = (TextView) findViewById(R$id.mileageUnitLabel);
        this.f12311g = (TextView) findViewById(R$id.durationLabel);
        this.f12313h = (TextView) findViewById(R$id.speedLabel);
        this.f12315i = (TextView) findViewById(R$id.speedUnitLabel);
        this.f12317j = (TextView) findViewById(R$id.totalTimeLabel);
        this.f12319k = (TextView) findViewById(R$id.totalTimeUnitLabel);
        this.f12321l = (TextView) findViewById(R$id.totalMileageLabel);
        this.f12323m = (TextView) findViewById(R$id.totalMileageUnitLabel);
        this.f12324n = (LinearLayout) findViewById(R$id.barLayout1);
        this.f12325o = (LinearLayout) findViewById(R$id.barLayout2);
        this.f12326p = (LinearLayout) findViewById(R$id.barLayout3);
        this.f12327q = (LinearLayout) findViewById(R$id.barLayout4);
        this.f12328r = (LinearLayout) findViewById(R$id.barLayout5);
        this.f12329s = (LinearLayout) findViewById(R$id.barLayout6);
        this.f12330t = (LinearLayout) findViewById(R$id.barLayout7);
        this.f12331u = (LinearLayout) findViewById(R$id.barLayout8);
        this.f12332v = (LinearLayout) findViewById(R$id.barLayout9);
        this.f12333w = (LinearLayout) findViewById(R$id.barLayout10);
        this.f12334x = (ImageButton) findViewById(R$id.barButton1);
        this.f12335y = (ImageButton) findViewById(R$id.barButton2);
        this.f12336z = (ImageButton) findViewById(R$id.barButton3);
        this.A = (ImageButton) findViewById(R$id.barButton4);
        this.B = (ImageButton) findViewById(R$id.barButton5);
        this.C = (ImageButton) findViewById(R$id.barButton6);
        this.D = (ImageButton) findViewById(R$id.barButton7);
        this.E = (ImageButton) findViewById(R$id.barButton8);
        this.F = (ImageButton) findViewById(R$id.barButton9);
        this.G = (ImageButton) findViewById(R$id.barButton10);
        this.H = (TextView) findViewById(R$id.yaxisLabel0);
        this.I = (TextView) findViewById(R$id.yaxisLabel0_5);
        this.J = (TextView) findViewById(R$id.yaxisLabel1);
        this.L = (TextView) findViewById(R$id.yaxisLabel1_5);
        this.M = (TextView) findViewById(R$id.yaxisLabel2);
        this.Q = (TextView) findViewById(R$id.yaxisLabel2_5);
        this.R = (TextView) findViewById(R$id.yaxisLabel3);
        this.S = (TextView) findViewById(R$id.yaxisLabel3_5);
        this.T = (TextView) findViewById(R$id.yaxisLabel4);
        this.U = (TextView) findViewById(R$id.yaxisLabel4_5);
        this.V = (TextView) findViewById(R$id.yaxisLabel5);
        this.W = (TextView) findViewById(R$id.yaxisLabel5_5);
        this.X = (TextView) findViewById(R$id.yaxisLabel6);
        this.Y = (TextView) findViewById(R$id.yaxisLabel6_5);
        this.Z = (TextView) findViewById(R$id.yaxisLabelX);
        this.f12301a0 = (DataStatusView) findViewById(R$id.statusView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(View view) {
        d0();
    }

    public final void d0() {
        if (b4.a.f(this.f12310f0)) {
            this.f12301a0.setStatus(DataStatusView.DataStatus.loading);
            K();
            b4.a.J(this.f12310f0);
        }
    }

    public final void e0() {
        ArrayList arrayList = this.f12308e0;
        if (arrayList == null || arrayList.isEmpty()) {
            Iterator it = this.f12302b0.iterator();
            while (it.hasNext()) {
                ((LinearLayout) it.next()).setVisibility(8);
            }
            Iterator it2 = this.f12306d0.iterator();
            while (it2.hasNext()) {
                ((TextView) it2.next()).setVisibility(8);
            }
            return;
        }
        int iRound = 0;
        for (int i6 = 0; i6 < this.f12308e0.size() && i6 < 10; i6++) {
            int mileage = ((DriveHistory) this.f12308e0.get(i6)).getMileage();
            if (mileage > 0) {
                this.f12316i0 = i6;
                iRound = Math.max(iRound, mileage);
            }
        }
        int mileageUnit = b4.a.W().f1933f.getMileageUnit();
        if (mileageUnit == 0) {
            iRound = (int) Math.round(iRound * 0.621d);
        }
        for (int i7 = 0; i7 < this.f12302b0.size(); i7++) {
            LinearLayout linearLayout = (LinearLayout) this.f12302b0.get(i7);
            if (i7 < this.f12308e0.size()) {
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(8);
            }
        }
        if (this.f12314h0 == 1) {
            this.f12318j0 = 100;
        }
        int i8 = this.f12318j0;
        int i9 = iRound % i8;
        int i10 = iRound / i8;
        if (i9 != 0) {
            i10++;
        }
        int i11 = i10 * i8;
        String string = getString(b4.a.W().f1933f.getMileageUnit() == 0 ? R$string.unit_mileage_imperial : R$string.unit_mileage_metric);
        this.Z.setText(this.f12314h0 == 1 ? (i11 / 10) + string : i11 + string);
        int height = this.f12303c.getHeight() - this.f12320k0;
        int i12 = i11 / this.f12318j0;
        for (int i13 = 0; i13 < this.f12306d0.size(); i13++) {
            TextView textView = (TextView) this.f12306d0.get(i13);
            if (i13 / 2 < i12) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        for (int i14 = 0; i14 < this.f12308e0.size(); i14++) {
            int mileage2 = ((DriveHistory) this.f12308e0.get(i14)).getMileage();
            if (mileage2 > 0) {
                if (mileageUnit == 0) {
                    mileage2 = (int) (mileage2 * 0.621d);
                }
                int i15 = i11 > 0 ? (int) ((height * mileage2) / i11) : 0;
                if (i14 < this.f12304c0.size()) {
                    ImageButton imageButton = (ImageButton) this.f12304c0.get(i14);
                    imageButton.setOnClickListener(new b(i14));
                    imageButton.post(new c(imageButton, i15, i14));
                    View view = (View) imageButton.getParent();
                    view.post(new d(imageButton, height, i15, view));
                }
            }
        }
        this.f12303c.post(new e());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f0() {
        /*
            r9 = this;
            r0 = 1
            java.util.ArrayList r1 = r9.f12308e0
            r2 = 0
            if (r1 == 0) goto L87
            int r1 = r1.size()
            int r3 = r9.f12316i0
            if (r1 <= r3) goto L87
            java.util.ArrayList r1 = r9.f12308e0
            java.lang.Object r1 = r1.get(r3)
            com.uz.navee.bean.DriveHistory r1 = (com.uz.navee.bean.DriveHistory) r1
            int r3 = r1.getMileage()
            float r3 = (float) r3
            int r4 = r1.getDuration()
            int r1 = r1.getAverageSpeed()
            float r1 = (float) r1
            int r5 = r9.f12314h0
            if (r5 != r0) goto L30
            double r5 = (double) r3
            r7 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r5 = r5 / r7
            float r3 = (float) r5
            double r5 = (double) r1
            double r5 = r5 / r7
            float r1 = (float) r5
        L30:
            int r1 = java.lang.Math.round(r1)
            float r1 = (float) r1
            b4.a r5 = b4.a.W()
            com.uz.navee.bean.DeviceCarInfo r5 = r5.f1933f
            int r5 = r5.getMileageUnit()
            if (r5 != 0) goto L4c
            double r5 = (double) r3
            r7 = 4603768690282470572(0x3fe3df3b645a1cac, double:0.621)
            double r5 = r5 * r7
            float r3 = (float) r5
            double r5 = (double) r1
            double r5 = r5 * r7
            float r1 = (float) r5
        L4c:
            java.util.Locale r5 = java.util.Locale.getDefault()
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r2] = r3
            java.lang.String r3 = "%.1f"
            java.lang.String r0 = java.lang.String.format(r5, r3, r0)
            java.lang.String r3 = ".0"
            boolean r3 = r0.endsWith(r3)
            if (r3 == 0) goto L6e
            java.lang.String r3 = "\\.0"
            java.lang.String[] r0 = r0.split(r3)
            r0 = r0[r2]
        L6e:
            android.widget.TextView r2 = r9.f12307e
            r2.setText(r0)
            android.widget.TextView r0 = r9.f12311g
            java.lang.String r2 = java.lang.String.valueOf(r4)
            r0.setText(r2)
            android.widget.TextView r0 = r9.f12313h
            int r1 = (int) r1
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.setText(r1)
            goto La2
        L87:
            android.widget.TextView r0 = r9.f12307e
            java.lang.String r1 = java.lang.String.valueOf(r2)
            r0.setText(r1)
            android.widget.TextView r0 = r9.f12311g
            java.lang.String r1 = java.lang.String.valueOf(r2)
            r0.setText(r1)
            android.widget.TextView r0 = r9.f12313h
            java.lang.String r1 = java.lang.String.valueOf(r2)
            r0.setText(r1)
        La2:
            int r0 = com.uz.navee.R$string.unit_mileage_metric
            java.lang.String r0 = r9.getString(r0)
            int r1 = com.uz.navee.R$string.unit_speed_metric
            java.lang.String r1 = r9.getString(r1)
            b4.a r2 = b4.a.W()
            com.uz.navee.bean.DeviceCarInfo r2 = r2.f1933f
            int r2 = r2.getMileageUnit()
            if (r2 != 0) goto Lc6
            int r0 = com.uz.navee.R$string.unit_mileage_imperial
            java.lang.String r0 = r9.getString(r0)
            int r1 = com.uz.navee.R$string.unit_speed_imperial
            java.lang.String r1 = r9.getString(r1)
        Lc6:
            android.widget.TextView r2 = r9.f12309f
            r2.setText(r0)
            android.widget.TextView r0 = r9.f12315i
            r0.setText(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uz.navee.ui.device.DriveHistoryActivity.f0():void");
    }

    public final String g0() {
        float totalMileage = b4.a.W().f1932e.getTotalMileage();
        if (b4.a.W().f1932e.getVersion() == 1) {
            totalMileage = (float) (totalMileage / 10.0d);
        }
        if (b4.a.W().f1933f.getMileageUnit() == 0) {
            totalMileage = (float) (totalMileage * 0.621d);
        }
        String str = String.format(Locale.getDefault(), "%.1f", Float.valueOf(totalMileage));
        return str.endsWith(".0") ? str.split("\\.0")[0] : str;
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(R$layout.activity_drive_history);
        a0();
        com.uz.navee.utils.c.e(this, getString(R$string.driving_history), ContextCompat.getColor(this, R$color.nav_title_color));
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        if (bundleExtra != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.f12310f0 = (BleDevice) bundleExtra.getParcelable("bleDevice", BleDevice.class);
                this.f12312g0 = (Vehicle) bundleExtra.getSerializable("vehicle", Vehicle.class);
            } else {
                this.f12310f0 = (BleDevice) bundleExtra.getParcelable("bleDevice");
                this.f12312g0 = (Vehicle) bundleExtra.getSerializable("vehicle");
            }
        }
        ArrayList arrayList = new ArrayList();
        this.f12302b0 = arrayList;
        arrayList.add(this.f12324n);
        this.f12302b0.add(this.f12325o);
        this.f12302b0.add(this.f12326p);
        this.f12302b0.add(this.f12327q);
        this.f12302b0.add(this.f12328r);
        this.f12302b0.add(this.f12329s);
        this.f12302b0.add(this.f12330t);
        this.f12302b0.add(this.f12331u);
        this.f12302b0.add(this.f12332v);
        this.f12302b0.add(this.f12333w);
        ArrayList arrayList2 = new ArrayList();
        this.f12304c0 = arrayList2;
        arrayList2.add(this.f12334x);
        this.f12304c0.add(this.f12335y);
        this.f12304c0.add(this.f12336z);
        this.f12304c0.add(this.A);
        this.f12304c0.add(this.B);
        this.f12304c0.add(this.C);
        this.f12304c0.add(this.D);
        this.f12304c0.add(this.E);
        this.f12304c0.add(this.F);
        this.f12304c0.add(this.G);
        ArrayList arrayList3 = new ArrayList();
        this.f12306d0 = arrayList3;
        arrayList3.add(this.H);
        this.f12306d0.add(this.I);
        this.f12306d0.add(this.J);
        this.f12306d0.add(this.L);
        this.f12306d0.add(this.M);
        this.f12306d0.add(this.Q);
        this.f12306d0.add(this.R);
        this.f12306d0.add(this.S);
        this.f12306d0.add(this.T);
        this.f12306d0.add(this.U);
        this.f12306d0.add(this.V);
        this.f12306d0.add(this.W);
        this.f12306d0.add(this.X);
        this.f12306d0.add(this.Y);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f12322l0, new IntentFilter("BleReadDriveHistoryNotification"));
        Vehicle vehicle = this.f12312g0;
        long jA = (vehicle == null || (str = vehicle.activateDate) == null) ? 0L : com.uz.navee.utils.l.a(com.uz.navee.utils.l.b(com.uz.navee.utils.l.g(str, "yyyy-MM-dd HH:mm:ss", "UTC").getTime(), "yyyy-MM-dd"));
        this.f12317j.setText(String.valueOf(jA));
        String string = getString(jA > 1 ? R$string.unit_day_plural : R$string.unit_day_singular);
        if (com.uz.navee.utils.d.e().startsWith("ru")) {
            if (jA > 1) {
                int i6 = (int) (jA % 10);
                string = (i6 == 1 || i6 == 2 || i6 == 3 || i6 == 4) ? "дня" : getString(R$string.unit_day_plural);
            } else {
                string = getString(R$string.unit_day_singular);
            }
        }
        this.f12319k.setText(string);
        this.f12321l.setText(g0());
        String string2 = getString(b4.a.W().f1933f.getMileageUnit() == 0 ? R$string.unit_mileage_imperial : R$string.unit_mileage_metric);
        this.f12323m.setText(string2);
        for (int i7 = 0; i7 < this.f12306d0.size(); i7++) {
            ((TextView) this.f12306d0.get(i7)).setText((i7 * 5) + string2);
        }
        this.f12301a0.setStatus(DataStatusView.DataStatus.empty);
        this.f12301a0.setActionButtonClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.s6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12649a.c0(view);
            }
        });
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f12322l0);
        super.onDestroy();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        d0();
    }
}
