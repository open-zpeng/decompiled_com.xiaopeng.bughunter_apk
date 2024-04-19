package defpackage;

import java.util.ArrayList;
import java.util.List;
/* compiled from: PendingPost.java */
/* renamed from: in  reason: default package */
/* loaded from: classes.dex */
final class in {
    private static final List<in> a = new ArrayList();
    Object b;
    pn c;
    in d;

    private in(Object obj, pn pnVar) {
        this.b = obj;
        this.c = pnVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static in a(pn pnVar, Object obj) {
        List<in> list = a;
        synchronized (list) {
            int size = list.size();
            if (size > 0) {
                in remove = list.remove(size - 1);
                remove.b = obj;
                remove.c = pnVar;
                remove.d = null;
                return remove;
            }
            return new in(obj, pnVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(in inVar) {
        inVar.b = null;
        inVar.c = null;
        inVar.d = null;
        List<in> list = a;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(inVar);
            }
        }
    }
}
