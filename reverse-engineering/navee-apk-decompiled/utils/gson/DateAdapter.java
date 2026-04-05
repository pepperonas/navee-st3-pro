package com.uz.navee.utils.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes3.dex */
public class DateAdapter implements JsonDeserializer<Date> {

    /* renamed from: a, reason: collision with root package name */
    public final DateFormat f13282a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        try {
            return this.f13282a.parse(jsonElement.getAsString());
        } catch (Exception e7) {
            e7.printStackTrace();
            return null;
        }
    }
}
