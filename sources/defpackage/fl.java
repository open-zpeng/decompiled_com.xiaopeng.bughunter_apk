package defpackage;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
/* compiled from: ResourceBundleCatalog.java */
/* renamed from: fl  reason: default package */
/* loaded from: classes.dex */
public class fl extends cl {
    private ResourceBundle b = ResourceBundle.getBundle("org.eclipse.paho.client.mqttv3.internal.nls.messages");

    @Override // defpackage.cl
    protected String a(int i) {
        try {
            return this.b.getString(Integer.toString(i));
        } catch (MissingResourceException unused) {
            return "MqttException";
        }
    }
}
