package defpackage;

import android.util.Log;
/* compiled from: KeyPressPresenter.java */
/* renamed from: xd  reason: default package */
/* loaded from: classes.dex */
public class xd {
    rd a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KeyPressPresenter.java */
    /* renamed from: xd$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.i("KeyPressPresenter", "BugHunter_UploadData_uploadStatusAndLog start");
            xd.this.a.i();
            Log.i("KeyPressPresenter", "BugHunter_UploadData_uploadStatusAndLog finish");
        }
    }

    public xd() {
        Log.i("KeyPressPresenter", "BugHunter_UploadData_KeyPressPresenter init");
        this.a = new rd();
    }

    public void a() {
        ag.i(new a());
    }
}
