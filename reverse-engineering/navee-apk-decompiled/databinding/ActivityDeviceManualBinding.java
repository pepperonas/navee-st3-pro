package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.rajat.pdfviewer.PdfRendererView;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ActivityDeviceManualBinding implements ViewBinding {

    @NonNull
    public final ToolbarBinding include;

    @NonNull
    public final PdfRendererView pdfView;

    @NonNull
    public final ProgressBar progressBar;

    @NonNull
    private final ConstraintLayout rootView;

    private ActivityDeviceManualBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ToolbarBinding toolbarBinding, @NonNull PdfRendererView pdfRendererView, @NonNull ProgressBar progressBar) {
        this.rootView = constraintLayout;
        this.include = toolbarBinding;
        this.pdfView = pdfRendererView;
        this.progressBar = progressBar;
    }

    @NonNull
    public static ActivityDeviceManualBinding bind(@NonNull View view) {
        int i6 = R$id.include;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, i6);
        if (viewFindChildViewById != null) {
            ToolbarBinding toolbarBindingBind = ToolbarBinding.bind(viewFindChildViewById);
            int i7 = R$id.pdfView;
            PdfRendererView pdfRendererView = (PdfRendererView) ViewBindings.findChildViewById(view, i7);
            if (pdfRendererView != null) {
                i7 = R$id.progress_bar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i7);
                if (progressBar != null) {
                    return new ActivityDeviceManualBinding((ConstraintLayout) view, toolbarBindingBind, pdfRendererView, progressBar);
                }
            }
            i6 = i7;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i6)));
    }

    @NonNull
    public static ActivityDeviceManualBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityDeviceManualBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_device_manual, viewGroup, false);
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
