package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.mob.tools.utils.ResHelper;

/* loaded from: classes2.dex */
public class PRTHeader extends LinearLayout {
    private static final int DESIGN_AVATAR_PADDING = 24;
    private static final int DESIGN_AVATAR_WIDTH = 64;
    private static final int DESIGN_SCREEN_WIDTH = 720;
    private RotateImageView ivArrow;
    private ProgressBar pbRefreshing;
    private TextView tvHeader;

    public PRTHeader(Context context) {
        super(context);
        int[] screenSize = ResHelper.getScreenSize(context);
        int i6 = screenSize[0];
        int i7 = screenSize[1];
        float f7 = (i6 < i7 ? i6 : i7) / 720.0f;
        setOrientation(1);
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        addView(linearLayout, layoutParams);
        this.ivArrow = new RotateImageView(context);
        int bitmapRes = ResHelper.getBitmapRes(context, "ssdk_oks_ptr_ptr");
        if (bitmapRes > 0) {
            this.ivArrow.setImageResource(bitmapRes);
        }
        int i8 = (int) (64.0f * f7);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i8, i8);
        layoutParams2.gravity = 16;
        int i9 = (int) (f7 * 24.0f);
        layoutParams2.bottomMargin = i9;
        layoutParams2.topMargin = i9;
        linearLayout.addView(this.ivArrow, layoutParams2);
        this.pbRefreshing = new ProgressBar(context);
        this.pbRefreshing.setIndeterminateDrawable(context.getResources().getDrawable(ResHelper.getBitmapRes(context, "ssdk_oks_classic_progressbar")));
        linearLayout.addView(this.pbRefreshing, layoutParams2);
        this.pbRefreshing.setVisibility(8);
        TextView textView = new TextView(getContext());
        this.tvHeader = textView;
        textView.setTextSize(2, 18.0f);
        this.tvHeader.setPadding(i9, 0, i9, 0);
        this.tvHeader.setTextColor(-16139513);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        linearLayout.addView(this.tvHeader, layoutParams3);
    }

    public void onPullDown(int i6) {
        if (i6 > 100) {
            int i7 = SubsamplingScaleImageView.ORIENTATION_180;
            int i8 = ((i6 - 100) * SubsamplingScaleImageView.ORIENTATION_180) / 20;
            if (i8 <= 180) {
                i7 = i8;
            }
            if (i7 < 0) {
                i7 = 0;
            }
            this.ivArrow.setRotation(i7);
        } else {
            this.ivArrow.setRotation(0.0f);
        }
        if (i6 < 100) {
            int stringRes = ResHelper.getStringRes(getContext(), "ssdk_oks_pull_to_refresh");
            if (stringRes > 0) {
                this.tvHeader.setText(stringRes);
                return;
            }
            return;
        }
        int stringRes2 = ResHelper.getStringRes(getContext(), "ssdk_oks_release_to_refresh");
        if (stringRes2 > 0) {
            this.tvHeader.setText(stringRes2);
        }
    }

    public void onRequest() {
        this.ivArrow.setVisibility(8);
        this.pbRefreshing.setVisibility(0);
        int stringRes = ResHelper.getStringRes(getContext(), "ssdk_oks_refreshing");
        if (stringRes > 0) {
            this.tvHeader.setText(stringRes);
        }
    }

    public void reverse() {
        this.pbRefreshing.setVisibility(8);
        this.ivArrow.setRotation(180.0f);
        this.ivArrow.setVisibility(0);
    }
}
