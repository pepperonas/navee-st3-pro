package com.uz.navee.ui.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.bean.Vehicle;
import d4.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.t;
import kotlin.jvm.internal.y;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p4.u;
import p4.v;
import p4.x;
import q5.l;
import r4.g;
import r4.o;

/* loaded from: classes3.dex */
public final class UserVehicleHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final UserVehicleHelper f11680a = new UserVehicleHelper();

    public static final class a implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f11681a;

        /* renamed from: com.uz.navee.ui.data.UserVehicleHelper$a$a, reason: collision with other inner class name */
        public static final class C0157a extends TypeToken<HttpResponse<ArrayList<Vehicle>>> {
        }

        public a(v vVar) {
            this.f11681a = vVar;
        }

        @Override // d4.d.h
        public void a(String json) {
            y.f(json, "json");
            HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(json, new C0157a().getType());
            if (httpResponse == null || httpResponse.getCode() != 200 || httpResponse.getData() == null) {
                this.f11681a.onSuccess(t.k());
            } else {
                this.f11681a.onSuccess(httpResponse.getData());
            }
        }

        @Override // d4.d.h
        public void b(Exception e7) {
            y.f(e7, "e");
            this.f11681a.onSuccess(t.k());
        }
    }

    public static final class b implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f11682a;

        public b(v vVar) {
            this.f11682a = vVar;
        }

        @Override // d4.d.h
        public void a(String json) throws JSONException {
            y.f(json, "json");
            ArrayList arrayList = new ArrayList();
            try {
                JSONObject jSONObject = new JSONObject(json);
                if (jSONObject.getInt("code") == 200) {
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    int length = jSONArray.length();
                    for (int i6 = 0; i6 < length; i6++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i6);
                        Vehicle vehicle = (Vehicle) new Gson().fromJson(jSONObject2.getString("vehicle"), Vehicle.class);
                        vehicle.shareUserId = jSONObject2.getInt("shareUserId");
                        vehicle.shareUserName = jSONObject2.getString("shareUserName");
                        y.c(vehicle);
                        arrayList.add(vehicle);
                    }
                }
            } catch (JSONException unused) {
            }
            this.f11682a.onSuccess(arrayList);
        }

        @Override // d4.d.h
        public void b(Exception e7) {
            y.f(e7, "e");
            this.f11682a.onSuccess(t.k());
        }
    }

    public static final void f(v it) {
        y.f(it, "it");
        d4.d.h().f(e4.a.a() + "/vehicle/getVehicle", new a(it));
    }

    public static final void h(v it) {
        y.f(it, "it");
        d4.d.h().f(e4.a.a() + "/shareVehicle/getMyShareVehicle", new b(it));
    }

    public static final List j(l tmp0, Object obj) {
        y.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    public static final void k(l tmp0, Object obj) {
        y.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final u e() {
        u uVarG = u.g(new x() { // from class: com.uz.navee.ui.data.c
            @Override // p4.x
            public final void a(v vVar) {
                UserVehicleHelper.f(vVar);
            }
        });
        y.e(uVarG, "create(...)");
        return uVarG;
    }

    public final u g() {
        u uVarG = u.g(new x() { // from class: com.uz.navee.ui.data.d
            @Override // p4.x
            public final void a(v vVar) {
                UserVehicleHelper.h(vVar);
            }
        });
        y.e(uVarG, "create(...)");
        return uVarG;
    }

    public final u i() {
        u uVarK = u.f(e(), g()).k();
        final UserVehicleHelper$getVehicles$1 userVehicleHelper$getVehicles$1 = new l() { // from class: com.uz.navee.ui.data.UserVehicleHelper$getVehicles$1
            @Override // q5.l
            public final List<Vehicle> invoke(List<List<Vehicle>> it) {
                y.f(it, "it");
                return kotlin.collections.u.w(it);
            }
        };
        u uVarL = uVarK.l(new o() { // from class: com.uz.navee.ui.data.a
            @Override // r4.o
            public final Object apply(Object obj) {
                return UserVehicleHelper.j(userVehicleHelper$getVehicles$1, obj);
            }
        });
        final UserVehicleHelper$getVehicles$2 userVehicleHelper$getVehicles$2 = new l() { // from class: com.uz.navee.ui.data.UserVehicleHelper$getVehicles$2
            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<? extends Vehicle>) obj);
                return kotlin.u.f15726a;
            }

            public final void invoke(List<? extends Vehicle> list) {
                b4.a.M(list);
            }
        };
        u uVarI = uVarL.i(new g() { // from class: com.uz.navee.ui.data.b
            @Override // r4.g
            public final void accept(Object obj) {
                UserVehicleHelper.k(userVehicleHelper$getVehicles$2, obj);
            }
        });
        y.e(uVarI, "doOnSuccess(...)");
        return uVarI;
    }
}
