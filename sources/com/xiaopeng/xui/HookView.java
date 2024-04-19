package com.xiaopeng.xui;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Calendar;
/* loaded from: classes.dex */
public class HookView {
    private static final String TAG = "HookView";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class OnClickListenerProxy implements View.OnClickListener {
        private long mLastClickTime;
        private long mMaxInterval;
        private View.OnClickListener mObject;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            if (timeInMillis - this.mLastClickTime > this.mMaxInterval) {
                this.mLastClickTime = timeInMillis;
                View.OnClickListener onClickListener = this.mObject;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }

        private OnClickListenerProxy(View.OnClickListener onClickListener, long j) {
            this.mMaxInterval = 1000L;
            this.mLastClickTime = 0L;
            this.mObject = onClickListener;
            if (j > 0) {
                this.mMaxInterval = j;
            }
        }
    }

    public static void hook(View view) {
        hook(view, 0L);
    }

    public static void hook(View view, long j) {
        if (view == null) {
            Log.i(TAG, "View is null, can not hook");
            return;
        }
        try {
            Method declaredMethod = Class.forName("android.view.View").getDeclaredMethod("getListenerInfo", new Class[0]);
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            Object invoke = declaredMethod.invoke(view, new Object[0]);
            Field declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            declaredField.set(invoke, new OnClickListenerProxy((View.OnClickListener) declaredField.get(invoke), j));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
