# cordova-device-accounts

Cordova plugin to get the device accounts on Android

Requires the **android.permission.GET_ACCOUNTS** permission.

## Install

```
cordova plugin add https://github.com/loicknuchel/cordova-device-accounts.git
```

## Methods

- `plugins.DeviceAccounts.get(onSuccess, onFail)` : get all accounts registred on device
- `plugins.DeviceAccounts.getByType(type, onSuccess, onFail)` : get all accounts registred on device for requested type
- `plugins.DeviceAccounts.getEmails(onSuccess, onFail)` : get all emails registred on device (accounts with 'com.google' type)
- `plugins.DeviceAccounts.getEmail(onSuccess, onFail)` : get the first email registred on device or undefined

## Example

```javascript
window.plugins.DeviceAccounts.get(function(accounts){
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
