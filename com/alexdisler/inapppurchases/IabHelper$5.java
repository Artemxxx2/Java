package com.alexdisler.inapppurchases;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

class null implements IabHelper.OnQueryPurchasesFinishedListener {
  ArrayList<IabPurchase> iabPurchasesList = new ArrayList<IabPurchase>();
  
  boolean inappFinished = false;
  
  boolean subsFinished = false;
  
  public void onAllFinished() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("queryAllPurchasesAsync onAllFinished");
    stringBuilder.append(this.inappFinished);
    stringBuilder.append(" ");
    stringBuilder.append(this.subsFinished);
    Log.d("google.payments Helper", stringBuilder.toString());
    if (this.inappFinished && this.subsFinished)
      listener.onQueryAllPurchasesFinished(this.iabPurchasesList); 
  }
  
  public void onQueryPurchasesFinished(List<IabPurchase> paramList, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onQueryPurchasesFinished: ");
    stringBuilder.append(paramList);
    stringBuilder.append(" ");
    stringBuilder.append(paramString);
    Log.d("google.payments Helper", stringBuilder.toString());
    if (paramString.equals("inapp")) {
      this.inappFinished = true;
    } else if (paramString.equals("subs")) {
      this.subsFinished = true;
    } 
    this.iabPurchasesList.addAll(paramList);
    onAllFinished();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\IabHelper$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */