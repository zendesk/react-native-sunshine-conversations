require 'json'

package = JSON.parse(File.read(File.join(__dir__, 'package.json')))

Pod::Spec.new do |s|
  s.name             = "react-native-smooch"
  s.version          = package['version']
  s.summary          = "A React Native client for smooch.io"
  s.requires_arc = true
  s.author       = { "Smooch Technologies Inc." => "help@smooch.io" }
  s.license      = 'MIT'
  s.homepage     = 'https://smooch.io'
  s.source       = { :git => "https://github.com/smooch/react-native-smooch" }
  s.source_files = 'ios/**/*.{h,m}'
  s.platform     = :ios, "8.0"
  s.dependency 'Smooch', '~> 7.1.2'
  s.dependency 'React'
end
