package com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket;

import okio.ByteString;
/* loaded from: classes.dex */
public abstract class WebSocketSubscriber implements sg<IWebSocketInfo> {
    private zg disposable;
    private boolean hasOpened;

    public final void dispose() {
        zg zgVar = this.disposable;
        if (zgVar != null) {
            zgVar.dispose();
        }
    }

    protected void onClose() {
    }

    protected void onClosed(int i, String str) {
    }

    @Override // defpackage.sg
    public final void onComplete() {
        if (this.hasOpened) {
            onClose();
        }
    }

    @Override // defpackage.sg
    public void onError(Throwable th) {
        th.printStackTrace();
    }

    protected void onMessage(String str) {
    }

    protected void onMessage(ByteString byteString) {
    }

    protected void onOpen() {
    }

    protected void onReconnect() {
    }

    @Override // defpackage.sg
    public final void onSubscribe(zg zgVar) {
        this.disposable = zgVar;
    }

    @Override // defpackage.sg
    public final void onNext(IWebSocketInfo iWebSocketInfo) {
        if (iWebSocketInfo.isOnOpen()) {
            this.hasOpened = true;
            onOpen();
        } else if (iWebSocketInfo.isClosed()) {
            this.hasOpened = false;
            onClosed(iWebSocketInfo.closedReasonCode(), iWebSocketInfo.closedReason());
        } else if (iWebSocketInfo.stringMessage() != null) {
            onMessage(iWebSocketInfo.stringMessage());
        } else if (iWebSocketInfo.byteStringMessage() != null) {
            onMessage(iWebSocketInfo.byteStringMessage());
        } else if (iWebSocketInfo.isOnReconnect()) {
            onReconnect();
        }
    }
}
