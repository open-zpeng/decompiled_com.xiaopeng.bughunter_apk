package com.xiaopeng.xui.widgets.popup;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.utils.UIUtils;
/* loaded from: classes.dex */
class XPopupBackgroundConstructor {
    XPopupBackgroundConstructor() {
    }

    private static Drawable getTintedDrawable(Context context, int i, int i2) {
        Drawable drawable = context.getResources().getDrawable(i);
        if (drawable != null) {
            drawable.setColorFilter(i2, PorterDuff.Mode.SRC_ATOP);
        }
        return drawable;
    }

    private static void setAboveBackground(View view, XPopup xPopup) {
        int align = xPopup.getAlign();
        if (align == 0) {
            setTipBackground(view, R.mipmap.xpopup_arrow_down, xPopup.getBackgroundColor());
        } else if (align == 1) {
            UIUtils.isRtl();
            setTipBackground(view, R.mipmap.xpopup_arrow_down, xPopup.getBackgroundColor());
        } else if (align != 2) {
        } else {
            UIUtils.isRtl();
            setTipBackground(view, R.mipmap.xpopup_arrow_down, xPopup.getBackgroundColor());
        }
    }

    @Deprecated
    static void setBackground(View view, XPopup xPopup) {
        if (xPopup.hideArrow()) {
            setNoArrowBackground(view, xPopup.getBackgroundColor());
            return;
        }
        int position = xPopup.getPosition();
        if (position == 0) {
            setAboveBackground(view, xPopup);
        } else if (position == 1) {
            setBelowBackground(view, xPopup);
        } else if (position == 3) {
            setLeftToBackground(view, xPopup.getBackgroundColor());
        } else if (position != 4) {
        } else {
            setRightToBackground(view, xPopup.getBackgroundColor());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setBackgroundNew(View view, XPopup xPopup) {
        setViewBackground(view, UIUtils.getDrawable(xPopup.getDrawableRes()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setBackgroundNewNight(View view, XPopup xPopup) {
        setViewBackground(view, UIUtils.getDrawable(xPopup.getDrawableResNight()));
    }

    private static void setBelowBackground(View view, XPopup xPopup) {
        int align = xPopup.getAlign();
        if (align == 0) {
            setTipBackground(view, R.mipmap.xpopup_arrow_up, xPopup.getBackgroundColor());
        } else if (align == 1) {
            UIUtils.isRtl();
            setTipBackground(view, R.mipmap.xpopup_arrow_up, xPopup.getBackgroundColor());
        } else if (align != 2) {
        } else {
            UIUtils.isRtl();
            setTipBackground(view, R.mipmap.xpopup_arrow_up, xPopup.getBackgroundColor());
        }
    }

    private static void setLeftToBackground(View view, int i) {
        setTipBackground(view, !UIUtils.isRtl() ? R.mipmap.xpopup_arrow_right : R.mipmap.xpopup_arrow_left, i);
    }

    private static void setNoArrowBackground(View view, int i) {
        setTipBackground(view, R.mipmap.xpopup_no_arrow, i);
    }

    private static void setRightToBackground(View view, int i) {
        setTipBackground(view, !UIUtils.isRtl() ? R.mipmap.xpopup_arrow_left : R.mipmap.xpopup_arrow_right, i);
    }

    private static void setTipBackground(View view, int i, int i2) {
        setViewBackground(view, getTintedDrawable(view.getContext(), i, i2));
    }

    private static void setViewBackground(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }
}
