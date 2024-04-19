package com.xiaopeng.xui.utils;

import android.util.Log;
/* loaded from: classes.dex */
public class L {
    public static final int LEVEL_ALL = 0;
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_INFO = 3;
    public static final int LEVEL_WARNING = 2;
    private static L mL;
    private final int level;

    private L(int i) {
        this.level = i;
    }

    public static void e(String str, String str2) {
        if (get().allow(4)) {
            Log.e(str, str2);
        }
    }

    public static L get() {
        if (mL == null) {
            mL = new L(4);
        }
        return mL;
    }

    public boolean allow(int i) {
        return this.level <= i;
    }
}
