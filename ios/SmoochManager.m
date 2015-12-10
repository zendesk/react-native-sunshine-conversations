#import "SmoochManager.h"
#import <Smooch/Smooch.h>

@implementation SmoochManager

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(show:(RCTResponseSenderBlock)callback) {
  NSLog(@"Smooch Show");
  
dispatch_async(dispatch_get_main_queue(), ^{
    [Smooch show];
  });

  callback(@[[NSNull null]]);
};

RCT_EXPORT_METHOD(login:(NSString*)userId jwt:(NSString*)jwt callback:(RCTResponseSenderBlock)callback) {
  NSLog(@"Smooch Show");
  
dispatch_async(dispatch_get_main_queue(), ^{
    [Smooch login:userId jwt:jwt];
  });

  callback(@[[NSNull null]]);
};

RCT_EXPORT_METHOD(logout:(RCTResponseSenderBlock)callback) {
  NSLog(@"Smooch Show");
  
dispatch_async(dispatch_get_main_queue(), ^{
    [Smooch logout];
  });

  callback(@[[NSNull null]]);
};


RCT_EXPORT_METHOD(setUserProperties:(NSDictionary*)options callback:(RCTResponseSenderBlock)callback) {
  NSLog(@"Smooch setUserProperties with %@", options);
  NSDictionary* attributes = options;
  
  [[SKTUser currentUser] addProperties:options];

  callback(@[[NSNull null]]);
};

RCT_EXPORT_METHOD(track:(NSString*)eventName callback:(RCTResponseSenderBlock)callback) {
  NSLog(@"Smooch track with %@", eventName);
  
  [Smooch track:eventName];

  callback(@[[NSNull null]]);
};

RCT_EXPORT_METHOD(setFirstName:(NSString*)firstName callback:(RCTResponseSenderBlock)callback) {
  NSLog(@"Smooch setFirstName");
  
  [SKTUser currentUser].firstName = firstName;
  
  callback(@[[NSNull null]]);
};

RCT_EXPORT_METHOD(setLastName:(NSString*)lastName callback:(RCTResponseSenderBlock)callback) {
  NSLog(@"Smooch setLastName");
  
  [SKTUser currentUser].lastName = lastName;
  
  callback(@[[NSNull null]]);
};

RCT_EXPORT_METHOD(setEmail:(NSString*)email callback:(RCTResponseSenderBlock)callback) {
  NSLog(@"Smooch setEmail");
  
  [SKTUser currentUser].email = email;
  
  callback(@[[NSNull null]]);
};

@end