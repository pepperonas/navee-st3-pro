package cn.sharesdk.framework;

import cn.sharesdk.framework.authorize.AuthorizeHelper;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOAuthorizeActivity;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.authorize.WebAuthorizeActivity;

/* loaded from: classes2.dex */
public abstract class f implements AuthorizeHelper {

    /* renamed from: a, reason: collision with root package name */
    protected Platform f6385a;

    /* renamed from: b, reason: collision with root package name */
    private AuthorizeListener f6386b;

    /* renamed from: c, reason: collision with root package name */
    private SSOListener f6387c;

    public f(Platform platform) {
        this.f6385a = platform;
    }

    public void a(SSOListener sSOListener) {
        this.f6387c = sSOListener;
        SSOAuthorizeActivity sSOAuthorizeActivity = new SSOAuthorizeActivity();
        sSOAuthorizeActivity.setSSOListener(sSOListener);
        sSOAuthorizeActivity.show(this);
    }

    public int b() {
        return this.f6385a.getPlatformId();
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public AuthorizeListener getAuthorizeListener() {
        return this.f6386b;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public Platform getPlatform() {
        return this.f6385a;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public SSOListener getSSOListener() {
        return this.f6387c;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public cn.sharesdk.framework.authorize.c getSSOProcessor(SSOAuthorizeActivity sSOAuthorizeActivity) {
        return null;
    }

    public void b(AuthorizeListener authorizeListener) {
        this.f6386b = authorizeListener;
        WebAuthorizeActivity webAuthorizeActivity = new WebAuthorizeActivity();
        webAuthorizeActivity.setAuthorizeListener(this.f6386b);
        webAuthorizeActivity.show(this);
    }
}
