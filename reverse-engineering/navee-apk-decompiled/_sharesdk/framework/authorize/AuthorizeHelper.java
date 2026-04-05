package cn.sharesdk.framework.authorize;

import cn.sharesdk.framework.Platform;

/* loaded from: classes2.dex */
public interface AuthorizeHelper {
    AuthorizeListener getAuthorizeListener();

    String getAuthorizeUrl();

    b getAuthorizeWebviewClient(WebAuthorizeActivity webAuthorizeActivity);

    Platform getPlatform();

    String getRedirectUri();

    SSOListener getSSOListener();

    c getSSOProcessor(SSOAuthorizeActivity sSOAuthorizeActivity);
}
