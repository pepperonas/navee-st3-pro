package cn.sharesdk.onekeyshare.themes.classic;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.onekeyshare.OnekeySharePage;
import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.onekeyshare.themes.classic.FriendAdapter;
import com.mob.tools.gui.PullToRequestView;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public abstract class FriendListPage extends OnekeySharePage implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static final int DESIGN_LEFT_PADDING = 40;
    private FriendAdapter adapter;
    private int checkNum;
    private int lastPosition;
    private LinearLayout llPage;
    private Platform platform;
    private RelativeLayout rlTitle;
    private TextView tvCancel;
    private TextView tvConfirm;

    public FriendListPage(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        super(onekeyShareThemeImpl);
        this.lastPosition = -1;
        this.checkNum = 0;
    }

    private void initTitle(RelativeLayout relativeLayout, float f7) {
        TextView textView = new TextView(this.activity);
        this.tvCancel = textView;
        textView.setTextColor(-12895429);
        this.tvCancel.setTextSize(2, 18.0f);
        this.tvCancel.setGravity(17);
        int stringRes = ResHelper.getStringRes(this.activity, "ssdk_oks_cancel");
        if (stringRes > 0) {
            this.tvCancel.setText(stringRes);
        }
        int i6 = (int) (f7 * 40.0f);
        this.tvCancel.setPadding(i6, 0, i6, 0);
        relativeLayout.addView(this.tvCancel, new RelativeLayout.LayoutParams(-2, -1));
        this.tvCancel.setOnClickListener(this);
        TextView textView2 = new TextView(this.activity);
        textView2.setTextColor(-12895429);
        textView2.setTextSize(2, 22.0f);
        textView2.setGravity(17);
        int stringRes2 = ResHelper.getStringRes(this.activity, "ssdk_oks_contacts");
        if (stringRes2 > 0) {
            textView2.setText(stringRes2);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(13);
        relativeLayout.addView(textView2, layoutParams);
        TextView textView3 = new TextView(this.activity);
        this.tvConfirm = textView3;
        textView3.setTextColor(-37615);
        this.tvConfirm.setTextSize(2, 18.0f);
        this.tvConfirm.setGravity(17);
        int stringRes3 = ResHelper.getStringRes(this.activity, "ssdk_oks_confirm");
        if (stringRes3 > 0) {
            this.tvConfirm.setText(stringRes3);
        }
        this.tvConfirm.setPadding(i6, 0, i6, 0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(11);
        relativeLayout.addView(this.tvConfirm, layoutParams2);
        this.tvConfirm.setOnClickListener(this);
    }

    private void updateConfirmView() {
        int stringRes = ResHelper.getStringRes(this.activity, "ssdk_oks_confirm");
        String string = stringRes > 0 ? getContext().getResources().getString(stringRes) : "Confirm";
        int i6 = this.checkNum;
        if (i6 == 0) {
            this.tvConfirm.setText(string);
            return;
        }
        if (i6 > 0) {
            this.tvConfirm.setText(string + "(" + this.checkNum + ")");
        }
    }

    public abstract int getDesignTitleHeight();

    public abstract float getRatio();

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.tvCancel)) {
            finish();
            return;
        }
        ArrayList arrayList = new ArrayList();
        int count = this.adapter.getCount();
        for (int i6 = 0; i6 < count; i6++) {
            if (this.adapter.getItem(i6).checked) {
                arrayList.add(this.adapter.getItem(i6).atName);
            }
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("selected", arrayList);
        map.put("platform", this.platform);
        setResult(map);
        finish();
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        this.activity.getWindow().setBackgroundDrawable(new ColorDrawable(-789517));
        LinearLayout linearLayout = new LinearLayout(this.activity);
        this.llPage = linearLayout;
        linearLayout.setOrientation(1);
        OnekeySharePage.setViewFitsSystemWindows(this.llPage);
        this.activity.setContentView(this.llPage);
        this.rlTitle = new RelativeLayout(this.activity);
        float ratio = getRatio();
        this.llPage.addView(this.rlTitle, new LinearLayout.LayoutParams(-1, (int) (getDesignTitleHeight() * ratio)));
        initTitle(this.rlTitle, ratio);
        View view = new View(this.activity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) (ratio < 1.0f ? 1.0f : ratio));
        view.setBackgroundColor(-2434599);
        this.llPage.addView(view, layoutParams);
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.weight = 1.0f;
        frameLayout.setLayoutParams(layoutParams2);
        this.llPage.addView(frameLayout);
        PullToRequestView pullToRequestView = new PullToRequestView(getContext());
        pullToRequestView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(pullToRequestView);
        FriendAdapter friendAdapter = new FriendAdapter(this, pullToRequestView);
        this.adapter = friendAdapter;
        friendAdapter.setPlatform(this.platform);
        this.adapter.setRatio(ratio);
        this.adapter.setOnItemClickListener(this);
        pullToRequestView.setAdapter(this.adapter);
        pullToRequestView.performPullingDown(true);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i6, long j6) {
        if ("FacebookMessenger".equals(this.platform.getName())) {
            int i7 = this.lastPosition;
            if (i7 >= 0) {
                this.adapter.getItem(i7).checked = false;
            }
            this.lastPosition = i6;
        }
        FriendAdapter.Following item = this.adapter.getItem(i6);
        boolean z6 = !item.checked;
        item.checked = z6;
        if (z6) {
            this.checkNum++;
        } else {
            this.checkNum--;
        }
        updateConfirmView();
        this.adapter.notifyDataSetChanged();
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }
}
