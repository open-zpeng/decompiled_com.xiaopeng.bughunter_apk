package com.xiaopeng.lib.framework.netchannelmodule.messaging.profile;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IMessaging;
import com.xiaopeng.lib.framework.netchannelmodule.messaging.protocol.MemoryPersistenceProxy;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class AbstractChannelProfile {
    private static final String AES_KEY = "@!chxpzi#0109$+/";
    private static final int CONNECTION_TIMEOUT = 10;
    private static final String DEBUG_FLAG_FILE = "/sdcard/MQTTTRACE.xp";
    private static final int MAX_INFLIGHT = 120;
    protected static final String SSL_PREFIX = "ssl://";
    public static final String SYSTEM_PROPERTY_MQTT_COMM_ID;
    public static final String SYSTEM_PROPERTY_MQTT_COMM_PASS;
    public static final String SYSTEM_PROPERTY_MQTT_COMM_URL;
    public static final String SYSTEM_PROPERTY_MQTT_COMM_USER;
    public static final String SYSTEM_PROPERTY_MQTT_ID;
    public static final String SYSTEM_PROPERTY_MQTT_PASS;
    public static final String SYSTEM_PROPERTY_MQTT_REPORTING_URL;
    public static final String SYSTEM_PROPERTY_MQTT_USER;
    private static final boolean sShorterAccountEncoding;
    private boolean mCanPublish;
    private boolean mCanSubscribe;
    private boolean mDebugging = checkDebuggingFlag();
    private MqttClientPersistenceFactory sPersistenceFactory;

    /* loaded from: classes.dex */
    public interface MqttClientPersistenceFactory {
        gk makePersistence();
    }

    static {
        sShorterAccountEncoding = Build.VERSION.SDK_INT != 19;
        SYSTEM_PROPERTY_MQTT_USER = "persist.sys.mqtt.user" + gg.a();
        SYSTEM_PROPERTY_MQTT_PASS = "persist.sys.mqtt.pass" + gg.a();
        SYSTEM_PROPERTY_MQTT_ID = "persist.sys.mqtt.id" + gg.a();
        SYSTEM_PROPERTY_MQTT_REPORTING_URL = "persist.sys.mqtt.url" + gg.a();
        SYSTEM_PROPERTY_MQTT_COMM_URL = "persist.sys.mqtt.comm_url" + gg.a();
        SYSTEM_PROPERTY_MQTT_COMM_ID = "persist.sys.mqtt.comm_id" + gg.a();
        SYSTEM_PROPERTY_MQTT_COMM_USER = "persist.sys.mqtt.comm_user" + gg.a();
        SYSTEM_PROPERTY_MQTT_COMM_PASS = "persist.sys.mqtt.comm_pass" + gg.a();
    }

    public AbstractChannelProfile(boolean z, boolean z2) {
        this.mCanPublish = z;
        this.mCanSubscribe = z2;
    }

    private static boolean checkDebuggingFlag() {
        return gg.g() && new File(DEBUG_FLAG_FILE).exists();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020 A[Catch: UnknownHostException -> 0x0078, TryCatch #0 {UnknownHostException -> 0x0078, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x001a, B:8:0x0020, B:10:0x002c, B:14:0x003e, B:16:0x0060, B:12:0x0032), top: B:20:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String resolveWithDns(java.lang.String r5) {
        /*
            android.net.Uri r0 = android.net.Uri.parse(r5)
            com.xiaopeng.lib.framework.netchannelmodule.http.xmart.TimeoutDns r1 = com.xiaopeng.lib.framework.netchannelmodule.http.xmart.TimeoutDns.getInstance()     // Catch: java.net.UnknownHostException -> L78
            java.lang.String r2 = r0.getHost()     // Catch: java.net.UnknownHostException -> L78
            java.util.List r1 = r1.lookupAsync(r2)     // Catch: java.net.UnknownHostException -> L78
            boolean r2 = r1.isEmpty()     // Catch: java.net.UnknownHostException -> L78
            if (r2 != 0) goto L78
            java.util.Iterator r1 = r1.iterator()     // Catch: java.net.UnknownHostException -> L78
        L1a:
            boolean r2 = r1.hasNext()     // Catch: java.net.UnknownHostException -> L78
            if (r2 == 0) goto L78
            java.lang.Object r2 = r1.next()     // Catch: java.net.UnknownHostException -> L78
            java.net.InetAddress r2 = (java.net.InetAddress) r2     // Catch: java.net.UnknownHostException -> L78
            boolean r3 = r2.isSiteLocalAddress()     // Catch: java.net.UnknownHostException -> L78
            if (r3 != 0) goto L32
            boolean r3 = r2.isLoopbackAddress()     // Catch: java.net.UnknownHostException -> L78
            if (r3 == 0) goto L3e
        L32:
            java.lang.String r3 = r2.getHostAddress()     // Catch: java.net.UnknownHostException -> L78
            java.lang.String r4 = "10."
            boolean r3 = r3.startsWith(r4)     // Catch: java.net.UnknownHostException -> L78
            if (r3 == 0) goto L1a
        L3e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.net.UnknownHostException -> L78
            r1.<init>()     // Catch: java.net.UnknownHostException -> L78
            java.lang.String r3 = r0.getScheme()     // Catch: java.net.UnknownHostException -> L78
            r1.append(r3)     // Catch: java.net.UnknownHostException -> L78
            java.lang.String r3 = "://"
            r1.append(r3)     // Catch: java.net.UnknownHostException -> L78
            java.lang.String r2 = r2.getHostAddress()     // Catch: java.net.UnknownHostException -> L78
            r1.append(r2)     // Catch: java.net.UnknownHostException -> L78
            java.lang.String r5 = r1.toString()     // Catch: java.net.UnknownHostException -> L78
            int r1 = r0.getPort()     // Catch: java.net.UnknownHostException -> L78
            if (r1 <= 0) goto L78
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.net.UnknownHostException -> L78
            r1.<init>()     // Catch: java.net.UnknownHostException -> L78
            r1.append(r5)     // Catch: java.net.UnknownHostException -> L78
            java.lang.String r2 = ":"
            r1.append(r2)     // Catch: java.net.UnknownHostException -> L78
            int r0 = r0.getPort()     // Catch: java.net.UnknownHostException -> L78
            r1.append(r0)     // Catch: java.net.UnknownHostException -> L78
            java.lang.String r5 = r1.toString()     // Catch: java.net.UnknownHostException -> L78
        L78:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Update server uri:"
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            defpackage.tf.d(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile.resolveWithDns(java.lang.String):java.lang.String");
    }

    public xj buildBufferOptions() {
        return null;
    }

    public hk buildConnectOptions() {
        hk hkVar = new hk();
        hkVar.p(false);
        hkVar.q(false);
        hkVar.t(4);
        hkVar.s(120);
        hkVar.r(10);
        return hkVar;
    }

    public boolean canPublish() {
        return this.mCanPublish;
    }

    public boolean canSubscribe() {
        return this.mCanSubscribe;
    }

    public abstract IMessaging.CHANNEL channel();

    public String clientId() {
        String str = SystemProperties.get(SYSTEM_PROPERTY_MQTT_ID);
        if (!TextUtils.isEmpty(str)) {
            return decode(str);
        }
        throw new RuntimeException("Initialization failure!!");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String decode(String str) {
        String a;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (sShorterAccountEncoding) {
            a = eg.b(str, AES_KEY);
        } else {
            a = eg.a(str, AES_KEY);
        }
        return a == null ? "" : a;
    }

    public int defaultQoSLevel() {
        return IMessaging.QOS.LEVEL_2.value();
    }

    public boolean enableExtremePing() {
        return false;
    }

    public boolean enableTrace() {
        return this.mDebugging;
    }

    public Set<String> getAcceptedLogList() {
        if (this.mDebugging) {
            return null;
        }
        return new HashSet(Arrays.asList("309", "627", "633", "802"));
    }

    public String logTag() {
        return "PahoLogger";
    }

    public gk mqttClientPersistence() {
        MqttClientPersistenceFactory mqttClientPersistenceFactory = this.sPersistenceFactory;
        if (mqttClientPersistenceFactory != null) {
            return mqttClientPersistenceFactory.makePersistence();
        }
        return new MemoryPersistenceProxy();
    }

    public boolean needToCollectData() {
        return true;
    }

    public boolean sendOutAllLogs() {
        return false;
    }

    public abstract String serverUrl();

    public void setPersistenceFactory(MqttClientPersistenceFactory mqttClientPersistenceFactory) {
        this.sPersistenceFactory = mqttClientPersistenceFactory;
    }
}
