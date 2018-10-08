package com.chandan.vecaptchatest.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chandan.vecaptchatest.R;
import com.chandan.vecaptchatest.captcha.CaptchaController;
import com.chandan.vecaptchatest.captcha.GenerateCaptcha;

/**
 * Created by ${Chandan} on 05-10-2018.
 */
public class CaptchaView extends LinearLayout {
    private ImageView imageViewCaptcha;
    private EditText editTextFillCaptcha;
    private CaptchaController controller;
    public CaptchaView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER);

        controller = refreshCaptcha();

        imageViewCaptcha = new ImageView(getContext());
        imageViewCaptcha.setImageBitmap(controller.getImage());
        imageViewCaptcha.setLayoutParams(new LinearLayout.LayoutParams(controller.width * 2, controller.height * 2));


        editTextFillCaptcha = new EditText(getContext());
        LayoutParams params = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
        );

        params.setMargins(0,20,0,0);
        editTextFillCaptcha.setGravity(Gravity.CENTER);
        editTextFillCaptcha.setLayoutParams(params);

        addView(imageViewCaptcha);
        addView(editTextFillCaptcha);
    }

    public int getCaptchaAnswer() {
        return Integer.parseInt(controller.answer);
    }

    private CaptchaController refreshCaptcha() {
        return new GenerateCaptcha(80, 80, GenerateCaptcha.MathOptions.PLUS_MINUS_MULTIPLY);
    }
}
