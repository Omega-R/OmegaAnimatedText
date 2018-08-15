[![](https://jitpack.io/v/Omega-R/OmegaAnimatedText.svg)](https://jitpack.io/#Omega-R/OmegaAnimatedText)
# AnimatedText
Android lib to animate bold and italic transformations in TextView.

# Use
Add dependencies to your gradle file.

Project build.gradle:
``` groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

App module build.gradle:
``` groovy
dependencies {
    implementation 'com.github.Omega-R:OmegaAnimatedText:$version'
}
```

Start animation:
``` Java
mTextView.createStrokeAnimator(0.05f).start();
mTextView.createItalicAnimator(0.4f)
        .setDuration(1000)
        .start();
```

# Note
createStrokeAnimator(...) takes float percentage of textSize as first parameter.

createItalicAnimator(...) takes float percentage of skew angle (from 0.0f for 0&deg; to 1.0f for 90&deg;) as first parameter.

Both methods returns android.animation.Animator instance so you can make animations more complicated.
