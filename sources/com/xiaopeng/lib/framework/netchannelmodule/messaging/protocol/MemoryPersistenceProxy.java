package com.xiaopeng.lib.framework.netchannelmodule.messaging.protocol;

import android.util.Pair;
import java.util.Enumeration;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class MemoryPersistenceProxy implements gk {
    private static final int MAX_MESSAGE_NUMBER = 200;
    private static final String TAG = "MemoryPersistenceProxy";
    protected String mClientId;
    protected Hashtable<String, Pair<lk, Long>> mHashTable = new Hashtable<>();
    protected String mServerURI;
    protected boolean mTraceEnabled;

    public MemoryPersistenceProxy() {
        log("new MemoryPersistenceProxy");
    }

    private void checkOpen() throws mk {
        if (this.mHashTable == null) {
            throw new mk();
        }
    }

    private void log(String str) {
        if (gg.g() && this.mTraceEnabled) {
            tf.a(TAG, str);
        }
    }

    @Override // defpackage.gk
    public void clear() throws mk {
        checkOpen();
        log("clear");
        this.mHashTable.clear();
    }

    @Override // defpackage.gk
    public void close() throws mk {
        log("close()");
    }

    @Override // defpackage.gk
    public boolean containsKey(String str) throws mk {
        checkOpen();
        boolean containsKey = this.mHashTable.containsKey(str);
        log("containsKey key:" + str + " result:" + containsKey);
        return containsKey;
    }

    @Override // defpackage.gk
    public lk get(String str) throws mk {
        checkOpen();
        lk lkVar = (lk) this.mHashTable.get(str).first;
        log("get key:" + str + " result:" + lkVar);
        return lkVar;
    }

    @Override // defpackage.gk
    public Enumeration keys() throws mk {
        checkOpen();
        Enumeration<String> keys = this.mHashTable.keys();
        log("keys():" + keys + " hasMoreElements:" + keys.hasMoreElements());
        return keys;
    }

    @Override // defpackage.gk
    public void open(String str, String str2) throws mk {
        log("open clientId:" + str + " serverURI:" + str2);
        if (str != null && str2 != null) {
            if (str.equals(this.mClientId) && str2.equals(this.mServerURI)) {
                log("same config, return!");
                return;
            }
            Hashtable<String, Pair<lk, Long>> hashtable = this.mHashTable;
            if (hashtable != null) {
                hashtable.clear();
            }
            this.mClientId = str;
            this.mServerURI = str2;
            this.mHashTable = new Hashtable<>();
            return;
        }
        throw new IllegalArgumentException("clientId or serverURI can't be null");
    }

    @Override // defpackage.gk
    public void put(String str, lk lkVar) throws mk {
        checkOpen();
        log("put key:" + str + " persistable:" + lkVar + " size:" + this.mHashTable.size());
        if (this.mHashTable.size() >= 200) {
            this.mHashTable.clear();
            log("exceed max persist count");
        }
        this.mHashTable.put(str, new Pair<>(lkVar, Long.valueOf(System.currentTimeMillis())));
    }

    @Override // defpackage.gk
    public void remove(String str) throws mk {
        checkOpen();
        log("remove key:" + str);
        this.mHashTable.remove(str);
    }

    public void setTraceEnabled(boolean z) {
        this.mTraceEnabled = z;
    }
}
