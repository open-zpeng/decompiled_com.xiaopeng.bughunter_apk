package com.ut.mini;

import android.net.Uri;
import android.text.TextUtils;
import com.ut.mini.base.UTMIVariables;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class UTTracker {
    private static Pattern a = Pattern.compile("(\\|\\||[\t\r\n])+");
    private String g;
    private String aq = null;
    private Map<String, String> D = new HashMap();

    private static String b(String str) {
        return d(str);
    }

    private static String d(String str) {
        return (str == null || "".equals(str)) ? str : a.matcher(str).replaceAll("");
    }

    private static void f(Map<String, String> map) {
        if (map != null) {
            pb pbVar = pb.IMEI;
            if (map.containsKey(pbVar.toString())) {
                map.remove(pbVar.toString());
            }
            pb pbVar2 = pb.IMSI;
            if (map.containsKey(pbVar2.toString())) {
                map.remove(pbVar2.toString());
            }
            pb pbVar3 = pb.CARRIER;
            if (map.containsKey(pbVar3.toString())) {
                map.remove(pbVar3.toString());
            }
            pb pbVar4 = pb.ACCESS;
            if (map.containsKey(pbVar4.toString())) {
                map.remove(pbVar4.toString());
            }
            pb pbVar5 = pb.ACCESS_SUBTYPE;
            if (map.containsKey(pbVar5.toString())) {
                map.remove(pbVar5.toString());
            }
            pb pbVar6 = pb.CHANNEL;
            if (map.containsKey(pbVar6.toString())) {
                map.remove(pbVar6.toString());
            }
            pb pbVar7 = pb.LL_USERNICK;
            if (map.containsKey(pbVar7.toString())) {
                map.remove(pbVar7.toString());
            }
            pb pbVar8 = pb.USERNICK;
            if (map.containsKey(pbVar8.toString())) {
                map.remove(pbVar8.toString());
            }
            pb pbVar9 = pb.LL_USERID;
            if (map.containsKey(pbVar9.toString())) {
                map.remove(pbVar9.toString());
            }
            pb pbVar10 = pb.USERID;
            if (map.containsKey(pbVar10.toString())) {
                map.remove(pbVar10.toString());
            }
            pb pbVar11 = pb.SDKVERSION;
            if (map.containsKey(pbVar11.toString())) {
                map.remove(pbVar11.toString());
            }
            pb pbVar12 = pb.START_SESSION_TIMESTAMP;
            if (map.containsKey(pbVar12.toString())) {
                map.remove(pbVar12.toString());
            }
            pb pbVar13 = pb.UTDID;
            if (map.containsKey(pbVar13.toString())) {
                map.remove(pbVar13.toString());
            }
            pb pbVar14 = pb.SDKTYPE;
            if (map.containsKey(pbVar14.toString())) {
                map.remove(pbVar14.toString());
            }
            pb pbVar15 = pb.RESERVE2;
            if (map.containsKey(pbVar15.toString())) {
                map.remove(pbVar15.toString());
            }
            pb pbVar16 = pb.RESERVE3;
            if (map.containsKey(pbVar16.toString())) {
                map.remove(pbVar16.toString());
            }
            pb pbVar17 = pb.RESERVE4;
            if (map.containsKey(pbVar17.toString())) {
                map.remove(pbVar17.toString());
            }
            pb pbVar18 = pb.RESERVE5;
            if (map.containsKey(pbVar18.toString())) {
                map.remove(pbVar18.toString());
            }
            pb pbVar19 = pb.RESERVES;
            if (map.containsKey(pbVar19.toString())) {
                map.remove(pbVar19.toString());
            }
            pb pbVar20 = pb.RECORD_TIMESTAMP;
            if (map.containsKey(pbVar20.toString())) {
                map.remove(pbVar20.toString());
            }
        }
    }

    private Map<String, String> g(Map<String, String> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            Iterator<String> it = map.keySet().iterator();
            if (it != null) {
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null) {
                        hashMap.put(next, b(map.get(next)));
                    }
                }
            }
            return hashMap;
        }
        return null;
    }

    private static void h(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map.containsKey(UTFields.TRACK_ID)) {
            String str = map.get(UTFields.TRACK_ID);
            map.remove(UTFields.TRACK_ID);
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("_tkid", str);
            }
        }
        if (hashMap.size() > 0) {
            map.put(pb.RESERVES.toString(), gb.c(hashMap));
        }
        pb pbVar = pb.PAGE;
        if (map.containsKey(pbVar.toString())) {
            return;
        }
        map.put(pbVar.toString(), "UT");
    }

    public synchronized String getGlobalProperty(String str) {
        if (str != null) {
            return this.D.get(str);
        }
        return null;
    }

    public void pageAppear(Object obj) {
        UTPageHitHelper.getInstance().pageAppear(obj);
    }

    public void pageAppearDonotSkip(Object obj) {
        UTPageHitHelper.getInstance().a(obj, null, true);
    }

    public void pageDisAppear(Object obj) {
        UTPageHitHelper.getInstance().pageDisAppear(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(String str) {
        this.aq = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(String str) {
        this.g = str;
    }

    public synchronized void removeGlobalProperty(String str) {
        if (str != null) {
            if (this.D.containsKey(str)) {
                this.D.remove(str);
            }
        }
    }

    public void send(Map<String, String> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.D);
            hashMap.putAll(map);
            if (!TextUtils.isEmpty(this.g)) {
                hashMap.put(pb.APPKEY.toString(), this.g);
            }
            Map<String, String> g = g((Map<String, String>) hashMap);
            if (!TextUtils.isEmpty(this.aq)) {
                g.put(UTFields.TRACK_ID, this.aq);
            }
            UTMIVariables.getInstance().isAliyunOSPlatform();
            f(g);
            d(g);
            m68g(g);
            h(g);
            ea.d(g.remove(pb.PAGE.toString()), g.remove(pb.EVENTID.toString()), g.remove(pb.ARG1.toString()), g.remove(pb.ARG2.toString()), g.remove(pb.ARG3.toString()), g);
        }
    }

    public synchronized void setGlobalProperty(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            this.D.put(str, str2);
        } else {
            ya.a("setGlobalProperty", "key is null or key is empty or value is null,please check it!");
        }
    }

    public void skipPage(Object obj) {
        UTPageHitHelper.getInstance().skipPage(obj);
    }

    public void updateNextPageProperties(Map<String, String> map) {
        UTPageHitHelper.getInstance().updateNextPageProperties(map);
    }

    public void updatePageName(Object obj, String str) {
        UTPageHitHelper.getInstance().updatePageName(obj, str);
    }

    public void updatePageProperties(Object obj, Map<String, String> map) {
        UTPageHitHelper.getInstance().updatePageProperties(obj, map);
    }

    public void updatePageStatus(Object obj, UTPageStatus uTPageStatus) {
        UTPageHitHelper.getInstance().updatePageStatus(obj, uTPageStatus);
    }

    public void updatePageUrl(Object obj, Uri uri) {
        UTPageHitHelper.getInstance().updatePageUrl(obj, uri);
    }

    public void pageAppear(Object obj, String str) {
        UTPageHitHelper.getInstance().pageAppear(obj, str);
    }

    public void pageAppearDonotSkip(Object obj, String str) {
        UTPageHitHelper.getInstance().a(obj, str, true);
    }

    private static void d(Map<String, String> map) {
        if (map != null) {
            if (map.containsKey(UTFields.OS)) {
                map.remove(UTFields.OS);
                map.put(pb.OS.toString(), map.get(UTFields.OS));
            }
            if (map.containsKey(UTFields.OS_VERSION)) {
                map.remove(UTFields.OS_VERSION);
                map.put(pb.OSVERSION.toString(), map.get(UTFields.OS_VERSION));
            }
        }
    }

    /* renamed from: g  reason: collision with other method in class */
    private static void m68g(Map<String, String> map) {
        map.put(pb.SDKTYPE.toString(), "mini");
    }
}
