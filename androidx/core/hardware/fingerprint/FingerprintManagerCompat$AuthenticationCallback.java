package androidx.core.hardware.fingerprint;

public abstract class AuthenticationCallback {
  public void onAuthenticationError(int paramInt, CharSequence paramCharSequence) {}
  
  public void onAuthenticationFailed() {}
  
  public void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence) {}
  
  public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult paramAuthenticationResult) {}
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\hardware\fingerprint\FingerprintManagerCompat$AuthenticationCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */