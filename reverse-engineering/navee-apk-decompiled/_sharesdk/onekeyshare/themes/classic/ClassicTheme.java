package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Context;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.onekeyshare.themes.classic.land.EditPageLand;
import cn.sharesdk.onekeyshare.themes.classic.land.PlatformPageLand;
import cn.sharesdk.onekeyshare.themes.classic.port.EditPagePort;
import cn.sharesdk.onekeyshare.themes.classic.port.PlatformPagePort;
import com.mob.tools.FakeActivity;

/* loaded from: classes2.dex */
public class ClassicTheme extends OnekeyShareThemeImpl {
    private static final int MIN_CLICK_DELAY_TIME = 1000;
    private static long lastTime;

    @Override // cn.sharesdk.onekeyshare.OnekeyShareThemeImpl
    public void showEditPage(Context context, Platform platform, Platform.ShareParams shareParams) {
        EditPage editPagePort = context.getResources().getConfiguration().orientation == 1 ? new EditPagePort(this) : new EditPageLand(this);
        editPagePort.setPlatform(platform);
        editPagePort.setShareParams(shareParams);
        editPagePort.show(context, null);
    }

    @Override // cn.sharesdk.onekeyshare.OnekeyShareThemeImpl
    public void showPlatformPage(Context context) {
        FakeActivity platformPagePort = context.getResources().getConfiguration().orientation == 1 ? new PlatformPagePort(this) : new PlatformPageLand(this);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - lastTime >= 1000) {
            platformPagePort.show(context, null);
        }
        lastTime = jCurrentTimeMillis;
    }
}
