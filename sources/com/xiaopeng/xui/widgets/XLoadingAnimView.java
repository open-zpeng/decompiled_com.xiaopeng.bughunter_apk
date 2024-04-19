package com.xiaopeng.xui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.rastermill.FrameSequenceUtil;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.theme.ThemeWatcher;
import com.xiaopeng.xui.theme.XResLoader;
/* loaded from: classes.dex */
public class XLoadingAnimView extends ImageView implements ThemeWatcher.OnThemeSwitchListener {
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_SMALL = 1;
    private int mLoadingType;

    public XLoadingAnimView(Context context) {
        this(context, null, 0);
    }

    private String getAnimFileName(boolean z) {
        return this.mLoadingType == 1 ? z ? "loading_140_night.webp" : "loading_140_day.webp" : z ? "loading_night.webp" : "loading_day.webp";
    }

    private void init() {
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
        setType(this.mLoadingType);
    }

    private void loadAnim(boolean z) {
        releaseAnim();
        FrameSequenceUtil.with(this).inputStream(XResLoader.openAssets(getAnimFileName(z))).loopBehavior(2).applyAsync();
    }

    private void releaseAnim() {
        if (getDrawable() != null) {
            FrameSequenceUtil.destroy(this);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        loadAnim(ThemeWatcher.getInstance().isNight());
        super.onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        releaseAnim();
        ThemeWatcher.getInstance().removeThemeListener(this);
        super.onDetachedFromWindow();
    }

    @Override // com.xiaopeng.xui.theme.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        setIsNight(2 == i);
    }

    public void setIsNight(boolean z) {
        loadAnim(z);
    }

    public void setType(int i) {
        if (i == 0 || i == 1) {
            this.mLoadingType = i;
        }
    }

    public XLoadingAnimView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XLoadingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Xui_Common);
        this.mLoadingType = obtainStyledAttributes.getInt(R.styleable.Xui_Common_xui_loadingType, -1);
        obtainStyledAttributes.recycle();
        init();
    }
}
