package cn.sharesdk.framework;

import android.app.Activity;
import android.os.Handler;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class i {
    public static ArrayList<Platform> a() {
        ArrayList<Platform> arrayListD = d();
        a(arrayListD);
        return arrayListD;
    }

    public static Activity b() {
        return cn.sharesdk.framework.authorize.a.c().b();
    }

    public static boolean c() {
        return cn.sharesdk.framework.authorize.a.c().a();
    }

    private static ArrayList<Platform> d() {
        String[] strArr = {"cn.sharesdk.douban.Douban", "cn.sharesdk.evernote.Evernote", "cn.sharesdk.facebook.Facebook", "cn.sharesdk.renren.Renren", "cn.sharesdk.sina.weibo.SinaWeibo", "cn.sharesdk.kaixin.KaiXin", "cn.sharesdk.linkedin.LinkedIn", "cn.sharesdk.system.email.Email", "cn.sharesdk.system.text.ShortMessage", "cn.sharesdk.tencent.qq.QQ", "cn.sharesdk.tencent.qzone.QZone", "cn.sharesdk.tencent.weibo.TencentWeibo", "cn.sharesdk.twitter.Twitter", "cn.sharesdk.wechat.friends.Wechat", "cn.sharesdk.wechat.moments.WechatMoments", "cn.sharesdk.wechat.favorite.WechatFavorite", "cn.sharesdk.youdao.YouDao", "cn.sharesdk.google.GooglePlus", "cn.sharesdk.foursquare.FourSquare", "cn.sharesdk.pinterest.Pinterest", "cn.sharesdk.flickr.Flickr", "cn.sharesdk.tumblr.Tumblr", "cn.sharesdk.dropbox.Dropbox", "cn.sharesdk.vkontakte.VKontakte", "cn.sharesdk.instagram.Instagram", "cn.sharesdk.yixin.friends.Yixin", "cn.sharesdk.yixin.moments.YixinMoments", "cn.sharesdk.mingdao.Mingdao", "cn.sharesdk.line.Line", "cn.sharesdk.kakao.story.KakaoStory", "cn.sharesdk.kakao.talk.KakaoTalk", "cn.sharesdk.whatsapp.WhatsApp", "cn.sharesdk.pocket.Pocket", "cn.sharesdk.instapaper.Instapaper", "cn.sharesdk.facebookmessenger.FacebookMessenger", "cn.sharesdk.alipay.friends.Alipay", "cn.sharesdk.alipay.moments.AlipayMoments", "cn.sharesdk.dingding.friends.Dingding", "cn.sharesdk.youtube.Youtube", "cn.sharesdk.meipai.Meipai", "cn.sharesdk.telegram.Telegram", "cn.sharesdk.cmcc.Cmcc", "cn.sharesdk.reddit.Reddit", "cn.sharesdk.telecom.Telecom", "cn.sharesdk.accountkit.Accountkit", "cn.sharesdk.douyin.Douyin", "cn.sharesdk.wework.Wework", "cn.sharesdk.oasis.Oasis", "cn.sharesdk.hwaccount.HWAccount", "cn.sharesdk.xmaccount.XMAccount", "cn.sharesdk.snapchat.Snapchat", "cn.sharesdk.littleredbook.Littleredbook", "cn.sharesdk.kuaishou.Kuaishou", "cn.sharesdk.watermelonvideo.Watermelonvideo", "cn.sharesdk.tiktok.Tiktok", "cn.sharesdk.taptap.Taptap", "cn.sharesdk.honoraccount.HonorAccount", "cn.sharesdk.threads.Threads", "cn.sharesdk.lark.Lark", "cn.sharesdk.whatsAppBusiness.WhatsAppBusiness"};
        ArrayList<Platform> arrayList = new ArrayList<>();
        for (int i6 = 0; i6 < 60; i6++) {
            String str = strArr[i6];
            try {
                arrayList.add((Platform) Class.forName(str).newInstance());
            } catch (Throwable unused) {
                SSDKLog.b().a("not found:" + str, new Object[0]);
            }
        }
        return arrayList;
    }

    public static void a(ArrayList<Platform> arrayList) {
        if (arrayList == null) {
            return;
        }
        Collections.sort(arrayList, new Comparator<Platform>() { // from class: cn.sharesdk.framework.i.1
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(Platform platform, Platform platform2) {
                int platformId;
                int platformId2;
                if (platform.getSortId() != platform2.getSortId()) {
                    platformId = platform.getSortId();
                    platformId2 = platform2.getSortId();
                } else {
                    platformId = platform.getPlatformId();
                    platformId2 = platform2.getPlatformId();
                }
                return platformId - platformId2;
            }
        });
    }

    public static void a(Activity activity) {
        cn.sharesdk.framework.authorize.a aVarC = cn.sharesdk.framework.authorize.a.c();
        if (aVarC != null) {
            aVarC.a(activity);
        }
    }

    public static void a(boolean z6) {
        cn.sharesdk.framework.authorize.a aVarC = cn.sharesdk.framework.authorize.a.c();
        if (aVarC != null) {
            aVarC.a(z6);
        }
    }

    public static void a(Handler handler) {
        cn.sharesdk.framework.a.d dVarA = cn.sharesdk.framework.a.d.a();
        if (dVarA != null) {
            dVarA.a(handler);
            dVarA.c();
        }
    }

    public static void a(int i6, Platform platform) {
        cn.sharesdk.framework.a.b.f fVar = new cn.sharesdk.framework.a.b.f();
        if (i6 == 1) {
            fVar.f6294a = "SHARESDK_ENTER_SHAREMENU";
        } else if (i6 == 2) {
            fVar.f6294a = "SHARESDK_CANCEL_SHAREMENU";
        } else if (i6 == 3) {
            fVar.f6294a = "SHARESDK_EDIT_SHARE";
        } else if (i6 == 4) {
            fVar.f6294a = "SHARESDK_FAILED_SHARE";
        } else if (i6 == 5) {
            fVar.f6294a = "SHARESDK_CANCEL_SHARE";
        }
        if (platform != null) {
            fVar.f6295b = platform.getPlatformId();
        }
        cn.sharesdk.framework.a.d dVarA = cn.sharesdk.framework.a.d.a();
        if (dVarA != null) {
            dVarA.a(fVar);
        }
    }

    public static void a(String str, int i6) {
        cn.sharesdk.framework.a.d dVarA = cn.sharesdk.framework.a.d.a();
        if (dVarA == null) {
            return;
        }
        cn.sharesdk.framework.a.b.a aVar = new cn.sharesdk.framework.a.b.a();
        aVar.f6275b = str;
        aVar.f6274a = i6;
        dVarA.a(aVar);
    }

    public static HashMap<Integer, HashMap<String, Object>> a(HashMap<String, Object> map) {
        int i6;
        HashMap<Integer, HashMap<String, Object>> map2 = null;
        if (map != null && map.size() > 0) {
            ArrayList arrayList = (ArrayList) map.get("fakelist");
            if (arrayList == null) {
                return null;
            }
            map2 = new HashMap<>();
            EventRecorder.addBegin(OnekeyShare.SHARESDK_TAG, "parseDevInfo");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                HashMap<String, Object> map3 = (HashMap) it.next();
                if (map3 != null) {
                    try {
                        i6 = ResHelper.parseInt(String.valueOf(map3.get("snsplat")));
                    } catch (Throwable th) {
                        SSDKLog.b().b(th);
                        i6 = -1;
                    }
                    if (i6 != -1) {
                        map2.put(Integer.valueOf(i6), map3);
                    }
                }
            }
            EventRecorder.addEnd(OnekeyShare.SHARESDK_TAG, "parseDevInfo");
        }
        return map2;
    }
}
