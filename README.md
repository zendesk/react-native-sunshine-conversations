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

Link it! `react-native link react-native-smooch`

## iOS
 * With CococaPods, you can add the react-native-smooch Pod in your `Podfile` like so:

 ```
 pod 'react-native-smooch',
     :path => '../node_modules/react-native-smooch'
 ```

 * You must also have your React dependencies defined in your Podfile as described [here](http://facebook.github.io/react-native/releases/0.31/docs/troubleshooting.html#missing-libraries-for-react), for example:

 ```
 pod 'React', :subspecs => [
     'Core',
     'RCTImage',
     'RCTNetwork',
     'RCTPushNotification',
     'RCTText',
 ], :path => '../node_modules/react-native'
 ```

 * Install pods by running `pod install`.

 * Without CocoaPods, you can add Smooch by navigating to your React Native project's `ios` directory and following [the manual steps here](http://docs.smooch.io/ios/#adding-smooch-to-your-app).

 * Open your project's .xcworkspace file in XCode and initialize Smooch with your app token inside of applicationDidFinishLaunchingWithOptions.

```
#import <Smooch/Smooch.h>

...

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    // Initialize Smooch - these instructions are also available on [app.smooch.io](https://app.smooch.io)
    [Smooch initWithSettings:[SKTSettings settingsWithAppId:@"YOUR_APP_ID"] completionHandler:^(NSError * _Nullable error, NSDictionary * _Nullable userInfo) {
        // Your code after init is complete
    }];
}
```

You're now ready to start interacting with Smooch in your React Native app.

## Android

You can easily add a binding to the [Smooch Android SDK](https://github.com/smooch/smooch-android) in your React Native application by following the instructions below.

* Add the `ReactNativeSmoochPackage` to the list of packages in your `ReactApplication`
```java
@Override
protected List<ReactPackage> getPackages() {
    return Arrays.<ReactPackage>asList(
            new MainReactPackage(),
            new ReactNativeSmoochPackage()
    );
}
```

* Add `Smooch.init` to the `onCreate` method of your `Application` class.

```java
import io.smooch.core.Smooch;
import com.facebook.soloader.SoLoader;

public class MainApplication extends Application implements ReactApplication {
    ...
    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, /* native exopackage */ false);
        Smooch.init(this, new Settings("YOUR_APP_ID"), new SmoochCallback() {
            @Override
            public void run(Response response) {
                // Your code after init is complete
            }
        });
    }
    ...
}
```

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

### Set the user's sign up date
```javascript
Smooch.setSignedUpAt( (new Date).getTime() );
```

### Associate key/value pairs with the user
```javascript
Smooch.setUserProperties({"whenDidYouFsckUp": "aLongTimeAgo"});
```

Learn more about the functions we've wrapped by checking out SmoochClient.js in the "lib" directory.
