package com.nass.ek.w3keyboard;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.view.View;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;

public class W3KeyboardService extends InputMethodService
        implements KeyboardView.OnKeyboardActionListener {

    private W3KeyboardView kv;
    private Keyboard keyboard;

    private boolean isCaps = false;

    @Override
    public void onPress(int i) {

    }

    @Override
    public void onRelease(int i) {

    }

    @Override
    public void onKey(int i, int[] ints) {
        InputConnection ic = getCurrentInputConnection();
        switch (i) {
            case Keyboard.KEYCODE_DELETE:
                ic.deleteSurroundingText(1, 0);
                break;
            case Keyboard.KEYCODE_SHIFT:
                isCaps = !isCaps;
                keyboard.setShifted(isCaps);
                kv.invalidateAllKeys();
                break;
            case Keyboard.KEYCODE_DONE:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            case -101:
                keyboard = new Keyboard(this, R.xml.latin_symbols_1);
                kv.setKeyboard(keyboard);
                break;
            case -102:
                keyboard = new Keyboard(this, R.xml.latin);
                kv.setKeyboard(keyboard);
                break;
            case -103:
                keyboard = new Keyboard(this, R.xml.latin_symbols_2);
                kv.setKeyboard(keyboard);
                break;
            default:
                char code = (char) i;
                if (Character.isLetter(code) && isCaps) {
                    code = Character.toUpperCase(code);
                }
                ic.commitText(String.valueOf(code), 1);
        }
    }

    @Override
    public void onText(CharSequence charSequence) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }

    @Override
    public View onCreateInputView() {
        kv = (W3KeyboardView) getLayoutInflater().inflate(R.layout.keyboard, null);
        keyboard = new Keyboard(this, R.xml.latin);
        kv.setKeyboard(keyboard);
        kv.setOnKeyboardActionListener(this);
        return kv;
    }
}
