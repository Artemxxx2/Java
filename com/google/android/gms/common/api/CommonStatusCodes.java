package com.google.android.gms.common.api;

import androidx.annotation.NonNull;

public class CommonStatusCodes {
  public static final int API_NOT_CONNECTED = 17;
  
  public static final int CANCELED = 16;
  
  public static final int CONNECTION_SUSPENDED_DURING_CALL = 20;
  
  public static final int DEVELOPER_ERROR = 10;
  
  public static final int ERROR = 13;
  
  public static final int INTERNAL_ERROR = 8;
  
  public static final int INTERRUPTED = 14;
  
  public static final int INVALID_ACCOUNT = 5;
  
  public static final int NETWORK_ERROR = 7;
  
  public static final int RECONNECTION_TIMED_OUT = 22;
  
  public static final int RECONNECTION_TIMED_OUT_DURING_UPDATE = 21;
  
  public static final int REMOTE_EXCEPTION = 19;
  
  public static final int RESOLUTION_REQUIRED = 6;
  
  @Deprecated
  public static final int SERVICE_DISABLED = 3;
  
  @Deprecated
  public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
  
  public static final int SIGN_IN_REQUIRED = 4;
  
  public static final int SUCCESS = 0;
  
  public static final int SUCCESS_CACHE = -1;
  
  public static final int TIMEOUT = 15;
  
  @NonNull
  public static String getStatusCodeString(int paramInt) {
    StringBuilder stringBuilder;
    switch (paramInt) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("unknown status code: ");
        stringBuilder.append(paramInt);
        return stringBuilder.toString();
      case 22:
        return "RECONNECTION_TIMED_OUT";
      case 21:
        return "RECONNECTION_TIMED_OUT_DURING_UPDATE";
      case 20:
        return "CONNECTION_SUSPENDED_DURING_CALL";
      case 19:
        return "REMOTE_EXCEPTION";
      case 18:
        return "DEAD_CLIENT";
      case 17:
        return "API_NOT_CONNECTED";
      case 16:
        return "CANCELED";
      case 15:
        return "TIMEOUT";
      case 14:
        return "INTERRUPTED";
      case 13:
        return "ERROR";
      case 10:
        return "DEVELOPER_ERROR";
      case 8:
        return "INTERNAL_ERROR";
      case 7:
        return "NETWORK_ERROR";
      case 6:
        return "RESOLUTION_REQUIRED";
      case 5:
        return "INVALID_ACCOUNT";
      case 4:
        return "SIGN_IN_REQUIRED";
      case 3:
        return "SERVICE_DISABLED";
      case 2:
        return "SERVICE_VERSION_UPDATE_REQUIRED";
      case 0:
        return "SUCCESS";
      case -1:
        break;
    } 
    return "SUCCESS_CACHE";
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\api\CommonStatusCodes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */