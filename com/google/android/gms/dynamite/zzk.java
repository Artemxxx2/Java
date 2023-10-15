package com.google.android.gms.dynamite;

import android.content.Context;

final class zzk implements DynamiteModule.VersionPolicy {
  public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context paramContext, String paramString, DynamiteModule.VersionPolicy.IVersions paramIVersions) throws DynamiteModule.LoadingException {
    // Byte code:
    //   0: new com/google/android/gms/dynamite/DynamiteModule$VersionPolicy$SelectionResult
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #4
    //   9: aload #4
    //   11: aload_3
    //   12: aload_1
    //   13: aload_2
    //   14: invokeinterface zza : (Landroid/content/Context;Ljava/lang/String;)I
    //   19: putfield localVersion : I
    //   22: aload_3
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_1
    //   26: invokeinterface zzb : (Landroid/content/Context;Ljava/lang/String;Z)I
    //   31: istore #5
    //   33: aload #4
    //   35: iload #5
    //   37: putfield remoteVersion : I
    //   40: aload #4
    //   42: getfield localVersion : I
    //   45: istore #6
    //   47: iload #6
    //   49: istore #7
    //   51: iload #6
    //   53: ifne -> 73
    //   56: iload #5
    //   58: ifne -> 70
    //   61: aload #4
    //   63: iconst_0
    //   64: putfield selection : I
    //   67: goto -> 95
    //   70: iconst_0
    //   71: istore #7
    //   73: iload #5
    //   75: iload #7
    //   77: if_icmplt -> 89
    //   80: aload #4
    //   82: iconst_1
    //   83: putfield selection : I
    //   86: goto -> 95
    //   89: aload #4
    //   91: iconst_m1
    //   92: putfield selection : I
    //   95: aload #4
    //   97: areturn
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\dynamite\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */