package defpackage;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* compiled from: LogAssemble.java */
/* renamed from: xa  reason: default package */
/* loaded from: classes.dex */
public class xa {
    public static String a(String str, String str2, String str3, String str4, String str5, Map<String, String> map, String str6, String str7) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(pb.PAGE.toString(), str);
        }
        hashMap.put(pb.EVENTID.toString(), str2);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(pb.ARG1.toString(), str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put(pb.ARG2.toString(), str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put(pb.ARG3.toString(), str5);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put(pb.RECORD_TIMESTAMP.toString(), str7);
        }
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put(pb.RESERVE3.toString(), str6);
        }
        return e(hashMap);
    }

    public static String b(Map<String, String> map) {
        boolean z;
        pb pbVar;
        StringBuilder sb = new StringBuilder();
        pb[] values = pb.values();
        int length = values.length;
        int i = 0;
        while (true) {
            String str = null;
            if (i >= length || (pbVar = values[i]) == pb.ARGS) {
                break;
            }
            if (map.containsKey(pbVar.toString())) {
                str = map.get(pbVar.toString()) + "";
                map.remove(pbVar.toString());
            }
            sb.append(d(str));
            sb.append("||");
            i++;
        }
        pb pbVar2 = pb.ARGS;
        if (map.containsKey(pbVar2.toString())) {
            sb.append(d(map.get(pbVar2.toString()) + ""));
            map.remove(pbVar2.toString());
            z = false;
        } else {
            z = true;
        }
        for (String str2 : map.keySet()) {
            String str3 = map.containsKey(str2) ? map.get(str2) + "" : null;
            if (z) {
                if ("StackTrace".equals(str2)) {
                    sb.append("StackTrace=====>");
                    sb.append(str3);
                } else {
                    sb.append(d(str2));
                    sb.append("=");
                    sb.append(str3);
                }
                z = false;
            } else if ("StackTrace".equals(str2)) {
                sb.append(",");
                sb.append("StackTrace=====>");
                sb.append(str3);
            } else {
                sb.append(",");
                sb.append(d(str2));
                sb.append("=");
                sb.append(str3);
            }
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2) || !sb2.endsWith("||")) {
            return sb2;
        }
        return sb2 + "-";
    }

    public static Map<String, String> c(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        try {
            String g = ra.g();
            if (!TextUtils.isEmpty(g)) {
                pb pbVar = pb.USERNICK;
                if (!map.containsKey(pbVar.toString())) {
                    map.put(pbVar.toString(), g);
                }
            }
            String d = ra.d();
            if (!TextUtils.isEmpty(d)) {
                pb pbVar2 = pb.LL_USERNICK;
                if (!map.containsKey(pbVar2.toString())) {
                    map.put(pbVar2.toString(), d);
                }
            }
            String h = ra.h();
            if (!TextUtils.isEmpty(h)) {
                pb pbVar3 = pb.USERID;
                if (!map.containsKey(pbVar3.toString())) {
                    map.put(pbVar3.toString(), h);
                }
            }
            String e = ra.e();
            if (!TextUtils.isEmpty(e)) {
                pb pbVar4 = pb.LL_USERID;
                if (!map.containsKey(pbVar4.toString())) {
                    map.put(pbVar4.toString(), e);
                }
            }
            String valueOf = String.valueOf(System.currentTimeMillis());
            pb pbVar5 = pb.RECORD_TIMESTAMP;
            if (!map.containsKey(pbVar5.toString())) {
                map.put(pbVar5.toString(), valueOf);
            }
            pb pbVar6 = pb.START_SESSION_TIMESTAMP;
            if (!map.containsKey(pbVar6.toString())) {
                map.put(pbVar6.toString(), String.valueOf(ea.e));
            }
            Map<String, String> a = ta.a(ea.j());
            if (a != null) {
                for (String str : a.keySet()) {
                    String str2 = a.get(str);
                    if (!TextUtils.isEmpty(str2) && !map.containsKey(str) && !map.containsKey(str)) {
                        map.put(str, str2);
                    }
                }
            }
            String f = f(map);
            if (!TextUtils.isEmpty(f)) {
                pb pbVar7 = pb.RESERVES;
                if (!map.containsKey(pbVar7.toString())) {
                    map.put(pbVar7.toString(), f);
                }
            }
        } catch (Throwable unused) {
        }
        return map;
    }

    private static String d(String str) {
        return TextUtils.isEmpty(str) ? "-" : str;
    }

    public static String e(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        c(map);
        return b(map);
    }

    private static String f(Map<String, String> map) {
        String str = "_ap=1";
        if ("y".equalsIgnoreCase(map.get(pb.OS.toString()))) {
            String j = ta.j();
            if (!TextUtils.isEmpty(j)) {
                str = "_ap=1,_did=" + j;
            }
        }
        String str2 = map.get(pb.APPKEY.toString());
        if (TextUtils.isEmpty(ra.c()) || TextUtils.isEmpty(str2) || ra.c().equalsIgnoreCase(str2)) {
            return str;
        }
        return str + ",_mak=" + ra.c();
    }
}
