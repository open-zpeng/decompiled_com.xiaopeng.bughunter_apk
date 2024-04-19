package defpackage;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
/* compiled from: JSR47Logger.java */
/* renamed from: qm  reason: default package */
/* loaded from: classes.dex */
public class qm implements rm {
    private Logger a = null;
    private ResourceBundle b = null;
    private ResourceBundle c = null;
    private String d = null;
    private String e = null;
    private String f = null;

    private String a(ResourceBundle resourceBundle, String str) {
        try {
            return resourceBundle.getString(str);
        } catch (MissingResourceException unused) {
            return str;
        }
    }

    private void c(Level level, String str, String str2, String str3, ResourceBundle resourceBundle, String str4, Object[] objArr, Throwable th) {
        if (str4.indexOf("=====") == -1) {
            str4 = MessageFormat.format(a(resourceBundle, str4), objArr);
        }
        LogRecord logRecord = new LogRecord(level, String.valueOf(this.e) + ": " + str4);
        logRecord.setSourceClassName(str);
        logRecord.setSourceMethodName(str2);
        logRecord.setLoggerName(this.f);
        if (th != null) {
            logRecord.setThrown(th);
        }
        this.a.log(logRecord);
    }

    private Level d(int i) {
        switch (i) {
            case 1:
                return Level.SEVERE;
            case 2:
                return Level.WARNING;
            case 3:
                return Level.INFO;
            case 4:
                return Level.CONFIG;
            case 5:
                return Level.FINE;
            case 6:
                return Level.FINER;
            case 7:
                return Level.FINEST;
            default:
                return null;
        }
    }

    public void b(int i, String str, String str2, String str3, Object[] objArr, Throwable th) {
        Level d = d(i);
        if (this.a.isLoggable(d)) {
            c(d, str, str2, this.d, this.b, str3, objArr, th);
        }
    }

    public void e(int i, String str, String str2, String str3, Object[] objArr, Throwable th) {
        Level d = d(i);
        if (this.a.isLoggable(d)) {
            c(d, str, str2, this.d, this.c, str3, objArr, th);
        }
    }

    @Override // defpackage.rm
    public void fine(String str, String str2, String str3) {
        e(5, str, str2, str3, null, null);
    }

    @Override // defpackage.rm
    public void finer(String str, String str2, String str3) {
        e(6, str, str2, str3, null, null);
    }

    @Override // defpackage.rm
    public void initialise(ResourceBundle resourceBundle, String str, String str2) {
        this.c = this.b;
        this.e = str2;
        this.f = str;
        this.a = Logger.getLogger(str);
        this.b = resourceBundle;
        this.c = resourceBundle;
        this.d = resourceBundle.getString("0");
    }

    @Override // defpackage.rm
    public boolean isLoggable(int i) {
        return this.a.isLoggable(d(i));
    }

    @Override // defpackage.rm
    public void setResourceName(String str) {
        this.e = str;
    }

    @Override // defpackage.rm
    public void severe(String str, String str2, String str3, Object[] objArr) {
        b(1, str, str2, str3, objArr, null);
    }

    @Override // defpackage.rm
    public void warning(String str, String str2, String str3) {
        b(2, str, str2, str3, null, null);
    }

    @Override // defpackage.rm
    public void fine(String str, String str2, String str3, Object[] objArr) {
        e(5, str, str2, str3, objArr, null);
    }

    @Override // defpackage.rm
    public void warning(String str, String str2, String str3, Object[] objArr) {
        b(2, str, str2, str3, objArr, null);
    }

    @Override // defpackage.rm
    public void fine(String str, String str2, String str3, Object[] objArr, Throwable th) {
        e(5, str, str2, str3, objArr, th);
    }
}
