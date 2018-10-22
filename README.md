# VeCaptcha

| Indeterminate | Determinate |
|:-------------:|:-----------:|

## Description

This library used to implement a simple captcha.

## Usage

To use VeCaptcha you must add it as a dependency in your Gradle build:

```groovy
dependencies {
    implementation 'com.chandan.vecaptcha:vecaptcha:1.0.1'
}
```

Then add the view to your layout:

```xml
<com.chandan.vecaptchatest.ui.CaptchaView
        android:id="@+id/captcha_view"
        android:layout_height="wrap_content"
        android:layout_width="match_parent"
        app:refreshButtonHeight="50"
        app:refreshButtonWidth="50"
        app:captchaHeight="60"
        app:captchaWidth="100">
    </com.chandan.vecaptchatest.ui.CaptchaView>
```

That's all you need! In java File you need to do following things:

```java
CaptchaView captchaView = this.findViewById(R.id.captcha_view);
verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (captchaView.getCaptchaAnswer() == Integer.parseInt(editTextInput.getText().toString().trim())) {
                    Toast.makeText(MainActivity.this, "Captcha filled correctly.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Captcha filled wrong.", Toast.LENGTH_SHORT).show();
                }
            }
        });
```

## XML attributes

| Name | Type | Default | Description |
|:----:|:----:|:-------:|:-----------:|
| refreshButtonHeight | int | 50 | set Captcha refresh button height. |
| refreshButtonWidth | int | 50 | set Captcha refresh button width. |
| captchaHeight | int | 60 | set Captcha image height. |
| captchaWidth | int | 100 | set Captcha image width. |

## Public Methods

| Name | Description |
|:----:|:-----------:|
| getCaptchaAnswer() | Returns Captcha answer as int value. |
