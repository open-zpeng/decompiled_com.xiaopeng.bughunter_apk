package com.xiaopeng.lib.framework.moduleinterface.carcontroller;
/* loaded from: classes.dex */
public abstract class AbstractEventMsg<T> implements IEventMsg<T> {
    private T mData;

    @Override // com.xiaopeng.lib.framework.moduleinterface.carcontroller.IEventMsg
    public T getData() {
        return this.mData;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.carcontroller.IEventMsg
    public void setData(T t) {
        this.mData = t;
    }

    public String toString() {
        if (this.mData != null) {
            return getClass().getSimpleName() + " = " + this.mData.toString();
        }
        return getClass().getSimpleName() + " = empty content";
    }
}
