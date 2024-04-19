package com.xiaopeng.lib.framework.moduleinterface.accountmodule;
/* loaded from: classes.dex */
public abstract class AbsException extends Exception {
    public AbsException() {
    }

    public abstract int getCode();

    public AbsException(int i) {
    }

    public AbsException(String str) {
        super(str);
    }

    public AbsException(int i, String str) {
        super(str);
    }
}
