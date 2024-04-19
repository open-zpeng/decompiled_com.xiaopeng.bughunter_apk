package com.xiaopeng.xui.widgets.popup;

import android.animation.AnimatorListenerAdapter;
import android.view.View;
/* loaded from: classes.dex */
public interface XPopupAnimator {
    void breakAnimator(View view);

    void popout(View view, AnimatorListenerAdapter animatorListenerAdapter);

    void popup(View view);
}
