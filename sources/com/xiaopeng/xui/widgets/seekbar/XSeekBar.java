package com.xiaopeng.xui.widgets.seekbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.interpolator.EaseCubicInterpolator;
import com.xiaopeng.xui.theme.ThemeWatcher;
import com.xiaopeng.xui.utils.UIUtils;
/* loaded from: classes.dex */
public class XSeekBar extends View implements ThemeWatcher.OnThemeSwitchListener {
    private static long ANIM_DURATION = 200;
    public static final int HORIZONTAL = 1;
    private static final String TAG = "XSeekBar";
    public static final int VERTICAL = 2;
    private ValueAnimator mActionDownAnimator;
    private ValueAnimator mActionUpAnimator;
    private int mBackgroundColor;
    private float mCanvasScale;
    private int mMax;
    private int mMin;
    private OnXSeekBarChangeListener mOnXSeekBarChangedListener;
    private int mOrientation;
    private int mProgress;
    private Paint mProgressPaint;
    private boolean mRotateThumb;
    private float mScaleRate;
    private float mScrollDistance;
    private int mSecondProgress;
    private int mSecondProgressColor;
    private float mSecondScrollDistance;
    private int mSelectedColor;
    private Bitmap mThumb;
    private Bitmap mThumbBitmap;
    private float mThumbMaxHeight;
    private float mThumbMaxWidth;
    private float mThumbOffset;
    private Paint mThumbPaint;
    private Bitmap mThumbPressed;
    private int mUnSelectedColor;

    /* loaded from: classes.dex */
    public interface OnXSeekBarChangeListener {
        void onProgressChanged(XSeekBar xSeekBar, int i, boolean z);

        void onStartTrackingTouch(XSeekBar xSeekBar);

        void onStopTrackingTouch(XSeekBar xSeekBar);
    }

    public XSeekBar(Context context) {
        this(context, null);
    }

    private void calculateProgress() {
        int i;
        float f = this.mThumbOffset;
        float measuredWidth = (getMeasuredWidth() - f) - f;
        float f2 = this.mScrollDistance;
        if (f2 > getMeasuredWidth() - (this.mThumbMaxWidth / 2.0f)) {
            f2 = getMeasuredWidth() - (this.mThumbMaxWidth / 2.0f);
        }
        float f3 = f2 - f;
        if (this.mOrientation == 2) {
            float f4 = this.mThumbOffset;
            measuredWidth = (getMeasuredHeight() - f4) - f4;
            float f5 = this.mScrollDistance;
            if (f5 > getMeasuredHeight() - (this.mThumbMaxWidth / 2.0f)) {
                f5 = getMeasuredHeight() - (this.mThumbMaxWidth / 2.0f);
            }
            f3 = f5 - f4;
        }
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        this.mProgress = (int) (this.mMin + (((this.mMax - i) * f3) / measuredWidth));
    }

    private void drawHorizontal(Canvas canvas) {
        float measuredWidth;
        float f;
        Bitmap bitmap;
        int dip2px = UIUtils.dip2px(4.0f);
        float f2 = this.mThumbOffset;
        float measuredHeight = (getMeasuredHeight() - dip2px) / 2;
        float f3 = dip2px + measuredHeight;
        this.mProgressPaint.setColor(this.mUnSelectedColor);
        canvas.drawRoundRect(new RectF(f2, measuredHeight, getMeasuredWidth() - f2, f3), 2.0f, 2.0f, this.mProgressPaint);
        if (this.mSecondProgressColor != 0 && this.mSecondProgress > 0) {
            float f4 = this.mSecondScrollDistance;
            if (f4 > getMeasuredWidth() - (this.mThumbMaxWidth / 2.0f)) {
                f4 = getMeasuredWidth() - (this.mThumbMaxWidth / 2.0f);
            }
            this.mProgressPaint.setColor(this.mSecondProgressColor);
            canvas.drawRoundRect(new RectF(f2, measuredHeight, f4, f3), 2.0f, 2.0f, this.mProgressPaint);
        }
        float f5 = this.mScrollDistance;
        if (f5 > getMeasuredWidth() - (this.mThumbMaxWidth / 2.0f)) {
            f5 = getMeasuredWidth() - (this.mThumbMaxWidth / 2.0f);
        }
        this.mProgressPaint.setColor(this.mSelectedColor);
        canvas.drawRoundRect(new RectF(f2, measuredHeight, f5, f3), 2.0f, 2.0f, this.mProgressPaint);
        float width = this.mScrollDistance - (this.mThumbBitmap.getWidth() / 2);
        float height = (getHeight() - this.mThumbBitmap.getHeight()) / 2;
        float f6 = this.mScrollDistance;
        float f7 = this.mThumbOffset;
        if (f6 < f7) {
            width = this.mThumbBitmap == this.mThumb ? f7 - (bitmap.getWidth() / 2) : 0.0f;
        }
        if (this.mScrollDistance > getMeasuredWidth() - this.mThumbOffset) {
            if (this.mThumbBitmap == this.mThumb) {
                measuredWidth = getMeasuredWidth() - (this.mThumbMaxWidth / 2.0f);
                f = this.mThumb.getWidth() / 2;
            } else {
                measuredWidth = getMeasuredWidth();
                f = this.mThumbMaxWidth;
            }
            width = measuredWidth - f;
        }
        canvas.save();
        float f8 = this.mCanvasScale;
        canvas.scale(f8, f8, (this.mThumbBitmap.getWidth() / 2) + width, (this.mThumbBitmap.getHeight() / 2) + height);
        canvas.drawBitmap(this.mThumbBitmap, width, height, this.mThumbPaint);
        canvas.restore();
    }

