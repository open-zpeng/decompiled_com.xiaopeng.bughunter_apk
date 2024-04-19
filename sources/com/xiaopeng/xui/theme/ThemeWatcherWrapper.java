package com.xiaopeng.xui.theme;

import android.content.Context;
import android.view.View;
import com.xiaopeng.xui.theme.ThemeWatcher;
import com.xiaopeng.xui.utils.ThreadUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class ThemeWatcherWrapper {
    private static final String CLASS = "com.xiaopeng.lib.themeswitch.ThemeWatcher";
    private static IThemeWatcher mThemeWatcher;

    /* loaded from: classes.dex */
    public static class FakeThemeWatcher implements IThemeWatcher {
        @Override // com.xiaopeng.xui.theme.ThemeWatcherWrapper.IThemeWatcher
        public void addThemeSwitchListener(ThemeWatcher.OnThemeSwitchListener onThemeSwitchListener) {
        }

        @Override // com.xiaopeng.xui.theme.ThemeWatcherWrapper.IThemeWatcher
        public void clear() {
        }

        @Override // com.xiaopeng.xui.theme.ThemeWatcherWrapper.IThemeWatcher
        public void init(Context context, int... iArr) {
        }

        @Override // com.xiaopeng.xui.theme.ThemeWatcherWrapper.IThemeWatcher
        public boolean isNight() {
            return false;
        }

        @Override // com.xiaopeng.xui.theme.ThemeWatcherWrapper.IThemeWatcher
        public String newThemeNameForRepeatView(String str) {
            return str;
        }

        @Override // com.xiaopeng.xui.theme.ThemeWatcherWrapper.IThemeWatcher
        public void register(View view, String str) {
        }

        @Override // com.xiaopeng.xui.theme.ThemeWatcherWrapper.IThemeWatcher
        public void release() {
        }

        @Override // com.xiaopeng.xui.theme.ThemeWatcherWrapper.IThemeWatcher
        public void removeThemeListener(ThemeWatcher.OnThemeSwitchListener onThemeSwitchListener) {
        }

        @Override // com.xiaopeng.xui.theme.ThemeWatcherWrapper.IThemeWatcher
        public void unregister(String str) {
        }
    }

    /* loaded from: classes.dex */
    public interface IThemeWatcher {
        void addThemeSwitchListener(ThemeWatcher.OnThemeSwitchListener onThemeSwitchListener);

        void clear();

        void init(Context context, int... iArr);

        boolean isNight();

        String newThemeNameForRepeatView(String str);

        void register(View view, String str);

        void release();

        void removeThemeListener(ThemeWatcher.OnThemeSwitchListener onThemeSwitchListener);

        void unregister(String str);
    }

    ThemeWatcherWrapper() {
    }

    private static IThemeWatcher createThemeWatcher() {
        try {
            Class<?> cls = Class.forName(CLASS);
            return new ThemeWatcherDelegate(cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]), cls);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return new FakeThemeWatcher();
        }
    }

    public static IThemeWatcher getInstance() {
        if (mThemeWatcher == null) {
            synchronized (ThemeWatcherWrapper.class) {
                if (mThemeWatcher == null) {
                    mThemeWatcher = createThemeWatcher();
                }
            }
        }
        return mThemeWatcher;
    }

    /* loaded from: classes.dex */
    public static class ThemeWatcherDelegate implements IThemeWatcher {
        private Object mDefaultThemeSwitchHooker;
        private final Object mTarget;
        private final Class<?> mTargetCls;
        private final List<ThemeWatcher.OnThemeSwitchListener> mListeners = new CopyOnWriteArrayList();
        private int mThemeType = 0;
        private final ThemeWatcher.OnThemeSwitchListener mDefaultThemeSwitchListener = new ThemeWatcher.OnThemeSwitchListener() { // from class: com.xiaopeng.xui.theme.ThemeWatcherWrapper.ThemeWatcherDelegate.1
            @Override // com.xiaopeng.xui.theme.ThemeWatcher.OnThemeSwitchListener
            public void onSwitchTheme(final int i) {
                ThemeWatcherDelegate.this.mThemeType = i;
                ThreadUtils.runOnMainThread(new Runnable() { // from class: com.xiaopeng.xui.theme.ThemeWatcherWrapper.ThemeWatcherDelegate.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (ThemeWatcher.OnThemeSwitchListener onThemeSwitchListener : (ThemeWatcher.OnThemeSwitchListener[]) ThemeWatcherDelegate.this.mListeners.toArray(new ThemeWatcher.OnThemeSwitchListener[0])) {
                            onThemeSwitchListener.onSwitchTheme(i);
                        }
                    }
                });
            }
        };

        public ThemeWatcherDelegate(Object obj, Class<?> cls) {
            this.mTarget = obj;
            this.mTargetCls = cls;
        }

        private void hookThemeSwitchEvent() {
            try {
                Class<?> cls = Class.forName("com.xiaopeng.lib.themeswitch.ThemeWatcher$OnThemeSwitchListener");
                Object newProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.xiaopeng.xui.theme.ThemeWatcherWrapper.ThemeWatcherDelegate.2
                    @Override // java.lang.reflect.InvocationHandler
                    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                        if (method.getDeclaringClass() == Object.class) {
                            return method.invoke(ThemeWatcherDelegate.this.mDefaultThemeSwitchListener, objArr);
                        }
                        if ("onSwitchTheme".equals(method.getName())) {
                            ThemeWatcherDelegate.this.mDefaultThemeSwitchListener.onSwitchTheme(((Integer) objArr[0]).intValue());
                            return null;
                        }
                        return null;
                    }
                });
                this.mDefaultThemeSwitchHooker = newProxyInstance;
                invoke("addThemeSwitchListener", new Class[]{cls}, new Object[]{newProxyInstance});
            } catch (ClassNotFoundException unused) {
            }
        }

        private Object invoke(String str, Class[] clsArr, Object[] objArr) {
            try {
                return this.mTargetCls.getDeclaredMethod(str, clsArr).invoke(this.mTarget, objArr);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }

        private void unbindThemeSwitchHook() {
            try {
                if (this.mDefaultThemeSwitchHooker != null) {
                    invoke("removeThemeSwitchListener", new Class[]{Class.forName("com.xiaopeng.lib.themeswitch.ThemeWatcher$OnThemeSwitchListener")}, new Object[]{this.mDefaultThemeSwitchHooker});
                }
            } catch (ClassNotFoundException unused) {
            }
        }

        @Override // com.xiaopeng.xui.theme.ThemeWatcherWrapper.IThemeWatcher
        public void addThemeSwitchListener(ThemeWatcher.OnThemeSwitchListener onThemeSwitchListener) {
            if (onThemeSwitchListener == null || this.mListeners.contains(onThemeSwitchListener)) {
                return;
            }
            this.mListeners.add(onThemeSwitchListener);
        }

        @Override // com.xiaopeng.xui.theme.ThemeWatcherWrapper.IThemeWatcher
        public void clear() {
            this.mListeners.clear();
        }

        @Override // com.xiaopeng.xui.theme.ThemeWatcherWrapper.IThemeWatcher
        public void init(Context context, int... iArr) {
            invoke("init", new Class[]{Context.class, int[].class}, new Object[]{context, iArr});
            hookThemeSwitchEvent();
        }

        @Override // com.xiaopeng.xui.theme.ThemeWatcherWrapper.IThemeWatcher
        public boolean isNight() {
            if (this.mThemeType == 0) {
                this.mThemeType = ((Integer) invoke("getCurrentTheme")).intValue();
            }
            return this.mThemeType == 2;
        }

        @Override // com.xiaopeng.xui.theme.ThemeWatcherWrapper.IThemeWatcher
        public String newThemeNameForRepeatView(String str) {
            return (String) invoke("newThemeNameForRepeatView", new Class[]{String.class}, new Object[]{str});
        }

        @Override // com.xiaopeng.xui.theme.ThemeWatcherWrapper.IThemeWatcher
        public void register(View view, String str) {
            invoke("register", new Class[]{View.class, String.class}, new Object[]{view, str});
        }

        @Override // com.xiaopeng.xui.theme.ThemeWatcherWrapper.IThemeWatcher
        public void release() {
            unbindThemeSwitchHook();
            invoke("release");
            clear();
        }

        @Override // com.xiaopeng.xui.theme.ThemeWatcherWrapper.IThemeWatcher
        public void removeThemeListener(ThemeWatcher.OnThemeSwitchListener onThemeSwitchListener) {
            if (onThemeSwitchListener == null) {
                return;
            }
            this.mListeners.remove(onThemeSwitchListener);
        }

        @Override // com.xiaopeng.xui.theme.ThemeWatcherWrapper.IThemeWatcher
        public void unregister(String str) {
            invoke("unregister", new Class[]{String.class}, new Object[]{str});
        }

        private Object invoke(String str) {
            try {
                return this.mTargetCls.getDeclaredMethod(str, new Class[0]).invoke(this.mTarget, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }
    }
}
