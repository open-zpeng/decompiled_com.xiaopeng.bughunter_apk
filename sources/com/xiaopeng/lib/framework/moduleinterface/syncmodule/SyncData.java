package com.xiaopeng.lib.framework.moduleinterface.syncmodule;
/* loaded from: classes.dex */
public class SyncData {
    public String key;
    public String value;

    public SyncData() {
    }

    public String toString() {
        return "SyncData { key:" + this.key + "; value:" + this.value + "; }";
    }

    public SyncData(String str, String str2) {
        this.key = str;
        this.value = str2;
    }
}
