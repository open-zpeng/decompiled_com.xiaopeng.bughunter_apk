package com.xiaopeng.xui.widgets.window;

import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
/* loaded from: classes.dex */
public class XWindowIPCImpl {
    private IOnWindIPCLIstener mListener;

    @ln(threadMode = qn.MAIN)
    public void onEvent(IIpcService.IpcMessageEvent ipcMessageEvent) {
        if (ipcMessageEvent.getMsgID() != 100011) {
            return;
        }
        String senderPackageName = ipcMessageEvent.getSenderPackageName();
        boolean z = ipcMessageEvent.getPayloadData().getBoolean(XWindowUtil.MSG_SHOW_FLAG);
        IOnWindIPCLIstener iOnWindIPCLIstener = this.mListener;
        if (iOnWindIPCLIstener != null) {
            iOnWindIPCLIstener.onWindowIPCEvent(z, senderPackageName);
        }
    }

    public void register(IOnWindIPCLIstener iOnWindIPCLIstener) {
        this.mListener = iOnWindIPCLIstener;
        bn.c().q(this);
    }

    public void unregister() {
        bn.c().s(this);
    }
}
