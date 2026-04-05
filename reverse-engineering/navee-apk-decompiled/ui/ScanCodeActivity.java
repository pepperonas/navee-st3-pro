package com.uz.navee.ui;

import android.os.Bundle;
import androidx.core.content.ContextCompat;
import cn.bingoogolapple.qrcode.core.BarcodeType;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import com.uz.navee.R$color;
import com.uz.navee.R$id;
import com.uz.navee.R$layout;
import com.uz.navee.base.BaseActivity;
import com.uz.navee.utils.c;
import f4.b;
import java.util.List;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.a;

/* loaded from: classes3.dex */
public class ScanCodeActivity extends BaseActivity implements QRCodeView.e, EasyPermissions.PermissionCallbacks {

    /* renamed from: c, reason: collision with root package name */
    public ZXingView f11679c;

    @a(9631)
    private void requestCodeQRCodePermissions() {
        String[] strArr = {"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE"};
        if (EasyPermissions.a(this, strArr)) {
            this.f11679c.y();
        } else {
            EasyPermissions.e(this, "扫描二维码需要打开相机和闪光灯的权限", 9631, strArr);
        }
    }

    @Override // pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
    public void b(int i6, List list) {
        if (EasyPermissions.h(this, list)) {
            new AppSettingsDialog.b(this).a().show();
        }
    }

    @Override // cn.bingoogolapple.qrcode.core.QRCodeView.e
    public void e(boolean z6) {
        String tipText = this.f11679c.getScanBoxView().getTipText();
        if (!z6) {
            if (tipText.contains("\n环境过暗，请打开闪光灯")) {
                this.f11679c.getScanBoxView().setTipText(tipText.substring(0, tipText.indexOf("\n环境过暗，请打开闪光灯")));
                return;
            }
            return;
        }
        if (tipText.contains("\n环境过暗，请打开闪光灯")) {
            return;
        }
        this.f11679c.getScanBoxView().setTipText(tipText + "\n环境过暗，请打开闪光灯");
    }

    @Override // cn.bingoogolapple.qrcode.core.QRCodeView.e
    public void i() {
        b.d("打开相机出错");
    }

    @Override // cn.bingoogolapple.qrcode.core.QRCodeView.e
    public void j(String str) {
        b.g("result:" + str, new Object[0]);
        setTitle("扫描结果为：" + str);
        O();
    }

    @Override // pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
    public void l(int i6, List list) {
        this.f11679c.y();
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_scan_code);
        ZXingView zXingView = (ZXingView) findViewById(R$id.zxing_view);
        this.f11679c = zXingView;
        zXingView.setDelegate(this);
        this.f11679c.c();
        this.f11679c.F(BarcodeType.ONLY_QR_CODE, null);
        c.e(this, "Scan", ContextCompat.getColor(this, R$color.nav_title_color));
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f11679c.k();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i6, strArr, iArr);
        EasyPermissions.d(i6, strArr, iArr, this);
    }

    @Override // com.uz.navee.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        requestCodeQRCodePermissions();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        this.f11679c.z();
        super.onStop();
    }
}
