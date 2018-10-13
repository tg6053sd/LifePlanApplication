package com.lifeplan.lifeplanapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

public class DelaySplashActivity extends AppCompatActivity {

    // region フィールド

    private final static int SPLASH_TIME = 2500;

    // endregion

    // region イベント

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delay_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(DelaySplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME);

    }

    /**
     * バックキー無効。
     * */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    // endregion

}
