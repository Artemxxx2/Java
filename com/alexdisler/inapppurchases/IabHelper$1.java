package com.alexdisler.inapppurchases;

import android.util.Log;
import com.android.billingclient.api.Purchase;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

class null implements IabHelper.QueryInventoryFinishedListener {
  public void onQueryInventoryFinished(IabResult paramIabResult, Inventory paramInventory) {
    Iterator<String> iterator = skus.iterator();
    while (iterator.hasNext()) {
      String str = iterator.next();
      IabSkuDetails iabSkuDetails = paramInventory.getIabSkuDetails(str);
      try {
        IabPurchase iabPurchase = new IabPurchase();
        this(iabSkuDetails.getType(), purchase.getOriginalJson(), purchase.getSignature());
        if (!skipPurchaseVerification) {
          if (!Security.verifyPurchase(IabHelper.this.mSignatureBase64, purchase.getOriginalJson(), purchase.getSignature())) {
            IabHelper iabHelper = IabHelper.this;
            StringBuilder stringBuilder = new StringBuilder();
            this();
            stringBuilder.append("Purchase signature verification FAILED for sku ");
            stringBuilder.append(str);
            iabHelper.logError(stringBuilder.toString());
            IabResult iabResult = new IabResult();
            stringBuilder = new StringBuilder();
            this();
            stringBuilder.append("Signature verification failed for sku ");
            stringBuilder.append(str);
            this(-1003, stringBuilder.toString());
            if (IabHelper.this.mPurchaseListener != null)
              IabHelper.this.mPurchaseListener.onIabPurchaseFinished(iabResult, iabPurchase); 
            return;
          } 
          Log.d("google.payments Helper", "Purchase signature successfully verified.");
        } 
        if (IabHelper.this.mPurchaseListener != null) {
          IabHelper.OnIabPurchaseFinishedListener onIabPurchaseFinishedListener = IabHelper.this.mPurchaseListener;
          IabResult iabResult = new IabResult();
          this(0, "Success");
          onIabPurchaseFinishedListener.onIabPurchaseFinished(iabResult, iabPurchase);
        } 
      } catch (JSONException jSONException) {
        IabResult iabResult = new IabResult(-1003, "Failed to parse purchase data.");
        if (IabHelper.this.mPurchaseListener != null)
          IabHelper.this.mPurchaseListener.onIabPurchaseFinished(iabResult, null); 
        return;
      } 
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\IabHelper$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */