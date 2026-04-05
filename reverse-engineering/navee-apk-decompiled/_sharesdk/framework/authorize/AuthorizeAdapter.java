package cn.sharesdk.framework.authorize;

import android.app.Activity;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import cn.sharesdk.framework.TitleLayout;

/* loaded from: classes2.dex */
public class AuthorizeAdapter {
    private Activity activity;
    private boolean noTitle;
    private String platform;
    private boolean popUpAnimationDisable;
    private RelativeLayout rlBody;
    private TitleLayout title;
    private WebView webview;

    public void disablePopUpAnimation() {
        this.popUpAnimationDisable = true;
    }

    public Activity getActivity() {
        return this.activity;
    }

    public RelativeLayout getBodyView() {
        return this.rlBody;
    }

    public String getPlatformName() {
        return this.platform;
    }

    public TitleLayout getTitleLayout() {
        return this.title;
    }

    public WebView getWebBody() {
        return this.webview;
    }

    public void hideShareSDKLogo() {
        getTitleLayout().getChildAt(getTitleLayout().getChildCount() - 1).setVisibility(8);
    }

    public boolean isNotitle() {
        return this.noTitle;
    }

    public boolean isPopUpAnimationDisable() {
        return this.popUpAnimationDisable;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public boolean onFinish() {
        return false;
    }

    public boolean onKeyEvent(int i6, KeyEvent keyEvent) {
        return false;
    }

    public void onPause() {
    }

    public void onResize(int i6, int i7, int i8, int i9) {
    }

    public void onRestart() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setBodyView(RelativeLayout relativeLayout) {
        this.rlBody = relativeLayout;
    }

    public void setNotitle(boolean z6) {
        this.noTitle = z6;
    }

    public void setPlatformName(String str) {
        this.platform = str;
    }

    public void setTitleView(TitleLayout titleLayout) {
        this.title = titleLayout;
    }

    public void setWebView(WebView webView) {
        this.webview = webView;
    }
}
