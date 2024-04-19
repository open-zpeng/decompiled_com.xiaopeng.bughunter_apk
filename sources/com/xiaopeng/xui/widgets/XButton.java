package com.xiaopeng.xui.widgets;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.anims.XAnimator;
import com.xiaopeng.xui.drawable.XGradientDrawable;
import com.xiaopeng.xui.drawable.XInvertColorDrawable;
import com.xiaopeng.xui.interpolator.EaseCubicInterpolator;
import com.xiaopeng.xui.theme.ThemeWatcher;
import com.xiaopeng.xui.theme.XTheme;
import com.xiaopeng.xui.utils.UIUtils;
/* loaded from: classes.dex */
public class XButton extends TextView implements ThemeWatcher.OnThemeSwitchListener {
    public static final int ANIM_ZOOM_IN = 1;
    public static final int ANIM_ZOOM_OUT = 2;
    public static final int TYPE_CIRCLE = 1;
    public static final int TYPE_ROUND_CORNER = 2;
    private boolean hasRegisterToThemeWatcher;
    private int mAnim;
    private ColorStateList mBackgroundColor;
    private int mBackgroundDrawablePadding;
    private int mBackgroundDrawablePaddingBottom;
    private int mBackgroundDrawablePaddingLeft;
    private int mBackgroundDrawablePaddingRight;
    private int mBackgroundDrawablePaddingTop;
    private Drawable mContentDrawable;
    private int mCurrentThemeType;
    private int mDisplayType;
    private int mDrawableId;
    private int mDuration;
    private int mEndColor;
    private float mEndScale;
    private final boolean mFontSizeChangeBySystem;
    private boolean mHasSetOnClickListener;
    private boolean mInvert;
    private Drawable mOriginalBackground;
    private float mRadius;
    private int mStartColor;
    private float mStartScale;
    private int mStrokeColor;
    private int mStrokeWidth;
    private float mTextSize;
    private XTheme mTheme;
    private int mThemeResId;

    public XButton(Context context) {
        this(context, null);
    }

    private void adaptBackground(Drawable drawable) {
        if (drawable == null) {
            drawable = newBackground();
        }
        if (useReplacedBackground()) {
            setOriginalBackground(drawable);
            setBackground(null);
            return;
        }
        setBackground(drawable);
    }

    private void adaptFontSize() {
        if (this.mFontSizeChangeBySystem) {
            return;
        }
        this.mTextSize = getTextSize() / UIUtils.getFontScale();
    }

    private void adaptTheme() {
        int i = this.mThemeResId;
        if (i > 0) {
            setTheme(i);
        }
    }

    protected Drawable createDrawableContent(int i) {
        if (i > 0) {
            try {
                Drawable b = l2.b(getContext(), i);
                this.mContentDrawable = b;
                if (this.mInvert && (b instanceof BitmapDrawable)) {
                    this.mContentDrawable = new XInvertColorDrawable(getResources(), BitmapFactory.decodeResource(getResources(), i));
                }
                return this.mContentDrawable;
            } catch (Resources.NotFoundException unused) {
                return null;
            }
        }
        return null;
    }

    protected void drawDrawableContent(Canvas canvas) {
        Drawable drawable = this.mContentDrawable;
        if (drawable != null) {
            int intrinsicWidth = ((int) (drawable.getIntrinsicWidth() * UIUtils.getScreenDensity())) / 2;
            int intrinsicHeight = ((int) (this.mContentDrawable.getIntrinsicHeight() * UIUtils.getScreenDensity())) / 2;
            this.mContentDrawable.setBounds((getMeasuredWidth() / 2) - intrinsicWidth, (getMeasuredHeight() / 2) - intrinsicHeight, (getMeasuredWidth() / 2) + intrinsicWidth, (getMeasuredHeight() / 2) + intrinsicHeight);
            this.mContentDrawable.setState(getDrawableState());
            if (this.mInvert) {
                Drawable drawable2 = this.mContentDrawable;
                if (drawable2 instanceof XInvertColorDrawable) {
                    ((XInvertColorDrawable) drawable2).setInvert(ThemeWatcher.getInstance().isNight());
                }
            }
            this.mContentDrawable.draw(canvas);
        }
    }

    public ColorStateList getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getBackgroundDrawablePadding() {
        return this.mBackgroundDrawablePadding;
    }

    public int getBackgroundDrawablePaddingBottom() {
        return this.mBackgroundDrawablePaddingBottom;
    }

    public int getBackgroundDrawablePaddingLeft() {
        return this.mBackgroundDrawablePaddingLeft;
    }

    public int getBackgroundDrawablePaddingRight() {
        return this.mBackgroundDrawablePaddingRight;
    }

