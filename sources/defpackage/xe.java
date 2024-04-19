package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: CounterImpl.java */
/* renamed from: xe  reason: default package */
/* loaded from: classes.dex */
public class xe implements ICounter, Handler.Callback {
    private final String b;
    private final long c;
    private final Map<String, AtomicInteger> d;
    private boolean e;
    private AtomicLong f;
    private Handler g;
    private final SharedPreferences h;
    private final SharedPreferences.Editor i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CounterImpl.java */
    /* renamed from: xe$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ Map b;
        final /* synthetic */ long c;

        a(Map map, long j) {
            this.b = map;
            this.c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            tf.l("CounterImpl", "[" + xe.this.b + " counter] send count event, name:" + xe.this.b + " values:" + this.b);
            IDataLog iDataLog = (IDataLog) Module.get(se.class).get(IDataLog.class);
            IMoleEventBuilder event = iDataLog.buildMoleEvent().setPageId("P00012").setButtonId("B001").setEvent(xe.this.b);
            for (String str : this.b.keySet()) {
                event.setProperty(str, (Number) this.b.get(str));
            }
            event.setProperty("time", Long.valueOf(this.c));
            IMoleEvent build = event.build();
            tf.a("CounterImpl", "start sendStatData:" + build.toJson());
            iDataLog.sendStatData(build);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public xe(Context context, String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            this.b = str;
            this.c = j;
            this.d = new HashMap();
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            this.h = defaultSharedPreferences;
            this.i = defaultSharedPreferences.edit();
            this.f = new AtomicLong(defaultSharedPreferences.getLong(c("time"), System.currentTimeMillis()));
            this.g = new Handler(ag.g(0), this);
            d();
            e(false);
            return;
        }
        throw new IllegalArgumentException("name can't be empty!");
    }

    private String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.b + "_";
        if (str.startsWith(str2)) {
            return str.substring(str2.length());
        }
        return null;
    }

    private String c(String str) {
        return this.b + "_" + str;
    }

    private void d() {
        Map<String, ?> all = this.h.getAll();
        tf.a("CounterImpl", "initValuesFromPref prefMap:" + all);
        for (String str : all.keySet()) {
            String b = b(str);
            if (!TextUtils.isEmpty(b) && !b.equals("time")) {
                Object obj = all.get(str);
                if (obj instanceof Integer) {
                    tf.a("CounterImpl", "initValuesFromPref key:" + b + " value:" + obj);
                    this.d.put(b, new AtomicInteger(((Integer) obj).intValue()));
                }
            }
        }
    }

    private void e(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f.get();
        long j2 = this.c;
        if (j / j2 < currentTimeMillis / j2 || z) {
            HashMap hashMap = new HashMap();
            for (String str : this.d.keySet()) {
                AtomicInteger atomicInteger = this.d.get(str);
                hashMap.put(str, Integer.valueOf(atomicInteger.get()));
                atomicInteger.set(0);
                this.i.putInt(c(str), 0);
            }
            ag.h(2, new a(hashMap, j));
            if (!this.g.hasMessages(1)) {
                this.g.sendEmptyMessageDelayed(1, 10000L);
            }
        }
        this.f.set(currentTimeMillis);
        this.i.putLong(c("time"), currentTimeMillis);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter
    public synchronized int count(String str) {
        return count(str, 1);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter
    public void debug(boolean z) {
        this.e = z;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            if (this.e) {
                tf.a("CounterImpl", "mEditor.apply()");
            }
            this.i.apply();
        }
        return true;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter
    public synchronized int count(String str, int i) {
        int i2;
        int i3;
        AtomicInteger atomicInteger = this.d.get(str);
        String c = c(str);
        if (atomicInteger == null) {
            try {
                i2 = this.h.getInt(c, 0);
            } catch (ClassCastException e) {
                tf.t("CounterImpl", "mPreferences.getInt(" + c + ") error!", e);
                i2 = 0;
            }
            if (this.e) {
                tf.r("CounterImpl", "count " + this.b + ", load key:" + c + " from pref, value is " + i2);
            }
            AtomicInteger atomicInteger2 = new AtomicInteger(i2);
            this.d.put(str, atomicInteger2);
            atomicInteger = atomicInteger2;
        }
        i3 = atomicInteger.get() + i;
        atomicInteger.set(i3);
        this.i.putInt(c, i3);
        if (this.e) {
            tf.r("CounterImpl", "count " + this.b + " " + str + ":" + i3 + ", cache is:" + this.d);
        }
        if (!this.g.hasMessages(1)) {
            this.g.sendEmptyMessageDelayed(1, 10000L);
        }
        e(i3 == Integer.MAX_VALUE);
        return i3;
    }
}
