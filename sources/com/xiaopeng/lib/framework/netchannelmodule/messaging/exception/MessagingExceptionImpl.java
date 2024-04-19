package com.xiaopeng.lib.framework.netchannelmodule.messaging.exception;

import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.MessagingException;
/* loaded from: classes.dex */
public class MessagingExceptionImpl extends MessagingException {
    private static final long serialVersionUID = 100;
    private int mProtocolReasonCode;
    private int mReasonCode;

    public MessagingExceptionImpl(int i) {
        super("");
        this.mReasonCode = i;
        this.mProtocolReasonCode = 0;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.MessagingException
    public int getProtocolReasonCode() {
        return this.mProtocolReasonCode;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.MessagingException
    public int getReasonCode() {
        return this.mReasonCode;
    }

    public MessagingExceptionImpl(jk jkVar) {
        super(jkVar.getMessage());
        this.mReasonCode = 1;
        this.mProtocolReasonCode = jkVar.a();
    }
}
