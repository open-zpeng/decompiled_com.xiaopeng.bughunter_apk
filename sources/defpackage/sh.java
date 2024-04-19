package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: DisposableHelper.java */
/* renamed from: sh  reason: default package */
/* loaded from: classes.dex */
public enum sh implements zg {
    DISPOSED;

    public static boolean dispose(AtomicReference<zg> atomicReference) {
        zg andSet;
        zg zgVar = atomicReference.get();
        sh shVar = DISPOSED;
        if (zgVar == shVar || (andSet = atomicReference.getAndSet(shVar)) == shVar) {
            return false;
        }
        if (andSet != null) {
            andSet.dispose();
            return true;
        }
        return true;
    }

    public static boolean isDisposed(zg zgVar) {
        return zgVar == DISPOSED;
    }

    public static boolean replace(AtomicReference<zg> atomicReference, zg zgVar) {
        zg zgVar2;
        do {
            zgVar2 = atomicReference.get();
            if (zgVar2 == DISPOSED) {
                if (zgVar != null) {
                    zgVar.dispose();
                    return false;
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(zgVar2, zgVar));
        return true;
    }

    public static void reportDisposableSet() {
        uj.m(new gh("Disposable already set!"));
    }

    public static boolean set(AtomicReference<zg> atomicReference, zg zgVar) {
        zg zgVar2;
        do {
            zgVar2 = atomicReference.get();
            if (zgVar2 == DISPOSED) {
                if (zgVar != null) {
                    zgVar.dispose();
                    return false;
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(zgVar2, zgVar));
        if (zgVar2 != null) {
            zgVar2.dispose();
            return true;
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<zg> atomicReference, zg zgVar) {
        xh.d(zgVar, "d is null");
        if (atomicReference.compareAndSet(null, zgVar)) {
            return true;
        }
        zgVar.dispose();
        if (atomicReference.get() != DISPOSED) {
            reportDisposableSet();
            return false;
        }
        return false;
    }

    public static boolean trySet(AtomicReference<zg> atomicReference, zg zgVar) {
        if (atomicReference.compareAndSet(null, zgVar)) {
            return true;
        }
        if (atomicReference.get() == DISPOSED) {
            zgVar.dispose();
            return false;
        }
        return false;
    }

    public static boolean validate(zg zgVar, zg zgVar2) {
        if (zgVar2 == null) {
            uj.m(new NullPointerException("next is null"));
            return false;
        } else if (zgVar != null) {
            zgVar2.dispose();
            reportDisposableSet();
            return false;
        } else {
            return true;
        }
    }

    @Override // defpackage.zg
    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }
}
