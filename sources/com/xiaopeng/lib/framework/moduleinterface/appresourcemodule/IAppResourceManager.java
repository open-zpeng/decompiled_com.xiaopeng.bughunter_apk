package com.xiaopeng.lib.framework.moduleinterface.appresourcemodule;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
/* loaded from: classes.dex */
public interface IAppResourceManager {

    /* loaded from: classes.dex */
    public interface IResourceObserver {
        void onChange(String str, AppResourceResponse appResourceResponse);
    }

    /* loaded from: classes.dex */
    public enum Status {
        NOT_REGISTER(0),
        NOT_AUTH(1),
        NOT_AVAILABLE(2),
        OK(3),
        ERROR(4);
        
        final int mId;

        Status(int i) {
            this.mId = i;
        }

        public int id() {
            return this.mId;
        }
    }

    /* loaded from: classes.dex */
    public enum UpdatePolicy {
        LOCAL(0),
        SYNC(1),
        ASYNC(2);
        
        final int mId;

        UpdatePolicy(int i) {
            this.mId = i;
        }

        public int id() {
            return this.mId;
        }
    }

    boolean addResource(AppResourceRequest appResourceRequest);

    og<AppResourceResponse> addResourceObSource(AppResourceRequest appResourceRequest);

    void checkUpdate(String str);

    og<AppResourceResponse> checkUpdateObSource(String str);

    og<AppResourceResponse> clearResourceObSource();

    void clearResources();

    boolean deleteResource(String str);

    og<AppResourceResponse> deleteResourceObSource(String str);

    AssetFileDescriptor getFileDescriptor(String str);

    og<AssetFileDescriptor> getFileDescriptorObSource(String str);

    Uri getFullUri(String str);

    og<Uri> getFullUrlObSource(String str);

    Status getStatus(String str);

    og<Status> getStatusObSource(String str);

    void subscribeChanges(IResourceObserver iResourceObserver);

    void unSubscribeChanges(IResourceObserver iResourceObserver);
}
