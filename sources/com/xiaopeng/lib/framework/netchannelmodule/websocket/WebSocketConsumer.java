package com.xiaopeng.lib.framework.netchannelmodule.websocket;

import okhttp3.WebSocket;
import okio.ByteString;
@Deprecated
/* loaded from: classes.dex */
abstract class WebSocketConsumer implements mh<WebSocketInfo> {
    WebSocketConsumer() {
    }

    public abstract void onClosed(WebSocket webSocket);

    public abstract void onMessage(String str);

    public abstract void onMessage(ByteString byteString);

    public abstract void onOpen(WebSocket webSocket);

    @Override // defpackage.mh
    public void accept(WebSocketInfo webSocketInfo) throws Exception {
        if (webSocketInfo.isOnOpen()) {
            onOpen(webSocketInfo.getWebSocket());
        } else if (webSocketInfo.isClosed()) {
            onClosed(webSocketInfo.getWebSocket());
        } else if (webSocketInfo.stringMessage() != null) {
            onMessage(webSocketInfo.stringMessage());
        } else if (webSocketInfo.byteStringMessage() != null) {
            onMessage(webSocketInfo.byteStringMessage());
        }
    }
}
