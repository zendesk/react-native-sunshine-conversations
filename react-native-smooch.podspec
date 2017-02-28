Pod::Spec.new do |s|
  s.name             = "react-native-smooch"
  s.version          = "0.1.3"
  s.summary          = "A React Native client for smooch.io"
  s.requires_arc = true
  s.author       = { "Mike Gozzo" => "gozman@users.noreply.github.com" }
  s.license      = 'MIT'
  s.homepage     = 'n/a'
  s.source       = { :git => "https://github.com/smooch/react-native-smooch" }
  s.source_files = 'ios/*'
  s.platform     = :ios, "8.0"
  s.dependency 'Smooch', '~> 4.0'
  s.dependency 'React'
end
