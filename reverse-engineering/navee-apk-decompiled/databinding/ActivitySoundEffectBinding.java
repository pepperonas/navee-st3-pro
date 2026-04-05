package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public abstract class ActivitySoundEffectBinding extends ViewDataBinding {

    @NonNull
    public final Group groupSetting;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final AppCompatImageView ivVolume;

    @NonNull
    public final Layer layerVolumeSetting;

    @NonNull
    public final RadioButton rbChinese;

    @NonNull
    public final RadioButton rbEnglish;

    @NonNull
    public final RadioGroup rgLanguage;

    @NonNull
    public final AppCompatSeekBar sbVolume;

    @NonNull
    public final SwitchCompat scVolume;

    @NonNull
    public final TextView tvTitleLanguage;

    @NonNull
    public final TextView tvUnit;

    @NonNull
    public final TextView tvVolume;

    @NonNull
    public final TextView tvVolumeSetting;

    public ActivitySoundEffectBinding(Object obj, View view, int i6, Group group, ToolbarBinding toolbarBinding, AppCompatImageView appCompatImageView, Layer layer, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, AppCompatSeekBar appCompatSeekBar, SwitchCompat switchCompat, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i6);
        this.groupSetting = group;
        this.include = toolbarBinding;
        this.ivVolume = appCompatImageView;
        this.layerVolumeSetting = layer;
        this.rbChinese = radioButton;
        this.rbEnglish = radioButton2;
        this.rgLanguage = radioGroup;
        this.sbVolume = appCompatSeekBar;
        this.scVolume = switchCompat;
        this.tvTitleLanguage = textView;
        this.tvUnit = textView2;
        this.tvVolume = textView3;
        this.tvVolumeSetting = textView4;
    }

    public static ActivitySoundEffectBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivitySoundEffectBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySoundEffectBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivitySoundEffectBinding) ViewDataBinding.bind(obj, view, R$layout.activity_sound_effect);
    }

    @NonNull
    @Deprecated
    public static ActivitySoundEffectBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ActivitySoundEffectBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_sound_effect, viewGroup, z6, obj);
    }

    @NonNull
    public static ActivitySoundEffectBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivitySoundEffectBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivitySoundEffectBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_sound_effect, null, false, obj);
    }
}
