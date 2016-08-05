[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-AVLoadingIndicatorView-green.svg?style=flat)](https://android-arsenal.com/details/1/2686)

AVLoadingIndicatorView
===================

> **Now AVLoadingIndicatorView was updated version to 2.0 , If you have any question or suggestion  with this library , welcome to tell me !**

如果你对实现各种酷炫的动画效果感兴趣 , 欢迎一起交流 :)

**Android动画开源交流QQ群 : 199750106**

## Introduction
AVLoadingIndicatorView is a collection of nice loading animations for Android.

You can also find iOS version of this [here](https://github.com/ninjaprox/NVActivityIndicatorView).

## Demo
![](https://github.com/81813780/AVLoadingIndicatorView/blob/master/Demo2.gif)

[Download Apk](https://github.com/81813780/AVLoadingIndicatorView/releases/download/1.0.1/app-debug.apk)

## Usage

### Step 1

Add dependencies in build.gradle.
```groovy
    dependencies {
       compile 'com.wang.avi:library:2.0.0'
       compile 'com.nineoldandroids:library:2.4.0'
    }
```

### Step 2

Add the AVLoadingIndicatorView to your layout:
```java
    <com.wang.avi.AVLoadingIndicatorView
        android:id="@+id/avi"
        android:layout_width="wrap_content"  //or your custom size
        android:layout_height="wrap_content"  //or your custom size
        style="@style/AVLoadingIndicatorView"// or AVLoadingIndicatorView.Large or AVLoadingIndicatorView.Small
        android:visibility="visible"  //visible or gone
        app:indicatorName="BallPulseIndicator"//Indicator Name
        app:indicatorColor="your color"
        />
```

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

## Custom Indicator

See [MyCustomIndicator](https://github.com/81813780/AVLoadingIndicatorView/blob/master/app/src/main/java/com/wang/avi/sample/MyCustomIndicator.java) in Sample .

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
 
**Row 8**
 * `com.wang.avi.sample.MyCustomIndicator`

## Thanks
- [nineoldandroids](https://github.com/JakeWharton/NineOldAndroids)
- [NVActivityIndicatorView](https://github.com/ninjaprox/NVActivityIndicatorView)
- [Connor Atherton](https://github.com/ConnorAtherton)

##Contact me

 If you have a better idea or way on this project, please let me know, thanks :)

[Email](mailto:81813780@qq.com)

[Weibo](http://weibo.com/601265161)

[My Blog](http://hlong.xyz)



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

