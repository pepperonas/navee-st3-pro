package cn.sharesdk.framework.utils;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class l implements Escaper {

    public static final class a extends ThreadLocal<char[]> {
        private a() {
        }

        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public char[] initialValue() {
            return new char[1024];
        }
    }

    public static final int b(CharSequence charSequence, int i6, int i7) {
        if (i6 >= i7) {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
        char cCharAt = charSequence.charAt(i6);
        int i8 = i6 + 1;
        if (cCharAt < 55296 || cCharAt > 57343) {
            return cCharAt;
        }
        if (cCharAt > 56319) {
            throw new IllegalArgumentException("Unexpected low surrogate character '" + cCharAt + "' with value " + ((int) cCharAt) + " at index " + i6);
        }
        if (i8 == i7) {
            return -cCharAt;
        }
        char cCharAt2 = charSequence.charAt(i8);
        if (Character.isLowSurrogate(cCharAt2)) {
            return Character.toCodePoint(cCharAt, cCharAt2);
        }
        throw new IllegalArgumentException("Expected low surrogate but got char '" + cCharAt2 + "' with value " + ((int) cCharAt2) + " at index " + i8);
    }

    public int a(CharSequence charSequence, int i6, int i7) {
        while (i6 < i7) {
            int iB = b(charSequence, i6, i7);
            if (iB < 0 || a(iB) != null) {
                break;
            }
            i6 += Character.isSupplementaryCodePoint(iB) ? 2 : 1;
        }
        return i6;
    }

    public abstract char[] a(int i6);

    @Override // cn.sharesdk.framework.utils.Escaper
    public String escape(String str) {
        int length = str.length();
        int iA = a(str, 0, length);
        return iA == length ? str : a(str, iA);
    }

    public final String a(String str, int i6) {
        int length = str.length();
        char[] cArrA = new a().get();
        int i7 = 0;
        int length2 = 0;
        while (i6 < length) {
            int iB = b(str, i6, length);
            if (iB >= 0) {
                char[] cArrA2 = a(iB);
                if (cArrA2 != null) {
                    int i8 = i6 - i7;
                    int i9 = length2 + i8;
                    int length3 = cArrA2.length + i9;
                    if (cArrA.length < length3) {
                        cArrA = a(cArrA, length2, length3 + (length - i6) + 32);
                    }
                    if (i8 > 0) {
                        str.getChars(i7, i6, cArrA, length2);
                        length2 = i9;
                    }
                    if (cArrA2.length > 0) {
                        System.arraycopy(cArrA2, 0, cArrA, length2, cArrA2.length);
                        length2 += cArrA2.length;
                    }
                }
                i7 = (Character.isSupplementaryCodePoint(iB) ? 2 : 1) + i6;
                i6 = a(str, i7, length);
            } else {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
        }
        int i10 = length - i7;
        if (i10 > 0) {
            int i11 = i10 + length2;
            if (cArrA.length < i11) {
                cArrA = a(cArrA, length2, i11);
            }
            str.getChars(i7, length, cArrA, length2);
            length2 = i11;
        }
        return new String(cArrA, 0, length2);
    }

    @Override // cn.sharesdk.framework.utils.Escaper
    public Appendable escape(final Appendable appendable) {
        e.a(appendable);
        return new Appendable() { // from class: cn.sharesdk.framework.utils.l.1

            /* renamed from: a, reason: collision with root package name */
            int f6481a = -1;

            /* renamed from: b, reason: collision with root package name */
            char[] f6482b = new char[2];

            private void a(char[] cArr, int i6) throws IOException {
                for (int i7 = 0; i7 < i6; i7++) {
                    appendable.append(cArr[i7]);
                }
            }

            @Override // java.lang.Appendable
            public Appendable append(CharSequence charSequence) throws IOException {
                return append(charSequence, 0, charSequence.length());
            }

            @Override // java.lang.Appendable
            public Appendable append(CharSequence charSequence, int i6, int i7) throws IOException {
                int i8;
                if (i6 < i7) {
                    if (this.f6481a != -1) {
                        char cCharAt = charSequence.charAt(i6);
                        int i9 = i6 + 1;
                        if (!Character.isLowSurrogate(cCharAt)) {
                            throw new IllegalArgumentException("Expected low surrogate character but got " + cCharAt);
                        }
                        char[] cArrA = l.this.a(Character.toCodePoint((char) this.f6481a, cCharAt));
                        if (cArrA != null) {
                            a(cArrA, cArrA.length);
                            i6 = i9;
                        } else {
                            appendable.append((char) this.f6481a);
                        }
                        this.f6481a = -1;
                        i8 = i6;
                        i6 = i9;
                    } else {
                        i8 = i6;
                    }
                    while (true) {
                        int iA = l.this.a(charSequence, i6, i7);
                        if (iA > i8) {
                            appendable.append(charSequence, i8, iA);
                        }
                        if (iA == i7) {
                            break;
                        }
                        int iB = l.b(charSequence, iA, i7);
                        if (iB < 0) {
                            this.f6481a = -iB;
                            break;
                        }
                        char[] cArrA2 = l.this.a(iB);
                        if (cArrA2 != null) {
                            a(cArrA2, cArrA2.length);
                        } else {
                            a(this.f6482b, Character.toChars(iB, this.f6482b, 0));
                        }
                        i8 = (Character.isSupplementaryCodePoint(iB) ? 2 : 1) + iA;
                        i6 = i8;
                    }
                }
                return this;
            }

            @Override // java.lang.Appendable
            public Appendable append(char c7) throws IOException {
                if (this.f6481a != -1) {
                    if (Character.isLowSurrogate(c7)) {
                        char[] cArrA = l.this.a(Character.toCodePoint((char) this.f6481a, c7));
                        if (cArrA != null) {
                            a(cArrA, cArrA.length);
                        } else {
                            appendable.append((char) this.f6481a);
                            appendable.append(c7);
                        }
                        this.f6481a = -1;
                    } else {
                        throw new IllegalArgumentException("Expected low surrogate character but got '" + c7 + "' with value " + ((int) c7));
                    }
                } else if (Character.isHighSurrogate(c7)) {
                    this.f6481a = c7;
                } else if (!Character.isLowSurrogate(c7)) {
                    char[] cArrA2 = l.this.a(c7);
                    if (cArrA2 != null) {
                        a(cArrA2, cArrA2.length);
                    } else {
                        appendable.append(c7);
                    }
                } else {
                    throw new IllegalArgumentException("Unexpected low surrogate character '" + c7 + "' with value " + ((int) c7));
                }
                return this;
            }
        };
    }

    private static final char[] a(char[] cArr, int i6, int i7) {
        char[] cArr2 = new char[i7];
        if (i6 > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i6);
        }
        return cArr2;
    }
}
