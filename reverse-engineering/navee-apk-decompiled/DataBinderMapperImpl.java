package com.uz.navee;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.uz.navee.databinding.ActivityAddDeviceSharerBindingImpl;
import com.uz.navee.databinding.ActivityAmbientLightV2BindingImpl;
import com.uz.navee.databinding.ActivityAmbientLightV3BindingImpl;
import com.uz.navee.databinding.ActivityChargingLimitBindingImpl;
import com.uz.navee.databinding.ActivityChargingTimeBindingImpl;
import com.uz.navee.databinding.ActivityDataDownloadBindingImpl;
import com.uz.navee.databinding.ActivityDedviceMoreActionBindingImpl;
import com.uz.navee.databinding.ActivityDeviceLockTimeBindingImpl;
import com.uz.navee.databinding.ActivityDeviceShareBindingImpl;
import com.uz.navee.databinding.ActivityDownloadExplainBindingImpl;
import com.uz.navee.databinding.ActivityDownloadRecordBindingImpl;
import com.uz.navee.databinding.ActivityLightControlBindingImpl;
import com.uz.navee.databinding.ActivityLoginBindingImpl;
import com.uz.navee.databinding.ActivityMaxSpeedBindingImpl;
import com.uz.navee.databinding.ActivityPromptToneBindingImpl;
import com.uz.navee.databinding.ActivityRegisterBindingImpl;
import com.uz.navee.databinding.ActivityResetAcPswBindingImpl;
import com.uz.navee.databinding.ActivityResetPasswordBindingImpl;
import com.uz.navee.databinding.ActivitySlopeSupBindingImpl;
import com.uz.navee.databinding.ActivitySoundEffectBindingImpl;
import com.uz.navee.databinding.ActivitySpeedLimitBindingImpl;
import com.uz.navee.databinding.ActivityStartupSpeedBindingImpl;
import com.uz.navee.databinding.ActivityWeatherMeterBindingImpl;
import com.uz.navee.databinding.ActivityWebBindingImpl;
import com.uz.navee.databinding.FragmentWebBindingImpl;
import com.uz.navee.databinding.ItemAmbientColorBindingImpl;
import com.uz.navee.databinding.ItemDeviceSharerBindingImpl;
import com.uz.navee.databinding.ItemUpdateContentBindingImpl;
import com.uz.navee.databinding.LayoutAmbientModePageBindingImpl;
import com.uz.navee.databinding.LayoutRecyclerviewBindingImpl;
import com.uz.navee.databinding.PopupChargingTimeBindingImpl;
import com.uz.navee.databinding.PopupDriveGuideBindingImpl;
import com.uz.navee.databinding.PopupDualDriveOpenBindingImpl;
import com.uz.navee.databinding.PopupFirmwareUpdateBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class DataBinderMapperImpl extends DataBinderMapper {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f11565a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final SparseArray f11566a;

        static {
            SparseArray sparseArray = new SparseArray(7);
            f11566a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "checked");
            sparseArray.put(2, "inputCodeStr");
            sparseArray.put(3, "inputIdStr");
            sparseArray.put(4, "inputPswStr");
            sparseArray.put(5, "item");
            sparseArray.put(6, "signTypeEmail");
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final HashMap f11567a;

        static {
            HashMap map = new HashMap(34);
            f11567a = map;
            map.put("layout/activity_add_device_sharer_0", Integer.valueOf(R$layout.activity_add_device_sharer));
            map.put("layout/activity_ambient_light_v2_0", Integer.valueOf(R$layout.activity_ambient_light_v2));
            map.put("layout/activity_ambient_light_v3_0", Integer.valueOf(R$layout.activity_ambient_light_v3));
            map.put("layout/activity_charging_limit_0", Integer.valueOf(R$layout.activity_charging_limit));
            map.put("layout/activity_charging_time_0", Integer.valueOf(R$layout.activity_charging_time));
            map.put("layout/activity_data_download_0", Integer.valueOf(R$layout.activity_data_download));
            map.put("layout/activity_dedvice_more_action_0", Integer.valueOf(R$layout.activity_dedvice_more_action));
            map.put("layout/activity_device_lock_time_0", Integer.valueOf(R$layout.activity_device_lock_time));
            map.put("layout/activity_device_share_0", Integer.valueOf(R$layout.activity_device_share));
            map.put("layout/activity_download_explain_0", Integer.valueOf(R$layout.activity_download_explain));
            map.put("layout/activity_download_record_0", Integer.valueOf(R$layout.activity_download_record));
            map.put("layout/activity_light_control_0", Integer.valueOf(R$layout.activity_light_control));
            map.put("layout/activity_login_0", Integer.valueOf(R$layout.activity_login));
            map.put("layout/activity_max_speed_0", Integer.valueOf(R$layout.activity_max_speed));
            map.put("layout/activity_prompt_tone_0", Integer.valueOf(R$layout.activity_prompt_tone));
            map.put("layout/activity_register_0", Integer.valueOf(R$layout.activity_register));
            map.put("layout/activity_reset_ac_psw_0", Integer.valueOf(R$layout.activity_reset_ac_psw));
            map.put("layout/activity_reset_password_0", Integer.valueOf(R$layout.activity_reset_password));
            map.put("layout/activity_slope_sup_0", Integer.valueOf(R$layout.activity_slope_sup));
            map.put("layout/activity_sound_effect_0", Integer.valueOf(R$layout.activity_sound_effect));
            map.put("layout/activity_speed_limit_0", Integer.valueOf(R$layout.activity_speed_limit));
            map.put("layout/activity_startup_speed_0", Integer.valueOf(R$layout.activity_startup_speed));
            map.put("layout/activity_weather_meter_0", Integer.valueOf(R$layout.activity_weather_meter));
            map.put("layout/activity_web_0", Integer.valueOf(R$layout.activity_web));
            map.put("layout/fragment_web_0", Integer.valueOf(R$layout.fragment_web));
            map.put("layout/item_ambient_color_0", Integer.valueOf(R$layout.item_ambient_color));
            map.put("layout/item_device_sharer_0", Integer.valueOf(R$layout.item_device_sharer));
            map.put("layout/item_update_content_0", Integer.valueOf(R$layout.item_update_content));
            map.put("layout/layout_ambient_mode_page_0", Integer.valueOf(R$layout.layout_ambient_mode_page));
            map.put("layout/layout_recyclerview_0", Integer.valueOf(R$layout.layout_recyclerview));
            map.put("layout/popup_charging_time_0", Integer.valueOf(R$layout.popup_charging_time));
            map.put("layout/popup_drive_guide_0", Integer.valueOf(R$layout.popup_drive_guide));
            map.put("layout/popup_dual_drive_open_0", Integer.valueOf(R$layout.popup_dual_drive_open));
            map.put("layout/popup_firmware_update_0", Integer.valueOf(R$layout.popup_firmware_update));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(34);
        f11565a = sparseIntArray;
        sparseIntArray.put(R$layout.activity_add_device_sharer, 1);
        sparseIntArray.put(R$layout.activity_ambient_light_v2, 2);
        sparseIntArray.put(R$layout.activity_ambient_light_v3, 3);
        sparseIntArray.put(R$layout.activity_charging_limit, 4);
        sparseIntArray.put(R$layout.activity_charging_time, 5);
        sparseIntArray.put(R$layout.activity_data_download, 6);
        sparseIntArray.put(R$layout.activity_dedvice_more_action, 7);
        sparseIntArray.put(R$layout.activity_device_lock_time, 8);
        sparseIntArray.put(R$layout.activity_device_share, 9);
        sparseIntArray.put(R$layout.activity_download_explain, 10);
        sparseIntArray.put(R$layout.activity_download_record, 11);
        sparseIntArray.put(R$layout.activity_light_control, 12);
        sparseIntArray.put(R$layout.activity_login, 13);
        sparseIntArray.put(R$layout.activity_max_speed, 14);
        sparseIntArray.put(R$layout.activity_prompt_tone, 15);
        sparseIntArray.put(R$layout.activity_register, 16);
        sparseIntArray.put(R$layout.activity_reset_ac_psw, 17);
        sparseIntArray.put(R$layout.activity_reset_password, 18);
        sparseIntArray.put(R$layout.activity_slope_sup, 19);
        sparseIntArray.put(R$layout.activity_sound_effect, 20);
        sparseIntArray.put(R$layout.activity_speed_limit, 21);
        sparseIntArray.put(R$layout.activity_startup_speed, 22);
        sparseIntArray.put(R$layout.activity_weather_meter, 23);
        sparseIntArray.put(R$layout.activity_web, 24);
        sparseIntArray.put(R$layout.fragment_web, 25);
        sparseIntArray.put(R$layout.item_ambient_color, 26);
        sparseIntArray.put(R$layout.item_device_sharer, 27);
        sparseIntArray.put(R$layout.item_update_content, 28);
        sparseIntArray.put(R$layout.layout_ambient_mode_page, 29);
        sparseIntArray.put(R$layout.layout_recyclerview, 30);
        sparseIntArray.put(R$layout.popup_charging_time, 31);
        sparseIntArray.put(R$layout.popup_drive_guide, 32);
        sparseIntArray.put(R$layout.popup_dual_drive_open, 33);
        sparseIntArray.put(R$layout.popup_firmware_update, 34);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i6) {
        return (String) a.f11566a.get(i6);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i6) {
        int i7 = f11565a.get(i6);
        if (i7 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i7) {
            case 1:
                if ("layout/activity_add_device_sharer_0".equals(tag)) {
                    return new ActivityAddDeviceSharerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_add_device_sharer is invalid. Received: " + tag);
            case 2:
                if ("layout/activity_ambient_light_v2_0".equals(tag)) {
                    return new ActivityAmbientLightV2BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_ambient_light_v2 is invalid. Received: " + tag);
            case 3:
                if ("layout/activity_ambient_light_v3_0".equals(tag)) {
                    return new ActivityAmbientLightV3BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_ambient_light_v3 is invalid. Received: " + tag);
            case 4:
                if ("layout/activity_charging_limit_0".equals(tag)) {
                    return new ActivityChargingLimitBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_charging_limit is invalid. Received: " + tag);
            case 5:
                if ("layout/activity_charging_time_0".equals(tag)) {
                    return new ActivityChargingTimeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_charging_time is invalid. Received: " + tag);
            case 6:
                if ("layout/activity_data_download_0".equals(tag)) {
                    return new ActivityDataDownloadBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_data_download is invalid. Received: " + tag);
            case 7:
                if ("layout/activity_dedvice_more_action_0".equals(tag)) {
                    return new ActivityDedviceMoreActionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_dedvice_more_action is invalid. Received: " + tag);
            case 8:
                if ("layout/activity_device_lock_time_0".equals(tag)) {
                    return new ActivityDeviceLockTimeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_device_lock_time is invalid. Received: " + tag);
            case 9:
                if ("layout/activity_device_share_0".equals(tag)) {
                    return new ActivityDeviceShareBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_device_share is invalid. Received: " + tag);
            case 10:
                if ("layout/activity_download_explain_0".equals(tag)) {
                    return new ActivityDownloadExplainBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_download_explain is invalid. Received: " + tag);
            case 11:
                if ("layout/activity_download_record_0".equals(tag)) {
                    return new ActivityDownloadRecordBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_download_record is invalid. Received: " + tag);
            case 12:
                if ("layout/activity_light_control_0".equals(tag)) {
                    return new ActivityLightControlBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_light_control is invalid. Received: " + tag);
            case 13:
                if ("layout/activity_login_0".equals(tag)) {
                    return new ActivityLoginBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
            case 14:
                if ("layout/activity_max_speed_0".equals(tag)) {
                    return new ActivityMaxSpeedBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_max_speed is invalid. Received: " + tag);
            case 15:
                if ("layout/activity_prompt_tone_0".equals(tag)) {
                    return new ActivityPromptToneBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_prompt_tone is invalid. Received: " + tag);
            case 16:
                if ("layout/activity_register_0".equals(tag)) {
                    return new ActivityRegisterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_register is invalid. Received: " + tag);
            case 17:
                if ("layout/activity_reset_ac_psw_0".equals(tag)) {
                    return new ActivityResetAcPswBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_reset_ac_psw is invalid. Received: " + tag);
            case 18:
                if ("layout/activity_reset_password_0".equals(tag)) {
                    return new ActivityResetPasswordBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_reset_password is invalid. Received: " + tag);
            case 19:
                if ("layout/activity_slope_sup_0".equals(tag)) {
                    return new ActivitySlopeSupBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_slope_sup is invalid. Received: " + tag);
            case 20:
                if ("layout/activity_sound_effect_0".equals(tag)) {
                    return new ActivitySoundEffectBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_sound_effect is invalid. Received: " + tag);
            case 21:
                if ("layout/activity_speed_limit_0".equals(tag)) {
                    return new ActivitySpeedLimitBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_speed_limit is invalid. Received: " + tag);
            case 22:
                if ("layout/activity_startup_speed_0".equals(tag)) {
                    return new ActivityStartupSpeedBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_startup_speed is invalid. Received: " + tag);
            case 23:
                if ("layout/activity_weather_meter_0".equals(tag)) {
                    return new ActivityWeatherMeterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_weather_meter is invalid. Received: " + tag);
            case 24:
                if ("layout/activity_web_0".equals(tag)) {
                    return new ActivityWebBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_web is invalid. Received: " + tag);
            case 25:
                if ("layout/fragment_web_0".equals(tag)) {
                    return new FragmentWebBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_web is invalid. Received: " + tag);
            case 26:
                if ("layout/item_ambient_color_0".equals(tag)) {
                    return new ItemAmbientColorBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_ambient_color is invalid. Received: " + tag);
            case 27:
                if ("layout/item_device_sharer_0".equals(tag)) {
                    return new ItemDeviceSharerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_device_sharer is invalid. Received: " + tag);
            case 28:
                if ("layout/item_update_content_0".equals(tag)) {
                    return new ItemUpdateContentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_update_content is invalid. Received: " + tag);
            case 29:
                if ("layout/layout_ambient_mode_page_0".equals(tag)) {
                    return new LayoutAmbientModePageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_ambient_mode_page is invalid. Received: " + tag);
            case 30:
                if ("layout/layout_recyclerview_0".equals(tag)) {
                    return new LayoutRecyclerviewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_recyclerview is invalid. Received: " + tag);
            case 31:
                if ("layout/popup_charging_time_0".equals(tag)) {
                    return new PopupChargingTimeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for popup_charging_time is invalid. Received: " + tag);
            case 32:
                if ("layout/popup_drive_guide_0".equals(tag)) {
                    return new PopupDriveGuideBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for popup_drive_guide is invalid. Received: " + tag);
            case 33:
                if ("layout/popup_dual_drive_open_0".equals(tag)) {
                    return new PopupDualDriveOpenBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for popup_dual_drive_open is invalid. Received: " + tag);
            case 34:
                if ("layout/popup_firmware_update_0".equals(tag)) {
                    return new PopupFirmwareUpdateBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for popup_firmware_update is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = (Integer) b.f11567a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i6) {
        if (viewArr == null || viewArr.length == 0 || f11565a.get(i6) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
