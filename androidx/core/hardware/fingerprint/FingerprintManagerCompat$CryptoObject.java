package androidx.core.hardware.fingerprint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public class CryptoObject {
  private final Cipher mCipher;
  
  private final Mac mMac;
  
  private final Signature mSignature;
  
  public CryptoObject(@NonNull Signature paramSignature) {
    this.mSignature = paramSignature;
    this.mCipher = null;
    this.mMac = null;
  }
  
  public CryptoObject(@NonNull Cipher paramCipher) {
    this.mCipher = paramCipher;
    this.mSignature = null;
    this.mMac = null;
  }
  
  public CryptoObject(@NonNull Mac paramMac) {
    this.mMac = paramMac;
    this.mCipher = null;
    this.mSignature = null;
  }
  
  @Nullable
  public Cipher getCipher() {
    return this.mCipher;
  }
  
  @Nullable
  public Mac getMac() {
    return this.mMac;
  }
  
  @Nullable
  public Signature getSignature() {
    return this.mSignature;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\hardware\fingerprint\FingerprintManagerCompat$CryptoObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */