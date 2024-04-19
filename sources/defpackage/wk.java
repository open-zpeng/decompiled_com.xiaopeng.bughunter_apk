package defpackage;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.io.IOUtils;
/* compiled from: CommsTokenStore.java */
/* renamed from: wk  reason: default package */
/* loaded from: classes.dex */
public class wk {
    private static final String a = "wk";
    private static final rm b = sm.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", wk.class.getName());
    private Hashtable c;
    private String d;
    private jk e = null;

    public wk(String str) {
        rm rmVar = b;
        rmVar.setResourceName(str);
        this.c = new Hashtable();
        this.d = str;
        rmVar.fine(a, "<Init>", "308");
    }

    public void a() {
        b.fine(a, "clear", "305", new Object[]{new Integer(this.c.size())});
        synchronized (this.c) {
            this.c.clear();
        }
    }

    public int b() {
        int size;
        synchronized (this.c) {
            size = this.c.size();
        }
        return size;
    }

    public ik[] c() {
        ik[] ikVarArr;
        synchronized (this.c) {
            b.fine(a, "getOutstandingDelTokens", "311");
            Vector vector = new Vector();
            Enumeration elements = this.c.elements();
            while (elements.hasMoreElements()) {
                pk pkVar = (pk) elements.nextElement();
                if (pkVar != null && (pkVar instanceof ik) && !pkVar.a.n()) {
                    vector.addElement(pkVar);
                }
            }
            ikVarArr = (ik[]) vector.toArray(new ik[vector.size()]);
        }
        return ikVarArr;
    }

    public Vector d() {
        Vector vector;
        synchronized (this.c) {
            b.fine(a, "getOutstandingTokens", "312");
            vector = new Vector();
            Enumeration elements = this.c.elements();
            while (elements.hasMoreElements()) {
                pk pkVar = (pk) elements.nextElement();
                if (pkVar != null) {
                    vector.addElement(pkVar);
                }
            }
        }
        return vector;
    }

    public pk e(String str) {
        return (pk) this.c.get(str);
    }

    public pk f(nm nmVar) {
        return (pk) this.c.get(nmVar.o());
    }

    public void g() {
        synchronized (this.c) {
            b.fine(a, "open", "310");
            this.e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(jk jkVar) {
        synchronized (this.c) {
            b.fine(a, "quiesce", "309", new Object[]{jkVar});
            this.e = jkVar;
        }
    }

    public pk i(String str) {
        b.fine(a, "removeToken", "306", new Object[]{str});
        if (str != null) {
            return (pk) this.c.remove(str);
        }
        return null;
    }

    public pk j(nm nmVar) {
        if (nmVar != null) {
            return i(nmVar.o());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ik k(hm hmVar) {
        ik ikVar;
        synchronized (this.c) {
            String num = new Integer(hmVar.p()).toString();
            if (this.c.containsKey(num)) {
                ikVar = (ik) this.c.get(num);
                b.fine(a, "restoreToken", "302", new Object[]{num, hmVar, ikVar});
            } else {
                ikVar = new ik(this.d);
                ikVar.a.u(num);
                this.c.put(num, ikVar);
                b.fine(a, "restoreToken", "303", new Object[]{num, hmVar, ikVar});
            }
        }
        return ikVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(pk pkVar, String str) {
        synchronized (this.c) {
            b.fine(a, "saveToken", "307", new Object[]{str, pkVar.toString()});
            pkVar.a.u(str);
            this.c.put(str, pkVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(pk pkVar, nm nmVar) throws jk {
        synchronized (this.c) {
            jk jkVar = this.e;
            if (jkVar == null) {
                String o = nmVar.o();
                b.fine(a, "saveToken", "300", new Object[]{o, nmVar});
                l(pkVar, o);
            } else {
                throw jkVar;
            }
        }
    }

    public String toString() {
        String stringBuffer;
        String property = System.getProperty("line.separator", IOUtils.LINE_SEPARATOR_UNIX);
        StringBuffer stringBuffer2 = new StringBuffer();
        synchronized (this.c) {
            Enumeration elements = this.c.elements();
            while (elements.hasMoreElements()) {
                stringBuffer2.append("{" + ((pk) elements.nextElement()).a + "}" + property);
            }
            stringBuffer = stringBuffer2.toString();
        }
        return stringBuffer;
    }
}
