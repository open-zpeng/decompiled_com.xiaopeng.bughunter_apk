package defpackage;

import android.content.Context;
import android.os.SystemClock;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: MoleEvent.java */
/* renamed from: ue  reason: default package */
/* loaded from: classes.dex */
public class ue implements IMoleEvent {
    private Map<String, Object> a;

    /* compiled from: MoleEvent.java */
    /* renamed from: ue$a */
    /* loaded from: classes.dex */
    class a extends TypeToken<Map<String, Object>> {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ue(Context context) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.a = concurrentHashMap;
        concurrentHashMap.put(IStatEvent.CUSTOM_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        this.a.put(IStatEvent.CUSTOM_MODULE_VERSION, ve.d(context));
        this.a.put(IStatEvent.CUSTOM_NETWORK, ve.c(context));
        this.a.put(IStatEvent.CUSTOM_STARTUP, Long.valueOf(SystemClock.uptimeMillis() / 1000));
        this.a.put(IStatEvent.CUSTOM_DEVICE_MCUVER, ve.a());
        this.a.put(IStatEvent.CUSTOM_UID, Long.valueOf(yf.a()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.a.containsKey("page_id")) {
            if (this.a.containsKey("button_id")) {
                if (!this.a.containsKey(IStatEvent.CUSTOM_MODULE)) {
                    throw new IllegalArgumentException("Please call setModule() first");
                }
                return;
            }
            throw new IllegalArgumentException("Please call setButtonId() first");
        }
        throw new IllegalArgumentException("Please call setPageId() first");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, Boolean bool) {
        if (str == null || bool == null) {
            return;
        }
        this.a.put(str, bool);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, Character ch) {
        if (str == null || ch == null) {
            return;
        }
        this.a.put(str, ch);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str, Number number) {
        if (str == null || number == null) {
            return;
        }
        this.a.put(str, number);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.a.put(str, str2);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent
    public String toJson() {
        return ze.b().a().toJson(this.a, new a().getType());
    }
}
