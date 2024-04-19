package com.xiaopeng.lib.themeswitch;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class DrawableLoader {
    private static final String TAG = "DrawableLoader";

    /* loaded from: classes.dex */
    public interface MultiDrawableLoadCallback {
        void onDrawableLoadFinish(Drawable[] drawableArr);
    }

    /* loaded from: classes.dex */
    public interface SingleDrawableLoadCallback {
        void onDrawableLoadFinish(Drawable drawable);
    }

    public static void loadDrawableAsync(final Context context, final int i, final SingleDrawableLoadCallback singleDrawableLoadCallback) {
        if (context == null) {
            return;
        }
        ThreadPoolHelper.getInstance().execute(new Runnable() { // from class: com.xiaopeng.lib.themeswitch.DrawableLoader.4
            @Override // java.lang.Runnable
            public void run() {
                final Drawable drawable;
                Process.setThreadPriority(10);
                try {
                    drawable = context.getResources().getDrawable(i);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    Log.e(DrawableLoader.TAG, String.format("loadDrawableAsync, Unable to load resource 0x%08x from pkg=%s", Integer.valueOf(i), context.getPackageName()), e);
                    drawable = null;
                }
                if (singleDrawableLoadCallback != null) {
                    ThreadPoolHelper.postMainThread(new Runnable() { // from class: com.xiaopeng.lib.themeswitch.DrawableLoader.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            singleDrawableLoadCallback.onDrawableLoadFinish(drawable);
                        }
                    });
                }
            }
        });
    }

    public static void setBackgroundDrawableAsyncForButton(Context context, int i, Button button) {
        final WeakReference weakReference = new WeakReference(button);
        loadDrawableAsync(context, i, new SingleDrawableLoadCallback() { // from class: com.xiaopeng.lib.themeswitch.DrawableLoader.3
            @Override // com.xiaopeng.lib.themeswitch.DrawableLoader.SingleDrawableLoadCallback
            public void onDrawableLoadFinish(Drawable drawable) {
                Button button2 = (Button) weakReference.get();
                if (button2 == null || drawable == null) {
                    return;
                }
                button2.setBackgroundDrawable(drawable);
            }
        });
    }

    public static void setBackgroundDrawableAsyncForView(Context context, int i, View view) {
        final WeakReference weakReference = new WeakReference(view);
        loadDrawableAsync(context, i, new SingleDrawableLoadCallback() { // from class: com.xiaopeng.lib.themeswitch.DrawableLoader.1
            @Override // com.xiaopeng.lib.themeswitch.DrawableLoader.SingleDrawableLoadCallback
            public void onDrawableLoadFinish(Drawable drawable) {
                View view2 = (View) weakReference.get();
                if (view2 == null || drawable == null) {
                    return;
                }
                view2.setBackgroundDrawable(drawable);
            }
        });
    }

    public static void setDrawableAsyncForImageView(Context context, int i, ImageView imageView) {
        if (context == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(imageView);
        loadDrawableAsync(context, i, new SingleDrawableLoadCallback() { // from class: com.xiaopeng.lib.themeswitch.DrawableLoader.2
            @Override // com.xiaopeng.lib.themeswitch.DrawableLoader.SingleDrawableLoadCallback
            public void onDrawableLoadFinish(Drawable drawable) {
                ImageView imageView2 = (ImageView) weakReference.get();
                if (imageView2 == null || drawable == null) {
                    return;
                }
                imageView2.setImageDrawable(drawable);
            }
        });
    }

    public static void loadDrawableAsync(final Context context, final int[] iArr, final MultiDrawableLoadCallback multiDrawableLoadCallback) {
        if (context == null || iArr == null) {
            return;
        }
        ThreadPoolHelper.getInstance().execute(new Runnable() { // from class: com.xiaopeng.lib.themeswitch.DrawableLoader.5
            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                final Drawable[] drawableArr = new Drawable[iArr.length];
                for (int i = 0; i < iArr.length; i++) {
                    try {
                        drawableArr[i] = context.getResources().getDrawable(iArr[i]);
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                        Log.e(DrawableLoader.TAG, String.format("loadDrawableAsync, Unable to load resource 0x%08x from pkg=%s, array index: %d", Integer.valueOf(iArr[i]), context.getPackageName(), Integer.valueOf(i)), e);
                    }
                }
                if (multiDrawableLoadCallback != null) {
                    ThreadPoolHelper.postMainThread(new Runnable() { // from class: com.xiaopeng.lib.themeswitch.DrawableLoader.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            multiDrawableLoadCallback.onDrawableLoadFinish(drawableArr);
                        }
                    });
                }
            }
        });
    }
}
