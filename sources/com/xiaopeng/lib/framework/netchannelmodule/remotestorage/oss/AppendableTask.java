package com.xiaopeng.lib.framework.netchannelmodule.remotestorage.oss;

import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.model.HeadObjectRequest;
import com.alibaba.sdk.android.oss.model.HeadObjectResult;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.StorageException;
import com.xiaopeng.lib.framework.netchannelmodule.remotestorage.exception.StorageExceptionImpl;
import com.xiaopeng.lib.framework.netchannelmodule.remotestorage.statistic.StorageCounter;
import com.xiaopeng.lib.framework.netchannelmodule.remotestorage.token.Token;
import com.xiaopeng.lib.framework.netchannelmodule.remotestorage.token.TokenRetriever;
/* loaded from: classes.dex */
public class AppendableTask extends BaseOssTask {
    private static int STATUS_OK = 200;
    private static final String TAG = "NetChannel-AppendableTask";
    private byte[] mUploadContent;

    /* loaded from: classes.dex */
    private class FutureTaskCallback implements TokenRetriever.IRetrievingCallback {
        private FutureTaskCallback() {
        }

        @Override // com.xiaopeng.lib.framework.netchannelmodule.remotestorage.token.TokenRetriever.IRetrievingCallback
        public void onFailure(StorageException storageException) {
            AppendableTask.this.doFailure(storageException);
            StorageCounter.getInstance().increaseFailureWithCode(String.valueOf((int) StorageException.REASON_GET_TOKEN_ERROR), 0L);
        }

        @Override // com.xiaopeng.lib.framework.netchannelmodule.remotestorage.token.TokenRetriever.IRetrievingCallback
        public void onSuccess(Token token) {
            AppendableTask.this.executeAppendTask(token);
        }
    }

    public AppendableTask(Bucket bucket) {
        super(bucket);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:48:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void appendToOssObject(com.alibaba.sdk.android.oss.OSS r20) {
        /*
            Method dump skipped, instructions count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.lib.framework.netchannelmodule.remotestorage.oss.AppendableTask.appendToOssObject(com.alibaba.sdk.android.oss.OSS):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeAppendTask(Token token) {
        final OSS createOssClient = createOssClient(token.accessKeyId(), token.acessKeySecret(), token.securityToken());
        ag.i(new Runnable() { // from class: com.xiaopeng.lib.framework.netchannelmodule.remotestorage.oss.AppendableTask.1
            @Override // java.lang.Runnable
            public void run() {
                AppendableTask.this.appendToOssObject(createOssClient);
            }
        });
    }

    private long tryToGetExistingObjectLength(OSS oss) {
        try {
            HeadObjectResult headObject = oss.headObject(new HeadObjectRequest(bucketRootName(), this.mRemoteObjectKey));
            if (STATUS_OK == headObject.getStatusCode()) {
                return headObject.getMetadata().getContentLength();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public AppendableTask append(byte[] bArr) throws StorageException {
        if (bArr != null && bArr.length != 0) {
            this.mUploadContent = bArr;
            return this;
        }
        throw new StorageExceptionImpl(4);
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.remotestorage.oss.BaseOssTask
    public BaseOssTask build() throws StorageException {
        byte[] bArr = this.mUploadContent;
        if (bArr != null && bArr.length != 0) {
            return super.build();
        }
        throw new StorageExceptionImpl(4);
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.remotestorage.oss.BaseOssTask
    public void performRealTask() {
        TokenRetriever.getInstance().getTokenWithCallback(new FutureTaskCallback());
    }
}
