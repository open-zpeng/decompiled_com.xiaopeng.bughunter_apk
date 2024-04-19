package defpackage;

import android.content.Context;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounterFactory;
/* compiled from: CounterFactory.java */
/* renamed from: we  reason: default package */
/* loaded from: classes.dex */
public class we implements ICounterFactory {

    /* compiled from: CounterFactory.java */
    /* renamed from: we$b */
    /* loaded from: classes.dex */
    private static final class b {
        private static final we a = new we();
    }

    public static we a() {
        return b.a;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounterFactory
    public ICounter createDailyCounter(Context context, String str) {
        return new xe(context, str, 86400000L);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounterFactory
    public ICounter createHourlyCounter(Context context, String str) {
        return new xe(context, str, 3600000L);
    }

    private we() {
    }
}
