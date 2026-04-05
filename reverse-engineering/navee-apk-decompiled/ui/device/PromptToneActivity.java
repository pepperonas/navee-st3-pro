package com.uz.navee.ui.device;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.ViewGroupKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseBindingActivity;
import com.uz.navee.databinding.ActivityPromptToneBinding;
import com.uz.navee.utils.CommonExt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class PromptToneActivity extends BaseBindingActivity<ActivityPromptToneBinding> {

    /* renamed from: g, reason: collision with root package name */
    public final kotlin.f f12400g = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.PromptToneActivity$audioIndex$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Integer> invoke() {
            PromptToneActivity promptToneActivity = this.this$0;
            return CommonExt.k(promptToneActivity, Integer.valueOf(promptToneActivity.R().getVolume()), "volume");
        }
    });

    /* renamed from: h, reason: collision with root package name */
    public final List f12401h = new ArrayList();

    public static final class a implements Observer, kotlin.jvm.internal.u {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q5.l f12402a;

        public a(q5.l function) {
            kotlin.jvm.internal.y.f(function, "function");
            this.f12402a = function;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.u)) {
                return kotlin.jvm.internal.y.a(getFunctionDelegate(), ((kotlin.jvm.internal.u) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.u
        public final kotlin.c getFunctionDelegate() {
            return this.f12402a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f12402a.invoke(obj);
        }
    }

    public static final void g0(PromptToneActivity this$0, RadioGroup radioGroup, int i6) throws IOException {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        Iterator it = this$0.f12401h.iterator();
        int i7 = 0;
        while (true) {
            if (!it.hasNext()) {
                i7 = -1;
                break;
            } else if (((RadioButton) it.next()).getId() == i6) {
                break;
            } else {
                i7++;
            }
        }
        int i8 = i7;
        Integer num = (Integer) this$0.f0().getValue();
        if (num != null && i8 == num.intValue()) {
            return;
        }
        BaseBindingActivity.Y(this$0, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, i8, false, 4, null);
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public int V() {
        return R$layout.activity_prompt_tone;
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public String b0() {
        String string = getString(R$string.prompt_tone);
        kotlin.jvm.internal.y.e(string, "getString(...)");
        return string;
    }

    public final LiveData f0() {
        return (LiveData) this.f12400g.getValue();
    }

    @Override // com.uz.navee.base.BaseBindingActivity, com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RadioGroup rgAudio = ((ActivityPromptToneBinding) Q()).rgAudio;
        kotlin.jvm.internal.y.e(rgAudio, "rgAudio");
        int i6 = 0;
        for (Object obj : ViewGroupKt.getChildren(rgAudio)) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                kotlin.collections.t.t();
            }
            View view = (View) obj;
            kotlin.jvm.internal.y.d(view, "null cannot be cast to non-null type android.widget.RadioButton");
            ((RadioButton) view).setText(getString(R$string.sound_effects) + i7);
            this.f12401h.add(view);
            i6 = i7;
        }
        ((ActivityPromptToneBinding) Q()).rgAudio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.c8
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i8) throws IOException {
                PromptToneActivity.g0(this.f12488a, radioGroup, i8);
            }
        });
        f0().observe(this, new a(new q5.l() { // from class: com.uz.navee.ui.device.PromptToneActivity.onCreate.3
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke((Integer) obj2);
                return kotlin.u.f15726a;
            }

            public final void invoke(Integer num) {
                List list = PromptToneActivity.this.f12401h;
                kotlin.jvm.internal.y.c(num);
                RadioButton radioButton = (RadioButton) kotlin.collections.b0.b0(list, num.intValue());
                if (radioButton == null) {
                    return;
                }
                radioButton.setChecked(true);
            }
        }));
    }
}
