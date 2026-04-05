package com.uz.navee.ui.device;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.clj.fastble.data.BleDevice;
import com.google.android.material.tabs.TabLayout;
import com.uz.navee.R$array;
import com.uz.navee.R$drawable;
import com.uz.navee.R$layout;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseBindingActivity;
import com.uz.navee.base.ViewHolder;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.databinding.ActivityAmbientLightV3Binding;
import com.uz.navee.databinding.ItemAmbientColorBinding;
import com.uz.navee.ui.device.AmbientLightV3Activity;
import com.uz.navee.utils.CommonExt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class AmbientLightV3Activity extends BaseBindingActivity<ActivityAmbientLightV3Binding> {

    /* renamed from: p, reason: collision with root package name */
    public static final b f11740p = new b(null);

    /* renamed from: g, reason: collision with root package name */
    public List f11741g;

    /* renamed from: h, reason: collision with root package name */
    public List f11742h;

    /* renamed from: i, reason: collision with root package name */
    public final kotlin.f f11743i = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.AmbientLightV3Activity$generalAdapter$2
        {
            super(0);
        }

        @Override // q5.a
        public final AmbientLightV3Activity.ColorAdapter invoke() {
            AmbientLightV3Activity ambientLightV3Activity = this.this$0;
            List list = ambientLightV3Activity.f11741g;
            if (list == null) {
                kotlin.jvm.internal.y.x("generalColorList");
                list = null;
            }
            return new AmbientLightV3Activity.ColorAdapter(ambientLightV3Activity, list, false);
        }
    });

    /* renamed from: j, reason: collision with root package name */
    public final kotlin.f f11744j = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.AmbientLightV3Activity$boostAdapter$2
        {
            super(0);
        }

        @Override // q5.a
        public final AmbientLightV3Activity.ColorAdapter invoke() {
            AmbientLightV3Activity ambientLightV3Activity = this.this$0;
            List list = ambientLightV3Activity.f11742h;
            if (list == null) {
                kotlin.jvm.internal.y.x("boostColorList");
                list = null;
            }
            return new AmbientLightV3Activity.ColorAdapter(ambientLightV3Activity, list, true);
        }
    });

    /* renamed from: k, reason: collision with root package name */
    public final kotlin.f f11745k = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.AmbientLightV3Activity$lightType$2
        {
            super(0);
        }

        @Override // q5.a
        public final Integer invoke() {
            return Integer.valueOf(this.this$0.getIntent().getIntExtra("LIGHT_TYPE", 4));
        }
    });

    /* renamed from: l, reason: collision with root package name */
    public final kotlin.f f11746l = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.AmbientLightV3Activity$lightOn$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Boolean> invoke() {
            LiveData liveDataK;
            if (this.this$0.w0()) {
                AmbientLightV3Activity ambientLightV3Activity = this.this$0;
                liveDataK = CommonExt.k(ambientLightV3Activity, Integer.valueOf(ambientLightV3Activity.R().getLightD()), "lightD");
            } else {
                AmbientLightV3Activity ambientLightV3Activity2 = this.this$0;
                liveDataK = CommonExt.k(ambientLightV3Activity2, Integer.valueOf(ambientLightV3Activity2.R().getAmbientLight()), "ambientLight");
            }
            return Transformations.distinctUntilChanged(Transformations.map(liveDataK, new q5.l() { // from class: com.uz.navee.ui.device.AmbientLightV3Activity$lightOn$2.1
                @Override // q5.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final Boolean invoke(int i6) {
                    return Boolean.valueOf(com.uz.navee.utils.f.h(i6, 7) == 1);
                }
            }));
        }
    });

    /* renamed from: m, reason: collision with root package name */
    public final kotlin.f f11747m = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.AmbientLightV3Activity$lightMode$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Integer> invoke() {
            LiveData liveDataK;
            if (this.this$0.w0()) {
                AmbientLightV3Activity ambientLightV3Activity = this.this$0;
                liveDataK = CommonExt.k(ambientLightV3Activity, Integer.valueOf(ambientLightV3Activity.R().getLightD()), "lightD");
            } else {
                AmbientLightV3Activity ambientLightV3Activity2 = this.this$0;
                liveDataK = CommonExt.k(ambientLightV3Activity2, Integer.valueOf(ambientLightV3Activity2.R().getAmbientLight()), "ambientLight");
            }
            return Transformations.distinctUntilChanged(Transformations.map(liveDataK, new q5.l() { // from class: com.uz.navee.ui.device.AmbientLightV3Activity$lightMode$2.1
                @Override // q5.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final Integer invoke(int i6) {
                    return Integer.valueOf(i6 & 127);
                }
            }));
        }
    });

    /* renamed from: n, reason: collision with root package name */
    public final kotlin.f f11748n = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.AmbientLightV3Activity$generalColor$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Integer> invoke() {
            LiveData liveDataK;
            if (this.this$0.w0()) {
                AmbientLightV3Activity ambientLightV3Activity = this.this$0;
                liveDataK = CommonExt.k(ambientLightV3Activity, Integer.valueOf(ambientLightV3Activity.R().getLightS()), "lightS");
            } else {
                AmbientLightV3Activity ambientLightV3Activity2 = this.this$0;
                liveDataK = CommonExt.k(ambientLightV3Activity2, Integer.valueOf(ambientLightV3Activity2.R().getLightE()), "lightE");
            }
            return Transformations.distinctUntilChanged(Transformations.map(liveDataK, new q5.l() { // from class: com.uz.navee.ui.device.AmbientLightV3Activity$generalColor$2.1
                @Override // q5.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final Integer invoke(int i6) {
                    return Integer.valueOf(i6 & 15);
                }
            }));
        }
    });

    /* renamed from: o, reason: collision with root package name */
    public final kotlin.f f11749o = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.AmbientLightV3Activity$boostColor$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Integer> invoke() {
            LiveData liveDataK;
            if (this.this$0.w0()) {
                AmbientLightV3Activity ambientLightV3Activity = this.this$0;
                liveDataK = CommonExt.k(ambientLightV3Activity, Integer.valueOf(ambientLightV3Activity.R().getLightS()), "lightS");
            } else {
                AmbientLightV3Activity ambientLightV3Activity2 = this.this$0;
                liveDataK = CommonExt.k(ambientLightV3Activity2, Integer.valueOf(ambientLightV3Activity2.R().getLightE()), "lightE");
            }
            return Transformations.distinctUntilChanged(Transformations.map(liveDataK, new q5.l() { // from class: com.uz.navee.ui.device.AmbientLightV3Activity$boostColor$2.1
                @Override // q5.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final Integer invoke(int i6) {
                    return Integer.valueOf((i6 >> 4) & 15);
                }
            }));
        }
    });

    public final class ColorAdapter extends RecyclerView.Adapter<ViewHolder> {

        /* renamed from: a, reason: collision with root package name */
        public final List f11750a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f11751b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AmbientLightV3Activity f11752c;

        public ColorAdapter(AmbientLightV3Activity ambientLightV3Activity, List list, boolean z6) {
            kotlin.jvm.internal.y.f(list, "list");
            this.f11752c = ambientLightV3Activity;
            this.f11750a = list;
            this.f11751b = z6;
        }

        public static final void d(AmbientLightV3Activity this$0, ColorAdapter this$1, int i6, a item, View view) throws IOException {
            kotlin.jvm.internal.y.f(this$0, "this$0");
            kotlin.jvm.internal.y.f(this$1, "this$1");
            kotlin.jvm.internal.y.f(item, "$item");
            this$0.y0(this$1.f11751b, i6);
            this$0.z0(item.b().getCmdValue(), this$1.f11751b);
        }

        public final List b() {
            return this.f11750a;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(ViewHolder holder, final int i6) {
            kotlin.jvm.internal.y.f(holder, "holder");
            final a aVar = (a) this.f11750a.get(i6);
            ViewDataBinding binding = holder.getBinding();
            kotlin.jvm.internal.y.d(binding, "null cannot be cast to non-null type com.uz.navee.databinding.ItemAmbientColorBinding");
            ImageFilterView imageFilterView = ((ItemAmbientColorBinding) binding).ivColor;
            final AmbientLightV3Activity ambientLightV3Activity = this.f11752c;
            imageFilterView.setBackgroundResource(aVar.b().getColorImg());
            imageFilterView.setSelected(aVar.a());
            imageFilterView.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws IOException {
                    AmbientLightV3Activity.ColorAdapter.d(ambientLightV3Activity, this, i6, aVar, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public ViewHolder onCreateViewHolder(ViewGroup parent, int i6) {
            kotlin.jvm.internal.y.f(parent, "parent");
            ItemAmbientColorBinding itemAmbientColorBinding = (ItemAmbientColorBinding) DataBindingUtil.inflate(this.f11752c.getLayoutInflater(), R$layout.item_ambient_color, parent, false);
            View root = itemAmbientColorBinding.getRoot();
            kotlin.jvm.internal.y.e(root, "getRoot(...)");
            ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams.height = -1;
            root.setLayoutParams(layoutParams);
            kotlin.jvm.internal.y.c(itemAmbientColorBinding);
            return new ViewHolder(itemAmbientColorBinding);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f11750a.size();
        }
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final AmbientColor f11753a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f11754b;

        public a(AmbientColor color, boolean z6) {
            kotlin.jvm.internal.y.f(color, "color");
            this.f11753a = color;
            this.f11754b = z6;
        }

        public final boolean a() {
            return this.f11754b;
        }

        public final AmbientColor b() {
            return this.f11753a;
        }

        public final void c(boolean z6) {
            this.f11754b = z6;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f11753a == aVar.f11753a && this.f11754b == aVar.f11754b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iHashCode = this.f11753a.hashCode() * 31;
            boolean z6 = this.f11754b;
            int i6 = z6;
            if (z6 != 0) {
                i6 = 1;
            }
            return iHashCode + i6;
        }

        public String toString() {
            return "CheckableColor(color=" + this.f11753a + ", checked=" + this.f11754b + ")";
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
            this();
        }

        public final void a(Context context, int i6, BleDevice bleDevice, Vehicle vehicle) {
            kotlin.jvm.internal.y.f(context, "context");
            if (b4.a.f(bleDevice)) {
                Intent intent = new Intent(context, (Class<?>) AmbientLightV3Activity.class);
                intent.putExtra("LIGHT_TYPE", i6);
                CommonExt.q(intent, bleDevice, vehicle, null, 4, null);
                context.startActivity(intent);
            }
        }
    }

    public static final class c implements TabLayout.OnTabSelectedListener {
        public c() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            kotlin.jvm.internal.y.f(tab, "tab");
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) throws IOException {
            kotlin.jvm.internal.y.f(tab, "tab");
            AmbientLightV3Activity.this.B0(tab.getPosition());
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            kotlin.jvm.internal.y.f(tab, "tab");
        }
    }

    public static final class d implements Observer, kotlin.jvm.internal.u {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q5.l f11756a;

        public d(q5.l function) {
            kotlin.jvm.internal.y.f(function, "function");
            this.f11756a = function;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.u)) {
                return kotlin.jvm.internal.y.a(getFunctionDelegate(), ((kotlin.jvm.internal.u) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.u
        public final kotlin.c getFunctionDelegate() {
            return this.f11756a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f11756a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C0() {
        AmbientColor ambientColorB;
        int carImg = 0;
        Object obj = null;
        if (((ActivityAmbientLightV3Binding) Q()).scSwitch.isChecked()) {
            List list = this.f11741g;
            if (list == null) {
                kotlin.jvm.internal.y.x("generalColorList");
                list = null;
            }
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((a) next).a()) {
                    obj = next;
                    break;
                }
            }
            a aVar = (a) obj;
            if (aVar != null && (ambientColorB = aVar.b()) != null) {
                carImg = ambientColorB.getCarImg();
            }
        } else {
            String strT = T();
            carImg = CommonExt.j(strT != null ? Boolean.valueOf(kotlin.text.s.D(strT, "2585", false, 2, null)) : null) ? R$drawable.img_ambient_ut5x_close : R$drawable.img_ambient_ut5_close;
        }
        ((ActivityAmbientLightV3Binding) Q()).ivVehicle.setImageResource(carImg);
    }

    public static final /* synthetic */ ActivityAmbientLightV3Binding d0(AmbientLightV3Activity ambientLightV3Activity) {
        return (ActivityAmbientLightV3Binding) ambientLightV3Activity.Q();
    }

    private final void o0() throws Resources.NotFoundException {
        String strT = T();
        if (!CommonExt.j(strT != null ? Boolean.valueOf(kotlin.text.s.D(strT, "2585", false, 2, null)) : null)) {
            if (w0()) {
                AmbientColor.RED.setCarImg(R$drawable.img_star_ut5_red);
                AmbientColor.LIGHT_BLUE.setCarImg(R$drawable.img_star_ut5_light_blue);
            } else {
                AmbientColor.RED.setCarImg(R$drawable.img_line_ut5_red);
                AmbientColor.LIGHT_BLUE.setCarImg(R$drawable.img_line_ut5_light_blue);
            }
            AmbientColor ambientColor = AmbientColor.LIGHT_BLUE;
            a aVar = new a(ambientColor, false);
            AmbientColor ambientColor2 = AmbientColor.RED;
            this.f11741g = kotlin.collections.t.n(aVar, new a(ambientColor2, false));
            this.f11742h = kotlin.collections.t.n(new a(ambientColor, false), new a(ambientColor2, false));
            return;
        }
        TypedArray typedArrayObtainTypedArray = getResources().obtainTypedArray(w0() ? R$array.img_star_ut5x : R$array.img_line_ut5x);
        kotlin.jvm.internal.y.e(typedArrayObtainTypedArray, "obtainTypedArray(...)");
        int length = typedArrayObtainTypedArray.length();
        int[] iArr = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            iArr[i6] = typedArrayObtainTypedArray.getResourceId(i6, 0);
        }
        typedArrayObtainTypedArray.recycle();
        kotlin.enums.a entries = AmbientColor.getEntries();
        ArrayList arrayList = new ArrayList(kotlin.collections.u.u(entries, 10));
        int i7 = 0;
        for (Object obj : entries) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                kotlin.collections.t.t();
            }
            AmbientColor ambientColor3 = (AmbientColor) obj;
            ambientColor3.setCarImg(iArr[i7]);
            arrayList.add(new a(ambientColor3, false));
            i7 = i8;
        }
        this.f11741g = arrayList;
        kotlin.enums.a entries2 = AmbientColor.getEntries();
        ArrayList arrayList2 = new ArrayList(kotlin.collections.u.u(entries2, 10));
        Iterator<E> it = entries2.iterator();
        while (it.hasNext()) {
            arrayList2.add(new a((AmbientColor) it.next(), false));
        }
        this.f11742h = arrayList2;
    }

    public static final void x0(AmbientLightV3Activity this$0, CompoundButton compoundButton, boolean z6) throws IOException {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        View lightSelectForegroundView = ((ActivityAmbientLightV3Binding) this$0.Q()).lightSelectForegroundView;
        kotlin.jvm.internal.y.e(lightSelectForegroundView, "lightSelectForegroundView");
        lightSelectForegroundView.setVisibility(z6 ^ true ? 0 : 8);
        ((ActivityAmbientLightV3Binding) this$0.Q()).switchSubTitleLabel.setText(z6 ? R$string.opened : R$string.closed);
        this$0.C0();
        if (kotlin.jvm.internal.y.a(this$0.u0().getValue(), Boolean.valueOf(z6))) {
            return;
        }
        this$0.A0();
    }

    public final void A0() throws IOException {
        if (kotlin.jvm.internal.y.a(u0().getValue(), Boolean.valueOf(((ActivityAmbientLightV3Binding) Q()).scSwitch.isChecked()))) {
            return;
        }
        BaseBindingActivity.Z(this, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, new byte[]{(byte) v0(), 0, ((ActivityAmbientLightV3Binding) Q()).scSwitch.isChecked()}, false, 4, null);
    }

    public final void B0(int i6) throws IOException {
        Integer num = (Integer) t0().getValue();
        if (num != null && i6 == num.intValue()) {
            return;
        }
        BaseBindingActivity.Z(this, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, new byte[]{(byte) v0(), 1, (byte) i6}, false, 4, null);
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public int V() {
        return R$layout.activity_ambient_light_v3;
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public String b0() {
        String string = getString(w0() ? R$string.light_star : R$string.light_line);
        kotlin.jvm.internal.y.e(string, "getString(...)");
        return string;
    }

    @Override // com.uz.navee.base.BaseBindingActivity, com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(ContextCompat.getDrawable(this, R$mipmap.bg_ambient));
        ((ActivityAmbientLightV3Binding) Q()).switchTitleLabel.setText(b0());
        ((ActivityAmbientLightV3Binding) Q()).scSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.u
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) throws IOException {
                AmbientLightV3Activity.x0(this.f12662a, compoundButton, z6);
            }
        });
        ((ActivityAmbientLightV3Binding) Q()).tbMode.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new c());
        o0();
        ((ActivityAmbientLightV3Binding) Q()).rvGeneral.setLayoutManager(new GridLayoutManager(this, 6));
        ((ActivityAmbientLightV3Binding) Q()).rvGeneral.setAdapter(r0());
        ((ActivityAmbientLightV3Binding) Q()).rvBoost.setLayoutManager(new GridLayoutManager(this, 6));
        ((ActivityAmbientLightV3Binding) Q()).rvBoost.setAdapter(p0());
        C0();
        u0().observe(this, new d(new q5.l() { // from class: com.uz.navee.ui.device.AmbientLightV3Activity.onCreate.3
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) throws Resources.NotFoundException {
                invoke((Boolean) obj);
                return kotlin.u.f15726a;
            }

            public final void invoke(Boolean bool) throws Resources.NotFoundException {
                SwitchCompat switchCompat = AmbientLightV3Activity.d0(AmbientLightV3Activity.this).scSwitch;
                kotlin.jvm.internal.y.c(bool);
                switchCompat.setChecked(bool.booleanValue());
            }
        }));
        t0().observe(this, new d(new q5.l() { // from class: com.uz.navee.ui.device.AmbientLightV3Activity.onCreate.4
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return kotlin.u.f15726a;
            }

            public final void invoke(Integer num) {
                TabLayout tabLayout = AmbientLightV3Activity.d0(AmbientLightV3Activity.this).tbMode;
                kotlin.jvm.internal.y.c(num);
                TabLayout.Tab tabAt = tabLayout.getTabAt(num.intValue());
                if (tabAt != null) {
                    tabAt.select();
                }
            }
        }));
        s0().observe(this, new d(new q5.l() { // from class: com.uz.navee.ui.device.AmbientLightV3Activity.onCreate.5
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return kotlin.u.f15726a;
            }

            public final void invoke(Integer num) {
                List<a> list = AmbientLightV3Activity.this.f11741g;
                if (list == null) {
                    kotlin.jvm.internal.y.x("generalColorList");
                    list = null;
                }
                for (a aVar : list) {
                    aVar.c(num != null && num.intValue() == aVar.b().getCmdValue());
                }
                AmbientLightV3Activity.this.r0().notifyDataSetChanged();
                AmbientLightV3Activity.this.C0();
            }
        }));
        q0().observe(this, new d(new q5.l() { // from class: com.uz.navee.ui.device.AmbientLightV3Activity.onCreate.6
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return kotlin.u.f15726a;
            }

            public final void invoke(Integer num) {
                List<a> list = AmbientLightV3Activity.this.f11742h;
                if (list == null) {
                    kotlin.jvm.internal.y.x("boostColorList");
                    list = null;
                }
                for (a aVar : list) {
                    aVar.c(num != null && num.intValue() == aVar.b().getCmdValue());
                }
                AmbientLightV3Activity.this.p0().notifyDataSetChanged();
            }
        }));
    }

    public final ColorAdapter p0() {
        return (ColorAdapter) this.f11744j.getValue();
    }

    public final LiveData q0() {
        return (LiveData) this.f11749o.getValue();
    }

    public final ColorAdapter r0() {
        return (ColorAdapter) this.f11743i.getValue();
    }

    public final LiveData s0() {
        return (LiveData) this.f11748n.getValue();
    }

    public final LiveData t0() {
        return (LiveData) this.f11747m.getValue();
    }

    public final LiveData u0() {
        return (LiveData) this.f11746l.getValue();
    }

    public final int v0() {
        return ((Number) this.f11745k.getValue()).intValue();
    }

    public final boolean w0() {
        return v0() == 5;
    }

    public final void y0(boolean z6, int i6) {
        ColorAdapter colorAdapterP0 = z6 ? p0() : r0();
        List listB = colorAdapterP0.b();
        if (((a) listB.get(i6)).a()) {
            return;
        }
        int i7 = 0;
        for (Object obj : listB) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                kotlin.collections.t.t();
            }
            ((a) obj).c(i7 == i6);
            i7 = i8;
        }
        colorAdapterP0.notifyDataSetChanged();
        ((ActivityAmbientLightV3Binding) Q()).ivVehicle.setImageResource(((a) listB.get(i6)).b().getCarImg());
    }

    public final void z0(int i6, boolean z6) throws IOException {
        Integer num;
        Integer num2;
        if (z6 && (num2 = (Integer) q0().getValue()) != null && num2.intValue() == i6) {
            return;
        }
        if (z6 || (num = (Integer) s0().getValue()) == null || num.intValue() != i6) {
            byte[] bArr = new byte[3];
            bArr[0] = (byte) v0();
            bArr[1] = z6 ? (byte) 3 : (byte) 2;
            bArr[2] = (byte) i6;
            BaseBindingActivity.Z(this, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, bArr, false, 4, null);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class AmbientColor {
        private static final /* synthetic */ kotlin.enums.a $ENTRIES;
        private static final /* synthetic */ AmbientColor[] $VALUES;
        public static final AmbientColor BLUE;
        public static final a Companion;
        public static final AmbientColor GREEN;
        public static final AmbientColor LIGHT_BLUE;
        public static final AmbientColor PURPLE;
        public static final AmbientColor RAINBOW;
        public static final AmbientColor RED;
        private int carImg;
        private final int cmdValue;
        private final int colorImg;

        public static final class a {
            public a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.r rVar) {
                this();
            }
        }

        private static final /* synthetic */ AmbientColor[] $values() {
            return new AmbientColor[]{RED, PURPLE, LIGHT_BLUE, GREEN, BLUE, RAINBOW};
        }

        static {
            int i6 = 0;
            RED = new AmbientColor("RED", 0, R$mipmap.ic_ambient_red_unselected, 1, i6, 4, null);
            int i7 = 4;
            kotlin.jvm.internal.r rVar = null;
            int i8 = 0;
            PURPLE = new AmbientColor("PURPLE", 1, R$mipmap.ic_ambient_purple_unselected, 4, i8, i7, rVar);
            int i9 = 4;
            kotlin.jvm.internal.r rVar2 = null;
            int i10 = 0;
            LIGHT_BLUE = new AmbientColor("LIGHT_BLUE", 2, R$mipmap.ic_ambient_light_blue, i6, i10, i9, rVar2);
            GREEN = new AmbientColor("GREEN", 3, R$mipmap.ic_ambient_green_unselected, 3, i8, i7, rVar);
            BLUE = new AmbientColor("BLUE", 4, R$mipmap.ic_ambient_blue_unselected, 2, i10, i9, rVar2);
            RAINBOW = new AmbientColor("RAINBOW", 5, R$mipmap.ic_ambient_colors_unselected, 5, i8, i7, rVar);
            AmbientColor[] ambientColorArr$values = $values();
            $VALUES = ambientColorArr$values;
            $ENTRIES = kotlin.enums.b.a(ambientColorArr$values);
            Companion = new a(null);
        }

        private AmbientColor(@DrawableRes String str, int i6, @DrawableRes int i7, int i8, int i9) {
            this.colorImg = i7;
            this.cmdValue = i8;
            this.carImg = i9;
        }

        public static kotlin.enums.a getEntries() {
            return $ENTRIES;
        }

        public static AmbientColor valueOf(String str) {
            return (AmbientColor) Enum.valueOf(AmbientColor.class, str);
        }

        public static AmbientColor[] values() {
            return (AmbientColor[]) $VALUES.clone();
        }

        public final int getCarImg() {
            return this.carImg;
        }

        public final int getCmdValue() {
            return this.cmdValue;
        }

        public final int getColorImg() {
            return this.colorImg;
        }

        public final void setCarImg(int i6) {
            this.carImg = i6;
        }

        public /* synthetic */ AmbientColor(String str, int i6, int i7, int i8, int i9, int i10, kotlin.jvm.internal.r rVar) {
            this(str, i6, i7, i8, (i10 & 4) != 0 ? 0 : i9);
        }
    }
}
