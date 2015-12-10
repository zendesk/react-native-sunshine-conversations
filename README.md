# react-native-smooch
React Native wrapper for Smooch.io. Based off of [smooch-cordova](https://github.com/smooch/smooch-cordova)

At the moment, this wrapper only covers the most commonly used features of the Smooch SDK. We encourage you to add to this wrapper or make any feature requests you need. Pull requests most definitely welcome!

Please hit up [@gozmike](https://twitter.com/gozmike) with any questions or [contact Smooch](mailto:help@smooch.io).

Installing Smooch on React Native
=================================

First, make sure you've [signed up for Smooch](https://app.smooch.io/signup)

Next, grab this React component with `npm install react-native-smooch`

## iOS

1. Navigate to the .xcodeproj in your React Native project's directory and follow [these steps](http://docs.smooch.io/ios/#adding-smooch-to-your-app) for adding the Smooch binary distribution to your project with CocoaPods.

2. Open your project's .xcworkspace file in XCode and initialize Smooch with your app token inside of applicationDidFinishLaunchingWithOptions.

```
- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    // Initialize Smooch - these instructions are also available on [app.smooch.io](https://app.smooch.io)
    [Smooch initWithSettings:
        [SKTSettings settingsWithAppToken:@"YOUR APP TOKEN GOES HERE"]];
}
```

3. Go to `node_modules/react-native-smooch/ios` and drag `SmoochManager.h` and `SmoochManager.m` into your XCode file tree so that they're included in the build.

You're now ready to start interacting with Smooch in your React Native app.

## Android

Coming soon!

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

