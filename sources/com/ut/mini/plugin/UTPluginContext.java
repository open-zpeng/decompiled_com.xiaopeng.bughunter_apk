package com.ut.mini.plugin;

import android.content.Context;
/* loaded from: classes.dex */
public class UTPluginContext {
    public static final int DEBUG_LOG_SWITCH = 1;
    private Context mContext = null;
    private boolean U = false;
    private boolean V = false;

    public void enableRealtimeDebug() {
        this.V = true;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean isDebugLogEnable() {
        return this.U;
    }

    public boolean isRealtimeDebugEnable() {
        return this.V;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setDebugLogFlag(boolean z) {
        this.U = z;
    }
}
