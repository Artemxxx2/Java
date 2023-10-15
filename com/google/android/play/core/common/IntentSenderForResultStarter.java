package com.google.android.play.core.common;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface IntentSenderForResultStarter {
  void startIntentSenderForResult(@NonNull IntentSender paramIntentSender, int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, @Nullable Bundle paramBundle) throws IntentSender.SendIntentException;
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\common\IntentSenderForResultStarter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */