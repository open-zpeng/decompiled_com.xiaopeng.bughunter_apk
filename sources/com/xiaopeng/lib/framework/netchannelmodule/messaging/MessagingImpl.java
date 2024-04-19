package com.xiaopeng.lib.framework.netchannelmodule.messaging;

import android.app.Application;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IMessaging;
import com.xiaopeng.lib.framework.netchannelmodule.common.GlobalConfig;
import com.xiaopeng.lib.framework.netchannelmodule.messaging.exception.MessagingExceptionImpl;
import com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile;
import com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.ProfileFactory;
import com.xiaopeng.lib.framework.netchannelmodule.messaging.protocol.MqttChannel;
/* loaded from: classes.dex */
public class MessagingImpl implements IMessaging {
    public static final String TAG = "MessagingImpl";
    private AbstractChannelProfile mChannelProfile;

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IMessaging
    public boolean available() {
        if (GlobalConfig.getApplicationContext() == null) {
            return false;
        }
        return MqttChannel.getInstance().isConnected();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IMessaging
    public void initChannelWithContext(IMessaging.CHANNEL channel, Application application) throws Exception {
        GlobalConfig.setApplicationContext(application);
        Module.register(se.class, new se(application));
        this.mChannelProfile = ProfileFactory.channelProfile(channel);
        MqttChannel.getInstance().init(application, this.mChannelProfile);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IMessaging
    public long publish(String str, String str2) throws Exception {
        if (GlobalConfig.getApplicationContext() != null) {
            if (this.mChannelProfile.canPublish()) {
                return MqttChannel.getInstance().publishMessage(str, str2);
            }
            throw new MessagingExceptionImpl(32);
        }
        throw new MessagingExceptionImpl(17);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IMessaging
    public void subscribe(String str) throws Exception {
        if (GlobalConfig.getApplicationContext() != null) {
            if (this.mChannelProfile.canSubscribe()) {
                MqttChannel.getInstance().subscribe(str);
                return;
            }
            throw new MessagingExceptionImpl(33);
        }
        throw new MessagingExceptionImpl(17);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IMessaging
    public long publish(String str, byte[] bArr) throws Exception {
        if (GlobalConfig.getApplicationContext() != null) {
            if (this.mChannelProfile.canPublish()) {
                return MqttChannel.getInstance().publishMessage(str, bArr);
            }
            throw new MessagingExceptionImpl(32);
        }
        throw new MessagingExceptionImpl(17);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IMessaging
    public long publish(String str, String str2, IMessaging.QOS qos) throws Exception {
        if (GlobalConfig.getApplicationContext() != null) {
            if (this.mChannelProfile.canPublish()) {
                return MqttChannel.getInstance().publishMessage(str, str2.getBytes(), qos.value());
            }
            throw new MessagingExceptionImpl(32);
        }
        throw new MessagingExceptionImpl(17);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IMessaging
    public long publish(String str, byte[] bArr, IMessaging.QOS qos) throws Exception {
        if (GlobalConfig.getApplicationContext() != null) {
            if (this.mChannelProfile.canPublish()) {
                return MqttChannel.getInstance().publishMessage(str, bArr, qos.value());
            }
            throw new MessagingExceptionImpl(32);
        }
        throw new MessagingExceptionImpl(17);
    }
}
