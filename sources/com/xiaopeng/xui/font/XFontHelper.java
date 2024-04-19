package com.xiaopeng.xui.font;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import com.xiaopeng.xui.utils.ThreadUtils;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class XFontHelper {
    private static final String BASE_FONT_DIR = "font/";
    private static final String BASE_SYSTEM_FONT_DIR = "/system/fonts/";
    @Deprecated
    public static final String FONT_CENTURY_GOTHIC = "xpnumber.ttf";
    @Deprecated
    public static final String FONT_CENTURY_GOTHIC_BOLD = "xpnumber.ttf";
    public static final String FONT_XP_BOLD = "Xpeng-Bold.ttf";
    public static final String FONT_XP_MEDIUM = "Xpeng-Medium.ttf";
    public static final String FONT_XP_NUMBER = "xpnumber.ttf";
    public static final String FONT_XP_REGULAR = "Xpeng-Regular.ttf";
    private static ConcurrentHashMap<String, Typeface> fonts = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface OnFontLoadCallback {
        void onLoaded(Typeface typeface);
    }

    public static void applyTypeface(TextView textView, String str) {
        applyTypeface(textView, str, false);
    }

    @Deprecated
    public static Typeface getAssetsTypeface(Context context, String str) {
        Typeface typeface = fonts.get(str);
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), getFontPath(str));
                if (typeface != null) {
                    fonts.put(str, typeface);
                }
            } catch (Exception unused) {
            }
        }
        return typeface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getFontPath(String str) {
        return BASE_FONT_DIR + str;
    }

    private static String getSystemFontPath(String str) {
        return BASE_SYSTEM_FONT_DIR + str;
    }

    @Deprecated
    public static Typeface getSystemTypeface(Context context, String str) {
        Typeface typeface = fonts.get(str);
        if (typeface == null) {
            try {
                typeface = Typeface.createFromFile(getSystemFontPath(str));
            } catch (Exception unused) {
            }
            fonts.put(str, typeface);
        }
        return typeface;
    }

    @Deprecated
    public static Typeface getTypeface(Context context, String str) {
        return getAssetsTypeface(context, str);
    }

    public static void getTypefaceAsync(final Context context, final String str, final OnFontLoadCallback onFontLoadCallback) {
        Typeface typeface = fonts.get(str);
        if (typeface == null) {
            ThreadUtils.runInBackground(new Runnable() { // from class: com.xiaopeng.xui.font.XFontHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    final Typeface typeface2 = null;
                    try {
                        typeface2 = XFontHelper.getTypeface(str);
                        if (typeface2 == null) {
                            typeface2 = Typeface.createFromAsset(context.getAssets(), XFontHelper.getFontPath(str));
                        }
                    } catch (Exception unused) {
                    }
                    if (typeface2 != null) {
                        XFontHelper.fonts.put(str, typeface2);
                        ThreadUtils.runOnMainThread(new Runnable() { // from class: com.xiaopeng.xui.font.XFontHelper.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                onFontLoadCallback.onLoaded(typeface2);
                            }
                        });
                    }
                }
            });
        } else {
            onFontLoadCallback.onLoaded(typeface);
        }
    }

    public static void applyTypeface(final TextView textView, String str, final boolean z) {
        if (textView == null) {
            return;
        }
        if (getTypeface(str) != null) {
            textView.setTypeface(getTypeface(str));
            textView.setIncludeFontPadding(z);
            return;
        }
        getTypefaceAsync(textView.getContext(), str, new OnFontLoadCallback() { // from class: com.xiaopeng.xui.font.XFontHelper.2
            @Override // com.xiaopeng.xui.font.XFontHelper.OnFontLoadCallback
            public void onLoaded(Typeface typeface) {
                if (typeface != null) {
                    textView.setTypeface(typeface);
                    textView.setIncludeFontPadding(z);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Typeface getTypeface(String str) {
        if (FONT_XP_REGULAR.equals(str)) {
            return Typeface.create("xpeng-regular", Typeface.NORMAL);
        }
        if (FONT_XP_MEDIUM.equals(str)) {
            return Typeface.DEFAULT;
        }
        if (FONT_XP_BOLD.equals(str)) {
            return Typeface.DEFAULT_BOLD;
        }
        if ("xpnumber.ttf".equals(str)) {
            return Typeface.create("xpeng-number", Typeface.NORMAL);
        }
        return null;
    }

    @Deprecated
    public static Typeface getSystemTypeface(String str) {
        Typeface typeface = fonts.get(str);
        if (typeface == null) {
            try {
                typeface = Typeface.createFromFile(getSystemFontPath(str));
            } catch (Exception unused) {
            }
            fonts.put(str, typeface);
        }
        return typeface;
    }
}
