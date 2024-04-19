package com.xiaopeng.xui.theme;

import com.xiaopeng.xui.theme.ThemeWatcherWrapper;
/* loaded from: classes.dex */
public class ThemeWatcher {
    public static final int THEME_TYPE_AUTO = 3;
    public static final int THEME_TYPE_DAY = 1;
    public static final int THEME_TYPE_NIGHT = 2;
    public static final int THEME_TYPE_NULL = 0;

    /* loaded from: classes.dex */
    public interface OnThemeSwitchListener {
        void onSwitchTheme(int i);
    }

    public static ThemeWatcherWrapper.IThemeWatcher getInstance() {
        return ThemeWatcherWrapper.getInstance();
    }
}