    public int getBackgroundDrawablePaddingTop() {
        return this.mBackgroundDrawablePaddingTop;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public float getEndScale() {
        return this.mEndScale;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable getOriginalBackground() {
        return this.mOriginalBackground;
    }

    public float getRadius() {
        return this.mRadius;
    }

    public float getStartScale() {
        return this.mStartScale;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }

    public int getStrokeWidth() {
        return this.mStrokeWidth;
    }

    protected Drawable newBackground() {
        XGradientDrawable xGradientDrawable = new XGradientDrawable();
        xGradientDrawable.setCornerRadius(getRadius());
        xGradientDrawable.setStroke(getStrokeWidth(), getStrokeColor());
        xGradientDrawable.setPadding(this.mBackgroundDrawablePaddingLeft, this.mBackgroundDrawablePaddingTop, this.mBackgroundDrawablePaddingRight, this.mBackgroundDrawablePaddingBottom);
        if (this.mStartColor != Integer.MIN_VALUE && this.mEndColor != Integer.MIN_VALUE) {
            int i = this.mDisplayType;
            if (i == 2) {
                xGradientDrawable.setGradientType(0);
                xGradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            } else if (i == 1) {
                xGradientDrawable.setGradientType(1);
                xGradientDrawable.setGradientRadius(getRadius());
            }
            xGradientDrawable.setColors(new int[]{this.mStartColor, this.mEndColor});
        } else {
            xGradientDrawable.setColorStateList(getBackgroundColor());
        }
        return xGradientDrawable;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        adaptTheme();
        setIsNight(ThemeWatcher.getInstance().isNight());
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        XTheme xTheme = this.mTheme;
        if (xTheme != null) {
            xTheme.release();
            this.mTheme = null;
        }
        ThemeWatcher.getInstance().removeThemeListener(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.mFontSizeChangeBySystem) {
            getPaint().setTextSize(this.mTextSize);
        }
        if (useReplacedBackground()) {
            onDrawBackground(canvas);
        }
        super.onDraw(canvas);
        drawDrawableContent(canvas);
    }

    protected void onDrawBackground(Canvas canvas) {
    }

    protected void onPreJudgeInitialize() {
        int i = this.mAnim;
        if (i == 1) {
            setDuration(100);
            setStartScale(1.0f);
            setEndScale(1.2f);
        } else if (i == 2) {
            setDuration(100);
            setStartScale(1.0f);
            setEndScale(0.9f);
        }
    }

    protected void onPressDown() {
        Drawable background = getBackground();
        if (background != null) {
            background.setState(getDrawableState());
            new XAnimator.Builder().interpolator(new EaseCubicInterpolator()).animators(ObjectAnimator.ofFloat(this, View.SCALE_X, getStartScale(), getEndScale()), ObjectAnimator.ofFloat(this, View.SCALE_Y, getStartScale(), getEndScale())).target(this).duration(getDuration()).start();
        }
    }

    protected void onPressUp() {
        Drawable background = getBackground();
        if (background != null) {
            background.setState(getDrawableState());
            new XAnimator.Builder().interpolator(new EaseCubicInterpolator()).animators(ObjectAnimator.ofFloat(this, View.SCALE_X, getEndScale(), getStartScale()), ObjectAnimator.ofFloat(this, View.SCALE_Y, getEndScale(), getStartScale())).target(this).duration(getDuration()).start();
        }
    }

    protected void onRender() {
        postInvalidate();
    }

    @Override // com.xiaopeng.xui.theme.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        setIsNight(ThemeWatcher.getInstance().isNight());
    }

    protected void onThemeSwitch(int i) {
        XTheme xTheme = this.mTheme;
        if (xTheme == null || i == this.mCurrentThemeType) {
            return;
        }
        this.mCurrentThemeType = i;
        XTheme.ViewTheme theme = xTheme.getTheme(i == 2 ? "night" : "day");
        if (theme != null) {
            int attrResourceId = theme.getAttrResourceId("xui_backgroundColor");
            int attrResourceId2 = theme.getAttrResourceId("xui_strokeWidth");
            int attrResourceId3 = theme.getAttrResourceId("xui_strokeColor");
            int attrResourceId4 = theme.getAttrResourceId("xui_drawable");
            int attrResourceId5 = theme.getAttrResourceId("textColor");
            int attrResourceId6 = theme.getAttrResourceId("drawableLeft");
            int attrResourceId7 = theme.getAttrResourceId("drawableTop");
            int attrResourceId8 = theme.getAttrResourceId("drawableRight");
            int attrResourceId9 = theme.getAttrResourceId("drawableBottom");
            int attrResourceId10 = theme.getAttrResourceId("background");
            this.mBackgroundColor = attrResourceId > 0 ? getResources().getColorStateList(attrResourceId) : this.mBackgroundColor;
            this.mStrokeWidth = attrResourceId2 > 0 ? getResources().getDimensionPixelSize(attrResourceId2) : this.mStrokeWidth;
            this.mStrokeColor = attrResourceId3 > 0 ? getResources().getColor(attrResourceId3) : this.mStrokeColor;
            if (attrResourceId4 <= 0) {
                attrResourceId4 = this.mDrawableId;
            }
            this.mDrawableId = attrResourceId4;
            this.mContentDrawable = createDrawableContent(attrResourceId4);
            Drawable[] compoundDrawables = getCompoundDrawables();
            setCompoundDrawablesWithIntrinsicBounds(attrResourceId6 > 0 ? getResources().getDrawable(attrResourceId6) : compoundDrawables[0], attrResourceId7 > 0 ? getResources().getDrawable(attrResourceId7) : compoundDrawables[1], attrResourceId8 > 0 ? getResources().getDrawable(attrResourceId8) : compoundDrawables[2], attrResourceId9 > 0 ? getResources().getDrawable(attrResourceId9) : compoundDrawables[3]);
            setTextColor(attrResourceId5 > 0 ? getResources().getColorStateList(attrResourceId5) : getTextColors());
            if (attrResourceId10 > 0) {
                adaptBackground(getResources().getDrawable(attrResourceId10));
            } else {
                adaptBackground(null);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((!this.mHasSetOnClickListener || isClickable()) && isEnabled()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                setPressed(true);
                onPressDown();
            } else if (action == 1) {
                setPressed(false);
                onPressUp();
                performClick();
            } else if (action == 3 || action == 4) {
                setPressed(false);
                onPressUp();
            }
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setEndScale(float f) {
        this.mEndScale = f;
    }

    public void setIsNight(boolean z) {
        onThemeSwitch(z ? 2 : 1);
        onRender();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.mHasSetOnClickListener = true;
    }

    protected void setOriginalBackground(Drawable drawable) {
        this.mOriginalBackground = drawable;
    }

    public void setStartScale(float f) {
        this.mStartScale = f;
    }

    @Override // android.widget.TextView
    public void setTextSize(float f) {
        super.setTextSize(f);
        adaptFontSize();
    }

    public void setTheme(int i) {
        if (this.mTheme == null || this.mThemeResId != i) {
            XTheme createFromXml = XTheme.createFromXml(getResources().getXml(i));
            this.mTheme = createFromXml;
            if (createFromXml == null || this.hasRegisterToThemeWatcher) {
                return;
            }
            this.mThemeResId = i;
            ThemeWatcher.getInstance().addThemeSwitchListener(this);
            this.hasRegisterToThemeWatcher = true;
        }
    }

    protected boolean useReplacedBackground() {
        return false;
    }

    public XButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Xui_Common);
        this.mRadius = obtainStyledAttributes.getDimension(R.styleable.Xui_Common_xui_radius, 0.0f);
        this.mStrokeColor = obtainStyledAttributes.getColor(R.styleable.Xui_Common_xui_strokeColor, 0);
        this.mStrokeWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Xui_Common_xui_strokeWidth, 0);
        this.mBackgroundColor = getResources().getColorStateList(obtainStyledAttributes.getResourceId(R.styleable.Xui_Common_xui_backgroundColor, R.color.xui_white));
        this.mDrawableId = obtainStyledAttributes.getResourceId(R.styleable.Xui_Common_xui_drawable, 0);
        this.mInvert = obtainStyledAttributes.getBoolean(R.styleable.Xui_Common_xui_invert, false);
        this.mThemeResId = obtainStyledAttributes.getResourceId(R.styleable.Xui_Common_xui_theme, 0);
        this.mStartScale = obtainStyledAttributes.getFloat(R.styleable.Xui_Common_xui_startScale, 1.0f);
        this.mEndScale = obtainStyledAttributes.getFloat(R.styleable.Xui_Common_xui_endScale, 1.0f);
        this.mAnim = obtainStyledAttributes.getInt(R.styleable.Xui_Common_xui_anim, 2);
        this.mDuration = obtainStyledAttributes.getInt(R.styleable.Xui_Common_xui_duration, 200);
        this.mDisplayType = obtainStyledAttributes.getInt(R.styleable.Xui_Common_xui_display, 2);
        this.mStartColor = obtainStyledAttributes.getColor(R.styleable.Xui_Common_xui_startColor, Integer.MIN_VALUE);
        this.mEndColor = obtainStyledAttributes.getColor(R.styleable.Xui_Common_xui_endColor, Integer.MIN_VALUE);
        this.mBackgroundDrawablePadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Xui_Common_xui_backgroundPadding, 0);
        this.mFontSizeChangeBySystem = obtainStyledAttributes.getBoolean(R.styleable.Xui_Common_xui_font_size_system, false);
        obtainStyledAttributes.recycle();
        int i2 = this.mBackgroundDrawablePadding;
        this.mBackgroundDrawablePaddingLeft = i2;
        this.mBackgroundDrawablePaddingRight = i2;
        this.mBackgroundDrawablePaddingTop = i2;
        this.mBackgroundDrawablePaddingBottom = i2;
        onPreJudgeInitialize();
        adaptFontSize();
        adaptTheme();
        adaptBackground(getBackground());
    }
}
