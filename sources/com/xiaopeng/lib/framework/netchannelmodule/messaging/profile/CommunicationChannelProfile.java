package com.xiaopeng.lib.framework.netchannelmodule.messaging.profile;

import android.os.SystemProperties;
import android.text.TextUtils;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IMessaging;
import com.xiaopeng.lib.framework.netchannelmodule.common.GlobalConfig;
/* loaded from: classes.dex */
public final class CommunicationChannelProfile extends AbstractChannelProfile {
    private static final boolean FUNCTION_PUBLISH = true;
    private static final boolean FUNCTION_SUBSCRIBE = true;

    public CommunicationChannelProfile() {
        super(true, true);
    }

    private String getMQTTPassword() {
        String str = SystemProperties.get(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_COMM_PASS);
        if (TextUtils.isEmpty(str)) {
            return decode(SystemProperties.get(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_PASS));
        }
        return decode(str);
    }

    private String getMQTTUserName() {
        String str = SystemProperties.get(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_COMM_USER);
        if (TextUtils.isEmpty(str)) {
            return decode(SystemProperties.get(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_USER));
        }
        return decode(str);
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public hk buildConnectOptions() {
        hk buildConnectOptions = super.buildConnectOptions();
        buildConnectOptions.v(GlobalConfig.getSocketFactory());
        buildConnectOptions.w(getMQTTUserName());
        buildConnectOptions.u(getMQTTPassword().toCharArray());
        return buildConnectOptions;
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public IMessaging.CHANNEL channel() {
        return IMessaging.CHANNEL.COMMUNICATION;
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public String clientId() {
        String decode;
        String str = SystemProperties.get(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_COMM_ID);
        if (TextUtils.isEmpty(str)) {
            decode = super.clientId();
        } else {
            decode = decode(str);
        }
        return decode + ":" + gg.e();
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public boolean enableExtremePing() {
        return true;
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public String logTag() {
        return "PahoBizLogger";
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public String serverUrl() {
        String decode = decode(SystemProperties.get(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_COMM_URL));
        if (TextUtils.isEmpty(decode)) {
            return "";
        }
        return AbstractChannelProfile.resolveWithDns("ssl://" + decode);
    }
}
