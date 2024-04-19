package defpackage;

import java.util.Map;
/* compiled from: UTAggregationPlugin.java */
/* renamed from: o9  reason: default package */
/* loaded from: classes.dex */
public class o9 {
    private static final String a = null;
    private static o9 b;

    private o9() {
    }

    public static synchronized o9 a() {
        o9 o9Var;
        synchronized (o9.class) {
            if (b == null) {
                b = new o9();
            }
            o9Var = b;
        }
        return o9Var;
    }

    public void b(Map<String, String> map) {
        if (map == null) {
            return;
        }
        ya.c(a, "[sendToUT]:", " args:", map);
        if (ea.g) {
            ea.d(map.get(pb.PAGE.toString()), map.get(pb.EVENTID.toString()), map.get(pb.ARG1.toString()), map.get(pb.ARG2.toString()), map.get(pb.ARG3.toString()), map);
            return;
        }
        map.put("_fuamf", "yes");
        jb.a(map);
    }
}
