package defpackage;
/* compiled from: MessageCatalog.java */
/* renamed from: cl  reason: default package */
/* loaded from: classes.dex */
public abstract class cl {
    private static cl a;

    public static final String b(int i) {
        if (a == null) {
            if (zk.c("java.util.ResourceBundle")) {
                try {
                    a = (cl) Class.forName("fl").newInstance();
                } catch (Exception unused) {
                    return "";
                }
            } else if (zk.c("org.eclipse.paho.client.mqttv3.internal.MIDPCatalog")) {
                try {
                    a = (cl) Class.forName("org.eclipse.paho.client.mqttv3.internal.MIDPCatalog").newInstance();
                } catch (Exception unused2) {
                    return "";
                }
            }
        }
        return a.a(i);
    }

    protected abstract String a(int i);
}
