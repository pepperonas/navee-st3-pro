package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
public final class ActivityDeviceBindBinding implements ViewBinding {

    @NonNull
    public final ImageButton bluetoothButton;

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final ImageView ovalView1;

    @NonNull
    public final ImageView ovalView2;

    @NonNull
    public final ImageView ovalView3;

    @NonNull
    public final ImageView ovalView4;

    @NonNull
    public final RecyclerView recyclerView;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final Button scanDeviceButton;

    @NonNull
    public final TextView scanningSubTextLabel;

    @NonNull
    public final TextView scanningTextLabel;

    @NonNull
    public final LinearLayout scanningView;

    @NonNull
    public final TextView unScannedTitleLabel;

    @NonNull
    public final TextView unScannedTitleLabel1;

    @NonNull
    public final TextView unScannedTitleLabel2;

    @NonNull
    public final TextView unScannedTitleLabel3;

    @NonNull
    public final TextView unScannedTitleLabel4;

    @NonNull
    public final LinearLayout unScannedView;

    private ActivityDeviceBindBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageButton imageButton, @NonNull ToolbarBinding toolbarBinding, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull RecyclerView recyclerView, @NonNull Button button, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull LinearLayout linearLayout2) {
        this.rootView = constraintLayout;
        this.bluetoothButton = imageButton;
        this.include = toolbarBinding;
        this.ovalView1 = imageView;
        this.ovalView2 = imageView2;
        this.ovalView3 = imageView3;
        this.ovalView4 = imageView4;
        this.recyclerView = recyclerView;
        this.scanDeviceButton = button;
        this.scanningSubTextLabel = textView;
        this.scanningTextLabel = textView2;
        this.scanningView = linearLayout;
        this.unScannedTitleLabel = textView3;
        this.unScannedTitleLabel1 = textView4;
        this.unScannedTitleLabel2 = textView5;
        this.unScannedTitleLabel3 = textView6;
        this.unScannedTitleLabel4 = textView7;
        this.unScannedView = linearLayout2;
    }

    @NonNull
    public static ActivityDeviceBindBinding bind(@NonNull View view) {
        View viewFindChildViewById;
        int i6 = R$id.bluetoothButton;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i6);
        if (imageButton != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i6 = R$id.include))) != null) {
            ToolbarBinding toolbarBindingBind = ToolbarBinding.bind(viewFindChildViewById);
            i6 = R$id.ovalView1;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i6);
            if (imageView != null) {
                i6 = R$id.ovalView2;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i6);
                if (imageView2 != null) {
                    i6 = R$id.ovalView3;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i6);
                    if (imageView3 != null) {
                        i6 = R$id.ovalView4;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i6);
                        if (imageView4 != null) {
                            i6 = R$id.recyclerView;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i6);
                            if (recyclerView != null) {
                                i6 = R$id.scanDeviceButton;
                                Button button = (Button) ViewBindings.findChildViewById(view, i6);
                                if (button != null) {
                                    i6 = R$id.scanningSubTextLabel;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
                                    if (textView != null) {
                                        i6 = R$id.scanningTextLabel;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                                        if (textView2 != null) {
                                            i6 = R$id.scanningView;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                            if (linearLayout != null) {
                                                i6 = R$id.unScannedTitleLabel;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                if (textView3 != null) {
                                                    i6 = R$id.unScannedTitleLabel1;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                    if (textView4 != null) {
                                                        i6 = R$id.unScannedTitleLabel2;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                        if (textView5 != null) {
                                                            i6 = R$id.unScannedTitleLabel3;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                            if (textView6 != null) {
                                                                i6 = R$id.unScannedTitleLabel4;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i6);
                                                                if (textView7 != null) {
                                                                    i6 = R$id.unScannedView;
                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                                                                    if (linearLayout2 != null) {
                                                                        return new ActivityDeviceBindBinding((ConstraintLayout) view, imageButton, toolbarBindingBind, imageView, imageView2, imageView3, imageView4, recyclerView, button, textView, textView2, linearLayout, textView3, textView4, textView5, textView6, textView7, linearLayout2);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
    public static ActivityDeviceBindBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityDeviceBindBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_device_bind, viewGroup, false);
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
