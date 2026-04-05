package cn.sharesdk.google;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.SupportMenu;

/* loaded from: classes2.dex */
public class d {
    public static int a(Parcel parcel) {
        return b(parcel, 20293);
    }

    private static void b(Parcel parcel, int i6, int i7) {
        if (i7 < 65535) {
            parcel.writeInt(i6 | (i7 << 16));
        } else {
            parcel.writeInt(i6 | SupportMenu.CATEGORY_MASK);
            parcel.writeInt(i7);
        }
    }

    private static void c(Parcel parcel, int i6) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i6 - 4);
        parcel.writeInt(iDataPosition - i6);
        parcel.setDataPosition(iDataPosition);
    }

    public static void a(Parcel parcel, int i6) {
        c(parcel, i6);
    }

    public static void a(Parcel parcel, int i6, boolean z6) {
        b(parcel, i6, 4);
        parcel.writeInt(z6 ? 1 : 0);
    }

    private static int b(Parcel parcel, int i6) {
        parcel.writeInt(i6 | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void a(Parcel parcel, int i6, int i7) {
        b(parcel, i6, 4);
        parcel.writeInt(i7);
    }

    public static void a(Parcel parcel, int i6, String str, boolean z6) {
        if (str == null) {
            if (z6) {
                b(parcel, i6, 0);
            }
        } else {
            int iB = b(parcel, i6);
            parcel.writeString(str);
            c(parcel, iB);
        }
    }

    public static void a(Parcel parcel, int i6, Parcelable parcelable, int i7, boolean z6) {
        if (parcelable == null) {
            if (z6) {
                b(parcel, i6, 0);
            }
        } else {
            int iB = b(parcel, i6);
            parcelable.writeToParcel(parcel, i7);
            c(parcel, iB);
        }
    }
}
