package com.uz.navee.ui.device;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MimeTypes;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;
import com.google.common.collect.ImmutableList;
import com.lxj.xpopup.core.CenterPopupView;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class ExoPlayerPopup extends CenterPopupView {
    public LinearLayout A;
    public PlayerView B;
    public Button C;
    public ImageButton D;
    public ImageButton E;
    public Context F;
    public ExoPlayer G;
    public String H;
    public String I;
    public VideoType J;

    /* renamed from: y, reason: collision with root package name */
    public TextView f12356y;

    /* renamed from: z, reason: collision with root package name */
    public TextView f12357z;

    public enum VideoType {
        drivingGuide,
        soldSupport,
        golfGuide
    }

    public ExoPlayerPopup(@NonNull Context context) {
        super(context);
        this.F = context;
    }

    private void P() {
        this.f12356y = (TextView) findViewById(R$id.tv_title);
        this.f12357z = (TextView) findViewById(R$id.tv_jump);
        this.A = (LinearLayout) findViewById(R$id.layout_btn);
        this.B = (PlayerView) findViewById(R$id.exo_player);
        this.C = (Button) findViewById(R$id.btn_replay);
        this.D = (ImageButton) findViewById(R$id.imageBtn_play);
        this.E = (ImageButton) findViewById(R$id.closeButton);
    }

    private void Q() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        this.f12356y.setText(this.I);
        ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(getContext()).build();
        this.G = exoPlayerBuild;
        this.B.setPlayer(exoPlayerBuild);
        if (this.J == VideoType.drivingGuide) {
            String strF = com.uz.navee.utils.d.f();
            File fileE = com.uz.navee.utils.o.e(this.F, "drive_guide_video_" + strF + ".vtt", "temp_subtitle_", ".vtt");
            if (fileE == null) {
                fileE = com.uz.navee.utils.o.e(this.F, "drive_guide_video_en.vtt", "temp_subtitle_", ".vtt");
            }
            if (fileE.exists()) {
                this.G.setMediaItem(new MediaItem.Builder().setUri(this.H).setSubtitleConfigurations(ImmutableList.of(new MediaItem.SubtitleConfiguration.Builder(Uri.fromFile(fileE)).setMimeType(MimeTypes.TEXT_VTT).setLanguage(strF).setSelectionFlags(1).build())).build());
                fileE.deleteOnExit();
            } else {
                this.G.setMediaItem(MediaItem.fromUri(this.H));
            }
        } else {
            this.G.setMediaItem(MediaItem.fromUri(this.H));
        }
        this.G.prepare();
        this.f12357z.getPaint().setFlags(8);
        this.f12357z.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.c7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12487a.R(view);
            }
        });
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.d7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12496a.S(view);
            }
        });
        this.E.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.e7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12507a.T(view);
            }
        });
        this.C.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.f7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12519a.U(view);
            }
        });
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void A() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        super.A();
        P();
        Q();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void B() {
        super.B();
        this.B.onPause();
        this.G.release();
    }

    public final /* synthetic */ void R(View view) {
        m();
        this.B.onPause();
        this.G.release();
    }

    public final /* synthetic */ void S(View view) {
        this.A.setVisibility(4);
        this.E.setVisibility(0);
        this.B.setVisibility(0);
        this.G.play();
    }

    public final /* synthetic */ void T(View view) {
        this.B.onPause();
        this.G.release();
        m();
    }

    public final /* synthetic */ void U(View view) {
        this.A.setVisibility(4);
        this.E.setVisibility(0);
        this.B.setVisibility(0);
        this.G.play();
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        return R$layout.activity_player_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void onDestroy() {
        super.onDestroy();
        this.B.onPause();
        this.G.release();
    }

    public ExoPlayerPopup(Context context, String str, String str2, VideoType videoType) {
        super(context);
        this.F = context;
        this.H = str;
        this.I = str2;
        this.J = videoType;
    }
}
