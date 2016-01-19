#import "SmoochManager.h"
#import <Smooch/Smooch.h>

@implementation SmoochManager

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(show) {
  NSLog(@"Smooch Show");

  dispatch_async(dispatch_get_main_queue(), ^{
    [Smooch show];
  });
};

RCT_EXPORT_METHOD(login:(NSString*)userId jwt:(NSString*)jwt) {
  NSLog(@"Smooch Login");

  dispatch_async(dispatch_get_main_queue(), ^{
    [Smooch login:userId jwt:jwt];
  });
};

RCT_EXPORT_METHOD(logout) {
  NSLog(@"Smooch Logout");

dispatch_async(dispatch_get_main_queue(), ^{
    [Smooch logout];
  });
};


RCT_EXPORT_METHOD(setUserProperties:(NSDictionary*)options) {
  NSLog(@"Smooch setUserProperties with %@", options);

  [[SKTUser currentUser] addProperties:options];
};

RCT_EXPORT_METHOD(track:(NSString*)eventName) {
  NSLog(@"Smooch track with %@", eventName);

  [Smooch track:eventName];
};

RCT_EXPORT_METHOD(setFirstName:(NSString*)firstName) {
  NSLog(@"Smooch setFirstName");

  [SKTUser currentUser].firstName = firstName;
};

RCT_EXPORT_METHOD(setLastName:(NSString*)lastName) {
  NSLog(@"Smooch setLastName");

  [SKTUser currentUser].lastName = lastName;
};

RCT_EXPORT_METHOD(setEmail:(NSString*)email) {
  NSLog(@"Smooch setEmail");

  [SKTUser currentUser].email = email;
};

@end
