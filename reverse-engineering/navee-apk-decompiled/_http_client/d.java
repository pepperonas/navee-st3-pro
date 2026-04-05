package d4;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import b6.p;
import com.google.common.net.HttpHeaders;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.uz.navee.MyApplication;
import com.uz.navee.R$string;
import com.uz.navee.bean.HttpResponse;
import com.uz.navee.ui.login.LoginLaunchActivity;
import com.uz.navee.ui.wheel.AlertPopup;
import com.uz.navee.utils.FloatingWindowManager;
import com.uz.navee.utils.o;
import d4.d;
import g4.e1;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    public static volatile d f13427c;

    /* renamed from: a, reason: collision with root package name */
    public final Handler f13428a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public final OkHttpClient f13429b;

    public class a implements HttpLoggingInterceptor.Logger {
        public a() {
        }

        @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
        public void log(String str) {
            f4.b.b(str);
        }
    }

    public class b extends TypeToken<HttpResponse<Object>> {
        public b() {
        }
    }

    public class c implements Callback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f13432a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f13433b;

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IOException f13435a;

            public a(IOException iOException) {
                this.f13435a = iOException;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f13432a.b(this.f13435a);
            }
        }

        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f13437a;

            public b(String str) {
                this.f13437a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.i(this.f13437a)) {
                    c.this.f13432a.a(this.f13437a);
                }
                f4.b.b(" 网络请求: " + c.this.f13433b + " ==> \n" + this.f13437a);
            }
        }

        public c(h hVar, String str) {
            this.f13432a = hVar;
            this.f13433b = str;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            d.this.f13428a.post(new a(iOException));
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            if (response.isSuccessful()) {
                ResponseBody responseBodyBody = response.body();
                Objects.requireNonNull(responseBodyBody);
                String strString = responseBodyBody.string();
                if (this.f13432a != null) {
                    d.this.f13428a.post(new b(strString));
                }
            }
        }
    }

    /* renamed from: d4.d$d, reason: collision with other inner class name */
    public class C0190d implements Callback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f13439a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f13440b;

        /* renamed from: d4.d$d$a */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IOException f13442a;

            public a(IOException iOException) {
                this.f13442a = iOException;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0190d.this.f13439a.b(this.f13442a);
                String message = this.f13442a.getMessage();
                Objects.requireNonNull(message);
                Log.e("doPost==err==", message);
            }
        }

        /* renamed from: d4.d$d$b */
        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f13444a;

            public b(String str) {
                this.f13444a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.i(this.f13444a)) {
                    C0190d.this.f13439a.a(this.f13444a);
                }
                f4.b.b(" 网络请求: " + C0190d.this.f13440b + " ==> \n" + this.f13444a);
            }
        }

        public C0190d(h hVar, String str) {
            this.f13439a = hVar;
            this.f13440b = str;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            d.this.f13428a.post(new a(iOException));
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            if (response.isSuccessful()) {
                ResponseBody responseBodyBody = response.body();
                Objects.requireNonNull(responseBodyBody);
                String strString = responseBodyBody.string();
                if (this.f13439a != null) {
                    d.this.f13428a.post(new b(strString));
                }
            }
        }
    }

    public class e implements Callback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f13446a;

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f13448a;

            public a(String str) {
                this.f13448a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f13446a.a(this.f13448a);
            }
        }

        public e(h hVar) {
            this.f13446a = hVar;
        }

        public static /* synthetic */ void b(h hVar, IOException iOException) {
            hVar.b(iOException);
            String message = iOException.getMessage();
            Objects.requireNonNull(message);
            Log.e("doPostToken==err==", message);
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, final IOException iOException) {
            Handler handler = d.this.f13428a;
            final h hVar = this.f13446a;
            handler.post(new Runnable() { // from class: d4.e
                @Override // java.lang.Runnable
                public final void run() {
                    d.e.b(hVar, iOException);
                }
            });
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            if (response.isSuccessful()) {
                ResponseBody responseBodyBody = response.body();
                Objects.requireNonNull(responseBodyBody);
                String strString = responseBodyBody.string();
                if (this.f13446a != null) {
                    d.this.f13428a.post(new a(strString));
                }
            }
        }
    }

    public class f extends RequestBody {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13450a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ContentResolver f13451b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Uri f13452c;

        public f(String str, ContentResolver contentResolver, Uri uri) {
            this.f13450a = str;
            this.f13451b = contentResolver;
            this.f13452c = uri;
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return MediaType.parse(this.f13450a);
        }

        @Override // okhttp3.RequestBody
        public void writeTo(b6.g gVar) throws IOException {
            InputStream inputStreamOpenInputStream = this.f13451b.openInputStream(this.f13452c);
            try {
                if (inputStreamOpenInputStream != null) {
                    gVar.o(p.k(inputStreamOpenInputStream));
                    inputStreamOpenInputStream.close();
                } else {
                    throw new IOException("Cannot open InputStream for uri: " + this.f13452c);
                }
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    public class g implements Callback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f13453a;

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f13455a;

            public a(String str) {
                this.f13455a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.f13453a.a(this.f13455a);
            }
        }

        public g(h hVar) {
            this.f13453a = hVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(h hVar, IOException iOException) {
            hVar.b(iOException);
            String message = iOException.getMessage();
            Objects.requireNonNull(message);
            Log.e("doPostToken==err==", message);
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, final IOException iOException) {
            Handler handler = d.this.f13428a;
            final h hVar = this.f13453a;
            handler.post(new Runnable() { // from class: d4.f
                @Override // java.lang.Runnable
                public final void run() {
                    d.g.b(hVar, iOException);
                }
            });
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            if (response.isSuccessful()) {
                ResponseBody responseBodyBody = response.body();
                Objects.requireNonNull(responseBodyBody);
                String strString = responseBodyBody.string();
                if (this.f13453a != null) {
                    d.this.f13428a.post(new a(strString));
                }
            }
        }
    }

    public interface h {
        void a(String str);

        void b(Exception exc);
    }

    public d() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new a());
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builderAddInterceptor = new OkHttpClient.Builder().addInterceptor(new d4.a()).addInterceptor(httpLoggingInterceptor);
        long j6 = 30;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f13429b = builderAddInterceptor.connectTimeout(j6, timeUnit).readTimeout(j6, timeUnit).writeTimeout(j6, timeUnit).build();
    }

    public static MultipartBody.Part e(Uri uri, String str) {
        Context contextB = MyApplication.b();
        ContentResolver contentResolver = contextB.getContentResolver();
        String strF = o.f(contextB, uri);
        if (strF == null) {
            strF = "upload_file";
        }
        String type = contentResolver.getType(uri);
        if (type == null) {
            type = "application/octet-stream";
        }
        return MultipartBody.Part.createFormData(str, strF, new f(type, contentResolver, uri));
    }

    public static d h() {
        if (f13427c == null) {
            synchronized (d4.g.class) {
                try {
                    if (f13427c == null) {
                        f13427c = new d();
                    }
                } finally {
                }
            }
        }
        return f13427c;
    }

    public static /* synthetic */ void j(Activity activity) {
        e1.m();
        LoginLaunchActivity.Q0(activity);
    }

    public void d(String str, String str2, h hVar) {
        if (com.uz.navee.utils.d.m(MyApplication.b())) {
            File file = new File(str2);
            this.f13429b.newCall(new Request.Builder().url(str).post(new MultipartBody.Builder().addFormDataPart("file", file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file)).setType(MultipartBody.FORM).build()).addHeader("content-type", "multipart/form-data").build()).enqueue(new g(hVar));
            return;
        }
        Activity activityB = com.uz.navee.e.c().b();
        if (activityB != null) {
            Toast.makeText(activityB, R$string.no_network_msg, 0).show();
        }
    }

    public void f(String str, h hVar) {
        if (com.uz.navee.utils.d.m(MyApplication.b())) {
            this.f13429b.newCall(new Request.Builder().url(str).get().addHeader(HttpHeaders.ACCEPT, "application/json").addHeader("content-type", String.valueOf(e4.b.f13488a)).build()).enqueue(new c(hVar, str));
        } else {
            Activity activityB = com.uz.navee.e.c().b();
            if (activityB != null) {
                Toast.makeText(activityB, R$string.no_network_msg, 0).show();
            }
        }
    }

    public void g(String str, Object obj, h hVar) {
        if (!com.uz.navee.utils.d.m(MyApplication.b())) {
            Activity activityB = com.uz.navee.e.c().b();
            if (activityB != null) {
                Toast.makeText(activityB, R$string.no_network_msg, 0).show();
                return;
            }
            return;
        }
        Gson gsonCreate = new GsonBuilder().enableComplexMapKeySerialization().create();
        MediaType mediaType = e4.b.f13488a;
        this.f13429b.newCall(new Request.Builder().url(str).post(RequestBody.create(gsonCreate.toJson(obj), mediaType)).addHeader(HttpHeaders.ACCEPT, "application/json").addHeader("content-type", String.valueOf(mediaType)).build()).enqueue(new C0190d(hVar, str));
    }

    public boolean i(String str) {
        HttpResponse httpResponse = (HttpResponse) new GsonBuilder().create().fromJson(str, new b().getType());
        if (httpResponse == null) {
            return true;
        }
        int code = httpResponse.getCode();
        String msg = httpResponse.getMsg();
        final Activity activityB = com.uz.navee.e.c().b();
        if (activityB == null) {
            return true;
        }
        if (code == 401) {
            Iterator it = FloatingWindowManager.f13265a.a(activityB).iterator();
            while (it.hasNext()) {
                ((View) it.next()).setVisibility(8);
            }
            AlertPopup.Q(activityB, activityB.getString(R$string.prompts), msg, activityB.getString(R$string.confirm), "", new AlertPopup.a() { // from class: d4.b
                @Override // com.uz.navee.ui.wheel.AlertPopup.a
                public /* synthetic */ void a() {
                    j4.c.a(this);
                }

                @Override // com.uz.navee.ui.wheel.AlertPopup.a
                public final void b() {
                    d.j(activityB);
                }
            });
            return false;
        }
        if (code != 410) {
            return true;
        }
        Iterator it2 = FloatingWindowManager.f13265a.a(activityB).iterator();
        while (it2.hasNext()) {
            ((View) it2.next()).setVisibility(8);
        }
        AlertPopup.Q(activityB, activityB.getString(R$string.prompts), msg, activityB.getString(R$string.confirm), "", new AlertPopup.a() { // from class: d4.c
            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public /* synthetic */ void a() {
                j4.c.a(this);
            }

            @Override // com.uz.navee.ui.wheel.AlertPopup.a
            public final void b() {
                System.exit(0);
            }
        });
        return false;
    }

    public void l(String str, Uri uri, h hVar) {
        if (com.uz.navee.utils.d.m(MyApplication.b())) {
            this.f13429b.newCall(new Request.Builder().url(str).post(new MultipartBody.Builder().addPart(e(uri, "file")).setType(MultipartBody.FORM).build()).addHeader("content-type", "multipart/form-data").build()).enqueue(new e(hVar));
        } else {
            Activity activityB = com.uz.navee.e.c().b();
            if (activityB != null) {
                Toast.makeText(activityB, R$string.no_network_msg, 0).show();
            }
            hVar.b(new Exception(MyApplication.b().getString(R$string.no_network_msg)));
        }
    }
}
