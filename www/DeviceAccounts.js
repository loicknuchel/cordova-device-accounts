function DeviceAccounts(){}

DeviceAccounts.prototype.get = function(onSuccess, onFail){
  cordova.exec(onSuccess, onFail, "DeviceAccounts", "getDeviceAccounts", []);
};
DeviceAccounts.prototype.getByType = function(type, onSuccess, onFail){
  cordova.exec(onSuccess, onFail, "DeviceAccounts", "getDeviceAccountsByType", [type]);
};

/*DeviceAccounts.install = function(){
  if (!window.plugins){
    window.plugins = {};
  }

  window.plugins.DeviceAccounts = new DeviceAccounts();
  return window.plugins.DeviceAccounts;
};

cordova.addConstructor(DeviceAccounts.install);*/

module.exports = DeviceAccounts;
