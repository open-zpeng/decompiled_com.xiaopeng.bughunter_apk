package com.xiaopeng.xui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.XUI;
import com.xiaopeng.xui.theme.ThemeWatcher;
/* loaded from: classes.dex */
public class XInput extends FrameLayout implements ThemeWatcher.OnThemeSwitchListener {
    private static final int STATE_EDITING = 2;
    private static final int STATE_ERROR = 3;
    private static final int STATE_IDLE_DONE = 1;
    private static final int STATE_IDLE_NULL = 0;
    private Context context;
    private int currentState;
    private EditText editText;
    private ImageView img;
    private View line;
    private OnInputErrorValidate onInputErrorValidate;
    private TextView tip;

    /* loaded from: classes.dex */
    public interface OnInputErrorValidate {
        String getErrorTips();

        boolean onInputErrorValidate(Editable editable);
    }

    public XInput(Context context) {
        this(context, null);
    }

    private void initListener() {
        this.editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.xiaopeng.xui.widgets.XInput.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (XInput.this.onInputErrorValidate != null ? XInput.this.onInputErrorValidate.onInputErrorValidate(XInput.this.editText.getText()) : false) {
                    XInput.this.updateState(3);
                } else if (z) {
                    XInput.this.updateState(2);
                } else if (XInput.this.editText.getText().length() > 0) {
                    XInput.this.updateState(1);
                } else {
                    XInput.this.updateState(0);
                }
            }
        });
        this.editText.addTextChangedListener(new TextWatcher() { // from class: com.xiaopeng.xui.widgets.XInput.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (XInput.this.onInputErrorValidate != null) {
                    if (XInput.this.onInputErrorValidate.onInputErrorValidate(editable)) {
                        XInput.this.updateState(3);
                    } else {
                        XInput.this.updateState(2);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    private void initView(AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.widget_xinput_layout, this);
        this.editText = (EditText) inflate.findViewById(R.id.edit_text);
        this.line = inflate.findViewById(R.id.line);
        this.tip = (TextView) inflate.findViewById(R.id.tip);
        this.img = (ImageView) inflate.findViewById(R.id.img);
        TypedArray obtainStyledAttributes = this.context.obtainStyledAttributes(attributeSet, R.styleable.xui_XInput);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.xui_XInput_xui_XInput_text_size, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.xui_XInput_xui_XInput_error_text_size, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.xui_XInput_xui_XInput_error_img, 0);
        String string = obtainStyledAttributes.getString(R.styleable.xui_XInput_xui_XInput_hint);
        String string2 = obtainStyledAttributes.getString(R.styleable.xui_XInput_xui_XInput_error_text);
        int i = obtainStyledAttributes.getInt(R.styleable.xui_XInput_xui_XInput_maxLines, 0);
        obtainStyledAttributes.recycle();
        if (dimensionPixelSize > 0) {
            this.editText.setTextSize(dimensionPixelSize);
        }
        if (dimensionPixelSize2 > 0) {
            this.tip.setText(string2);
        }
        if (resourceId > 0) {
            this.img.setImageResource(resourceId);
        }
        if (string != null && !string.isEmpty()) {
            this.editText.setHint(string);
        }
        if (string2 != null && !string2.isEmpty()) {
            this.tip.setText(string2);
        }
        if (i > 0) {
            setMaxLines(i);
        }
        this.editText.setTextColor(XUI.getContext().getResources().getColor(R.color.xui_main_color_2));
        this.editText.setHintTextColor(XUI.getContext().getResources().getColor(R.color.xui_main_color_4));
        updateState(0);
    }

    private void updateByTheme(int i) {
        if (!ThemeWatcher.getInstance().isNight()) {
            this.editText.setTextColor(XUI.getContext().getResources().getColor(R.color.xui_main_color_2));
            this.editText.setHintTextColor(XUI.getContext().getResources().getColor(R.color.xui_main_color_4));
        } else {
            this.editText.setTextColor(XUI.getContext().getResources().getColor(R.color.xui_white));
            this.editText.setHintTextColor(getResources().getColor(R.color.x_input_hint_night));
        }
        if (i == 0) {
            if (!ThemeWatcher.getInstance().isNight()) {
                this.line.setBackgroundResource(R.color.x_input_state_null_line_color);
            } else {
                this.line.setBackgroundResource(R.color.x_input_state_null_line_color_night);
            }
        } else if (i == 1) {
            if (!ThemeWatcher.getInstance().isNight()) {
                this.line.setBackgroundResource(R.color.xui_main_color_4);
            } else {
                this.line.setBackgroundResource(R.color.x_input_state_done_line_color_night);
            }
        } else if (i == 2) {
            if (!ThemeWatcher.getInstance().isNight()) {
                this.line.setBackgroundResource(R.color.xui_main_color);
            } else {
                this.line.setBackgroundResource(R.color.x_input_state_editing_line_color_night);
            }
        } else if (i != 3) {
        } else {
            if (!ThemeWatcher.getInstance().isNight()) {
                this.line.setBackgroundResource(R.color.xui_red);
            } else {
                this.line.setBackgroundResource(R.color.xui_red);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateState(int i) {
        updateByTheme(i);
        if (i == 0) {
            this.tip.setVisibility(4);
            this.img.setVisibility(4);
        } else if (i == 1) {
            this.tip.setVisibility(4);
            this.img.setVisibility(4);
        } else if (i == 2) {
            this.tip.setVisibility(4);
            this.img.setVisibility(4);
        } else if (i == 3) {
            this.tip.setVisibility(0);
            this.img.setVisibility(0);
            OnInputErrorValidate onInputErrorValidate = this.onInputErrorValidate;
            if (onInputErrorValidate != null && onInputErrorValidate.getErrorTips() != null && !this.onInputErrorValidate.getErrorTips().isEmpty()) {
                this.tip.setText(this.onInputErrorValidate.getErrorTips());
            }
        }
        this.currentState = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.editText.dispatchTouchEvent(motionEvent);
        return true;
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

    @Override // com.xiaopeng.xui.theme.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        updateState(this.currentState);
    }

    public void setMaxLines(int i) {
        EditText editText = this.editText;
        if (editText != null) {
            editText.setMaxLines(i);
            if (i == 1) {
                this.editText.setSingleLine();
            }
        }
    }

    public void setOnInputErrorValidate(OnInputErrorValidate onInputErrorValidate) {
        this.onInputErrorValidate = onInputErrorValidate;
    }

    public XInput(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XInput(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentState = 0;
        this.context = context;
        initView(attributeSet);
        initListener();
    }
}
