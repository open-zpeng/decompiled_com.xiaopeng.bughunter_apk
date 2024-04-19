package com.xiaopeng.xui.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.xui.XUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
/* loaded from: classes.dex */
public class UIUtils {
    private static final String VIEW_ATTR_VALUE_SPLIT = "/";
    private static float density;
    private static int height;
    private static int width;

    public static int dip2px(float f) {
        return (int) ((f * XUI.getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static View[] findViewsByType(ViewGroup viewGroup, Class cls) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (cls.isInstance(childAt)) {
                arrayList.add(childAt);
            } else if (childAt instanceof ViewGroup) {
                arrayList.addAll(Arrays.asList(findViewsByType((ViewGroup) childAt, cls)));
            }
        }
        return (View[]) arrayList.toArray(new View[arrayList.size()]);
    }

    public static int getColor(int i) {
        return XUI.getContext().getResources().getColor(i);
    }

    public static Drawable getDrawable(int i) {
        return XUI.getContext().getResources().getDrawable(i);
    }

    public static float getFontScale() {
        return XUI.getContext().getResources().getDisplayMetrics().scaledDensity;
    }

    public static int getResourceId(Context context, String str) {
        if (str.contains(VIEW_ATTR_VALUE_SPLIT)) {
            String substring = str.substring(1, str.indexOf(VIEW_ATTR_VALUE_SPLIT));
            return context.getResources().getIdentifier(str.substring(str.indexOf(VIEW_ATTR_VALUE_SPLIT) + 1), substring, context.getPackageName());
        }
        return -1;
    }

    public static float getScreenDensity() {
        return density;
    }

    public static int getScreenHeight() {
        return height;
    }

    public static int getScreenWidth() {
        return width;
    }

    public static int getStatusBarBottomHeight() {
        try {
            return XUI.getContext().getResources().getDimensionPixelSize(XUI.getContext().getResources().getIdentifier("status_bar_bottom_height", "dimen", "android"));
        } catch (Exception e) {
            Log.d("UIUtils", "e: " + e.getMessage());
            return 0;
        }
    }

    public static int getStatusBarHeight() {
        try {
            return XUI.getContext().getResources().getDimensionPixelSize(XUI.getContext().getResources().getIdentifier("status_bar_height", "dimen", "android")) + XUI.getContext().getResources().getDimensionPixelSize(XUI.getContext().getResources().getIdentifier("status_bar_bottom_height", "dimen", "android"));
        } catch (Exception e) {
            Log.d("UIUtils", "e: " + e.getMessage());
            return 0;
        }
    }

    public static void init(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        width = displayMetrics.widthPixels;
        height = displayMetrics.heightPixels;
        density = displayMetrics.density;
    }

    public static boolean isRtl() {
        return isRtl(Locale.getDefault());
    }

    public static int px2dip(float f) {
        return (int) ((f / XUI.getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2sp(float f) {
        return (int) ((f / XUI.getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int sp2px(float f) {
        return (int) ((f * XUI.getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private static boolean isRtl(Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName().charAt(0));
        return directionality == 1 || directionality == 2;
    }
}
