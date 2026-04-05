package com.uz.navee.ui.device;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.uz.navee.R$layout;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseBindingActivity;
import com.uz.navee.databinding.ActivitySoundEffectBinding;
import com.uz.navee.utils.CommonExt;
import java.io.IOException;
import kotlin.Pair;

/* loaded from: classes3.dex */
public final class SoundEffectActivity extends BaseBindingActivity<ActivitySoundEffectBinding> {

    /* renamed from: g, reason: collision with root package name */
    public final kotlin.f f12437g = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.SoundEffectActivity$volume$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Integer> invoke() {
            return CommonExt.k(this.this$0, Integer.valueOf(b4.a.W().f1933f.getVolume()), "volume");
        }
    });

    /* renamed from: h, reason: collision with root package name */
    public final kotlin.f f12438h = kotlin.h.b(new q5.a() { // from class: com.uz.navee.ui.device.SoundEffectActivity$language$2
        {
            super(0);
        }

        @Override // q5.a
        public final LiveData<Integer> invoke() {
            return CommonExt.k(this.this$0, Integer.valueOf(b4.a.W().f1933f.getReportLanguage()), "reportLanguage");
        }
    });

    public static final class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar sv, int i6, boolean z6) {
            kotlin.jvm.internal.y.f(sv, "sv");
            SoundEffectActivity.e0(SoundEffectActivity.this).tvVolume.setText(String.valueOf(i6));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar sb) throws IOException {
            kotlin.jvm.internal.y.f(sb, "sb");
            SoundEffectActivity.this.l0();
        }
    }

    public static final class b implements Observer, kotlin.jvm.internal.u {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q5.l f12440a;

        public b(q5.l function) {
            kotlin.jvm.internal.y.f(function, "function");
            this.f12440a = function;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.u)) {
                return kotlin.jvm.internal.y.a(getFunctionDelegate(), ((kotlin.jvm.internal.u) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.u
        public final kotlin.c getFunctionDelegate() {
            return this.f12440a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f12440a.invoke(obj);
        }
    }

    public static final /* synthetic */ ActivitySoundEffectBinding e0(SoundEffectActivity soundEffectActivity) {
        return (ActivitySoundEffectBinding) soundEffectActivity.Q();
    }

    public static final void j0(SoundEffectActivity this$0, CompoundButton compoundButton, boolean z6) throws IOException {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        Group groupSetting = ((ActivitySoundEffectBinding) this$0.Q()).groupSetting;
        kotlin.jvm.internal.y.e(groupSetting, "groupSetting");
        groupSetting.setVisibility(z6 ? 0 : 8);
        this$0.l0();
    }

    public static final void k0(SoundEffectActivity this$0, RadioGroup radioGroup, int i6) throws IOException {
        kotlin.jvm.internal.y.f(this$0, "this$0");
        this$0.l0();
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public int V() {
        return R$layout.activity_sound_effect;
    }

    @Override // com.uz.navee.base.BaseBindingActivity
    public String b0() {
        String string = getString(R$string.sound_effect_settings);
        kotlin.jvm.internal.y.e(string, "getString(...)");
        return string;
    }

    public final LiveData g0() {
        return (LiveData) this.f12438h.getValue();
    }

    public final LiveData h0() {
        return (LiveData) this.f12437g.getValue();
    }

    public final void i0() {
        CommonExt.u(h0(), g0()).observe(this, new b(new q5.l() { // from class: com.uz.navee.ui.device.SoundEffectActivity$observer$1
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) throws Resources.NotFoundException {
                invoke((Pair<Integer, Integer>) obj);
                return kotlin.u.f15726a;
            }

            public final void invoke(Pair<Integer, Integer> pair) throws Resources.NotFoundException {
                int iIntValue = pair.getFirst().intValue();
                int iIntValue2 = pair.getSecond().intValue();
                boolean z6 = ((iIntValue & 128) >> 7) == 1;
                ActivitySoundEffectBinding activitySoundEffectBindingE0 = SoundEffectActivity.e0(this.this$0);
                SoundEffectActivity soundEffectActivity = this.this$0;
                activitySoundEffectBindingE0.sbVolume.setProgress(iIntValue & 127);
                activitySoundEffectBindingE0.scVolume.setChecked(z6);
                (iIntValue2 == 0 ? SoundEffectActivity.e0(soundEffectActivity).rbChinese : SoundEffectActivity.e0(soundEffectActivity).rbEnglish).setChecked(true);
            }
        }));
    }

    public final void l0() throws IOException {
        boolean zIsChecked = ((ActivitySoundEffectBinding) Q()).scVolume.isChecked();
        int progress = zIsChecked ? ((ActivitySoundEffectBinding) Q()).sbVolume.getProgress() | 128 : 0;
        int i6 = !((ActivitySoundEffectBinding) Q()).rbChinese.isChecked() ? 1 : 0;
        if ((((b4.a.W().f1933f.getVolume() & 128) >> 7) == 1) != zIsChecked || ((zIsChecked && progress != b4.a.W().f1933f.getVolume()) || i6 != b4.a.W().f1933f.getReportLanguage())) {
            BaseBindingActivity.Z(this, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, new byte[]{(byte) progress, (byte) i6}, false, 4, null);
        }
    }

    @Override // com.uz.navee.base.BaseBindingActivity, com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((ActivitySoundEffectBinding) Q()).scVolume.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.j8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) throws IOException {
                SoundEffectActivity.j0(this.f12562a, compoundButton, z6);
            }
        });
        ((ActivitySoundEffectBinding) Q()).sbVolume.setOnSeekBarChangeListener(new a());
        ((ActivitySoundEffectBinding) Q()).sbVolume.setProgress(80);
        ((ActivitySoundEffectBinding) Q()).rgLanguage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.uz.navee.ui.device.k8
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i6) throws IOException {
                SoundEffectActivity.k0(this.f12571a, radioGroup, i6);
            }
        });
        i0();
    }
}
