package com.uz.navee.ui.device;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintProperties;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.uz.navee.R$array;
import com.uz.navee.R$drawable;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseBindingActivity;
import com.uz.navee.base.ViewHolder;
import com.uz.navee.bean.DeviceCarInfo;
import com.uz.navee.databinding.ActivityAmbientLightV2Binding;
import com.uz.navee.databinding.ItemAmbientColorBinding;
import com.uz.navee.databinding.LayoutRecyclerviewBinding;
import com.uz.navee.ui.device.AmbientLightV2Activity;
import com.uz.navee.utils.CommonExt;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes3.dex */
public final class AmbientLightV2Activity extends BaseBindingActivity<ActivityAmbientLightV2Binding> {

    /* renamed from: g, reason: collision with root package name */
    public List f11719g;

    /* renamed from: h, reason: collision with root package name */
    public List f11720h;

    /* renamed from: i, reason: collision with root package name */
    public List f11721i;

    /* renamed from: j, reason: collision with root package name */
    public final kotlin.f f11722j = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.AmbientLightV2Activity$eColorAdapter$2
        {
            super(0);
        }

        @Override // q5.a
        public final AmbientLightV2Activity.ColorAdapter invoke() {
            AmbientLightV2Activity ambientLightV2Activity = this.this$0;
            List list = ambientLightV2Activity.f11719g;
            if (list == null) {
                kotlin.jvm.internal.y.x("eColorList");
                list = null;
            }
            return new AmbientLightV2Activity.ColorAdapter(ambientLightV2Activity, list);
        }
    });

    /* renamed from: k, reason: collision with root package name */
    public final kotlin.f f11723k = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.AmbientLightV2Activity$dColorAdapter$2
        {
            super(0);
        }

        @Override // q5.a
        public final AmbientLightV2Activity.ColorAdapter invoke() {
            AmbientLightV2Activity ambientLightV2Activity = this.this$0;
            List list = ambientLightV2Activity.f11720h;
            if (list == null) {
                kotlin.jvm.internal.y.x("dColorList");
                list = null;
            }
            return new AmbientLightV2Activity.ColorAdapter(ambientLightV2Activity, list);
        }
    });

    /* renamed from: l, reason: collision with root package name */
    public final kotlin.f f11724l = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.AmbientLightV2Activity$sColorAdapter$2
        {
            super(0);
        }

        @Override // q5.a
        public final AmbientLightV2Activity.ColorAdapter invoke() {
            AmbientLightV2Activity ambientLightV2Activity = this.this$0;
            List list = ambientLightV2Activity.f11721i;
            if (list == null) {
                kotlin.jvm.internal.y.x("sColorList");
                list = null;
            }
            return new AmbientLightV2Activity.ColorAdapter(ambientLightV2Activity, list);
        }
    });

    /* renamed from: m, reason: collision with root package name */
    public final kotlin.f f11725m = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.AmbientLightV2Activity$closeCarImg$2
        {
            super(0);
        }

        @Override // q5.a
        public final Integer invoke() {
            int i6;
            String strT = this.this$0.T();
            if (strT == null || !kotlin.text.s.D(strT, "2506", false, 2, null)) {
                String strT2 = this.this$0.T();
                i6 = (strT2 == null || !kotlin.text.s.D(strT2, "2505", false, 2, null)) ? R$drawable.img_ambient_k100_close : R$drawable.img_ambient_k100pro_close;
            } else {
                i6 = R$drawable.img_ambient_k100max_close;
            }
            return Integer.valueOf(i6);
        }
    });

    /* renamed from: n, reason: collision with root package name */
    public final kotlin.f f11726n = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.AmbientLightV2Activity$selectedModes$2
        @Override // q5.a
        public final AmbientLightV2Activity.AmbientMode[] invoke() {
            AmbientLightV2Activity.AmbientMode[] ambientModeArr = new AmbientLightV2Activity.AmbientMode[3];
            for (int i6 = 0; i6 < 3; i6++) {
                ambientModeArr[i6] = AmbientLightV2Activity.AmbientMode.BREATHING;
            }
            return ambientModeArr;
        }
    });

    /* renamed from: o, reason: collision with root package name */
    public PropertyChangeListener f11727o;

    /* renamed from: p, reason: collision with root package name */
    public PropertyChangeListener f11728p;

    /* renamed from: q, reason: collision with root package name */
    public PropertyChangeListener f11729q;

    /* renamed from: r, reason: collision with root package name */
    public PropertyChangeListener f11730r;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class AmbientGear {
        private static final /* synthetic */ kotlin.enums.a $ENTRIES;
        private static final /* synthetic */ AmbientGear[] $VALUES;
        public static final AmbientGear E = new AmbientGear(ExifInterface.LONGITUDE_EAST, 0);
        public static final AmbientGear D = new AmbientGear("D", 1);
        public static final AmbientGear S = new AmbientGear(ExifInterface.LATITUDE_SOUTH, 2);

        private static final /* synthetic */ AmbientGear[] $values() {
            return new AmbientGear[]{E, D, S};
        }

        static {
            AmbientGear[] ambientGearArr$values = $values();
            $VALUES = ambientGearArr$values;
            $ENTRIES = kotlin.enums.b.a(ambientGearArr$values);
        }

        private AmbientGear(String str, int i6) {
        }

        public static kotlin.enums.a getEntries() {
            return $ENTRIES;
        }

        public static AmbientGear valueOf(String str) {
            return (AmbientGear) Enum.valueOf(AmbientGear.class, str);
        }

        public static AmbientGear[] values() {
            return (AmbientGear[]) $VALUES.clone();
        }
    }

    public final class ColorAdapter extends RecyclerView.Adapter<ViewHolder> {

        /* renamed from: a, reason: collision with root package name */
        public final List f11731a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AmbientLightV2Activity f11732b;

        public ColorAdapter(AmbientLightV2Activity ambientLightV2Activity, List list) {
            kotlin.jvm.internal.y.f(list, "list");
            this.f11732b = ambientLightV2Activity;
            this.f11731a = list;
        }

        public static final void d(AmbientLightV2Activity this$0, a item, int i6, View view) throws IOException {
            kotlin.jvm.internal.y.f(this$0, "this$0");
            kotlin.jvm.internal.y.f(item, "$item");
            this$0.N0(item.c(), i6);
            this$0.P0();
        }

        public final List b() {
            return this.f11731a;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(ViewHolder holder, final int i6) {
            kotlin.jvm.internal.y.f(holder, "holder");
            final a aVar = (a) this.f11731a.get(i6);
            ViewDataBinding binding = holder.getBinding();
            kotlin.jvm.internal.y.d(binding, "null cannot be cast to non-null type com.uz.navee.databinding.ItemAmbientColorBinding");
            ImageFilterView imageFilterView = ((ItemAmbientColorBinding) binding).ivColor;
            final AmbientLightV2Activity ambientLightV2Activity = this.f11732b;
            imageFilterView.setBackgroundResource(aVar.b().getColorImg());
            imageFilterView.setSelected(aVar.a());
            imageFilterView.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws IOException {
                    AmbientLightV2Activity.ColorAdapter.d(ambientLightV2Activity, aVar, i6, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public ViewHolder onCreateViewHolder(ViewGroup parent, int i6) {
            kotlin.jvm.internal.y.f(parent, "parent");
            ItemAmbientColorBinding itemAmbientColorBinding = (ItemAmbientColorBinding) DataBindingUtil.inflate(this.f11732b.getLayoutInflater(), R$layout.item_ambient_color, parent, false);
            kotlin.jvm.internal.y.c(itemAmbientColorBinding);
            return new ViewHolder(itemAmbientColorBinding);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f11731a.size();
        }
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final AmbientGear f11733a;

        /* renamed from: b, reason: collision with root package name */
        public final AmbientColor f11734b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f11735c;

        public a(AmbientGear gear, AmbientColor color, boolean z6) {
            kotlin.jvm.internal.y.f(gear, "gear");
            kotlin.jvm.internal.y.f(color, "color");
            this.f11733a = gear;
            this.f11734b = color;
            this.f11735c = z6;
        }

        public final boolean a() {
            return this.f11735c;
        }

        public final AmbientColor b() {
            return this.f11734b;
        }

        public final AmbientGear c() {
            return this.f11733a;
        }

        public final void d(boolean z6) {
            this.f11735c = z6;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f11733a == aVar.f11733a && this.f11734b == aVar.f11734b && this.f11735c == aVar.f11735c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iHashCode = ((this.f11733a.hashCode() * 31) + this.f11734b.hashCode()) * 31;
            boolean z6 = this.f11735c;
            int i6 = z6;
            if (z6 != 0) {
                i6 = 1;
            }
            return iHashCode + i6;
        }

        public String toString() {
            return "CheckableColor(gear=" + this.f11733a + ", color=" + this.f11734b + ", checked=" + this.f11735c + ")";
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11736a;

        static {
            int[] iArr = new int[AmbientGear.values().length];
            try {
                iArr[AmbientGear.E.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AmbientGear.D.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AmbientGear.S.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f11736a = iArr;
        }
    }

    public static final void G0(AmbientLightV2Activity this$0, PropertyChangeEvent propertyChangeEvent) throws Resources.NotFoundException {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        if (kotlin.jvm.internal.y.a("ambientLight", propertyChangeEvent.getPropertyName())) {
            ((ActivityAmbientLightV2Binding) this$0.Q()).scSwitch.setChecked(kotlin.jvm.internal.y.a(propertyChangeEvent.getNewValue(), 1));
        }
    }

    public static final void H0(AmbientLightV2Activity this$0, PropertyChangeEvent propertyChangeEvent) {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        if (kotlin.jvm.internal.y.a("lightE", propertyChangeEvent.getPropertyName())) {
            AmbientGear ambientGear = AmbientGear.E;
            Object newValue = propertyChangeEvent.getNewValue();
            kotlin.jvm.internal.y.d(newValue, "null cannot be cast to non-null type kotlin.Int");
            this$0.M0(ambientGear, ((Integer) newValue).intValue());
        }
    }

    public static final void I0(AmbientLightV2Activity this$0, PropertyChangeEvent propertyChangeEvent) {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        if (kotlin.jvm.internal.y.a("lightD", propertyChangeEvent.getPropertyName())) {
            AmbientGear ambientGear = AmbientGear.D;
            Object newValue = propertyChangeEvent.getNewValue();
            kotlin.jvm.internal.y.d(newValue, "null cannot be cast to non-null type kotlin.Int");
            this$0.M0(ambientGear, ((Integer) newValue).intValue());
        }
    }

    public static final void J0(AmbientLightV2Activity this$0, PropertyChangeEvent propertyChangeEvent) {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        if (kotlin.jvm.internal.y.a("lightS", propertyChangeEvent.getPropertyName())) {
            AmbientGear ambientGear = AmbientGear.S;
            Object newValue = propertyChangeEvent.getNewValue();
            kotlin.jvm.internal.y.d(newValue, "null cannot be cast to non-null type kotlin.Int");
            this$0.M0(ambientGear, ((Integer) newValue).intValue());
        }
    }

    public static final void K0(AmbientLightV2Activity this$0, CompoundButton compoundButton, boolean z6) throws IOException {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        View lightSelectForegroundView = ((ActivityAmbientLightV2Binding) this$0.Q()).lightSelectForegroundView;
        kotlin.jvm.internal.y.e(lightSelectForegroundView, "lightSelectForegroundView");
        lightSelectForegroundView.setVisibility(z6 ^ true ? 0 : 8);
        ((ActivityAmbientLightV2Binding) this$0.Q()).switchSubTitleLabel.setText(z6 ? R$string.opened : R$string.closed);
        this$0.Q0();
        if ((b4.a.W().f1933f.getAmbientLight() == 1) == z6) {
            return;
        }
        this$0.P0();
    }

    public static final void L0(String[] titles, TabLayout.Tab tab, int i6) {
        kotlin.jvm.internal.y.f(titles, "$titles");
        kotlin.jvm.internal.y.f(tab, "tab");
        tab.setText(titles[i6]);
    }

    public final ColorAdapter A0() {
        return (ColorAdapter) this.f11723k.getValue();
    }

    public final ColorAdapter B0() {
        return (ColorAdapter) this.f11722j.getValue();
    }

    public final ColorAdapter C0() {
        return (ColorAdapter) this.f11724l.getValue();
    }

    public final AmbientMode[] D0() {
        return (AmbientMode[]) this.f11726n.getValue();
    }

    public final boolean E0() {
        String strT = T();
        return (strT == null || kotlin.text.s.D(strT, "2506", false, 2, null)) ? false : true;
    }

    public final void F0() throws Resources.NotFoundException {
        DeviceCarInfo deviceCarInfo = b4.a.W().f1933f;
        ((ActivityAmbientLightV2Binding) Q()).scSwitch.setChecked(deviceCarInfo.getAmbientLight() == 1);
        M0(AmbientGear.E, deviceCarInfo.getLightE());
        M0(AmbientGear.D, deviceCarInfo.getLightD());
        M0(AmbientGear.S, deviceCarInfo.getLightS());
        PropertyChangeListener propertyChangeListenerAddListener = deviceCarInfo.addListener("ambientLight", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.o
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) throws Resources.NotFoundException {
                AmbientLightV2Activity.G0(this.f12602a, propertyChangeEvent);
            }
        });
        kotlin.jvm.internal.y.e(propertyChangeListenerAddListener, "addListener(...)");
        this.f11727o = propertyChangeListenerAddListener;
        PropertyChangeListener propertyChangeListenerAddListener2 = deviceCarInfo.addListener("lightE", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.p
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                AmbientLightV2Activity.H0(this.f12611a, propertyChangeEvent);
            }
        });
        kotlin.jvm.internal.y.e(propertyChangeListenerAddListener2, "addListener(...)");
        this.f11728p = propertyChangeListenerAddListener2;
        PropertyChangeListener propertyChangeListenerAddListener3 = deviceCarInfo.addListener("lightD", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.q
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                AmbientLightV2Activity.I0(this.f12620a, propertyChangeEvent);
            }
        });
        kotlin.jvm.internal.y.e(propertyChangeListenerAddListener3, "addListener(...)");
        this.f11729q = propertyChangeListenerAddListener3;
        PropertyChangeListener propertyChangeListenerAddListener4 = deviceCarInfo.addListener("lightS", new PropertyChangeListener() { // from class: com.uz.navee.ui.device.r
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                AmbientLightV2Activity.J0(this.f12630a, propertyChangeEvent);
            }
        });
        kotlin.jvm.internal.y.e(propertyChangeListenerAddListener4, "addListener(...)");
        this.f11730r = propertyChangeListenerAddListener4;
    }

    public final void M0(AmbientGear ambientGear, int i6) {
        if (E0()) {
            AmbientColor ambientColorA = AmbientColor.Companion.a(i6);
            N0(ambientGear, ambientGear == AmbientGear.S ? ambientColorA.ordinal() >= 8 ? ambientColorA.ordinal() - 8 : 0 : ambientColorA.ordinal());
            return;
        }
        D0()[ambientGear.ordinal()] = AmbientMode.Companion.a(i6);
        RecyclerView.Adapter adapter = ((ActivityAmbientLightV2Binding) Q()).vpAmbient.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(ambientGear.ordinal());
        }
        Q0();
    }

    public final void N0(AmbientGear ambientGear, int i6) {
        ColorAdapter colorAdapterB0;
        int i7 = b.f11736a[ambientGear.ordinal()];
        if (i7 == 1) {
            colorAdapterB0 = B0();
        } else if (i7 == 2) {
            colorAdapterB0 = A0();
        } else {
            if (i7 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            colorAdapterB0 = C0();
        }
        List listB = colorAdapterB0.b();
        if (((a) listB.get(i6)).a()) {
            return;
        }
        int i8 = 0;
        for (Object obj : listB) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                kotlin.collections.t.t();
            }
            ((a) obj).d(i8 == i6);
            i8 = i9;
        }
        colorAdapterB0.notifyDataSetChanged();
        ((ActivityAmbientLightV2Binding) Q()).ivVehicle.setImageResource(((a) listB.get(i6)).b().getCarImg());
    }

    public final boolean O0(int i6, int i7) {
        AmbientMode ambientModeB = AmbientMode.Companion.b(i7);
        if (ambientModeB == D0()[i6]) {
            return false;
        }
        D0()[i6] = ambientModeB;
        ((ActivityAmbientLightV2Binding) Q()).ivVehicle.setImageResource(ambientModeB.getCarImg());
        return true;
    }

    public final void P0() throws IOException {
        int cmdValue;
        int cmdValue2;
        int cmdValue3;
        boolean zIsChecked = ((ActivityAmbientLightV2Binding) Q()).scSwitch.isChecked();
        if (E0()) {
            List<a> list = this.f11719g;
            List<a> list2 = null;
            if (list == null) {
                kotlin.jvm.internal.y.x("eColorList");
                list = null;
            }
            for (a aVar : list) {
                if (aVar.a()) {
                    cmdValue = aVar.b().getCmdValue();
                    List<a> list3 = this.f11720h;
                    if (list3 == null) {
                        kotlin.jvm.internal.y.x("dColorList");
                        list3 = null;
                    }
                    for (a aVar2 : list3) {
                        if (aVar2.a()) {
                            cmdValue2 = aVar2.b().getCmdValue();
                            List list4 = this.f11721i;
                            if (list4 == null) {
                                kotlin.jvm.internal.y.x("sColorList");
                            } else {
                                list2 = list4;
                            }
                            for (a aVar3 : list2) {
                                if (aVar3.a()) {
                                    cmdValue3 = aVar3.b().getCmdValue();
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        cmdValue = D0()[0].getCmdValue();
        cmdValue2 = D0()[1].getCmdValue();
        cmdValue3 = D0()[2].getCmdValue();
        DeviceCarInfo deviceCarInfo = b4.a.W().f1933f;
        if (deviceCarInfo.getAmbientLight() == zIsChecked && deviceCarInfo.getLightE() == cmdValue && deviceCarInfo.getLightD() == cmdValue2 && deviceCarInfo.getLightS() == cmdValue3) {
            return;
        }
        f4.b.c("sendAmbientCmd: on=0x%02X e=0x%02X d=0x%02X s=0x%02X", Integer.valueOf(zIsChecked ? 1 : 0), Integer.valueOf(cmdValue), Integer.valueOf(cmdValue2), Integer.valueOf(cmdValue3));
        BaseBindingActivity.Z(this, 94, new byte[]{zIsChecked ? (byte) 1 : (byte) 0, (byte) cmdValue, (byte) cmdValue2, (byte) cmdValue3}, false, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005f A[EDGE_INSN: B:36:0x005f->B:26:0x005f BREAK  A[LOOP:0: B:21:0x004b->B:38:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q0() {
        /*
            r4 = this;
            androidx.databinding.ViewDataBinding r0 = r4.Q()
            com.uz.navee.databinding.ActivityAmbientLightV2Binding r0 = (com.uz.navee.databinding.ActivityAmbientLightV2Binding) r0
            androidx.appcompat.widget.SwitchCompat r0 = r0.scSwitch
            boolean r0 = r0.isChecked()
            if (r0 == 0) goto L7b
            androidx.databinding.ViewDataBinding r0 = r4.Q()
            com.uz.navee.databinding.ActivityAmbientLightV2Binding r0 = (com.uz.navee.databinding.ActivityAmbientLightV2Binding) r0
            androidx.viewpager2.widget.ViewPager2 r0 = r0.vpAmbient
            int r0 = r0.getCurrentItem()
            boolean r1 = r4.E0()
            if (r1 == 0) goto L70
            r1 = 0
            if (r0 == 0) goto L3b
            r2 = 1
            if (r0 == r2) goto L31
            java.util.List r0 = r4.f11721i
            if (r0 != 0) goto L45
            java.lang.String r0 = "sColorList"
            kotlin.jvm.internal.y.x(r0)
        L2f:
            r0 = r1
            goto L45
        L31:
            java.util.List r0 = r4.f11720h
            if (r0 != 0) goto L45
            java.lang.String r0 = "dColorList"
            kotlin.jvm.internal.y.x(r0)
            goto L2f
        L3b:
            java.util.List r0 = r4.f11719g
            if (r0 != 0) goto L45
            java.lang.String r0 = "eColorList"
            kotlin.jvm.internal.y.x(r0)
            goto L2f
        L45:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L4b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L5f
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.uz.navee.ui.device.AmbientLightV2Activity$a r3 = (com.uz.navee.ui.device.AmbientLightV2Activity.a) r3
            boolean r3 = r3.a()
            if (r3 == 0) goto L4b
            r1 = r2
        L5f:
            com.uz.navee.ui.device.AmbientLightV2Activity$a r1 = (com.uz.navee.ui.device.AmbientLightV2Activity.a) r1
            if (r1 == 0) goto L6e
            com.uz.navee.ui.device.AmbientLightV2Activity$AmbientColor r0 = r1.b()
            if (r0 == 0) goto L6e
            int r0 = r0.getCarImg()
            goto L7f
        L6e:
            r0 = 0
            goto L7f
        L70:
            com.uz.navee.ui.device.AmbientLightV2Activity$AmbientMode[] r1 = r4.D0()
            r0 = r1[r0]
            int r0 = r0.getCarImg()
            goto L7f
        L7b:
            int r0 = r4.z0()
        L7f:
            androidx.databinding.ViewDataBinding r1 = r4.Q()
            com.uz.navee.databinding.ActivityAmbientLightV2Binding r1 = (com.uz.navee.databinding.ActivityAmbientLightV2Binding) r1
            androidx.appcompat.widget.AppCompatImageView r1 = r1.ivVehicle
            r1.setImageResource(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uz.navee.ui.device.AmbientLightV2Activity.Q0():void");
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public int V() {
        return R$layout.activity_ambient_light_v2;
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public String b0() {
        String string = getString(R$string.light_settings);
        kotlin.jvm.internal.y.e(string, "getString(...)");
        return string;
    }

    @Override // com.uz.navee.base.BaseBindingActivity, com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        int i6;
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(ContextCompat.getDrawable(this, R$mipmap.bg_ambient));
        ((ActivityAmbientLightV2Binding) Q()).scSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.m
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) throws IOException {
                AmbientLightV2Activity.K0(this.f12583a, compoundButton, z6);
            }
        });
        String strT = T();
        if (strT == null || !kotlin.text.s.D(strT, "2505", false, 2, null)) {
            String strT2 = T();
            i6 = (strT2 == null || !kotlin.text.s.D(strT2, "2506", false, 2, null)) ? R$array.img_ambient_k100 : R$array.img_ambient_k100max;
        } else {
            i6 = R$array.img_ambient_k100pro;
        }
        TypedArray typedArrayObtainTypedArray = getResources().obtainTypedArray(i6);
        kotlin.jvm.internal.y.e(typedArrayObtainTypedArray, "obtainTypedArray(...)");
        int length = typedArrayObtainTypedArray.length();
        int[] iArr = new int[length];
        for (int i7 = 0; i7 < length; i7++) {
            iArr[i7] = typedArrayObtainTypedArray.getResourceId(i7, 0);
        }
        typedArrayObtainTypedArray.recycle();
        if (E0()) {
            x0();
            ((ActivityAmbientLightV2Binding) Q()).vpAmbient.setAdapter(w0());
            u0(iArr);
        } else {
            new ConstraintProperties(((ActivityAmbientLightV2Binding) Q()).vpAmbient).constrainHeight(CommonExt.b(this, 40)).apply();
            ((ActivityAmbientLightV2Binding) Q()).tvTitleVp.setText(R$string.model_title);
            ((ActivityAmbientLightV2Binding) Q()).vpAmbient.setAdapter(y0());
            v0(iArr);
        }
        ((ActivityAmbientLightV2Binding) Q()).vpAmbient.setUserInputEnabled(false);
        final String[] strArr = {getString(R$string.gear_e), getString(R$string.gear_d), getString(R$string.gear_s)};
        new TabLayoutMediator(((ActivityAmbientLightV2Binding) Q()).tbGear, ((ActivityAmbientLightV2Binding) Q()).vpAmbient, true, false, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.uz.navee.ui.device.n
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i8) {
                AmbientLightV2Activity.L0(strArr, tab, i8);
            }
        }).attach();
        ((ActivityAmbientLightV2Binding) Q()).vpAmbient.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.uz.navee.ui.device.AmbientLightV2Activity.onCreate.3
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i8) {
                AmbientLightV2Activity.this.Q0();
            }
        });
        ((ActivityAmbientLightV2Binding) Q()).ivVehicle.setImageResource(z0());
        ((ActivityAmbientLightV2Binding) Q()).lightSelectForegroundView.setOnClickListener(null);
        F0();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        DeviceCarInfo deviceCarInfo = b4.a.W().f1933f;
        PropertyChangeListener propertyChangeListener = this.f11727o;
        PropertyChangeListener propertyChangeListener2 = null;
        if (propertyChangeListener == null) {
            kotlin.jvm.internal.y.x("switchListener");
            propertyChangeListener = null;
        }
        deviceCarInfo.removeListener("ambientLight", propertyChangeListener);
        DeviceCarInfo deviceCarInfo2 = b4.a.W().f1933f;
        PropertyChangeListener propertyChangeListener3 = this.f11728p;
        if (propertyChangeListener3 == null) {
            kotlin.jvm.internal.y.x("lightEListener");
            propertyChangeListener3 = null;
        }
        deviceCarInfo2.removeListener("lightE", propertyChangeListener3);
        DeviceCarInfo deviceCarInfo3 = b4.a.W().f1933f;
        PropertyChangeListener propertyChangeListener4 = this.f11729q;
        if (propertyChangeListener4 == null) {
            kotlin.jvm.internal.y.x("lightDListener");
            propertyChangeListener4 = null;
        }
        deviceCarInfo3.removeListener("lightD", propertyChangeListener4);
        DeviceCarInfo deviceCarInfo4 = b4.a.W().f1933f;
        PropertyChangeListener propertyChangeListener5 = this.f11730r;
        if (propertyChangeListener5 == null) {
            kotlin.jvm.internal.y.x("lightSListener");
        } else {
            propertyChangeListener2 = propertyChangeListener5;
        }
        deviceCarInfo4.removeListener("lightS", propertyChangeListener2);
    }

    public final void u0(int[] iArr) {
        int i6 = 0;
        for (Object obj : AmbientColor.getEntries()) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                kotlin.collections.t.t();
            }
            ((AmbientColor) obj).setCarImg(iArr[i6]);
            i6 = i7;
        }
    }

    public final void v0(int[] iArr) {
        int i6 = 0;
        for (Object obj : AmbientMode.getEntries()) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                kotlin.collections.t.t();
            }
            ((AmbientMode) obj).setCarImg(iArr[i6]);
            i6 = i7;
        }
    }

    public final RecyclerView.Adapter w0() {
        return new RecyclerView.Adapter<ViewHolder>() { // from class: com.uz.navee.ui.device.AmbientLightV2Activity$createColorAdapter$1
            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onBindViewHolder(ViewHolder holder, int i6) {
                kotlin.jvm.internal.y.f(holder, "holder");
                ViewDataBinding binding = holder.getBinding();
                kotlin.jvm.internal.y.d(binding, "null cannot be cast to non-null type com.uz.navee.databinding.LayoutRecyclerviewBinding");
                LayoutRecyclerviewBinding layoutRecyclerviewBinding = (LayoutRecyclerviewBinding) binding;
                if (layoutRecyclerviewBinding.recyclerView.getAdapter() == null) {
                    layoutRecyclerviewBinding.recyclerView.setAdapter(i6 != 0 ? i6 != 1 ? this.f11737a.C0() : this.f11737a.A0() : this.f11737a.B0());
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ViewHolder onCreateViewHolder(ViewGroup parent, int i6) {
                kotlin.jvm.internal.y.f(parent, "parent");
                LayoutRecyclerviewBinding layoutRecyclerviewBinding = (LayoutRecyclerviewBinding) DataBindingUtil.inflate(this.f11737a.getLayoutInflater(), R$layout.layout_recyclerview, parent, false);
                layoutRecyclerviewBinding.recyclerView.setBackgroundResource(R$drawable.bg_ambient_mode);
                layoutRecyclerviewBinding.recyclerView.setLayoutManager(new GridLayoutManager(this.f11737a, 4));
                kotlin.jvm.internal.y.c(layoutRecyclerviewBinding);
                return new ViewHolder(layoutRecyclerviewBinding);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return 3;
            }
        };
    }

    public final void x0() {
        List listS0 = kotlin.collections.b0.s0(AmbientColor.getEntries(), 8);
        ArrayList arrayList = new ArrayList(kotlin.collections.u.u(listS0, 10));
        Iterator it = listS0.iterator();
        while (true) {
            boolean z6 = false;
            if (!it.hasNext()) {
                break;
            }
            AmbientColor ambientColor = (AmbientColor) it.next();
            AmbientGear ambientGear = AmbientGear.E;
            if (ambientColor == AmbientColor.RED) {
                z6 = true;
            }
            arrayList.add(new a(ambientGear, ambientColor, z6));
        }
        this.f11719g = arrayList;
        List<AmbientColor> listS02 = kotlin.collections.b0.s0(AmbientColor.getEntries(), 8);
        ArrayList arrayList2 = new ArrayList(kotlin.collections.u.u(listS02, 10));
        for (AmbientColor ambientColor2 : listS02) {
            arrayList2.add(new a(AmbientGear.D, ambientColor2, ambientColor2 == AmbientColor.BLUE));
        }
        this.f11720h = arrayList2;
        List<AmbientColor> listT0 = kotlin.collections.b0.t0(AmbientColor.getEntries(), 8);
        ArrayList arrayList3 = new ArrayList(kotlin.collections.u.u(listT0, 10));
        for (AmbientColor ambientColor3 : listT0) {
            arrayList3.add(new a(AmbientGear.S, ambientColor3, ambientColor3 == AmbientColor.RED_GREEN));
        }
        this.f11721i = arrayList3;
    }

    public final RecyclerView.Adapter y0() {
        return new AmbientLightV2Activity$createModeAdapter$1(this);
    }

    public final int z0() {
        return ((Number) this.f11725m.getValue()).intValue();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class AmbientColor {
        private static final /* synthetic */ kotlin.enums.a $ENTRIES;
        private static final /* synthetic */ AmbientColor[] $VALUES;
        public static final AmbientColor BLUE;
        public static final AmbientColor BLUE_PURPLE;
        public static final a Companion;
        public static final AmbientColor GREEN;
        public static final AmbientColor LIGHT_BLUE;
        public static final AmbientColor ORANGE;
        public static final AmbientColor ORANGE_LIGHT_BLUE;
        public static final AmbientColor ORANGE_PURPLE;
        public static final AmbientColor PINK;
        public static final AmbientColor PINK_GREEN;
        public static final AmbientColor PURPLE;
        public static final AmbientColor RAINBOW;
        public static final AmbientColor RED = new AmbientColor("RED", 0, R$mipmap.ic_ambient_red_unselected, 1, 0, 4, null);
        public static final AmbientColor RED_BLUE;
        public static final AmbientColor RED_GREEN;
        public static final AmbientColor YELLOW;
        public static final AmbientColor YELLOW_LIGHT_BLUE;
        private int carImg;
        private final int cmdValue;
        private final int colorImg;

        public static final class a {
            public a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.r rVar) {
                this();
            }

            public final AmbientColor a(int i6) {
                Object next;
                Iterator<E> it = AmbientColor.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (((AmbientColor) next).getCmdValue() == i6) {
                        break;
                    }
                }
                AmbientColor ambientColor = (AmbientColor) next;
                return ambientColor == null ? AmbientColor.RED : ambientColor;
            }
        }

        private static final /* synthetic */ AmbientColor[] $values() {
            return new AmbientColor[]{RED, ORANGE, YELLOW, GREEN, LIGHT_BLUE, BLUE, PURPLE, PINK, RED_GREEN, RED_BLUE, ORANGE_LIGHT_BLUE, ORANGE_PURPLE, YELLOW_LIGHT_BLUE, PINK_GREEN, BLUE_PURPLE, RAINBOW};
        }

        static {
            int i6 = 4;
            kotlin.jvm.internal.r rVar = null;
            int i7 = 0;
            ORANGE = new AmbientColor("ORANGE", 1, R$mipmap.ic_ambient_orange, 2, i7, i6, rVar);
            int i8 = 4;
            kotlin.jvm.internal.r rVar2 = null;
            int i9 = 0;
            YELLOW = new AmbientColor("YELLOW", 2, R$mipmap.ic_ambient_yellow, 3, i9, i8, rVar2);
            GREEN = new AmbientColor("GREEN", 3, R$mipmap.ic_ambient_green_unselected, 6, i7, i6, rVar);
            LIGHT_BLUE = new AmbientColor("LIGHT_BLUE", 4, R$mipmap.ic_ambient_light_blue, 5, i9, i8, rVar2);
            BLUE = new AmbientColor("BLUE", 5, R$mipmap.ic_ambient_blue_unselected, 4, i7, i6, rVar);
            PURPLE = new AmbientColor("PURPLE", 6, R$mipmap.ic_ambient_purple_unselected, 7, i9, i8, rVar2);
            PINK = new AmbientColor("PINK", 7, R$mipmap.ic_ambient_pink, 8, i7, i6, rVar);
            RED_GREEN = new AmbientColor("RED_GREEN", 8, R$mipmap.ic_ambient_red_green, 22, i9, i8, rVar2);
            RED_BLUE = new AmbientColor("RED_BLUE", 9, R$mipmap.ic_ambient_red_blue, 20, i7, i6, rVar);
            ORANGE_LIGHT_BLUE = new AmbientColor("ORANGE_LIGHT_BLUE", 10, R$mipmap.ic_ambient_orange_light_blue, 37, i9, i8, rVar2);
            ORANGE_PURPLE = new AmbientColor("ORANGE_PURPLE", 11, R$mipmap.ic_ambient_orange_purple, 39, i7, i6, rVar);
            YELLOW_LIGHT_BLUE = new AmbientColor("YELLOW_LIGHT_BLUE", 12, R$mipmap.ic_ambient_yellow_light_blue, 53, i9, i8, rVar2);
            PINK_GREEN = new AmbientColor("PINK_GREEN", 13, R$mipmap.ic_ambient_pink_green, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, i7, i6, rVar);
            BLUE_PURPLE = new AmbientColor("BLUE_PURPLE", 14, R$mipmap.ic_ambient_blue_purple, 71, i9, i8, rVar2);
            RAINBOW = new AmbientColor("RAINBOW", 15, R$mipmap.ic_ambient_colors_unselected, 64, i7, i6, rVar);
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class AmbientMode {
        private static final /* synthetic */ kotlin.enums.a $ENTRIES;
        private static final /* synthetic */ AmbientMode[] $VALUES;
        public static final a Companion;
        private int carImg;
        private final int cmdValue;
        private final int rbId;
        public static final AmbientMode BREATHING = new AmbientMode("BREATHING", 0, R$id.rb_breathing, 64, 0, 4, null);
        public static final AmbientMode FLOWING = new AmbientMode("FLOWING", 1, R$id.rb_flowing, 48, 0, 4, null);
        public static final AmbientMode RUNNING = new AmbientMode("RUNNING", 2, R$id.rb_running, 80, 0, 4, null);

        public static final class a {
            public a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.r rVar) {
                this();
            }

            public final AmbientMode a(int i6) {
                Object next;
                Iterator<E> it = AmbientMode.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (((AmbientMode) next).getCmdValue() == i6) {
                        break;
                    }
                }
                AmbientMode ambientMode = (AmbientMode) next;
                return ambientMode == null ? AmbientMode.BREATHING : ambientMode;
            }

            public final AmbientMode b(int i6) {
                Object next;
                Iterator<E> it = AmbientMode.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (((AmbientMode) next).getRbId() == i6) {
                        break;
                    }
                }
                AmbientMode ambientMode = (AmbientMode) next;
                return ambientMode == null ? AmbientMode.BREATHING : ambientMode;
            }
        }

        private static final /* synthetic */ AmbientMode[] $values() {
            return new AmbientMode[]{BREATHING, FLOWING, RUNNING};
        }

        static {
            AmbientMode[] ambientModeArr$values = $values();
            $VALUES = ambientModeArr$values;
            $ENTRIES = kotlin.enums.b.a(ambientModeArr$values);
            Companion = new a(null);
        }

        private AmbientMode(@IdRes String str, int i6, @DrawableRes int i7, int i8, int i9) {
            this.rbId = i7;
            this.cmdValue = i8;
            this.carImg = i9;
        }

        public static kotlin.enums.a getEntries() {
            return $ENTRIES;
        }

        public static AmbientMode valueOf(String str) {
            return (AmbientMode) Enum.valueOf(AmbientMode.class, str);
        }

        public static AmbientMode[] values() {
            return (AmbientMode[]) $VALUES.clone();
        }

        public final int getCarImg() {
            return this.carImg;
        }

        public final int getCmdValue() {
            return this.cmdValue;
        }

        public final int getRbId() {
            return this.rbId;
        }

        public final void setCarImg(int i6) {
            this.carImg = i6;
        }

        public /* synthetic */ AmbientMode(String str, int i6, int i7, int i8, int i9, int i10, kotlin.jvm.internal.r rVar) {
            this(str, i6, i7, i8, (i10 & 4) != 0 ? 0 : i9);
        }
    }
}
