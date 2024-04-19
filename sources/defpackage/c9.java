package defpackage;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ReuseJSONObject.java */
/* renamed from: c9  reason: default package */
/* loaded from: classes.dex */
public class c9 extends JSONObject implements z8 {
    @Override // defpackage.z8
    public void a() {
        Iterator<String> keys = keys();
        if (keys != null) {
            while (keys.hasNext()) {
                try {
                    Object obj = get(keys.next());
                    if (obj != null && (obj instanceof z8)) {
                        y8.a().d((z8) obj);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // defpackage.z8
    public void b(Object... objArr) {
    }
}
