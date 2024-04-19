package com.xiaopeng.xui.theme;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class XResLoader {
    private static final int NOT_FOUND = 0;
    private static final String RES_APK_PACKAGE = "com.xiaopeng.xui.resources";
    private static Context mApkContext;
    private static String mLoadedApkPackage;
    private static HashMap<String, Integer> mResIDMap = new HashMap<>();

    public static Drawable getDrawable(String str) {
        int resId;
        if (mApkContext == null || (resId = getResId(str)) <= 0) {
            return null;
        }
        return l2.b(mApkContext, resId);
    }

    public static InputStream getRaw(String str) {
        int resId;
        if (mApkContext == null || (resId = getResId(str)) <= 0) {
            return null;
        }
        return mApkContext.getResources().openRawResource(resId);
    }

    public static int getResId(String str) {
        HashMap<String, Integer> hashMap = mResIDMap;
        if (hashMap != null) {
            return hashMap.get(str).intValue();
        }
        return 0;
    }

    public static void init(Context context) {
        loadApk(context, RES_APK_PACKAGE);
    }

    public static void loadApk(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = mLoadedApkPackage;
        if (str2 == null || !str2.equalsIgnoreCase(str)) {
            try {
                mLoadedApkPackage = str;
                Context createPackageContext = context.createPackageContext(str, 3);
                mApkContext = createPackageContext;
                loadResources(createPackageContext, str);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }

    private static void loadResources(Context context, String str) {
        try {
            Class<?>[] classes = context.getClassLoader().loadClass(str + ".R").getClasses();
            for (int i = 0; i < classes.length; i++) {
                Field[] fields = classes[i].getFields();
                for (int i2 = 0; i2 < fields.length; i2++) {
                    if (!fields[i2].getType().getCanonicalName().equals("int[]")) {
                        mResIDMap.put(fields[i2].getName(), Integer.valueOf(fields[i2].getInt(fields[i2].getName())));
                    }
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException unused) {
        }
    }

    public static InputStream openAssets(String str) {
        Context context = mApkContext;
        if (context != null) {
            try {
                return context.getAssets().open(str);
            } catch (IOException unused) {
                return null;
            }
        }
        return null;
    }
}
