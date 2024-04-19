package defpackage;
/* compiled from: MqttCallback.java */
/* renamed from: ek  reason: default package */
/* loaded from: classes.dex */
public interface ek {
    void connectionLost(Throwable th);

    void deliveryComplete(ak akVar);

    void messageArrived(String str, kk kkVar) throws Exception;
}
