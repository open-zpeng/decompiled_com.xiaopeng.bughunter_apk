package com.xiaopeng.xui;

import android.content.Context;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.xui.theme.ThemeWatcher;
import com.xiaopeng.xui.theme.XResLoader;
import com.xiaopeng.xui.utils.UIUtils;
/* loaded from: classes.dex */
public class XUI {
    private static Context mContext;

    /* loaded from: classes.dex */
    public static class Config {
        private boolean enableIpc;
        private boolean enableSharedResources;
        private boolean enableThemeSwitch;

        public Config useIpc(boolean z) {
            this.enableIpc = z;
            return this;
        }

        public Config useSharedResources(boolean z) {
            this.enableSharedResources = z;
            return this;
        }

        public Config useThemeSwitch(boolean z) {
            this.enableThemeSwitch = z;
            return this;
        }
    }

    @Deprecated
    public static void clear() {
        ThemeWatcher.getInstance().clear();
    }

    public static Context getContext() {
        Context context = mContext;
        if (context != null) {
            return context;
        }
        throw new RuntimeException("Xui must be call XUI#init()!");
    }

    public static void init(Context context) {
        init(context, new Config().useIpc(true).useSharedResources(true).useThemeSwitch(true));
    }

    private static void initIPC(Context context) {
        Module.register(IpcModuleEntry.class, new IpcModuleEntry(context));
        ((IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class)).init();
    }

    public static void release() {
        ThemeWatcher.getInstance().release();
    }

    public static void init(Context context, Config config) {
        mContext = context;
        UIUtils.init(context);
        if (config != null) {
            if (config.enableIpc) {
                initIPC(context);
            }
            if (config.enableSharedResources) {
                XResLoader.init(context);
            }
            if (config.enableThemeSwitch) {
                ThemeWatcher.getInstance().init(context, new int[0]);
            }
        }
    }
}
