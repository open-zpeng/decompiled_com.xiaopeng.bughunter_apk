package defpackage;

import android.util.Log;
import java.io.PrintStream;
import java.util.logging.Level;
import org.apache.commons.io.IOUtils;
/* compiled from: Logger.java */
/* renamed from: fn  reason: default package */
/* loaded from: classes.dex */
public interface fn {

    /* compiled from: Logger.java */
    /* renamed from: fn$a */
    /* loaded from: classes.dex */
    public static class a implements fn {
        static final boolean a;
        private final String b;

        static {
            boolean z;
            try {
                Class.forName("android.util.Log");
                z = true;
            } catch (ClassNotFoundException unused) {
                z = false;
            }
            a = z;
        }

        public a(String str) {
            this.b = str;
        }

        public static boolean c() {
            return a;
        }

        @Override // defpackage.fn
        public void a(Level level, String str) {
            if (level != Level.OFF) {
                Log.println(d(level), this.b, str);
            }
        }

        @Override // defpackage.fn
        public void b(Level level, String str, Throwable th) {
            if (level != Level.OFF) {
                int d = d(level);
                String str2 = this.b;
                Log.println(d, str2, str + IOUtils.LINE_SEPARATOR_UNIX + Log.getStackTraceString(th));
            }
        }

        protected int d(Level level) {
            int intValue = level.intValue();
            if (intValue < 800) {
                return intValue < 500 ? 2 : 3;
            } else if (intValue < 900) {
                return 4;
            } else {
                return intValue < 1000 ? 5 : 6;
            }
        }
    }

    /* compiled from: Logger.java */
    /* renamed from: fn$b */
    /* loaded from: classes.dex */
    public static class b implements fn {
        @Override // defpackage.fn
        public void a(Level level, String str) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
        }

        @Override // defpackage.fn
        public void b(Level level, String str, Throwable th) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
            th.printStackTrace(System.out);
        }
    }

    void a(Level level, String str);

    void b(Level level, String str, Throwable th);
}
