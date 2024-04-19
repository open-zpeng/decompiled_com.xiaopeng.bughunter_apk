package com.xiaopeng.xui.widgets;

import android.content.Context;
import android.support.v7.widget.h;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.theme.ThemeWatcher;
/* loaded from: classes.dex */
public class XCheckBox extends h implements CompoundButton.OnCheckedChangeListener, ThemeWatcher.OnThemeSwitchListener {
    private CompoundButton.OnCheckedChangeListener mCheckedChangeListener;

    public XCheckBox(Context context) {
        super(context);
        init();
    }

    private void init() {
        super.setOnCheckedChangeListener(this);
        setBackgroundColor(0);
        onRender(ThemeWatcher.getInstance().isNight());
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.mCheckedChangeListener;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z);
        }
        onRender(ThemeWatcher.getInstance().isNight());
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcher.getInstance().removeThemeListener(this);
    }

    protected void onRender(boolean z) {
        if (z) {
            setButtonDrawable(isChecked() ? R.mipmap.xui_ico_checked_night : R.mipmap.xui_ico_unchecked_night);
        } else {
            setButtonDrawable(isChecked() ? R.mipmap.xui_ico_checked : R.mipmap.xui_ico_unchecked);
        }
    }

    @Override // com.xiaopeng.xui.theme.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        onRender(ThemeWatcher.getInstance().isNight());
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mCheckedChangeListener = onCheckedChangeListener;
    }

    public XCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public XCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
