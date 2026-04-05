package cn.sharesdk.google;

import android.os.Parcel;
import android.os.Parcelable;
import cn.sharesdk.framework.utils.SSDKLog;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class UserData {

    public static final class Cover implements Parcelable {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6506a = new a();

        /* renamed from: b, reason: collision with root package name */
        private final Set<Integer> f6507b;

        /* renamed from: c, reason: collision with root package name */
        private final int f6508c;

        /* renamed from: d, reason: collision with root package name */
        private CoverInfo f6509d;

        /* renamed from: e, reason: collision with root package name */
        private CoverPhoto f6510e;

        /* renamed from: f, reason: collision with root package name */
        private int f6511f;

        public Cover() {
            this.f6508c = 1;
            this.f6507b = new HashSet();
        }

        public Set<Integer> a() {
            return this.f6507b;
        }

        public int b() {
            return this.f6508c;
        }

        public CoverInfo c() {
            return this.f6509d;
        }

        public CoverPhoto d() {
            return this.f6510e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int e() {
            return this.f6511f;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            a.a(this, parcel, i6);
        }

        public static final class CoverInfo implements Parcelable {

            /* renamed from: a, reason: collision with root package name */
            public static final a f6512a = new a();

            /* renamed from: b, reason: collision with root package name */
            private final Set<Integer> f6513b;

            /* renamed from: c, reason: collision with root package name */
            private final int f6514c;

            /* renamed from: d, reason: collision with root package name */
            private int f6515d;

            /* renamed from: e, reason: collision with root package name */
            private int f6516e;

            public CoverInfo() {
                this.f6514c = 1;
                this.f6513b = new HashSet();
            }

            public Set<Integer> a() {
                return this.f6513b;
            }

            public int b() {
                return this.f6514c;
            }

            public int c() {
                return this.f6515d;
            }

            public int d() {
                return this.f6516e;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i6) {
                a.a(this, parcel, i6);
            }

            public CoverInfo(Set<Integer> set, int i6, int i7, int i8) {
                this.f6513b = set;
                this.f6514c = i6;
                this.f6515d = i7;
                this.f6516e = i8;
            }

            public static class a implements Parcelable.Creator<CoverInfo> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public CoverInfo createFromParcel(Parcel parcel) {
                    int iD;
                    int iD2;
                    HashSet hashSet = new HashSet();
                    int iD3 = 0;
                    try {
                        int iB = e.b(parcel);
                        iD = 0;
                        iD2 = 0;
                        while (parcel.dataPosition() < iB) {
                            try {
                                int iA = e.a(parcel);
                                int iA2 = e.a(iA);
                                if (iA2 == 1) {
                                    iD3 = e.d(parcel, iA);
                                    hashSet.add(1);
                                } else if (iA2 == 2) {
                                    iD = e.d(parcel, iA);
                                    hashSet.add(2);
                                } else if (iA2 != 3) {
                                    e.b(parcel, iA);
                                } else {
                                    iD2 = e.d(parcel, iA);
                                    hashSet.add(3);
                                }
                            } catch (Throwable th) {
                                th = th;
                                th.printStackTrace();
                                return new CoverInfo(hashSet, iD3, iD, iD2);
                            }
                        }
                        if (parcel.dataPosition() != iB) {
                            try {
                                throw new Throwable("Overread allowed size end=" + iB);
                            } catch (Throwable th2) {
                                SSDKLog.b().a(th2);
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        iD = 0;
                        iD2 = 0;
                    }
                    return new CoverInfo(hashSet, iD3, iD, iD2);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public CoverInfo[] newArray(int i6) {
                    return new CoverInfo[i6];
                }

                public static void a(CoverInfo coverInfo, Parcel parcel, int i6) {
                    int iA = d.a(parcel);
                    Set<Integer> setA = coverInfo.a();
                    if (setA.contains(1)) {
                        d.a(parcel, 1, coverInfo.b());
                    }
                    if (setA.contains(2)) {
                        d.a(parcel, 2, coverInfo.c());
                    }
                    if (setA.contains(3)) {
                        d.a(parcel, 3, coverInfo.d());
                    }
                    d.a(parcel, iA);
                }
            }
        }

        public static final class CoverPhoto implements Parcelable {

            /* renamed from: a, reason: collision with root package name */
            public static final a f6517a = new a();

            /* renamed from: b, reason: collision with root package name */
            private final Set<Integer> f6518b;

            /* renamed from: c, reason: collision with root package name */
            private final int f6519c;

            /* renamed from: d, reason: collision with root package name */
            private int f6520d;

            /* renamed from: e, reason: collision with root package name */
            private String f6521e;

            /* renamed from: f, reason: collision with root package name */
            private int f6522f;

            public CoverPhoto() {
                this.f6519c = 1;
                this.f6518b = new HashSet();
            }

            public Set<Integer> a() {
                return this.f6518b;
            }

            public int b() {
                return this.f6519c;
            }

            public int c() {
                return this.f6520d;
            }

            public String d() {
                return this.f6521e;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public int e() {
                return this.f6522f;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i6) {
                a.a(this, parcel, i6);
            }

            public CoverPhoto(Set<Integer> set, int i6, int i7, String str, int i8) {
                this.f6518b = set;
                this.f6519c = i6;
                this.f6520d = i7;
                this.f6521e = str;
                this.f6522f = i8;
            }

            public static class a implements Parcelable.Creator<CoverPhoto> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public CoverPhoto createFromParcel(Parcel parcel) {
                    int iD;
                    String strE;
                    int iD2;
                    HashSet hashSet = new HashSet();
                    int iD3 = 0;
                    try {
                        int iB = e.b(parcel);
                        iD = 0;
                        strE = null;
                        iD2 = 0;
                        while (parcel.dataPosition() < iB) {
                            try {
                                int iA = e.a(parcel);
                                int iA2 = e.a(iA);
                                if (iA2 == 1) {
                                    iD3 = e.d(parcel, iA);
                                    hashSet.add(1);
                                } else if (iA2 == 2) {
                                    iD2 = e.d(parcel, iA);
                                    hashSet.add(2);
                                } else if (iA2 == 3) {
                                    strE = e.e(parcel, iA);
                                    hashSet.add(3);
                                } else if (iA2 != 4) {
                                    e.b(parcel, iA);
                                } else {
                                    iD = e.d(parcel, iA);
                                    hashSet.add(4);
                                }
                            } catch (Throwable th) {
                                th = th;
                                th.printStackTrace();
                                return new CoverPhoto(hashSet, iD3, iD2, strE, iD);
                            }
                        }
                        if (parcel.dataPosition() != iB) {
                            try {
                                throw new Throwable("Overread allowed size end=" + iB);
                            } catch (Throwable th2) {
                                SSDKLog.b().a(th2);
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        iD = 0;
                        strE = null;
                        iD2 = 0;
                    }
                    return new CoverPhoto(hashSet, iD3, iD2, strE, iD);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public CoverPhoto[] newArray(int i6) {
                    return new CoverPhoto[i6];
                }

                public static void a(CoverPhoto coverPhoto, Parcel parcel, int i6) {
                    int iA = d.a(parcel);
                    Set<Integer> setA = coverPhoto.a();
                    if (setA.contains(1)) {
                        d.a(parcel, 1, coverPhoto.b());
                    }
                    if (setA.contains(2)) {
                        d.a(parcel, 2, coverPhoto.c());
                    }
                    if (setA.contains(3)) {
                        d.a(parcel, 3, coverPhoto.d(), true);
                    }
                    if (setA.contains(4)) {
                        d.a(parcel, 4, coverPhoto.e());
                    }
                    d.a(parcel, iA);
                }
            }
        }

        public Cover(Set<Integer> set, int i6, CoverInfo coverInfo, CoverPhoto coverPhoto, int i7) {
            this.f6507b = set;
            this.f6508c = i6;
            this.f6509d = coverInfo;
            this.f6510e = coverPhoto;
            this.f6511f = i7;
        }

        public static class a implements Parcelable.Creator<Cover> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Cover createFromParcel(Parcel parcel) {
                CoverInfo coverInfo;
                CoverPhoto coverPhoto;
                int iD;
                int iB;
                int iA;
                int iA2;
                HashSet hashSet = new HashSet();
                int iD2 = 0;
                try {
                    iB = e.b(parcel);
                    coverInfo = null;
                    coverPhoto = null;
                    iD = 0;
                } catch (Throwable th) {
                    th = th;
                    coverInfo = null;
                    coverPhoto = null;
                    iD = 0;
                }
                while (parcel.dataPosition() < iB) {
                    try {
                        iA = e.a(parcel);
                        iA2 = e.a(iA);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (iA2 != 1) {
                        if (iA2 == 2) {
                            CoverInfo coverInfo2 = (CoverInfo) e.a(parcel, iA, CoverInfo.f6512a);
                            try {
                                hashSet.add(2);
                                coverInfo = coverInfo2;
                            } catch (Throwable th3) {
                                th = th3;
                                coverInfo = coverInfo2;
                                th.printStackTrace();
                                return new Cover(hashSet, iD2, coverInfo, coverPhoto, iD);
                            }
                        } else if (iA2 == 3) {
                            CoverPhoto coverPhoto2 = (CoverPhoto) e.a(parcel, iA, CoverPhoto.f6517a);
                            try {
                                hashSet.add(3);
                                coverPhoto = coverPhoto2;
                            } catch (Throwable th4) {
                                th = th4;
                                coverPhoto = coverPhoto2;
                                th.printStackTrace();
                                return new Cover(hashSet, iD2, coverInfo, coverPhoto, iD);
                            }
                        } else if (iA2 != 4) {
                            e.b(parcel, iA);
                        } else {
                            iD = e.d(parcel, iA);
                            hashSet.add(4);
                        }
                        return new Cover(hashSet, iD2, coverInfo, coverPhoto, iD);
                    }
                    iD2 = e.d(parcel, iA);
                    hashSet.add(1);
                }
                if (parcel.dataPosition() != iB) {
                    try {
                        throw new Throwable("Overread allowed size end=" + iB);
                    } catch (Throwable th5) {
                        SSDKLog.b().a(th5);
                    }
                }
                return new Cover(hashSet, iD2, coverInfo, coverPhoto, iD);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Cover[] newArray(int i6) {
                return new Cover[i6];
            }

            public static void a(Cover cover, Parcel parcel, int i6) {
                int iA = d.a(parcel);
                Set<Integer> setA = cover.a();
                if (setA.contains(1)) {
                    d.a(parcel, 1, cover.b());
                }
                if (setA.contains(2)) {
                    d.a(parcel, 2, cover.c(), i6, true);
                }
                if (setA.contains(3)) {
                    d.a(parcel, 3, cover.d(), i6, true);
                }
                if (setA.contains(4)) {
                    d.a(parcel, 4, cover.e());
                }
                d.a(parcel, iA);
            }
        }
    }

    public static final class AgeRange implements Parcelable {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6501a = new a();

        /* renamed from: b, reason: collision with root package name */
        private final Set<Integer> f6502b;

        /* renamed from: c, reason: collision with root package name */
        private final int f6503c;

        /* renamed from: d, reason: collision with root package name */
        private int f6504d;

        /* renamed from: e, reason: collision with root package name */
        private int f6505e;

        public AgeRange() {
            this.f6503c = 1;
            this.f6502b = new HashSet();
        }

        public Set<Integer> a() {
            return this.f6502b;
        }

        public int b() {
            return this.f6503c;
        }

        public int c() {
            return this.f6504d;
        }

        public int d() {
            return this.f6505e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            a.a(this, parcel, i6);
        }

        public AgeRange(Set<Integer> set, int i6, int i7, int i8) {
            this.f6502b = set;
            this.f6503c = i6;
            this.f6504d = i7;
            this.f6505e = i8;
        }

        public static class a implements Parcelable.Creator<AgeRange> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AgeRange createFromParcel(Parcel parcel) {
                int iD;
                int iD2;
                HashSet hashSet = new HashSet();
                int iD3 = 0;
                try {
                    int iB = e.b(parcel);
                    iD = 0;
                    iD2 = 0;
                    while (parcel.dataPosition() < iB) {
                        try {
                            int iA = e.a(parcel);
                            int iA2 = e.a(iA);
                            if (iA2 == 1) {
                                iD3 = e.d(parcel, iA);
                                hashSet.add(1);
                            } else if (iA2 == 2) {
                                iD = e.d(parcel, iA);
                                hashSet.add(2);
                            } else if (iA2 != 3) {
                                e.b(parcel, iA);
                            } else {
                                iD2 = e.d(parcel, iA);
                                hashSet.add(3);
                            }
                        } catch (Throwable th) {
                            th = th;
                            th.printStackTrace();
                            return new AgeRange(hashSet, iD3, iD, iD2);
                        }
                    }
                    if (parcel.dataPosition() != iB) {
                        try {
                            throw new Throwable("Overread allowed size end=" + iB);
                        } catch (Throwable th2) {
                            SSDKLog.b().a(th2);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    iD = 0;
                    iD2 = 0;
                }
                return new AgeRange(hashSet, iD3, iD, iD2);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AgeRange[] newArray(int i6) {
                return new AgeRange[i6];
            }

            public static void a(AgeRange ageRange, Parcel parcel, int i6) {
                int iA = d.a(parcel);
                Set<Integer> setA = ageRange.a();
                if (setA.contains(1)) {
                    d.a(parcel, 1, ageRange.b());
                }
                if (setA.contains(2)) {
                    d.a(parcel, 2, ageRange.c());
                }
                if (setA.contains(3)) {
                    d.a(parcel, 3, ageRange.d());
                }
                d.a(parcel, iA);
            }
        }
    }

    public static final class Emails implements Parcelable {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6523a = new a();

        /* renamed from: b, reason: collision with root package name */
        private final Set<Integer> f6524b;

        /* renamed from: c, reason: collision with root package name */
        private final int f6525c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f6526d;

        /* renamed from: e, reason: collision with root package name */
        private int f6527e;

        /* renamed from: f, reason: collision with root package name */
        private String f6528f;

        public Emails() {
            this.f6525c = 1;
            this.f6524b = new HashSet();
        }

        public Set<Integer> a() {
            return this.f6524b;
        }

        public int b() {
            return this.f6525c;
        }

        public boolean c() {
            return this.f6526d;
        }

        public int d() {
            return this.f6527e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f6528f;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            a.a(this, parcel, i6);
        }

        public Emails(Set<Integer> set, int i6, boolean z6, int i7, String str) {
            this.f6524b = set;
            this.f6525c = i6;
            this.f6526d = z6;
            this.f6527e = i7;
            this.f6528f = str;
        }

        public static class a implements Parcelable.Creator<Emails> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Emails createFromParcel(Parcel parcel) {
                int iD;
                String strE;
                boolean zC;
                HashSet hashSet = new HashSet();
                int iD2 = 0;
                try {
                    int iB = e.b(parcel);
                    iD = 0;
                    strE = null;
                    zC = false;
                    while (parcel.dataPosition() < iB) {
                        try {
                            int iA = e.a(parcel);
                            int iA2 = e.a(iA);
                            if (iA2 == 1) {
                                iD2 = e.d(parcel, iA);
                                hashSet.add(1);
                            } else if (iA2 == 2) {
                                zC = e.c(parcel, iA);
                                hashSet.add(2);
                            } else if (iA2 == 3) {
                                iD = e.d(parcel, iA);
                                hashSet.add(3);
                            } else if (iA2 != 4) {
                                e.b(parcel, iA);
                            } else {
                                strE = e.e(parcel, iA);
                                hashSet.add(4);
                            }
                        } catch (Throwable th) {
                            th = th;
                            th.printStackTrace();
                            return new Emails(hashSet, iD2, zC, iD, strE);
                        }
                    }
                    if (parcel.dataPosition() != iB) {
                        try {
                            throw new Throwable("Overread allowed size end=" + iB);
                        } catch (Throwable th2) {
                            SSDKLog.b().a(th2);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    iD = 0;
                    strE = null;
                    zC = false;
                }
                return new Emails(hashSet, iD2, zC, iD, strE);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Emails[] newArray(int i6) {
                return new Emails[i6];
            }

            public static void a(Emails emails, Parcel parcel, int i6) {
                int iA = d.a(parcel);
                Set<Integer> setA = emails.a();
                if (setA.contains(1)) {
                    d.a(parcel, 1, emails.b());
                }
                if (setA.contains(2)) {
                    d.a(parcel, 2, emails.c());
                }
                if (setA.contains(3)) {
                    d.a(parcel, 3, emails.d());
                }
                if (setA.contains(4)) {
                    d.a(parcel, 4, emails.e(), true);
                }
                d.a(parcel, iA);
            }
        }
    }

    public static final class Image implements Parcelable {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6529a = new a();

        /* renamed from: b, reason: collision with root package name */
        private final Set<Integer> f6530b;

        /* renamed from: c, reason: collision with root package name */
        private final int f6531c;

        /* renamed from: d, reason: collision with root package name */
        private String f6532d;

        public Image() {
            this.f6531c = 1;
            this.f6530b = new HashSet();
        }

        public Set<Integer> a() {
            return this.f6530b;
        }

        public int b() {
            return this.f6531c;
        }

        public String c() {
            return this.f6532d;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            a.a(this, parcel, i6);
        }

        public Image(Set<Integer> set, int i6, String str) {
            this.f6530b = set;
            this.f6531c = i6;
            this.f6532d = str;
        }

        public static class a implements Parcelable.Creator<Image> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Image createFromParcel(Parcel parcel) {
                HashSet hashSet = new HashSet();
                int iD = 0;
                String strE = null;
                try {
                    int iB = e.b(parcel);
                    while (parcel.dataPosition() < iB) {
                        int iA = e.a(parcel);
                        int iA2 = e.a(iA);
                        if (iA2 == 1) {
                            iD = e.d(parcel, iA);
                            hashSet.add(1);
                        } else if (iA2 != 2) {
                            e.b(parcel, iA);
                        } else {
                            strE = e.e(parcel, iA);
                            hashSet.add(2);
                        }
                    }
                    if (parcel.dataPosition() != iB) {
                        try {
                            throw new Throwable("Overread allowed size end=" + iB);
                        } catch (Throwable th) {
                            SSDKLog.b().a(th);
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                return new Image(hashSet, iD, strE);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Image[] newArray(int i6) {
                return new Image[i6];
            }

            public static void a(Image image, Parcel parcel, int i6) {
                int iA = d.a(parcel);
                Set<Integer> setA = image.a();
                if (setA.contains(1)) {
                    d.a(parcel, 1, image.b());
                }
                if (setA.contains(2)) {
                    d.a(parcel, 2, image.c(), true);
                }
                d.a(parcel, iA);
            }
        }
    }

    public static final class Name implements Parcelable {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6533a = new a();

        /* renamed from: b, reason: collision with root package name */
        private final Set<Integer> f6534b;

        /* renamed from: c, reason: collision with root package name */
        private final int f6535c;

        /* renamed from: d, reason: collision with root package name */
        private String f6536d;

        /* renamed from: e, reason: collision with root package name */
        private String f6537e;

        /* renamed from: f, reason: collision with root package name */
        private String f6538f;

        /* renamed from: g, reason: collision with root package name */
        private String f6539g;

        /* renamed from: h, reason: collision with root package name */
        private String f6540h;

        /* renamed from: i, reason: collision with root package name */
        private String f6541i;

        public Name() {
            this.f6535c = 1;
            this.f6534b = new HashSet();
        }

        public Set<Integer> a() {
            return this.f6534b;
        }

        public int b() {
            return this.f6535c;
        }

        public String c() {
            return this.f6536d;
        }

        public String d() {
            return this.f6537e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f6538f;
        }

        public String f() {
            return this.f6539g;
        }

        public String g() {
            return this.f6540h;
        }

        public String h() {
            return this.f6541i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            a.a(this, parcel, i6);
        }

        public Name(Set<Integer> set, int i6, String str, String str2, String str3, String str4, String str5, String str6) {
            this.f6534b = set;
            this.f6535c = i6;
            this.f6536d = str;
            this.f6537e = str2;
            this.f6538f = str3;
            this.f6539g = str4;
            this.f6540h = str5;
            this.f6541i = str6;
        }

        public static class a implements Parcelable.Creator<Name> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Name createFromParcel(Parcel parcel) {
                String strE;
                String strE2;
                String strE3;
                String strE4;
                String strE5;
                HashSet hashSet = new HashSet();
                int iD = 0;
                String strE6 = null;
                try {
                    int iB = e.b(parcel);
                    strE = null;
                    strE2 = null;
                    strE3 = null;
                    strE4 = null;
                    strE5 = null;
                    while (parcel.dataPosition() < iB) {
                        try {
                            int iA = e.a(parcel);
                            switch (e.a(iA)) {
                                case 1:
                                    iD = e.d(parcel, iA);
                                    hashSet.add(1);
                                    break;
                                case 2:
                                    strE6 = e.e(parcel, iA);
                                    hashSet.add(2);
                                    break;
                                case 3:
                                    strE = e.e(parcel, iA);
                                    hashSet.add(3);
                                    break;
                                case 4:
                                    strE2 = e.e(parcel, iA);
                                    hashSet.add(4);
                                    break;
                                case 5:
                                    strE3 = e.e(parcel, iA);
                                    hashSet.add(5);
                                    break;
                                case 6:
                                    strE4 = e.e(parcel, iA);
                                    hashSet.add(6);
                                    break;
                                case 7:
                                    strE5 = e.e(parcel, iA);
                                    hashSet.add(7);
                                    break;
                                default:
                                    e.b(parcel, iA);
                                    break;
                            }
                        } catch (Throwable th) {
                            th = th;
                            th.printStackTrace();
                            return new Name(hashSet, iD, strE6, strE, strE2, strE3, strE4, strE5);
                        }
                    }
                    if (parcel.dataPosition() != iB) {
                        try {
                            throw new Throwable("Overread allowed size end=" + iB);
                        } catch (Throwable th2) {
                            SSDKLog.b().a(th2);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    strE = null;
                    strE2 = null;
                    strE3 = null;
                    strE4 = null;
                    strE5 = null;
                }
                return new Name(hashSet, iD, strE6, strE, strE2, strE3, strE4, strE5);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Name[] newArray(int i6) {
                return new Name[i6];
            }

            public static void a(Name name, Parcel parcel, int i6) {
                int iA = d.a(parcel);
                Set<Integer> setA = name.a();
                if (setA.contains(1)) {
                    d.a(parcel, 1, name.b());
                }
                if (setA.contains(2)) {
                    d.a(parcel, 2, name.c(), true);
                }
                if (setA.contains(3)) {
                    d.a(parcel, 3, name.d(), true);
                }
                if (setA.contains(4)) {
                    d.a(parcel, 4, name.e(), true);
                }
                if (setA.contains(5)) {
                    d.a(parcel, 5, name.f(), true);
                }
                if (setA.contains(6)) {
                    d.a(parcel, 6, name.g(), true);
                }
                if (setA.contains(7)) {
                    d.a(parcel, 7, name.h(), true);
                }
                d.a(parcel, iA);
            }
        }
    }

    public static final class Organizations implements Parcelable {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6542a = new a();

        /* renamed from: b, reason: collision with root package name */
        private final Set<Integer> f6543b;

        /* renamed from: c, reason: collision with root package name */
        private final int f6544c;

        /* renamed from: d, reason: collision with root package name */
        private String f6545d;

        /* renamed from: e, reason: collision with root package name */
        private String f6546e;

        /* renamed from: f, reason: collision with root package name */
        private String f6547f;

        /* renamed from: g, reason: collision with root package name */
        private String f6548g;

        /* renamed from: h, reason: collision with root package name */
        private String f6549h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f6550i;

        /* renamed from: j, reason: collision with root package name */
        private String f6551j;

        /* renamed from: k, reason: collision with root package name */
        private String f6552k;

        /* renamed from: l, reason: collision with root package name */
        private int f6553l;

        public Organizations() {
            this.f6544c = 1;
            this.f6543b = new HashSet();
        }

        public Set<Integer> a() {
            return this.f6543b;
        }

        public int b() {
            return this.f6544c;
        }

        public String c() {
            return this.f6545d;
        }

        public String d() {
            return this.f6546e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f6547f;
        }

        public String f() {
            return this.f6548g;
        }

        public String g() {
            return this.f6549h;
        }

        public boolean h() {
            return this.f6550i;
        }

        public String i() {
            return this.f6551j;
        }

        public String j() {
            return this.f6552k;
        }

        public int k() {
            return this.f6553l;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            a.a(this, parcel, i6);
        }

        public Organizations(Set<Integer> set, int i6, String str, String str2, String str3, String str4, String str5, boolean z6, String str6, String str7, int i7) {
            this.f6543b = set;
            this.f6544c = i6;
            this.f6545d = str;
            this.f6546e = str2;
            this.f6547f = str3;
            this.f6548g = str4;
            this.f6549h = str5;
            this.f6550i = z6;
            this.f6551j = str6;
            this.f6552k = str7;
            this.f6553l = i7;
        }

        public static class a implements Parcelable.Creator<Organizations> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Organizations createFromParcel(Parcel parcel) {
                int iD;
                String strE;
                String strE2;
                String strE3;
                String strE4;
                String strE5;
                String strE6;
                String strE7;
                boolean zC;
                HashSet hashSet = new HashSet();
                int iD2 = 0;
                try {
                    int iB = e.b(parcel);
                    iD = 0;
                    strE = null;
                    strE2 = null;
                    strE3 = null;
                    strE4 = null;
                    strE5 = null;
                    strE6 = null;
                    strE7 = null;
                    zC = false;
                    while (parcel.dataPosition() < iB) {
                        try {
                            int iA = e.a(parcel);
                            switch (e.a(iA)) {
                                case 1:
                                    iD2 = e.d(parcel, iA);
                                    hashSet.add(1);
                                    break;
                                case 2:
                                    strE = e.e(parcel, iA);
                                    hashSet.add(2);
                                    break;
                                case 3:
                                    strE2 = e.e(parcel, iA);
                                    hashSet.add(3);
                                    break;
                                case 4:
                                    strE3 = e.e(parcel, iA);
                                    hashSet.add(4);
                                    break;
                                case 5:
                                    strE4 = e.e(parcel, iA);
                                    hashSet.add(5);
                                    break;
                                case 6:
                                    strE5 = e.e(parcel, iA);
                                    hashSet.add(6);
                                    break;
                                case 7:
                                    zC = e.c(parcel, iA);
                                    hashSet.add(7);
                                    break;
                                case 8:
                                    strE6 = e.e(parcel, iA);
                                    hashSet.add(8);
                                    break;
                                case 9:
                                    strE7 = e.e(parcel, iA);
                                    hashSet.add(9);
                                    break;
                                case 10:
                                    iD = e.d(parcel, iA);
                                    hashSet.add(10);
                                    break;
                                default:
                                    e.b(parcel, iA);
                                    break;
                            }
                        } catch (Throwable th) {
                            th = th;
                            th.printStackTrace();
                            return new Organizations(hashSet, iD2, strE, strE2, strE3, strE4, strE5, zC, strE6, strE7, iD);
                        }
                    }
                    if (parcel.dataPosition() != iB) {
                        try {
                            throw new Throwable("Overread allowed size end=" + iB);
                        } catch (Throwable th2) {
                            SSDKLog.b().a(th2);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    iD = 0;
                    strE = null;
                    strE2 = null;
                    strE3 = null;
                    strE4 = null;
                    strE5 = null;
                    strE6 = null;
                    strE7 = null;
                    zC = false;
                }
                return new Organizations(hashSet, iD2, strE, strE2, strE3, strE4, strE5, zC, strE6, strE7, iD);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Organizations[] newArray(int i6) {
                return new Organizations[i6];
            }

            public static void a(Organizations organizations, Parcel parcel, int i6) {
                int iA = d.a(parcel);
                Set<Integer> setA = organizations.a();
                if (setA.contains(1)) {
                    d.a(parcel, 1, organizations.b());
                }
                if (setA.contains(2)) {
                    d.a(parcel, 2, organizations.c(), true);
                }
                if (setA.contains(3)) {
                    d.a(parcel, 3, organizations.d(), true);
                }
                if (setA.contains(4)) {
                    d.a(parcel, 4, organizations.e(), true);
                }
                if (setA.contains(5)) {
                    d.a(parcel, 5, organizations.f(), true);
                }
                if (setA.contains(6)) {
                    d.a(parcel, 6, organizations.g(), true);
                }
                if (setA.contains(7)) {
                    d.a(parcel, 7, organizations.h());
                }
                if (setA.contains(8)) {
                    d.a(parcel, 8, organizations.i(), true);
                }
                if (setA.contains(9)) {
                    d.a(parcel, 9, organizations.j(), true);
                }
                if (setA.contains(10)) {
                    d.a(parcel, 10, organizations.k());
                }
                d.a(parcel, iA);
            }
        }
    }

    public static final class PlacesLived implements Parcelable {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6554a = new a();

        /* renamed from: b, reason: collision with root package name */
        private final Set<Integer> f6555b;

        /* renamed from: c, reason: collision with root package name */
        private final int f6556c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f6557d;

        /* renamed from: e, reason: collision with root package name */
        private String f6558e;

        public PlacesLived() {
            this.f6556c = 1;
            this.f6555b = new HashSet();
        }

        public Set<Integer> a() {
            return this.f6555b;
        }

        public int b() {
            return this.f6556c;
        }

        public boolean c() {
            return this.f6557d;
        }

        public String d() {
            return this.f6558e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            a.a(this, parcel, i6);
        }

        public PlacesLived(Set<Integer> set, int i6, boolean z6, String str) {
            this.f6555b = set;
            this.f6556c = i6;
            this.f6557d = z6;
            this.f6558e = str;
        }

        public static class a implements Parcelable.Creator<PlacesLived> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public PlacesLived createFromParcel(Parcel parcel) {
                String strE;
                boolean zC;
                HashSet hashSet = new HashSet();
                int iD = 0;
                try {
                    int iB = e.b(parcel);
                    strE = null;
                    zC = false;
                    while (parcel.dataPosition() < iB) {
                        try {
                            int iA = e.a(parcel);
                            int iA2 = e.a(iA);
                            if (iA2 == 1) {
                                iD = e.d(parcel, iA);
                                hashSet.add(1);
                            } else if (iA2 == 2) {
                                zC = e.c(parcel, iA);
                                hashSet.add(2);
                            } else if (iA2 != 3) {
                                e.b(parcel, iA);
                            } else {
                                strE = e.e(parcel, iA);
                                hashSet.add(3);
                            }
                        } catch (Throwable th) {
                            th = th;
                            th.printStackTrace();
                            return new PlacesLived(hashSet, iD, zC, strE);
                        }
                    }
                    if (parcel.dataPosition() != iB) {
                        try {
                            throw new Throwable("Overread allowed size end=" + iB);
                        } catch (Throwable th2) {
                            SSDKLog.b().a(th2);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    strE = null;
                    zC = false;
                }
                return new PlacesLived(hashSet, iD, zC, strE);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public PlacesLived[] newArray(int i6) {
                return new PlacesLived[i6];
            }

            public static void a(PlacesLived placesLived, Parcel parcel, int i6) {
                int iA = d.a(parcel);
                Set<Integer> setA = placesLived.a();
                if (setA.contains(1)) {
                    d.a(parcel, 1, placesLived.b());
                }
                if (setA.contains(2)) {
                    d.a(parcel, 2, placesLived.c());
                }
                if (setA.contains(3)) {
                    d.a(parcel, 3, placesLived.d(), true);
                }
                d.a(parcel, iA);
            }
        }
    }

    public static final class Urls implements Parcelable {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6559a = new a();

        /* renamed from: b, reason: collision with root package name */
        private final Set<Integer> f6560b;

        /* renamed from: c, reason: collision with root package name */
        private final int f6561c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f6562d;

        /* renamed from: e, reason: collision with root package name */
        private int f6563e;

        /* renamed from: f, reason: collision with root package name */
        private String f6564f;

        public Urls() {
            this.f6561c = 1;
            this.f6560b = new HashSet();
        }

        public Set<Integer> a() {
            return this.f6560b;
        }

        public int b() {
            return this.f6561c;
        }

        public boolean c() {
            return this.f6562d;
        }

        public int d() {
            return this.f6563e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f6564f;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            a.a(this, parcel, i6);
        }

        public Urls(Set<Integer> set, int i6, boolean z6, int i7, String str) {
            this.f6560b = set;
            this.f6561c = i6;
            this.f6562d = z6;
            this.f6563e = i7;
            this.f6564f = str;
        }

        public static class a implements Parcelable.Creator<Urls> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Urls createFromParcel(Parcel parcel) {
                int iD;
                String strE;
                boolean zC;
                HashSet hashSet = new HashSet();
                int iD2 = 0;
                try {
                    int iB = e.b(parcel);
                    iD = 0;
                    strE = null;
                    zC = false;
                    while (parcel.dataPosition() < iB) {
                        try {
                            int iA = e.a(parcel);
                            int iA2 = e.a(iA);
                            if (iA2 == 1) {
                                iD2 = e.d(parcel, iA);
                                hashSet.add(1);
                            } else if (iA2 == 2) {
                                zC = e.c(parcel, iA);
                                hashSet.add(2);
                            } else if (iA2 == 3) {
                                iD = e.d(parcel, iA);
                                hashSet.add(3);
                            } else if (iA2 != 4) {
                                e.b(parcel, iA);
                            } else {
                                strE = e.e(parcel, iA);
                                hashSet.add(4);
                            }
                        } catch (Throwable th) {
                            th = th;
                            th.printStackTrace();
                            return new Urls(hashSet, iD2, zC, iD, strE);
                        }
                    }
                    if (parcel.dataPosition() != iB) {
                        try {
                            throw new Throwable("Overread allowed size end=" + iB);
                        } catch (Throwable th2) {
                            SSDKLog.b().a(th2);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    iD = 0;
                    strE = null;
                    zC = false;
                }
                return new Urls(hashSet, iD2, zC, iD, strE);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Urls[] newArray(int i6) {
                return new Urls[i6];
            }

            public static void a(Urls urls, Parcel parcel, int i6) {
                int iA = d.a(parcel);
                Set<Integer> setA = urls.a();
                if (setA.contains(1)) {
                    d.a(parcel, 1, urls.b());
                }
                if (setA.contains(2)) {
                    d.a(parcel, 2, urls.c());
                }
                if (setA.contains(3)) {
                    d.a(parcel, 3, urls.d());
                }
                if (setA.contains(4)) {
                    d.a(parcel, 4, urls.e(), true);
                }
                d.a(parcel, iA);
            }
        }
    }
}
