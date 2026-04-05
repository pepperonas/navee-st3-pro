package com.uz.navee.ui.web;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.clj.fastble.data.BleDevice;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.uz.navee.R$color;
import com.uz.navee.bean.Vehicle;
import com.uz.navee.bean.VehicleModel;
import com.uz.navee.databinding.FragmentWebBinding;
import com.uz.navee.ui.web.DefaultWebView;
import com.uz.navee.ui.web.WebActivity;
import com.uz.navee.utils.CommonExt;
import com.uz.navee.utils.DensityUtil;
import com.uz.navee.utils.b0;
import com.uz.navee.utils.z;
import g4.e1;
import java.util.Arrays;
import java.util.Locale;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.h0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.y;
import kotlin.k;
import kotlin.text.s;
import kotlin.u;
import kotlinx.coroutines.i;
import kotlinx.coroutines.u0;
import org.json.JSONException;
import org.json.JSONObject;
import pub.devrel.easypermissions.EasyPermissions;

/* loaded from: classes3.dex */
public class WebFragment extends Fragment {

    /* renamed from: g, reason: collision with root package name */
    public static final a f13181g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public FragmentWebBinding f13182a;

    /* renamed from: b, reason: collision with root package name */
    public q5.a f13183b;

    /* renamed from: c, reason: collision with root package name */
    public final f f13184c = h.b(new q5.a() { // from class: com.uz.navee.ui.web.WebFragment$device$2
        {
            super(0);
        }

        @Override // q5.a
        public final BleDevice invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return (BleDevice) CommonExt.f(arguments, "DEVICE", BleDevice.class);
            }
            return null;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    public final f f13185d = h.b(new q5.a() { // from class: com.uz.navee.ui.web.WebFragment$vehicle$2
        {
            super(0);
        }

        @Override // q5.a
        public final Vehicle invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return (Vehicle) CommonExt.g(arguments, "VEHICLE", Vehicle.class);
            }
            return null;
        }
    });

    /* renamed from: e, reason: collision with root package name */
    public final OnBackPressedCallback f13186e = new OnBackPressedCallback() { // from class: com.uz.navee.ui.web.WebFragment$backPressedCallback$1
        {
            super(true);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            if (this.f13192a.f13183b != null) {
                q5.a aVar = this.f13192a.f13183b;
                if (aVar != null) {
                    aVar.invoke();
                    return;
                }
                return;
            }
            if (this.f13192a.o().webView.canGoBack()) {
                this.f13192a.o().webView.goBack();
                return;
            }
            setEnabled(false);
            this.f13192a.requireActivity().onBackPressed();
            setEnabled(true);
        }
    };

    /* renamed from: f, reason: collision with root package name */
    public final b0 f13187f = new b0() { // from class: com.uz.navee.ui.web.c
        @Override // com.uz.navee.utils.b0
        public final void a(Location location) {
            WebFragment.s(this.f13198a, location);
        }
    };

    public final class JSAndroidImpl implements DefaultWebView.a {
        public JSAndroidImpl() {
        }

        @Override // com.uz.navee.ui.web.DefaultWebView.a
        public String a() {
            return "nativeBridge";
        }

        public final void b(String str, String str2) {
            String strOptString = new JSONObject(str).optString("callback");
            y.c(strOptString);
            if (s.s(strOptString)) {
                strOptString = null;
            }
            if (strOptString != null) {
                WebFragment.this.m(strOptString, null, str2);
            }
        }

        @JavascriptInterface
        public final void clearBackHandler(String str) {
            WebFragment.this.f13183b = null;
        }

        @JavascriptInterface
        public final void closeWebView() {
            WebFragment.this.requireActivity().finish();
        }

        @JavascriptInterface
        public final void getArea(String str) {
            String strC = com.uz.navee.utils.y.c();
            WebFragment webFragment = WebFragment.this;
            y.c(strC);
            webFragment.m("receiveGetArea", null, strC);
        }

        @JavascriptInterface
        public final void getLanguage(String str) {
            String strF = com.uz.navee.utils.d.f();
            WebFragment webFragment = WebFragment.this;
            y.c(strF);
            webFragment.m("receiveGetLanguage", null, strF);
        }

        @JavascriptInterface
        public final void getLocation(String str) {
            LifecycleOwner viewLifecycleOwner = WebFragment.this.getViewLifecycleOwner();
            y.e(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            i.d(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), u0.c(), null, new WebFragment$JSAndroidImpl$getLocation$1(WebFragment.this, null), 2, null);
        }

        @JavascriptInterface
        public final void getSafeArea(String str) throws JSONException {
            if (WebFragment.this.isAdded()) {
                Rect rectI = com.uz.navee.utils.d.i(WebFragment.this.requireActivity());
                JSONObject jSONObject = new JSONObject();
                WebFragment webFragment = WebFragment.this;
                jSONObject.put(TtmlNode.LEFT, DensityUtil.b(webFragment.getContext(), rectI.left));
                jSONObject.put("top", DensityUtil.b(webFragment.getContext(), rectI.top));
                jSONObject.put(TtmlNode.RIGHT, DensityUtil.b(webFragment.getContext(), rectI.right));
                jSONObject.put("bottom", DensityUtil.b(webFragment.getContext(), rectI.bottom));
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, DensityUtil.b(webFragment.getContext(), com.uz.navee.utils.d.k(webFragment.getActivity())));
                String string = jSONObject.toString();
                y.e(string, "toString(...)");
                WebFragment.this.m("receiveGetSafeArea", null, string);
            }
        }

        @JavascriptInterface
        public final void getScooterInfo(String str) {
            String str2;
            VehicleModel vehicleModel;
            int mileageUnit = 0;
            f4.b.c("getScooterInfo，param=" + str, new Object[0]);
            if (str != null) {
                WebFragment webFragment = WebFragment.this;
                Vehicle vehicleR = webFragment.r();
                String str3 = (vehicleR == null || (vehicleModel = vehicleR.model) == null) ? null : vehicleModel.pid;
                if (b4.a.f(webFragment.p())) {
                    float totalMileage = b4.a.W().f1932e.getTotalMileage();
                    if (b4.a.W().f1932e.getVersion() == 1) {
                        totalMileage /= 10.0f;
                    }
                    h0 h0Var = h0.f15610a;
                    str2 = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(totalMileage)}, 1));
                    y.e(str2, "format(...)");
                    mileageUnit = b4.a.W().f1933f.getMileageUnit();
                } else {
                    str2 = "0.0";
                }
                b(str, "{\"pid\":\"" + str3 + "\",\"totalMileage\":\"" + str2 + "\",\"mileageUnit\":\"" + mileageUnit + "\"}");
            }
        }

        @JavascriptInterface
        public final void getToken(String str) {
            String strI = e1.i();
            WebFragment webFragment = WebFragment.this;
            y.c(strI);
            webFragment.m("receiveGetToken", null, strI);
        }

        @JavascriptInterface
        public final void getUserInfo(String str) {
            f4.b.c("调用getUserInfo，param=" + str, new Object[0]);
            if (str != null) {
                b(str, "{\"naveeId\":\"" + e1.u().f13675c.getNaveeId() + "\"}");
            }
        }

        @JavascriptInterface
        public final void hideBottomBar(String params) {
            y.f(params, "params");
        }

        @JavascriptInterface
        public final void openWebView(String params) {
            y.f(params, "params");
            if (WebFragment.this.isAdded()) {
                try {
                    JSONObject jSONObject = new JSONObject(params);
                    WebFragment webFragment = WebFragment.this;
                    String strOptString = jSONObject.optString("title");
                    String strOptString2 = jSONObject.optString(ImagesContract.URL);
                    boolean z6 = jSONObject.optInt("hasPageHeader") == 1;
                    y.c(strOptString2);
                    if (strOptString2.length() > 0) {
                        WebActivity.a aVar = WebActivity.f13179h;
                        Context contextRequireContext = webFragment.requireContext();
                        y.e(contextRequireContext, "requireContext(...)");
                        y.c(strOptString);
                        WebActivity.a.c(aVar, contextRequireContext, strOptString, strOptString2, !z6, null, null, 48, null);
                    }
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
        }

        @JavascriptInterface
        public final void screenShot(String str) {
            LifecycleOwner viewLifecycleOwner = WebFragment.this.getViewLifecycleOwner();
            y.e(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            i.d(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), u0.c(), null, new WebFragment$JSAndroidImpl$screenShot$1(WebFragment.this, null), 2, null);
        }

        @JavascriptInterface
        public final void setBackHandler(final String method) {
            y.f(method, "method");
            final WebFragment webFragment = WebFragment.this;
            webFragment.f13183b = new q5.a() { // from class: com.uz.navee.ui.web.WebFragment$JSAndroidImpl$setBackHandler$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // q5.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m123invoke();
                    return u.f15726a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m123invoke() {
                    webFragment.m(method, null, new Object[0]);
                }
            };
        }

        @JavascriptInterface
        public final void setTitle(String title) {
            y.f(title, "title");
            LifecycleOwner viewLifecycleOwner = WebFragment.this.getViewLifecycleOwner();
            y.e(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            i.d(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), u0.c(), null, new WebFragment$JSAndroidImpl$setTitle$1(WebFragment.this, title, null), 2, null);
        }

        @JavascriptInterface
        public final void shareContent(String param) {
            y.f(param, "param");
            if (WebFragment.this.isAdded()) {
                try {
                    JSONObject jSONObject = new JSONObject(param);
                    WebFragment webFragment = WebFragment.this;
                    String strOptString = jSONObject.optString("title");
                    String strOptString2 = jSONObject.optString(FirebaseAnalytics.Param.CONTENT);
                    String strOptString3 = jSONObject.optString(ImagesContract.URL);
                    y.c(strOptString2);
                    if (strOptString2.length() > 0) {
                        webFragment.u(strOptString, strOptString2 + ":" + strOptString3);
                    }
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
        }

        @JavascriptInterface
        public final void showBottomBar(String params) {
            y.f(params, "params");
        }

        @JavascriptInterface
        public final void takePhoto(String str) {
        }

        @JavascriptInterface
        public final void takeVideo(String str) {
        }

        @JavascriptInterface
        public final void closeWebView(String str) {
            WebFragment.this.requireActivity().finish();
        }
    }

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public static /* synthetic */ WebFragment b(a aVar, String str, String str2, boolean z6, BleDevice bleDevice, Vehicle vehicle, int i6, Object obj) {
            if ((i6 & 4) != 0) {
                z6 = false;
            }
            return aVar.a(str, str2, z6, (i6 & 8) != 0 ? null : bleDevice, (i6 & 16) != 0 ? null : vehicle);
        }

        public final WebFragment a(String title, String url, boolean z6, BleDevice bleDevice, Vehicle vehicle) {
            y.f(title, "title");
            y.f(url, "url");
            WebFragment webFragment = new WebFragment();
            webFragment.setArguments(BundleKt.bundleOf(k.a("TITLE", title), k.a("INDEX_URL", url), k.a("show_title_bar", Boolean.valueOf(z6)), k.a("DEVICE", bleDevice), k.a("VEHICLE", vehicle)));
            return webFragment;
        }
    }

    public static final class b extends WebChromeClient {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f13189a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f13190b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WebFragment f13191c;

        public b(boolean z6, String str, WebFragment webFragment) {
            this.f13189a = z6;
            this.f13190b = str;
            this.f13191c = webFragment;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            y.f(consoleMessage, "consoleMessage");
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView view, int i6) {
            y.f(view, "view");
            this.f13191c.o().progressBar.setProgress(i6);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (!TextUtils.isEmpty(str) && this.f13189a && this.f13190b.length() == 0) {
                this.f13191c.o().include.titleViewToolbar.setText(str);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }
    }

    public static final class c extends WebViewClient {
        public c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            ProgressBar progressBar = WebFragment.this.o().progressBar;
            y.e(progressBar, "progressBar");
            progressBar.setVisibility(8);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            ProgressBar progressBar = WebFragment.this.o().progressBar;
            y.e(progressBar, "progressBar");
            progressBar.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (s.D(String.valueOf(webResourceRequest != null ? webResourceRequest.getUrl() : null), "http", false, 2, null)) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @pub.devrel.easypermissions.a(1002)
    public final void captureWeb() {
        final DefaultWebView defaultWebView = o().webView;
        int contentHeight = (int) (defaultWebView.getContentHeight() * defaultWebView.getScale());
        final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(defaultWebView.getWidth(), contentHeight, Bitmap.Config.ARGB_8888);
        defaultWebView.measure(View.MeasureSpec.makeMeasureSpec(defaultWebView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(contentHeight, 1073741824));
        defaultWebView.layout(0, defaultWebView.getTop(), defaultWebView.getWidth(), defaultWebView.getTop() + contentHeight);
        defaultWebView.postDelayed(new Runnable() { // from class: com.uz.navee.ui.web.b
            @Override // java.lang.Runnable
            public final void run() {
                WebFragment.n(defaultWebView, bitmapCreateBitmap, this);
            }
        }, 200L);
    }

    public static final void n(DefaultWebView this_run, Bitmap bitmap, WebFragment this$0) {
        y.f(this_run, "$this_run");
        y.f(bitmap, "$bitmap");
        y.f(this$0, "this$0");
        this_run.draw(new Canvas(bitmap));
        LifecycleOwner viewLifecycleOwner = this$0.getViewLifecycleOwner();
        y.e(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        i.d(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), u0.b(), null, new WebFragment$captureWeb$1$1$1(bitmap, this$0, null), 2, null);
        this_run.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BleDevice p() {
        return (BleDevice) this.f13184c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Vehicle r() {
        return (Vehicle) this.f13185d.getValue();
    }

    public static final void s(WebFragment this$0, Location location) {
        y.f(this$0, "this$0");
        if (location != null) {
            this$0.m("receiveGetLocation", null, "{\"longitude\":" + location.getLongitude() + ",\"latitude\":" + location.getLatitude() + "}");
        }
    }

    @pub.devrel.easypermissions.a(1001)
    private final void startLocate() {
        z.b().f13294b = this.f13187f;
        z.b().c(requireActivity());
    }

    public static final void t(WebFragment this$0, View view) {
        y.f(this$0, "this$0");
        this$0.requireActivity().onBackPressed();
    }

    public final void m(String str, ValueCallback valueCallback, Object... objArr) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        y.e(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        i.d(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), u0.c(), null, new WebFragment$callJSMethod$1(this, str, valueCallback, objArr, null), 2, null);
    }

    public final FragmentWebBinding o() {
        FragmentWebBinding fragmentWebBinding = this.f13182a;
        y.c(fragmentWebBinding);
        return fragmentWebBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        y.f(inflater, "inflater");
        this.f13182a = FragmentWebBinding.inflate(inflater, viewGroup, false);
        View root = o().getRoot();
        y.e(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        o().webView.destroy();
        z.b().f13294b = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f13186e.setEnabled(false);
        o().webView.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i6, String[] permissions, int[] grantResults) {
        y.f(permissions, "permissions");
        y.f(grantResults, "grantResults");
        EasyPermissions.d(i6, permissions, grantResults, this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f13186e.setEnabled(true);
        o().webView.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String string;
        y.f(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("TITLE")) == null) {
            string = "";
        }
        Bundle arguments2 = getArguments();
        boolean zJ = CommonExt.j(arguments2 != null ? Boolean.valueOf(arguments2.getBoolean("show_title_bar")) : null);
        View root = o().getRoot();
        y.e(root, "getRoot(...)");
        com.uz.navee.utils.c.d(root, string, ContextCompat.getColor(requireContext(), R$color.nav_title_color), new View.OnClickListener() { // from class: com.uz.navee.ui.web.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WebFragment.t(this.f13194a, view2);
            }
        });
        if (!zJ) {
            Toolbar toolbar = o().include.toolbar;
            y.e(toolbar, "toolbar");
            toolbar.setVisibility(8);
        }
        DefaultWebView webView = o().webView;
        y.e(webView, "webView");
        webView.setBackgroundColor(0);
        webView.setWebChromeClient(new b(zJ, string, this));
        webView.setWebViewClient(new c());
        webView.a(new JSAndroidImpl());
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        y.e(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.addCallback(viewLifecycleOwner, this.f13186e);
        webView.loadUrl(q());
    }

    public String q() {
        String string;
        Bundle arguments = getArguments();
        return (arguments == null || (string = arguments.getString("INDEX_URL")) == null) ? "" : string;
    }

    public final void u(String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str2);
        if (str != null) {
            intent.putExtra("android.intent.extra.TITLE", str);
        }
        intent.setType("text/plain");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        y.e(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        i.d(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new WebFragment$share$2(intent, this, null), 3, null);
    }
}
