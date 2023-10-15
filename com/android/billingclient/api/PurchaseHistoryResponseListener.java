package com.android.billingclient.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public interface PurchaseHistoryResponseListener {
  void onPurchaseHistoryResponse(@NonNull BillingResult paramBillingResult, @Nullable List<PurchaseHistoryRecord> paramList);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\PurchaseHistoryResponseListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */