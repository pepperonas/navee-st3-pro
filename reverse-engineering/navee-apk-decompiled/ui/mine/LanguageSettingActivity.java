package com.uz.navee.ui.mine;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.uz.navee.R$color;
import com.uz.navee.R$drawable;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.R$mipmap;
import com.uz.navee.R$string;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.ui.mine.LanguageSettingActivity;
import com.uz.navee.utils.DensityUtil;
import com.uz.navee.utils.Language;
import com.uz.navee.utils.c;
import com.uz.navee.utils.d;
import com.uz.navee.utils.g0;
import java.util.ArrayList;
import java.util.List;
import kotlin.enums.a;

@SuppressLint({"NonConstantResourceId"})
/* loaded from: classes3.dex */
public class LanguageSettingActivity extends BaseActivity {

    /* renamed from: c, reason: collision with root package name */
    public QMUIGroupListView f13035c;

    /* renamed from: d, reason: collision with root package name */
    public SwitchCompat f13036d;

    /* renamed from: e, reason: collision with root package name */
    public Language f13037e;

    /* renamed from: f, reason: collision with root package name */
    public Language f13038f;

    /* renamed from: g, reason: collision with root package name */
    public final List f13039g = new ArrayList();

    private void T() {
        this.f13035c = (QMUIGroupListView) findViewById(R$id.groupListView);
    }

    private void U() throws Resources.NotFoundException {
        int iA = DensityUtil.a(this, 16.0f);
        QMUICommonListItemView qMUICommonListItemViewC = this.f13035c.c(null, getString(R$string.follow_system_default), "", 1, 3);
        qMUICommonListItemViewC.setRadius(iA);
        SwitchCompat switchCompat = new SwitchCompat(this);
        this.f13036d = switchCompat;
        switchCompat.setThumbResource(R$drawable.switch_thumb);
        this.f13036d.setTrackResource(R$drawable.switch_track);
        qMUICommonListItemViewC.l(this.f13036d);
        this.f13036d.setChecked(true);
        if (this.f13038f != Language.FOLLOW) {
            this.f13036d.setChecked(false);
        }
        this.f13036d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: h4.x0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) {
                this.f13835a.V(compoundButton, z6);
            }
        });
        QMUIGroupListView.e(this).c(qMUICommonListItemViewC, new View.OnClickListener() { // from class: h4.y0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LanguageSettingActivity.W(view);
            }
        }).e(this.f13035c);
        this.f13039g.add(qMUICommonListItemViewC);
        QMUIGroupListView.a aVarE = QMUIGroupListView.e(this);
        a entries = Language.getEntries();
        for (int i6 = 1; i6 < entries.size(); i6++) {
            final Language language = (Language) entries.get(i6);
            QMUICommonListItemView qMUICommonListItemViewC2 = this.f13035c.c(null, language.getTitle(), "", 1, 3);
            if (i6 == 1) {
                qMUICommonListItemViewC2.e(iA, 3);
            } else if (i6 == entries.size() - 1) {
                qMUICommonListItemViewC2.e(iA, 1);
            }
            Z(qMUICommonListItemViewC2, language == this.f13037e);
            aVarE.c(qMUICommonListItemViewC2, new View.OnClickListener() { // from class: h4.z0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f13839a.X(language, view);
                }
            });
            this.f13039g.add(qMUICommonListItemViewC2);
        }
        aVarE.g(iA, iA).e(this.f13035c);
        if (d.p(this)) {
            d.b(this.f13035c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W(View view) {
    }

    public final /* synthetic */ void V(CompoundButton compoundButton, boolean z6) {
        if (z6) {
            Y(Language.FOLLOW);
        } else {
            Y(this.f13037e);
        }
    }

    public final /* synthetic */ void X(Language language, View view) {
        if (this.f13036d.isChecked()) {
            return;
        }
        Y(language);
    }

    public final void Y(Language language) {
        if (language != this.f13038f) {
            g0.f("is_follow_system", Boolean.valueOf(language == Language.FOLLOW));
            g0.f("current_language", language.getLanguageTag());
            language.save();
            b4.a.W().f1935h = new ArrayList();
        }
    }

    public final void Z(QMUICommonListItemView qMUICommonListItemView, boolean z6) {
        if (!z6) {
            qMUICommonListItemView.setAccessoryType(0);
            return;
        }
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, R$mipmap.ic_check));
        qMUICommonListItemView.setAccessoryType(3);
        qMUICommonListItemView.l(imageView);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setContentView(R$layout.activity_language_setting);
        T();
        c.e(this, getString(R$string.language_selection), ContextCompat.getColor(this, R$color.nav_title_color));
        this.f13038f = Language.current();
        this.f13037e = Language.lang();
        U();
    }
}
