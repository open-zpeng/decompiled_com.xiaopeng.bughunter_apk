package defpackage;

import java.util.ArrayList;
import java.util.List;
/* compiled from: TableEntity.java */
/* renamed from: sc  reason: default package */
/* loaded from: classes.dex */
public class sc {
    public String a;
    private List<pc> b = new ArrayList();

    public sc(String str) {
        this.a = str;
    }

    public sc a(pc pcVar) {
        this.b.add(pcVar);
        return this;
    }

    public String b() {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(this.a);
        sb.append('(');
        for (pc pcVar : this.b) {
            if (pcVar.c != null) {
                sb.append("PRIMARY KEY (");
                for (String str : pcVar.c) {
                    sb.append(str);
                    sb.append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append(")");
            } else {
                sb.append(pcVar.a);
                sb.append(" ");
                sb.append(pcVar.b);
                if (pcVar.e) {
                    sb.append(" NOT NULL");
                }
                if (pcVar.d) {
                    sb.append(" PRIMARY KEY");
                }
                if (pcVar.f) {
                    sb.append(" AUTOINCREMENT");
                }
                sb.append(",");
            }
        }
        if (sb.toString().endsWith(",")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(')');
        return sb.toString();
    }

    public int c() {
        return this.b.size();
    }

    public int d(String str) {
        int c = c();
        for (int i = 0; i < c; i++) {
            if (this.b.get(i).a.equals(str)) {
                return i;
            }
        }
        return -1;
    }
}
