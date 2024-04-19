package defpackage;

import java.util.prefs.AbstractPreferences;
import java.util.prefs.BackingStoreException;
/* compiled from: Base64.java */
/* renamed from: ll  reason: default package */
/* loaded from: classes.dex */
public class ll {
    private static final ll a;
    private static final a b;

    /* compiled from: Base64.java */
    /* renamed from: ll$a */
    /* loaded from: classes.dex */
    public class a extends AbstractPreferences {
        private String a;

        public a() {
            super(null, "");
            this.a = null;
        }

        public String a() {
            return this.a;
        }

        @Override // java.util.prefs.AbstractPreferences
        protected AbstractPreferences childSpi(String str) {
            return null;
        }

        @Override // java.util.prefs.AbstractPreferences
        protected String[] childrenNamesSpi() throws BackingStoreException {
            return null;
        }

        @Override // java.util.prefs.AbstractPreferences
        protected void flushSpi() throws BackingStoreException {
        }

        @Override // java.util.prefs.AbstractPreferences
        protected String getSpi(String str) {
            return null;
        }

        @Override // java.util.prefs.AbstractPreferences
        protected String[] keysSpi() throws BackingStoreException {
            return null;
        }

        @Override // java.util.prefs.AbstractPreferences
        protected void putSpi(String str, String str2) {
            this.a = str2;
        }

        @Override // java.util.prefs.AbstractPreferences
        protected void removeNodeSpi() throws BackingStoreException {
        }

        @Override // java.util.prefs.AbstractPreferences
        protected void removeSpi(String str) {
        }

        @Override // java.util.prefs.AbstractPreferences
        protected void syncSpi() throws BackingStoreException {
        }
    }

    static {
        ll llVar = new ll();
        a = llVar;
        b = new a();
    }

    public static String a(String str) {
        a aVar = b;
        aVar.putByteArray("akey", str.getBytes());
        return aVar.a();
    }

    public static String b(byte[] bArr) {
        a aVar = b;
        aVar.putByteArray("aKey", bArr);
        return aVar.a();
    }
}
