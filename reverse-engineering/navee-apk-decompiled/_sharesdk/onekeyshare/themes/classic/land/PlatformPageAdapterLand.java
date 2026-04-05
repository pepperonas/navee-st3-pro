package cn.sharesdk.onekeyshare.themes.classic.land;

import android.content.Context;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPage;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class PlatformPageAdapterLand extends PlatformPageAdapter {
    private static final int DESIGN_CELL_WIDTH_L = 160;
    private static final int DESIGN_LOGO_HEIGHT = 76;
    private static final int DESIGN_PADDING_TOP = 20;
    private static final int DESIGN_SCREEN_WIDTH_L = 1280;
    private static final int DESIGN_SEP_LINE_WIDTH = 1;

    public PlatformPageAdapterLand(PlatformPage platformPage, ArrayList<Object> arrayList) {
        super(platformPage, arrayList);
    }

    @Override // cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter
    public void calculateSize(Context context, ArrayList<Object> arrayList) {
        int screenWidth = ResHelper.getScreenWidth(context);
        float f7 = screenWidth / 1280.0f;
        int i6 = screenWidth / ((int) (160.0f * f7));
        this.lineSize = i6;
        int i7 = (int) (1.0f * f7);
        this.sepLineWidth = i7;
        if (i7 < 1) {
            i7 = 1;
        }
        this.sepLineWidth = i7;
        this.logoHeight = (int) (76.0f * f7);
        this.paddingTop = (int) (20.0f * f7);
        this.bottomHeight = (int) (f7 * 52.0f);
        int i8 = (screenWidth - (i7 * 3)) / (i6 - 1);
        this.cellHeight = i8;
        this.panelHeight = i8 + i7;
    }

    @Override // cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter
    public void collectCells(ArrayList<Object> arrayList) {
        int size = arrayList.size();
        int i6 = this.lineSize;
        if (size < i6) {
            int i7 = size / i6;
            if (size % i6 != 0) {
                i7++;
            }
            this.cells = (Object[][]) Array.newInstance((Class<?>) Object.class, 1, i7 * i6);
        } else {
            int i8 = size / i6;
            if (size % i6 != 0) {
                i8++;
            }
            this.cells = (Object[][]) Array.newInstance((Class<?>) Object.class, i8, i6);
        }
        for (int i9 = 0; i9 < size; i9++) {
            int i10 = this.lineSize;
            int i11 = i9 / i10;
            this.cells[i11][i9 - (i10 * i11)] = arrayList.get(i9);
        }
    }
}
