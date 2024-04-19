package com.xiaopeng.lib.framework.netchannelmodule.messaging.profile;

import android.os.SystemProperties;
import android.text.TextUtils;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IMessaging;
import com.xiaopeng.lib.framework.netchannelmodule.common.GlobalConfig;
/* loaded from: classes.dex */
public final class ReportingChannelProfile extends AbstractChannelProfile {
    private static final boolean FUNCTION_PUBLISH = true;
    private static final boolean FUNCTION_SUBSCRIBE = false;
    private static final int MAX_CACHABLE_BUFFER_SIZE = 1000;

    public ReportingChannelProfile() {
        super(FUNCTION_PUBLISH, false);
    }

    private String getMQTTPassword() {
        return decode(SystemProperties.get(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_PASS));
    }

    private String getMQTTUserName() {
        return decode(SystemProperties.get(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_USER));
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public xj buildBufferOptions() {
        xj xjVar = new xj();
        xjVar.e(FUNCTION_PUBLISH);
        xjVar.f(1000);
        xjVar.g(FUNCTION_PUBLISH);
        xjVar.h(FUNCTION_PUBLISH);
        return xjVar;
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
        return IMessaging.CHANNEL.REPORTING;
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public String clientId() {
        return super.clientId();
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public int defaultQoSLevel() {
        return IMessaging.QOS.LEVEL_1.value();
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public String serverUrl() {
        String decode = decode(SystemProperties.get(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_REPORTING_URL));
        if (TextUtils.isEmpty(decode)) {
            return "";
        }
        return AbstractChannelProfile.resolveWithDns("ssl://" + decode);
    }
}
