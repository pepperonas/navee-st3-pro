package cn.sharesdk.google;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.SupportMenu;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class e {
    public static int a(int i6) {
        return i6 & 65535;
    }

    public static void b(Parcel parcel, int i6) {
        parcel.setDataPosition(parcel.dataPosition() + a(parcel, i6));
    }

    public static boolean c(Parcel parcel, int i6) throws Throwable {
        a(parcel, i6, 4);
        return parcel.readInt() != 0;
    }

    public static int d(Parcel parcel, int i6) throws Throwable {
        a(parcel, i6, 4);
        return parcel.readInt();
    }

    public static String e(Parcel parcel, int i6) {
        int iA = a(parcel, i6);
        int iDataPosition = parcel.dataPosition();
        if (iA == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iA);
        return string;
    }

    public static int a(Parcel parcel) {
        return parcel.readInt();
    }

    public static int a(Parcel parcel, int i6) {
        return (i6 & SupportMenu.CATEGORY_MASK) != -65536 ? (i6 >> 16) & 65535 : parcel.readInt();
    }

    public static int b(Parcel parcel) throws Throwable {
        int iA = a(parcel);
        int iA2 = a(parcel, iA);
        int iDataPosition = parcel.dataPosition();
        if (a(iA) == 20293) {
            int i6 = iA2 + iDataPosition;
            if (i6 >= iDataPosition && i6 <= parcel.dataSize()) {
                return i6;
            }
            throw new Throwable("Size read is invalid start=" + iDataPosition + " end=" + i6);
        }
        throw new Throwable("Expected object header. Got 0x" + Integer.toHexString(iA));
    }

    private static void a(Parcel parcel, int i6, int i7) throws Throwable {
        int iA = a(parcel, i6);
        if (iA == i7) {
            return;
        }
        throw new Throwable("Expected size " + i7 + " got " + iA + " (0x" + Integer.toHexString(iA) + ")");
    }

    public static <T extends Parcelable> T a(Parcel parcel, int i6, Parcelable.Creator<T> creator) {
        int iA = a(parcel, i6);
        int iDataPosition = parcel.dataPosition();
        if (iA == 0) {
            return null;
        }
        T tCreateFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iA);
        return tCreateFromParcel;
    }

    public static <T> ArrayList<T> b(Parcel parcel, int i6, Parcelable.Creator<T> creator) {
        int iA = a(parcel, i6);
        int iDataPosition = parcel.dataPosition();
        if (iA == 0) {
            return null;
        }
        ArrayList<T> arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iA);
        return arrayListCreateTypedArrayList;
    }
}
