'use strict';

var React = require('react-native');
var { NativeModules } = React;

let SmoochManager = NativeModules.SmoochManager;

module.exports = Object.assign({}, SmoochManager, {
    login: function login(userId, jwt) {
    	jwt = jwt || '';

    	return SmoochManager.login(userId, jwt);
    }
});
