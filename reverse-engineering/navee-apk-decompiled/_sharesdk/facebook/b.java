package cn.sharesdk.facebook;

import android.content.Intent;
import android.content.pm.Signature;
import android.text.TextUtils;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.authorize.SSOAuthorizeActivity;
import cn.sharesdk.framework.authorize.SSOListener;
import com.mob.MobSDK;
import com.mob.tools.utils.DH;

/* loaded from: classes2.dex */
public class b extends cn.sharesdk.framework.authorize.c {

    /* renamed from: d, reason: collision with root package name */
    private String f6113d;

    /* renamed from: e, reason: collision with root package name */
    private String[] f6114e;

    public b(SSOAuthorizeActivity sSOAuthorizeActivity) {
        super(sSOAuthorizeActivity);
    }

    private void b(Intent intent) {
        if (this.f6364c == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("error_message");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("error_code");
        }
        if (stringExtra == null) {
            this.f6364c.onComplete(intent.getExtras());
            return;
        }
        if (stringExtra.equals("access_denied") || stringExtra.equals("OAuthAccessDeniedException")) {
            this.f6364c.onCancel();
            return;
        }
        String stringExtra2 = intent.getStringExtra("error_message");
        if (stringExtra2 != null) {
            stringExtra = intent.getStringExtra("error_code") + ": " + stringExtra2;
        }
        this.f6364c.onFailed(new Throwable(stringExtra));
    }

    private void c(Intent intent) {
        SSOListener sSOListener = this.f6364c;
        if (sSOListener == null) {
            return;
        }
        if (intent == null) {
            sSOListener.onCancel();
            return;
        }
        String stringExtra = intent.getStringExtra("error");
        String stringExtra2 = intent.getStringExtra("error_code");
        if (stringExtra.equals("access_denied") && stringExtra2.equals("200")) {
            this.f6364c.onCancel();
            return;
        }
        this.f6364c.onFailed(new Throwable(stringExtra + " (" + stringExtra2 + ")"));
    }

    public void a(String str, String[] strArr) {
        this.f6113d = str;
        this.f6114e = strArr;
    }

    @Override // cn.sharesdk.framework.authorize.c
    public void a() {
        a(new ShareSDKCallback<Boolean>() { // from class: cn.sharesdk.facebook.b.1
            @Override // cn.sharesdk.framework.ShareSDKCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onCallback(Boolean bool) {
                if (bool.booleanValue()) {
                    return;
                }
                ((cn.sharesdk.framework.authorize.c) b.this).f6362a.finish();
                if (((cn.sharesdk.framework.authorize.c) b.this).f6364c != null) {
                    ((cn.sharesdk.framework.authorize.c) b.this).f6364c.onFailed(new Throwable());
                }
            }
        });
    }

    private void a(final ShareSDKCallback<Boolean> shareSDKCallback) {
        final Intent intent = new Intent();
        intent.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
        intent.putExtra("client_id", this.f6113d);
        String[] strArr = this.f6114e;
        if (strArr != null && strArr.length > 0) {
            intent.putExtra("scope", TextUtils.join(",", strArr));
        }
        a(intent, new ShareSDKCallback<Boolean>() { // from class: cn.sharesdk.facebook.b.2
            @Override // cn.sharesdk.framework.ShareSDKCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onCallback(Boolean bool) {
                if (!bool.booleanValue()) {
                    ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                    if (shareSDKCallback2 != null) {
                        shareSDKCallback2.onCallback(Boolean.FALSE);
                        return;
                    }
                    return;
                }
                try {
                    ((cn.sharesdk.framework.authorize.c) b.this).f6362a.startActivityForResult(intent, ((cn.sharesdk.framework.authorize.c) b.this).f6363b);
                    ShareSDKCallback shareSDKCallback3 = shareSDKCallback;
                    if (shareSDKCallback3 != null) {
                        shareSDKCallback3.onCallback(Boolean.TRUE);
                    }
                } catch (Throwable unused) {
                    ShareSDKCallback shareSDKCallback4 = shareSDKCallback;
                    if (shareSDKCallback4 != null) {
                        shareSDKCallback4.onCallback(Boolean.FALSE);
                    }
                }
            }
        });
    }

    private void a(Intent intent, final ShareSDKCallback<Boolean> shareSDKCallback) {
        DH.requester(MobSDK.getContext()).getPInfoForce(true, "com.facebook.katana", 64).resolveActivity(intent, 0).request(new DH.DHResponder() { // from class: cn.sharesdk.facebook.b.3
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                ShareSDKCallback shareSDKCallback2;
                try {
                    if (dHResponse.resolveActivity(new int[0]) == null) {
                        ShareSDKCallback shareSDKCallback3 = shareSDKCallback;
                        if (shareSDKCallback3 != null) {
                            shareSDKCallback3.onCallback(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                    try {
                        for (Signature signature : dHResponse.getPInfoForce(new int[0]).signatures) {
                            if ("30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2".equals(signature.toCharsString()) && (shareSDKCallback2 = shareSDKCallback) != null) {
                                shareSDKCallback2.onCallback(Boolean.TRUE);
                            }
                        }
                    } catch (Throwable unused) {
                        ShareSDKCallback shareSDKCallback4 = shareSDKCallback;
                        if (shareSDKCallback4 != null) {
                            shareSDKCallback4.onCallback(Boolean.FALSE);
                        }
                    }
                } catch (Throwable unused2) {
                    ShareSDKCallback shareSDKCallback5 = shareSDKCallback;
                    if (shareSDKCallback5 != null) {
                        shareSDKCallback5.onCallback(Boolean.FALSE);
                    }
                }
            }
        });
    }

    @Override // cn.sharesdk.framework.authorize.c
    public void a(int i6, int i7, Intent intent) {
        this.f6362a.finish();
        if (i6 == this.f6363b) {
            if (i7 == -1) {
                b(intent);
            } else {
                if (i7 != 0) {
                    return;
                }
                c(intent);
            }
        }
    }
}
