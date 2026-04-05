package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ActivityDeviceFirmwareUpdateBinding implements ViewBinding {

    @NonNull
    public final TextView failSubTextLabel;

    @NonNull
    public final TextView failTextLabel;

    @NonNull
    public final ImageView imageView;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final TextView progressLabel;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final RecyclerView rvContent;

    @NonNull
    public final TextView subTextLabel;

    @NonNull
    public final TextView textLabel;

    @NonNull
    public final TextView tvUpdate;

    @NonNull
    public final Button updateButton;

    private ActivityDeviceFirmwareUpdateBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull ToolbarBinding toolbarBinding, @NonNull TextView textView3, @NonNull RecyclerView recyclerView, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull Button button) {
        this.rootView = constraintLayout;
        this.failSubTextLabel = textView;
        this.failTextLabel = textView2;
        this.imageView = imageView;
        this.include = toolbarBinding;
        this.progressLabel = textView3;
        this.rvContent = recyclerView;
        this.subTextLabel = textView4;
        this.textLabel = textView5;
        this.tvUpdate = textView6;
        this.updateButton = button;
    }

    @NonNull
    public static ActivityDeviceFirmwareUpdateBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.failSubTextLabel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
        if (textView != null) {
            i6 = R$id.failTextLabel;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
            if (textView2 != null) {
                i6 = R$id.imageView;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
                if (imageView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.include))) != null) {
                    ToolbarBinding toolbarBindingBind = ToolbarBinding.bind(viewFindChildViewById);
                    i6 = R$id.progressLabel;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i6);
                    if (textView3 != null) {
                        i6 = R$id.rvContent;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i6);
                        if (recyclerView != null) {
                            i6 = R$id.subTextLabel;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i6);
                            if (textView4 != null) {
                                i6 = R$id.textLabel;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i6);
                                if (textView5 != null) {
                                    i6 = R$id.tvUpdate;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i6);
                                    if (textView6 != null) {
                                        i6 = R$id.updateButton;
                                        Button button = (Button) ViewBindings.findChildViewById(view, i6);
                                        if (button != null) {
                                            return new ActivityDeviceFirmwareUpdateBinding((ConstraintLayout) view, textView, textView2, imageView, toolbarBindingBind, textView3, recyclerView, textView4, textView5, textView6, button);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ActivityDeviceFirmwareUpdateBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityDeviceFirmwareUpdateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_device_firmware_update, viewGroup, false);
        if (z6) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
