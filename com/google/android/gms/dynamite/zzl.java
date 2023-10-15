package com.google.android.gms.dynamite;

import android.content.Context;

final class zzl implements DynamiteModule.VersionPolicy {
  public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context paramContext, String paramString, DynamiteModule.VersionPolicy.IVersions paramIVersions) throws DynamiteModule.LoadingException {
    // Byte code:
    //   0: new com/google/android/gms/dynamite/DynamiteModule$VersionPolicy$SelectionResult
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #4
    //   9: aload_3
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface zza : (Landroid/content/Context;Ljava/lang/String;)I
    //   17: istore #5
    //   19: aload #4
    //   21: iload #5
    //   23: putfield localVersion : I
    //   26: iload #5
    //   28: ifeq -> 52
    //   31: aload_3
    //   32: aload_1
    //   33: aload_2
    //   34: iconst_0
    //   35: invokeinterface zzb : (Landroid/content/Context;Ljava/lang/String;Z)I
    //   40: istore #5
    //   42: aload #4
    //   44: iload #5
    //   46: putfield remoteVersion : I
    //   49: goto -> 70
    //   52: aload_3
    //   53: aload_1
    //   54: aload_2
    //   55: iconst_1
    //   56: invokeinterface zzb : (Landroid/content/Context;Ljava/lang/String;Z)I
    //   61: istore #5
    //   63: aload #4
    //   65: iload #5
    //   67: putfield remoteVersion : I
    //   70: aload #4
    //   72: getfield localVersion : I
    //   75: istore #6
    //   77: iload #6
    //   79: istore #7
    //   81: iload #6
    //   83: ifne -> 103
    //   86: iload #5
    //   88: ifne -> 100
    //   91: aload #4
    //   93: iconst_0
    //   94: putfield selection : I
    //   97: goto -> 125
    //   100: iconst_0
    //   101: istore #7
    //   103: iload #5
    //   105: iload #7
    //   107: if_icmplt -> 119
    //   110: aload #4
    //   112: iconst_1
    //   113: putfield selection : I
    //   116: goto -> 125
    //   119: aload #4
    //   121: iconst_m1
    //   122: putfield selection : I
    //   125: aload #4
    //   127: areturn
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\dynamite\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */