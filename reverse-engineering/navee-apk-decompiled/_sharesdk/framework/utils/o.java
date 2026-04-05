package cn.sharesdk.framework.utils;

import android.text.TextUtils;
import android.util.Xml;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes2.dex */
public class o {

    public static class a extends DefaultHandler {

        /* renamed from: a, reason: collision with root package name */
        private HashMap<String, Object> f6485a = new HashMap<>();

        /* renamed from: b, reason: collision with root package name */
        private HashMap<String, Object> f6486b;

        public HashMap<String, Object> a() {
            return this.f6485a;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i6, int i7) {
            HashMap<String, Object> map;
            String strTrim = String.valueOf(cArr, i6, i7).trim();
            if (TextUtils.isEmpty(strTrim) || (map = this.f6486b) == null) {
                return;
            }
            map.put("value", strTrim);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            this.f6486b = null;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            if (this.f6486b != null) {
                HashMap<String, Object> map = new HashMap<>();
                this.f6486b.put(str2, map);
                this.f6486b = map;
            } else {
                HashMap<String, Object> map2 = new HashMap<>();
                this.f6486b = map2;
                this.f6485a.put(str2, map2);
            }
            int length = attributes.getLength();
            for (int i6 = 0; i6 < length; i6++) {
                this.f6486b.put(attributes.getLocalName(i6), attributes.getValue(i6));
            }
        }
    }

    public HashMap<String, Object> a(String str) throws Throwable {
        a aVar = new a();
        Xml.parse(str, aVar);
        return aVar.a();
    }
}
