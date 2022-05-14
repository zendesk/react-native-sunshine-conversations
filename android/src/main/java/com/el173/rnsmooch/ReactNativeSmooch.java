package com.el173.rnsmooch;

import android.content.Intent;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.Promise;

import java.util.HashMap;
import java.util.Map;

import io.smooch.core.FcmService;
import io.smooch.core.Smooch;
import io.smooch.core.SmoochCallback;
import io.smooch.core.User;
import io.smooch.ui.ConversationActivity;

public class ReactNativeSmooch extends ReactContextBaseJavaModule {
  @Override
  public String getName() {
    return "SmoochManager";
  }

  public ReactNativeSmooch(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @ReactMethod
  public void login(String userId, String jwt, final Promise promise) {
    Smooch.login(userId, jwt, new SmoochCallback() {
      @Override
      public void run(Response response) {
      if (promise != null) {
        if (response.getError() != null) {
          promise.reject("" + response.getStatus(), response.getError());
          return;
        }

        promise.resolve(null);
      }
      }
    });
  }

  @ReactMethod
  public void logout(final Promise promise) {
    Smooch.logout(new SmoochCallback() {
      @Override
      public void run(Response response) {
      if (response.getError() != null) {
        promise.reject("" + response.getStatus(), response.getError());
        return;
      }

      promise.resolve(null);
      }
    });
  }

  @ReactMethod
  public void show() {
//    ConversationActivity.show(getReactApplicationContext(), Intent.FLAG_ACTIVITY_NEW_TASK);
     ConversationActivity.builder().withFlags(Intent.FLAG_ACTIVITY_NEW_TASK).show(getReactApplicationContext());
  }

  @ReactMethod
  public void close() {
    ConversationActivity.close();
  }

  @ReactMethod
  public void getUnreadCount(Promise promise) {
    int unreadCount = Smooch.getConversation().getUnreadCount();
    promise.resolve(unreadCount);
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
    User.getCurrentUser().addMetadata(getUserProperties(properties));
  }

//  @ReactMethod
//  public void triggerSmoochNotification(ReadableMap remoteMessage, Promise promise) {
//    try {
//      HashMap<String,Object> map = remoteMessage.toHashMap();
//      HashMap<String,String> newMap =new HashMap<String,String>();
//
//      for (Map.Entry<String, Object> entry : map.entrySet()) {
//        if(entry.getValue() instanceof String){
//          newMap.put(entry.getKey(), entry.getValue().toString());
//        }
//      }
//      Log.v("SMOOCH", String.valueOf(newMap));
//      FcmService.triggerSmoochNotification(newMap, getReactApplicationContext());
//      promise.resolve(true);
//    } catch (Exception e) {
//      promise.resolve("ERROR While parsing smooch notification : " + e.getLocalizedMessage());
//    }
//  }

  @ReactMethod
  public void setFirebaseCloudMessagingToken(String fcmToken) {
    Smooch.setFirebaseCloudMessagingToken(fcmToken);
  }

  private Map<String, Object> getUserProperties(ReadableMap properties) {
    ReadableMapKeySetIterator iterator = properties.keySetIterator();
    Map<String, Object> userProperties = new HashMap<>();

    while (iterator.hasNextKey()) {
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
