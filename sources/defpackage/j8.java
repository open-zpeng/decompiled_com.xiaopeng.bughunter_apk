package defpackage;

import java.util.HashMap;
import java.util.Map;
/* compiled from: SdkMeta.java */
/* renamed from: j8  reason: default package */
/* loaded from: classes.dex */
public class j8 {
    private static final Map<String, String> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("sdk-version", "2.6.4.10_for_bc");
    }

    public static Map<String, String> a() {
        ea.j();
        Map<String, String> map = a;
        if (!map.containsKey("sdk-version")) {
            map.put("sdk-version", "2.6.4.10_for_bc");
        }
        return map;
    }
}
