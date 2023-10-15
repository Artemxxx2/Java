package com.alexdisler.inapppurchases;

import com.android.billingclient.api.SkuDetails;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class IabSkuDetails {
  String TAG = "google.payments ISD";
  
  String mDescription;
  
  String mItemType;
  
  String mPrice;
  
  Double mPriceAsDecimal;
  
  String mPriceCurrency;
  
  String mPriceRaw;
  
  String mSku;
  
  SkuDetails mSkuDetails;
  
  String mTitle;
  
  String mType;
  
  public IabSkuDetails(SkuDetails paramSkuDetails) {
    this("inapp", paramSkuDetails);
  }
  
  public IabSkuDetails(String paramString, SkuDetails paramSkuDetails) {
    this.mSkuDetails = paramSkuDetails;
    this.mItemType = paramString;
    this.mSku = paramSkuDetails.getSku();
    this.mType = paramSkuDetails.getType();
    this.mPrice = paramSkuDetails.getPrice();
    this.mPriceCurrency = paramSkuDetails.getPriceCurrencyCode();
    double d1 = paramSkuDetails.getPriceAmountMicros();
    double d2 = Double.valueOf(1000000.0D).doubleValue();
    Double.isNaN(d1);
    this.mPriceAsDecimal = Double.valueOf(d1 / d2);
    this.mTitle = paramSkuDetails.getTitle();
    this.mDescription = paramSkuDetails.getDescription();
    long l = paramSkuDetails.getPriceAmountMicros();
    DecimalFormat decimalFormat = new DecimalFormat("#.00####");
    decimalFormat.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));
    d2 = l;
    Double.isNaN(d2);
    this.mPriceRaw = decimalFormat.format(d2 / 1000000.0D);
  }
  
  public String getDescription() {
    return this.mDescription;
  }
  
  public String getPrice() {
    return this.mPrice;
  }
  
  public Double getPriceAsDecimal() {
    return this.mPriceAsDecimal;
  }
  
  public String getPriceCurrency() {
    return this.mPriceCurrency;
  }
  
  public String getPriceRaw() {
    return this.mPriceRaw;
  }
  
  public String getSku() {
    return this.mSku;
  }
  
  public String getTitle() {
    return this.mTitle;
  }
  
  public String getType() {
    return this.mType;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("IabSkuDetails:");
    stringBuilder.append(this.mSkuDetails);
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\IabSkuDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */