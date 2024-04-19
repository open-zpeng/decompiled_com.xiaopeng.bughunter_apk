package com.xiaopeng.xui.widgets.popup;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.theme.ThemeWatcher;
import com.xiaopeng.xui.utils.UIUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public class XPopup implements ThemeWatcher.OnThemeSwitchListener {
    public static final int ALIGN_CENTER = 0;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int GRAVITY_CENTER = 0;
    public static final int GRAVITY_LEFT = 1;
    public static final int GRAVITY_RIGHT = 2;
    public static final int POSITION_ABOVE = 0;
    public static final int POSITION_BELOW = 1;
    public static final int POSITION_LEFT_TO = 3;
    public static final int POSITION_RIGHT_TO = 4;
    private int arrowDownNightResId;
    private int arrowDownResId;
    private int arrowLeftNightResId;
    private int arrowLeftResId;
    private int arrowNoNightResId;
    private int arrowNoResId;
    private int arrowRightNightResId;
    private int arrowRightResId;
    private int arrowUpNightResId;
    private int arrowUpResId;
    private int mAlign;
    private View mAnchorView;
    private boolean mArrow;
    private int mBackgroundColor;
    private Context mContext;
    private View mCustomView;
    private float mElevation;
    private CharSequence mMessage;
    private int mOffsetX;
    private int mOffsetY;
    private int mPosition;
    private ViewGroup mRootViewGroup;
    private int mTextAppearanceStyle;
    private int mTextAppearanceStyleNight;
    private int mTextGravity;
    private Typeface mTypeface;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Align {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Gravity {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Position {
    }

    public XPopup(Builder builder) {
        this.mContext = builder.mContext;
        this.mAnchorView = builder.mAnchorView;
        this.mRootViewGroup = builder.mRootViewGroup;
        this.mMessage = builder.mMessage;
        this.mPosition = builder.mPosition;
        this.mAlign = builder.mAlign;
        this.mOffsetX = builder.mOffsetX;
        this.mOffsetX = builder.mOffsetX;
        this.mOffsetY = builder.mOffsetY;
        this.mArrow = builder.mArrow;
        this.mBackgroundColor = builder.mBackgroundColor;
        this.mElevation = builder.mElevation;
        this.mTextGravity = builder.mTextGravity;
        this.mTextAppearanceStyle = builder.mTextAppearanceStyle;
        this.mTextAppearanceStyleNight = builder.mTextAppearanceStyleNight;
        this.mTypeface = builder.mTypeface;
        this.arrowDownResId = builder.arrowDownResId;
        this.arrowDownNightResId = builder.arrowDownNightResId;
        this.arrowUpResId = builder.arrowUpResId;
        this.arrowUpNightResId = builder.arrowUpNightResId;
        this.arrowLeftResId = builder.arrowLeftResId;
        this.arrowLeftNightResId = builder.arrowLeftNightResId;
        this.arrowRightResId = builder.arrowRightResId;
        this.arrowRightNightResId = builder.arrowRightNightResId;
        this.arrowNoResId = builder.arrowNoResId;
        this.arrowNoNightResId = builder.arrowNoNightResId;
        this.mCustomView = builder.mCustomView;
    }

    public boolean alignedCenter() {
        return this.mAlign == 0;
    }

    public boolean alignedLeft() {
        return 1 == this.mAlign;
    }

    public boolean alignedRight() {
        return 2 == this.mAlign;
    }

    public int getAlign() {
        return this.mAlign;
    }

    public View getAnchorView() {
        return this.mAnchorView;
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public Context getContext() {
        return this.mContext;
    }

    public View getCustomView() {
        return this.mCustomView;
    }

    public int getDrawableRes() {
        if (hideArrow()) {
            int i = this.arrowNoResId;
            return i > 0 ? i : R.mipmap.xpopup_no_arrow;
        }
        int position = getPosition();
        if (position == 0) {
            int i2 = this.arrowDownResId;
            return i2 > 0 ? i2 : R.mipmap.xpopup_arrow_down;
        } else if (position == 1) {
            int i3 = this.arrowUpResId;
            return i3 > 0 ? i3 : R.mipmap.xpopup_arrow_up;
        } else if (position == 3) {
            int i4 = this.arrowRightResId;
            return i4 > 0 ? i4 : R.mipmap.xpopup_arrow_right;
        } else if (position != 4) {
            int i5 = this.arrowNoResId;
            return i5 > 0 ? i5 : R.mipmap.xpopup_no_arrow;
        } else {
            int i6 = this.arrowLeftResId;
            return i6 > 0 ? i6 : R.mipmap.xpopup_arrow_left;
        }
    }

    public int getDrawableResNight() {
        if (hideArrow()) {
            int i = this.arrowNoNightResId;
            return i > 0 ? i : R.mipmap.xpopup_no_arrow_night;
        }
        int position = getPosition();
        if (position == 0) {
            int i2 = this.arrowDownNightResId;
            return i2 > 0 ? i2 : R.mipmap.xpopup_arrow_down_night;
        } else if (position == 1) {
            int i3 = this.arrowUpNightResId;
            return i3 > 0 ? i3 : R.mipmap.xpopup_arrow_up_night;
        } else if (position == 3) {
            int i4 = this.arrowRightNightResId;
            return i4 > 0 ? i4 : R.mipmap.xpopup_arrow_right_night;
        } else if (position != 4) {
            int i5 = this.arrowNoNightResId;
            return i5 > 0 ? i5 : R.mipmap.xpopup_no_arrow_night;
        } else {
            int i6 = this.arrowLeftNightResId;
            return i6 > 0 ? i6 : R.mipmap.xpopup_arrow_left_night;
        }
    }

    public float getElevation() {
        return this.mElevation;
    }

    public CharSequence getMessage() {
        return this.mMessage;
    }

    public int getOffsetX() {
        return this.mOffsetX;
    }

    public int getOffsetY() {
        return this.mOffsetY;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public ViewGroup getRootView() {
        return this.mRootViewGroup;
    }

    public int getTextAppearanceStyle() {
        return this.mTextAppearanceStyle;
    }

    public int getTextAppearanceStyleNight() {
        return this.mTextAppearanceStyleNight;
    }

    public int getTextGravity() {
        int i = this.mTextGravity;
        if (i != 0) {
            if (i != 1) {
                return i != 2 ? 17 : 8388613;
            }
            return 8388611;
        }
        return 17;
    }

    public Typeface getTypeface() {
        return this.mTypeface;
    }

    public boolean hideArrow() {
        return !this.mArrow;
    }

    @Override // com.xiaopeng.xui.theme.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        updateByTheme(this.mCustomView, this);
    }

    public boolean positionedAbove() {
        return this.mPosition == 0;
    }

    public boolean positionedBelow() {
        return 1 == this.mPosition;
    }

    public boolean positionedLeftTo() {
        return 3 == this.mPosition;
    }

    public boolean positionedRightTo() {
        return 4 == this.mPosition;
    }

    public void registerTheme() {
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
    }

    public void setCustomView(View view) {
        this.mCustomView = view;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void unregisterTheme() {
        ThemeWatcher.getInstance().removeThemeListener(this);
    }

    public void updateByTheme(View view, XPopup xPopup) {
        if (!ThemeWatcher.getInstance().isNight()) {
            XPopupBackgroundConstructor.setBackgroundNew(view, xPopup);
            if (view instanceof TextView) {
                ((TextView) view).setTextAppearance(xPopup.getContext(), xPopup.getTextAppearanceStyle());
                return;
            }
            return;
        }
        XPopupBackgroundConstructor.setBackgroundNewNight(view, xPopup);
        if (view instanceof TextView) {
            ((TextView) view).setTextAppearance(xPopup.getContext(), xPopup.getTextAppearanceStyleNight());
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private int arrowDownNightResId;
        private int arrowDownResId;
        private int arrowLeftNightResId;
        private int arrowLeftResId;
        private int arrowNoNightResId;
        private int arrowNoResId;
        private int arrowRightNightResId;
        private int arrowRightResId;
        private int arrowUpNightResId;
        private int arrowUpResId;
        private int mAlign;
        private View mAnchorView;
        private boolean mArrow;
        private int mBackgroundColor;
        private Context mContext;
        private View mCustomView;
        private float mElevation;
        private CharSequence mMessage;
        private int mOffsetX;
        private int mOffsetY;
        private int mPosition;
        private ViewGroup mRootViewGroup;
        private int mTextAppearanceStyle;
        private int mTextAppearanceStyleNight;
        private int mTextGravity;
        private Typeface mTypeface;

        public Builder(Context context, View view, ViewGroup viewGroup, CharSequence charSequence, int i) {
            this.mContext = context;
            this.mAnchorView = view;
            this.mRootViewGroup = viewGroup;
            this.mMessage = charSequence;
            this.mPosition = i;
            this.mAlign = 0;
            this.mOffsetX = 0;
            this.mOffsetY = 0;
            this.mArrow = true;
            this.mBackgroundColor = 0;
            this.mTextGravity = 0;
            this.mTextAppearanceStyle = R.style.XPopupDefaultStyle;
            this.mTextAppearanceStyleNight = R.style.XPopupNightStyle;
            this.arrowDownResId = R.mipmap.xpopup_arrow_down;
            this.arrowDownNightResId = R.mipmap.xpopup_arrow_down_night;
            this.arrowUpResId = R.mipmap.xpopup_arrow_up;
            this.arrowUpNightResId = R.mipmap.xpopup_arrow_up_night;
            this.arrowLeftResId = R.mipmap.xpopup_arrow_left;
            this.arrowLeftNightResId = R.mipmap.xpopup_arrow_left_night;
            this.arrowRightResId = R.mipmap.xpopup_arrow_right;
            this.arrowRightNightResId = R.mipmap.xpopup_arrow_right_night;
            this.arrowNoResId = R.mipmap.xpopup_no_arrow;
            this.arrowNoNightResId = R.mipmap.xpopup_no_arrow_night;
            if (i == 0) {
                this.mOffsetY = UIUtils.dip2px(76.0f);
                int i2 = this.mAlign;
                if (i2 == 1) {
                    this.mOffsetX = UIUtils.dip2px(-59.0f);
                } else if (i2 == 2) {
                    this.mOffsetX = UIUtils.dip2px(59.0f);
                }
            } else if (i != 1) {
                if (i == 3) {
                    this.mOffsetX = UIUtils.dip2px(52.0f);
                    this.mOffsetY = UIUtils.dip2px(22.5f);
                } else if (i != 4) {
                } else {
                    this.mOffsetX = UIUtils.dip2px(-52.0f);
                    this.mOffsetY = UIUtils.dip2px(22.5f);
                }
            } else {
                this.mOffsetY = UIUtils.dip2px(-30.0f);
                int i3 = this.mAlign;
                if (i3 == 1) {
                    this.mOffsetX = UIUtils.dip2px(-59.0f);
                } else if (i3 == 2) {
                    this.mOffsetX = UIUtils.dip2px(59.0f);
                }
            }
        }

        public XPopup build() {
            return new XPopup(this);
        }

        public Builder setAlign(int i) {
            this.mAlign = i;
            return this;
        }

        public Builder setArrowDownNightResId(int i) {
            this.arrowDownNightResId = i;
            setOffsetX(0);
            setOffsetY(0);
            return this;
        }

        public Builder setArrowDownResId(int i) {
            this.arrowDownResId = i;
            setOffsetX(0);
            setOffsetY(0);
            return this;
        }

        public Builder setArrowLeftNightResId(int i) {
            this.arrowLeftNightResId = i;
            setOffsetX(0);
            setOffsetY(0);
            return this;
        }

        public Builder setArrowLeftResId(int i) {
            this.arrowLeftResId = i;
            setOffsetX(0);
            setOffsetY(0);
            return this;
        }

        public Builder setArrowNoNightResId(int i) {
            this.arrowNoNightResId = i;
            setOffsetX(0);
            setOffsetY(0);
            return this;
        }

        public Builder setArrowNoResId(int i) {
            this.arrowNoResId = i;
            setOffsetX(0);
            setOffsetY(0);
            return this;
        }

        public Builder setArrowRightNightResId(int i) {
            this.arrowRightNightResId = i;
            setOffsetX(0);
            setOffsetY(0);
            return this;
        }

        public Builder setArrowRightResId(int i) {
            this.arrowRightResId = i;
            setOffsetX(0);
            setOffsetY(0);
            return this;
        }

        public Builder setArrowUpNightResId(int i) {
            this.arrowUpNightResId = i;
            setOffsetX(0);
            setOffsetY(0);
            return this;
        }

        public Builder setArrowUpResId(int i) {
            this.arrowUpResId = i;
            setOffsetX(0);
            setOffsetY(0);
            return this;
        }

        public Builder setBackgroundColor(int i) {
            this.mBackgroundColor = i;
            return this;
        }

        public Builder setElevation(float f) {
            this.mElevation = f;
            return this;
        }

        public Builder setGravity(int i) {
            this.mTextGravity = i;
            return this;
        }

        public Builder setOffsetX(int i) {
            this.mOffsetX = i;
            return this;
        }

        public Builder setOffsetY(int i) {
            this.mOffsetY = i;
            return this;
        }

        public Builder setPosition(int i) {
            this.mPosition = i;
            return this;
        }

        public Builder setTextAppearance(int i) {
            this.mTextAppearanceStyle = i;
            return this;
        }

        public Builder setTextAppearanceNight(int i) {
            this.mTextAppearanceStyleNight = i;
            return this;
        }

        public Builder setTypeface(Typeface typeface) {
            this.mTypeface = typeface;
            return this;
        }

        public Builder withArrow(boolean z) {
            this.mArrow = z;
            return this;
        }

        public Builder(Context context, View view, ViewGroup viewGroup, View view2, int i) {
            this(context, view, viewGroup, "", i);
            this.mCustomView = view2;
        }
    }
}
