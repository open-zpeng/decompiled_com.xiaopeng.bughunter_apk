package defpackage;

import java.util.Enumeration;
/* compiled from: MqttClientPersistence.java */
/* renamed from: gk  reason: default package */
/* loaded from: classes.dex */
public interface gk {
    void clear() throws mk;

    void close() throws mk;

    boolean containsKey(String str) throws mk;

    lk get(String str) throws mk;

    Enumeration keys() throws mk;

    void open(String str, String str2) throws mk;

    void put(String str, lk lkVar) throws mk;

    void remove(String str) throws mk;
}
