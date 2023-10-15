package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzm;
import com.google.android.gms.internal.play_billing.zzu;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class BillingFlowParams {
  @NonNull
  public static final String EXTRA_PARAM_KEY_ACCOUNT_ID = "accountId";
  
  private boolean zza;
  
  private String zzb;
  
  private String zzc;
  
  private SubscriptionUpdateParams zzd;
  
  private zzu zze;
  
  private ArrayList zzf;
  
  private boolean zzg;
  
  private BillingFlowParams() {}
  
  @NonNull
  public static Builder newBuilder() {
    return new Builder(null);
  }
  
  public final int zza() {
    return this.zzd.zza();
  }
  
  @Nullable
  public final String zzb() {
    return this.zzb;
  }
  
  @Nullable
  public final String zzc() {
    return this.zzc;
  }
  
  @Nullable
  public final String zzd() {
    return this.zzd.zzc();
  }
  
  @NonNull
  public final ArrayList zze() {
    ArrayList arrayList = new ArrayList();
    arrayList.addAll(this.zzf);
    return arrayList;
  }
  
  @NonNull
  public final List zzf() {
    return (List)this.zze;
  }
  
  public final boolean zzn() {
    return this.zzg;
  }
  
  final boolean zzo() {
    return (this.zzb != null || this.zzc != null || this.zzd.zza() != 0 || this.zza || this.zzg);
  }
  
  public static class Builder {
    private String zza;
    
    private String zzb;
    
    private List zzc;
    
    private ArrayList zzd;
    
    private boolean zze;
    
    private BillingFlowParams.SubscriptionUpdateParams.Builder zzf;
    
    private Builder() {
      BillingFlowParams.SubscriptionUpdateParams.Builder builder = BillingFlowParams.SubscriptionUpdateParams.newBuilder();
      BillingFlowParams.SubscriptionUpdateParams.Builder.zza(builder);
      this.zzf = builder;
    }
    
    @NonNull
    public BillingFlowParams build() {
      // Byte code:
      //   0: aload_0
      //   1: getfield zzd : Ljava/util/ArrayList;
      //   4: astore_1
      //   5: iconst_1
      //   6: istore_2
      //   7: aload_1
      //   8: ifnull -> 28
      //   11: aload_1
      //   12: invokevirtual isEmpty : ()Z
      //   15: ifne -> 23
      //   18: iconst_1
      //   19: istore_3
      //   20: goto -> 30
      //   23: iconst_0
      //   24: istore_3
      //   25: goto -> 30
      //   28: iconst_0
      //   29: istore_3
      //   30: aload_0
      //   31: getfield zzc : Ljava/util/List;
      //   34: astore_1
      //   35: aload_1
      //   36: ifnull -> 54
      //   39: aload_1
      //   40: invokeinterface isEmpty : ()Z
      //   45: ifne -> 54
      //   48: iconst_1
      //   49: istore #4
      //   51: goto -> 57
      //   54: iconst_0
      //   55: istore #4
      //   57: iload_3
      //   58: ifne -> 79
      //   61: iload #4
      //   63: ifeq -> 69
      //   66: goto -> 79
      //   69: new java/lang/IllegalArgumentException
      //   72: dup
      //   73: ldc 'Details of the products must be provided.'
      //   75: invokespecial <init> : (Ljava/lang/String;)V
      //   78: athrow
      //   79: iload_3
      //   80: ifeq -> 101
      //   83: iload #4
      //   85: ifne -> 91
      //   88: goto -> 101
      //   91: new java/lang/IllegalArgumentException
      //   94: dup
      //   95: ldc 'Set SkuDetails or ProductDetailsParams, not both.'
      //   97: invokespecial <init> : (Ljava/lang/String;)V
      //   100: athrow
      //   101: iload_3
      //   102: ifeq -> 348
      //   105: aload_0
      //   106: getfield zzd : Ljava/util/ArrayList;
      //   109: aconst_null
      //   110: invokevirtual contains : (Ljava/lang/Object;)Z
      //   113: ifne -> 338
      //   116: aload_0
      //   117: getfield zzd : Ljava/util/ArrayList;
      //   120: invokevirtual size : ()I
      //   123: iconst_1
      //   124: if_icmple -> 573
      //   127: aload_0
      //   128: getfield zzd : Ljava/util/ArrayList;
      //   131: iconst_0
      //   132: invokevirtual get : (I)Ljava/lang/Object;
      //   135: checkcast com/android/billingclient/api/SkuDetails
      //   138: astore #5
      //   140: aload #5
      //   142: invokevirtual getType : ()Ljava/lang/String;
      //   145: astore_1
      //   146: aload_0
      //   147: getfield zzd : Ljava/util/ArrayList;
      //   150: astore #6
      //   152: aload #6
      //   154: invokeinterface size : ()I
      //   159: istore #7
      //   161: iconst_0
      //   162: istore #8
      //   164: iload #8
      //   166: iload #7
      //   168: if_icmpge -> 238
      //   171: aload #6
      //   173: iload #8
      //   175: invokeinterface get : (I)Ljava/lang/Object;
      //   180: checkcast com/android/billingclient/api/SkuDetails
      //   183: astore #9
      //   185: aload_1
      //   186: ldc 'play_pass_subs'
      //   188: invokevirtual equals : (Ljava/lang/Object;)Z
      //   191: ifne -> 232
      //   194: aload #9
      //   196: invokevirtual getType : ()Ljava/lang/String;
      //   199: ldc 'play_pass_subs'
      //   201: invokevirtual equals : (Ljava/lang/Object;)Z
      //   204: ifne -> 232
      //   207: aload_1
      //   208: aload #9
      //   210: invokevirtual getType : ()Ljava/lang/String;
      //   213: invokevirtual equals : (Ljava/lang/Object;)Z
      //   216: ifeq -> 222
      //   219: goto -> 232
      //   222: new java/lang/IllegalArgumentException
      //   225: dup
      //   226: ldc 'SKUs should have the same type.'
      //   228: invokespecial <init> : (Ljava/lang/String;)V
      //   231: athrow
      //   232: iinc #8, 1
      //   235: goto -> 164
      //   238: aload #5
      //   240: invokevirtual zzd : ()Ljava/lang/String;
      //   243: astore #6
      //   245: aload_0
      //   246: getfield zzd : Ljava/util/ArrayList;
      //   249: astore #5
      //   251: aload #5
      //   253: invokeinterface size : ()I
      //   258: istore #7
      //   260: iconst_0
      //   261: istore #8
      //   263: iload #8
      //   265: iload #7
      //   267: if_icmpge -> 573
      //   270: aload #5
      //   272: iload #8
      //   274: invokeinterface get : (I)Ljava/lang/Object;
      //   279: checkcast com/android/billingclient/api/SkuDetails
      //   282: astore #9
      //   284: aload_1
      //   285: ldc 'play_pass_subs'
      //   287: invokevirtual equals : (Ljava/lang/Object;)Z
      //   290: ifne -> 332
      //   293: aload #9
      //   295: invokevirtual getType : ()Ljava/lang/String;
      //   298: ldc 'play_pass_subs'
      //   300: invokevirtual equals : (Ljava/lang/Object;)Z
      //   303: ifne -> 332
      //   306: aload #6
      //   308: aload #9
      //   310: invokevirtual zzd : ()Ljava/lang/String;
      //   313: invokevirtual equals : (Ljava/lang/Object;)Z
      //   316: ifeq -> 322
      //   319: goto -> 332
      //   322: new java/lang/IllegalArgumentException
      //   325: dup
      //   326: ldc 'All SKUs must have the same package name.'
      //   328: invokespecial <init> : (Ljava/lang/String;)V
      //   331: athrow
      //   332: iinc #8, 1
      //   335: goto -> 263
      //   338: new java/lang/IllegalArgumentException
      //   341: dup
      //   342: ldc 'SKU cannot be null.'
      //   344: invokespecial <init> : (Ljava/lang/String;)V
      //   347: athrow
      //   348: aload_0
      //   349: getfield zzc : Ljava/util/List;
      //   352: iconst_0
      //   353: invokeinterface get : (I)Ljava/lang/Object;
      //   358: checkcast com/android/billingclient/api/BillingFlowParams$ProductDetailsParams
      //   361: astore_1
      //   362: iconst_0
      //   363: istore #8
      //   365: iload #8
      //   367: aload_0
      //   368: getfield zzc : Ljava/util/List;
      //   371: invokeinterface size : ()I
      //   376: if_icmpge -> 471
      //   379: aload_0
      //   380: getfield zzc : Ljava/util/List;
      //   383: iload #8
      //   385: invokeinterface get : (I)Ljava/lang/Object;
      //   390: checkcast com/android/billingclient/api/BillingFlowParams$ProductDetailsParams
      //   393: astore #5
      //   395: aload #5
      //   397: ifnull -> 461
      //   400: iload #8
      //   402: ifeq -> 455
      //   405: aload #5
      //   407: invokevirtual zza : ()Lcom/android/billingclient/api/ProductDetails;
      //   410: invokevirtual getProductType : ()Ljava/lang/String;
      //   413: aload_1
      //   414: invokevirtual zza : ()Lcom/android/billingclient/api/ProductDetails;
      //   417: invokevirtual getProductType : ()Ljava/lang/String;
      //   420: invokevirtual equals : (Ljava/lang/Object;)Z
      //   423: ifne -> 455
      //   426: aload #5
      //   428: invokevirtual zza : ()Lcom/android/billingclient/api/ProductDetails;
      //   431: invokevirtual getProductType : ()Ljava/lang/String;
      //   434: ldc 'play_pass_subs'
      //   436: invokevirtual equals : (Ljava/lang/Object;)Z
      //   439: ifeq -> 445
      //   442: goto -> 455
      //   445: new java/lang/IllegalArgumentException
      //   448: dup
      //   449: ldc 'All products should have same ProductType.'
      //   451: invokespecial <init> : (Ljava/lang/String;)V
      //   454: athrow
      //   455: iinc #8, 1
      //   458: goto -> 365
      //   461: new java/lang/IllegalArgumentException
      //   464: dup
      //   465: ldc 'ProductDetailsParams cannot be null.'
      //   467: invokespecial <init> : (Ljava/lang/String;)V
      //   470: athrow
      //   471: aload_1
      //   472: invokevirtual zza : ()Lcom/android/billingclient/api/ProductDetails;
      //   475: invokevirtual zza : ()Ljava/lang/String;
      //   478: astore #5
      //   480: aload_0
      //   481: getfield zzc : Ljava/util/List;
      //   484: invokeinterface iterator : ()Ljava/util/Iterator;
      //   489: astore #9
      //   491: aload #9
      //   493: invokeinterface hasNext : ()Z
      //   498: ifeq -> 573
      //   501: aload #9
      //   503: invokeinterface next : ()Ljava/lang/Object;
      //   508: checkcast com/android/billingclient/api/BillingFlowParams$ProductDetailsParams
      //   511: astore #6
      //   513: aload_1
      //   514: invokevirtual zza : ()Lcom/android/billingclient/api/ProductDetails;
      //   517: invokevirtual getProductType : ()Ljava/lang/String;
      //   520: ldc 'play_pass_subs'
      //   522: invokevirtual equals : (Ljava/lang/Object;)Z
      //   525: ifne -> 491
      //   528: aload #6
      //   530: invokevirtual zza : ()Lcom/android/billingclient/api/ProductDetails;
      //   533: invokevirtual getProductType : ()Ljava/lang/String;
      //   536: ldc 'play_pass_subs'
      //   538: invokevirtual equals : (Ljava/lang/Object;)Z
      //   541: ifne -> 491
      //   544: aload #5
      //   546: aload #6
      //   548: invokevirtual zza : ()Lcom/android/billingclient/api/ProductDetails;
      //   551: invokevirtual zza : ()Ljava/lang/String;
      //   554: invokevirtual equals : (Ljava/lang/Object;)Z
      //   557: ifeq -> 563
      //   560: goto -> 491
      //   563: new java/lang/IllegalArgumentException
      //   566: dup
      //   567: ldc 'All products must have the same package name.'
      //   569: invokespecial <init> : (Ljava/lang/String;)V
      //   572: athrow
      //   573: new com/android/billingclient/api/BillingFlowParams
      //   576: dup
      //   577: aconst_null
      //   578: invokespecial <init> : (Lcom/android/billingclient/api/zzaz;)V
      //   581: astore #5
      //   583: iload_3
      //   584: ifeq -> 610
      //   587: iload_2
      //   588: istore #10
      //   590: aload_0
      //   591: getfield zzd : Ljava/util/ArrayList;
      //   594: iconst_0
      //   595: invokevirtual get : (I)Ljava/lang/Object;
      //   598: checkcast com/android/billingclient/api/SkuDetails
      //   601: invokevirtual zzd : ()Ljava/lang/String;
      //   604: invokevirtual isEmpty : ()Z
      //   607: ifeq -> 649
      //   610: iload #4
      //   612: ifeq -> 646
      //   615: aload_0
      //   616: getfield zzc : Ljava/util/List;
      //   619: iconst_0
      //   620: invokeinterface get : (I)Ljava/lang/Object;
      //   625: checkcast com/android/billingclient/api/BillingFlowParams$ProductDetailsParams
      //   628: invokevirtual zza : ()Lcom/android/billingclient/api/ProductDetails;
      //   631: invokevirtual zza : ()Ljava/lang/String;
      //   634: invokevirtual isEmpty : ()Z
      //   637: ifne -> 646
      //   640: iload_2
      //   641: istore #10
      //   643: goto -> 649
      //   646: iconst_0
      //   647: istore #10
      //   649: aload #5
      //   651: iload #10
      //   653: invokestatic zzg : (Lcom/android/billingclient/api/BillingFlowParams;Z)V
      //   656: aload #5
      //   658: aload_0
      //   659: getfield zza : Ljava/lang/String;
      //   662: invokestatic zzi : (Lcom/android/billingclient/api/BillingFlowParams;Ljava/lang/String;)V
      //   665: aload #5
      //   667: aload_0
      //   668: getfield zzb : Ljava/lang/String;
      //   671: invokestatic zzj : (Lcom/android/billingclient/api/BillingFlowParams;Ljava/lang/String;)V
      //   674: aload #5
      //   676: aload_0
      //   677: getfield zzf : Lcom/android/billingclient/api/BillingFlowParams$SubscriptionUpdateParams$Builder;
      //   680: invokevirtual build : ()Lcom/android/billingclient/api/BillingFlowParams$SubscriptionUpdateParams;
      //   683: invokestatic zzm : (Lcom/android/billingclient/api/BillingFlowParams;Lcom/android/billingclient/api/BillingFlowParams$SubscriptionUpdateParams;)V
      //   686: aload_0
      //   687: getfield zzd : Ljava/util/ArrayList;
      //   690: astore_1
      //   691: aload_1
      //   692: ifnull -> 707
      //   695: new java/util/ArrayList
      //   698: dup
      //   699: aload_1
      //   700: invokespecial <init> : (Ljava/util/Collection;)V
      //   703: astore_1
      //   704: goto -> 715
      //   707: new java/util/ArrayList
      //   710: dup
      //   711: invokespecial <init> : ()V
      //   714: astore_1
      //   715: aload #5
      //   717: aload_1
      //   718: invokestatic zzl : (Lcom/android/billingclient/api/BillingFlowParams;Ljava/util/ArrayList;)V
      //   721: aload #5
      //   723: aload_0
      //   724: getfield zze : Z
      //   727: invokestatic zzh : (Lcom/android/billingclient/api/BillingFlowParams;Z)V
      //   730: aload_0
      //   731: getfield zzc : Ljava/util/List;
      //   734: astore_1
      //   735: aload_1
      //   736: ifnull -> 747
      //   739: aload_1
      //   740: invokestatic zzk : (Ljava/util/Collection;)Lcom/google/android/gms/internal/play_billing/zzu;
      //   743: astore_1
      //   744: goto -> 751
      //   747: invokestatic zzl : ()Lcom/google/android/gms/internal/play_billing/zzu;
      //   750: astore_1
      //   751: aload #5
      //   753: aload_1
      //   754: invokestatic zzk : (Lcom/android/billingclient/api/BillingFlowParams;Lcom/google/android/gms/internal/play_billing/zzu;)V
      //   757: aload #5
      //   759: areturn
    }
    
    @NonNull
    @zzh
    public Builder setIsOfferPersonalized(boolean param1Boolean) {
      this.zze = param1Boolean;
      return this;
    }
    
    @NonNull
    public Builder setObfuscatedAccountId(@NonNull String param1String) {
      this.zza = param1String;
      return this;
    }
    
    @NonNull
    public Builder setObfuscatedProfileId(@NonNull String param1String) {
      this.zzb = param1String;
      return this;
    }
    
    @NonNull
    @zzj
    public Builder setProductDetailsParamsList(@NonNull List<BillingFlowParams.ProductDetailsParams> param1List) {
      this.zzc = new ArrayList<BillingFlowParams.ProductDetailsParams>(param1List);
      return this;
    }
    
    @Deprecated
    @NonNull
    public Builder setSkuDetails(@NonNull SkuDetails param1SkuDetails) {
      ArrayList<SkuDetails> arrayList = new ArrayList();
      arrayList.add(param1SkuDetails);
      this.zzd = arrayList;
      return this;
    }
    
    @NonNull
    public Builder setSubscriptionUpdateParams(@NonNull BillingFlowParams.SubscriptionUpdateParams param1SubscriptionUpdateParams) {
      this.zzf = BillingFlowParams.SubscriptionUpdateParams.zzb(param1SubscriptionUpdateParams);
      return this;
    }
  }
  
  @zzj
  public static final class ProductDetailsParams {
    private final ProductDetails zza;
    
    private final String zzb;
    
    @NonNull
    @zzj
    public static Builder newBuilder() {
      return new Builder(null);
    }
    
    @NonNull
    public final ProductDetails zza() {
      return this.zza;
    }
    
    @NonNull
    public final String zzb() {
      return this.zzb;
    }
    
    @zzj
    public static class Builder {
      private ProductDetails zza;
      
      private String zzb;
      
      private Builder() {}
      
      @NonNull
      @zzj
      public BillingFlowParams.ProductDetailsParams build() {
        zzm.zzc(this.zza, "ProductDetails is required for constructing ProductDetailsParams.");
        zzm.zzc(this.zzb, "offerToken is required for constructing ProductDetailsParams.");
        return new BillingFlowParams.ProductDetailsParams(this, null);
      }
      
      @NonNull
      @zzj
      public Builder setOfferToken(@NonNull String param2String) {
        this.zzb = param2String;
        return this;
      }
      
      @NonNull
      @zzj
      public Builder setProductDetails(@NonNull ProductDetails param2ProductDetails) {
        this.zza = param2ProductDetails;
        if (param2ProductDetails.getOneTimePurchaseOfferDetails() != null)
          if (param2ProductDetails.getOneTimePurchaseOfferDetails() != null) {
            this.zzb = param2ProductDetails.getOneTimePurchaseOfferDetails().zza();
          } else {
            throw null;
          }  
        return this;
      }
    }
  }
  
  @zzj
  public static class Builder {
    private ProductDetails zza;
    
    private String zzb;
    
    private Builder() {}
    
    @NonNull
    @zzj
    public BillingFlowParams.ProductDetailsParams build() {
      zzm.zzc(this.zza, "ProductDetails is required for constructing ProductDetailsParams.");
      zzm.zzc(this.zzb, "offerToken is required for constructing ProductDetailsParams.");
      return new BillingFlowParams.ProductDetailsParams(this, null);
    }
    
    @NonNull
    @zzj
    public Builder setOfferToken(@NonNull String param1String) {
      this.zzb = param1String;
      return this;
    }
    
    @NonNull
    @zzj
    public Builder setProductDetails(@NonNull ProductDetails param1ProductDetails) {
      this.zza = param1ProductDetails;
      if (param1ProductDetails.getOneTimePurchaseOfferDetails() != null)
        if (param1ProductDetails.getOneTimePurchaseOfferDetails() != null) {
          this.zzb = param1ProductDetails.getOneTimePurchaseOfferDetails().zza();
        } else {
          throw null;
        }  
      return this;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ProrationMode {
    public static final int DEFERRED = 4;
    
    public static final int IMMEDIATE_AND_CHARGE_FULL_PRICE = 5;
    
    public static final int IMMEDIATE_AND_CHARGE_PRORATED_PRICE = 2;
    
    public static final int IMMEDIATE_WITHOUT_PRORATION = 3;
    
    public static final int IMMEDIATE_WITH_TIME_PRORATION = 1;
    
    public static final int UNKNOWN_SUBSCRIPTION_UPGRADE_DOWNGRADE_POLICY = 0;
  }
  
  public static class SubscriptionUpdateParams {
    private String zza;
    
    private int zzb = 0;
    
    private SubscriptionUpdateParams() {}
    
    @NonNull
    public static Builder newBuilder() {
      return new Builder(null);
    }
    
    final int zza() {
      return this.zzb;
    }
    
    final String zzc() {
      return this.zza;
    }
    
    public static class Builder {
      private String zza;
      
      private boolean zzb;
      
      private int zzc = 0;
      
      private Builder() {}
      
      @NonNull
      public BillingFlowParams.SubscriptionUpdateParams build() {
        boolean bool;
        if (TextUtils.isEmpty(this.zza)) {
          if (!TextUtils.isEmpty(null)) {
            bool = true;
          } else {
            bool = false;
          } 
        } else {
          bool = true;
        } 
        int i = true ^ TextUtils.isEmpty(null);
        if (!bool || i == 0) {
          if (this.zzb || bool || i != 0) {
            BillingFlowParams.SubscriptionUpdateParams subscriptionUpdateParams = new BillingFlowParams.SubscriptionUpdateParams(null);
            BillingFlowParams.SubscriptionUpdateParams.zzd(subscriptionUpdateParams, this.zza);
            BillingFlowParams.SubscriptionUpdateParams.zze(subscriptionUpdateParams, this.zzc);
            return subscriptionUpdateParams;
          } 
          throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
        } 
        throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
      }
      
      @NonNull
      @zzj
      public Builder setOldPurchaseToken(@NonNull String param2String) {
        this.zza = param2String;
        return this;
      }
      
      @Deprecated
      @NonNull
      public Builder setOldSkuPurchaseToken(@NonNull String param2String) {
        this.zza = param2String;
        return this;
      }
      
      @NonNull
      @zzj
      public Builder setReplaceProrationMode(int param2Int) {
        this.zzc = param2Int;
        return this;
      }
      
      @Deprecated
      @NonNull
      public Builder setReplaceSkusProrationMode(int param2Int) {
        this.zzc = param2Int;
        return this;
      }
    }
  }
  
  public static class Builder {
    private String zza;
    
    private boolean zzb;
    
    private int zzc = 0;
    
    private Builder() {}
    
    @NonNull
    public BillingFlowParams.SubscriptionUpdateParams build() {
      boolean bool;
      if (TextUtils.isEmpty(this.zza)) {
        if (!TextUtils.isEmpty(null)) {
          bool = true;
        } else {
          bool = false;
        } 
      } else {
        bool = true;
      } 
      int i = true ^ TextUtils.isEmpty(null);
      if (!bool || i == 0) {
        if (this.zzb || bool || i != 0) {
          BillingFlowParams.SubscriptionUpdateParams subscriptionUpdateParams = new BillingFlowParams.SubscriptionUpdateParams(null);
          BillingFlowParams.SubscriptionUpdateParams.zzd(subscriptionUpdateParams, this.zza);
          BillingFlowParams.SubscriptionUpdateParams.zze(subscriptionUpdateParams, this.zzc);
          return subscriptionUpdateParams;
        } 
        throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
      } 
      throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
    }
    
    @NonNull
    @zzj
    public Builder setOldPurchaseToken(@NonNull String param1String) {
      this.zza = param1String;
      return this;
    }
    
    @Deprecated
    @NonNull
    public Builder setOldSkuPurchaseToken(@NonNull String param1String) {
      this.zza = param1String;
      return this;
    }
    
    @NonNull
    @zzj
    public Builder setReplaceProrationMode(int param1Int) {
      this.zzc = param1Int;
      return this;
    }
    
    @Deprecated
    @NonNull
    public Builder setReplaceSkusProrationMode(int param1Int) {
      this.zzc = param1Int;
      return this;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\BillingFlowParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */