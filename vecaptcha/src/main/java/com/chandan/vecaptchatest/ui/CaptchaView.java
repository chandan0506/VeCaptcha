package com.chandan.vecaptchatest.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
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
    private CaptchaController controller;
    private final LinearLayout layoutCaptcha;
    private int captchaHeight;
    private int captchaWidth;
//    private final EditText editTextFillCaptcha;

    public CaptchaView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray arrayValues = context.obtainStyledAttributes(attrs,R.styleable.CaptchaView,0,0);

        int refreshButtonWidth = arrayValues.getInteger(R.styleable.CaptchaView_refreshButtonWidth,50);
        int refreshButtonHeight = arrayValues.getInteger(R.styleable.CaptchaView_refreshButtonHeight,50);

        captchaHeight = arrayValues.getInteger(R.styleable.CaptchaView_captchaHeight,60);
        captchaWidth = arrayValues.getInteger(R.styleable.CaptchaView_captchaWidth,100);

        arrayValues.recycle();

        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER);

        controller = refreshCaptcha();

        imageViewCaptcha = new ImageView(getContext());
        imageViewCaptcha.setImageBitmap(controller.getImage());
        imageViewCaptcha.setLayoutParams(new LinearLayout.LayoutParams(controller.width * 2, controller.height * 2));

        ImageView imageViewRefreshCaptcha = new ImageView(getContext());
        imageViewRefreshCaptcha.setImageDrawable(getResources().getDrawable(R.drawable.reload));

        LayoutParams paramsRefresh = new LinearLayout.LayoutParams(
                refreshButtonWidth,
                refreshButtonHeight);


        paramsRefresh.setMargins(10,0,0,0);
        imageViewRefreshCaptcha.setLayoutParams(paramsRefresh);


        layoutCaptcha = new LinearLayout(getContext());
        layoutCaptcha.setOrientation(LinearLayout.HORIZONTAL);
        layoutCaptcha.setGravity(Gravity.CENTER);
        layoutCaptcha.addView(imageViewCaptcha);
        layoutCaptcha.addView(imageViewRefreshCaptcha);

        LayoutParams params = new LayoutParams(
                controller.width * 2,
                LayoutParams.WRAP_CONTENT
        );

        params.setMargins(0,10,20,0);

        Log.d("TESTING ", "CaptchaView: Width " + imageViewCaptcha.getLayoutParams().width +
        " Refresh Button height and width:- " + refreshButtonHeight + " , " + refreshButtonWidth);

        imageViewRefreshCaptcha.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TESTING ", "onClick: ");
                refreshCaptchaImage();

            }
        });

        addView(layoutCaptcha);
    }

    private void refreshCaptchaImage() {
        removeAllViewsInLayout();
        controller = refreshCaptcha();
        imageViewCaptcha.setImageBitmap(controller.getImage());
        addView(layoutCaptcha);
    }

    public int getCaptchaAnswer() {
        return Integer.parseInt(controller.answer);
    }

    private CaptchaController refreshCaptcha() {
        return new GenerateCaptcha(captchaWidth, captchaHeight, GenerateCaptcha.MathOptions.PLUS_MINUS_MULTIPLY);
    }
}
