package com.xiaopeng.lib.framework.moduleinterface.ipcmodule;

import android.os.Bundle;
/* loaded from: classes.dex */
public interface IIpcService {

    /* loaded from: classes.dex */
    public static class IpcMessageEvent {
        int mMsgID;
        Bundle mPayloadData;
        String mSenderPackageName;

        public int getMsgID() {
            return this.mMsgID;
        }

        public Bundle getPayloadData() {
            return this.mPayloadData;
        }

        public String getSenderPackageName() {
            return this.mSenderPackageName;
        }

        public void setMsgID(int i) {
            this.mMsgID = i;
        }

        public void setPayloadData(Bundle bundle) {
            this.mPayloadData = bundle;
        }

        public void setSenderPackageName(String str) {
            this.mSenderPackageName = str;
        }

        public String toString() {
            return "IpcMessageEvent{mSenderPackageName='" + this.mSenderPackageName + "', mMsgID=" + this.mMsgID + ", mPayloadData=" + this.mPayloadData + '}';
        }
    }

    void init();

    void sendData(int i, Bundle bundle, String... strArr);
}
