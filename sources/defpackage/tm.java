package defpackage;

import java.util.Enumeration;
import java.util.Hashtable;
/* compiled from: MemoryPersistence.java */
/* renamed from: tm  reason: default package */
/* loaded from: classes.dex */
public class tm implements gk {
    private Hashtable a;

    @Override // defpackage.gk
    public void clear() throws mk {
        this.a.clear();
    }

    @Override // defpackage.gk
    public void close() throws mk {
        this.a.clear();
    }

    @Override // defpackage.gk
    public boolean containsKey(String str) throws mk {
        return this.a.containsKey(str);
    }

    @Override // defpackage.gk
    public lk get(String str) throws mk {
        return (lk) this.a.get(str);
    }

    @Override // defpackage.gk
    public Enumeration keys() throws mk {
        return this.a.keys();
    }

    @Override // defpackage.gk
    public void open(String str, String str2) throws mk {
        this.a = new Hashtable();
    }

    @Override // defpackage.gk
    public void put(String str, lk lkVar) throws mk {
        this.a.put(str, lkVar);
    }

    @Override // defpackage.gk
    public void remove(String str) throws mk {
        this.a.remove(str);
    }
}
