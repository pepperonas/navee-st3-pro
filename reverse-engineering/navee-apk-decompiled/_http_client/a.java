package d4;

import android.os.Build;
import com.google.common.net.HttpHeaders;
import com.uz.navee.utils.y;
import g4.e1;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes3.dex */
public class a implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Request request = chain.request();
        String strF = com.uz.navee.utils.d.f();
        String str = Build.VERSION.RELEASE;
        String str2 = Build.MODEL;
        String strC = com.uz.navee.utils.d.c();
        String strI = e1.i();
        String strC2 = y.c();
        Request.Builder builderAddHeader = request.newBuilder().addHeader("platform", "android").addHeader("language", strF);
        if (str == null) {
            str = "";
        }
        Request.Builder builderAddHeader2 = builderAddHeader.addHeader("systemVersion", str);
        if (str2 == null) {
            str2 = "";
        }
        Request.Builder builderAddHeader3 = builderAddHeader2.addHeader("model", str2);
        if (strC == null) {
            strC = "";
        }
        Request.Builder builderAddHeader4 = builderAddHeader3.addHeader("appVersion", strC).addHeader(HttpHeaders.AUTHORIZATION, strI);
        if (strC2 == null) {
            strC2 = "";
        }
        Request requestBuild = builderAddHeader4.addHeader("area", strC2).build();
        f4.b.b(" 请求头: " + requestBuild.headers());
        return chain.proceed(requestBuild);
    }
}
