package com.xiaopeng.xui.widgets;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.interpolator.EaseCubicInterpolator;
import com.xiaopeng.xui.theme.ThemeWatcher;
/* loaded from: classes.dex */
public class XSwitcher extends View implements ThemeWatcher.OnThemeSwitchListener {
    private static final int STATE_OFF = 0;
    private static final int STATE_ON = 1;
    int bg_off;
    int bg_off_dis;
    int bg_off_night;
    int bg_off_night_dis;
    int bg_on;
    int bg_on_dis;
    int bg_on_night;
    int bg_on_night_dis;
    private boolean changeImmediately;
    private Drawable drawableBgOff;
    private Drawable drawableBgOn;
    private Drawable drawableFg;
    int fg;
    private int fgButtom;
    private int fgLeft;
    private int fgRight;
    private int fgTop;
    int fg_dis;
    int fg_night;
    int fg_night_dis;
    private int measuredHeight;
    private int measuredWidth;
    private int measuredfgH;
    private int measuredfgW;
    private OnSwitchListener onSwitchListener;
    private int state;

    /* loaded from: classes.dex */
    public interface OnSwitchListener {
        void onSwitch(View view, boolean z);
    }

    public XSwitcher(Context context) {
        this(context, null);
    }

    private void init() {
        super.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.xui.widgets.XSwitcher.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (XSwitcher.this.state == 0) {
                    if (XSwitcher.this.changeImmediately) {
                        XSwitcher.this.state = 1;
                        XSwitcher.this.onSwitchOn(true);
                    }
                    if (XSwitcher.this.onSwitchListener != null) {
                        XSwitcher.this.onSwitchListener.onSwitch(XSwitcher.this, true);
                    }
                } else if (XSwitcher.this.state == 1) {
                    if (XSwitcher.this.changeImmediately) {
                        XSwitcher.this.state = 0;
                        XSwitcher.this.onSwitchOff(true);
                    }
                    if (XSwitcher.this.onSwitchListener != null) {
                        XSwitcher.this.onSwitchListener.onSwitch(XSwitcher.this, false);
                    }
                }
            }
        });
        updateByTheme();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSwitchOff(boolean z) {
        if (z) {
            startFgAnimation(0, this.measuredWidth - this.measuredfgW, 0);
            return;
        }
        this.fgLeft = 0;
        this.fgRight = 0 + this.measuredfgW;
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSwitchOn(boolean z) {
        if (z) {
            startFgAnimation(1, 0, this.measuredWidth - this.measuredfgW);
            return;
        }
        int i = this.measuredWidth;
        int i2 = this.measuredfgW;
        int i3 = i - i2;
        this.fgLeft = i3;
        this.fgRight = i3 + i2;
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        int i = this.state;
        if (i == 1) {
            onSwitchOn(false);
        } else if (i == 0) {
            onSwitchOff(false);
        }
    }

    private void startFgAnimation(final int i, int i2, int i3) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
        ofInt.setDuration(200L);
        ofInt.setInterpolator(new EaseCubicInterpolator(0.2f, 0.0f, 0.2f, 1.0f));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.xui.widgets.XSwitcher.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (XSwitcher.this.state != i) {
                    XSwitcher.this.reset();
                    return;
                }
                XSwitcher.this.fgLeft = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                XSwitcher xSwitcher = XSwitcher.this;
                xSwitcher.fgRight = xSwitcher.fgLeft + XSwitcher.this.measuredfgW;
                XSwitcher.this.postInvalidate();
            }
        });
        ofInt.start();
    }

    private void updateByTheme() {
        if (!ThemeWatcher.getInstance().isNight()) {
            if (isEnabled()) {
                this.drawableBgOn = getContext().getResources().getDrawable(this.bg_on);
                this.drawableBgOff = getContext().getResources().getDrawable(this.bg_off);
                this.drawableFg = getContext().getResources().getDrawable(this.fg);
            } else {
                this.drawableBgOn = getContext().getResources().getDrawable(this.bg_on_dis);
                this.drawableBgOff = getContext().getResources().getDrawable(this.bg_off_dis);
                this.drawableFg = getContext().getResources().getDrawable(this.fg_dis);
            }
        } else if (isEnabled()) {
            this.drawableBgOn = getContext().getResources().getDrawable(this.bg_on_night);
            this.drawableBgOff = getContext().getResources().getDrawable(this.bg_off_night);
            this.drawableFg = getContext().getResources().getDrawable(this.fg_night);
        } else {
            this.drawableBgOn = getContext().getResources().getDrawable(this.bg_on_night_dis);
            this.drawableBgOff = getContext().getResources().getDrawable(this.bg_off_night_dis);
            this.drawableFg = getContext().getResources().getDrawable(this.fg_night_dis);
        }
        postInvalidate();
    }

    public boolean getSwitchState() {
        int i = this.state;
        return i != 0 && i == 1;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcher.getInstance().removeThemeListener(this);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.state;
        if (i == 1) {
            this.drawableBgOn.setBounds(0, 0, this.measuredWidth, this.measuredHeight);
            this.drawableBgOn.draw(canvas);
            this.drawableFg.setBounds(this.fgLeft, this.fgTop, this.fgRight, this.fgButtom);
            this.drawableFg.draw(canvas);
        } else if (i == 0) {
            this.drawableBgOff.setBounds(0, 0, this.measuredWidth, this.measuredHeight);
            this.drawableBgOff.draw(canvas);
            this.drawableFg.setBounds(this.fgLeft, this.fgTop, this.fgRight, this.fgButtom);
            this.drawableFg.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            this.measuredWidth = this.drawableBgOn.getIntrinsicWidth();
        } else {
            this.measuredWidth = View.MeasureSpec.getSize(i);
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.measuredHeight = this.drawableBgOn.getIntrinsicHeight();
        } else {
            this.measuredHeight = View.MeasureSpec.getSize(i2);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.measuredWidth, mode), View.MeasureSpec.makeMeasureSpec(this.measuredHeight, mode2));
        this.measuredfgH = this.measuredHeight;
        float intrinsicWidth = this.drawableFg.getIntrinsicWidth() / this.drawableFg.getIntrinsicHeight();
        int i3 = this.measuredfgH;
        int i4 = (int) (intrinsicWidth * i3);
        this.measuredfgW = i4;
        int i5 = this.state;
        if (i5 == 1) {
            int i6 = this.measuredWidth - i4;
            this.fgLeft = i6;
            this.fgTop = 0;
            this.fgRight = i6 + i4;
            this.fgButtom = 0 + i3;
        } else if (i5 == 0) {
            this.fgLeft = 0;
            this.fgTop = 0;
            this.fgRight = i4 + 0;
            this.fgButtom = 0 + i3;
        }
    }

    @Override // com.xiaopeng.xui.theme.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        updateByTheme();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (z == isEnabled()) {
            return;
        }
        super.setEnabled(z);
        updateByTheme();
        postInvalidate();
    }

    public void setOnSwitchListener(OnSwitchListener onSwitchListener) {
        setOnSwitchListener(onSwitchListener, true);
    }

    public void setSwitchState(boolean z) {
        if (this.state == z) {
            return;
        }
        updateByTheme();
        if (z && this.state == 0) {
            this.state = 1;
            onSwitchOn(false);
        } else if (!z && this.state == 1) {
            this.state = 0;
            onSwitchOff(false);
        }
        postInvalidate();
    }

    public XSwitcher(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnSwitchListener(OnSwitchListener onSwitchListener, boolean z) {
        this.onSwitchListener = onSwitchListener;
        this.changeImmediately = z;
    }

    public XSwitcher(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.state = 0;
        this.changeImmediately = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.xui_XSwitcher);
        int i2 = R.styleable.xui_XSwitcher_xui_XSwitcher_bg_on_day;
        this.bg_on = obtainStyledAttributes.getResourceId(i2, R.mipmap.xswitch_bg_on_day);
        int i3 = R.styleable.xui_XSwitcher_xui_XSwitcher_bg_off_day;
        this.bg_off = obtainStyledAttributes.getResourceId(i3, R.mipmap.xswitch_bg_off_day);
        int i4 = R.styleable.xui_XSwitcher_xui_XSwitcher_fg_day;
        this.fg = obtainStyledAttributes.getResourceId(i4, R.mipmap.xswitch_fg_day);
        this.bg_on_night = obtainStyledAttributes.getResourceId(i2, R.mipmap.xswitch_bg_on_night);
        this.bg_off_night = obtainStyledAttributes.getResourceId(i3, R.mipmap.xswitch_bg_off_night);
        this.fg_night = obtainStyledAttributes.getResourceId(i4, R.mipmap.xswitch_fg_night);
        this.bg_on_dis = R.mipmap.xswitch_bg_on_day_disable;
        this.bg_off_dis = R.mipmap.xswitch_bg_off_day_disable;
        this.fg_dis = R.mipmap.xswitch_fg_day_disable;
        this.bg_on_night_dis = R.mipmap.xswitch_bg_on_night_disable;
        this.bg_off_night_dis = R.mipmap.xswitch_bg_off_night_disable;
        this.fg_night_dis = R.mipmap.xswitch_fg_night_disable;
        obtainStyledAttributes.recycle();
        this.drawableBgOn = context.getResources().getDrawable(this.bg_on);
        this.drawableBgOff = context.getResources().getDrawable(this.bg_off);
        this.drawableFg = context.getResources().getDrawable(this.fg);
        init();
    }
}
