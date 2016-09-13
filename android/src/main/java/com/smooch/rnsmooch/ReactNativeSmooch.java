package com.smooch.rnsmooch;

import android.app.Activity;

import com.facebook.react.ReactActivity;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;

import java.util.HashMap;
import java.util.Map;

import io.smooch.core.User;
import io.smooch.ui.ConversationActivity;
import io.smooch.core.Smooch;

/**
 * Created by mario on 2016-01-18.
 */

public class ReactNativeSmooch extends ReactContextBaseJavaModule {
    @Override
    public String getName() {
        return "SmoochManager";
    }

    public ReactNativeSmooch(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    final Activity currentActivity = this.getCurrentActivity();

    @ReactMethod
    public void login(String userId, String jwt) {
        Smooch.login(userId, jwt);
    }

    @ReactMethod
    public void show() {
        if (currentActivity == null) {
            // The currentActivity can be null if it is backgrounded / destroyed, so we simply
            // no-op to prevent any null pointer exceptions.
            return;
        } else {
            ConversationActivity.show(currentActivity);
        }
    }

    @ReactMethod
    public void track(String event) {
        Smooch.track(event);
    }

    @ReactMethod
    public void setFirstName(String firstName) {
        User.getCurrentUser().setFirstName(firstName);
    }

    @ReactMethod
    public void setLastName(String lastName) {
        User.getCurrentUser().setLastName(lastName);
    }

    @ReactMethod
    public void setEmail(String email) {
        User.getCurrentUser().setEmail(email);
    }

    @ReactMethod
    public void setUserProperties(ReadableMap properties) {
        User.getCurrentUser().addProperties(getUserProperties(properties));
    }

    private Map<String, Object> getUserProperties(ReadableMap properties) {
        ReadableMapKeySetIterator iterator = properties.keySetIterator();
        Map<String, Object> userProperties = new HashMap<>();

        while(iterator.hasNextKey()) {
            String key = iterator.nextKey();
            ReadableType type = properties.getType(key);
            if (type == ReadableType.Boolean) {
                userProperties.put(key, properties.getBoolean(key));
            } else if (type == ReadableType.Number) {
                userProperties.put(key, properties.getDouble(key));
            } else if (type == ReadableType.String) {
                userProperties.put(key, properties.getString(key));
            }
        }

        return userProperties;
    }


}
