'use strict';

import React from 'react';
import { NativeModules } from 'react-native';

const { SmoochManager } = NativeModules;

module.exports = Object.assign({}, SmoochManager, {
    login: function login(userId, jwt) {
    	jwt = jwt || '';

    	return SmoochManager.login(userId, jwt);
    }
});
