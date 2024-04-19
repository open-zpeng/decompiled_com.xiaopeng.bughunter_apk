package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
/* compiled from: ContextThemeWrapper.java */
/* renamed from: d6  reason: default package */
/* loaded from: classes.dex */
public class d6 extends ContextWrapper {
    private int a;
    private Resources.Theme b;
    private LayoutInflater c;
    private Configuration d;
    private Resources e;

    public d6() {
        super(null);
    }

    private Resources a() {
        if (this.e == null) {
            Configuration configuration = this.d;
            if (configuration == null) {
                this.e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.e = createConfigurationContext(configuration).getResources();
            }
        }
        return this.e;
    }

    private void b() {
        boolean z = this.b == null;
        if (z) {
            this.b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.b.setTo(theme);
            }
        }
        c(this.b, this.a, z);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    protected void c(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return a();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.c == null) {
                this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.c;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.b;
        if (theme != null) {
            return theme;
        }
        if (this.a == 0) {
            this.a = s5.b;
        }
        b();
        return this.b;
    }

    public int getThemeResId() {
        return this.a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.a != i) {
            this.a = i;
            b();
        }
    }

    public d6(Context context, int i) {
        super(context);
        this.a = i;
    }

    public d6(Context context, Resources.Theme theme) {
        super(context);
        this.b = theme;
    }
}
