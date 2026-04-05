package com.uz.navee.utils;

import android.content.Context;
import androidx.appcompat.widget.SwitchCompat;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.uz.navee.R$drawable;
import kotlin.Pair;

/* loaded from: classes3.dex */
public abstract class l0 {
    public static final QMUICommonListItemView a(QMUIGroupListView qMUIGroupListView, int i6, int i7, int i8, int i9, int i10) {
        kotlin.jvm.internal.y.f(qMUIGroupListView, "<this>");
        String string = qMUIGroupListView.getContext().getString(i6);
        kotlin.jvm.internal.y.e(string, "getString(...)");
        String string2 = i7 != 0 ? qMUIGroupListView.getContext().getString(i7) : "";
        kotlin.jvm.internal.y.c(string2);
        return c(qMUIGroupListView, string, string2, i8, i9, i10);
    }

    public static final QMUICommonListItemView b(QMUIGroupListView qMUIGroupListView, String title, String des, int i6, int i7) {
        kotlin.jvm.internal.y.f(qMUIGroupListView, "<this>");
        kotlin.jvm.internal.y.f(title, "title");
        kotlin.jvm.internal.y.f(des, "des");
        return e(qMUIGroupListView, title, des, i6, i7, 0, 16, null);
    }

    public static final QMUICommonListItemView c(QMUIGroupListView qMUIGroupListView, String title, String des, int i6, int i7, int i8) {
        kotlin.jvm.internal.y.f(qMUIGroupListView, "<this>");
        kotlin.jvm.internal.y.f(title, "title");
        kotlin.jvm.internal.y.f(des, "des");
        QMUICommonListItemView qMUICommonListItemViewC = qMUIGroupListView.c(null, title, des, 1, 1);
        qMUICommonListItemViewC.e(CommonExt.d(qMUIGroupListView, i6), i7);
        qMUICommonListItemViewC.setOrientation(i8);
        d.t(qMUIGroupListView.getContext(), qMUICommonListItemViewC);
        kotlin.jvm.internal.y.c(qMUICommonListItemViewC);
        return qMUICommonListItemViewC;
    }

    public static /* synthetic */ QMUICommonListItemView d(QMUIGroupListView qMUIGroupListView, int i6, int i7, int i8, int i9, int i10, int i11, Object obj) {
        int i12 = (i11 & 2) != 0 ? 0 : i7;
        int i13 = (i11 & 4) != 0 ? 0 : i8;
        if ((i11 & 8) != 0) {
            i9 = 3;
        }
        int i14 = i9;
        if ((i11 & 16) != 0) {
            i10 = 1;
        }
        return a(qMUIGroupListView, i6, i12, i13, i14, i10);
    }

    public static /* synthetic */ QMUICommonListItemView e(QMUIGroupListView qMUIGroupListView, String str, String str2, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i9 & 4) != 0) {
            i6 = 0;
        }
        int i10 = i6;
        if ((i9 & 8) != 0) {
            i7 = 3;
        }
        int i11 = i7;
        if ((i9 & 16) != 0) {
            i8 = 1;
        }
        return c(qMUIGroupListView, str, str3, i10, i11, i8);
    }

    public static final Pair f(QMUIGroupListView qMUIGroupListView, int i6, int i7, int i8, int i9) {
        kotlin.jvm.internal.y.f(qMUIGroupListView, "<this>");
        String string = qMUIGroupListView.getContext().getString(i6);
        kotlin.jvm.internal.y.e(string, "getString(...)");
        String string2 = i7 != 0 ? qMUIGroupListView.getContext().getString(i7) : "";
        kotlin.jvm.internal.y.c(string2);
        return g(qMUIGroupListView, string, string2, i8, i9);
    }

    public static final Pair g(QMUIGroupListView qMUIGroupListView, String title, String des, int i6, int i7) {
        kotlin.jvm.internal.y.f(qMUIGroupListView, "<this>");
        kotlin.jvm.internal.y.f(title, "title");
        kotlin.jvm.internal.y.f(des, "des");
        QMUICommonListItemView qMUICommonListItemViewC = qMUIGroupListView.c(null, title, des, 1, 3);
        Context context = qMUIGroupListView.getContext();
        kotlin.jvm.internal.y.e(context, "getContext(...)");
        qMUICommonListItemViewC.e(CommonExt.b(context, i6), i7);
        SwitchCompat switchCompat = new SwitchCompat(qMUIGroupListView.getContext());
        switchCompat.setThumbResource(R$drawable.switch_thumb);
        switchCompat.setTrackResource(R$drawable.switch_track);
        qMUICommonListItemViewC.l(switchCompat);
        return kotlin.k.a(qMUICommonListItemViewC, switchCompat);
    }

    public static /* synthetic */ Pair h(QMUIGroupListView qMUIGroupListView, int i6, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i7 = 0;
        }
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = 0;
        }
        return f(qMUIGroupListView, i6, i7, i8, i9);
    }
}
