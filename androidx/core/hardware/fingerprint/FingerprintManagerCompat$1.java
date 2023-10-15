package androidx.core.hardware.fingerprint;

import android.hardware.fingerprint.FingerprintManager;

final class null extends FingerprintManager.AuthenticationCallback {
  public void onAuthenticationError(int paramInt, CharSequence paramCharSequence) {
    callback.onAuthenticationError(paramInt, paramCharSequence);
  }
  
  public void onAuthenticationFailed() {
    callback.onAuthenticationFailed();
  }
  
  public void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence) {
    callback.onAuthenticationHelp(paramInt, paramCharSequence);
  }
  
  public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult paramAuthenticationResult) {
    callback.onAuthenticationSucceeded(new FingerprintManagerCompat.AuthenticationResult(FingerprintManagerCompat.unwrapCryptoObject(paramAuthenticationResult.getCryptoObject())));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\hardware\fingerprint\FingerprintManagerCompat$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */