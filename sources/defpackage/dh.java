package defpackage;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
/* compiled from: CompositeException.java */
/* renamed from: dh  reason: default package */
/* loaded from: classes.dex */
public final class dh extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private final List<Throwable> b;
    private final String c;
    private Throwable d;

    /* compiled from: CompositeException.java */
    /* renamed from: dh$a */
    /* loaded from: classes.dex */
    static final class a extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        a() {
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompositeException.java */
    /* renamed from: dh$b */
    /* loaded from: classes.dex */
    public static abstract class b {
        b() {
        }

        abstract void a(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompositeException.java */
    /* renamed from: dh$c */
    /* loaded from: classes.dex */
    public static final class c extends b {
        private final PrintStream a;

        c(PrintStream printStream) {
            this.a = printStream;
        }

        @Override // defpackage.dh.b
        void a(Object obj) {
            this.a.println(obj);
        }
    }

    /* compiled from: CompositeException.java */
    /* renamed from: dh$d */
    /* loaded from: classes.dex */
    static final class d extends b {
        private final PrintWriter a;

        d(PrintWriter printWriter) {
            this.a = printWriter;
        }

        @Override // defpackage.dh.b
        void a(Object obj) {
            this.a.println(obj);
        }
    }

    public dh(Throwable... thArr) {
        this(thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    private void a(StringBuilder sb, Throwable th, String str) {
        StackTraceElement[] stackTrace;
        sb.append(str);
        sb.append(th);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            a(sb, th.getCause(), "");
        }
    }

    private List<Throwable> c(Throwable th) {
        ArrayList arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause != null && cause != th) {
            while (true) {
                arrayList.add(cause);
                Throwable cause2 = cause.getCause();
                if (cause2 == null || cause2 == cause) {
                    break;
                }
                cause = cause2;
            }
        }
        return arrayList;
    }

    private void e(b bVar) {
        StackTraceElement[] stackTrace;
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        int i = 1;
        for (Throwable th : this.b) {
            sb.append("  ComposedException ");
            sb.append(i);
            sb.append(" :\n");
            a(sb, th, "\t");
            i++;
        }
        bVar.a(sb.toString());
    }

    public List<Throwable> b() {
        return this.b;
    }

    Throwable d(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null || this.d == cause) {
            return th;
        }
        while (true) {
            Throwable cause2 = cause.getCause();
            if (cause2 == null || cause2 == cause) {
                break;
            }
            cause = cause2;
        }
        return cause;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        if (this.d == null) {
            a aVar = new a();
            HashSet hashSet = new HashSet();
            Iterator<Throwable> it = this.b.iterator();
            a aVar2 = aVar;
            while (it.hasNext()) {
                Throwable next = it.next();
                if (!hashSet.contains(next)) {
                    hashSet.add(next);
                    for (Throwable th : c(next)) {
                        if (hashSet.contains(th)) {
                            next = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            hashSet.add(th);
                        }
                    }
                    try {
                        aVar2.initCause(next);
                    } catch (Throwable unused) {
                    }
                    aVar2 = d(aVar2);
                }
            }
            this.d = aVar;
        }
        return this.d;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.c;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        e(new c(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        e(new d(printWriter));
    }

    public dh(Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof dh) {
                    linkedHashSet.addAll(((dh) th).b());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            arrayList.addAll(linkedHashSet);
            List<Throwable> unmodifiableList = Collections.unmodifiableList(arrayList);
            this.b = unmodifiableList;
            this.c = unmodifiableList.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }
}
