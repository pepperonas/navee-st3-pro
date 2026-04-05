package com.uz.navee.ui.device;

import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.uz.navee.R$layout;
import com.uz.navee.base.ViewHolder;
import com.uz.navee.databinding.LayoutAmbientModePageBinding;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class AmbientLightV2Activity$createModeAdapter$1 extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AmbientLightV2Activity f11738a;

    public AmbientLightV2Activity$createModeAdapter$1(AmbientLightV2Activity ambientLightV2Activity) {
        this.f11738a = ambientLightV2Activity;
    }

    public static final void c(AmbientLightV2Activity this$0, int i6, RadioGroup radioGroup, int i7) throws IOException {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        if (this$0.O0(i6, i7)) {
            this$0.P0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ViewHolder holder, final int i6) {
        kotlin.jvm.internal.y.f(holder, "holder");
        ViewDataBinding binding = holder.getBinding();
        kotlin.jvm.internal.y.d(binding, "null cannot be cast to non-null type com.uz.navee.databinding.LayoutAmbientModePageBinding");
        LayoutAmbientModePageBinding layoutAmbientModePageBinding = (LayoutAmbientModePageBinding) binding;
        layoutAmbientModePageBinding.rgMode.setOnCheckedChangeListener(null);
        layoutAmbientModePageBinding.rgMode.check(this.f11738a.D0()[i6].getRbId());
        RadioGroup radioGroup = layoutAmbientModePageBinding.rgMode;
        final AmbientLightV2Activity ambientLightV2Activity = this.f11738a;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.t
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i7) throws IOException {
                AmbientLightV2Activity$createModeAdapter$1.c(ambientLightV2Activity, i6, radioGroup2, i7);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i6) {
        kotlin.jvm.internal.y.f(parent, "parent");
        LayoutAmbientModePageBinding layoutAmbientModePageBinding = (LayoutAmbientModePageBinding) DataBindingUtil.inflate(this.f11738a.getLayoutInflater(), R$layout.layout_ambient_mode_page, parent, false);
        kotlin.jvm.internal.y.c(layoutAmbientModePageBinding);
        return new ViewHolder(layoutAmbientModePageBinding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 3;
    }
}
