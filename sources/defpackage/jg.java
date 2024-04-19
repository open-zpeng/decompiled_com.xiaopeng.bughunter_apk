package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.systemdelegate.ISystemDelegate;
/* compiled from: SystemDelegateService.java */
/* renamed from: jg  reason: default package */
/* loaded from: classes.dex */
public class jg implements ISystemDelegate {
    private Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jg(Context context) {
        this.a = context;
        Module.register(ig.class, new ig(context));
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.systemdelegate.ISystemDelegate
    public String getCertificate() throws RemoteException {
        tf.a("SystemDelegateService", "start getCertificate!");
        Cursor query = this.a.getContentResolver().query(Uri.parse("content://com.xiaopeng.system.delegate/cert/ssl"), null, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    String string = query.getString(0);
                    tf.s("SystemDelegateService", "query result success");
                    query.close();
                    return string;
                }
            } finally {
                if (query != null) {
                    query.close();
                }
            }
        }
        tf.s("SystemDelegateService", "cursor is empty!");
        return null;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.systemdelegate.ISystemDelegate
    public void setSystemProperty(String str, String str2) throws RemoteException {
        tf.a("SystemDelegateService", "setSystemProperty " + str + ":" + str2);
        Uri parse = Uri.parse("content://com.xiaopeng.system.delegate/sysprop/set");
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        this.a.getContentResolver().update(parse, contentValues, null, null);
    }
}
