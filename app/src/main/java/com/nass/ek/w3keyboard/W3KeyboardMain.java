package com.nass.ek.w3keyboard;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class W3KeyboardMain extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkActiveIme();
    }

    public void checkActiveIme(){
        InputMethodManager imeManager = (InputMethodManager) getApplicationContext().getSystemService(INPUT_METHOD_SERVICE);
        if (imeManager != null) {
            String id = Settings.Secure.getString(getContentResolver(),Settings.Secure.ENABLED_INPUT_METHODS);
            if (!id.contains(getString(R.string.app_name))){
                Intent intent = new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS);
                startActivityForResult(intent, 1);
            } else {
                checkDefaultIme();
            }
        }
    }

    public void checkDefaultIme(){
        InputMethodManager imeManager = (InputMethodManager) getApplicationContext().getSystemService(INPUT_METHOD_SERVICE);
        if (imeManager != null) {
            String iid = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.DEFAULT_INPUT_METHOD);
            if (!iid.contains(getString(R.string.app_name))) {
                imeManager.showInputMethodPicker();
            }
        }
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        checkDefaultIme();
    }
}
