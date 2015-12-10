'use strict';

var React = require('react-native');
var {
	NativeModules
} = React;

let SmoochManager = NativeModules.SmoochManager;

/**
 * @class SmoochClient
 */

class SmoochClient {
	show() {
		return new Promise((resolve, reject) => {
			SmoochManager.show(function(error) {
				if (error) {
					reject(error);
				} else {
					resolve()
				}
			});
		});
	}

	login(userId, jwt) {
		return new Promise((resolve, reject) => {
			SmoochManager.login(userId, jwt, function(error) {
				if (error) {
					reject(error);
				} else {
					resolve()
				}
			});
		});
	}

	logout() {
		return new Promise((resolve, reject) => {
			SmoochManager.logout(function(error) {
				if (error) {
					reject(error);
				} else {
					resolve()
				}
			});
		});
	}	

	setUserProperties(properties) {
		return new Promise((resolve, reject) => {
			SmoochManager.setUserProperties(properties, function(error) {
				if (error) {
					reject(error);
				} else {
					resolve()
				}
			});
		});
	}

	track(eventName) {
		return new Promise((resolve, reject) => {
			SmoochManager.track(eventName, function(error) {
				if (error) {
					reject(error);
				} else {
					resolve()
				}
			});
		});
	}

	setFirstName(firstName) {
		return new Promise((resolve, reject) => {
			SmoochManager.setFirstName(firstName, function(error) {
				if (error) {
					reject(error);
				} else {
					resolve()
				}
			});
		});
	}

	setLastName(lastName) {
		return new Promise((resolve, reject) => {
			SmoochManager.setLastName(lastName, function(error) {
				if (error) {
					reject(error);
				} else {
					resolve()
				}
			});
		});
	}

	setEmail(email) {
		return new Promise((resolve, reject) => {
			SmoochManager.setEmail(email, function(error) {
				if (error) {
					reject(error);
				} else {
					resolve()
				}
			});
		});
	}	
}

module.exports = new SmoochClient();