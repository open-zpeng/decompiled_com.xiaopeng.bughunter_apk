package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
/* compiled from: LocalBroadcastManager.java */
/* renamed from: n2  reason: default package */
/* loaded from: classes.dex */
public final class n2 {
    private static final Object a = new Object();
    private static n2 b;
    private final Context c;
    private final HashMap<BroadcastReceiver, ArrayList<c>> d = new HashMap<>();
    private final HashMap<String, ArrayList<c>> e = new HashMap<>();
    private final ArrayList<b> f = new ArrayList<>();
    private final Handler g;

    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: n2$a */
    /* loaded from: classes.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                n2.this.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: n2$b */
    /* loaded from: classes.dex */
    public static final class b {
        final Intent a;
        final ArrayList<c> b;

        b(Intent intent, ArrayList<c> arrayList) {
            this.a = intent;
            this.b = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: n2$c */
    /* loaded from: classes.dex */
    public static final class c {
        final IntentFilter a;
        final BroadcastReceiver b;
        boolean c;
        boolean d;

        c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.a = intentFilter;
            this.b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.b);
            sb.append(" filter=");
            sb.append(this.a);
            if (this.d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private n2(Context context) {
        this.c = context;
        this.g = new a(context.getMainLooper());
    }

    public static n2 b(Context context) {
        n2 n2Var;
        synchronized (a) {
            if (b == null) {
                b = new n2(context.getApplicationContext());
            }
            n2Var = b;
        }
        return n2Var;
    }

    void a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.d) {
                size = this.f.size();
                if (size <= 0) {
                    return;
                }
                bVarArr = new b[size];
                this.f.toArray(bVarArr);
                this.f.clear();
            }
            for (int i = 0; i < size; i++) {
                b bVar = bVarArr[i];
                int size2 = bVar.b.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    c cVar = bVar.b.get(i2);
                    if (!cVar.d) {
                        cVar.b.onReceive(this.c, bVar.a);
                    }
                }
            }
        }
    }

    public void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.d) {
            c cVar = new c(intentFilter, broadcastReceiver);
            ArrayList<c> arrayList = this.d.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.d.put(broadcastReceiver, arrayList);
            }
            arrayList.add(cVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<c> arrayList2 = this.e.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.e.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    public boolean d(Intent intent) {
        int i;
        String str;
        ArrayList arrayList;
        ArrayList<c> arrayList2;
        String str2;
        synchronized (this.d) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.c.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<c> arrayList3 = this.e.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    c cVar = arrayList3.get(i2);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + cVar.a);
                    }
                    if (cVar.c) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i = i2;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i = i2;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = resolveTypeIfNeeded;
                        int match = cVar.a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(cVar);
                            cVar.c = true;
                            i2 = i + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        } else if (z) {
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + (match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                        }
                    }
                    arrayList4 = arrayList;
                    i2 = i + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    resolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                        ((c) arrayList5.get(i3)).c = false;
                    }
                    this.f.add(new b(intent, arrayList5));
                    if (!this.g.hasMessages(1)) {
                        this.g.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void e(BroadcastReceiver broadcastReceiver) {
        synchronized (this.d) {
            ArrayList<c> remove = this.d.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                c cVar = remove.get(size);
                cVar.d = true;
                for (int i = 0; i < cVar.a.countActions(); i++) {
                    String action = cVar.a.getAction(i);
                    ArrayList<c> arrayList = this.e.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            c cVar2 = arrayList.get(size2);
                            if (cVar2.b == broadcastReceiver) {
                                cVar2.d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.e.remove(action);
                        }
                    }
                }
            }
        }
    }
}
