# Cordova plugin to get device accounts

Cordova plugin to get the device accounts on Android

Requires the **android.permission.GET_ACCOUNTS** permission.

## Install

```
cordova plugin add https://github.com/loicknuchel/cordova-device-accounts.git
```

## Methods

- cordova.plugins.DeviceAccounts.get(onSuccess, onFail)
- cordova.plugins.DeviceAccounts.getByType(type, onSuccess, onFail)

### Example

````
cordova.plugins.DeviceAccounts.get(function(accounts){
  // accounts is an array with objects containing name and type attributes
  console.log('account registered on this device:', accounts);
}, function(error){
  console.log('Fail to retrieve accounts, details on exception:', error);
});
```

## Compatibility

Tested with:

* Cordova 3.3
* Android 4.4

Should work with Android API level 5+ and Android >2.2, but not tested.
