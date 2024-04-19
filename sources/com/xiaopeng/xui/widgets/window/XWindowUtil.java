package com.xiaopeng.xui.widgets.window;

import android.os.Bundle;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.xui.XUI;
import com.xiaopeng.xui.utils.ThreadUtils;
/* loaded from: classes.dex */
public class XWindowUtil {
    public static final String AUTO_CAR_WASH = "com.xiaopeng.autocarwash";
    public static final String CAR_AIOS_ADAPTER = "com.aispeech.aios.adapter";
    public static final String CAR_AIOS_BRIDGE = "com.aispeech.aios.bridge";
    public static final String CAR_CAMERA = "com.xiaopeng.xmart.camera";
    public static final String CAR_DEVTOOLS = "com.xiaopeng.devtools";
    public static final String CAR_FACTORY_TEST = "com.xiaopeng.factorytest";
    public static final String CAR_GALLERY = "com.xiaopeng.xmart.cargallery";
    public static final String CAR_MUSIC = "com.xiaopeng.musicradio";
    public static final String CAR_NAVIGATION = "com.xiaopeng.xmapnavi";
    public static final String CAR_OTA = "com.xiaopeng.ota";
    public static final String CAR_REMOTE_CONTROL = "com.xiaopeng.remote.control";
    public static final String CONFIGURATION_CENTER = "com.xiaopeng.configurationcenter";
    public static final String DATA_COLLECTOR = "com.xiaopeng.data.collector";
    public static final String DEVICE_COMMUNICATION = "com.xiaopeng.device.communication";
    public static final String MAP_NAVI = "com.xiaopeng.montecarlo";
    public static final String MESSAGE_CENTER = "com.xiaopeng.message.center";
    public static final int MSG_ID = 100011;
    public static final String MSG_SHOW_FLAG = "MSG_SHOW_FLAG";
    public static final String PILOT_PARK = "com.xiaopeng.pilotpark";
    public static final String SPEECH_PACKAGE = "com.xiaopeng.carspeechservice";
    public static final String UPLOAD_CAR_INFO = "com.xiaopeng.uploadcarinfo";
    public static final String CAR_AUTOPILOT = "com.xiaopeng.autopilot";
    public static final String AI = "com.xiaopeng.aiassistant";
    public static final String SYSTEM_SETTINGS = "com.android.settings";
    public static final String CAR_CHARGE_CONTROL = "com.xiaopeng.chargecontrol";
    public static final String SYSTEM_SYSTEMUI = "com.android.systemui";
    public static final String CAR_CONTROL = "com.xiaopeng.carcontrol";
    public static final String CAR_ACCOUNT = "com.xiaopeng.caraccount";
    public static final String CAR_BT_PHONE = "com.xiaopeng.btphone";
    public static final String IDIOM_GAME = "com.xiaopeng.idiomgame";
    private static String[] sApps = {CAR_AUTOPILOT, AI, SYSTEM_SETTINGS, CAR_CHARGE_CONTROL, SYSTEM_SYSTEMUI, CAR_CONTROL, CAR_ACCOUNT, CAR_BT_PHONE, IDIOM_GAME};

    public static void notifyAllWindow(boolean z) {
        ThreadUtils.runInBackground(sendShowMsg(z));
    }

    private static Runnable sendShowMsg(final boolean z) {
        final String packageName = XUI.getContext().getPackageName();
        return new Runnable() { // from class: com.xiaopeng.xui.widgets.window.XWindowUtil.1
            @Override // java.lang.Runnable
            public void run() {
                String[] strArr;
                Bundle bundle = new Bundle();
                bundle.putBoolean(XWindowUtil.MSG_SHOW_FLAG, z);
                IIpcService iIpcService = (IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class);
                for (String str : XWindowUtil.sApps) {
                    if (!str.equals(packageName)) {
                        iIpcService.sendData(XWindowUtil.MSG_ID, bundle, str);
                    }
                }
            }
        };
    }
}
