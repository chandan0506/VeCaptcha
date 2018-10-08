package com.chandan.vecaptchatest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.chandan.vecaptchatest.ui.CaptchaView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CaptchaView captchaView = this.findViewById(R.id.captcha_view);

        captchaView.getCaptchaAnswer();

        Log.d("TESTING ", "onCreate: " + captchaView.getCaptchaAnswer());
    }
}
