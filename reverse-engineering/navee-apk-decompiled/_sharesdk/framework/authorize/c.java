package cn.sharesdk.framework.authorize;

import android.content.Intent;

/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    protected SSOAuthorizeActivity f6362a;

    /* renamed from: b, reason: collision with root package name */
    protected int f6363b;

    /* renamed from: c, reason: collision with root package name */
    protected SSOListener f6364c;

    public c(SSOAuthorizeActivity sSOAuthorizeActivity) {
        this.f6362a = sSOAuthorizeActivity;
        this.f6364c = sSOAuthorizeActivity.getHelper().getSSOListener();
    }

    public abstract void a();

    public void a(int i6, int i7, Intent intent) {
    }

    public void a(Intent intent) {
    }

    public void a(int i6) {
        this.f6363b = i6;
    }
}
