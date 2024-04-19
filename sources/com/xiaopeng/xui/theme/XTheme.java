package com.xiaopeng.xui.theme;

import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class XTheme {
    private List<ViewTheme> mThemes = new ArrayList();

    /* loaded from: classes.dex */
    public static class ViewAttr {
        private String name;
        private int value;

        public String getName() {
            return this.name;
        }

        public int getValue() {
            return this.value;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setValue(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes.dex */
    public static class ViewTheme {
        private List<ViewAttr> mAttrs = new ArrayList();
        private String mClassName;

        public void addAttr(ViewAttr viewAttr) {
            this.mAttrs.add(viewAttr);
        }

        public int getAttrResourceId(String str) {
            for (ViewAttr viewAttr : getAttrs()) {
                if (str.equals(viewAttr.getName())) {
                    return viewAttr.getValue();
                }
            }
            return -1;
        }

        public List<ViewAttr> getAttrs() {
            return this.mAttrs;
        }

        public String getClassName() {
            return this.mClassName;
        }

        public void setClassName(String str) {
            this.mClassName = str;
        }
    }

    public static XTheme createFromXml(XmlResourceParser xmlResourceParser) {
        XTheme xTheme = new XTheme();
        try {
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlResourceParser.getName();
                    if ("view".equals(name)) {
                        ViewTheme viewTheme = new ViewTheme();
                        viewTheme.setClassName(xmlResourceParser.getAttributeValue(null, "class"));
                        xTheme.addTheme(viewTheme);
                    } else if ("attr".equals(name)) {
                        ViewAttr viewAttr = new ViewAttr();
                        viewAttr.setName(xmlResourceParser.getAttributeValue(null, "name"));
                        viewAttr.setValue(xmlResourceParser.getAttributeResourceValue(null, "value", 0));
                        xTheme.getThemes().get(xTheme.getThemes().size() - 1).addAttr(viewAttr);
                    }
                }
                eventType = xmlResourceParser.next();
            }
            xmlResourceParser.close();
        } catch (IOException | XmlPullParserException unused) {
        }
        return xTheme;
    }

    public void addTheme(ViewTheme viewTheme) {
        this.mThemes.add(viewTheme);
    }

    public ViewTheme getTheme(String str) {
        for (ViewTheme viewTheme : this.mThemes) {
            if (TextUtils.equals(viewTheme.getClassName(), str)) {
                return viewTheme;
            }
        }
        return null;
    }

    public List<ViewTheme> getThemes() {
        return this.mThemes;
    }

    public void release() {
        this.mThemes.clear();
        this.mThemes = null;
    }
}
