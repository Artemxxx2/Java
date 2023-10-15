package com.alexdisler.inapppurchases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
  Map<String, IabPurchase> mPurchaseMap = new HashMap<String, IabPurchase>();
  
  Map<String, IabSkuDetails> mSkuMap = new HashMap<String, IabSkuDetails>();
  
  void addIabSkuDetails(IabSkuDetails paramIabSkuDetails) {
    this.mSkuMap.put(paramIabSkuDetails.getSku(), paramIabSkuDetails);
  }
  
  void addPurchase(IabPurchase paramIabPurchase) {
    this.mPurchaseMap.put(paramIabPurchase.getSku(), paramIabPurchase);
  }
  
  public void erasePurchase(String paramString) {
    if (this.mPurchaseMap.containsKey(paramString))
      this.mPurchaseMap.remove(paramString); 
  }
  
  List<String> getAllOwnedSkus() {
    return new ArrayList<String>(this.mPurchaseMap.keySet());
  }
  
  List<String> getAllOwnedSkus(String paramString) {
    ArrayList<String> arrayList = new ArrayList();
    for (IabPurchase iabPurchase : this.mPurchaseMap.values()) {
      if (paramString == null || iabPurchase.getItemType().equals(paramString))
        arrayList.add(iabPurchase.getSku()); 
    } 
    return arrayList;
  }
  
  List<IabPurchase> getAllPurchases() {
    return new ArrayList<IabPurchase>(this.mPurchaseMap.values());
  }
  
  public IabSkuDetails getIabSkuDetails(String paramString) {
    return this.mSkuMap.get(paramString);
  }
  
  public IabPurchase getPurchase(String paramString) {
    return this.mPurchaseMap.get(paramString);
  }
  
  public boolean hasDetails(String paramString) {
    return this.mSkuMap.containsKey(paramString);
  }
  
  public boolean hasPurchase(String paramString) {
    return this.mPurchaseMap.containsKey(paramString);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\Inventory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */