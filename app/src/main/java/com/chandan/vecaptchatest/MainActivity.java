package com.chandan.vecaptchatest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chandan.vecaptchatest.ui.CaptchaView;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = this.findViewById(R.id.bt_test);

        final CaptchaView captchaView = this.findViewById(R.id.captcha_view);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (captchaView.getCaptchaAnswer() == captchaView.getUserInput()) {
                    Toast.makeText(MainActivity.this, "Right captcha.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Wrong captcha.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Log.d("TESTING ", "onCreate: " + captchaView.getCaptchaAnswer());
    }
}
