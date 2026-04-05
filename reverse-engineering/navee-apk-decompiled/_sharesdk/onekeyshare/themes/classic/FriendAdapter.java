package cn.sharesdk.onekeyshare.themes.classic;

import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.tools.gui.PullToRequestListAdapter;
import com.mob.tools.gui.PullToRequestView;
import com.mob.tools.utils.UIHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class FriendAdapter extends PullToRequestListAdapter implements PlatformActionListener {
    private FriendListPage activity;
    private int curPage;
    private ArrayList<Following> follows;
    private boolean hasNext;
    private PRTHeader llHeader;
    private HashMap<String, Boolean> map;
    private final int pageCount;
    private Platform platform;
    private float ratio;

    public static class FollowersResult {
        public boolean hasNextPage;
        public ArrayList<Following> list;

        private FollowersResult() {
            this.hasNextPage = false;
        }
    }

    public static class Following {
        public String atName;
        public boolean checked;
        public String description;
        public String icon;
        public String screenName;
        public String uid;
    }

    public FriendAdapter(FriendListPage friendListPage, PullToRequestView pullToRequestView) {
        super(pullToRequestView);
        this.pageCount = 15;
        this.activity = friendListPage;
        this.curPage = -1;
        this.hasNext = true;
        this.map = new HashMap<>();
        this.follows = new ArrayList<>();
        getListView().setDivider(new ColorDrawable(-1381654));
    }

    private void next() {
        if (this.hasNext) {
            this.platform.listFriend(15, this.curPage + 1, null);
        }
    }

    private FollowersResult parseFollowers(String str, HashMap<String, Object> map, HashMap<String, Boolean> map2) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        ArrayList<Following> arrayList = new ArrayList<>();
        boolean zContainsKey = false;
        if ("SinaWeibo".equals(str)) {
            Iterator it = ((ArrayList) map.get("users")).iterator();
            while (it.hasNext()) {
                HashMap map3 = (HashMap) it.next();
                String strValueOf = String.valueOf(map3.get(TtmlNode.ATTR_ID));
                if (!map2.containsKey(strValueOf)) {
                    Following following = new Following();
                    following.uid = strValueOf;
                    following.screenName = String.valueOf(map3.get(AppMeasurementSdk.ConditionalUserProperty.NAME));
                    following.description = String.valueOf(map3.get("description"));
                    following.icon = String.valueOf(map3.get("profile_image_url"));
                    following.atName = following.screenName;
                    map2.put(following.uid, Boolean.TRUE);
                    arrayList.add(following);
                }
            }
            if (((Integer) map.get("total_number")).intValue() <= map2.size()) {
                z = false;
            }
        } else {
            if (!"TencentWeibo".equals(str)) {
                if ("Facebook".equals(str)) {
                    Iterator it2 = ((ArrayList) map.get("data")).iterator();
                    while (it2.hasNext()) {
                        HashMap map4 = (HashMap) it2.next();
                        String strValueOf2 = String.valueOf(map4.get(TtmlNode.ATTR_ID));
                        if (!map2.containsKey(strValueOf2)) {
                            Following following2 = new Following();
                            following2.uid = strValueOf2;
                            following2.atName = "[" + strValueOf2 + "]";
                            following2.screenName = String.valueOf(map4.get(AppMeasurementSdk.ConditionalUserProperty.NAME));
                            HashMap map5 = (HashMap) map4.get("picture");
                            if (map5 != null) {
                                following2.icon = String.valueOf(((HashMap) map5.get("data")).get(ImagesContract.URL));
                            }
                            map2.put(following2.uid, Boolean.TRUE);
                            arrayList.add(following2);
                        }
                    }
                    zContainsKey = ((HashMap) map.get("paging")).containsKey("next");
                } else if ("Twitter".equals(str)) {
                    Iterator it3 = ((ArrayList) map.get("users")).iterator();
                    while (it3.hasNext()) {
                        HashMap map6 = (HashMap) it3.next();
                        String strValueOf3 = String.valueOf(map6.get(FirebaseAnalytics.Param.SCREEN_NAME));
                        if (!map2.containsKey(strValueOf3)) {
                            Following following3 = new Following();
                            following3.uid = strValueOf3;
                            following3.atName = strValueOf3;
                            following3.screenName = String.valueOf(map6.get(AppMeasurementSdk.ConditionalUserProperty.NAME));
                            following3.description = String.valueOf(map6.get("description"));
                            following3.icon = String.valueOf(map6.get("profile_image_url"));
                            map2.put(following3.uid, Boolean.TRUE);
                            arrayList.add(following3);
                        }
                    }
                }
                FollowersResult followersResult = new FollowersResult();
                followersResult.list = arrayList;
                followersResult.hasNextPage = zContainsKey;
                return followersResult;
            }
            z = ((Integer) map.get("hasnext")).intValue() == 0;
            Iterator it4 = ((ArrayList) map.get("info")).iterator();
            while (it4.hasNext()) {
                HashMap map7 = (HashMap) it4.next();
                String strValueOf4 = String.valueOf(map7.get(AppMeasurementSdk.ConditionalUserProperty.NAME));
                if (!map2.containsKey(strValueOf4)) {
                    Following following4 = new Following();
                    following4.screenName = String.valueOf(map7.get("nick"));
                    following4.uid = strValueOf4;
                    following4.atName = strValueOf4;
                    Iterator it5 = ((ArrayList) map7.get("tweet")).iterator();
                    if (it5.hasNext()) {
                        following4.description = String.valueOf(((HashMap) it5.next()).get("text"));
                    }
                    following4.icon = String.valueOf(map7.get(TtmlNode.TAG_HEAD)) + "/100";
                    map2.put(following4.uid, Boolean.TRUE);
                    arrayList.add(following4);
                }
            }
        }
        zContainsKey = z;
        FollowersResult followersResult2 = new FollowersResult();
        followersResult2.list = arrayList;
        followersResult2.hasNextPage = zContainsKey;
        return followersResult2;
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public int getCount() {
        ArrayList<Following> arrayList = this.follows;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public View getFooterView() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setMinimumHeight(10);
        return linearLayout;
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public View getHeaderView() {
        if (this.llHeader == null) {
            this.llHeader = new PRTHeader(getContext());
        }
        return this.llHeader;
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public long getItemId(int i6) {
        return i6;
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public View getView(int i6, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new FriendListItem(viewGroup.getContext(), this.ratio);
        }
        ((FriendListItem) view).update(getItem(i6), isFling());
        if (i6 == getCount() - 1) {
            next();
        }
        return view;
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onCancel(Platform platform, int i6) {
        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.sharesdk.onekeyshare.themes.classic.FriendAdapter.3
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                FriendAdapter.this.activity.finish();
                return false;
            }
        });
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onComplete(Platform platform, int i6, HashMap<String, Object> map) {
        final FollowersResult followers = parseFollowers(this.platform.getName(), map, this.map);
        if (followers == null) {
            UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.sharesdk.onekeyshare.themes.classic.FriendAdapter.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    FriendAdapter.this.notifyDataSetChanged();
                    return false;
                }
            });
            return;
        }
        this.hasNext = followers.hasNextPage;
        ArrayList<Following> arrayList = followers.list;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.curPage++;
        Message message = new Message();
        message.what = 1;
        message.obj = followers.list;
        UIHandler.sendMessage(message, new Handler.Callback() { // from class: cn.sharesdk.onekeyshare.themes.classic.FriendAdapter.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message2) {
                if (FriendAdapter.this.curPage <= 0) {
                    FriendAdapter.this.follows.clear();
                }
                FriendAdapter.this.follows.addAll(followers.list);
                FriendAdapter.this.notifyDataSetChanged();
                return false;
            }
        });
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onError(Platform platform, int i6, Throwable th) {
        th.printStackTrace();
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public void onPullDown(int i6) {
        this.llHeader.onPullDown(i6);
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public void onRefresh() {
        this.llHeader.onRequest();
        this.curPage = -1;
        this.hasNext = true;
        this.map.clear();
        next();
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public void onReversed() {
        this.llHeader.reverse();
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        getListView().setOnItemClickListener(onItemClickListener);
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
        platform.setPlatformActionListener(this);
    }

    public void setRatio(float f7) {
        this.ratio = f7;
        ListView listView = getListView();
        if (f7 < 1.0f) {
            f7 = 1.0f;
        }
        listView.setDividerHeight((int) f7);
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public Following getItem(int i6) {
        return this.follows.get(i6);
    }
}
