package defpackage;

import android.os.Build;
import android.text.TextUtils;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.TimeZone;
/* compiled from: HttpHeaders.java */
/* renamed from: xc  reason: default package */
/* loaded from: classes.dex */
public class xc implements Serializable {
    public static final TimeZone b = TimeZone.getTimeZone("GMT");
    private static String c = null;
    private static String d = null;
    private static final long serialVersionUID = 8458647755751403873L;
    public LinkedHashMap<String, String> e;

    public xc() {
        j();
    }

    public static String b(long j) {
        Date date = new Date(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM y HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(b);
        return simpleDateFormat.format(date);
    }

    public static String d() {
        if (TextUtils.isEmpty(c)) {
            Locale locale = Locale.getDefault();
            String language = locale.getLanguage();
            String country = locale.getCountry();
            StringBuilder sb = new StringBuilder(language);
            if (!TextUtils.isEmpty(country)) {
                sb.append('-');
                sb.append(country);
                sb.append(',');
                sb.append(language);
                sb.append(";q=0.8");
            }
            String sb2 = sb.toString();
            c = sb2;
            return sb2;
        }
        return c;
    }

    public static String e(String str, String str2) {
        if (str != null) {
            return str;
        }
        if (str2 != null) {
            return str2;
        }
        return null;
    }

    public static long f(String str) {
        try {
            return k(str);
        } catch (ParseException unused) {
            return 0L;
        }
    }

    public static long g(String str) {
        try {
            return k(str);
        } catch (ParseException unused) {
            return -1L;
        }
    }

    public static long h(String str) {
        try {
            return k(str);
        } catch (ParseException unused) {
            return 0L;
        }
    }

    public static String i() {
        if (TextUtils.isEmpty(d)) {
            String str = null;
            try {
                str = wb.h().f().getString(((Integer) Class.forName("com.android.internal.R$string").getDeclaredField("web_user_agent").get(null)).intValue());
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(str)) {
                str = "okhttp-okgo/jeasonlzy";
            }
            Locale locale = Locale.getDefault();
            StringBuffer stringBuffer = new StringBuffer();
            String str2 = Build.VERSION.RELEASE;
            if (str2.length() > 0) {
                stringBuffer.append(str2);
            } else {
                stringBuffer.append("1.0");
            }
            stringBuffer.append("; ");
            String language = locale.getLanguage();
            if (language != null) {
                stringBuffer.append(language.toLowerCase(locale));
                String country = locale.getCountry();
                if (!TextUtils.isEmpty(country)) {
                    stringBuffer.append("-");
                    stringBuffer.append(country.toLowerCase(locale));
                }
            } else {
                stringBuffer.append("en");
            }
            if ("REL".equals(Build.VERSION.CODENAME)) {
                String str3 = Build.MODEL;
                if (str3.length() > 0) {
                    stringBuffer.append("; ");
                    stringBuffer.append(str3);
                }
            }
            String str4 = Build.ID;
            if (str4.length() > 0) {
                stringBuffer.append(" Build/");
                stringBuffer.append(str4);
            }
            String format = String.format(str, stringBuffer, "Mobile ");
            d = format;
            return format;
        }
        return d;
    }

    private void j() {
        this.e = new LinkedHashMap<>();
    }

    public static long k(String str) throws ParseException {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM y HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(b);
        return simpleDateFormat.parse(str).getTime();
    }

    public void a() {
        this.e.clear();
    }

    public String c(String str) {
        return this.e.get(str);
    }

    public void l(xc xcVar) {
        LinkedHashMap<String, String> linkedHashMap;
        if (xcVar == null || (linkedHashMap = xcVar.e) == null || linkedHashMap.isEmpty()) {
            return;
        }
        this.e.putAll(xcVar.e);
    }

    public void m(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.e.put(str, str2);
    }

    public String n(String str) {
        return this.e.remove(str);
    }

    public String toString() {
        return "HttpHeaders{headersMap=" + this.e + '}';
    }
}
