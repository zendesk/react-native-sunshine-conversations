# react-native-smooch
React Native wrapper for Smooch.io. Based off of [smooch-cordova](https://github.com/smooch/smooch-cordova)

This React Native module was built and tested with version 0.18 of React Native. Since React Native is not mature yet, there might be some breaking changes which will break our module. Therefore, if you find a problem, please open an issue.

At the moment, this wrapper only covers the most commonly used features of the Smooch SDK. We encourage you to add to this wrapper or make any feature requests you need. Pull requests most definitely welcome!

Please hit up [@gozmike](https://twitter.com/gozmike) with any questions or [contact Smooch](mailto:help@smooch.io).

Installing Smooch on React Native
=================================

First, make sure you've [signed up for Smooch](https://app.smooch.io/signup)

If you don't already have a React Native application setup, follow the instructions [here](https://facebook.github.io/react-native/docs/getting-started.html) to create one.

Next, grab this React Native module with `npm install react-native-smooch`

## iOS

 * Navigate to your React Native project's `ios` directory and follow [these steps](http://docs.smooch.io/ios/#adding-smooch-to-your-app) for adding the Smooch binary distribution to your project with CocoaPods.

 * Open your project's .xcworkspace file in XCode and initialize Smooch with your app token inside of applicationDidFinishLaunchingWithOptions.

```
#import <Smooch/Smooch.h>

...

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    // Initialize Smooch - these instructions are also available on [app.smooch.io](https://app.smooch.io)
    [Smooch initWithSettings:
        [SKTSettings settingsWithAppToken:@"YOUR APP TOKEN GOES HERE"]];
}
```

 * Go to `node_modules/react-native-smooch/ios` and drag `SmoochManager.h` and `SmoochManager.m` into your XCode file tree so that they're included in the build.

You're now ready to start interacting with Smooch in your React Native app.

## Android

* Open the `/android` directory of your React Native project in Android Studio.
* Open the `/android/build.gradle` file. Make sure that `jcenter()` is listed in the repositories.
```
buildscript {
    repositories {
        jcenter()
    }
    ...
```

* Open the `/android/app/build.gradle` file and add Smooch to the dependencies.
```
dependencies {
    ...
    compile 'com.google.android.gms:play-services-gcm:7.8.0'
    compile 'com.google.code.gson:gson:2.3.1'
    compile 'com.squareup.okhttp:okhttp:2.4.0'
    compile 'io.smooch:core:latest.release'        
    compile 'io.smooch:ui:latest.release'
}
```

* Create an Application class for the React project. Add `Smooch.init` in the `onCreate` method.
```
//...
import io.smooch.core.Smooch; // <-- add this line
//...
public class ReactNativeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Smooch.init(this, "<your-smooch-app-token>");
    }
}
```

* In the `AndroidManifest.xml` file, make sure to reference the application class you just created (replace `<package-name>` with your React Application's package name).

```
<application
  android:name="<package-name>.ReactNativeApplication"
  ...
  >
```

* Copy the `SmoochManager.java` and `SmoochPackage.java` files from `node_modules/react-native-smooch/android` into your the Android project.
* In the `MainActivity.java` file, add `new SmoochPackage()` to the `getPackages()` method.

```
//...
import io.smooch.core.Smooch; // <-- add this line
//...
 @Override
 protected List<ReactPackage> getPackages() {
   return Arrays.asList(
     new MainReactPackage(),
      //...
        new SmoochPackage()); // <-- add this line
      //..
 }
 ```
 
Make sure you have installed Google Play services and Google Repository package from Android SDK 

Add these permissions in android/app/src/main/AndroidManifest.xml
```
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="com.google.android.c2dm.permission.RECEIVE"/>
```
Add these services in AndroidManifest.xml:
```
<application ...
<service android:name="io.smooch.core.service.SmoochService"/>
<service android:name="io.smooch.core.GcmInstanceIDListenerService" android:exported="false">
    <intent-filter>
        <action android:name="com.google.android.gms.iid.InstanceID"/>
    </intent-filter>
</service>
<service android:name="io.smooch.core.GcmRegistrationIntentService" android:exported="false"/>
<service android:name="io.smooch.core.GcmService" android:exported="false">
    <intent-filter>
        <action android:name="com.google.android.c2dm.intent.RECEIVE"/>
    </intent-filter>
</service>
<receiver
        android:name="io.smooch.ui.notification.NotificationReceiver"
        android:exported="false">
    <intent-filter>
        <action android:name="io.smooch.NOTIFICATION"/>
    </intent-filter>
</receiver>

<activity android:name="io.smooch.ui.ConversationActivity" android:theme="@style/Theme.Smooch" />

...   </application>
 ```
[More information](http://docs.smooch.io/android/#adding-smooch-to-your-app) 


You're now ready to start interacting with Smooch in your React Native app.

Using Smooch in your React Native App
=====================================

### Require the module
```javascript
var Smooch = require('react-native-smooch');
```

### Show the conversation screen
```javascript
Smooch.show();
```

### Set the user's first name
```javascript
Smooch.setFirstName("Kurt");
```

### Set the user's last name
```javascript
Smooch.setLastName("Osiander");
```

### Set the user's email address
```javascript
Smooch.setEmail("kurt@ralphgraciesf.com");
```

### Associate key/value pairs with the user
```javascript
Smooch.setUserProperties({"whenDidYouFsckUp": "aLongTimeAgo"});
```

### Track an event
```javascript
Smooch.track("User tapped");
```

Learn more about the functions we've wrapped by checking out SmoochClient.js in the "lib" directory.

![](https://media.giphy.com/media/h9KtiB6DgiS2s/giphy.gif)