    private void drawVertical(Canvas canvas) {
        int measuredHeight;
        Bitmap bitmap;
        float measuredWidth = (getMeasuredWidth() - UIUtils.dip2px(4.0f)) / 2;
        float f = this.mThumbOffset;
        float measuredWidth2 = getMeasuredWidth() - measuredWidth;
        this.mProgressPaint.setColor(this.mUnSelectedColor);
        canvas.drawRoundRect(new RectF(measuredWidth, f, measuredWidth2, getMeasuredHeight() - f), 2.0f, 2.0f, this.mProgressPaint);
        if (this.mSecondProgressColor != 0 && this.mSecondProgress > 0) {
            float f2 = this.mSecondScrollDistance;
            if (f2 > getMeasuredHeight() - (this.mThumbMaxWidth / 2.0f)) {
                f2 = getMeasuredHeight() - (this.mThumbMaxWidth / 2.0f);
            }
            this.mProgressPaint.setColor(this.mSecondProgressColor);
            canvas.drawRoundRect(new RectF(measuredWidth, f, measuredWidth2, f2), 2.0f, 2.0f, this.mProgressPaint);
        }
        float f3 = this.mScrollDistance;
        if (f3 > getMeasuredHeight() - (this.mThumbMaxWidth / 2.0f)) {
            f3 = getMeasuredHeight() - (this.mThumbMaxWidth / 2.0f);
        }
        this.mProgressPaint.setColor(this.mSelectedColor);
        canvas.drawRoundRect(new RectF(measuredWidth, f, measuredWidth2, f3), 2.0f, 2.0f, this.mProgressPaint);
        float measuredWidth3 = (getMeasuredWidth() / 2) - (this.mThumbBitmap.getWidth() / 2);
        float height = this.mScrollDistance - (this.mThumbBitmap.getHeight() / 2);
        float f4 = this.mScrollDistance;
        float f5 = this.mThumbOffset;
        if (f4 < f5) {
            height = this.mThumbBitmap == this.mThumb ? f5 - (bitmap.getHeight() / 2) : 0.0f;
        }
        if (this.mScrollDistance > getMeasuredHeight() - this.mThumbOffset) {
            int max = Math.max(this.mThumb.getHeight(), this.mThumbPressed.getHeight());
            if (this.mThumbBitmap == this.mThumb) {
                measuredHeight = getMeasuredHeight() - (max / 2);
                max = this.mThumb.getHeight() / 2;
            } else {
                measuredHeight = getMeasuredHeight();
            }
            height = measuredHeight - max;
        }
        canvas.save();
        float f6 = this.mCanvasScale;
        canvas.scale(f6, f6, (this.mThumbBitmap.getWidth() / 2) + measuredWidth3, (this.mThumbBitmap.getHeight() / 2) + height);
        canvas.drawBitmap(this.mThumbBitmap, measuredWidth3, height, this.mThumbPaint);
        canvas.restore();
    }

