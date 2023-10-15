package com.google.android.play.core.review.internal;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class zzv {
  public static String zza(byte[] paramArrayOfbyte) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
      messageDigest.update(paramArrayOfbyte);
      return Base64.encodeToString(messageDigest.digest(), 11);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      return "";
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\internal\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */