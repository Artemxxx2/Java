package androidx.core.hardware.fingerprint;

public final class AuthenticationResult {
  private final FingerprintManagerCompat.CryptoObject mCryptoObject;
  
  public AuthenticationResult(FingerprintManagerCompat.CryptoObject paramCryptoObject) {
    this.mCryptoObject = paramCryptoObject;
  }
  
  public FingerprintManagerCompat.CryptoObject getCryptoObject() {
    return this.mCryptoObject;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\hardware\fingerprint\FingerprintManagerCompat$AuthenticationResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */