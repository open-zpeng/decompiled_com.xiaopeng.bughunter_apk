package com.xiaopeng.xui.watchers;

import android.app.Activity;
import android.os.Bundle;
/* loaded from: classes.dex */
public interface XWatcher {
    void onCreate(Activity activity, Bundle bundle);

    void onDestroy();

    void onPause();

    void onResume();
}
