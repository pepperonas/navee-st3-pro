package cn.sharesdk.onekeyshare.themes.classic.port;

import android.content.Context;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPage;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class PlatformPageAdapterPort extends PlatformPageAdapter {
    private static final int DESIGN_LOGO_HEIGHT = 76;
    private static final int DESIGN_PADDING_TOP = 20;
    private static final int DESIGN_SCREEN_WIDTH_P = 720;
    private static final int DESIGN_SEP_LINE_WIDTH = 1;
    private static final int LINE_SIZE_P = 4;
    private static final int PAGE_SIZE_P = 12;

    public PlatformPageAdapterPort(PlatformPage platformPage, ArrayList<Object> arrayList) {
        super(platformPage, arrayList);
    }

    @Override // cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter
    public void calculateSize(Context context, ArrayList<Object> arrayList) {
        int screenWidth = ResHelper.getScreenWidth(context);
        this.lineSize = 4;
        float f7 = screenWidth / 720.0f;
        int i6 = (int) (1.0f * f7);
        this.sepLineWidth = i6;
        if (i6 < 1) {
            i6 = 1;
        }
        this.sepLineWidth = i6;
        this.logoHeight = (int) (76.0f * f7);
        this.paddingTop = (int) (20.0f * f7);
        this.bottomHeight = (int) (f7 * 52.0f);
        this.cellHeight = (screenWidth - (i6 * 3)) / 4;
        if (arrayList.size() <= this.lineSize) {
            this.panelHeight = this.cellHeight + this.sepLineWidth;
        } else if (arrayList.size() <= 12 - this.lineSize) {
            this.panelHeight = (this.cellHeight + this.sepLineWidth) * 2;
        } else {
            this.panelHeight = (this.cellHeight + this.sepLineWidth) * 3;
        }
    }

    @Override // cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter
    public void collectCells(ArrayList<Object> arrayList) {
        int size = arrayList.size();
        if (size < 12) {
            int i6 = this.lineSize;
            int i7 = size / i6;
            if (size % i6 != 0) {
                i7++;
            }
            this.cells = (Object[][]) Array.newInstance((Class<?>) Object.class, 1, i7 * i6);
        } else {
            int i8 = size / 12;
            if (size % 12 != 0) {
                i8++;
            }
            this.cells = (Object[][]) Array.newInstance((Class<?>) Object.class, i8, 12);
        }
        for (int i9 = 0; i9 < size; i9++) {
            int i10 = i9 / 12;
            this.cells[i10][i9 - (i10 * 12)] = arrayList.get(i9);
        }
    }
}
