package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public abstract class ActivityPromptToneBinding extends ViewDataBinding {

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final RadioButton rbAudio1;

    @NonNull
    public final RadioButton rbAudio2;

    @NonNull
    public final RadioButton rbAudio3;

    @NonNull
    public final RadioButton rbAudio4;

    @NonNull
    public final RadioButton rbAudio5;

    @NonNull
    public final RadioGroup rgAudio;

    public ActivityPromptToneBinding(Object obj, View view, int i6, ToolbarBinding toolbarBinding, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioGroup radioGroup) {
        super(obj, view, i6);
        this.include = toolbarBinding;
        this.rbAudio1 = radioButton;
        this.rbAudio2 = radioButton2;
        this.rbAudio3 = radioButton3;
        this.rbAudio4 = radioButton4;
        this.rbAudio5 = radioButton5;
        this.rgAudio = radioGroup;
    }

    public static ActivityPromptToneBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityPromptToneBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        return inflate(layoutInflater, viewGroup, z6, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPromptToneBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityPromptToneBinding) ViewDataBinding.bind(obj, view, R$layout.activity_prompt_tone);
    }

    @NonNull
    @Deprecated
    public static ActivityPromptToneBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6, @Nullable Object obj) {
        return (ActivityPromptToneBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_prompt_tone, viewGroup, z6, obj);
    }

    @NonNull
    public static ActivityPromptToneBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityPromptToneBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityPromptToneBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_prompt_tone, null, false, obj);
    }
}
