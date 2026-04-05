package cn.sharesdk.onekeyshare.themes.classic;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.sharesdk.framework.CustomPlatform;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.onekeyshare.CustomerLogo;
import cn.sharesdk.onekeyshare.OnekeySharePage;
import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import com.mob.tools.FakeActivity;
import com.mob.tools.gui.MobViewPager;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public abstract class PlatformPage extends OnekeySharePage {
    private Animation animHide;
    private Animation animShow;
    private Runnable beforeFinish;
    private boolean finished;
    private ClassicTheme impl;
    private LinearLayout llPanel;

    /* renamed from: cn.sharesdk.onekeyshare.themes.classic.PlatformPage$2, reason: invalid class name */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ Platform val$platform;

        public AnonymousClass2(Platform platform) {
            this.val$platform = platform;
        }

        @Override // java.lang.Runnable
        public void run() {
            final boolean zIsSilent = PlatformPage.this.isSilent();
            Platform platform = this.val$platform;
            final boolean z6 = platform instanceof CustomPlatform;
            PlatformPage.this.isUseClientToShare(platform, new ShareSDKCallback<Boolean>() { // from class: cn.sharesdk.onekeyshare.themes.classic.PlatformPage.2.1
                @Override // cn.sharesdk.framework.ShareSDKCallback
                public void onCallback(Boolean bool) {
                    if (zIsSilent || z6 || bool.booleanValue()) {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        PlatformPage.this.shareSilently(anonymousClass2.val$platform);
                    } else {
                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                        PlatformPage.this.formateShareData(anonymousClass22.val$platform, new ShareSDKCallback<Platform.ShareParams>() { // from class: cn.sharesdk.onekeyshare.themes.classic.PlatformPage.2.1.1
                            @Override // cn.sharesdk.framework.ShareSDKCallback
                            public void onCallback(Platform.ShareParams shareParams) {
                                if (shareParams != null) {
                                    ShareSDK.logDemoEvent(3, AnonymousClass2.this.val$platform);
                                    shareParams.setOpenCustomEven(true);
                                    if (PlatformPage.this.getCustomizeCallback() != null) {
                                        PlatformPage.this.getCustomizeCallback().onShare(AnonymousClass2.this.val$platform, shareParams);
                                    }
                                    PlatformPage.this.impl.showEditPage(((FakeActivity) PlatformPage.this).activity, AnonymousClass2.this.val$platform, shareParams);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public PlatformPage(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        super(onekeyShareThemeImpl);
        this.impl = (ClassicTheme) ResHelper.forceCast(onekeyShareThemeImpl);
    }

    private void initAnims() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        this.animShow = translateAnimation;
        translateAnimation.setDuration(300L);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        this.animHide = translateAnimation2;
        translateAnimation2.setDuration(300L);
    }

    private boolean isCanShare(Platform platform) {
        String name = platform.getName();
        return ("Cmcc".equals(name) || "Accountkit".equals(name) || "Telecom".equals(name) || "GooglePlus".equals(name) || "HWAccount".equals(name)) ? false : true;
    }

    public ArrayList<Object> collectCells() {
        ArrayList<Object> arrayList = new ArrayList<>();
        Platform[] platformList = ShareSDK.getPlatformList();
        if (platformList == null) {
            platformList = new Platform[0];
        }
        HashMap<String, String> hiddenPlatforms = getHiddenPlatforms();
        if (hiddenPlatforms == null) {
            hiddenPlatforms = new HashMap<>();
        }
        for (Platform platform : platformList) {
            if (!hiddenPlatforms.containsKey(platform.getName()) && isCanShare(platform)) {
                arrayList.add(platform);
            }
        }
        ArrayList<CustomerLogo> customerLogos = getCustomerLogos();
        if (customerLogos != null && customerLogos.size() > 0) {
            arrayList.addAll(customerLogos);
        }
        return arrayList;
    }

    public abstract PlatformPageAdapter newAdapter(ArrayList<Object> arrayList);

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        this.activity.getWindow().setBackgroundDrawable(new ColorDrawable(1275068416));
        initAnims();
        LinearLayout linearLayout = new LinearLayout(this.activity);
        linearLayout.setOrientation(1);
        OnekeySharePage.setViewFitsSystemWindows(linearLayout);
        this.activity.setContentView(linearLayout);
        TextView textView = new TextView(this.activity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.weight = 1.0f;
        textView.setOnClickListener(new View.OnClickListener() { // from class: cn.sharesdk.onekeyshare.themes.classic.PlatformPage.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PlatformPage.this.finish();
            }
        });
        linearLayout.addView(textView, layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(this.activity);
        this.llPanel = linearLayout2;
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.llPanel.setAnimation(this.animShow);
        linearLayout.addView(this.llPanel, layoutParams2);
        MobViewPager mobViewPager = new MobViewPager(this.activity);
        PlatformPageAdapter platformPageAdapterNewAdapter = newAdapter(collectCells());
        this.llPanel.addView(mobViewPager, new LinearLayout.LayoutParams(-1, platformPageAdapterNewAdapter.getPanelHeight()));
        IndicatorView indicatorView = new IndicatorView(this.activity);
        this.llPanel.addView(indicatorView, new LinearLayout.LayoutParams(-1, platformPageAdapterNewAdapter.getBottomHeight()));
        indicatorView.setScreenCount(platformPageAdapterNewAdapter.getCount());
        indicatorView.onScreenChange(0, 0);
        platformPageAdapterNewAdapter.setIndicator(indicatorView);
        mobViewPager.setAdapter(platformPageAdapterNewAdapter);
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onFinish() {
        if (this.finished) {
            this.finished = false;
            return false;
        }
        this.animHide.setAnimationListener(new Animation.AnimationListener() { // from class: cn.sharesdk.onekeyshare.themes.classic.PlatformPage.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (PlatformPage.this.beforeFinish == null) {
                    ShareSDK.logDemoEvent(2, null);
                } else {
                    PlatformPage.this.beforeFinish.run();
                    PlatformPage.this.beforeFinish = null;
                }
                PlatformPage.this.finished = true;
                PlatformPage.this.finish();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.llPanel.clearAnimation();
        this.llPanel.setAnimation(this.animHide);
        this.llPanel.setVisibility(8);
        return true;
    }

    public final void performCustomLogoClick(final View view, final CustomerLogo customerLogo) {
        this.beforeFinish = new Runnable() { // from class: cn.sharesdk.onekeyshare.themes.classic.PlatformPage.3
            @Override // java.lang.Runnable
            public void run() {
                customerLogo.listener.onClick(view);
            }
        };
        finish();
    }

    public final void showEditPage(Platform platform) {
        this.beforeFinish = new AnonymousClass2(platform);
        finish();
    }
}
