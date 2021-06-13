package com.nass.ek.w3keyboard;

import android.content.Context;
import android.graphics.Canvas;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;

public class W3KeyboardView extends KeyboardView {

    public W3KeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public W3KeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
