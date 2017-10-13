'use strict';

import React from 'react';
import { NativeModules } from 'react-native';

const { SmoochManager } = NativeModules;

module.exports = Object.assign({}, SmoochManager);
