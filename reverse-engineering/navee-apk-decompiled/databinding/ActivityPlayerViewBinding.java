package com.uz.navee.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.ui.PlayerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

/* loaded from: classes3.dex */
public final class ActivityPlayerViewBinding implements ViewBinding {

    @NonNull
    public final Button btnReplay;

    @NonNull
    public final ImageButton closeButton;

    @NonNull
    public final PlayerView exoPlayer;

    @NonNull
    public final ImageButton imageBtnPlay;

    @NonNull
    public final LinearLayout layoutBtn;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView tvJump;

    @NonNull
    public final TextView tvTitle;

    private ActivityPlayerViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Button button, @NonNull ImageButton imageButton, @NonNull PlayerView playerView, @NonNull ImageButton imageButton2, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.btnReplay = button;
        this.closeButton = imageButton;
        this.exoPlayer = playerView;
        this.imageBtnPlay = imageButton2;
        this.layoutBtn = linearLayout;
        this.tvJump = textView;
        this.tvTitle = textView2;
    }

    @NonNull
    public static ActivityPlayerViewBinding bind(@NonNull View view) {
        int i6 = R$id.btn_replay;
        Button button = (Button) ViewBindings.findChildViewById(view, i6);
        if (button != null) {
            i6 = R$id.closeButton;
            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i6);
            if (imageButton != null) {
                i6 = R$id.exo_player;
                PlayerView playerView = (PlayerView) ViewBindings.findChildViewById(view, i6);
                if (playerView != null) {
                    i6 = R$id.imageBtn_play;
                    ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, i6);
                    if (imageButton2 != null) {
                        i6 = R$id.layout_btn;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i6);
                        if (linearLayout != null) {
                            i6 = R$id.tv_jump;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i6);
                            if (textView != null) {
                                i6 = R$id.tv_title;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i6);
                                if (textView2 != null) {
                                    return new ActivityPlayerViewBinding((ConstraintLayout) view, button, imageButton, playerView, imageButton2, linearLayout, textView, textView2);
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
    public static ActivityPlayerViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityPlayerViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z6) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_player_view, viewGroup, false);
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
