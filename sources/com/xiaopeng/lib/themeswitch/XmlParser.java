package com.xiaopeng.lib.themeswitch;

import android.text.TextUtils;
import android.util.Log;
import com.xiaopeng.lib.themeswitch.bean.PageTheme;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes.dex */
public class XmlParser {
    private static final String TAG = "ThemeXmlParser";

    public static PageTheme parseXMLWithPull(InputStream inputStream, String str) {
        Log.d(TAG, "parseXMLWithPull: target=" + str);
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(inputStream, "utf-8");
            PageTheme pageTheme = new PageTheme();
            boolean z = false;
            boolean z2 = false;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (z) {
                    return pageTheme;
                }
                String name = newPullParser.getName();
                if (eventType != 2) {
                    if (eventType == 3 && "page".equals(name.toLowerCase()) && z2) {
                        z = true;
                    }
                } else if ("page".equals(name.toLowerCase()) && newPullParser.getAttributeValue(null, "name").equals(str)) {
                    pageTheme.setPageName(str);
                    pageTheme.setViewList(new ArrayList());
                    z2 = true;
                } else if ("view".equals(name.toLowerCase()) && z2) {
                    PageTheme.ThemeView themeView = new PageTheme.ThemeView();
                    themeView.setId(newPullParser.getAttributeValue(null, "id"));
                    themeView.setAttrList(new ArrayList());
                    pageTheme.getViewList().add(themeView);
                } else if (z2) {
                    PageTheme.ThemeView.ViewAttr viewAttr = new PageTheme.ThemeView.ViewAttr();
                    viewAttr.setAttrName(name);
                    viewAttr.setAttrValue(newPullParser.getAttributeValue(null, "value"));
                    pageTheme.getViewList().get(pageTheme.getViewList().size() - 1).getAttrList().add(viewAttr);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, PageTheme> parseXMLWithPull(InputStream inputStream) {
        Log.d(TAG, "parseXMLWithPull: target=all");
        HashMap hashMap = new HashMap();
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(inputStream, "utf-8");
            PageTheme pageTheme = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                String name = newPullParser.getName();
                if (eventType != 2) {
                    if (eventType == 3 && "page".equals(name.toLowerCase()) && pageTheme != null) {
                        hashMap.put(pageTheme.getPageName(), pageTheme);
                    }
                } else if ("page".equals(name.toLowerCase())) {
                    String attributeValue = newPullParser.getAttributeValue(null, "name");
                    if (pageTheme == null || !TextUtils.equals(attributeValue, pageTheme.getPageName())) {
                        pageTheme = new PageTheme();
                        pageTheme.setPageName(attributeValue);
                        pageTheme.setViewList(new ArrayList());
                    }
                } else if ("view".equals(name.toLowerCase())) {
                    PageTheme.ThemeView themeView = new PageTheme.ThemeView();
                    themeView.setId(newPullParser.getAttributeValue(null, "id"));
                    themeView.setAttrList(new ArrayList());
                    if (pageTheme != null) {
                        pageTheme.getViewList().add(themeView);
                    }
                } else {
                    PageTheme.ThemeView.ViewAttr viewAttr = new PageTheme.ThemeView.ViewAttr();
                    viewAttr.setAttrName(name);
                    viewAttr.setAttrValue(newPullParser.getAttributeValue(null, "value"));
                    if (pageTheme != null) {
                        pageTheme.getViewList().get(pageTheme.getViewList().size() - 1).getAttrList().add(viewAttr);
                    }
                }
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }
}
