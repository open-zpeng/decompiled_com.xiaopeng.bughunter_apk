package com.xiaopeng.lib.themeswitch.bean;

import android.view.View;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import java.util.List;
/* loaded from: classes.dex */
public class PrePageTheme {
    private View rootView;
    private List<ThemeView> viewList;

    /* loaded from: classes.dex */
    public static class ThemeView {
        private List<ViewAttr> attrList;
        private int id;

        /* loaded from: classes.dex */
        public static class ViewAttr {
            private String attrName;
            private Object attrValue;

            public String getAttrName() {
                return this.attrName;
            }

            public Object getAttrValue() {
                return this.attrValue;
            }

            public void setAttrName(String str) {
                this.attrName = str;
            }

            public void setAttrValue(Object obj) {
                this.attrValue = obj;
            }
        }

        public List<ViewAttr> getAttrList() {
            return this.attrList;
        }

        public int getId() {
            return this.id;
        }

        public void setAttrList(List<ViewAttr> list) {
            this.attrList = list;
        }

        public void setId(int i) {
            this.id = i;
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public List<ThemeView> getViewList() {
        return this.viewList;
    }

    public void setRootView(View view) {
        this.rootView = view;
    }

    public void setViewList(List<ThemeView> list) {
        this.viewList = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) IInputController.KEYCODE_BACK_BUTTON);
        sb.append("<RootView=");
        sb.append(this.rootView);
        sb.append(">\n");
        for (ThemeView themeView : this.viewList) {
            sb.append("  <View id=");
            sb.append(themeView.getId());
            sb.append(">\n");
            for (ThemeView.ViewAttr viewAttr : themeView.getAttrList()) {
                sb.append("    <");
                sb.append(viewAttr.getAttrName());
                sb.append(" value=");
                sb.append(viewAttr.getAttrValue());
                sb.append("/>\n");
            }
            sb.append("  </View>\n");
        }
        sb.append("</Page>");
        return sb.toString();
    }
}
