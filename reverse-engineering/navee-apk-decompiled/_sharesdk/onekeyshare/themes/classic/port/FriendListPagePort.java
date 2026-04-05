package cn.sharesdk.onekeyshare.themes.classic.port;

import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.onekeyshare.themes.classic.FriendListPage;
import com.mob.tools.utils.ResHelper;

/* loaded from: classes2.dex */
public class FriendListPagePort extends FriendListPage {
    private static final int DESIGN_SCREEN_WIDTH = 720;
    private static final int DESIGN_TITLE_HEIGHT = 96;

    public FriendListPagePort(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        super(onekeyShareThemeImpl);
    }

    @Override // cn.sharesdk.onekeyshare.themes.classic.FriendListPage
    public int getDesignTitleHeight() {
        return DESIGN_TITLE_HEIGHT;
    }

    @Override // cn.sharesdk.onekeyshare.themes.classic.FriendListPage
    public float getRatio() {
        return ResHelper.getScreenWidth(this.activity) / 720.0f;
    }
}