    private void init() {
        Paint paint = new Paint(1);
        this.mProgressPaint = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.mProgressPaint.setColor(UIUtils.getColor(R.color.x_bar_unselected_color_day));
        this.mProgressPaint.setStrokeWidth(4.0f);
        this.mThumbPaint = new Paint(1);
        setIsNight(ThemeWatcher.getInstance().isNight());
    }

    private void initThumbValue() {
        this.mThumbMaxWidth = Math.max(this.mThumb.getWidth(), this.mThumbPressed.getWidth());
        this.mThumbMaxHeight = Math.max(this.mThumb.getHeight(), this.mThumbPressed.getHeight());
        this.mThumbOffset = this.mThumbMaxWidth / 2.0f;
        Bitmap bitmap = this.mThumb;
        this.mThumbBitmap = bitmap;
        this.mScaleRate = ((bitmap.getWidth() * 1.0f) / this.mThumbPressed.getWidth()) * 2.15f;
    }

    private Bitmap rotateBitmap(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate(f, width / 2, height / 2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        if (createBitmap.equals(bitmap)) {
            return createBitmap;
        }
        bitmap.recycle();
        return createBitmap;
    }

    private void rotateThumb() {
        float f = this.mRotateThumb ? 90 : 0;
        this.mThumb = rotateBitmap(this.mThumb, f);
        this.mThumbPressed = rotateBitmap(this.mThumbPressed, f);
        this.mThumbBitmap = this.mThumb;
    }

    private void startActionDownAnimation() {
        ValueAnimator valueAnimator = this.mActionDownAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator.ofFloat(new float[0]);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.mScaleRate, 1.0f);
        this.mActionDownAnimator = ofFloat;
        ofFloat.setInterpolator(new EaseCubicInterpolator());
        this.mActionDownAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.xui.widgets.seekbar.XSeekBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                XSeekBar.this.mCanvasScale = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                XSeekBar.this.invalidate();
            }
        });
        this.mActionDownAnimator.setDuration(ANIM_DURATION);
        this.mActionDownAnimator.start();
    }

    private void startActionUpAnimation() {
        ValueAnimator valueAnimator = this.mActionUpAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator.ofFloat(new float[0]);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, this.mScaleRate);
        this.mActionUpAnimator = ofFloat;
        ofFloat.setInterpolator(new EaseCubicInterpolator());
        this.mActionUpAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.xui.widgets.seekbar.XSeekBar.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                XSeekBar.this.mCanvasScale = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                XSeekBar.this.invalidate();
            }
        });
        this.mActionUpAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.xiaopeng.xui.widgets.seekbar.XSeekBar.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                XSeekBar xSeekBar = XSeekBar.this;
                xSeekBar.mThumbBitmap = xSeekBar.mThumb;
                XSeekBar.this.mCanvasScale = 1.0f;
                XSeekBar.this.invalidate();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                XSeekBar xSeekBar = XSeekBar.this;
                xSeekBar.mThumbBitmap = xSeekBar.mThumbPressed;
            }
        });
        this.mActionUpAnimator.setDuration(ANIM_DURATION);
        this.mActionUpAnimator.start();
    }

    public int getMax() {
        return this.mMax;
    }

    public int getMin() {
        return this.mMin;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public int getSecondProgress() {
        return this.mSecondProgress;
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
        int i = this.mBackgroundColor;
        if (i != 0) {
            canvas.drawColor(i);
        }
        if (this.mOrientation == 2) {
            drawVertical(canvas);
        } else {
            drawHorizontal(canvas);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            float f = this.mThumbOffset;
            float measuredWidth = getMeasuredWidth() - (f * 2.0f);
            int i5 = this.mProgress;
            int i6 = this.mMin;
            this.mScrollDistance = (((measuredWidth * (i5 - i6)) * 1.0f) / (this.mMax - i6)) + f;
            float f2 = this.mThumbOffset;
            float measuredWidth2 = getMeasuredWidth() - (f2 * 2.0f);
            int i7 = this.mSecondProgress;
            int i8 = this.mMin;
            this.mSecondScrollDistance = (((measuredWidth2 * (i7 - i8)) * 1.0f) / (this.mMax - i8)) + f2;
            if (this.mOrientation == 2) {
                float f3 = this.mThumbOffset;
                float measuredHeight = getMeasuredHeight() - (f3 * 2.0f);
                int i9 = this.mProgress;
                int i10 = this.mMin;
                this.mScrollDistance = (((measuredHeight * (i9 - i10)) * 1.0f) / (this.mMax - i10)) + f3;
                float f4 = this.mThumbOffset;
                float measuredHeight2 = getMeasuredHeight() - (2.0f * f4);
                int i11 = this.mSecondProgress;
                int i12 = this.mMin;
                this.mSecondScrollDistance = (((measuredHeight2 * (i11 - i12)) * 1.0f) / (this.mMax - i12)) + f4;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        if (this.mOrientation == 2) {
            if (mode2 == Integer.MIN_VALUE) {
                size = (int) this.mThumbMaxHeight;
            }
        } else if (mode == Integer.MIN_VALUE) {
            size2 = (int) this.mThumbMaxHeight;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // com.xiaopeng.xui.theme.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        setIsNight(ThemeWatcher.getInstance().isNight());
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
        if (r0 != 3) goto L7;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            int r0 = r4.getAction()
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L62
            if (r0 == r2) goto L57
            if (r0 == r1) goto L11
            r4 = 3
            if (r0 == r4) goto L57
            goto L8c
        L11:
            float r0 = r4.getX()
            r3.mScrollDistance = r0
            int r0 = r3.mOrientation
            if (r0 != r1) goto L21
            float r4 = r4.getY()
            r3.mScrollDistance = r4
        L21:
            r3.calculateProgress()
            com.xiaopeng.xui.widgets.seekbar.XSeekBar$OnXSeekBarChangeListener r4 = r3.mOnXSeekBarChangedListener
            if (r4 == 0) goto L2d
            int r0 = r3.mProgress
            r4.onProgressChanged(r3, r0, r2)
        L2d:
            android.animation.ValueAnimator r4 = r3.mActionDownAnimator
            if (r4 == 0) goto L3c
            boolean r4 = r4.isRunning()
            if (r4 == 0) goto L3c
            android.animation.ValueAnimator r4 = r3.mActionDownAnimator
            r4.cancel()
        L3c:
            android.animation.ValueAnimator r4 = r3.mActionUpAnimator
            if (r4 == 0) goto L4b
            boolean r4 = r4.isRunning()
            if (r4 == 0) goto L4b
            android.animation.ValueAnimator r4 = r3.mActionUpAnimator
            r4.cancel()
        L4b:
            r4 = 1065353216(0x3f800000, float:1.0)
            r3.mCanvasScale = r4
            android.graphics.Bitmap r4 = r3.mThumbPressed
            r3.mThumbBitmap = r4
            r3.invalidate()
            goto L8c
        L57:
            r3.startActionUpAnimation()
            com.xiaopeng.xui.widgets.seekbar.XSeekBar$OnXSeekBarChangeListener r4 = r3.mOnXSeekBarChangedListener
            if (r4 == 0) goto L8c
            r4.onStopTrackingTouch(r3)
            goto L8c
        L62:
            float r0 = r4.getX()
            r3.mScrollDistance = r0
            int r0 = r3.mOrientation
            if (r0 != r1) goto L72
            float r4 = r4.getY()
            r3.mScrollDistance = r4
        L72:
            android.graphics.Bitmap r4 = r3.mThumbPressed
            r3.mThumbBitmap = r4
            r3.startActionDownAnimation()
            com.xiaopeng.xui.widgets.seekbar.XSeekBar$OnXSeekBarChangeListener r4 = r3.mOnXSeekBarChangedListener
            if (r4 == 0) goto L80
            r4.onStartTrackingTouch(r3)
        L80:
            r3.calculateProgress()
            com.xiaopeng.xui.widgets.seekbar.XSeekBar$OnXSeekBarChangeListener r4 = r3.mOnXSeekBarChangedListener
            if (r4 == 0) goto L8c
            int r0 = r3.mProgress
            r4.onProgressChanged(r3, r0, r2)
        L8c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.xui.widgets.seekbar.XSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAnimDuration(long j) {
        ANIM_DURATION = j;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    public void setIsNight(boolean z) {
        if (z) {
            this.mSelectedColor = UIUtils.getColor(R.color.x_bar_selected_color_night);
            this.mUnSelectedColor = UIUtils.getColor(R.color.x_bar_unselected_color_night);
            this.mThumb = BitmapFactory.decodeResource(getResources(), R.mipmap.xseekbar_thumb_night);
            this.mThumbPressed = BitmapFactory.decodeResource(getResources(), R.mipmap.xseekbar_thumb_pressed_night);
        } else {
            this.mSelectedColor = UIUtils.getColor(R.color.x_bar_selected_color_day);
            this.mUnSelectedColor = UIUtils.getColor(R.color.x_bar_unselected_color_day);
            this.mThumb = BitmapFactory.decodeResource(getResources(), R.mipmap.xseekbar_thumb_day);
            this.mThumbPressed = BitmapFactory.decodeResource(getResources(), R.mipmap.xseekbar_thumb_pressed_day);
        }
        initThumbValue();
        setOrientation(this.mOrientation);
    }

    public void setMax(int i) {
        if (i <= 0) {
            Log.e(TAG, "max must be more than 0.");
        } else {
            this.mMax = i;
        }
    }

    public void setMin(int i) {
        if (i < 0) {
            i = 0;
            Log.e(TAG, "min must be more than 0.");
        }
        this.mMin = i;
    }

    public void setOnXSeekBarChangedListener(OnXSeekBarChangeListener onXSeekBarChangeListener) {
        this.mOnXSeekBarChangedListener = onXSeekBarChangeListener;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
        if (i == 2) {
            rotateThumb();
        }
    }

    public void setProgress(int i) {
        if (i <= this.mMax && i >= this.mMin) {
            this.mProgress = i;
            int i2 = this.mOrientation;
            if (i2 == 1) {
                float f = this.mThumbOffset;
                float measuredWidth = getMeasuredWidth() - (2.0f * f);
                int i3 = this.mProgress;
                int i4 = this.mMin;
                this.mScrollDistance = (((measuredWidth * (i3 - i4)) * 1.0f) / (this.mMax - i4)) + f;
            } else if (i2 == 2) {
                float f2 = this.mThumbOffset;
                float measuredHeight = getMeasuredHeight() - (2.0f * f2);
                int i5 = this.mProgress;
                int i6 = this.mMin;
                this.mScrollDistance = (((measuredHeight * (i5 - i6)) * 1.0f) / (this.mMax - i6)) + f2;
            }
            OnXSeekBarChangeListener onXSeekBarChangeListener = this.mOnXSeekBarChangedListener;
            if (onXSeekBarChangeListener != null) {
                onXSeekBarChangeListener.onProgressChanged(this, i, false);
            }
            invalidate();
            return;
        }
        Log.e(TAG, "progress must between " + this.mMin + " and " + this.mMax);
    }

    public void setProgressColor(int i, int i2) {
        this.mUnSelectedColor = i;
        this.mSelectedColor = i2;
        invalidate();
    }

    public void setRotateThumb(boolean z) {
        this.mRotateThumb = z;
    }

    public void setScaleRate(float f) {
        this.mScaleRate = f;
    }

    public void setSecondProgress(int i) {
        if (i <= this.mMax && i >= this.mMin) {
            this.mSecondProgress = i;
            int i2 = this.mOrientation;
            if (i2 == 1) {
                float f = this.mThumbOffset;
                float measuredWidth = getMeasuredWidth() - (2.0f * f);
                int i3 = this.mSecondProgress;
                int i4 = this.mMin;
                this.mSecondScrollDistance = (((measuredWidth * (i3 - i4)) * 1.0f) / (this.mMax - i4)) + f;
            } else if (i2 == 2) {
                float f2 = this.mThumbOffset;
                float measuredHeight = getMeasuredHeight() - (2.0f * f2);
                int i5 = this.mSecondProgress;
                int i6 = this.mMin;
                this.mSecondScrollDistance = (((measuredHeight * (i5 - i6)) * 1.0f) / (this.mMax - i6)) + f2;
            }
            invalidate();
            return;
        }
        Log.e(TAG, "progress must between " + this.mMin + " and " + this.mMax);
    }

    public void setSecondProgressColor(int i) {
        this.mSecondProgressColor = i;
        invalidate();
    }

    public void setThumb(Bitmap bitmap) {
        this.mThumb = bitmap;
        this.mThumbBitmap = bitmap;
        initThumbValue();
        invalidate();
    }

    public void setThumbPressed(Bitmap bitmap) {
        this.mThumbPressed = bitmap;
        initThumbValue();
        invalidate();
    }

    public XSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOrientation = 1;
        this.mCanvasScale = 1.0f;
        this.mMax = 100;
        this.mMin = 0;
        this.mRotateThumb = true;
        init();
    }
}
