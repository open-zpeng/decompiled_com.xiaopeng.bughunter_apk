package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.xiaopeng.datalog.stat.StatEventHelper;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounterFactory;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder;
import java.util.List;
/* compiled from: DataLogService.java */
/* renamed from: te  reason: default package */
/* loaded from: classes.dex */
public class te implements IDataLog {
    private Context a;

    /* compiled from: DataLogService.java */
    /* renamed from: te$b */
    /* loaded from: classes.dex */
    private class b implements IMoleEventBuilder {
        ue a;

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEvent build() {
            this.a.a();
            return this.a;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setButtonId(String str) {
            this.a.e("button_id", str);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setEvent(String str) {
            this.a.e(IStatEvent.CUSTOM_MODULE, ve.b(str));
            this.a.e(IStatEvent.CUSTOM_EVENT, str);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setModule(String str) {
            this.a.e(IStatEvent.CUSTOM_MODULE, str);
            ue ueVar = this.a;
            ueVar.e(IStatEvent.CUSTOM_EVENT, str + "_page_button");
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setPageId(String str) {
            this.a.e("page_id", str);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setProperty(String str, String str2) {
            this.a.e(str, str2);
            return this;
        }

        private b(Context context) {
            this.a = new ue(context);
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setProperty(String str, Number number) {
            this.a.d(str, number);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setProperty(String str, boolean z) {
            this.a.b(str, Boolean.valueOf(z));
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setProperty(String str, char c) {
            this.a.c(str, Character.valueOf(c));
            return this;
        }
    }

    /* compiled from: DataLogService.java */
    /* renamed from: te$c */
    /* loaded from: classes.dex */
    private class c implements IStatEventBuilder {
        private IStatEvent a;

        c(Context context) {
            this.a = new ve(context);
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEvent build() {
            if (!TextUtils.isEmpty(this.a.getEventName())) {
                return this.a;
            }
            throw new IllegalStateException("Please call setEventName first!");
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setEventName(String str) {
            this.a.setEventName(str);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setProperty(String str, String str2) {
            this.a.put(str, str2);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setProperty(String str, Number number) {
            this.a.put(str, number);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setProperty(String str, boolean z) {
            this.a.put(str, Boolean.valueOf(z));
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setProperty(String str, char c) {
            this.a.put(str, Character.valueOf(c));
            return this;
        }
    }

    public te(Context context) {
        StatEventHelper.init(context);
        this.a = context;
        Module.register(se.class, new se(context));
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public IMoleEventBuilder buildMoleEvent() {
        return new b(this.a);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public IStatEventBuilder buildStat() {
        return new c(this.a);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public ICounterFactory counterFactory() {
        return we.a();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendCanData(String str) {
        StatEventHelper.getInstance().uploadCan(str);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendFiles(List<String> list) {
        StatEventHelper.getInstance().uploadFiles(list);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public String sendRecentSystemLog() {
        return StatEventHelper.getInstance().uploadRecentSystemLog();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatData(String str, String str2) {
        StatEventHelper.getInstance().uploadLogImmediately(str, str2);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatOriginData(String str, String str2) {
        StatEventHelper.getInstance().uploadLogOrigin(str, str2);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatData(IStatEvent iStatEvent) {
        StatEventHelper.getInstance().uploadCdu(iStatEvent);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatData(IMoleEvent iMoleEvent) {
        StatEventHelper.getInstance().uploadCdu(iMoleEvent);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatData(IStatEvent iStatEvent, List<String> list) {
        StatEventHelper.getInstance().uploadCduWithFiles(iStatEvent, list);
    }
}
