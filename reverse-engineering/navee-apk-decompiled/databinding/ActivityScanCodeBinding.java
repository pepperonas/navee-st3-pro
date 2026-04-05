package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ActivityScanCodeBinding implements ViewBinding {

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final ZXingView zxingView;

    private ActivityScanCodeBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ZXingView zXingView) {
        this.rootView = constraintLayout;
        this.zxingView = zXingView;
    }

    @NonNull
    public static ActivityScanCodeBinding bind(@NonNull View view) {
        int i6 = R$id.zxing_view;
        ZXingView zXingView = (ZXingView) ViewBindings.findChildViewById(view, i6);
        if (zXingView != null) {
            return new ActivityScanCodeBinding((ConstraintLayout) view, zXingView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ActivityScanCodeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityScanCodeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_scan_code, viewGroup, false);
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
