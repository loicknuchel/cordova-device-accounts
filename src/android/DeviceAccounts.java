package org.loicknuchel.cordova.deviceaccounts;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.accounts.AccountManager;
import android.accounts.Account;
import java.util.List;
import java.util.ArrayList;

/**
 * See :
 * http://developer.android.com/reference/android/accounts/AccountManager.html
 * http://developer.android.com/reference/android/accounts/Account.html
 */
public class DeviceAccounts extends CordovaPlugin {
  /**
     * Sets the context of the Command. This can then be used to do things like
     * get file paths associated with the Activity.
     *
     * @param cordova The context of the main Activity.
     * @param webView The CordovaWebView Cordova is running in.
     */
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
  }

  /**
     * Executes the request and returns PluginResult.
     *
     * @param action            The action to execute.
     * @param args              JSONArry of arguments for the plugin.
     * @param callbackContext   The callback id used when calling back into JavaScript.
     * @return                  True if the action was valid, false if not.
     */
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    if("getDeviceAccounts".equals(action)){
      List<Account> accounts = getAccounts(null);
      JSONArray result = formatResult(accounts);
      callbackContext.success(result);
      return true;
    } else if("getDeviceAccountsByType".equals(action)){
      final String type = args.getString(0);
      List<Account> accounts = getAccounts(type);
      JSONArray result = formatResult(accounts);
      callbackContext.success(result);
      return true;
    } else {
      callbackContext.error("DeviceAccounts." + action + " is not a supported function. Avaiable functions are getDeviceAccounts() and getDeviceAccountsByType(String type) !");
      return false;
    }
  }

  //--------------------------------------------------------------------------
  // LOCAL METHODS
  //--------------------------------------------------------------------------
  private List<Account> getAccounts(String type) {
    AccountManager manager = AccountManager.get(cordova.getActivity().getApplicationContext());
    Account[] accounts = manager.getAccounts();
    List<Account> ret = new ArrayList<Account>();
    for(Account account : accounts){
      if(type == null || account.type.equals(type)){
        ret.add(account);
      }
    }
    return ret;
  }

  private JSONArray formatResult(List<Account> accounts) throws JSONException {
    JSONArray jsonAccounts = new JSONArray();
    for (Account a : accounts) {
      JSONObject obj = new JSONObject();
      obj.put("type", a.type);
      obj.put("name", a.name);
      jsonAccounts.put(obj);
    }
    return jsonAccounts;
  }
}
