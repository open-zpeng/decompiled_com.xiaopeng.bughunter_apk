package defpackage;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ApiResponseParse.java */
/* renamed from: qa  reason: default package */
/* loaded from: classes.dex */
public class qa {

    /* compiled from: ApiResponseParse.java */
    /* renamed from: qa$a */
    /* loaded from: classes.dex */
    public static class a {
        public static a a = new a();
        public boolean b = false;
        public String c = null;

        public boolean a() {
            return "E0102".equalsIgnoreCase(this.c);
        }

        public boolean b() {
            return "E0111".equalsIgnoreCase(this.c) || "E0112".equalsIgnoreCase(this.c);
        }
    }

    public static a a(String str) {
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("success")) {
                String string = jSONObject.getString("success");
                if (!TextUtils.isEmpty(string) && string.equals("success")) {
                    aVar.b = true;
                }
            }
            if (jSONObject.has("ret")) {
                aVar.c = jSONObject.getString("ret");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return aVar;
    }
}
