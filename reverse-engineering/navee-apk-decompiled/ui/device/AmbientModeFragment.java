package com.uz.navee.ui.device;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class AmbientModeFragment extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f11760a;

    /* renamed from: b, reason: collision with root package name */
    public ImageButton f11761b;

    /* renamed from: c, reason: collision with root package name */
    public ImageButton f11762c;

    /* renamed from: d, reason: collision with root package name */
    public ImageButton f11763d;

    /* renamed from: e, reason: collision with root package name */
    public ImageButton f11764e;

    /* renamed from: f, reason: collision with root package name */
    public ImageButton f11765f;

    /* renamed from: g, reason: collision with root package name */
    public AmbientMode f11766g;

    /* renamed from: h, reason: collision with root package name */
    public a f11767h;

    public enum AmbientMode {
        alwaysOn,
        breathing,
        flowingWater,
        horseRacing
    }

    public interface a {
        void a(int i6);

        void b(int i6, int i7);
    }

    public final void g(View view) {
        this.f11760a = (ViewGroup) view.findViewById(R$id.colorLayout);
        this.f11761b = (ImageButton) view.findViewById(R$id.redButton);
        this.f11762c = (ImageButton) view.findViewById(R$id.greenButton);
        this.f11763d = (ImageButton) view.findViewById(R$id.blueButton);
        this.f11764e = (ImageButton) view.findViewById(R$id.purpleButton);
        this.f11765f = (ImageButton) view.findViewById(R$id.colorsButton);
    }

    public final /* synthetic */ void h(View view) {
        if (view.isSelected()) {
            return;
        }
        a aVar = this.f11767h;
        if (aVar != null) {
            aVar.b(this.f11766g.ordinal(), 0);
        }
        view.setSelected(true);
    }

    public final /* synthetic */ void i(View view) {
        if (view.isSelected()) {
            return;
        }
        a aVar = this.f11767h;
        if (aVar != null) {
            aVar.b(this.f11766g.ordinal(), 1);
        }
        view.setSelected(true);
    }

    public final /* synthetic */ void j(View view) {
        if (view.isSelected()) {
            return;
        }
        a aVar = this.f11767h;
        if (aVar != null) {
            aVar.b(this.f11766g.ordinal(), 2);
        }
        view.setSelected(true);
    }

    public final /* synthetic */ void k(View view) {
        if (view.isSelected()) {
            return;
        }
        a aVar = this.f11767h;
        if (aVar != null) {
            aVar.b(this.f11766g.ordinal(), 3);
        }
        view.setSelected(true);
    }

    public final /* synthetic */ void l(View view) {
        if (view.isSelected()) {
            return;
        }
        a aVar = this.f11767h;
        if (aVar != null) {
            AmbientMode ambientMode = this.f11766g;
            if (ambientMode == AmbientMode.horseRacing) {
                aVar.b(ambientMode.ordinal(), 0);
            } else {
                aVar.b(ambientMode.ordinal(), 4);
            }
        }
        view.setSelected(true);
    }

    public void m(int i6, int i7) {
        ImageButton imageButton = this.f11761b;
        if (imageButton != null) {
            imageButton.setSelected(false);
        }
        ImageButton imageButton2 = this.f11762c;
        if (imageButton2 != null) {
            imageButton2.setSelected(false);
        }
        ImageButton imageButton3 = this.f11763d;
        if (imageButton3 != null) {
            imageButton3.setSelected(false);
        }
        ImageButton imageButton4 = this.f11764e;
        if (imageButton4 != null) {
            imageButton4.setSelected(false);
        }
        ImageButton imageButton5 = this.f11765f;
        if (imageButton5 != null) {
            imageButton5.setSelected(false);
        }
        if (i6 != this.f11766g.ordinal() || i7 >= this.f11760a.getChildCount()) {
            return;
        }
        View childAt = this.f11760a.getChildAt(i7);
        if (childAt instanceof ImageButton) {
            childAt.setSelected(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_ambient_mode, viewGroup, false);
        g(viewInflate);
        this.f11761b.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12685a.h(view);
            }
        });
        this.f11762c.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12695a.i(view);
            }
        });
        this.f11763d.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12706a.j(view);
            }
        });
        this.f11764e.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12716a.k(view);
            }
        });
        this.f11765f.setOnClickListener(new View.OnClickListener() { // from class: com.uz.navee.ui.device.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12462a.l(view);
            }
        });
        AmbientMode ambientMode = this.f11766g;
        if (ambientMode == AmbientMode.alwaysOn) {
            this.f11760a.removeView(this.f11765f);
        } else if (ambientMode == AmbientMode.horseRacing) {
            this.f11760a.removeView(this.f11761b);
            this.f11760a.removeView(this.f11762c);
            this.f11760a.removeView(this.f11763d);
            this.f11760a.removeView(this.f11764e);
        }
        a aVar = this.f11767h;
        if (aVar != null) {
            aVar.a(this.f11766g.ordinal());
        }
        return viewInflate;
    }
}
