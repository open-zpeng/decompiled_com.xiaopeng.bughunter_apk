package defpackage;

import android.content.Intent;
import android.util.Log;
/* compiled from: IntentUtils.java */
/* renamed from: de  reason: default package */
/* loaded from: classes.dex */
public class de {
    public static Intent a(String str) {
        try {
            return Intent.parseUri(str, 1);
        } catch (Exception e) {
            Log.e("IntentUtils", "parse:" + str, e);
            return null;
        }
    }
}
