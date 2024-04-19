package com.xiaopeng.lib.framework.netchannelmodule.http.statistic;
/* loaded from: classes.dex */
public class SocketCounter extends BaseHttpCounter {
    private static final String EVENT_NAME = "data_traffic_socket";
    private static final String MOLE_TRAFFIC_SOCKET_BUTTON_ID = "B002";

    /* loaded from: classes.dex */
    private static final class Holder {
        private static final SocketCounter INSTANCE = new SocketCounter();

        private Holder() {
        }
    }

    public SocketCounter() {
        super(EVENT_NAME, MOLE_TRAFFIC_SOCKET_BUTTON_ID);
        BaseHttpCounter.sKeyFailed = "net_socket_failed";
        BaseHttpCounter.sKeySucceed = "net_socket_succeed";
        BaseHttpCounter.sKeyRequest = "net_socket_request";
        BaseHttpCounter.sKeyTrafficRx = "net_socket_rx";
        BaseHttpCounter.sKeyTrafficTx = "net_socket_tx";
        BaseHttpCounter.sKeyDetails = "net_socket_details";
        BaseHttpCounter.sKeyLastDate = "net_socket_date";
    }

    public static SocketCounter getInstance() {
        return Holder.INSTANCE;
    }
}
