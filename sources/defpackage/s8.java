package defpackage;

import com.xiaopeng.xui.widgets.popup.XSuperPopup;
/* compiled from: EventType.java */
/* renamed from: s8  reason: default package */
/* loaded from: classes.dex */
public enum s8 {
    ALARM(65501, 30, "alarmData", XSuperPopup.DURATION_LONG),
    COUNTER(65502, 30, "counterData", XSuperPopup.DURATION_LONG),
    OFFLINE_COUNTER(65133, 30, "counterData", XSuperPopup.DURATION_LONG),
    STAT(65503, 30, "statData", XSuperPopup.DURATION_LONG);
    
    static String e = "EventType";
    private int g;
    private int i;
    private String j;
    private int m;
    private int k = 25;
    private int l = 180;
    private boolean h = true;

    s8(int i, int i2, String str, int i3) {
        this.g = i;
        this.i = i2;
        this.j = str;
        this.m = i3;
    }

    public int a() {
        return this.g;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public int c() {
        return this.k;
    }

    public int d() {
        return this.l;
    }

    public int e() {
        return this.m;
    }

    public boolean isOpen() {
        return this.h;
    }

    public void setStatisticsInterval(int i) {
        this.k = i;
        this.l = i;
    }

    public static s8 a(int i) {
        s8[] values;
        for (s8 s8Var : values()) {
            if (s8Var != null && s8Var.a() == i) {
                return s8Var;
            }
        }
        return null;
    }

    public int b() {
        return this.i;
    }

    public void c(int i) {
        this.m = i;
    }

    public void b(int i) {
        String str = e;
        ya.c(str, "[setTriggerCount]", this.j, i + "");
        this.i = i;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m110a() {
        return this.j;
    }
}
