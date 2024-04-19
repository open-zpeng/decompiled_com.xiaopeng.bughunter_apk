package com.xiaopeng.lib.framework.module;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class Module {
    private static ConcurrentHashMap<Class, IModuleEntry> sModuleMap = new ConcurrentHashMap<>();

    public static IModuleEntry get(Class cls) {
        return sModuleMap.get(cls);
    }

    public static void register(Class cls, IModuleEntry iModuleEntry) {
        if (cls == null || iModuleEntry == null || sModuleMap.containsKey(cls)) {
            return;
        }
        sModuleMap.put(cls, iModuleEntry);
    }
}
