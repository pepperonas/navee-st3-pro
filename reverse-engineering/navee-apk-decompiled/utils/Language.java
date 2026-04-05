package com.uz.navee.utils;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.uz.navee.MyApplication;
import java.util.Iterator;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class Language {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ Language[] $VALUES;
    public static final a Companion;
    private final String languageTag;
    private final LocaleListCompat localList;
    private final String title;
    public static final Language FOLLOW = new Language("FOLLOW", 0, "", "");
    public static final Language ZH = new Language("ZH", 1, "zh", "中文（简体）");
    public static final Language EN = new Language("EN", 2, "en", "English");
    public static final Language FR = new Language("FR", 3, "fr", "Français");
    public static final Language DE = new Language("DE", 4, "de", "Deutsch");
    public static final Language IT = new Language("IT", 5, "it", "Italiano");
    public static final Language ES = new Language("ES", 6, "es", "Español");
    public static final Language NL = new Language("NL", 7, "nl", "Nederlands");
    public static final Language PT = new Language("PT", 8, "pt", "Português Brasileiro");
    public static final Language TR = new Language("TR", 9, "tr", "Türkçe");
    public static final Language RU = new Language("RU", 10, "ru", "Русский");
    public static final Language IN = new Language("IN", 11, TtmlNode.ATTR_ID, "Indonesia");
    public static final Language PL = new Language("PL", 12, "pl", "Polski");
    public static final Language RO = new Language("RO", 13, "ro", "Română");
    public static final Language EL = new Language("EL", 14, "el", "Ελληνικά");
    public static final Language BG = new Language("BG", 15, "bg", "български");
    public static final Language HU = new Language("HU", 16, "hu", "Magyar");
    public static final Language AR = new Language("AR", 17, "ar", "عربي");

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.r rVar) {
            this();
        }

        public final Language a() {
            LocaleListCompat applicationLocales = AppCompatDelegate.getApplicationLocales();
            kotlin.jvm.internal.y.e(applicationLocales, "getApplicationLocales(...)");
            return b(applicationLocales);
        }

        public final Language b(LocaleListCompat localeList) {
            kotlin.jvm.internal.y.f(localeList, "localeList");
            return c(g(localeList.get(0)));
        }

        public final Language c(String languageTag) {
            Object next;
            kotlin.jvm.internal.y.f(languageTag, "languageTag");
            if (kotlin.jvm.internal.y.a(languageTag, "in")) {
                return Language.IN;
            }
            Iterator<E> it = Language.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (kotlin.jvm.internal.y.a(((Language) next).getLanguageTag(), languageTag)) {
                    break;
                }
            }
            Language language = (Language) next;
            return language == null ? Language.FOLLOW : language;
        }

        public final Language d() {
            Language languageA = a();
            return languageA != Language.FOLLOW ? languageA : f();
        }

        public final void e() {
            Object objA = g0.a("is_follow_system", Boolean.TRUE);
            if (CommonExt.i(objA instanceof Boolean ? (Boolean) objA : null)) {
                Language languageA = a();
                Language language = Language.FOLLOW;
                if (languageA == language) {
                    String strE = g0.e("current_language", "");
                    a aVar = Language.Companion;
                    kotlin.jvm.internal.y.c(strE);
                    Language languageC = aVar.c(strE);
                    if (languageC != language) {
                        f4.b.c("migrate lang", new Object[0]);
                        languageC.save();
                    }
                }
            }
        }

        public final Language f() {
            Locale locale;
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 33) {
                locale = v.a(MyApplication.b().getSystemService(u.a())).getSystemLocales().get(0);
            } else {
                Configuration configuration = Resources.getSystem().getConfiguration();
                locale = i6 >= 24 ? configuration.getLocales().get(0) : configuration.locale;
            }
            String language = locale.getLanguage();
            kotlin.jvm.internal.y.e(language, "getLanguage(...)");
            Language languageC = c(language);
            return languageC == Language.FOLLOW ? Language.EN : languageC;
        }

        public final String g(Locale locale) {
            String language = locale != null ? locale.getLanguage() : null;
            String script = locale != null ? locale.getScript() : null;
            if (language == null || language.length() == 0) {
                return "";
            }
            if (script == null || script.length() == 0) {
                return language;
            }
            return language + "-" + script;
        }
    }

    private static final /* synthetic */ Language[] $values() {
        return new Language[]{FOLLOW, ZH, EN, FR, DE, IT, ES, NL, PT, TR, RU, IN, PL, RO, EL, BG, HU, AR};
    }

    static {
        Language[] languageArr$values = $values();
        $VALUES = languageArr$values;
        $ENTRIES = kotlin.enums.b.a(languageArr$values);
        Companion = new a(null);
    }

    private Language(String str, int i6, String str2, String str3) {
        this.languageTag = str2;
        this.title = str3;
        LocaleListCompat localeListCompatForLanguageTags = LocaleListCompat.forLanguageTags(str2);
        kotlin.jvm.internal.y.e(localeListCompatForLanguageTags, "forLanguageTags(...)");
        this.localList = localeListCompatForLanguageTags;
    }

    public static final Language current() {
        return Companion.a();
    }

    public static final Language from(LocaleListCompat localeListCompat) {
        return Companion.b(localeListCompat);
    }

    public static kotlin.enums.a getEntries() {
        return $ENTRIES;
    }

    public static final Language lang() {
        return Companion.d();
    }

    public static final void migrate() {
        Companion.e();
    }

    public static final Language sysLang() {
        return Companion.f();
    }

    public static Language valueOf(String str) {
        return (Language) Enum.valueOf(Language.class, str);
    }

    public static Language[] values() {
        return (Language[]) $VALUES.clone();
    }

    public final String getLanguageTag() {
        return this.languageTag;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void save() {
        AppCompatDelegate.setApplicationLocales(this.localList);
    }

    public static final Language from(String str) {
        return Companion.c(str);
    }
}
