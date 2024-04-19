package defpackage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* compiled from: UTUtil.java */
/* renamed from: r9  reason: default package */
/* loaded from: classes.dex */
public class r9 {
    public static void a(u8 u8Var) {
        if (u8Var == null) {
            return;
        }
        ea.d(u8Var.b, String.valueOf(u8Var.c), u8Var.d, u8Var.e, u8Var.f, u8Var.g);
        y8.a().d(u8Var);
    }

    public static void b(da daVar, q8 q8Var) {
        Integer k = daVar.k();
        if (k != null) {
            s8 a = s8.a(k.intValue());
            u8 u8Var = (u8) y8.a().b(u8.class, new Object[0]);
            u8Var.c = 6699;
            if (daVar.g() != null) {
                u8Var.g.putAll(daVar.g());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("meta", j8.a());
            hashMap.put("_event_id", k);
            b9 b9Var = (b9) y8.a().b(b9.class, new Object[0]);
            b9Var.put(q8Var.c());
            y8.a().d(q8Var);
            hashMap.put("data", b9Var);
            u8Var.g.put(a.m110a(), new JSONObject(hashMap).toString());
            u8Var.g.put(pb.EVENTID.toString(), String.valueOf(6699));
            c(u8Var);
            y8.a().d(b9Var);
        }
    }

    public static void c(u8 u8Var) {
        ya.c("UTUtil", "upload without flowback. args:", u8Var.g);
        o9.a().b(u8Var.g);
        y8.a().d(u8Var);
    }

    public static void d(Map<da, List<q8>> map) {
        Integer k;
        for (Map.Entry<da, List<q8>> entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            da key = entry.getKey();
            List<q8> value = entry.getValue();
            if (value.size() != 0 && (k = key.k()) != null) {
                s8 a = s8.a(k.intValue());
                int i = 0;
                u8 u8Var = (u8) y8.a().b(u8.class, new Object[0]);
                u8Var.c = k.intValue();
                if (key.g() != null) {
                    u8Var.g.putAll(key.g());
                }
                HashMap hashMap = new HashMap();
                hashMap.put("meta", j8.a());
                b9 b9Var = (b9) y8.a().b(b9.class, new Object[0]);
                for (q8 q8Var : value) {
                    b9Var.put(q8Var.c());
                    if (i == 0) {
                        sb.append(q8Var.b);
                        sb2.append(q8Var.c);
                    } else {
                        sb.append(",");
                        sb.append(q8Var.b);
                        sb2.append(",");
                        sb2.append(q8Var.c);
                    }
                    i++;
                    y8.a().d(q8Var);
                }
                hashMap.put("data", b9Var);
                u8Var.g.put(a.m110a(), new JSONObject(hashMap).toString());
                String sb3 = sb.toString();
                String sb4 = sb2.toString();
                u8Var.g.put(pb.ARG1.toString(), sb3);
                u8Var.g.put(pb.ARG2.toString(), sb4);
                u8Var.d = sb3;
                u8Var.e = sb4;
                c(u8Var);
                y8.a().d(b9Var);
            }
            y8.a().d(key);
        }
    }
}
