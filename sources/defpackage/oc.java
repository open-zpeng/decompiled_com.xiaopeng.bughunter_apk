package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import com.irdeto.securesdk.core.SSUtils;
import java.util.List;
/* compiled from: CacheManager.java */
/* renamed from: oc  reason: default package */
/* loaded from: classes.dex */
public class oc extends nc<zb<?>> {

    /* compiled from: CacheManager.java */
    /* renamed from: oc$b */
    /* loaded from: classes.dex */
    private static class b {
        private static final oc a = new oc();
    }

    public static oc l() {
        return b.a;
    }

    @Override // defpackage.nc
    public String d() {
        return SSUtils.O00000o0;
    }

    public zb<?> j(String str) {
        if (str == null) {
            return null;
        }
        List<zb<?>> g = g("key=?", new String[]{str});
        if (g.size() > 0) {
            return g.get(0);
        }
        return null;
    }

    @Override // defpackage.nc
    /* renamed from: k */
    public ContentValues c(zb<?> zbVar) {
        return zb.b(zbVar);
    }

    @Override // defpackage.nc
    /* renamed from: m */
    public zb<?> f(Cursor cursor) {
        return zb.h(cursor);
    }

    public boolean n(String str) {
        if (str == null) {
            return false;
        }
        return b("key=?", new String[]{str});
    }

    public <T> zb<T> o(String str, zb<T> zbVar) {
        zbVar.k(str);
        i(zbVar);
        return zbVar;
    }

    private oc() {
        super(new qc());
    }
}
