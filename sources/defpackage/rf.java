package defpackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
/* compiled from: DateUtils.java */
/* renamed from: rf  reason: default package */
/* loaded from: classes.dex */
public class rf {
    private static SimpleDateFormat a = new SimpleDateFormat("MM.dd");
    private static SimpleDateFormat b = new SimpleDateFormat("yyyy.MM");
    private static SimpleDateFormat c = new SimpleDateFormat("MM.dd");
    private static SimpleDateFormat d = new SimpleDateFormat("MM月dd日");
    private static SimpleDateFormat e = new SimpleDateFormat("yyyy年MM月dd日");
    private static SimpleDateFormat f = new SimpleDateFormat("yyyy.MM.dd");
    private static SimpleDateFormat g = new SimpleDateFormat("HH:mm:ss");
    private static SimpleDateFormat h = new SimpleDateFormat("HH:mm");
    private static SimpleDateFormat i = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat j = new SimpleDateFormat("yyMMddHHmmss");
    private static SimpleDateFormat k = new SimpleDateFormat("yyyy/MM/dd");
    private static SimpleDateFormat l = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
    private static SimpleDateFormat m = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
    private static SimpleDateFormat n = new SimpleDateFormat("yyyyMMdd_HHmmss");
    private static SimpleDateFormat o = new SimpleDateFormat("dd MMM yyyy");
    private static SimpleDateFormat p = new SimpleDateFormat("dd.MMM yyyy");
    private static SimpleDateFormat q = new SimpleDateFormat("dd MMM");
    private static SimpleDateFormat r = new SimpleDateFormat("dd.MMM");
    private static SimpleDateFormat s = new SimpleDateFormat("E,dd MMM");
    private static SimpleDateFormat t = new SimpleDateFormat("E,dd.MMM");

    public static synchronized long a(String str) {
        long j2;
        synchronized (rf.class) {
            try {
                j2 = n.parse(str).getTime();
            } catch (ParseException e2) {
                e2.printStackTrace();
                j2 = 0;
            }
        }
        return j2;
    }

    public static synchronized String b(long j2) {
        String format;
        synchronized (rf.class) {
            format = n.format(Long.valueOf(j2));
        }
        return format;
    }

    public static synchronized String c(long j2) {
        String format;
        synchronized (rf.class) {
            format = k.format(Long.valueOf(j2));
        }
        return format;
    }
}
