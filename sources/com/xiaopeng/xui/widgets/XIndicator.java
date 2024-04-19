package com.xiaopeng.xui.widgets;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.font.XFontHelper;
import com.xiaopeng.xui.interpolator.EaseCubicInterpolator;
import com.xiaopeng.xui.interpolator.SpringInterpolator;
import com.xiaopeng.xui.theme.ThemeWatcher;
import com.xiaopeng.xui.utils.ThreadUtils;
import com.xiaopeng.xui.utils.UIUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class XIndicator extends FrameLayout implements ThemeWatcher.OnThemeSwitchListener {
    private static final String TAG = "XIndicator";
    private int mBackground;
    private int mBackgroundDay;
    private int mBackgroundNight;
    private Drawable mBgDrawable;
    private Drawable mBgDrawableUnable;
    private boolean mBoldFake;
    private long mClickableInterval;
    private LinearLayout mContainer;
    private int mCoverBottomOffset;
    private Rect mCoverRect;
    private SparseArray<Drawable> mDrawableMap;
    private boolean mEnable;
    private boolean mFontSizeChangeBySystem;
    private int mHorizontalMargin;
    private Map<ImageView, ImageItem> mImageItemResMap;
    private InterceptClickFilter mInterceptFilter;
    private boolean mIsNinePatch;
    private int mItemHeight;
    private int mItemImgWidth;
    private int mItemWidth;
    private long mLastClickTime;
    private OnItemChangedListener mOnItemChangedListener;
    private int mSelectPosition;
    private Drawable mSelectedCover;
    private int mSelectedCoverDay;
    private NinePatch mSelectedCoverNiePatch;
    private NinePatch mSelectedCoverNiePatchDay;
    private NinePatch mSelectedCoverNiePatchNight;
    private int mSelectedCoverNight;
    private int mSelectedTextColor;
    private int mSelectedTextColorDay;
    private int mSelectedTextColorNight;
    private float mSelectedTextSize;
    private boolean mShowBg;
    private boolean mShowCover;
    private View mTargetView;
    private float mTextSize;
    private int mTranslateX;
    private int mUnAbleBgDay;
    private int mUnAbleBgNight;
    private int mUnSelectedTextColor;
    private int mUnSelectedTextColorDay;
    private int mUnSelectedTextColorNight;

    /* loaded from: classes.dex */
    public static class ClickInterceptor implements InterceptClickFilter {
        private int interceptIndex;

        public ClickInterceptor(int i) {
            this.interceptIndex = i;
        }

        @Override // com.xiaopeng.xui.widgets.XIndicator.InterceptClickFilter
        public boolean interceptClick() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ImageItem {
        private int mSelectedDay;
        private int mSelectedNight;
        private int mUnSelectedDay;
        private int mUnSelectedNight;

        public ImageItem(int i, int i2, int i3, int i4) {
            this.mSelectedDay = i;
            this.mSelectedNight = i2;
            this.mUnSelectedDay = i3;
            this.mUnSelectedNight = i4;
        }

        public int getSelected() {
            return ThemeWatcher.getInstance().isNight() ? this.mSelectedNight : this.mSelectedDay;
        }

        public int getUnSelected() {
            return ThemeWatcher.getInstance().isNight() ? this.mUnSelectedNight : this.mUnSelectedDay;
        }
    }

    /* loaded from: classes.dex */
    public interface InterceptClickFilter {
        boolean interceptClick();
    }

    /* loaded from: classes.dex */
    public interface OnItemChangedListener {
        void onItemChanged(View view, int i);
    }

    public XIndicator(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calculateAnimBounds(boolean z) {
        if (this.mTargetView != null) {
            if (z) {
                int dip2px = UIUtils.dip2px(6.0f);
                int dip2px2 = UIUtils.dip2px(27.0f);
                int i = this.mTranslateX - dip2px2;
                int top = this.mContainer.getTop() - dip2px;
                int width = this.mTargetView.getWidth() + i + (dip2px2 * 2);
                int height = this.mContainer.getHeight() + top + this.mCoverBottomOffset + dip2px;
                this.mCoverRect.set(i, top, width, height);
                this.mSelectedCover.setBounds(i, top, width, height);
            }
            this.mBgDrawable.setBounds(this.mContainer.getLeft(), this.mContainer.getTop(), this.mContainer.getRight(), this.mContainer.getBottom());
            this.mBgDrawableUnable.setBounds(this.mContainer.getLeft(), this.mContainer.getTop(), this.mContainer.getRight(), this.mContainer.getBottom());
            invalidate();
        }
    }

    private Drawable getDrawable(int i) {
        Drawable drawable = this.mDrawableMap.get(i);
        if (drawable == null) {
            Drawable drawable2 = UIUtils.getDrawable(i);
            this.mDrawableMap.put(i, drawable2);
            return drawable2;
        }
        return drawable;
    }

    private Drawable getImgItemBgDrawable(int i) {
        Bitmap createBitmap = Bitmap.createBitmap(i, UIUtils.dip2px(66.0f), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawColor(0);
        return new BitmapDrawable(getResources(), createBitmap);
    }

    private void init(Context context) {
        this.mImageItemResMap = new HashMap();
        this.mDrawableMap = new SparseArray<>();
        this.mContainer = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = UIUtils.dip2px(6.0f);
        this.mContainer.setLayoutParams(layoutParams);
        addView(this.mContainer);
        setIsNight(ThemeWatcher.getInstance().isNight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setItemAttr() {
        int childCount = this.mContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mContainer.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                textView.setTextSize(this.mTextSize);
                textView.setTextColor(this.mUnSelectedTextColor);
                XFontHelper.applyTypeface(textView, XFontHelper.FONT_XP_REGULAR);
                TextPaint paint = textView.getPaint();
                if (!this.mFontSizeChangeBySystem) {
                    paint.setTextSize(this.mTextSize);
                }
                if (this.mBoldFake && paint != null) {
                    paint.setFakeBoldText(false);
                }
            } else if (childAt instanceof ImageView) {
                ((ImageView) childAt).setImageResource(this.mImageItemResMap.get(childAt).getUnSelected());
            }
        }
        View view = this.mTargetView;
        if (view instanceof TextView) {
            ((TextView) view).setTextSize(this.mSelectedTextSize);
            ((TextView) this.mTargetView).setTextColor(this.mSelectedTextColor);
            XFontHelper.applyTypeface((TextView) this.mTargetView, XFontHelper.FONT_XP_MEDIUM);
            TextPaint paint2 = ((TextView) this.mTargetView).getPaint();
            if (!this.mFontSizeChangeBySystem) {
                paint2.setTextSize(this.mSelectedTextSize);
            }
            if (!this.mBoldFake || paint2 == null) {
                return;
            }
            paint2.setFakeBoldText(true);
        } else if (view instanceof ImageView) {
            ((ImageView) this.mTargetView).setImageResource(this.mImageItemResMap.get(view).getSelected());
        }
    }

    private void setItemClick(final View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.xui.widgets.XIndicator.3
            @Override // android.view.View.OnClickListener
            public void onClick(final View view2) {
                if (XIndicator.this.mEnable) {
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= XIndicator.this.mContainer.getChildCount()) {
                            break;
                        } else if (view2 == XIndicator.this.mContainer.getChildAt(i2)) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (XIndicator.this.mInterceptFilter instanceof ClickInterceptor) {
                        int i3 = ((ClickInterceptor) XIndicator.this.mInterceptFilter).interceptIndex;
                        if (i3 == i && XIndicator.this.mInterceptFilter.interceptClick()) {
                            Log.e(XIndicator.TAG, "item[" + i3 + "] intercept click, return");
                            return;
                        }
                    } else if (XIndicator.this.mInterceptFilter != null && XIndicator.this.mInterceptFilter.interceptClick()) {
                        Log.e(XIndicator.TAG, "intercept click, return");
                        return;
                    }
                    if (view2 == XIndicator.this.mTargetView) {
                        Log.d(XIndicator.TAG, "Click the same item, return.");
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - XIndicator.this.mLastClickTime >= XIndicator.this.mClickableInterval || currentTimeMillis - XIndicator.this.mLastClickTime <= 0) {
                        XIndicator.this.mLastClickTime = currentTimeMillis;
                        final int left = XIndicator.this.mTargetView.getLeft() + XIndicator.this.mContainer.getLeft();
                        final int left2 = view2.getLeft() + XIndicator.this.mContainer.getLeft();
                        XIndicator.this.mTargetView = view2;
                        XIndicator.this.post(new Runnable() { // from class: com.xiaopeng.xui.widgets.XIndicator.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                XIndicator.this.setItemAttr();
                                XIndicator.this.startSliderAnimation(left, left2);
                                XIndicator.this.startItemAnimation(0.5f, 1.0f, view2);
                            }
                        });
                        XIndicator.this.mSelectPosition = i;
                        if (XIndicator.this.mOnItemChangedListener != null) {
                            XIndicator.this.mOnItemChangedListener.onItemChanged(view, i);
                            return;
                        }
                        return;
                    }
                    Log.e(XIndicator.TAG, "Click time < interval : " + XIndicator.this.mClickableInterval);
                    return;
                }
                Log.d(XIndicator.TAG, "Click item, unable, return.");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startItemAnimation(float f, float f2, final View view) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new EaseCubicInterpolator(0.2f, 0.0f, 0.2f, 1.0f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.xui.widgets.XIndicator.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSliderAnimation(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setDuration(800L);
        ofInt.setInterpolator(new SpringInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.xui.widgets.XIndicator.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                XIndicator.this.mTranslateX = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                XIndicator.this.calculateAnimBounds(true);
            }
        });
        ofInt.start();
    }

    public void addItem(String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(17);
        textView.setMaxLines(1);
        textView.setTextColor(this.mUnSelectedTextColor);
        textView.setTextSize(this.mTextSize);
        textView.setPadding(UIUtils.dip2px(10.0f), 0, UIUtils.dip2px(10.0f), 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.gravity = 17;
        textView.setLayoutParams(layoutParams);
        this.mContainer.addView(textView);
        setItemClick(textView);
    }

    public void addItemWithWidth(int i, int i2, int i3, int i4) {
        ImageView imageView = new ImageView(getContext());
        imageView.setBackground(getImgItemBgDrawable(this.mItemImgWidth));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, UIUtils.dip2px(66.0f));
        layoutParams.gravity = 17;
        imageView.setLayoutParams(layoutParams);
        this.mImageItemResMap.put(imageView, new ImageItem(i, i2, i3, i4));
        this.mContainer.addView(imageView);
        setItemClick(imageView);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mShowBg && this.mEnable) {
            this.mBgDrawable.draw(canvas);
        }
        if (this.mShowCover) {
            if (this.mIsNinePatch) {
                NinePatch ninePatch = this.mSelectedCoverNiePatch;
                if (ninePatch != null) {
                    ninePatch.draw(canvas, this.mCoverRect);
                }
            } else {
                this.mSelectedCover.draw(canvas);
            }
        }
        super.dispatchDraw(canvas);
        if (this.mEnable) {
            return;
        }
        this.mBgDrawableUnable.draw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcher.getInstance().removeThemeListener(this);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            View childAt = this.mContainer.getChildAt(this.mSelectPosition);
            this.mTargetView = childAt;
            if (childAt != null) {
                this.mTranslateX = childAt.getLeft() + this.mContainer.getLeft();
                setItemAttr();
                calculateAnimBounds(true);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((this.mItemWidth * this.mContainer.getChildCount()) + this.mHorizontalMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mSelectedCover.getIntrinsicHeight(), 1073741824));
    }

    @Override // com.xiaopeng.xui.theme.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        setIsNight(ThemeWatcher.getInstance().isNight());
    }

    public void setClickableInterval(long j) {
        this.mClickableInterval = j;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        this.mEnable = z;
        invalidate();
    }

    public void setInterceptFilterClick(InterceptClickFilter interceptClickFilter) {
        this.mInterceptFilter = interceptClickFilter;
    }

    public void setIsNight(boolean z) {
        this.mSelectedTextColor = z ? this.mSelectedTextColorNight : this.mSelectedTextColorDay;
        this.mUnSelectedTextColor = z ? this.mUnSelectedTextColorNight : this.mUnSelectedTextColorDay;
        this.mBackground = z ? this.mBackgroundNight : this.mBackgroundDay;
        Drawable drawable = getDrawable(z ? this.mSelectedCoverNight : this.mSelectedCoverDay);
        this.mSelectedCover = drawable;
        boolean z2 = drawable instanceof NinePatchDrawable;
        this.mIsNinePatch = z2;
        if (z2) {
            if (z) {
                if (this.mSelectedCoverNiePatchNight == null) {
                    ThreadUtils.runInBackground(new Runnable() { // from class: com.xiaopeng.xui.widgets.XIndicator.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap decodeResource = BitmapFactory.decodeResource(XIndicator.this.getResources(), XIndicator.this.mSelectedCoverNight);
                            XIndicator.this.mSelectedCoverNiePatchNight = new NinePatch(decodeResource, decodeResource.getNinePatchChunk(), null);
                            XIndicator xIndicator = XIndicator.this;
                            xIndicator.mSelectedCoverNiePatch = xIndicator.mSelectedCoverNiePatchNight;
                            XIndicator.this.postInvalidate();
                        }
                    });
                }
            } else if (this.mSelectedCoverNiePatchDay == null) {
                ThreadUtils.runInBackground(new Runnable() { // from class: com.xiaopeng.xui.widgets.XIndicator.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap decodeResource = BitmapFactory.decodeResource(XIndicator.this.getResources(), XIndicator.this.mSelectedCoverDay);
                        XIndicator.this.mSelectedCoverNiePatchDay = new NinePatch(decodeResource, decodeResource.getNinePatchChunk(), null);
                        XIndicator xIndicator = XIndicator.this;
                        xIndicator.mSelectedCoverNiePatch = xIndicator.mSelectedCoverNiePatchDay;
                        XIndicator.this.postInvalidate();
                    }
                });
            }
            this.mSelectedCoverNiePatch = z ? this.mSelectedCoverNiePatchNight : this.mSelectedCoverNiePatchDay;
        }
        this.mBgDrawable = getDrawable(this.mBackground);
        this.mBgDrawableUnable = getDrawable(z ? this.mUnAbleBgNight : this.mUnAbleBgDay);
        setItemAttr();
        calculateAnimBounds(false);
    }

    public void setItemText(String str, int i) {
        LinearLayout linearLayout = this.mContainer;
        if (linearLayout == null) {
            Log.e(TAG, "setItemText error, mContainer is null.");
            return;
        }
        View childAt = linearLayout.getChildAt(i);
        if (childAt == null) {
            Log.e(TAG, "setItemText error, child is null, may be position does not correct");
        } else if (childAt instanceof TextView) {
            ((TextView) childAt).setText(str);
        }
    }

    public void setOnItemChangedListener(OnItemChangedListener onItemChangedListener) {
        this.mOnItemChangedListener = onItemChangedListener;
    }

    public void setSelectedTextSize(int i) {
        this.mSelectedTextSize = i;
        setItemAttr();
    }

    public void setSelection(int i) {
        setSelection(i, true);
    }

    public void setShowBg(boolean z) {
        this.mShowBg = z;
    }

    public void setShowCover(boolean z) {
        this.mShowCover = z;
    }

    public void setTextBoldFake(boolean z) {
        this.mBoldFake = z;
        setItemAttr();
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
        setItemAttr();
    }

    public XIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init(context);
    }

    public void setSelection(int i, boolean z) {
        if (!this.mEnable) {
            Log.e(TAG, "Can not selection, because the indicator is unable");
            return;
        }
        this.mSelectPosition = i;
        View view = this.mTargetView;
        int left = view != null ? view.getLeft() + this.mContainer.getLeft() : -1;
        View childAt = this.mContainer.getChildAt(this.mSelectPosition);
        this.mTargetView = childAt;
        this.mTranslateX = childAt.getLeft() + this.mContainer.getLeft();
        int left2 = this.mTargetView.getLeft() + this.mContainer.getLeft();
        setItemAttr();
        if (left > 0) {
            startSliderAnimation(left, left2);
            startItemAnimation(0.5f, 1.0f, this.mTargetView);
        }
        OnItemChangedListener onItemChangedListener = this.mOnItemChangedListener;
        if (onItemChangedListener == null || !z) {
            return;
        }
        onItemChangedListener.onItemChanged(this.mTargetView, i);
    }

    public XIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCoverRect = new Rect();
        this.mShowCover = true;
        this.mShowBg = true;
        this.mEnable = true;
        this.mBoldFake = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.xui_XIndicator);
        this.mSelectedTextColorNight = obtainStyledAttributes.getColor(R.styleable.xui_XIndicator_xui_text_color_selected_night, UIUtils.getColor(R.color.x_indicator_text_color_selected_night));
        this.mSelectedTextColorDay = obtainStyledAttributes.getColor(R.styleable.xui_XIndicator_xui_text_color_selected_day, UIUtils.getColor(R.color.x_indicator_text_color_selected_day));
        this.mUnSelectedTextColorNight = obtainStyledAttributes.getColor(R.styleable.xui_XIndicator_xui_text_color_unselected_night, UIUtils.getColor(R.color.x_indicator_text_color_unselected_night));
        this.mUnSelectedTextColorDay = obtainStyledAttributes.getColor(R.styleable.xui_XIndicator_xui_text_color_unselected_day, UIUtils.getColor(R.color.x_indicator_text_color_unselected_day));
        this.mBackgroundNight = obtainStyledAttributes.getResourceId(R.styleable.xui_XIndicator_xui_background_night, R.drawable.xindicator_bg_night);
        this.mBackgroundDay = obtainStyledAttributes.getResourceId(R.styleable.xui_XIndicator_xui_background_day, R.drawable.xindicator_bg_day);
        this.mSelectedCoverNight = obtainStyledAttributes.getResourceId(R.styleable.xui_XIndicator_xui_cover_night, R.mipmap.xindicator_selected_night);
        this.mSelectedCoverDay = obtainStyledAttributes.getResourceId(R.styleable.xui_XIndicator_xui_cover_day, R.mipmap.xindicator_selected_day);
        this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.xui_XIndicator_xui_text_size, UIUtils.sp2px(28.0f));
        this.mSelectedTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.xui_XIndicator_xui_selected_text_size, UIUtils.sp2px(28.0f));
        this.mItemWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.xui_XIndicator_xui_item_width, UIUtils.dip2px(178.0f));
        this.mItemHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.xui_XIndicator_xui_item_height, UIUtils.dip2px(66.0f));
        this.mItemImgWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.xui_XIndicator_xui_item_img_width, UIUtils.dip2px(160.0f));
        this.mCoverBottomOffset = obtainStyledAttributes.getDimensionPixelSize(R.styleable.xui_XIndicator_xui_cover_bottom_offset, UIUtils.dip2px(50.0f));
        this.mHorizontalMargin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.xui_XIndicator_xui_item_horizontal_margin, UIUtils.dip2px(180.0f));
        this.mUnAbleBgDay = obtainStyledAttributes.getResourceId(R.styleable.xui_XIndicator_xui_unable_bg_day, R.drawable.xindicator_bg_unable_day);
        this.mUnAbleBgNight = obtainStyledAttributes.getResourceId(R.styleable.xui_XIndicator_xui_unable_bg_night, R.drawable.xindicator_bg_unable_night);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.Xui_Common);
        this.mFontSizeChangeBySystem = obtainStyledAttributes2.getBoolean(R.styleable.Xui_Common_xui_font_size_system, false);
        obtainStyledAttributes2.recycle();
        if (!this.mFontSizeChangeBySystem) {
            this.mTextSize /= UIUtils.getFontScale();
            this.mSelectedTextSize /= UIUtils.getFontScale();
        }
        Log.d(TAG, "textSize: " + this.mTextSize + "   selectedTextSize: " + this.mSelectedTextSize);
    }

    public void addItem(int i, int i2, int i3, int i4) {
        addItem(i, i2, i3, i4, R.drawable.xindicator_empty_bg);
    }

    public void addItem(int i, int i2, int i3, int i4, int i5) {
        ImageView imageView = new ImageView(getContext());
        if (i5 > 0) {
            imageView.setBackgroundResource(i5);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, UIUtils.dip2px(66.0f));
        layoutParams.gravity = 17;
        imageView.setLayoutParams(layoutParams);
        this.mImageItemResMap.put(imageView, new ImageItem(i, i2, i3, i4));
        this.mContainer.addView(imageView);
        setItemClick(imageView);
        if (i5 > 0) {
            this.mItemWidth = getResources().getDrawable(i5).getIntrinsicWidth();
        }
    }
}
