AVLoadingIndicatorView
===================

## Introduction
AVLoadingIndicatorView is a collection of nice loading animations for Android.

You can also find IOS version of this [here](https://github.com/ninjaprox/NVActivityIndicatorView).

## Demo
![](https://github.com/81813780/AVLoadingIndicatorView/blob/master/Demo.gif)

[Download Apk](https://github.com/81813780/AVLoadingIndicatorView/releases/download/getSampleApk/app-debug.apk)

## Usage

### Step 1

Add dependencies in build.gradle.
```groovy
	dependencies {
	   compile 'com.wang.avi:library:1.0.0'
	   compile 'com.nineoldandroids:library:2.4.0'
	}
```

### Step 2

Add the AVLoadingIndicatorView to your layout:
```java
    <com.wang.avi.AVLoadingIndicatorView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:indicator="BallPulse"
        app:indicator_color="your color"
        />
```

## Indicators

Here they are

 * `BallPulse`
 * `BallGridPulse`
 * `BallClipRotate`
 * `BallClipRotatePulse`
 * `SquareSpin`
 * `BallClipRotateMultiple`
 * `BallPulseRise`
 * `BallRotate`
 * `CubeTransition`
 * `BallZigZag`
 * `BallZigZagDeflect`
 * `BallTrianglePath`
 * `BallScale`
 * `LineScale`
 * `LineScaleParty`
 * `BallScaleMultiple`
 * `BallPulseSync`
 * `BallBeat`
 * `LineScalePulseOut`
 * `LineScalePulseOutRapid`
 * `BallScaleRipple`
 * `BallScaleRippleMultiple`
 * `BallSpinFadeLoader`
 * `LineSpinFadeLoader`
 * `TriangleSkewSpin`
 * `Pacman`
 * `BallGridBeat`
 * `SemiCircleSpin`

## Thanks
- [nineoldandroids](https://github.com/JakeWharton/NineOldAndroids)
- [NVActivityIndicatorView](https://github.com/ninjaprox/NVActivityIndicatorView)

##Contact me

 if you have a better idea or way on this project, please let me know, thanks:)

[Email](mailto:81813780@qq.com)

[Weibo](http://weibo.com/601265161)
