package org.apache.cordova;

import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public interface ICordovaClientCertRequest {
  void cancel();
  
  String getHost();
  
  String[] getKeyTypes();
  
  int getPort();
  
  Principal[] getPrincipals();
  
  void ignore();
  
  void proceed(PrivateKey paramPrivateKey, X509Certificate[] paramArrayOfX509Certificate);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\ICordovaClientCertRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */