[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-AVLoadingIndicatorView-green.svg?style=flat)](https://android-arsenal.com/details/1/2686)

AVLoadingIndicatorView
===================

## Introduction
AVLoadingIndicatorView is a collection of nice loading animations for Android.

You can also find IOS version of this [here](https://github.com/ninjaprox/NVActivityIndicatorView).

## Demo
![](https://github.com/81813780/AVLoadingIndicatorView/blob/master/Demo2.gif)

[Download Apk](https://github.com/81813780/AVLoadingIndicatorView/releases/download/1.0.1/app-debug.apk)

## Usage

### Step 1

Add dependencies in build.gradle.
```groovy
    dependencies {
       compile 'com.wang.avi:library:1.0.1'
       compile 'com.nineoldandroids:library:2.4.0'
    }
```

### Step 2 - Using Built-in indicator type

Add the AVLoadingIndicatorView to your layout:
```java
    <com.wang.avi.AVLoadingIndicatorView
        android:id="@+id/avloadingIndicatorView"
        android:layout_width="wrap_content"  //or your custom size
        android:layout_height="wrap_content"  //or your custom size
        android:visibility="visible"  //visible or gone
        app:indicator="BallPulse"
        app:indicator_color="your color"
        />
```

### Step 2* - Using custom indicator class
First, provides a non-param constructor in your own subclass:  
```java
   package com.example;
   public class MyIndicator extends BaseIndicatorController{
      public void MyIndicator(){
        //...
      }
      //...
   }
```
Then put its full class name on XML:  
```XML
    <com.wang.avi.AVLoadingIndicatorView
        android:id="@+id/avloadingIndicatorView"
        android:layout_width="wrap_content"  //or your custom size
        android:layout_height="wrap_content"  //or your custom size
        android:visibility="visible"  //visible or gone
        app:customIndicator="com.example.MyIndicator"
        />
```
**NOTE: If you use proguard, please remember to keep your indicator class.**

### Step 3

It's very simple use just like Progressbar.
```java
   void startAnim(){
        findViewById(R.id.avloadingIndicatorView).setVisibility(View.VISIBLE);
   }
   
   void stopAnim(){
        findViewById(R.id.avloadingIndicatorView).setVisibility(View.GONE);
   }
   
```

### Advanced customize
If your custom indicator has some property need to be specified in XML, you can do as following:  
First, put all your customize properties into a styleable:  
```XML
   <declare-styleable name="MyCustomIndicator">
       <attr name="colorScheme1" format="color" />
       <!-- more properties... -->
   </declare-styleable>
```

And provides a **non-private constructor** in your indicator controller:  
```java
    package com.example;
    public class MyCustomIndicator extends BaseIndicatorController {
        public MyCustomIndicator(Context context, AttributeSet attr){
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyCustomIndicator);
            int color = a.getColor(R.styleable.MyCustomIndicator_colorScheme1, -1);
            a.recycle();
        }
    }
```

Then just use it as convention！  
```XML
    <com.wang.avi.AVLoadingIndicatorView
        android:id="@+id/avloadingIndicatorView"
        android:layout_width="wrap_content"  //or your custom size
        android:layout_height="wrap_content"  //or your custom size
        android:visibility="visible"  //visible or gone
        app:customIndicator="com.example.MyCustomIndicator"
        app:colorScheme1="@color/material_green"
        />
```

So easy~ here is a demo:  
![](https://github.com/Muyangmin/AVLoadingIndicatorView/blob/master/DemoCustom.gif)

For more detail usage, please see sample codes.

## Indicators

As seen above in the **Demo**, the indicators are as follows:

**Row 1**
 * `BallPulse`
 * `BallGridPulse`
 * `BallClipRotate`
 * `BallClipRotatePulse`

**Row 2**
 * `SquareSpin`
 * `BallClipRotateMultiple`
 * `BallPulseRise`
 * `BallRotate`

**Row 3**
 * `CubeTransition`
 * `BallZigZag`
 * `BallZigZagDeflect`
 * `BallTrianglePath`

**Row 4**
 * `BallScale`
 * `LineScale`
 * `LineScaleParty`
 * `BallScaleMultiple`

**Row 5**
 * `BallPulseSync`
 * `BallBeat`
 * `LineScalePulseOut`
 * `LineScalePulseOutRapid`

**Row 6**
 * `BallScaleRipple`
 * `BallScaleRippleMultiple`
 * `BallSpinFadeLoader`
 * `LineSpinFadeLoader`

**Row 7**
 * `TriangleSkewSpin`
 * `Pacman`
 * `BallGridBeat`
 * `SemiCircleSpin`

## Thanks
- [nineoldandroids](https://github.com/JakeWharton/NineOldAndroids)
- [NVActivityIndicatorView](https://github.com/ninjaprox/NVActivityIndicatorView)
- [Connor Atherton](https://github.com/ConnorAtherton)

##Contact me

 If you have a better idea or way on this project, please let me know, thanks :)

[Email](mailto:81813780@qq.com)

[Weibo](http://weibo.com/601265161)




### License
```
Copyright 2015 jack wang

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

