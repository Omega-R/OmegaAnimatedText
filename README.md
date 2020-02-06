[![](https://jitpack.io/v/Omega-R/OmegaAnimatedText.svg)](https://jitpack.io/#Omega-R/OmegaAnimatedText)
[![GitHub license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://opensource.org/licenses/MIT)
# AnimatedText
Android lib to animate bold and italic transformations in TextView.

<p align="center">
    <img src="/images/AnimatedTextPreview.gif?raw=true" width="200" height="60" />
</p>

# Installation
To get a Git project into your build:

**Step 1.** Add the JitPack repository to your build file
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
**Step 2.** Add the dependency
```
dependencies {
    implementation 'com.github.Omega-R:OmegaAnimatedText:2.0.0'
}
```

For Support library the latest version is '1.0.0'

# Usage
Start animation:
``` Java
animatedTextView.createStrokeAnimator(0.05f).start();
animatedTextView.createItalicAnimator(0.4f)
        .setDuration(1000)
        .start();
```

# Note
createStrokeAnimator(...) takes float percentage of textSize as first parameter.

createItalicAnimator(...) takes float percentage of skew angle (from 0.0f for 0&deg; to 1.0f for 90&deg;) as first parameter.

Both methods returns android.animation.Animator instance so you can make animations more complicated.

# License
```
The MIT License

Copyright 2020 Omega-R

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and 
associated documentation files (the "Software"), to deal in the Software without restriction, 
including without limitation the rights to use, copy, modify, merge, publish, distribute, 
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is 
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```
