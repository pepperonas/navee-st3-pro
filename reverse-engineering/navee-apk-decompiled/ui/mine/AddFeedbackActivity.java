package com.uz.navee.ui.mine;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.ui.device.DeviceListActivity;
import com.uz.navee.ui.mine.AddFeedbackActivity;
import com.uz.navee.ui.mine.adapter.PhotoAdapter;
import com.uz.navee.ui.mine.bean.AttachmentItem;
import com.uz.navee.ui.mine.bean.BaseBean;
import com.uz.navee.ui.mine.bean.UploadBean;
import com.uz.navee.ui.wheel.AlertPopup;
import com.uz.navee.ui.wheel.GridItemDecoration;
import com.uz.navee.utils.DensityUtil;
import com.uz.navee.utils.c0;
import com.uz.navee.utils.h0;
import com.uz.navee.utils.j0;
import com.uz.navee.utils.l;
import com.uz.navee.utils.o;
import com.uz.navee.utils.q;
import com.uz.navee.utils.y;
import com.zhongjh.common.entity.LocalMedia;
import com.zhongjh.common.enums.MimeType;
import com.zhongjh.multimedia.settings.CameraSetting;
import com.zhongjh.multimedia.settings.GlobalSetting;
import com.zhongjh.multimedia.settings.MultiMediaSetting;
import d4.d;
import g4.e1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class AddFeedbackActivity extends BaseActivity {
    public GridLayoutManager A;
    public d4.d C;
    public Pair D;
    public boolean J;
    public Pair L;
    public AttachmentItem M;
    public ActivityResultLauncher Q;
    public ActivityResultLauncher R;
    public ActivityResultLauncher S;
    public ActivityResultLauncher T;
    public ActivityResultLauncher U;

    /* renamed from: d, reason: collision with root package name */
    public ScrollView f12930d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f12931e;

    /* renamed from: f, reason: collision with root package name */
    public View f12932f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f12933g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f12934h;

    /* renamed from: i, reason: collision with root package name */
    public View f12935i;

    /* renamed from: j, reason: collision with root package name */
    public EditText f12936j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f12937k;

    /* renamed from: l, reason: collision with root package name */
    public EditText f12938l;

    /* renamed from: m, reason: collision with root package name */
    public Button f12939m;

    /* renamed from: n, reason: collision with root package name */
    public RecyclerView f12940n;

    /* renamed from: o, reason: collision with root package name */
    public LinearLayout f12941o;

    /* renamed from: p, reason: collision with root package name */
    public LinearLayout f12942p;

    /* renamed from: q, reason: collision with root package name */
    public ImageView f12943q;

    /* renamed from: r, reason: collision with root package name */
    public LinearLayout f12944r;

    /* renamed from: s, reason: collision with root package name */
    public ConstraintLayout f12945s;

    /* renamed from: t, reason: collision with root package name */
    public EditText f12946t;

    /* renamed from: u, reason: collision with root package name */
    public EditText f12947u;

    /* renamed from: v, reason: collision with root package name */
    public TextView f12948v;

    /* renamed from: w, reason: collision with root package name */
    public RadioGroup f12949w;

    /* renamed from: x, reason: collision with root package name */
    public ImageView f12950x;

    /* renamed from: y, reason: collision with root package name */
    public TextView f12951y;

    /* renamed from: z, reason: collision with root package name */
    public PhotoAdapter f12952z;

    /* renamed from: c, reason: collision with root package name */
    public int f12929c = 1;
    public List B = new ArrayList();
    public String E = "";
    public String F = "";
    public String G = "";
    public ArrayList H = new ArrayList();
    public boolean I = false;

    public static class CountrySelectContract extends ActivityResultContract<String, Pair<String, String>> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Pair parseResult(int i6, Intent intent) {
            if (i6 != -1 || intent == null) {
                return null;
            }
            return new Pair(intent.getStringExtra("areaCode"), intent.getStringExtra("areaName"));
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, String str) {
            Intent intent = new Intent(context, (Class<?>) RegionSettingActivity.class);
            intent.putExtra("selectable", true);
            intent.putExtra("selectedCode", str);
            return intent;
        }
    }

    public static class VehicleSelectContract extends ActivityResultContract<String, Pair<String, String>> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Pair parseResult(int i6, Intent intent) {
            if (i6 != -1 || intent == null) {
                return null;
            }
            return new Pair(intent.getStringExtra("mac"), intent.getStringExtra(AppMeasurementSdk.ConditionalUserProperty.NAME));
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, String str) {
            Intent intent = new Intent(context, (Class<?>) DeviceListActivity.class);
            intent.putExtra("selectable", true);
            intent.putExtra("selectedMac", str);
            return intent;
        }
    }

    public class a extends c0 {
        public a() {
        }

        @Override // com.uz.navee.utils.c0
        public void a(View view) {
            AddFeedbackActivity.this.M0();
        }
    }

    public class b implements PhotoAdapter.c {

        public class a implements DialogInterface.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f12955a;

            public a(int i6) {
                this.f12955a = i6;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i6) {
                AddFeedbackActivity.this.B.remove(this.f12955a);
                AddFeedbackActivity.this.f12952z.notifyDataSetChanged();
            }
        }

        /* renamed from: com.uz.navee.ui.mine.AddFeedbackActivity$b$b, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0181b implements DialogInterface.OnClickListener {
            public DialogInterfaceOnClickListenerC0181b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i6) {
            }
        }

        public b() {
        }

        @Override // com.uz.navee.ui.mine.adapter.PhotoAdapter.c
        public void a(View view, int i6) {
            AddFeedbackActivity addFeedbackActivity = AddFeedbackActivity.this;
            if (addFeedbackActivity.I) {
                return;
            }
            addFeedbackActivity.I = true;
            Uri uri = ((AttachmentItem) addFeedbackActivity.B.get(i6)).uri;
            if (!o.i(AddFeedbackActivity.this, uri)) {
                Intent intent = new Intent(AddFeedbackActivity.this, (Class<?>) OpenPictureActivity.class);
                intent.putExtra("uri", uri.toString());
                AddFeedbackActivity.this.startActivity(intent);
            } else {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setDataAndType(uri, "video/*");
                intent2.addFlags(1);
                AddFeedbackActivity.this.startActivity(intent2);
            }
        }

        @Override // com.uz.navee.ui.mine.adapter.PhotoAdapter.c
        public void b(View view, int i6) {
            AlertDialog.Builder builder = new AlertDialog.Builder(AddFeedbackActivity.this);
            builder.setTitle(R$string.delete);
            builder.setMessage(R$string.alert_delete_photo);
            builder.setPositiveButton(AddFeedbackActivity.this.getString(R$string.confirm), new a(i6));
            builder.setNegativeButton(AddFeedbackActivity.this.getString(R$string.cancel), new DialogInterfaceOnClickListenerC0181b());
            builder.show();
        }
    }

    public class c extends c0 {
        public c() {
        }

        @Override // com.uz.navee.utils.c0
        public void a(View view) {
            AddFeedbackActivity.this.L0(false, "", true);
        }
    }

    public class d extends c0 {
        public d() {
        }

        @Override // com.uz.navee.utils.c0
        public void a(View view) {
            if (AddFeedbackActivity.this.S != null) {
                AddFeedbackActivity.this.S.launch(AddFeedbackActivity.this.L != null ? (String) AddFeedbackActivity.this.L.first : y.a());
            }
        }
    }

    public class e extends c0 {
        public e() {
        }

        @Override // com.uz.navee.utils.c0
        public void a(View view) {
            if (AddFeedbackActivity.this.M != null) {
                AddFeedbackActivity.this.K0();
            } else if (AddFeedbackActivity.this.U != null) {
                AddFeedbackActivity.this.U.launch(new String[]{"image/*", "application/pdf"});
            }
        }
    }

    public class f implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachmentItem f12961a;

        public f(AttachmentItem attachmentItem) {
            this.f12961a = attachmentItem;
        }

        @Override // d4.d.h
        public void a(String str) {
            AddFeedbackActivity.this.B();
            UploadBean uploadBean = (UploadBean) q.a(str, UploadBean.class);
            if (uploadBean == null || uploadBean.getCode() != 200) {
                return;
            }
            this.f12961a.uploadStr = uploadBean.getData().getUrl();
            AddFeedbackActivity.this.O0();
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            AddFeedbackActivity.this.B();
            Toast.makeText(AddFeedbackActivity.this, exc.getMessage(), 0).show();
        }
    }

    public class g implements d.h {
        public g() {
        }

        @Override // d4.d.h
        public void a(String str) {
            AddFeedbackActivity.this.B();
            BaseBean baseBean = (BaseBean) q.a(str, BaseBean.class);
            if (baseBean != null) {
                if (baseBean.getCode() != 200) {
                    AddFeedbackActivity.this.I(baseBean.getMsg());
                } else {
                    AddFeedbackActivity.this.M("");
                    AddFeedbackActivity.this.finish();
                }
            }
        }

        @Override // d4.d.h
        public void b(Exception exc) {
            AddFeedbackActivity.this.B();
            Toast.makeText(AddFeedbackActivity.this, exc.getMessage(), 0).show();
        }
    }

    public static void D0(Context context, int i6) {
        Intent intent = new Intent(context, (Class<?>) AddFeedbackActivity.class);
        intent.putExtra("FEEDBACK_TYPE", i6);
        context.startActivity(intent);
    }

    private void H0() {
        try {
            CameraSetting cameraSetting = new CameraSetting();
            cameraSetting.mimeTypeSet(MimeType.ofAll());
            GlobalSetting globalSettingChoose = MultiMediaSetting.from(this).choose(MimeType.ofAll());
            globalSettingChoose.cameraSetting(cameraSetting);
            globalSettingChoose.maxSelectablePerMediaType(null, 1, 1, 0, 0, 0, 0).isImageEdit(false).forResult(this.R);
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(boolean z6, CharSequence charSequence, boolean z7) {
        QMUIBottomSheet.e eVar = new QMUIBottomSheet.e(this);
        ((QMUIBottomSheet.e) ((QMUIBottomSheet.e) ((QMUIBottomSheet.e) ((QMUIBottomSheet.e) ((QMUIBottomSheet.e) eVar.q(z6).l(QMUISkinManager.e(this))).m(charSequence)).i(true)).k(getString(R$string.cancel))).j(z7)).r(false).s(new QMUIBottomSheet.e.c() { // from class: h4.v
            @Override // com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet.e.c
            public final void a(QMUIBottomSheet qMUIBottomSheet, View view, int i6, String str) {
                this.f13829a.C0(qMUIBottomSheet, view, i6, str);
            }
        });
        eVar.p(getString(R$string.select_from_album), "1");
        eVar.p(getString(R$string.take_picture), "2");
        eVar.a().show();
    }

    private void initView() {
        boolean booleanExtra = getIntent().getBooleanExtra("unread", false);
        this.J = booleanExtra;
        if (booleanExtra) {
            this.f12935i.setVisibility(0);
        }
        if (this.f12929c == 2) {
            this.f12933g.setText(getString(R$string.feedback_quality));
        } else {
            this.f12933g.setText(getString(R$string.feedback_usage));
        }
        this.f12931e.setOnClickListener(new View.OnClickListener() { // from class: h4.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13815a.s0(view);
            }
        });
        this.f12932f.setOnClickListener(new View.OnClickListener() { // from class: h4.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13818a.t0(view);
            }
        });
        this.f12948v.setOnClickListener(new d());
        this.f12949w.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: h4.t
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i6) {
                this.f13821a.v0(radioGroup, i6);
            }
        });
        this.f12950x.setOnClickListener(new e());
        final TextView textView = (TextView) findViewById(R$id.tv_amount);
        StringBuilder sb = new StringBuilder();
        sb.append("0/");
        final int i6 = 1000;
        sb.append(1000);
        textView.setText(sb.toString());
        this.f12938l.setFilters(new InputFilter[]{new InputFilter() { // from class: h4.u
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i7, int i8, Spanned spanned, int i9, int i10) {
                return AddFeedbackActivity.w0(i6, textView, charSequence, i7, i8, spanned, i9, i10);
            }
        }});
    }

    private void l0() {
        this.f12930d = (ScrollView) findViewById(R$id.scrollView);
        this.f12931e = (ImageView) findViewById(R$id.logo_toolbar);
        this.f12932f = findViewById(R$id.lyVehicle);
        this.f12933g = (TextView) findViewById(R$id.titleView_toolbar);
        this.f12934h = (TextView) findViewById(R$id.tv_right_toolbar);
        this.f12935i = findViewById(R$id.tag_red_toolbar);
        this.f12936j = (EditText) findViewById(R$id.et_title);
        this.f12937k = (TextView) findViewById(R$id.tvVehicleName);
        this.f12938l = (EditText) findViewById(R$id.et_question_msg);
        this.f12939m = (Button) findViewById(R$id.btn_submit);
        this.f12940n = (RecyclerView) findViewById(R$id.rv_photo);
        this.f12941o = (LinearLayout) findViewById(R$id.llayout_title);
        this.f12942p = (LinearLayout) findViewById(R$id.llayout_msg);
        this.f12943q = (ImageView) findViewById(R$id.vehicleIndicator);
        this.f12944r = (LinearLayout) findViewById(R$id.ll_has_invoice);
        this.f12945s = (ConstraintLayout) findViewById(R$id.cl_invoice_file);
        this.f12946t = (EditText) findViewById(R$id.et_channel);
        this.f12947u = (EditText) findViewById(R$id.et_input_email);
        this.f12951y = (TextView) findViewById(R$id.tv_invoice_title);
        this.f12950x = (ImageView) findViewById(R$id.iv_invoice_operator);
        this.f12944r = (LinearLayout) findViewById(R$id.ll_has_invoice);
        this.f12948v = (TextView) findViewById(R$id.tv_country);
        this.f12949w = (RadioGroup) findViewById(R$id.rg_invoice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(View view) {
        N0();
    }

    public static /* synthetic */ CharSequence w0(int i6, TextView textView, CharSequence charSequence, int i7, int i8, Spanned spanned, int i9, int i10) {
        int iC = j0.c(spanned.toString());
        int iC2 = j0.c(charSequence.toString());
        int iC3 = (iC + iC2) - j0.c(spanned.subSequence(i9, i10).toString());
        if (iC3 <= i6) {
            textView.setText(iC3 + RemoteSettings.FORWARD_SLASH_STRING + i6);
            return null;
        }
        String strE = j0.e(charSequence.toString(), (i6 - iC3) + iC2);
        textView.setText(i6 + RemoteSettings.FORWARD_SLASH_STRING + i6);
        return strE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1 && activityResult.getData() != null) {
            ArrayList<LocalMedia> arrayListObtainLocalMediaResult = MultiMediaSetting.obtainLocalMediaResult(activityResult.getData());
            if (arrayListObtainLocalMediaResult.isEmpty()) {
                return;
            }
            q0(Uri.parse(arrayListObtainLocalMediaResult.get(0).getUri()));
        }
    }

    public final /* synthetic */ void A0(Uri uri) {
        if (uri != null) {
            getContentResolver().takePersistableUriPermission(uri, 1);
            this.M = new AttachmentItem(uri);
            this.f12950x.setImageResource(R$mipmap.ic_device_delete);
            this.f12951y.setText(o.f(this, uri));
        }
    }

    public final /* synthetic */ void B0() {
        this.M = null;
        this.f12950x.setImageResource(R$mipmap.ic_share_add);
        this.f12951y.setText(getString(R$string.invoice_des));
    }

    public final /* synthetic */ void C0(QMUIBottomSheet qMUIBottomSheet, View view, int i6, String str) {
        qMUIBottomSheet.dismiss();
        if (str.equals("1")) {
            if (F0()) {
                return;
            }
            G0();
        } else if (str.equals("2")) {
            H0();
        }
    }

    @Override // com.uz.navee.base.BaseActivity
    public void E() {
        super.E();
        this.f12936j.setTextDirection(3);
        this.f12938l.setTextDirection(3);
        if (com.uz.navee.utils.d.p(this)) {
            this.f12936j.setGravity(8388629);
            this.f12938l.setGravity(8388629);
            this.f12931e.setImageDrawable(com.uz.navee.utils.d.q(ContextCompat.getDrawable(this, R$mipmap.ic_nav_back)));
            this.f12943q.setImageDrawable(com.uz.navee.utils.d.q(ContextCompat.getDrawable(this, R$mipmap.ic_cell_accessory_m)));
        }
    }

    public final void E0(View view) {
        com.uz.navee.utils.a.b(view);
        O();
        h0.a(this.f12930d, view);
    }

    public final boolean F0() {
        ActivityResultLauncher activityResultLauncher = this.Q;
        if (activityResultLauncher == null) {
            return false;
        }
        activityResultLauncher.launch(new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE).build());
        return true;
    }

    public final void G0() {
        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, CameraAccessExceptionCompat.CAMERA_UNAVAILABLE_DO_NOT_DISTURB);
        }
    }

    public final void I0() {
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < this.B.size(); i6++) {
            sb.append(((AttachmentItem) this.B.get(i6)).uploadStr);
            if (i6 < this.B.size() - 1) {
                sb.append("$");
            }
        }
        HashMap map = new HashMap();
        Pair pair = this.D;
        map.put("mac", pair == null ? "" : pair.first);
        map.put("title", this.E);
        map.put("createDate", l.b(System.currentTimeMillis(), null));
        map.put("context", this.G);
        map.put("opinionTypeId", Integer.valueOf(this.f12929c));
        map.put("imgs", sb.toString());
        map.put("areaKey", this.L.first);
        map.put("contactEmail", this.f12947u.getText().toString());
        AttachmentItem attachmentItem = this.M;
        map.put("invoiceUrl", attachmentItem != null ? attachmentItem.uploadStr : "");
        map.put("purchaseChannel", this.f12946t.getText().toString());
        String str = e4.a.a() + "/feedback";
        K();
        this.C.g(str, map, new g());
    }

    public final void J0(Pair pair) {
        this.D = pair;
        if (pair != null) {
            this.f12937k.setText(((String) this.D.second) + "(" + ((String) this.D.first) + ")");
        }
    }

    public final void K0() {
        AlertPopup.Q(this, getString(R$string.action_prompt), getString(R$string.alert_delete_invoice), getString(R$string.confirm), getString(R$string.cancel), new AlertPopup.a() { // from class: h4.m
            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public /* synthetic */ void a() {
                j4.c.a(this);
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public final void b() {
                this.f13802a.B0();
            }
        });
    }

    public final void M0() {
        this.E = this.f12936j.getText().toString();
        this.G = this.f12938l.getText().toString();
        String string = this.f12947u.getText().toString();
        String string2 = this.f12946t.getText().toString();
        if (TextUtils.isEmpty(this.E)) {
            E0(this.f12941o);
            return;
        }
        if (TextUtils.isEmpty(this.G)) {
            E0(this.f12942p);
            return;
        }
        if (TextUtils.isEmpty(string)) {
            E0(this.f12947u);
            return;
        }
        int i6 = this.f12929c;
        if (i6 == 2 && this.D == null) {
            E0(this.f12932f);
            return;
        }
        if (i6 == 2 && TextUtils.isEmpty(string2)) {
            E0(this.f12946t);
        } else if (this.f12929c == 2 && this.f12949w.getCheckedRadioButtonId() == R$id.rb_has && this.M == null) {
            E0(this.f12945s);
        } else {
            O0();
        }
    }

    public final void N0() {
        ActivityResultLauncher activityResultLauncher = this.T;
        if (activityResultLauncher != null) {
            Pair pair = this.D;
            activityResultLauncher.launch(pair != null ? (String) pair.first : "");
        }
    }

    public void O0() {
        AttachmentItem attachmentItem;
        Iterator it = this.B.iterator();
        while (true) {
            if (!it.hasNext()) {
                attachmentItem = null;
                break;
            } else {
                attachmentItem = (AttachmentItem) it.next();
                if (attachmentItem.uploadStr == null) {
                    break;
                }
            }
        }
        if (attachmentItem == null && (this.f12949w.getCheckedRadioButtonId() == R$id.rb_not || (attachmentItem = this.M) == null || attachmentItem.uploadStr != null)) {
            I0();
            return;
        }
        String str = e4.a.a() + "/upload2";
        K();
        this.C.l(str, attachmentItem.uri, new f(attachmentItem));
    }

    public void initData() {
        String strA = y.a();
        String displayCountry = new Locale(com.uz.navee.utils.d.f(), strA).getDisplayCountry();
        this.L = new Pair(strA, displayCountry);
        this.f12948v.setText(displayCountry);
        String email = e1.u().f13675c.getEmail();
        if (!TextUtils.isEmpty(email)) {
            this.f12947u.setText(email);
        }
        ArrayList arrayListE = b4.a.e();
        if (arrayListE == null || arrayListE.isEmpty()) {
            return;
        }
        Vehicle vehicle = (Vehicle) arrayListE.get(arrayListE.size() - 1);
        J0(new Pair(vehicle.mac, vehicle.displayName()));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i6, int i7, Intent intent) {
        super.onActivityResult(i6, i7, intent);
        if (i7 == -1 && intent != null && i6 == 10001) {
            try {
                q0(intent.getData());
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        }
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_add_feedback);
        l0();
        this.C = d4.d.h();
        this.f12929c = getIntent().getIntExtra("FEEDBACK_TYPE", 1);
        if (ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(this)) {
            this.Q = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: h4.k
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    this.f13795a.q0((Uri) obj);
                }
            });
        }
        this.R = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: h4.n
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.f13805a.x0((ActivityResult) obj);
            }
        });
        this.S = registerForActivityResult(new CountrySelectContract(), new ActivityResultCallback() { // from class: h4.o
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.f13809a.y0((Pair) obj);
            }
        });
        this.T = registerForActivityResult(new VehicleSelectContract(), new ActivityResultCallback() { // from class: h4.p
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.f13812a.z0((Pair) obj);
            }
        });
        this.U = registerForActivityResult(new ActivityResultContracts.OpenDocument(), new ActivityResultCallback() { // from class: h4.q
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.f13814a.A0((Uri) obj);
            }
        });
        initView();
        r0();
        initData();
        this.f12939m.setOnClickListener(new a());
        E();
        if (this.f12929c == 1) {
            this.f12944r.setVisibility(8);
            this.f12946t.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i6, strArr, iArr);
        for (int i7 = 0; i7 < strArr.length; i7++) {
            int i8 = iArr[i7];
        }
        if (i6 == 306) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                J(getString(R$string.camera_no_auth1));
            } else {
                H0();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.I = false;
    }

    public final void q0(Uri uri) {
        if (uri == null) {
            return;
        }
        Iterator it = this.B.iterator();
        while (it.hasNext()) {
            if (((AttachmentItem) it.next()).uri.equals(uri)) {
                Toast.makeText(this, getString(R$string.picture_exists), 0).show();
                return;
            }
        }
        this.B.add(new AttachmentItem(uri));
        this.f12952z.notifyDataSetChanged();
    }

    public final void r0() {
        this.f12952z = new PhotoAdapter(this.B, this);
        this.A = new GridLayoutManager(this, 3);
        this.f12952z.setOnItemClickListener(new b());
        this.f12952z.setOnAddClickListener(new c());
        this.f12940n.setLayoutManager(this.A);
        this.f12940n.setAdapter(this.f12952z);
        this.f12940n.addItemDecoration(new GridItemDecoration(3, DensityUtil.a(this, 15.0f), 0));
    }

    public final /* synthetic */ void s0(View view) {
        finish();
    }

    public final /* synthetic */ void u0() {
        h0.a(this.f12930d, this.f12945s);
    }

    public final /* synthetic */ void v0(RadioGroup radioGroup, int i6) {
        this.f12945s.setVisibility(i6 == R$id.rb_has ? 0 : 8);
        if (this.f12945s.getVisibility() == 0) {
            this.f12945s.post(new Runnable() { // from class: h4.l
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13799a.u0();
                }
            });
        }
    }

    public final /* synthetic */ void y0(Pair pair) {
        if (pair != null) {
            this.L = pair;
            this.f12948v.setText((CharSequence) pair.second);
        }
    }

    public final /* synthetic */ void z0(Pair pair) {
        if (pair != null) {
            J0(pair);
        }
    }
}
